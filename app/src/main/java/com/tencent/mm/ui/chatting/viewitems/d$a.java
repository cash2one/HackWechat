package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class d$a extends a {
    public int maxSize = 0;
    public ImageView yJK;
    public TextView yJL;
    public TextView yJM;
    public TextView yJN;
    public int yJO = 0;
    public int yJw = 0;

    d$a() {
    }

    public final d$a dt(View view) {
        super.ds(view);
        this.ldK = (TextView) this.mUL.findViewById(R.h.bVf);
        this.mSc = (CheckBox) this.mUL.findViewById(R.h.bTC);
        this.jWc = this.mUL.findViewById(R.h.bUC);
        this.qhg = (TextView) this.mUL.findViewById(R.h.bVk);
        this.yJK = (ImageView) this.mUL.findViewById(R.h.bKV);
        this.yJL = (TextView) this.mUL.findViewById(R.h.bKX);
        this.yJM = (TextView) this.mUL.findViewById(R.h.bKU);
        this.yJN = (TextView) this.mUL.findViewById(R.h.bKY);
        this.yIy = (LinearLayout) this.mUL.findViewById(R.h.bTD);
        this.yJw = b.fP(ac.getContext());
        this.yJO = com.tencent.mm.bv.a.aa(ac.getContext(), R.f.buy);
        this.maxSize = (int) (((float) com.tencent.mm.bv.a.ab(ac.getContext(), R.f.buy)) * 1.45f);
        return this;
    }
}
