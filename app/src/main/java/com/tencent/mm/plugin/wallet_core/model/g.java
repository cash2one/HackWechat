package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class g {
    private static g sLV;
    public String oZB;
    public int sLW = 0;
    JSONObject sLX;

    public static g bKX() {
        if (sLV == null) {
            sLV = new g();
        }
        return sLV;
    }

    public final boolean aHh() {
        if (this.sLW != 1 || bh.ov(this.oZB)) {
            return false;
        }
        return true;
    }
}
