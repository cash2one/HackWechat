package com.tencent.mm.modelgeo;

import android.os.Bundle;
import com.tencent.mm.modelgeo.c.1;

class c$1$1 implements Runnable {
    final /* synthetic */ boolean hyi;
    final /* synthetic */ double hyj;
    final /* synthetic */ double hyk;
    final /* synthetic */ int hyl;
    final /* synthetic */ double hym;
    final /* synthetic */ double hyn;
    final /* synthetic */ double hyo;
    final /* synthetic */ 1 hyp;

    c$1$1(1 1, boolean z, double d, double d2, int i, double d3, double d4, double d5) {
        this.hyp = 1;
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
        bundle.putString("indoor_building_floor", this.hyp.hyh.hyb);
        bundle.putString("indoor_building_id", this.hyp.hyh.hya);
        bundle.putInt("indoor_building_type", this.hyp.hyh.hyc);
        c.a(this.hyp.hyh, this.hyi, this.hyj, this.hyk, this.hyl, this.hym, this.hyn, this.hyo, bundle);
    }
}
