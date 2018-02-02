package com.tencent.mm.plugin.appbrand.q;

import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.net.MalformedURLException;
import java.net.URL;

public final class h {

    public interface a {
        void fq(String str);

        void po(String str);
    }

    public static void a(b bVar, String str, a aVar) {
        if (bh.ov(str)) {
            aVar.fq("isNullOrNil script");
            return;
        }
        bVar.evaluateJavascript(str + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)}), new 1(aVar));
    }

    public static void a(b bVar, String str, String str2, a aVar) {
        if (bh.ov(str2)) {
            aVar.fq("isNullOrNil script");
            return;
        }
        String str3 = str2 + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)});
        URL url = null;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    url = new URL(q.rl(str));
                }
            } catch (MalformedURLException e) {
                return;
            }
        }
        bVar.a(url, str3, new 2(aVar));
    }
}
