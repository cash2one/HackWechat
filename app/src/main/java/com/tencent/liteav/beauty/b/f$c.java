package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

class f$c extends r {
    int r;
    int s;
    float t = DownloadHelper.SAVE_FATOR;

    public f$c() {
        super(null, null);
    }

    public boolean a() {
        NativeLoad.getInstance();
        this.a = NativeLoad.nativeLoadGLProgram(2);
        if (this.a == 0 || !b()) {
            this.g = false;
        } else {
            this.g = true;
        }
        c();
        return this.g;
    }

    public boolean b() {
        if (!super.b()) {
            return false;
        }
        this.r = GLES20.glGetUniformLocation(this.a, "texelWidthOffset");
        this.s = GLES20.glGetUniformLocation(this.a, "texelHeightOffset");
        return true;
    }

    void a(float f) {
        this.t = f;
        a(this.r, this.t / ((float) this.e));
        a(this.s, this.t / ((float) this.f));
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        a(this.t);
    }
}
