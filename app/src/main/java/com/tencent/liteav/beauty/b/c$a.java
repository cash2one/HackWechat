package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;

public class c$a extends q {
    private int x = -1;
    private int y = -1;
    private int z = -1;

    public c$a() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public boolean a() {
        NativeLoad.getInstance();
        this.a = NativeLoad.nativeLoadGLProgram(1);
        if (this.a == 0 || !b()) {
            this.g = false;
        } else {
            this.g = true;
        }
        c();
        return this.g;
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        this.x = GLES20.glGetUniformLocation(p(), "smoothDegree");
        this.y = GLES20.glGetUniformLocation(p(), "brightDegree");
        this.z = GLES20.glGetUniformLocation(p(), "ruddyDegree");
    }

    public boolean b() {
        return super.b();
    }

    public void a(float f) {
        a(this.x, c.a(f));
    }

    public void b(float f) {
        a(this.y, f / 3.0f);
    }

    public void c(float f) {
        a(this.z, (f / 10.0f) / 2.0f);
    }
}
