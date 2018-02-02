package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.b;
import com.tencent.mm.ui.chatting.viewitems.b.d;
import com.tencent.mm.y.g;

class AppBrandServiceChattingUI$a$5 extends d {
    final /* synthetic */ a ypW;

    public AppBrandServiceChattingUI$a$5(a aVar, ChattingUI.a aVar2, b bVar) {
        this.ypW = aVar;
        super(aVar2, bVar);
    }

    public final void a(View view, ChattingUI.a aVar, au auVar) {
        x.d("MicroMsg.AppBrandServiceChattingUI", "clickListener ChattingListClickListener onClick");
        view.getTag();
        if (auVar.cje()) {
            super.a(view, aVar, auVar);
        } else if (auVar.aNc()) {
            String str = auVar.field_content;
            if (str != null) {
                g.a fT = g.a.fT(str);
                if (fT == null) {
                    return;
                }
                if (a.b(this.ypW) == 2 && fT.type == 33 && a.c(this.ypW).appId.equals(fT.hdy)) {
                    a.a(this.ypW, fT.hdw);
                } else {
                    super.a(view, aVar, auVar);
                }
            }
        } else {
            super.a(view, aVar, auVar);
        }
    }
}
