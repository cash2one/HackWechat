package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

class WelabMainUI$4 implements OnClickListener {
    final /* synthetic */ WelabMainUI tQc;

    WelabMainUI$4(WelabMainUI welabMainUI) {
        this.tQc = welabMainUI;
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof a) {
            a aVar = (a) tag;
            Intent intent = new Intent();
            intent.putExtra("para_appid", aVar.field_LabsAppId);
            intent.putExtra("para_from_with_red_point", b.bVJ().e(aVar) ? 1 : 0);
            intent.setClass(this.tQc, WelabAppInfoUI.class);
            this.tQc.startActivity(intent);
            b bVJ = b.bVJ();
            String str = aVar.field_LabsAppId;
            bVJ.tPC.put(str, Integer.valueOf(1));
            bVJ.tag += "&" + str + "=1";
            g.Dj().CU().a(w.a.xvn, bVJ.tag);
            b.bVK();
            x.i("MicroMsg.WelabMainUI", "click " + aVar);
        }
    }
}
