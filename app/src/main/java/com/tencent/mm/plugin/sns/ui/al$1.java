package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.pi;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class al$1 extends c<pi> {
    final /* synthetic */ al rxo;

    al$1(al alVar) {
        this.rxo = alVar;
        this.xen = pi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        pi piVar = (pi) bVar;
        x.i("MicroMsg.SightWidget", "on sight send result callback, type %d", new Object[]{Integer.valueOf(piVar.fHh.type)});
        switch (piVar.fHh.type) {
            case 1:
                x.i("MicroMsg.SightWidget", "come event done");
                this.rxo.videoPath = piVar.fHh.videoPath;
                this.rxo.fqR = piVar.fHh.fHk;
                if (this.rxo.iln != null) {
                    this.rxo.iln.dismiss();
                }
                this.rxo.rxm.aA(this.rxo.videoPath, false);
                this.rxo.lAk.setVisibility(8);
                if (piVar.fHh.fHj && this.rxo.ruB != null) {
                    this.rxo.bAb();
                }
                x.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", new Object[]{Boolean.valueOf(piVar.fHh.fHj), piVar.fHh.videoPath, Long.valueOf(FileOp.me(piVar.fHh.videoPath)), this.rxo.fqR});
                break;
        }
        return false;
    }
}
