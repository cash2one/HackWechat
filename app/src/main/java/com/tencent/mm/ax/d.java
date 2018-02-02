package com.tencent.mm.ax;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import java.util.Map;

public final class d extends a {
    public String fBq;
    public LinkedList<String> hII = new LinkedList();
    public String url;

    public d(Map<String, String> map, au auVar) {
        super(map, auVar);
    }

    protected final boolean QA() {
        if (this.values == null) {
            x.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        x.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", bh.ou(this.TYPE), Integer.valueOf(this.values.size()));
        if (bh.ov(this.TYPE) || !this.TYPE.equalsIgnoreCase("delchatroommember")) {
            x.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", bh.ou(this.TYPE));
            return false;
        }
        this.url = bh.ou((String) this.values.get(".sysmsg.delchatroommember.url"));
        this.fBq = bh.ou((String) this.values.get(".sysmsg.delchatroommember.link.qrcode"));
        this.hII.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
        for (String str : this.values.keySet()) {
            if (str.startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
                this.hII.add(this.values.get(str));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str2 : this.values.keySet()) {
            if (!str2.startsWith(hIr)) {
                int length;
                if (str2.startsWith(".sysmsg.delchatroommember.link.text")) {
                    stringBuilder.append((String) this.values.get(str2));
                    this.hIv.add(this.values.get(str2));
                    length = ((String) this.values.get(str2)).length();
                } else {
                    length = i;
                }
                i = length;
            } else if (stringBuilder.length() > 0) {
                stringBuilder.insert(0, (String) this.values.get(str2));
            } else {
                stringBuilder.append((String) this.values.get(str2));
            }
        }
        this.hIw.addFirst(Integer.valueOf(stringBuilder.length() - i));
        this.hIx.add(Integer.valueOf(stringBuilder.length()));
        this.hIt = stringBuilder.toString();
        x.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", this.url, this.fBq, Integer.valueOf(this.hII.size()));
        return true;
    }
}
