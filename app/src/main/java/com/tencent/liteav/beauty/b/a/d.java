package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;

public class d extends c {
    private int r = -1;
    private int s = -1;
    private float t = 4.0f;
    private String u = "SmoothHorizontal";

    d() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public boolean a() {
        NativeLoad.getInstance();
        this.a = NativeLoad.nativeLoadGLProgram(13);
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

    public void q() {
        this.r = GLES20.glGetUniformLocation(p(), "texelWidthOffset");
        this.s = GLES20.glGetUniformLocation(p(), "texelHeightOffset");
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (i > i2) {
            if (i2 < 540) {
                this.t = 2.0f;
            } else {
                this.t = 4.0f;
            }
        } else if (i < 540) {
            this.t = 2.0f;
        } else {
            this.t = 4.0f;
        }
        TXCLog.i(this.u, "m_textureRation " + this.t);
        a(this.r, this.t / ((float) i));
        a(this.s, this.t / ((float) i2));
    }
}
