package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class e {
    private static final f<Integer, e> hdO = new f(100);
    public String fny;
    public int hbb;
    public String hbc;
    public int rWq;
    public int rWr;
    public String rWs;
    public int rWt;
    public int rWu;
    public int rWv;
    public int rWw;

    public static e Mj(String str) {
        if (bh.ov(str)) {
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        int hashCode = str.hashCode();
        e eVar = (e) hdO.get(Integer.valueOf(hashCode));
        if (eVar != null) {
            return eVar;
        }
        Map y = bi.y(str, "msg");
        if (y == null) {
            x.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
            return null;
        }
        try {
            e eVar2 = new e();
            eVar2.hbb = bh.getInt((String) y.get(".msg.appmsg.appattach.totallen"), 0);
            eVar2.fny = (String) y.get(".msg.appmsg.appattach.attachid");
            eVar2.hbc = (String) y.get(".msg.appmsg.appattach.fileext");
            eVar2.rWq = bh.getInt((String) y.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
            eVar2.rWr = bh.getInt((String) y.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
            eVar2.rWs = (String) y.get(".msg.appmsg.voicecmd.reminder.$remindattachid");
            eVar2.rWt = bh.getInt((String) y.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
            eVar2.rWu = bh.getInt((String) y.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
            eVar2.rWv = bh.getInt((String) y.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
            eVar2.rWw = bh.getInt((String) y.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
            hdO.l(Integer.valueOf(hashCode), eVar2);
            return eVar2;
        } catch (Throwable e) {
            x.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
            x.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", e, "", new Object[0]);
            return null;
        }
    }
}
