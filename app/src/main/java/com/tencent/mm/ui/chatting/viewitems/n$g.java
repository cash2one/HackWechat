package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;

class n$g extends n$b {
    View yKZ;

    n$g() {
    }

    public final void dz(View view) {
        if (this.pBg == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.h.cWd);
            if (viewStub != null) {
                viewStub.inflate();
                this.pBg = view.findViewById(R.h.bUk);
                this.yKZ = view.findViewById(R.h.bottom);
                this.jpW = (TextView) this.pBg.findViewById(R.h.title);
            }
        }
    }
}
