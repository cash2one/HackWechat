package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

class SettingsChattingUI$2 implements OnClickListener {
    final /* synthetic */ SettingsChattingUI qji;

    SettingsChattingUI$2(SettingsChattingUI settingsChattingUI) {
        this.qji = settingsChattingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ArrayList arrayList;
        g.pQN.h(14553, new Object[]{Integer.valueOf(5), Integer.valueOf(2), ""});
        g.pQN.a(324, 0, 1, false);
        SettingsChattingUI.a(this.qji, false);
        SettingsChattingUI settingsChattingUI = this.qji;
        Context context = this.qji;
        this.qji.getString(R.l.dGO);
        SettingsChattingUI.a(settingsChattingUI, h.a(context, this.qji.getString(R.l.dHc), true, new 1(this)));
        ar.Hg();
        List<au> aZv = c.Fa().aZv();
        if (aZv != null) {
            x.i("MicroMsg.WalletConvDelCheckLogic", "checkGetUnProcessorWalletConversation, msgInfoList size: %s", new Object[]{Integer.valueOf(aZv.size())});
            Collection hashSet = new HashSet();
            for (au auVar : aZv) {
                if (!hashSet.contains(auVar.field_talker)) {
                    ar.Hg();
                    if (c.Fd().WY(auVar.field_talker) != null && e.ab(auVar)) {
                        hashSet.add(auVar.field_talker);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(hashSet);
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            SettingsChattingUI.b(this.qji);
            return;
        }
        SettingsChattingUI.a(this.qji).dismiss();
        h.a(this.qji, false, this.qji.getString(R.l.eWh, new Object[]{Integer.valueOf(arrayList.size())}), null, this.qji.getString(R.l.enD), this.qji.getString(R.l.dTS), new 2(this, arrayList), new 3(this), -1, R.e.brm);
    }
}
