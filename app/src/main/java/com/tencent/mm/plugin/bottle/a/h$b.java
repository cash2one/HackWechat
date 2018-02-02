package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Map;
import junit.framework.Assert;

public class h$b implements e {
    public String iconUrl = "";
    public int kAF = -10001;
    public String kAK;
    private a kAP = null;
    public String kAQ = "";
    public final f kAR = new f();

    public final boolean a(a aVar) {
        x.d("MicroMsg.PickBottle", "bottle pick:" + c.arz() + " throw:" + c.ary());
        Assert.assertTrue("renew this class", this.kAP == null);
        Assert.assertTrue("must call back onFin", true);
        if (c.arz() <= 0) {
            aVar.cd(1, 16);
            return false;
        }
        ar.CG().a(155, this);
        ar.CG().a(156, this);
        this.kAP = aVar;
        return ar.CG().a(this.kAR, 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.PickBottle", "type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
        if (kVar.getType() == 155) {
            f fVar = (f) kVar;
            if (fVar.kAN) {
                ar.CG().b(155, this);
                com.tencent.mm.plugin.bottle.a.ift.um();
                this.kAK = fVar.arD().wCw == null ? "" : fVar.arD().wCw;
                this.kAF = fVar.arD().ngq;
                Map y = bi.y(fVar.arD().wli == null ? "" : fVar.arD().wli, "branduser");
                if (y != null) {
                    this.kAQ = (String) y.get(".branduser.$username");
                    this.iconUrl = (String) y.get(".branduser.$iconurl");
                    if (this.kAQ != null) {
                        this.kAF = 19990;
                        if (this.kAP != null) {
                            if (i == 0 && i2 == 0) {
                                this.kAP.cd(i, i2);
                            } else {
                                this.kAP.cd(i, i2);
                            }
                        }
                        this.kAP = null;
                        return;
                    }
                }
                ar.CG().a(new e(this.kAK, this.kAF), 0);
                return;
            }
            if (this.kAP != null) {
                this.kAP.cd(i, i2);
            }
            this.kAP = null;
            ar.CG().b(155, this);
            ar.CG().b(156, this);
        } else if (kVar.getType() == 156) {
            ar.CG().b(156, this);
            if (this.kAP != null) {
                if (i == 0 && i2 == 0) {
                    this.kAP.cd(i, i2);
                } else {
                    this.kAP.cd(i, i2);
                }
            }
            this.kAP = null;
        }
    }
}
