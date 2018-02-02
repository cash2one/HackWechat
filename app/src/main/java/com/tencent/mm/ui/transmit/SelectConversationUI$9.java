package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.ui.base.i$a$a;
import com.tencent.mm.y.g.a;

class SelectConversationUI$9 implements i$a$a {
    final /* synthetic */ a jrh;
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$9(SelectConversationUI selectConversationUI, a aVar) {
        this.zpv = selectConversationUI;
        this.jrh = aVar;
    }

    public final void aJL() {
        String A = p.A(this.jrh.url, "message");
        String A2 = p.A(this.jrh.hba, "message");
        if (an.isMobile(this.zpv.mController.xIM) ? A2 != null && A2.length() > 0 : A == null || A.length() <= 0) {
            A = A2;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", A);
        intent.putExtra("showShare", false);
        d.b(this.zpv.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
