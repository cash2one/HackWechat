package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceManageDeviceUI$a$2 implements OnClickListener {
    final /* synthetic */ a lUT;

    ExdeviceManageDeviceUI$a$2(a aVar) {
        this.lUT = aVar;
    }

    public final void onClick(View view) {
        if (!a.b(this.lUT)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof Integer)) {
                int intValue = ((Integer) tag).intValue();
                if (intValue >= 0 && intValue < this.lUT.getCount()) {
                    b pm = this.lUT.pm(intValue);
                    Context context = (Context) a.c(this.lUT).get();
                    if (context == null) {
                        x.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
                    } else {
                        a.a(context, pm);
                    }
                }
            }
        }
    }
}
