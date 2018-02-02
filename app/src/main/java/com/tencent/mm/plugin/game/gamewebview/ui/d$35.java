package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class d$35 implements OnTouchListener {
    final /* synthetic */ d mZC;

    d$35(d dVar) {
        this.mZC = dVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (!view.hasFocus()) {
                    view.requestFocus();
                    break;
                }
                break;
        }
        if (d.n(this.mZC) != null && (motionEvent.getAction() == 0 || motionEvent.getAction() == 5 || motionEvent.getAction() == 5 || motionEvent.getAction() == 261 || motionEvent.getAction() == 517)) {
            if (motionEvent.getPointerCount() > 1) {
                d.n(this.mZC).getSettings().setBuiltInZoomControls(true);
                d.n(this.mZC).getSettings().setSupportZoom(true);
            } else {
                d.n(this.mZC).getSettings().setBuiltInZoomControls(false);
                d.n(this.mZC).getSettings().setSupportZoom(false);
            }
        }
        return false;
    }
}
