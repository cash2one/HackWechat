package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.rtmp.sharp.jni.QLog;

public class BankRemitScrollBar extends AlphabetScrollBar {
    public BankRemitScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void axX() {
        super.axX();
        this.nJi = new String[]{"☆", "A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z", "#"};
    }
}
