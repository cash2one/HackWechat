package com.tencent.mm.app.plugin.b;

import com.tencent.mm.e.a.a;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class a$d extends c<ez> {
    a fhH;
    String fileName;

    public a$d() {
        this.xen = ez.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ez ezVar = (ez) bVar;
        if (bh.ov(ezVar.ftT.fileName) && ezVar.ftT.op == 1) {
            x.e("MicroMsg.SubCoreExtAgent", "fileName(%s) is null or nil.", ezVar.ftT.fileName);
        } else if (ezVar.ftT.op == 1) {
            if (this.fhH == null) {
                this.fhH = new a(ac.getContext());
            } else if (!ezVar.ftT.fileName.equals(this.fileName)) {
                if (this.fhH.isPlaying()) {
                    this.fhH.aL(false);
                }
                this.fileName = ezVar.ftT.fileName;
            } else if (this.fhH.vg()) {
                ezVar.ftU.fpW = this.fhH.vc();
            } else if (this.fhH.isPlaying()) {
                ezVar.ftU.fpW = false;
            }
            this.fhH.fjG = ezVar.ftT.ftW;
            this.fhH.fjF = ezVar.ftT.ftX;
            ezVar.ftU.fpW = this.fhH.a(ezVar.ftT.fileName, ezVar.ftT.fjt, ezVar.ftT.ftV, -1);
        } else if (ezVar.ftT.op == 2) {
            if (this.fhH != null) {
                this.fhH.aL(false);
            }
        } else if (ezVar.ftT.op == 4 && this.fhH != null && this.fhH.isPlaying()) {
            ezVar.ftU.fpW = this.fhH.aK(true);
        }
        return true;
    }
}
