package com.tencent.mm.ay;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class r$a$1 implements a {
    private int hFt = 0;
    private int hJh = 0;
    final /* synthetic */ r hJi;
    final /* synthetic */ List hJj;
    final /* synthetic */ LinkedList hJk;

    r$a$1(r rVar, List list, LinkedList linkedList) {
        this.hJi = rVar;
        this.hJj = list;
        this.hJk = linkedList;
    }

    public final boolean uF() {
        int i = 0;
        int size = this.hJj.size();
        int size2 = this.hJk.size();
        int i2 = size < size2 ? size : size2;
        if (size != size2) {
            x.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", new Object[]{Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(i2), Integer.valueOf(this.hFt)});
        }
        List arrayList = new ArrayList();
        if (this.hFt >= i2) {
            this.hJi.hkG = false;
            if (this.hJh > 0) {
                long j;
                ak akVar = this.hJi.hyD;
                if (this.hJi.hyw.size() > 0) {
                    j = 500;
                } else {
                    j = 0;
                }
                akVar.J(j, j);
            }
            return false;
        }
        size = this.hFt + 20;
        if (size > i2) {
            size2 = i2;
        } else {
            size2 = size;
        }
        while (this.hFt < size2) {
            size = ((Integer) this.hJk.get(this.hFt)).intValue();
            b bVar = (b) this.hJj.get(this.hFt);
            int i3 = bVar.id;
            x.d("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(bVar.getCmdId()), Integer.valueOf(size)});
            if (size == 0) {
                this.hJh++;
                arrayList.add(bVar);
                this.hJi.hyw.remove(Integer.valueOf(i3));
            } else if (size == -433) {
                x.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(bVar.getCmdId())});
            } else {
                Integer num = (Integer) this.hJi.hyw.get(Integer.valueOf(i3));
                x.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[]{Integer.valueOf(i3), Long.valueOf(bVar.hyu), num});
                if (num == null) {
                    this.hJi.hyw.l(Integer.valueOf(i3), Integer.valueOf(1));
                } else if (num.intValue() < 2) {
                    this.hJi.hyw.l(Integer.valueOf(i3), Integer.valueOf(num.intValue() + 1));
                } else {
                    x.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[]{Integer.valueOf(i3), Long.valueOf(bVar.hyu)});
                    arrayList.add(bVar);
                }
            }
            this.hFt++;
        }
        size = arrayList.size();
        if (size > 0) {
            g.Dk();
            long dz = g.Dj().gQj.dz(Thread.currentThread().getId());
            while (i < size) {
                this.hJi.hJf.a((b) arrayList.get(i));
                i++;
            }
            g.Dk();
            g.Dj().gQj.fS(dz);
        }
        return true;
    }

    public final String toString() {
        return super.toString() + "|RespHandler";
    }
}
