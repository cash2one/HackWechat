package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class ab$c extends a {
    TextView mxT;
    TextView yMh;

    ab$c() {
    }

    public final a dB(View view) {
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        this.yMh = (TextView) view.findViewById(R.h.bTH);
        this.mxT = (TextView) view.findViewById(R.h.bUQ);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        return this;
    }
}
