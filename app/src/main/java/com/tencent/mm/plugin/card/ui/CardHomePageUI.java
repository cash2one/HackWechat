package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.a.l;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.ui.i.2;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import java.util.ArrayList;

public class CardHomePageUI extends CardBaseUI implements d, a {
    private int fromScene = 0;
    private b kOF;
    private boolean kOS = false;
    private boolean kOU = true;
    private boolean kOW = false;
    private String kOX = "";
    private boolean kOY = false;
    private boolean kOZ = false;
    private long kPd = 0;
    boolean kPe = false;
    private boolean kTA = false;
    private TextView kTB;
    private i kTv;
    private f kTw;
    private f kTx;
    private f kTy;
    private boolean kTz = true;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.kPd = currentTimeMillis;
        initView();
        am.auE().a(this.kTv);
        ar.CG().a(1164, this);
        ar.CG().a(984, this);
        am.auH().auR();
        am.auz();
        com.tencent.mm.plugin.card.a.b.nF(1);
        avo();
        Looper.myQueue().addIdleHandler(new 9(this));
        am.auH().a(this);
        am.auA().c(this);
    }

    protected final int getLayoutId() {
        return R.i.dcf;
    }

    protected void onDestroy() {
        if (this.kTA) {
            ata();
        }
        am.auE().b(this.kTv);
        this.kOF.kMX = null;
        ar.CG().b(1164, this);
        ar.CG().b(984, this);
        am.auH().b(this);
        am.auA().j(this);
        l.auo();
        b.auX();
        long currentTimeMillis = System.currentTimeMillis() - this.kPd;
        g.pQN.h(13219, new Object[]{"CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis)});
        super.onDestroy();
    }

    protected void onResume() {
        x.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[]{Boolean.valueOf(this.kTA), Boolean.valueOf(this.kPe), Boolean.valueOf(this.kOS)});
        if (this.kTA && this.kPe && this.kOS) {
            this.kOX = "";
            this.kOY = false;
            asZ();
        } else if (this.kOS) {
            this.kOX = "";
            avm();
        }
        this.kOS = false;
        au();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(1);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g.pQN.a(arrayList, true);
            this.mStartTime = 0;
        }
        ar.Dm().F(new 1(this));
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void initView() {
        x.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.kTA = r0;
        if (this.kTA) {
            avj();
        } else {
            x.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
            avm();
        }
        super.initView();
    }

    protected final void asS() {
        setMMTitle(R.l.dOp);
        addTextOptionMenu(0, getString(R.l.dON), new OnMenuItemClickListener(this) {
            final /* synthetic */ CardHomePageUI kTC;

            {
                this.kTC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.card.b.b.a(this.kTC, true);
                g.pQN.h(11582, new Object[]{"CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", ""});
                return true;
            }
        });
        this.kOF = new b(this);
        this.kOF.init();
        if (this.kTv == null) {
            this.kTv = new i(this, this.mController.contentView);
            i iVar = this.kTv;
            iVar.kUw = View.inflate(iVar.kaY, R.i.dct, null);
            iVar.kUw.setVisibility(8);
            iVar.kUx = (TextView) iVar.kUw.findViewById(R.h.bRb);
            iVar.kUy = (ImageView) iVar.kUw.findViewById(R.h.bRa);
            iVar.kUw.setOnClickListener(new i$1(iVar));
            iVar.awd();
            if (iVar.kUz == null) {
                iVar.kUz = ((ViewStub) iVar.kND.findViewById(R.h.bRv)).inflate();
                iVar.kUz.setVisibility(8);
                iVar.kUA = (TextView) iVar.kUz.findViewById(R.h.bRb);
                iVar.kUB = (ImageView) iVar.kUz.findViewById(R.h.bRa);
                iVar.kUz.setOnClickListener(new 2(iVar));
            }
            this.kTv.kPn = true;
        }
        if (this.kTw == null) {
            this.kTw = new f(this, findViewById(R.h.bRs), 1, this.kOF);
        }
        if (this.kTx == null) {
            this.kTx = new f(this, findViewById(R.h.bRZ), 2, this.kOF);
        }
        if (this.kTy == null) {
            this.kTy = new f(this, findViewById(R.h.bSj), 3, this.kOF);
        }
        if (this.kTw != null) {
            this.kTw.setOnClickListener(new 6(this));
        }
        if (this.kTx != null) {
            this.kTx.setOnClickListener(new 7(this));
        }
        if (this.kTy != null) {
            this.kTy.setOnClickListener(new 8(this));
        }
        setBackBtn(new 3(this));
    }

    protected final int asT() {
        return n.a.kLL;
    }

    private void avj() {
        x.d("MicroMsg.CardHomePageUI", "initLocation");
        ar.Dm().F(new Runnable(this) {
            final /* synthetic */ CardHomePageUI kTC;

            {
                this.kTC = r1;
            }

            public final void run() {
                this.kTC.hpO = c.OP();
                this.kTC.asY();
                this.kTC.kPe = true;
                x.d("MicroMsg.CardHomePageUI", "initLocation end");
            }
        });
    }

    protected final void atd() {
        x.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.kTA);
        if (!this.kTA) {
            this.kTA = true;
            avj();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        avo();
        this.kOS = true;
        this.kTz = true;
    }

    private void au() {
        x.i("MicroMsg.CardHomePageUI", "updateView()");
        this.kTv.awd();
        avY();
        this.kTx.au();
        this.kTy.au();
    }

    private void avY() {
        x.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
        c cVar = (c) this.kIf;
        if (this.kTB == null) {
            this.kTB = (TextView) findViewById(R.h.cvG);
            this.kTB.setOnClickListener(new 5(this));
        }
        if (cVar.getCount() > 0) {
            this.kTB.setVisibility(0);
            this.kTB.setText(getString(R.l.dPv, new Object[]{Integer.valueOf(b.auS())}));
        } else {
            this.kTB.setVisibility(0);
            this.kTB.setText(getString(R.l.dPv, new Object[]{Integer.valueOf(0)}));
            LinearLayout linearLayout = (LinearLayout) findViewById(R.h.bQO);
            if (linearLayout != null) {
                LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = com.tencent.mm.bv.a.fromDPToPix(this, 29);
                layoutParams.bottomMargin = com.tencent.mm.bv.a.fromDPToPix(this, 29);
                linearLayout.setLayoutParams(layoutParams);
            }
        }
        this.kTw.kND.setVisibility(8);
    }

    protected final void ate() {
        avY();
    }

    protected final void atb() {
        if (this.kOY) {
            x.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.kTA) {
                ata();
                return;
            }
            return;
        }
        x.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
        this.kOY = true;
        avm();
        ata();
    }

    protected final void atc() {
        if (this.kOZ || this.kOY) {
            ata();
            return;
        }
        this.kOZ = true;
        x.i("MicroMsg.CardHomePageUI", "onLocationFail()");
        avm();
    }

    private void avm() {
        x.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        if (!this.kTz) {
            x.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
        } else if (this.kOW) {
            x.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
        } else {
            if (this.kOU && !bh.ov(this.kOX)) {
                this.kOX = "";
            }
            this.kOW = true;
            this.kTz = false;
            ar.CG().a(new com.tencent.mm.plugin.card.sharecard.model.b((double) am.auG().gyz, (double) am.auG().gyA, this.kOX), 0);
        }
        if (com.tencent.mm.plugin.card.b.l.axf()) {
            ar.Hg();
            int intValue = ((Integer) com.tencent.mm.z.c.CU().get(w.a.xoo, Integer.valueOf(1))).intValue();
            x.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is " + intValue);
            ar.CG().a(new ad((double) am.auG().gyz, (double) am.auG().gyA, intValue), 0);
        } else {
            x.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
        }
        am.auG().m("", "", 4);
    }

    protected final boolean asV() {
        return super.asV();
    }

    protected final boolean asW() {
        return true;
    }

    protected final void b(com.tencent.mm.plugin.card.base.b bVar) {
        super.b(bVar);
    }

    protected final void c(com.tencent.mm.plugin.card.base.b bVar) {
        super.c(bVar);
    }

    public final void a(int i, int i2, String str, k kVar) {
        super.a(i, i2, str, kVar);
        if (i != 0 || i2 != 0) {
            if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                this.kOW = false;
            }
            x.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (kVar instanceof ad) {
            avY();
            this.kIl.Hv();
            this.kTy.au();
        } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) kVar;
            this.kOW = false;
            this.kOX = bVar.kNf;
            this.kOF.aa(bVar.kLN, this.kOU);
            if (!(b.auY() && b.auZ())) {
                this.kOU = false;
            }
            x.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
            au();
        }
    }

    private void avo() {
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean aQ = com.tencent.mm.s.c.Bq().aQ(262152, 266256);
        boolean aR = com.tencent.mm.s.c.Bq().aR(262152, 266256);
        boolean a = com.tencent.mm.s.c.Bq().a(w.a.xoc, w.a.xoe);
        boolean a2 = com.tencent.mm.s.c.Bq().a(w.a.xod, w.a.xof);
        ar.Hg();
        String ou = bh.ou((String) com.tencent.mm.z.c.CU().get(w.a.xoi, null));
        if (aQ) {
            g.pQN.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        } else if (aR) {
            g.pQN.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        } else if (a && !a2) {
            g.pQN.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        } else if (a && a2) {
            g.pQN.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        } else if (a2) {
            g.pQN.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        } else {
            g.pQN.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        }
    }

    public final void atM() {
        this.kOS = true;
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        this.kOS = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fromScene == 1 || this.fromScene == 2) {
                avZ();
            } else {
                finish();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void avZ() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        com.tencent.mm.bm.d.a((Context) this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
    }
}
