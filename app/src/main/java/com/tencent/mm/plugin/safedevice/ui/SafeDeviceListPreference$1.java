package com.tencent.mm.plugin.safedevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.safedevice.a.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class SafeDeviceListPreference$1 implements OnClickListener {
    final /* synthetic */ SafeDeviceListPreference pRJ;

    SafeDeviceListPreference$1(SafeDeviceListPreference safeDeviceListPreference) {
        this.pRJ = safeDeviceListPreference;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SafeDeviceListPreference.a(this.pRJ);
        final k aVar = new a(this.pRJ.pRF.field_uid);
        ar.CG().a(aVar, 0);
        SafeDeviceListPreference.a(this.pRJ, h.a(SafeDeviceListPreference.b(this.pRJ), com.tencent.mm.bv.a.ac(SafeDeviceListPreference.b(this.pRJ), R.l.dHc), true, new OnCancelListener(this) {
            final /* synthetic */ SafeDeviceListPreference$1 pRL;

            public final void onCancel(DialogInterface dialogInterface) {
                ar.CG().c(aVar);
                SafeDeviceListPreference.c(this.pRL.pRJ);
            }
        }));
    }
}
