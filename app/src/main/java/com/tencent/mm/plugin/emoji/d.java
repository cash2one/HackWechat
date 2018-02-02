package com.tencent.mm.plugin.emoji;

import com.tencent.mm.ao.a;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.z.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d extends p implements b {
    private static d ltb;

    private d() {
        super(a.class);
    }

    public static synchronized d aAl() {
        d dVar;
        synchronized (d.class) {
            if (ltb == null) {
                ltb = new d();
            }
            dVar = ltb;
        }
        return dVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"emoji/"});
        return linkedList;
    }

    public static String aAm() {
        return g.Dj().gQi + "emoji/";
    }
}
