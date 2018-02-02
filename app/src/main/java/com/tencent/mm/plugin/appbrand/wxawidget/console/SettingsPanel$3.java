package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.picker.a;
import java.util.ArrayList;

class SettingsPanel$3 implements OnClickListener {
    final /* synthetic */ SettingsPanel khW;

    SettingsPanel$3(SettingsPanel settingsPanel) {
        this.khW = settingsPanel;
    }

    public final void onClick(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("MHADrawableView");
        arrayList.add("MTextureView");
        arrayList.add("MSurfaceView");
        arrayList.add("MCanvasView");
        arrayList.add("MDrawableView");
        a aVar = new a(this.khW.getContext(), arrayList);
        aVar.Hl(((Integer) SettingsPanel.b(this.khW).getTag()).intValue());
        aVar.zyb = new 1(this, aVar);
        aVar.Hk(com.tencent.mm.bv.a.fromDPToPix(this.khW.getContext(), 288));
        aVar.show();
    }
}
