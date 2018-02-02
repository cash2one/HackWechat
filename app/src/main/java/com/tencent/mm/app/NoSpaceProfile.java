package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;

public class NoSpaceProfile extends e {
    public static final String ffc = (ac.getPackageName() + ":nospace");

    public final void onCreate() {
        k.b(a.xdV, NoSpaceProfile.class.getClassLoader());
        i.cq(ffc);
        k.setupBrokenLibraryHandler();
        bh.initLanguage(ac.getContext());
        m.tZ();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }
}
