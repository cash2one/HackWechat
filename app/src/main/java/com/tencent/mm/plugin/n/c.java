package com.tencent.mm.plugin.n;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c implements b, com.tencent.mm.kernel.b.c {
    private static c nBG;

    private c() {
    }

    public static synchronized c aSM() {
        c cVar;
        synchronized (c.class) {
            if (nBG == null) {
                nBG = new c();
            }
            cVar = nBG;
        }
        return cVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"image/", "image2/"});
        return linkedList;
    }

    public static String Fi() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("image/").toString();
    }

    public static String Fj() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("image2/").toString();
    }

    public static String Fy() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dk();
        return stringBuilder.append(g.Dj().gQi).append("sfs").toString();
    }
}
