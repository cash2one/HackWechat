package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.a.f.a;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

class e$2 implements e {
    final /* synthetic */ e koc;

    e$2(e eVar) {
        this.koc = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        b.b(11, this.koc.koa);
        if (i == 0 && i2 == 0) {
            h hVar = (h) kVar;
            LinkedList linkedList = hVar.kpr.ksQ;
            LinkedList linkedList2 = hVar.kpr.ksR;
            LinkedList linkedList3 = new LinkedList();
            HashSet hashSet = new HashSet();
            Iterator it = linkedList2.iterator();
            long j = 0;
            long j2 = 0;
            for (int i3 = 0; i3 < linkedList.size(); i3++) {
                if (it.hasNext()) {
                    j = ((Long) it.next()).longValue();
                    if (it.hasNext()) {
                        j2 = ((Long) it.next()).longValue();
                    }
                }
                hashSet.add(linkedList.get(i3));
                linkedList3.add(new a(hashSet.size() - 1, (String) linkedList.get(i3), j, j2));
            }
            x.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[]{Integer.valueOf(linkedList3.size())});
            c b = e.b(this.koc);
            b.aps().apt();
            b.a(linkedList3, b.aps().aol().kiM, e.access$100());
            return;
        }
        x.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        g.pQN.a(400, 119, 1, false);
        this.koc.al(false);
        b.aps().aol().kiJ = -5;
        this.koc.mK(-5);
    }
}
