package com.tencent.mm.ui.chatting.viewitems;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.tencent.mm.ui.base.a.a;

abstract class az extends ClickableSpan implements a {
    private boolean yPE;
    private int yPF;
    private int yPG;

    public az(int i, int i2) {
        this.yPF = i;
        this.yPG = i2;
    }

    public final void lo(boolean z) {
        this.yPE = z;
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.yPE ? this.yPG : this.yPF);
        textPaint.setUnderlineText(false);
    }
}
