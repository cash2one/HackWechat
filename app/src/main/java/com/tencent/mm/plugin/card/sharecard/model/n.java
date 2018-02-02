package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.g.b.da;
import com.tencent.mm.protocal.c.bib;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends da {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_id";
        aVar.xjA.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "card_id";
        aVar.columns[1] = "state_flag";
        aVar.xjA.put("state_flag", "INTEGER");
        stringBuilder.append(" state_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "update_time";
        aVar.xjA.put("update_time", "LONG");
        stringBuilder.append(" update_time LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "seq";
        aVar.xjA.put("seq", "LONG");
        stringBuilder.append(" seq LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "retryCount";
        aVar.xjA.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        aVar.columns[5] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        if (this.field_card_id == ((n) obj).field_card_id) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.field_card_id == null ? 0 : this.field_card_id.hashCode();
    }

    public static n b(bib com_tencent_mm_protocal_c_bib) {
        n nVar = new n();
        nVar.field_card_id = com_tencent_mm_protocal_c_bib.fGU;
        nVar.field_update_time = (long) com_tencent_mm_protocal_c_bib.vUc;
        nVar.field_state_flag = com_tencent_mm_protocal_c_bib.kNd;
        nVar.field_seq = com_tencent_mm_protocal_c_bib.wLE;
        nVar.field_retryCount = 10;
        return nVar;
    }
}
