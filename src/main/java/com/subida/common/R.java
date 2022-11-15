package com.subida.common;

public class R<T>{
    private Integer code;
    private String msg;
    private T data;

    //<T>是申明T为泛型，以区别于类名。
    public static <T> R<T> success(T object){
        R<T> r = new R<T>();
        r.code = 1;
        r.data = object;
        return r;
    }

    public static <T> R<T> error(String msg){
        R<T> r = new R<>();
        r.msg = msg;
        r.code = 0;
        return r;
    }
}
