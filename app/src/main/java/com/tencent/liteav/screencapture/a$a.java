package com.tencent.liteav.screencapture;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.d.b;
import com.tencent.liteav.basic.d.d;
import com.tencent.liteav.basic.d.e;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.util.TXCTimeUtil;

protected class a$a extends Handler {
    public int a = 0;
    public int[] b = null;
    public Surface c = null;
    public SurfaceTexture d = null;
    public int e = 720;
    public int f = 1280;
    public int g = 25;
    protected boolean h = false;
    protected long i = 0;
    protected long j = 0;
    protected b k = null;
    protected d l = null;
    float[] m = new float[16];
    final /* synthetic */ a n;

    public a$a(a aVar, Looper looper, a aVar2) {
        this.n = aVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message != null) {
            if (this.a == this.n.e || 101 == message.what) {
                switch (message.what) {
                    case 100:
                        a(message);
                        break;
                    case 101:
                        b(message);
                        break;
                    case 102:
                        c(message);
                        break;
                    case 103:
                        d(message);
                        break;
                }
                if (message != null && message.obj != null) {
                    ((Runnable) message.obj).run();
                }
            }
        }
    }

    protected void a(Message message) {
        this.i = 0;
        this.j = 0;
        if (a()) {
            this.n.a(0, this.k.d());
            return;
        }
        b();
        this.n.b();
        this.n.a(20000003, null);
    }

    protected void b(Message message) {
        c c = this.n.c();
        if (c != null) {
            c.a(a.a(this.n));
        }
        b();
    }

    protected void c(Message message) {
        this.n.a(102, 5);
        if (!this.n.i) {
            return;
        }
        if (this.h) {
            long nanoTime = System.nanoTime();
            if (nanoTime >= this.j + ((((this.i * 1000) * 1000) * 1000) / ((long) this.g))) {
                if (this.j == 0) {
                    this.j = nanoTime;
                } else if (nanoTime > this.j + 1000000000) {
                    this.i = 0;
                    this.j = nanoTime;
                }
                this.i++;
                if (this.d != null && this.b != null) {
                    this.d.getTransformMatrix(this.m);
                    this.d.updateTexImage();
                    this.l.a(this.m);
                    GLES20.glViewport(0, 0, this.e, this.f);
                    this.n.a(0, this.l.b(this.b[0]), this.e, this.f, TXCTimeUtil.getTimeTick());
                    return;
                }
                return;
            }
            return;
        }
        this.i = 0;
        this.j = System.nanoTime();
    }

    protected void d(Message message) {
        if (message != null) {
            this.g = message.arg1 <= 0 ? 1 : message.arg1;
            this.i = 0;
            this.j = 0;
        }
    }

    protected boolean a() {
        this.k = b.a(null, null, null, this.e, this.f);
        if (this.k == null) {
            return false;
        }
        this.b = new int[1];
        this.b[0] = e.b();
        if (this.b[0] <= 0) {
            this.b = null;
            return false;
        }
        this.d = new SurfaceTexture(this.b[0]);
        this.c = new Surface(this.d);
        this.d.setDefaultBufferSize(this.e, this.f);
        this.d.setOnFrameAvailableListener(new 1(this));
        this.l = new d();
        if (!this.l.a()) {
            return false;
        }
        this.l.a(true);
        this.l.a(this.e, this.f);
        this.l.a(g.e, g.a(f.a, false, false));
        b.a().a(this.c, this.e, this.f);
        return true;
    }

    protected void b() {
        c();
        if (this.l != null) {
            this.l.d();
            this.l = null;
        }
        if (this.k != null) {
            this.k.c();
            this.k = null;
        }
    }

    protected void c() {
        if (this.d != null) {
            this.d.setOnFrameAvailableListener(null);
            this.d.release();
            this.h = false;
            this.d = null;
        }
        b.a().a(this.c);
        if (this.c != null) {
            this.c.release();
            this.c = null;
        }
        if (this.b != null) {
            GLES20.glDeleteTextures(1, this.b, 0);
            this.b = null;
        }
    }
}
