package com.tencent.mm.plugin.messenger.b;

import com.tencent.mm.ae.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class a$1 implements m {
    final /* synthetic */ a opk;

    a$1(a aVar) {
        this.opk = aVar;
    }

    public final void b(String str, Map<String, String> map, a aVar) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: on new xml received: %s", new Object[]{map.toString()});
        a.d(aVar);
    }
}
