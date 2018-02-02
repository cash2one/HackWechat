package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;

class SnsLabelUI$7 implements Runnable {
    final /* synthetic */ SnsLabelUI rDf;
    final /* synthetic */ String rDi;

    SnsLabelUI$7(SnsLabelUI snsLabelUI, String str) {
        this.rDf = snsLabelUI;
        this.rDi = str;
    }

    public final void run() {
        SnsLabelUI.a(this.rDf, (ArrayList) a.aUX().aUS());
        if (SnsLabelUI.j(this.rDf) == null) {
            SnsLabelUI.a(this.rDf, new ArrayList());
        }
        int i;
        if (bh.ov(this.rDi)) {
            i = -1;
        } else {
            if (!SnsLabelUI.j(this.rDf).contains(this.rDi)) {
                SnsLabelUI.j(this.rDf).add(this.rDi);
            }
            i = SnsLabelUI.j(this.rDf).indexOf(this.rDi);
        }
        SnsLabelUI.a(this.rDf).Q(SnsLabelUI.j(this.rDf));
        SnsLabelUI.a(this.rDf).rDl = SnsLabelUI.k(this.rDf);
        if (!bh.ov(this.rDi) && r0 != -1) {
            if (SnsLabelUI.k(this.rDf) == 2) {
                SnsLabelUI.a(this.rDf).rDn.add(this.rDi);
                SnsLabelUI.a(this.rDf).rDp.clear();
            } else if (SnsLabelUI.k(this.rDf) == 3) {
                SnsLabelUI.a(this.rDf).rDo.add(this.rDi);
                SnsLabelUI.a(this.rDf).rDq.clear();
            }
            SnsLabelUI.a(this.rDf).notifyDataSetChanged();
            SnsLabelUI.g(this.rDf).expandGroup(SnsLabelUI.k(this.rDf));
        }
    }
}
