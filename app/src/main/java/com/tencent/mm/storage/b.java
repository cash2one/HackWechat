package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.protocal.c.tf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class b extends i<a> {
    public static final String[] gJN = new String[]{i.a(a.gJc, "ABTestInfo")};
    private e gJP;

    public b(e eVar) {
        super(eVar, a.gJc, "ABTestInfo", null);
        this.gJP = eVar;
    }

    public final void i(List<a> list, int i) {
        Object obj = null;
        long Wo = bh.Wo();
        this.gJP.delete("ABTestInfo", String.format(Locale.US, "%s<>0 and %s<%d", new Object[]{"endTime", "endTime", Long.valueOf(Wo)}), null);
        if (1 == i) {
            c aVar = new a();
            aVar.field_prioritylevel = 1;
            a(aVar, false, new String[]{"prioritylevel"});
        }
        for (a aVar2 : list) {
            boolean z;
            Object obj2;
            if (aVar2 == null || bh.ov(aVar2.field_abtestkey)) {
                x.e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                c aVar3 = new a();
                aVar3.field_abtestkey = aVar2.field_abtestkey;
                if (!super.b(aVar3, new String[0])) {
                    x.i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", new Object[]{aVar2.field_abtestkey, Boolean.valueOf(super.a(aVar2, false))});
                    z = r2;
                } else if ((aVar2.field_sequence <= aVar3.field_sequence || aVar2.field_prioritylevel != aVar3.field_prioritylevel) && aVar2.field_prioritylevel <= aVar3.field_prioritylevel) {
                    x.i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", new Object[]{aVar2.field_abtestkey, Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel)});
                    z = false;
                } else {
                    x.i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", new Object[]{aVar2.field_abtestkey, Boolean.valueOf(super.b(aVar2, false, new String[0])), Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel)});
                    z = r2;
                }
            }
            if (z) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
        if (obj != null) {
            Wc("event_updated");
        }
    }

    public final LinkedList<tf> chG() {
        LinkedList<tf> linkedList = new LinkedList();
        Cursor Tj = Tj();
        if (Tj != null) {
            if (Tj.moveToFirst()) {
                a aVar = new a();
                do {
                    aVar.b(Tj);
                    tf tfVar = new tf();
                    try {
                        tfVar.vYU = bh.getInt(aVar.field_expId, 0);
                    } catch (Exception e) {
                        x.e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", new Object[]{aVar.field_expId});
                    }
                    tfVar.priority = aVar.field_prioritylevel;
                    linkedList.add(tfVar);
                } while (Tj.moveToNext());
                Tj.close();
            } else {
                Tj.close();
            }
        }
        return linkedList;
    }

    public final a Wo(String str) {
        c aVar = new a();
        aVar.field_abtestkey = str;
        if (super.b(aVar, new String[0]) && aVar.field_endTime == 0) {
            aVar.field_endTime = Long.MAX_VALUE;
        }
        x.i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", new Object[]{str, Boolean.valueOf(r1)});
        return aVar;
    }

    public final int da(String str, int i) {
        a Wo = Wo(str);
        if (Wo.isValid()) {
            return bh.getInt(Wo.field_value, i);
        }
        return i;
    }

    public final String getExpIdByKey(String str) {
        a Wo = Wo(str);
        if (Wo.isValid()) {
            return Wo.field_expId == null ? "" : Wo.field_expId;
        } else {
            return "";
        }
    }

    public final String chH() {
        Cursor Tj = Tj();
        if (Tj == null) {
            return "null cursor!!";
        }
        if (Tj.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            a aVar = new a();
            do {
                stringBuilder.append("============\n");
                aVar.b(Tj);
                stringBuilder.append("abtestkey = ").append(aVar.field_abtestkey).append("\n");
                stringBuilder.append("sequence = ").append(aVar.field_sequence).append("\n");
                stringBuilder.append("priorityLV = ").append(aVar.field_prioritylevel).append("\n");
                stringBuilder.append("expId = ").append(aVar.field_expId).append("\n");
            } while (Tj.moveToNext());
            Tj.close();
            return stringBuilder.toString();
        }
        Tj.close();
        return "cursor empty!!";
    }
}
