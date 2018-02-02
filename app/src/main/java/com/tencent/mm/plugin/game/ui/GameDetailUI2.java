package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.a.a;
import com.tencent.mm.g.a.or;
import com.tencent.mm.plugin.game.c.cf;
import com.tencent.mm.plugin.game.c.dt;
import com.tencent.mm.plugin.game.c.y;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.ui.k$a.1;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2 extends MMActivity implements e {
    private String appId = null;
    private Dialog lNB;
    private d nbT = null;
    private int ndn = 0;
    private String noA = null;
    private String noB = null;
    private int noD = 18;
    private boolean noE;
    private boolean noF;
    private String noG = null;
    private b noH = null;
    private e noI = null;
    private o noJ = null;
    private ViewGroup noK;
    private ImageView noL;
    private ImageView noM;
    private TextView noN;
    private Button noO;
    private TextProgressBar noP;
    private TextView noQ;
    private LinearLayout noR;
    private GameDetailAutoScrollView noS;
    private LinearLayout noT;
    private TextView noU;
    private LinearLayout noV;
    private TextView noW;
    private LinearLayout noX;
    private ImageView noY;
    private View noZ;
    private TextView npa;
    private TextView npb;
    private View npc;
    private TextView npd;
    private ImageView npe;
    private TextView npf;
    private TextView npg;
    private LinearLayout nph;
    private GameMediaList npi;
    private TextView npj;
    private TextView npk;
    private TextView npl;
    private boolean npm = false;
    private LinearLayout npn;
    private TextView npo;
    private LinearLayout npp;
    private TextView npq;
    private dt npr;
    private OnClickListener nps = new 15(this);
    private View.OnClickListener npt = new 16(this);
    private View.OnClickListener npu = new 17(this);
    private View.OnClickListener npv = new 2(this);
    private View.OnClickListener npw = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 npz;

        {
            this.npz = r1;
        }

        public final void onClick(View view) {
            c.a(view, this.npz);
            ap.a(this.npz.mController.xIM, 12, 1205, 1, 7, this.npz.appId, this.npz.ndn, null);
        }
    };
    private View.OnClickListener npx = new 4(this);
    private View.OnClickListener npy = new 5(this);

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, dt dtVar) {
        g gVar = new g(gameDetailUI2.mController.xIM, g.ztp, false);
        gVar.rKC = new 7(gameDetailUI2, dtVar);
        gVar.rKD = new p.d(gameDetailUI2) {
            final /* synthetic */ GameDetailUI2 npz;

            {
                this.npz = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        GameDetailUI2.p(this.npz);
                        return;
                    case 1:
                        GameDetailUI2.q(this.npz);
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUk();
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, af afVar) {
        if (gameDetailUI2.isFinishing()) {
            x.w("MicroMsg.GameDetailUI2", "GameDetailUI2 hasFinished");
        } else if (afVar == null) {
            x.e("MicroMsg.GameDetailUI2", "Null data");
        } else {
            gameDetailUI2.nbT = afVar.ndv;
            String str = afVar.ndt.nhX == null ? null : bh.ov(afVar.ndt.nhX.njT) ? null : afVar.ndt.nhX.njT;
            gameDetailUI2.noA = str;
            str = afVar.ndt.nhX == null ? null : bh.ov(afVar.ndt.nhX.njU) ? null : afVar.ndt.nhX.njU;
            gameDetailUI2.noB = str;
            if (!gameDetailUI2.noF) {
                gameDetailUI2.noF = true;
                ap.a(gameDetailUI2, 12, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 0, 1, gameDetailUI2.appId, gameDetailUI2.ndn, null);
            }
            d dVar = afVar.ndv;
            a PA = com.tencent.mm.aq.o.PA();
            String str2 = afVar.ndt.nhS;
            ImageView imageView = gameDetailUI2.noL;
            com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
            aVar.hDz = true;
            PA.a(str2, imageView, aVar.PK());
            ImageView imageView2 = gameDetailUI2.noM;
            str2 = gameDetailUI2.appId;
            float density = com.tencent.mm.bv.a.getDensity(gameDetailUI2);
            if (!(imageView2 == null || bh.ov(str2))) {
                Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str2, 1, density);
                if (b == null || b.isRecycled()) {
                    imageView2.setImageResource(R.g.bCC);
                    an.bin().c(new 1(str2, density, imageView2));
                } else {
                    imageView2.setImageBitmap(b);
                }
            }
            gameDetailUI2.noN.setText(dVar != null ? dVar.field_appName : "");
            if (dVar == null || bh.ov(dVar.naP)) {
                gameDetailUI2.noQ.setVisibility(8);
            } else {
                gameDetailUI2.noQ.setText(dVar.naP);
                gameDetailUI2.noQ.setVisibility(0);
            }
            if (gameDetailUI2.nbT == null) {
                gameDetailUI2.noO.setVisibility(8);
            } else {
                gameDetailUI2.noO.setVisibility(0);
                if (gameDetailUI2.noI == null) {
                    gameDetailUI2.noI = new e(gameDetailUI2);
                    gameDetailUI2.noI.nlx = gameDetailUI2.nps;
                    gameDetailUI2.noI.ndn = gameDetailUI2.ndn;
                    gameDetailUI2.noI.nlh = gameDetailUI2.noG;
                }
                gameDetailUI2.noO.setOnClickListener(gameDetailUI2.npt);
                gameDetailUI2.noP.setOnClickListener(gameDetailUI2.npt);
                gameDetailUI2.noJ = new o(gameDetailUI2.nbT);
                gameDetailUI2.noJ.cP(gameDetailUI2);
                gameDetailUI2.noJ.aQj();
                gameDetailUI2.noI.a(gameDetailUI2.noP, gameDetailUI2.noO, gameDetailUI2.nbT, gameDetailUI2.noJ);
                x.i("MicroMsg.GameDetailUI2", "App Status: %d, Download Mode: %d, Download Status: %d", new Object[]{Integer.valueOf(gameDetailUI2.nbT.status), Integer.valueOf(gameDetailUI2.noJ.mode), Integer.valueOf(gameDetailUI2.noJ.status)});
                if (!bh.ov(gameDetailUI2.appId)) {
                    if (gameDetailUI2.noH != null) {
                        n.a(gameDetailUI2.noH);
                    } else {
                        gameDetailUI2.noH = new 6(gameDetailUI2);
                        n.a(gameDetailUI2.noH);
                    }
                }
            }
            Collection arrayList = new ArrayList();
            if (afVar.ndt.nhY != null) {
                Iterator it = afVar.ndt.nhY.iterator();
                while (it.hasNext()) {
                    y yVar = (y) it.next();
                    if (bh.ov(yVar.ksU)) {
                        arrayList.add("");
                    } else {
                        ar.Hg();
                        com.tencent.mm.storage.x WO = com.tencent.mm.z.c.EY().WO(yVar.ksU);
                        if (WO == null || WO.gJd == 0) {
                            arrayList.add(yVar.ksU + " ");
                        } else {
                            arrayList.add(WO.AQ() + " ");
                        }
                    }
                    arrayList.add(yVar.ngs);
                }
            }
            if (arrayList.size() != 0) {
                gameDetailUI2.noS.setVisibility(0);
                GameDetailAutoScrollView gameDetailAutoScrollView = gameDetailUI2.noS;
                gameDetailAutoScrollView.nnS.clear();
                gameDetailAutoScrollView.nlD.TG();
                if (arrayList.size() == 0 || arrayList.size() % 2 != 0) {
                    gameDetailAutoScrollView.nnT.setVisibility(8);
                    gameDetailAutoScrollView.nnW.setVisibility(8);
                } else {
                    gameDetailAutoScrollView.nnS.addAll(arrayList);
                    gameDetailAutoScrollView.lHX = 0;
                    gameDetailAutoScrollView.nnU.setText(i.b(gameDetailAutoScrollView.getContext(), (CharSequence) gameDetailAutoScrollView.nnS.get(0), gameDetailAutoScrollView.nnU.getTextSize()));
                    gameDetailAutoScrollView.nnV.setText((CharSequence) gameDetailAutoScrollView.nnS.get(1));
                    gameDetailAutoScrollView.nnT.setVisibility(0);
                    gameDetailAutoScrollView.nnW.setVisibility(8);
                    if (gameDetailAutoScrollView.nnS.size() / 2 != 1) {
                        gameDetailAutoScrollView.nlD.J(5000, 5000);
                    }
                }
            } else {
                gameDetailUI2.noS.setVisibility(8);
            }
            gameDetailUI2.b(afVar.ndw);
            CharSequence charSequence = afVar.ndt.nhX == null ? null : bh.ov(afVar.ndt.nhX.niR) ? null : afVar.ndt.nhX.niR;
            String str3 = afVar.ndt.nhX == null ? null : bh.ov(afVar.ndt.nhX.niS) ? null : afVar.ndt.nhX.niS;
            if (bh.ov(charSequence)) {
                gameDetailUI2.noU.setVisibility(8);
            } else {
                gameDetailUI2.noU.setText(charSequence);
                if (bh.ov(str3)) {
                    gameDetailUI2.noU.setTag(null);
                } else {
                    gameDetailUI2.noU.setTag(str3);
                }
                gameDetailUI2.noU.setOnClickListener(gameDetailUI2.npu);
            }
            gameDetailUI2.a(afVar);
            gameDetailUI2.b(afVar);
            if (bh.ov(afVar.aQD()) || bh.ov(afVar.aQE())) {
                gameDetailUI2.nph.setVisibility(8);
            } else {
                gameDetailUI2.nph.setVisibility(0);
                gameDetailUI2.npi.R(afVar.aQC());
                gameDetailUI2.npj.setText(afVar.aQD());
                gameDetailUI2.npk.setText(afVar.aQE());
            }
            if (afVar.ndt.nia == null) {
                gameDetailUI2.npc.setVisibility(8);
            } else {
                gameDetailUI2.npc.setVisibility(0);
                gameDetailUI2.npd.setText(afVar.ndt.nia.title);
                com.tencent.mm.aq.o.PA().a(afVar.ndt.nia.haH, gameDetailUI2.npe);
                gameDetailUI2.npf.setText(afVar.ndt.nia.niU);
                gameDetailUI2.npg.setText(afVar.ndt.nia.desc);
                ((ViewGroup) gameDetailUI2.npf.getParent().getParent()).setTag(afVar.ndt.nia.niV);
                ((ViewGroup) gameDetailUI2.npf.getParent().getParent()).setOnClickListener(gameDetailUI2.npy);
            }
            gameDetailUI2.c(afVar);
            gameDetailUI2.npr = afVar.ndt.nhZ;
            if (gameDetailUI2.npr == null || !(gameDetailUI2.npr.nkj || gameDetailUI2.npr.nkk)) {
                gameDetailUI2.mController.removeAllOptionMenu();
            } else {
                super.addIconOptionMenu(0, R.g.bDI, new 13(gameDetailUI2));
            }
            gameDetailUI2.noK.removeView(gameDetailUI2.nph);
            gameDetailUI2.noK.removeView(gameDetailUI2.npc);
            gameDetailUI2.noK.removeView(gameDetailUI2.npn);
            if (afVar.ndv.status == 1) {
                gameDetailUI2.noK.addView(gameDetailUI2.npc);
                gameDetailUI2.noK.addView(gameDetailUI2.nph);
            } else {
                gameDetailUI2.noK.addView(gameDetailUI2.nph);
                gameDetailUI2.noK.addView(gameDetailUI2.npc);
            }
            gameDetailUI2.noK.addView(gameDetailUI2.npn);
        }
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, String str, String str2) {
        g$a com_tencent_mm_y_g_a = new g$a();
        com_tencent_mm_y_g_a.title = gameDetailUI2.npr.nkg;
        com_tencent_mm_y_g_a.description = gameDetailUI2.npr.nkh;
        com_tencent_mm_y_g_a.type = 5;
        if (bh.ov(gameDetailUI2.npr.nfo)) {
            com_tencent_mm_y_g_a.thumburl = gameDetailUI2.nbT.field_appIconUrl;
        } else {
            com_tencent_mm_y_g_a.thumburl = gameDetailUI2.npr.nfo;
        }
        com_tencent_mm_y_g_a.url = gameDetailUI2.npr.nfj;
        l.a(com_tencent_mm_y_g_a, gameDetailUI2.appId, gameDetailUI2.nbT.field_appName, str, null, null, null);
        if (!bh.ov(str2)) {
            com.tencent.mm.sdk.b.b orVar = new or();
            orVar.fGI.fGJ = str;
            orVar.fGI.content = str2;
            orVar.fGI.type = s.hp(str);
            orVar.fGI.flags = 0;
            com.tencent.mm.sdk.b.a.xef.m(orVar);
        }
    }

    static /* synthetic */ void p(GameDetailUI2 gameDetailUI2) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        intent.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
        com.tencent.mm.bm.d.a(gameDetailUI2, ".ui.transmit.SelectConversationUI", intent, 2);
        gameDetailUI2.mController.xIM.overridePendingTransition(R.a.bqo, R.a.bqa);
    }

    static /* synthetic */ void q(GameDetailUI2 gameDetailUI2) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", gameDetailUI2.npr.nki);
        String str = gameDetailUI2.npr.nfo;
        if (bh.ov(str)) {
            str = gameDetailUI2.nbT.field_appIconUrl;
        }
        intent.putExtra("Ksnsupload_imgurl", str);
        intent.putExtra("Ksnsupload_link", gameDetailUI2.npr.nfj);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        str = com.tencent.mm.z.u.hz("game_center");
        com.tencent.mm.z.u.GK().t(str, true).o("prePublishId", "game_center");
        intent.putExtra("reportSessionId", str);
        com.tencent.mm.bm.d.b(gameDetailUI2.mController.xIM, "sns", ".ui.SnsUploadUI", intent, 3);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        if (ar.Hj()) {
            this.noE = true;
            this.noF = false;
            this.appId = getIntent().getStringExtra("game_app_id");
            if (bh.ov(this.appId)) {
                x.e("MicroMsg.GameDetailUI2", "appid is null or nill");
                finish();
            } else {
                this.ndn = getIntent().getIntExtra("game_report_from_scene", 0);
            }
            initView();
            ar.CG().a(1217, this);
            byte[] BX = SubCoreGameCenter.aRh().BX(this.appId);
            if (BX == null || BX.length == 0) {
                x.i("MicroMsg.GameDetailUI2", "No cache found");
                z = false;
            } else {
                ar.Dm().F(new 12(this, BX));
            }
            if (!z) {
                this.lNB = c.cR(this);
                this.lNB.show();
            }
            ar.CG().a(new ax(w.cfi(), this.appId, com.tencent.mm.pluginsdk.model.app.g.m(this, this.appId)), 0);
            return;
        }
        x.e("MicroMsg.GameDetailUI2", "account not ready");
        finish();
    }

    protected final int getLayoutId() {
        return R.i.djS;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (!(this.nbT == null || this.noJ == null)) {
            this.noJ.aQj();
            this.noI.a(this.noP, this.noO, this.nbT, this.noJ);
        }
        if (this.noE) {
            this.noE = false;
        } else {
            b(new ag(this.appId));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(1217, this);
        if (this.noH != null) {
            n.b(this.noH);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!bh.ov(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            startActivity(intent);
        }
        finish();
    }

    protected final void initView() {
        setMMTitle(R.l.emc);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameDetailUI2 npz;

            {
                this.npz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.npz.goBack();
                return true;
            }
        });
        this.noK = (ViewGroup) findViewById(R.h.ckV);
        this.noL = (ImageView) findViewById(R.h.ckW);
        this.noM = (ImageView) findViewById(R.h.cml);
        this.noN = (TextView) findViewById(R.h.cmV);
        this.noQ = (TextView) findViewById(R.h.cmp);
        this.noO = (Button) findViewById(R.h.ckA);
        this.noP = (TextProgressBar) findViewById(R.h.cmZ);
        this.noP.rd(this.noD);
        this.noR = (LinearLayout) findViewById(R.h.clS);
        this.noS = (GameDetailAutoScrollView) findViewById(R.h.clR);
        this.noT = (LinearLayout) findViewById(R.h.clB);
        this.noU = (TextView) findViewById(R.h.clD);
        this.noV = (LinearLayout) findViewById(R.h.cld);
        this.noW = (TextView) findViewById(R.h.clm);
        this.noX = (LinearLayout) findViewById(R.h.cle);
        this.noY = (ImageView) findViewById(R.h.clf);
        this.noZ = findViewById(R.h.clg);
        this.npa = (TextView) findViewById(R.h.cli);
        this.npb = (TextView) findViewById(R.h.clh);
        this.npc = findViewById(R.h.cln);
        this.npd = (TextView) findViewById(R.h.clr);
        this.npe = (ImageView) findViewById(R.h.clq);
        this.npf = (TextView) findViewById(R.h.clo);
        this.npg = (TextView) findViewById(R.h.clp);
        this.nph = (LinearLayout) findViewById(R.h.ckZ);
        this.npi = (GameMediaList) findViewById(R.h.clA);
        GameMediaList gameMediaList = this.npi;
        String str = this.appId;
        int i = this.ndn;
        gameMediaList.appId = str;
        gameMediaList.mfA = 12;
        gameMediaList.nqL = i;
        gameMediaList.mContext = this;
        this.npi.nsT = R.i.dkL;
        this.npj = (TextView) findViewById(R.h.clb);
        this.npk = (TextView) findViewById(R.h.cla);
        this.npk.getViewTreeObserver().addOnGlobalLayoutListener(new 10(this));
        this.npl = (TextView) findViewById(R.h.clc);
        this.npl.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ GameDetailUI2 npz;

            {
                this.npz = r1;
            }

            public final void onClick(View view) {
                if (this.npz.npm) {
                    this.npz.npk.setMaxLines(3);
                    this.npz.npl.setText(this.npz.getResources().getText(R.l.elT));
                    this.npz.npm = false;
                    return;
                }
                this.npz.npk.setMaxLines(100);
                this.npz.npl.setText(this.npz.getResources().getText(R.l.elU));
                this.npz.npm = true;
            }
        });
        this.npn = (LinearLayout) findViewById(R.h.cls);
        this.npo = (TextView) findViewById(R.h.clz);
        this.npp = (LinearLayout) findViewById(R.h.clt);
        this.npq = (TextView) findViewById(R.h.clu);
    }

    private void b(ag agVar) {
        int i = 0;
        List list = agVar.ndx;
        if (list == null || list.size() == 0) {
            this.noT.setVisibility(8);
            this.noU.setVisibility(8);
            return;
        }
        this.noT.setVisibility(0);
        if (list.size() > 3) {
            this.noU.setVisibility(0);
        } else {
            this.noU.setVisibility(8);
        }
        this.noT.removeAllViews();
        j jVar = new j(this.mController.xIM);
        jVar.DD = R.i.dka;
        jVar.a(agVar);
        jVar.ndn = this.ndn;
        while (i < list.size() && i < 3) {
            this.noT.addView(jVar.getView(i, null, this.noR));
            i++;
        }
    }

    private void a(af afVar) {
        LinkedList linkedList = null;
        if (afVar.ndw.ndx == null || afVar.ndw.ndx.size() == 0) {
            linkedList = afVar.ndt.nhT;
        }
        if (linkedList == null || linkedList.size() == 0) {
            this.noR.setVisibility(8);
            return;
        }
        this.noR.setVisibility(0);
        this.noR.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.game.c.x xVar = (com.tencent.mm.plugin.game.c.x) it.next();
            View inflate = LayoutInflater.from(this.mController.xIM).inflate(R.i.dkd, this.noR, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.clU);
            TextView textView = (TextView) inflate.findViewById(R.h.clV);
            TextView textView2 = (TextView) inflate.findViewById(R.h.clT);
            if (bh.ov(xVar.ksU)) {
                com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
                aVar.hDY = true;
                com.tencent.mm.aq.o.PA().a(xVar.nfo, imageView, aVar.PK());
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, xVar.ksU, 0.5f, false);
            }
            textView.setText(xVar.fon);
            textView2.setText(xVar.ngs);
            this.noR.addView(inflate);
        }
    }

    private void b(af afVar) {
        if (afVar.aQA() == null || afVar.aQA().isEmpty()) {
            this.noV.setVisibility(8);
            return;
        }
        int i;
        af.a aVar;
        this.noV.setVisibility(0);
        if (bh.ov(afVar.aQz())) {
            this.noW.setVisibility(8);
        } else {
            this.noW.setVisibility(0);
            this.noW.setText(afVar.aQz());
        }
        this.noX.removeAllViews();
        int i2;
        if (afVar.aQB() == 1) {
            this.noX.setOrientation(1);
            i2 = R.i.djV;
            this.noY.setVisibility(8);
            i = i2;
        } else {
            this.noX.setOrientation(0);
            i2 = R.i.djU;
            this.noY.setVisibility(0);
            i = i2;
        }
        LinkedList aQA = afVar.aQA();
        if (aQA != null) {
            Iterator it = aQA.iterator();
            while (it.hasNext()) {
                af.b bVar = (af.b) it.next();
                View inflate = LayoutInflater.from(this.mController.xIM).inflate(i, this.noX, false);
                com.tencent.mm.aq.o.PA().a(bVar.fDI, (ImageView) inflate.findViewById(R.h.clk));
                if (afVar.aQB() == 1) {
                    ((TextView) inflate.findViewById(R.h.cll)).setText(bVar.title);
                }
                ((TextView) inflate.findViewById(R.h.clj)).setText(bVar.desc);
                if (afVar.aQB() == 1) {
                    inflate.setTag(bVar.url);
                    inflate.setOnClickListener(this.npv);
                }
                this.noX.addView(inflate);
            }
        }
        if (afVar.ndt.nib != null) {
            aVar = new af.a();
            aVar.title = afVar.ndt.nib.niP;
            aVar.desc = afVar.ndt.nib.desc;
            aVar.url = afVar.ndt.nib.url;
        } else if (afVar.ndt.nhW == null || bh.ov(afVar.ndt.nhW.niR) || bh.ov(afVar.ndt.nhW.niS)) {
            aVar = null;
        } else {
            aVar = new af.a();
            aVar.title = afVar.ndt.nhW.niR;
            aVar.url = afVar.ndt.nhW.niS;
        }
        if (aVar != null) {
            this.noZ.setVisibility(0);
            this.npa.setText(aVar.title);
            if (bh.ov(aVar.desc)) {
                this.npb.setVisibility(8);
            } else {
                this.npb.setVisibility(0);
                this.npb.setText(aVar.desc);
            }
            this.noZ.setTag(aVar.url);
            this.noZ.setOnClickListener(this.npv);
            return;
        }
        this.noZ.setVisibility(8);
    }

    private void c(af afVar) {
        if (afVar.aQG() == null || afVar.aQG().isEmpty()) {
            this.npn.setVisibility(8);
            return;
        }
        this.npn.setVisibility(0);
        if (bh.ov(afVar.aQF())) {
            this.npo.setVisibility(8);
        } else {
            this.npo.setVisibility(0);
            this.npo.setText(afVar.aQF());
        }
        this.npp.removeAllViews();
        this.npp.setOnClickListener(null);
        Iterator it = afVar.aQG().iterator();
        while (it.hasNext()) {
            cf cfVar = (cf) it.next();
            View inflate = LayoutInflater.from(this.mController.xIM).inflate(R.i.djW, this.npp, false);
            TextView textView = (TextView) inflate.findViewById(R.h.cly);
            TextView textView2 = (TextView) inflate.findViewById(R.h.clv);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.clw);
            ((TextView) inflate.findViewById(R.h.clx)).setText(cfVar.niX);
            textView.setText(cfVar.fon);
            textView2.setText(cfVar.ngs);
            com.tencent.mm.aq.o.PA().a(cfVar.niT, imageView);
            inflate.setTag(cfVar.nfj);
            inflate.setOnClickListener(this.npw);
            this.npp.addView(inflate);
        }
        Pair pair = afVar.ndt.nhW == null ? null : (bh.ov(afVar.ndt.nhV.fon) || bh.ov(afVar.ndt.nhV.niS)) ? null : new Pair(afVar.ndt.nhV.niR, afVar.ndt.nhV.niS);
        if (pair != null) {
            this.npq.setVisibility(0);
            this.npq.setText((CharSequence) pair.first);
            this.npq.setTag(pair.second);
            this.npq.setOnClickListener(this.npx);
            return;
        }
        this.npq.setVisibility(8);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 1217:
                    ar.Dm().F(new 14(this, ((ax) kVar).lMW.hmh.hmo));
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

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                switch (i2) {
                    case 0:
                        return;
                    case 2:
                        if (this.nbT != null && this.noJ != null) {
                            this.noJ.aQk();
                            this.noI.a(this.nbT, this.noJ);
                            return;
                        }
                        return;
                    case 3:
                        if (this.noJ != null) {
                            this.noJ.aQj();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            case 2:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bh.ov(stringExtra)) {
                        String str = this.npr.nfo;
                        if (bh.ov(str)) {
                            str = this.nbT.field_appIconUrl;
                        }
                        com.tencent.mm.pluginsdk.ui.applet.e.b(this.mController, this.npr.nkg, str, this.npr.nkh, null, getResources().getString(R.l.dGA), new 9(this, stringExtra));
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (i2 == -1) {
                    ap.a(this.mController.xIM, 12, 1207, 2, 15, this.appId, this.ndn, null);
                    return;
                }
                return;
            default:
                x.e("MicroMsg.GameDetailUI2", "error request code");
                return;
        }
    }
}
