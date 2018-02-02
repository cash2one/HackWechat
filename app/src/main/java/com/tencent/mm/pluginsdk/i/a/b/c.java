package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bh;

final class c extends k {
    final long fileSize;
    private final boolean fpt;
    final String fqR;
    volatile boolean tmA;
    volatile byte[] vgL;
    final long vgl;

    private c(String str, int i, String str2, boolean z, long j, String str3, int i2, long j2, int i3, int i4) {
        super(str, i.RR(str), String.valueOf(i), "CheckResUpdate", str3, "GET", i2, i3, i4);
        this.fqR = str2;
        this.vgl = j;
        this.fpt = z;
        this.fileSize = j2;
    }

    public final boolean bZn() {
        return true;
    }

    public final String getFilePath() {
        return i.RR(this.vgd);
    }

    public final String aab() {
        return "CheckResUpdate";
    }

    static c b(q qVar) {
        return new c(qVar.field_urlKey, bh.getInt(qVar.field_fileVersion, 0), qVar.field_md5, bh.ou(qVar.field_groupId2).equals("NewXml"), qVar.field_reportId, qVar.field_url, qVar.field_maxRetryTimes, qVar.field_fileSize, qVar.field_networkType, qVar.field_priority);
    }
}
