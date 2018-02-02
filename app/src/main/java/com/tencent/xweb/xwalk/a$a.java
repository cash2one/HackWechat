package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

class a$a extends UpdateConfig {
    String AsF;

    public a$a(String str, String str2) {
        int i = 100000;
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        if (availableVersion >= 100000) {
            i = availableVersion + 1;
        }
        this(i);
        this.AsF = str;
        this.isMatchMd5 = false;
        this.isPatchUpdate = false;
        this.versionDetail = "local:" + str2;
    }

    public final boolean checkValid() {
        return true;
    }

    private a$a(int i) {
        super(null, false, i);
    }
}
