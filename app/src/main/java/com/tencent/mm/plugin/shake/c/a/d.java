package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public float gyA = -1000.0f;
    public float gyz = -85.0f;
    Map<String, Object> kIN = new HashMap();
    int qol = 0;
    long qom = 0;
    String qon = "";

    public d() {
        this.kIN.clear();
    }

    public final void putValue(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.kIN.put(str, obj);
        }
    }
}
