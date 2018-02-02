package com.tencent.mm.plugin.fav.b.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.j;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends i<c> implements j {
    private List<com.tencent.mm.plugin.fav.a.i> avD = new LinkedList();
    private e gJP;

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        return b((c) cVar, strArr);
    }

    public final /* synthetic */ boolean c(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        return a((c) cVar, strArr);
    }

    public final void a(com.tencent.mm.plugin.fav.a.i iVar) {
        this.avD.add(iVar);
    }

    public final void b(com.tencent.mm.plugin.fav.a.i iVar) {
        this.avD.remove(iVar);
    }

    public a(e eVar) {
        super(eVar, c.gJc, "FavCdnInfo", null);
        this.gJP = eVar;
    }

    public final void aHS() {
        this.gJP.fx("FavCdnInfo", "update FavCdnInfo set status = 1 where status <> 3");
    }

    public final boolean b(c cVar) {
        int i = 0;
        if (cVar == null || !super.b(cVar)) {
            return false;
        }
        com.tencent.mm.plugin.fav.a.i[] iVarArr = new com.tencent.mm.plugin.fav.a.i[this.avD.size()];
        this.avD.toArray(iVarArr);
        int length = iVarArr.length;
        while (i < length) {
            com.tencent.mm.plugin.fav.a.i iVar = iVarArr[i];
            if (iVar != null) {
                iVar.a(cVar);
            }
            i++;
        }
        return true;
    }

    public final boolean a(c cVar, String... strArr) {
        int i = 0;
        if (!super.c(cVar, strArr)) {
            return false;
        }
        com.tencent.mm.plugin.fav.a.i[] iVarArr = new com.tencent.mm.plugin.fav.a.i[this.avD.size()];
        this.avD.toArray(iVarArr);
        int length = iVarArr.length;
        while (i < length) {
            iVarArr[i].a(cVar);
            i++;
        }
        return true;
    }

    public final boolean b(c cVar, String... strArr) {
        int i = 0;
        if (!super.a(cVar, strArr)) {
            return false;
        }
        com.tencent.mm.plugin.fav.a.i[] iVarArr = new com.tencent.mm.plugin.fav.a.i[this.avD.size()];
        this.avD.toArray(iVarArr);
        int length = iVarArr.length;
        while (i < length) {
            iVarArr[i].a(cVar);
            i++;
        }
        return true;
    }

    public final c zT(String str) {
        c cVar = null;
        if (bh.ov(str)) {
            x.e("MicroMsg.FavCdnStorage", "md5 null");
        } else {
            Cursor a = this.gJP.a("select * from FavCdnInfo where dataId = '" + str + "'", null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    cVar = new c();
                    cVar.b(a);
                }
                a.close();
            }
        }
        return cVar;
    }

    public final void d(f fVar) {
        this.gJP.fx("FavCdnInfo", "update FavCdnInfo set status = 1,modifyTime = " + bh.Wp() + " where favLocalId = " + fVar.field_localId + " and type = 0" + " and status <> 3");
    }

    public final LinkedList<c> aHT() {
        LinkedList<c> linkedList = null;
        Cursor a = this.gJP.a("select * from FavCdnInfo where status = 1 order by modifyTime desc " + " limit 1", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                linkedList = new LinkedList();
                do {
                    c cVar = new c();
                    cVar.b(a);
                    linkedList.add(cVar);
                } while (a.moveToNext());
                a.close();
            } else {
                a.close();
            }
        }
        return linkedList;
    }

    public final List<c> cW(long j) {
        List<c> arrayList = new ArrayList();
        Cursor a = this.gJP.a("select * from FavCdnInfo where favLocalId = " + j, null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                c cVar = new c();
                cVar.b(a);
                arrayList.add(cVar);
            }
            a.close();
        }
        x.v("MicroMsg.FavCdnStorage", "getInfos size:%d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }

    public final List<c> cX(long j) {
        List<c> linkedList = new LinkedList();
        Cursor a = this.gJP.a("select * from FavCdnInfo where favLocalId = " + j + " and type = 0" + " and status = 3", null, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            x.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", new Object[]{Integer.valueOf(linkedList.size())});
            return linkedList;
        }
        do {
            c cVar = new c();
            cVar.b(a);
            linkedList.add(cVar);
        } while (a.moveToNext());
        if (a != null) {
            a.close();
        }
        x.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public final void cY(long j) {
        this.gJP.fx("FavCdnInfo", String.format("delete from %s where %s = %d and %s = %d", new Object[]{"FavCdnInfo", "favLocalId", Long.valueOf(j), DownloadSettingTable$Columns.TYPE, Integer.valueOf(0)}));
    }

    public final int m(long j, int i) {
        Cursor a = this.gJP.a("select status from FavCdnInfo where favLocalId = " + j + " and type = " + i, null, 2);
        if (a == null) {
            return 3;
        }
        if (a.moveToFirst()) {
            int i2 = 1;
            int i3 = 1;
            int i4 = 1;
            do {
                int i5 = a.getInt(0);
                if (i5 == 1) {
                    a.close();
                    return 1;
                }
                if (i5 != 4) {
                    i4 = 0;
                }
                if (i5 != 2) {
                    i3 = 0;
                }
                if (i5 != 3) {
                    i2 = 0;
                }
            } while (a.moveToNext());
            a.close();
            if (i3 != 0) {
                return 2;
            }
            if (i4 != 0) {
                return 4;
            }
            if (i2 != 0) {
                return 3;
            }
            return 0;
        }
        a.close();
        return 3;
    }

    public final Cursor aHU() {
        return this.gJP.rawQuery("select * from FavCdnInfo where type = 0 and status = 1", null);
    }

    public final Cursor aHV() {
        return this.gJP.rawQuery("select * from FavCdnInfo where type = 1 and status = 1", null);
    }

    public final boolean cZ(long j) {
        c cVar = new c();
        cVar.field_favLocalId = j;
        return b(cVar, "favLocalId");
    }
}
