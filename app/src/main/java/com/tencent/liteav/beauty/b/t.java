package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.c;

public class t extends s {
    protected float u;

    public boolean b() {
        if (super.b() && GLES20.glGetError() == 0) {
            return true;
        }
        return false;
    }

    protected void s() {
        float r = r();
        c cVar = (c) this.r.get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(cVar.p(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(cVar.p(), "texelHeightOffset");
        cVar.a(glGetUniformLocation, r / ((float) this.e));
        cVar.a(glGetUniformLocation2, 0.0f);
        r = q();
        cVar = (c) this.r.get(1);
        glGetUniformLocation = GLES20.glGetUniformLocation(cVar.p(), "texelWidthOffset");
        glGetUniformLocation2 = GLES20.glGetUniformLocation(cVar.p(), "texelHeightOffset");
        cVar.a(glGetUniformLocation, 0.0f);
        cVar.a(glGetUniformLocation2, r / ((float) this.f));
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        s();
    }

    public float q() {
        return this.u;
    }

    public float r() {
        return this.u;
    }
}
