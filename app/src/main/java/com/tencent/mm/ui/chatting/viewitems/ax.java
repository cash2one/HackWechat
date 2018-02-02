package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class ax extends a {
    protected TextView iir;
    protected ImageView yPD;

    ax() {
    }

    public final ax dH(View view) {
        super.ds(view);
        this.iir = (TextView) view.findViewById(R.h.bTc);
        this.yPD = (ImageView) view.findViewById(R.h.bTo);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        return this;
    }
}
