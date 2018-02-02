package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.game.c.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.bd;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.ui.n.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI extends MMActivity implements e {
    private View kgd;
    private Dialog lNB;
    private boolean mNm = false;
    private int ndn = 0;
    private int nds = 0;
    private l nlW = new l();
    private ListView nmc;
    private m nmd;
    private boolean nme = false;
    private boolean nmf = true;
    private a nmi = new 3(this);
    private OnScrollListener nmj = new OnScrollListener(this) {
        final /* synthetic */ GameLibraryUI nsw;

        {
            this.nsw = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.nsw.nmf && !this.nsw.nme) {
                this.nsw.kgd.setVisibility(0);
                this.nsw.aRE();
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private boolean nnc = true;
    private OnClickListener nnf = new OnClickListener(this) {
        final /* synthetic */ GameLibraryUI nsw;

        {
            this.nsw = r1;
        }

        public final void onClick(View view) {
            int i = 6;
            if (view.getTag() instanceof String) {
                c.a(view, this.nsw);
                i = 7;
            } else {
                Intent intent = new Intent(this.nsw, GameCategoryUI.class);
                intent.putExtra("extra_type", 2);
                intent.putExtra("extra_category_name", this.nsw.getString(R.l.emp));
                intent.putExtra("game_report_from_scene", 1113);
                this.nsw.startActivity(intent);
            }
            ap.a(this.nsw, 11, 1113, 1, i, this.nsw.ndn, null);
        }
    };
    private GameBannerView nsh;
    private GameLibraryCategoriesView nsi;
    private View nsj;
    private TextView nsk;
    private View nsl;
    private GameDropdownView nsm;
    private HashMap<Integer, String> nsn;
    private int nso = 0;
    private View nsp;
    private Button nsq;
    private boolean nsr = false;
    private int nss = 990;
    private int nst = 0;
    private OnClickListener nsu = new 5(this);
    private GameDropdownView.a nsv = new GameDropdownView.a(this) {
        final /* synthetic */ GameLibraryUI nsw;

        {
            this.nsw = r1;
        }

        public final void qV(int i) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.nsw.nsn.keySet());
            if (i <= linkedList.size() - 1) {
                this.nsw.nso = ((Integer) linkedList.get(i)).intValue();
                x.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", new Object[]{Integer.valueOf(this.nsw.nso)});
                this.nsw.nds = 0;
                this.nsw.aRE();
                ap.a(this.nsw, 11, 1111, this.nsw.nso + this.nsw.nss, 2, this.nsw.ndn, null);
            }
        }
    };

    static /* synthetic */ void a(GameLibraryUI gameLibraryUI, al alVar, boolean z) {
        Pair pair = null;
        gameLibraryUI.nmf = alVar.ndV.niJ;
        LinkedList linkedList;
        if (z) {
            gameLibraryUI.nmd.O(alVar.ndX);
            x.i("MicroMsg.GameLibraryUI", "Appending list size: %d", new Object[]{Integer.valueOf(linkedList.size())});
        } else {
            LinkedList linkedList2;
            GameBannerView gameBannerView = gameLibraryUI.nsh;
            if (alVar.ndV.niH == null || alVar.ndV.niH.nju == null) {
                x.e("MicroMsg.GamePBDataLibrary", "Has no banner");
                linkedList = null;
            } else {
                linkedList2 = new LinkedList();
                for (int i = 0; i < alVar.ndV.niH.nju.size(); i++) {
                    GameBannerView.a aVar = new GameBannerView.a();
                    b bVar = (b) alVar.ndV.niH.nju.get(i);
                    f a = al.a(bVar.nfh);
                    if (a != null) {
                        d.a(a);
                        aVar.index = i;
                        aVar.nlG = a;
                        aVar.hkg = bVar.nfi;
                        aVar.naS = bVar.nfj;
                        linkedList2.add(aVar);
                    }
                }
                linkedList = linkedList2;
            }
            gameBannerView.Q(linkedList);
            gameLibraryUI.nsi.H(alVar.aQT());
            gameLibraryUI.nsi.ndn = gameLibraryUI.ndn;
            linkedList = new LinkedList();
            linkedList2 = alVar.ndW;
            Object obj = alVar.ndX;
            linkedList.addAll(linkedList2);
            linkedList.addAll(obj);
            gameLibraryUI.nmd.P(linkedList);
            x.i("MicroMsg.GameLibraryUI", "Initial new game list size: %d, initial all game list size: %d", new Object[]{Integer.valueOf(linkedList2.size()), Integer.valueOf(obj.size())});
            gameLibraryUI.nsn = alVar.aQS();
            linkedList = new LinkedList();
            linkedList.addAll(gameLibraryUI.nsn.values());
            GameDropdownView gameDropdownView = gameLibraryUI.nsm;
            LinkedList linkedList3 = new LinkedList();
            linkedList3.addAll(gameLibraryUI.nsn.keySet());
            gameDropdownView.c(linkedList, linkedList3.indexOf(Integer.valueOf(gameLibraryUI.nso)));
            Pair pair2 = (alVar.ndV.niH == null || alVar.ndV.niH.njv == null) ? null : new Pair(alVar.ndV.niH.njv.njQ, alVar.ndV.niH.njv.niS);
            if (pair2 == null || bh.ov((String) pair2.first) || bh.ov((String) pair2.second)) {
                gameLibraryUI.nsj.setTag(null);
                gameLibraryUI.nsk.setVisibility(8);
            } else {
                gameLibraryUI.nsj.setTag(pair2.second);
                gameLibraryUI.nsk.setVisibility(0);
                gameLibraryUI.nsk.setText((CharSequence) pair2.first);
            }
            SparseArray sparseArray = new SparseArray();
            if (linkedList2.size() != 0) {
                sparseArray.put(0, gameLibraryUI.nsj);
            }
            sparseArray.put(linkedList2.size(), gameLibraryUI.nsl);
            gameLibraryUI.nmd.b(sparseArray);
            if (!(alVar.ndV.niH == null || alVar.ndV.niH.njx == null)) {
                pair = new Pair(alVar.ndV.niH.njx.njE, alVar.ndV.niH.njx.nfj);
            }
            if (pair != null) {
                gameLibraryUI.nsq.setText((CharSequence) pair.first);
                gameLibraryUI.nsq.setTag(pair.second);
                gameLibraryUI.nsr = true;
            }
        }
        if (!gameLibraryUI.nmf && gameLibraryUI.nsr) {
            gameLibraryUI.nsp.setVisibility(0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ar.Hj()) {
            int i;
            this.ndn = getIntent().getIntExtra("game_report_from_scene", 0);
            ar.CG().a(1218, this);
            initView();
            byte[] BX = SubCoreGameCenter.aRh().BX("pb_library");
            if (BX == null) {
                x.i("MicroMsg.GameLibraryUI", "No cache found");
                i = 0;
            } else {
                ar.Dm().F(new 4(this, BX));
                i = 1;
            }
            if (i == 0) {
                this.lNB = c.cR(this);
                this.lNB.show();
            }
            aRE();
            ap.a(this, 11, 1100, 0, 1, this.ndn, null);
            return;
        }
        x.e("MicroMsg.GameLibraryUI", "account not ready");
        finish();
    }

    protected void onResume() {
        super.onResume();
        if (ar.Hj()) {
            this.nmd.refresh();
            if (!(this.nnc || this.nsh == null)) {
                GameBannerView gameBannerView = this.nsh;
                if (gameBannerView.nlD != null && gameBannerView.nlD.cfK() && gameBannerView.nlC.size() > 1) {
                    gameBannerView.nlD.J(5000, 5000);
                    x.i("MicroMsg.GameBannerView", "Auto scroll restarted");
                }
            }
            if (this.nnc) {
                this.nnc = false;
                return;
            }
            return;
        }
        x.e("MicroMsg.GameLibraryUI", "account not ready");
    }

    protected void onPause() {
        super.onPause();
        if (this.nsh != null) {
            GameBannerView gameBannerView = this.nsh;
            if (gameBannerView.nlD != null) {
                gameBannerView.nlD.TG();
                x.i("MicroMsg.GameBannerView", "Auto scroll stopped");
            }
        }
    }

    protected void onDestroy() {
        x.i("MicroMsg.GameLibraryUI", "onDestroy");
        super.onDestroy();
        ar.CG().b(1218, this);
        this.nmd.clear();
        if (this.nsh != null) {
            this.nsh.nlD.TG();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dkB;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        setMMTitle(R.l.dkB);
        setBackBtn(new 1(this));
        if (!bh.ov(SubCoreGameCenter.aRb())) {
            addIconOptionMenu(0, R.l.eRj, R.k.dvb, new 2(this));
        }
        this.nmc = (ListView) findViewById(R.h.cmD);
        this.nmc.setOnItemClickListener(this.nlW);
        this.nlW.qO(this.ndn);
        this.nmc.setOnScrollListener(this.nmj);
        this.nmd = new m(this);
        this.nmd.qO(this.ndn);
        this.nmd.a(this.nmi);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.xIM.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.i.cmG, this.nmc, false);
        this.nsh = (GameBannerView) inflate.findViewById(R.h.cmG);
        this.nsh.ndn = this.ndn;
        this.nmc.addHeaderView(inflate);
        this.nst++;
        this.nsi = (GameLibraryCategoriesView) layoutInflater.inflate(R.i.dkD, this.nmc, false);
        View linearLayout = new LinearLayout(this);
        linearLayout.addView(this.nsi);
        this.nmc.addHeaderView(linearLayout);
        this.nst++;
        this.nsj = layoutInflater.inflate(R.i.dkH, this.nmc, false);
        this.nsj.setOnClickListener(this.nsu);
        this.nsk = (TextView) this.nsj.findViewById(R.h.cmF);
        this.nsl = layoutInflater.inflate(R.i.dkC, this.nmc, false);
        this.nsl.setOnClickListener(null);
        this.nsm = (GameDropdownView) this.nsl.findViewById(R.h.cmB);
        this.nsm.npX = this.nsl;
        this.nsm.npW = this.nsv;
        this.kgd = layoutInflater.inflate(R.i.dkI, this.nmc, false);
        this.kgd.setVisibility(8);
        linearLayout = new LinearLayout(this);
        linearLayout.addView(this.kgd);
        this.nmc.addFooterView(linearLayout);
        this.nsp = layoutInflater.inflate(R.i.dkG, this.nmc, false);
        this.nsp.setVisibility(8);
        this.nsq = (Button) this.nsp.findViewById(R.h.cmE);
        this.nsq.setOnClickListener(this.nnf);
        this.nmc.addFooterView(this.nsp);
        this.nmc.setAdapter(this.nmd);
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

    private void aRE() {
        ar.CG().a(new bd(this.nds, g.aPX(), this.nso, this.nds == 0), 0);
        this.nme = true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 1218:
                    ar.Dm().F(new 9(this, ((bd) kVar).lMW.hmh.hmo));
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

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 1) {
            x.e("MicroMsg.GameLibraryUI", "error request code");
        }
    }
}
