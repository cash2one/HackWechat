package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MaskImageButton$2 implements OnTouchListener {
    final /* synthetic */ MaskImageButton zlI;

    MaskImageButton$2(MaskImageButton maskImageButton) {
        this.zlI = maskImageButton;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setPressed(true);
                view.invalidate();
                MaskImageButton.b(this.zlI).removeCallbacks(MaskImageButton.a(this.zlI));
                break;
            case 1:
            case 3:
                MaskImageButton.b(this.zlI).post(MaskImageButton.a(this.zlI));
                break;
        }
        if (this.zlI.isClickable() || this.zlI.isLongClickable()) {
            return false;
        }
        return true;
    }
}
