package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.g.a.qo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<qo> {
    final /* synthetic */ a rTK;

    a$1(a aVar) {
        this.rTK = aVar;
        this.xen = qo.class.getName().hashCode();
    }

    private boolean a(qo qoVar) {
        long bDl;
        boolean fb;
        switch (qoVar.fIh.action) {
            case 1:
            case 2:
            case 3:
                g.bDq();
                if (a.bDn()) {
                    this.rTK.bDm();
                    bDl = this.rTK.bDl();
                    if (qoVar.fIh.action == 1) {
                        fb = this.rTK.fb(bDl);
                    } else if (n.F(this.rTK.bDk(), bDl)) {
                        fb = this.rTK.fb(bDl);
                    } else {
                        fb = false;
                    }
                    x.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d %b", new Object[]{Integer.valueOf(qoVar.fIh.action), Long.valueOf(bDl), Boolean.valueOf(fb)});
                    break;
                }
                break;
            case 4:
            case 5:
                g.bDq();
                if (a.bDn()) {
                    this.rTK.bDm();
                    bDl = this.rTK.bDl();
                    a aVar = this.rTK;
                    if (aVar.rTH == 0) {
                        aVar.rTH = i.K(3, 0);
                    }
                    boolean E = n.E(aVar.rTH, System.currentTimeMillis());
                    if (n.F(this.rTK.bDk(), bDl) || E) {
                        fb = this.rTK.fb(bDl);
                    } else {
                        fb = false;
                    }
                    x.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d result %b timeCondition %b stepCountCondition %b", new Object[]{Integer.valueOf(qoVar.fIh.action), Long.valueOf(bDl), Boolean.valueOf(fb), Boolean.valueOf(E), Boolean.valueOf(r5)});
                    break;
                }
                break;
        }
        return false;
    }
}
