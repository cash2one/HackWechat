package com.tencent.mm.plugin.voip.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class VoipSmallIconButton$1 implements OnTouchListener {
    final /* synthetic */ VoipSmallIconButton sqy;

    VoipSmallIconButton$1(VoipSmallIconButton voipSmallIconButton) {
        this.sqy = voipSmallIconButton;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                VoipSmallIconButton.b(this.sqy).setImageDrawable(VoipSmallIconButton.a(this.sqy));
                VoipSmallIconButton.c(this.sqy).setTextColor(-855638017);
                break;
            case 1:
                VoipSmallIconButton.b(this.sqy).setImageDrawable(VoipSmallIconButton.d(this.sqy));
                VoipSmallIconButton.c(this.sqy).setTextColor(-1);
                break;
        }
        return false;
    }
}
