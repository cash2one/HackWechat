package com.tencent.mm.plugin.accountsync.ui;

import com.tencent.mm.plugin.accountsync.ui.InviteFacebookFriendsUI.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.tools.p.b;

class InviteFacebookFriendsUI$1 implements b {
    final /* synthetic */ InviteFacebookFriendsUI ilq;

    InviteFacebookFriendsUI$1(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        this.ilq = inviteFacebookFriendsUI;
    }

    public final boolean oK(String str) {
        return false;
    }

    public final void oL(String str) {
        InviteFacebookFriendsUI.a(this.ilq, bh.ot(str));
        InviteFacebookFriendsUI inviteFacebookFriendsUI = this.ilq;
        if (inviteFacebookFriendsUI.ill != null) {
            a aVar = inviteFacebookFriendsUI.ill;
            aVar.ilx = bh.ot(inviteFacebookFriendsUI.ilo.trim());
            aVar.aUn();
            aVar.Xy();
        }
    }

    public final void Xr() {
    }

    public final void Xs() {
    }

    public final void Xt() {
    }

    public final void Xu() {
    }
}
