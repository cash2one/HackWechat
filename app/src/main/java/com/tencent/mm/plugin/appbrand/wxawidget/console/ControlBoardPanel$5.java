package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;

class ControlBoardPanel$5 implements OnClickListener {
    final /* synthetic */ ControlBoardPanel khQ;

    ControlBoardPanel$5(ControlBoardPanel controlBoardPanel) {
        this.khQ = controlBoardPanel;
    }

    public final void onClick(View view) {
        View view2 = this.khQ;
        if (view2.khP) {
            view2.khP = false;
            view2.khN.removeViewImmediate(view2);
            d.b(view2.iUX);
            if (view2.khG != null) {
                view2.khG.a(view2, false);
            }
        }
    }
}
