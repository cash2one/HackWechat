package org.b.d;

import java.util.HashMap;
import java.util.Map;

public final class c extends f {
    public Map<String, String> Ayq = new HashMap();

    public final /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        super.addHeader(str, str2);
    }

    public final /* bridge */ /* synthetic */ e cKd() {
        return super.cKd();
    }

    public final /* bridge */ /* synthetic */ j cKe() {
        return super.cKe();
    }

    public final /* bridge */ /* synthetic */ String cKf() {
        return super.cKf();
    }

    public final /* bridge */ /* synthetic */ String cKg() {
        return super.cKg();
    }

    public final /* bridge */ /* synthetic */ g cKh() {
        return super.cKh();
    }

    public final /* bridge */ /* synthetic */ e cKi() {
        return super.cKi();
    }

    public final /* bridge */ /* synthetic */ String cKj() {
        return super.cKj();
    }

    public final /* bridge */ /* synthetic */ String getUrl() {
        return super.getUrl();
    }

    public final /* bridge */ /* synthetic */ void gn(String str, String str2) {
        super.gn(str, str2);
    }

    public c(j jVar, String str) {
        super(jVar, str);
    }

    public final void gm(String str, String str2) {
        Map map = this.Ayq;
        if (str.startsWith("oauth_") || str.equals("scope")) {
            map.put(str, str2);
        } else {
            throw new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", new Object[]{"scope", "oauth_"}));
        }
    }

    public final String toString() {
        return String.format("@OAuthRequest(%s, %s)", new Object[]{super.cKe(), super.getUrl()});
    }
}
