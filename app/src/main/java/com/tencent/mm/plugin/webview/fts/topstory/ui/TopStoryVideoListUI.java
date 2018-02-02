package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.webview.fts.topstory.a.c;
import com.tencent.mm.plugin.webview.fts.topstory.a.e;
import com.tencent.mm.plugin.webview.fts.topstory.a.f;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TopStoryVideoListUI extends MMActivity implements b, b {
    private static final int toM = a.fromDPToPix(ac.getContext(), 10);
    private int fromScene;
    private af hae = new af(Looper.getMainLooper());
    private View nWi;
    private bzu qYw;
    private View qlf;
    private com.tencent.mm.plugin.topstory.a.a.a tnw = new com.tencent.mm.plugin.topstory.a.a.a();
    private ListView toA;
    private View toB;
    private e toC;
    private ViewGroup toD;
    private long toE = -1;
    private boolean toF = false;
    private GestureDetector toG;
    private long toH = -1;
    private c toI;
    private c toJ;
    private long toK = -1;
    private ProgressDialog toL;
    private OnScrollListener toN = new 1(this);
    private Runnable toO = new 2(this);
    private boolean toP = false;

    static /* synthetic */ void a(TopStoryVideoListUI topStoryVideoListUI, String str) {
        if (!an.isNetworkConnected(topStoryVideoListUI)) {
            Toast.makeText(topStoryVideoListUI, topStoryVideoListUI.getString(R.l.eCs), 1).show();
        } else if (bh.ov(str)) {
            Toast.makeText(topStoryVideoListUI, topStoryVideoListUI.getString(R.l.eCt), 1).show();
        } else {
            Toast.makeText(topStoryVideoListUI, str, 1).show();
        }
    }

    static /* synthetic */ List cn(List list) {
        Collection arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                arrayList.add(list.get(i));
            }
            if (com.tencent.mm.plugin.webview.fts.topstory.a.b.tnt.containsKey(((com.tencent.mm.plugin.topstory.a.a.c) list.get(i)).sey)) {
                arrayList.add(list.get(i));
            }
        }
        list.removeAll(arrayList);
        return list;
    }

    static /* synthetic */ void l(TopStoryVideoListUI topStoryVideoListUI) {
        if (topStoryVideoListUI.toB != null) {
            topStoryVideoListUI.toA.removeFooterView(topStoryVideoListUI.toB);
        }
    }

    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        overridePendingTransition(MMFragmentActivity.a.xKg, MMFragmentActivity.a.xKh);
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
            getSupportActionBar().hide();
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.e.bso));
        }
        this.toK = bh.Wq();
        ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFm();
        d bPB = d.bPB();
        bPB.tog = this;
        bPB.toj = null;
        bPB.toi = null;
        bPB.toh = false;
        bPB.nbV = false;
        e bPt = e.bPt();
        Object obj = g.Dj().CU().get(w.a.xxE, Long.valueOf(0));
        long longValue = (obj == null || !(obj instanceof Long)) ? 0 : ((Long) obj).longValue();
        e.tnR.set(longValue);
        x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "Get FileIndexInteger ConfigIndex %d", new Object[]{Long.valueOf(longValue)});
        if (!e.tnU.get()) {
            com.tencent.mm.sdk.f.e.post(new e.a(bPt, e.tnR.get()), "FtsRecommendVideoPreloadMgr.DeleteUnusedTask");
        }
        com.tencent.mm.plugin.webview.fts.topstory.a.b.init(this);
        this.fromScene = getIntent().getIntExtra("key_scene", 1);
        f.tob.fromScene = this.fromScene;
        x.i("MicroMsg.WebSearch.TopStoryVideoListUI", "onCreate, fromScene: %s", new Object[]{Integer.valueOf(this.fromScene)});
        this.qlf = findViewById(R.h.cSm);
        this.toA = (ListView) findViewById(R.h.cVa);
        this.toD = (ViewGroup) findViewById(R.h.ckr);
        d.bPB().toj = this.toD;
        this.nWi = findViewById(R.h.bLT);
        this.nWi.setOnClickListener(new 3(this));
        this.toI = new c();
        ar.CG().a(1943, this.toI);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_search_web_data");
        ar.a(new n(this) {
            final /* synthetic */ TopStoryVideoListUI toU;

            {
                this.toU = r1;
            }

            public final void eq(int i) {
                if (i == 4 && this.toU.toP) {
                    this.toU.G(true, true);
                }
            }

            public final IBinder asBinder() {
                return null;
            }
        });
        com.tencent.mm.plugin.topstory.a.a.c cVar;
        if (com.tencent.mm.plugin.webview.fts.topstory.a.b.tnx != null && com.tencent.mm.plugin.webview.fts.topstory.a.b.tnv != null) {
            cVar = com.tencent.mm.plugin.webview.fts.topstory.a.b.tnx;
            List arrayList = new ArrayList();
            arrayList.add(com.tencent.mm.plugin.webview.fts.topstory.a.b.tnx);
            U(arrayList);
            com.tencent.mm.plugin.webview.fts.topstory.a.b.h(arrayList, true);
            this.tnw = new com.tencent.mm.plugin.topstory.a.a.a();
            this.tnw.sek = cVar.sey;
            this.tnw.sel = com.tencent.mm.plugin.webview.fts.topstory.a.b.tny;
            this.tnw.sem = com.tencent.mm.plugin.webview.fts.topstory.a.b.tnz;
            this.tnw.seo = cVar.seC;
            x.i("MicroMsg.WebSearch.TopStoryVideoListUI", "first fetch from init video, videoId: %s, expand: %s, searchId: %s, category: %s", new Object[]{this.tnw.sek, this.tnw.sel, this.tnw.sem, Long.valueOf(this.tnw.seo)});
            com.tencent.mm.plugin.webview.fts.topstory.a.b.tnw = this.tnw;
            com.tencent.mm.plugin.webview.fts.topstory.a.b.tnD = true;
            if (an.isNetworkConnected(ac.getContext())) {
                G(bh.ov(cVar.videoUrl), true);
                this.toP = false;
            } else {
                Toast.makeText(this, R.l.eCu, 1).show();
                this.toP = true;
            }
        } else if (byteArrayExtra != null) {
            this.qYw = new bzu();
            try {
                this.qYw.aF(byteArrayExtra);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListUI", e, "parse webSearchData failed!", new Object[0]);
                this.qYw = null;
            }
            if (this.qYw != null) {
                cVar = new com.tencent.mm.plugin.topstory.a.a.c();
                cVar.title = this.qYw.lOY;
                cVar.sey = this.qYw.tnm;
                cVar.sew = "http://shp.qpic.cn/qqvideo_ori/0/" + this.qYw.tnm + String.format("_%s_%s/0", new Object[]{Integer.valueOf(496), Integer.valueOf(280)});
                cVar.seF = this.qYw.seF;
                cVar.bhd = this.qYw.bhd;
                cVar.pes = this.qYw.pes;
                cVar.seE = this.qYw.tnn;
                cVar.seA = this.qYw.seA;
                cVar.hbo = 496;
                cVar.hbn = 280;
                cVar.timestamp = bh.Wq();
                Object arrayList2 = new ArrayList();
                arrayList2.add(cVar);
                com.tencent.mm.plugin.webview.fts.topstory.a.b.h(arrayList2, true);
                com.tencent.mm.plugin.webview.fts.topstory.a.b.a(null, cVar, this.qYw.tnn, this.qYw.tno);
                if (this.qYw != null) {
                    d dVar = new d();
                    dVar.offset = 0;
                    dVar.lEK = "";
                    switch (this.fromScene) {
                        case 2:
                            dVar.scene = 32;
                            break;
                        case 3:
                            dVar.scene = 31;
                            break;
                    }
                    dVar.tjR = 1;
                    dVar.fod = getString(R.l.ekJ);
                    dVar.tjW = 0;
                    com.tencent.mm.plugin.webview.fts.topstory.a.b.d(dVar);
                    this.tnw = new com.tencent.mm.plugin.topstory.a.a.a();
                    this.tnw.sek = this.qYw.tnm;
                    this.tnw.sel = this.qYw.tnn;
                    this.tnw.sem = this.qYw.tno;
                    this.tnw.sen = this.qYw.tnp;
                    this.tnw.seo = this.qYw.tnq;
                }
                U(arrayList2);
                x.i("MicroMsg.WebSearch.TopStoryVideoListUI", "first fetch from init video, videoId: %s, expand: %s, searchId: %s, category: %s", new Object[]{this.tnw.sek, this.tnw.sel, this.tnw.sem, Long.valueOf(this.tnw.seo)});
                com.tencent.mm.plugin.webview.fts.topstory.a.b.tnw = this.tnw;
                com.tencent.mm.plugin.webview.fts.topstory.a.b.tnD = true;
                if (an.isNetworkConnected(ac.getContext())) {
                    this.toL = h.a(this, getString(R.l.ctB), true, new 4(this));
                    G(true, false);
                    this.toP = false;
                } else {
                    Toast.makeText(this, R.l.eCu, 1).show();
                    this.toP = true;
                }
            }
        }
        ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).a(this);
        if (com.tencent.mm.plugin.webview.fts.topstory.a.b.tnv != null) {
            f.tob.iRN = com.tencent.mm.plugin.webview.fts.topstory.a.b.tnv.lEK;
        }
        if (this.toC != null) {
            e eVar = this.toC;
            if (!eVar.tox) {
                a.toe.enable();
                a.toe.tod = eVar.toy;
            }
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(791, 13);
    }

    private void U(ArrayList<com.tencent.mm.plugin.topstory.a.a.c> arrayList) {
        View view = new View(this);
        view.setClickable(false);
        view.setFocusableInTouchMode(false);
        view.setFocusable(false);
        view.setBackgroundResource(R.e.bso);
        view.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(R.f.bxo)));
        this.toA.addHeaderView(view);
        this.toC = new e(this, arrayList);
        this.toA.setAdapter(this.toC);
        this.toA.setOnScrollListener(this.toN);
        this.toC.tov = true;
        if (this.fromScene == 2 || this.fromScene == 3) {
            this.toC.tou = true;
        }
        this.toG = new GestureDetector(this, new 6(this));
        this.toA.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ TopStoryVideoListUI toU;

            {
                this.toU = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    this.toU.toF = false;
                }
                return this.toU.toG.onTouchEvent(motionEvent);
            }
        });
    }

    private void G(boolean z, boolean z2) {
        if (z2) {
            bPH();
        }
        this.toI.a(0, this.tnw, com.tencent.mm.plugin.webview.fts.topstory.a.b.tnv, z, new 8(this));
    }

    private void bPG() {
        com.tencent.mm.plugin.webview.fts.topstory.a.b.tnD = true;
        this.toH = bh.Wq();
        bPH();
        this.toI.a(com.tencent.mm.plugin.webview.fts.topstory.a.b.bPn(), this.tnw, com.tencent.mm.plugin.webview.fts.topstory.a.b.tnv, false, new c.a(this) {
            final /* synthetic */ TopStoryVideoListUI toU;

            {
                this.toU = r1;
            }

            public final void cl(List<com.tencent.mm.plugin.topstory.a.a.c> list) {
                if (list != null && list.size() > 0) {
                    List cn = TopStoryVideoListUI.cn(list);
                    com.tencent.mm.plugin.webview.fts.topstory.a.b.h(cn, false);
                    this.toU.toC.cm(cn);
                    if (cn != null && cn.size() > 0 && ((com.tencent.mm.plugin.topstory.a.a.c) cn.get(0)).seC > 0) {
                        this.toU.tnw.seo = ((com.tencent.mm.plugin.topstory.a.a.c) cn.get(0)).seC;
                        com.tencent.mm.plugin.webview.fts.topstory.a.b.tnw = this.toU.tnw;
                    }
                    x.i("MicroMsg.WebSearch.TopStoryVideoListUI", "update recCategory: %s", new Object[]{Long.valueOf(this.toU.tnw.seo)});
                }
                TopStoryVideoListUI.l(this.toU);
                com.tencent.mm.plugin.webview.fts.topstory.a.b.tnD = false;
                com.tencent.mm.plugin.webview.fts.topstory.a.b.tnE = false;
                if (this.toU.toJ != null && TopStoryVideoItemView.agN()) {
                    this.toU.toJ.bPA();
                    this.toU.toJ = null;
                }
            }

            public final void a(com.tencent.mm.plugin.topstory.a.a.c cVar) {
            }

            public final void Ob(String str) {
                TopStoryVideoListUI.l(this.toU);
                com.tencent.mm.plugin.webview.fts.topstory.a.b.tnD = false;
                com.tencent.mm.plugin.webview.fts.topstory.a.b.tnE = true;
                TopStoryVideoListUI.a(this.toU, str);
            }
        });
    }

    private void bPH() {
        if (this.toB == null) {
            this.toB = LayoutInflater.from(this).inflate(R.i.dtd, null);
            this.toB.setPadding(0, 0, 0, ((a.eB(this.mController.xIM) * 2) / 5) - getResources().getDimensionPixelSize(R.f.bxo));
        }
        this.toA.addFooterView(this.toB);
    }

    protected final int getLayoutId() {
        return R.i.dte;
    }

    protected void onPause() {
        x.i("MicroMsg.WebSearch.TopStoryVideoListUI", "onPause");
        super.onPause();
        if (this.toK > 0) {
            int i;
            long bA = bh.bA(this.toK) / 1000;
            switch (this.fromScene) {
                case 2:
                    i = 32;
                    break;
                case 3:
                    i = 31;
                    break;
                default:
                    i = 21;
                    break;
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(15018, new Object[]{Integer.valueOf(i), Long.valueOf(bA)});
        }
        g bQd = g.bQd();
        if (bQd.tpX != null) {
            bQd.tpX.TD();
        }
        e.bPt();
        e.onPause();
        com.tencent.mm.plugin.report.service.g.pQN.h(791, 15);
    }

    protected void onResume() {
        super.onResume();
        this.toK = bh.Wq();
        g bQd = g.bQd();
        if (bQd.tpX != null) {
            bQd.tpX.TE();
        }
        d bPB = d.bPB();
        if (bPB.nbV) {
            bPB.bPC();
        }
        e.bPt();
        e.onResume();
        com.tencent.mm.plugin.report.service.g.pQN.h(791, 14);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.toC != null && this.toC.tox) {
            a.toe.disable();
            a.toe.tod = null;
        }
        ar.CG().b(1943, this.toI);
        ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).ahl();
        d bPB = d.bPB();
        bPB.tog = null;
        bPB.toj = null;
        bPB.toi = null;
        bPB.toh = false;
        bPB.nbV = false;
        d.tof = null;
        g bQd = g.bQd();
        if (bQd.tpX != null) {
            bQd.stopPlay();
            bQd.tpX.ahl();
            g.tpV = null;
        }
        e bPt = e.bPt();
        g.Dj().CU().a(w.a.xxE, Long.valueOf(e.tnR.get()));
        x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "Save FileIndexInteger ConfigIndex %d", new Object[]{Long.valueOf(e.tnR.get())});
        bPt.tnT = "";
        if (!e.tnU.get()) {
            com.tencent.mm.sdk.f.e.post(new e.a(bPt, e.tnR.get() - 1), "FtsRecommendVideoPreloadMgr.DeleteUnusedTask");
        }
        com.tencent.mm.plugin.webview.fts.topstory.a.b.reset();
        com.tencent.mm.plugin.webview.fts.topstory.a.d.ahl();
        com.tencent.mm.plugin.report.service.g.pQN.h(791, 16);
    }

    public void onBackPressed() {
        if (this.toC == null || e.aeG()) {
            super.onBackPressed();
        } else {
            x.i("MicroMsg.WebSearch.TopStoryVideoListUI", "list consume onBackPressed");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        e eVar;
        TopStoryVideoItemView b;
        if (i == 25 && keyEvent.getAction() == 0) {
            if (this.toC != null) {
                eVar = this.toC;
                if (d.bPB().nbV) {
                    d.bPB().toi.bPX();
                } else {
                    b = com.tencent.mm.plugin.webview.fts.topstory.ui.a.a.b(eVar.tog);
                    if (!(b == null || b.tom.tqf == null)) {
                        b.tom.tqf.bPX();
                    }
                }
            }
        } else if (i == 24 && keyEvent.getAction() == 0 && this.toC != null) {
            eVar = this.toC;
            if (d.bPB().nbV) {
                d.bPB().toi.setMute(false);
            } else {
                b = com.tencent.mm.plugin.webview.fts.topstory.ui.a.a.b(eVar.tog);
                if (!(b == null || b.tom.tqf == null)) {
                    b.tom.tqf.setMute(false);
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final int getForceOrientation() {
        if (TopStoryVideoItemView.agN()) {
            return 0;
        }
        return 1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        switch (f.tob.fromScene) {
            case 1:
                i3 = 21;
                break;
            case 2:
                i3 = 32;
                break;
            case 3:
                i3 = 31;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            if (i2 == -1) {
                Toast.makeText(ac.getContext(), R.l.dGG, 1).show();
                com.tencent.mm.plugin.report.service.g.pQN.h(15035, new Object[]{Integer.valueOf(i3), r3.iRN, r3.toc.seK, r3.toc.sey, Integer.valueOf(1)});
            }
        } else if (i == 2048 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder("");
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    if (s.eV((String) it.next())) {
                        stringBuilder.append(3);
                        stringBuilder.append(";");
                    } else {
                        stringBuilder.append(2);
                        stringBuilder.append(";");
                    }
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(15035, new Object[]{Integer.valueOf(i3), r3.iRN, r3.toc.seK, r3.toc.sey, stringBuilder.toString()});
            }
        }
    }

    public final ListView getListView() {
        return this.toA;
    }

    public final void bPy() {
        this.qlf.animate().alpha(0.1f).setDuration(200).setStartDelay(3000);
    }

    public final void bPz() {
        this.qlf.animate().cancel();
        this.qlf.setAlpha(1.0f);
    }

    public final void Ad(int i) {
        x.i("MicroMsg.WebSearch.TopStoryVideoListUI", "tryToPlayPositionVideo %d", new Object[]{Integer.valueOf(i)});
        ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).iX(true);
        this.toA.smoothScrollToPositionFromTop(this.toA.getHeaderViewsCount() + i, getResources().getDimensionPixelSize(R.f.bxo));
    }

    public final void a(c cVar) {
        this.toJ = cVar;
        if (d.bPB().nbV && !com.tencent.mm.plugin.webview.fts.topstory.a.b.tnD) {
            bPG();
        }
    }

    public final MMActivity bPx() {
        return this;
    }

    public final void dN(int i, int i2) {
        d bPB = d.bPB();
        if (bPB.nbV) {
            bPB.toi.ej(i, i2);
        }
        g bQd = g.bQd();
        if (i == 0) {
            if (bQd.tpZ && bQd.tqd) {
                bQd.tqd = false;
                bQd.bEA();
            }
        } else if (i2 == 0 && bQd.tpZ && bQd.bQg()) {
            bQd.tqd = true;
            bQd.bxv();
        }
        if (!d.bPB().nbV) {
            com.tencent.mm.plugin.webview.fts.topstory.ui.a.a.a(this).tom.tqf.ej(i, i2);
        }
    }
}
