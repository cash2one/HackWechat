package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.method.NumberKeyListener;

class q$1 extends NumberKeyListener {
    final /* synthetic */ q jYj;

    q$1(q qVar) {
        this.jYj = qVar;
    }

    protected final char[] getAcceptedChars() {
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', 'X', 'x'};
    }

    public final int getInputType() {
        return (this.jYj.jYO ? 16 : 0) | 2;
    }
}
