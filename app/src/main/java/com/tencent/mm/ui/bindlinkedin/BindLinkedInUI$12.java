package com.tencent.mm.ui.bindlinkedin;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.R;

class BindLinkedInUI$12 extends ClickableSpan {
    final /* synthetic */ BindLinkedInUI ylv;

    BindLinkedInUI$12(BindLinkedInUI bindLinkedInUI) {
        this.ylv = bindLinkedInUI;
    }

    public final void onClick(View view) {
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.ylv.getResources().getColor(R.e.btd));
        textPaint.setUnderlineText(false);
    }
}
