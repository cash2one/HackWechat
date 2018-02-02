package com.tencent.mm.plugin.safedevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.safedevice.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class ModSafeDeviceNameUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ModSafeDeviceNameUI pRr;

    ModSafeDeviceNameUI$2(ModSafeDeviceNameUI modSafeDeviceNameUI) {
        this.pRr = modSafeDeviceNameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ModSafeDeviceNameUI.a(this.pRr, ModSafeDeviceNameUI.a(this.pRr).getText().toString());
        if (!bh.ov(ModSafeDeviceNameUI.b(this.pRr))) {
            this.pRr.aWs();
            final k bVar = new b(ModSafeDeviceNameUI.c(this.pRr), ModSafeDeviceNameUI.b(this.pRr), ModSafeDeviceNameUI.d(this.pRr));
            ar.CG().a(bVar, 0);
            ModSafeDeviceNameUI.a(this.pRr, h.a(this.pRr, a.ac(this.pRr, R.l.dHc), true, new OnCancelListener(this) {
                final /* synthetic */ ModSafeDeviceNameUI$2 pRt;

                public final void onCancel(DialogInterface dialogInterface) {
                    ar.CG().c(bVar);
                }
            }));
        }
        return true;
    }
}
