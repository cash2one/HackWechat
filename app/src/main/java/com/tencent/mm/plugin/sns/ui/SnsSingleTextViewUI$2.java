package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qi;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class SnsSingleTextViewUI$2 extends c<qi> {
    final /* synthetic */ SnsSingleTextViewUI rGK;

    SnsSingleTextViewUI$2(SnsSingleTextViewUI snsSingleTextViewUI) {
        this.rGK = snsSingleTextViewUI;
        super(0);
        this.xen = qi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qi qiVar = (qi) bVar;
        if ((qiVar instanceof qi) && SnsSingleTextViewUI.a(this.rGK) != null && SnsSingleTextViewUI.a(this.rGK).bxW().equals(qiVar.fHU.id)) {
            ao.ca(SnsSingleTextViewUI.a(this.rGK).bxW(), 8);
            String str = qiVar.fHU.result;
            String str2 = qiVar.fHU.fHV;
            if (bh.ov(str)) {
                SnsSingleTextViewUI.b(this.rGK).setVisibility(8);
                ao.cb(SnsSingleTextViewUI.a(this.rGK).bxW(), 8);
            } else {
                SnsSingleTextViewUI.b(this.rGK).setVisibility(0);
                SnsSingleTextViewUI.b(this.rGK).a(null, 1, str, str2, true);
                SnsSingleTextViewUI.a(this.rGK, true);
            }
        }
        return false;
    }
}
