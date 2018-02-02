package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

public final class e {
    public Map<String, Object> kIN = new HashMap();
    public CardInfo kIm = null;

    public e() {
        this.kIN.clear();
    }

    public final void putValue(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.kIN.put(str, obj);
        }
    }

    public final Object getValue(String str) {
        if (!TextUtils.isEmpty(str) && this.kIN.containsKey(str)) {
            return this.kIN.get(str);
        }
        return null;
    }
}
