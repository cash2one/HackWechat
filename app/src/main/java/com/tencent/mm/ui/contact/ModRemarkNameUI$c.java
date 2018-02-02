package com.tencent.mm.ui.contact;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;

class ModRemarkNameUI$c extends ClickableSpan {
    public String iIj;
    final /* synthetic */ ModRemarkNameUI yTW;

    public ModRemarkNameUI$c(ModRemarkNameUI modRemarkNameUI, String str) {
        this.yTW = modRemarkNameUI;
        this.iIj = str;
    }

    public final void onClick(View view) {
        ModRemarkNameUI.a(this.yTW).setText(i.b(this.yTW, t.ou(this.iIj), ModRemarkNameUI.a(this.yTW).getTextSize()));
        ModRemarkNameUI.a(this.yTW).setSelection(ModRemarkNameUI.a(this.yTW).getText().length());
        ModRemarkNameUI.l(this.yTW).setVisibility(8);
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.yTW.getResources().getColor(R.e.brA));
        textPaint.setUnderlineText(false);
    }
}
