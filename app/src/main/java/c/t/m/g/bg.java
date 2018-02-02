package c.t.m.g;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public final class bg {
    public Map<String, Object> a = new HashMap();

    public final byte[] a() {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : this.a.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Exception e) {
            }
        }
        return jSONObject.toString().getBytes();
    }
}
