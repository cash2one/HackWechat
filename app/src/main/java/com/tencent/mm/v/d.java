package com.tencent.mm.v;

import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements c {
    private JSONObject gOY;

    public d() {
        this.gOY = new JSONObject();
    }

    public d(Map map) {
        this.gOY = new JSONObject(map);
    }

    public d(String str) {
        try {
            this.gOY = new JSONObject(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    d(JSONObject jSONObject) {
        Assert.assertNotNull(jSONObject);
        this.gOY = jSONObject;
    }

    public final int length() {
        return this.gOY.length();
    }

    public final c n(String str, boolean z) {
        try {
            this.gOY.put(str, z);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c a(String str, double d) {
        try {
            this.gOY.put(str, d);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c C(String str, int i) {
        try {
            this.gOY.put(str, i);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c i(String str, long j) {
        try {
            this.gOY.put(str, j);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c k(String str, Object obj) {
        try {
            this.gOY.put(str, obj);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c l(String str, Object obj) {
        try {
            this.gOY.put(str, obj);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final String ft(String str) {
        if (str != null) {
            return str;
        }
        throw new f("Names must be non-null");
    }

    public final Object remove(String str) {
        return this.gOY.remove(str);
    }

    public final boolean isNull(String str) {
        return this.gOY.isNull(str);
    }

    public final boolean has(String str) {
        return this.gOY.has(str);
    }

    public final Object get(String str) {
        try {
            Object obj = this.gOY.get(str);
            if (obj instanceof JSONObject) {
                return new d((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                return new b((JSONArray) obj);
            }
            return obj;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final Object opt(String str) {
        try {
            Object obj = this.gOY.get(str);
            if (obj instanceof JSONObject) {
                return new d((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                return new b((JSONArray) obj);
            }
            return obj;
        } catch (JSONException e) {
            return null;
        }
    }

    public final boolean getBoolean(String str) {
        try {
            return this.gOY.getBoolean(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final boolean optBoolean(String str, boolean z) {
        return this.gOY.optBoolean(str, z);
    }

    public final double getDouble(String str) {
        try {
            return this.gOY.getDouble(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final double optDouble(String str, double d) {
        return this.gOY.optDouble(str, d);
    }

    public final int getInt(String str) {
        try {
            return this.gOY.getInt(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final int optInt(String str, int i) {
        return this.gOY.optInt(str, i);
    }

    public final long getLong(String str) {
        try {
            return this.gOY.getLong(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final long optLong(String str, long j) {
        return this.gOY.optLong(str, j);
    }

    public final String getString(String str) {
        try {
            return this.gOY.getString(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final String optString(String str) {
        return this.gOY.optString(str);
    }

    public final String optString(String str, String str2) {
        return this.gOY.optString(str, str2);
    }

    public final a fu(String str) {
        try {
            JSONArray jSONArray = this.gOY.getJSONArray(str);
            if (jSONArray == null) {
                return null;
            }
            return new b(jSONArray);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final a fv(String str) {
        JSONArray optJSONArray = this.gOY.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        return new b(optJSONArray);
    }

    public final c fw(String str) {
        try {
            JSONObject jSONObject = this.gOY.getJSONObject(str);
            if (jSONObject == null) {
                return null;
            }
            return new d(jSONObject);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c fx(String str) {
        JSONObject optJSONObject = this.gOY.optJSONObject(str);
        if (optJSONObject == null) {
            return null;
        }
        return new d(optJSONObject);
    }

    public final Iterator<String> keys() {
        return this.gOY.keys();
    }

    public final String toString() {
        return this.gOY.toString();
    }
}
