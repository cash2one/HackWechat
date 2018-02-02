package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.game.c.ao;
import com.tencent.mm.plugin.game.c.bj;
import com.tencent.mm.plugin.game.c.cp;
import com.tencent.mm.plugin.game.c.cw;
import com.tencent.mm.plugin.game.c.dr;
import com.tencent.mm.plugin.game.c.q;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.az;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.ui.n.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Map;

public class GameCenterUI2 extends GameCenterActivity implements e {
    private Dialog lNB;
    private bj ndD;
    private int ndn = 0;
    l nlW = new l();
    private GameCenterListView nmM;
    private h nmN;
    private GameTopBannerView nmO;
    private GameInfoView nmP;
    private GameInfoViewForeign nmQ;
    private GameMessageBubbleView nmR;
    private GameCommonRecommendView nmS;
    private MyGameInfoView nmT;
    private GameInstalledView nmU;
    private GameClassifyView nmV;
    private View nmW;
    private TextView nmX;
    private View nmY;
    private TextView nmZ;
    private a nmi = new 6(this);
    private boolean nmv = false;
    private t nmw;
    private t nmx;
    private t nmy;
    private boolean nmz = false;
    private ImageView nna;
    private View nnb;
    private boolean nnc = true;
    private boolean nnd;
    private String nne = "";
    private OnClickListener nnf = new OnClickListener(this) {
        final /* synthetic */ GameCenterUI2 nnh;

        {
            this.nnh = r1;
        }

        public final void onClick(View view) {
            int p;
            b.a aPQ = b.aPQ();
            if (aPQ.fDt == 2) {
                p = c.p(this.nnh.mController.xIM, aPQ.url, "game_center_library");
            } else {
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String) || bh.ov((String) tag)) {
                    Intent intent = new Intent(this.nnh, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1005);
                    this.nnh.startActivity(intent);
                    p = 6;
                } else {
                    p = c.p(this.nnh, (String) tag, "game_center_library");
                }
            }
            ap.a(this.nnh.mController.xIM, 10, 1005, 1, p, this.nnh.ndn, null);
        }
    };
    private OnClickListener nng = new 5(this);

    static /* synthetic */ void a(GameCenterUI2 gameCenterUI2) {
        if (gameCenterUI2.nmv) {
            SubCoreGameCenter.aRe();
            gameCenterUI2.nmw = w.aQn();
            if (gameCenterUI2.nmw != null) {
                gameCenterUI2.nmw.aQm();
            }
            SubCoreGameCenter.aRe();
            gameCenterUI2.nmx = w.aQp();
            if (gameCenterUI2.nmx != null) {
                gameCenterUI2.nmx.aQm();
            }
        }
        SubCoreGameCenter.aRe();
        gameCenterUI2.nmy = w.aQr();
        if (gameCenterUI2.nmy != null) {
            gameCenterUI2.nmy.aQm();
        }
    }

    static /* synthetic */ void a(GameCenterUI2 gameCenterUI2, ai aiVar, int i) {
        if (gameCenterUI2.isFinishing()) {
            x.w("MicroMsg.GameCenterUI2", "GameCenterUI2 hasFinished");
        } else if (aiVar == null) {
            x.e("MicroMsg.GameCenterUI2", "Null data");
        } else {
            q qVar = aiVar.ndD != null ? aiVar.ndD.nip : null;
            if (qVar != null) {
                if (gameCenterUI2.nnb instanceof ViewStub) {
                    gameCenterUI2.nnb = ((ViewStub) gameCenterUI2.nnb).inflate();
                }
                gameCenterUI2.nnb.setVisibility(0);
                TextView textView = (TextView) gameCenterUI2.nnb.findViewById(R.h.cuM);
                TextView textView2 = (TextView) gameCenterUI2.nnb.findViewById(R.h.cKq);
                TextView textView3 = (TextView) gameCenterUI2.nnb.findViewById(R.h.cKj);
                if (bh.ov(qVar.ngc)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(qVar.ngc);
                    textView.setVisibility(0);
                }
                if (bh.ov(qVar.ngd)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(qVar.ngd);
                    textView2.setVisibility(0);
                }
                if (bh.ov(qVar.nge)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(qVar.nge);
                    textView3.setVisibility(0);
                }
                gameCenterUI2.a(aiVar);
                gameCenterUI2.nmM.setVisibility(8);
            } else {
                com.tencent.mm.plugin.game.c.t tVar;
                if (!(gameCenterUI2.nnb instanceof ViewStub)) {
                    gameCenterUI2.nnb.setVisibility(8);
                    gameCenterUI2.nmM.setVisibility(0);
                }
                gameCenterUI2.a(aiVar);
                gameCenterUI2.nmO.ndn = gameCenterUI2.ndn;
                GameTopBannerView gameTopBannerView = gameCenterUI2.nmO;
                cp aQM = aiVar.aQM();
                boolean z = gameCenterUI2.nmz;
                if (aQM == null || aQM.njn == null || bh.ov(aQM.njn.ngr)) {
                    gameTopBannerView.setVisibility(8);
                } else {
                    gameTopBannerView.jcA = aQM.njm != null ? ap.BY(aQM.njm.nfK) : null;
                    if (!gameTopBannerView.ntO.equals(aQM.njn.ngr)) {
                        gameTopBannerView.ntO = aQM.njn.ngr;
                        com.tencent.mm.plugin.game.d.e.aRV().h(gameTopBannerView.nmK, aQM.njn.ngr);
                        gameTopBannerView.ntM = gameTopBannerView.b(gameTopBannerView.nmK, gameTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvq), gameTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvp));
                        if (gameTopBannerView.ntM > 0) {
                            if (i == 2) {
                                ap.a(gameTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameTopBannerView.ndn, 0, null, null, gameTopBannerView.jcA);
                            }
                            if (gameTopBannerView.ntM <= 0 || aQM.njm == null || bh.ov(aQM.njm.nff)) {
                                gameTopBannerView.nmJ.setVisibility(8);
                            } else {
                                com.tencent.mm.plugin.game.d.e.aRV().h(gameTopBannerView.nmJ, aQM.njm.nff);
                                gameTopBannerView.ntN = gameTopBannerView.b(gameTopBannerView.nmJ, gameTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvn), gameTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvp));
                                if (gameTopBannerView.ntN > 0) {
                                    gameTopBannerView.nmJ.setVisibility(0);
                                    gameTopBannerView.nmJ.setTag(aQM.njm.nfg);
                                    gameTopBannerView.nmJ.setOnClickListener(gameTopBannerView);
                                } else {
                                    gameTopBannerView.nmJ.setVisibility(8);
                                }
                            }
                            if (gameTopBannerView.nmJ.getVisibility() == 0) {
                                if (aQM.njm.nkn == g.cN(gameTopBannerView.mContext) || z) {
                                    ((ViewGroup) gameTopBannerView.getParent()).setPadding(0, gameTopBannerView.ntM - gameTopBannerView.ntN, 0, 0);
                                } else {
                                    gameTopBannerView.nmK.setAlpha(0);
                                    gameTopBannerView.nmJ.setClickable(true);
                                    g.D(gameTopBannerView.mContext, aQM.njm.nkn);
                                }
                                GameCenterListView.fG(true);
                                GameCenterListView.qS(gameTopBannerView.ntM - gameTopBannerView.ntN);
                            } else {
                                GameCenterListView.fG(false);
                            }
                            gameTopBannerView.setVisibility(0);
                        } else {
                            gameTopBannerView.setVisibility(8);
                        }
                    } else if (i == 2) {
                        ap.a(gameTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameTopBannerView.ndn, 0, null, null, gameTopBannerView.jcA);
                    }
                }
                if (aiVar.ndD != null ? aiVar.ndD.nit : false) {
                    gameCenterUI2.nmQ.ndn = gameCenterUI2.ndn;
                    gameCenterUI2.nmQ.setVisibility(0);
                    gameCenterUI2.nmP.setVisibility(8);
                } else {
                    gameCenterUI2.nmQ.setVisibility(8);
                    gameCenterUI2.nmP.ndn = gameCenterUI2.ndn;
                    gameCenterUI2.nmP.nrE = bh.az(gameCenterUI2.nne, "");
                    GameInfoView gameInfoView = gameCenterUI2.nmP;
                    ao aoVar = aiVar.ndD != null ? aiVar.ndD.nig : null;
                    if (aoVar == null) {
                        x.e("MicroMsg.GameInfoView", "Null data");
                        gameInfoView.setVisibility(8);
                    } else {
                        gameInfoView.setVisibility(0);
                        ((ViewGroup) gameInfoView.getParent()).setPadding(0, 0, 0, 0);
                        if (aoVar.nhc == null) {
                            x.e("MicroMsg.GameInfoView", "MyProfile is null, use default data");
                            CharSequence FS = com.tencent.mm.z.q.FS();
                            CharSequence FT = com.tencent.mm.z.q.FT();
                            com.tencent.mm.plugin.game.d.e.aRV().j(gameInfoView.nrx, FS);
                            if (bh.ov(FT)) {
                                gameInfoView.nry.setText(FS);
                            } else {
                                gameInfoView.nry.setText(FT);
                            }
                            gameInfoView.nrw.setEnabled(false);
                        } else {
                            if (bh.ov(aoVar.nhc.nfT)) {
                                com.tencent.mm.plugin.game.d.e.aRV().j(gameInfoView.nrx, com.tencent.mm.z.q.FS());
                            } else {
                                com.tencent.mm.plugin.game.d.e.a.a aVar = new com.tencent.mm.plugin.game.d.e.a.a();
                                aVar.hDY = true;
                                com.tencent.mm.plugin.game.d.e.aRV().a(gameInfoView.nrx, aoVar.nhc.nfT, aVar.aRW());
                            }
                            gameInfoView.nry.setText(aoVar.nhc.fon);
                            Map hashMap = new HashMap();
                            if (bh.ov(aoVar.nhc.njg)) {
                                gameInfoView.nrz.setVisibility(8);
                                hashMap.put("badge_icon", "0");
                            } else {
                                com.tencent.mm.plugin.game.d.e.aRV().h(gameInfoView.nrz, aoVar.nhc.njg);
                                gameInfoView.nrz.setVisibility(0);
                                hashMap.put("badge_icon", "1");
                            }
                            gameInfoView.nrJ = ap.A(hashMap);
                            gameInfoView.nrw.setEnabled(true);
                            gameInfoView.nrw.setTag(aoVar.nhc.nfg);
                            gameInfoView.nrw.setVisibility(0);
                            if (i == 2) {
                                ap.a(gameInfoView.mContext, 10, 1001, gameInfoView.nrI, null, gameInfoView.ndn, gameInfoView.nrJ);
                            }
                        }
                        if (aoVar.nhd == null || bh.ov(aoVar.nhd.nfT)) {
                            gameInfoView.nrp.setVisibility(8);
                        } else if (!gameInfoView.nrC.equals(aoVar.nhd.nfT)) {
                            gameInfoView.nrC = aoVar.nhd.nfT;
                            gameInfoView.nrp.setVisibility(0);
                            com.tencent.mm.plugin.game.d.e.aRV().h(gameInfoView.nrq, aoVar.nhd.nfT);
                            gameInfoView.nrp.setTag(aoVar.nhd.nfg);
                            gameInfoView.aRC();
                        }
                        if (aoVar.nhe == null || bh.ov(aoVar.nhe.nfT)) {
                            gameInfoView.nrs.setVisibility(8);
                        } else if (!gameInfoView.nrB.equals(aoVar.nhe.nfT)) {
                            gameInfoView.nrB = aoVar.nhe.nfT;
                            gameInfoView.nrs.setVisibility(0);
                            com.tencent.mm.plugin.game.d.e.aRV().h(gameInfoView.nrt, aoVar.nhe.nfT);
                            gameInfoView.nrs.setTag(aoVar.nhe.nfg);
                            SubCoreGameCenter.aRe();
                            if (w.aQt() != null) {
                                gameInfoView.nru.setVisibility(0);
                            } else {
                                gameInfoView.nru.setVisibility(8);
                            }
                        }
                        if (aoVar.nhf == null || bh.ov(aoVar.nhf.nfT)) {
                            gameInfoView.nrv.setVisibility(8);
                            gameInfoView.nrD.setVisibility(8);
                        } else if (!gameInfoView.nrA.equals(aoVar.nhf.nfT)) {
                            gameInfoView.nrA = aoVar.nhf.nfT;
                            gameInfoView.nrv.setVisibility(0);
                            com.tencent.mm.plugin.game.d.e.aRV().h(gameInfoView.nrv, aoVar.nhf.nfT);
                            gameInfoView.nrv.setTag(aoVar.nhf.nfg);
                            gameInfoView.nrD.setVisibility(0);
                        }
                    }
                }
                gameCenterUI2.nmT.a(aiVar.ndH, gameCenterUI2.ndn, i);
                GameCommonRecommendView gameCommonRecommendView = gameCenterUI2.nmS;
                dr drVar = aiVar.ndD != null ? aiVar.ndD.nij : null;
                int i2 = gameCenterUI2.ndn;
                if (drVar == null || drVar.nkc == null || drVar.nkd == null || drVar.nke == null) {
                    gameCommonRecommendView.setVisibility(8);
                } else {
                    gameCommonRecommendView.setVisibility(0);
                    gameCommonRecommendView.ndn = i2;
                    gameCommonRecommendView.nnA = i;
                    gameCommonRecommendView.a(drVar);
                }
                gameCenterUI2.nmU.ndn = gameCenterUI2.ndn;
                GameInstalledView.B(aiVar.ndG);
                GameInstalledView gameInstalledView = gameCenterUI2.nmU;
                GameInstalledView.a aVar2 = new GameInstalledView.a();
                if (!(aiVar.ndD.nim == null || aiVar.ndD.nim.njq == null)) {
                    aVar2.iconUrl = aiVar.ndD.nim.njq.nfo;
                    aVar2.title = aiVar.ndD.nim.njq.fon;
                    aVar2.jeE = aiVar.ndD.nim.njq.nfj;
                }
                gameInstalledView.nrX = aVar2;
                gameCenterUI2.nmU.nrY = aiVar.aQO();
                gameCenterUI2.nmU.eJ(true);
                gameCenterUI2.nmV.a(aiVar.ndD != null ? aiVar.ndD.nik : null, i, gameCenterUI2.ndn);
                if (gameCenterUI2.nmv) {
                    gameCenterUI2.nmR.aRH();
                }
                cw cwVar = aiVar.ndD != null ? aiVar.ndD.nio : null;
                if (cwVar == null || bh.ov(cwVar.nfe) || bh.ov(cwVar.nfg)) {
                    gameCenterUI2.nmW.setVisibility(8);
                } else {
                    gameCenterUI2.nmW.setVisibility(0);
                    gameCenterUI2.nmX.setText(cwVar.nfe);
                    gameCenterUI2.nmW.setTag(cwVar.nfg);
                    gameCenterUI2.nmW.setOnClickListener(gameCenterUI2.nnf);
                }
                if (!(aiVar.aQM() == null || aiVar.aQM().njo == null || bh.ov(aiVar.aQM().njo.ngr))) {
                    com.tencent.mm.plugin.game.d.e.aRV().h(gameCenterUI2.nna, aiVar.aQM().njo.ngr);
                    LayoutParams layoutParams = gameCenterUI2.nna.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = (int) (((float) c.getScreenWidth(gameCenterUI2)) * (((float) gameCenterUI2.getResources().getDimensionPixelSize(R.f.bvo)) / ((float) gameCenterUI2.getResources().getDimensionPixelSize(R.f.bvp))));
                        gameCenterUI2.nna.setLayoutParams(layoutParams);
                        gameCenterUI2.nna.setVisibility(0);
                        if (gameCenterUI2.nna.getVisibility() != 8) {
                            tVar = aiVar.ndD == null ? aiVar.ndD.niq : null;
                            if (tVar != null || bh.ov(tVar.fon) || bh.ov(tVar.nfj)) {
                                gameCenterUI2.nmY.setVisibility(8);
                            } else {
                                gameCenterUI2.nmY.setVisibility(0);
                                gameCenterUI2.nmZ.setText(tVar.fon);
                                gameCenterUI2.nmZ.setTag(tVar.nfj);
                            }
                        } else {
                            gameCenterUI2.nmY.setVisibility(8);
                        }
                        gameCenterUI2.nmN.qR(i);
                        gameCenterUI2.nmN.P(aiVar.ndF);
                    } else {
                        x.i("MicroMsg.GameCenterUI2", "mGameFooterImg, params is null");
                    }
                }
                gameCenterUI2.nna.setVisibility(8);
                if (gameCenterUI2.nna.getVisibility() != 8) {
                    gameCenterUI2.nmY.setVisibility(8);
                } else {
                    if (aiVar.ndD == null) {
                    }
                    if (tVar != null) {
                    }
                    gameCenterUI2.nmY.setVisibility(8);
                }
                gameCenterUI2.nmN.qR(i);
                gameCenterUI2.nmN.P(aiVar.ndF);
            }
            if (i == 2) {
                c.Dm().F(new 9(gameCenterUI2));
            }
        }
    }

    static /* synthetic */ void c(GameCenterUI2 gameCenterUI2) {
        int i = gameCenterUI2.getIntent().getBooleanExtra("game_force_native_index", false) ? 32 : 6;
        if (gameCenterUI2.nmw == null || gameCenterUI2.nmw.field_isHidden) {
            ap.a(gameCenterUI2, 9, 901, 1, i, 0, ap.cL("resource", "0"));
            return;
        }
        int i2 = gameCenterUI2.nmw.field_msgType;
        if (gameCenterUI2.nmw.field_msgType == 100) {
            i2 = gameCenterUI2.nmw.ncS;
        }
        ap.a(gameCenterUI2, 9, 901, 1, i, 0, gameCenterUI2.nmw.field_appId, 0, i2, gameCenterUI2.nmw.field_gameMsgId, gameCenterUI2.nmw.ncT, ap.cL("resource", String.valueOf(gameCenterUI2.nmw.ncl.nda)));
    }

    static /* synthetic */ void d(GameCenterUI2 gameCenterUI2) {
        if (gameCenterUI2.nmx != null && !gameCenterUI2.nmx.field_isHidden && !bh.ov(gameCenterUI2.nmx.ncA.url)) {
            gameCenterUI2.nmz = true;
            t tVar = gameCenterUI2.nmx;
            c.a(gameCenterUI2.getBaseContext(), tVar, "game_center_h5_floatlayer");
            int i = tVar.field_msgType;
            if (tVar.field_msgType == 100) {
                i = tVar.ncS;
            }
            ap.a(gameCenterUI2, 10, 1006, 1, 1, 0, tVar.field_appId, 0, i, tVar.field_gameMsgId, tVar.ncT, null);
            gameCenterUI2.nmx.field_isRead = true;
            SubCoreGameCenter.aRd().c(gameCenterUI2.nmx, new String[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        if (ar.Hj()) {
            this.ndn = getIntent().getIntExtra("game_report_from_scene", 0);
            this.nmv = getIntent().getBooleanExtra("from_find_more_friend", false);
            c.Dm().F(new 1(this));
            ar.CG().a(1238, this);
            initView();
            c.Dm().F(new 7(this));
            ap.a(this, 10, 1000, 0, 1, 0, null, this.ndn, 0, null, null, null);
            x.i("MicroMsg.GameCenterUI2", "[onCreate] time:" + (System.currentTimeMillis() - currentTimeMillis));
            x.i("MicroMsg.GameCenterUI2", "fromScene = %d", new Object[]{Integer.valueOf(this.ndn)});
            return;
        }
        x.e("MicroMsg.GameCenterUI2", "account not ready");
        finish();
    }

    protected void onResume() {
        super.onResume();
        if (ar.Hj()) {
            if (!this.nnc) {
                if (this.nmP.getVisibility() == 0) {
                    this.nmP.aRC();
                } else if (this.nmQ.getVisibility() == 0) {
                    this.nmQ.aRC();
                }
                SubCoreGameCenter.aRj().init(this);
                this.nmU.eJ(false);
                this.nmN.refresh();
                if (this.nmT != null) {
                    MyGameInfoView myGameInfoView = this.nmT;
                    String[] strArr = new String[MyGameInfoView.nwi.keySet().size()];
                    MyGameInfoView.nwi.keySet().toArray(strArr);
                    for (Object obj : strArr) {
                        View view = (View) MyGameInfoView.nwi.get(obj);
                        if (view != null) {
                            MyGameInfoView.a aVar = (MyGameInfoView.a) view.getTag();
                            o oVar = (o) myGameInfoView.nwh.get(obj);
                            if (!(oVar == null || oVar.nbT == null)) {
                                myGameInfoView.noI.a(aVar.nsP, aVar.nsO, oVar.nbT, (o) myGameInfoView.nwh.get(oVar.nbT.field_appId));
                            }
                        }
                    }
                }
                this.nmR.aRI();
                if (this.nmv) {
                    this.nmR.aRH();
                }
                if (com.tencent.mm.plugin.game.d.a.a.aRT().nwU) {
                    com.tencent.mm.plugin.game.d.a.a.aRT().nwU = false;
                    c.Dm().F(new 8(this));
                }
            }
            this.nnc = false;
            return;
        }
        x.e("MicroMsg.GameCenterUI2", "account not ready");
    }

    private void goBack() {
        String stringExtra = getIntent().getStringExtra("jump_find_more_friends");
        if (!bh.ov(stringExtra) && stringExtra.equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.a((Context) this, ".ui.LauncherUI", intent);
        }
        finish();
    }

    protected void onDestroy() {
        x.i("MicroMsg.GameCenterUI2", "onDestroy");
        super.onDestroy();
        if (ar.Hj()) {
            if (this.nmN != null) {
                this.nmN.clear();
            }
            if (this.nmU != null) {
                GameInstalledView gameInstalledView = this.nmU;
                if (gameInstalledView.ndF != null) {
                    gameInstalledView.ndF.clear();
                }
                if (gameInstalledView.noH != null) {
                    n.b(gameInstalledView.noH);
                }
            }
            if (this.nmT != null) {
                MyGameInfoView myGameInfoView = this.nmT;
                if (myGameInfoView.noH != null) {
                    n.b(myGameInfoView.noH);
                }
                if (MyGameInfoView.nwi != null) {
                    MyGameInfoView.nwi.clear();
                }
            }
            com.tencent.mm.plugin.game.d.a.a.aRT().clearCache();
            ar.CG().b(1238, this);
            SubCoreGameCenter.aRj().clearCache();
            com.tencent.mm.plugin.game.model.bj.aRa();
            return;
        }
        x.e("MicroMsg.GameCenterUI2", "account not ready");
    }

    protected final int getLayoutId() {
        return R.i.djJ;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        setBackBtn(new 3(this));
        setMMTitle(R.l.enh);
        this.nmM = (GameCenterListView) findViewById(R.h.ckO);
        this.nmM.setOnItemClickListener(this.nlW);
        this.nlW.qO(this.ndn);
        this.nmN = new h(this);
        this.nmN.qO(this.ndn);
        this.nmN.a(this.nmi);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.xIM.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.i.dlp, this.nmM, false);
        this.nmO = (GameTopBannerView) inflate.findViewById(R.h.cSB);
        this.nmM.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.djM, this.nmM, false);
        this.nmQ = (GameInfoViewForeign) inflate.findViewById(R.h.ckM);
        this.nmM.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.djL, this.nmM, false);
        this.nmP = (GameInfoView) inflate.findViewById(R.h.ckL);
        this.nmM.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.djH, this.nmM, false);
        this.nmR = (GameMessageBubbleView) inflate.findViewById(R.h.cmQ);
        this.nmM.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.djP, this.nmM, false);
        this.nmT = (MyGameInfoView) inflate.findViewById(R.h.cyv);
        this.nmM.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.ckK, this.nmM, false);
        this.nmS = (GameCommonRecommendView) inflate.findViewById(R.h.ckK);
        this.nmM.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.djN, this.nmM, false);
        this.nmU = (GameInstalledView) inflate.findViewById(R.h.cmq);
        this.nmM.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.djQ, this.nmM, false);
        this.nmV = (GameClassifyView) inflate.findViewById(R.h.ckR);
        this.nmM.addHeaderView(inflate);
        View inflate2 = layoutInflater.inflate(R.i.djK, this.nmM, false);
        this.nmM.addFooterView(inflate2);
        this.nmW = inflate2.findViewById(R.h.cmi);
        this.nmW.setOnClickListener(this.nnf);
        this.nmX = (TextView) inflate2.findViewById(R.h.cmj);
        inflate2 = layoutInflater.inflate(R.i.djI, null);
        this.nmM.addFooterView(inflate2);
        this.nmY = inflate2.findViewById(R.h.chz);
        this.nmZ = (TextView) inflate2.findViewById(R.h.chA);
        this.nmZ.setOnClickListener(this.nng);
        View inflate3 = layoutInflater.inflate(R.i.dkx, this.nmM, false);
        this.nmM.addFooterView(inflate3);
        this.nna = (ImageView) inflate3.findViewById(R.h.cmm);
        this.nmM.setAdapter(this.nmN);
        this.nnb = findViewById(R.h.cnL);
    }

    private void a(ai aiVar) {
        if (aiVar == null || aiVar.aQL() == null) {
            this.nne = "";
        } else {
            this.nne = aiVar.aQL().nfg;
        }
        if (bh.ov(this.nne)) {
            if (this.nnd) {
                removeOptionMenu(0);
                this.nnd = false;
            }
        } else if (!this.nnd) {
            addIconOptionMenu(0, R.k.dvc, new 10(this));
            this.nnd = true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GameCenterUI2", "errType: %d errCode: %d, scene: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.hashCode())});
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 1238:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final com.tencent.mm.bq.a aVar = ((az) kVar).lMW.hmh.hmo;
                    c.Dm().F(new Runnable(this) {
                        final /* synthetic */ GameCenterUI2 nnh;

                        public final void run() {
                            if (aVar == null) {
                                this.nnh.ndD = new bj();
                            } else {
                                this.nnh.ndD = (bj) aVar;
                            }
                            ag.y(new 1(this, new ai(aVar)));
                        }
                    });
                    return;
                default:
                    return;
            }
        }
        if (!com.tencent.mm.plugin.game.a.a.ift.a(this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.emx, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lNB != null) {
            this.lNB.cancel();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.GameCenterUI2", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final int aRr() {
        return 10;
    }

    public final int aRs() {
        return 1000;
    }

    public final int aRt() {
        return this.ndn;
    }
}
