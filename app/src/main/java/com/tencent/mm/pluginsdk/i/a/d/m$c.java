package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.pluginsdk.i.a.d.f.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

final class m$c extends PriorityBlockingQueue<Runnable> {
    public final /* synthetic */ boolean offer(Object obj) {
        Runnable runnable = (Runnable) obj;
        boolean offer = super.offer(runnable);
        x.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "offer() | tid = %d | " + H(runnable), new Object[]{Long.valueOf(Thread.currentThread().getId())});
        return offer;
    }

    public final /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
        Runnable runnable = (Runnable) super.poll(j, timeUnit);
        if (runnable != null) {
            x.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "poll(long, TimeUnit) | tid = %d | " + H(runnable), new Object[]{Long.valueOf(Thread.currentThread().getId())});
        }
        return runnable;
    }

    public m$c() {
        super(11, new 1());
    }

    private static String H(Runnable runnable) {
        if (!(runnable instanceof c)) {
            return String.format("unknown runnable = %s", new Object[]{runnable});
        } else if (((c) runnable).vhC instanceof k) {
            return String.format("priority = %d, urlKey = %s", new Object[]{Integer.valueOf(((k) ((c) runnable).vhC).priority), ((c) runnable).vhC.bZj()});
        } else {
            return String.format("unknown request = %s", new Object[]{((c) runnable).vhC});
        }
    }
}
