package com.tencent.mm.v;

import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends JSONObject implements c {
    private final c gPc;

    public final /* synthetic */ c C(String str, int i) {
        return D(str, i);
    }

    public final /* synthetic */ c a(String str, double d) {
        return b(str, d);
    }

    public final /* synthetic */ a fu(String str) {
        return fB(str);
    }

    public final /* synthetic */ a fv(String str) {
        return fC(str);
    }

    public final /* synthetic */ c fw(String str) {
        return fD(str);
    }

    public final /* synthetic */ c fx(String str) {
        return fE(str);
    }

    public final /* synthetic */ JSONArray getJSONArray(String str) {
        return fB(str);
    }

    public final /* synthetic */ JSONObject getJSONObject(String str) {
        return fD(str);
    }

    public final /* synthetic */ c i(String str, long j) {
        return j(str, j);
    }

    public final /* synthetic */ c k(String str, Object obj) {
        return m(str, obj);
    }

    public final /* synthetic */ c l(String str, Object obj) {
        return n(str, obj);
    }

    public final /* synthetic */ c n(String str, boolean z) {
        return o(str, z);
    }

    public final /* synthetic */ JSONArray optJSONArray(String str) {
        return fC(str);
    }

    public final /* synthetic */ JSONObject optJSONObject(String str) {
        return fE(str);
    }

    public final /* synthetic */ JSONObject put(String str, double d) {
        return b(str, d);
    }

    public final /* synthetic */ JSONObject put(String str, int i) {
        return D(str, i);
    }

    public final /* synthetic */ JSONObject put(String str, long j) {
        return j(str, j);
    }

    public final /* synthetic */ JSONObject put(String str, Object obj) {
        return m(str, obj);
    }

    public final /* synthetic */ JSONObject put(String str, boolean z) {
        return o(str, z);
    }

    public final /* synthetic */ JSONObject putOpt(String str, Object obj) {
        return n(str, obj);
    }

    public h() {
        this.gPc = g.Cd();
    }

    public h(c cVar) {
        Assert.assertNotNull(cVar);
        this.gPc = cVar;
    }

    public h(Map map) {
        this.gPc = g.n(map);
    }

    public h(String str) {
        this.gPc = g.fz(str);
    }

    public final int length() {
        return this.gPc.length();
    }

    private h o(String str, boolean z) {
        this.gPc.n(str, z);
        return this;
    }

    private h b(String str, double d) {
        this.gPc.a(ft(str), d);
        return this;
    }

    private h D(String str, int i) {
        this.gPc.C(ft(str), i);
        return this;
    }

    private h j(String str, long j) {
        this.gPc.i(ft(str), j);
        return this;
    }

    private h m(String str, Object obj) {
        this.gPc.k(str, obj);
        return this;
    }

    private h n(String str, Object obj) {
        this.gPc.l(str, obj);
        return this;
    }

    public final String ft(String str) {
        return this.gPc.ft(str);
    }

    public final Object remove(String str) {
        return this.gPc.remove(str);
    }

    public final boolean isNull(String str) {
        return this.gPc.isNull(str);
    }

    public final boolean has(String str) {
        return this.gPc.has(str);
    }

    public final Object get(String str) {
        return this.gPc.get(str);
    }

    public final Object opt(String str) {
        return this.gPc.opt(str);
    }

    public final boolean getBoolean(String str) {
        return this.gPc.getBoolean(str);
    }

    public final boolean optBoolean(String str) {
        return this.gPc.optBoolean(str, false);
    }

    public final boolean optBoolean(String str, boolean z) {
        return this.gPc.optBoolean(str, z);
    }

    public final double getDouble(String str) {
        return this.gPc.getDouble(str);
    }

    public final double optDouble(String str) {
        return this.gPc.optDouble(str, Double.NaN);
    }

    public final double optDouble(String str, double d) {
        return this.gPc.optDouble(str, d);
    }

    public final int getInt(String str) {
        return this.gPc.getInt(str);
    }

    public final int optInt(String str) {
        return this.gPc.optInt(str, 0);
    }

    public final int optInt(String str, int i) {
        return this.gPc.optInt(str, i);
    }

    public final long getLong(String str) {
        return this.gPc.getLong(str);
    }

    public final long optLong(String str) {
        return this.gPc.optLong(str, 0);
    }

    public final long optLong(String str, long j) {
        return this.gPc.optLong(str, j);
    }

    public final String getString(String str) {
        return this.gPc.getString(str);
    }

    public final String optString(String str) {
        return this.gPc.optString(str, "");
    }

    public final String optString(String str, String str2) {
        return this.gPc.optString(str);
    }

    private e fB(String str) {
        a fu = this.gPc.fu(str);
        if (fu == null) {
            return null;
        }
        return new e(fu);
    }

    private e fC(String str) {
        a fv = this.gPc.fv(str);
        if (fv == null) {
            return null;
        }
        return new e(fv);
    }

    private h fD(String str) {
        c fw = this.gPc.fw(str);
        if (fw == null) {
            return null;
        }
        return new h(fw);
    }

    private h fE(String str) {
        c fx = this.gPc.fx(str);
        if (fx == null) {
            return null;
        }
        return new h(fx);
    }

    public final Iterator<String> keys() {
        return this.gPc.keys();
    }

    public final String toString() {
        return this.gPc.toString();
    }
}
