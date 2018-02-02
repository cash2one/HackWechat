package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMClearEditText$3 implements OnTouchListener {
    final /* synthetic */ MMClearEditText xZL;

    MMClearEditText$3(MMClearEditText mMClearEditText) {
        this.xZL = mMClearEditText;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MMClearEditText mMClearEditText = this.xZL;
        if (mMClearEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMClearEditText.getWidth() - mMClearEditText.getPaddingRight()) - this.xZL.vkn.getIntrinsicWidth()))) {
            mMClearEditText.setText("");
            MMClearEditText.c(this.xZL);
        }
        return false;
    }
}
