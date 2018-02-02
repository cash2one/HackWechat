package com.tencent.liteav.basic.d;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class d extends c {
    public boolean r;
    private float[] s;
    private int t;

    public d() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        this.s = new float[16];
        this.r = false;
        this.o = true;
    }

    public boolean b() {
        boolean b = super.b();
        this.t = GLES20.glGetUniformLocation(this.a, "textureTransform");
        if (b && GLES20.glGetError() == 0) {
            return true;
        }
        return false;
    }

    public void a(float[] fArr) {
        this.s = fArr;
    }

    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.a);
        k();
        if (m() && this.s != null) {
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 0, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.b);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.d);
            GLES20.glUniformMatrix4fv(this.t, 1, false, this.s, 0);
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(36197, i);
                GLES20.glUniform1i(this.c, 0);
            }
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.b);
            GLES20.glDisableVertexAttribArray(this.d);
            GLES20.glBindTexture(36197, 0);
        }
    }
}
