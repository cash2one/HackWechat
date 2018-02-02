package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.qr;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter.StartGameProcessTask;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

class SubCoreGameCenter$16 extends c<qr> {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$16(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
        this.xen = qr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qr qrVar = (qr) bVar;
        StartGameProcessTask startGameProcessTask = new StartGameProcessTask(ac.getContext());
        startGameProcessTask.fmZ = qrVar.fIw.bundle.getLong("extra_download_id", -1);
        startGameProcessTask.aKE();
        return false;
    }
}
