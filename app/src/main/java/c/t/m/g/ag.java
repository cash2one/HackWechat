package c.t.m.g;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ag extends ae {
    private static boolean p = false;
    public String o;
    private ak q;
    private aj r;
    private af s;
    private boolean t;
    private s u;
    private n v;
    private String w;
    private String x;

    public ag(String str, Map<String, String> map, byte[] bArr, int i, String str2, boolean z, s sVar, String str3) {
        this.b = str;
        this.c = false;
        this.d = map;
        this.e = bArr;
        this.f = i;
        this.g = str2;
        this.t = z;
        this.u = sVar;
        this.w = str3;
    }

    public static ag a(String str, Map<String, String> map, byte[] bArr, int i, String str2, s sVar) {
        return new ag(str, map, bArr, i, str2, true, sVar, "");
    }

    public final void a(boolean z) {
        if (this.q != null) {
            int i;
            if (this.i) {
                this.q.i = true;
            }
            Map hashMap = new HashMap();
            if (z) {
                hashMap.put("B46", "1");
            } else {
                hashMap.put("B22", this.k);
            }
            if (!cg.a(this.o)) {
                hashMap.put("B15", this.o);
            }
            if (!cg.a(this.w)) {
                hashMap.put("B54", this.w);
            }
            Map hashMap2 = new HashMap();
            hashMap2.put("B82", this.g);
            if (this.l != 0) {
                hashMap2.put("B83", this.l);
            }
            hashMap2.put("B44", cg.b(this.a));
            if (!(TextUtils.isEmpty(this.a) || this.a.equals(this.x))) {
                hashMap2.put("B49", cg.b(this.x));
            }
            if (this.v != null) {
                if (!this.v.b()) {
                    hashMap2.put("B10", this.v.a());
                }
                if (this.v.c != -1) {
                    hashMap2.put("B45", this.v.c);
                }
            }
            hashMap2.put("B53", this.n.get());
            if (!TextUtils.isEmpty(this.s.c)) {
                hashMap2.put("B26", this.s.c);
            }
            if (this.j) {
                hashMap2.put("B97", "1");
            }
            ak akVar = this.q;
            Map hashMap3 = new HashMap();
            hashMap3.putAll(hashMap);
            hashMap3.put("B59", akVar.w);
            if (akVar.p) {
                hashMap3.put("B85", "1");
            }
            if (akVar.c) {
                hashMap3.put("B95", "1");
            } else {
                hashMap3.put("B96", akVar.t);
            }
            if (!akVar.q) {
                hashMap3.put("B23", "1");
            }
            Map hashMap4 = new HashMap();
            hashMap4.putAll(hashMap2);
            if (akVar.m != 0) {
                hashMap4.put("B84", akVar.m);
            }
            hashMap4.put("B87", akVar.r);
            hashMap4.put("B88", akVar.s);
            hashMap4.put("B90", akVar.v.g);
            hashMap4.put("B91", akVar.v.h);
            hashMap4.put("B92", akVar.v.i);
            hashMap4.put("B93", akVar.v.j);
            hashMap4.put("B94", akVar.v.k);
            if (!TextUtils.isEmpty(akVar.h)) {
                hashMap4.put("B47", cg.b(akVar.h));
            }
            if (!TextUtils.isEmpty(akVar.u)) {
                hashMap4.put("B41", akVar.u);
            }
            if (akVar.o.a != 0) {
                i = akVar.o.a;
            } else {
                i = akVar.o.c == 200 ? 0 : akVar.o.c;
            }
            if (akVar.A) {
                cc.a("HLHttpDirect", m.b(), i, akVar.o.b, hashMap3, hashMap4, akVar.i);
            } else {
                cc.b("HLHttpDirect", m.b(), i, akVar.o.b, hashMap3, hashMap4, akVar.i);
            }
        }
    }

    public final aj a() {
        if (!p) {
            p = true;
            try {
                if (VERSION.SDK != null && VERSION.SDK_INT < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
            } catch (Exception e) {
            }
        }
        this.r = new aj(0, "");
        try {
            URL url = new URL(this.b);
            this.s = new af(url, this.b, this.u);
            List a = this.s.a(this.t, url.getProtocol().toLowerCase().startsWith("https"));
            int size = a.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = this.f;
            int i2 = 0;
            while (i2 < size) {
                String str;
                this.n.incrementAndGet();
                this.v = (n) a.get(i2);
                af afVar = this.s;
                n nVar = this.v;
                if (nVar.b == -1) {
                    str = nVar.a;
                } else {
                    if (afVar.a.getProtocol().startsWith("https")) {
                        str = afVar.b != 0 ? "https://" + nVar.a + ":" + afVar.b : "https://" + nVar.a + ":443";
                    } else {
                        str = "http://" + nVar.a + ":" + nVar.b;
                    }
                    String file = afVar.a.getFile();
                    if (!TextUtils.isEmpty(file)) {
                        str = file.startsWith("/") ? str + file : str + "/" + file;
                    }
                    Object ref = afVar.a.getRef();
                    if (!TextUtils.isEmpty(ref)) {
                        str = str + "#" + ref;
                    }
                }
                this.x = str;
                this.q = new ak(url.getHost(), this.x, this.c, this.d, this.e, i, this.g);
                if (i2 != 0) {
                    this.q.A = true;
                }
                if (p.i() && i2 != 0) {
                    this.q.x = true;
                }
                if (i2 == 1 && ((n) a.get(0)).a.equals(this.b) && ((n) a.get(1)).a.equals(this.b)) {
                    this.q.y = true;
                }
                this.q.z = this.n.get();
                this.r = this.q.a();
                if (!this.q.i && this.r.c < 500) {
                    af.b(this.v);
                } else if (!(!p.h() || this.v == null || this.v.b())) {
                    af.a(this.v);
                }
                i = (int) (((long) this.f) - (SystemClock.elapsedRealtime() - elapsedRealtime));
                Object obj = ((this.r.a == 0 && this.r.c >= 200 && this.r.c < 400) || this.r.a == -20 || this.r.a == -300 || this.r.a == -306 || i2 == size - 1 || i <= 200) ? 1 : null;
                if (obj == null && this.r.a == -4) {
                    int a2 = v.a("direct_nonet_retry_gap", 0, 10000, 3000);
                    long j = this.q.w;
                    if (j >= ((long) a2)) {
                        obj = 1;
                    } else {
                        SystemClock.sleep((long) cg.a((int) (((long) a2) - j), 200, a2, 200));
                    }
                }
                if (obj != null) {
                    break;
                }
                a(true);
                i2++;
            }
            return this.r;
        } catch (MalformedURLException e2) {
            this.r.a = -300;
            return this.r;
        }
    }
}
