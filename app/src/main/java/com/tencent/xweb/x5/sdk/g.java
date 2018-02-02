package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.p;
import com.tencent.xweb.x5.sdk.f.a;

public final class g implements b {
    public final boolean s(Context context, boolean z) {
        return p.s(context, false);
    }

    public final boolean a(Context context, boolean z, boolean z2, a aVar) {
        if (aVar == null) {
            return p.a(context, z, z2, null);
        }
        return p.a(context, z, z2, new a(aVar));
    }

    public final void t(Context context, boolean z) {
        p.t(context, z);
    }

    public final void stopDownload() {
        p.stopDownload();
    }

    public final boolean isDownloading() {
        return p.isDownloading();
    }

    public final boolean cEs() {
        return p.cEs();
    }
}
