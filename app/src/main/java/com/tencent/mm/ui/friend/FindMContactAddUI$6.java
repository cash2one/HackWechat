package com.tencent.mm.ui.friend;

import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.x;

class FindMContactAddUI$6 implements a {
    final /* synthetic */ FindMContactAddUI zcv;

    FindMContactAddUI$6(FindMContactAddUI findMContactAddUI) {
        this.zcv = findMContactAddUI;
    }

    public final boolean JC() {
        if (FindMContactAddUI.a(this.zcv) != null) {
            FindMContactAddUI.a(this.zcv).dismiss();
            FindMContactAddUI.b(this.zcv);
        }
        FindMContactAddUI.c(this.zcv).notifyDataSetChanged();
        return false;
    }

    public final boolean JB() {
        try {
            FindMContactAddUI.a(this.zcv, com.tencent.mm.pluginsdk.a.bV(this.zcv));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FindMContactAddUI", e, "", new Object[0]);
        }
        FindMContactAddUI.c(this.zcv).hvQ = FindMContactAddUI.d(this.zcv);
        FindMContactAddUI.c(this.zcv).e(af.OJ());
        return true;
    }

    public final String toString() {
        return super.toString() + "|listMFriendData";
    }
}
