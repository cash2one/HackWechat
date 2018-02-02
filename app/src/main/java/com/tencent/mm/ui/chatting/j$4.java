package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;

class j$4 implements a {
    final /* synthetic */ Runnable fgd = null;
    final /* synthetic */ String gIT;
    final /* synthetic */ Context val$context;
    final /* synthetic */ boolean yrH;

    j$4(Context context, String str, boolean z, Runnable runnable) {
        this.val$context = context;
        this.gIT = str;
        this.yrH = z;
    }

    public final boolean JB() {
        if (j.crs().yrI == null) {
            return false;
        }
        for (au d : j.crs().yrI) {
            j.d(this.val$context, this.gIT, d, j.crs().ypn);
        }
        return true;
    }

    public final boolean JC() {
        if (j.crs().yrI != null) {
            g.pQN.h(10811, new Object[]{Integer.valueOf(5), Integer.valueOf(j.crs().yrI.size()), Integer.valueOf(j.crs().yrI.size() - i.dc(j.crs().yrI))});
        }
        if (this.yrH) {
            if (this.fgd != null) {
                x.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
                this.fgd.run();
            }
            if (j.crs().yrB != null) {
                j.crs().yrB.b(ac.a.yxj);
            }
            j.crr();
        }
        return true;
    }
}
