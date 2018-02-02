package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class SendFeedBackUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SendFeedBackUI qhI;

    SendFeedBackUI$3(SendFeedBackUI sendFeedBackUI) {
        this.qhI = sendFeedBackUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String trim = SendFeedBackUI.a(this.qhI).getText().toString().trim();
        if (trim.length() > 0) {
            if (trim.startsWith("//traceroute")) {
                SendFeedBackUI.a(this.qhI).setText("");
                d.y(this.qhI.mController.xIM, "traceroute", ".ui.NetworkDiagnoseIntroUI");
            } else {
                final k nVar = new n(q.yT(), trim + " key " + be.cjW() + " local key " + be.cjV() + "NetType:" + an.getNetTypeString(this.qhI.getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.d.n.yv() + " isArmv6: " + com.tencent.mm.compatible.d.n.yx() + " isArmv7: " + com.tencent.mm.compatible.d.n.yw());
                ar.CG().a(153, this.qhI);
                ar.CG().a(nVar, 0);
                this.qhI.aWs();
                SendFeedBackUI sendFeedBackUI = this.qhI;
                Context context = this.qhI;
                this.qhI.getString(R.l.dGO);
                SendFeedBackUI.a(sendFeedBackUI, h.a(context, this.qhI.getString(R.l.dGB), true, new OnCancelListener(this) {
                    final /* synthetic */ SendFeedBackUI$3 qhK;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ar.CG().c(nVar);
                    }
                }));
            }
        }
        return false;
    }
}
