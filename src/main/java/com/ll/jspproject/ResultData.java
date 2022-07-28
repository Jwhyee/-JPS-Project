package com.ll.jspproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ResultData<T> {
    private final String msg;
    private  String resultCode;
    private T data;
}
