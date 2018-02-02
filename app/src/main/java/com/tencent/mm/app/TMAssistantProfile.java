package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a;
import com.tencent.mm.sdk.platformtools.ac;

public class TMAssistantProfile extends e {
    public static final String ffc = (ac.getPackageName() + ":TMAssistantDownloadSDKService");

    public final void onCreate() {
        a.ay(ac.getContext());
        i.cq(ffc);
        k.setupBrokenLibraryHandler();
        k.b(com.tencent.mm.sdk.a.xdV, TMAssistantProfile.class.getClassLoader());
        m.tZ();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public String toString() {
        return ffc;
    }
}
