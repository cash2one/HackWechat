package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.c;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLContext;

public class i implements j, c {
    private static final String a = i.class.getSimpleName();
    private k b;
    private a c = null;
    private EGLContext d = null;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Queue<Runnable> j = new LinkedList();

    public i(Context context, f fVar) {
        int i;
        int i2 = 720;
        this.c = new a(context);
        this.c.a(this);
        boolean a = fVar.a();
        this.e = fVar.h;
        if (a) {
            i = 1280;
        } else {
            i = 720;
        }
        this.f = i;
        if (!a) {
            i2 = 1280;
        }
        this.g = i2;
        this.h = fVar.a;
        this.i = fVar.b;
    }

    public void a() {
        this.c.a(this.f, this.g, this.e);
        this.c.a(true);
    }

    public void a(boolean z) {
        this.c.a(null);
        this.c.a(false);
    }

    public void b() {
        this.c.a(false);
    }

    public void b(boolean z) {
    }

    public boolean c() {
        return true;
    }

    public int d() {
        return 0;
    }

    public EGLContext e() {
        return this.d;
    }

    public boolean a(int i) {
        return false;
    }

    public void a(float f) {
    }

    public void b(int i) {
    }

    public void a(k kVar) {
        this.b = kVar;
    }

    public void c(boolean z) {
    }

    public boolean d(boolean z) {
        return false;
    }

    public void a(com.tencent.liteav.basic.f.c cVar) {
    }

    public void e(boolean z) {
    }

    public void a(Runnable runnable) {
        synchronized (this.j) {
            this.j.add(runnable);
        }
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        if (this.c != null) {
            this.c.a(aVar);
        }
    }

    public void c(int i) {
    }

    public void a(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    public void d(int i) {
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

    public void a(int i, EGLContext eGLContext) {
        if (i == 0) {
            this.d = eGLContext;
            return;
        }
        this.d = null;
        TXCLog.e(a, "Start screen capture failed");
    }

    public void a(int i, int i2, int i3, int i4, long j) {
        do {
        } while (a(this.j));
        if (i != 0) {
            TXCLog.e(a, "onScreenCaptureFrame failed");
        } else if (this.b != null) {
            com.tencent.liteav.basic.f.c cVar = new com.tencent.liteav.basic.f.c();
            cVar.d = i3;
            cVar.e = i4;
            cVar.f = this.h;
            cVar.g = this.i;
            cVar.a = i2;
            cVar.b = 0;
            cVar.i = 0;
            cVar.j = com.tencent.liteav.basic.util.a.a(cVar.d, cVar.e, this.h, this.i);
            this.b.b(cVar);
        }
    }

    public void a(Object obj) {
        do {
        } while (a(this.j));
        if (this.b != null) {
            this.b.q();
        }
    }
}
