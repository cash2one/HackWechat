package com.tencent.mm.plugin.sns;

import android.database.Cursor;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends c<mo> {
    public j() {
        this.xen = mo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mo moVar = (mo) bVar;
        if (moVar instanceof mo) {
            List linkedList = new LinkedList();
            moVar.fEw.fEx = null;
            moVar.fEw.fEy = null;
            moVar.fEw.fEz = null;
            x.i("MicroMsg.RecentlySnsMediaObjListener", "recently username " + moVar.fEv.username);
            if (!bh.ov(moVar.fEv.username)) {
                g.Dk();
                boolean z = moVar.fEv.username.equals((String) g.Dj().CU().get(2, null));
                n bvv = ae.bvv();
                String str = ("select *,rowid from SnsInfo " + n.aG(moVar.fEv.username, z)) + " AND type in ( 1 , 15)" + n.roZ + " limit 3";
                x.d("MicroMsg.SnsInfoStorage", "getUserNewerInfo " + str);
                Cursor rawQuery = bvv.gJP.rawQuery(str, null);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        int i = 0;
                        do {
                            m mVar = new m();
                            mVar.b(rawQuery);
                            if (mVar.field_type != 21) {
                                Iterator it = mVar.bxV().wQo.vYd.iterator();
                                while (it.hasNext()) {
                                    aqr com_tencent_mm_protocal_c_aqr = (aqr) it.next();
                                    if (com_tencent_mm_protocal_c_aqr.ktN == 2 || com_tencent_mm_protocal_c_aqr.ktN == 6) {
                                        i++;
                                        linkedList.add(com_tencent_mm_protocal_c_aqr);
                                        if (i >= 3) {
                                            break;
                                        }
                                    }
                                    i = i;
                                }
                            }
                        } while (rawQuery.moveToNext());
                        rawQuery.close();
                        if (linkedList.size() > 0) {
                            moVar.fEw.fEx = (aqr) linkedList.get(0);
                        }
                        if (linkedList.size() > 1) {
                            moVar.fEw.fEy = (aqr) linkedList.get(1);
                        }
                        if (linkedList.size() > 2) {
                            moVar.fEw.fEz = (aqr) linkedList.get(2);
                        }
                    } else {
                        rawQuery.close();
                    }
                }
            }
            return true;
        }
        x.f("MicroMsg.RecentlySnsMediaObjListener", "mismatched event");
        return false;
    }
}
