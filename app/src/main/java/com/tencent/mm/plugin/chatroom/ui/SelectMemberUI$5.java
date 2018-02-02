package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.d.n;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class SelectMemberUI$5 implements OnClickListener {
    final /* synthetic */ String gIT;
    final /* synthetic */ SelectMemberUI ldP;

    SelectMemberUI$5(SelectMemberUI selectMemberUI, String str) {
        this.ldP = selectMemberUI;
        this.gIT = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.CG().a(new n(SelectMemberUI.e(this.ldP), this.gIT), 0);
        SelectMemberUI selectMemberUI = this.ldP;
        Context context = this.ldP;
        this.ldP.getString(R.l.dGO);
        SelectMemberUI.a(selectMemberUI, h.a(context, this.ldP.getString(R.l.eGk), false, null));
    }
}
