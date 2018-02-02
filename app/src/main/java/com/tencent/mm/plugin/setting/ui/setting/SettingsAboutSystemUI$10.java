package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class SettingsAboutSystemUI$10 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI qin;
    final /* synthetic */ LinearLayout qio;

    SettingsAboutSystemUI$10(SettingsAboutSystemUI settingsAboutSystemUI, LinearLayout linearLayout) {
        this.qin = settingsAboutSystemUI;
        this.qio = linearLayout;
    }

    public final void onClick(View view) {
        int i;
        int i2;
        int i3 = 0;
        for (i = 0; i < this.qio.getChildCount(); i++) {
            TextView textView = (TextView) this.qio.getChildAt(i);
            if (R.h.cSe != textView.getId()) {
                textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dAq, 0, 0, 0);
            }
        }
        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.k.dAr, 0, 0, 0);
        ar.Hg();
        int intValue = ((Integer) c.CU().get(7, Integer.valueOf(0))).intValue();
        int intValue2 = ((Integer) view.getTag()).intValue();
        x.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", new Object[]{Integer.valueOf(intValue2)});
        if (intValue2 == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if ((intValue & 16777216) == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i != i2) {
            if (intValue2 == 0) {
                i3 = 1;
            }
            if (i3 != 0) {
                i = -16777217 & intValue;
            } else {
                i = intValue | 16777216;
            }
            i2 = i3 == 0 ? 1 : 2;
            ar.Hg();
            c.CU().set(7, Integer.valueOf(i));
            a wlVar = new wl();
            wlVar.wgL = 35;
            wlVar.wgM = i2;
            ar.Hg();
            c.EX().b(new e.a(23, wlVar));
            com.tencent.mm.plugin.setting.a.ift.um();
            view.post(new 1(this));
        }
    }
}
