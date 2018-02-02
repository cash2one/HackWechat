package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.i.a.a;

class SelectConversationUI$2 implements a {
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$2(SelectConversationUI selectConversationUI) {
        this.zpv = selectConversationUI;
    }

    public final void aJL() {
        Intent intent = new Intent(this.zpv.mController.xIM, RetransmitPreviewUI.class);
        intent.putExtra("Retr_Msg_content", SelectConversationUI.h(this.zpv));
        this.zpv.startActivity(intent);
        b.fF(this.zpv.mController.xIM);
    }
}
