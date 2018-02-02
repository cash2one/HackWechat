package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class y$9 implements a {
    final /* synthetic */ y rlv;

    y$9(y yVar) {
        this.rlv = yVar;
    }

    public final boolean a(PString pString) {
        String str = "adId";
        String str2 = y.a(this.rlv).rgD;
        String ej = d.ej(str, str2);
        if (FileOp.bO(ej)) {
            pString.value = ej;
            this.rlv.rlo = true;
            return true;
        }
        d.a(str, str2, false, 62, new 1(this));
        return false;
    }

    public final void vh() {
        boolean z = false;
        y yVar = this.rlv;
        yVar.rkX++;
        this.rlv.rkO.setVisibility(0);
        this.rlv.rlb.setVisibility(0);
        this.rlv.jWc.setVisibility(0);
        if (this.rlv.rkM != null) {
            ab abVar = this.rlv.rkM;
            if (this.rlv.rkO.getVisibility() == 0) {
                z = true;
            }
            abVar.iD(z);
        }
        this.rlv.hae.post(new Runnable(this) {
            final /* synthetic */ y$9 rlx;

            {
                this.rlx = r1;
            }

            public final void run() {
                this.rlx.rlv.rkN.F(0, false);
                this.rlx.rlv.rkO.db(false);
                this.rlx.rlv.rkO.seek(0);
            }
        });
        if (this.rlv.oKL != 0) {
            this.rlv.rkV = (int) (((long) this.rlv.rkV) + (System.currentTimeMillis() - this.rlv.oKL));
            this.rlv.oKL = 0;
        }
        this.rlv.rlg = 5;
    }

    public final void onStart(int i) {
        boolean z = false;
        this.rlv.rkT = true;
        this.rlv.rkQ = i;
        if (this.rlv.rkO.qur != i) {
            this.rlv.rkO.wl(this.rlv.rkQ);
        }
        this.rlv.rkO.setVisibility(0);
        this.rlv.rlb.setVisibility(0);
        if (this.rlv.rkM != null) {
            ab abVar = this.rlv.rkM;
            if (this.rlv.rkO.getVisibility() == 0) {
                z = true;
            }
            abVar.iD(z);
        }
        y yVar = this.rlv;
        if (yVar.rkN != null && yVar.rkO != null && Math.abs(yVar.rkN.getCurrentPosition() - yVar.rkO.mPosition) > 1) {
            yVar.rkN.F(yVar.rkO.mPosition, true);
        }
    }

    public final void wZ(final int i) {
        ag.y(new Runnable(this) {
            final /* synthetic */ y$9 rlx;

            public final void run() {
                x.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "play time " + i + " video time " + this.rlx.rlv.rkQ);
                if (this.rlx.rlv.rkO.qur != this.rlx.rlv.rkQ) {
                    this.rlx.rlv.rkO.wl(this.rlx.rlv.rkQ);
                }
                this.rlx.rlv.rkO.seek(i);
                this.rlx.rlv.rkO.db(this.rlx.rlv.rkN.isPlaying());
                if (this.rlx.rlv.rkN.isPlaying()) {
                    this.rlx.rlv.rkT = true;
                }
            }
        });
    }
}
