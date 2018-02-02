package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

class n$d extends n$b {
    ImageView pBi;
    ImageView yKK;
    TextView yKT;
    ImageView yKU;

    n$d() {
    }

    public final void dz(View view) {
        if (this.pBg == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.h.cWa);
            if (viewStub != null) {
                viewStub.inflate();
                this.pBg = view.findViewById(R.h.bUi);
                this.pBi = (ImageView) this.pBg.findViewById(R.h.bZl);
                this.jpW = (TextView) this.pBg.findViewById(R.h.title);
                this.yKT = (TextView) this.pBg.findViewById(R.h.cCP);
                this.yKK = (ImageView) this.pBg.findViewById(R.h.cCF);
                this.yKU = (ImageView) this.pBg.findViewById(R.h.cYB);
                this.yKL = (ImageView) this.pBg.findViewById(R.h.bZt);
            }
        }
    }
}
