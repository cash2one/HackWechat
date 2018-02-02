package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.rtmp.sharp.jni.QLog;

public class SortViewScrollBar extends AlphabetScrollBar {
    public SortViewScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void axX() {
        this.nJi = new String[]{"A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z", "#"};
        this.nJg = 1.45f;
        this.nJh = 79;
    }
}
