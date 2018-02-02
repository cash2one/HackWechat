package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.y.a.a.a;
import com.tencent.mm.protocal.c.agk;
import com.tencent.mm.protocal.c.api;
import com.tencent.mm.protocal.c.apj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao implements e, t {
    private static ao vfu;
    public String lang;
    public int vfA = 0;
    public long vfB;
    public boolean vfv = false;
    public boolean vfw = false;
    private List<String> vfx = new LinkedList();
    public long vfy;
    private final int vfz = 20;

    private ao() {
    }

    public static ao bYV() {
        if (vfu == null) {
            vfu = new ao();
        }
        return vfu;
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (g.Dh().Cy()) {
            this.vfv = false;
            x.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (wVar == null) {
                x.e("MicroMsg.SuggestionAppListLogic", "scene == null");
            } else if (i == 0 && i2 == 0) {
                switch (wVar.getType()) {
                    case 4:
                        x.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[]{Integer.valueOf(((agk) ((ag) wVar).lMW.hmh.hmo).wnQ)});
                        LinkedList linkedList = r13.veS;
                        if (linkedList == null || linkedList.size() <= 0) {
                            x.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
                            return;
                        } else if (ac.getContext() == null || a.bis() == null) {
                            x.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
                            return;
                        } else {
                            f fVar;
                            LinkedList linkedList2 = new LinkedList();
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                fVar = (f) it.next();
                                String str2 = "MicroMsg.SuggestionAppListLogic";
                                String str3 = "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]";
                                Object[] objArr = new Object[5];
                                objArr[0] = fVar.field_appName;
                                objArr[1] = fVar.field_packageName;
                                objArr[2] = fVar.field_signature;
                                objArr[3] = fVar.fQM;
                                objArr[4] = Boolean.valueOf(fVar.fQL != null);
                                x.d(str2, str3, objArr);
                                linkedList2.add(fVar.field_appId);
                            }
                            a.bis().Z(linkedList2);
                            List<f> eh = g.eh(ac.getContext());
                            if (eh.size() > 0) {
                                i biq = a.bis().biq();
                                for (f fVar2 : eh) {
                                    if (fVar2.field_appId != null) {
                                        Object obj;
                                        Iterator it2 = linkedList.iterator();
                                        while (it2.hasNext()) {
                                            fVar = (f) it2.next();
                                            if (fVar.field_appId != null && fVar2.field_appId.equals(fVar.field_appId)) {
                                                obj = 1;
                                                if (obj != null) {
                                                    if (g.a(ac.getContext(), fVar2)) {
                                                        fVar2.field_status = 4;
                                                    } else {
                                                        fVar2.field_status = 1;
                                                    }
                                                    biq.a(fVar2, new String[0]);
                                                }
                                            }
                                        }
                                        obj = null;
                                        if (obj != null) {
                                            if (g.a(ac.getContext(), fVar2)) {
                                                fVar2.field_status = 4;
                                            } else {
                                                fVar2.field_status = 1;
                                            }
                                            biq.a(fVar2, new String[0]);
                                        }
                                    }
                                }
                            }
                            g.Dk();
                            g.Dj().CU().setLong(352275, System.currentTimeMillis());
                            this.vfy = System.currentTimeMillis();
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    public final void ej(Context context) {
        if (!g.Dh().Cy() || context == null) {
            return;
        }
        if (this.vfw) {
            x.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
            return;
        }
        this.vfw = true;
        if (this.lang == null) {
            this.lang = w.d(context.getSharedPreferences(ac.cfs(), 0));
        }
        x.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
        cS(this.lang, this.vfA);
    }

    public static void cS(String str, int i) {
        x.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[]{Integer.valueOf(i), str});
        k afVar = new af(i, str);
        g.Dk();
        g.Di().gPJ.a(afVar, 0);
    }

    public final void reset() {
        x.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
        g.Dk();
        g.Dj().CU().setLong(352276, 0);
        this.vfB = 0;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (g.Dh().Cy()) {
            this.vfw = false;
            if (kVar == null) {
                x.e("MicroMsg.SuggestionAppListLogic", "scene == null");
                this.vfA = 0;
                this.vfx.clear();
                return;
            } else if (i == 0 && i2 == 0) {
                x.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                af afVar = (af) kVar;
                api com_tencent_mm_protocal_c_api = (afVar.gJQ == null || afVar.gJQ.hmh.hmo == null) ? null : (api) afVar.gJQ.hmh.hmo;
                if (com_tencent_mm_protocal_c_api == null) {
                    x.e("MicroMsg.SuggestionAppListLogic", "resp == null");
                    this.vfA = 0;
                    this.vfx.clear();
                    return;
                } else if (com_tencent_mm_protocal_c_api.wvY == null || com_tencent_mm_protocal_c_api.wvY.size() <= 0) {
                    x.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
                    a(a.bis().biq(), this.vfx);
                    this.vfA = 0;
                    this.vfx.clear();
                    g.Dk();
                    g.Dj().CU().setLong(352276, System.currentTimeMillis());
                    this.vfB = System.currentTimeMillis();
                    return;
                } else {
                    x.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[]{Integer.valueOf(this.vfA), Integer.valueOf(com_tencent_mm_protocal_c_api.wvY.size())});
                    i biq = a.bis().biq();
                    List linkedList = new LinkedList();
                    Iterator it = com_tencent_mm_protocal_c_api.wvY.iterator();
                    while (it.hasNext()) {
                        apj com_tencent_mm_protocal_c_apj = (apj) it.next();
                        x.v("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[]{com_tencent_mm_protocal_c_apj.vUF, Integer.valueOf(com_tencent_mm_protocal_c_apj.wwd), Integer.valueOf(com_tencent_mm_protocal_c_apj.wwh), Integer.valueOf(com_tencent_mm_protocal_c_apj.wwg), Integer.valueOf(com_tencent_mm_protocal_c_apj.wwe), com_tencent_mm_protocal_c_apj.fFm});
                        if (!bh.ov(com_tencent_mm_protocal_c_apj.fFm)) {
                            if (f.vei.equals(com_tencent_mm_protocal_c_apj.fFm)) {
                                com_tencent_mm_protocal_c_apj.wwe = (com_tencent_mm_protocal_c_apj.wwe ^ 253) ^ -1;
                                x.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_apj.wwe)});
                            }
                            this.vfx.add(com_tencent_mm_protocal_c_apj.fFm);
                            f aZ = g.aZ(com_tencent_mm_protocal_c_apj.fFm, true);
                            if (aZ != null) {
                                Object obj = aZ.field_serviceAppInfoFlag != com_tencent_mm_protocal_c_apj.wwe ? 1 : aZ.field_serviceAppType != com_tencent_mm_protocal_c_apj.wwd ? 1 : aZ.fQZ != com_tencent_mm_protocal_c_apj.wwg ? 1 : aZ.field_serviceShowFlag != com_tencent_mm_protocal_c_apj.wwh ? 1 : !bh.ou(aZ.field_appName).equals(bh.ou(com_tencent_mm_protocal_c_apj.vUF)) ? 1 : !bh.ou(aZ.field_appName_en).equals(bh.ou(com_tencent_mm_protocal_c_apj.wvZ)) ? 1 : !bh.ou(aZ.field_appName_tw).equals(bh.ou(com_tencent_mm_protocal_c_apj.wwa)) ? 1 : !bh.ou(aZ.field_appName_hk).equals(bh.ou(com_tencent_mm_protocal_c_apj.wwl)) ? 1 : !bh.ou(aZ.fQX).equals(bh.ou(com_tencent_mm_protocal_c_apj.wwc)) ? 1 : !bh.ou(aZ.fQW).equals(bh.ou(com_tencent_mm_protocal_c_apj.wwb)) ? 1 : !bh.ou(aZ.fQY).equals(bh.ou(com_tencent_mm_protocal_c_apj.wwf)) ? 1 : null;
                                if (obj != null) {
                                    String str2 = aZ.fQX;
                                    String str3 = aZ.fQW;
                                    a(aZ, com_tencent_mm_protocal_c_apj);
                                    boolean a = biq.a(aZ, new String[0]);
                                    if (!bh.ou(str2).equals(bh.ou(com_tencent_mm_protocal_c_apj.wwc))) {
                                        x.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bh.ou(com_tencent_mm_protocal_c_apj.wwc));
                                        com.tencent.mm.plugin.y.a.bil().cP(aZ.field_appId, 5);
                                    }
                                    if (!bh.ou(str3).equals(bh.ou(com_tencent_mm_protocal_c_apj.wwb))) {
                                        x.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bh.ou(com_tencent_mm_protocal_c_apj.wwb));
                                        com.tencent.mm.plugin.y.a.bil().cP(aZ.field_appId, 4);
                                    }
                                    x.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[]{com_tencent_mm_protocal_c_apj.fFm, Boolean.valueOf(a)});
                                }
                            } else {
                                aZ = new f();
                                aZ.field_appId = com_tencent_mm_protocal_c_apj.fFm;
                                a(aZ, com_tencent_mm_protocal_c_apj);
                                boolean l = biq.l(aZ);
                                x.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[]{com_tencent_mm_protocal_c_apj.fFm, Boolean.valueOf(l)});
                            }
                            if (bh.ov(aZ.field_openId)) {
                                linkedList.add(com_tencent_mm_protocal_c_apj.fFm);
                            }
                        }
                    }
                    if (linkedList.size() > 0) {
                        x.d("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[]{Integer.valueOf(linkedList.size())});
                        com.tencent.mm.plugin.y.a.bip().cv(linkedList);
                    }
                    if (com_tencent_mm_protocal_c_api.wvY.size() == 20) {
                        this.vfA += 20;
                        cS(this.lang, this.vfA);
                    } else {
                        a(biq, this.vfx);
                        this.vfA = 0;
                        this.vfx.clear();
                    }
                    g.Dk();
                    g.Dj().CU().setLong(352276, System.currentTimeMillis());
                    this.vfB = System.currentTimeMillis();
                    return;
                }
            } else {
                x.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                this.vfA = 0;
                this.vfx.clear();
                return;
            }
        }
        x.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
        this.vfA = 0;
        this.vfx.clear();
    }

    private static void a(i iVar, List<String> list) {
        if (iVar != null && list != null && list.size() > 0) {
            x.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
            List<f> arrayList = new ArrayList();
            if (a.bis() == null) {
                x.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
            } else {
                Cursor bir = a.bis().bir();
                if (bir != null) {
                    while (bir.moveToNext()) {
                        f fVar = new f();
                        fVar.b(bir);
                        if (!bh.ov(fVar.field_openId)) {
                            arrayList.add(fVar);
                        }
                    }
                    bir.close();
                }
            }
            x.d("MicroMsg.SuggestionAppListLogic", "oldList %d", new Object[]{Integer.valueOf(arrayList.size())});
            if (arrayList.size() > 0) {
                for (f fVar2 : arrayList) {
                    if (fVar2.field_appId != null) {
                        int i;
                        for (String equals : list) {
                            if (fVar2.field_appId.equals(equals)) {
                                i = 1;
                                break;
                            }
                        }
                        i = 0;
                        if (i == 0) {
                            boolean b = iVar.b(fVar2, new String[0]);
                            x.d("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", new Object[]{fVar2.field_appId, Boolean.valueOf(b)});
                        }
                    }
                }
            }
        }
    }

    private static void a(f fVar, apj com_tencent_mm_protocal_c_apj) {
        fVar.field_appName = com_tencent_mm_protocal_c_apj.vUF;
        fVar.field_appName_en = com_tencent_mm_protocal_c_apj.wvZ;
        fVar.field_appName_tw = com_tencent_mm_protocal_c_apj.wwa;
        fVar.field_appName_hk = com_tencent_mm_protocal_c_apj.wwl;
        fVar.fQW = com_tencent_mm_protocal_c_apj.wwb;
        fVar.fPZ = true;
        fVar.fQX = com_tencent_mm_protocal_c_apj.wwc;
        fVar.fPZ = true;
        fVar.fQY = com_tencent_mm_protocal_c_apj.wwf;
        fVar.fPZ = true;
        fVar.field_serviceAppInfoFlag = com_tencent_mm_protocal_c_apj.wwe;
        fVar.field_serviceAppType = com_tencent_mm_protocal_c_apj.wwd;
        fVar.fQZ = com_tencent_mm_protocal_c_apj.wwg;
        fVar.fPZ = true;
        fVar.field_serviceShowFlag = com_tencent_mm_protocal_c_apj.wwh;
    }
}
