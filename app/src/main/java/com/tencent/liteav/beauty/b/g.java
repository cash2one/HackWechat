package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.c;
import java.util.List;

public class g extends c {
    protected List<c> r;
    protected List<c> s;
    private int[] t;
    private int[] u;
    private c v;

    public boolean b() {
        boolean b = super.b();
        if (b) {
            for (c cVar : this.r) {
                cVar.a();
                if (!cVar.m()) {
                    break;
                }
            }
            b = this.v.a();
        }
        if (b && GLES20.glGetError() == 0) {
            return true;
        }
        return false;
    }

    public void e() {
        super.e();
        for (c d : this.r) {
            d.d();
        }
    }

    public void f() {
        super.f();
        if (this.u != null) {
            GLES20.glDeleteTextures(2, this.u, 0);
            this.u = null;
        }
        if (this.t != null) {
            GLES20.glDeleteFramebuffers(2, this.t, 0);
            this.t = null;
        }
    }

    public void a(int i, int i2) {
        if (this.e != i || this.f != i2) {
            if (this.t != null) {
                f();
            }
            super.a(i, i2);
            int size = this.s.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((c) this.s.get(i3)).a(i, i2);
            }
            this.v.a(i, i2);
            if (this.s != null && this.s.size() > 0) {
                this.s.size();
                this.t = new int[2];
                this.u = new int[2];
                for (int i4 = 0; i4 < 2; i4++) {
                    GLES20.glGenFramebuffers(1, this.t, i4);
                    GLES20.glGenTextures(1, this.u, i4);
                    GLES20.glBindTexture(3553, this.u[i4]);
                    GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLES20.glBindFramebuffer(36160, this.t[i4]);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u[i4], 0);
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glBindFramebuffer(36160, 0);
                }
            }
        }
    }

    public int a(int i, int i2, int i3) {
        int size = this.s.size();
        k();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            int a;
            int i6;
            c cVar = (c) this.s.get(i4);
            if (i5 != 0) {
                a = cVar.a(i, i2, i3);
            } else {
                a = cVar.a(i, this.t[0], this.u[0]);
            }
            if (i5 != 0) {
                i6 = 0;
            } else {
                i6 = 1;
            }
            i4++;
            i5 = i6;
            i = a;
        }
        if (i5 != 0) {
            this.v.a(i, i2, i3);
        }
        return i3;
    }
}
