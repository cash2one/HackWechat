package com.tencent.mm.plugin.scanner.ui;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.z.ar;

class BaseScanUI$1 extends a {
    final /* synthetic */ BaseScanUI pUR;

    BaseScanUI$1(BaseScanUI baseScanUI) {
        this.pUR = baseScanUI;
    }

    public final void eq(final int i) {
        if (BaseScanUI.a(this.pUR)) {
            new af(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ BaseScanUI$1 pUT;

                public final void run() {
                    if (ar.CG().Km() == 6 || ar.CG().Km() == 4) {
                        if (!BaseScanUI.b(this.pUT.pUR)) {
                            if (!(BaseScanUI.c(this.pUT.pUR) == null || BaseScanUI.d(this.pUT.pUR) == null)) {
                                BaseScanUI.c(this.pUT.pUR).setVisibility(8);
                                BaseScanUI.d(this.pUT.pUR).setVisibility(8);
                            }
                            BaseScanUI.a(this.pUT.pUR, true);
                            BaseScanUI.b(this.pUT.pUR, false);
                            BaseScanUI.e(this.pUT.pUR);
                        } else {
                            return;
                        }
                    } else if (BaseScanUI.b(this.pUT.pUR)) {
                        if (!(BaseScanUI.c(this.pUT.pUR) == null || BaseScanUI.d(this.pUT.pUR) == null)) {
                            BaseScanUI.c(this.pUT.pUR).setText(R.l.eHS);
                            BaseScanUI.d(this.pUT.pUR).setVisibility(0);
                            BaseScanUI.c(this.pUT.pUR).setVisibility(0);
                        }
                        if (BaseScanUI.f(this.pUT.pUR) != null && BaseScanUI.f(this.pUT.pUR).osh) {
                            BaseScanUI.f(this.pUT.pUR).bad();
                        }
                        if (BaseScanUI.g(this.pUT.pUR) != null) {
                            BaseScanUI.g(this.pUT.pUR).bpt();
                            BaseScanUI.g(this.pUT.pUR).hide();
                        }
                        BaseScanUI.a(this.pUT.pUR, false);
                        BaseScanUI.b(this.pUT.pUR, true);
                        this.pUT.pUR.boT();
                    } else {
                        return;
                    }
                    if (BaseScanUI.h(this.pUT.pUR) != null) {
                        BaseScanUI.h(this.pUT.pUR).boL();
                    }
                }
            });
        }
    }
}
