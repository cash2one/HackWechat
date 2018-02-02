package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.js;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsCommentDetailUI$6 extends c<js> {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$6(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
        this.xen = js.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        js jsVar = (js) bVar;
        if (jsVar instanceof js) {
            switch (jsVar.fAz.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    SnsCommentDetailUI.o(this.rAr);
                    break;
            }
        }
        return false;
    }
}
