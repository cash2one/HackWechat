package com.tencent.mm.app.plugin.a;

import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.g.a.la;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$b extends c<la> {
    final /* synthetic */ a fhy;

    a$b(a aVar) {
        this.fhy = aVar;
        this.xen = la.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        la laVar = (la) bVar;
        if (this.fhy.fhr != null) {
            if (!this.fhy.fhr.csq().isFinishing()) {
                int i = laVar.fCm.op;
                String str = laVar.fCm.fzF;
                x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "opcode is %d, brand name is %s", new Object[]{Integer.valueOf(i), str});
                if (this.fhy.fhr.crz().equals(str)) {
                    switch (i) {
                        case 1:
                            a aVar = this.fhy;
                            x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "handleConnectFailedReason, reason : %d, brand name : %s", new Object[]{Integer.valueOf(laVar.fCm.aAk), str});
                            d jS = f.jS(str);
                            if (a.a(jS)) {
                                if (jS.bI(false).Ly().hpb == 1) {
                                    aVar.fhr.csq().setMMSubTitle(null);
                                    break;
                                }
                            }
                            x.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[]{str});
                            break;
                            break;
                        case 2:
                            this.fhy.e(laVar.fCm.fsg, str, laVar.fCm.ffq);
                            break;
                        case 3:
                            if (this.fhy.fhv != null) {
                                this.fhy.fhv.clear();
                                x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "clear connected device ids successfully.");
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
                x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "not current brandname");
            } else {
                x.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context isFinishing");
            }
        } else {
            x.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context == null");
        }
        return false;
    }
}
