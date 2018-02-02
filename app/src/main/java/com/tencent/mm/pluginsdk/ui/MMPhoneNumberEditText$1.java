package com.tencent.mm.pluginsdk.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMPhoneNumberEditText$1 implements OnTouchListener {
    final /* synthetic */ MMPhoneNumberEditText vkr;

    MMPhoneNumberEditText$1(MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.vkr = mMPhoneNumberEditText;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MMPhoneNumberEditText mMPhoneNumberEditText = this.vkr;
        if (mMPhoneNumberEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMPhoneNumberEditText.getWidth() - mMPhoneNumberEditText.getPaddingRight()) - this.vkr.vkn.getIntrinsicWidth()))) {
            if (mMPhoneNumberEditText.isFocused()) {
                mMPhoneNumberEditText.setText("");
                MMPhoneNumberEditText.a(mMPhoneNumberEditText);
            } else if (MMPhoneNumberEditText.b(this.vkr) != null) {
                MMPhoneNumberEditText.b(this.vkr).f(mMPhoneNumberEditText);
            }
        }
        return false;
    }
}
