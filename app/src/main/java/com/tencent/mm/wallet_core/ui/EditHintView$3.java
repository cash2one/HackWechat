package com.tencent.mm.wallet_core.ui;

import android.text.method.NumberKeyListener;

class EditHintView$3 extends NumberKeyListener {
    final /* synthetic */ EditHintView zIQ;

    EditHintView$3(EditHintView editHintView) {
        this.zIQ = editHintView;
    }

    public final int getInputType() {
        return 1;
    }

    protected final char[] getAcceptedChars() {
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
    }
}
