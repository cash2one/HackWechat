package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class a$2 extends LinkedHashMap<Long, Integer> {
    a$2(int i) {
        super(i, 0.75f);
    }

    protected final boolean removeEldestEntry(Entry<Long, Integer> entry) {
        if (size() > 500 && entry != null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "remove eldest ad snsId " + entry.getKey());
        }
        return size() > 500;
    }
}
