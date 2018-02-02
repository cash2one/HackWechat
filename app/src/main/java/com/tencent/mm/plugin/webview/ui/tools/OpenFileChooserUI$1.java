package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class OpenFileChooserUI$1 implements c {
    final /* synthetic */ OpenFileChooserUI twU;

    OpenFileChooserUI$1(OpenFileChooserUI openFileChooserUI) {
        this.twU = openFileChooserUI;
    }

    public final void jl(int i) {
        x.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.twU.mController.xIM, "android.permission.CAMERA", 16, "", "")), bh.cgy(), this.twU.mController.xIM});
        if (a.a(this.twU.mController.xIM, "android.permission.CAMERA", 16, "", "")) {
            k.c(this.twU.mController.xIM, e.gHu, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
        }
    }
}
