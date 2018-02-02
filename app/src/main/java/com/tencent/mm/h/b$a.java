package com.tencent.mm.h;

import com.tencent.mm.g.a.rs;
import java.util.HashMap;
import java.util.Map;

class b$a {
    String gBg = null;
    long gBh = 0;
    String gBi = null;
    Map<Integer, rs> gBj = new HashMap();

    b$a() {
    }

    public final String toString() {
        String str = "";
        for (Integer num : this.gBj.keySet()) {
            str = str + num + ",";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[]{Integer.valueOf(hashCode()), this.gBg, Long.valueOf(this.gBh), this.gBi, str});
    }
}
