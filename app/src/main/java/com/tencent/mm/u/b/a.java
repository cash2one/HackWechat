package com.tencent.mm.u.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class a extends b<JSONObject, JSONObject> implements e {
    public a(String str, int i) {
        super(str, i);
    }

    public final JSONObject a(boolean z, String str, Map<String, ? extends Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(":");
        stringBuilder.append(z ? "ok" : "fail");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(":");
            stringBuilder.append(bh.ou(str));
        }
        Map hashMap = new HashMap();
        hashMap.put("errMsg", stringBuilder.toString());
        if (map != null) {
            hashMap.putAll(map);
        }
        m(hashMap);
        return new JSONObject(hashMap);
    }

    public final JSONObject a(boolean z, String str, Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(":");
        stringBuilder.append(z ? "ok" : "fail");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(":");
            stringBuilder.append(bh.ou(str));
        }
        Map hashMap = new HashMap();
        hashMap.put("errMsg", stringBuilder.toString());
        if (bundle != null) {
            Set<String> keySet = bundle.keySet();
            if (!(keySet == null || keySet.isEmpty())) {
                for (String str2 : keySet) {
                    hashMap.put(str2, bundle.get(str2));
                }
            }
        }
        m(hashMap);
        return new JSONObject(hashMap);
    }

    private static void m(Map map) {
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                m((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
    }
}
