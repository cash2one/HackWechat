package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.r;

public class b extends r {
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private final String x = "BeautyBlend";

    public b() {
        super("varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public boolean a() {
        NativeLoad.getInstance();
        this.a = NativeLoad.nativeLoadGLProgram(12);
        if (this.a == 0 || !b()) {
            this.g = false;
        } else {
            this.g = true;
        }
        c();
        return this.g;
    }

    public boolean b() {
        super.b();
        q();
        return true;
    }

    public void a(float f) {
        TXCLog.i("BeautyBlend", "setBrightLevel " + f);
        a(this.s, f);
    }

    public void b(float f) {
        a(this.t, f / 2.0f);
    }

    private void q() {
        this.s = GLES20.glGetUniformLocation(p(), "whiteDegree");
        this.r = GLES20.glGetUniformLocation(p(), "contrast");
        this.t = GLES20.glGetUniformLocation(p(), "ruddyDegree");
    }
}
