package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class InviteFriendsBy3rdUI$6 implements OnClickListener {
    final /* synthetic */ InviteFriendsBy3rdUI rYL;

    InviteFriendsBy3rdUI$6(InviteFriendsBy3rdUI inviteFriendsBy3rdUI) {
        this.rYL = inviteFriendsBy3rdUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        InviteFriendsBy3rdUI inviteFriendsBy3rdUI = this.rYL;
        Context context = this.rYL.mController.xIM;
        this.rYL.mController.xIM.getString(R.l.dGO);
        InviteFriendsBy3rdUI.a(inviteFriendsBy3rdUI, h.a(context, this.rYL.mController.xIM.getString(R.l.eRz), true, new 1(this)));
        InviteFriendsBy3rdUI.a(this.rYL).a(this.rYL, this.rYL.mController.xIM);
    }
}
