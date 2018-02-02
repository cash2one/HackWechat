package com.tencent.mm.app.plugin.b;

import com.tencent.mm.g.a.fh;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class a$h extends c<fh> {
    public a$h() {
        this.xen = fh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fh fhVar = (fh) bVar;
        if (m.UD() == null) {
            x.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg()" + bh.cgy());
            fhVar.fuy.fileName = "";
        }
        p iM = m.UD().iM((int) fhVar.fux.fqm);
        if (iM == null) {
            fhVar.fuy.fileName = "";
        } else {
            fhVar.fuy.fileName = iM.fileName;
        }
        return true;
    }
}
