package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.29;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class ExdeviceProfileUI$29$1 implements OnClickListener {
    final /* synthetic */ 29 lWi;

    ExdeviceProfileUI$29$1(29 29) {
        this.lWi = 29;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.Hg();
        x WO = c.EY().WO(ExdeviceProfileUI.u(this.lWi.lVZ));
        d.pY(37);
        s.f(WO);
        ExdeviceProfileUI.v(this.lWi.lVZ).ceO();
        if (ExdeviceProfileUI.d(this.lWi.lVZ) != null) {
            ExdeviceProfileUI.d(this.lWi.lVZ).show();
        }
    }
}
