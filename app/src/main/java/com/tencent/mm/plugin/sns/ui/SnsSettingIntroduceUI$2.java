package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.an;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.e.e;

class SnsSettingIntroduceUI$2 implements OnClickListener {
    final /* synthetic */ SnsSettingIntroduceUI rGm;

    SnsSettingIntroduceUI$2(SnsSettingIntroduceUI snsSettingIntroduceUI) {
        this.rGm = snsSettingIntroduceUI;
    }

    public final void onClick(View view) {
        b anVar = new an();
        anVar.foF.index = 3;
        a.xef.m(anVar);
        d.b(this.rGm.mController.xIM, "setting", ".ui.setting.SettingsUI", new Intent());
        Intent intent = new Intent();
        intent.putExtra("enter_scene", e.xEm);
        d.b(this.rGm.mController.xIM, "setting", ".ui.setting.SettingsPrivacyUI", intent);
        g.pQN.h(14090, new Object[]{Integer.valueOf(2)});
        this.rGm.finish();
    }
}
