package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI;
import com.tencent.mm.z.ba.a;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$4 implements a {
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ AppBrandServiceConversationFmUI yVG;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$4(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI, ProgressDialog progressDialog) {
        this.yVG = appBrandServiceConversationFmUI;
        this.lao = progressDialog;
    }

    public final boolean HB() {
        return AppBrandServiceConversationFmUI.access$900(this.yVG);
    }

    public final void HA() {
        if (this.lao != null) {
            this.lao.dismiss();
        }
    }
}
