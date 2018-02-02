package com.tencent.mm.plugin.sns.a;

import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class a implements c {
    private Map<Integer, com.tencent.mm.plugin.sns.a.a.a> qOa = new HashMap();

    public final void a(com.tencent.mm.plugin.sns.a.a.a aVar) {
        this.qOa.put(Integer.valueOf(aVar.bmL()), aVar);
    }

    public final void a(int i, int i2, Object... objArr) {
        com.tencent.mm.plugin.sns.a.a.a aVar = (com.tencent.mm.plugin.sns.a.a.a) this.qOa.get(Integer.valueOf(i));
        if (aVar == null) {
            x.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[]{com.tencent.mm.plugin.sns.a.a.a.class, Integer.valueOf(i)});
            return;
        }
        aVar.h(i2, objArr);
    }

    public final void h(int i, Object... objArr) {
        com.tencent.mm.plugin.sns.a.a.a aVar = (com.tencent.mm.plugin.sns.a.a.a) this.qOa.get(Integer.valueOf(i));
        if (aVar == null) {
            x.w("SnsAdReportService", "can not find %s implementation for kv %d", new Object[]{com.tencent.mm.plugin.sns.a.a.a.class, Integer.valueOf(i)});
            return;
        }
        aVar.c(objArr);
    }
}
