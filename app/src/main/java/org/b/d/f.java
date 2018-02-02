package org.b.d;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.b.b.a;
import org.b.b.b;
import org.b.g.d;

class f {
    private j Ays;
    private e Ayt;
    private e Ayu;
    private byte[] Ayv = null;
    private boolean Ayw = false;
    private Long Ayx = null;
    private Long Ayy = null;
    private HttpURLConnection aBw;
    private String charset;
    private Map<String, String> jTx;
    private String url;
    private String wsk = null;

    public f(j jVar, String str) {
        this.Ays = jVar;
        this.url = str;
        this.Ayt = new e();
        this.Ayu = new e();
        this.jTx = new HashMap();
    }

    public g cKh() {
        try {
            String cKf = cKf();
            if (this.aBw == null) {
                System.setProperty("http.keepAlive", this.Ayw ? "true" : "false");
                this.aBw = (HttpURLConnection) new URL(cKf).openConnection();
            }
            this.aBw.setRequestMethod(this.Ays.name());
            if (this.Ayx != null) {
                this.aBw.setConnectTimeout(this.Ayx.intValue());
            }
            if (this.Ayy != null) {
                this.aBw.setReadTimeout(this.Ayy.intValue());
            }
            g(this.aBw);
            if (this.Ays.equals(j.AyG) || this.Ays.equals(j.AyF)) {
                HttpURLConnection httpURLConnection = this.aBw;
                byte[] cKl = cKl();
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(cKl.length));
                if (httpURLConnection.getRequestProperty("Content-Type") == null) {
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(cKl);
            }
            return new g(this.aBw);
        } catch (Exception e) {
            throw new a(e);
        }
    }

    public String cKf() {
        e eVar = this.Ayt;
        String str = this.url;
        d.j(str, "Cannot append to null URL");
        String cKk = eVar.cKk();
        if (cKk.equals("")) {
            return str;
        }
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str)).append(str.indexOf(63) != -1 ? "&" : Character.valueOf('?')).toString())).append(cKk).toString();
    }

    private void g(HttpURLConnection httpURLConnection) {
        for (String str : this.jTx.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.jTx.get(str));
        }
    }

    public void addHeader(String str, String str2) {
        this.jTx.put(str, str2);
    }

    public void gn(String str, String str2) {
        this.Ayt.Ayr.add(new d(str, str2));
    }

    public e cKd() {
        try {
            e eVar = new e();
            eVar.acD(new URL(this.url).getQuery());
            eVar.a(this.Ayt);
            return eVar;
        } catch (Exception e) {
            throw new b("Malformed URL", e);
        }
    }

    public e cKi() {
        return this.Ayu;
    }

    public String getUrl() {
        return this.url;
    }

    public String cKj() {
        return this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
    }

    private byte[] cKl() {
        if (this.Ayv != null) {
            return this.Ayv;
        }
        try {
            return (this.wsk != null ? this.wsk : this.Ayu.cKk()).getBytes(cKg());
        } catch (Exception e) {
            throw new b("Unsupported Charset: " + cKg(), e);
        }
    }

    public j cKe() {
        return this.Ays;
    }

    public String cKg() {
        return this.charset == null ? Charset.defaultCharset().name() : this.charset;
    }

    public String toString() {
        return String.format("@Request(%s %s)", new Object[]{cKe(), getUrl()});
    }
}
