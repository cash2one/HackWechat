package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class k$a extends a {
    public int yJw = 0;
    public ImageView yKu;
    public TextView yKv;
    public TextView yKw;

    k$a() {
    }

    public final k$a dx(View view) {
        super.ds(view);
        this.ldK = (TextView) this.mUL.findViewById(R.h.bVf);
        this.mSc = (CheckBox) this.mUL.findViewById(R.h.bTC);
        this.jWc = this.mUL.findViewById(R.h.bUC);
        this.qhg = (TextView) this.mUL.findViewById(R.h.bVk);
        this.yKu = (ImageView) this.mUL.findViewById(R.h.bLf);
        this.yKv = (TextView) this.mUL.findViewById(R.h.bLg);
        this.yKw = (TextView) this.mUL.findViewById(R.h.bLe);
        this.yJw = b.fP(ac.getContext());
        this.yKw.setTypeface(((b) g.h(b.class)).de(this.mUL.getContext()));
        return this;
    }
}
