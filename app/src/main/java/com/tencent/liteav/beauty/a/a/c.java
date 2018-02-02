package com.tencent.liteav.beauty.a.a;

import android.view.Surface;

public class c extends b {
    private Surface b;
    private boolean c;

    public c(a aVar, int i, int i2, boolean z) {
        super(aVar);
        a(i, i2);
        this.c = z;
    }

    public void c() {
        a();
        if (this.b != null) {
            if (this.c) {
                this.b.release();
            }
            this.b = null;
        }
    }
}
