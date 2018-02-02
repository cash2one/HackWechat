package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public final class n {

    static class f extends b {
        TextView pBC;
        ImageView pBi;
        View xPF;
        ImageView yKV;
        ImageView yKW;
        View yKX;
        TextView yKY;

        f() {
        }

        public final void dz(View view) {
            if (this.pBg == null) {
                ViewStub viewStub = (ViewStub) view.findViewById(R.h.cWc);
                if (viewStub != null) {
                    viewStub.inflate();
                    this.pBg = view.findViewById(R.h.cSz);
                    this.jpW = (TextView) this.pBg.findViewById(R.h.title);
                    this.pBi = (ImageView) this.pBg.findViewById(R.h.bZl);
                    this.yKX = this.pBg.findViewById(R.h.bZp);
                    this.xPF = this.pBg.findViewById(R.h.bOQ);
                    this.yKY = (TextView) this.pBg.findViewById(R.h.cSt);
                    this.pBC = (TextView) this.pBg.findViewById(R.h.ccd);
                    this.yKV = (ImageView) this.pBg.findViewById(R.h.cDo);
                    this.yKW = (ImageView) this.pBg.findViewById(R.h.bZv);
                }
            }
        }
    }
}
