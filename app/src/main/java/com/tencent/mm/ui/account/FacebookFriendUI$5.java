package com.tencent.mm.ui.account;

import android.widget.TextView;
import com.tencent.mm.ui.o$a;
import com.tencent.mm.z.q;

class FacebookFriendUI$5 implements o$a {
    final /* synthetic */ TextView ilr;
    final /* synthetic */ FacebookFriendUI xNZ;

    FacebookFriendUI$5(FacebookFriendUI facebookFriendUI, TextView textView) {
        this.xNZ = facebookFriendUI;
        this.ilr = textView;
    }

    public final void Xv() {
        if (q.Gt() && FacebookFriendUI.a(this.xNZ)) {
            if (FacebookFriendUI.b(this.xNZ).getCount() == 0) {
                this.ilr.setVisibility(0);
            } else {
                this.ilr.setVisibility(8);
            }
        }
        FacebookFriendUI.c(this.xNZ);
    }

    public final void Xw() {
    }
}
