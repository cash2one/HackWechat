package com.tencent.mm.plugin.search.ui;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bc.i;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.a.to;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.search.ui.i.b;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e$h;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayout;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashMap;
import java.util.Map;

public class FTSMainUI extends FTSBaseVoiceSearchUI implements a {
    long jzh;
    private Dialog lNB;
    private int mOz;
    int qbP = -1;
    private FTSMainUIEducationLayout qcQ;
    private LinearLayout qcR;
    private LinearLayout qcS;
    private LinearLayout qcT;
    private View qcU;
    private View qcV;
    private h qcW;
    private TextView qcX;
    private TextView qcY;
    private View qcZ;
    private View qda;
    private TextView qdb;
    private String qdc;
    i qdd;
    private Map<String, Integer> qde = new HashMap();
    private i qdf;
    private b qdg = new 6(this);
    private e qdh = new 3(this);
    private OnClickListener qdi = new 4(this);
    private c<to> qdj = new 5(this);

    static /* synthetic */ void a(FTSMainUI fTSMainUI, Map map) {
        fTSMainUI.qdf.qcv = true;
        String str = fTSMainUI.fDj;
        if (str != null && !bh.ov(str.trim()) && System.currentTimeMillis() - fTSMainUI.jzh > 1000) {
            fTSMainUI.jzh = System.currentTimeMillis();
            if (g.zM(0)) {
                Intent QM = com.tencent.mm.bc.b.QM();
                QM.putExtra("ftsbizscene", 3);
                QM.putExtra("ftsQuery", fTSMainUI.fDj);
                Map b = com.tencent.mm.bc.b.b(3, true, 0);
                b.put("query", fTSMainUI.fDj);
                str = g.zH(bh.VI((String) b.get("scene")));
                b.put("sessionId", str);
                QM.putExtra("key_session_id", str);
                b.putAll(map);
                QM.putExtra("rawUrl", com.tencent.mm.bc.b.r(b));
                QM.putExtra("key_preload_biz", 3);
                com.tencent.mm.sdk.b.b kwVar = new kw();
                kwVar.fCe.scene = 0;
                com.tencent.mm.sdk.b.a.xef.m(kwVar);
                QM.putExtra("ftsInitToSearch", true);
                d.b(fTSMainUI.mController.xIM, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", QM);
                com.tencent.mm.bc.g.ip(3);
                fTSMainUI.qcU.setEnabled(false);
                return;
            }
            x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }

    static /* synthetic */ void b(FTSMainUI fTSMainUI, final String str) {
        b bVar = fTSMainUI.qdf;
        bVar.qcv = true;
        if (!bh.ov(bVar.fDj)) {
            com.tencent.mm.bc.g.d(bVar.fDj, bVar.qbL, 1, 3);
        }
        if (str != null && str.length() != 0 && str.trim().length() != 0) {
            fTSMainUI.qbP = Character.isDigit(str.charAt(0)) ? 15 : 3;
            e anonymousClass11 = new e(fTSMainUI) {
                final /* synthetic */ FTSMainUI qdk;

                public final void a(int i, int i2, String str, k kVar) {
                    ar.CG().b(106, this);
                    if (i == 4 && i2 == -4) {
                        ag.y(new Runnable(this.qdk) {
                            final /* synthetic */ FTSMainUI qdk;

                            {
                                this.qdk = r1;
                            }

                            public final void run() {
                                if (this.qdk.lNB != null) {
                                    this.qdk.lNB.dismiss();
                                    this.qdk.lNB = null;
                                }
                            }
                        });
                        h.a(this.qdk, R.l.dDd, 0, true, null);
                        return;
                    }
                    ag.y(/* anonymous class already generated */);
                    if (i == 0 && i2 == 0) {
                        bem So = ((ac) kVar).So();
                        Intent intent;
                        if (So.wkk > 0) {
                            if (So.wkl.isEmpty()) {
                                h.a(this.qdk, R.l.dDd, 0, true, null);
                                return;
                            }
                            intent = new Intent();
                            com.tencent.mm.pluginsdk.ui.tools.c.a(intent, (bek) So.wkl.getFirst(), this.qdk.qbP);
                            com.tencent.mm.plugin.search.a.ifs.d(intent, this.qdk);
                            return;
                        } else if (bh.ou(n.a(So.vYI)).length() > 0) {
                            if (2 == So.wJY) {
                                this.qdk.qbP = 15;
                            } else if (1 == So.wJY) {
                                this.qdk.qbP = 1;
                            }
                            intent = new Intent();
                            com.tencent.mm.pluginsdk.ui.tools.c.a(intent, So, this.qdk.qbP);
                            if (this.qdk.qbP == 15) {
                                intent.putExtra("Contact_Search_Mobile", str.trim());
                            }
                            intent.putExtra("add_more_friend_search_scene", 2);
                            com.tencent.mm.plugin.search.a.ifs.d(intent, this.qdk);
                            return;
                        } else {
                            return;
                        }
                    }
                    switch (i2) {
                        case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                            com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                            if (eA != null) {
                                h.a(this.qdk, eA.desc, eA.fon, true, null);
                                break;
                            }
                            break;
                        case -4:
                            Toast.makeText(this.qdk, this.qdk.getString(R.l.ejf), 0).show();
                            break;
                    }
                    x.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                }
            };
            ar.CG().a(106, anonymousClass11);
            k acVar = new ac(str, 3);
            ar.CG().a(acVar, 0);
            fTSMainUI.getString(R.l.dGO);
            fTSMainUI.lNB = h.a((Context) fTSMainUI, fTSMainUI.getString(R.l.dDg), true, new 12(fTSMainUI, acVar, anonymousClass11));
        }
    }

    static /* synthetic */ void c(FTSMainUI fTSMainUI) {
        fTSMainUI.qdf.qcv = true;
        String str = fTSMainUI.fDj;
        if (str != null && !bh.ov(str.trim()) && System.currentTimeMillis() - fTSMainUI.jzh > 1000) {
            fTSMainUI.jzh = System.currentTimeMillis();
            if (g.zM(0)) {
                Intent QM = com.tencent.mm.bc.b.QM();
                QM.putExtra("ftsbizscene", 3);
                QM.putExtra("ftsQuery", fTSMainUI.fDj);
                QM.putExtra("ftsInitToSearch", true);
                Map b = com.tencent.mm.bc.b.b(3, true, 0);
                try {
                    b.put("query", p.encode(fTSMainUI.fDj, "UTF-8"));
                } catch (Exception e) {
                    b.put("query", fTSMainUI.fDj);
                }
                b.put("sessionId", com.tencent.mm.bc.e.hKF);
                QM.putExtra("sessionId", com.tencent.mm.bc.e.hKF);
                QM.putExtra("rawUrl", com.tencent.mm.bc.b.r(b));
                QM.putExtra("key_preload_biz", 3);
                com.tencent.mm.sdk.b.b kwVar = new kw();
                kwVar.fCe.scene = 0;
                com.tencent.mm.sdk.b.a.xef.m(kwVar);
                QM.putExtra("key_load_js_without_delay", true);
                d.b(fTSMainUI.mController.xIM, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", QM);
                com.tencent.mm.bc.g.ip(3);
                if (!bh.ov(fTSMainUI.fDj)) {
                    com.tencent.mm.bc.g.d(fTSMainUI.fDj, 2, 2, 3);
                }
                fTSMainUI.qcU.setEnabled(false);
                return;
            }
            x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.bc.e.hKF = g.zH(3);
        com.tencent.mm.bc.e.in(this.mOz);
        this.qcQ = (FTSMainUIEducationLayout) findViewById(R.h.cJC);
        this.qcT = (LinearLayout) findViewById(R.h.cJM);
        this.qcQ.q(this.qdi);
        this.qcQ.zem = new 1(this);
        this.qcQ.cxe();
        com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
        com.tencent.mm.plugin.search.a.c.bpR();
        com.tencent.mm.modelgeo.c.OP().a((a) this, true);
        if (com.tencent.mm.plugin.search.a.c.bpQ() == null) {
            finish();
            return;
        }
        com.tencent.mm.plugin.search.a.c.bpQ().aNt();
        com.tencent.mm.plugin.aj.a.h.zW(3);
        com.tencent.mm.sdk.b.a.xef.a(this.qdj);
        ar.CG().a(1944, this.qdh);
    }

    protected final void bpY() {
        switch (getIntent().getIntExtra("from_tab_index", -1)) {
            case 0:
                this.mOz = 1;
                return;
            case 1:
                this.mOz = 2;
                return;
            case 2:
                this.mOz = 3;
                return;
            case 3:
                this.mOz = 4;
                return;
            default:
                this.mOz = 0;
                return;
        }
    }

    protected final boolean bqf() {
        return w.cff();
    }

    protected final b a(c cVar) {
        this.qdf = new i(cVar, this.mOz, this.qdg);
        return this.qdf;
    }

    protected final int getLayoutId() {
        return R.i.djb;
    }

    public final void a(com.tencent.mm.plugin.fts.d.a.b bVar) {
    }

    protected void onDestroy() {
        ag.y(new 7(this));
        com.tencent.mm.modelgeo.c.OP().c(this);
        if (com.tencent.mm.plugin.fts.d.h.aNx() != null) {
            com.tencent.mm.plugin.fts.d.h.aNx().aNu();
        }
        com.tencent.mm.sdk.b.a.xef.c(this.qdj);
        ar.CG().b(1944, this.qdh);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.sdk.b.b scVar = new sc();
        scVar.fJP.fpS = 0;
        com.tencent.mm.sdk.b.a.xef.m(scVar);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e$h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        if (this.qcU != null) {
            this.qcU.setEnabled(true);
        }
        if (!bh.ov(this.qdc)) {
            this.fDj = this.qdc;
            this.qdc = null;
        }
        com.tencent.mm.bc.b.QR();
    }

    public void finish() {
        aWs();
        super.finish();
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        x.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[]{Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)});
        com.tencent.mm.modelgeo.c.OP().c(this);
        return false;
    }

    private void bql() {
        this.qcQ.setVisibility(0);
        this.qcQ.au();
    }

    private void bqm() {
        this.qcQ.setVisibility(8);
    }

    protected final void bqg() {
        super.bqg();
        bqm();
        this.qcT.setVisibility(8);
    }

    protected final void bqh() {
        super.bqh();
        bql();
        this.qcT.setVisibility(8);
    }

    protected final void bqe() {
        super.bqe();
        bql();
        this.qcT.setVisibility(8);
    }

    protected final void bqd() {
        super.bqd();
        bqm();
        this.qcT.setVisibility(8);
    }

    protected final void bqc() {
        super.bqc();
        bqm();
        this.qcT.setVisibility(8);
        this.qbX.setVisibility(0);
        this.nvA.setVisibility(8);
    }

    protected final void bqb() {
        super.bqb();
        bqm();
        this.qcT.setVisibility(8);
    }

    public final View avu() {
        if (this.qcR == null) {
            this.qcR = (LinearLayout) getLayoutInflater().inflate(R.i.diY, null);
            this.qcX = (TextView) this.qcR.findViewById(R.h.cJP);
            this.qcY = (TextView) this.qcR.findViewById(R.h.ckj);
            try {
                x.i("MicroMsg.FTS.FTSMainUI", "set searchNetworkTips %s", new Object[]{com.tencent.mm.plugin.aj.a.h.NT("webSearchBar").optString("wording")});
                this.qcY.setText(r0);
            } catch (Exception e) {
            }
            this.qcV = this.qcR.findViewById(R.h.cJN);
            this.qcU = this.qcR.findViewById(R.h.cJO);
            this.qcU.setOnClickListener(new 8(this));
            this.qcW = new h(this);
            this.qcW.qcz = new 9(this);
            int indexOfChild = this.qcR.indexOfChild(this.qcU);
            if (indexOfChild >= 0 && indexOfChild < this.qcR.getChildCount()) {
                this.qcR.addView(this.qcW, indexOfChild + 1);
            }
            this.qdb = (TextView) this.qcR.findViewById(R.h.cJw);
            this.qda = this.qcR.findViewById(R.h.cJu);
            this.qcZ = this.qcR.findViewById(R.h.cJv);
            this.qcZ.setOnClickListener(new 10(this));
            this.qcS = (LinearLayout) this.qcR.findViewById(R.h.ciY);
        }
        return this.qcR;
    }

    public final boolean oK(String str) {
        return super.oK(str);
    }

    protected final void bqi() {
        if (this.qcS != null) {
            this.qcS.setVisibility(0);
        }
    }

    protected final void bqj() {
        if (this.qcS != null) {
            this.qcS.setVisibility(8);
        }
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
        super.a(z, strArr, j, i);
        if (z) {
            d.a(this, ".ui.voicesearch.VoiceSearchResultUI", new Intent().putExtra("VoiceSearchResultUI_Resultlist", strArr).putExtra("VoiceSearchResultUI_VoiceId", j).putExtra("VoiceSearchResultUI_ShowType", i));
            return;
        }
        d.a(this, ".ui.voicesearch.VoiceSearchResultUI", new Intent().putExtra("VoiceSearchResultUI_Resultlist", new String[0]).putExtra("VoiceSearchResultUI_Error", this.mController.xIM.getString(R.l.eiE)).putExtra("VoiceSearchResultUI_VoiceId", j).putExtra("VoiceSearchResultUI_ShowType", i));
    }

    public final void H(int i, boolean z) {
        super.H(i, z);
        this.qcW.setVisibility(8);
        if (this.qdd != null) {
            ar.CG().c(this.qdd);
            this.qdd = null;
        }
        if (!z && i == 0 && this.qdf.qcM) {
            this.qcT.setVisibility(0);
        } else {
            this.qcT.setVisibility(8);
        }
        if (z) {
            boolean IQ = com.tencent.mm.plugin.search.a.b.IQ(this.fDj);
            boolean IR = com.tencent.mm.plugin.search.a.b.IR(this.fDj);
            if (i > 0) {
                if (IQ || IR) {
                    this.qda.setVisibility(0);
                }
                this.qcV.setVisibility(0);
            } else {
                this.qda.setVisibility(8);
                if (IQ || IR) {
                    this.qcV.setVisibility(0);
                } else {
                    this.qcV.setVisibility(8);
                }
            }
            if (IQ || IR) {
                this.qcZ.setVisibility(0);
            }
            this.qcU.setVisibility(0);
            if (this.fDj != null && this.fDj.length() > 0) {
                this.qdd = new i(this.fDj);
                ar.CG().a(this.qdd, 0);
                return;
            }
            return;
        }
        this.qcU.setVisibility(8);
        this.qcZ.setVisibility(8);
    }

    protected final void bpV() {
        super.bpV();
        this.qcX.setText(com.tencent.mm.pluginsdk.ui.d.i.c(this, f.a(getString(R.l.ekH), "", com.tencent.mm.plugin.fts.d.b.a.d(this.fDj, this.fDj)).mQk, com.tencent.mm.bv.a.aa(this, R.f.bvK)));
        CharSequence charSequence = null;
        if (com.tencent.mm.plugin.search.a.b.IQ(this.fDj)) {
            charSequence = f.a(getString(R.l.ekr), "", com.tencent.mm.plugin.fts.d.b.a.d(this.fDj, this.fDj)).mQk;
        } else if (com.tencent.mm.plugin.search.a.b.IR(this.fDj)) {
            charSequence = f.a(getString(R.l.eks), "", com.tencent.mm.plugin.fts.d.b.a.d(this.fDj, this.fDj)).mQk;
        }
        this.qdb.setText(com.tencent.mm.pluginsdk.ui.d.i.c(this, charSequence, com.tencent.mm.bv.a.aa(this, R.f.bvK)));
    }

    public void onClickSnsHotArticle(String str) {
        if (System.currentTimeMillis() - this.jzh > 1000) {
            this.jzh = System.currentTimeMillis();
            if (g.zM(0)) {
                Intent QM = com.tencent.mm.bc.b.QM();
                QM.putExtra("ftsbizscene", 15);
                QM.putExtra("ftsQuery", str);
                QM.putExtra("title", str);
                QM.putExtra("isWebwx", str);
                QM.putExtra("ftscaneditable", false);
                Map b = com.tencent.mm.bc.b.b(15, false, 2);
                b.put("query", str);
                b.put("sceneActionType", "2");
                QM.putExtra("rawUrl", com.tencent.mm.bc.b.r(b));
                com.tencent.mm.sdk.b.b kwVar = new kw();
                kwVar.fCe.scene = 0;
                com.tencent.mm.sdk.b.a.xef.m(kwVar);
                QM.putExtra("ftsInitToSearch", true);
                d.b(this.mController.xIM, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", QM);
                com.tencent.mm.bc.g.u(15, str);
                return;
            }
            x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }
}
