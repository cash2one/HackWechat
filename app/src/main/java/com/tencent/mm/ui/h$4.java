package com.tencent.mm.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI;

class h$4 implements OnClickListener {
    final /* synthetic */ h xFs;

    h$4(h hVar) {
        this.xFs = hVar;
    }

    public final void onClick(View view) {
        this.xFs.startActivity(new Intent(this.xFs.getContext(), SettingsManageFindMoreUI.class));
    }
}
