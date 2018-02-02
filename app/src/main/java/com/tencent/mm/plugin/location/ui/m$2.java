package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class m$2 implements OnClickListener {
    final /* synthetic */ m nVm;

    m$2(m mVar) {
        this.nVm = mVar;
    }

    public final void onClick(View view) {
        String str = (String) view.getTag();
        x.d("MicroMsg.TrackPointViewMgrImpl", "onLocationTpClick, username=%s", new Object[]{str});
        if (!bh.ov(str)) {
            View viewByItag = m.d(this.nVm).getViewByItag(str);
            if (viewByItag != null && (viewByItag instanceof TrackPoint)) {
                TrackPoint trackPoint = (TrackPoint) viewByItag;
                if (trackPoint.visible) {
                    trackPoint.aWI();
                } else {
                    trackPoint.aWJ();
                }
            }
        }
    }
}
