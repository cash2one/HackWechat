package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.sdk.platformtools.x;

class ControlBoardPanel$4 implements OnKeyListener {
    final /* synthetic */ ControlBoardPanel khQ;

    ControlBoardPanel$4(ControlBoardPanel controlBoardPanel) {
        this.khQ = controlBoardPanel;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        x.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", new Object[]{Integer.valueOf(i), keyEvent});
        if (i == 4) {
            this.khQ.khH.setVisibility(8);
            this.khQ.khJ.setVisibility(8);
            this.khQ.khJ.setVisibility(8);
            this.khQ.khM.setSelected(false);
            this.khQ.khK.setSelected(false);
            this.khQ.khL.setSelected(false);
            ControlBoardPanel.a(this.khQ);
        }
        return false;
    }
}
