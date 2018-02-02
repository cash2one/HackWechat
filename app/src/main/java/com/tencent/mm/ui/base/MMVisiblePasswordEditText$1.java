package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMVisiblePasswordEditText$1 implements OnTouchListener {
    final /* synthetic */ MMVisiblePasswordEditText yeV;

    MMVisiblePasswordEditText$1(MMVisiblePasswordEditText mMVisiblePasswordEditText) {
        this.yeV = mMVisiblePasswordEditText;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        MMVisiblePasswordEditText mMVisiblePasswordEditText = this.yeV;
        if (mMVisiblePasswordEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMVisiblePasswordEditText.getWidth() - mMVisiblePasswordEditText.getPaddingRight()) - this.yeV.yeS.getIntrinsicWidth()))) {
            mMVisiblePasswordEditText = this.yeV;
            if (MMVisiblePasswordEditText.a(this.yeV)) {
                z = false;
            }
            MMVisiblePasswordEditText.a(mMVisiblePasswordEditText, z);
            MMVisiblePasswordEditText.b(this.yeV);
        }
        return false;
    }
}
