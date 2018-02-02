package com.tencent.mm.y;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.bh;

public final class i {
    public static boolean fV(String str) {
        return str != null && str.endsWith("@app");
    }

    public static l fW(String str) {
        try {
            return (l) new l().aF(Base64.decode(str, 0));
        } catch (Exception e) {
            try {
                return (l) new l().aF(bh.VD(str));
            } catch (Exception e2) {
                return new l();
            }
        }
    }
}
