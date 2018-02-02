package com.tencent.mm.modelmulti;

import com.tencent.mm.booter.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r.c;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Queue;

class r$d implements c {
    final /* synthetic */ r hHn;

    r$d(r rVar) {
        this.hHn = rVar;
    }

    public final boolean b(Queue<c> queue) {
        PInt pInt = new PInt();
        g.Dk();
        g.Dh();
        byte[] a = f.a(pInt, a.Cg());
        String str = "MicroMsg.SyncService";
        String str2 = "%s index:%d, buf.len:%d ";
        Object[] objArr = new Object[3];
        objArr[0] = this;
        objArr[1] = Integer.valueOf(pInt.value);
        objArr[2] = Integer.valueOf(a != null ? a.length : -1);
        x.i(str, str2, objArr);
        if (pInt.value == 0 || bh.bw(a)) {
            return false;
        }
        atj com_tencent_mm_protocal_c_atj;
        int i = pInt.value;
        atj com_tencent_mm_protocal_c_atj2 = null;
        try {
            b bVar = new b();
            bVar.E(a);
            com_tencent_mm_protocal_c_atj = bVar.vBR;
        } catch (Exception e) {
            d.pPH.a(99, 38, 1, false);
            x.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed ", new Object[]{this, Integer.valueOf(i)});
            g.Dk();
            g.Dh();
            f.aL(i, a.Cg());
            com_tencent_mm_protocal_c_atj = com_tencent_mm_protocal_c_atj2;
        } catch (Error e2) {
            d.pPH.a(99, 39, 1, false);
            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
            x.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[]{this, Integer.valueOf(i), Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory)});
            r.C("LightPush memory error", false);
            com_tencent_mm_protocal_c_atj = com_tencent_mm_protocal_c_atj2;
        }
        if (com_tencent_mm_protocal_c_atj == null) {
            return false;
        }
        d.pPH.a(99, 20, 1, false);
        r.a aVar = new r.a(this.hHn, this, true, com_tencent_mm_protocal_c_atj, new 1(this, i), (byte) 0);
        return true;
    }

    public final String toString() {
        return "LightPush[" + hashCode() + "]";
    }
}
