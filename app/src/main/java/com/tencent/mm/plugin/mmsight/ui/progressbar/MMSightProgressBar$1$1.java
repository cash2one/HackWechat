package com.tencent.mm.plugin.mmsight.ui.progressbar;

import com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar.1;
import com.tencent.mm.plugin.mmsight.ui.progressbar.b.a;
import com.tencent.wcdb.support.Log;

class MMSightProgressBar$1$1 implements a {
    final /* synthetic */ 1 oDM;

    MMSightProgressBar$1$1(1 1) {
        this.oDM = 1;
    }

    public final void a(a aVar) {
        MMSightProgressBar.b(this.oDM.oDL).add(aVar);
        MMSightProgressBar.a(this.oDM.oDL, null);
        if (MMSightProgressBar.b(this.oDM.oDL).size() >= 5) {
            Log.i("MicroMsg.MMSightProgressBar", "progress finish!");
            if (MMSightProgressBar.e(this.oDM.oDL) != null) {
                MMSightProgressBar.e(this.oDM.oDL);
            }
        } else if (MMSightProgressBar.a(this.oDM.oDL)) {
            MMSightProgressBar.f(this.oDM.oDL).sendEmptyMessage(233);
        }
        this.oDM.oDL.invalidate();
    }

    public final void bbK() {
        this.oDM.oDL.invalidate();
    }
}
