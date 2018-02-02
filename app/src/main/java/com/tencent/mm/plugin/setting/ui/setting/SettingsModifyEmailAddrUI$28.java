package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;

class SettingsModifyEmailAddrUI$28 implements OnClickListener {
    final /* synthetic */ SettingsModifyEmailAddrUI qjX;

    SettingsModifyEmailAddrUI$28(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        this.qjX = settingsModifyEmailAddrUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("kintent_hint", this.qjX.getString(R.l.eNG));
        intent.putExtra("from_unbind", true);
        d.b(this.qjX, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
    }
}
