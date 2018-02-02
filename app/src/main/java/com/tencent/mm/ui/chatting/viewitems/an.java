package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class an extends a {
    protected TextView iir;
    protected TextView yOp;
    protected TextView yOq;
    protected Button yOr;
    protected Button yOs;
    protected ImageView yOt;

    an() {
    }

    public final an dG(View view) {
        super.ds(view);
        this.iir = (TextView) view.findViewById(R.h.bTc);
        this.yOp = (TextView) view.findViewById(R.h.bTb);
        this.yOq = (TextView) view.findViewById(R.h.bTp);
        this.yOr = (Button) view.findViewById(R.h.bUt);
        this.yOs = (Button) view.findViewById(R.h.bUs);
        this.yOt = (ImageView) view.findViewById(R.h.bVg);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        return this;
    }
}
