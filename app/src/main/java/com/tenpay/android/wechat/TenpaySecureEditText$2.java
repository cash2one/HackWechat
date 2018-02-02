package com.tenpay.android.wechat;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tenpay.android.wechat.TenpaySecureEditText.EditState;

class TenpaySecureEditText$2 implements OnFocusChangeListener {
    final /* synthetic */ TenpaySecureEditText this$0;

    TenpaySecureEditText$2(TenpaySecureEditText tenpaySecureEditText) {
        this.this$0 = tenpaySecureEditText;
    }

    public void onFocusChange(View view, boolean z) {
        if (!z) {
            this.this$0.setCompoundDrawables(this.this$0.getCompoundDrawables()[0], this.this$0.getCompoundDrawables()[1], null, this.this$0.getCompoundDrawables()[3]);
        } else if (!this.this$0.getText().toString().equals("") && EditState.PASSWORD != this.this$0.mEditState && EditState.CVV_PAYMENT != this.this$0.mEditState && EditState.CVV_4_PAYMENT != this.this$0.mEditState) {
            this.this$0.setCompoundDrawables(this.this$0.getCompoundDrawables()[0], this.this$0.getCompoundDrawables()[1], TenpaySecureEditText.access$000(this.this$0), this.this$0.getCompoundDrawables()[3]);
        }
    }
}
