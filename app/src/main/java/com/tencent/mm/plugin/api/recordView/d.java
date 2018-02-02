package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class d {
    static float[] iow = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    static final float[] ioy = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    static final Object lock = new Object();
    int fFy;
    private int ioA;
    boolean ioB;
    int ioD;
    int ioE;
    ByteBuffer ioF;
    ByteBuffer ioG;
    int ioH;
    int ioI;
    int ioJ;
    int ioK;
    int ioL;
    int ioM;
    int ioN;
    int ioO;
    FloatBuffer ioP;
    FloatBuffer ioQ;
    float[] ioR;
    float[] ioT;
    private int ioz;
    volatile boolean ipp;
    volatile boolean ipq;

    public d() {
        this.ioz = 0;
        this.ioA = 0;
        this.ioB = false;
        this.ioD = 0;
        this.ioE = 0;
        this.fFy = 0;
        this.ioH = -1;
        this.ioI = -1;
        this.ioJ = -1;
        this.ioR = new float[16];
        this.ioT = iow;
        this.ipp = false;
        this.ipq = false;
        this.ipp = false;
    }

    public final void bv(int i, int i2) {
        x.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this});
        if (i != this.ioz || i2 != this.ioA) {
            x.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i, i2);
            this.ioz = i;
            this.ioA = i2;
        }
    }
}
