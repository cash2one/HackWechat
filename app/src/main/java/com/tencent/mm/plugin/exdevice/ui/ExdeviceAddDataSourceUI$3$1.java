package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.3;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.b;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.c;
import com.tencent.mm.z.ar;

class ExdeviceAddDataSourceUI$3$1 implements OnCancelListener {
    final /* synthetic */ 3 lRN;

    ExdeviceAddDataSourceUI$3$1(3 3) {
        this.lRN = 3;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(ExdeviceAddDataSourceUI.g(this.lRN.lRL));
        ExdeviceAddDataSourceUI.h(this.lRN.lRL);
        b zl = ExdeviceAddDataSourceUI.c(this.lRN.lRL).zl(this.lRN.lRM);
        if (zl != null) {
            zl.lRS = c.lRT;
        }
    }
}
