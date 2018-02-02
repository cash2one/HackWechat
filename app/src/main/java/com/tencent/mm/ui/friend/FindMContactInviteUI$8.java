package com.tencent.mm.ui.friend;

import android.view.View;
import android.view.View.OnClickListener;

class FindMContactInviteUI$8 implements OnClickListener {
    final /* synthetic */ FindMContactInviteUI zcx;

    FindMContactInviteUI$8(FindMContactInviteUI findMContactInviteUI) {
        this.zcx = findMContactInviteUI;
    }

    public final void onClick(View view) {
        FindMContactInviteUI.e(this.zcx).setVisibility(0);
        FindMContactInviteUI.f(this.zcx).setVisibility(8);
        FindMContactInviteUI.b(this.zcx).bN(false);
        FindMContactInviteUI.b(this.zcx).notifyDataSetChanged();
    }
}
