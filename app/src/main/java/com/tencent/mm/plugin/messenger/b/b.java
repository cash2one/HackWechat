package com.tencent.mm.plugin.messenger.b;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class b {
    static ArrayList<a> Fc(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.SysMsgTemplateParser", "hy: null text!!");
            return null;
        }
        ArrayList<a> arrayList = new ArrayList();
        String[] split = str.split("\\$");
        for (int i = 0; i < split.length; i++) {
            Object aVar;
            if (i % 2 == 0) {
                aVar = new a(0, split[i]);
            } else {
                aVar = new a(1, split[i]);
            }
            arrayList.add(aVar);
        }
        return arrayList;
    }
}
