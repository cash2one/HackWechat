package com.tencent.mm.plugin.api.recordView;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

final class a implements Renderer {
    static float[] iow = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    static float[] iox = new float[]{-1.0f, -0.5f, 1.0f, -0.5f, -1.0f, 0.5f, 1.0f, 0.5f};
    private static final float[] ioy = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    int fFy = 0;
    private int ioA = 0;
    boolean ioB = false;
    byte[] ioC = null;
    int ioD = 0;
    int ioE = 0;
    ByteBuffer ioF;
    ByteBuffer ioG;
    private int ioH;
    private int ioI;
    private int ioJ;
    private int ioK;
    private int ioL;
    private int ioM;
    private int ioN;
    private int ioO;
    FloatBuffer ioP;
    private FloatBuffer ioQ;
    private float[] ioR = new float[16];
    private boolean ioS = false;
    float[] ioT = iow;
    boolean ioU = false;
    private int ioz = 0;

    public a() {
        Point aZP = d.aZP();
        float f = (((float) aZP.x) / ((float) aZP.y)) / 2.0f;
        iox = new float[]{-1.0f, -f, 1.0f, -f, -1.0f, f, 1.0f, f};
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[]{this});
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glDisable(2929);
        this.ioJ = b.aI("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (this.ioJ == 0) {
            x.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
        }
        this.ioL = GLES20.glGetAttribLocation(this.ioJ, "a_position");
        this.ioK = GLES20.glGetAttribLocation(this.ioJ, "a_texCoord");
        this.ioM = GLES20.glGetUniformLocation(this.ioJ, "y_texture");
        this.ioN = GLES20.glGetUniformLocation(this.ioJ, "uv_texture");
        this.ioO = GLES20.glGetUniformLocation(this.ioJ, "uMatrix");
        this.ioH = b.XZ();
        this.ioI = b.XZ();
        this.ioP = ByteBuffer.allocateDirect(this.ioT.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.ioP.put(this.ioT);
        this.ioP.position(0);
        this.ioQ = ByteBuffer.allocateDirect(ioy.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.ioQ.put(ioy);
        this.ioQ.position(0);
        x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[]{Integer.valueOf(this.ioH), Integer.valueOf(this.ioI), this});
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this});
        if (i != this.ioz || i2 != this.ioA) {
            x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i, i2);
            this.ioz = i;
            this.ioA = i2;
        }
    }

    public final void onDrawFrame(GL10 gl10) {
        bh.Wq();
        this.ioB = true;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.ioS) {
            x.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
            this.ioS = false;
            this.ioB = false;
            this.ioC = null;
            this.ioD = -1;
            this.ioE = -1;
            return;
        }
        if (!(this.ioJ == 0 || this.ioH == -1 || this.ioI == -1 || this.ioD <= 0 || this.ioE <= 0 || this.ioC == null)) {
            GLES20.glUseProgram(this.ioJ);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.ioH);
            GLES20.glTexImage2D(3553, 0, 6409, this.ioD, this.ioE, 0, 6409, 5121, this.ioF);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.ioM, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.ioI);
            GLES20.glTexImage2D(3553, 0, 6410, this.ioD / 2, this.ioE / 2, 0, 6410, 5121, this.ioG);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.ioN, 1);
            Matrix.setIdentityM(this.ioR, 0);
            Matrix.setRotateM(this.ioR, 0, (float) this.fFy, 0.0f, 0.0f, -1.0f);
            GLES20.glUniformMatrix4fv(this.ioO, 1, false, this.ioR, 0);
            this.ioP.position(0);
            GLES20.glVertexAttribPointer(this.ioL, 2, 5126, false, 0, this.ioP);
            GLES20.glEnableVertexAttribArray(this.ioL);
            this.ioQ.position(0);
            GLES20.glVertexAttribPointer(this.ioK, 2, 5126, false, 0, this.ioQ);
            GLES20.glEnableVertexAttribArray(this.ioK);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.ioL);
            GLES20.glDisableVertexAttribArray(this.ioK);
            GLES20.glBindTexture(3553, 0);
        }
        this.ioB = false;
    }
}
