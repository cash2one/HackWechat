package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class j$a extends a {
    protected TextView yKt;

    j$a() {
    }

    public final j$a dw(View view) {
        super.ds(view);
        this.yKt = (TextView) view.findViewById(R.h.ctZ);
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        return this;
    }
}
