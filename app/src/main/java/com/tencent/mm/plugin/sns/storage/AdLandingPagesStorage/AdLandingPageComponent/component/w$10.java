package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class w$10 implements a {
    final /* synthetic */ w rls;

    w$10(w wVar) {
        this.rls = wVar;
    }

    public final boolean a(PString pString) {
        String str = "adId";
        String str2 = w.l(this.rls).rgB;
        String ej = d.ej(str, str2);
        if (FileOp.bO(ej)) {
            pString.value = ej;
            w.m(this.rls);
            return true;
        }
        d.a(str, str2, false, 62, new 1(this));
        return false;
    }

    public final void vh() {
        w.n(this.rls);
        w.o(this.rls);
    }

    public final void onStart(int i) {
        boolean z = false;
        w.p(this.rls);
        w.b(this.rls, i);
        if (this.rls.rkO.qur != i) {
            this.rls.rkO.wl(w.q(this.rls));
        }
        this.rls.rkO.setVisibility(4);
        this.rls.rlb.setVisibility(0);
        if (this.rls.rkM != null) {
            ab abVar = this.rls.rkM;
            if (this.rls.rkO.getVisibility() == 0) {
                z = true;
            }
            abVar.iD(z);
        }
        this.rls.bxu();
    }

    public final void wZ(final int i) {
        ag.y(new Runnable(this) {
            final /* synthetic */ w$10 rlu;

            public final void run() {
                x.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + i + " video time " + w.q(this.rlu.rls));
                if (this.rlu.rls.rkO.qur != w.q(this.rlu.rls)) {
                    this.rlu.rls.rkO.wl(w.q(this.rlu.rls));
                }
                this.rlu.rls.rkO.seek(i);
                this.rlu.rls.rkO.db(w.a(this.rlu.rls).isPlaying());
                if (w.a(this.rlu.rls).isPlaying()) {
                    w.p(this.rlu.rls);
                }
            }
        });
    }
}
