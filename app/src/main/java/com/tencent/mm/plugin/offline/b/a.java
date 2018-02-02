package com.tencent.mm.plugin.offline.b;

import android.database.Cursor;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends i<r> {
    public static final String[] gJN = new String[]{i.a(r.gJc, "OfflineOrderStatus")};
    public e gJP;

    public a(e eVar) {
        super(eVar, r.gJc, "OfflineOrderStatus", null);
        this.gJP = eVar;
    }

    public final r bhf() {
        int i = 1;
        r rVar = null;
        x.i("MicroMsg.OfflineOrderStatusStorage", "in getLastestOrder: orders count: %d, latest 3 orders: %s", new Object[]{Integer.valueOf(bhh()), bhg()});
        Cursor a = this.gJP.a("SELECT * FROM OfflineOrderStatus WHERE status!=-1 ORDER BY rowid DESC LIMIT 1", null, 2);
        if (a != null) {
            a.moveToFirst();
            if (a.isAfterLast()) {
                i = 0;
            }
            if (i != 0) {
                rVar = new r();
                rVar.b(a);
            }
            a.close();
            if (rVar != null) {
                x.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder status = " + rVar.field_status);
            } else {
                x.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder null");
            }
        }
        return rVar;
    }

    public final r GR(String str) {
        r rVar = null;
        Cursor a = this.gJP.a("select * from OfflineOrderStatus where reqkey=?", new String[]{str}, 2);
        if (a != null) {
            a.moveToFirst();
            x.i("MicroMsg.OfflineOrderStatusStorage", "in getOrderStatusByTranId: cursor.isAfterLast() = " + a.isAfterLast());
            if (!a.isAfterLast()) {
                rVar = new r();
                rVar.b(a);
            }
            a.close();
        }
        return rVar;
    }

    public final void b(r rVar) {
        if (rVar.field_reqkey == null) {
            x.e("MicroMsg.OfflineOrderStatusStorage", "status.field_reqkey is null");
            return;
        }
        int i;
        Cursor a = this.gJP.a("select * from OfflineOrderStatus where reqkey=?", new String[]{rVar.field_reqkey}, 2);
        if (a == null) {
            i = 0;
        } else {
            a.moveToFirst();
            i = !a.isAfterLast() ? 1 : 0;
            a.close();
        }
        if (i == 0) {
            x.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: insert reqKey: %s,  status: %d ", new Object[]{rVar.field_reqkey, Integer.valueOf(rVar.field_status)});
            b(rVar);
            return;
        }
        x.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: update reqKey: %s,  status: %d ", new Object[]{rVar.field_reqkey, Integer.valueOf(rVar.field_status)});
        c(rVar, new String[0]);
    }

    public final void GS(String str) {
        r GR = GR(str);
        if (GR != null) {
            GR.field_status = -1;
        } else {
            GR = new r();
            GR.field_reqkey = str;
            GR.field_status = -1;
        }
        b(GR);
    }

    public final String bhg() {
        Cursor a = this.gJP.a(String.format("SELECT * FROM %s ORDER BY %s DESC LIMIT %d;", new Object[]{"OfflineOrderStatus", "rowid", Integer.valueOf(3)}), null, 2);
        String str = "";
        if (a == null) {
            x.e("MicroMsg.OfflineOrderStatusStorage", "getAllOrdersInfo: error.cursor is null\n");
        } else {
            int i = 0;
            while (a.moveToNext()) {
                int i2 = i + 1;
                if (i2 > 3) {
                    break;
                }
                String str2 = str;
                for (int i3 = 0; i3 < a.getColumnCount(); i3++) {
                    str2 = str2 + a.getColumnName(i3) + ": " + a.getString(i3) + ", ";
                }
                str = str2 + ";";
                i = i2;
            }
            a.close();
        }
        return str;
    }

    public final int bhh() {
        int i = 0;
        Cursor a = this.gJP.a(String.format("SELECT COUNT(*) FROM %s;", new Object[]{"OfflineOrderStatus"}), null, 2);
        if (a == null) {
            x.e("MicroMsg.OfflineOrderStatusStorage", "getOrdersCount: error.cursor is null\n");
        } else {
            if (a.moveToNext() && a.getColumnCount() > 0) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }
}
