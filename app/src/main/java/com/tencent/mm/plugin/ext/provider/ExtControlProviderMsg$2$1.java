package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.2;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class ExtControlProviderMsg$2$1 implements e {
    final /* synthetic */ String maB;
    final /* synthetic */ 2 maC;

    ExtControlProviderMsg$2$1(2 2, String str) {
        this.maC = 2;
        this.maB = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar == null) {
            x.e("MicroMsg.ExtControlProviderMsg", "scene == null");
            ar.CG().b(522, this);
            this.maC.maz.pp(4);
            this.maC.kvk.countDown();
            return;
        }
        switch (kVar.getType()) {
            case 522:
                if (i != 0 || i2 != 0) {
                    x.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + i + ", errCode = " + i2);
                    ExtControlProviderMsg.a(this.maC.maz).addRow(new Object[]{this.maB, Integer.valueOf(2)});
                    this.maC.maz.pp(4);
                    break;
                }
                x.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                ExtControlProviderMsg.a(this.maC.maz).addRow(new Object[]{this.maB, Integer.valueOf(1)});
                break;
            default:
                this.maC.maz.pp(0);
                break;
        }
        this.maC.kvk.countDown();
        ar.CG().b(522, this);
    }
}
