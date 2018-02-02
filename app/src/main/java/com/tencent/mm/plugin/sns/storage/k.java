package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.g.b.df;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.uo;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.lang.reflect.Field;

public final class k extends df {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[16];
        aVar.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.xjA.put("userName", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "userName";
        aVar.columns[1] = "md5";
        aVar.xjA.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "newerIds";
        aVar.xjA.put("newerIds", "TEXT");
        stringBuilder.append(" newerIds TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "bgId";
        aVar.xjA.put("bgId", "TEXT");
        stringBuilder.append(" bgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "bgUrl";
        aVar.xjA.put("bgUrl", "TEXT");
        stringBuilder.append(" bgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "older_bgId";
        aVar.xjA.put("older_bgId", "TEXT");
        stringBuilder.append(" older_bgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "local_flag";
        aVar.xjA.put("local_flag", "INTEGER");
        stringBuilder.append(" local_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "istyle";
        aVar.xjA.put("istyle", "INTEGER");
        stringBuilder.append(" istyle INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "iFlag";
        aVar.xjA.put("iFlag", "INTEGER");
        stringBuilder.append(" iFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "icount";
        aVar.xjA.put("icount", "INTEGER");
        stringBuilder.append(" icount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "faultS";
        aVar.xjA.put("faultS", "BLOB");
        stringBuilder.append(" faultS BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "snsBgId";
        aVar.xjA.put("snsBgId", "LONG");
        stringBuilder.append(" snsBgId LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "snsuser";
        aVar.xjA.put("snsuser", "BLOB");
        stringBuilder.append(" snsuser BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "adsession";
        aVar.xjA.put("adsession", "BLOB");
        stringBuilder.append(" adsession BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "lastFirstPageRequestErrCode";
        aVar.xjA.put("lastFirstPageRequestErrCode", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "lastFirstPageRequestErrType";
        aVar.xjA.put("lastFirstPageRequestErrType", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrType INTEGER");
        aVar.columns[16] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final void bye() {
        this.field_local_flag &= -3;
    }

    public final boolean byf() {
        return (this.field_local_flag & 2) > 0;
    }

    public final bla byg() {
        try {
            return (bla) new bla().aF(this.field_snsuser);
        } catch (Exception e) {
            return null;
        }
    }

    public final uo byh() {
        wk wkVar = new wk();
        uo uoVar = new uo();
        if (bh.bw(this.field_faultS)) {
            return uoVar;
        }
        try {
            uo uoVar2;
            wkVar = (wk) new wk().aF(this.field_faultS);
            if (wkVar.wgK.size() > 0) {
                uoVar2 = (uo) wkVar.wgK.getFirst();
            } else {
                uoVar2 = uoVar;
            }
            return uoVar2;
        } catch (Exception e) {
            return uoVar;
        }
    }
}
