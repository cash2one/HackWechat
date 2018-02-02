package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.oq;

public final class u extends i {
    private View kWU;

    public final void initView() {
    }

    public final void update() {
        if (this.kWU == null) {
            this.kWU = ((ViewStub) findViewById(R.h.bRB)).inflate();
        }
        b avI = this.kWz.avI();
        Context avL = this.kWz.avL();
        oq oqVar = avI.atC().vRm;
        if (this.kWU != null) {
            TextView textView = (TextView) this.kWU.findViewById(R.h.bRC);
            textView.setText(oqVar.title);
            textView.setTextColor(l.wO(avI.atB().hbM));
            TextView textView2 = (TextView) this.kWU.findViewById(R.h.bRA);
            LinearLayout linearLayout = (LinearLayout) this.kWU.findViewById(R.h.bSu);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            if (avI.ati()) {
                LayoutParams layoutParams2 = (LayoutParams) textView.getLayoutParams();
                if (TextUtils.isEmpty(oqVar.kJR)) {
                    textView2.setVisibility(8);
                    layoutParams.height = avL.getResources().getDimensionPixelOffset(R.f.bwv);
                } else {
                    textView2.setText(oqVar.kJR);
                    textView2.setVisibility(0);
                    layoutParams.height = avL.getResources().getDimensionPixelOffset(R.f.bwu);
                    layoutParams2.bottomMargin = avL.getResources().getDimensionPixelSize(R.f.buo);
                    LayoutParams layoutParams3 = (LayoutParams) textView2.getLayoutParams();
                    layoutParams3.topMargin = avL.getResources().getDimensionPixelSize(R.f.buo);
                    textView2.setLayoutParams(layoutParams3);
                    textView2.invalidate();
                }
                layoutParams2.height = avL.getResources().getDimensionPixelSize(R.f.bww);
                textView.setLayoutParams(layoutParams2);
                textView.invalidate();
                textView.setBackgroundDrawable(l.e(avL, avI.atB().hbM, avL.getResources().getDimensionPixelSize(R.f.bwy)));
                textView.setTextColor(l.U(avL, avI.atB().hbM));
                linearLayout.setBackgroundDrawable(null);
                textView.setOnClickListener(this.kWz.avM());
            } else {
                if (TextUtils.isEmpty(oqVar.kJR)) {
                    textView2.setVisibility(8);
                    layoutParams.height = avL.getResources().getDimensionPixelOffset(R.f.bwE);
                } else {
                    textView2.setText(oqVar.kJR);
                    textView2.setVisibility(0);
                    layoutParams.height = avL.getResources().getDimensionPixelOffset(R.f.bwD);
                }
                linearLayout.setOnClickListener(this.kWz.avM());
            }
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.invalidate();
            this.kWU.invalidate();
            if (avI.ati()) {
                linearLayout.getLayoutParams();
            }
        }
    }

    public final void awW() {
        if (this.kWU != null) {
            this.kWU.setVisibility(8);
        }
    }
}
