package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;

class IPCallUserProfileUI$4 implements OnClickListener {
    final /* synthetic */ IPCallUserProfileUI nNH;
    final /* synthetic */ String nNI;

    IPCallUserProfileUI$4(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        this.nNH = iPCallUserProfileUI;
        this.nNI = str;
    }

    public final void onClick(View view) {
        IPCallUserProfileUI.a(this.nNH, this.nNI);
    }
}
