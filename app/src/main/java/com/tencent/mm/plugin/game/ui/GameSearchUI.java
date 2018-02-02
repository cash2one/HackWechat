package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.au;
import com.tencent.mm.plugin.game.model.av;
import com.tencent.mm.plugin.game.ui.t.c;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.protocal.c.wp;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.protocal.c.wt;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.wv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class GameSearchUI extends MMActivity implements e, b {
    private static final Pattern nvy = Pattern.compile("\\s+");
    private int fromScene;
    private View kgd;
    private ProgressBar lAk;
    private p lcZ;
    private TextView nvA;
    private ListView nvB;
    private ListView nvC;
    private t nvD;
    private u nvE;
    private String nvF;
    private String nvG;
    private LinkedList<String> nvH;
    private String nvI;
    private LinkedList<k> nvJ = new LinkedList();
    private boolean nvK = false;
    private OnItemClickListener nvL = new OnItemClickListener(this) {
        final /* synthetic */ GameSearchUI nvN;

        {
            this.nvN = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            t b = this.nvN.nvD;
            c cVar = (i < 0 || i >= b.getCount()) ? null : ((t$b) b.getItem(i)).nvo;
            if (cVar != null) {
                int a;
                Map hashMap;
                if (cVar.actionType == 1 && !bh.ov(cVar.appId)) {
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", cVar.appId);
                    bundle.putInt("game_report_from_scene", cVar.fFj);
                    a = com.tencent.mm.plugin.game.d.c.a(this.nvN, cVar.appId, null, bundle);
                    hashMap = new HashMap();
                    hashMap.put("function_type", "search");
                    hashMap.put("funtion_value", cVar.nvq);
                    hashMap.put("keyword", this.nvN.nvF);
                    ap.a(this.nvN, 14, cVar.fFj, cVar.position, a, cVar.appId, this.nvN.fromScene, ap.A(hashMap));
                } else if (cVar.actionType == 2 && !bh.ov(cVar.nvp)) {
                    a = com.tencent.mm.plugin.game.d.c.p(this.nvN, cVar.nvp, "game_center_detail");
                    hashMap = new HashMap();
                    hashMap.put("function_type", "search");
                    hashMap.put("funtion_value", cVar.nvq);
                    hashMap.put("keyword", this.nvN.nvF);
                    ap.a(this.nvN, 14, cVar.fFj, cVar.position, a, 0, cVar.appId, this.nvN.fromScene, cVar.nvk, String.valueOf(cVar.nvl), null, ap.A(hashMap));
                }
            }
        }
    };
    private OnItemClickListener nvM = new 6(this);
    private ViewGroup nvz;

    public final void Xt() {
    }

    public final void Xu() {
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        if (ar.Hj()) {
            ar.CG().a(1328, this);
            ar.CG().a(1329, this);
            this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
            initView();
            ap.a(this, 14, 1401, 0, 2, this.fromScene, null);
            x.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        x.e("MicroMsg.GameSearchUI", "account not ready");
        finish();
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameSearchUI nvN;

            {
                this.nvN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nvN.onBackPressed();
                return true;
            }
        });
        this.lcZ = new p();
        this.lcZ.nu(true);
        this.lcZ.zms = this;
        this.nvz = (ViewGroup) findViewById(R.h.cXh);
        this.lAk = (ProgressBar) findViewById(R.h.cJU);
        this.nvA = (TextView) findViewById(R.h.cAw);
        this.nvB = (ListView) findViewById(R.h.cJX);
        this.nvD = new t(this);
        this.nvB.setAdapter(this.nvD);
        this.nvB.setOnItemClickListener(this.nvL);
        this.nvB.setOnTouchListener(new 2(this));
        this.nvB.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ GameSearchUI nvN;

            {
                this.nvN = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.nvN.nvD.nuS) {
                    if (this.nvN.kgd != null) {
                        this.nvN.kgd.setVisibility(0);
                    }
                    this.nvN.a(this.nvN.nvH, 0, false);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.kgd = getLayoutInflater().inflate(R.i.dkI, this.nvB, false);
        this.kgd.setVisibility(8);
        this.nvB.addFooterView(this.kgd);
        this.nvC = (ListView) findViewById(R.h.cJV);
        this.nvE = new u(this);
        this.nvC.setAdapter(this.nvE);
        this.nvC.setOnItemClickListener(this.nvM);
        this.nvC.setOnTouchListener(new 4(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.lcZ.a(this, menu);
        this.lcZ.setHint(SubCoreGameCenter.aRb());
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.lcZ.a(this, menu);
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dlh;
    }

    private void mK(int i) {
        switch (i) {
            case 0:
                this.nvz.setVisibility(8);
                this.nvA.setVisibility(8);
                this.nvB.setVisibility(8);
                this.nvC.setVisibility(8);
                this.lAk.setVisibility(8);
                return;
            case 1:
                aWs();
                this.nvB.smoothScrollToPosition(0);
                this.lcZ.clearFocus();
                this.nvz.setVisibility(8);
                this.nvA.setVisibility(8);
                this.nvB.setVisibility(8);
                this.nvC.setVisibility(8);
                this.lAk.setVisibility(0);
                return;
            case 2:
                this.nvz.setVisibility(8);
                if (this.nvD.getCount() > 0) {
                    this.nvA.setVisibility(8);
                    this.nvB.setVisibility(0);
                } else {
                    this.nvA.setVisibility(0);
                    this.nvB.setVisibility(8);
                }
                this.nvC.setVisibility(8);
                this.lAk.setVisibility(8);
                return;
            case 3:
                this.nvz.setVisibility(0);
                this.nvA.setVisibility(8);
                this.nvB.setVisibility(8);
                this.nvC.setVisibility(8);
                this.lAk.setVisibility(8);
                return;
            case 4:
                this.nvz.setVisibility(8);
                this.nvA.setVisibility(0);
                this.nvB.setVisibility(8);
                this.nvC.setVisibility(8);
                this.lAk.setVisibility(8);
                return;
            case 5:
                this.nvz.setVisibility(8);
                this.nvA.setVisibility(8);
                this.nvB.setVisibility(8);
                this.nvC.setVisibility(0);
                this.lAk.setVisibility(8);
                return;
            case 6:
                this.nvB.smoothScrollToPosition(0);
                this.nvz.setVisibility(8);
                this.nvA.setVisibility(8);
                this.nvB.setVisibility(8);
                this.nvC.setVisibility(8);
                this.lAk.setVisibility(0);
                return;
            default:
                return;
        }
    }

    private void d(LinkedList<String> linkedList, int i) {
        a(linkedList, 0, true);
    }

    private void a(LinkedList<String> linkedList, int i, boolean z) {
        while (!this.nvJ.isEmpty()) {
            g.Dk();
            g.Di().gPJ.c((k) this.nvJ.pop());
        }
        if (z) {
            t tVar = this.nvD;
            tVar.nds = 0;
            tVar.nuS = false;
        }
        this.nvH = linkedList;
        k auVar = new au(w.cfi(), linkedList, com.tencent.mm.plugin.game.model.g.aPX(), this.nvD.nds);
        ar.CG().a(auVar, 0);
        this.nvJ.add(auVar);
        Iterator it = linkedList.iterator();
        this.nvF = "";
        while (it.hasNext()) {
            this.nvF += " " + ((String) it.next());
        }
        this.nvF = this.nvF.trim();
        if (i == 1 || i == 2) {
            this.nvK = true;
            this.lcZ.ZR(this.nvF);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!kVar.aBT) {
            if (this.nvJ.contains(kVar)) {
                this.nvJ.remove(kVar);
            }
            this.kgd.setVisibility(8);
            switch (kVar.getType()) {
                case 1328:
                    wr wrVar = (wr) ((au) kVar).lMW.hmg.hmo;
                    x.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[]{wrVar.wha, Integer.valueOf(wrVar.whb)});
                    if (i == 0 && i2 == 0) {
                        ws wsVar = (ws) ((au) kVar).lMW.hmh.hmo;
                        LinkedList linkedList = wsVar != null ? wsVar.whc : null;
                        if (!bh.cA(linkedList)) {
                            this.nvG = this.nvF;
                            wt wtVar;
                            if (this.nvD.nds != 0) {
                                t tVar = this.nvD;
                                String str2 = this.nvG;
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    wtVar = (wt) it.next();
                                    if (wtVar.type != 3 || bh.cA(wtVar.whe)) {
                                        tVar.nuS = false;
                                    } else {
                                        tVar.nds = wtVar.whi;
                                        tVar.nuS = wtVar.whj;
                                        Iterator it2 = wtVar.whe.iterator();
                                        while (it2.hasNext()) {
                                            t$b a = t$b.a((wv) it2.next());
                                            a.fod = str2;
                                            a.nvo.appId = a.appId;
                                            a.nvo.nvk = a.nvk;
                                            a.nvo.nvl = a.nvl;
                                            a.nvo.nvq = "2";
                                            c cVar = a.nvo;
                                            int i3 = tVar.nuP;
                                            tVar.nuP = i3 + 1;
                                            cVar.position = i3 + 301;
                                            a.nvo.fFj = tVar.foh ? 1403 : 1405;
                                            tVar.lfg.add(a);
                                        }
                                    }
                                }
                            } else {
                                t tVar2 = this.nvD;
                                String str3 = this.nvG;
                                if (tVar2.lfg == null) {
                                    tVar2.lfg = new ArrayList();
                                }
                                tVar2.nrV = 0;
                                tVar2.nuN = 0;
                                tVar2.nuO = 0;
                                tVar2.nuP = 0;
                                tVar2.nuQ = 0;
                                tVar2.foh = false;
                                tVar2.nuM = false;
                                tVar2.nuS = false;
                                tVar2.nds = 0;
                                tVar2.lfg.clear();
                                tVar2.nuT = false;
                                Iterator it3 = linkedList.iterator();
                                while (it3.hasNext()) {
                                    wtVar = (wt) it3.next();
                                    Object obj = (wtVar.whd == null || wtVar.whd.size() == 0) ? 1 : null;
                                    Object obj2 = (wtVar.whe == null || wtVar.whe.size() == 0) ? 1 : null;
                                    Object obj3 = (wtVar.whh == null || wtVar.whh.size() == 0) ? 1 : null;
                                    obj2 = (obj == null || obj2 == null || obj3 == null) ? null : 1;
                                    if (obj2 == null) {
                                        Iterator it4;
                                        t$b com_tencent_mm_plugin_game_ui_t_b;
                                        c cVar2;
                                        int i4;
                                        tVar2.lfg.add(t$b.an(0, wtVar.fon));
                                        if (!tVar2.nuT) {
                                            ((t$b) tVar2.lfg.get(tVar2.lfg.size() - 1)).nvm = true;
                                            tVar2.nuT = true;
                                        }
                                        if (wtVar.type == 4 && wtVar.whh != null) {
                                            it4 = wtVar.whh.iterator();
                                            while (it4.hasNext()) {
                                                wu wuVar = (wu) it4.next();
                                                com_tencent_mm_plugin_game_ui_t_b = new t$b();
                                                com_tencent_mm_plugin_game_ui_t_b.type = 3;
                                                com_tencent_mm_plugin_game_ui_t_b.appId = wuVar.whk.ngo;
                                                com_tencent_mm_plugin_game_ui_t_b.name = wuVar.whk.nfp;
                                                com_tencent_mm_plugin_game_ui_t_b.iIj = wuVar.whk.vXO;
                                                com_tencent_mm_plugin_game_ui_t_b.iconUrl = wuVar.whk.nfT;
                                                com_tencent_mm_plugin_game_ui_t_b.nvg = wuVar.whk.nfq;
                                                com_tencent_mm_plugin_game_ui_t_b.nvh = wuVar.whk.wgP;
                                                com_tencent_mm_plugin_game_ui_t_b.actionType = wuVar.whk.wgQ;
                                                com_tencent_mm_plugin_game_ui_t_b.nvi = wuVar.whk.wgR;
                                                com_tencent_mm_plugin_game_ui_t_b.nvj = wuVar.whl;
                                                com_tencent_mm_plugin_game_ui_t_b.nvo = new c(wuVar.whk.wgQ, 4, wuVar.whk.ngo, wuVar.whk.wgR);
                                                com_tencent_mm_plugin_game_ui_t_b.fod = str3;
                                                com_tencent_mm_plugin_game_ui_t_b.nvo.nvq = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                                                cVar2 = com_tencent_mm_plugin_game_ui_t_b.nvo;
                                                i4 = tVar2.nuO;
                                                tVar2.nuO = i4 + 1;
                                                cVar2.position = i4 + 601;
                                                tVar2.lfg.add(com_tencent_mm_plugin_game_ui_t_b);
                                            }
                                        }
                                        if ((wtVar.type == 1 || wtVar.type == 2) && wtVar.whd != null) {
                                            it4 = wtVar.whd.iterator();
                                            while (it4.hasNext()) {
                                                wn wnVar = (wn) it4.next();
                                                com_tencent_mm_plugin_game_ui_t_b = new t$b();
                                                com_tencent_mm_plugin_game_ui_t_b.type = 1;
                                                com_tencent_mm_plugin_game_ui_t_b.appId = wnVar.ngo;
                                                com_tencent_mm_plugin_game_ui_t_b.name = wnVar.nfp;
                                                com_tencent_mm_plugin_game_ui_t_b.iIj = wnVar.vXO;
                                                com_tencent_mm_plugin_game_ui_t_b.iconUrl = wnVar.nfT;
                                                com_tencent_mm_plugin_game_ui_t_b.nvg = wnVar.nfq;
                                                com_tencent_mm_plugin_game_ui_t_b.nvh = wnVar.wgP;
                                                com_tencent_mm_plugin_game_ui_t_b.actionType = wnVar.wgQ;
                                                com_tencent_mm_plugin_game_ui_t_b.nvi = wnVar.wgR;
                                                com_tencent_mm_plugin_game_ui_t_b.nvo = new c(wnVar.wgQ, 1, wnVar.ngo, wnVar.wgR);
                                                com_tencent_mm_plugin_game_ui_t_b.fod = str3;
                                                if (wtVar.type == 1) {
                                                    tVar2.foh = true;
                                                    cVar2 = com_tencent_mm_plugin_game_ui_t_b.nvo;
                                                    i4 = tVar2.nrV;
                                                    tVar2.nrV = i4 + 1;
                                                    cVar2.position = i4 + 1;
                                                } else if (wtVar.type == 2) {
                                                    tVar2.nuM = true;
                                                    cVar2 = com_tencent_mm_plugin_game_ui_t_b.nvo;
                                                    i4 = tVar2.nuN;
                                                    tVar2.nuN = i4 + 1;
                                                    cVar2.position = i4 + 1;
                                                }
                                                com_tencent_mm_plugin_game_ui_t_b.nvo.nvq = "1";
                                                tVar2.lfg.add(com_tencent_mm_plugin_game_ui_t_b);
                                            }
                                        } else if (wtVar.type == 3 && wtVar.whe != null) {
                                            tVar2.nds = wtVar.whi;
                                            tVar2.nuS = wtVar.whj;
                                            it4 = wtVar.whe.iterator();
                                            while (it4.hasNext()) {
                                                t$b a2 = t$b.a((wv) it4.next());
                                                a2.fod = str3;
                                                a2.nvo.appId = a2.appId;
                                                a2.nvo.nvk = a2.nvk;
                                                a2.nvo.nvl = a2.nvl;
                                                a2.nvo.nvq = "2";
                                                c cVar3 = a2.nvo;
                                                i4 = tVar2.nuP;
                                                tVar2.nuP = i4 + 1;
                                                cVar3.position = i4 + 301;
                                                tVar2.lfg.add(a2);
                                            }
                                        }
                                        if (!(bh.ov(wtVar.whf) || bh.ov(wtVar.whg) || wtVar.type != 1)) {
                                            String str4 = wtVar.whf;
                                            String str5 = wtVar.whg;
                                            t$b com_tencent_mm_plugin_game_ui_t_b2 = new t$b();
                                            com_tencent_mm_plugin_game_ui_t_b2.type = 5;
                                            com_tencent_mm_plugin_game_ui_t_b2.name = str4;
                                            com_tencent_mm_plugin_game_ui_t_b2.nvo = new c(str5);
                                            com_tencent_mm_plugin_game_ui_t_b2.nvo.appId = "wx62d9035fd4fd2059";
                                            com_tencent_mm_plugin_game_ui_t_b2.nvo.nvq = "1";
                                            com_tencent_mm_plugin_game_ui_t_b2.nvo.position = 300;
                                            tVar2.lfg.add(com_tencent_mm_plugin_game_ui_t_b2);
                                        }
                                    } else if (wtVar.type == 1) {
                                        tVar2.lfg.add(t$b.an(6, !bh.ov(str3) ? tVar2.context.getString(R.l.emY, new Object[]{str3}) : tVar2.context.getString(R.l.emX)));
                                        tVar2.nuT = true;
                                    }
                                }
                                Iterator it5 = tVar2.lfg.iterator();
                                while (it5.hasNext()) {
                                    t$b com_tencent_mm_plugin_game_ui_t_b3 = (t$b) it5.next();
                                    if (tVar2.foh) {
                                        com_tencent_mm_plugin_game_ui_t_b3.nvo.fFj = 1403;
                                    } else if (tVar2.nuM) {
                                        com_tencent_mm_plugin_game_ui_t_b3.nvo.fFj = 1404;
                                    } else {
                                        com_tencent_mm_plugin_game_ui_t_b3.nvo.fFj = 1405;
                                    }
                                }
                                tVar2.notifyDataSetChanged();
                            }
                        }
                    }
                    mK(2);
                    return;
                case 1329:
                    if (i == 0 && i2 == 0) {
                        this.nvE.a(((av) kVar).fod, ((wp) ((av) kVar).lMW.hmh.hmo).fon, ((wp) ((av) kVar).lMW.hmh.hmo).wgY);
                        mK(5);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void onDestroy() {
        x.i("MicroMsg.GameSearchUI", "onDestroy");
        super.onDestroy();
        ar.CG().b(1328, this);
        ar.CG().b(1329, this);
    }

    public final void Xs() {
    }

    public final void Xr() {
        aWs();
        onBackPressed();
    }

    public final void oL(String str) {
        if (this.nvK) {
            this.nvK = false;
        } else if (this.nvI == null || !this.nvI.equals(bh.ou(str))) {
            this.nvI = str;
            if (bh.ov(str)) {
                while (!this.nvJ.isEmpty()) {
                    g.Dk();
                    g.Di().gPJ.c((k) this.nvJ.pop());
                }
                k avVar = new av(w.cfi(), str, com.tencent.mm.plugin.game.model.g.aPX());
                ar.CG().a(avVar, 0);
                this.nvJ.add(avVar);
                return;
            }
            LinkedList linkedList = new LinkedList();
            String[] split = nvy.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            d(linkedList, 0);
            mK(6);
        } else {
            x.d("MicroMsg.GameSearchUI", "repeat searchChange");
        }
    }

    public final boolean oK(String str) {
        if (!bh.ov(str)) {
            LinkedList linkedList = new LinkedList();
            String[] split = nvy.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            d(linkedList, 0);
            mK(1);
        }
        return true;
    }
}
