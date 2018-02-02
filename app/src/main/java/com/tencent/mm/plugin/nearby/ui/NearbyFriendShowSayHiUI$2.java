package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class NearbyFriendShowSayHiUI$2 implements OnClickListener {
    final /* synthetic */ NearbyFriendShowSayHiUI oOy;

    NearbyFriendShowSayHiUI$2(NearbyFriendShowSayHiUI nearbyFriendShowSayHiUI) {
        this.oOy = nearbyFriendShowSayHiUI;
    }

    public final void onClick(View view) {
        this.oOy.startActivity(new Intent(this.oOy, NearbyFriendsUI.class));
    }
}
