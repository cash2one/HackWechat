package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.protocal.c.aqg;
import com.tencent.mm.protocal.c.aqh;
import com.tencent.mm.protocal.c.aqi;
import java.util.LinkedList;

public final class j extends c {
    protected final void aLV() {
        a aVar = new a();
        aVar.hmj = new aqg();
        aVar.hmk = new aqh();
        aVar.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
        aVar.hmi = 1707;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1707;
    }

    public j(LinkedList<aqi> linkedList, int i) {
        aLV();
        aqg com_tencent_mm_protocal_c_aqg = (aqg) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aqg.wxc = Build.BRAND;
        com_tencent_mm_protocal_c_aqg.wxb = i;
        com_tencent_mm_protocal_c_aqg.wxa = linkedList;
    }

    public final aqh aMi() {
        return (aqh) this.gJQ.hmh.hmo;
    }
}
