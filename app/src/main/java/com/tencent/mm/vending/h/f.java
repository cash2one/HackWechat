package com.tencent.mm.vending.h;

public final class f {
    private volatile d zCc;
    volatile a zCn;

    public interface a {
        void co(Object obj);

        void czT();

        void interrupt();
    }

    public f(d dVar, a aVar) {
        b(dVar);
        this.zCn = aVar;
    }

    public final synchronized void b(d dVar) {
        c(dVar);
    }

    private synchronized void c(d dVar) {
        this.zCc = dVar;
    }

    private synchronized void a(final com.tencent.mm.vending.c.a aVar, final Object obj, long j, boolean z) {
        d aap;
        Runnable anonymousClass1;
        d dVar = this.zCc;
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            if (!"Vending.ANY".equals(eVar.wx())) {
                aap = g.aap(eVar.wx());
                if (aap == null) {
                    final RuntimeException runtimeException = new RuntimeException("object is not right: " + obj);
                    anonymousClass1 = new Runnable(this) {
                        final /* synthetic */ f zCR;

                        public final void run() {
                            if (this.zCR.zCn != null) {
                                this.zCR.zCn.czT();
                            }
                            try {
                                Object call = aVar.call(obj);
                                if (this.zCR.zCn != null) {
                                    this.zCR.zCn.co(call);
                                }
                            } catch (Throwable e) {
                                runtimeException.initCause(e);
                                throw runtimeException;
                            }
                        }
                    };
                    if (-1 < 0) {
                        aap.f(anonymousClass1, -1);
                    } else if (z || g.czY() != aap) {
                        aap.f(anonymousClass1);
                    } else {
                        anonymousClass1.run();
                    }
                } else if (this.zCn != null) {
                    this.zCn.interrupt();
                }
            }
        }
        aap = dVar;
        if (aap == null) {
            final RuntimeException runtimeException2 = new RuntimeException("object is not right: " + obj);
            anonymousClass1 = /* anonymous class already generated */;
            if (-1 < 0) {
                aap.f(anonymousClass1, -1);
            } else {
                if (z) {
                }
                aap.f(anonymousClass1);
            }
        } else if (this.zCn != null) {
            this.zCn.interrupt();
        }
    }

    public final void a(com.tencent.mm.vending.c.a aVar, Object obj, boolean z) {
        a(aVar, obj, -1, z);
    }
}
