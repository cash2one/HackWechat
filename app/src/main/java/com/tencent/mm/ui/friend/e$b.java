package com.tencent.mm.ui.friend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;

class e$b {
    TextView hvZ;
    ImageView ihQ;
    TextView ihV;
    int status;
    int wXW;
    View ymt;
    ProgressBar ymu;
    final /* synthetic */ e zda;
    String zdc;

    public e$b(e eVar, View view) {
        this.zda = eVar;
        this.ihQ = (ImageView) view.findViewById(R.h.bYy);
        this.hvZ = (TextView) view.findViewById(R.h.cEt);
        this.ymt = view.findViewById(R.h.cEn);
        this.ihV = (TextView) view.findViewById(R.h.cEv);
        this.ymu = (ProgressBar) view.findViewById(R.h.cEu);
        this.ymt.setOnClickListener(new 1(this, eVar));
    }
}
