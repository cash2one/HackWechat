package com.tencent.mm.z;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class bq {
    public static bq hhK = new bq();
    private SharedPreferences hhL = ac.getContext().getSharedPreferences(ac.cfs() + "_account_history", 0);
    private SharedPreferences hhM = ac.getContext().getSharedPreferences(ac.cfs() + "_account_switch", 0);

    private bq() {
    }

    public final void j(String str, String str2, String str3) {
        try {
            JSONObject jSONObject;
            if (this.hhL.contains(str)) {
                String string = this.hhL.getString(str, "");
                if (bh.ov(string)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(new String(Base64.decode(string, 0)));
                }
            } else {
                jSONObject = new JSONObject();
            }
            if (!bh.G(str2, str3)) {
                jSONObject.put(str2, str3);
                x.i("MicroMsg.SwitchAccountInfo", "put key %s, jsonStr %s", str2, jSONObject.toString());
                this.hhL.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SwitchAccountInfo", "save account info %s about %s failed, error: %s", str2, str, e.getMessage());
        }
    }

    public final void c(String str, Map<String, String> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject;
                    if (this.hhL.contains(str)) {
                        String string = this.hhL.getString(str, "");
                        if (bh.ov(string)) {
                            jSONObject = new JSONObject();
                        } else {
                            jSONObject = new JSONObject(new String(Base64.decode(string, 0)));
                        }
                    } else {
                        jSONObject = new JSONObject();
                    }
                    for (String str2 : map.keySet()) {
                        jSONObject.put(str2, map.get(str2));
                    }
                    x.i("MicroMsg.SwitchAccountInfo", "put json str %s", jSONObject.toString());
                    this.hhL.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.SwitchAccountInfo", "save account info about %s failed, error: %s", str, e.getMessage());
                return;
            }
        }
        x.i("MicroMsg.SwitchAccountInfo", "kv map is null or empty!");
    }

    public final String getString(String str, String str2) {
        try {
            x.i("MicroMsg.SwitchAccountInfo", "get %s, %s", str, str2);
            if (this.hhL.contains(str)) {
                String str3 = new String(Base64.decode(this.hhL.getString(str, ""), 0));
                if (!bh.ov(str3)) {
                    x.i("MicroMsg.SwitchAccountInfo", "get json str %s", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.has(str2)) {
                        return jSONObject.getString(str2);
                    }
                }
            }
            x.w("MicroMsg.SwitchAccountInfo", "account info about %s is not found!", str);
        } catch (Exception e) {
            x.e("MicroMsg.SwitchAccountInfo", "get account info %s about %s failed, error: %s", str2, str, e.getMessage());
        }
        return "";
    }

    public final void hZ(String str) {
        if (ia(str)) {
            Set stringSet = this.hhM.getStringSet("first_switch_group", null);
            if (stringSet != null) {
                stringSet.remove(str);
                this.hhM.edit().remove("first_switch_group").apply();
                this.hhM.edit().putStringSet("first_switch_group", stringSet).commit();
            }
        }
        if (ib(str) && this.hhL.contains(str)) {
            this.hhL.edit().remove(str).commit();
        }
    }

    public final void V(String str, String str2) {
        if (!bh.G(str, str2) && !str.equals(str2)) {
            Set stringSet = this.hhM.getStringSet("first_switch_group", null);
            if (stringSet == null) {
                stringSet = new HashSet();
            }
            if (!stringSet.contains(str) || stringSet.size() >= 2) {
                stringSet.clear();
                stringSet.add(str);
                stringSet.add(str2);
            } else {
                stringSet.add(str2);
            }
            this.hhM.edit().remove("first_switch_group").apply();
            this.hhM.edit().putStringSet("first_switch_group", stringSet).commit();
        }
    }

    public final boolean ia(String str) {
        Set stringSet = this.hhM.getStringSet("first_switch_group", null);
        if (stringSet == null) {
            return false;
        }
        return stringSet.contains(str);
    }

    public final boolean ib(String str) {
        return this.hhL.contains(str);
    }

    public final Set<String> HV() {
        Set<String> hashSet = new HashSet();
        Collection stringSet = this.hhM.getStringSet("first_switch_group", null);
        if (!(stringSet == null || stringSet.isEmpty())) {
            hashSet.addAll(stringSet);
        }
        return hashSet;
    }
}
