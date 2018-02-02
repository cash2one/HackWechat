package com.tencent.mm.plugin.voip_cs.b.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements OnClickListener {
    final /* synthetic */ b sxB;

    b$3(b bVar) {
        this.sxB = bVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
        b.d(this.sxB).setEnabled(false);
        if (b.bIT().swV > 1) {
            b.e(this.sxB);
        }
        b.d(this.sxB).setEnabled(true);
        if (b.f(this.sxB) != null) {
            b.f(this.sxB).bIu();
        }
    }
}
