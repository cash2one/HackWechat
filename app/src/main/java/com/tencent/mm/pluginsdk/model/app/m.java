package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public final class m implements t {
    private volatile boolean veA = false;
    private List<String> vec = new ArrayList();
    public Vector<String> vez = new Vector();

    public m() {
        a.aRi().a(1, this);
    }

    public final void OI(String str) {
        x.d("MicroMsg.AppSettingService", "appId = " + str);
        if (bh.ov(str)) {
            x.e("MicroMsg.AppSettingService", "add appId is null");
            return;
        }
        if (!this.vez.contains(str)) {
            this.vez.add(str);
        }
        aQU();
    }

    public final void cv(List<String> list) {
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.AppSettingService", "addAll list is null");
            return;
        }
        for (String str : list) {
            if (!(bh.ov(str) || this.vez.contains(str))) {
                this.vez.add(str);
            }
        }
        aQU();
    }

    private void aQU() {
        int i = 20;
        if (this.veA) {
            x.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
        } else if (this.vez.size() <= 0) {
            x.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
        } else {
            x.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.vez.size());
            int size = this.vez.size();
            if (size <= 20) {
                i = size;
            }
            this.veA = true;
            this.vec.addAll(this.vez.subList(0, i));
            g.Di().gPJ.a(new x(1, new ae(this.vec)), 0);
        }
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (wVar.getType() == 1) {
            this.veA = false;
            x.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + ((ae) wVar).veR.size());
            this.vez.removeAll(this.vec);
            this.vec.clear();
            aQU();
        }
    }
}
