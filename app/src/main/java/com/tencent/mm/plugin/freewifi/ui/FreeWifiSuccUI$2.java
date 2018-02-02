package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;

class FreeWifiSuccUI$2 implements OnClickListener {
    final /* synthetic */ FreeWifiSuccUI mIG;

    FreeWifiSuccUI$2(FreeWifiSuccUI freeWifiSuccUI) {
        this.mIG = freeWifiSuccUI;
    }

    public final void onClick(View view) {
        if (!bh.ov(FreeWifiSuccUI.b(this.mIG))) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", FreeWifiSuccUI.b(this.mIG));
            d.b(this.mIG, "profile", ".ui.ContactInfoUI", intent);
        }
    }
}
