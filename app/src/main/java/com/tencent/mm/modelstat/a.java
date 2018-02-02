package com.tencent.mm.modelstat;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;

public final class a {
    public static void a(au auVar, a aVar) {
        if (!bh.ov(auVar.gjO)) {
            int i;
            d dVar = new d();
            dVar.q("20ExpIdStr", auVar.gjO + ",");
            dVar.q("21OpType", aVar.value + ",");
            dVar.q("22msgId", auVar.field_msgSvrId + ",");
            dVar.q("23MessageType", auVar.getType() + ",");
            if (auVar.aNc()) {
                com.tencent.mm.y.g.a I = com.tencent.mm.y.g.a.I(auVar.field_content, auVar.field_reserved);
                i = I == null ? 0 : I.type;
            } else {
                i = 0;
            }
            String str = auVar.field_talker;
            dVar.q("24AppMsgInnerType", i + ",");
            dVar.q("25curUsername", str + ",");
            String str2 = "";
            if (auVar.field_isSend == 1) {
                str2 = q.FS();
            } else if (str == null || !str.endsWith("@chatroom")) {
                str2 = str;
            } else if (auVar.field_content != null) {
                int hO = ba.hO(auVar.field_content);
                if (hO != -1) {
                    str2 = auVar.field_content.substring(0, hO).trim();
                }
            }
            dVar.q("26msgPostUserName", str2 + ",");
            dVar.q("27MediaState", auVar.gjP + ",");
            x.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + dVar.Sz());
            g.pQN.h(13564, new Object[]{dVar});
        }
    }
}
