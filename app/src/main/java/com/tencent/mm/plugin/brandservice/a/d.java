package com.tencent.mm.plugin.brandservice.a;

import android.database.Cursor;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements e {
    public LinkedList<a> kEE = new LinkedList();
    public boolean kEF = false;
    public List<b> kEG = new LinkedList();
    public List<b> kEH = new LinkedList();

    public interface a {
        void asi();
    }

    public d() {
        ar.CG().a(387, this);
        ar.CG().a(new f(), 0);
    }

    public final void init() {
        long currentTimeMillis = System.currentTimeMillis();
        this.kEG.clear();
        this.kEH.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.conRemarkPYFull");
        stringBuilder.append(", rcontact.conRemarkPYShort");
        stringBuilder.append(", rcontact.showHead");
        stringBuilder.append(", rcontact.pyInitial");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(x.cic()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
        stringBuilder.append(" order by showHead asc, ");
        stringBuilder.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" upper(quanPin) asc, ");
        stringBuilder.append(" upper(nickname) asc");
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", new Object[]{stringBuilder.toString()});
        ar.Hg();
        Cursor a = c.EV().a(r0, null, 2);
        Map hashMap = new HashMap();
        if (a != null) {
            int i = 0;
            while (a.moveToNext()) {
                i++;
                af xVar = new x();
                xVar.b(a);
                com.tencent.mm.ag.d dVar = new com.tencent.mm.ag.d();
                dVar.b(a);
                if (!xVar.field_username.equals("gh_43f2581f6fd6")) {
                    b bVar = new b();
                    bVar.userName = xVar.field_username;
                    bVar.jLe = xVar;
                    bVar.kEC = dVar;
                    if (!s.gR(bVar.userName)) {
                        hashMap.put(bVar.userName, bVar);
                        if (bVar.kEC.field_type != 3) {
                            if (bVar.kEC.field_type == 2) {
                                this.kEG.add(bVar);
                            } else if (bVar.kEC.field_type == 1 || bVar.kEC.field_type == 0) {
                                this.kEH.add(bVar);
                            }
                        }
                    }
                }
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", new Object[]{Integer.valueOf(i)});
            a.close();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        stringBuilder = new StringBuilder();
        stringBuilder.append("select username");
        stringBuilder.append(" from rcontact");
        stringBuilder.append(" where (verifyFlag & ").append(x.cic()).append(") != 0 ");
        stringBuilder.append(" and (type & 1").append(") != 0 ");
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", new Object[]{stringBuilder.toString()});
        ar.Hg();
        Cursor a2 = c.EV().a(r0, null, 0);
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            while (a2.moveToNext()) {
                String string = a2.getString(0);
                if (!hashMap.containsKey(string)) {
                    arrayList.add(string);
                }
            }
            a2.close();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", new Object[]{Integer.valueOf(arrayList.size()), arrayList});
            if (!arrayList.isEmpty()) {
                ar.Hg();
                long dz = c.EV().dz(Thread.currentThread().getId());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.z.ak.a.hfL.Q((String) it.next(), "");
                }
                ar.Hg();
                c.EV().fS(dz);
            }
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", new Object[]{Integer.valueOf(this.kEH.size()), Integer.valueOf(this.kEG.size())});
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0 && kVar.getType() == 387) {
            LinkedList linkedList = ((f) kVar).kEI;
            if (linkedList == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
            } else if (this.kEG == null || this.kEH == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
            } else {
                int i4;
                if (linkedList.size() != this.kEG.size() + this.kEH.size()) {
                    i4 = 1;
                } else {
                    for (b bVar : this.kEG) {
                        if (bVar != null) {
                            if (!linkedList.contains(bVar.userName)) {
                            }
                        }
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        for (b bVar2 : this.kEH) {
                            if (bVar2 != null) {
                                if (!linkedList.contains(bVar2.userName)) {
                                }
                            }
                            i4 = 1;
                        }
                    }
                    i4 = i3;
                }
                if (i4 != 0) {
                    init();
                    Iterator it = this.kEE.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).asi();
                    }
                }
            }
        }
    }
}
