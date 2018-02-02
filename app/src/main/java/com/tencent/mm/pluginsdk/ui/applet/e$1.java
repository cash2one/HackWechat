package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.i.a.b;
import java.util.ArrayList;
import java.util.List;

class e$1 implements b {
    final /* synthetic */ String fgO;
    final /* synthetic */ List iPg;
    final /* synthetic */ View vni;
    final /* synthetic */ ArrayList vnj;

    e$1(View view, ArrayList arrayList, String str, List list) {
        this.vni = view;
        this.vnj = arrayList;
        this.fgO = str;
        this.iPg = list;
    }

    public final void caR() {
        bh.hideVKB(this.vni);
        if (this.vnj.size() == 0 && !bh.ov(this.fgO)) {
            ArrayList arrayList = this.vnj;
            List<String> list = this.iPg;
            if (!bh.cA(list)) {
                for (String gu : list) {
                    arrayList.add(((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gu(gu));
                }
            }
        }
    }
}
