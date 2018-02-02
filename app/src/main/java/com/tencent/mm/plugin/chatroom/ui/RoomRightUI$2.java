package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.chatroom.d.j;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class RoomRightUI$2 implements OnClickListener {
    final /* synthetic */ RoomRightUI lcb;
    final /* synthetic */ String lcc;

    RoomRightUI$2(RoomRightUI roomRightUI, String str) {
        this.lcb = roomRightUI;
        this.lcc = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        k jVar = new j(this.lcc);
        RoomRightUI roomRightUI = this.lcb;
        Context context = this.lcb;
        this.lcb.getString(R.l.dGO);
        RoomRightUI.a(roomRightUI, h.a(context, "", true, new 1(this, jVar)));
        ar.CG().a(jVar, 0);
    }
}
