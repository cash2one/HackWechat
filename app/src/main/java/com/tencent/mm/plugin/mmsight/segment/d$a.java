package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class d$a {
    Lock mBP = new ReentrantLock();
    LinkedBlockingQueue<d> oxv = new LinkedBlockingQueue(4);
    private final int oxw = 4;
    private Callable<d> oxx;
    private volatile int size = 0;

    public d$a(Callable<d> callable) {
        this.oxx = callable;
    }

    public final d bbc() {
        d dVar = null;
        long Wq = bh.Wq();
        x.d("FetcherPool", "acquireFetcher");
        if (this.oxv == null) {
            x.d("FetcherPool", "acquireFetcher no pool directly return null");
        } else {
            this.mBP.lock();
            x.d("FetcherPool", "pool.size() %d, size %d, maxFetcherSize %d", new Object[]{Integer.valueOf(this.oxv.size()), Integer.valueOf(this.size), Integer.valueOf(this.oxw)});
            if (this.oxv == null) {
                this.mBP.unlock();
            } else {
                if (!this.oxv.isEmpty() || this.size >= this.oxw) {
                    x.d("FetcherPool", "waiting fetcher");
                    this.mBP.unlock();
                    dVar = (d) this.oxv.poll(5, TimeUnit.SECONDS);
                } else {
                    x.d("FetcherPool", "new fetcher");
                    this.size++;
                    this.mBP.unlock();
                    dVar = bbd();
                }
                x.d("FetcherPool", "time flee, acquireFetcher cost time %d", new Object[]{Long.valueOf(bh.bA(Wq))});
            }
        }
        return dVar;
    }

    private d bbd() {
        if (this.oxx == null) {
            throw new IllegalStateException("fetcher generator can not be null.");
        }
        try {
            d dVar = (d) this.oxx.call();
            x.d("FetcherPool", "time flee, construct fetcher instance cost %d", new Object[]{Long.valueOf(bh.bA(bh.Wq()))});
            return dVar;
        } catch (Throwable e) {
            x.printErrStackTrace("FetcherPool", e, " fetcher generater call error %s", new Object[]{e.getMessage()});
            throw e;
        }
    }

    public final void a(d dVar) {
        x.d("FetcherPool", "reuseFetcher");
        if (dVar == null) {
            x.e("FetcherPool", "Null object can not be reused.");
        } else if (this.oxv == null) {
            dVar.release();
        } else if (this.oxv.contains(dVar)) {
            throw new IllegalStateException("fetcher already in pool");
        } else {
            this.oxv.offer(dVar);
        }
    }
}
