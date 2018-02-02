package com.tencent.mm.plugin.product.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public List<String> pec = new ArrayList();

    public d() {
        WT();
    }

    private void WT() {
        this.pec.clear();
        g.Dk();
        String str = (String) g.Dj().CU().get(270340, "");
        x.d("MicroMsg.MallNewsManager", "data : " + str);
        for (String str2 : bh.F(str2.split(";"))) {
            if (!bh.ov(str2)) {
                this.pec.add(str2);
            }
        }
    }

    public final boolean bjh() {
        x.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.pec.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.pec) {
            if (!(bh.ov(str) || str.contains(";"))) {
                stringBuffer.append(str);
            }
        }
        x.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        g.Dk();
        g.Dj().CU().set(270340, stringBuffer.toString());
        return true;
    }
}
