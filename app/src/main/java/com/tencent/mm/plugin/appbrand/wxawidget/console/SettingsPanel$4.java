package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.picker.a;
import java.util.ArrayList;

class SettingsPanel$4 implements OnClickListener {
    final /* synthetic */ SettingsPanel khW;

    SettingsPanel$4(SettingsPanel settingsPanel) {
        this.khW = settingsPanel;
    }

    public final void onClick(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Normal");
        arrayList.add("Minimal-json");
        a aVar = new a(this.khW.getContext(), arrayList);
        aVar.Hl(((Integer) SettingsPanel.c(this.khW).getTag()).intValue());
        aVar.zyb = new 1(this, aVar);
        aVar.Hk(com.tencent.mm.bv.a.fromDPToPix(this.khW.getContext(), 288));
        aVar.show();
    }
}
