package com.tencent.mm.plugin.order.ui.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.order.ui.a.a.3;

class a$3$1 implements OnClickListener {
    final /* synthetic */ 3 pcK;

    a$3$1(3 3) {
        this.pcK = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("transaction_id", this.pcK.pag.fuI);
        intent.putExtra("receiver_name", this.pcK.pag.paO);
        intent.putExtra("resend_msg_from_flag", 1);
        d.b(this.pcK.val$context, "remittance", ".ui.RemittanceResendMsgUI", intent);
    }
}
