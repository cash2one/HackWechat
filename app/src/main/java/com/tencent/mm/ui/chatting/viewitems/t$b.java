package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class t$b extends a {
    TextView qjb;
    TextView yLs;
    TextView yMh;
    View yMi;
    ImageView yMj;
    ImageView yMk;
    TextView yMl;
    TextView yMm;

    t$b() {
    }

    public final a dB(View view) {
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.yLs = (TextView) view.findViewById(R.h.bVj);
        this.qjb = (TextView) view.findViewById(R.h.bVl);
        this.yMh = (TextView) view.findViewById(R.h.bTH);
        this.yIy = view.findViewById(R.h.bTD);
        this.yMm = (TextView) view.findViewById(R.h.bUD);
        this.yMi = view.findViewById(R.h.bUc);
        this.yMj = (ImageView) view.findViewById(R.h.bSC);
        this.yMk = (ImageView) view.findViewById(R.h.bUd);
        this.yMl = (TextView) view.findViewById(R.h.bSD);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        return this;
    }
}
