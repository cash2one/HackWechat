package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class FacebookFriendUI$12 implements OnClickListener {
    final /* synthetic */ FacebookFriendUI xNZ;

    FacebookFriendUI$12(FacebookFriendUI facebookFriendUI) {
        this.xNZ = facebookFriendUI;
    }

    public final void onClick(View view) {
        this.xNZ.startActivity(new Intent(this.xNZ, FacebookAuthUI.class));
    }
}
