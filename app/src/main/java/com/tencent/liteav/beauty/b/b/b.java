package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.beauty.NativeLoad;

public class b extends c {
    private int r = -1;
    private int s = -1;
    private float[] t = new float[4];
    private String u = "Beauty3Filter";

    public b() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public boolean a() {
        NativeLoad.getInstance();
        this.a = NativeLoad.nativeLoadGLProgram(14);
        if (this.a == 0 || !b()) {
            this.g = false;
        } else {
            this.g = true;
        }
        c();
        return this.g;
    }

    public boolean b() {
        boolean b = super.b();
        this.r = GLES20.glGetUniformLocation(p(), "singleStepOffset");
        this.s = GLES20.glGetUniformLocation(p(), "beautyParams");
        a(5.0f);
        return b;
    }

    public void b(int i, int i2) {
        a(this.r, new float[]{2.0f / ((float) i), 2.0f / ((float) i2)});
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        b(i, i2);
    }

    public void a(float f) {
        this.t[0] = f;
        b(this.t);
    }

    public void b(float f) {
        this.t[1] = f;
        b(this.t);
    }

    public void c(float f) {
        this.t[2] = f;
        b(this.t);
    }

    private void b(float[] fArr) {
        c(this.s, fArr);
    }
}
