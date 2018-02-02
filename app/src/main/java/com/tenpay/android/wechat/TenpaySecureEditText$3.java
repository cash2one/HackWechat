package com.tenpay.android.wechat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tenpay.android.wechat.TenpaySecureEditText.EditState;

class TenpaySecureEditText$3 implements OnTouchListener {
    final /* synthetic */ TenpaySecureEditText this$0;

    TenpaySecureEditText$3(TenpaySecureEditText tenpaySecureEditText) {
        this.this$0 = tenpaySecureEditText;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!(EditState.PASSWORD == this.this$0.mEditState || EditState.CVV_PAYMENT == this.this$0.mEditState || EditState.CVV_4_PAYMENT == this.this$0.mEditState)) {
            TenpaySecureEditText tenpaySecureEditText = this.this$0;
            if (tenpaySecureEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((tenpaySecureEditText.getWidth() - tenpaySecureEditText.getPaddingRight()) - TenpaySecureEditText.access$000(this.this$0).getIntrinsicWidth()))) {
                tenpaySecureEditText.setText("");
            }
        }
        return false;
    }
}
