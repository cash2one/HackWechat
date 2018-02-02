package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.sdk.platformtools.bh;

class ExdeviceConnectWifiUI$a {
    public static String X(int i, String str) {
        if (bh.ov(str)) {
            return null;
        }
        return i + "@" + str.hashCode();
    }
}
