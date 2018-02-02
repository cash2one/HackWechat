package com.tencent.mm.plugin.voip.widget;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.sdk.platformtools.ac;

class b$5 implements a {
    final /* synthetic */ b svK;

    b$5(b bVar) {
        this.svK = bVar;
    }

    public final boolean aTc() {
        if (b.yU(b.e(this.svK)) || b.yS(b.e(this.svK))) {
            return true;
        }
        return false;
    }

    public final void a(Intent intent, h hVar) {
        if (intent.getBooleanExtra("Voip_Is_Talking", false)) {
            hVar.ME(this.svK.bIN());
        } else {
            hVar.ME(ac.getContext().getString(R.l.ewL));
        }
    }
}
