package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class x$d extends a {
    TextView mxT;
    ProgressBar psA;
    ImageView yJk;
    ImageView yKh;
    TextView yMD;
    ImageView yME;
    View yMF;

    public final a q(View view, boolean z) {
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.yKh = (ImageView) view.findViewById(R.h.bTI);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        this.yMF = view.findViewById(R.h.cUb);
        if (z) {
            this.qhg = (TextView) view.findViewById(R.h.bVk);
            this.psA = (ProgressBar) view.findViewById(R.h.ccV);
        } else {
            this.psA = (ProgressBar) view.findViewById(R.h.cTZ);
            this.yMD = (TextView) view.findViewById(R.h.cUa);
            this.qhg = (TextView) view.findViewById(R.h.bVk);
            this.yJk = (ImageView) view.findViewById(R.h.bVd);
        }
        this.yME = (ImageView) view.findViewById(R.h.bTK);
        this.mxT = (TextView) view.findViewById(R.h.bTl);
        return this;
    }
}
