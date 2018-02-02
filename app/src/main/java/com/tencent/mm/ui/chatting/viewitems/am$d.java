package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class am$d extends a {
    TextView yMh;

    am$d() {
    }

    public final a dB(View view) {
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.yMh = (TextView) view.findViewById(R.h.bVD);
        this.yIy = view.findViewById(R.h.bTD);
        this.yIz = (ImageView) view.findViewById(R.h.bVb);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        return this;
    }
}
