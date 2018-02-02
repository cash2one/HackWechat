package com.tencent.mm.plugin.favorite.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.mm;
import com.tencent.mm.protocal.c.mn;
import com.tencent.mm.protocal.c.mo;
import com.tencent.mm.protocal.c.up;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkUpdater;

public final class o extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT = null;
    private int mqB = 0;
    public f mqC;
    private boolean mqD = true;
    private boolean mqE = false;
    HashMap<uq, Boolean> mqF = new HashMap();

    public o(f fVar) {
        a aVar = new a();
        aVar.hmj = new mn();
        aVar.hmk = new mo();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcdn";
        aVar.hmi = TencentLocation.ERROR_UNKNOWN;
        aVar.hml = 197;
        aVar.hmm = 1000000197;
        this.gJQ = aVar.JZ();
        this.mqC = fVar;
        Iterator it = fVar.field_favProto.weU.iterator();
        while (it.hasNext()) {
            this.mqF.put((uq) it.next(), Boolean.valueOf(false));
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        int i = 0;
        for (uq uqVar : this.mqF.keySet()) {
            int i2;
            if (((Boolean) this.mqF.get(uqVar)).booleanValue()) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
            i = i2;
        }
        if (i == 0) {
            x.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
            this.mqB = -100;
            return -100;
        }
        int i3;
        mn mnVar = (mn) this.gJQ.hmg.hmo;
        mnVar.ksP.clear();
        List list = this.mqC.field_favProto.weU;
        int i4 = 0;
        int i5 = 0;
        while (i4 < list.size()) {
            uq uqVar2 = (uq) list.get(i4);
            if (!((Boolean) this.mqF.get(uqVar2)).booleanValue()) {
                if (!uqVar2.wdv) {
                    mm mmVar = new mm();
                    mmVar.vVj = (int) uqVar2.wde;
                    mmVar.vVh = uqVar2.wda;
                    mmVar.vVi = uqVar2.wdc;
                    mmVar.vVg = String.valueOf(i4);
                    mmVar.vVl = uqVar2.wdr;
                    mmVar.vVk = this.mqC.field_sourceType;
                    mmVar.vVm = 0;
                    mnVar.ksP.add(mmVar);
                    i5++;
                    x.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[]{mmVar.vVg, mmVar.vVl, Integer.valueOf(mmVar.vVk), Integer.valueOf(mmVar.vVj), mmVar.vVh, mmVar.vVi});
                }
                if (uqVar2.wdx) {
                    i3 = i5;
                } else {
                    mm mmVar2 = new mm();
                    mmVar2.vVj = (int) uqVar2.wdp;
                    mmVar2.vVh = uqVar2.wdl;
                    mmVar2.vVi = uqVar2.wdn;
                    mmVar2.vVl = uqVar2.wdr;
                    mmVar2.vVk = this.mqC.field_sourceType;
                    mmVar2.vVg = i4 + "t";
                    mmVar2.vVm = 1;
                    mnVar.ksP.add(mmVar2);
                    i3 = i5 + 1;
                    x.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[]{mmVar2.vVg, mmVar2.vVl, Integer.valueOf(mmVar2.vVk), Integer.valueOf(mmVar2.vVj), mmVar2.vVh, mmVar2.vVi});
                }
                if (i3 >= 19) {
                    break;
                }
            } else {
                i3 = i5;
            }
            i4++;
            i5 = i3;
        }
        i3 = i5;
        x.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4 + 1)});
        mnVar.ksO = i3;
        if (i3 != 0) {
            return a(eVar, this.gJQ, this);
        }
        x.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
        this.mqB = XWalkUpdater.ERROR_SET_VERNUM;
        return XWalkUpdater.ERROR_SET_VERNUM;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mqB), str});
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 3 && this.mqB == -100) {
                x.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
                h.getFavItemInfoStorage().t(9, this.mqC.field_localId);
                h.aIn().run();
                this.gJT.a(i2, i3, str, this);
                return;
            } else if (i2 == 3 && this.mqB == XWalkUpdater.ERROR_SET_VERNUM) {
                i3 = 0;
            } else {
                this.gJT.a(i2, i3, str, this);
                return;
            }
        }
        if (this.mqB != XWalkUpdater.ERROR_SET_VERNUM && i2 == 0 && i3 == 0) {
            int i4;
            List list = ((mo) ((b) qVar).hmh.hmo).ksP;
            List list2 = this.mqC.field_favProto.weU;
            for (int i5 = 0; i5 < list.size(); i5++) {
                up upVar = (up) list.get(i5);
                String str2 = upVar.vVg;
                if (!bh.ov(str2)) {
                    uq uqVar;
                    x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[]{Integer.valueOf(upVar.ktm), str2});
                    if (upVar.ktm == 1) {
                        if (str2.endsWith("t")) {
                            uqVar = (uq) list2.get(bh.getInt(str2.substring(0, str2.length() - 1), 0));
                            x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[]{upVar.wcz, upVar.vQA, upVar.vVg, upVar.vVh, Integer.valueOf(upVar.vVj), upVar.vVi});
                            uqVar.Tt(upVar.vQA);
                            uqVar.Ts(upVar.wcz);
                            if (upVar.vVj > 0) {
                                uqVar.fx((long) upVar.vVj);
                                if (!(bh.ov(upVar.vVh) || upVar.vVh.equals(uqVar.wdl))) {
                                    x.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[]{upVar.vVh, uqVar.wdl});
                                    uqVar.TG(upVar.vVh);
                                }
                                if (!(bh.ov(upVar.vVi) || upVar.vVi.equals(uqVar.wdn))) {
                                    x.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[]{upVar.vVi, uqVar.wdn});
                                    uqVar.TH(upVar.vVi);
                                }
                            }
                        } else {
                            uqVar = (uq) list2.get(bh.getInt(str2, 0));
                            x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[]{upVar.wcz, upVar.vQA, upVar.vVg, upVar.vVh, Integer.valueOf(upVar.vVj), upVar.vVi});
                            uqVar.Tv(upVar.vQA);
                            uqVar.Tu(upVar.wcz);
                            if (!bh.ov(upVar.wcA)) {
                                uqVar.TJ(upVar.wcA);
                            }
                            if (bh.ov(uqVar.wda)) {
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
                                uqVar.TB(upVar.vVh);
                                uqVar.fw((long) upVar.vVj);
                                uqVar.TC(upVar.vVi);
                                j.a(uqVar, this.mqC, 1, false);
                            }
                            if (!(bh.ov(upVar.vVh) || upVar.vVh.equals(uqVar.wda))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[]{upVar.vVh, uqVar.wda});
                                uqVar.TB(upVar.vVh);
                            }
                            if (!(bh.ov(upVar.vVi) || upVar.vVi.equals(uqVar.wdc))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[]{upVar.vVi, uqVar.wdc});
                                uqVar.TC(upVar.vVi);
                            }
                            if (upVar.vVj > 0 && ((long) upVar.vVj) != uqVar.wde) {
                                x.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[]{Integer.valueOf(upVar.vVj), Long.valueOf(uqVar.wde)});
                                uqVar.fw((long) upVar.vVj);
                            }
                        }
                    }
                    if (str2.endsWith("t")) {
                        this.mqF.put((uq) list2.get(bh.getInt(str2.substring(0, str2.length() - 1), 0)), Boolean.valueOf(true));
                    } else {
                        this.mqF.put((uq) list2.get(bh.getInt(str2, 0)), Boolean.valueOf(true));
                    }
                    if (upVar.ktm == 3 || upVar.ktm == -2 || upVar.ktm == -1) {
                        if (str2.endsWith("t")) {
                            uqVar = (uq) list2.get(bh.getInt(str2.substring(0, str2.length() - 1), 0));
                            if (bh.ov(uqVar.wdl)) {
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[]{uqVar.wdl});
                            } else {
                                this.mqD = false;
                                if (bh.ov(uqVar.wcL)) {
                                    g.MK();
                                    uqVar.Tv(com.tencent.mm.modelcdntran.b.MC());
                                    x.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[]{r10});
                                }
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", new Object[]{uqVar.wda, uqVar.wcL});
                                j.a(uqVar, this.mqC, 0);
                            }
                        } else {
                            uqVar = (uq) list2.get(bh.getInt(str2, 0));
                            if (bh.ov(uqVar.wda)) {
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[]{uqVar.wda});
                            } else {
                                this.mqD = false;
                                if (bh.ov(uqVar.wcL)) {
                                    g.MK();
                                    uqVar.Tv(com.tencent.mm.modelcdntran.b.MC());
                                    x.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[]{r10});
                                }
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", new Object[]{uqVar.wda, uqVar.wcL});
                                j.a(uqVar, this.mqC, 0, false);
                            }
                        }
                    }
                    if (upVar.ktm == 2) {
                        this.mqE = true;
                        if (str2.endsWith("t")) {
                            x.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
                        } else {
                            x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[]{Integer.valueOf(upVar.wcB), upVar.wcz, upVar.vQA});
                            uqVar = (uq) list2.get(bh.getInt(str2, 0));
                            uqVar.CK(upVar.wcB);
                            uqVar.Tv(upVar.vQA);
                            uqVar.Tu(upVar.wcz);
                            if (!bh.ov(upVar.wcA)) {
                                uqVar.TJ(upVar.wcA);
                            }
                            if (!(bh.ov(upVar.vVh) || upVar.vVh.equals(uqVar.wda))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[]{upVar.vVh, uqVar.wda});
                                uqVar.TB(upVar.vVh);
                            }
                            if (!(bh.ov(upVar.vVi) || upVar.vVi.equals(uqVar.wdc))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[]{upVar.vVi, uqVar.wdc});
                                uqVar.TC(upVar.vVi);
                            }
                            if (upVar.vVj > 0 && ((long) upVar.vVj) != uqVar.wde) {
                                x.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[]{Integer.valueOf(upVar.vVj), Long.valueOf(uqVar.wde)});
                                uqVar.fw((long) upVar.vVj);
                            }
                        }
                    }
                }
            }
            int i6 = 0;
            for (uq uqVar2 : this.mqF.keySet()) {
                if (((Boolean) this.mqF.get(uqVar2)).booleanValue()) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            x.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(list2.size())});
            if (i6 > 0) {
                x.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
                i4 = a(this.hmA, this.gJT);
                if (!(i4 == -100 || i4 == XWalkUpdater.ERROR_SET_VERNUM)) {
                    return;
                }
            }
        }
        if (this.mqE) {
            x.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
            this.mqC.field_itemStatus = 12;
            h.getFavItemInfoStorage().a(this.mqC, new String[]{"localId"});
            h.aIn().run();
            this.gJT.a(i2, i3, str, this);
            return;
        }
        if (this.mqD) {
            x.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
            if (this.mqC.field_id > 0) {
                this.mqC.field_itemStatus = 17;
                h.getFavItemInfoStorage().a(this.mqC, new String[]{"localId"});
                h.aIp().run();
            } else {
                if (this.mqC.field_type == 18) {
                    this.mqC.field_favProto.CR(1);
                }
                this.mqC.field_itemStatus = 9;
                h.getFavItemInfoStorage().a(this.mqC, new String[]{"localId"});
                h.aIn().run();
            }
        } else {
            if (this.mqC.field_id > 0) {
                this.mqC.field_itemStatus = 15;
            } else {
                if (this.mqC.field_type == 18) {
                    this.mqC.field_favProto.CR(1);
                }
                this.mqC.field_itemStatus = 4;
            }
            h.getFavItemInfoStorage().a(this.mqC, new String[]{"localId"});
            h.aIr().run();
        }
        this.gJT.a(i2, i3, str, this);
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 10;
    }

    public final int getType() {
        return TencentLocation.ERROR_UNKNOWN;
    }
}
