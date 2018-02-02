package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.ui.widget.MMTextView;

class af$d extends d {
    public af$d(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        if (auVar.ciZ()) {
            if (this.yqa != null) {
                g.pQN.k(10221, "1");
                Intent intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.bm.d.b(this.yqa.getContext(), "shake", ".ui.ShakeReportUI", intent);
            }
        } else if (auVar.cjg() && (view instanceof MMTextView)) {
            MMTextView mMTextView = (MMTextView) view;
            com.tencent.mm.ui.chatting.f.a.a.cvt();
            com.tencent.mm.ui.chatting.f.a.a.a(mMTextView.getText(), arVar.fEJ);
        }
    }
}
