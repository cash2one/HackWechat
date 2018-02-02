package com.tencent.mm.compatible.util;

import java.security.PrivilegedAction;

public final class i implements PrivilegedAction {
    private String gHL;
    private String gHM;

    public i(String str) {
        this.gHL = str;
    }

    public final Object run() {
        Object property = System.getProperty(this.gHL);
        return property == null ? this.gHM : property;
    }
}
