package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.sdk.platformtools.bh;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;

public final class c extends a {
    public c(a$b com_tencent_mm_ui_chatting_g_a_b) {
        super(com_tencent_mm_ui_chatting_g_a_b);
    }

    final String cvv() {
        return "link_revoke";
    }

    final CharSequence a(Map<String, String> map, String str, WeakReference<Context> weakReference) {
        String str2 = (String) map.get(str + ".title");
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            Object obj = str + ".usernamelist.username";
            if (i != 0) {
                obj = obj + i;
            }
            String str3 = (String) map.get(obj);
            if (bh.ov(str3)) {
                CharSequence spannableString = new SpannableString(str2);
                spannableString.setSpan(new 1(this, linkedList), 0, str2.length(), 33);
                return spannableString;
            }
            linkedList.add(str3);
            i++;
        }
    }
}
