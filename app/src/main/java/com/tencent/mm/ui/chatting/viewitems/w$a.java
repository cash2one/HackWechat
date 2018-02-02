package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class w$a extends a {
    protected ImageView hvY;
    final /* synthetic */ w yMA;
    protected TextView yMz;

    w$a(w wVar) {
        this.yMA = wVar;
    }

    public final w$a dE(View view) {
        super.ds(view);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.hvY = (ImageView) view.findViewById(R.h.cEk);
        this.yMz = (TextView) view.findViewById(R.h.cRT);
        return this;
    }
}
