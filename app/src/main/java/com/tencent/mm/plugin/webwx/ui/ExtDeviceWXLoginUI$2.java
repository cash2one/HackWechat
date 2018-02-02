package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ExtDeviceWXLoginUI$2 implements OnClickListener {
    final /* synthetic */ ExtDeviceWXLoginUI tOD;

    ExtDeviceWXLoginUI$2(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        this.tOD = extDeviceWXLoginUI;
    }

    public final void onClick(View view) {
        if (ExtDeviceWXLoginUI.b(this.tOD) == 0) {
            if (ExtDeviceWXLoginUI.c(this.tOD)) {
                boolean z;
                boolean isChecked = ((CheckBox) this.tOD.findViewById(R.h.cPn)).isChecked();
                ExtDeviceWXLoginUI.a(this.tOD, false);
                if (isChecked) {
                    ar.Hg();
                    c.CU().a(a.xtb, Boolean.valueOf(true));
                } else {
                    ar.Hg();
                    if (((Boolean) c.CU().get(a.xtb, Boolean.valueOf(true))).booleanValue()) {
                        ExtDeviceWXLoginUI.a(this.tOD, true);
                    }
                    ar.Hg();
                    c.CU().a(a.xtb, Boolean.valueOf(false));
                }
                ExtDeviceWXLoginUI extDeviceWXLoginUI = this.tOD;
                if (ExtDeviceWXLoginUI.c(this.tOD) && isChecked) {
                    z = true;
                } else {
                    z = false;
                }
                ExtDeviceWXLoginUI.b(extDeviceWXLoginUI, z);
                return;
            }
            ExtDeviceWXLoginUI.b(this.tOD, false);
        } else if (ExtDeviceWXLoginUI.b(this.tOD) == -2) {
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
            intent.putExtra("from_album", false);
            intent.putExtra("show_intro", false);
            intent.setFlags(65536);
            d.b(this.tOD, "scanner", ".ui.BaseScanUI", intent);
            this.tOD.finish();
        }
    }
}
