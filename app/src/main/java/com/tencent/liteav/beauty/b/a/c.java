package com.tencent.liteav.beauty.b.a;

import com.tencent.liteav.beauty.NativeLoad;

public class c extends com.tencent.liteav.basic.d.c {
    public boolean a() {
        NativeLoad.getInstance();
        this.a = NativeLoad.nativeLoadGLProgram(6);
        if (this.a == 0 || !b()) {
            this.g = false;
        } else {
            this.g = true;
        }
        c();
        return this.g;
    }
}
