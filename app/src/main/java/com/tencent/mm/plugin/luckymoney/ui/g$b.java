package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.ui.g.c;
import com.tencent.mm.plugin.luckymoney.ui.g.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.bh;

class g$b implements d {
    c ojm;

    g$b() {
    }

    public final void a(Context context, ViewGroup viewGroup, ah ahVar) {
        if (!bh.ov(ahVar.name)) {
            View textView = new TextView(context);
            if (this.ojm == null || this.ojm.textColor == Integer.MIN_VALUE) {
                textView.setTextColor(context.getResources().getColor(a.c.ubA));
            } else {
                textView.setTextColor(this.ojm.textColor);
            }
            if (this.ojm == null || this.ojm.textSize == Integer.MIN_VALUE) {
                textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(a.d.bvs));
            } else {
                textView.setTextSize(0, (float) this.ojm.textSize);
            }
            textView.setGravity(17);
            textView.setText(ahVar.name);
            if (!bh.ov(ahVar.content)) {
                textView.setOnClickListener(new 1(this, ahVar, context));
            }
            viewGroup.addView(textView, new LayoutParams(-2, -2));
            viewGroup.setVisibility(0);
            g.pQN.h(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(ahVar.odF));
        }
    }
}
