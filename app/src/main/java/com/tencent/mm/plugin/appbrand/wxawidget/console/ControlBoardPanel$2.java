package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;

class ControlBoardPanel$2 implements OnClickListener {
    final /* synthetic */ ControlBoardPanel khQ;

    ControlBoardPanel$2(ControlBoardPanel controlBoardPanel) {
        this.khQ = controlBoardPanel;
    }

    public final void onClick(View view) {
        if (this.khQ.khI.getVisibility() == 0) {
            this.khQ.khH.setVisibility(8);
            this.khQ.khI.setVisibility(8);
            this.khQ.khL.setSelected(false);
            ControlBoardPanel.a(this.khQ);
            return;
        }
        this.khQ.khH.setVisibility(0);
        this.khQ.iUX.setVisibility(8);
        this.khQ.khI.setVisibility(0);
        this.khQ.khJ.setVisibility(8);
        this.khQ.khK.setSelected(false);
        this.khQ.khL.setSelected(true);
        this.khQ.khM.setSelected(false);
        ControlBoardPanel.b(this.khQ);
    }
}
