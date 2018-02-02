package com.tencent.mm.app.plugin.b;

import com.tencent.mm.e.b.h;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public class a$e extends c<fa> {
    h fhI;
    String fileName;

    public a$e() {
        this.fileName = "";
        this.xen = fa.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fa faVar = (fa) bVar;
        if (faVar.ftY.op == 1) {
            if (this.fhI == null) {
                this.fhI = new h(ac.getContext(), false);
            }
            faVar.ftZ.fpW = this.fhI.cJ(faVar.ftY.username);
            this.fileName = this.fhI.getFileName();
            x.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", Integer.valueOf(faVar.ftY.op), Boolean.valueOf(faVar.ftZ.fpW));
        } else if (faVar.ftY.op == 2 && this.fhI != null) {
            faVar.ftZ.fileName = this.fileName;
            faVar.ftZ.fpW = this.fhI.vo();
            x.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", Integer.valueOf(faVar.ftY.op), this.fileName, Boolean.valueOf(faVar.ftZ.fpW));
            this.fileName = "";
        }
        return true;
    }
}
