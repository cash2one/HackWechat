package com.tencent.mm.ui.account;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class DisasterUI$1 implements OnClickListener {
    final /* synthetic */ String val$url;
    final /* synthetic */ DisasterUI xNz;

    DisasterUI$1(DisasterUI disasterUI, String str) {
        this.xNz = disasterUI;
        this.val$url = str;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.DisasterUI", "summerdiz jump link");
        g.pQN.h(13939, new Object[]{Integer.valueOf(1)});
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.val$url));
        this.xNz.startActivity(intent);
    }
}
