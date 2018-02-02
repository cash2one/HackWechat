package com.tencent.mm.vending.g;

import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import com.tencent.mm.vending.j.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import junit.framework.Assert;

public class e<_Var> implements c<_Var> {
    private int mRetryCount = 0;
    f zBL = new f(this.zCd, this.zCn);
    private volatile boolean zBY = false;
    volatile d zBZ = d.Idle;
    boolean zCa = false;
    private Queue<a> zCb = new LinkedList();
    private volatile com.tencent.mm.vending.h.d zCc = this.zCd;
    private volatile com.tencent.mm.vending.h.d zCd = g.czY();
    volatile Object zCe;
    volatile boolean zCf;
    volatile Object zCg;
    a zCh;
    a zCi;
    private long zCj = -1;
    private boolean zCk = false;
    private b zCl = new b(this);
    private com.tencent.mm.vending.h.d zCm;
    private com.tencent.mm.vending.h.f.a zCn = new com.tencent.mm.vending.h.f.a(this) {
        final /* synthetic */ e zCv;

        {
            this.zCv = r1;
        }

        public final void czT() {
            f czV = f.czV();
            e eVar = this.zCv;
            Stack stack = (Stack) czV.zCM.get();
            if (stack == null) {
                stack = new Stack();
                czV.zCM.set(stack);
            }
            stack.push(eVar);
        }

        public final void co(Object obj) {
            ((Stack) f.czV().zCM.get()).pop();
            synchronized (this.zCv) {
                this.zCv.zCh = this.zCv.zCi;
                this.zCv.zCi = null;
                if (this.zCv.zCa) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
                } else {
                    this.zCv.zCe = obj;
                }
                if (this.zCv.zBZ == d.Interrupted) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
                } else if (this.zCv.zBZ == d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
                } else {
                    this.zCv.zBZ = d.Resolved;
                    this.zCv.cn(this.zCv.cm(obj));
                }
            }
        }

        public final void interrupt() {
            this.zCv.nG(true);
        }
    };
    List<Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d>> zCo;
    private List<Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d>> zCp;
    private boolean zCq = false;
    boolean zCr = false;
    private boolean zCs = false;
    private Object zCt;
    Object zCu;

    private static class a {
        public com.tencent.mm.vending.h.d ffh;
        public com.tencent.mm.vending.c.a gSf;
        public long mInterval;
        public boolean zCD;

        public a(com.tencent.mm.vending.c.a aVar, com.tencent.mm.vending.h.d dVar, long j, boolean z) {
            this.gSf = aVar;
            this.ffh = dVar;
            this.mInterval = j;
            this.zCD = z;
        }
    }

    public static class c extends Error {
        public c(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private enum d {
        Idle,
        Resolved,
        Invoking,
        Pausing,
        Interrupted,
        AllDone
    }

    class b implements b {
        final /* synthetic */ e zCv;

        b(e eVar) {
            this.zCv = eVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void cl(Object obj) {
            synchronized (this.zCv) {
                if (this.zCv.zBZ == d.Interrupted) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
                } else if (e.a(this.zCv) || this.zCv.zBZ == d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt Pipeline(%s)", this.zCv);
                    this.zCv.nG(false);
                    this.zCv.zCr = true;
                    this.zCv.zCu = obj;
                    if (this.zCv.zCo != null) {
                        for (Pair a : this.zCv.zCo) {
                            this.zCv.a(a, obj);
                        }
                    }
                } else {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
                }
            }
        }

        public final void czP() {
            synchronized (this.zCv) {
                synchronized (this.zCv) {
                    if (this.zCv.zBZ == d.Interrupted || this.zCv.zBZ == d.Idle) {
                        com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", this.zCv.zBZ);
                    } else if (!e.a(this.zCv)) {
                        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", this.zCv);
                    } else if (e.b(this.zCv)) {
                        this.zCv.zBZ = d.Pausing;
                    } else {
                        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", this.zCv);
                    }
                }
            }
        }

        public final void t(Object... objArr) {
            synchronized (this.zCv) {
                if (this.zCv.zBZ != d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", this.zCv.zBZ);
                    return;
                }
                e eVar = this.zCv;
                Object v = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.v(objArr);
                eVar.zCg = v;
                this.zCv.zCf = true;
                com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole().", this.zCv);
                resume();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void resume() {
            synchronized (this.zCv) {
                if (this.zCv.zBZ != d.Pausing) {
                    com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", this.zCv);
                    return;
                }
                if (e.a(this.zCv)) {
                    this.zCv.zBZ = d.Invoking;
                } else {
                    this.zCv.zBZ = d.Resolved;
                }
                if (!e.b(this.zCv)) {
                    this.zCv.cn(this.zCv.cm(this.zCv.zCe));
                }
            }
        }
    }

    static /* synthetic */ boolean a(e eVar) {
        return eVar.zCi != null;
    }

    static /* synthetic */ boolean b(e eVar) {
        return eVar.zCl == g.czQ();
    }

    public c<_Var> aan(String str) {
        if (str == null) {
            Assert.assertNotNull("schedulerTypeString should not be null!", str);
        } else {
            this.zCc = g.aap(str);
            Assert.assertNotNull("mCurrentScheduler should not be null!", this.zCc);
        }
        return this;
    }

    public c<_Var> a(com.tencent.mm.vending.h.d dVar) {
        if (dVar == null) {
            Assert.assertNotNull("scheduler should not be null!", dVar);
        } else {
            this.zCc = dVar;
        }
        return this;
    }

    public c<_Var> b(com.tencent.mm.vending.e.b bVar) {
        Assert.assertNotNull("keeper should not be null!", bVar);
        bVar.keep(this);
        return this;
    }

    public synchronized c<_Var> gs(long j) {
        this.zCj = j;
        return this;
    }

    public c<_Var> nF(boolean z) {
        this.zCk = z;
        return this;
    }

    public synchronized c<_Var> a(final com.tencent.mm.vending.g.c.a<_Var> aVar) {
        u(new Object[0]);
        a(new com.tencent.mm.vending.c.a<_Var, _Var>(this) {
            final /* synthetic */ e zCv;

            public final _Var call(_Var _Var) {
                return aVar.call();
            }
        }, true);
        return this;
    }

    public synchronized c<_Var> u(Object... objArr) {
        c<_Var> cVar;
        if (this.zBZ != d.Idle) {
            cVar = this;
        } else {
            this.zBZ = d.Resolved;
            Object v = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.v(objArr);
            this.zCe = v;
            cn(this.zCe);
            v = this;
        }
        return cVar;
    }

    public void dead() {
        nG(true);
    }

    public final b czQ() {
        return this.zCl;
    }

    public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return aan("Vending.UI").b(aVar);
    }

    public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return aan("Vending.LOGIC").b(aVar);
    }

    public <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return aan("Vending.HEAVY_WORK").b(aVar);
    }

    private synchronized <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> aVar, boolean z) {
        c<_Ret> cVar;
        czR();
        this.zCb.add(new a(aVar, this.zCc, this.zCj, z));
        this.zCj = -1;
        if (this.zBZ == d.Idle) {
            cVar = this;
        } else if (this.zBZ != d.Resolved) {
            r0 = this;
        } else {
            cn(this.zCe);
            r0 = this;
        }
        return cVar;
    }

    public synchronized <_Ret> c<_Ret> b(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return a((com.tencent.mm.vending.c.a) aVar, this.zCk);
    }

    private synchronized void czR() {
        if (this.zBY) {
            throw new c("This Pipeline(%s) has terminate and do not allow any next().", this);
        }
    }

    final synchronized void a(final Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d> pair, final Object obj) {
        com.tencent.mm.vending.h.d dVar = (com.tencent.mm.vending.h.d) pair.second;
        Runnable anonymousClass3 = new Runnable(this) {
            final /* synthetic */ e zCv;

            public final void run() {
                ((com.tencent.mm.vending.g.d.a) pair.first).aW(obj);
            }
        };
        if (dVar == null) {
            com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", this.zCd);
        }
        dVar.f(anonymousClass3);
    }

    private synchronized void b(final Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d> pair, final Object obj) {
        final RuntimeException runtimeException = new RuntimeException("object is not right: " + obj);
        new f((com.tencent.mm.vending.h.d) pair.second, null).a(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ e zCv;

            public final /* synthetic */ Object call(Object obj) {
                return czU();
            }

            private Void czU() {
                try {
                    ((com.tencent.mm.vending.g.d.b) pair.first).aB(obj);
                    return zBS;
                } catch (Throwable e) {
                    if (runtimeException.getCause() == null) {
                        runtimeException.initCause(e);
                    }
                    throw runtimeException;
                }
            }
        }, null, this.zCk);
    }

    private synchronized void a(com.tencent.mm.vending.g.d.a aVar, com.tencent.mm.vending.h.d dVar) {
        czS();
        if (this.zCo == null) {
            this.zCo = new LinkedList();
        }
        Pair pair = new Pair(aVar, dVar);
        if (this.zCr) {
            a(pair, this.zCu);
        } else {
            this.zCo.add(pair);
        }
    }

    private synchronized void a(com.tencent.mm.vending.g.d.b bVar, com.tencent.mm.vending.h.d dVar) {
        czS();
        cn(this.zCe);
        if (this.zCp == null) {
            this.zCp = new LinkedList();
        }
        Pair pair = new Pair(bVar, dVar);
        if (this.zCq) {
            b(pair, this.zCt);
        } else {
            this.zCp.add(pair);
        }
    }

    private synchronized d<_Var> czS() {
        this.zBY = true;
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.a aVar) {
        a(aVar, this.zCd);
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.b<_Var> bVar) {
        a((com.tencent.mm.vending.g.d.b) bVar, this.zCd);
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.h.d dVar, com.tencent.mm.vending.g.d.b<_Var> bVar) {
        a((com.tencent.mm.vending.g.d.b) bVar, dVar);
        return this;
    }

    final synchronized void nG(boolean z) {
        if (!(this.zBZ == d.Interrupted || this.zBZ == d.AllDone)) {
            if (z) {
                if (this.zCb.size() > 0) {
                    com.tencent.mm.vending.f.a.w("Vending.Pipeline", "Pipe is not finish and be interrupt! %s pipes did not run", Integer.valueOf(this.zCb.size()));
                }
            }
            this.zBZ = d.Interrupted;
            this.zCb.clear();
            this.zCe = null;
            if (this.zCm != null) {
                this.zCm.cancel();
            }
        }
    }

    final synchronized Object cm(Object obj) {
        if (this.zCa) {
            this.mRetryCount++;
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", this.zCh.gSf.toString(), Integer.valueOf(this.mRetryCount));
            ((LinkedList) this.zCb).add(0, this.zCh);
            this.zCa = false;
        } else {
            if (this.zCf) {
                this.zCe = this.zCg;
                this.zCg = null;
                this.zCf = false;
            } else {
                this.zCe = obj;
            }
            this.mRetryCount = 0;
        }
        return this.zCe;
    }

    final synchronized void cn(final Object obj) {
        if (this.zBZ == d.Resolved) {
            this.zBZ = d.Invoking;
            a aVar = (a) this.zCb.peek();
            if (aVar != null) {
                final com.tencent.mm.vending.c.a aVar2 = aVar.gSf;
                com.tencent.mm.vending.h.d dVar = aVar.ffh;
                long j = aVar.mInterval;
                final boolean z = aVar.zCD;
                if (this.zBZ == d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
                } else {
                    this.zCi = (a) this.zCb.poll();
                    this.zBL.b(dVar);
                    if (j < 0) {
                        this.zBL.a(aVar2, obj, z);
                    } else {
                        if (Looper.myLooper() == null) {
                            this.zCm = new com.tencent.mm.vending.h.c();
                        } else {
                            this.zCm = new h(Looper.myLooper(), Looper.myLooper().toString());
                        }
                        this.zCm.f(new Runnable(this) {
                            final /* synthetic */ e zCv;

                            public final void run() {
                                this.zCv.zBL.a(aVar2, obj, z);
                            }
                        }, j);
                    }
                }
            } else if (this.zBY) {
                this.zBZ = d.AllDone;
                this.zCq = true;
                this.zCt = obj;
                if (this.zCp != null) {
                    for (Pair b : this.zCp) {
                        b(b, this.zCt);
                    }
                }
            } else {
                this.zBZ = d.Resolved;
            }
        }
    }
}
