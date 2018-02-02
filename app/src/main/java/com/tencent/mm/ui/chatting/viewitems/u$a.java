package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class u$a extends a {
    protected TextView yMp;
    protected TextView yMq;
    protected TextView yMr;
    protected TextView yMs;
    protected TextView yMt;
    protected TextView yMu;
    protected ImageView yMv;
    final /* synthetic */ u yMw;

    u$a(u uVar) {
        this.yMw = uVar;
    }

    public final u$a dC(View view) {
        super.ds(view);
        this.yMp = (TextView) view.findViewById(R.h.cPw);
        this.yMr = (TextView) view.findViewById(R.h.cFp);
        this.yMq = (TextView) view.findViewById(R.h.cPx);
        this.yMs = (TextView) view.findViewById(R.h.cFq);
        this.yMt = (TextView) view.findViewById(R.h.cVP);
        this.yMu = (TextView) view.findViewById(R.h.coe);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.yMv = (ImageView) view.findViewById(R.h.cVL);
        return this;
    }
}
