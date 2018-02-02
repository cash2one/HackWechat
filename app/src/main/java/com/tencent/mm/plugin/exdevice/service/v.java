package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashMap;

public final class v {
    private static v lQq = null;
    public ag hOa = new ag();
    final HashMap<Long, Integer> lQr = new HashMap();

    private v() {
    }

    public static v aEN() {
        if (lQq == null) {
            lQq = new v();
        }
        return lQq;
    }
}
