package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;

class g$30 implements OnClickListener {
    final /* synthetic */ String tIG;
    final /* synthetic */ String tIH;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$30(g gVar, String str, String str2, i iVar) {
        this.tIj = gVar;
        this.tIG = str;
        this.tIH = str2;
        this.tIg = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("transaction_id", this.tIG);
        intent.putExtra("receiver_name", this.tIH);
        d.b(g.i(this.tIj), "remittance", ".ui.RemittanceResendMsgUI", intent);
        g.a(this.tIj, this.tIg, "doResendRemittanceMsg:ok", null);
    }
}
