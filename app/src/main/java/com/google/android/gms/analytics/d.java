package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.p;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.analytics.internal.s;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.ai;
import com.google.android.gms.c.aj;
import com.google.android.gms.c.ak;
import com.google.android.gms.c.al;
import com.google.android.gms.c.am;
import com.google.android.gms.c.an;
import com.google.android.gms.c.ao;
import com.google.android.gms.c.ap;
import com.google.android.gms.c.aq;
import com.google.android.gms.c.ar;
import com.google.android.gms.c.e;
import com.google.android.gms.c.f;
import com.google.android.gms.c.g;
import com.google.android.gms.c.h;
import com.google.android.gms.common.internal.w;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d extends n implements ai {
    private static DecimalFormat aIo;
    private final q aHf;
    private final String aIp;
    private final Uri aIq;
    private final boolean aIr;
    private final boolean aIs;

    public d(q qVar, String str) {
        this(qVar, str, (byte) 0);
    }

    private d(q qVar, String str, byte b) {
        super(qVar);
        w.aM(str);
        this.aHf = qVar;
        this.aIp = str;
        this.aIr = true;
        this.aIs = false;
        this.aIq = aG(this.aIp);
    }

    private static void a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, f(d));
        }
    }

    private static void a(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    public static Uri aG(String str) {
        w.aM(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    private static void b(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static Map<String, String> c(ae aeVar) {
        CharSequence l;
        Map hashMap = new HashMap();
        g gVar = (g) aeVar.a(g.class);
        if (gVar != null) {
            for (Entry entry : Collections.unmodifiableMap(gVar.aFb).entrySet()) {
                Object obj;
                Boolean value = entry.getValue();
                if (value == null) {
                    obj = null;
                } else if (value instanceof String) {
                    String str = (String) value;
                    if (TextUtils.isEmpty(str)) {
                        obj = null;
                    }
                } else if (value instanceof Double) {
                    Double d = (Double) value;
                    obj = d.doubleValue() != 0.0d ? f(d.doubleValue()) : null;
                } else {
                    obj = value instanceof Boolean ? value != Boolean.FALSE ? "1" : null : String.valueOf(value);
                }
                if (obj != null) {
                    hashMap.put(entry.getKey(), obj);
                }
            }
        }
        h hVar = (h) aeVar.a(h.class);
        if (hVar != null) {
            b(hashMap, "t", hVar.aWo);
            b(hashMap, "cid", hVar.aGm);
            b(hashMap, "uid", hVar.aWp);
            b(hashMap, "sc", hVar.aWs);
            a(hashMap, "sf", hVar.aWu);
            a(hashMap, "ni", hVar.aWt);
            b(hashMap, "adid", hVar.aWq);
            a(hashMap, "ate", hVar.aWr);
        }
        ap apVar = (ap) aeVar.a(ap.class);
        if (apVar != null) {
            b(hashMap, "cd", apVar.aYT);
            a(hashMap, "a", (double) apVar.aYU);
            b(hashMap, "dr", apVar.aYX);
        }
        an anVar = (an) aeVar.a(an.class);
        if (anVar != null) {
            b(hashMap, "ec", anVar.st);
            b(hashMap, "ea", anVar.aOB);
            b(hashMap, "el", anVar.aYP);
            a(hashMap, "ev", (double) anVar.aYQ);
        }
        ak akVar = (ak) aeVar.a(ak.class);
        if (akVar != null) {
            b(hashMap, "cn", akVar.mName);
            b(hashMap, "cs", akVar.aYx);
            b(hashMap, "cm", akVar.aYy);
            b(hashMap, "ck", akVar.aYz);
            b(hashMap, "cc", akVar.aYA);
            b(hashMap, "ci", akVar.aEO);
            b(hashMap, "anid", akVar.aYB);
            b(hashMap, "gclid", akVar.aYC);
            b(hashMap, "dclid", akVar.aYD);
            b(hashMap, "aclid", akVar.aYE);
        }
        ao aoVar = (ao) aeVar.a(ao.class);
        if (aoVar != null) {
            b(hashMap, "exd", aoVar.aYR);
            a(hashMap, "exf", aoVar.aYS);
        }
        aq aqVar = (aq) aeVar.a(aq.class);
        if (aqVar != null) {
            b(hashMap, "sn", aqVar.aZb);
            b(hashMap, "sa", aqVar.aOB);
            b(hashMap, "st", aqVar.aZc);
        }
        ar arVar = (ar) aeVar.a(ar.class);
        if (arVar != null) {
            b(hashMap, "utv", arVar.aZd);
            a(hashMap, "utt", (double) arVar.aZe);
            b(hashMap, "utc", arVar.st);
            b(hashMap, "utl", arVar.aYP);
        }
        e eVar = (e) aeVar.a(e.class);
        if (eVar != null) {
            for (Entry entry2 : Collections.unmodifiableMap(eVar.aWm).entrySet()) {
                l = e.l("cd", ((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(l)) {
                    hashMap.put(l, entry2.getValue());
                }
            }
        }
        f fVar = (f) aeVar.a(f.class);
        if (fVar != null) {
            for (Entry entry22 : Collections.unmodifiableMap(fVar.aWn).entrySet()) {
                l = e.l("cm", ((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(l)) {
                    hashMap.put(l, f(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        am amVar = (am) aeVar.a(am.class);
        if (amVar != null) {
            b bVar = amVar.aYO;
            if (bVar != null) {
                for (Entry entry3 : new HashMap(bVar.aEN).entrySet()) {
                    if (((String) entry3.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry3.getKey()).substring(1), entry3.getValue());
                    } else {
                        hashMap.put(entry3.getKey(), entry3.getValue());
                    }
                }
            }
            int i = 1;
            for (c an : Collections.unmodifiableList(amVar.aYM)) {
                hashMap.putAll(an.an(e.l("promo", i)));
                i++;
            }
            i = 1;
            for (a an2 : Collections.unmodifiableList(amVar.aYL)) {
                hashMap.putAll(an2.an(e.l("pr", i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry32 : amVar.aYN.entrySet()) {
                List<a> list = (List) entry32.getValue();
                String l2 = e.l("il", i2);
                i = 1;
                for (a an3 : list) {
                    hashMap.putAll(an3.an(l2 + e.l("pi", i)));
                    i++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry32.getKey())) {
                    hashMap.put(l2 + "nm", entry32.getKey());
                }
                i2++;
            }
        }
        al alVar = (al) aeVar.a(al.class);
        if (alVar != null) {
            b(hashMap, "ul", alVar.aYF);
            a(hashMap, "sd", (double) alVar.aYG);
            a(hashMap, "sr", alVar.aYH, alVar.aYI);
            a(hashMap, "vp", alVar.aYJ, alVar.aYK);
        }
        aj ajVar = (aj) aeVar.a(aj.class);
        if (ajVar != null) {
            b(hashMap, "an", ajVar.aEW);
            b(hashMap, "aid", ajVar.aYv);
            b(hashMap, "aiid", ajVar.aYw);
            b(hashMap, "av", ajVar.aEX);
        }
        return hashMap;
    }

    private static String f(double d) {
        if (aIo == null) {
            aIo = new DecimalFormat("0.######");
        }
        return aIo.format(d);
    }

    public final void b(ae aeVar) {
        w.ag(aeVar);
        w.e(aeVar.aYa, "Can't deliver not submitted measurement");
        w.aO("deliver should be called on worker thread");
        ae pN = aeVar.pN();
        h hVar = (h) pN.b(h.class);
        if (TextUtils.isEmpty(hVar.aWo)) {
            this.aFo.mS().a(c(pN), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(hVar.aGm)) {
            this.aFo.mS().a(c(pN), "Ignoring measurement without client id");
        } else if (!this.aHf.mV().aEM) {
            double d = hVar.aWu;
            if (k.a(d, hVar.aGm)) {
                d("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
                return;
            }
            Map c = c(pN);
            c.put("v", "1");
            c.put("_v", p.aFT);
            c.put("tid", this.aIp);
            if (this.aHf.mV().aEL) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Entry entry : c.entrySet()) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                }
                a(4, "Dry run is enabled. GoogleAnalytics would have sent", stringBuilder.toString(), null, null);
                return;
            }
            Map hashMap = new HashMap();
            k.a(hashMap, "uid", hVar.aWp);
            aj ajVar = (aj) aeVar.a(aj.class);
            if (ajVar != null) {
                k.a(hashMap, "an", ajVar.aEW);
                k.a(hashMap, "aid", ajVar.aYv);
                k.a(hashMap, "av", ajVar.aEX);
                k.a(hashMap, "aiid", ajVar.aYw);
            }
            c.put("_s", String.valueOf(this.aFo.mU().a(new s(0, hVar.aGm, this.aIp, !TextUtils.isEmpty(hVar.aWq), 0, hashMap))));
            this.aFo.mU().c(new com.google.android.gms.analytics.internal.c(this.aFo.mS(), c, aeVar.aYb));
        }
    }

    public final Uri nL() {
        return this.aIq;
    }
}
