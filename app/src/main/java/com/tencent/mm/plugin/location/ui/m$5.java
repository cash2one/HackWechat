package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.plugin.location.model.i.a;
import com.tencent.mm.sdk.platformtools.x;

class m$5 implements a {
    final /* synthetic */ m nVm;

    m$5(m mVar) {
        this.nVm = mVar;
    }

    public final void n(double d) {
        if (m.e(this.nVm) != null) {
            x.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[]{Double.valueOf(d)});
            m.e(this.nVm).o(d);
        }
    }
}
