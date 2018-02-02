package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$6 extends af {
    final /* synthetic */ BaseScanUI pUR;

    BaseScanUI$6(BaseScanUI baseScanUI) {
        this.pUR = baseScanUI;
    }

    public final void handleMessage(Message message) {
        synchronized (BaseScanUI.n(this.pUR)) {
            h f = BaseScanUI.f(this.pUR);
        }
        if (message == null) {
            x.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler msg is null");
        } else if (BaseScanUI.w(this.pUR)) {
            x.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler click too quick, msg.what=[%s]", new Object[]{Integer.valueOf(message.what)});
        } else {
            BaseScanUI.d(this.pUR, true);
            if (BaseScanUI.h(this.pUR) != null) {
                if (BaseScanUI.x(this.pUR) == message.what) {
                    BaseScanUI.d(this.pUR, false);
                    return;
                }
                BaseScanUI.h(this.pUR).onPause();
                if (BaseScanUI.h(this.pUR).boM() != null) {
                    BaseScanUI.h(this.pUR).boM().kL();
                }
                BaseScanUI.h(this.pUR).onDestroy();
                BaseScanUI.a(this.pUR, null);
            }
            if (!BaseScanUI.a(this.pUR) || BaseScanUI.b(this.pUR)) {
                BaseScanUI.b(this.pUR, false);
            } else {
                BaseScanUI.b(this.pUR, true);
            }
            if (BaseScanUI.y(this.pUR) && message.what != 1) {
                Toast.makeText(this.pUR, R.l.eHr, 0).show();
                BaseScanUI.z(this.pUR).vI(1);
                BaseScanUI.d(this.pUR, false);
            } else if (this.pUR.isFinishing()) {
                x.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler is invoke after ui was destroyed, msg.what=[%s]", new Object[]{Integer.valueOf(message.what)});
            } else {
                if (f != null) {
                    f.vL(message.what);
                }
                BaseScanUI.a(this.pUR, message.what);
                switch (message.what) {
                    case 1:
                        if (!BaseScanUI.A(this.pUR)) {
                            this.pUR.setMMTitle(R.l.eHA);
                            BaseScanUI.a(this.pUR, new p(this.pUR, BaseScanUI.B(this.pUR), BaseScanUI.C(this.pUR), 0));
                            break;
                        }
                        this.pUR.setMMTitle(R.l.eHz);
                        BaseScanUI.a(this.pUR, new p(this.pUR, BaseScanUI.B(this.pUR), BaseScanUI.C(this.pUR), 1));
                        break;
                    case 2:
                        this.pUR.setMMTitle(p.dV(p.qbg, this.pUR.getString(R.l.eHI)));
                        BaseScanUI.a(this.pUR, new k(this.pUR, BaseScanUI.B(this.pUR)));
                        break;
                    case 3:
                        this.pUR.setMMTitle(R.l.eHx);
                        BaseScanUI.a(this.pUR, new o(this.pUR, BaseScanUI.B(this.pUR)));
                        break;
                    case 4:
                        this.pUR.setMMTitle(R.l.eHA);
                        BaseScanUI.a(this.pUR, new p(this.pUR, BaseScanUI.B(this.pUR), BaseScanUI.C(this.pUR), 2));
                        break;
                    case 5:
                        this.pUR.setMMTitle(R.l.eHB);
                        BaseScanUI.a(this.pUR, new q(this.pUR, BaseScanUI.B(this.pUR)));
                        boolean a = a.a(this.pUR, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
                        x.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation[%b], stack[%s]", new Object[]{Boolean.valueOf(a), bh.cgy()});
                        break;
                    case 8:
                        this.pUR.setMMTitle(R.l.eHz);
                        BaseScanUI.a(this.pUR, new p(this.pUR, BaseScanUI.B(this.pUR), BaseScanUI.C(this.pUR), 1));
                        break;
                }
                if (f != null && f.isOpen() && f.mgX) {
                    f.bpH();
                    f.vN(1);
                }
                l.pST.reset();
                BaseScanUI.q(this.pUR);
                BaseScanUI.d(this.pUR, false);
            }
        }
    }
}
