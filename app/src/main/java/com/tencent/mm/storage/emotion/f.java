package com.tencent.mm.storage.emotion;

import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class f extends i<e> implements a {
    public static final String[] gJN = new String[]{i.a(e.gJc, "EmojiSuggestDescInfo")};
    private e gJP;

    public f(e eVar) {
        this(eVar, e.gJc, "EmojiSuggestDescInfo");
    }

    private f(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gJP = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final boolean ag(ArrayList<ArrayList<String>> arrayList) {
        if (arrayList.isEmpty()) {
            x.i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
        } else {
            long dz;
            h hVar;
            if (this.gJP instanceof h) {
                h hVar2 = (h) this.gJP;
                dz = hVar2.dz(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                dz = -1;
                hVar = null;
            }
            this.gJP.delete("EmojiSuggestDescInfo", "", null);
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                ArrayList arrayList2 = (ArrayList) it.next();
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    i2 = i;
                } else {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        String str = (String) it2.next();
                        if (!bh.ov(str)) {
                            x.d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", new Object[]{String.valueOf(i), str});
                            b(new e(String.valueOf(i), str));
                        }
                    }
                    i2 = i + 1;
                }
                i = i2;
            }
            if (hVar != null) {
                hVar.fS(dz);
            }
        }
        return false;
    }
}
