package com.tencent.mm.plugin.l;

import com.tencent.mm.az.r;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.z.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a extends p implements b {
    private static a lqW;

    private a() {
        super(r.class);
    }

    public static synchronized a azP() {
        a aVar;
        synchronized (a.class) {
            if (lqW == null) {
                lqW = new a();
            }
            aVar = lqW;
        }
        return aVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"package/"});
        return linkedList;
    }

    public static String Fs() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("package/").toString();
    }
}
