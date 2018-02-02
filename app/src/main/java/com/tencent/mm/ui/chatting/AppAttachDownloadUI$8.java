package com.tencent.mm.ui.chatting;

import com.tencent.mm.a.e;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.x;

class AppAttachDownloadUI$8 implements Runnable {
    final /* synthetic */ AppAttachDownloadUI ypv;
    final /* synthetic */ b ypw;
    final /* synthetic */ b ypx;

    AppAttachDownloadUI$8(AppAttachDownloadUI appAttachDownloadUI, b bVar, b bVar2) {
        this.ypv = appAttachDownloadUI;
        this.ypw = bVar;
        this.ypx = bVar2;
    }

    public final void run() {
        boolean c;
        long currentTimeMillis = System.currentTimeMillis();
        long x = e.x(this.ypw.field_fileFullPath, this.ypx.field_fileFullPath);
        if (x > 0) {
            this.ypx.field_offset = x;
            if (AppAttachDownloadUI.b(this.ypx)) {
                this.ypx.field_status = 199;
            }
            c = an.aqd().c(this.ypx, new String[0]);
        } else {
            c = false;
        }
        x.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", new Object[]{Long.valueOf(x), Long.valueOf(this.ypw.field_msgInfoId), Long.valueOf(this.ypx.field_msgInfoId), Boolean.valueOf(c), Long.valueOf(this.ypx.field_status), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
