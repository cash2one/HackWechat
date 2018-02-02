package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;

class InviteRemindDialog$2 implements OnClickListener {
    final /* synthetic */ InviteRemindDialog spJ;

    InviteRemindDialog$2(InviteRemindDialog inviteRemindDialog) {
        this.spJ = inviteRemindDialog;
    }

    public final void onClick(View view) {
        this.spJ.finish();
    }
}
