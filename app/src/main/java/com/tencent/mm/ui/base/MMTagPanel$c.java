package com.tencent.mm.ui.base;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.ui.tools.h;

public class MMTagPanel$c implements InputFilter {
    final /* synthetic */ MMTagPanel ydR;
    int ydY = 36;
    private int ydZ = 256;
    private int yea;

    public MMTagPanel$c(MMTagPanel mMTagPanel) {
        this.ydR = mMTagPanel;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int ZY = h.ZY(spanned.toString()) + h.ZY(charSequence.toString());
        if (i4 > i3) {
            if (ZY - (i4 - i3) > this.ydY) {
                MMTagPanel.a(this.ydR, true);
                this.yea = (ZY - (i4 - i3)) - this.ydY;
            } else {
                MMTagPanel.a(this.ydR, false);
            }
        } else if (ZY > this.ydY) {
            MMTagPanel.a(this.ydR, true);
            this.yea = ZY - this.ydY;
        } else {
            MMTagPanel.a(this.ydR, false);
        }
        if (MMTagPanel.h(this.ydR) && 1 == this.yea && charSequence.equals("\n")) {
            this.yea = 0;
        }
        if (MMTagPanel.e(this.ydR) != null) {
            this.ydR.post(new 1(this));
        }
        if (ZY > this.ydZ) {
            return "";
        }
        return charSequence;
    }
}
