package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class AddMoreFriendsUI$3 implements OnClickListener {
    final /* synthetic */ AddMoreFriendsUI rYm;

    AddMoreFriendsUI$3(AddMoreFriendsUI addMoreFriendsUI) {
        this.rYm = addMoreFriendsUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11264, new Object[]{Integer.valueOf(1)});
        Intent intent = new Intent();
        intent.setClassName(this.rYm, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
        this.rYm.mController.xIM.startActivity(intent);
    }
}
