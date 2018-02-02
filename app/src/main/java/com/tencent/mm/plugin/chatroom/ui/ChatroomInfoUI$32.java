package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.protocal.c.aar;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.z.m;

class ChatroomInfoUI$32 implements a<com.tencent.mm.ae.a.a<aar>, com.tencent.mm.ae.a.a<aar>> {
    final /* synthetic */ ChatroomInfoUI lal;

    ChatroomInfoUI$32(ChatroomInfoUI chatroomInfoUI) {
        this.lal = chatroomInfoUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        if (ChatroomInfoUI.a(this.lal, aVar.errType, aVar.errCode, aVar.fnL)) {
            return null;
        }
        int i = aVar.errType;
        int i2 = aVar.errCode;
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] roomId:%s", new Object[]{ChatroomInfoUI.b(this.lal)});
            return null;
        } else if (i != 0 || i2 != 0) {
            return aVar;
        } else {
            String str = ((aar) aVar.fJJ).wjE;
            int i3 = ((aar) aVar.fJJ).wjF;
            long j = (long) ((aar) aVar.fJJ).wjH;
            String str2 = ((aar) aVar.fJJ).wjG;
            x.i("MicroMsg.ChatroomInfoUI", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s", new Object[]{ChatroomInfoUI.b(this.lal), Integer.valueOf(i3), Long.valueOf(j)});
            m.a(ChatroomInfoUI.b(this.lal), bh.ou(str), str2, j, i3);
            return aVar;
        }
    }
}
