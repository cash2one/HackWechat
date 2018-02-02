package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.d.c;

class d$c$1 implements OnClickListener {
    final /* synthetic */ String tIH;
    final /* synthetic */ String val$url;
    final /* synthetic */ a yII;
    final /* synthetic */ String yJP;
    final /* synthetic */ String yJQ;
    final /* synthetic */ String yJR;
    final /* synthetic */ String yJS;
    final /* synthetic */ String yJT;
    final /* synthetic */ String yJU;
    final /* synthetic */ c yJV;

    d$c$1(c cVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, a aVar) {
        this.yJV = cVar;
        this.tIH = str;
        this.yJP = str2;
        this.yJQ = str3;
        this.yJR = str4;
        this.yJS = str5;
        this.val$url = str6;
        this.yJT = str7;
        this.yJU = str8;
        this.yII = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_scene", 1);
        intent.putExtra("key_receiver", this.tIH);
        intent.putExtra("key_receivertitle", this.yJP);
        intent.putExtra("key_sendertitle", this.yJQ);
        intent.putExtra("key_sender_des", this.yJR);
        intent.putExtra("key_receiver_des", this.yJS);
        intent.putExtra("key_url", this.val$url);
        intent.putExtra("key_templateid", this.yJT);
        intent.putExtra("key_sceneid", this.yJU);
        d.b(this.yII.thisActivity(), "wallet_index", ".ui.WalletSendC2CMsgUI", intent);
    }
}
