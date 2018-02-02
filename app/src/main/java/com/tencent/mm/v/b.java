package com.tencent.mm.v;

import android.annotation.TargetApi;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a {
    private JSONArray gOX;

    public b() {
        this.gOX = new JSONArray();
    }

    public b(String str) {
        try {
            this.gOX = new JSONArray(str);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    b(JSONArray jSONArray) {
        Assert.assertNotNull(jSONArray);
        this.gOX = jSONArray;
    }

    public final int length() {
        return this.gOX.length();
    }

    public final a bt(boolean z) {
        this.gOX.put(z);
        return this;
    }

    public final a g(double d) {
        try {
            this.gOX.put(d);
            return this;
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final a go(int i) {
        this.gOX.put(i);
        return this;
    }

    public final a aE(long j) {
        this.gOX.put(j);
        return this;
    }

    public final a ax(Object obj) {
        this.gOX.put(obj);
        return this;
    }

    public final boolean isNull(int i) {
        return this.gOX.isNull(i);
    }

    public final Object get(int i) {
        try {
            Object obj = this.gOX.get(i);
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

    public final Object opt(int i) {
        Object opt = this.gOX.opt(i);
        if (opt instanceof JSONObject) {
            return new d((JSONObject) opt);
        }
        if (opt instanceof JSONArray) {
            return new b((JSONArray) opt);
        }
        return opt;
    }

    @TargetApi(19)
    public final Object remove(int i) {
        Object remove = this.gOX.remove(i);
        if (remove instanceof JSONObject) {
            return new d((JSONObject) remove);
        }
        if (remove instanceof JSONArray) {
            return new b((JSONArray) remove);
        }
        return remove;
    }

    public final boolean getBoolean(int i) {
        try {
            return this.gOX.getBoolean(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final boolean optBoolean(int i) {
        return this.gOX.optBoolean(i);
    }

    public final boolean optBoolean(int i, boolean z) {
        return this.gOX.optBoolean(i, z);
    }

    public final double getDouble(int i) {
        try {
            return this.gOX.getDouble(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final double optDouble(int i) {
        return this.gOX.optDouble(i);
    }

    public final double optDouble(int i, double d) {
        return this.gOX.optDouble(i, d);
    }

    public final int getInt(int i) {
        try {
            return this.gOX.getInt(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final int optInt(int i) {
        return this.gOX.optInt(i);
    }

    public final int optInt(int i, int i2) {
        return this.gOX.optInt(i, i2);
    }

    public final long getLong(int i) {
        try {
            return this.gOX.getLong(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final long optLong(int i) {
        return this.gOX.optLong(i);
    }

    public final long optLong(int i, long j) {
        return this.gOX.optLong(i, j);
    }

    public final String getString(int i) {
        try {
            return this.gOX.getString(i);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final String optString(int i) {
        return this.gOX.optString(i);
    }

    public final String optString(int i, String str) {
        return this.gOX.optString(i, str);
    }

    public final a gp(int i) {
        try {
            JSONArray jSONArray = this.gOX.getJSONArray(i);
            if (jSONArray == null) {
                return null;
            }
            return new b(jSONArray);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final a gq(int i) {
        JSONArray optJSONArray = this.gOX.optJSONArray(i);
        if (optJSONArray == null) {
            return null;
        }
        return new b(optJSONArray);
    }

    public final c gr(int i) {
        try {
            JSONObject jSONObject = this.gOX.getJSONObject(i);
            if (jSONObject == null) {
                return null;
            }
            return new d(jSONObject);
        } catch (Throwable e) {
            throw new f(e);
        }
    }

    public final c gs(int i) {
        JSONObject optJSONObject = this.gOX.optJSONObject(i);
        if (optJSONObject == null) {
            return null;
        }
        return new d(optJSONObject);
    }
}
