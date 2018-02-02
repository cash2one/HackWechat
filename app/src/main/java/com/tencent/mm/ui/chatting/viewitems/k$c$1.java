package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.k.c;
import com.tencent.mm.z.q;

class k$c$1 implements OnClickListener {
    final /* synthetic */ String tIG;
    final /* synthetic */ String tIH;
    final /* synthetic */ a yII;
    final /* synthetic */ c yKA;
    final /* synthetic */ int yKx;
    final /* synthetic */ int yKy;
    final /* synthetic */ String yKz;

    k$c$1(c cVar, String str, String str2, int i, int i2, String str3, a aVar) {
        this.yKA = cVar;
        this.tIG = str;
        this.tIH = str2;
        this.yKx = i;
        this.yKy = i2;
        this.yKz = str3;
        this.yII = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("transaction_id", this.tIG);
        intent.putExtra("receiver_name", this.tIH);
        intent.putExtra("resend_msg_from_flag", 2);
        intent.putExtra("invalid_time", this.yKx);
        intent.putExtra("total_fee", this.yKy);
        intent.putExtra("fee_type", this.yKz);
        if (q.Gf()) {
            d.b(this.yII.thisActivity(), "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", intent);
        } else {
            d.b(this.yII.thisActivity(), "remittance", ".ui.RemittanceResendMsgUI", intent);
        }
    }
}
