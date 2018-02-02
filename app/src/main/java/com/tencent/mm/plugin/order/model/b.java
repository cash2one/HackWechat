package com.tencent.mm.plugin.order.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    public HashSet<String> pai = new HashSet();

    public b() {
        aJh();
    }

    private void aJh() {
        this.pai.clear();
        g.Dk();
        for (String str : bh.F(((String) g.Dj().CU().get(204803, "")).split(";"))) {
            if (!(bh.ov(str) || this.pai.contains(str))) {
                this.pai.add(str);
            }
        }
        g.Dk();
        g.Dj().CU().set(204817, Integer.valueOf(this.pai.size()));
        x.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.pai.size());
    }

    public final void bix() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.pai.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!bh.ov(str)) {
                stringBuffer.append(str + ";");
            }
        }
        g.Dk();
        g.Dj().CU().set(204803, stringBuffer.toString());
    }
}
