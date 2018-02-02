package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.d.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class k extends c {
    private static String z = "YUV420pToRGBFilter";
    private ByteBuffer r = null;
    private byte[] s = null;
    private int t = 1;
    private int[] u = null;
    private int[] v = null;
    private int w = 0;
    private int x = 0;
    private int[] y = null;

    public k(int i) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        this.t = i;
        TXCLog.i(z, "yuv Type " + i);
    }

    public boolean a() {
        int i = 7;
        if (this.t != 1) {
            if (this.t == 3) {
                i = 9;
            } else if (this.t == 2) {
                return super.a();
            } else {
                TXCLog.e(z, "don't support yuv format " + this.t);
            }
        }
        NativeLoad.getInstance();
        this.a = NativeLoad.nativeLoadGLProgram(i);
        if (this.a == 0 || !b()) {
            this.g = false;
        } else {
            this.g = true;
        }
        c();
        return this.g;
    }

    public void a(int i, int i2) {
        if (this.f != i2 || this.e != i) {
            if (1 == this.t) {
                this.u = new int[1];
                this.u[0] = e.a(i, (i2 * 3) / 2, 6409, 6409, this.u);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.u[0]);
                GLES20.glBindTexture(3553, 0);
                GLES20.glUniform1i(this.c, 0);
            } else if (3 == this.t) {
                GLES20.glActiveTexture(33984);
                GLES20.glActiveTexture(33985);
                this.w = GLES20.glGetUniformLocation(p(), "yTexture");
                this.x = GLES20.glGetUniformLocation(p(), "uvTexture");
                if (this.u == null) {
                    this.u = new int[1];
                    this.u[0] = e.a(i, i2, 6409, 6409, this.u);
                }
                if (this.v == null) {
                    this.v = new int[1];
                    this.v[0] = e.a(i / 2, i2 / 2, 6410, 6410, this.v);
                }
                GLES20.glUniform1i(this.w, 0);
                GLES20.glUniform1i(this.x, 1);
            } else if (2 == this.t && this.y == null) {
                this.y = new int[1];
                this.y[0] = e.a(i, i2, 6408, 6408, this.y);
            }
            super.a(i, i2);
        }
    }

    public void a(byte[] bArr) {
        this.s = bArr;
    }

    protected void i() {
        super.i();
        if (1 == this.t) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.u[0]);
            GLES20.glUniform1i(this.c, 0);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.e, (this.f * 3) / 2, 0, 6409, 5121, this.s, 0);
        } else if (3 == this.t) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.u[0]);
            GLES20.glUniform1i(this.w, 0);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.e, this.f, 0, 6409, 5121, this.s, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.v[0]);
            GLES20.glUniform1i(this.x, 1);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6410, this.e / 2, this.f / 2, 0, 6410, 5121, this.s, this.f * this.e);
        } else if (2 == this.t) {
            r();
        }
    }

    public int q() {
        if (2 != this.t) {
            return super.b(-1);
        }
        int r = r();
        GLES20.glBindTexture(3553, 0);
        return r;
    }

    private int r() {
        GLES20.glBindTexture(3553, this.y[0]);
        if (this.s != null) {
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6408, this.e, this.f, 0, 6408, 5121, this.s, 0);
        }
        return this.y[0];
    }

    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.a(-1, floatBuffer, floatBuffer2);
    }

    public void e() {
        super.e();
        if (this.u != null && this.u[0] > 0) {
            GLES20.glDeleteTextures(1, this.u, 0);
            this.u = null;
        }
        if (this.v != null && this.v[0] > 0) {
            GLES20.glDeleteTextures(1, this.v, 0);
            this.v = null;
        }
    }
}
