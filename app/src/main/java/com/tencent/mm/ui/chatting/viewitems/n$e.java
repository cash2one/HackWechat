package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

class n$e extends n$b {
    ImageView jMv;
    ImageView pBi;
    ImageView yKV;
    ImageView yKW;

    n$e() {
    }

    public final void dz(View view) {
        if (this.pBg == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.h.cWb);
            if (viewStub != null) {
                viewStub.inflate();
                this.pBg = view.findViewById(R.h.bUj);
                this.pBi = (ImageView) this.pBg.findViewById(R.h.bZl);
                this.yKL = (ImageView) this.pBg.findViewById(R.h.bZt);
                this.yKV = (ImageView) this.pBg.findViewById(R.h.cDo);
                this.jpW = (TextView) this.pBg.findViewById(R.h.title);
                this.yKW = (ImageView) this.pBg.findViewById(R.h.bZv);
                this.jMv = (ImageView) this.pBg.findViewById(R.h.cCz);
            }
        }
    }
}
