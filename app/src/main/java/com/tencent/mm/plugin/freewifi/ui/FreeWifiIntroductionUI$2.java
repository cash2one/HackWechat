package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class FreeWifiIntroductionUI$2 implements OnClickListener {
    final /* synthetic */ FreeWifiIntroductionUI mHN;

    FreeWifiIntroductionUI$2(FreeWifiIntroductionUI freeWifiIntroductionUI) {
        this.mHN = freeWifiIntroductionUI;
    }

    public final void onClick(View view) {
        ar.Hg();
        c.CU().set(303104, Integer.valueOf(1));
        Intent intent = this.mHN.getIntent();
        intent.setClass(this.mHN, FreeWifiEntryUI.class);
        this.mHN.startActivity(intent);
        this.mHN.finish();
    }
}
