package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public class c extends b {
    private static final String r = c.class.getSimpleName();
    private float A = 0.0f;
    private f s;
    private a t;
    private p u = null;
    private int v = -1;
    private int w = -1;
    private float x = 0.0f;
    private float y = 0.0f;
    private float z = 0.0f;

    public int b(int i) {
        if (this.x > 0.0f || this.y > 0.0f || this.z > 0.0f) {
            int b;
            if (this.x != 0.0f) {
                b = this.s.b(i);
            } else {
                b = i;
            }
            i = this.t.a(b, i, i);
        }
        if (this.A > 0.0f) {
            return this.u.b(i);
        }
        return i;
    }

    public void a(int i, int i2) {
        if (this.t != null) {
            this.t.a(i, i2);
        }
        if (this.s != null) {
            this.s.a(i, i2);
        }
    }

    public boolean b(int i, int i2) {
        this.v = i;
        this.w = i2;
        if (this.u == null) {
            this.u = new p();
            this.u.a(true);
            if (!this.u.a()) {
                return false;
            }
            this.u.a(this.v, this.w);
        }
        this.s = new f();
        this.s.a(true);
        this.t = new a();
        this.t.a(true);
        if (this.t.a() && this.s.a()) {
            this.t.a(this.v, this.w);
            this.s.a(this.v, this.w);
            if (GLES20.glGetError() == 0) {
                return true;
            }
            e();
            return false;
        }
        e();
        return false;
    }

    public void e() {
        if (this.t != null) {
            this.t.d();
            this.t = null;
        }
        if (this.s != null) {
            this.s.d();
            this.s = null;
        }
        if (this.u != null) {
            this.u.d();
            this.u = null;
        }
    }

    public void c(int i) {
        this.x = (float) i;
        if (this.t != null) {
            this.t.a((float) i);
        }
    }

    public void d(int i) {
        this.y = (float) i;
        if (this.t != null) {
            this.t.b((float) i);
        }
    }

    public void e(int i) {
        this.z = (float) i;
        if (this.t != null) {
            this.t.c((float) i);
        }
    }

    public void f(int i) {
        this.A = ((float) i) / 15.0f;
        if (this.u != null) {
            this.u.a(this.A);
        }
    }

    private static float b(float f) {
        if (f <= 1.0f) {
            return 0.1f;
        }
        if (((double) f) < 2.5d) {
            f = a((f - 1.0f) / DownloadHelper.SAVE_FATOR, 1.0f, 4.1f);
        } else if (f < 4.0f) {
            f = a((f - 2.5f) / DownloadHelper.SAVE_FATOR, 4.1f, 5.6f);
        } else if (((double) f) < 5.5d) {
            f = a((f - 4.0f) / DownloadHelper.SAVE_FATOR, 5.6f, 6.8f);
        } else if (((double) f) <= 7.0d) {
            f = a((f - 5.5f) / DownloadHelper.SAVE_FATOR, 6.8f, 7.0f);
        }
        return f / 10.0f;
    }

    private static float a(float f, float f2, float f3) {
        return ((f3 - f2) * f) + f2;
    }
}
