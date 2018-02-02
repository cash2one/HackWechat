package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import com.tencent.mm.plugin.qqmail.ui.ComposeUI.8;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class ComposeUI$8$1 implements c {
    final /* synthetic */ 8 pru;

    ComposeUI$8$1(8 8) {
        this.pru = 8;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                x.i("MicroMsg.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.pru.prr.mController.xIM, "android.permission.CAMERA", 16, "", "")), bh.cgy(), this.pru.prr.mController.xIM});
                if (a.a(this.pru.prr.mController.xIM, "android.permission.CAMERA", 16, "", "")) {
                    ComposeUI.C(this.pru.prr);
                    return;
                }
                return;
            case 1:
                k.a(this.pru.prr, 4, null);
                return;
            case 2:
                this.pru.prr.startActivityForResult(new Intent(this.pru.prr, FileExplorerUI.class), 5);
                return;
            default:
                return;
        }
    }
}
