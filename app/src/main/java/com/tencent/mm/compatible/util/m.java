package com.tencent.mm.compatible.util;

public final class m {
    public static <T> T Y(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
