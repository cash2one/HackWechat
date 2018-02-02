package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;

class InviteFriendsBy3rdUI$4 implements OnClickListener {
    final /* synthetic */ InviteFriendsBy3rdUI rYL;

    InviteFriendsBy3rdUI$4(InviteFriendsBy3rdUI inviteFriendsBy3rdUI) {
        this.rYL = inviteFriendsBy3rdUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.a(this.rYL.mController.xIM, ".ui.account.FacebookAuthUI", new Intent());
    }
}
