package org.b.d;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.b.b.b;
import org.b.g.e;

public final class g {
    private String Ayz;
    public int code;
    private Map<String, String> jTx;
    private InputStream stream;

    g(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.connect();
            this.code = httpURLConnection.getResponseCode();
            this.jTx = h(httpURLConnection);
            Object obj = (this.code < 200 || this.code >= 400) ? null : 1;
            this.stream = obj != null ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
        } catch (Exception e) {
            throw new b("The IP address of a host could not be determined.", e);
        }
    }

    private static Map<String, String> h(HttpURLConnection httpURLConnection) {
        Map<String, String> hashMap = new HashMap();
        for (String str : httpURLConnection.getHeaderFields().keySet()) {
            hashMap.put(str, (String) ((List) httpURLConnection.getHeaderFields().get(str)).get(0));
        }
        return hashMap;
    }

    public final String getBody() {
        if (this.Ayz != null) {
            return this.Ayz;
        }
        this.Ayz = e.y(this.stream);
        return this.Ayz;
    }
}
