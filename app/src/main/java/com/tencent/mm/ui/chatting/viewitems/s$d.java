package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class s$d extends a {
    ProgressBar psA;
    ImageView yJk;
    RTChattingEmojiView yKg;
    ImageView yKh;
    ViewStub yMg;

    s$d() {
    }

    public final a q(View view, boolean z) {
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.yKg = (RTChattingEmojiView) view.findViewById(R.h.bTI);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        if (z) {
            this.qhg = (TextView) view.findViewById(R.h.bVk);
        } else {
            this.psA = (ProgressBar) view.findViewById(R.h.cTZ);
            this.qhg = (TextView) view.findViewById(R.h.bVk);
            this.yIz = (ImageView) view.findViewById(R.h.bVb);
            this.yJk = (ImageView) view.findViewById(R.h.bVd);
        }
        if (this.yKh != null) {
            ((ViewGroup) this.yKh.getParent()).setBackgroundDrawable(null);
        }
        this.yMg = (ViewStub) view.findViewById(R.h.bUR);
        return this;
    }
}
