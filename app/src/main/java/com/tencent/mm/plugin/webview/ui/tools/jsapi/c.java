package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.l;
import com.tencent.mm.plugin.webview.model.m;
import com.tencent.mm.plugin.webview.model.n;
import com.tencent.mm.plugin.webview.model.o;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.protocal.c.als;
import com.tencent.mm.protocal.c.alt;
import com.tencent.mm.protocal.c.ama;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.amd;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.protocal.c.bsb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class c implements e {
    private Context context;
    private com.tencent.mm.plugin.webview.stub.e fBH;
    final HashMap<String, d> mZy = new HashMap();
    final HashMap<String, alr> tGx = new HashMap();
    final HashMap<String, String> tGy = new HashMap();
    final int tsc;

    public final String PB(String str) {
        if (str == null) {
            return null;
        }
        String str2 = (String) this.tGy.get(str);
        if (!bh.ov(str2)) {
            return str2;
        }
        String BQ = BQ(str);
        x.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[]{str2, str, BQ});
        if (bh.ov(BQ)) {
            return str2;
        }
        return (String) this.tGy.get(BQ);
    }

    public c(int i) {
        this.tsc = i;
    }

    final void a(Context context, com.tencent.mm.plugin.webview.stub.e eVar) {
        this.context = context;
        this.fBH = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(kVar instanceof b)) {
            x.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
        } else if (((b) kVar).bQE() != this.tsc) {
            x.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[]{Integer.valueOf(this.tsc), Integer.valueOf(((b) kVar).bQE())});
        } else {
            int type = kVar.getType();
            if (type == 1093) {
                ar.CG().b(1093, this);
                m mVar = (m) kVar;
                if (mVar == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "");
                } else if (mVar.tsa == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
                } else {
                    int i3 = 0;
                    if (!(mVar.bQF() == null || mVar.bQF().wsK == null)) {
                        i3 = mVar.bQF().wsK.fts;
                    }
                    if (i == 0 && i2 == 0) {
                        amb bQF = mVar.bQF();
                        ama com_tencent_mm_protocal_c_ama = mVar.gJQ == null ? null : (ama) mVar.gJQ.hmg.hmo;
                        if (bQF == null || bh.ov(mVar.jIW) || com_tencent_mm_protocal_c_ama == null || bh.ov(com_tencent_mm_protocal_c_ama.fFm)) {
                            String str2 = "MicroMsg.webview.JSVerifyHelper";
                            String str3 = "something null %b, %b, %b";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(bQF == null);
                            objArr[1] = Boolean.valueOf(bh.ov(mVar.jIW));
                            objArr[2] = Boolean.valueOf(com_tencent_mm_protocal_c_ama == null);
                            x.e(str2, str3, objArr);
                            mVar.tsa.a(a.tGD, null, null, i2, i3);
                        } else if (bQF.wsK == null) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
                            mVar.tsa.a(a.tGD, null, null, i2, i3);
                        } else if (bQF.wsK.fts != 0) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[]{Integer.valueOf(bQF.wsK.fts), bQF.wsK.ftt});
                            mVar.tsa.a(a.tGD, bQF.wsK.ftt, null, i2, i3);
                        } else {
                            this.tGy.put(BQ(com_tencent_mm_protocal_c_ama.url), com_tencent_mm_protocal_c_ama.fFm);
                            d dVar = new d();
                            dVar.appId = com_tencent_mm_protocal_c_ama.fFm;
                            dVar.tGI = bQF.wsY;
                            this.mZy.put(BQ(com_tencent_mm_protocal_c_ama.url), dVar);
                            mVar.tsa.a(a.tGC, null, bQF.wsX, i2, i3);
                        }
                    } else if (i == 4) {
                        mVar.tsa.a(a.tGD, i2 + "_" + str, null, i2, i3);
                    } else {
                        mVar.tsa.a(a.tGD, null, null, i2, i3);
                    }
                }
            } else if (type == 1095) {
                ar.CG().b(1095, this);
                a(i, i2, str, (l) kVar);
            } else if (type == 1094) {
                ar.CG().b(1094, this);
                n nVar = (n) kVar;
                if (nVar == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
                    return;
                }
                int i4;
                g.pQN.a(157, 24, 1, false);
                if (nVar.bQG() == null || nVar.bQG().wsK == null) {
                    i4 = 0;
                } else {
                    i4 = nVar.bQG().wsK.fts;
                }
                if (i == 0 && i2 == 0) {
                    amd bQG = nVar.bQG();
                    if (bQG == null || bQG.wsK == null) {
                        x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
                        nVar.tsa.a(a.tGD, null, null, i2, i4);
                        return;
                    } else if (bQG.wsK.fts != 0) {
                        x.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[]{Integer.valueOf(bQG.wsK.fts), bQG.wsK.ftt});
                        nVar.tsa.a(a.tGD, bQG.wsK.ftt, null, i2, i4);
                        return;
                    } else {
                        bsb com_tencent_mm_protocal_c_bsb = bQG.wsZ;
                        if (com_tencent_mm_protocal_c_bsb == null) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
                            nVar.tsa.a(a.tGD, "verifyFail", null, i2, i4);
                            return;
                        } else if (com_tencent_mm_protocal_c_bsb.wTv != 1) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bsb.wTv)});
                            nVar.tsa.a(a.tGD, "verifyFail", null, i2, i4);
                            return;
                        } else {
                            nVar.tsa.a(a.tGC, null, null, i2, i4);
                            return;
                        }
                    }
                }
                x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                g.pQN.a(157, 25, 1, false);
                if (i == 4) {
                    nVar.tsa.a(a.tGD, i2 + "_" + str, null, i2, i4);
                } else {
                    nVar.tsa.a(a.tGD, null, null, i2, i4);
                }
            } else if (type == 1096) {
                ar.CG().b(1096, this);
                o oVar = (o) kVar;
                ame com_tencent_mm_protocal_c_ame = oVar.gJQ == null ? null : (ame) oVar.gJQ.hmg.hmo;
                if (com_tencent_mm_protocal_c_ame == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
                } else if (i != 0 || i2 != 0) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), com_tencent_mm_protocal_c_ame.wsE});
                } else if (com.tencent.mm.protocal.c.Tm(bh.ou(com_tencent_mm_protocal_c_ame.wsE)) == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    alr com_tencent_mm_protocal_c_alr = ((o) kVar).tsd;
                    com_tencent_mm_protocal_c_alr.vJs = 1;
                    this.tGx.put(com_tencent_mm_protocal_c_ame.wsE + com_tencent_mm_protocal_c_ame.url, com_tencent_mm_protocal_c_alr);
                }
            }
        }
    }

    private void a(int i, int i2, String str, l lVar) {
        if (lVar == null) {
            x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
            return;
        }
        int i3 = 0;
        if (!(lVar.bQD() == null || lVar.bQD().wsK == null)) {
            i3 = lVar.bQD().wsK.fts;
        }
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i == 4) {
                lVar.tsa.a(a.tGD, str, null, i2, i3);
            } else {
                lVar.tsa.a(a.tGD, null, null, i2, i3);
            }
        } else if (bh.ov(lVar.tsb)) {
            x.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
            lVar.tsa.a(a.tGD, null, null, i2, i3);
        } else {
            alt bQD = lVar.bQD();
            if (bQD == null || bQD.wsK == null) {
                x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
                lVar.tsa.a(a.tGD, null, null, i2, i3);
            } else if (bQD.wsK.fts != 0) {
                x.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[]{Integer.valueOf(bQD.wsK.fts), bQD.wsK.ftt});
                lVar.tsa.a(a.tGD, bQD.wsK.ftt, null, i2, i3);
            } else {
                x.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[]{Integer.valueOf(lVar.bQC() == null ? 0 : lVar.bQC().wsJ)});
                if ((lVar.bQC() == null ? 0 : lVar.bQC().wsJ) == 1) {
                    if (bQD.wsN == null) {
                        x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
                        lVar.tsa.a(a.tGD, null, null, i2, i3);
                        return;
                    }
                    Iterator it = bQD.wsN.iterator();
                    while (it.hasNext()) {
                        ams com_tencent_mm_protocal_c_ams = (ams) it.next();
                        if (com_tencent_mm_protocal_c_ams.wto == null) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
                        } else {
                            Iterator it2 = com_tencent_mm_protocal_c_ams.wto.iterator();
                            while (it2.hasNext()) {
                                String str2 = (String) it2.next();
                                if (!bh.ov(str2)) {
                                    alr com_tencent_mm_protocal_c_alr = new alr();
                                    com_tencent_mm_protocal_c_alr.wsE = str2;
                                    com_tencent_mm_protocal_c_alr.vJs = com_tencent_mm_protocal_c_ams.wtn;
                                    com_tencent_mm_protocal_c_alr.wsF = com_tencent_mm_protocal_c_ams.qgh;
                                    this.tGx.put(com_tencent_mm_protocal_c_alr.wsE + lVar.url, com_tencent_mm_protocal_c_alr);
                                }
                            }
                        }
                    }
                } else if (bQD.wsL == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
                    lVar.tsa.a(a.tGD, "nullAuthInfo", null, i2, i3);
                    return;
                } else {
                    Iterator it3 = bQD.wsL.iterator();
                    while (it3.hasNext()) {
                        alr com_tencent_mm_protocal_c_alr2 = (alr) it3.next();
                        if (!bh.ov(com_tencent_mm_protocal_c_alr2.wsE)) {
                            this.tGx.put(com_tencent_mm_protocal_c_alr2.wsE + lVar.url, com_tencent_mm_protocal_c_alr2);
                        }
                    }
                }
                alr com_tencent_mm_protocal_c_alr3 = (alr) this.tGx.get(lVar.tsb + lVar.url);
                if (com_tencent_mm_protocal_c_alr3 == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[]{lVar.tsb, lVar.url});
                    lVar.tsa.a(a.tGD, null, null, i2, i3);
                } else if (com_tencent_mm_protocal_c_alr3.vJs == 1) {
                    lVar.tsa.a(a.tGC, null, null, i2, i3);
                } else if (this.context == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
                    a(lVar, i2, com_tencent_mm_protocal_c_alr3);
                } else {
                    WebViewStubTempUI.a(this.context, this.fBH, bh.ou(com_tencent_mm_protocal_c_alr3.wsF), "", this.context.getString(R.l.ess), this.context.getString(R.l.esr), new 1(this, lVar, i2, com_tencent_mm_protocal_c_alr3), new 2(this, lVar, i2));
                }
            }
        }
    }

    final void a(l lVar, int i, alr com_tencent_mm_protocal_c_alr) {
        als bQC = lVar.bQC();
        alt bQD = lVar.bQD();
        if (bQC == null) {
            x.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
            lVar.tsa.a(a.tGD, null, null, i, lVar.bQD().wsK.fts);
        } else if (bQD == null) {
            x.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
            lVar.tsa.a(a.tGD, null, null, i, lVar.bQD().wsK.fts);
        } else {
            ar.CG().a(1096, this);
            LinkedList linkedList = bQD.wsN;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ams com_tencent_mm_protocal_c_ams = (ams) it.next();
                    if (com_tencent_mm_protocal_c_ams != null) {
                        x.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[]{com_tencent_mm_protocal_c_ams.wto, com_tencent_mm_protocal_c_ams.scope, com_tencent_mm_protocal_c_ams.qgh, Integer.valueOf(com_tencent_mm_protocal_c_ams.wtn), bQC.wsE});
                        com_tencent_mm_protocal_c_ams.wtn = 1;
                    }
                }
                it = linkedList.iterator();
                while (it.hasNext()) {
                    if (((ams) it.next()) != null) {
                        x.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[]{((ams) it.next()).wto, ((ams) it.next()).scope, ((ams) it.next()).qgh, Integer.valueOf(((ams) it.next()).wtn), bQC.wsE});
                    }
                }
            }
            ar.CG().a(new o(com_tencent_mm_protocal_c_alr, bQC.url, bQC.nfn, bQC.wsE, bQC.fqD, bQC.wsG, bQC.signature, bQC.wsH, bQC.wsI, bQC.wsJ, linkedList, this.tsc), 0);
            lVar.tsa.a(a.tGC, null, null, i, lVar.bQD().wsK.fts);
        }
    }

    static String BQ(String str) {
        int indexOf = str.indexOf("#");
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }
}
