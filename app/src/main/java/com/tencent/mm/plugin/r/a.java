package com.tencent.mm.plugin.r;

import com.tencent.mm.by.h;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.at;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.r.a.a {
    private at ooc;

    public final at Ff() {
        g.Dk();
        g.Dh().Ct();
        return this.ooc;
    }

    public final void onDataBaseOpened(h hVar, h hVar2) {
        this.ooc = new at(hVar);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final HashMap<Integer, h.d> collectDatabaseFactory() {
        HashMap<Integer, h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new 1(this));
        return hashMap;
    }
}
