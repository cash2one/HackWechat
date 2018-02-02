package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.network.n.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class g$1 extends a {
    g$1() {
    }

    public final void eq(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(DownloadInfo.STATUS, i);
        f.a("com.tencent.mm:support", bundle, g$a.class, null);
    }
}
