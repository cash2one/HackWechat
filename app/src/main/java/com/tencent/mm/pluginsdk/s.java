package com.tencent.mm.pluginsdk;

import com.tencent.mm.sdk.platformtools.x;

public final class s {
    private static boolean vcG = false;
    public String mTag = "";
    public boolean vcF = false;

    public s(String str) {
        this.mTag = str;
    }

    public static void bYf() {
        vcG = true;
    }

    public final boolean ch(String str) {
        if (vcG) {
            x.i("MicroMsg.SplashOptimizing", "[%s], check cancel", this.mTag);
            return false;
        } else if (!this.vcF) {
            return false;
        } else {
            x.i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", this.mTag, str);
            return true;
        }
    }
}
