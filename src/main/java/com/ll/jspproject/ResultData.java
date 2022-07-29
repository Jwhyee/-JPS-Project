package com.ll.jspproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ResultData<T> {
    private String resultCode;
    private final String msg;
    private T data;
}
