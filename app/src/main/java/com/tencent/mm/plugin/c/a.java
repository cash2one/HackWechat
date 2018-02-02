package com.tencent.mm.plugin.c;

import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements p {
    public static volatile n ifs;
    public static volatile m ift;

    public final void a(n nVar) {
        ifs = nVar;
    }

    public final void a(m mVar) {
        x.i("MicroMsg.AccountSyncApplication", "regitMMModelCallback %s", new Object[]{mVar});
        ift = mVar;
    }
}
