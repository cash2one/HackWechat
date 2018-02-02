package com.tencent.mm.plugin.setting.ui.setting;

import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.FTSEditTextView.a;
import com.tencent.mm.ui.fts.widget.a.b;
import java.util.List;

class SettingsSearchAuthUI$2 implements a {
    final /* synthetic */ SettingsSearchAuthUI qkQ;

    SettingsSearchAuthUI$2(SettingsSearchAuthUI settingsSearchAuthUI) {
        this.qkQ = settingsSearchAuthUI;
    }

    public final void bqa() {
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        x.i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", new Object[]{str});
        if (bh.ov(str)) {
            SettingsSearchAuthUI.c(this.qkQ);
            return;
        }
        SettingsSearchAuthUI.a(this.qkQ);
        String string = this.qkQ.getString(R.l.dGz);
        CharSequence jVar = new j(string + " " + str.trim());
        jVar.setSpan(new ForegroundColorSpan(this.qkQ.getResources().getColor(R.e.bsE)), string.length(), jVar.length(), 33);
        SettingsSearchAuthUI.b(this.qkQ).setText(jVar);
    }

    public final void hL(boolean z) {
        x.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.qkQ.showVKB();
        } else {
            this.qkQ.aWs();
        }
    }

    public final void cs(View view) {
        x.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
        SettingsSearchAuthUI.c(this.qkQ);
    }

    public final boolean akL() {
        x.i("MicroMsg.SettingsSearchAuthUI", "search key down");
        CharSequence text = SettingsSearchAuthUI.d(this.qkQ).zet.yig.getText();
        SettingsSearchAuthUI.b(this.qkQ).setVisibility(8);
        SettingsSearchAuthUI.d(this.qkQ).zet.yig.clearFocus();
        this.qkQ.aWs();
        SettingsSearchAuthUI.e(this.qkQ);
        if (!bh.M(text)) {
            SettingsSearchAuthUI.a(this.qkQ, text.toString().trim());
        }
        return true;
    }
}
