package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class b extends a {
    public b(com.tencent.mm.ui.chatting.g.a.b bVar) {
        super(bVar);
    }

    final String cvv() {
        return "link_profile";
    }

    final CharSequence a(Map<String, String> map, String str, WeakReference<Context> weakReference) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        CharSequence az = bh.az((String) map.get(str + ".separator"), "、");
        int i = 0;
        while (true) {
            String str2 = str + ".memberlist.member" + (i != 0 ? Integer.valueOf(i) : "");
            if (map.get(str2) == null) {
                return spannableStringBuilder;
            }
            if (i != 0) {
                spannableStringBuilder.append(az);
            }
            String str3 = (String) map.get(str2 + ".username");
            str2 = (String) map.get(str2 + ".nickname");
            if (bh.ov(str3) || bh.ov(str2)) {
                x.w("MicroMsg.SysMsgHandlerProfile", "hy: can not resolve username or nickname");
            } else {
                CharSequence a = i.a(ac.getContext(), str2);
                a.setSpan(new 1(this, weakReference, str3), 0, str2.length(), 33);
                spannableStringBuilder.append(a);
            }
            i++;
        }
    }
}
