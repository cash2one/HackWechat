package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.q;

public final class j extends c<sq> {
    public j() {
        this.xen = sq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        final sq sqVar = (sq) bVar;
        g.Dk();
        final int intValue = ((Integer) g.Dj().CU().get(a.xrD, Integer.valueOf(0))).intValue();
        int FZ = q.FZ();
        sqVar.fKv.retCode = 0;
        if (FZ == 4) {
            if (intValue != sqVar.fKu.fKy) {
                x.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong region, client: %s, req: %s", new Object[]{Integer.valueOf(intValue), Integer.valueOf(sqVar.fKu.fKy)});
                sqVar.fKv.retCode = -1;
            } else if ("fetch".equals(sqVar.fKu.action)) {
                String str;
                x.i("MicroMsg.HandleWCPayWalletBufferListener", "do fetch");
                switch (intValue) {
                    case 1:
                        g.Dk();
                        str = (String) g.Dj().CU().get(a.xwL, "");
                        break;
                    case 2:
                        g.Dk();
                        str = (String) g.Dj().CU().get(a.xwM, "");
                        break;
                    case 4:
                        g.Dk();
                        str = (String) g.Dj().CU().get(a.xwN, "");
                        break;
                    case 8:
                        g.Dk();
                        str = (String) g.Dj().CU().get(a.xwO, "");
                        break;
                    default:
                        str = "";
                        break;
                }
                if (bh.ov(str)) {
                    x.i("MicroMsg.HandleWCPayWalletBufferListener", "fetch empty buffer");
                    sqVar.fKv.retCode = -2;
                } else {
                    a(sqVar, new 1(this, sqVar, str));
                }
            } else if ("save".equals(sqVar.fKu.action)) {
                x.i("MicroMsg.HandleWCPayWalletBufferListener", "do save");
                a(sqVar, new e(this) {
                    final /* synthetic */ j sDJ;

                    public final void a(int i, int i2, String str, k kVar) {
                        g.Dk();
                        g.Di().gPJ.b(1767, this);
                        if (i == 0 && i2 == 0) {
                            int i3 = intValue;
                            String str2 = sqVar.fKu.buffer;
                            switch (i3) {
                                case 1:
                                    g.Dk();
                                    g.Dj().CU().a(a.xwL, str2);
                                    break;
                                case 2:
                                    g.Dk();
                                    g.Dj().CU().a(a.xwM, str2);
                                    break;
                                case 4:
                                    g.Dk();
                                    g.Dj().CU().a(a.xwN, str2);
                                    break;
                                case 8:
                                    g.Dk();
                                    g.Dj().CU().a(a.xwO, str2);
                                    break;
                            }
                            sqVar.fKv.fKz.run();
                            return;
                        }
                        x.i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", new Object[]{Integer.valueOf(i2), str});
                        sqVar.fKv.retCode = -1;
                        sqVar.fKv.fKz.run();
                    }
                });
            } else {
                x.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong action: %s", new Object[]{sqVar.fKu.action});
                sqVar.fKv.retCode = -1;
            }
            sqVar.fKv.fKz.run();
        } else {
            x.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong type: %s", new Object[]{Integer.valueOf(FZ)});
            sqVar.fKv.retCode = -1;
            sqVar.fKv.fKz.run();
        }
        return false;
    }

    private static void a(sq sqVar, e eVar) {
        x.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
        g.Dk();
        g.Di().gPJ.a(1767, eVar);
        sq.a aVar = sqVar.fKu;
        x.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", new Object[]{aVar.appId, aVar.nonceStr, aVar.fqD, aVar.fKw, aVar.fKx, aVar.signType, aVar.url});
        k aVar2 = new com.tencent.mm.plugin.wallet_core.c.a.a(aVar.appId, aVar.nonceStr, aVar.fqD, aVar.fKw, aVar.fKx, aVar.signType, aVar.url);
        g.Dk();
        g.Di().gPJ.a(aVar2, 0);
    }
}
