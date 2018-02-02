package com.tencent.mm.ax;

import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import java.util.Map;

public final class b extends a {
    public String frP = null;
    public LinkedList<String> hIA = new LinkedList();
    public String hIB = null;
    public String hIz;
    public String text = null;

    public b(Map<String, String> map, au auVar) {
        super(map, auVar);
    }

    protected final boolean QA() {
        if (this.values == null) {
            x.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        x.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", bh.ou(this.TYPE), Integer.valueOf(this.values.size()));
        if (bh.ov(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            x.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", bh.ou(this.TYPE));
            return false;
        }
        this.hIz = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket";
        if (this.values.containsKey(hIr)) {
            this.text = bh.ou((String) this.values.get(hIr));
        }
        if (this.values.containsKey(str)) {
            this.hIB = bh.ou((String) this.values.get(str));
        }
        if (this.values.containsKey(str2)) {
            this.frP = bh.ou((String) this.values.get(str2));
        }
        this.hIt = this.text;
        if (this.fEJ.cjz()) {
            this.hIt += " " + ac.getContext().getString(a.kYR);
        } else {
            this.hIv.add(this.hIB);
            this.hIw.add(Integer.valueOf(this.hIt.length()));
            this.hIt += this.hIB;
            this.hIx.add(Integer.valueOf(this.hIt.length()));
        }
        for (String str3 : this.values.keySet()) {
            if (str3.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
                this.hIA.add(this.values.get(str3));
            }
        }
        return true;
    }
}
