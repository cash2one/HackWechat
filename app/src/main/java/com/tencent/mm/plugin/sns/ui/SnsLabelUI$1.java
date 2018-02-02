package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class SnsLabelUI$1 implements OnGroupClickListener {
    final /* synthetic */ SnsLabelUI rDf;

    SnsLabelUI$1(SnsLabelUI snsLabelUI) {
        this.rDf = snsLabelUI;
    }

    public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        int i2 = SnsLabelUI.a(this.rDf).rDl;
        x.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        if (i <= 1) {
            if (i2 > 1) {
                SnsLabelUI.g(this.rDf).Em(i2);
            }
            SnsLabelUI.a(this.rDf).rDl = i;
            return false;
        } else if (SnsLabelUI.b(this.rDf) != null && SnsLabelUI.b(this.rDf).size() != 0 && SnsLabelUI.bBl() == 0) {
            SnsLabelUI.a(this.rDf, i);
            SnsLabelUI.c(this.rDf);
            x.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
            return true;
        } else if (SnsLabelUI.d(this.rDf)) {
            SnsLabelUI.e(this.rDf);
            SnsLabelUI.a(this.rDf, i);
            SnsLabelUI.a(this.rDf, h.a(this.rDf, this.rDf.getString(j.qLn), false, null));
            x.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
            return true;
        } else if (SnsLabelUI.a(this.rDf).rDk == null || SnsLabelUI.a(this.rDf).rDk.size() == 0) {
            SnsLabelUI.a(this.rDf, i);
            SnsLabelUI.f(this.rDf);
            x.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
            return true;
        } else {
            if (i2 != i) {
                if (i2 == 2) {
                    SnsLabelUI.g(this.rDf).collapseGroup(2);
                    SnsLabelUI.a(this.rDf).rDn.clear();
                    SnsLabelUI.a(this.rDf).rDp.clear();
                } else if (i2 == 3) {
                    SnsLabelUI.g(this.rDf).collapseGroup(3);
                    SnsLabelUI.a(this.rDf).rDo.clear();
                    SnsLabelUI.a(this.rDf).rDq.clear();
                }
                SnsLabelUI.g(this.rDf).post(new 1(this, i));
            } else if (SnsLabelUI.g(this.rDf).isGroupExpanded(i)) {
                SnsLabelUI.g(this.rDf).Em(i);
            } else {
                SnsLabelUI.g(this.rDf).El(i);
            }
            SnsLabelUI.a(this.rDf).rDl = i;
            return true;
        }
    }
}
