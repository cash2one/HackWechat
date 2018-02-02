package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class a extends i {
    private View kWg;

    public final void initView() {
        this.kWg = findViewById(R.h.bPx);
    }

    public final void update() {
        g avN = this.kWz.avN();
        b avI = this.kWz.avI();
        Context avL = this.kWz.avL();
        com.tencent.mm.plugin.card.ui.e.a avP = this.kWz.avP();
        f avQ = this.kWz.avQ();
        if (avN.awG()) {
            this.kWg.setVisibility(0);
            findViewById(R.h.bIj).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(R.h.bIi);
            TextView textView = (TextView) findViewById(R.h.bIk);
            TextView textView2 = (TextView) findViewById(R.h.bIn);
            if (avP.kQw != null) {
                ar.Hg();
                textView.setText(i.b(avL, c.EY().WO(avP.kQw).AP(), textView.getTextSize()));
            }
            if (avP.kFm == 23) {
                if (!TextUtils.isEmpty(avI.atB().vSi)) {
                    textView2.setText(avI.atB().vSi);
                } else if (TextUtils.isEmpty(avI.atB().kKZ)) {
                    textView2.setText(avL.getString(R.l.dOT, new Object[]{avQ.getTitle()}));
                } else {
                    textView2.setText(avL.getString(R.l.dOT, new Object[]{avI.atB().kKZ}));
                }
            } else if (avI.atD() != null && !TextUtils.isEmpty(avI.atD().wLJ)) {
                textView2.setText(avI.atD().wLJ);
            } else if (TextUtils.isEmpty(avI.atB().kKZ)) {
                textView2.setText(avL.getString(R.l.dOl, new Object[]{avQ.getTitle()}));
            } else {
                textView2.setText(avL.getString(R.l.dOl, new Object[]{avI.atB().kKZ}));
            }
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, avP.kQw, 0.15f, false);
            imageView.setOnClickListener(this.kWz.avM());
        } else if (!avN.awH()) {
            awW();
        } else if (TextUtils.isEmpty(avI.atB().vSi)) {
            this.kWg.setVisibility(8);
        } else {
            this.kWg.setVisibility(0);
            findViewById(R.h.bIj).setVisibility(8);
            ((TextView) findViewById(R.h.bIn)).setText(avI.atB().vSi);
        }
    }

    public final void awW() {
        this.kWg.setVisibility(8);
    }
}
