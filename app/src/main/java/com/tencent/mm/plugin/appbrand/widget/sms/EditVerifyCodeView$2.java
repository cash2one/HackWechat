package com.tencent.mm.plugin.appbrand.widget.sms;

import android.text.method.NumberKeyListener;

class EditVerifyCodeView$2 extends NumberKeyListener {
    final /* synthetic */ EditVerifyCodeView kgq;

    EditVerifyCodeView$2(EditVerifyCodeView editVerifyCodeView) {
        this.kgq = editVerifyCodeView;
    }

    protected final char[] getAcceptedChars() {
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    }

    public final int getInputType() {
        return 3;
    }
}
