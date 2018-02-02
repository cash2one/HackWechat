package com.tencent.mm.y;

import com.tencent.mm.cd.c;
import com.tencent.mm.g.b.o;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import junit.framework.Assert;

public final class g extends o {
    public static a gJc;

    public static class b {
        private static final ArrayList<c<? extends d>> hdV = new ArrayList();
        private static final HashMap<Integer, c<? extends d>> hdW = new HashMap();

        static /* synthetic */ d gJ(int i) {
            c cVar = (c) hdW.get(Integer.valueOf(i));
            if (cVar != null) {
                d dVar = (d) cVar.get();
                dVar.type = i;
                return dVar;
            }
            x.w("MicroMsg.AppMessage", "get for type(%s) is null", new Object[]{Integer.valueOf(i)});
            return null;
        }

        public static void a(c<? extends d> cVar) {
            hdV.add(cVar);
        }
    }

    static {
        a aVar = new a();
        aVar.hSY = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xjA.put("msgId", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "msgId";
        aVar.columns[1] = "xml";
        aVar.xjA.put("xml", "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.xjA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "title";
        aVar.xjA.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "description";
        aVar.xjA.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "source";
        aVar.xjA.put("source", "TEXT");
        stringBuilder.append(" source TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        aVar.columns[7] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
        if (com.tencent.mm.sdk.a.b.ceK()) {
            Assert.assertTrue(EK());
        }
    }

    protected final a Ac() {
        return gJc;
    }

    private static final boolean EK() {
        Field[] declaredFields = a.class.getDeclaredFields();
        int i = 0;
        for (Field modifiers : declaredFields) {
            if (!Modifier.isStatic(modifiers.getModifiers())) {
                i++;
            }
        }
        if (i > 185) {
            x.e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", new Object[]{Integer.valueOf(i), Integer.valueOf(185)});
            return false;
        }
        x.i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", new Object[]{Integer.valueOf(i)});
        return true;
    }
}
