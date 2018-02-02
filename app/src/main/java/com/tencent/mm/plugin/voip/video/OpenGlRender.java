package com.tencent.mm.plugin.voip.video;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGlRender implements Renderer {
    static String TAG = "OpenGlRender";
    public static int stZ = 0;
    public static int sua = 1;
    public static int sub = 2;
    public static int suc = 0;
    public static int sud = 1;
    public static int sue = 0;
    public static int suf = 1;
    public static int sug = 2;
    public static int suh = 3;
    public static int sui = 4;
    public static int suj = 12;
    public static int suk = 16;
    public static int sul = 0;
    public static int sum = 1;
    public static int suw = 0;
    static boolean suy = false;
    int mRenderMode = sul;
    boolean stI = false;
    int stJ = 0;
    long stK = 0;
    long stL = 0;
    int stM = 0;
    a stN;
    public float stO = 1.2f;
    public float stP = 1.93f;
    public float stQ = 1.05f;
    boolean stR = false;
    public boolean stS = false;
    boolean stT = false;
    boolean stU = false;
    boolean stV = false;
    int stW = 0;
    int stX = 0;
    WeakReference<OpenGlView> stY;
    public boolean sun = false;
    public Bitmap suo = null;
    private int sup = 0;
    private int suq = 0;
    private byte[] sur = null;
    private int[] sus = null;
    private int sut;
    private int suu;
    private int suv;
    WeakReference<Object> sux;

    private native void render32(int[] iArr, int i, int i2, int i3, int i4);

    private native void render8(byte[] bArr, int i, int i2, int i3, int i4);

    final native void Init(int i, Object obj, int i2);

    final native void Uninit(int i);

    final native void setMode(int i, int i2, int i3, int i4);

    final native void setParam(float f, float f2, float f3, int i);

    public static int bID() {
        if (suw == 0) {
            suw = ((ActivityManager) ac.getContext().getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT ? 2 : 1;
            if (Build.MODEL.equals("Nexus 6")) {
                suw = 2;
            }
        }
        return suw;
    }

    public OpenGlRender(OpenGlView openGlView, int i) {
        if (!suy) {
            k.b("mm_gl_disp", OpenGlRender.class.getClassLoader());
            suy = true;
        }
        this.mRenderMode = i;
        this.stY = new WeakReference(openGlView);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.stN = new a(this, myLooper);
        } else {
            myLooper = Looper.getMainLooper();
            if (myLooper != null) {
                this.stN = new a(this, myLooper);
            } else {
                this.stN = null;
            }
        }
        this.sux = null;
    }

    public final void onDrawFrame(GL10 gl10) {
        if (this.stS && this.stR && this.stY.get() != null) {
            if (this.sur != null) {
                render8(this.sur, this.sut, this.suu, this.suv, this.mRenderMode);
                this.sur = null;
            }
            if (this.sus != null) {
                render32(this.sus, this.sut, this.suu, this.suv, this.mRenderMode);
                this.sus = null;
                return;
            }
            return;
        }
        this.sur = null;
        this.sus = null;
    }

    public final void c(byte[] bArr, int i, int i2, int i3) {
        if (this.stR && this.sur == null) {
            this.sut = i;
            this.suu = i2;
            this.suv = i3;
            this.sur = bArr;
            requestRender();
        }
    }

    public final void a(int[] iArr, int i, int i2, int i3) {
        if (this.stR && this.sus == null) {
            this.sut = i;
            this.suu = i2;
            this.suv = i3;
            this.sus = iArr;
            requestRender();
        }
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        x.i(TAG, "onSurfaceChanged, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.stW != i || this.stX != i2) {
            gl10.glViewport(0, 0, i, i2);
            this.stW = i;
            this.stX = i2;
            if (VERSION.SDK_INT >= 23) {
                setMode(this.stW, this.stX, 1, this.mRenderMode);
            }
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    public final void bIE() {
        this.stS = false;
        this.stV = false;
    }

    public final void bIF() {
        x.i(TAG, "steve: try to reset GLRender mode=%d, inited:%b, started:%b", new Object[]{Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.stR), Boolean.valueOf(this.stS)});
        if (this.stR && this.stS) {
            x.i(TAG, "steve: Reset GLRender first! mode=%d", new Object[]{Integer.valueOf(this.mRenderMode)});
            this.stR = false;
            this.stS = false;
            Uninit(this.mRenderMode);
        }
    }

    public final void requestRender() {
        if (this.stR) {
            if (!this.stV) {
                setMode(((OpenGlView) this.stY.get()).getWidth(), ((OpenGlView) this.stY.get()).getHeight(), 0, this.mRenderMode);
                this.stV = true;
            }
            if (this.stY.get() != null) {
                OpenGlView openGlView = (OpenGlView) this.stY.get();
                openGlView.suA = true;
                openGlView.requestRender();
            }
        }
    }
}
