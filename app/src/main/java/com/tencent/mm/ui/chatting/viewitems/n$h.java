package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.n.b;

class n$h extends b {
    ImageView jMv;
    TextView lUD;
    ImageView pBi;
    ImageView yKV;

    n$h() {
    }

    public final void dz(View view) {
        if (this.pBg == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.h.cWe);
            if (viewStub != null) {
                viewStub.inflate();
                this.pBg = view.findViewById(R.h.bUl);
                this.pBi = (ImageView) this.pBg.findViewById(R.h.bZl);
                this.yKL = (ImageView) this.pBg.findViewById(R.h.bZt);
                this.yKV = (ImageView) this.pBg.findViewById(R.h.cDo);
                this.jMv = (ImageView) this.pBg.findViewById(R.h.cUW);
                this.jpW = (TextView) this.pBg.findViewById(R.h.title);
                this.lUD = (TextView) this.pBg.findViewById(R.h.cRs);
            }
        }
    }
}
