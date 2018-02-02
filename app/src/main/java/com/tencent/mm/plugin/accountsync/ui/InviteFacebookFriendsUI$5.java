package com.tencent.mm.plugin.accountsync.ui;

import android.os.Bundle;
import com.tencent.mm.aa.a;

class InviteFacebookFriendsUI$5 extends a {
    final /* synthetic */ InviteFacebookFriendsUI ilq;

    InviteFacebookFriendsUI$5(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        this.ilq = inviteFacebookFriendsUI;
    }

    public final void k(Bundle bundle) {
        super.k(bundle);
    }

    public final void onError(int i, String str) {
        super.onError(i, str);
        if (i == 3) {
            InviteFacebookFriendsUI.c(this.ilq);
        }
    }
}
