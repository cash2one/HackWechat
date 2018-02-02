package com.tencent.mm.plugin.f;

import com.tencent.mm.ad.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.k;
import com.tencent.mm.z.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a extends p implements b {
    private static a kip;

    private a() {
        super(n.class);
    }

    public static synchronized a aod() {
        a aVar;
        synchronized (a.class) {
            if (kip == null) {
                kip = new a();
            }
            aVar = kip;
        }
        return aVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"avatar/"});
        return linkedList;
    }

    public static String aoe() {
        return g.Dj().gQi + "avatar/";
    }

    public final void fN(String str) {
        super.fN(str);
        String str2 = "avatar/";
        if (f.ze()) {
            g.Dk();
            if (g.Dj().gQh.equals(e.bnF)) {
                g.Dk();
                com.tencent.mm.sdk.f.e.post(new k(g.Dj().cachePath, str, str2), "Account_moveDataFiles_" + str2);
            }
        }
    }
}
