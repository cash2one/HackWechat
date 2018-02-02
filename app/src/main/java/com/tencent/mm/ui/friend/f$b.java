package com.tencent.mm.ui.friend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;

class f$b {
    String hNv;
    ImageView ihQ;
    TextView ihV;
    TextView jLc;
    ProgressBar ptW;
    int status;
    int wXW;
    TextView ymA;
    View ymt;
    TextView ymz;
    final /* synthetic */ f zdh;

    public f$b(f fVar, View view) {
        this.zdh = fVar;
        this.ymz = (TextView) view.findViewById(R.h.cjX);
        this.ihQ = (ImageView) view.findViewById(R.h.cjW);
        this.jLc = (TextView) view.findViewById(R.h.cjY);
        this.ymA = (TextView) view.findViewById(R.h.ckb);
        this.ymt = view.findViewById(R.h.cjV);
        this.ihV = (TextView) view.findViewById(R.h.cka);
        this.ptW = (ProgressBar) view.findViewById(R.h.cjZ);
        this.ymt.setOnClickListener(new 1(this, fVar));
    }
}
