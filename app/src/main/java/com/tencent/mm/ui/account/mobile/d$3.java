package com.tencent.mm.ui.account.mobile;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;

class d$3 extends ClickableSpan {
    final /* synthetic */ MobileInputUI xTP;
    final /* synthetic */ d xTS;

    d$3(d dVar, MobileInputUI mobileInputUI) {
        this.xTS = dVar;
        this.xTP = mobileInputUI;
    }

    public final void onClick(View view) {
        bh.F(this.xTP.mController.xIM, this.xTP.getString(R.l.eSl));
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.xTP.getResources().getColor(R.e.btd));
        textPaint.setUnderlineText(true);
    }
}
