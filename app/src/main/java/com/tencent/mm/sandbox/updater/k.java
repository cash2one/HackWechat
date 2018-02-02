package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.b.d;
import com.tencent.xweb.i;
import com.tencent.xweb.q;
import com.tencent.xweb.r;
import com.tencent.xweb.util.b;
import org.xwalk.core.XWalkEnvironment;

public final class k implements a {
    public final boolean af(Intent intent) {
        i.iP(ac.getContext());
        return true;
    }

    public final void lv(boolean z) {
    }

    public final boolean isBusy() {
        boolean isBusy = i.isBusy();
        x.i("MicroMsg.WCWebDownloadMgr", "bIsBusy = " + isBusy);
        return isBusy;
    }

    public final void onDestroy() {
    }

    private k() {
        b 1 = new 1(this);
        q 2 = new 2(this);
        XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.zvE);
        r.a(ac.getContext(), 1, 2, null);
        d.a(a.aAk());
    }
}
