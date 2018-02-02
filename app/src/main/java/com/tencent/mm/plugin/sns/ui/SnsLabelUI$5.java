package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;

class SnsLabelUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ SnsLabelUI rDf;

    SnsLabelUI$5(SnsLabelUI snsLabelUI) {
        this.rDf = snsLabelUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Context context = this.rDf;
        String d = bh.d(context.rCR.rDn, ",");
        String d2 = bh.d(context.rCR.rDp, ",");
        String d3 = bh.d(context.rCR.rDo, ",");
        String d4 = bh.d(context.rCR.rDq, ",");
        if ((context.rCR.rDl == 2 && context.rCR.rDn.size() == 0 && context.rCR.rDp.size() == 0) || (context.rCR.rDl == 3 && context.rCR.rDo.size() == 0 && context.rCR.rDq.size() == 0)) {
            h.a(context, context.getString(j.qLo), "", context.getString(j.qLv), null);
        } else if ((context.rCR.rDl == 2 && bh.ov(d) && bh.ov(d2)) || (context.rCR.rDl == 3 && bh.ov(d3) && bh.ov(d4))) {
            h.a(context, context.getString(j.qLo), "", context.getString(j.qLv), null);
        } else {
            context.bBi();
        }
        return true;
    }
}
