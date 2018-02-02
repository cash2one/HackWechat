package com.tencent.mm.wallet_core.ui.formview;

import android.text.method.NumberKeyListener;
import com.tencent.mm.wallet_core.ui.formview.a.a;

class a$a$1 extends NumberKeyListener {
    final /* synthetic */ a zJw;

    a$a$1(a aVar) {
        this.zJw = aVar;
    }

    public final int getInputType() {
        return 1;
    }

    protected final char[] getAcceptedChars() {
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
    }
}
