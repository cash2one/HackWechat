package com.tencent.mm.plugin.setting.a;

import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class a$4 implements k {
    final int asN = this.qgx;
    final /* synthetic */ long gyu;
    final /* synthetic */ List juo;
    final /* synthetic */ a qgt;
    final /* synthetic */ int qgx;
    final /* synthetic */ LinkedList qgy;

    a$4(a aVar, int i, List list, LinkedList linkedList, long j) {
        this.qgt = aVar;
        this.qgx = i;
        this.juo = list;
        this.qgy = linkedList;
        this.gyu = j;
    }

    public final void b(h hVar) {
        List list = hVar.mMc;
        String str;
        String str2;
        if (list == null || list.size() <= 0) {
            str = "MicroMsg.UnfamiliarContactEngine";
            str2 = "[getSameChatInfoTask] list is null? %s ";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.juo == null);
            x.e(str, str2, objArr);
        } else {
            j jVar = (j) list.get(0);
            if (jVar.userData == null || !(jVar.userData instanceof HashMap)) {
                str2 = "MicroMsg.UnfamiliarContactEngine";
                String str3 = "[getSameChatInfoTask] is null?%s is instanceof List";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Boolean.valueOf(jVar.userData == null);
                objArr2[1] = Boolean.valueOf(jVar.userData instanceof HashMap);
                x.e(str2, str3, objArr2);
            } else {
                HashMap hashMap = (HashMap) jVar.userData;
                synchronized (this.qgt.mLock) {
                    for (String str4 : this.juo) {
                        if (hashMap.containsKey(str4)) {
                            int i;
                            for (j jVar2 : (List) hashMap.get(str4)) {
                                if (jVar2.mMf < 100) {
                                    i = 1;
                                    break;
                                }
                            }
                            i = 0;
                            if (i == 0) {
                                this.qgt.qgp.add(str4);
                            }
                        } else {
                            this.qgt.qgp.add(str4);
                        }
                    }
                }
            }
        }
        if (this.asN >= this.qgy.size()) {
            x.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", new Object[]{Integer.valueOf(this.qgy.size()), Long.valueOf(System.currentTimeMillis() - this.gyu)});
            this.qgt.qgm.countDown();
            return;
        }
        this.qgt.f(this.qgy, this.asN);
    }
}
