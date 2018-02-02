package com.tencent.mm.storage;

import com.tencent.mm.g.b.dk;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bf extends dk {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "encryptUsername";
        aVar.xjA.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "encryptUsername";
        aVar.columns[1] = "conRemark";
        aVar.xjA.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "contactLabels";
        aVar.xjA.put("contactLabels", "TEXT default '' ");
        stringBuilder.append(" contactLabels TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "conDescription";
        aVar.xjA.put("conDescription", "TEXT default '' ");
        stringBuilder.append(" conDescription TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "conPhone";
        aVar.xjA.put("conPhone", "TEXT default '' ");
        stringBuilder.append(" conPhone TEXT default '' ");
        aVar.columns[5] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public bf(String str) {
        this();
        this.field_conRemark = "";
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
    }

    public bf(String str, String str2) {
        this();
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
        if (str2 == null) {
            str2 = "";
        }
        this.field_conRemark = str2;
    }

    public bf() {
        this.field_encryptUsername = "";
        this.field_conRemark = "";
    }

    public final String vS() {
        return this.field_encryptUsername;
    }

    public final String vO() {
        return this.field_conRemark;
    }

    protected final Object clone() {
        return super.clone();
    }
}
