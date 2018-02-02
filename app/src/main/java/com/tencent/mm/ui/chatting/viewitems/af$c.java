package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.ui.widget.MMNeatTextView$b;
import java.util.HashMap;
import java.util.Map;

final class af$c implements MMNeatTextView$b {
    private af$c() {
    }

    public final void a(Exception exception, String str, String str2) {
        if (!d.vAA) {
            Map hashMap = new HashMap(2);
            hashMap.put("Content", str);
            hashMap.put("Exception", exception.toString());
            hashMap.put("Stack", exception.getStackTrace());
            g.pQN.c("NeatTextView", str2, hashMap);
        }
    }
}
