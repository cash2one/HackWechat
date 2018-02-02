package com.tencent.b.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class a {
    public static String boX = "ts";
    public static String boY = "times";
    public static String boZ = "mfreq";
    public static String bpa = "mdays";
    long boT = 0;
    int boU = 0;
    int boV = 100;
    int boW = 3;

    a() {
    }

    a(String str) {
        if (s.bJ(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(boX)) {
                    this.boT = jSONObject.getLong(boX);
                }
                if (!jSONObject.isNull(boZ)) {
                    this.boV = jSONObject.getInt(boZ);
                }
                if (!jSONObject.isNull(boY)) {
                    this.boU = jSONObject.getInt(boY);
                }
                if (!jSONObject.isNull(bpa)) {
                    this.boW = jSONObject.getInt(bpa);
                }
            } catch (JSONException e) {
            }
        }
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(boX, this.boT);
            jSONObject.put(boY, this.boU);
            jSONObject.put(boZ, this.boV);
            jSONObject.put(bpa, this.boW);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
