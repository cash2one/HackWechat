package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.rtmp.TXLiveConstants;

class NearbyFriendShowSayHiUI$3 implements OnClickListener {
    final /* synthetic */ NearbyFriendShowSayHiUI oOy;

    NearbyFriendShowSayHiUI$3(NearbyFriendShowSayHiUI nearbyFriendShowSayHiUI) {
        this.oOy = nearbyFriendShowSayHiUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.oOy, NearbySayHiListUI.class);
        intent.putExtra("k_say_hi_type", 2);
        intent.putExtra("show_clear_header", true);
        this.oOy.startActivityForResult(intent, TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION);
    }
}
