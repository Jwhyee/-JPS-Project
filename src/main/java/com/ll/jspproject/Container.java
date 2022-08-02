package com.ll.jspproject;

import com.ll.jspproject.annotation.Autowired;
import com.ll.jspproject.annotation.Controller;
import com.ll.jspproject.annotation.Service;
import com.ll.jspproject.article.controller.ArticleController;
import com.ll.jspproject.home.controller.HomeController;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.*;

public class Container {
    private static Map<Class, Object> objects;

    static {
        objects = new HashMap<>();

        scanComponents();
    }

    private static void scanComponents() {
        scanServices();
        scanControllers();

        // 조립
        resolveDependenciesAllComponents();
    }

    private static void resolveDependenciesAllComponents() {
        for (Class cls : objects.keySet()) {
            Object o = objects.get(cls);
            resolveDependencies(o);
        }

    }

    private static void resolveDependencies(Object o) {
        Arrays.asList(o.getClass().getDeclaredFields())
                .stream()
                .filter(f -> f.isAnnotationPresent(Autowired.class))
                .map(field -> {
                    field.setAccessible(true);
                    return field;
                })
                .forEach(field -> {
                    Class cls = field.getType();
                    Object dependency = objects.get(cls);
                    try {
                        field.set(o, dependency);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    private static void scanServices() {
        Reflections ref = new Reflections("com.ll.jspproject");
        for (Class<?> cls : ref.getTypesAnnotatedWith(Service.class)) {
            objects.put(cls, Ut.cls.newObj(cls, null));
        }
    }

    private static void scanControllers() {
        Reflections ref = new Reflections("com.ll.jspproject");
        for (Class<?> cls : ref.getTypesAnnotatedWith(Controller.class)) {
            objects.put(cls, Ut.cls.newObj(cls, null));
        }
    }

    public static <T> T getObj(Class<T> cls) {
        return (T)objects.get(cls);
    }

    public static List<String> getControllerNames() {
        List<String> names = new ArrayList<>();

        Reflections ref = new Reflections("com.ll.jspproject");
        for (Class<?> cls : ref.getTypesAnnotatedWith(Controller.class)) {
            String name = cls.getSimpleName(); // HomeController
            name = name.replace("Controller", ""); // Home
            name = Ut.str.decapitalize(name); // home

            names.add(name.replace("Controller", name));
        }

        return names;
    }
}