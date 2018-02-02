package com.tencent.mm.plugin.freewifi.b;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.freewifi.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private boolean mDu;
    private Map<String, b> mDv;

    private a() {
        this.mDu = false;
        this.mDv = new LinkedHashMap<String, b>(this) {
            final /* synthetic */ a mDw;

            {
                this.mDw = r1;
            }

            protected final boolean removeEldestEntry(Entry entry) {
                return size() > WXMediaMessage.TITLE_LENGTH_LIMIT;
            }
        };
    }

    private static String cz(String str, String str2) {
        return str + "-" + str2;
    }

    public final synchronized void c(String str, String str2, String str3, int i) {
        if (!(m.AA(str) || m.AA(str2) || m.AA(str3) || (i != 4 && i != 31))) {
            b bVar = new b();
            bVar.fpz = str3;
            bVar.mCv = i;
            this.mDv.put(cz(str, str2), bVar);
        }
    }

    public final synchronized b cA(String str, String str2) {
        b bVar;
        if (m.AA(str) || m.AA(str2)) {
            bVar = null;
        } else {
            bVar = (b) this.mDv.get(cz(str, str2));
        }
        return bVar;
    }

    public final synchronized int size() {
        return this.mDv.size();
    }
}
