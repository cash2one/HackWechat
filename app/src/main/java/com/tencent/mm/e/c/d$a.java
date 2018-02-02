package com.tencent.mm.e.c;

import com.tencent.mm.e.b.g.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

final class d$a implements Runnable {
    final /* synthetic */ d fmA;

    public final void run() {
        while (true) {
            boolean z;
            synchronized (this.fmA) {
                z = this.fmA.fmn;
            }
            x.d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + z + " queueLen: " + this.fmA.fmm.size());
            if (!z || !this.fmA.fmm.isEmpty()) {
                try {
                    a aVar = (a) this.fmA.fmm.poll(200, TimeUnit.MILLISECONDS);
                    if (aVar == null) {
                        x.e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.fmA.fmo);
                    } else {
                        this.fmA.a(aVar, 0, false);
                    }
                } catch (InterruptedException e) {
                    x.i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
                }
            } else {
                return;
            }
        }
    }
}
