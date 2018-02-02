package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.at.c;
import com.tencent.mm.plugin.sns.ui.au.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Map;

class at$1 implements b {
    final /* synthetic */ c rFi;
    final /* synthetic */ at rFj;

    at$1(at atVar, c cVar) {
        this.rFj = atVar;
        this.rFi = cVar;
    }

    public final void a(List<m> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2) {
        x.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
        at atVar = this.rFj;
        x.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
        if (list != null && list.size() > 0) {
            int i3;
            x.d("MicroMsg.SnsphotoAdapter", "copy list info");
            int size = list.size();
            atVar.list.clear();
            atVar.rqp.clear();
            atVar.rqq.clear();
            atVar.rEX.clear();
            for (i3 = 0; i3 < size; i3++) {
                atVar.list.add(m.x((m) list.get(i3)));
            }
            for (Integer intValue : map.keySet()) {
                size = intValue.intValue();
                atVar.rqp.put(Integer.valueOf(size), Integer.valueOf(((Integer) map.get(Integer.valueOf(size))).intValue()));
            }
            for (Integer intValue2 : map2.keySet()) {
                size = intValue2.intValue();
                atVar.rqq.put(Integer.valueOf(size), Integer.valueOf(((Integer) map2.get(Integer.valueOf(size))).intValue()));
            }
            for (Integer intValue22 : map3.keySet()) {
                size = intValue22.intValue();
                atVar.rEX.put(Integer.valueOf(size), Integer.valueOf(((Integer) map3.get(Integer.valueOf(size))).intValue()));
            }
            map.clear();
            map2.clear();
            if (atVar.fuf) {
                i3 = atVar.list.size() <= 1 ? Integer.MAX_VALUE : ((m) atVar.list.get(1)).field_head;
            } else {
                i3 = atVar.list.isEmpty() ? Integer.MAX_VALUE : ((m) atVar.list.get(0)).field_head;
            }
            atVar.rFc = 0;
            size = 0;
            while (size < atVar.list.size()) {
                if (!atVar.fuf || size != 0) {
                    if (i3 != ((m) atVar.list.get(size)).field_head) {
                        break;
                    }
                    atVar.rFc = Math.max(atVar.rFc, ((m) atVar.list.get(size)).field_createTime);
                }
                size++;
            }
            if (atVar.list.isEmpty() || (atVar.fuf && atVar.list.size() == 1)) {
                atVar.rFc = Integer.MAX_VALUE;
            }
            i3 = atVar.list.isEmpty() ? 0 : ((m) atVar.list.get(atVar.list.size() - 1)).field_head;
            atVar.rFd = Integer.MAX_VALUE;
            int size2 = atVar.list.size() - 1;
            while (size2 >= 0 && i3 != 0 && i3 == ((m) atVar.list.get(size2)).field_head) {
                atVar.rFd = Math.min(atVar.rFd, ((m) atVar.list.get(size2)).field_createTime);
                size2--;
            }
            if (atVar.list.isEmpty()) {
                atVar.rFd = 0;
            }
            atVar.rqs = i;
            atVar.rqr = i2;
            x.d("MicroMsg.SnsphotoAdapter", "reallyCount " + i + " icount " + i2 + " stTime " + atVar.rFc + " edTIme " + atVar.rFd);
            atVar.notifyDataSetChanged();
        }
    }

    public final void bBs() {
        this.rFj.notifyDataSetChanged();
    }
}
