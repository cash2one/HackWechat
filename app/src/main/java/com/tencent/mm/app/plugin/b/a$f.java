package com.tencent.mm.app.plugin.b;

import com.tencent.mm.g.a.fc;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

public class a$f extends c<fc> {
    k fhJ;
    ak fhK;
    boolean fhL;
    boolean fhM;
    boolean fhN;
    fc fhO;
    Runnable fhP;
    String fileName;

    public a$f() {
        this.fileName = "";
        this.xen = fc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 600;
        fc fcVar = (fc) bVar;
        if (fcVar instanceof fc) {
            if (fcVar.fua.op == 1) {
                if (this.fhJ == null) {
                    this.fhJ = new k();
                }
                this.fhP = fcVar.fua.fhP;
                if (this.fhJ.mStatus == 1) {
                    this.fhJ.vi();
                }
                fcVar.fub.fpW = this.fhJ.cI(fcVar.fua.filePath);
                int i2 = fcVar.fua.duration;
                if (i2 <= 0) {
                    x.e("MicroMsg.SubCoreExtAgent", "duration is invalid, less than 0");
                    i2 = 60;
                }
                if (i2 > 600) {
                    x.e("MicroMsg.SubCoreExtAgent", "duration is invalid, more than %d", new Object[]{Integer.valueOf(600)});
                } else {
                    i = i2;
                }
                x.i("MicroMsg.SubCoreExtAgent", "MaxVoiceRecordTime (%d)s", new Object[]{Integer.valueOf(i)});
                long j = (long) (i * 1000);
                if (this.fhK == null) {
                    this.fhK = new ak(new 1(this), false);
                }
                if (this.fhK.cfK()) {
                    this.fhK.TG();
                }
                this.fhN = false;
                this.fhK.J(j, j);
                this.fhL = false;
                x.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", new Object[]{Integer.valueOf(fcVar.fua.op), Boolean.valueOf(fcVar.fub.fpW)});
            } else if (fcVar.fua.op == 2 && this.fhJ != null) {
                if (!this.fhL) {
                    this.fhK.TG();
                    x.i("MicroMsg.SubCoreExtAgent", "Voice record stop.");
                    uE();
                }
                fcVar.fub.fpW = this.fhM;
                x.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", new Object[]{Integer.valueOf(fcVar.fua.op), this.fileName, Boolean.valueOf(fcVar.fub.fpW)});
                this.fileName = "";
                this.fhM = false;
            }
            return true;
        }
        x.f("MicroMsg.SubCoreExtAgent", "mismatched event");
        return false;
    }

    final void uE() {
        if (this.fhJ != null) {
            this.fhM = this.fhJ.vi();
            if (this.fhP != null) {
                if (this.fhO != null) {
                    this.fhO.fub.fuc = this.fhJ.fkb.fkP;
                    this.fhO = null;
                }
                if (this.fhN) {
                    this.fhP.run();
                }
                this.fhP = null;
            }
            this.fhL = true;
        }
    }
}
