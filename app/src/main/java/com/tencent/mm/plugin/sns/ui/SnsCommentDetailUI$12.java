package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsCommentDetailUI$12 extends c<qj> {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$12(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
        this.xen = qj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qj qjVar = (qj) bVar;
        if (qjVar instanceof qj) {
            String str = qjVar.fHW.id;
            if (qjVar.fHW.type == 1) {
                SnsCommentDetailUI.b(this.rAr, str);
            } else if (qjVar.fHW.type == 2) {
                SnsCommentDetailUI.c(this.rAr, str);
            }
        }
        return false;
    }
}
