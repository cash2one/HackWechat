package com.tencent.mm.ui.bindmobile;

import com.tencent.mm.modelfriend.y;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class FindMContactIntroUI$11 implements a {
    final /* synthetic */ FindMContactIntroUI ymj;

    FindMContactIntroUI$11(FindMContactIntroUI findMContactIntroUI) {
        this.ymj = findMContactIntroUI;
    }

    public final boolean JC() {
        if (FindMContactIntroUI.k(this.ymj) == null || FindMContactIntroUI.k(this.ymj).size() == 0) {
            if (FindMContactIntroUI.g(this.ymj) != null) {
                FindMContactIntroUI.g(this.ymj).dismiss();
                FindMContactIntroUI.h(this.ymj);
            }
            FindMContactIntroUI.b(this.ymj);
        } else {
            FindMContactIntroUI.a(this.ymj, new y(FindMContactIntroUI.c(this.ymj), FindMContactIntroUI.k(this.ymj)));
            ar.CG().a(FindMContactIntroUI.l(this.ymj), 0);
        }
        return false;
    }

    public final boolean JB() {
        try {
            FindMContactIntroUI.a(this.ymj, com.tencent.mm.pluginsdk.a.bV(this.ymj));
            x.d("MicroMsg.FindMContactIntroUI", "tigerreg mobileList size " + (FindMContactIntroUI.k(this.ymj) == null ? 0 : FindMContactIntroUI.k(this.ymj).size()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FindMContactIntroUI", e, "", new Object[0]);
        }
        return true;
    }

    public final String toString() {
        return super.toString() + "|doUpload";
    }
}
