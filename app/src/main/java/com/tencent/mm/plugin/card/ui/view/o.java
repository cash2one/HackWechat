package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class o extends i {
    private View kWQ;
    private ImageView kWR;
    private TextView kWS;
    private TextView kWT;

    public final void initView() {
        this.kWQ = findViewById(R.h.ckf);
        this.kWR = (ImageView) findViewById(R.h.ckd);
        this.kWS = (TextView) findViewById(R.h.ckh);
        this.kWT = (TextView) findViewById(R.h.ckg);
        this.kWQ.setVisibility(8);
    }

    public final void update() {
        b avI = this.kWz.avI();
        Context avL = this.kWz.avL();
        a avP = this.kWz.avP();
        this.kWQ.setVisibility(0);
        TextView textView = this.kWS;
        ar.Hg();
        textView.setText(i.b(avL, c.EY().WO(avP.kQw).AP(), this.kWS.getTextSize()));
        if (avI.atD() != null && !TextUtils.isEmpty(avI.atD().wLJ)) {
            this.kWT.setText(i.b(avL, avI.atD().wLJ, this.kWT.getTextSize()));
        } else if (TextUtils.isEmpty(avI.atB().kKZ)) {
            this.kWT.setText(avL.getString(R.l.dOl, new Object[]{this.kWz.avQ().getTitle()}));
        } else {
            this.kWT.setText(avL.getString(R.l.dOl, new Object[]{avI.atB().kKZ}));
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(this.kWR, avP.kQw);
        this.kWR.setOnClickListener(this.kWz.avM());
    }

    public final void awW() {
        this.kWQ.setVisibility(8);
    }
}
