package com.tencent.mm.plugin.offline;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class m$1 extends c<tj> {
    final /* synthetic */ m oWj;

    m$1(m mVar) {
        this.oWj = mVar;
        this.xen = tj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tj tjVar = (tj) bVar;
        if (tjVar instanceof tj) {
            switch (tjVar.fLO.action) {
                case 3:
                    if (!((com.tencent.mm.plugin.walletlock.a.b) g.h(com.tencent.mm.plugin.walletlock.a.b.class)).bNy()) {
                        if (!o.bLq().bLL()) {
                            if (!o.bLq().bLJ()) {
                                if (!o.bLq().bLM() || !a.bhH()) {
                                    if (!o.bLq().bLM() || a.bhH()) {
                                        if (o.bLq().bLN()) {
                                            tjVar.fLP.fLQ = 3;
                                            break;
                                        }
                                    }
                                    tjVar.fLP.fLQ = 4;
                                    break;
                                }
                                k.bgX();
                                e bgZ = k.bgZ();
                                x.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[]{Integer.valueOf(9), Integer.valueOf(0), bh.cgy().toString()});
                                String k = bgZ.k(9, 0, "");
                                Bitmap b = com.tencent.mm.bs.a.a.b(ac.getContext(), k, 5, 0);
                                Bitmap b2 = com.tencent.mm.bs.a.a.b(ac.getContext(), k, 0, 3);
                                tjVar.fLP.fLQ = 1;
                                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                tjVar.fLP.fLU = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.reset();
                                b2.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                tjVar.fLP.fLV = byteArrayOutputStream.toByteArray();
                                tjVar.fLP.fLW = e.aaE(k);
                                String bhR = a.bhR();
                                Bankcard bankcard = null;
                                for (Bankcard bankcard2 : a.hf(true)) {
                                    Bankcard bankcard22;
                                    if (bankcard22.field_bindSerial == null || !bankcard22.field_bindSerial.equals(bhR)) {
                                        bankcard22 = bankcard;
                                    }
                                    bankcard = bankcard22;
                                }
                                if (bankcard == null) {
                                    x.i("MicroMsg.Wear.WearOfflineLogic", "get payway fail");
                                    break;
                                }
                                tjVar.fLP.fLX = ac.getContext().getString(a$i.uXw, new Object[]{bankcard.field_desc});
                                x.i("MicroMsg.Wear.WearOfflineLogic", "payway %s", new Object[]{tjVar.fLP.fLX});
                                break;
                            }
                            tjVar.fLP.fLQ = 3;
                            break;
                        }
                        tjVar.fLP.fLQ = 2;
                        break;
                    }
                    tjVar.fLP.fLQ = 5;
                    break;
                    break;
            }
        }
        return false;
    }
}
