package com.tencent.mm.z;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

public final class bu {
    public static long Ie() {
        if (!ac.cfw()) {
            return 0;
        }
        g.Dk();
        if (!g.Dh().Cy()) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            g.Dk();
            Object obj = g.Dj().CU().get(a.xuZ, null);
            if (obj != null) {
                return currentTimeMillis - bh.getLong(obj.toString(), 0);
            }
            return 0;
        } catch (Throwable th) {
            x.e("MicroMsg.TimeHelper", th.getMessage());
            return 0;
        }
    }
}
