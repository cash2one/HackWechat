package com.tencent.mm.ui.bindgooglecontact;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;

class a$b {
    ImageView ihQ;
    TextView ihV;
    TextView inw;
    String pjU;
    int position;
    TextView ykL;
    View ykM;
    ProgressBar ykN;
    final /* synthetic */ a ykO;

    public a$b(a aVar, View view) {
        this.ykO = aVar;
        this.ihQ = (ImageView) view.findViewById(R.h.cnv);
        this.inw = (TextView) view.findViewById(R.h.cnz);
        this.ykM = view.findViewById(R.h.cnA);
        this.ihV = (TextView) view.findViewById(R.h.cnB);
        this.ykN = (ProgressBar) view.findViewById(R.h.cny);
        this.ykL = (TextView) view.findViewById(R.h.cnw);
        this.ykM.setOnClickListener(new 1(this, aVar));
    }
}
