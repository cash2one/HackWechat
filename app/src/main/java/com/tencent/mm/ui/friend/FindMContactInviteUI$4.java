package com.tencent.mm.ui.friend;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FindMContactInviteUI$4 implements OnClickListener {
    final /* synthetic */ FindMContactInviteUI zcx;

    FindMContactInviteUI$4(FindMContactInviteUI findMContactInviteUI) {
        this.zcx = findMContactInviteUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FindMContactInviteUI.n(this.zcx);
        this.zcx.finish();
    }
}
