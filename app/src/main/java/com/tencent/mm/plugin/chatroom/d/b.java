package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.a;
import com.tencent.mm.protocal.c.dn;
import com.tencent.mm.protocal.c.do;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends a<do> {
    public b(String str, String str2, String str3, LinkedList<String> linkedList) {
        x.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s", new Object[]{str, str2, bh.VT(str3), linkedList});
        com.tencent.mm.bq.a dnVar = new dn();
        dnVar.hIF = str;
        dnVar.vIL = str2;
        dnVar.frP = str3;
        dnVar.vIM = linkedList;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = dnVar;
        aVar.hmk = new do();
        aVar.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
        aVar.hmi = 774;
        this.gJQ = aVar.JZ();
    }
}
