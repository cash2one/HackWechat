package com.tencent.mm.ui.contact;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class u {
    public static final void l(String str, int i, int i2, int i3) {
        if (!bh.ov(str)) {
            x.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[]{String.format("%s,%d,%d,%d,%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0)})});
            g.pQN.k(13234, r0);
        }
    }

    public static void Go(int i) {
        x.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", new Object[]{Integer.valueOf(13941), Integer.valueOf(i)});
        g.pQN.h(13941, new Object[]{Integer.valueOf(i)});
    }
}
