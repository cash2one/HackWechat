package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.w.a.h;
import com.tencent.rtmp.sharp.jni.QLog;

public class AlphabetScrollBar extends VerticalScrollBar {
    public void axX() {
        this.nJi = new String[]{"↑", "☆", "A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z", "#"};
        this.nJg = 1.3f;
        this.nJh = 79;
    }

    public AlphabetScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final int aUq() {
        return h.dsC;
    }
}
