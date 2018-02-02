package com.tencent.mm.plugin.welab.d;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private static final b tQe = new b();
    public Map<String, Integer> tPC = new HashMap();
    public String tag = "";

    public static b bVJ() {
        return tQe;
    }

    private b() {
        bVy();
    }

    private void bVy() {
        this.tag = (String) g.Dj().CU().get(a.xvn, null);
        x.i("WeLabRedPointMgr", "load red tag " + this.tag);
        if (!TextUtils.isEmpty(this.tag)) {
            for (Object obj : this.tag.split("&")) {
                if (!TextUtils.isEmpty(obj)) {
                    String[] split = obj.split("=");
                    if (split != null && split.length == 2) {
                        this.tPC.put(split[0], Integer.valueOf(bh.VI(split[1])));
                    }
                }
            }
        }
    }

    public final boolean e(com.tencent.mm.plugin.welab.c.a.a aVar) {
        if (aVar.field_RedPoint != 1) {
            return false;
        }
        boolean z = aVar.bPi() || aVar.field_Switch == 3;
        if (z || QF(aVar.field_LabsAppId)) {
            return false;
        }
        return true;
    }

    private boolean QF(String str) {
        return this.tPC.containsKey(str) && ((Integer) this.tPC.get(str)).intValue() == 1;
    }

    public final void f(com.tencent.mm.plugin.welab.c.a.a aVar) {
        if (aVar.field_RedPoint == 1 && !QF(aVar.field_LabsAppId) && aVar.bVF()) {
            c.Bq().p(266267, true);
        }
    }

    public static void bVK() {
        List<com.tencent.mm.plugin.welab.c.a.a> bVv = com.tencent.mm.plugin.welab.b.bVu().bVv();
        if (bVv == null || bVv.isEmpty()) {
        } else {
        }
        for (com.tencent.mm.plugin.welab.c.a.a aVar : bVv) {
            if (aVar != null && tQe.e(aVar)) {
                Object obj = null;
                break;
            }
        }
        int i = 1;
        if (obj != null) {
            c.Bq().aS(266267, 266241);
        }
    }

    public static boolean bVL() {
        return c.Bq().aR(266267, 266241);
    }

    public static boolean bVM() {
        return ac.cft().getBoolean("key_has_enter_welab", false);
    }
}
