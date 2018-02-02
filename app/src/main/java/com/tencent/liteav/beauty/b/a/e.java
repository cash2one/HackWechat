package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.r;

public class e extends r {
    private String A = "SmoothVertical";
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int x = -1;
    private float y = 2.0f;
    private float z = 0.5f;

    e() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public boolean a() {
        if (Build.BRAND.equals("samsung") && Build.MODEL.equals("GT-I9500") && VERSION.RELEASE.equals("4.3")) {
            NativeLoad.getInstance();
            this.a = NativeLoad.nativeLoadGLProgram(15);
        } else {
            NativeLoad.getInstance();
            this.a = NativeLoad.nativeLoadGLProgram(5);
        }
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
        this.z = f;
        TXCLog.i(this.A, "setBeautyLevel " + f);
        a(this.t, f);
    }

    public void q() {
        this.r = GLES20.glGetUniformLocation(p(), "texelWidthOffset");
        this.s = GLES20.glGetUniformLocation(p(), "texelHeightOffset");
        this.t = GLES20.glGetUniformLocation(p(), "smoothDegree");
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (i > i2) {
            if (i2 < 540) {
                this.y = 2.0f;
            } else {
                this.y = 4.0f;
            }
        } else if (i < 540) {
            this.y = 2.0f;
        } else {
            this.y = 4.0f;
        }
        TXCLog.i(this.A, "m_textureRation " + this.y);
        a(this.r, this.y / ((float) i));
        a(this.s, this.y / ((float) i2));
    }
}
