package com.tencent.mm.plugin.favorite.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.em;
import com.tencent.mm.plugin.favorite.a.p;
import com.tencent.mm.plugin.favorite.a.q;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.base.c;
import com.tencent.mm.plugin.favorite.ui.base.c.a;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;

public abstract class FavBaseUI extends MMActivity implements OnItemClickListener {
    protected af hae = new af(Looper.getMainLooper());
    private final Object lockObj = new Object();
    protected h mpb;
    private boolean mrE = false;
    protected boolean mrF = false;
    private boolean mrG = false;
    private long mrH = 0;
    protected ListView mrI;
    protected TextView mrJ;
    private HandlerThread mrK;
    protected af mrL;
    protected View mrM;
    private View mrN;
    protected c mrO;
    protected a mrP = null;
    private e mrQ = new e(this) {
        final /* synthetic */ FavBaseUI mrW;

        {
            this.mrW = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
            if (((p) kVar).mqI) {
                x.i("MicroMsg.FavoriteBaseUI", "need batch get return");
                return;
            }
            x.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
            if (this.mrW.mrG) {
                this.mrW.mrG = false;
            }
            this.mrW.eY(false);
            this.mrW.aJf();
        }
    };
    private e mrR = new e(this) {
        final /* synthetic */ FavBaseUI mrW;

        {
            this.mrW = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.FavoriteBaseUI", "on batch get end");
            if (this.mrW.mrG) {
                x.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
                this.mrW.mrG = false;
                this.mrW.eY(false);
            }
        }
    };
    private Runnable mrS = new Runnable(this) {
        final /* synthetic */ FavBaseUI mrW;

        {
            this.mrW = r1;
        }

        public final void run() {
            com.tencent.mm.plugin.favorite.ui.a.a aJb = this.mrW.aJb();
            aJb.aJt();
            aJb.aJu();
            this.mrW.aJf();
        }
    };
    protected Runnable mrT = new 9(this);
    private Runnable mrU = new 10(this);
    private j.a mrV = new 2(this);

    public abstract com.tencent.mm.plugin.favorite.ui.a.a aJb();

    protected abstract void aJc();

    protected abstract boolean aJd();

    protected abstract void aJe();

    static /* synthetic */ boolean a(FavBaseUI favBaseUI) {
        if (favBaseUI.mrI.getChildAt(favBaseUI.mrI.getChildCount() - 1) == null || favBaseUI.mrI.getLastVisiblePosition() != favBaseUI.mrI.getAdapter().getCount() - 1) {
            return false;
        }
        x.i("MicroMsg.FavoriteBaseUI", "at bottom call back");
        return true;
    }

