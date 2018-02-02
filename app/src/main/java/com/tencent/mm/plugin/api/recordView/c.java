package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class c extends Thread {
    private d iph;
    private SurfaceTexture ipj;
    private EGL10 ipk;
    private EGLDisplay ipl = EGL10.EGL_NO_DISPLAY;
    private EGLContext ipm = EGL10.EGL_NO_CONTEXT;
    private EGLSurface ipn = EGL10.EGL_NO_SURFACE;
    volatile boolean ipo;

    public c(SurfaceTexture surfaceTexture, d dVar) {
        this.ipj = surfaceTexture;
        this.iph = dVar;
    }

    public final void run() {
        Object obj;
        x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
        this.ipk = (EGL10) EGLContext.getEGL();
        this.ipl = this.ipk.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.ipl == EGL10.EGL_NO_DISPLAY) {
            x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", new Object[]{GLUtils.getEGLErrorString(this.ipk.eglGetError())});
            obj = -1;
        } else {
            if (this.ipk.eglInitialize(this.ipl, new int[2])) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (this.ipk.eglChooseConfig(this.ipl, new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                    this.ipm = this.ipk.eglCreateContext(this.ipl, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    this.ipn = this.ipk.eglCreateWindowSurface(this.ipl, eGLConfigArr[0], this.ipj, null);
                    if (this.ipn != EGL10.EGL_NO_SURFACE && this.ipm != EGL10.EGL_NO_CONTEXT) {
                        if (!this.ipk.eglMakeCurrent(this.ipl, this.ipn, this.ipn, this.ipm)) {
                            x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", new Object[]{GLUtils.getEGLErrorString(this.ipk.eglGetError())});
                        }
                        obj = null;
                    } else if (this.ipk.eglGetError() == 12299) {
                        x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                        obj = -1;
                    } else {
                        x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", new Object[]{GLUtils.getEGLErrorString(this.ipk.eglGetError())});
                        obj = -1;
                    }
                } else {
                    x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", new Object[]{GLUtils.getEGLErrorString(this.ipk.eglGetError())});
                    obj = -1;
                }
            } else {
                x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", new Object[]{GLUtils.getEGLErrorString(this.ipk.eglGetError())});
                obj = -1;
            }
        }
        if (obj < null) {
            x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
            return;
        }
        d dVar;
        if (this.iph != null) {
            dVar = this.iph;
            synchronized (d.lock) {
                x.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", new Object[]{dVar});
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glDisable(2929);
                dVar.ioJ = b.aI("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
                if (dVar.ioJ == 0) {
                    x.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
                }
                dVar.ioL = GLES20.glGetAttribLocation(dVar.ioJ, "a_position");
                dVar.ioK = GLES20.glGetAttribLocation(dVar.ioJ, "a_texCoord");
                dVar.ioM = GLES20.glGetUniformLocation(dVar.ioJ, "y_texture");
                dVar.ioN = GLES20.glGetUniformLocation(dVar.ioJ, "uv_texture");
                dVar.ioO = GLES20.glGetUniformLocation(dVar.ioJ, "uMatrix");
                dVar.ioH = b.XZ();
                dVar.ioI = b.XZ();
                dVar.ioP = ByteBuffer.allocateDirect(dVar.ioT.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                dVar.ioP.put(dVar.ioT);
                dVar.ioP.position(0);
                dVar.ioQ = ByteBuffer.allocateDirect(d.ioy.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                dVar.ioQ.put(d.ioy);
                dVar.ioQ.position(0);
                x.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[]{Integer.valueOf(dVar.ioH), Integer.valueOf(dVar.ioI), dVar});
            }
            x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        }
        while (this.ipo) {
            if (this.iph != null) {
                if (!this.iph.ipq) {
                    try {
                        Thread.sleep(10);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", e, "", new Object[0]);
                    }
                }
                d dVar2 = this.iph;
                bh.Wq();
                dVar2.ioB = true;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16640);
                synchronized (d.lock) {
                    if (dVar2.ioJ != -1 && dVar2.ioH != -1 && dVar2.ioI != -1 && dVar2.ioD > 0 && dVar2.ioE > 0 && dVar2.ioG != null && dVar2.ioF != null && dVar2.ioG.limit() > 0 && dVar2.ioF.limit() > 0 && dVar2.ioG.position() == 0 && dVar2.ioF.position() == 0) {
                        GLES20.glUseProgram(dVar2.ioJ);
                        GLES20.glActiveTexture(33984);
                        GLES20.glBindTexture(3553, dVar2.ioH);
                        GLES20.glTexImage2D(3553, 0, 6409, dVar2.ioD, dVar2.ioE, 0, 6409, 5121, dVar2.ioF);
                        GLES20.glTexParameterf(3553, 10241, 9729.0f);
                        GLES20.glTexParameterf(3553, 10240, 9729.0f);
                        GLES20.glTexParameterf(3553, 10242, 33071.0f);
                        GLES20.glTexParameterf(3553, 10243, 33071.0f);
                        GLES20.glUniform1i(dVar2.ioM, 0);
                        GLES20.glActiveTexture(33985);
                        GLES20.glBindTexture(3553, dVar2.ioI);
                        GLES20.glTexImage2D(3553, 0, 6410, dVar2.ioD / 2, dVar2.ioE / 2, 0, 6410, 5121, dVar2.ioG);
                        GLES20.glTexParameterf(3553, 10241, 9729.0f);
                        GLES20.glTexParameterf(3553, 10240, 9729.0f);
                        GLES20.glTexParameterf(3553, 10242, 33071.0f);
                        GLES20.glTexParameterf(3553, 10243, 33071.0f);
                        GLES20.glUniform1i(dVar2.ioN, 1);
                        Matrix.setIdentityM(dVar2.ioR, 0);
                        Matrix.setRotateM(dVar2.ioR, 0, (float) dVar2.fFy, 0.0f, 0.0f, -1.0f);
                        GLES20.glUniformMatrix4fv(dVar2.ioO, 1, false, dVar2.ioR, 0);
                        dVar2.ioP.position(0);
                        GLES20.glVertexAttribPointer(dVar2.ioL, 2, 5126, false, 0, dVar2.ioP);
                        GLES20.glEnableVertexAttribArray(dVar2.ioL);
                        dVar2.ioQ.position(0);
                        GLES20.glVertexAttribPointer(dVar2.ioK, 2, 5126, false, 0, dVar2.ioQ);
                        GLES20.glEnableVertexAttribArray(dVar2.ioK);
                        GLES20.glDrawArrays(5, 0, 4);
                        GLES20.glDisableVertexAttribArray(dVar2.ioL);
                        GLES20.glDisableVertexAttribArray(dVar2.ioK);
                        GLES20.glBindTexture(3553, 0);
                    }
                }
                dVar2.ioB = false;
            }
            if (this.ipk != null) {
                this.ipk.eglSwapBuffers(this.ipl, this.ipn);
            }
        }
        x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
        if (this.iph != null) {
            dVar = this.iph;
            synchronized (d.lock) {
                if (dVar.ioJ >= 0) {
                    GLES20.glDeleteProgram(dVar.ioJ);
                    dVar.ioJ = -1;
                }
                if (dVar.ioI >= 0) {
                    GLES20.glDeleteTextures(1, new int[]{dVar.ioI}, 0);
                    dVar.ioI = -1;
                }
                if (dVar.ioH >= 0) {
                    GLES20.glDeleteTextures(1, new int[]{dVar.ioH}, 0);
                    dVar.ioH = -1;
                }
                dVar.ioE = -1;
                dVar.ioD = -1;
                dVar.ipp = true;
                dVar.ioF = null;
                dVar.ioG = null;
            }
        }
        if (!(this.ipk == null || this.ipm == null || this.ipn == null)) {
            this.ipk.eglDestroyContext(this.ipl, this.ipm);
            this.ipk.eglDestroySurface(this.ipl, this.ipn);
            this.ipm = EGL10.EGL_NO_CONTEXT;
            this.ipn = EGL10.EGL_NO_SURFACE;
        }
        if (this.ipj != null) {
            this.ipj.release();
        }
        x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
    }
}
