package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsCommentDetailUI$23 extends c<qk> {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$23(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
        this.xen = qk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qk qkVar = (qk) bVar;
        if (qkVar instanceof qk) {
            String str = qkVar.fHX.id;
            if (qkVar.fHX.type == 1) {
                SnsCommentDetailUI.d(this.rAr, str);
            } else if (qkVar.fHX.type == 2) {
                SnsCommentDetailUI.e(this.rAr, str);
            }
        }
        return false;
    }
}
