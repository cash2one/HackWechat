package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class SettingsPrivacyUI$2 implements OnClickListener {
    final /* synthetic */ LinearLayout qio;
    final /* synthetic */ SettingsPrivacyUI qkC;

    SettingsPrivacyUI$2(SettingsPrivacyUI settingsPrivacyUI, LinearLayout linearLayout) {
        this.qkC = settingsPrivacyUI;
        this.qio = linearLayout;
    }

    public final void onClick(View view) {
        for (int i = 0; i < this.qio.getChildCount(); i++) {
            TextView textView = (TextView) this.qio.getChildAt(i);
            if (R.h.cSe != textView.getId()) {
                textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dAq, 0, 0, 0);
            }
        }
        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.k.dAr, 0, 0, 0);
        bla com_tencent_mm_protocal_c_bla = new bla();
        if (n.qQz != null) {
            com_tencent_mm_protocal_c_bla = n.qQz.Jz(SettingsPrivacyUI.b(this.qkC));
        }
        if (com_tencent_mm_protocal_c_bla == null) {
            x.e("MicroMsg.SettingPrivacy", "userinfo is null");
            return;
        }
        int intValue = ((Integer) view.getTag()).intValue();
        x.d("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", new Object[]{Integer.valueOf(intValue)});
        a b;
        if (intValue == 0) {
            if (SettingsPrivacyUI.c(this.qkC) == e.xEm) {
                g.pQN.h(14090, new Object[]{Integer.valueOf(4)});
            }
            SettingsPrivacyUI.a(this.qkC, false);
            SettingsPrivacyUI.b(this.qkC, true);
            SettingsPrivacyUI.d(this.qkC);
            if (n.qQz != null) {
                n.qQz.a(SettingsPrivacyUI.b(this.qkC), SettingsPrivacyUI.e(this.qkC), SettingsPrivacyUI.f(this.qkC), SettingsPrivacyUI.g(this.qkC));
            }
            if (n.qQz != null) {
                b = n.qQz.b(SettingsPrivacyUI.b(this.qkC), SettingsPrivacyUI.e(this.qkC), SettingsPrivacyUI.f(this.qkC), SettingsPrivacyUI.g(this.qkC));
                n.qQz.a(SettingsPrivacyUI.b(this.qkC), b);
                if (b == null) {
                    x.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                    return;
                }
                x.d("MicroMsg.SettingPrivacy", "dancy userinfo " + b.toString());
                ar.Hg();
                c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(51, b));
            }
        } else if (intValue == 1) {
            if (SettingsPrivacyUI.c(this.qkC) == e.xEm) {
                g.pQN.h(14090, new Object[]{Integer.valueOf(5)});
            }
            SettingsPrivacyUI.a(this.qkC, true);
            SettingsPrivacyUI.b(this.qkC, false);
            SettingsPrivacyUI.d(this.qkC);
            if (n.qQz != null) {
                n.qQz.a(SettingsPrivacyUI.b(this.qkC), SettingsPrivacyUI.e(this.qkC), SettingsPrivacyUI.f(this.qkC), SettingsPrivacyUI.g(this.qkC));
            }
            if (n.qQz != null) {
                b = n.qQz.b(SettingsPrivacyUI.b(this.qkC), SettingsPrivacyUI.e(this.qkC), SettingsPrivacyUI.f(this.qkC), SettingsPrivacyUI.g(this.qkC));
                n.qQz.a(SettingsPrivacyUI.b(this.qkC), b);
                if (b == null) {
                    x.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                    return;
                }
                x.d("MicroMsg.SettingPrivacy", "dancy userinfo " + b.toString());
                ar.Hg();
                c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(51, b));
            }
        } else {
            if (SettingsPrivacyUI.c(this.qkC) == e.xEm) {
                g.pQN.h(14090, new Object[]{Integer.valueOf(6)});
            }
            SettingsPrivacyUI.a(this.qkC, false);
            SettingsPrivacyUI.b(this.qkC, false);
            SettingsPrivacyUI.d(this.qkC);
            if (n.qQz != null) {
                n.qQz.a(SettingsPrivacyUI.b(this.qkC), SettingsPrivacyUI.e(this.qkC), SettingsPrivacyUI.f(this.qkC), SettingsPrivacyUI.g(this.qkC));
            }
            if (n.qQz != null) {
                b = n.qQz.b(SettingsPrivacyUI.b(this.qkC), SettingsPrivacyUI.e(this.qkC), SettingsPrivacyUI.f(this.qkC), SettingsPrivacyUI.g(this.qkC));
                n.qQz.a(SettingsPrivacyUI.b(this.qkC), b);
                if (b == null) {
                    x.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                    return;
                }
                x.d("MicroMsg.SettingPrivacy", "dancy userinfo " + b.toString());
                ar.Hg();
                c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(51, b));
            }
        }
        view.post(new 1(this));
    }
}
