package com.tencent.mm.ay;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.f;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.avb;
import com.tencent.mm.protocal.c.avd;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class r implements e, d {
    j hJf;
    boolean hkG = false;
    long hkQ = 0;
    private final int hyB = 500;
    ak hyD = new ak(g.Dm().oAt.getLooper(), new a(this) {
        final /* synthetic */ r hJg;

        {
            this.hJg = r1;
        }

        public final boolean uF() {
            x.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
            r rVar = this.hJg;
            long Wp = bh.Wp();
            if (rVar.hkG && Wp - rVar.hkQ > 10000) {
                rVar.hkG = false;
            }
            if (rVar.hkG) {
                x.d("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
            } else {
                j jVar = rVar.hJf;
                List arrayList = new ArrayList();
                Cursor a = jVar.hhp.a("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[]{"200"}, 0);
                if (a != null) {
                    int count = a.getCount();
                    if (count > 0) {
                        for (int i = 0; i < count; i++) {
                            a.moveToPosition(i);
                            b bVar = new b(0);
                            bVar.id = a.getInt(0);
                            bVar.hyu = a.getLong(1);
                            bVar.cmdId = a.getInt(2);
                            bVar.buffer = a.getBlob(3);
                            bVar.opa = a.getInt(4);
                            bVar.opb = a.getLong(4);
                            bVar.opc = a.getString(4);
                            bVar.opd = a.getString(4);
                            arrayList.add(bVar);
                        }
                    }
                    a.close();
                }
                if (arrayList.size() == 0) {
                    x.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
                } else {
                    if (!rVar.hkG && arrayList.size() > 0) {
                        rVar.hkQ = Wp;
                        rVar.hkG = true;
                        g.Dk();
                        g.Di().gPJ.a(new a(arrayList), 0);
                    }
                    x.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. ", new Object[]{Long.valueOf(rVar.hkQ), Boolean.valueOf(rVar.hkG), Long.valueOf(System.currentTimeMillis() - Wp)});
                }
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|pusherTry";
        }
    }, false);
    f<Integer, Integer> hyw = new f(200);

    public r(j jVar) {
        this.hJf = jVar;
        g.Dk();
        g.Di().gPJ.a(681, this);
    }

    public final void b(b bVar) {
        if (bVar != null) {
            String str = "MicroMsg.OplogService";
            String str2 = "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bVar.getCmdId());
            objArr[1] = Integer.valueOf(bVar.getBuffer() == null ? -1 : bVar.getBuffer().length);
            objArr[2] = bh.cgy();
            x.i(str, str2, objArr);
            bVar.hyu = bh.Wp();
            j jVar = this.hJf;
            if (bVar != null) {
                bVar.fDt = -1;
                ContentValues contentValues = new ContentValues();
                if ((bVar.fDt & 2) != 0) {
                    contentValues.put("inserTime", Long.valueOf(bVar.hyu));
                }
                if ((bVar.fDt & 4) != 0) {
                    contentValues.put("cmdId", Integer.valueOf(bVar.getCmdId()));
                }
                if ((bVar.fDt & 8) != 0) {
                    contentValues.put("buffer", bVar.getBuffer());
                }
                if ((bVar.fDt & 16) != 0) {
                    contentValues.put("reserved1", Integer.valueOf(bVar.opa));
                }
                if ((bVar.fDt & 32) != 0) {
                    contentValues.put("reserved2", Long.valueOf(bVar.opb));
                }
                if ((bVar.fDt & 64) != 0) {
                    contentValues.put("reserved3", bVar.opc);
                }
                if ((bVar.fDt & FileUtils.S_IWUSR) != 0) {
                    contentValues.put("reserved4", bVar.opd);
                }
                int insert = (int) jVar.hhp.insert("oplog2", SlookAirButtonFrequentContactAdapter.ID, contentValues);
                if (insert > 0) {
                    bVar.id = insert;
                }
            }
        } else {
            x.i("MicroMsg.OplogService", "summeroplog dealWith option null");
        }
        this.hyD.J(0, 0);
    }

    public final void c(b bVar) {
        g.Dk();
        long dz = g.Dj().gQj.dz(Thread.currentThread().getId());
        this.hJf.a(bVar);
        g.Dk();
        g.Dj().gQj.fS(dz);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar.getType() == 681) {
            if (i == 0 && i2 == 0 && ((a) kVar).hIJ != null) {
                avd com_tencent_mm_protocal_c_avd = ((a) kVar).hIJ.hIM.hIO;
                if (com_tencent_mm_protocal_c_avd.vJU != 0 || com_tencent_mm_protocal_c_avd.wCP == null || com_tencent_mm_protocal_c_avd.wCP.wkm == null) {
                    x.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_avd.vJU)});
                    this.hkG = false;
                    return;
                }
                com.tencent.mm.sdk.b.b ljVar = new lj();
                ljVar.fCK.ret = ((Integer) com_tencent_mm_protocal_c_avd.wCP.wkm.getLast()).intValue();
                LinkedList linkedList = com_tencent_mm_protocal_c_avd.wCP.wCQ;
                ljVar.fCK.fCL = linkedList.isEmpty() ? "" : ((avb) linkedList.getLast()).fon;
                ljVar.fCK.fCM = linkedList.isEmpty() ? "" : ((avb) linkedList.getLast()).nje;
                com.tencent.mm.sdk.b.a.xef.m(ljVar);
                new a(this, ((a) kVar).hIK, com_tencent_mm_protocal_c_avd.wCP.wkm).J(50, 50);
                return;
            }
            x.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ((a) kVar).hIJ.toString()});
            this.hkG = false;
        }
    }
}
