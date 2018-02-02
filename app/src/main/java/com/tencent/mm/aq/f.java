package com.tencent.mm.aq;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class f {
    public static e a(e eVar) {
        if (eVar == null) {
            return null;
        }
        if (!eVar.Pe()) {
            return eVar;
        }
        e hQ = o.Pw().hQ(eVar.hzZ);
        if (hQ != null) {
            return hQ;
        }
        return eVar;
    }

    public static boolean b(e eVar) {
        if (eVar == null) {
            return false;
        }
        int i = eVar.offset;
        int i2 = eVar.hlp;
        long j = eVar.fFo;
        if (eVar.Pe()) {
            e hQ = o.Pw().hQ(eVar.hzZ);
            i = hQ.offset;
            i2 = hQ.hlp;
            j = hQ.fFo;
        }
        if (i2 == 0) {
            return true;
        }
        if ((i != i2 || i2 == 0) && r2 == 0) {
            return false;
        }
        return true;
    }

    public static String c(e eVar) {
        if (eVar == null) {
            return "";
        }
        if (!eVar.Pe()) {
            return eVar.hzQ;
        }
        e hQ = o.Pw().hQ(eVar.hzZ);
        if (hQ == null) {
            return "";
        }
        return hQ.hzQ;
    }

    public static String c(String str, String str2, String str3, String str4) {
        if (bh.ov(str)) {
            return null;
        }
        return String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[]{str, bh.ou(str2), bh.ou(str3), bh.ou(str4)});
    }

    public static final a lk(String str) {
        if (bh.ov(str)) {
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map y = bi.y(str, "msg");
        if (y == null) {
            x.e("MicroMsg.ImgInfoLogic", "parseImg failed");
            return null;
        }
        a aVar = new a();
        aVar.appId = (String) y.get(".msg.appinfo.appid");
        aVar.mediaTagName = (String) y.get(".msg.appinfo.mediatagname");
        aVar.messageExt = (String) y.get(".msg.appinfo.messageext");
        aVar.messageAction = (String) y.get(".msg.appinfo.messageaction");
        return aVar;
    }
}
