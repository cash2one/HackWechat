package com.tencent.b.a.a;

import org.json.JSONObject;

class i$1 implements Runnable {
    final /* synthetic */ i bpy;
    private final /* synthetic */ String bpz;

    public i$1(i iVar, String str) {
        this.bpy = iVar;
        this.bpz = str;
    }

    public final void run() {
        try {
            new StringBuilder("receive data:").append(this.bpz);
            int i = 100;
            int i2 = 3;
            if (s.bJ(this.bpz)) {
                JSONObject jSONObject = new JSONObject(this.bpz);
                if (!jSONObject.isNull("mid")) {
                    String optString = jSONObject.optString("mid");
                    if (s.bK(optString) && !s.bK(this.bpy.sK())) {
                        i.a(this.bpy).bpr = optString;
                        i.a(this.bpy).bpq = s.ac(i.sM());
                        i.a(this.bpy).bjM = s.ab(i.sM());
                        if (jSONObject.isNull("ts")) {
                            i.a(this.bpy).bps = System.currentTimeMillis();
                        } else {
                            long optLong = jSONObject.optLong("ts");
                            if (optLong > 0) {
                                i.a(this.bpy).bps = optLong;
                            }
                        }
                        new StringBuilder("new mid midEntity:").append(i.a(this.bpy).toString());
                        r.Z(i.sM()).b(i.a(this.bpy));
                    }
                }
                if (!jSONObject.isNull(a.boZ)) {
                    i = jSONObject.getInt(a.boZ);
                }
                if (!jSONObject.isNull(a.bpa)) {
                    i2 = jSONObject.getInt(a.bpa);
                }
                j.bpA = jSONObject.optInt("disable", 0);
                j.bpB = jSONObject.optInt("limit", 0);
            }
            r Z = r.Z(i.sM());
            a sQ = Z.sQ();
            if (i > 0) {
                sQ.boV = i;
            }
            if (i2 > 0) {
                sQ.boW = i2;
            }
            sQ.boT = System.currentTimeMillis();
            sQ.boU = 0;
            Z.b(sQ);
        } catch (Throwable th) {
        }
    }
}
