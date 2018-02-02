package com.tencent.mars.smc;

import com.tencent.mm.protocal.a.a.a;
import com.tencent.mm.protocal.a.a.b;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.d;
import com.tencent.mm.protocal.a.a.e;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.a.a.l;
import com.tencent.mm.protocal.a.a.m;
import com.tencent.mm.protocal.a.a.n;
import com.tencent.mm.protocal.a.a.o;
import com.tencent.mm.protocal.c.aay;
import com.tencent.mm.protocal.c.aaz;
import com.tencent.mm.protocal.c.akz;
import com.tencent.mm.protocal.c.ala;
import com.tencent.mm.protocal.c.ank;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.protocal.c.bmd;
import com.tencent.mm.protocal.c.nz;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.protocal.c.ob;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil {
    public static oa toMMReportKvReq(i iVar) {
        oa oaVar = new oa();
        oaVar.vWL = iVar.vCd;
        oaVar.vWM = iVar.vCt;
        oaVar.vWN = iVar.vCr;
        for (int i = 0; i < iVar.vCu.size(); i++) {
            e eVar = (e) iVar.vCu.get(i);
            nz nzVar = new nz();
            nzVar.lOd = eVar.uin;
            nzVar.vLa = eVar.vCb;
            nzVar.vWK = eVar.nettype;
            nzVar.vOh = eVar.vCn;
            nzVar.vOf = eVar.vCl;
            nzVar.vOg = eVar.vCm;
            nzVar.vOi = eVar.vCo;
            nzVar.vOj = eVar.vCp;
            nzVar.ktS = eVar.vCq;
            for (int i2 = 0; i2 < eVar.vCc.size(); i2++) {
                d dVar = (d) eVar.vCc.get(i2);
                ank com_tencent_mm_protocal_c_ank = new ank();
                com_tencent_mm_protocal_c_ank.wuu = dVar.vCa;
                com_tencent_mm_protocal_c_ank.wuv = dVar.vCj;
                com_tencent_mm_protocal_c_ank.wuw = dVar.vCk;
                com_tencent_mm_protocal_c_ank.vZk = dVar.qox;
                com_tencent_mm_protocal_c_ank.ksO = dVar.count;
                nzVar.ngS.add(com_tencent_mm_protocal_c_ank);
            }
            oaVar.vWO.add(nzVar);
        }
        return oaVar;
    }

    public static oa toMMReportIdkeyReq(g gVar) {
        oa oaVar = new oa();
        oaVar.vWL = gVar.vCd;
        oaVar.vWM = gVar.vCt;
        oaVar.vWN = 0;
        for (int i = 0; i < gVar.vCu.size(); i++) {
            b bVar = (b) gVar.vCu.get(i);
            nz nzVar = new nz();
            nzVar.lOd = bVar.uin;
            nzVar.vLa = bVar.vCb;
            nzVar.vWK = bVar.nettype;
            for (int i2 = 0; i2 < bVar.vCc.size(); i2++) {
                a aVar = (a) bVar.vCc.get(i2);
                ank com_tencent_mm_protocal_c_ank = new ank();
                com_tencent_mm_protocal_c_ank.wuu = aVar.vCa;
                com_tencent_mm_protocal_c_ank.vZk = 0;
                com_tencent_mm_protocal_c_ank.wuw = 0;
                com_tencent_mm_protocal_c_ank.ksO = aVar.count;
                com_tencent_mm_protocal_c_ank.wuv = com.tencent.mm.bq.b.bc(Integer.toString(aVar.value).getBytes());
                nzVar.ngS.add(com_tencent_mm_protocal_c_ank);
            }
            oaVar.vWO.add(nzVar);
        }
        return oaVar;
    }

    private static o fillStrategyTable(LinkedList<bmd> linkedList) {
        o oVar = new o();
        for (int i = 0; i < linkedList.size(); i++) {
            bmd com_tencent_mm_protocal_c_bmd = (bmd) linkedList.get(i);
            m mVar = new m();
            mVar.vCG = com_tencent_mm_protocal_c_bmd.wPJ;
            mVar.vCH = com_tencent_mm_protocal_c_bmd.wPK;
            for (int i2 = 0; i2 < com_tencent_mm_protocal_c_bmd.wPL.size(); i2++) {
                ath com_tencent_mm_protocal_c_ath = (ath) com_tencent_mm_protocal_c_bmd.wPL.get(i2);
                n nVar = new n();
                nVar.vCa = com_tencent_mm_protocal_c_ath.wuu;
                nVar.vCJ = com_tencent_mm_protocal_c_ath.wBq;
                nVar.vCK = com_tencent_mm_protocal_c_ath.wBo;
                nVar.vCL = com_tencent_mm_protocal_c_ath.wBp;
                nVar.vCM = com_tencent_mm_protocal_c_ath.wBr;
                nVar.vCN = com_tencent_mm_protocal_c_ath.wBs;
                nVar.vCO = com_tencent_mm_protocal_c_ath.wBt;
                mVar.vCI.add(nVar);
            }
            oVar.vCP.add(mVar);
        }
        return oVar;
    }

    public static j toSmcReportKvResp(ob obVar) {
        j jVar = new j();
        jVar.ret = obVar.vJU;
        jVar.vCd = obVar.vWR;
        jVar.vCe = obVar.vWS;
        jVar.vCr = obVar.vWT;
        jVar.vCh = obVar.vWX;
        jVar.vCw = obVar.vWY;
        jVar.vCi = obVar.vWZ;
        jVar.vCf = fillStrategyTable(obVar.vWU);
        jVar.vCg = fillStrategyTable(obVar.vWV);
        jVar.vCs = fillStrategyTable(obVar.vWW);
        return jVar;
    }

    public static h toSmcReportIdkeyResp(ob obVar) {
        h hVar = new h();
        hVar.ret = obVar.vJU;
        hVar.vCd = obVar.vWR;
        hVar.vCe = obVar.vWS;
        hVar.vCh = obVar.vWX;
        hVar.vCw = obVar.vWY;
        hVar.vCi = obVar.vWZ;
        hVar.vCf = fillStrategyTable(obVar.vWU);
        hVar.vCg = fillStrategyTable(obVar.vWV);
        return hVar;
    }

    public static aay toMMGetStrategyReq() {
        aay com_tencent_mm_protocal_c_aay = new aay();
        ArrayList strategyVersions = SmcLogic.getStrategyVersions();
        if (strategyVersions.size() != 6) {
            return null;
        }
        com_tencent_mm_protocal_c_aay.vWL = ((Integer) strategyVersions.get(0)).intValue();
        com_tencent_mm_protocal_c_aay.vWM = ((Integer) strategyVersions.get(1)).intValue();
        com_tencent_mm_protocal_c_aay.vWN = ((Integer) strategyVersions.get(2)).intValue();
        com_tencent_mm_protocal_c_aay.wjW = ((Integer) strategyVersions.get(3)).intValue();
        com_tencent_mm_protocal_c_aay.wjX = ((Integer) strategyVersions.get(4)).intValue();
        com_tencent_mm_protocal_c_aay.wjY = ((Integer) strategyVersions.get(5)).intValue();
        return com_tencent_mm_protocal_c_aay;
    }

    public static f toSmcKVStrategyResp(aaz com_tencent_mm_protocal_c_aaz) {
        f fVar = new f();
        fVar.ret = com_tencent_mm_protocal_c_aaz.vJU;
        fVar.vCd = com_tencent_mm_protocal_c_aaz.wjW;
        fVar.vCe = com_tencent_mm_protocal_c_aaz.wjX;
        fVar.vCr = com_tencent_mm_protocal_c_aaz.wjY;
        fVar.vCh = com_tencent_mm_protocal_c_aaz.vWX;
        fVar.vCi = com_tencent_mm_protocal_c_aaz.vWZ;
        fVar.vCf = fillStrategyTable(com_tencent_mm_protocal_c_aaz.wjZ);
        fVar.vCg = fillStrategyTable(com_tencent_mm_protocal_c_aaz.wka);
        fVar.vCs = fillStrategyTable(com_tencent_mm_protocal_c_aaz.wkb);
        return fVar;
    }

    public static c toSmcIdkeyStrategyResp(aaz com_tencent_mm_protocal_c_aaz) {
        c cVar = new c();
        cVar.ret = com_tencent_mm_protocal_c_aaz.vJU;
        cVar.vCd = com_tencent_mm_protocal_c_aaz.vWR;
        cVar.vCe = com_tencent_mm_protocal_c_aaz.vWS;
        cVar.vCh = com_tencent_mm_protocal_c_aaz.vWX;
        cVar.vCi = com_tencent_mm_protocal_c_aaz.vWZ;
        cVar.vCf = fillStrategyTable(com_tencent_mm_protocal_c_aaz.vWU);
        cVar.vCg = fillStrategyTable(com_tencent_mm_protocal_c_aaz.vWV);
        return cVar;
    }

    public static akz toMMSelfMonitor(k kVar) {
        akz com_tencent_mm_protocal_c_akz = new akz();
        com_tencent_mm_protocal_c_akz.wsb = kVar.vCx;
        for (int i = 0; i < kVar.vCy.size(); i++) {
            ala com_tencent_mm_protocal_c_ala = new ala();
            l lVar = (l) kVar.vCy.get(i);
            com_tencent_mm_protocal_c_ala.wsc = lVar.vCz;
            com_tencent_mm_protocal_c_ala.fom = lVar.action;
            com_tencent_mm_protocal_c_ala.wsd = lVar.vCA;
            com_tencent_mm_protocal_c_ala.wse = lVar.vCB;
            com_tencent_mm_protocal_c_ala.wsf = lVar.vCC;
            com_tencent_mm_protocal_c_ala.wsg = lVar.vCD;
            com_tencent_mm_protocal_c_ala.wsh = lVar.vCE;
            com_tencent_mm_protocal_c_ala.wsi = lVar.vCF;
            com_tencent_mm_protocal_c_akz.ngS.add(com_tencent_mm_protocal_c_ala);
        }
        return com_tencent_mm_protocal_c_akz;
    }
}
