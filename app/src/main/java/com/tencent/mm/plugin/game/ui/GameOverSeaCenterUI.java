package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.game.c.bt;
import com.tencent.mm.plugin.game.c.ck;
import com.tencent.mm.plugin.game.c.cr;
import com.tencent.mm.plugin.game.c.cw;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.b.a;
import com.tencent.mm.plugin.game.model.bc;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Iterator;
import java.util.LinkedList;

public class GameOverSeaCenterUI extends GameCenterBaseUI implements e {
    private Dialog lNB;
    private bt ndY;
    l nlW = new l();
    private GameCenterListView nmM;
    private h nmN;
    private GameInfoViewForeign nmQ;
    private GameMessageBubbleView nmR;
    private GameInstalledView nmU;
    private View nmW;
    private TextView nmX;
    private boolean nnd;
    private String nne = "";
    private OnClickListener nnf = new OnClickListener(this) {
        final /* synthetic */ GameOverSeaCenterUI ntQ;

        {
            this.ntQ = r1;
        }

        public final void onClick(View view) {
            int p;
            a aPQ = b.aPQ();
            if (aPQ.fDt == 2) {
                p = c.p(this.ntQ.mController.xIM, aPQ.url, "game_center_library");
            } else {
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String) || bh.ov((String) tag)) {
                    Intent intent = new Intent(this.ntQ.mController.xIM, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1005);
                    this.ntQ.startActivity(intent);
                    p = 6;
                } else {
                    p = c.p(this.ntQ.mController.xIM, (String) tag, "game_center_library");
                }
            }
            ap.a(this.ntQ.mController.xIM, 10, 1005, 1, p, this.ntQ.ndn, null);
        }
    };

    static /* synthetic */ void a(GameOverSeaCenterUI gameOverSeaCenterUI, am amVar, int i) {
        if (gameOverSeaCenterUI.isFinishing()) {
            x.w("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI hasFinished");
        } else if (amVar == null) {
            x.e("MicroMsg.GameOverSeaCenterUI", "Null data");
        } else {
            LinkedList linkedList;
            if (amVar == null || amVar.aQL() == null) {
                gameOverSeaCenterUI.nne = "";
            } else {
                gameOverSeaCenterUI.nne = amVar.aQL().nfg;
            }
            if (bh.ov(gameOverSeaCenterUI.nne)) {
                if (gameOverSeaCenterUI.nnd) {
                    gameOverSeaCenterUI.removeOptionMenu(0);
                    gameOverSeaCenterUI.nnd = false;
                }
            } else if (!gameOverSeaCenterUI.nnd) {
                gameOverSeaCenterUI.addIconOptionMenu(0, R.k.dvc, new 5(gameOverSeaCenterUI));
                gameOverSeaCenterUI.nnd = true;
            }
            ck ckVar = (amVar.ndY == null || amVar.ndY.nig == null) ? null : amVar.ndY.nig.nhd;
            if (ckVar != null) {
                gameOverSeaCenterUI.nmQ.ndn = gameOverSeaCenterUI.ndn;
                gameOverSeaCenterUI.nmQ.setVisibility(0);
            } else {
                gameOverSeaCenterUI.nmQ.setVisibility(8);
            }
            gameOverSeaCenterUI.nmU.ndn = gameOverSeaCenterUI.ndn;
            GameInstalledView.B(amVar.ndG);
            GameInstalledView gameInstalledView = gameOverSeaCenterUI.nmU;
            GameInstalledView.a aVar = new GameInstalledView.a();
            if (!(amVar.ndY.nim == null || amVar.ndY.nim.njq == null)) {
                aVar.iconUrl = amVar.ndY.nim.njq.nfo;
                aVar.title = amVar.ndY.nim.njq.fon;
                aVar.jeE = amVar.ndY.nim.njq.nfj;
            }
            gameInstalledView.nrX = aVar;
            GameInstalledView gameInstalledView2 = gameOverSeaCenterUI.nmU;
            LinkedList linkedList2 = new LinkedList();
            if (amVar.ndY.nim == null || amVar.ndY.nim.njp == null) {
                linkedList = linkedList2;
            } else {
                Iterator it = amVar.ndY.nim.njp.iterator();
                while (it.hasNext()) {
                    cr crVar = (cr) it.next();
                    if (crVar != null) {
                        d a = am.a(crVar.nfh);
                        if (a != null) {
                            a.cQ(crVar.njr);
                            linkedList2.addFirst(a);
                        }
                    }
                }
                linkedList = linkedList2;
            }
            gameInstalledView2.nrY = linkedList;
            gameOverSeaCenterUI.nmU.eJ(true);
            if (gameOverSeaCenterUI.nmv) {
                gameOverSeaCenterUI.nmR.aRH();
            }
            cw cwVar = amVar.ndY != null ? amVar.ndY.nio : null;
            if (cwVar == null || bh.ov(cwVar.nfe) || bh.ov(cwVar.nfg)) {
                gameOverSeaCenterUI.nmW.setVisibility(8);
            } else {
                gameOverSeaCenterUI.nmW.setVisibility(0);
                gameOverSeaCenterUI.nmX.setText(cwVar.nfe);
                gameOverSeaCenterUI.nmW.setTag(cwVar.nfg);
                gameOverSeaCenterUI.nmW.setOnClickListener(gameOverSeaCenterUI.nnf);
            }
            gameOverSeaCenterUI.nmN.qR(i);
            gameOverSeaCenterUI.nmN.P(amVar.ndF);
            if (i == 2) {
                c.Dm().F(new 3(gameOverSeaCenterUI));
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
        ar.CG().a(2855, this);
        initView();
        c.Dm().F(new 2(this));
    }

    protected void onDestroy() {
        x.i("MicroMsg.GameOverSeaCenterUI", "onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.game.d.a.a.aRT().clearCache();
        ar.CG().b(2855, this);
        SubCoreGameCenter.aRj().clearCache();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        setMMTitle(R.l.enh);
        this.nmM = (GameCenterListView) findViewById(R.h.ckO);
        this.nmM.setOnItemClickListener(this.nlW);
        this.nlW.qO(this.ndn);
        this.nmN = new h(this);
        this.nmN.qO(this.ndn);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.xIM.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.i.djM, this.nmM, false);
        this.nmQ = (GameInfoViewForeign) inflate.findViewById(R.h.ckM);
        this.nmM.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.djH, this.nmM, false);
        this.nmR = (GameMessageBubbleView) inflate.findViewById(R.h.cmQ);
        this.nmM.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.djN, this.nmM, false);
        this.nmU = (GameInstalledView) inflate.findViewById(R.h.cmq);
        this.nmM.addHeaderView(inflate);
        View inflate2 = layoutInflater.inflate(R.i.djK, this.nmM, false);
        this.nmM.addFooterView(inflate2);
        this.nmW = inflate2.findViewById(R.h.cmi);
        this.nmW.setOnClickListener(this.nnf);
        this.nmX = (TextView) inflate2.findViewById(R.h.cmj);
        this.nmM.setAdapter(this.nmN);
    }

    protected final int getLayoutId() {
        return R.i.djJ;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GameOverSeaCenterUI", "errType: %d errCode: %d, scene: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.hashCode())});
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 2855:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final com.tencent.mm.bq.a aVar = ((bc) kVar).lMW.hmh.hmo;
                    c.Dm().F(new Runnable(this) {
                        final /* synthetic */ GameOverSeaCenterUI ntQ;

                        public final void run() {
                            if (aVar == null) {
                                this.ntQ.ndY = new bt();
                            } else {
                                this.ntQ.ndY = (bt) aVar;
                            }
                            ag.y(new 1(this, new am(aVar)));
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
}
