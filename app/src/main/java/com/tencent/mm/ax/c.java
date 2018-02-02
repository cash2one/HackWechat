package com.tencent.mm.ax;

import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import java.util.Map;

public final class c extends a {
    public String frP;
    public LinkedList<String> hIA = new LinkedList();
    public int hIC;
    public LinkedList<String> hID = new LinkedList();
    public LinkedList<String> hIE = new LinkedList();
    public String hIF = null;
    public String hIG = null;
    public String hIH = null;
    public String hIz;
    public String text = null;

    public c(Map<String, String> map, au auVar) {
        super(map, auVar);
    }

    protected final boolean QA() {
        int i = 0;
        if (this.values == null) {
            x.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        x.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", bh.ou(this.TYPE), Integer.valueOf(this.values.size()));
        if (bh.ov(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            x.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", bh.ou(this.TYPE));
            return false;
        }
        this.hIz = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket";
        String str3 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername";
        String str4 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason";
        String str5 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize";
        if (this.values.containsKey(str)) {
            this.hIH = bh.ou((String) this.values.get(str));
        }
        if (this.values.containsKey(str3)) {
            this.hIF = bh.ou((String) this.values.get(str3));
        }
        if (this.values.containsKey(str4)) {
            this.hIG = bh.ou((String) this.values.get(str4));
        }
        if (this.values.containsKey(hIr)) {
            this.text = bh.ou((String) this.values.get(hIr));
        }
        if (this.values.containsKey(str2)) {
            this.frP = (String) this.values.get(str2);
        }
        if (this.values.containsKey(str5)) {
            this.hIC = bh.getInt((String) this.values.get(str5), 0);
        }
        if (this.fEJ.cjz()) {
            this.hIv.clear();
            this.hIw.clear();
            this.hIx.clear();
            this.hIt = this.text + " ";
            this.hIw.add(Integer.valueOf(this.hIt.length()));
            this.hIv.add(ac.getContext().getString(a.eoZ));
            this.hIt += ac.getContext().getString(a.eoZ);
            this.hIx.add(Integer.valueOf(this.hIt.length()));
        } else {
            this.hIw.add(Integer.valueOf(this.text.length()));
            this.hIv.add(this.hIH);
            this.hIt = this.text + this.hIH;
            this.hIx.add(Integer.valueOf(this.hIt.length()));
        }
        while (i < this.hIC) {
            if (i == 0) {
                this.hIA.add(bh.ou((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
                this.hID.add(bh.ou((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
                this.hIE.add(bh.ou((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
            } else {
                this.hIA.add(bh.ou((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
                this.hID.add(bh.ou((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
                this.hIE.add(bh.ou((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
            }
            i++;
        }
        return true;
    }
}
