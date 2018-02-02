package com.tencent.mm.ui.bindmobile;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;

class c$a {
    String hNv;
    ImageView ihQ;
    TextView ihV;
    TextView jLc;
    ProgressBar ptW;
    int status;
    int wXW;
    TextView ymA;
    View ymt;
    final /* synthetic */ c ymx;
    TextView ymz;

    public c$a(final c cVar, View view) {
        this.ymx = cVar;
        this.ymz = (TextView) view.findViewById(R.h.cjX);
        this.ihQ = (ImageView) view.findViewById(R.h.cjW);
        this.jLc = (TextView) view.findViewById(R.h.cjY);
        this.ymA = (TextView) view.findViewById(R.h.ckb);
        this.ymt = view.findViewById(R.h.cjV);
        this.ihV = (TextView) view.findViewById(R.h.cka);
        this.ptW = (ProgressBar) view.findViewById(R.h.cjZ);
        this.ymt.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c$a ymC;

            public final void onClick(View view) {
                if (c.f(this.ymC.ymx) != null) {
                    c.f(this.ymC.ymx).h(this.ymC.wXW, this.ymC.hNv, this.ymC.status);
                }
            }
        });
    }
}
