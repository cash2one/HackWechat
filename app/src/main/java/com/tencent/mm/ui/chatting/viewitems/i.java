package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public final class i {

    static class a extends com.tencent.mm.ui.chatting.viewitems.b.a {
        protected ImageView mRY;
        protected ImageView mSe;
        protected View mwb;
        protected TextView mxT;
        protected TextView yIW;
        protected TextView yKn;
        protected ImageView yKo;

        a() {
        }

        public final a dv(View view) {
            super.ds(view);
            this.mRY = (ImageView) view.findViewById(R.h.bTo);
            this.mxT = (TextView) view.findViewById(R.h.bTl);
            this.yKn = (TextView) view.findViewById(R.h.bTe);
            this.mwb = view.findViewById(R.h.bTf);
            this.yIW = (TextView) view.findViewById(R.h.bSZ);
            this.qhg = (TextView) view.findViewById(R.h.bVk);
            this.yKo = (ImageView) view.findViewById(R.h.bTg);
            this.mSc = (CheckBox) view.findViewById(R.h.bTC);
            this.jWc = view.findViewById(R.h.bUC);
            this.mSe = (ImageView) view.findViewById(R.h.bTK);
            return this;
        }
    }
}
