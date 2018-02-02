package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.c;

public class f extends c {
    private int[] A;
    private float B = 4.0f;
    int r;
    int s;
    boolean t;
    private d u;
    private c v;
    private c w;
    private a x;
    private b y;
    private int[] z;

    private static class a extends r {
        public a(String str) {
            super(str);
        }

        public boolean b() {
            if (super.b()) {
                return true;
            }
            return false;
        }
    }

    private static class b extends q {
        public b(String str) {
            super(str);
        }

        public boolean b() {
            if (super.b()) {
                return true;
            }
            return false;
        }
    }

    public boolean b() {
        boolean b = super.b();
        if (b) {
            this.u = new d();
            if (b) {
                b = this.u.a();
            }
            this.w = new c();
            if (b) {
                b = this.w.a();
            }
            this.x = new a("precision highp float;  \nuniform sampler2D inputImageTexture;  \nuniform sampler2D inputImageTexture2;  \nvarying vec2 textureCoordinate;  \nvarying vec2 textureCoordinate2;  \nvoid main()  \n{  \n\tgl_FragColor = texture2D(inputImageTexture2, textureCoordinate2) - texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture2, textureCoordinate2);  \n}  \n");
            if (b) {
                b = this.x.a();
            }
            this.y = new b("precision highp float;   \nuniform sampler2D inputImageTexture;   \nuniform sampler2D inputImageTexture2;  \nuniform sampler2D inputImageTexture3;   \nvarying vec2 textureCoordinate;   \nvarying vec2 textureCoordinate2;  \nvarying vec2 textureCoordinate3;    \nvoid main()   \n{   \n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture3, textureCoordinate3) + texture2D(inputImageTexture2, textureCoordinate2);   \n}   \n");
            if (b) {
                b = this.y.a();
            }
            this.v = new c();
            this.v.a(true);
            if (b) {
                b = this.v.a();
            }
            if (b) {
                return true;
            }
        }
        d();
        return false;
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (!this.t) {
            if (i < i2) {
                if (i < 540) {
                    this.B = 1.0f;
                } else {
                    this.B = 4.0f;
                }
            } else if (i2 < 540) {
                this.B = 1.0f;
            } else {
                this.B = 4.0f;
            }
        }
        this.r = (int) (((float) i) / this.B);
        this.s = (int) (((float) i2) / this.B);
        this.v.a(this.r, this.s);
        this.w.a(this.r, this.s);
        this.x.a(this.r, this.s);
        this.y.a(i, i2);
        this.u.a(this.r, this.s);
        if (this.z != null) {
            GLES20.glDeleteFramebuffers(this.z.length, this.z, 0);
            GLES20.glDeleteTextures(this.z.length, this.A, 0);
            this.z = null;
            this.A = null;
        }
        this.z = new int[8];
        this.A = new int[this.z.length];
        GLES20.glGenFramebuffers(this.z.length, this.z, 0);
        GLES20.glGenTextures(this.z.length, this.A, 0);
        for (int i3 = 0; i3 < this.z.length; i3++) {
            GLES20.glBindTexture(3553, this.A[i3]);
            if (i3 >= 5) {
                GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
            } else {
                GLES20.glTexImage2D(3553, 0, 6408, this.r, this.s, 0, 6408, 5121, null);
            }
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.z[i3]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.A[i3], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    public int b(int i) {
        int b;
        if (this.B != 1.0f) {
            GLES20.glViewport(0, 0, this.r, this.s);
            b = this.v.b(i);
        } else {
            b = i;
        }
        int a = this.u.a(b, this.z[4], this.A[4]);
        b = this.w.a(b, a, this.z[0], this.A[0]);
        int a2 = this.x.a(b, a, this.z[1], this.A[1]);
        a = this.u.a(b, this.z[2], this.A[2]);
        a2 = this.u.a(a2, this.z[3], this.A[3]);
        if (this.B != 1.0f) {
            GLES20.glViewport(0, 0, this.e, this.f);
            a = this.v.a(a, this.z[5], this.A[5]);
            a2 = this.v.a(a2, this.z[6], this.A[6]);
        }
        return this.y.a(a, a2, i, this.z[7], this.A[7]);
    }

    public void e() {
        if (this.g) {
            super.e();
            this.u.d();
            this.w.d();
            this.x.d();
            this.y.d();
            this.v.d();
            if (this.z != null) {
                GLES20.glDeleteFramebuffers(this.z.length, this.z, 0);
                GLES20.glDeleteTextures(this.z.length, this.A, 0);
                this.z = null;
            }
            this.A = null;
        }
    }
}
