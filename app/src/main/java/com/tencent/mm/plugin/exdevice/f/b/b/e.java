package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class e extends i<com.tencent.mm.plugin.exdevice.f.b.a.e> {
    public static final String[] gJN = new String[]{i.a(com.tencent.mm.plugin.exdevice.f.b.a.e.gJc, "HardDeviceLikeUser")};
    private com.tencent.mm.sdk.e.e gJP;

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, com.tencent.mm.plugin.exdevice.f.b.a.e.gJc, "HardDeviceLikeUser", null);
        this.gJP = eVar;
        eVar.fx("HardDeviceLikeUser", "CREATE INDEX IF NOT EXISTS ExdeviceRankLikeInfoRankIdAppNameIndex ON HardDeviceLikeUser ( rankID, appusername )");
    }

    public final ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> zd(String str) {
        ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> arrayList = null;
        if (bh.ov(str)) {
            x.e("MicroMsg.ExdeviceRankLikeUserStg", "hy: param error");
        } else {
            String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceLikeUser", "rankID", "timestamp"});
            Cursor a = this.gJP.a(format, new String[]{bh.az(str, "")}, 2);
            if (a == null) {
                x.e("MicroMsg.ExdeviceRankLikeUserStg", "Get no rank in DB");
            } else {
                if (a.moveToFirst()) {
                    arrayList = new ArrayList();
                    do {
                        com.tencent.mm.plugin.exdevice.f.b.a.e eVar = new com.tencent.mm.plugin.exdevice.f.b.a.e();
                        eVar.b(a);
                        arrayList.add(eVar);
                    } while (a.moveToNext());
                }
                a.close();
            }
        }
        return arrayList;
    }

    public final void a(String str, String str2, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> arrayList) {
        Assert.assertTrue(!bh.ov(str));
        if (arrayList == null) {
            x.i("MicroMsg.ExdeviceRankLikeUserStg", "batchInsertOrUpdate failed, data is null.");
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.f.b.a.e eVar = (com.tencent.mm.plugin.exdevice.f.b.a.e) it.next();
            Assert.assertTrue(eVar != null);
            if (c(eVar, new String[]{"rankID", "username"})) {
                x.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: update success");
            } else if (b(eVar)) {
                x.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert success");
            } else {
                x.w("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert or update failed");
            }
        }
        ad.aEt().a("HardDeviceLikeUser", new d(str, str2, null));
    }
}
