package com.tencent.c.d.a;

import com.tencent.c.d.b.d.a;
import com.tencent.c.f.h;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class g implements b {
    private final Pattern yyy = Pattern.compile("^/system/xbin/ku\\.sud$|^daemonsu:|^k_worker/[1-9]\\d*:[1-9]\\d*$|^kr_worker/[1-9]\\d*:[1-9]\\d*$|^km_worker/[1-9]\\d*:[1-9]\\d*$|^tworker/[1-9]\\d*:[1-9]\\d*$|^tu_worker/[1-9]\\d*:[1-9]\\d*$|^tq_worker/[1-9]\\d*:[1-9]\\d*$|^kworker/[1-9]\\d{2}$|^permmgrd$|^360sguard$|^/data/data/[\\w\\-\\.]+/");
    private final List<a> zTr = new ArrayList();

    public final void a(a aVar) {
        if (aVar.uid == 0 && aVar.zTy == 1) {
            this.zTr.add(aVar);
        }
    }

    public final boolean cDr() {
        for (a aVar : this.zTr) {
            h.aaX("SingleProcessAnalyzer : " + aVar.toString());
            if (aVar.name != null && this.yyy.matcher(aVar.name).find()) {
                h.aaW("SingleProcessAnalyzer match : " + aVar.toString());
                return true;
            }
        }
        return false;
    }
}
