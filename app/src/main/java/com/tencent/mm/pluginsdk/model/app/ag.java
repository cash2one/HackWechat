package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.agj;
import com.tencent.mm.protocal.c.agk;
import com.tencent.mm.protocal.c.ay;
import com.tencent.mm.protocal.c.bar;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.cbw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class ag extends w {
    private int hts;
    LinkedList<f> veS;
    private LinkedList<f> veT;
    private LinkedList<String> veU;

    public ag(String str, LinkedList<String> linkedList) {
        x.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0" + ", limit = 20, lang = " + str + "installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", new Object[]{(String) it.next()});
        }
        this.hts = 3;
        a aVar = new a();
        aVar.hmj = new agj();
        aVar.hmk = new agk();
        aVar.uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
        aVar.hmi = 409;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        agj com_tencent_mm_protocal_c_agj = (agj) this.lMW.hmg.hmo;
        com_tencent_mm_protocal_c_agj.nfC = 3;
        com_tencent_mm_protocal_c_agj.niD = 0;
        com_tencent_mm_protocal_c_agj.niE = 20;
        com_tencent_mm_protocal_c_agj.nhF = str;
        LinkedList au = au(linkedList);
        com_tencent_mm_protocal_c_agj.wnP = au.size();
        com_tencent_mm_protocal_c_agj.nic = au;
        this.veS = new LinkedList();
        this.veT = new LinkedList();
        this.veU = new LinkedList();
        this.veU.addAll(linkedList);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            agk com_tencent_mm_protocal_c_agk = (agk) this.lMW.hmh.hmo;
            if (com_tencent_mm_protocal_c_agk == null) {
                x.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
                return;
            }
            x.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_agk.wnQ), Integer.valueOf(this.hts)});
            i biq = com.tencent.mm.plugin.y.a.a.a.bis().biq();
            b(biq, com_tencent_mm_protocal_c_agk.wnR);
            a(biq, com_tencent_mm_protocal_c_agk.nju);
            return;
        }
        x.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
    }

    private void a(i iVar, LinkedList<ay> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                Object obj;
                ay ayVar = (ay) it.next();
                f aZ = g.aZ(ayVar.nfn, true);
                if (aZ != null) {
                    a(aZ, ayVar);
                    iVar.a(aZ, new String[0]);
                    obj = aZ;
                } else {
                    aZ = new f();
                    aZ.field_appId = ayVar.nfn;
                    a(aZ, ayVar);
                    iVar.l(aZ);
                    f fVar = aZ;
                }
                this.veT.add(obj);
            }
        }
    }

    private void b(i iVar, LinkedList<bar> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bar com_tencent_mm_protocal_c_bar = (bar) it.next();
                if (bh.ov(com_tencent_mm_protocal_c_bar.nfn)) {
                    x.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
                } else {
                    Object obj;
                    boolean z = true;
                    boolean z2 = false;
                    f aZ = g.aZ(com_tencent_mm_protocal_c_bar.nfn, true);
                    String str;
                    String str2;
                    Object[] objArr;
                    if (aZ != null) {
                        boolean z3;
                        a(aZ, com_tencent_mm_protocal_c_bar);
                        if (this.hts == 3) {
                            aZ.field_status = 5;
                            if (bh.ov(aZ.fQM) || bh.ov(aZ.fQL)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params1, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(aZ.fQM != null);
                                objArr[1] = Boolean.valueOf(aZ.fQL != null);
                                x.e(str, str2, objArr);
                                z2 = false;
                                z3 = false;
                                x.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[]{com_tencent_mm_protocal_c_bar.nfn, Boolean.valueOf(z3), Boolean.valueOf(z2)});
                                obj = aZ;
                            }
                        }
                        z3 = iVar.a(aZ, new String[0]);
                        z2 = true;
                        x.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[]{com_tencent_mm_protocal_c_bar.nfn, Boolean.valueOf(z3), Boolean.valueOf(z2)});
                        obj = aZ;
                    } else {
                        f fVar;
                        aZ = new f();
                        aZ.field_appId = com_tencent_mm_protocal_c_bar.nfn;
                        a(aZ, com_tencent_mm_protocal_c_bar);
                        if (this.hts == 3) {
                            aZ.field_status = 5;
                            if (bh.ov(aZ.fQM) || bh.ov(aZ.fQL)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params2, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(aZ.fQM != null);
                                objArr[1] = Boolean.valueOf(aZ.fQL != null);
                                x.e(str, str2, objArr);
                                z = false;
                                x.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[]{com_tencent_mm_protocal_c_bar.nfn, Boolean.valueOf(z2), Boolean.valueOf(z)});
                                fVar = aZ;
                                z2 = z;
                            }
                        }
                        z2 = iVar.l(aZ);
                        x.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[]{com_tencent_mm_protocal_c_bar.nfn, Boolean.valueOf(z2), Boolean.valueOf(z)});
                        fVar = aZ;
                        z2 = z;
                    }
                    if (!(!z2 || this.veU.contains(com_tencent_mm_protocal_c_bar.nfn) || this.veS.contains(obj))) {
                        this.veS.add(obj);
                    }
                }
            }
        }
    }

    private static LinkedList<bdo> au(LinkedList<String> linkedList) {
        LinkedList<bdo> linkedList2 = new LinkedList();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!bh.ov(str)) {
                linkedList2.add(n.os(str));
            }
        }
        return linkedList2;
    }

    private static void a(f fVar, bar com_tencent_mm_protocal_c_bar) {
        fVar.cO(com_tencent_mm_protocal_c_bar.vFV);
        fVar.field_appIconUrl = com_tencent_mm_protocal_c_bar.vFW;
        fVar.cN(com_tencent_mm_protocal_c_bar.wHi);
        fVar.field_appName = com_tencent_mm_protocal_c_bar.niZ;
        fVar.cP(com_tencent_mm_protocal_c_bar.vFX);
        fVar.field_appType = com_tencent_mm_protocal_c_bar.vIU;
        fVar.cR(com_tencent_mm_protocal_c_bar.ngg);
        fVar.field_packageName = com_tencent_mm_protocal_c_bar.vFY;
        fVar.cS(com_tencent_mm_protocal_c_bar.vFZ);
        if (!bh.ov(com_tencent_mm_protocal_c_bar.vFZ)) {
            x.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", new Object[]{com_tencent_mm_protocal_c_bar.vFZ, Integer.valueOf(com_tencent_mm_protocal_c_bar.wHs)});
            fVar.ev(com_tencent_mm_protocal_c_bar.wHs);
        }
        fVar.cT(com_tencent_mm_protocal_c_bar.wHp);
        fVar.cU(com_tencent_mm_protocal_c_bar.wHq);
        a(fVar, com_tencent_mm_protocal_c_bar.vGa);
        if (!bh.ov(fVar.field_appType)) {
            if (fVar.field_appType.startsWith("1") || fVar.field_appType.startsWith("6")) {
                if (!fVar.field_appType.endsWith(",")) {
                    fVar.field_appType += ",";
                }
                fVar.field_appType = "," + fVar.field_appType;
            }
        }
    }

    private static void a(f fVar, cbw com_tencent_mm_protocal_c_cbw) {
        x.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", new Object[]{fVar.field_appId});
        if (com_tencent_mm_protocal_c_cbw != null) {
            fVar.ev(com_tencent_mm_protocal_c_cbw.xaR);
            fVar.cX(com_tencent_mm_protocal_c_cbw.vNd);
            fVar.cY(com_tencent_mm_protocal_c_cbw.nkz);
            fVar.cV(com_tencent_mm_protocal_c_cbw.xaS);
            fVar.cW(com_tencent_mm_protocal_c_cbw.nkB);
            fVar.fQS = com_tencent_mm_protocal_c_cbw.nkC;
            fVar.fPZ = true;
            fVar.ew(com_tencent_mm_protocal_c_cbw.nkD);
            x.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_cbw.xaR), com_tencent_mm_protocal_c_cbw.vNd, com_tencent_mm_protocal_c_cbw.nkz, com_tencent_mm_protocal_c_cbw.xaS, com_tencent_mm_protocal_c_cbw.nkB, com_tencent_mm_protocal_c_cbw.nkC, Integer.valueOf(com_tencent_mm_protocal_c_cbw.nkD)});
        }
    }

    private static void a(f fVar, ay ayVar) {
        fVar.cO(ayVar.vFV);
        fVar.cR(ayVar.ngg);
        fVar.cP(ayVar.vFX);
        fVar.field_appName = ayVar.niZ;
        fVar.field_appIconUrl = ayVar.vFW;
        fVar.cS(ayVar.vFZ);
        fVar.fQU = ayVar.vGb;
        fVar.fPZ = true;
        a(fVar, ayVar.vGa);
    }

    public final byte[] aQX() {
        try {
            return ((b) this.lMW.Kb()).Hq();
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e, "", new Object[0]);
            return null;
        }
    }

    public final void ax(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
            return;
        }
        try {
            this.lMW.hmh.E(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 4;
    }
}
