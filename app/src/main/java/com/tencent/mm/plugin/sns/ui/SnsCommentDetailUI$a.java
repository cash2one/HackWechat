package com.tencent.mm.plugin.sns.ui;

import android.text.TextPaint;
import android.view.View;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.pluginsdk.ui.d.n;

class SnsCommentDetailUI$a extends n {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$a(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final void onClick(View view) {
        SnsCommentDetailUI.i(this.rAr).rMt.onClick(view);
    }

    public final void updateDrawState(TextPaint textPaint) {
        int color = this.rAr.getResources().getColor(c.lnH);
        if (this.ozA) {
            textPaint.bgColor = color;
        } else {
            textPaint.bgColor = 0;
        }
    }
}
