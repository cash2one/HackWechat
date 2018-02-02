package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.e.e;

class at$5 implements OnClickListener {
    final /* synthetic */ at rFj;

    at$5(at atVar) {
        this.rFj = atVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("enter_scene", e.xEn);
        d.b(at.a(this.rFj), "setting", ".ui.setting.SettingsPrivacyUI", intent);
        g.pQN.h(14098, new Object[]{Integer.valueOf(8)});
    }
}
