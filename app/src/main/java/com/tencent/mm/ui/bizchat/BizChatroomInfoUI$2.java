package com.tencent.mm.ui.bizchat;

import android.app.ProgressDialog;
import com.tencent.mm.ag.y;
import com.tencent.mm.z.ba.a;

class BizChatroomInfoUI$2 implements a {
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ BizChatroomInfoUI yoK;

    BizChatroomInfoUI$2(BizChatroomInfoUI bizChatroomInfoUI, ProgressDialog progressDialog) {
        this.yoK = bizChatroomInfoUI;
        this.lao = progressDialog;
    }

    public final boolean HB() {
        return BizChatroomInfoUI.f(this.yoK);
    }

    public final void HA() {
        if (this.lao != null) {
            y.Mi().aT(BizChatroomInfoUI.g(this.yoK));
            y.Mh().aT(BizChatroomInfoUI.g(this.yoK));
            this.lao.dismiss();
        }
    }
}
