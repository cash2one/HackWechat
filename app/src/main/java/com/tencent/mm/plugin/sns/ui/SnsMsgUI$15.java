package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SnsMsgUI$15 implements OnTouchListener {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$15(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.rDE.aWs();
                SnsMsgUI.i(this.rDE)[0] = (int) motionEvent.getRawX();
                SnsMsgUI.i(this.rDE)[1] = (int) motionEvent.getRawY();
                break;
        }
        return false;
    }
}
