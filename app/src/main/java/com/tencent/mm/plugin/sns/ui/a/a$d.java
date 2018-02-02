package com.tencent.mm.plugin.sns.ui.a;

import android.text.TextPaint;
import android.view.View;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.pluginsdk.ui.d.n;

class a$d extends n {
    final /* synthetic */ a rNC;

    a$d(a aVar) {
        this.rNC = aVar;
    }

    public final void onClick(View view) {
        this.rNC.qZU.rzO.rMu.onClick(view);
    }

    public final void updateDrawState(TextPaint textPaint) {
        int color = this.rNC.mActivity.getResources().getColor(c.lnH);
        if (this.ozA) {
            textPaint.bgColor = color;
        } else {
            textPaint.bgColor = 0;
        }
    }
}
