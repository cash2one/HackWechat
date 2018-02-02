package com.tencent.mm.ui.friend;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class FindMContactInviteUI$3 implements OnClickListener {
    final /* synthetic */ FindMContactInviteUI zcx;

    FindMContactInviteUI$3(FindMContactInviteUI findMContactInviteUI) {
        this.zcx = findMContactInviteUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zcx.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        FindMContactInviteUI.n(this.zcx);
        this.zcx.finish();
    }
}
