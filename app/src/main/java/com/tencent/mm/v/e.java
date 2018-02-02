package com.tencent.mm.v;

import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends JSONArray implements a {
    private final a gOZ;

    public final /* synthetic */ a aE(long j) {
        return aF(j);
    }

    public final /* synthetic */ a ax(Object obj) {
        return ay(obj);
    }

    public final /* synthetic */ a bt(boolean z) {
        return bu(z);
    }

    public final /* synthetic */ a g(double d) {
        return h(d);
    }

    public final /* synthetic */ JSONArray getJSONArray(int i) {
        return gu(i);
    }

    public final /* synthetic */ JSONObject getJSONObject(int i) {
        return gw(i);
    }

    public final /* synthetic */ a go(int i) {
        return gt(i);
    }

    public final /* synthetic */ a gp(int i) {
        return gu(i);
    }

    public final /* synthetic */ a gq(int i) {
        return gv(i);
    }

    public final /* synthetic */ c gr(int i) {
        return gw(i);
    }

    public final /* synthetic */ c gs(int i) {
        return gx(i);
    }

    public final /* synthetic */ JSONArray optJSONArray(int i) {
        return gv(i);
    }

    public final /* synthetic */ JSONObject optJSONObject(int i) {
        return gx(i);
    }

    public final /* synthetic */ JSONArray put(double d) {
        return h(d);
    }

    public final /* synthetic */ JSONArray put(int i) {
        return gt(i);
    }

    public final /* synthetic */ JSONArray put(int i, double d) {
        this.gOZ.g(d);
        return this;
    }

    public final /* synthetic */ JSONArray put(int i, int i2) {
        this.gOZ.go(i2);
        return this;
    }

    public final /* synthetic */ JSONArray put(int i, long j) {
        this.gOZ.aE(j);
        return this;
    }

    public final /* synthetic */ JSONArray put(int i, Object obj) {
        this.gOZ.ax(obj);
        return this;
    }

    public final /* synthetic */ JSONArray put(int i, boolean z) {
        this.gOZ.bt(z);
        return this;
    }

    public final /* synthetic */ JSONArray put(long j) {
        return aF(j);
    }

    public final /* synthetic */ JSONArray put(Object obj) {
        return ay(obj);
    }

    public final /* synthetic */ JSONArray put(boolean z) {
        return bu(z);
    }

    public e() {
        this.gOZ = g.Ce();
    }

    e(a aVar) {
        Assert.assertNotNull(aVar);
        this.gOZ = aVar;
    }

    public final int length() {
        return this.gOZ.length();
    }

    private e bu(boolean z) {
        this.gOZ.bt(z);
        return this;
    }

    private e h(double d) {
        this.gOZ.g(d);
        return this;
    }

    private e gt(int i) {
        this.gOZ.go(i);
        return this;
    }

    private e aF(long j) {
        this.gOZ.aE(j);
        return this;
    }

    private e ay(Object obj) {
        this.gOZ.ax(obj);
        return this;
    }

    public final boolean isNull(int i) {
        return this.gOZ.isNull(i);
    }

    public final Object get(int i) {
        return this.gOZ.get(i);
    }

    public final Object opt(int i) {
        return this.gOZ.opt(i);
    }

    public final Object remove(int i) {
        return this.gOZ.remove(i);
    }

    public final boolean getBoolean(int i) {
        return this.gOZ.getBoolean(i);
    }

    public final boolean optBoolean(int i) {
        return this.gOZ.optBoolean(i);
    }

    public final boolean optBoolean(int i, boolean z) {
        return this.gOZ.optBoolean(i, z);
    }

    public final double getDouble(int i) {
        return this.gOZ.getDouble(i);
    }

    public final double optDouble(int i) {
        return this.gOZ.optDouble(i);
    }

    public final double optDouble(int i, double d) {
        return this.gOZ.optDouble(i, d);
    }

    public final int getInt(int i) {
        return this.gOZ.getInt(i);
    }

    public final int optInt(int i) {
        return this.gOZ.optInt(i);
    }

    public final int optInt(int i, int i2) {
        return this.gOZ.optInt(i, i2);
    }

    public final long getLong(int i) {
        return this.gOZ.getLong(i);
    }

    public final long optLong(int i) {
        return this.gOZ.optLong(i);
    }

    public final long optLong(int i, long j) {
        return this.gOZ.optLong(i, j);
    }

    public final String getString(int i) {
        return this.gOZ.getString(i);
    }

    public final String optString(int i) {
        return this.gOZ.optString(i);
    }

    public final String optString(int i, String str) {
        return this.gOZ.optString(i, str);
    }

    private e gu(int i) {
        return new e(this.gOZ.gp(i));
    }

    private e gv(int i) {
        return new e(this.gOZ.gq(i));
    }

    private h gw(int i) {
        return new h(this.gOZ.gr(i));
    }

    private h gx(int i) {
        return new h(this.gOZ.gs(i));
    }
}
