package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.d.e;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class d extends e implements OnFrameAvailableListener, Renderer {
    private int A = 0;
    private boolean B = true;
    private a C = null;
    private final Queue<Runnable> D = new LinkedList();
    i a;
    j b;
    WeakReference<a> c;
    private SurfaceTexture i;
    private EGLContext j;
    private c k;
    private boolean l = false;
    private int[] m;
    private float[] n = new float[16];
    private int o = 0;
    private boolean p = false;
    private float q = 1.0f;
    private float r = 1.0f;
    private int s = 20;
    private long t = 0;
    private long u = 0;
    private int v = 12288;
    private boolean w = true;
    private boolean x = false;
    private Object y = new Object();
    private int z = 0;

    public d(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        a(8, 8, 8, 8, 16, 0);
        setRenderer(this);
    }

    public void setFPS(int i) {
        a(new 1(this, i));
    }

    protected void a() {
        if (this.a != null) {
            this.a.b(null);
        }
    }

    protected void setRunInBackground(boolean z) {
        if (z) {
            synchronized (this) {
                TXCLog.d("TXCGLSurfaceView", "background capture enter background");
                this.e = true;
            }
            return;
        }
        a(new 2(this));
    }

    public void setListener(i iVar) {
        this.a = iVar;
    }

    public void setTextureListener(j jVar) {
        this.b = jVar;
    }

    public void setNotifyListener(a aVar) {
        this.c = new WeakReference(aVar);
    }

    public void a(a aVar) {
        this.C = aVar;
        this.B = true;
    }

    public void b() {
        this.l = false;
        this.C = null;
        this.B = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        if (this.k != null) {
            synchronized (this) {
                if (this.e) {
                }
            }
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.i;
    }

    public EGLContext getGLContext() {
        return this.j;
    }

    protected int c() {
        if (this.v != 12288) {
            TXCLog.e("TXCGLSurfaceView", "background capture swapbuffer error : " + this.v);
        }
        return this.v;
    }

    public void a(Runnable runnable) {
        synchronized (this.D) {
            this.D.add(runnable);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(Queue<Runnable> queue) {
        synchronized (queue) {
            if (queue.isEmpty()) {
                return false;
            }
            Runnable runnable = (Runnable) queue.poll();
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.j = ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
        this.m = new int[1];
        this.m[0] = e.b();
        if (this.m[0] <= 0) {
            this.m = null;
            TXCLog.e("TXCGLSurfaceView", "create oes texture error!! at glsurfaceview");
            return;
        }
        this.i = new SurfaceTexture(this.m[0]);
        this.i.setOnFrameAvailableListener(this);
        this.k = new c();
        if (this.k.a()) {
            this.k.a(g.e, g.a(f.a, false, false));
            if (this.a != null) {
                this.a.a(this.i);
            }
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDrawFrame(GL10 gl10) {
        Object obj = null;
        a(this.D);
        while (true) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.u == 0) {
                this.u = currentTimeMillis;
            }
            if (currentTimeMillis - this.u >= (this.t * 1000) / ((long) this.s)) {
                break;
            }
            g();
        }
        this.t++;
        if (currentTimeMillis - this.u > 2000) {
            this.t = 1;
            this.u = System.currentTimeMillis();
        }
        if (!this.w) {
            synchronized (this) {
                if (this.x) {
                    if (this.i != null) {
                        this.i.updateTexImage();
                        this.i.getTransformMatrix(this.n);
                    }
                    this.x = false;
                } else {
                    return;
                }
            }
        }
        return;
        f();
        synchronized (this) {
            if (!this.e) {
                obj = 1;
            }
        }
        if (obj != null) {
            this.v = d();
        }
    }

    private void f() {
        if (this.B) {
            if (!(this.z == 0 || this.A == 0)) {
                boolean z = getWidth() <= getHeight();
                int i = this.A >= this.z ? this.A : this.z;
                int i2 = this.A >= this.z ? this.z : this.A;
                if (z) {
                    int i3 = i;
                    i = i2;
                    i2 = i3;
                }
                Buffer allocate = ByteBuffer.allocate((i * i2) * 4);
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                allocate.position(0);
                GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, allocate);
                new Thread(new 3(this, allocate, createBitmap, i, i2)).start();
            }
            this.B = false;
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (!this.l) {
            com.tencent.liteav.basic.util.a.a(this.c, 1007, "首帧画面采集完成");
            this.l = true;
        }
        this.w = false;
        synchronized (this) {
            this.x = true;
        }
    }

    public void a(boolean z) {
        this.w = true;
        if (z) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            this.v = d();
        }
        synchronized (this) {
            if (this.x) {
                this.x = false;
                if (this.i != null) {
                    this.i.updateTexImage();
                }
            }
        }
    }

    public void b(boolean z) {
        synchronized (this.y) {
            a(new 4(this, z));
            try {
                this.y.wait(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    private void g() {
        try {
            Thread.sleep(15);
        } catch (Exception e) {
        }
    }
}
