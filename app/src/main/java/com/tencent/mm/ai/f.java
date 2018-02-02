package com.tencent.mm.ai;

import com.tencent.mm.bf.l;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.z.af;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import java.util.LinkedList;

public final class f extends af {
    public final boolean gN(int i) {
        return i != 0 && i < 604307701;
    }

    public final void transfer(int i) {
        if (i != 0 && i < 604307701) {
            g.pQN.h(336, 11);
            ar.Hg();
            au[] bF = c.Fa().bF("fmessage", 20);
            if (bF == null) {
                x.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
                return;
            }
            l.Tx();
            x.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + bF.length);
            for (cf cfVar : bF) {
                if (cfVar != null && cfVar.field_msgId != 0) {
                    x.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + cfVar.getType());
                    String str = cfVar.field_content;
                    if (str != null && str.length() != 0) {
                        com.tencent.mm.bf.f fVar;
                        switch (cfVar.getType()) {
                            case 37:
                                x.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + cfVar.field_content);
                                d Xu = d.Xu(cfVar.field_content);
                                if (!t.ov(Xu.rYX) && (Xu.scene == 18 || ba.gS(Xu.scene))) {
                                    x.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + Xu.scene);
                                    break;
                                }
                                fVar = new com.tencent.mm.bf.f();
                                fVar.field_createTime = cfVar.field_createTime;
                                fVar.field_isSend = 0;
                                fVar.field_msgContent = cfVar.field_content;
                                fVar.field_svrId = cfVar.field_msgSvrId;
                                fVar.field_talker = Xu.rYX;
                                switch (Xu.fuL) {
                                    case 2:
                                        fVar.field_type = 1;
                                        break;
                                    case 5:
                                        fVar.field_type = 2;
                                        break;
                                    case 6:
                                        fVar.field_type = 3;
                                        break;
                                    default:
                                        fVar.field_type = 1;
                                        break;
                                }
                                l.Tw().a(fVar);
                                break;
                            case 40:
                                x.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + cfVar.field_content);
                                a Xr = a.Xr(cfVar.field_content);
                                fVar = new com.tencent.mm.bf.f();
                                fVar.field_createTime = cfVar.field_createTime;
                                fVar.field_isSend = 0;
                                fVar.field_msgContent = cfVar.field_content;
                                fVar.field_svrId = cfVar.field_msgSvrId;
                                fVar.field_talker = Xr.rYX;
                                fVar.field_type = 0;
                                l.Tw().a(fVar);
                                break;
                            default:
                                x.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + cfVar.getType());
                                break;
                        }
                    }
                    x.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + cfVar.field_msgId);
                } else {
                    x.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
                }
            }
            ar.Hg();
            c.CU().set(143618, Integer.valueOf(0));
            l.Tx().Tk();
            x.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
            ar.Hg();
            c.EY().WU("fmessage");
            LinkedList linkedList = new LinkedList();
            linkedList.add("fmessage");
            ar.Hg();
            c.Fd().aw(linkedList);
        }
    }

    public final String getTag() {
        return "MicroMsg.FMessageDataTransfer";
    }
}
