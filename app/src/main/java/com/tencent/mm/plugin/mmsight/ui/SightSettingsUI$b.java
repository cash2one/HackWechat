package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.storage.w.a;

class SightSettingsUI$b {
    final /* synthetic */ SightSettingsUI oDm;
    public String oDp;
    String[] oDq;
    int[] oDr;
    a oDs;

    public SightSettingsUI$b(SightSettingsUI sightSettingsUI, String str, a aVar, String[] strArr, int[] iArr) {
        this.oDm = sightSettingsUI;
        this.oDp = str;
        this.oDq = strArr;
        this.oDs = aVar;
        this.oDr = iArr;
    }

    final String tc(int i) {
        int i2 = 0;
        while (i2 < this.oDr.length) {
            if (i == this.oDr[i2] && i2 < this.oDq.length) {
                return this.oDq[i2];
            }
            i2++;
        }
        return this.oDq[0];
    }
}
