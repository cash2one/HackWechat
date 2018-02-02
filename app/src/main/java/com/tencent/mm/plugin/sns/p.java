package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.se;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p extends c<se> {
    public p() {
        this.xen = se.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 0;
        se seVar = (se) bVar;
        if (seVar instanceof se) {
            if (seVar.fJQ.fJS instanceof u) {
                u uVar = (u) seVar.fJQ.fJS;
                int i2 = uVar.qUA;
                LinkedList linkedList = uVar.qUz;
                seVar.fJR.state = i2;
                if (i2 == 2) {
                    if (linkedList != null && linkedList.size() > 0) {
                        ae.bvB().eU(7);
                    }
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            bkp com_tencent_mm_protocal_c_bkp = (bkp) it.next();
                            if (com_tencent_mm_protocal_c_bkp.wOd == 7) {
                                s sVar = new s();
                                u.a(sVar, com_tencent_mm_protocal_c_bkp);
                                ae.bvB().a(sVar);
                            }
                        }
                    }
                }
                if (i2 != 1) {
                    s eT = ae.bvB().eT(7);
                    se.b bVar2 = seVar.fJR;
                    List linkedList2 = new LinkedList();
                    if (eT.field_memberList != null) {
                        String[] split = eT.field_memberList.split(",");
                        int length = split.length;
                        while (i < length) {
                            linkedList2.add(split[i]);
                            i++;
                        }
                    }
                    bVar2.fJT = linkedList2;
                }
            }
            return true;
        }
        x.f("MicroMsg.UpdateSnsTagListListener", "mismatched event");
        return false;
    }
}
