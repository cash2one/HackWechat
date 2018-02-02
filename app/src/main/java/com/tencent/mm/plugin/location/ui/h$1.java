package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;

class h$1 implements OnItemClickListener {
    final /* synthetic */ h nTH;

    h$1(h hVar) {
        this.nTH = hVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = (String) view.getTag();
        if (!bh.ov(str)) {
            g.pQN.h(10997, new Object[]{"15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            if (this.nTH.nTG != null) {
                this.nTH.nTG.DJ(str);
            }
        }
    }
}
