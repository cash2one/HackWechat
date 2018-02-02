package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;

class SettingsAliasResultUI$2 implements OnClickListener {
    final /* synthetic */ SettingsAliasResultUI qiX;

    SettingsAliasResultUI$2(SettingsAliasResultUI settingsAliasResultUI) {
        this.qiX = settingsAliasResultUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.qiX.mController.xIM, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", this.qiX.getString(R.l.eDS));
        this.qiX.startActivityForResult(intent, 0);
    }
}
