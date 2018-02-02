package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.game.c.ak;
import com.tencent.mm.plugin.game.c.ar;
import com.tencent.mm.plugin.game.c.ch;
import com.tencent.mm.plugin.game.c.dg;
import com.tencent.mm.plugin.game.c.dl;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.ba;
import com.tencent.mm.plugin.game.model.bj;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.ui.GameIndexSearchView.1;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public class GameCenterUI5 extends GameCenterBaseUI implements e {
    private Dialog lNB;
    private boolean nnc = true;
    private GameNewTopBannerView nnm;
    private GameIndexSearchView nnn;
    private GameIndexWxagView nno;
    private GameMessageBubbleView nnp;
    private GameBlockView nnq;
    private GameRecomBlockView nnr;
    private GameNewClassifyView nns;
    private GameIndexListView nnt;

    static /* synthetic */ void a(GameCenterUI5 gameCenterUI5, aj ajVar, int i) {
        if (gameCenterUI5.isFinishing()) {
            x.w("MicroMsg.GameCenterUI5", "GameCenterUI5 hasFinished");
        } else if (ajVar == null) {
            x.e("MicroMsg.GameCenterUI5", "Null data");
        } else {
            ImageView imageView;
            TextView textView;
            View view;
            GameNewTopBannerView gameNewTopBannerView = gameCenterUI5.nnm;
            ch chVar = ajVar.ndN;
            int i2 = gameCenterUI5.ndn;
            boolean z = gameCenterUI5.nmz;
            if (chVar == null || chVar.njc == null || bh.ov(chVar.njc.ngr)) {
                GameNewTopBannerView.aRJ();
                gameNewTopBannerView.setVisibility(8);
            } else {
                gameNewTopBannerView.ndn = i2;
                gameNewTopBannerView.jcA = chVar.njb != null ? ap.BY(chVar.njb.nfK) : null;
                if (!gameNewTopBannerView.ntO.equals(chVar.njc.ngr)) {
                    gameNewTopBannerView.ntO = chVar.njc.ngr;
                    com.tencent.mm.plugin.game.d.e.aRV().h(gameNewTopBannerView.nmK, chVar.njc.ngr);
                    gameNewTopBannerView.ntM = gameNewTopBannerView.b(gameNewTopBannerView.nmK, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvq), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvp));
                    if (gameNewTopBannerView.ntM > 0) {
                        if (i == 2) {
                            ap.a(gameNewTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameNewTopBannerView.ndn, 0, null, null, gameNewTopBannerView.jcA);
                        }
                        if (gameNewTopBannerView.ntM <= 0 || chVar.njb == null || bh.ov(chVar.njb.nff)) {
                            gameNewTopBannerView.nmJ.setVisibility(8);
                        } else {
                            com.tencent.mm.plugin.game.d.e.aRV().h(gameNewTopBannerView.nmJ, chVar.njb.nff);
                            gameNewTopBannerView.ntN = gameNewTopBannerView.b(gameNewTopBannerView.nmJ, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvn), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvp));
                            if (gameNewTopBannerView.ntN > 0) {
                                gameNewTopBannerView.nmJ.setVisibility(0);
                                gameNewTopBannerView.nmJ.setTag(chVar.njb.nfg);
                                gameNewTopBannerView.nmJ.setOnClickListener(gameNewTopBannerView);
                            } else {
                                gameNewTopBannerView.nmJ.setVisibility(8);
                            }
                        }
                        if (gameNewTopBannerView.nmJ.getVisibility() == 0) {
                            if (chVar.njb.nkn == g.cN(gameNewTopBannerView.mContext) || z) {
                                GameIndexListView.qX(gameNewTopBannerView.ntM - gameNewTopBannerView.ntN);
                            } else {
                                gameNewTopBannerView.nmK.setImageAlpha(0);
                                g.D(gameNewTopBannerView.mContext, chVar.njb.nkn);
                                GameIndexListView.qX(0);
                            }
                            GameIndexListView.qS(gameNewTopBannerView.ntM - gameNewTopBannerView.ntN);
                            GameIndexListView.fG(true);
                        } else {
                            GameNewTopBannerView.aRJ();
                        }
                        gameNewTopBannerView.setVisibility(0);
                    } else {
                        GameNewTopBannerView.aRJ();
                        gameNewTopBannerView.setVisibility(8);
                    }
                } else if (i == 2) {
                    ap.a(gameNewTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameNewTopBannerView.ndn, 0, null, null, gameNewTopBannerView.jcA);
                }
            }
            ViewGroup viewGroup = gameCenterUI5.nnn;
            ch chVar2 = ajVar.ndN;
            int i3 = gameCenterUI5.ndn;
            if (chVar2 == null || chVar2.njc == null || chVar2.njc.njK == null) {
                viewGroup.setVisibility(8);
            } else {
                viewGroup.removeAllViews();
                dg dgVar = chVar2.njc.njK;
                viewGroup.setVisibility(0);
                viewGroup.DF.inflate(R.i.dkz, viewGroup, true);
                imageView = (ImageView) viewGroup.findViewById(R.h.cJH);
                textView = (TextView) viewGroup.findViewById(R.h.cKc);
                a aVar = new a();
                if (bh.ov(dgVar.nfT)) {
                    imageView.setVisibility(8);
                } else {
                    com.tencent.mm.plugin.game.d.e.aRV().a(imageView, dgVar.nfT, aVar.aRW());
                }
                if (bh.ov(dgVar.fon)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(dgVar.fon);
                }
                viewGroup.setTag(dgVar.nfg);
                viewGroup.setOnClickListener(new 1(viewGroup, i3));
            }
            ViewGroup viewGroup2 = gameCenterUI5.nno;
            ar arVar = ajVar.ndR;
            int i4 = gameCenterUI5.ndn;
            if (arVar == null) {
                viewGroup2.setVisibility(8);
            } else {
                viewGroup2.ndn = i4;
                viewGroup2.setVisibility(0);
                viewGroup2.mContainer.removeAllViews();
                if (bh.cA(arVar.nhn) && arVar.nho == null) {
                    viewGroup2.setVisibility(8);
                } else {
                    int i5;
                    if (i == 2) {
                        ap.a(viewGroup2.getContext(), 10, 1025, 0, null, i4, ap.BY(arVar.nfK));
                    }
                    viewGroup2.DF.inflate(R.i.djG, viewGroup2, true);
                    TextView textView2 = (TextView) viewGroup2.findViewById(R.h.cZQ);
                    LinearLayout linearLayout = (LinearLayout) viewGroup2.findViewById(R.h.cZO);
                    if (bh.ov(arVar.fon)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(arVar.fon);
                    }
                    for (int i6 = 0; i6 < 4; i6++) {
                        linearLayout.addView((LinearLayout) viewGroup2.DF.inflate(R.i.djF, viewGroup2, false), new LayoutParams(-1, -2, 1.0f));
                    }
                    if (bh.cA(arVar.nhn)) {
                        i5 = 0;
                    } else {
                        int i7 = 0;
                        i5 = 0;
                        while (i7 < arVar.nhn.size()) {
                            dl dlVar = (dl) arVar.nhn.get(i7);
                            if (!(dlVar == null || dlVar.njR == null || dlVar.njR.ngv == null)) {
                                View childAt = linearLayout.getChildAt(i5);
                                textView = (TextView) childAt.findViewById(R.h.cZP);
                                com.tencent.mm.plugin.game.d.e.aRV().h((ImageView) childAt.findViewById(R.h.cZN), dlVar.njR.ngv.nfT);
                                textView.setText(dlVar.njR.ngv.niZ);
                                if (i == 2) {
                                    ap.a(viewGroup2.getContext(), 10, 1025, i5 + 1, dlVar.njR.ngv.ngo, i4, null);
                                }
                                childAt.setTag(new GameIndexWxagView.a(i5 + 1, dlVar.njR.ngv));
                                childAt.setOnClickListener(viewGroup2);
                                i5++;
                                if (i5 >= 3) {
                                    break;
                                }
                            }
                            i7++;
                            i5 = i5;
                        }
                    }
                    if (arVar.nho != null) {
                        View childAt2 = linearLayout.getChildAt(i5);
                        textView = (TextView) childAt2.findViewById(R.h.cZP);
                        com.tencent.mm.plugin.game.d.e.aRV().h((ImageView) childAt2.findViewById(R.h.cZN), arVar.nho.nfT);
                        textView.setText(arVar.nho.niZ);
                        childAt2.setTag(arVar.nho);
                        childAt2.setOnClickListener(new GameIndexWxagView.1(viewGroup2, i4));
                    }
                    view = new View(viewGroup2.getContext());
                    view.setBackgroundColor(viewGroup2.getContext().getResources().getColor(R.e.bsr));
                    viewGroup2.addView(view, new LayoutParams(-1, com.tencent.mm.bv.a.fromDPToPix(viewGroup2.getContext(), 5)));
                }
            }
            if (gameCenterUI5.nmv) {
                gameCenterUI5.nnp.aRH();
            }
            ViewGroup viewGroup3 = gameCenterUI5.nnq;
            aj.a aVar2 = ajVar.ndO;
            i4 = gameCenterUI5.ndn;
            if (aVar2 == null) {
                viewGroup3.setVisibility(8);
            } else {
                viewGroup3.nlW.qO(i4);
                viewGroup3.setVisibility(0);
                viewGroup3.muI.removeAllViews();
                if (aVar2.ndK == null || bh.ov(aVar2.ndK.field_appId) || bh.ov(aVar2.ndK.field_appName)) {
                    viewGroup3.setVisibility(8);
                } else {
                    View findViewById;
                    if (i == 2) {
                        ap.a(viewGroup3.getContext(), 10, 1002, 0, aVar2.ndK.field_appId, i4, null);
                    }
                    d dVar = aVar2.ndK;
                    GameBlockView.a aVar3 = new GameBlockView.a((byte) 0);
                    View inflate = viewGroup3.DF.inflate(R.i.djA, viewGroup3.muI, false);
                    aVar3.nlZ = (ViewGroup) inflate.findViewById(R.h.cuR);
                    aVar3.nlL = (ImageView) inflate.findViewById(R.h.cml);
                    aVar3.nlM = (TextView) inflate.findViewById(R.h.cmV);
                    aVar3.nma = (TextView) inflate.findViewById(R.h.ckT);
                    aVar3.nmb = (GameDownloadView) inflate.findViewById(R.h.clY);
                    com.tencent.mm.plugin.game.d.e.aRV().a(aVar3.nlL, dVar.field_appId, com.tencent.mm.bv.a.getDensity(viewGroup3.getContext()));
                    CharSequence charSequence = dVar.field_appName;
                    if (!bh.ov(dVar.field_appName) && dVar.field_appName.length() > 8) {
                        charSequence = dVar.field_appName.substring(0, 7) + "...";
                    }
                    aVar3.nlM.setText(charSequence);
                    if (bh.ov(dVar.naQ)) {
                        aVar3.nma.setVisibility(8);
                    } else {
                        aVar3.nma.setText(dVar.naQ);
                        aVar3.nma.setVisibility(0);
                    }
                    aVar3.nmb.a(new o(dVar));
                    aVar3.nlZ.setOnClickListener(viewGroup3.nlW);
                    aVar3.nlZ.setTag(dVar);
                    viewGroup3.muI.addView(inflate);
                    view = new g(viewGroup3.getContext());
                    view.a(aVar2.ndT, aVar2.ndK.field_appId, i, i4);
                    viewGroup3.muI.addView(view, viewGroup3.nlV);
                    view = new f(viewGroup3.getContext());
                    view.a(aVar2.ndS, aVar2.ndK.field_appId, i, i4);
                    viewGroup3.muI.addView(view, viewGroup3.nlV);
                    if (aVar2.ndU != null) {
                        imageView = (ImageView) viewGroup3.DF.inflate(R.i.dkf, viewGroup3, false);
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                        marginLayoutParams.leftMargin = com.tencent.mm.bv.a.fromDPToPix(viewGroup3.getContext(), 20);
                        imageView.setLayoutParams(marginLayoutParams);
                        viewGroup3.addView(imageView);
                        viewGroup3.DF.inflate(R.i.djB, viewGroup3, true);
                        findViewById = viewGroup3.findViewById(R.h.cxr);
                        ((TextView) viewGroup3.findViewById(R.h.cxs)).setText(aVar2.ndU.nfe);
                        findViewById.setTag(aVar2.ndU.nfg);
                        findViewById.setOnClickListener(new GameBlockView$1(viewGroup3, i4));
                    }
                    ViewGroup viewGroup4 = viewGroup3.muI;
                    findViewById = new View(viewGroup3.getContext());
                    findViewById.setBackgroundColor(viewGroup3.getContext().getResources().getColor(R.e.bsr));
                    viewGroup4.addView(findViewById, new LayoutParams(-1, com.tencent.mm.bv.a.fromDPToPix(viewGroup3.getContext(), 5)));
                }
            }
            GameRecomBlockView gameRecomBlockView = gameCenterUI5.nnr;
            ak akVar = ajVar.ndP;
            int i8 = gameCenterUI5.ndn;
            if (akVar == null) {
                gameRecomBlockView.setVisibility(8);
            } else {
                gameRecomBlockView.ndn = i8;
                gameRecomBlockView.setVisibility(0);
                gameRecomBlockView.a(akVar, i, i8);
            }
            gameCenterUI5.nns.a(ajVar.ndQ, i, gameCenterUI5.ndn);
            gameCenterUI5.nnt.setVisibility(0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.tencent.mm.z.ar.Hj()) {
            GameIndexListView.qO(this.ndn);
            com.tencent.mm.z.ar.CG().a(2994, this);
            initView();
            c.Dm().F(new Runnable(this) {
                final /* synthetic */ GameCenterUI5 nnu;

                {
                    this.nnu = r1;
                }

                public final void run() {
                    byte[] BX = SubCoreGameCenter.aRh().BX("pb_index_4");
                    if (BX == null) {
                        ag.y(new 1(this));
                    } else {
                        ag.y(new 2(this, new aj(BX)));
                    }
                    SubCoreGameCenter.aRj().init(this.nnu);
                    c.T(g.aPX());
                    com.tencent.mm.z.ar.CG().a(new ba(w.cfi(), g.aPX(), this.nnu.nmw, this.nnu.nmx, this.nnu.nmy, this.nnu.nmv), 0);
                    g.cL(this.nnu.mController.xIM);
                    g.aPZ();
                    com.tencent.mm.plugin.game.d.a.a.aRT().aRR();
                }
            });
            x.i("MicroMsg.GameCenterUI5", "fromScene = %d", new Object[]{Integer.valueOf(this.ndn)});
            return;
        }
        x.e("MicroMsg.GameCenterUI5", "account not ready");
        finish();
    }

    public void onResume() {
        super.onResume();
        if (com.tencent.mm.z.ar.Hj()) {
            if (!this.nnc) {
                SubCoreGameCenter.aRj().init(this);
                this.nnp.aRI();
                if (this.nmv) {
                    this.nnp.aRH();
                }
            }
            this.nnc = false;
            return;
        }
        x.e("MicroMsg.GameCenterUI5", "account not ready");
    }

    public void onDestroy() {
        x.i("MicroMsg.GameCenterUI5", "onDestroy");
        super.onDestroy();
        if (com.tencent.mm.z.ar.Hj()) {
            com.tencent.mm.plugin.game.d.a.a.aRT().clearCache();
            com.tencent.mm.z.ar.CG().b(2994, this);
            SubCoreGameCenter.aRj().clearCache();
            bj.aRa();
            return;
        }
        x.e("MicroMsg.GameCenterUI5", "account not ready");
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        setMMTitle(R.l.enh);
        this.nnt = (GameIndexListView) findViewById(R.h.cmc);
        this.nnt.setVisibility(8);
        View inflate = getLayoutInflater().inflate(R.i.dky, this.nnt, false);
        this.nnt.addHeaderView(inflate);
        this.nnm = (GameNewTopBannerView) inflate.findViewById(R.h.cnq);
        this.nnn = (GameIndexSearchView) inflate.findViewById(R.h.cmn);
        this.nno = (GameIndexWxagView) inflate.findViewById(R.h.cmo);
        this.nnp = (GameMessageBubbleView) inflate.findViewById(R.h.cmQ);
        this.nnq = (GameBlockView) inflate.findViewById(R.h.ckH);
        this.nnr = (GameRecomBlockView) inflate.findViewById(R.h.cne);
        this.nns = (GameNewClassifyView) inflate.findViewById(R.h.cmW);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.hashCode())});
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 2994:
                    long currentTimeMillis = System.currentTimeMillis();
                    c.Dm().F(new 2(this, ((ba) kVar).lMW.hmh.hmo, currentTimeMillis));
                    return;
                default:
                    return;
            }
        }
        if (!com.tencent.mm.plugin.game.a.a.ift.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.emx, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lNB != null) {
            this.lNB.cancel();
        }
    }

    protected final int getLayoutId() {
        return R.i.djE;
    }
}
