package com.tencent.mm.ui.bindmobile;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;

class b$a {
    String fqR;
    TextView hvZ;
    TextView ihV;
    int status;
    int wXW;
    final /* synthetic */ b ymq;
    View ymt;
    ProgressBar ymu;

    public b$a(b bVar, View view) {
        this.ymq = bVar;
        this.hvZ = (TextView) view.findViewById(R.h.cwD);
        this.ymt = view.findViewById(R.h.cwv);
        this.ihV = (TextView) view.findViewById(R.h.cwG);
        this.ymu = (ProgressBar) view.findViewById(R.h.cwF);
        this.ymt.setOnClickListener(new 1(this, bVar));
    }
}
