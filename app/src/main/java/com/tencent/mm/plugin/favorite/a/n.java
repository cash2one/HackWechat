package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.ft;
import com.tencent.mm.protocal.c.fu;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class n extends k implements com.tencent.mm.network.k {
    private static AtomicInteger mqA = new AtomicInteger(0);
    private final b gJQ;
    private e gJT = null;
    private LinkedList<Integer> mqw;
    private int mqx = 0;
    private boolean mqy = false;
    private boolean mqz = false;

    public n(LinkedList<Integer> linkedList) {
        a aVar = new a();
        aVar.hmj = new ft();
        aVar.hmk = new fu();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
        aVar.hmi = com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.mqw = linkedList;
        mqA.incrementAndGet();
    }

    public static void aIS() {
        mqA.set(0);
    }

    public static void aIT() {
        mqA.decrementAndGet();
    }

    public static int aIU() {
        return mqA.get();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[]{Integer.valueOf(mqA.get())});
        if (this.mqw == null || this.mqw.isEmpty() || this.mqx >= this.mqw.size()) {
            x.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[]{Integer.valueOf(this.mqx)});
            return -1;
        }
        x.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[]{Integer.valueOf(this.mqw.size()), Integer.valueOf(this.mqx), this.mqw});
        ar.Hg();
        if (bh.e((Integer) c.CU().get(8217, null)) == 0) {
            x.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
            return -1;
        }
        ft ftVar = (ft) this.gJQ.hmg.hmo;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.mqw.subList(this.mqx, Math.min(this.mqx + 15, this.mqw.size())));
        ftVar.vLf = linkedList;
        ftVar.ksO = linkedList.size();
        this.mqx += 15;
        x.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList});
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    private boolean aIR() {
        boolean z;
        boolean z2;
        ar.Hg();
        if (bh.e((Integer) c.CU().get(8217, null)) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.mqw == null || this.mqx >= this.mqw.size()) {
            z2 = false;
        } else {
            z2 = true;
        }
        x.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z || !z2) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mqx), Integer.valueOf(this.mqw.size()), str});
        if (i2 == 0 && i3 == 0) {
            fu fuVar = (fu) ((b) qVar).hmh.hmo;
            int i4 = fuVar.ksO;
            int size = fuVar.vLo.size();
            if (i4 != size) {
                String str2 = "MicroMsg.NetSceneBatchgetFav";
                String str3 = "klem onGYNet resp list size:%d, return count %d, request count %d";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(size);
                objArr[1] = Integer.valueOf(i4);
                objArr[2] = Integer.valueOf(this.mqx > this.mqw.size() ? this.mqw.size() % 15 : 15);
                x.e(str2, str3, objArr);
                if (aIR()) {
                    a(this.hmA, this.gJT);
                    return;
                }
                mqA.decrementAndGet();
                this.gJT.a(i2, -1, str, this);
                return;
            }
            for (int i5 = 0; i5 < size; i5++) {
                uz uzVar = (uz) fuVar.vLo.get(i5);
                x.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[]{Integer.valueOf(uzVar.vGM), Integer.valueOf(uzVar.ktm)});
                if (uzVar.ktm == 0) {
                    f dc = h.getFavItemInfoStorage().dc((long) uzVar.vGM);
                    if (dc == null) {
                        x.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[]{Integer.valueOf(uzVar.vGM)});
                    } else {
                        dc.field_xml = uzVar.vGT;
                        dc.zQ(uzVar.vGT);
                        dc.field_flag = uzVar.vGN;
                        dc.field_localSeq = uzVar.vGP;
                        dc.field_updateTime = (((long) uzVar.vGO) * 1000) + ((long) i5);
                        x.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", new Object[]{dc.field_xml});
                        int size2 = dc.field_favProto.weU.size();
                        if (size2 == 0) {
                            x.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[]{Integer.valueOf(dc.field_id)});
                        } else {
                            List list = dc.field_favProto.weU;
                            for (int i6 = size2 - 1; i6 >= 0; i6--) {
                                uq uqVar = (uq) list.get(i6);
                                if (!bh.ov(uqVar.wda)) {
                                    x.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[]{new File(j.h(uqVar)).getName()});
                                    if (new File(j.h(uqVar)).exists()) {
                                        if (uqVar.wdz != 0) {
                                            x.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[]{uqVar.wda});
                                            this.mqz = true;
                                            j.a(uqVar, dc, 0, false);
                                        }
                                        x.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(dc.field_id), Integer.valueOf(i6)});
                                    } else if (bh.ov(uqVar.wcL) || bh.ov(uqVar.wcJ)) {
                                        x.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[]{Integer.valueOf(dc.field_id)});
                                    } else {
                                        x.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(dc.field_id), Integer.valueOf(i6)});
                                        j.a(uqVar, dc, 1, false);
                                        this.mqy = true;
                                    }
                                }
                                if (!bh.ov(uqVar.wdl)) {
                                    if (new File(j.i(uqVar)).exists()) {
                                        x.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(dc.field_id), Integer.valueOf(i6)});
                                    } else if (bh.ov(uqVar.wcF) || bh.ov(uqVar.hbj)) {
                                        x.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", new Object[]{Integer.valueOf(dc.field_id)});
                                    } else {
                                        x.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(dc.field_id), Integer.valueOf(i6)});
                                        j.a(uqVar, dc, 1);
                                        this.mqy = true;
                                    }
                                }
                            }
                        }
                        x.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[]{Boolean.valueOf(this.mqz), Boolean.valueOf(this.mqy)});
                        if (this.mqz) {
                            dc.field_itemStatus = 15;
                            h.getFavItemInfoStorage().a(dc, new String[]{"localId"});
                            h.aIr().run();
                        } else if (this.mqy) {
                            dc.field_itemStatus = 10;
                            h.getFavItemInfoStorage().a(dc, new String[]{"localId"});
                        } else {
                            dc.field_itemStatus = 10;
                            h.getFavItemInfoStorage().a(dc, new String[]{"localId"});
                        }
                        j.t(dc);
                        dc.zR("MicroMsg.NetSceneBatchgetFav");
                    }
                }
                if ((uzVar.vGN & 1) != 0) {
                    x.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[]{Integer.valueOf(uzVar.vGM)});
                    j.a(h.getFavItemInfoStorage().dc((long) uzVar.vGM), null);
                }
            }
            h.aIr().run();
            if (aIR()) {
                a(this.hmA, this.gJT);
                return;
            }
            mqA.decrementAndGet();
            this.gJT.a(i2, i3, str, this);
        } else if (aIR()) {
            a(this.hmA, this.gJT);
        } else {
            mqA.decrementAndGet();
            this.gJT.a(i2, i3, str, this);
        }
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 10;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX;
    }
}
