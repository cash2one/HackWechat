package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.ui.base.i.a.a;

class SelectConversationUI$13 implements a {
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$13(SelectConversationUI selectConversationUI) {
        this.zpv = selectConversationUI;
    }

    public final void aJL() {
        Intent intent = new Intent();
        intent.setClassName(this.zpv.mController.xIM, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        intent.putExtra("app_msg_id", SelectConversationUI.i(this.zpv));
        intent.putExtra("app_show_share", false);
        this.zpv.startActivity(intent);
    }
}
