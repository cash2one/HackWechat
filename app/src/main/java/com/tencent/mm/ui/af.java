package com.tencent.mm.ui;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;

public final class af {
    public static List<String> cnG() {
        int FW = q.FW();
        List<String> arrayList = new ArrayList();
        if ((FW & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            arrayList.add("floatbottle");
            x.d("MicroMsg.LauncherUI", "add bottle into show unread count blacklist.");
        }
        ar.Hg();
        if (!c.CU().getBoolean(a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("notifymessage");
            x.d("MicroMsg.UnreadCountHelper", "add service notify message into show unread count blacklist.");
        }
        ar.Hg();
        if (!c.CU().getBoolean(a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("appbrandcustomerservicemsg");
            x.d("MicroMsg.UnreadCountHelper", "add wxa custom session notify message into show unread count blacklist.");
        }
        x.d("MicroMsg.LauncherUI", "getShowUnreadCountBlacklist unread count blacklist(size : %s).", Integer.valueOf(arrayList.size()));
        return arrayList;
    }
}
