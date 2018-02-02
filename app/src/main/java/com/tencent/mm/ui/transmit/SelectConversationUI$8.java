package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.base.i$a.a;
import com.tencent.mm.y.g;

class SelectConversationUI$8 implements a {
    final /* synthetic */ g.a jrh;
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$8(SelectConversationUI selectConversationUI, g.a aVar) {
        this.zpv = selectConversationUI;
        this.jrh = aVar;
    }

    public final void aJL() {
        Intent intent = new Intent();
        intent.putExtra("message_id", SelectConversationUI.i(this.zpv));
        intent.putExtra("record_xml", this.jrh.hbB);
        intent.putExtra("record_show_share", false);
        d.b(this.zpv.mController.xIM, "record", ".ui.RecordMsgDetailUI", intent);
    }
}
