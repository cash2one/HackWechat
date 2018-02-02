package com.tencent.mm.plugin.accountsync.ui;

import android.widget.TextView;
import com.tencent.mm.ui.o$a;
import com.tencent.mm.z.q;

class InviteFacebookFriendsUI$3 implements o$a {
    final /* synthetic */ InviteFacebookFriendsUI ilq;
    final /* synthetic */ TextView ilr;

    InviteFacebookFriendsUI$3(InviteFacebookFriendsUI inviteFacebookFriendsUI, TextView textView) {
        this.ilq = inviteFacebookFriendsUI;
        this.ilr = textView;
    }

    public final void Xv() {
        if (!q.Gt()) {
            return;
        }
        if (InviteFacebookFriendsUI.a(this.ilq).getCount() == 0) {
            this.ilr.setVisibility(0);
        } else {
            this.ilr.setVisibility(8);
        }
    }

    public final void Xw() {
    }
}
