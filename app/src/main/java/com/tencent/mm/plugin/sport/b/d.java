package com.tencent.mm.plugin.sport.b;

import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static final void pY(int i) {
        x.v("MicroMsg.Sport.SportReportLogic", "report action=%d", new Object[]{Integer.valueOf(i)});
        com.tencent.mm.plugin.report.d.pPH.h(13168, new Object[]{Integer.valueOf(i)});
    }
}
