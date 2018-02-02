package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;

public class n extends c {
    private int r = -1;
    private int s = -1;
    private String t = "RGBA2I420Filter";
    private int u = 1;

    public n(int i) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        this.u = i;
    }

    public boolean a() {
        if (1 == this.u) {
            NativeLoad.getInstance();
            this.a = NativeLoad.nativeLoadGLProgram(8);
            TXCLog.i(this.t, "RGB-->I420 init!");
        } else if (3 == this.u) {
            TXCLog.i(this.t, "RGB-->NV21 init!");
            NativeLoad.getInstance();
            this.a = NativeLoad.nativeLoadGLProgram(11);
        } else if (2 == this.u) {
            TXCLog.i(this.t, "RGBA Format init!");
            return super.a();
        } else {
            TXCLog.i(this.t, "don't support format " + this.u + " use default I420");
            NativeLoad.getInstance();
            this.a = NativeLoad.nativeLoadGLProgram(8);
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

    public void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            TXCLog.e(this.t, "width or height is error!");
            return;
        }
        super.a(i, i2);
        TXCLog.i(this.t, "RGBA2I420Filter width " + i + " height " + i2);
        a(this.r, (float) i);
        a(this.s, (float) i2);
    }

    public void c() {
        super.c();
    }

    public void q() {
        this.r = GLES20.glGetUniformLocation(p(), "width");
        this.s = GLES20.glGetUniformLocation(p(), "height");
    }
}
