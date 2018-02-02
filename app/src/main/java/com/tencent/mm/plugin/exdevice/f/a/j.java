package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.ahh;
import com.tencent.mm.protocal.c.ahi;
import com.tencent.mm.protocal.c.cbz;
import com.tencent.mm.protocal.c.cca;
import com.tencent.mm.protocal.c.wb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends a<ahh, ahi> {
    public String appName;
    public String lOX;
    public String lOY;
    public boolean lPh;
    public boolean lPi;
    public String lPj;
    public String lPk;
    public com.tencent.mm.plugin.exdevice.f.b.a.a lPl;
    public ArrayList<d> lPm;
    public ArrayList<c> lPn;
    public ArrayList<e> lPo;
    public ArrayList<String> lPp;
    public String lPq;
    public String lPr;
    public boolean lPs;
    public boolean lPt;
    public String lPu;
    private final WeakReference<b<j>> lPv;
    public a lPw;

    protected final /* synthetic */ com.tencent.mm.bq.a aDC() {
        return new ahh();
    }

    protected final /* synthetic */ com.tencent.mm.bq.a aDD() {
        return new ahi();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bq.a aVar) {
        ahh com_tencent_mm_protocal_c_ahh = (ahh) aVar;
        com_tencent_mm_protocal_c_ahh.lWn = this.appName;
        com_tencent_mm_protocal_c_ahh.hbH = this.lPj;
        com_tencent_mm_protocal_c_ahh.woJ = this.lPi;
        com_tencent_mm_protocal_c_ahh.woK = this.lPk;
    }

    public j(String str, String str2, String str3, boolean z, b<j> bVar) {
        this.lPv = new WeakReference(bVar);
        this.lPq = str;
        this.lPj = str;
        this.appName = bh.ou(str2);
        this.lPi = z;
        this.lPk = str3;
    }

    public final int getType() {
        return 1042;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            Iterator it;
            String str2;
            String str3;
            Object obj;
            String str4;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar;
            ahi com_tencent_mm_protocal_c_ahi = (ahi) apH();
            String str5 = "";
            this.lPn = new ArrayList();
            if (com_tencent_mm_protocal_c_ahi.vGV != null) {
                it = com_tencent_mm_protocal_c_ahi.vGV.iterator();
                while (it.hasNext()) {
                    wb wbVar = (wb) it.next();
                    ar.Hg();
                    if (com.tencent.mm.z.c.EY().WK(wbVar.username)) {
                        str2 = com_tencent_mm_protocal_c_ahi.hbH;
                        str3 = this.appName;
                        if (bh.ov(str2) || wbVar == null) {
                            x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                            obj = null;
                        } else {
                            c cVar = new c();
                            cVar.field_rankID = str2;
                            cVar.field_username = wbVar.username;
                            cVar.field_step = wbVar.jer;
                            cVar.field_appusername = str3;
                            c cVar2 = cVar;
                        }
                        if (obj != null) {
                            this.lPn.add(obj);
                        }
                    } else {
                        ar.CG().a(new h(wbVar.username, null), 0);
                    }
                }
            }
            this.lPm = new ArrayList();
            if (com_tencent_mm_protocal_c_ahi.woL != null) {
                it = com_tencent_mm_protocal_c_ahi.woL.iterator();
                while (it.hasNext()) {
                    d dVar;
                    cbz com_tencent_mm_protocal_c_cbz = (cbz) it.next();
                    str2 = com_tencent_mm_protocal_c_ahi.hbH;
                    str3 = this.appName;
                    if (bh.ov(str2) || com_tencent_mm_protocal_c_cbz == null) {
                        x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        dVar = null;
                    } else {
                        dVar = new d();
                        dVar.field_appusername = str3;
                        dVar.field_rankID = str2;
                        dVar.field_likecount = com_tencent_mm_protocal_c_cbz.xaX;
                        dVar.field_ranknum = com_tencent_mm_protocal_c_cbz.xaW;
                        dVar.field_score = com_tencent_mm_protocal_c_cbz.score;
                        dVar.field_selfLikeState = com_tencent_mm_protocal_c_cbz.xaY;
                        dVar.field_username = com_tencent_mm_protocal_c_cbz.username;
                    }
                    if (dVar != null) {
                        if (dVar.field_ranknum == 1) {
                            str4 = dVar.field_username;
                        } else {
                            str4 = str5;
                        }
                        this.lPm.add(dVar);
                        str5 = str4;
                    }
                }
            }
            this.lPo = new ArrayList();
            if (com_tencent_mm_protocal_c_ahi.woM != null) {
                it = com_tencent_mm_protocal_c_ahi.woM.iterator();
                while (it.hasNext()) {
                    cca com_tencent_mm_protocal_c_cca = (cca) it.next();
                    str2 = com_tencent_mm_protocal_c_ahi.hbH;
                    str3 = this.appName;
                    if (bh.ov(str2) || com_tencent_mm_protocal_c_cca == null) {
                        x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        obj = null;
                    } else {
                        e eVar = new e();
                        eVar.field_appusername = str3;
                        eVar.field_rankID = str2;
                        eVar.field_timestamp = com_tencent_mm_protocal_c_cca.cRJ;
                        eVar.field_username = com_tencent_mm_protocal_c_cca.username;
                        e eVar2 = eVar;
                    }
                    if (obj != null) {
                        this.lPo.add(obj);
                    }
                }
            }
            this.lPp = new ArrayList();
            if (com_tencent_mm_protocal_c_ahi.woE != null) {
                Iterator it2 = com_tencent_mm_protocal_c_ahi.woE.iterator();
                while (it2.hasNext()) {
                    this.lPp.add((String) it2.next());
                }
            }
            if (!bh.ov(this.lPk)) {
                str5 = this.lPk;
            }
            String str6 = com_tencent_mm_protocal_c_ahi.woN;
            String str7 = com_tencent_mm_protocal_c_ahi.woO;
            if (bh.ov(str5)) {
                x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                aVar = null;
            } else {
                aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
                aVar.field_username = str5;
                aVar.field_championUrl = str6;
                aVar.field_championMotto = str7;
            }
            this.lPl = aVar;
            this.lPq = com_tencent_mm_protocal_c_ahi.hbH;
            this.lOY = com_tencent_mm_protocal_c_ahi.woG;
            this.lOX = com_tencent_mm_protocal_c_ahi.woF;
            this.lPr = com_tencent_mm_protocal_c_ahi.woP;
            this.lPs = com_tencent_mm_protocal_c_ahi.lPs;
            this.lPt = com_tencent_mm_protocal_c_ahi.woS == 1;
            this.lPu = com_tencent_mm_protocal_c_ahi.woT;
            this.lPh = com_tencent_mm_protocal_c_ahi.woI;
            x.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
            if (this.lPj == null || !this.lPj.equals(this.lPq)) {
                f fVar = ad.aEs().lPD;
                if (fVar != null) {
                    fVar.yZ(this.lPq);
                }
            }
            if (this.lPw != null && this.lPi) {
                this.lPw.a(this);
            }
            if (this.lPi) {
                ad.aEm().aE(this.lPn);
            }
            com.tencent.mm.plugin.exdevice.f.b.b.d aEl = ad.aEl();
            if (bh.ov(this.lPq)) {
                x.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
            } else {
                int delete = aEl.gJP.delete("HardDeviceRankInfo", "rankID = ? ", new String[]{this.lPq});
                x.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", str4, Integer.valueOf(delete));
            }
            ad.aEl().e(this.lPq, this.lPm);
            str4 = "MicroMsg.NetSceneGetRankInfo";
            str5 = "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(this.lPs);
            objArr[1] = Integer.valueOf(this.lPn != null ? this.lPn.size() : 0);
            objArr[2] = Integer.valueOf(this.lPm != null ? this.lPm.size() : 0);
            objArr[3] = Integer.valueOf(this.lPo != null ? this.lPo.size() : 0);
            x.i(str4, str5, objArr);
            ad.aEp().a(this.lPq, this.appName, this.lPo);
            if (this.lPl != null) {
                ad.aEo().a(this.lPl, true);
            }
        }
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.lPv.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserranklike";
    }
}
