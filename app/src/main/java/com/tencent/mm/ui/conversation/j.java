package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.4;
import com.tencent.mm.ui.conversation.k.2;
import com.tencent.mm.ui.conversation.m.1;
import com.tencent.mm.ui.conversation.m.3;
import com.tencent.mm.ui.conversation.m.5;
import com.tencent.mm.ui.conversation.m.6;
import com.tencent.mm.ui.conversation.m.7;
import com.tencent.mm.ui.conversation.m.9;
import com.tencent.mm.ui.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

public class j extends com.tencent.mm.ui.AbstractTabChildActivity.a implements i$a {
    private int[] rDA = new int[2];
    private g yWw;
    private ConversationWithAppBrandListView yZE;
    private TextView yZF;
    private i yZG = new i();
    private c yZH = new c();
    private m yZI = new m();
    private k yZJ = new k();
    private a yZK;
    private a yZt = new a();

    class a {
        boolean fpa;
        final /* synthetic */ j yZL;
        boolean yZN;
        boolean yZO;

        public a(j jVar, boolean z, boolean z2, boolean z3) {
            this.yZL = jVar;
            this.fpa = z;
            this.yZN = z2;
            this.yZO = z3;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(j jVar, int i) {
        int i2 = 1;
        x.i("MicroMsg.MainUI", "summerinit setShowView count[%d], stack[%s]", new Object[]{Integer.valueOf(i), t.Ws()});
        if (i <= 0) {
            a aVar = jVar.yZt;
            if (aVar.context != null) {
                x.i("MicroMsg.BannerHelper", "checkBannerEmpyt %d", new Object[]{Integer.valueOf(aVar.hashCode())});
                if (!aVar.l(aVar.yVK, false)) {
                    if (!aVar.l(aVar.yVL, false)) {
                        if (!aVar.l(aVar.yVM, false)) {
                        }
                    }
                }
            }
            i2 = 0;
            if (i2 != 0) {
                jVar.yZF.setVisibility(0);
                jVar.yZE.setVisibility(8);
            }
        }
        jVar.yZE.setVisibility(0);
        jVar.yZF.setVisibility(8);
    }

    protected int getLayoutId() {
        return R.i.cuK;
    }

    protected View getLayoutView() {
        return b.DY().a(getContext(), "R.layout.main", R.i.cuK);
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    public void onResume() {
        x.i("MicroMsg.MainUI", "onResume");
        super.onResume();
        if (this.yZE != null) {
            ConversationWithAppBrandListView conversationWithAppBrandListView = this.yZE;
            x.i("MicroMsg.ConversationWithAppBrandListView", "[onResume]");
            if (conversationWithAppBrandListView.yXJ != null) {
                conversationWithAppBrandListView.yXJ.R(false);
            }
            conversationWithAppBrandListView.ne(true);
        }
    }

    public void onPause() {
        x.i("MicroMsg.MainUI", "onPause");
        super.onPause();
    }

    public final void d(boolean z, boolean z2, boolean z3) {
        if (this.yZE instanceof ConversationWithAppBrandListView) {
            ConversationWithAppBrandListView conversationWithAppBrandListView = this.yZE;
            if (conversationWithAppBrandListView.nj(false)) {
                x.i("MicroMsg.ConversationWithAppBrandListView", "[showAppBrandHeader] isShow:%s isScrollFirst:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z3)});
                conversationWithAppBrandListView.ne(true);
                if (conversationWithAppBrandListView.yXI != null && !z) {
                    conversationWithAppBrandListView.yXI.setVisibility(8);
                } else if (!(conversationWithAppBrandListView.yXI == null || conversationWithAppBrandListView.yXJ == null || conversationWithAppBrandListView.yXJ.fm().getItemCount() <= 1)) {
                    conversationWithAppBrandListView.yXI.setVisibility(0);
                    if (z3) {
                        conversationWithAppBrandListView.yXJ.smoothScrollToPosition(0);
                    }
                }
                conversationWithAppBrandListView.post(new 4(conversationWithAppBrandListView, z2));
                return;
            }
            x.w("MicroMsg.ConversationWithAppBrandListView", "[showAppBrandHeader] AppBrandHeader is disable! ");
            return;
        }
        this.yZK = new a(this, z, z2, z3);
    }

    public final void cvI() {
        if (this.yWw != null) {
            this.yWw.cvI();
        }
    }

    public final void z(long j, int i) {
        if (this.yZE != null) {
            this.yZE.z(j, i);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.yZt.cwo();
    }

    protected final void clt() {
        a aVar;
        x.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[]{Integer.valueOf(hashCode())});
        if (this.mController != null) {
            this.mController.ad(4, false);
        }
        x.i("MicroMsg.MainUI", "mainUIOnCreate");
        long currentTimeMillis = System.currentTimeMillis();
        setMenuVisibility(true);
        ar.Dm().cfE();
        x.i("MicroMsg.MainUI", "main ui init view");
        if (this.yZE != null) {
            aVar = this.yZt;
            if (aVar.yVR != null) {
                aVar.dy(aVar.yVK);
                aVar.dy(aVar.yVL);
                aVar.dy(aVar.yVM);
                aVar.dy(aVar.yVN);
                for (com.tencent.mm.pluginsdk.ui.b.b bVar : aVar.yVO) {
                    if (!(bVar == null || bVar.getView() == null)) {
                        aVar.yVR.removeFooterView(bVar.getView());
                    }
                }
            }
        }
        this.yZF = (TextView) findViewById(R.h.ceg);
        this.yZE = (ConversationWithAppBrandListView) findViewById(R.h.cuL);
        this.yZE.setDrawingCacheEnabled(false);
        this.yZE.setScrollingCacheEnabled(false);
        this.yWw = new g(getContext(), new 3(this));
        this.yWw.a(new 4(this));
        this.yWw.a(new 5(this));
        if (d.fO(18)) {
            com.tencent.mm.blink.b.wo().f(new Runnable(this) {
                final /* synthetic */ j yZL;

                {
                    this.yZL = r1;
                }

                public final void run() {
                    this.yZL.yZt.a(this.yZL.getContext(), this.yZL.yZE, this.yZL.yZF);
                }
            });
        } else {
            this.yZt.a(getContext(), this.yZE, this.yZF);
        }
        k kVar = this.yZJ;
        ListView listView = this.yZE;
        g gVar = this.yWw;
        kVar.yVR = listView;
        kVar.yWw = gVar;
        listView.setOnScrollListener(kVar.kZW);
        gVar.yWH = kVar.kZW;
        ag.y(new 2(kVar));
        this.yZH.aa(getActivity());
        this.yZE.setAdapter(this.yWw);
        this.yZE.setOnItemClickListener(new e(this.yWw, this.yZE, getActivity()));
        this.yZE.setOnItemLongClickListener(new f(this.yWw, this.yZE, getActivity(), this.rDA));
        this.yZE.setOnTouchListener(new 7(this));
        if (this.yZK != null) {
            d(this.yZK.fpa, this.yZK.yZN, this.yZK.yZO);
        }
        this.yZE.setSelection(0);
        i iVar = this.yZG;
        Activity activity = getActivity();
        aVar = this.yZt;
        iVar.fAF = activity;
        iVar.yZt = aVar;
        iVar.yZu = this;
        iVar.wakeLock = ((PowerManager) activity.getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
        ar.CG().a(-1, iVar);
        iVar.yZq = false;
        com.tencent.mm.sdk.b.a.xef.b(iVar.yZv);
        com.tencent.mm.sdk.b.a.xef.b(iVar.yZw);
        File file = new File(ac.getContext().getFilesDir(), "DBRecoverStarted");
        if (file.exists()) {
            com.tencent.mm.plugin.report.d.pPH.c("DBRepair", "Last recovery interrupted.", null);
            file.delete();
        }
        iVar.yZx = new FLock(new File(ac.getContext().getFilesDir(), "MMStarted"), true);
        if (iVar.yZx.ceT()) {
            iVar.yZx.unlock();
            x.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
        } else {
            x.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
            com.tencent.mm.plugin.report.d.pPH.a(579, 0, 1, true);
        }
        iVar.yZx.ceS();
        c cVar = this.yZH;
        g gVar2 = this.yWw;
        ListView listView2 = this.yZE;
        Activity activity2 = getActivity();
        cVar.yWw = gVar2;
        cVar.yVR = listView2;
        cVar.activity = activity2;
        com.tencent.mm.sdk.b.a.xef.b(cVar.yWz);
        com.tencent.mm.sdk.b.a.xef.b(cVar.yWx);
        com.tencent.mm.sdk.b.a.xef.b(cVar.yWy);
        m mVar = this.yZI;
        gVar2 = this.yWw;
        ConversationWithAppBrandListView conversationWithAppBrandListView = this.yZE;
        activity2 = getActivity();
        mVar.yWw = gVar2;
        mVar.fAF = activity2;
        mVar.yZE = conversationWithAppBrandListView;
        if (mVar.lvr == null) {
            mVar.lvr = new 3(mVar, new 1(mVar));
        }
        if (mVar.yZZ == null) {
            mVar.yZZ = new m.4(mVar);
        }
        if (mVar.zaa == null) {
            mVar.zaa = new 5(mVar, conversationWithAppBrandListView);
        }
        com.tencent.mm.sdk.b.a.xef.b(mVar.lvr);
        com.tencent.mm.sdk.b.a.xef.b(mVar.yZZ);
        com.tencent.mm.sdk.b.a.xef.b(mVar.zaa);
        mVar.xGr = new 6(mVar);
        Looper.myQueue().addIdleHandler(mVar.xGr);
        conversationWithAppBrandListView.post(new 7(mVar));
        com.tencent.mm.aq.b Py = o.Py();
        int i = R.g.bAH;
        x.d("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + Py.hzn + " to " + i);
        Py.hzn = i;
        o.Py().start();
        ar.by(false);
        ar.Hg();
        c.Fd().a(this.yWw);
        ar.Hg();
        c.EY().a(this.yWw);
        g gVar3 = this.yWw;
        if (gVar3.yWN == null) {
            gVar3.yWN = new g.1(gVar3);
        }
        com.tencent.mm.sdk.b.a.xef.b(gVar3.yWN);
        this.yWw.yYu = new 1(this);
        r2 = new Object[3];
        ar.Hg();
        r2[1] = Integer.valueOf(c.Cg());
        r2[2] = Integer.valueOf(com.tencent.mm.protocal.d.vAz);
        x.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", r2);
        this.yZE.postDelayed(new 8(this), 200);
    }

    public final void cwK() {
        if (this.yWw != null) {
            this.yWw.onResume();
        }
    }

    public final void cwL() {
        if (this.yWw != null) {
            this.yWw.onPause();
        }
    }

    protected final void clu() {
        x.i("MicroMsg.MainUI", "onTabResume");
        long Wp = t.Wp();
        c cVar = this.yZH;
        if (cVar.yWv < 0) {
            x.d("MicroMsg.ConvUnreadHelper", "onTabResume totalUnReadCount %d", new Object[]{Integer.valueOf(cVar.yWv)});
            if (cVar.yWw != null) {
                cVar.yWw.cwA();
            }
        }
        cwK();
        com.tencent.mm.blink.b.wo().f(new 9(this));
        x.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[]{Long.valueOf(t.bz(Wp))});
        m mVar = this.yZI;
        if (com.tencent.mm.pluginsdk.q.a.vcp != null) {
            com.tencent.mm.pluginsdk.q.a.vcp.a(mVar);
        }
        ag.y(new m$8(mVar));
        l.fS(mVar.fAF);
        if (!(mVar.fAF == null || mVar.fAF.getIntent() == null || !mVar.fAF.getIntent().getBooleanExtra("resend_fail_messages", false))) {
            ag.h(new 9(mVar), 500);
            mVar.fAF.getIntent().putExtra("resend_fail_messages", false);
        }
        LauncherUI launcherUI = (LauncherUI) mVar.fAF;
        if (launcherUI != null) {
            launcherUI.xGS.aa(mVar.yQE);
        }
        if (com.tencent.mm.sdk.platformtools.t.a(mVar.fAF.getIntent(), "Main_ListToTop", false) && mVar.yZE != null) {
            mVar.yZE.post(new m.2(mVar));
        }
        com.tencent.mm.sdk.platformtools.t.b(mVar.fAF.getIntent(), "Main_ListToTop", false);
        i iVar = this.yZG;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabResume tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = iVar.iln == null ? -1 : iVar.iln.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iVar.cwG());
        x.i(str, str2, objArr);
        iVar.cwF();
        ag.h(new i$6(iVar), 100);
        if (ar.Hj() && !this.yZG.cwH()) {
            com.tencent.mm.sdk.b.a.xef.a(new rc(), Looper.getMainLooper());
            com.tencent.mm.sdk.b.b qoVar = new qo();
            qoVar.fIh.action = 4;
            com.tencent.mm.sdk.b.a.xef.a(qoVar, Looper.getMainLooper());
        }
    }

    protected final void clv() {
        x.i("MicroMsg.MainUI", "onTabStart");
    }

    protected final void clw() {
        x.i("MicroMsg.MainUI", "onTabPause");
        com.tencent.mm.blink.b.wo().f(new 10(this));
        i iVar = this.yZG;
        if (iVar.wakeLock.isHeld()) {
            x.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
            iVar.wakeLock.release();
        }
        hideVKB();
        m mVar = this.yZI;
        if (com.tencent.mm.pluginsdk.q.a.vcp != null) {
            com.tencent.mm.pluginsdk.q.a.vcp.b(mVar);
        }
        l.cwN();
        LauncherUI launcherUI = (LauncherUI) mVar.fAF;
        if (launcherUI != null) {
            launcherUI.xGS.ab(mVar.yQE);
        }
        cwL();
    }

    protected final void clx() {
        x.i("MicroMsg.MainUI", "onTabStop");
    }

    protected final void cly() {
        x.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[]{Boolean.valueOf(ar.Hj())});
        com.tencent.mm.blink.b.wo().f(new 2(this));
        i iVar = this.yZG;
        iVar.yZx.unlock();
        ar.CG().b(-1, iVar);
        if (iVar.iln != null) {
            iVar.iln.dismiss();
            iVar.iln = null;
        }
        com.tencent.mm.sdk.b.a.xef.c(iVar.yZv);
        com.tencent.mm.sdk.b.a.xef.c(iVar.yZw);
        l lVar = this.yZI;
        if (lVar.lvr != null) {
            com.tencent.mm.sdk.b.a.xef.c(lVar.lvr);
            lVar.lvr = null;
        }
        com.tencent.mm.sdk.b.a.xef.c(lVar.yZZ);
        com.tencent.mm.sdk.b.a.xef.c(lVar.zaa);
        if (com.tencent.mm.pluginsdk.q.a.vcp != null) {
            com.tencent.mm.pluginsdk.q.a.vcp.b(lVar);
        }
        if (ar.Hj()) {
            t.Wr();
        }
        c cVar = this.yZH;
        com.tencent.mm.sdk.b.a.xef.c(cVar.yWz);
        com.tencent.mm.sdk.b.a.xef.c(cVar.yWx);
        com.tencent.mm.sdk.b.a.xef.c(cVar.yWy);
        cVar.activity = null;
        if (ar.Hj() && this.yWw != null) {
            ar.Hg();
            c.Fd().b(this.yWw);
            ar.Hg();
            c.EY().b(this.yWw);
        }
        if (this.yWw != null) {
            g gVar = this.yWw;
            if (gVar.yWN != null) {
                com.tencent.mm.sdk.b.a.xef.c(gVar.yWN);
                gVar.yWN = null;
            }
            this.yWw.yYu = null;
            f fVar = this.yWw;
            fVar.yYu = null;
            if (fVar.yns != null) {
                fVar.yns.clear();
                fVar.yns = null;
            }
            fVar.lP(true);
            fVar.clU();
            fVar.yYx.clear();
            x.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
        }
    }

    public final void clA() {
        x.i("MicroMsg.MainUI", "turn to bg");
    }

    public final void clB() {
        x.i("MicroMsg.MainUI", "turn to fg");
    }

    public final void clz() {
        if (this.yZE != null) {
            this.yZE.clz();
        }
    }

    public final void cmr() {
        x.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
        i iVar = this.yZG;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabSwitchIn tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = iVar.iln == null ? -1 : iVar.iln.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iVar.cwG());
        x.i(str, str2, objArr);
        if (iVar.wakeLock != null) {
            iVar.cwF();
        }
        if (this.mController != null) {
            this.mController.onResume();
        }
    }

    public final void cms() {
        x.i("MicroMsg.MainUI", "onTabSwitchOut");
        z(0, 8);
    }

    public void onDestroy() {
        x.i("MicroMsg.MainUI", "onDestroy");
        this.yZJ.cwM();
        if (this.yZE != null) {
            ConversationWithAppBrandListView conversationWithAppBrandListView = this.yZE;
            if (conversationWithAppBrandListView.yXJ != null) {
                conversationWithAppBrandListView.yXJ.release();
            }
            conversationWithAppBrandListView.yXR.dead();
        }
        super.onDestroy();
    }

    public final void cwI() {
        if (this.yWw != null) {
            this.yWw.nUw = true;
        }
    }

    public final void cwJ() {
        if (this.yWw != null) {
            this.yWw.nUw = false;
            this.yWw.cwA();
            if (thisActivity() != null) {
                this.yZH.aa(getActivity());
            }
        }
    }
}
