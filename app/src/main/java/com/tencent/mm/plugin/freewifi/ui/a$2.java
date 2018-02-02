package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.z.ar;

class a$2 implements Runnable {
    final /* synthetic */ a mGE;

    a$2(a aVar) {
        this.mGE = aVar;
    }

    public final void run() {
        View findViewById = a.b(this.mGE).findViewById(R.h.cjS);
        if (an.getNetType(ac.getContext()) != 0) {
            findViewById.setVisibility(8);
        } else {
            ar.Dm().F(new 1(this, findViewById));
        }
    }
}
