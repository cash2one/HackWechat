package com.tencent.mm.plugin.sns.ui;

import java.util.HashSet;
import java.util.Iterator;

class SnsLabelUI$10 implements Runnable {
    final /* synthetic */ SnsLabelUI rDf;

    SnsLabelUI$10(SnsLabelUI snsLabelUI) {
        this.rDf = snsLabelUI;
    }

    public final void run() {
        SnsLabelUI.a(this.rDf).rDl = SnsLabelUI.k(this.rDf);
        if (SnsLabelUI.j(this.rDf) == null) {
            SnsLabelUI.a(this.rDf, SnsLabelUI.b(this.rDf));
        } else {
            SnsLabelUI.j(this.rDf).addAll(SnsLabelUI.b(this.rDf));
        }
        if (SnsLabelUI.b(this.rDf) != null) {
            Iterator it = SnsLabelUI.b(this.rDf).iterator();
            while (it.hasNext()) {
                SnsLabelUI.a(this.rDf);
                aq.LX((String) it.next());
            }
        }
        Object hashSet = new HashSet(SnsLabelUI.j(this.rDf));
        SnsLabelUI.j(this.rDf).clear();
        SnsLabelUI.j(this.rDf).addAll(hashSet);
        SnsLabelUI.a(this.rDf).Q(SnsLabelUI.j(this.rDf));
        SnsLabelUI.a(this.rDf).notifyDataSetChanged();
        SnsLabelUI.g(this.rDf).El(SnsLabelUI.a(this.rDf).rDl);
        if (SnsLabelUI.b(this.rDf) != null) {
            SnsLabelUI.b(this.rDf).clear();
        }
        SnsLabelUI.n(this.rDf);
        hashSet.clear();
        if (SnsLabelUI.o(this.rDf) != null && SnsLabelUI.o(this.rDf).isShowing()) {
            SnsLabelUI.o(this.rDf).dismiss();
        }
    }
}
