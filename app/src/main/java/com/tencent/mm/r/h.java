package com.tencent.mm.r;

import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.z.p;

public final class h extends p implements c {
    private static h gJX;

    public static synchronized h Bj() {
        h hVar;
        synchronized (h.class) {
            if (gJX == null) {
                gJX = new h();
            }
            hVar = gJX;
        }
        return hVar;
    }

    private h() {
        super(i.class);
    }

    public final void onAccountInitialized(e.c cVar) {
        super.onAccountInitialized(cVar);
    }
}
