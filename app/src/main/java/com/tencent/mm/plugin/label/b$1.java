package com.tencent.mm.plugin.label;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class b$1 implements e {
    final /* synthetic */ b nOz;

    b$1(b bVar) {
        this.nOz = bVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
        switch (kVar.getType()) {
            case 635:
                if (i == 0 && i2 == 0) {
                    b.g(this.nOz.username, this.nOz.nOw);
                    return;
                }
                this.nOz.aUT();
                x.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
                return;
            case 638:
                if (i == 0 && i2 == 0) {
                    int i3;
                    int i4;
                    if (this.nOz.nOx == null || this.nOz.nOx.isEmpty()) {
                        i3 = 0;
                    } else {
                        i3 = this.nOz.nOx.size();
                    }
                    if (this.nOz.nOw == null || this.nOz.nOw.isEmpty()) {
                        i4 = 0;
                    } else {
                        i4 = this.nOz.nOw.size() - i3;
                    }
                    if (i3 > 0 || i4 > 0) {
                        x.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                        g.pQN.h(11220, new Object[]{q.FS(), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(0)});
                    }
                }
                this.nOz.aUT();
                return;
            default:
                return;
        }
    }
}
