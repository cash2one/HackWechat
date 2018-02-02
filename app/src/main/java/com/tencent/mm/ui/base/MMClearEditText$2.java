package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MMClearEditText$2 implements OnFocusChangeListener {
    final /* synthetic */ MMClearEditText xZL;

    MMClearEditText$2(MMClearEditText mMClearEditText) {
        this.xZL = mMClearEditText;
    }

    public final void onFocusChange(View view, boolean z) {
        if (MMClearEditText.b(this.xZL) != null) {
            MMClearEditText.b(this.xZL).onFocusChange(view, z);
        }
        MMClearEditText.a(this.xZL);
    }
}
