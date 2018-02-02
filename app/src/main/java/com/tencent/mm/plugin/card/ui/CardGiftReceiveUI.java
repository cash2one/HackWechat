package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.card.b.a.a;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo$AcceptedCardItem;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI extends DrawStatusBarActivity implements OnClickListener, e {
    private int hcn;
    private String hco;
    private CardGiftInfo kRT;
    private ProgressBar kRX;
    private af kRY = new af(Looper.getMainLooper());
    private View kSA;
    private TextView kSB;
    private LinearLayout kSC;
    private ListView kSD;
    private RelativeLayout kSE;
    private LinearLayout kSF;
    private ImageView kSG;
    private TextView kSH;
    private LinearLayout kSI;
    private TextView kSJ;
    private RelativeLayout kSK;
    private RelativeLayout kSL;
    private ImageView kSM;
    private ImageView kSN;
    private TextView kSO;
    private TextView kSP;
    private ListView kSQ;
    private RelativeLayout kSR;
    private TextView kSS;
    private TextView kST;
    private View kSU;
    a kSV = new 4(this);
    private ScrollView kSj;
    private LinearLayout kSk;
    private ImageView kSl;
    private TextView kSm;
    private TextView kSn;
    private ImageView kSo;
    private ImageView kSp;
    private LinearLayout kSq;
    private RelativeLayout kSr;
    private RelativeLayout kSs;
    private TextView kSt;
    private ImageView kSu;
    private TextView kSv;
    private TextView kSw;
    private TextView kSx;
    private ImageView kSy;
    private ImageView kSz;
    private r tipDialog = null;

    class c extends BaseAdapter {
        final /* synthetic */ CardGiftReceiveUI kSW;
        private LinkedList<CardGiftInfo$AcceptedCardItem> kTb;

        public final /* synthetic */ Object getItem(int i) {
            return nU(i);
        }

        c(CardGiftReceiveUI cardGiftReceiveUI, LinkedList<CardGiftInfo$AcceptedCardItem> linkedList) {
            this.kSW = cardGiftReceiveUI;
            this.kTb = linkedList;
        }

        public final int getCount() {
            return this.kTb.size();
        }

        private CardGiftInfo$AcceptedCardItem nU(int i) {
            return (CardGiftInfo$AcceptedCardItem) this.kTb.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            CardGiftInfo$AcceptedCardItem nU = nU(i);
            if (view == null) {
                view = View.inflate(this.kSW, R.i.dbZ, null);
                d dVar2 = new d(this.kSW);
                dVar2.jpW = (TextView) view.findViewById(R.h.cTc);
                dVar2.kTa = (TextView) view.findViewById(R.h.cTb);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.jpW.setText(nU.kKO);
            dVar.kTa.setText(nU.kKP + this.kSW.mController.xIM.getString(R.l.dOk));
            return view;
        }
    }

    static /* synthetic */ void a(CardGiftReceiveUI cardGiftReceiveUI, boolean z) {
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(cardGiftReceiveUI, R.i.dcb, null);
        cardGiftReceiveUI.kSU = relativeLayout.findViewById(R.h.bOR);
        cardGiftReceiveUI.kSS = (TextView) relativeLayout.findViewById(R.h.cTi);
        cardGiftReceiveUI.kST = (TextView) relativeLayout.findViewById(R.h.cTh);
        cardGiftReceiveUI.kSS.setOnClickListener(cardGiftReceiveUI);
        cardGiftReceiveUI.kST.setOnClickListener(cardGiftReceiveUI);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (z) {
            if (cardGiftReceiveUI.kSR.getVisibility() == 0) {
                layoutParams.addRule(3, R.h.bIo);
            } else {
                layoutParams.addRule(3, R.h.bQC);
            }
            layoutParams.bottomMargin = cardGiftReceiveUI.I(30);
            layoutParams.topMargin = cardGiftReceiveUI.I(40);
        } else {
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = cardGiftReceiveUI.I(30);
            layoutParams.topMargin = cardGiftReceiveUI.I(40);
        }
        LayoutParams layoutParams2;
        if (cardGiftReceiveUI.kSR.getVisibility() == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            if (cardGiftReceiveUI.kSK.getVisibility() == 0) {
                layoutParams2.topMargin = cardGiftReceiveUI.I(0);
                cardGiftReceiveUI.kSR.setLayoutParams(layoutParams2);
            } else {
                layoutParams2.topMargin = cardGiftReceiveUI.I(60);
            }
            cardGiftReceiveUI.kSR.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.kSR.addView(relativeLayout, layoutParams);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams2.topMargin = cardGiftReceiveUI.I(60);
            cardGiftReceiveUI.kSE.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.kSE.addView(relativeLayout, layoutParams);
        }
        if (bh.ov(cardGiftReceiveUI.kRT.kKE)) {
            cardGiftReceiveUI.kSS.setVisibility(8);
        } else {
            cardGiftReceiveUI.kSS.setVisibility(0);
            cardGiftReceiveUI.kSS.setText(cardGiftReceiveUI.kRT.kKE);
        }
        if (bh.ov(cardGiftReceiveUI.kRT.kKr)) {
            cardGiftReceiveUI.kSU.setVisibility(8);
            cardGiftReceiveUI.kST.setVisibility(8);
        } else {
            cardGiftReceiveUI.kSU.setVisibility(0);
            cardGiftReceiveUI.kST.setVisibility(0);
            cardGiftReceiveUI.kST.setText(cardGiftReceiveUI.kRT.kKr);
        }
        if (bh.ov(cardGiftReceiveUI.kRT.kKg)) {
            cardGiftReceiveUI.kSE.setVisibility(8);
        }
    }

    protected final int getLayoutId() {
        return R.i.dcd;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hco = getIntent().getStringExtra("key_order_id");
        this.hcn = getIntent().getIntExtra("key_biz_uin", -1);
        this.kRT = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        x.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[]{this.hco, Integer.valueOf(this.hcn)});
        initView();
        ar.CG().a(1165, this);
        ar.CG().a(699, this);
        com.tencent.mm.plugin.card.b.a.a(this.kSV);
        if (this.kRT == null) {
            x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
            if (this.hcn == -1) {
                x.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
                return;
            }
            if (this.hco == null) {
                x.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
            }
            x.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
            ar.CG().a(new z(this.hcn, this.hco), 0);
            this.tipDialog = h.a(this.mController.xIM, getString(R.l.ctB), true, new 3(this));
            if (this.tipDialog != null) {
                this.tipDialog.show();
                return;
            }
            return;
        }
        ava();
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(1165, this);
        ar.CG().b(699, this);
        com.tencent.mm.plugin.card.b.a.b(this.kSV);
    }

    private void ava() {
        if (this.kRT == null) {
            x.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
            return;
        }
        x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[]{Integer.valueOf(this.kRT.kKy)});
        com.tencent.mm.aq.a.a.c.a aVar;
        if (this.kRT.kKy == 1 || this.kRT.kKy != 2) {
            this.kSk.setVisibility(8);
            this.kSq.setVisibility(0);
            this.kSv.setText(this.kRT.kKp);
            if (this.kRT.kKL == 1) {
                this.kSy.setAlpha(0.5f);
                this.kSw.setVisibility(8);
                this.kSx.setVisibility(8);
                this.kSs.setVisibility(8);
                this.kSr.setVisibility(8);
            } else {
                this.kSw.setVisibility(0);
                this.kSx.setVisibility(0);
                this.kSs.setVisibility(0);
                this.kSr.setVisibility(0);
                this.kSw.setText(this.kRT.kKq);
                this.kSx.setText(R.l.dOk);
                if (bh.ov(this.kRT.kKq)) {
                    this.kSw.setVisibility(8);
                    this.kSx.setVisibility(8);
                }
                if (bh.ov(this.kRT.kKC)) {
                    x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
                } else {
                    this.kSw.setTextColor(bh.ba(this.kRT.kKC, getResources().getColor(R.e.black)));
                }
            }
            if (bh.ov(this.kRT.kKx)) {
                this.kSu.setVisibility(8);
                x.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
            } else {
                this.kSu.setVisibility(0);
                aVar = new com.tencent.mm.aq.a.a.c.a();
                aVar.hDD = com.tencent.mm.compatible.util.e.bnF;
                o.PB();
                aVar.hDW = null;
                aVar.hDC = m.wk(this.kRT.kKx);
                aVar.hDA = true;
                aVar.hDy = true;
                o.PA().a(this.kRT.kKx, this.kSu, aVar.PK());
            }
            if (bh.ov(this.kRT.kKw)) {
                this.kSt.setVisibility(8);
                x.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
            } else {
                this.kSt.setVisibility(0);
                this.kSt.setText(this.kRT.kKw);
                if (bh.ov(this.kRT.kKA)) {
                    x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
                } else {
                    this.kSt.setTextColor(bh.ba(this.kRT.kKA, getResources().getColor(R.e.black)));
                }
            }
            if (bh.ov(this.kRT.kKB)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
            } else {
                this.kSv.setTextColor(bh.ba(this.kRT.kKB, getResources().getColor(R.e.black)));
            }
            if (bh.ov(this.kRT.kKo)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
            } else {
                aVar = new com.tencent.mm.aq.a.a.c.a();
                aVar.hDD = com.tencent.mm.compatible.util.e.bnF;
                o.PB();
                aVar.hDW = null;
                aVar.hDC = m.wk(this.kRT.kKo);
                aVar.hDY = true;
                aVar.hDA = true;
                aVar.hDy = true;
                aVar.hDQ = new ColorDrawable(l.wO("#CCCCCC"));
                o.PA().a(this.kRT.kKo, this.kSz, aVar.PK());
            }
            if (bh.ov(this.kRT.kKn)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            } else {
                aVar = new com.tencent.mm.aq.a.a.c.a();
                aVar.hDD = com.tencent.mm.compatible.util.e.bnF;
                o.PB();
                aVar.hDW = null;
                aVar.hDC = m.wk(this.kRT.kKn);
                aVar.hDA = true;
                aVar.hDy = true;
                aVar.hDQ = new ColorDrawable(l.wO("#CCCCCC"));
                aVar.hDY = true;
                aVar.hDZ = (float) com.tencent.mm.bv.a.fromDPToPix(this, 8);
                o.PA().a(this.kRT.kKn, this.kSy, aVar.PK());
            }
        } else {
            this.kSq.setVisibility(8);
            this.kSk.setVisibility(0);
            this.kSm.setText(this.kRT.kKw);
            this.kSn.setText(this.kRT.kKp + "     " + this.kRT.kKq + this.mController.xIM.getString(R.l.dOk));
            if (bh.ov(this.kRT.kKx)) {
                this.kSl.setVisibility(8);
            } else {
                this.kSl.setVisibility(0);
                aVar = new com.tencent.mm.aq.a.a.c.a();
                aVar.hDD = com.tencent.mm.compatible.util.e.bnF;
                o.PB();
                aVar.hDW = null;
                aVar.hDC = m.wk(this.kRT.kKx);
                aVar.hDA = true;
                aVar.hDy = true;
                o.PA().a(this.kRT.kKx, this.kSl, aVar.PK());
            }
            if (bh.ov(this.kRT.kKA)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
            } else {
                this.kSm.setTextColor(bh.ba(this.kRT.kKA, getResources().getColor(R.e.black)));
            }
            if (bh.ov(this.kRT.kKB)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
            } else {
                this.kSn.setTextColor(bh.ba(this.kRT.kKB, getResources().getColor(R.e.black)));
            }
            if (bh.ov(this.kRT.kKo)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
            } else {
                aVar = new com.tencent.mm.aq.a.a.c.a();
                aVar.hDD = com.tencent.mm.compatible.util.e.bnF;
                o.PB();
                aVar.hDW = null;
                aVar.hDC = m.wk(this.kRT.kKo);
                aVar.hDY = true;
                aVar.hDA = true;
                aVar.hDy = true;
                aVar.hDQ = new ColorDrawable(l.wO("#CCCCCC"));
                o.PA().a(this.kRT.kKo, this.kSp, aVar.PK());
            }
            if (bh.ov(this.kRT.kKn)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            } else {
                aVar = new com.tencent.mm.aq.a.a.c.a();
                aVar.hDD = com.tencent.mm.compatible.util.e.bnF;
                o.PB();
                aVar.hDW = null;
                aVar.hDC = m.wk(this.kRT.kKn);
                aVar.hDA = true;
                aVar.hDy = true;
                aVar.hDQ = new ColorDrawable(l.wO("#CCCCCC"));
                aVar.hDY = true;
                aVar.hDZ = (float) com.tencent.mm.bv.a.fromDPToPix(this, 8);
                o.PA().a(this.kRT.kKn, this.kSo, aVar.PK());
            }
        }
        if (this.kRT.kKL == 1) {
            this.kSF.setVisibility(0);
            this.kSI.setVisibility(8);
            this.kSE.setVisibility(8);
            this.kSH.setText(i.b(this, this.kRT.fFh, this.kSH.getTextSize()));
            a(this.kSG);
        } else {
            this.kSF.setVisibility(8);
            this.kSI.setVisibility(0);
            this.kSE.setVisibility(0);
            a(this.kSN);
            this.kSO.setText(i.b(this, this.kRT.fFh, this.kSO.getTextSize()));
            if ((bh.ov(this.kRT.kKh) || "undefined".equals(this.kRT.kKh)) && (bh.ov(this.kRT.kKi) || "undefined".equals(this.kRT.kKi))) {
                this.kSK.setVisibility(8);
                x.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
            } else {
                this.kSK.setVisibility(0);
            }
            if (this.kRT == null || bh.ov(this.kRT.kKh)) {
                x.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
            } else {
                com.tencent.mm.plugin.card.b.a.g(this.kRT.kKh, this.kRT.kKk, this.kRT.kKt, 2);
            }
            if (this.kRT == null || bh.ov(this.kRT.kKj)) {
                x.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
            } else {
                com.tencent.mm.plugin.card.b.a.g(this.kRT.kKj, this.kRT.kKm, this.kRT.kKv, 2);
            }
            if (!bh.ov(this.kRT.kKg)) {
                this.kSJ.setText(i.b(this, this.kRT.kKg, this.kSJ.getTextSize()));
            }
        }
        avl();
        if (this.kRT.kKJ.size() > 0) {
            this.kSR.setVisibility(0);
            this.kSQ.setVisibility(0);
            this.kSQ.setAdapter(new a(this));
            b(this.kSQ);
            if (!bh.ov(this.kRT.kKK)) {
                this.kSP.setVisibility(0);
                this.kSP.setText(this.kRT.kKK);
            }
        } else {
            this.kSR.setVisibility(0);
            this.kSQ.setVisibility(0);
            this.kSP.setVisibility(0);
            if (!bh.ov(this.kRT.kKK)) {
                this.kSP.setVisibility(0);
                this.kSP.setText(this.kRT.kKK);
            }
        }
        if (bh.ov(this.kRT.kKE) && bh.ov(this.kRT.kKr)) {
            this.kSj.setFillViewport(true);
        } else {
            this.kSj.getViewTreeObserver().addOnGlobalLayoutListener(new 1(this));
        }
    }

    private int I(int i) {
        return com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, i);
    }

    private void a(ImageView imageView) {
        if (bh.ov(this.kRT.kKf)) {
            x.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
            return;
        }
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this, 20);
        com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
        aVar.hDD = com.tencent.mm.compatible.util.e.bnF;
        o.PB();
        aVar.hDW = null;
        aVar.hDC = m.wk(this.kRT.kKf);
        aVar.hDA = true;
        aVar.hDY = true;
        aVar.hDZ = 3.0f;
        aVar.hDy = true;
        aVar.hDH = fromDPToPix;
        aVar.hDG = fromDPToPix;
        aVar.hDQ = new ColorDrawable(l.wO("#CCCCCC"));
        o.PA().a(this.kRT.kKf, imageView, aVar.PK());
    }

    private void avl() {
        int i = 0;
        if (this.kRT.kKI.size() > 0) {
            this.kSA.setVisibility(0);
            this.kSD.setVisibility(8);
            if (this.kRT.kKI.size() <= 2) {
                this.kSB.setVisibility(8);
                F(this.kRT.kKI);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.kRT.kKI.get(0));
            linkedList.add(this.kRT.kKI.get(1));
            F(linkedList);
            this.kSB.setVisibility(0);
            this.kSB.setOnClickListener(this);
            linkedList = new LinkedList();
            while (i < this.kRT.kKI.size()) {
                if (!(i == 0 || i == 1)) {
                    linkedList.add(this.kRT.kKI.get(i));
                }
                i++;
            }
            this.kSD.setAdapter(new c(this, linkedList));
            b(this.kSD);
            return;
        }
        this.kSA.setVisibility(8);
        this.kSB.setVisibility(8);
        this.kSD.setVisibility(8);
    }

    private void F(LinkedList<CardGiftInfo$AcceptedCardItem> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            CardGiftInfo$AcceptedCardItem cardGiftInfo$AcceptedCardItem = (CardGiftInfo$AcceptedCardItem) it.next();
            View inflate = View.inflate(this, R.i.dbZ, null);
            TextView textView = (TextView) inflate.findViewById(R.h.cTb);
            ((TextView) inflate.findViewById(R.h.cTc)).setText(cardGiftInfo$AcceptedCardItem.kKO);
            textView.setText(cardGiftInfo$AcceptedCardItem.kKP + this.mController.xIM.getString(R.l.dOk));
            this.kSC.addView(inflate);
        }
    }

    private static void b(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            int i = 0;
            for (int i2 = 0; i2 < count; i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
        }
    }

    protected final void initView() {
        this.kSj = (ScrollView) findViewById(R.h.bQM);
        this.kSk = (LinearLayout) findViewById(R.h.bSo);
        this.kSl = (ImageView) findViewById(R.h.csd);
        this.kSm = (TextView) findViewById(R.h.cTu);
        this.kSn = (TextView) findViewById(R.h.cTt);
        this.kSo = (ImageView) findViewById(R.h.csb);
        this.kSp = (ImageView) findViewById(R.h.csc);
        this.kSo.setOnClickListener(this);
        this.kSq = (LinearLayout) findViewById(R.h.bSn);
        this.kSr = (RelativeLayout) findViewById(R.h.bMO);
        this.kSs = (RelativeLayout) findViewById(R.h.bMQ);
        this.kSt = (TextView) findViewById(R.h.cTf);
        this.kSv = (TextView) findViewById(R.h.cTs);
        this.kSu = (ImageView) findViewById(R.h.csa);
        this.kSw = (TextView) findViewById(R.h.cTw);
        this.kSx = (TextView) findViewById(R.h.cTx);
        this.kSy = (ImageView) findViewById(R.h.crV);
        this.kSz = (ImageView) findViewById(R.h.crW);
        this.kSy.setOnClickListener(this);
        this.kSA = findViewById(R.h.bRn);
        this.kSB = (TextView) findViewById(R.h.cTv);
        this.kSC = (LinearLayout) findViewById(R.h.bRm);
        this.kSD = (ListView) findViewById(R.h.bRo);
        this.kSE = (RelativeLayout) findViewById(R.h.bQB);
        this.kSF = (LinearLayout) findViewById(R.h.cnI);
        this.kSG = (ImageView) findViewById(R.h.crY);
        this.kSH = (TextView) findViewById(R.h.cTl);
        this.kSI = (LinearLayout) findViewById(R.h.cnH);
        this.kSN = (ImageView) findViewById(R.h.crX);
        this.kSO = (TextView) findViewById(R.h.cTk);
        this.kSJ = (TextView) findViewById(R.h.cTj);
        this.kSK = (RelativeLayout) findViewById(R.h.bQZ);
        this.kSL = (RelativeLayout) findViewById(R.h.cpG);
        this.kSM = (ImageView) findViewById(R.h.cTm);
        this.kSK.setOnClickListener(this);
        this.kSL.setOnClickListener(this);
        this.kSP = (TextView) findViewById(R.h.cSX);
        this.kSQ = (ListView) findViewById(R.h.bIo);
        this.kSR = (RelativeLayout) findViewById(R.h.bQA);
        this.kRX = (ProgressBar) findViewById(R.h.cpp);
        com.tencent.mm.plugin.card.b.m.b(this, false);
        com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, -1, true);
        setMMTitle("");
        setBackBtn(new 2(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (kVar instanceof z) {
                x.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
                this.kRT = ((z) kVar).kLQ;
                ava();
            } else if (kVar instanceof t) {
                Intent intent = new Intent(this, CardDetailUI.class);
                LinkedList linkedList = ((t) kVar).kLU;
                if (linkedList == null || linkedList.size() == 0) {
                    x.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
                    return;
                }
                b bVar = (b) linkedList.get(0);
                if (bVar == null || !(bVar instanceof CardInfo)) {
                    x.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add((CardInfo) it.next());
                }
                intent.putExtra("key_card_info", (CardInfo) bVar);
                intent.putExtra("key_previous_scene", 27);
                intent.putExtra("key_from_scene", 27);
                intent.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
                intent.putExtra("key_card_git_info", this.kRT);
                startActivity(intent);
            }
        } else if (kVar instanceof z) {
            x.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            d.a(this, str, true);
        } else if (kVar instanceof t) {
            x.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }

    public void onClick(View view) {
        Intent intent;
        if (view.getId() == R.h.cpG) {
            if (!bh.ov(this.kRT.kKi)) {
                intent = new Intent(this, CardGiftVideoUI.class);
                intent.putExtra("key_gift_into", this.kRT);
                intent.putExtra("key_is_mute", false);
                startActivity(intent);
                overridePendingTransition(0, 0);
                g.pQN.h(13866, new Object[]{Integer.valueOf(3), this.hco, com.tencent.mm.a.o.getString(this.hcn)});
            }
        } else if (view.getId() == R.h.bQZ) {
            if (this.kRX.getVisibility() != 0 && !bh.ov(this.kRT.kKh)) {
                intent = new Intent(this, CardGiftImageUI.class);
                intent.putExtra("key_gift_into", this.kRT);
                startActivity(intent);
                overridePendingTransition(0, 0);
                g.pQN.h(13866, new Object[]{Integer.valueOf(4), this.hco, com.tencent.mm.a.o.getString(this.hcn)});
            }
        } else if (view.getId() == R.h.cTh) {
            if (this.kRT != null && this.kRT.kKs) {
                g.pQN.h(13866, new Object[]{Integer.valueOf(7), this.hco, com.tencent.mm.a.o.getString(this.hcn)});
                intent = new Intent(this, CardHomePageUI.class);
                intent.putExtra("key_home_page_from_scene", 2);
                startActivity(intent);
                x.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
                finish();
                overridePendingTransition(0, 0);
            }
        } else if (view.getId() == R.h.cTi) {
            if (!TextUtils.isEmpty(this.kRT.kKM) && !TextUtils.isEmpty(this.kRT.kKN)) {
                com.tencent.mm.plugin.card.b.b.d(this.kRT.kKD, this.kRT.kKM, this.kRT.kKN, 1062, getIntent().getIntExtra("key_from_appbrand_type", 0));
                g.pQN.h(13866, new Object[]{Integer.valueOf(8), this.hco, com.tencent.mm.a.o.getString(this.hcn)});
            } else if (!bh.ov(this.kRT.kKF)) {
                com.tencent.mm.plugin.card.b.b.a(this, this.kRT.kKF, 0);
                g.pQN.h(13866, new Object[]{Integer.valueOf(8), this.hco, com.tencent.mm.a.o.getString(this.hcn)});
            }
        } else if (view.getId() == R.h.crV || view.getId() == R.h.csb) {
            if (bh.ov(this.kRT.kKG) || bh.ov(this.kRT.kKH)) {
                x.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
                return;
            }
            LinkedList linkedList = new LinkedList();
            kp kpVar = new kp();
            kpVar.kJN = this.kRT.kKG;
            kpVar.code = this.kRT.kKH;
            linkedList.add(kpVar);
            String stringExtra = getIntent().getStringExtra("key_template_id");
            blp com_tencent_mm_protocal_c_blp = new blp();
            com_tencent_mm_protocal_c_blp.wPf = stringExtra;
            x.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[]{stringExtra});
            ar.CG().a(new t(linkedList, com_tencent_mm_protocal_c_blp, 27), 0);
            g.pQN.h(13866, new Object[]{Integer.valueOf(9), this.hco, com.tencent.mm.a.o.getString(this.hcn)});
        } else if (view.getId() != R.h.cTv) {
        } else {
            if (this.kSD.getVisibility() == 0) {
                this.kSD.setVisibility(8);
                this.kSB.setText("查看全部");
                return;
            }
            this.kSD.setVisibility(0);
            this.kSB.setText("收起");
        }
    }
}
