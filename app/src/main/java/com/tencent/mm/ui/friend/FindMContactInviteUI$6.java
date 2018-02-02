package com.tencent.mm.ui.friend;

import com.tencent.mm.R;
import com.tencent.mm.modelfriend.j.a;

class FindMContactInviteUI$6 implements a {
    final /* synthetic */ FindMContactInviteUI zcx;

    FindMContactInviteUI$6(FindMContactInviteUI findMContactInviteUI) {
        this.zcx = findMContactInviteUI;
    }

    public final void notifyDataSetChanged() {
        if (FindMContactInviteUI.d(this.zcx) == 2 || FindMContactInviteUI.d(this.zcx) != 1) {
            FindMContactInviteUI.e(this.zcx).setText(this.zcx.getString(R.l.ehN, new Object[]{Integer.valueOf(FindMContactInviteUI.b(this.zcx).getCount())}));
        } else {
            FindMContactInviteUI.e(this.zcx).setText(this.zcx.getString(R.l.ehO));
        }
        if (FindMContactInviteUI.b(this.zcx).NI()) {
            if (!(FindMContactInviteUI.d(this.zcx) == 1 || FindMContactInviteUI.e(this.zcx).getVisibility() != 0 || FindMContactInviteUI.f(this.zcx) == null)) {
                FindMContactInviteUI.e(this.zcx).setVisibility(8);
                FindMContactInviteUI.f(this.zcx).setVisibility(0);
            }
        } else if (!(FindMContactInviteUI.d(this.zcx) == 1 || FindMContactInviteUI.e(this.zcx).getVisibility() != 8 || FindMContactInviteUI.f(this.zcx) == null)) {
            FindMContactInviteUI.e(this.zcx).setVisibility(0);
            FindMContactInviteUI.f(this.zcx).setVisibility(8);
        }
        if (FindMContactInviteUI.b(this.zcx).NH() <= 0 || FindMContactInviteUI.d(this.zcx) == 1) {
            FindMContactInviteUI.g(this.zcx).setText(this.zcx.getResources().getQuantityString(R.j.dur, FindMContactInviteUI.b(this.zcx).getCount(), new Object[]{Integer.valueOf(FindMContactInviteUI.b(this.zcx).getCount())}));
            return;
        }
        FindMContactInviteUI.g(this.zcx).setText(this.zcx.getResources().getQuantityString(R.j.duq, FindMContactInviteUI.b(this.zcx).NH(), new Object[]{Integer.valueOf(FindMContactInviteUI.b(this.zcx).NH())}));
    }
}
