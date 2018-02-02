package android.support.v4.view;

import android.view.View;
import android.view.View.OnClickListener;

class PagerTabStrip$2 implements OnClickListener {
    final /* synthetic */ PagerTabStrip xR;

    PagerTabStrip$2(PagerTabStrip pagerTabStrip) {
        this.xR = pagerTabStrip;
    }

    public final void onClick(View view) {
        this.xR.xS.ah(this.xR.xS.yF + 1);
    }
}
