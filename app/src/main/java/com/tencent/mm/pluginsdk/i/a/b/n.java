package com.tencent.mm.pluginsdk.i.a.b;

import android.util.SparseArray;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.i.a.a.a;
import com.tencent.mm.pluginsdk.i.a.b.b.c;
import com.tencent.mm.pluginsdk.i.a.b.i.b;
import com.tencent.mm.protocal.c.bcy;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.nk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public abstract class n extends k implements com.tencent.mm.network.k {
    protected static final SparseArray<a> vhp = new SparseArray();
    private volatile e gJT;
    protected final List<bde> vho = new LinkedList();

    protected abstract q bZv();

    protected abstract String getTag();

    protected abstract nk i(q qVar);

    static /* synthetic */ void a(n nVar, int i, bcy com_tencent_mm_protocal_c_bcy) {
        if (com_tencent_mm_protocal_c_bcy != null) {
            x.i(nVar.getTag(), "resType = %d, subType = %d, res.Oper = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_bcy.wFj), Integer.valueOf(com_tencent_mm_protocal_c_bcy.wlp)});
            if (com_tencent_mm_protocal_c_bcy.wJb != null) {
                x.i(nVar.getTag(), "resource.Info.FileFlag %d ", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bcy.wJb.wJm)});
            }
            if (b.BL(com_tencent_mm_protocal_c_bcy.wlp)) {
                x.i(nVar.getTag(), "just do nothing");
                return;
            }
            if (b.BM(com_tencent_mm_protocal_c_bcy.wlp)) {
                x.i(nVar.getTag(), "do cache");
                c.bZm().b(i, com_tencent_mm_protocal_c_bcy, false);
            }
            if (b.BN(com_tencent_mm_protocal_c_bcy.wlp)) {
                x.i(nVar.getTag(), "do decrypt");
                c.bZm().c(i, com_tencent_mm_protocal_c_bcy, false);
            }
            if (b.BO(com_tencent_mm_protocal_c_bcy.wlp)) {
                x.i(nVar.getTag(), "do delete");
                c.bZm().a(i, com_tencent_mm_protocal_c_bcy, false);
            }
        }
    }

    public static void a(a aVar) {
        vhp.put(39, aVar);
    }

    public n() {
        for (int i : i.vgS) {
            a aVar = (a) vhp.get(i);
            if (aVar == null || !aVar.nc(i)) {
                bde com_tencent_mm_protocal_c_bde = new bde();
                com_tencent_mm_protocal_c_bde.ktN = i;
                this.vho.add(com_tencent_mm_protocal_c_bde);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.d(getTag(), "before dispatch");
        return a(eVar, bZv(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            nk i4 = i(qVar);
            String tag = getTag();
            String str2 = "response.Res.size() = %s";
            Object[] objArr = new Object[1];
            objArr[0] = bh.cA(i4.vWq) ? "null" : String.valueOf(i4.vWq.size());
            x.i(tag, str2, objArr);
            if (!bh.cA(i4.vWq)) {
                com.tencent.mm.sdk.f.e.post(new 1(this, i4.vWq), "NetSceneCheckResUpdate-ResponseHandlingThread");
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
