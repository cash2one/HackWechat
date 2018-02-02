package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.d.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.List;

public class v extends c {
    private static final short[] x = new short[]{(short) 1, (short) 2, (short) 0, (short) 2, (short) 0, (short) 3};
    private static final float[] y = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private static final float[] z = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    private ShortBuffer A = null;
    private String B = "GPUWatermark";
    protected a[] r = null;
    protected List<com.tencent.liteav.beauty.c.c> s = null;
    protected boolean t = false;
    protected int u = 772;
    private a v = null;
    private int w = 1;

    public class a {
        public FloatBuffer a = null;
        public FloatBuffer b = null;
        public Bitmap c;
        public int[] d = null;
        final /* synthetic */ v e;

        public a(v vVar) {
            this.e = vVar;
        }
    }

    public v() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(x.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.A = allocateDirect.asShortBuffer();
        this.A.put(x);
        this.A.position(0);
        this.o = true;
    }

    public void d() {
        super.d();
        this.t = false;
        q();
    }

    public void c(boolean z) {
        this.t = z;
    }

    public void a(Bitmap bitmap, float f, float f2, float f3, int i) {
        if (bitmap == null) {
            if (this.r != null && this.r[i] != null) {
                new StringBuilder("release ").append(i).append(" water mark!");
                if (this.r[i].d != null) {
                    GLES20.glDeleteTextures(1, this.r[i].d, 0);
                }
                this.r[i].d = null;
                this.r[i].c = null;
                this.r[i] = null;
            }
        } else if (this.r[i] != null && i < this.r.length) {
            a(bitmap.getWidth(), bitmap.getHeight(), f, f2, f3, i);
            if (this.r[i].d == null) {
                this.r[i].d = new int[1];
                GLES20.glGenTextures(1, this.r[i].d, 0);
                GLES20.glBindTexture(3553, this.r[i].d[0]);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            if (this.r[i].c == null || !this.r[i].c.equals(bitmap)) {
                GLES20.glBindTexture(3553, this.r[i].d[0]);
                GLUtils.texImage2D(3553, 0, bitmap, 0);
            }
            this.r[i].c = bitmap;
        }
    }

    protected void a(int i, int i2, float f, float f2, float f3, int i3) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(y.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.r[i3].a = allocateDirect.asFloatBuffer();
        float[] fArr = new float[y.length];
        float f4 = (((((float) i2) / ((float) i)) * f3) * ((float) this.e)) / ((float) this.f);
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        fArr[0] = (2.0f * f) - 1.0f;
        fArr[1] = 1.0f - (2.0f * f2);
        fArr[2] = fArr[0];
        fArr[3] = fArr[1] - (f4 * 2.0f);
        fArr[4] = fArr[0] + (2.0f * f3);
        fArr[5] = fArr[3];
        fArr[6] = fArr[4];
        fArr[7] = fArr[1];
        for (int i4 = 1; i4 <= 7; i4 += 2) {
            fArr[i4] = fArr[i4] * -1.0f;
        }
        this.r[i3].a.put(fArr);
        this.r[i3].a.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(z.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.r[i3].b = allocateDirect2.asFloatBuffer();
        this.r[i3].b.put(z);
        this.r[i3].b.position(0);
    }

    public void a(Bitmap bitmap, float f, float f2, float f3) {
        if (this.r == null) {
            this.r = new a[1];
        }
        if (this.r[0] == null) {
            this.r[0] = new a(this);
        }
        a(bitmap, f, f2, f3, 0);
        this.v = this.r[0];
    }

    private void q() {
        if (this.r != null) {
            for (int i = 0; i < this.r.length; i++) {
                if (this.r[i] != null) {
                    if (this.r[i].d != null) {
                        GLES20.glDeleteTextures(1, this.r[i].d, 0);
                    }
                    this.r[i].d = null;
                    this.r[i].c = null;
                    this.r[i] = null;
                }
            }
        }
        this.r = null;
    }

    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.a);
        k();
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 0, floatBuffer);
        GLES20.glEnableVertexAttribArray(this.b);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.d);
        if (i != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(this.c, 0);
            i();
            GLES20.glDrawArrays(5, 0, 4);
        }
        GLES20.glDisableVertexAttribArray(this.b);
        GLES20.glDisableVertexAttribArray(this.d);
        if (this.t) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(this.u, 771);
            GLES20.glActiveTexture(33984);
            for (int i2 = 0; i2 < this.r.length; i2++) {
                if (this.r[i2] != null) {
                    GLES20.glBindTexture(3553, this.r[i2].d[0]);
                    GLES20.glUniform1i(this.c, 0);
                    GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 8, this.r[i2].a);
                    GLES20.glEnableVertexAttribArray(this.b);
                    GLES20.glVertexAttribPointer(this.d, 4, 5126, false, 16, this.r[i2].b);
                    GLES20.glEnableVertexAttribArray(this.d);
                    GLES20.glDrawElements(4, x.length, 5123, this.A);
                    GLES20.glDisableVertexAttribArray(this.b);
                    GLES20.glDisableVertexAttribArray(this.d);
                }
            }
            GLES20.glDisable(3042);
        }
        GLES20.glBindTexture(3553, 0);
    }
}
