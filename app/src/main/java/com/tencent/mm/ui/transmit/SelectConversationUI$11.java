package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.i$a$a;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.y.g.a;

class SelectConversationUI$11 implements i$a$a {
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$11(SelectConversationUI selectConversationUI) {
        this.zpv = selectConversationUI;
    }

    public final void aJL() {
        mt fL = j.fL(this.zpv.mController.xIM);
        a fT = a.fT(bh.VH(h.a(fL.fEF.fEN.title, fL.fEF.fEN.desc, fL.fEF.fEg.fqp.fqr, fL.fEE.fEL)));
        if (fT != null) {
            Intent intent = new Intent();
            intent.putExtra("message_id", SelectConversationUI.i(this.zpv));
            intent.putExtra("record_xml", fT.hbB);
            intent.putExtra("record_show_share", false);
            d.b(this.zpv.mController.xIM, "record", ".ui.RecordMsgDetailUI", intent);
        }
    }
}
