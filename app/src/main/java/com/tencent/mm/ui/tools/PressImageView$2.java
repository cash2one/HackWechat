package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class PressImageView$2 implements OnTouchListener {
    final /* synthetic */ PressImageView zmf;

    PressImageView$2(PressImageView pressImageView) {
        this.zmf = pressImageView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setPressed(true);
                view.invalidate();
                PressImageView.b(this.zmf).removeCallbacks(PressImageView.a(this.zmf));
                break;
            case 1:
            case 3:
                PressImageView.b(this.zmf).post(PressImageView.a(this.zmf));
                break;
        }
        if (this.zmf.isClickable() || this.zmf.isLongClickable()) {
            return false;
        }
        return true;
    }
}
