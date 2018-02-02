package com.tencent.mm.z;

import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.List;

public final class l {
    public static boolean ga(String str) {
        if (!s.eV(str)) {
            return false;
        }
        long j;
        boolean z;
        aj WY = ((h) g.h(h.class)).Fd().WY(str);
        if (WY == null || WY.field_lastSeq == 0 || ((h) g.h(h.class)).aZi().G(str, WY.field_lastSeq).field_msgId != 0) {
            j = 0;
            z = false;
        } else {
            j = WY.field_lastSeq;
            z = true;
        }
        if (!z) {
            cf EU = ((h) g.h(h.class)).aZi().EU(str);
            if (!(EU == null || EU.field_msgId == 0)) {
                z = true;
            }
        }
        if (j == 0) {
            j = ((h) g.h(h.class)).aZi().ET(str);
        }
        if (j != 0) {
            ((h) g.h(h.class)).FJ().C(str, j);
        }
        x.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", new Object[]{str, Boolean.valueOf(z), Long.valueOf(j)});
        return z;
    }

    public static List<Boolean> A(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String ga : list) {
            arrayList.add(Boolean.valueOf(ga(ga)));
        }
        return arrayList;
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3) {
        a(str, list, str2, z, str3, 2);
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3, int i) {
        au auVar = new au();
        auVar.dS(str);
        auVar.setType(10000);
        auVar.aq(System.currentTimeMillis());
        auVar.eQ(4);
        auVar.eR(i);
        CharSequence stringBuffer = new StringBuffer();
        if (list != null) {
            String FS = q.FS();
            String string = ac.getContext().getString(a.dQz);
            for (String str4 : list) {
                if (!str4.equals(FS)) {
                    com.tencent.mm.l.a WO = ((h) g.h(h.class)).EY().WO(str4);
                    if (WO == null || ((int) WO.gJd) == 0) {
                        if (z) {
                            stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + str4 + "</a>" + string);
                        } else {
                            stringBuffer.append(str4 + string);
                        }
                    } else if (z) {
                        stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + WO.AQ() + "</a>" + string);
                    } else {
                        stringBuffer.append(WO.AQ() + string);
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(string));
            }
        }
        auVar.setContent(str2.replace("%s", stringBuffer));
        ((h) g.h(h.class)).aZi().Q(auVar);
    }
}
