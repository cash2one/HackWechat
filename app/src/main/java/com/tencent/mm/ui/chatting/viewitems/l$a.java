package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class l$a extends a {
    protected TextView mxT;
    protected ProgressBar psA;
    protected TextView yIW;
    protected ImageView yIz;
    protected MMNeatTextView yKB;

    l$a() {
    }

    public final l$a dy(View view) {
        super.ds(view);
        this.yKB = (MMNeatTextView) view.findViewById(R.h.bTH);
        this.psA = (ProgressBar) view.findViewById(R.h.cTZ);
        this.yIz = (ImageView) view.findViewById(R.h.bVb);
        this.mxT = (TextView) view.findViewById(R.h.bTl);
        this.yIW = (TextView) view.findViewById(R.h.bSZ);
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        return this;
    }
}
