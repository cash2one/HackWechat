package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.l;
import java.util.List;

class SettingsAboutSystemUI$5 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI qin;

    SettingsAboutSystemUI$5(SettingsAboutSystemUI settingsAboutSystemUI) {
        this.qin = settingsAboutSystemUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SettingsAboutSystemUI.a(this.qin, false);
        SettingsAboutSystemUI settingsAboutSystemUI = this.qin;
        Context context = this.qin;
        this.qin.getString(R.l.dGO);
        SettingsAboutSystemUI.a(settingsAboutSystemUI, h.a(context, this.qin.getString(R.l.dHc), true, new 1(this)));
        ar.Hg();
        List ciF = c.Fd().ciF();
        if (ciF.size() > 0) {
            List A = l.A(ciF);
            if (A != null) {
                for (int i2 = 0; i2 < A.size(); i2++) {
                    if (((Boolean) A.get(i2)).booleanValue()) {
                        a.ift.cB((String) ciF.get(i2));
                    }
                }
            }
        }
        ba.a(new ba.a(this) {
            final /* synthetic */ SettingsAboutSystemUI$5 qiv;

            {
                this.qiv = r1;
            }

            public final boolean HB() {
                return SettingsAboutSystemUI.b(this.qiv.qin);
            }

            public final void HA() {
                if (SettingsAboutSystemUI.c(this.qiv.qin) != null) {
                    SettingsAboutSystemUI.c(this.qiv.qin).dismiss();
                    SettingsAboutSystemUI.a(this.qiv.qin, null);
                }
            }
        });
    }
}
