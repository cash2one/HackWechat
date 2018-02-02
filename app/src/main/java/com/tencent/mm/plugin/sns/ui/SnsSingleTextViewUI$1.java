package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qj;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsSingleTextViewUI$1 extends c<qj> {
    final /* synthetic */ SnsSingleTextViewUI rGK;

    SnsSingleTextViewUI$1(SnsSingleTextViewUI snsSingleTextViewUI) {
        this.rGK = snsSingleTextViewUI;
        this.xen = qj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qj qjVar = (qj) bVar;
        if ((qjVar instanceof qj) && SnsSingleTextViewUI.a(this.rGK) != null && SnsSingleTextViewUI.a(this.rGK).bxW().equals(qjVar.fHW.id)) {
            ao.ca(SnsSingleTextViewUI.a(this.rGK).bxW(), 8);
            SnsSingleTextViewUI.b(this.rGK).setVisibility(0);
            SnsSingleTextViewUI.b(this.rGK).xP(2);
            SnsSingleTextViewUI.a(this.rGK, false);
        }
        return false;
    }
}
