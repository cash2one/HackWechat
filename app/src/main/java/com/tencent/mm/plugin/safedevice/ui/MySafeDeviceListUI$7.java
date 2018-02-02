package com.tencent.mm.plugin.safedevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class MySafeDeviceListUI$7 implements OnClickListener {
    final /* synthetic */ MySafeDeviceListUI pRA;

    MySafeDeviceListUI$7(MySafeDeviceListUI mySafeDeviceListUI) {
        this.pRA = mySafeDeviceListUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.Hg();
        String str = (String) c.CU().get(6, null);
        if (bh.ov(str)) {
            x.d("MicroMsg.MySafeDeviceListUI", "not bind mobile");
            return;
        }
        Intent intent = new Intent(this.pRA, SecurityAccountIntroUI.class);
        intent.putExtra("binded_mobile", str);
        intent.putExtra("re_open_verify", true);
        MMWizardActivity.A(this.pRA, intent);
    }
}
