package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.d.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class r extends c {
    private ByteBuffer r;
    public int u;
    public int v;
    public int w;

    public r(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", str);
    }

    public r(String str, String str2) {
        super(str, str2);
        this.w = -1;
        a(f.NORMAL, false, true);
    }

    public boolean b() {
        boolean b = super.b();
        if (b) {
            this.u = GLES20.glGetAttribLocation(p(), "inputTextureCoordinate2");
            this.v = GLES20.glGetUniformLocation(p(), "inputImageTexture2");
            GLES20.glEnableVertexAttribArray(this.u);
        }
        if (b && GLES20.glGetError() == 0) {
            return true;
        }
        return false;
    }

    public void e() {
        super.e();
    }

    protected void i() {
        GLES20.glEnableVertexAttribArray(this.u);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.w);
        GLES20.glUniform1i(this.v, 3);
        this.r.position(0);
        GLES20.glVertexAttribPointer(this.u, 2, 5126, false, 0, this.r);
    }

    public void a(f fVar, boolean z, boolean z2) {
        float[] a = g.a(fVar, z, z2);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(a);
        asFloatBuffer.flip();
        this.r = order;
    }

    public int b(int i, int i2) {
        this.w = i2;
        return a(i, this.m, this.n);
    }

    public int a(int i, int i2, int i3, int i4) {
        this.w = i2;
        return a(i, i3, i4);
    }
}
