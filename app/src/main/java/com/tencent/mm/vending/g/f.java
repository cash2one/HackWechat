package com.tencent.mm.vending.g;

import java.util.Stack;

final class f {
    private static f zCL;
    ThreadLocal<Stack<c>> zCM = new ThreadLocal();

    private f() {
    }

    static {
        zCL = null;
        zCL = new f();
    }

    public static f czV() {
        return zCL;
    }
}
