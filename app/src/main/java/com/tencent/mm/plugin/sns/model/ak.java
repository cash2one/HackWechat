package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class ak<K, O> {
    private int maxSize;
    Map<K, b<O>> qWZ = null;
    private a qXa = null;

    public interface a {
        boolean bI(Object obj);
    }

    public ak(int i, a aVar) {
        this.maxSize = i;
        this.qWZ = new HashMap();
        this.qXa = aVar;
    }

    public final void bvS() {
        if (this.qWZ.size() > this.maxSize) {
            Object arrayList = new ArrayList(this.qWZ.entrySet());
            Collections.sort(arrayList, new 1(this));
            int size = this.qWZ.size() - this.maxSize;
            if (size > 0) {
                Iterator it = arrayList.iterator();
                int i = size;
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (this.qXa.bI(entry.getKey())) {
                        x.d("MicroMsg.SnsLRUMap", " remove targetKey: " + entry.getKey());
                        size = i - 1;
                    } else {
                        size = i;
                    }
                    if (size > 0) {
                        i = size;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
