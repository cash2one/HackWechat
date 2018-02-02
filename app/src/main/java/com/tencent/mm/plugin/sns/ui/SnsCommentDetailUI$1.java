package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qi;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsCommentDetailUI$1 extends c<qi> {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$1(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
        this.xen = qi.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        qi qiVar = (qi) bVar;
        if (qiVar instanceof qi) {
            String str = qiVar.fHU.id;
            String str2 = qiVar.fHU.result;
            String str3 = qiVar.fHU.fHV;
            if (qiVar.fHU.type == 1) {
                SnsCommentDetailUI.a(this.rAr, str, str2, str3);
            } else if (qiVar.fHU.type == 2) {
                SnsCommentDetailUI.a(this.rAr, str);
            }
        }
        return false;
    }
}
