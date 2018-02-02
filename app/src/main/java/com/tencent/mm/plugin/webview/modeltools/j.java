package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class j {
    private final LinkedList<String> tvk = new LinkedList();

    public final void OI(String str) {
        try {
            if (!bh.ov(str)) {
                synchronized (this.tvk) {
                    String str2 = (String) this.tvk.peekLast();
                    String encode = URLEncoder.encode(str);
                    if (str2 == null || !str2.equals(encode)) {
                        this.tvk.addLast(encode);
                    }
                    if (this.tvk.size() > 10) {
                        this.tvk.removeFirst();
                    }
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[]{bh.i(e)});
        }
    }

    public final String[] bRH() {
        String[] strArr;
        synchronized (this.tvk) {
            strArr = new String[this.tvk.size()];
            Iterator it = this.tvk.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2 = i + 1;
                strArr[i] = (String) it.next();
                i = i2;
            }
        }
        return strArr;
    }

    public final void bRI() {
        if (b.ceK()) {
            StringBuilder stringBuilder = new StringBuilder("routeList: ");
            synchronized (this.tvk) {
                Iterator it = this.tvk.iterator();
                while (it.hasNext()) {
                    stringBuilder.append(URLDecoder.decode((String) it.next())).append("\n");
                }
            }
            x.d("MicroMsg.WebViewURLRouteList", stringBuilder.toString());
        }
    }
}
