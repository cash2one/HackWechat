package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$h implements Runnable {
    volatile boolean otH;
    final /* synthetic */ a rmk;

    private a$h(a aVar) {
        this.rmk = aVar;
        this.otH = false;
    }

    public final void run() {
        if (a.c(this.rmk)) {
            x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
            return;
        }
        a.a(this.rmk, SightVideoJNI.openFile(a.a(this.rmk), 1 == a.d(this.rmk) ? 0 : 1, 1, false));
        if (a.e(this.rmk) < 0) {
            x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(a.e(this.rmk)), a.a(this.rmk)});
            this.rmk.bxx();
            if (a.b(this.rmk) != null) {
                a.b(this.rmk).xb(-1);
                return;
            }
            return;
        }
        if (((Boolean) AdLandingPagesProxy.getInstance().getCfg(344065, Boolean.valueOf(false))).booleanValue()) {
            if (a.f(this.rmk) == null) {
                a.a(this.rmk, new j(this.rmk, (byte) 0));
            }
            a.g(this.rmk).removeCallbacks(a.f(this.rmk));
            a.g(this.rmk).post(a.f(this.rmk));
        }
        int max = Math.max(1, SightVideoJNI.getVideoWidth(a.e(this.rmk)));
        int max2 = Math.max(1, SightVideoJNI.getVideoHeight(a.e(this.rmk)));
        if (a.d(this.rmk) == 0) {
            if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                x.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[]{Integer.valueOf(max), Integer.valueOf(max2)});
                return;
            }
            a.a(this.rmk, max, max2);
        }
        this.rmk.bsM();
        if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
            x.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[]{Integer.valueOf(max), Integer.valueOf(max2)});
            if (!bh.ov(a.a(this.rmk))) {
                a.bsP().put(a.a(this.rmk), Integer.valueOf(2));
            }
            a.a(this.rmk, 0);
            a.b(this.rmk, a.e(this.rmk));
            a.a(this.rmk, -1);
            a.a(this.rmk, "");
            a.b(this.rmk, "ERROR#PATH");
            a.a(this.rmk, null);
            this.otH = true;
            if (a.b(this.rmk) != null) {
                a.b(this.rmk).xb(-1);
                return;
            }
            return;
        }
        this.rmk.cg(max, max2);
        if (1 == a.d(this.rmk)) {
            a.a(this.rmk, new b(this.rmk, (byte) 0));
            a.a(this.rmk, null);
            if (!this.otH) {
                o.c(a.h(this.rmk), 0);
            }
        } else {
            a.a(this.rmk, new b(this.rmk, (byte) 0));
            a.a(this.rmk, new a$c(this.rmk));
            a.h(this.rmk).rml = a.i(this.rmk);
            a.i(this.rmk).rmn = a.h(this.rmk);
            if (!this.otH) {
                o.c(a.h(this.rmk), 0);
            }
        }
        if (this.otH) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.otH)});
        }
    }
}
