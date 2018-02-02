package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.c.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.Map;

public class b$b {
    public int gKi;
    public String host;
    public int pow = 0;
    public Map<String, String> pox = null;
    public Map<String, String> poy = null;
    public String uri;
    public String xet;
    public a xeu = null;

    public final String getUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(this.uri.startsWith("http://") || this.uri.startsWith("https://"))) {
            stringBuilder.append(this.xet + this.host);
        }
        stringBuilder.append(this.uri);
        if (this.pox == null) {
            return stringBuilder.toString();
        }
        stringBuilder.append('?');
        Object obj = 1;
        for (String str : this.pox.keySet()) {
            stringBuilder.append(obj != null ? "" : "&").append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(bh.ou((String) this.pox.get(str)), ProtocolPackage.ServerEncoding));
            obj = null;
        }
        return stringBuilder.toString();
    }

    public final String toString() {
        try {
            return getUrl();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.HttpWrapperBase", e, "", new Object[0]);
            return "";
        }
    }
}
