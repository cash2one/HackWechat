package com.tencent.liteav.beauty.b.b;

import com.tencent.liteav.beauty.b.b;
import com.tencent.liteav.beauty.b.p;

public class a extends b {
    private b r = null;
    private p s = null;
    private String t = "TXCBeauty3Filter";
    private float u = 0.0f;
    private float v = 0.0f;
    private float w = 0.0f;
    private float x = 0.0f;

    public boolean b(int i, int i2) {
        return c(i, i2);
    }

    private boolean c(int i, int i2) {
        if (this.r == null) {
            this.r = new b();
            this.r.a(true);
            if (!this.r.a()) {
                return false;
            }
            this.r.a(i, i2);
        }
        if (this.s == null) {
            this.s = new p();
            this.s.a(true);
            if (!this.s.a()) {
                return false;
            }
            this.s.a(i, i2);
        }
        return true;
    }

    public int b(int i) {
        if (this.u > 0.0f || this.v > 0.0f || this.w > 0.0f) {
            i = this.r.b(i);
        }
        if (this.x > 0.0f) {
            return this.s.b(i);
        }
        return i;
    }

    public void c(int i) {
        this.u = ((float) i) / 10.0f;
        if (this.r != null) {
            this.r.a(this.u);
        }
    }

    public void d(int i) {
        this.v = ((float) i) / 10.0f;
        if (this.r != null) {
            this.r.b(this.v);
        }
    }

    public void e(int i) {
        this.w = ((float) i) / 10.0f;
        if (this.r != null) {
            this.r.c(this.w);
        }
    }

    public void f(int i) {
        this.x = ((float) i) / 20.0f;
        if (this.s != null) {
            this.s.a(this.x);
        }
    }

    void q() {
        if (this.r != null) {
            this.r.e();
            this.r = null;
        }
        if (this.s != null) {
            this.s.e();
            this.s = null;
        }
    }

    public void e() {
        super.e();
        q();
    }
}
