package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class SettingsAboutSystemUI$2 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI qin;
    final /* synthetic */ LinearLayout qio;
    final /* synthetic */ int qip;

    SettingsAboutSystemUI$2(SettingsAboutSystemUI settingsAboutSystemUI, LinearLayout linearLayout, int i) {
        this.qin = settingsAboutSystemUI;
        this.qio = linearLayout;
        this.qip = i;
    }

    public final void onClick(View view) {
        for (int i = 0; i < this.qio.getChildCount(); i++) {
            TextView textView = (TextView) this.qio.getChildAt(i);
            if (R.h.cSe != textView.getId()) {
                textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dAq, 0, 0, 0);
            }
        }
        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.k.dAr, 0, 0, 0);
        int intValue = ((Integer) view.getTag()).intValue();
        x.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", new Object[]{Integer.valueOf(this.qip), Integer.valueOf(intValue)});
        if (this.qip != intValue) {
            view.post(new 1(this, intValue));
        }
    }
}
