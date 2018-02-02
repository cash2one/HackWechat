package com.tencent.mm.plugin.profile.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;

class SayHiWithSnsPermissionUI$a extends ClickableSpan {
    public String iIj;
    final /* synthetic */ SayHiWithSnsPermissionUI plm;

    public SayHiWithSnsPermissionUI$a(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI, String str) {
        this.plm = sayHiWithSnsPermissionUI;
        this.iIj = str;
    }

    public final void onClick(View view) {
        SayHiWithSnsPermissionUI.b(this.plm).setText(i.b(this.plm, bh.ou(this.iIj), SayHiWithSnsPermissionUI.b(this.plm).getTextSize()));
        SayHiWithSnsPermissionUI.b(this.plm).setSelection(SayHiWithSnsPermissionUI.b(this.plm).getText().length());
        SayHiWithSnsPermissionUI.l(this.plm).setVisibility(8);
        SayHiWithSnsPermissionUI.k(this.plm)[4] = 1;
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.plm.getResources().getColor(R.e.brA));
        textPaint.setUnderlineText(false);
    }
}
