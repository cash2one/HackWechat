package com.tencent.mm.plugin.appbrand.launching;

public abstract class RuntimeLoadModuleTask {
    public final LoadParams jyy;

    public abstract void pv(String str);

    public RuntimeLoadModuleTask(String str, int i, int i2, String str2) {
        this.jyy = new LoadParams(str, i, i2, str2, (byte) 0);
    }
}
