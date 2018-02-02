package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.q;

class IPCallUserProfileUI$9 implements OnClickListener {
    final /* synthetic */ IPCallUserProfileUI nNH;

    IPCallUserProfileUI$9(IPCallUserProfileUI iPCallUserProfileUI) {
        this.nNH = iPCallUserProfileUI;
    }

    public final void onClick(View view) {
        IPCallUserProfileUI.d(this.nNH).start();
        IPCallUserProfileUI.d(this.nNH).nFY = 1;
        IPCallUserProfileUI.d(this.nNH).nFZ = 5;
        IPCallUserProfileUI.d(this.nNH).finish();
        g.pQN.h(12766, new Object[]{Integer.valueOf(3)});
        Intent intent;
        if (!bh.ov(IPCallUserProfileUI.e(this.nNH))) {
            intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.CX(IPCallUserProfileUI.e(this.nNH))));
            intent.putExtra("sms_body", this.nNH.getString(R.l.eqK, new Object[]{q.Gy().AP()}));
            this.nNH.startActivity(intent);
        } else if (!bh.ov(IPCallUserProfileUI.f(this.nNH))) {
            intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.f(this.nNH)));
            intent.putExtra("sms_body", this.nNH.getString(R.l.eqK, new Object[]{q.Gy().AP()}));
            this.nNH.startActivity(intent);
        }
    }
}
