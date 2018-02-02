package com.tencent.mm.ui.bindmobile;

import com.tencent.mm.modelfriend.y;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class FindMContactLearmMoreUI$5 implements a {
    final /* synthetic */ FindMContactLearmMoreUI ymn;

    FindMContactLearmMoreUI$5(FindMContactLearmMoreUI findMContactLearmMoreUI) {
        this.ymn = findMContactLearmMoreUI;
    }

    public final boolean JC() {
        if (FindMContactLearmMoreUI.j(this.ymn) == null || FindMContactLearmMoreUI.j(this.ymn).size() == 0) {
            if (FindMContactLearmMoreUI.c(this.ymn) != null) {
                FindMContactLearmMoreUI.c(this.ymn).dismiss();
                FindMContactLearmMoreUI.d(this.ymn);
            }
            FindMContactLearmMoreUI.b(this.ymn);
        } else {
            FindMContactLearmMoreUI.a(this.ymn, new y(FindMContactLearmMoreUI.h(this.ymn), FindMContactLearmMoreUI.j(this.ymn)));
            ar.CG().a(FindMContactLearmMoreUI.k(this.ymn), 0);
        }
        return false;
    }

    public final boolean JB() {
        try {
            FindMContactLearmMoreUI.a(this.ymn, com.tencent.mm.pluginsdk.a.bV(this.ymn));
            x.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg mobileList size " + (FindMContactLearmMoreUI.j(this.ymn) == null ? 0 : FindMContactLearmMoreUI.j(this.ymn).size()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", e, "", new Object[0]);
        }
        return true;
    }

    public final String toString() {
        return super.toString() + "|doUpload";
    }
}
