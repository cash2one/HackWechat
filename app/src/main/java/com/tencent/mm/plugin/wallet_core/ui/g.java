package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.wxpay.a.c;

public class g extends ClickableSpan {
    private int jjf = -1;
    private Context mContext = null;
    public a sTw = null;
    int su = -1;

    public g(Context context) {
        this.mContext = context;
        this.su = this.mContext.getResources().getColor(c.ubA);
        this.jjf = this.mContext.getResources().getColor(c.transparent);
    }

    public void onClick(View view) {
        if (this.sTw != null) {
            this.sTw.onClick(view);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(false);
        textPaint.setColor(this.su);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.jjf;
    }
}