    static /* synthetic */ boolean b(FavBaseUI favBaseUI) {
        x.v("MicroMsg.FavoriteBaseUI", "on pull down callback");
        if (!com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().p(favBaseUI.aJb().aJr(), favBaseUI.aJb().getType())) {
            if (com.tencent.mm.plugin.favorite.a.j.aIH()) {
                x.w("MicroMsg.FavoriteBaseUI", "doing batchget, do not load data");
            } else if (favBaseUI.mrE) {
                x.w("MicroMsg.FavoriteBaseUI", "onBottomLoadData loading, return");
            } else {
                favBaseUI.mrE = true;
                x.i("MicroMsg.FavoriteBaseUI", "on bottom load data listener");
                favBaseUI.mrL.removeCallbacks(favBaseUI.mrS);
                favBaseUI.mrL.post(favBaseUI.mrS);
            }
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dhT;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        if (com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aHY() == null) {
            com.tencent.mm.plugin.favorite.h.aIm().mpn = em.wf();
            finish();
            return;
        }
        x.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", new Object[]{Boolean.valueOf(ar.Hj())});
        ar.CG().a(new q(), 0);
        com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().c(this.mrV);
        ar.CG().a(400, this.mrQ);
        ar.CG().a(com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX, this.mrR);
        this.mrK = com.tencent.mm.sdk.f.e.Wf(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.mrK.start();
        this.mrL = new af(this.mrK.getLooper());
        this.mpb = new h(this.mController.xIM, 64);
        initView();
        ar.Hg();
        if (bh.e((Integer) com.tencent.mm.z.c.CU().get(8217, null)) == 0) {
            x.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
            this.mrG = true;
            ar.CG().a(new p(), 0);
            if (this.mrG) {
                x.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
                if (aJb() == null || aJb().isEmpty()) {
                    eY(true);
                }
                eZ(false);
            }
        } else {
            com.tencent.mm.plugin.favorite.a.j.startSync();
            if (aJb().isEmpty()) {
                eY(true);
                eZ(false);
                this.mrM.setVisibility(8);
            } else {
                eY(false);
                eZ(false);
            }
        }
        com.tencent.mm.plugin.favorite.h.aIr().run();
        com.tencent.mm.plugin.favorite.h.aIo().run();
        com.tencent.mm.plugin.favorite.h.aIn().run();
        com.tencent.mm.plugin.favorite.h.aIp().run();
        ar.Dm().F(new Runnable(this) {
            final /* synthetic */ FavBaseUI mrW;

            {
                this.mrW = r1;
            }

            public final void run() {
                com.tencent.mm.plugin.favorite.a.j.aII();
            }
        });
        x.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    protected void onResume() {
        super.onResume();
        i.CB(5);
    }

    protected void onPause() {
        super.onPause();
        aJb();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aHY() != null) {
            this.mpb.destory();
            this.mpb = null;
            this.mrK.quit();
            com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().j(this.mrV);
            ar.CG().b(400, this.mrQ);
            ar.CG().b(com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX, this.mrR);
        }
    }

    protected final void initView() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mrI = (ListView) findViewById(R.h.chw);
        this.mrI.setDrawingCacheEnabled(false);
        3 3 = new 3(this);
        initHeaderView();
        this.mrM = v.fv(this).inflate(R.i.dhF, null);
        this.mrI.setOnScrollListener(new 4(this));
        this.mrI.setOnItemClickListener(this);
        this.mrI.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavBaseUI mrW;

            {
                this.mrW = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.mrW.aWs();
                return false;
            }
        });
        this.mrI.setAdapter(aJb());
        a(aJb());
        x.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    protected final void eY(boolean z) {
        if (z) {
            if (this.mrN == null) {
                this.mrN = ((ViewStub) findViewById(R.h.cek)).inflate();
            }
            this.mrN.setVisibility(0);
        } else if (this.mrN != null) {
            this.mrN.setVisibility(8);
        }
    }

    private void eZ(boolean z) {
        if (z) {
            if (this.mrJ == null) {
                this.mrJ = (TextView) ((ViewStub) findViewById(R.h.cev)).inflate().findViewById(R.h.cei);
            }
            this.mrJ.setVisibility(0);
        } else if (this.mrJ != null) {
            this.mrJ.setVisibility(8);
        }
    }

    protected void initHeaderView() {
        this.mrO = new c(this.mController.xIM);
        this.mrO.mva = this.mrP;
        this.mrO.fd(false);
        this.mrO.muY.setVisibility(8);
        this.mrO.muZ.setVisibility(8);
        x.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[]{Integer.valueOf(this.mrO.getPaddingTop()), Integer.valueOf(this.mrO.getPaddingBottom())});
        this.mrI.addHeaderView(this.mrO);
    }

    protected void aJf() {
        x.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
        this.hae.removeCallbacks(this.mrT);
        this.hae.post(this.mrT);
    }

    protected final void a(com.tencent.mm.plugin.favorite.ui.a.a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
            return;
        }
        if (!aVar.isEmpty()) {
            eY(false);
            eZ(false);
        } else if (aJd()) {
            eY(true);
            eZ(false);
        } else {
            eY(false);
            eZ(true);
            aJe();
        }
        if (aVar.isEmpty() || com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().p(aVar.aJr(), aVar.getType())) {
            this.mrI.removeFooterView(this.mrM);
        } else if (this.mrI.getFooterViewsCount() == 0) {
            this.mrI.addFooterView(this.mrM);
        }
    }
}
