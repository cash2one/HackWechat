package com.tencent.mm.sdk.platformtools;

public abstract class bc<R> {
    long hhb;
    private final long hnk;
    private Object lock;
    private R result;
    private Runnable xfV;
    long xih;
    boolean xii;

    public abstract R run();

    public bc() {
        this(0, null);
    }

    public bc(long j, R r, boolean z) {
        this.lock = new Object();
        this.xii = false;
        this.xfV = new Runnable(this) {
            final /* synthetic */ bc xij;

            {
                this.xij = r1;
            }

            public final void run() {
                x.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + this.xij.xii);
                if (this.xij.xii) {
                    this.xij.run();
                } else {
                    this.xij.bX(this.xij.run());
                }
                this.xij.xih = bh.bA(this.xij.hhb);
            }
        };
        this.hnk = j;
        this.result = r;
        this.xii = true;
    }

    public bc(long j, R r) {
        this.lock = new Object();
        this.xii = false;
        this.xfV = /* anonymous class already generated */;
        this.hnk = j;
        this.result = r;
    }

    public final void bX(R r) {
        x.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
        this.result = r;
        synchronized (this.lock) {
            x.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
            this.lock.notify();
        }
    }

    public final R b(af afVar) {
        if (afVar == null) {
            x.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return run();
        }
        x.i("MicroMsg.SDK.SyncTask", "sync task exec...");
        if (Thread.currentThread().getId() == afVar.getLooper().getThread().getId()) {
            x.i("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        }
        this.hhb = bh.Wq();
        try {
            synchronized (this.lock) {
                x.i("MicroMsg.SDK.SyncTask", "sync task exec at synchronized");
                afVar.post(this.xfV);
                this.lock.wait(this.hnk);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.SyncTask", e, "", new Object[0]);
        }
        long bA = bh.bA(this.hhb);
        x.i("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", new Object[]{this.result, Long.valueOf(bA), Long.valueOf(this.xih), Long.valueOf(bA - this.xih)});
        return this.result;
    }
}
