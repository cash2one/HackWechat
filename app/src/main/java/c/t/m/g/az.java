package c.t.m.g;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class az implements Runnable {
    private /* synthetic */ ay a;

    az(ay ayVar) {
        this.a = ayVar;
    }

    public final void run() {
        Object b = p.b();
        ay ayVar = this.a;
        byte[] a = this.a.a.a(b);
        try {
            if (!TextUtils.isEmpty(b) && !cg.a(a)) {
                JSONObject jSONObject = new JSONObject(new String(a));
                q qVar = new q(b);
                jSONObject.getString("ipInfo");
                jSONObject = jSONObject.optJSONObject("resultMap");
                if (jSONObject != null) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        JSONArray optJSONArray = jSONObject.optJSONArray((String) keys.next());
                        if (optJSONArray != null) {
                            ay.a(qVar, optJSONArray);
                        }
                    }
                }
                ayVar.b = qVar;
            }
        } catch (Throwable th) {
        }
    }
}
