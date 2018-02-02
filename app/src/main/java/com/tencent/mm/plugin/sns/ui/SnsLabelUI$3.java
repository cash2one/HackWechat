package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

class SnsLabelUI$3 implements OnChildClickListener {
    final /* synthetic */ SnsLabelUI rDf;

    SnsLabelUI$3(SnsLabelUI snsLabelUI) {
        this.rDf = snsLabelUI;
    }

    public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        if (i2 == SnsLabelUI.a(this.rDf).getChildrenCount(i) - 1) {
            SnsLabelUI.a(this.rDf, i);
            SnsLabelUI.f(this.rDf);
        } else {
            String str = (String) SnsLabelUI.a(this.rDf).getChild(i, i2);
            SnsLabelUI.a(this.rDf);
            aq.LX(str);
            if (i == 2) {
                SnsLabelUI.a(this.rDf, 1, SnsLabelUI.a(this.rDf).rDn, str, view);
            } else if (i == 3) {
                SnsLabelUI.a(this.rDf, 2, SnsLabelUI.a(this.rDf).rDo, str, view);
            }
        }
        return false;
    }
}
