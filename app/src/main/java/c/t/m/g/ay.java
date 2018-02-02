package c.t.m.g;

import org.json.JSONArray;
import org.json.JSONObject;

public final class ay extends ax implements s {
    bl a = new bl("HttpSchedulerClient");
    q b;

    static void a(q qVar, JSONArray jSONArray) {
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONArray optJSONArray = jSONObject.optJSONArray("domains");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("resultlist");
                String optString = jSONObject.optString("schedulecode");
                String optString2 = jSONObject.optString("httpsport");
                if (!(optJSONArray == null || optJSONArray2 == null)) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        r rVar = new r(optJSONArray.getString(i2), optString);
                        try {
                            rVar.d = Integer.parseInt(optString2);
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                String string = optJSONArray2.getString(i3);
                                n nVar = new n();
                                if (nVar.a(string)) {
                                    rVar.c.add(nVar);
                                }
                            }
                            qVar.b.put(rVar.a, rVar);
                        } catch (Throwable th) {
                        }
                    }
                    continue;
                }
                i++;
            } catch (Exception e) {
                return;
            }
        }
    }

    public final r a(String str) {
        if (this.b != null) {
            if (this.b.a.equals(p.b())) {
                return (r) this.b.b.get(str);
            }
            m.i().post(new az(this));
        }
        return null;
    }

    public final String a() {
        return "accessscheduler";
    }

    public final void a(String str, byte[] bArr, String str2) {
        this.a.a(str, bArr);
        m.i().post(new az(this));
    }

    public final void a_() {
        bx.c().a();
    }
}
