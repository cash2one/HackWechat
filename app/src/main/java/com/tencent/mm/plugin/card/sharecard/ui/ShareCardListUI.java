package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;

public class ShareCardListUI extends CardBaseUI implements d, a {
    private String kKG = null;
    private b.a kMX = null;
    private b kOF;
    private f kOO;
    private e kOP;
    private i kOQ;
    private boolean kOR = false;
    private boolean kOS = true;
    private boolean kOT = false;
    private boolean kOU = true;
    private boolean kOV = true;
    private boolean kOW = false;
    private String kOX = "";
    private boolean kOY = false;
    private boolean kOZ = false;
    private boolean kPa = false;
    private int kPb = 0;
    private boolean kPc = false;
    private long kPd = 0;
    boolean kPe = false;
    private long kPf = 0;
    private final long kPg = 500;
    private boolean kPh = false;
    private boolean kPi = false;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.kPd = currentTimeMillis;
        initView();
        ar.CG().a(1164, this);
        am.auH().a(this);
        avo();
        am.auI().c(this);
    }

    protected void onDestroy() {
        if (this.kPc) {
            ata();
        }
        this.kOO.kOF = null;
        this.kOP.kOF = null;
        this.kOF.kMX = null;
        ar.CG().b(1164, this);
        am.auH().b(this);
        b.auX();
        am.auI().j(this);
        long currentTimeMillis = System.currentTimeMillis() - this.kPd;
        if (TextUtils.isEmpty(this.kKG)) {
            g.pQN.h(13219, new Object[]{"ShareCardListUI", Integer.valueOf(1), "", "", Long.valueOf(currentTimeMillis)});
        } else {
            g.pQN.h(13219, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Long.valueOf(currentTimeMillis)});
        }
        super.onDestroy();
    }

    protected void onResume() {
        dZ(true);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(56);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(57);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g.pQN.a(arrayList, true);
            this.mStartTime = 0;
        }
        super.onResume();
    }

    private void dZ(boolean z) {
        x.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", new Object[]{Boolean.valueOf(this.kOS), Boolean.valueOf(z)});
        if (this.kOS) {
            this.kOS = false;
            this.kOY = false;
            this.kOU = true;
            this.kOX = "";
            x.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
            if (!z) {
                avn();
            } else if (this.kPc && this.kPe) {
                asZ();
            }
        }
        avk();
    }

    protected void onPause() {
        super.onPause();
        this.kOS = false;
        this.kOT = true;
    }

    protected final BaseAdapter asU() {
        return new c(this.mController.xIM);
    }

    protected final void initView() {
        super.initView();
        x.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.kPc = r0;
        if (this.kPc) {
            avj();
            return;
        }
        x.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
        avm();
    }

    private void avj() {
        x.d("MicroMsg.ShareCardListUI", "initLocation");
        ar.Dm().F(new 1(this));
    }

    protected final void atd() {
        x.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.kPc);
        if (!this.kPc) {
            this.kPc = true;
            avj();
        }
    }

    protected final void asS() {
        setMMTitle(R.l.dPg);
        this.kOF = new b(this);
        this.kMX = new b.a(this) {
            final /* synthetic */ ShareCardListUI kPj;

            {
                this.kPj = r1;
            }
        };
        this.kOF.kMX = this.kMX;
        this.kOF.init();
        this.kPb = b.auU();
        if (this.kOQ == null) {
            this.kOQ = new i(this, this.mController.contentView);
            i iVar = this.kOQ;
            iVar.kPk = View.inflate(iVar.kaY, R.i.dcB, null);
            iVar.kPl = (TextView) iVar.kPk.findViewById(R.h.bRc);
            iVar.kPm = (TextView) iVar.kPk.findViewById(R.h.bRd);
            iVar.au();
        }
        if (this.kOO == null) {
            this.kOO = new f(this, this.mController.contentView);
            f fVar = this.kOO;
            fVar.kOJ = (ImageView) fVar.kND.findViewById(R.h.cAp);
            fVar.kOL = (TextView) fVar.kND.findViewById(R.h.cAr);
            fVar.kOK = (TextView) fVar.kND.findViewById(R.h.cAs);
            this.kOO.kOF = this.kOF;
        }
        if (this.kOP == null) {
            View view = this.mController.contentView;
            this.kOP = new e(this);
            this.kOP.kOF = this.kOF;
            this.kOP.ave();
            e eVar = this.kOP;
            OnClickListener 3 = new 3(this);
            if (eVar.kOE != null) {
                eVar.kOE.setOnClickListener(3);
            }
        }
        if (this.kIh != null) {
            this.kIh.addView(this.kOQ.kPk);
        }
        if (this.kIi != null) {
            this.kIi.addView(this.kOP.kOE);
        }
        this.kIe.setVisibility(0);
        this.kIe.setOnScrollListener(new 4(this));
        Integer num;
        if (getIntent() == null || !getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)) {
            ar.Hg();
            num = (Integer) c.CU().get(w.a.xou, Integer.valueOf(0));
            if (!(num == null || num.intValue() == 1)) {
                ar.Hg();
                c.CU().a(w.a.xou, Integer.valueOf(1));
            }
        } else {
            ar.Hg();
            num = (Integer) c.CU().get(w.a.xou, Integer.valueOf(0));
            if (num == null || num.intValue() != 1) {
                ar.Hg();
                c.CU().a(w.a.xou, Integer.valueOf(1));
                com.tencent.mm.plugin.card.b.d.c(this, R.i.dcG, R.l.dPn, "");
            }
        }
        this.kKG = getIntent().getStringExtra("KEY_CARD_TP_ID");
        this.kOX = getIntent().getStringExtra("key_layout_buff");
        if (!bh.ov(this.kOX)) {
            this.kOS = false;
        }
        if (!bh.ov(this.kKG)) {
            this.kOR = true;
            this.kOT = true;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        avo();
        if (intent != null) {
            this.kKG = intent.getStringExtra("KEY_CARD_TP_ID");
            if (!bh.ov(this.kKG)) {
                this.kOR = true;
                this.kOT = true;
            }
        }
    }

    private void avk() {
        long currentTimeMillis = System.currentTimeMillis() - this.kPf;
        if (!this.kPh || currentTimeMillis >= 1000) {
            x.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", new Object[]{Boolean.valueOf(this.kPh), Long.valueOf(currentTimeMillis)});
            this.kPh = true;
            if (currentTimeMillis < 500) {
                ag.h(new 5(this), 500);
                return;
            }
            if (this.kPb == 0 || this.kPb == 4 || ((this.kPb == 2 && !(b.auW() && b.auV())) || ((this.kPb == 1 && (!b.auW() || b.auV())) || (this.kPb == 3 && (!b.auV() || b.auW()))))) {
                this.kPb = b.auU();
            }
            am.auF().putValue("key_share_card_show_type", Integer.valueOf(this.kPb));
            x.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", new Object[]{Integer.valueOf(this.kPb), Boolean.valueOf(b.auW()), Boolean.valueOf(b.auV())});
            f fVar = this.kOO;
            fVar.kOK.setVisibility(0);
            fVar.kOJ.setImageDrawable(fVar.kaY.getResources().getDrawable(R.g.bAp));
            fVar.kOK.setText(R.l.dPb);
            fVar.kOL.setText(R.l.dPa);
            LayoutParams layoutParams = (LayoutParams) fVar.kOJ.getLayoutParams();
            layoutParams.topMargin = fVar.kaY.getResources().getDimensionPixelOffset(R.f.bwC);
            fVar.kOJ.setLayoutParams(layoutParams);
            fVar.kOJ.invalidate();
            if (b.auW() || b.auV()) {
                this.kOP.au();
                this.kOQ.au();
                if (this.kPb == 4 && this.kIe.getEmptyView() != null) {
                    this.kIe.setEmptyView(null);
                    this.kIe.invalidate();
                }
            } else {
                this.kOP.avi();
                this.kOQ.kPk.setVisibility(8);
                if (this.kIe.getEmptyView() != this.kIg) {
                    this.kIe.setEmptyView(this.kIg);
                    this.kIe.invalidate();
                }
            }
            avl();
            this.kPf = System.currentTimeMillis();
            this.kPh = false;
            return;
        }
        x.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
    }

    private void avl() {
        if (this.kIf instanceof c) {
            c cVar = (c) this.kIf;
            cVar.kOC = this.kPb;
            cVar.a(null, null);
        }
    }

    protected final void atb() {
        this.kPa = true;
        if (this.kOY) {
            x.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.kPc) {
                ata();
                return;
            }
            return;
        }
        x.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
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
        x.i("MicroMsg.ShareCardListUI", "onLocationFail()");
        avm();
    }

    private void avm() {
        if (b.auY() && b.auZ()) {
            x.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
            this.kOV = true;
            return;
        }
        if (!(b.auY() && b.auZ())) {
            this.kOU = false;
        }
        x.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        avn();
        am.auG().m("", "", 4);
    }

    private void avn() {
        if (this.kOW) {
            x.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
            return;
        }
        if (!(!bh.ov(this.kOX) || b.auW() || b.auV() || b.auW() || b.auV())) {
            this.kOP.avf();
            this.kIe.setEmptyView(null);
            this.kIe.invalidate();
            this.kPi = true;
        }
        if (this.kOU && !bh.ov(this.kOX)) {
            this.kOX = "";
        }
        this.kOW = true;
        ar.CG().a(new com.tencent.mm.plugin.card.sharecard.model.b((double) am.auG().gyz, (double) am.auG().gyA, this.kOX), 0);
    }

    protected final boolean asV() {
        return super.asV();
    }

    protected final boolean asW() {
        return false;
    }

    protected final void b(com.tencent.mm.plugin.card.base.b bVar) {
        if (bVar != null) {
            b.wl(bVar.atG());
        }
        super.b(bVar);
    }

    protected final void c(com.tencent.mm.plugin.card.base.b bVar) {
        super.c(bVar);
    }

    protected final void a(com.tencent.mm.plugin.card.base.b bVar) {
        Intent intent = new Intent(this, CardDetailUI.class);
        x.i("MicroMsg.ShareCardListUI", "card tp id:" + bVar.atG());
        x.i("MicroMsg.ShareCardListUI", "card id:" + bVar.atF());
        intent.putExtra("key_card_id", am.auI().wt(bVar.atG()));
        intent.putExtra("key_card_tp_id", bVar.atG());
        intent.putExtra("key_is_share_card", true);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        b.wq(bVar.atG());
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        super.a(i, i2, str, kVar);
        if (i != 0 || i2 != 0) {
            if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                if (this.kPi) {
                    this.kPi = false;
                    this.kOP.avg();
                    this.kIe.setEmptyView(this.kIg);
                    this.kIe.invalidate();
                }
                this.kOW = false;
                this.kOV = true;
            }
            x.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) kVar;
            this.kOW = false;
            this.kOX = bVar.kNf;
            this.kOF.aa(bVar.kLN, this.kOU);
            if (!(b.auY() && b.auZ())) {
                this.kOU = false;
            }
            if (!(b.auY() && b.auZ())) {
                z = false;
            }
            this.kOV = z;
            x.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
            avk();
        }
    }

    public final void atM() {
        b.auT();
        this.kOS = true;
        x.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", new Object[]{Boolean.valueOf(this.kOT), Boolean.valueOf(this.kIk), Boolean.valueOf(this.kPa)});
        if (this.kOT && this.kIk && this.kPa) {
            dZ(false);
        } else {
            avk();
        }
        this.kOT = false;
    }

    public final void a(String str, l lVar) {
        x.d("MicroMsg.ShareCardListUI", "onNotifyChange");
        this.kOS = true;
    }

    private void avo() {
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean aQ = com.tencent.mm.s.c.Bq().aQ(262152, 266256);
        boolean aR = com.tencent.mm.s.c.Bq().aR(262152, 266256);
        boolean a = com.tencent.mm.s.c.Bq().a(w.a.xoc, w.a.xoe);
        boolean a2 = com.tencent.mm.s.c.Bq().a(w.a.xod, w.a.xof);
        ar.Hg();
        String ou = bh.ou((String) c.CU().get(w.a.xoi, null));
        if (aQ) {
            g.pQN.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        } else if (aR) {
            g.pQN.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        } else if (a && !a2) {
            g.pQN.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        } else if (a && a2) {
            g.pQN.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        } else if (a2) {
            g.pQN.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        } else {
            g.pQN.h(11324, new Object[]{"ShareCardListUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), ou});
        }
    }
}
