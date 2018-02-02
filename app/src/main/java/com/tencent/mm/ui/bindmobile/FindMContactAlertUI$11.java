package com.tencent.mm.ui.bindmobile;

import com.tencent.mm.modelfriend.y;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class FindMContactAlertUI$11 implements a {
    final /* synthetic */ FindMContactAlertUI ymg;

    FindMContactAlertUI$11(FindMContactAlertUI findMContactAlertUI) {
        this.ymg = findMContactAlertUI;
    }

    public final boolean JC() {
        if (FindMContactAlertUI.k(this.ymg) == null || FindMContactAlertUI.k(this.ymg).size() == 0) {
            if (FindMContactAlertUI.f(this.ymg) != null) {
                FindMContactAlertUI.f(this.ymg).dismiss();
                FindMContactAlertUI.g(this.ymg);
            }
            FindMContactAlertUI.d(this.ymg);
        } else {
            FindMContactAlertUI.a(this.ymg, new y(FindMContactAlertUI.a(this.ymg), FindMContactAlertUI.k(this.ymg)));
            ar.CG().a(FindMContactAlertUI.l(this.ymg), 0);
        }
        return false;
    }

    public final boolean JB() {
        try {
            FindMContactAlertUI.a(this.ymg, com.tencent.mm.pluginsdk.a.bV(this.ymg));
            x.d("MicroMsg.FindMContactAlertUI", "tigerreg mobileList size " + (FindMContactAlertUI.k(this.ymg) == null ? 0 : FindMContactAlertUI.k(this.ymg).size()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FindMContactAlertUI", e, "", new Object[0]);
        }
        return true;
    }

    public final String toString() {
        return super.toString() + "|doUpload";
    }
}
