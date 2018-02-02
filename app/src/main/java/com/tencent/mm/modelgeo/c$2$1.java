package com.tencent.mm.modelgeo;

import android.os.Bundle;
import com.tencent.mm.modelgeo.c.2;

class c$2$1 implements Runnable {
    final /* synthetic */ boolean hyi;
    final /* synthetic */ double hyj;
    final /* synthetic */ double hyk;
    final /* synthetic */ int hyl;
    final /* synthetic */ double hym;
    final /* synthetic */ double hyn;
    final /* synthetic */ double hyo;
    final /* synthetic */ 2 hyq;

    c$2$1(2 2, boolean z, double d, double d2, int i, double d3, double d4, double d5) {
        this.hyq = 2;
        this.hyi = z;
        this.hyj = d;
        this.hyk = d2;
        this.hyl = i;
        this.hym = d3;
        this.hyn = d4;
        this.hyo = d5;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        bundle.putString("indoor_building_floor", this.hyq.hyh.hyb);
        bundle.putString("indoor_building_id", this.hyq.hyh.hya);
        bundle.putInt("indoor_building_type", this.hyq.hyh.hyc);
        c.a(this.hyq.hyh, this.hyi, this.hyj, this.hyk, this.hyl, this.hym, this.hyn, this.hyo, bundle);
    }
}
