package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qk;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsSingleTextViewUI$3 extends c<qk> {
    final /* synthetic */ SnsSingleTextViewUI rGK;

    SnsSingleTextViewUI$3(SnsSingleTextViewUI snsSingleTextViewUI) {
        this.rGK = snsSingleTextViewUI;
        this.xen = qk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qk qkVar = (qk) bVar;
        if ((qkVar instanceof qk) && SnsSingleTextViewUI.a(this.rGK).bxW().equals(qkVar.fHX.id)) {
            ao.cb(qkVar.fHX.id, 8);
            SnsSingleTextViewUI.b(this.rGK).setVisibility(8);
            SnsSingleTextViewUI.a(this.rGK, false);
        }
        return false;
    }
}
