package com.tencent.b.a.a;

import android.content.Context;
import com.tencent.b.a.a.b.a;
import org.json.JSONArray;
import org.json.JSONObject;

final class m {
    private int bpC = 0;
    private JSONObject bpD = null;
    protected Context context = null;

    m(Context context, JSONObject jSONObject) {
        this.context = context;
        this.bpC = (int) (System.currentTimeMillis() / 1000);
        this.bpD = jSONObject;
    }

    final JSONObject sN() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ky", "AVF4T76RVR81");
            jSONObject.put("et", 2);
            jSONObject.put("ts", this.bpC);
            jSONObject.put("si", this.bpC);
            s.a(jSONObject, "ui", s.ab(this.context));
            s.a(jSONObject, "mc", s.ac(this.context));
            String sL = i.X(this.context).sL();
            if (s.bK(sL)) {
                jSONObject.put("mid", sL);
            } else {
                jSONObject.put("mid", "0");
            }
            b bVar = new b(this.context);
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (b.bpb != null) {
                    a aVar = b.bpb;
                    jSONObject2.put("sr", new StringBuilder(String.valueOf(aVar.bpg.widthPixels)).append("*").append(aVar.bpg.heightPixels).toString());
                    s.a(jSONObject2, "av", aVar.bpe);
                    s.a(jSONObject2, "ch", aVar.bpj);
                    s.a(jSONObject2, "mf", aVar.bpi);
                    s.a(jSONObject2, "sv", aVar.bpf);
                    s.a(jSONObject2, "ov", Integer.toString(aVar.bph));
                    jSONObject2.put("os", 1);
                    s.a(jSONObject2, "op", aVar.bpk);
                    s.a(jSONObject2, "lg", aVar.ael);
                    s.a(jSONObject2, "md", aVar.model);
                    s.a(jSONObject2, "tz", aVar.timezone);
                    if (aVar.bpm != 0) {
                        jSONObject2.put("jb", aVar.bpm);
                    }
                    s.a(jSONObject2, "sd", aVar.bpl);
                    s.a(jSONObject2, "apn", aVar.packageName);
                    if (s.aa(aVar.ctx)) {
                        JSONObject jSONObject3 = new JSONObject();
                        s.a(jSONObject3, "bs", s.ad(aVar.ctx));
                        s.a(jSONObject3, "ss", s.ae(aVar.ctx));
                        if (jSONObject3.length() > 0) {
                            s.a(jSONObject2, "wf", jSONObject3.toString());
                        }
                    }
                    JSONArray af = s.af(aVar.ctx);
                    if (af != null && af.length() > 0) {
                        s.a(jSONObject2, "wflist", af.toString());
                    }
                    s.a(jSONObject2, "ram", aVar.bpn);
                    s.a(jSONObject2, "rom", aVar.bpo);
                    s.a(jSONObject2, "im", aVar.imsi);
                }
                s.a(jSONObject2, "cn", bVar.bpd);
                if (bVar.bpc != null) {
                    jSONObject2.put("tn", bVar.bpc);
                }
                jSONObject.put("ev", jSONObject2);
            } catch (Throwable th) {
            }
            if (this.bpD != null) {
                jSONObject.put("ext", this.bpD);
            }
        } catch (Throwable th2) {
        }
        return jSONObject;
    }
}
