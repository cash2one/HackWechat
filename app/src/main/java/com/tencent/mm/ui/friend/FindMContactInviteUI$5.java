package com.tencent.mm.ui.friend;

import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.x;

class FindMContactInviteUI$5 implements a {
    final /* synthetic */ FindMContactInviteUI zcx;

    FindMContactInviteUI$5(FindMContactInviteUI findMContactInviteUI) {
        this.zcx = findMContactInviteUI;
    }

    public final boolean JC() {
        if (FindMContactInviteUI.a(this.zcx) != null) {
            FindMContactInviteUI.a(this.zcx).dismiss();
            FindMContactInviteUI.a(this.zcx, null);
        }
        FindMContactInviteUI.b(this.zcx).notifyDataSetChanged();
        return false;
    }

    public final boolean JB() {
        try {
            FindMContactInviteUI.a(this.zcx, com.tencent.mm.pluginsdk.a.bV(this.zcx));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FindMContactInviteUI", e, "", new Object[0]);
        }
        FindMContactInviteUI.b(this.zcx).hvQ = FindMContactInviteUI.c(this.zcx);
        FindMContactInviteUI.b(this.zcx).e(af.OJ());
        return true;
    }

    public final String toString() {
        return super.toString() + "|listMFriendData";
    }
}
