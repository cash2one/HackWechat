package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.wxpay.a.c;

public final class a extends ClickableSpan {
    private int jjf = -1;
    private Context mContext = null;
    public a pdj = null;
    private int su = -1;

    public a(Context context) {
        this.mContext = context;
        this.su = this.mContext.getResources().getColor(c.ubc);
        this.jjf = -1;
    }

    public final void onClick(View view) {
        if (this.pdj != null) {
            this.pdj.onClick(view);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(true);
        textPaint.setColor(this.su);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.jjf;
    }
}
