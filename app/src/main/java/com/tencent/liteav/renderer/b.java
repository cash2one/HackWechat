package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLContext;

public class b extends h implements OnFrameAvailableListener {
    j a;
    a b;
    private final int k = 0;
    private final int l = 0;
    private final int m = 0;
    private final int n = 0;
    private c o;
    private SurfaceTexture p;
    private f q;
    private boolean r;
    private float[] s = new float[16];
    private f t;
    private ArrayList<Long> u = new ArrayList();
    private TXCYuvTextureRender v;
    private final Queue<Runnable> w = new LinkedList();

    public void a(j jVar) {
        this.a = jVar;
    }

    public void a(a aVar) {
        this.b = aVar;
        if (aVar != null && this.v != null) {
            this.v.setHasFrameBuffer(this.g, this.h);
        }
    }

    public void a(long j, int i, int i2) {
        synchronized (this) {
            this.u.add(Long.valueOf(j));
        }
        super.a(j, i, i2);
    }

    public void a(int i, int i2, int i3, boolean z, int i4) {
        GLES20.glViewport(0, 0, this.e, this.f);
        if (this.t != null) {
            this.t.a(i, z, i4);
        }
        super.a(i, i2, i3, z, i4);
    }

    public SurfaceTexture a() {
        return this.p;
    }

    public EGLContext b() {
        return this.o != null ? this.o.a() : null;
    }

    protected void a(SurfaceTexture surfaceTexture) {
        n();
    }

    protected void b(SurfaceTexture surfaceTexture) {
        o();
    }

    protected void a(int i, int i2) {
        super.a(i, i2);
        if (this.v != null) {
            this.v.setVideoSize(i, i2);
        }
        if (this.q != null) {
            this.q.a(i, i2);
        }
    }

    void c() {
        m();
        if (this.d != null) {
            this.d.a(this.e, this.f);
            this.d.b(this.g, this.h);
        }
        if (this.q != null) {
            this.q.b();
            this.p = new SurfaceTexture(this.q.a());
            this.p.setOnFrameAvailableListener(this);
        }
        if (this.v != null) {
            this.v.createTexture();
        }
        if (!(this.b == null || this.v == null)) {
            this.v.setHasFrameBuffer(this.g, this.h);
        }
        if (this.t != null) {
            this.t.b();
        }
        if (this.i != null) {
            this.i.a(this.p);
        }
    }

    private void m() {
        this.q = new f(true);
        this.v = new TXCYuvTextureRender();
        this.t = new f(false);
    }

    void d() {
        try {
            if (this.i != null) {
                this.i.b(this.p);
            }
        } catch (Exception e) {
        }
        this.q = null;
        this.v = null;
        this.t = null;
    }

    boolean e() {
        do {
        } while (a(this.w));
        return p();
    }

    SurfaceTexture f() {
        return this.c != null ? this.c.getSurfaceTexture() : null;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private void n() {
        this.o = new c(new WeakReference(this));
        this.o.start();
        TXCLog.w("TXCVideoRender", "play:vrender: start render thread");
    }

    private void o() {
        if (this.o != null) {
            this.o.b();
            this.o = null;
            TXCLog.w("TXCVideoRender", "play:vrender: quit render thread");
        }
        this.p = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean p() {
        synchronized (this) {
            boolean z;
            long j;
            if (this.r) {
                z = this.r;
                this.r = false;
                j = 0;
            } else if (this.u.isEmpty()) {
                return false;
            } else {
                j = ((Long) this.u.get(0)).longValue();
                this.u.remove(0);
                z = false;
            }
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

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            this.r = true;
        }
    }

    public void finalize() {
        super.finalize();
        TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when finalize");
        try {
            o();
        } catch (Exception e) {
        }
    }
}
