package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public final class l extends o {
    protected boolean aEL;
    protected String aEW;
    protected String aEX;
    protected int aEZ;
    protected boolean aFG;
    protected int aFH;
    protected boolean aFI;
    protected boolean aFJ;

    public l(q qVar) {
        super(qVar);
    }

    public final int getLogLevel() {
        mQ();
        return this.aFH;
    }

    public final String mC() {
        mQ();
        return this.aEX;
    }

    public final String mD() {
        mQ();
        return this.aEW;
    }

    public final boolean mE() {
        mQ();
        return this.aFG;
    }

    public final boolean mF() {
        mQ();
        return this.aFI;
    }

    public final int mG() {
        mQ();
        return this.aEZ;
    }

    public final boolean mH() {
        mQ();
        return this.aFJ;
    }

    public final boolean mI() {
        mQ();
        return this.aEL;
    }

    protected final void mf() {
        ApplicationInfo applicationInfo;
        Context context = this.aFo.mContext;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 129);
        } catch (NameNotFoundException e) {
            e("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            ax("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                b bVar = (b) new ak(this.aFo).db(i);
                if (bVar != null) {
                    String str;
                    int i2;
                    au("Loading global XML config values");
                    if (bVar.aEW != null) {
                        str = bVar.aEW;
                        this.aEW = str;
                        d("XML config - app name", str);
                    }
                    if (bVar.aEX != null) {
                        str = bVar.aEX;
                        this.aEX = str;
                        d("XML config - app version", str);
                    }
                    if (bVar.aEY != null) {
                        str = bVar.aEY.toLowerCase();
                        i2 = "verbose".equals(str) ? 0 : "info".equals(str) ? 1 : "warning".equals(str) ? 2 : "error".equals(str) ? 3 : -1;
                        if (i2 >= 0) {
                            this.aFH = i2;
                            c("XML config - log level", Integer.valueOf(i2));
                        }
                    }
                    if (bVar.aEZ >= 0) {
                        i2 = bVar.aEZ;
                        this.aEZ = i2;
                        this.aFI = true;
                        d("XML config - dispatch period (sec)", Integer.valueOf(i2));
                    }
                    if (bVar.aFa != -1) {
                        boolean z = bVar.aFa == 1;
                        this.aEL = z;
                        this.aFJ = true;
                        d("XML config - dry run", Boolean.valueOf(z));
                    }
                }
            }
        }
    }
}
