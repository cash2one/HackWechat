package com.tencent.mm.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.b.b.b;

class a$2 implements OnClickListener {
    final /* synthetic */ a xWG;

    a$2(a aVar) {
        this.xWG = aVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
        this.xWG.Ek(2);
        ar.Hg().FH().c(b.hir);
        ar.Hg().FH().c(b.his);
        this.xWG.setVisibility(8);
    }
}
