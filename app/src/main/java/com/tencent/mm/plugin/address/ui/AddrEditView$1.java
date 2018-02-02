package com.tencent.mm.plugin.address.ui;

import android.text.method.NumberKeyListener;

class AddrEditView$1 extends NumberKeyListener {
    final /* synthetic */ AddrEditView ine;

    AddrEditView$1(AddrEditView addrEditView) {
        this.ine = addrEditView;
    }

    public final int getInputType() {
        return 3;
    }

    protected final char[] getAcceptedChars() {
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    }
}
