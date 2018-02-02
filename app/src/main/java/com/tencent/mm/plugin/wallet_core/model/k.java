package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.g.b.ce;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class k extends ce {
    public static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "title";
        aVar.xjA.put("title", "TEXT PRIMARY KEY ");
        stringBuilder.append(" title TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "title";
        aVar.columns[1] = "loan_jump_url";
        aVar.xjA.put("loan_jump_url", "TEXT");
        stringBuilder.append(" loan_jump_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "red_dot_index";
        aVar.xjA.put("red_dot_index", "INTEGER");
        stringBuilder.append(" red_dot_index INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "is_show_entry";
        aVar.xjA.put("is_show_entry", "INTEGER");
        stringBuilder.append(" is_show_entry INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "tips";
        aVar.xjA.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "is_overdue";
        aVar.xjA.put("is_overdue", "INTEGER");
        stringBuilder.append(" is_overdue INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "available_otb";
        aVar.xjA.put("available_otb", "TEXT");
        stringBuilder.append(" available_otb TEXT");
        aVar.columns[7] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }
}
