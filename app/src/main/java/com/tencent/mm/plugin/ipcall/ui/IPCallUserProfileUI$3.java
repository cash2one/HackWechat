package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class IPCallUserProfileUI$3 implements OnClickListener {
    final /* synthetic */ IPCallUserProfileUI nNH;

    IPCallUserProfileUI$3(IPCallUserProfileUI iPCallUserProfileUI) {
        this.nNH = iPCallUserProfileUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.nNH, IPCallAllRecordUI.class);
        if (!bh.ov(IPCallUserProfileUI.e(this.nNH))) {
            intent.putExtra("IPCallAllRecordUI_contactId", IPCallUserProfileUI.e(this.nNH));
        } else if (!bh.ov(IPCallUserProfileUI.f(this.nNH))) {
            intent.putExtra("IPCallAllRecordUI_phoneNumber", IPCallUserProfileUI.f(this.nNH));
        }
        intent.putExtra("IPCallAllRecordUI_isSinglePhoneNumber", IPCallUserProfileUI.g(this.nNH));
        this.nNH.startActivity(intent);
    }
}
