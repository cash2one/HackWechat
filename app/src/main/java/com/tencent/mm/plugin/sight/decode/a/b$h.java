package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$h implements Runnable {
    volatile boolean otH;
    final /* synthetic */ b qtU;

    private b$h(b bVar) {
        this.qtU = bVar;
        this.otH = false;
    }

    public final void run() {
        if (b.c(this.qtU)) {
            x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
            return;
        }
        b.a(this.qtU, SightVideoJNI.openFile(b.a(this.qtU), 1 == b.d(this.qtU) ? 0 : 1, 1, false));
        if (b.e(this.qtU) < 0) {
            x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(b.e(this.qtU)), b.a(this.qtU)});
            this.qtU.C(null);
            if (b.b(this.qtU) != null) {
                b.b(this.qtU).d(this.qtU, -1);
                return;
            }
            return;
        }
        if (((Boolean) g.Dj().CU().get(344065, Boolean.valueOf(false))).booleanValue()) {
            if (b.f(this.qtU) == null) {
                b.a(this.qtU, new j(this.qtU, (byte) 0));
            }
            b.g(this.qtU).removeCallbacks(b.f(this.qtU));
            b.g(this.qtU).post(b.f(this.qtU));
        }
        int max = Math.max(1, SightVideoJNI.getVideoWidth(b.e(this.qtU)));
        int max2 = Math.max(1, SightVideoJNI.getVideoHeight(b.e(this.qtU)));
        if (b.d(this.qtU) == 0) {
            if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                x.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[]{Integer.valueOf(max), Integer.valueOf(max2)});
                return;
            }
            b.a(this.qtU, max, max2);
        }
        this.qtU.bsM();
        if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
            x.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[]{Integer.valueOf(max), Integer.valueOf(max2)});
            if (!bh.ov(b.a(this.qtU))) {
                b.bsP().put(b.a(this.qtU), Integer.valueOf(2));
            }
            b.a(this.qtU, 0);
            b.b(this.qtU, b.e(this.qtU));
            b.a(this.qtU, -1);
            b.a(this.qtU, "");
            b.b(this.qtU, "ERROR#PATH");
            b.a(this.qtU, null);
            this.otH = true;
            if (b.b(this.qtU) != null) {
                b.b(this.qtU).d(this.qtU, -1);
                return;
            }
            return;
        }
        this.qtU.cg(max, max2);
        if (1 == b.d(this.qtU)) {
            b.a(this.qtU, new b$b(this.qtU));
            b.a(this.qtU, null);
            if (!this.otH) {
                o.c(b.h(this.qtU), 0);
            }
        } else {
            b.a(this.qtU, new b$b(this.qtU));
            b.a(this.qtU, new b$c(this.qtU));
            b.h(this.qtU).qtZ = b.i(this.qtU);
            b.i(this.qtU).qud = b.h(this.qtU);
            if (!this.otH) {
                o.c(b.h(this.qtU), 0);
            }
        }
        if (this.otH) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.otH)});
        }
    }
}
