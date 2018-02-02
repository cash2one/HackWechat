package com.tencent.mm.plugin.nearlife.ui;

import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class BaseLifeUI$7 implements a$a {
    final /* synthetic */ BaseLifeUI oQu;

    BaseLifeUI$7(BaseLifeUI baseLifeUI) {
        this.oQu = baseLifeUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (this.oQu.hnr) {
            return false;
        }
        if (this.oQu.gyB) {
            return false;
        }
        if (!z) {
            return true;
        }
        o.a(2003, f, f2, (int) d2);
        this.oQu.gyB = true;
        x.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[]{Float.valueOf(f2), Float.valueOf(f)});
        this.oQu.oQf = new aog();
        this.oQu.oQf.wct = "";
        this.oQu.oQf.wcu = 0;
        this.oQu.oQf.vQu = f2;
        this.oQu.oQf.vQt = f;
        this.oQu.oQf.wcs = "";
        this.oQu.oQf.wcr = (int) d2;
        this.oQu.oQg = f2;
        this.oQu.oQh = f;
        this.oQu.oQi = i;
        this.oQu.oQj = (float) d2;
        this.oQu.hxP = BaseLifeUI.j(this.oQu) == null ? false : BaseLifeUI.j(this.oQu).hxP;
        ArrayList arrayList = BaseLifeUI.f(this.oQu).oPN;
        if (arrayList == null || arrayList.size() <= 0) {
            this.oQu.l((double) f2, (double) f);
        } else {
            LatLongData latLongData = (LatLongData) arrayList.get(arrayList.size() - 1);
            this.oQu.l((double) latLongData.fzt, (double) latLongData.hBL);
            this.oQu.oQq = BaseLifeUI.d(latLongData.fzt, latLongData.hBL, f2, f);
        }
        BaseLifeUI.f(this.oQu).oPR = new LatLongData(this.oQu.oQf.vQu, this.oQu.oQf.vQt);
        BaseLifeUI.b(this.oQu).oPR = new LatLongData(this.oQu.oQf.vQu, this.oQu.oQf.vQt);
        BaseLifeUI.a(this.oQu, this.oQu.nXt ? BaseLifeUI.b(this.oQu) : BaseLifeUI.f(this.oQu));
        BaseLifeUI.k(this.oQu);
        this.oQu.a(BaseLifeUI.i(this.oQu));
        return false;
    }
}
