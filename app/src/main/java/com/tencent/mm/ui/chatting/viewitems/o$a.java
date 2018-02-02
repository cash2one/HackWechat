package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class o$a extends a {
    TextView kBH;
    ImageView yJk;
    public int yJw;
    ImageView yLr;
    TextView yLs;
    TextView yLt;

    o$a() {
    }

    public final a q(View view, boolean z) {
        super.ds(view);
        this.yLr = (ImageView) view.findViewById(R.h.bTv);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.yLs = (TextView) view.findViewById(R.h.bVj);
        this.yLt = (TextView) view.findViewById(R.h.bVl);
        this.kBH = (TextView) view.findViewById(R.h.bUH);
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        this.yIy = view.findViewById(R.h.bTD);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        if (!z) {
            this.yIz = (ImageView) view.findViewById(R.h.bVb);
            this.yJk = (ImageView) view.findViewById(R.h.bVd);
            this.psA = (ProgressBar) view.findViewById(R.h.cTZ);
        }
        this.yJw = b.fP(ac.getContext());
        return this;
    }
}
