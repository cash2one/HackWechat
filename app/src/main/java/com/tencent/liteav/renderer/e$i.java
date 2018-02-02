package com.tencent.liteav.renderer;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

class e$i extends Thread {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l = 0;
    private int m = 0;
    private int n = 1;
    private boolean o = true;
    private boolean p;
    private ArrayList<Runnable> q = new ArrayList();
    private boolean r = true;
    private e$h s;
    private WeakReference<e> t;

    e$i(WeakReference<e> weakReference) {
        this.t = weakReference;
    }

    public void run() {
        setName("GLThread " + getId());
        try {
            i();
        } catch (InterruptedException e) {
        } finally {
            e.e().a(this);
        }
    }

    public int a() {
        return this.s.c();
    }

    public e$h b() {
        return this.s;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() {
        this.s = new e$h(this.t);
        this.h = false;
        this.i = false;
        Object obj = null;
        GL10 gl10 = null;
        int i = 0;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Runnable runnable = null;
        int i2 = 0;
        Object obj8 = null;
        while (true) {
            try {
                synchronized (e.e()) {
                    while (!this.a) {
                        Object obj9;
                        Runnable runnable2;
                        Object obj10;
                        int i3;
                        int i4;
                        if (this.q.isEmpty()) {
                            boolean z;
                            boolean z2;
                            if (this.d != this.c) {
                                z = this.c;
                                this.d = this.c;
                                e.e().notifyAll();
                                z2 = z;
                            } else {
                                z2 = false;
                            }
                            if (this.k) {
                                j();
                                k();
                                this.k = false;
                                obj2 = 1;
                            }
                            if (obj5 != null) {
                                j();
                                k();
                                obj5 = null;
                            }
                            if (z2 && this.i) {
                                j();
                            }
                            if (z2 && this.h) {
                                e eVar = (e) this.t.get();
                                if (eVar == null) {
                                    z = false;
                                } else {
                                    z = e.a(eVar);
                                }
                                if (!z || e.e().a()) {
                                    k();
                                }
                            }
                            if (z2 && e.e().b()) {
                                this.s.g();
                            }
                            if (!(this.e || this.g)) {
                                if (this.i) {
                                    j();
                                }
                                this.g = true;
                                this.f = false;
                                e.e().notifyAll();
                            }
                            if (this.e && this.g) {
                                this.g = false;
                                e.e().notifyAll();
                            }
                            if (obj8 != null) {
                                obj3 = null;
                                obj8 = null;
                                this.p = true;
                                e.e().notifyAll();
                            }
                            if (l()) {
                                if (!this.h) {
                                    if (obj2 != null) {
                                        obj2 = null;
                                    } else if (e.e().b(this)) {
                                        this.s.a();
                                        this.h = true;
                                        obj = 1;
                                        e.e().notifyAll();
                                    }
                                }
                                if (!this.h || this.i) {
                                    obj9 = obj4;
                                    obj4 = obj6;
                                } else {
                                    this.i = true;
                                    obj7 = 1;
                                    obj9 = 1;
                                    obj4 = 1;
                                }
                                if (this.i) {
                                    int i5;
                                    Object obj11;
                                    int i6;
                                    if (this.r) {
                                        obj3 = 1;
                                        i = this.l;
                                        i5 = this.m;
                                        obj11 = 1;
                                        obj6 = 1;
                                        this.r = false;
                                    } else {
                                        obj6 = obj7;
                                        i6 = i2;
                                        obj11 = obj3;
                                        obj3 = obj9;
                                        i5 = i;
                                        i = i6;
                                    }
                                    this.o = false;
                                    e.e().notifyAll();
                                    obj7 = obj4;
                                    obj4 = obj11;
                                    runnable2 = runnable;
                                    obj10 = obj8;
                                    i3 = i;
                                    i6 = i5;
                                    obj9 = obj6;
                                    obj6 = obj5;
                                    obj5 = obj3;
                                    obj3 = obj2;
                                    i4 = i6;
                                } else {
                                    obj6 = obj4;
                                    obj4 = obj9;
                                }
                            }
                            e.e().wait();
                        } else {
                            obj10 = obj8;
                            i3 = i2;
                            runnable2 = (Runnable) this.q.remove(0);
                            obj9 = obj7;
                            obj7 = obj6;
                            obj6 = obj5;
                            obj5 = obj4;
                            obj4 = obj3;
                            obj3 = obj2;
                            i4 = i;
                        }
                    }
                    synchronized (e.e()) {
                        j();
                        k();
                    }
                    return;
                }
            } catch (RuntimeException e) {
                e.e().c(this);
                throw e;
            } catch (Throwable th) {
                synchronized (e.e()) {
                    j();
                    k();
                }
            }
        }
    }

    private void j() {
        if (this.i) {
            this.i = false;
            this.s.f();
        }
    }

    private void k() {
        if (this.h) {
            this.s.g();
            this.h = false;
            e eVar = (e) this.t.get();
            if (eVar != null) {
                eVar.h = false;
            }
            e.e().c(this);
        }
    }

    public boolean c() {
        return this.h && this.i && l();
    }

    private boolean l() {
        return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
    }

    public void a(int i) {
        if (i < 0 || i > 1) {
            throw new IllegalArgumentException("renderMode");
        }
        synchronized (e.e()) {
            this.n = i;
            e.e().notifyAll();
        }
    }

    public int d() {
        int i;
        synchronized (e.e()) {
            i = this.n;
        }
        return i;
    }

    public void e() {
        synchronized (e.e()) {
            this.e = true;
            this.j = false;
            e.e().notifyAll();
            while (this.g && !this.j && !this.b) {
                try {
                    e.e().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void f() {
        synchronized (e.e()) {
            this.e = false;
            e.e().notifyAll();
            while (!this.g && !this.b) {
                try {
                    e.e().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void a(int i, int i2) {
        synchronized (e.e()) {
            this.l = i;
            this.m = i2;
            this.r = true;
            this.o = true;
            this.p = false;
            e.e().notifyAll();
            while (!this.b && !this.d && !this.p && c()) {
                try {
                    e.e().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void g() {
        synchronized (e.e()) {
            this.a = true;
            e.e().notifyAll();
            while (!this.b) {
                try {
                    e.e().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void h() {
        this.k = true;
        e.e().notifyAll();
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        synchronized (e.e()) {
            this.q.add(runnable);
            e.e().notifyAll();
        }
    }
}
