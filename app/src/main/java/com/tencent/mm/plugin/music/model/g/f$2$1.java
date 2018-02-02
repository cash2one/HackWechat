package com.tencent.mm.plugin.music.model.g;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.music.model.g.f.2;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.ac;

class f$2$1 implements Runnable {
    final /* synthetic */ int fhx;
    final /* synthetic */ 2 oMJ;

    f$2$1(2 2, int i) {
        this.oMJ = 2;
        this.fhx = i;
    }

    public final void run() {
        Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ewS), 0).show();
        f.a(this.oMJ.oMH, h.bdz().bdo(), this.fhx);
    }
}
