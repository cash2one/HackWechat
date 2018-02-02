package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class FacebookFriendUI$4 implements OnClickListener {
    final /* synthetic */ FacebookFriendUI xNZ;

    FacebookFriendUI$4(FacebookFriendUI facebookFriendUI) {
        this.xNZ = facebookFriendUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.xNZ.mController.xIM, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        this.xNZ.mController.xIM.startActivity(intent);
        this.xNZ.finish();
    }
}
