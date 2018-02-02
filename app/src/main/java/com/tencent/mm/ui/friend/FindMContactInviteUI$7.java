package com.tencent.mm.ui.friend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.z.ar;

class FindMContactInviteUI$7 implements OnClickListener {
    final /* synthetic */ FindMContactInviteUI zcx;

    FindMContactInviteUI$7(FindMContactInviteUI findMContactInviteUI) {
        this.zcx = findMContactInviteUI;
    }

    public final void onClick(View view) {
        b.oI(ar.CB() + "," + this.zcx.getClass().getName() + ",R300_400_AddAllButton," + ar.fH("R300_300_AddAllButton") + ",3");
        if (FindMContactInviteUI.d(this.zcx) == 2) {
            FindMContactInviteUI.b(this.zcx).bN(true);
            FindMContactInviteUI.b(this.zcx).notifyDataSetChanged();
            FindMContactInviteUI.e(this.zcx).setVisibility(8);
            if (FindMContactInviteUI.f(this.zcx) != null) {
                FindMContactInviteUI.f(this.zcx).setVisibility(0);
            }
        } else if (FindMContactInviteUI.d(this.zcx) == 1) {
            FindMContactInviteUI.b(this.zcx).bN(true);
            FindMContactInviteUI.b(this.zcx).notifyDataSetChanged();
            FindMContactInviteUI.h(this.zcx);
        } else {
            FindMContactInviteUI.b(this.zcx).bN(true);
            FindMContactInviteUI.b(this.zcx).notifyDataSetChanged();
            FindMContactInviteUI.e(this.zcx).setVisibility(8);
            if (FindMContactInviteUI.f(this.zcx) != null) {
                FindMContactInviteUI.f(this.zcx).setVisibility(0);
            }
        }
    }
}
