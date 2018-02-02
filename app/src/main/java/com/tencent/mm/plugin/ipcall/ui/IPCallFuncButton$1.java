package com.tencent.mm.plugin.ipcall.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class IPCallFuncButton$1 implements OnTouchListener {
    final /* synthetic */ IPCallFuncButton nKF;

    IPCallFuncButton$1(IPCallFuncButton iPCallFuncButton) {
        this.nKF = iPCallFuncButton;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (IPCallFuncButton.a(this.nKF)) {
            if (motionEvent.getAction() == 0) {
                if (IPCallFuncButton.b(this.nKF)) {
                    if (IPCallFuncButton.e(this.nKF)) {
                        IPCallFuncButton.d(this.nKF).setImageDrawable(IPCallFuncButton.f(this.nKF));
                        IPCallFuncButton.a(this.nKF, false);
                    } else {
                        IPCallFuncButton.d(this.nKF).setImageDrawable(IPCallFuncButton.c(this.nKF));
                        IPCallFuncButton.a(this.nKF, true);
                    }
                    if (IPCallFuncButton.g(this.nKF) != null) {
                        IPCallFuncButton.g(this.nKF).gf(IPCallFuncButton.e(this.nKF));
                    }
                } else if (IPCallFuncButton.c(this.nKF) != null) {
                    IPCallFuncButton.d(this.nKF).setImageDrawable(IPCallFuncButton.c(this.nKF));
                }
            } else if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && !IPCallFuncButton.b(this.nKF)) {
                if (IPCallFuncButton.f(this.nKF) != null) {
                    IPCallFuncButton.d(this.nKF).setImageDrawable(IPCallFuncButton.f(this.nKF));
                }
                if (IPCallFuncButton.g(this.nKF) != null) {
                    IPCallFuncButton.g(this.nKF).gf(false);
                }
            }
        }
        return false;
    }
}
