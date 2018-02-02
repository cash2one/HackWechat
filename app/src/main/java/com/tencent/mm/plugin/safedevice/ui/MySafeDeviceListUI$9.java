package com.tencent.mm.plugin.safedevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.safedevice.a.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.z.ar;

class MySafeDeviceListUI$9 implements b {
    final /* synthetic */ MySafeDeviceListUI pRA;
    final /* synthetic */ c pRD;

    MySafeDeviceListUI$9(MySafeDeviceListUI mySafeDeviceListUI, c cVar) {
        this.pRA = mySafeDeviceListUI;
        this.pRD = cVar;
    }

    public final boolean v(CharSequence charSequence) {
        String trim = charSequence == null ? "" : charSequence.toString().trim();
        if (trim.equals(this.pRD.field_name)) {
            return true;
        }
        if (trim.length() <= 0) {
            h.bu(this.pRA.mController.xIM, this.pRA.getString(R.l.eGO));
            return false;
        }
        k bVar = new com.tencent.mm.plugin.safedevice.a.b(this.pRD.field_uid, trim, this.pRD.field_devicetype);
        ar.CG().a(bVar, 0);
        if (MySafeDeviceListUI.g(this.pRA) != null) {
            MySafeDeviceListUI.g(this.pRA).dismiss();
        }
        MySafeDeviceListUI.a(this.pRA, h.a(this.pRA, a.ac(this.pRA, R.l.dHc), true, new 1(this, bVar)));
        return true;
    }
}
