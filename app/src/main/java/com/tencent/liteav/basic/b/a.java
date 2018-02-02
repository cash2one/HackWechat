package com.tencent.liteav.basic.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.util.LinkedList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class a {
    private static int a = 200;
    private long A;
    private ReadWriteLock B;
    private b b;
    private LinkedList<b> c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private HandlerThread j;
    private Handler k;
    private boolean l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private int s;
    private int t;
    private long u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    static /* synthetic */ long e(a aVar) {
        long j = aVar.v + 1;
        aVar.v = j;
        return j;
    }

    static /* synthetic */ long g(a aVar) {
        long j = aVar.z + 1;
        aVar.z = j;
        return j;
    }

    public a() {
        this.b = null;
        this.c = new LinkedList();
        this.d = 0;
        this.e = 15;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = null;
        this.k = null;
        this.l = false;
        this.m = 20;
        this.n = 0;
        this.o = 200;
        this.p = 10;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = new ReentrantReadWriteLock();
        this.j = new HandlerThread("VideoJitterBufferHandler");
        this.j.start();
        this.B.writeLock().lock();
        this.k = new Handler(this.j.getLooper());
        this.B.writeLock().unlock();
    }

    public void a(b bVar) {
        this.B.readLock().lock();
        if (this.k != null) {
            this.k.post(new 1(this, bVar));
        }
        this.B.readLock().unlock();
    }

    private void l() {
        this.B.readLock().lock();
        if (this.k != null) {
            this.k.postDelayed(new 2(this), this.m);
        }
        this.B.readLock().unlock();
    }

    public void a() {
        this.B.readLock().lock();
        if (this.k != null) {
            this.k.post(new 3(this));
        }
        this.B.readLock().unlock();
        l();
    }

    public void b() {
        this.B.writeLock().lock();
        if (this.k != null) {
            this.k.post(new 4(this));
        }
        this.k = null;
        this.B.writeLock().unlock();
    }

    private void m() {
        this.c.clear();
        this.d = 0;
        this.e = 15;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.q = 0;
        this.r = 0;
        this.t = 0;
        this.s = 0;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.r = bVar.g;
            if (bVar.b == 0) {
                this.s = this.t;
                this.t = 1;
            } else if (bVar.b == 2 || bVar.b == 1) {
                this.t++;
            }
            this.B.readLock().lock();
            if (this.k != null) {
                this.k.post(new 5(this, bVar));
            }
            this.B.readLock().unlock();
        }
    }

    private b n() {
        long timeTick = TXCTimeUtil.getTimeTick() - this.f;
        long o = o();
        if (this.n + timeTick < o) {
            return null;
        }
        if (this.f != 0) {
            this.n = (timeTick + this.n) - o;
        }
        b p = p();
        if (p != null) {
            this.f = TXCTimeUtil.getTimeTick();
            return p;
        }
        this.n = 0;
        return p;
    }

    public void a(long j) {
        this.q = j;
    }

    public long c() {
        return this.r - this.q;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.q;
    }

    public long f() {
        return this.r;
    }

    public int g() {
        return this.s;
    }

    public long h() {
        return this.x;
    }

    public long i() {
        return this.A;
    }

    public long j() {
        long j;
        if (this.v != 0) {
            j = this.u / this.v;
        } else {
            j = 0;
        }
        this.v = 0;
        this.u = 0;
        return j;
    }

    private long o() {
        long m;
        if (this.b != null) {
            m = this.b.m();
        } else {
            m = 0;
        }
        long d = d();
        if (0 == m) {
            if ((d * 1000) / this.e < this.o) {
                return 1000 / this.e;
            }
            m = (1000 / this.e) - this.p;
            if (m >= 0) {
                return m;
            }
            return 0;
        } else if (d == 0) {
            return 1000 / this.e;
        } else {
            return m / d;
        }
    }

    private b p() {
        b bVar = null;
        if (!this.c.isEmpty()) {
            bVar = (b) this.c.getFirst();
            this.c.removeFirst();
            this.d = (long) this.c.size();
            if (this.b != null) {
                this.d += (long) this.b.n();
            }
        }
        return bVar;
    }

    private void b(long j) {
        if (this.i != 0) {
            if (this.h >= 5) {
                this.e = this.g / this.h;
                if (this.e > 200) {
                    this.e = 200;
                } else if (this.e < 1) {
                    this.e = 1;
                }
                this.g = 0;
                this.h = 0;
            } else {
                long j2 = j - this.i;
                if (j2 > 0) {
                    this.g = (1000 / j2) + this.g;
                    this.h++;
                }
            }
        }
        this.i = j;
    }

    protected void finalize() {
        super.finalize();
        try {
            b();
        } catch (Exception e) {
        }
    }
}
