package com.tencent.mm.plugin.appbrand.q.a;

import android.content.Context;

public enum a implements e {
    ;
    
    public static final c jSw = null;
    private final e jSx;

    private a(String str) {
        this.jSx = new b();
    }

    static {
        jSw = new c();
    }

    public final void init(Context context) {
        this.jSx.init(context);
    }

    public final void release() {
        this.jSx.release();
    }

    public final c alM() {
        return this.jSx.alM();
    }
}
