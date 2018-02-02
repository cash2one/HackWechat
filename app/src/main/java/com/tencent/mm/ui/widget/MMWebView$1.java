package com.tencent.mm.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMWebView$1 implements OnTouchListener {
    final /* synthetic */ MMWebView zvJ;

    MMWebView$1(MMWebView mMWebView) {
        this.zvJ = mMWebView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zvJ.isX5Kernel) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                case 2:
                    MMWebView.c(this.zvJ).requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                case 3:
                    MMWebView.c(this.zvJ).requestDisallowInterceptTouchEvent(false);
                    break;
                default:
                    MMWebView.c(this.zvJ).requestDisallowInterceptTouchEvent(true);
                    break;
            }
        }
        if (MMWebView.d(this.zvJ) != null) {
            return MMWebView.d(this.zvJ).onTouch(view, motionEvent);
        }
        return false;
    }
}
