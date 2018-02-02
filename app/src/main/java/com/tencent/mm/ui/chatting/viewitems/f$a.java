package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ChattingTranslateView;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.MMTextView;

final class f$a extends a {
    View lWv;
    MMTextView yJY;
    ChattingTranslateView yJZ;
    ImageView yJk;

    f$a() {
    }

    public final a q(View view, boolean z) {
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        this.yJY = (MMTextView) view.findViewById(R.h.bTH);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        this.lWv = view.findViewById(R.h.bTF);
        this.yJZ = (ChattingTranslateView) view.findViewById(R.h.bVi);
        if (!z) {
            this.yJk = (ImageView) view.findViewById(R.h.bVd);
            this.yIz = (ImageView) view.findViewById(R.h.bVb);
            this.psA = (ProgressBar) view.findViewById(R.h.cTZ);
        }
        return this;
    }
}
