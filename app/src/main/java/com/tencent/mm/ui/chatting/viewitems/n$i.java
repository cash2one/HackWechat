package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.viewitems.n.b;

class n$i extends b {
    TextView nou;
    ImageView yKK;

    n$i() {
    }

    public final void dz(View view) {
        if (this.pBg == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.h.cWf);
            if (viewStub != null) {
                viewStub.inflate();
                this.pBg = view.findViewById(R.h.bUm);
                this.jpW = (TextView) this.pBg.findViewById(R.h.title);
                this.nou = (TextView) this.pBg.findViewById(R.h.cRs);
                this.yKK = (ImageView) this.pBg.findViewById(R.h.cCF);
            }
        }
    }
}
