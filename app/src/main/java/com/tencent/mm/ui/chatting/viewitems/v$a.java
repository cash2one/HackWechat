package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class v$a extends a {
    protected ImageView hvY;
    protected NoMeasuredTextView yMx;
    final /* synthetic */ v yMy;

    v$a(v vVar) {
        this.yMy = vVar;
    }

    public final v$a dD(View view) {
        super.ds(view);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.hvY = (ImageView) view.findViewById(R.h.csS);
        this.yMx = (NoMeasuredTextView) view.findViewById(R.h.cRT);
        return this;
    }
}
