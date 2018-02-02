package com.tencent.mm.plugin.appbrand.game.b;

import android.util.Base64;
import com.tencent.magicbrush.handler.image.a.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class b$b extends a {
    private b$b() {
    }

    private static int rK(String str) {
        int i = 14;
        if (str == null) {
            return 0;
        }
        if (!str.startsWith("data:image/")) {
            return 0;
        }
        if (str.startsWith("jpeg", 11)) {
            i = 15;
        } else if (!(str.startsWith("png", 11) || str.startsWith("gif", 11))) {
            return 0;
        }
        if (str.startsWith(";base64,", i)) {
            return i + 8;
        }
        return 0;
    }

    public final boolean bE(String str) {
        return rK(str) > 0;
    }

    public final InputStream bF(String str) {
        return new ByteArrayInputStream(Base64.decode(str.substring(rK(str)), 2));
    }
}
