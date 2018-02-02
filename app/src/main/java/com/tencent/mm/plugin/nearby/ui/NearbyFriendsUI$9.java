package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.rtmp.TXLiveConstants;

class NearbyFriendsUI$9 implements OnClickListener {
    final /* synthetic */ NearbyFriendsUI oOS;

    NearbyFriendsUI$9(NearbyFriendsUI nearbyFriendsUI) {
        this.oOS = nearbyFriendsUI;
    }

    public final void onClick(View view) {
        NearbyFriendsUI.k(this.oOS).removeHeaderView(NearbyFriendsUI.m(this.oOS));
        NearbyFriendsUI.n(this.oOS);
        Intent intent = new Intent(this.oOS, NearbySayHiListUI.class);
        intent.putExtra("k_say_hi_type", 2);
        intent.putExtra("show_clear_header", true);
        this.oOS.startActivityForResult(intent, TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION);
    }
}
