package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.sdk.platformtools.ak.a;

class g$7 implements a {
    final /* synthetic */ g lMw;

    g$7(g gVar) {
        this.lMw = gVar;
    }

    public final boolean uF() {
        int size = this.lMw.lMh.size();
        int i = 0;
        while (i < size) {
            if (((b) this.lMw.lMh.get(i)).gfT.contains("internet_to_device") && ((b) this.lMw.lMh.get(i)).gfT.contains("wechat_to_device") && !this.lMw.lMi.contains(this.lMw.lMh.get(i))) {
                this.lMw.lMi.add(this.lMw.lMh.get(i));
                g.a(this.lMw, this.lMw.lMi);
            }
            i++;
        }
        return true;
    }
}
