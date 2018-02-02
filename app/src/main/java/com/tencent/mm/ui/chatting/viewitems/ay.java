package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class ay extends a {
    TextView iir;

    ay() {
    }

    public final a dI(View view) {
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        this.iir = (TextView) view.findViewById(R.h.bTH);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        return this;
    }
}
