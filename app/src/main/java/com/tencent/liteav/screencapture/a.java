package com.tencent.liteav.screencapture;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class a {
    protected Handler a;
    protected volatile HandlerThread b;
    protected volatile a c;
    protected volatile WeakReference<c> d;
    protected volatile int e;
    protected int f;
    protected int g;
    protected int h;
    protected boolean i;
    private Object j;

    public a(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 720;
        this.g = 1280;
        this.h = 20;
        this.i = false;
        this.j = null;
        this.a = new Handler(Looper.getMainLooper());
        if (VERSION.SDK_INT >= 21) {
            b.a().a(context);
        }
    }

    public int a(int i, int i2, int i3) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        if (VERSION.SDK_INT < 21) {
            a(20000004, null);
            return 20000004;
        }
        a();
        return 0;
    }

    public void a(Object obj) {
        this.j = obj;
        b();
    }

    public void a(boolean z) {
        if (this.c != null) {
            this.c.post(new 1(this, z));
        } else {
            this.i = z;
        }
    }

    public void a(c cVar) {
        this.d = new WeakReference(cVar);
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        b.a().a(aVar);
    }

    protected void a() {
        b();
        synchronized (this) {
            this.b = new HandlerThread("HWVideoEncoder");
            this.b.start();
            this.c = new a(this, this.b.getLooper(), this);
            this.e++;
            this.c.a = this.e;
            this.c.e = this.f;
            this.c.f = this.g;
            this.c.g = this.h <= 0 ? 1 : this.h;
        }
        a(100);
    }

    protected void b() {
        synchronized (this) {
            this.e++;
            if (this.c != null) {
                a(101, new 2(this, this.c, this.b));
            }
            this.c = null;
            this.b = null;
        }
    }

    protected c c() {
        return this.d == null ? null : (c) this.d.get();
    }

    protected void a(int i, long j) {
        synchronized (this) {
            if (this.c != null) {
                this.c.sendEmptyMessageDelayed(i, j);
            }
        }
    }

    protected void a(int i) {
        synchronized (this) {
            if (this.c != null) {
                this.c.sendEmptyMessage(i);
            }
        }
    }

    protected void a(int i, Runnable runnable) {
        synchronized (this) {
            if (this.c != null) {
                Message message = new Message();
                message.what = i;
                message.obj = runnable;
                this.c.sendMessage(message);
            }
        }
    }

    protected void a(int i, EGLContext eGLContext) {
        c c = c();
        if (c != null) {
            c.a(i, eGLContext);
        }
    }

    protected void a(int i, int i2, int i3, int i4, long j) {
        c c = c();
        if (c != null) {
            c.a(i, i2, i3, i4, j);
        }
    }
}
