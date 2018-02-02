package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

class d$3 implements ComponentCallbacks2 {
    final /* synthetic */ d bbE;

    d$3(d dVar) {
        this.bbE = dVar;
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20) {
            this.bbE.bbA.ra();
        }
    }
}
