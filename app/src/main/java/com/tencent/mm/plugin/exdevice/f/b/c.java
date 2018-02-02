package com.tencent.mm.plugin.exdevice.f.b;

import android.database.Cursor;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.exdevice.f.a.f;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.l;
import com.tencent.mm.plugin.exdevice.f.a.m;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class c implements e {
    public f lPD;
    public f lPE;

    public c() {
        x.d("MicroMsg.ExdeviceRankInfoManager", "hy: constructing manager....");
        ar.CG().a(1042, this);
        ar.CG().a(1041, this);
        ar.CG().a(1043, this);
        ar.CG().a(1040, this);
    }

    public static void b(String str, String str2, String str3, int i) {
        ar.CG().a(new l(str3, str2, i, str), 0);
    }

    public static ArrayList<d> yY(String str) {
        ArrayList<d> arrayList = null;
        x.d("MicroMsg.ExdeviceRankInfoManager", "hy: getting like info...");
        if (bh.ov(str)) {
            x.w("MicroMsg.ExdeviceRankInfoManager", "hy: param error");
        } else {
            com.tencent.mm.plugin.exdevice.f.b.b.d aEl = ad.aEl();
            if (bh.ov(str)) {
                x.e("MicroMsg.ExdeviceRankInfoStg", "hy: param error");
            } else {
                String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceRankInfo", "rankID", "score"});
                Cursor a = aEl.gJP.a(format, new String[]{bh.az(str, "")}, 2);
                if (a == null) {
                    x.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                } else {
                    if (a.moveToFirst()) {
                        arrayList = new ArrayList();
                        do {
                            d dVar = new d();
                            dVar.b(a);
                            arrayList.add(dVar);
                        } while (a.moveToNext());
                    } else {
                        x.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    }
                    a.close();
                }
            }
        }
        return arrayList;
    }

    public static void d(String str, ArrayList<d> arrayList) {
        com.tencent.mm.plugin.exdevice.f.b.b.d aEl = ad.aEl();
        Assert.assertTrue(!bh.ov(str));
        if (arrayList != null) {
            int i;
            Cursor a = aEl.gJP.a(String.format("select COUNT(*) from %s where %s = ?", new Object[]{"HardDeviceRankInfo", "rankID"}), new String[]{bh.az(str, "")}, 2);
            if (a == null) {
                x.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                i = 0;
            } else {
                if (a.moveToFirst()) {
                    i = a.getInt(0);
                } else {
                    x.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    i = 0;
                }
                a.close();
            }
            Iterator it;
            if (i == 0) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    aEl.a((d) it.next(), false);
                }
                return;
            }
            it = arrayList.iterator();
            while (it.hasNext()) {
                aEl.b((d) it.next(), false);
            }
            return;
        }
        x.w("MicroMsg.ExdeviceRankInfoStg", "hy: data is null. abort insert");
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ExdeviceRankInfoManager", "hy: netscene back.err type: %d, err code: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar instanceof j) {
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error.");
            }
        } else if (kVar instanceof l) {
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
            }
        } else if (!(kVar instanceof m)) {
        } else {
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
            }
        }
    }
}
