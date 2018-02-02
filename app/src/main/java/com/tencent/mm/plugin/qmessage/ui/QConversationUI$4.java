package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba.a;
import com.tencent.mm.z.c;

class QConversationUI$4 implements a {
    final /* synthetic */ String gIx;
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ QConversationUI pnT;

    QConversationUI$4(QConversationUI qConversationUI, String str, ProgressDialog progressDialog) {
        this.pnT = qConversationUI;
        this.gIx = str;
        this.lao = progressDialog;
    }

    public final boolean HB() {
        return QConversationUI.i(this.pnT);
    }

    public final void HA() {
        ar.Hg();
        c.Fd().WX(this.gIx);
        if (this.lao != null) {
            this.lao.dismiss();
        }
    }
}
