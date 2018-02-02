package com.tencent.mm.plugin.exdevice.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.g.b.bq;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class c extends i<b> {
    public static final String[] gJN = new String[]{i.a(b.gJc, "HardDeviceInfo")};
    private e gJP;

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.e.c cVar) {
        b bVar = (b) cVar;
        if (bVar == null || bh.ov(bVar.field_brandName) || bh.ov(bVar.field_deviceID)) {
            x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "wrong argument");
            return false;
        }
        x.i("MicroMsg.exdevice.HardDeviceInfoStorage", "replace: brandName=%s, deviceId=%s, ret=%s ", new Object[]{bVar.field_brandName, bVar.field_deviceID, Boolean.valueOf(this.gJP.replace("HardDeviceInfo", b.gJc.xjz, bVar.vI()) > 0)});
        return this.gJP.replace("HardDeviceInfo", b.gJc.xjz, bVar.vI()) > 0;
    }

    public c(e eVar) {
        super(eVar, b.gJc, "HardDeviceInfo", null);
        this.gJP = eVar;
        eVar.fx("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceUsernameIndex ON HardDeviceInfo ( brandName )");
        eVar.fx("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceMacIndex ON HardDeviceInfo ( mac )");
    }

    public final b zf(String str) {
        if (bh.ov(str)) {
            return null;
        }
        Cursor a = this.gJP.a("HardDeviceInfo", null, "mac=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.b(a);
            a.close();
            return bVar;
        }
        x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:" + str);
        a.close();
        return null;
    }

    public final b cJ(long j) {
        b bVar = null;
        Cursor query = this.gJP.query("HardDeviceInfo", null, "mac=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                bVar = new b();
                bVar.b(query);
            } else {
                x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:" + j);
            }
            query.close();
        }
        return bVar;
    }

    public final b zg(String str) {
        if (bh.ov(str)) {
            return null;
        }
        Cursor a = this.gJP.a("HardDeviceInfo", null, "deviceID=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.b(a);
            a.close();
            return bVar;
        }
        x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceId:" + str);
        a.close();
        return null;
    }

    public final b co(String str, String str2) {
        if (bh.ov(str2) || bh.ov(str)) {
            x.e("MicroMsg.exdevice.HardDeviceInfoStorage", "deviceType(%s) or deviceId(%s) is null or nil.", new Object[]{str2, str});
            return null;
        }
        Cursor a = this.gJP.a("HardDeviceInfo", null, "deviceType=? and deviceID=?", new String[]{str2, str}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.b(a);
            a.close();
            return bVar;
        }
        x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceType:%s and deviceId:%s", new Object[]{str2, str});
        a.close();
        return null;
    }

    public static boolean zh(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.exdevice.HardDeviceInfoStorage", "Ability is null or nil.");
            return false;
        } else if (str.contains("wxmsg_music") || str.contains("wxmsg_poi") || str.contains("wxmsg_image") || str.contains("wxmsg_file") || str.contains("wxmsg_video") || str.contains("wxmsg_url")) {
            return true;
        } else {
            return false;
        }
    }

    public final List<b> aEO() {
        List<b> linkedList = new LinkedList();
        Cursor Tj = Tj();
        if (Tj == null || !Tj.moveToFirst()) {
            if (Tj != null) {
                Tj.close();
            }
            return linkedList;
        }
        do {
            bq bVar = new b();
            bVar.b(Tj);
            String str = bVar.gfT;
            if (str != null && zh(str)) {
                linkedList.add(bVar);
            }
        } while (Tj.moveToNext());
        if (Tj != null) {
            Tj.close();
        }
        return linkedList;
    }

    public final List<b> aEP() {
        List<b> linkedList = new LinkedList();
        Cursor Tj = Tj();
        if (Tj == null || !Tj.moveToFirst()) {
            if (Tj != null) {
                Tj.close();
            }
            return linkedList;
        }
        do {
            bq bVar = new b();
            bVar.b(Tj);
            String str = bVar.gfP;
            String str2 = bVar.iconUrl;
            String str3 = bVar.category;
            String str4 = bVar.field_brandName;
            if (!(bh.ov(str3) || str3.equals("1") || str3.equals("0") || bh.ov(str4) || bh.ov(str) || bh.ov(str2))) {
                linkedList.add(bVar);
            }
        } while (Tj.moveToNext());
        if (Tj != null) {
            Tj.close();
        }
        return linkedList;
    }

    public final b cp(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.exdevice.HardDeviceInfoStorage", "brandName(%s) or deviceId(%s) is null or nil.", new Object[]{str, str2});
            return null;
        }
        Cursor a = this.gJP.a("HardDeviceInfo", null, "brandName=? and deviceID=?", new String[]{str, str2}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.b(a);
            a.close();
            return bVar;
        }
        x.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with brandName:" + str);
        a.close();
        return null;
    }

    public final LinkedList<b> zi(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.exdevice.HardDeviceInfoStorage", "The given brandName is null or nil.");
            return null;
        }
        LinkedList<b> linkedList = new LinkedList();
        Cursor a = this.gJP.a("HardDeviceInfo", null, "brandName=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            return linkedList;
        }
        if (a.moveToFirst()) {
            do {
                b bVar = new b();
                bVar.b(a);
                linkedList.add(bVar);
            } while (a.moveToNext());
        }
        a.close();
        return linkedList;
    }

    public final LinkedList<b> aEQ() {
        LinkedList<b> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery("select * from HardDeviceInfo where mac > 0 and connProto like '3'", new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.exdevice.HardDeviceInfoStorage", "get cursor is null");
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.b(rawQuery);
                    linkedList.add(bVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean cq(String str, String str2) {
        if (bh.ov(str)) {
            return false;
        }
        if (this.gJP.delete("HardDeviceInfo", "deviceID=? and deviceType=? ", new String[]{str, str2}) <= 0) {
            x.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo fail, deviceId = %s", new Object[]{str});
            return false;
        }
        x.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo ok, deviceId = %s", new Object[]{str});
        return true;
    }

    public final int e(b bVar) {
        int update;
        ContentValues vI = bVar.vI();
        if (vI.size() > 0) {
            update = this.gJP.update("HardDeviceInfo", vI, "deviceID = ? and deviceType = ? ", new String[]{bVar.field_deviceID, bVar.field_deviceType});
        } else {
            update = 0;
        }
        x.i("MicroMsg.exdevice.HardDeviceInfoStorage", "update: deviceId = %s, deviceType = %s, ret = %s ", new Object[]{bVar.field_deviceID, bVar.field_deviceType, Integer.valueOf(update)});
        return update;
    }
}
