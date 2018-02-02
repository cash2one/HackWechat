package com.tencent.mm.z;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.Map;

public final class bc {
    public static int hgY = 0;

    public static void w(String str, boolean z) {
        if (!"bizflag".equals(str)) {
            return;
        }
        if (z) {
            hgY |= 1;
        } else {
            hgY &= -2;
        }
    }

    public static String HC() {
        StringBuilder stringBuilder = new StringBuilder();
        if (hgY != 0) {
            stringBuilder.append("<");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
            stringBuilder.append(hgY);
            stringBuilder.append("</");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
        }
        return stringBuilder.toString();
    }

    public static int k(au auVar) {
        if (auVar == null) {
            return 0;
        }
        int i;
        Map y = bi.y(auVar.gjF, "msgsource");
        if (y != null) {
            String str = (String) y.get(".msgsource.bizflag");
            if (!bh.ov(str)) {
                i = bh.getInt(str, 0);
                return i;
            }
        }
        i = 0;
        return i;
    }

    public static String HD() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bh.ou(HC()));
        if (stringBuilder.length() <= 0) {
            return null;
        }
        stringBuilder.insert(0, "<msgsource>");
        stringBuilder.append("</msgsource>");
        return stringBuilder.toString();
    }

    public static String HE() {
        String str = (String) g.Dj().CU().get(70, null);
        if (!bh.ov(str)) {
            g.Dj().CU().set(70, "");
        }
        x.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", new Object[]{str});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append(bh.ou(str));
        if (hgY != 0) {
            stringBuilder.append("<");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
            stringBuilder.append(hgY);
            stringBuilder.append("</");
            stringBuilder.append("bizflag");
            stringBuilder.append(">");
        }
        stringBuilder.append("</msgsource>");
        return stringBuilder.toString();
    }

    public static void hV(String str) {
        x.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[]{str, ""});
    }
}
