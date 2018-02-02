package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.handler.image.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

class b$c extends a {
    private b$c() {
    }

    public final boolean bE(String str) {
        return str != null && (str.startsWith("http://") || str.startsWith("https://"));
    }

    public final InputStream bF(String str) {
        try {
            return new BufferedInputStream(new URL(str).openStream());
        } catch (Exception e) {
            x.e("HttpDecoder", "fetch error failed. path = [%s], error = [%s]", new Object[]{str, e.toString()});
            return null;
        }
    }
}
