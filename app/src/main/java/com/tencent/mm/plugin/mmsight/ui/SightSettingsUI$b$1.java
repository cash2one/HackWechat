package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.b;
import com.tencent.mm.ui.base.h$d;

class SightSettingsUI$b$1 implements h$d {
    final /* synthetic */ b oDt;

    SightSettingsUI$b$1(b bVar) {
        this.oDt = bVar;
    }

    public final void cn(int i, int i2) {
        this.oDt.oDm.ora.set(this.oDt.oDs, Integer.valueOf(this.oDt.oDr[i]));
        this.oDt.oDm.oDk.notifyDataSetChanged();
    }
}
