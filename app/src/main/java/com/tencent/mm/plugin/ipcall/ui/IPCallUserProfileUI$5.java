package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

class IPCallUserProfileUI$5 implements OnLongClickListener {
    final /* synthetic */ IPCallUserProfileUI nNH;
    final /* synthetic */ TextView nNJ;

    IPCallUserProfileUI$5(IPCallUserProfileUI iPCallUserProfileUI, TextView textView) {
        this.nNH = iPCallUserProfileUI;
        this.nNJ = textView;
    }

    public final boolean onLongClick(View view) {
        IPCallUserProfileUI.a(this.nNH, this.nNJ);
        return true;
    }
}
