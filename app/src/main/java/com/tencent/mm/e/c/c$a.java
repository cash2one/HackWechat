package com.tencent.mm.e.c;

import com.tencent.mm.e.b.g$a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

final class c$a implements Runnable {
    final /* synthetic */ c fmx;

    private c$a(c cVar) {
        this.fmx = cVar;
    }

    public final void run() {
        x.i("MicroMsg.SilkWriter", "Silk Thread start run");
        while (true) {
            boolean a;
            synchronized (this.fmx) {
                a = c.a(this.fmx);
            }
            x.d("MicroMsg.SilkWriter", "ThreadSilk in :" + a + " cnt :" + c.b(this.fmx).size());
            if (!a || !c.b(this.fmx).isEmpty()) {
                try {
                    g$a com_tencent_mm_e_b_g_a = (g$a) c.b(this.fmx).poll(200, TimeUnit.MILLISECONDS);
                    if (com_tencent_mm_e_b_g_a == null) {
                        x.i("MicroMsg.SilkWriter", "poll byte null file:" + c.c(this.fmx));
                    } else {
                        int size = c.b(this.fmx).size();
                        if (size > 10 || a) {
                            x.w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + size + " stop:" + a);
                            size = false;
                        } else if (size < 9) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        if (c.vH().count >= 10 && c.vH().fmj > 240) {
                            size = 0;
                        }
                        this.fmx.a(com_tencent_mm_e_b_g_a, size, false);
                    }
                } catch (InterruptedException e) {
                    x.i("MicroMsg.SilkWriter", "ThreadAmr poll null");
                }
            } else {
                return;
            }
        }
    }
}
