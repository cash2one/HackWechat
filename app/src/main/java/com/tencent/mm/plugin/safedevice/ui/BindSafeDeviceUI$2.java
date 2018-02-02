package com.tencent.mm.plugin.safedevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.safedevice.a;

class BindSafeDeviceUI$2 implements OnClickListener {
    final /* synthetic */ BindSafeDeviceUI pRn;

    BindSafeDeviceUI$2(BindSafeDeviceUI bindSafeDeviceUI) {
        this.pRn = bindSafeDeviceUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("is_bind_for_safe_device", true);
        a.ifs.b(this.pRn, intent);
    }
}
