package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class e$a extends a {
    public TextView yJW;

    e$a() {
    }

    public final e$a du(View view) {
        super.ds(view);
        this.ldK = (TextView) this.mUL.findViewById(R.h.bVf);
        this.mSc = (CheckBox) this.mUL.findViewById(R.h.bTC);
        this.jWc = this.mUL.findViewById(R.h.bUC);
        this.qhg = (TextView) this.mUL.findViewById(R.h.bVk);
        this.yJW = (TextView) this.mUL.findViewById(R.h.bKW);
        return this;
    }
}
