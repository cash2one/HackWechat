package com.tencent.mm.ui.friend;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class FindMContactInviteUI$12 implements OnClickListener {
    final /* synthetic */ FindMContactInviteUI zcx;

    FindMContactInviteUI$12(FindMContactInviteUI findMContactInviteUI) {
        this.zcx = findMContactInviteUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (FindMContactInviteUI.j(this.zcx) == 1) {
            b.oI(ar.CB() + "," + getClass().getName() + ",R300_500_QQ," + ar.fH("R300_500_QQ") + ",3");
        } else {
            b.oI(ar.CB() + "," + getClass().getName() + ",R300_500_phone," + ar.fH("R300_500_phone") + ",3");
        }
        ar.CG().a(432, FindMContactInviteUI.a(this.zcx, new 1(this)));
        FindMContactInviteUI findMContactInviteUI = this.zcx;
        Context context = this.zcx.mController.xIM;
        this.zcx.getString(R.l.dGO);
        FindMContactInviteUI.a(findMContactInviteUI, h.a(context, this.zcx.getString(R.l.ehQ), true, new 2(this)));
        FindMContactInviteUI.b(this.zcx).kW(FindMContactInviteUI.m(this.zcx));
    }
}
