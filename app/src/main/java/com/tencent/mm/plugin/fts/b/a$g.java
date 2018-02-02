package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class a$g extends a {
    final /* synthetic */ a mMS;
    private int[] mNj;
    private int mNk = 0;
    private int mNl = 0;

    public a$g(a aVar, int[] iArr) {
        this.mMS = aVar;
        this.mNj = iArr;
    }

    public final boolean execute() {
        List<b> e = a.a(this.mMS).e(this.mNj, 1);
        this.mNk = e.size();
        Object hashMap = new HashMap();
        for (b bVar : e) {
            String str = bVar.mLs;
            if (!a.b(this.mMS).containsKey(str)) {
                List list = (List) hashMap.get(str);
                if (list == null) {
                    list = new ArrayList(16);
                    hashMap.put(str, list);
                }
                list.add(Long.valueOf(bVar.mLq));
            }
        }
        a.b(this.mMS).putAll(hashMap);
        this.mNl = hashMap.size();
        return true;
    }

    public final String ado() {
        return String.format("{touched: %d users: %d}", new Object[]{Integer.valueOf(this.mNk), Integer.valueOf(this.mNl)});
    }

    public final String getName() {
        return "MarkAllContactDirtyTask";
    }
}
