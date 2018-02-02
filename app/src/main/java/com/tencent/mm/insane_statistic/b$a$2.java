package com.tencent.mm.insane_statistic;

import com.tencent.mm.g.a.mq;
import com.tencent.mm.insane_statistic.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$a$2 extends c<mq> {
    final /* synthetic */ a gMa;

    b$a$2(a aVar) {
        this.gMa = aVar;
        this.xen = mq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((mq) bVar).fEC.filePath.equals(this.gMa.gLU)) {
            if (this.gMa.gLX) {
                x.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717), imgLocalId:%d, scene.hash:%d, %s", new Object[]{Long.valueOf(this.gMa.gLP), Integer.valueOf(this.gMa.hashCode()), this.gMa.gLS});
                g.pQN.k(13717, this.gMa.gLS);
            }
            a.a(this.gMa);
        }
        return false;
    }
}
