package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.chatroom.d.d;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

class ChatroomInfoUI$21 implements OnClickListener {
    final /* synthetic */ ChatroomInfoUI lal;
    final /* synthetic */ d las;
    final /* synthetic */ List lau;
    final /* synthetic */ List lav;
    final /* synthetic */ List law;

    ChatroomInfoUI$21(ChatroomInfoUI chatroomInfoUI, d dVar, List list, List list2, List list3) {
        this.lal = chatroomInfoUI;
        this.las = dVar;
        this.lau = list;
        this.lav = list2;
        this.law = list3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ChatroomInfoUI.a(this.lal, this.las.chatroomName, this.lau);
        List arrayList = new ArrayList();
        arrayList.addAll(this.lav);
        arrayList.addAll(this.law);
        k kVar = new com.tencent.mm.plugin.chatroom.d.k(ChatroomInfoUI.b(this.lal), arrayList);
        ar.CG().a(kVar, 0);
        ChatroomInfoUI chatroomInfoUI = this.lal;
        Context context = this.lal;
        this.lal.getString(R.l.dGO);
        ChatroomInfoUI.b(chatroomInfoUI, h.a(context, this.lal.getString(R.l.eFy), true, new 1(this, kVar)));
    }
}
