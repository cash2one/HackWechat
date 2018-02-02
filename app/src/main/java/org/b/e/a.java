package org.b.e;

import com.qq.taf.jce.BuildConfig;
import java.util.Map.Entry;
import org.b.a.a.b;
import org.b.c.e;
import org.b.d.c;
import org.b.d.g;
import org.b.d.h;
import org.b.d.i;
import org.b.d.j;
import org.b.d.k;
import org.b.f.d;

public final class a implements b {
    private static /* synthetic */ int[] AyP;
    private org.b.d.a AyN;
    private b AyO;

    private static /* synthetic */ int[] cKn() {
        int[] iArr = AyP;
        if (iArr == null) {
            iArr = new int[h.values().length];
            try {
                iArr[h.AyA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[h.AyB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            AyP = iArr;
        }
        return iArr;
    }

    public a(b bVar, org.b.d.a aVar) {
        this.AyO = bVar;
        this.AyN = aVar;
    }

    public final i cKm() {
        this.AyN.rE("obtaining request token from " + this.AyO.cKb());
        c cVar = new c(j.AyF, this.AyO.cKb());
        this.AyN.rE("setting oauth_callback to " + this.AyN.Ayj);
        cVar.gm("oauth_callback", this.AyN.Ayj);
        a(cVar, org.b.d.b.Ayp);
        b(cVar);
        this.AyN.rE("sending request...");
        g cKh = cVar.cKh();
        String body = cKh.getBody();
        this.AyN.rE("response status code: " + cKh.code);
        this.AyN.rE("response body: " + body);
        return new org.b.c.g().acC(body);
    }

    private void a(c cVar, i iVar) {
        cVar.gm("oauth_timestamp", new d().cKp());
        cVar.gm("oauth_nonce", new d().getNonce());
        cVar.gm("oauth_consumer_key", this.AyN.Ayh);
        cVar.gm("oauth_signature_method", new org.b.f.a().cKo());
        cVar.gm("oauth_version", BuildConfig.VERSION_NAME);
        if ((this.AyN.scope != null ? 1 : null) != null) {
            cVar.gm("scope", this.AyN.scope);
        }
        this.AyN.rE("generating signature...");
        String a = new org.b.c.c().a(cVar);
        String an = new org.b.f.a().an(a, this.AyN.Ayi, iVar.wyk);
        this.AyN.rE("base string is: " + a);
        this.AyN.rE("signature is: " + an);
        cVar.gm("oauth_signature", an);
        this.AyN.rE("appended additional OAuth parameters: " + org.b.g.b.aD(cVar.Ayq));
    }

    public final i a(i iVar, k kVar) {
        this.AyN.rE("obtaining access token from " + this.AyO.cKc());
        c cVar = new c(j.AyF, this.AyO.cKc());
        cVar.gm("oauth_token", iVar.token);
        cVar.gm("oauth_verifier", kVar.value);
        this.AyN.rE("setting token to: " + iVar + " and verifier to: " + kVar);
        a(cVar, iVar);
        b(cVar);
        return new org.b.c.g().acC(cVar.cKh().getBody());
    }

    public final void a(i iVar, c cVar) {
        this.AyN.rE("signing request: " + cVar.cKf());
        Object obj = ("".equals(iVar.token) && "".equals(iVar.wyk)) ? 1 : null;
        if (obj == null) {
            cVar.gm("oauth_token", iVar.token);
        }
        this.AyN.rE("setting token to: " + iVar);
        a(cVar, iVar);
        b(cVar);
    }

    public final String b(i iVar) {
        return this.AyO.b(iVar);
    }

    private void b(c cVar) {
        switch (cKn()[this.AyN.Ayl.ordinal()]) {
            case 1:
                this.AyN.rE("using Http Header signature");
                cVar.addHeader("Authorization", new e().a(cVar));
                return;
            case 2:
                this.AyN.rE("using Querystring signature");
                for (Entry entry : cVar.Ayq.entrySet()) {
                    cVar.gn((String) entry.getKey(), (String) entry.getValue());
                }
                return;
            default:
                return;
        }
    }
}
