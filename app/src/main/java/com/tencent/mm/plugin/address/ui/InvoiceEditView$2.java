package com.tencent.mm.plugin.address.ui;

import android.text.method.NumberKeyListener;

class InvoiceEditView$2 extends NumberKeyListener {
    final /* synthetic */ InvoiceEditView inj;

    InvoiceEditView$2(InvoiceEditView invoiceEditView) {
        this.inj = invoiceEditView;
    }

    public final int getInputType() {
        return 3;
    }

    protected final char[] getAcceptedChars() {
        if (this.inj.inf) {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', ' '};
        }
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '+', '_', '—', ' ', ' ', '(', ')', '（', '）', '@', '~', '*', '&', '^', '%', '$', '#', '@', '!', ';', ':', '：', '；', '{', '}', '[', ']', '｛', '｝', '【', '】', '<', '>', '转', '~', '`', '·', '=', '=', '+'};
    }
}
