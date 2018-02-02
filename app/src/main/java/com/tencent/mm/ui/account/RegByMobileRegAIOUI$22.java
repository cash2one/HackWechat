package com.tencent.mm.ui.account;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;

class RegByMobileRegAIOUI$22 extends ClickableSpan {
    final /* synthetic */ RegByMobileRegAIOUI xQK;

    RegByMobileRegAIOUI$22(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.xQK = regByMobileRegAIOUI;
    }

    public final void onClick(View view) {
        bh.F(this.xQK.mController.xIM, this.xQK.getString(R.l.esR, new Object[]{w.cfi(), w.cfh()}));
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.xQK.getResources().getColor(R.e.btd));
        textPaint.setUnderlineText(true);
    }
}
