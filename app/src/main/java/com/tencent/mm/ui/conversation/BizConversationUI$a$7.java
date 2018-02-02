package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.z.ba.a;

class BizConversationUI$a$7 implements a {
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ BizConversationUI.a yWk;

    BizConversationUI$a$7(BizConversationUI.a aVar, ProgressDialog progressDialog) {
        this.yWk = aVar;
        this.lao = progressDialog;
    }

    public final boolean HB() {
        return BizConversationUI.a.l(this.yWk);
    }

    public final void HA() {
        if (this.lao != null) {
            this.lao.dismiss();
        }
    }
}
