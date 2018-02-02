package com.tencent.mm.plugin.search.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bc.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSEditTextView$b;
import com.tencent.mm.z.ar;
import java.util.List;
import java.util.Map;

public class FTSAddFriendUI extends FTSBaseUI {
    private long jzh;
    private Dialog lNB;
    private bem lZN;
    private String muF = "";
    private View qbA;
    private View qbB;
    private View qbC;
    private ImageView qbD;
    private TextView qbE;
    private TextView qbF;
    private TextView qbG;
    private TextView qbH;
    private TextView qbI;
    private boolean qbJ;
    protected boolean qbK;
    private int qbL = 1;
    private a qbM;
    private int qbN;
    private int qbO;
    int qbP = -1;
    private View qbx;
    private View qby;
    private View qbz;

    static /* synthetic */ void a(FTSAddFriendUI fTSAddFriendUI) {
        String str = fTSAddFriendUI.fDj;
        if (str != null && !bh.ov(str.trim()) && System.currentTimeMillis() - fTSAddFriendUI.jzh > 1000) {
            fTSAddFriendUI.jzh = System.currentTimeMillis();
            if (g.zM(0)) {
                if (!bh.ov(fTSAddFriendUI.fDj)) {
                    fTSAddFriendUI.qbK = true;
                    com.tencent.mm.bc.g.d(fTSAddFriendUI.fDj, 2, 2, 16);
                }
                Intent QM = b.QM();
                QM.putExtra("ftsbizscene", 16);
                QM.putExtra("ftsQuery", fTSAddFriendUI.fDj);
                Map b = b.b(16, true, 0);
                b.put("query", fTSAddFriendUI.fDj);
                str = g.zH(bh.VI((String) b.get("scene")));
                b.put("sessionId", str);
                QM.putExtra("sessionId", str);
                QM.putExtra("rawUrl", b.r(b));
                com.tencent.mm.sdk.b.b kwVar = new kw();
                kwVar.fCe.scene = 0;
                a.xef.m(kwVar);
                QM.putExtra("ftsInitToSearch", true);
                QM.putExtra("key_load_js_without_delay", true);
                d.b(fTSAddFriendUI.mController.xIM, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", QM);
                com.tencent.mm.bc.g.ip(16);
                return;
            }
            x.e("MicroMsg.FTS.FTSAddFriendUI", "fts h5 template not avail");
        }
    }

    static /* synthetic */ void f(FTSAddFriendUI fTSAddFriendUI) {
        com.tencent.mm.sdk.b.b agVar = new ag();
        agVar.fob.context = fTSAddFriendUI;
        agVar.fob.fromScene = 16;
        agVar.fob.fod = fTSAddFriendUI.fDj;
        agVar.fob.fof = false;
        agVar.fob.title = fTSAddFriendUI.getString(R.l.dfa);
        agVar.fob.foe = 1;
        Runnable 6 = new 6(fTSAddFriendUI, agVar);
        agVar.fob.fog = 6;
        agVar.fob.action = 1;
        if (!a.xef.m(agVar)) {
            agVar.foc.foh = false;
            6.run();
        }
    }

    static /* synthetic */ void g(FTSAddFriendUI fTSAddFriendUI) {
        if (fTSAddFriendUI.qbN != 0 && fTSAddFriendUI.qbO != 0) {
            fTSAddFriendUI.bpX();
            if (fTSAddFriendUI.qbN <= 0 || fTSAddFriendUI.qbO >= 0) {
                if (fTSAddFriendUI.qbN > 0) {
                    bem com_tencent_mm_protocal_c_bem = fTSAddFriendUI.lZN;
                    String a = n.a(com_tencent_mm_protocal_c_bem.vYI);
                    CharSequence a2 = n.a(com_tencent_mm_protocal_c_bem.wsB);
                    CharSequence charSequence = com_tencent_mm_protocal_c_bem.hvw;
                    fTSAddFriendUI.qbX.setVisibility(8);
                    fTSAddFriendUI.qbx.setVisibility(0);
                    fTSAddFriendUI.qby.setVisibility(0);
                    fTSAddFriendUI.qbC.setOnClickListener(new 3(fTSAddFriendUI));
                    fTSAddFriendUI.qbE.setText(a2);
                    fTSAddFriendUI.qbF.setText(charSequence);
                    com.tencent.mm.pluginsdk.ui.a.b.a(fTSAddFriendUI.qbD, a);
                    fTSAddFriendUI.qbz.setVisibility(8);
                    fTSAddFriendUI.qbA.setVisibility(8);
                    fTSAddFriendUI.qbB.setVisibility(8);
                } else {
                    fTSAddFriendUI.qbX.setVisibility(8);
                    fTSAddFriendUI.qbx.setVisibility(0);
                    fTSAddFriendUI.qby.setVisibility(8);
                    fTSAddFriendUI.qbz.setVisibility(0);
                    fTSAddFriendUI.qbA.setVisibility(8);
                    fTSAddFriendUI.qbB.setVisibility(8);
                }
                if (fTSAddFriendUI.qbO > 0) {
                    fTSAddFriendUI.qbA.setVisibility(0);
                    fTSAddFriendUI.qbB.setVisibility(0);
                    fTSAddFriendUI.qbG.setText(f.a(fTSAddFriendUI.getString(R.l.ekH), "", com.tencent.mm.plugin.fts.d.b.a.d(fTSAddFriendUI.fDj, fTSAddFriendUI.fDj)).mQk);
                    fTSAddFriendUI.qbL = 2;
                    fTSAddFriendUI.qbB.setOnClickListener(new OnClickListener(fTSAddFriendUI) {
                        final /* synthetic */ FTSAddFriendUI qbQ;

                        {
                            this.qbQ = r1;
                        }

                        public final void onClick(View view) {
                            FTSAddFriendUI.a(this.qbQ);
                        }
                    });
                    return;
                }
                fTSAddFriendUI.qbA.setVisibility(8);
                fTSAddFriendUI.qbB.setVisibility(8);
                return;
            }
            fTSAddFriendUI.qbK = true;
            fTSAddFriendUI.bpW();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qbx = findViewById(R.h.bXf);
        this.qby = findViewById(R.h.cog);
        this.qbC = findViewById(R.h.bXg);
        this.qbz = findViewById(R.h.cAt);
        this.qbA = findViewById(R.h.cvS);
        this.qbB = findViewById(R.h.cJz);
        this.qbD = (ImageView) findViewById(R.h.bXe);
        this.qbE = (TextView) findViewById(R.h.bYu);
        this.qbF = (TextView) findViewById(R.h.bXj);
        this.qbG = (TextView) findViewById(R.h.cKd);
        this.qbH = (TextView) findViewById(R.h.bXk);
        this.qbI = (TextView) findViewById(R.h.cJA);
        try {
            x.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[]{h.NT("webSearchBar").optString("wording")});
            this.qbI.setText(r0);
        } catch (Exception e) {
        }
        this.mController.contentView.postDelayed(new 1(this), 128);
    }

    protected final b a(c cVar) {
        if (this.qbM == null) {
            this.qbM = new a(cVar);
        }
        return this.qbM;
    }

    public final void a(com.tencent.mm.plugin.fts.d.a.b bVar) {
        if (bVar instanceof com.tencent.mm.plugin.search.ui.a.a) {
            this.muF = bVar.mMb.mLA;
            IS(bVar.mMb.mLA);
        }
    }

    public final void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, FTSEditTextView$b fTSEditTextView$b) {
        super.a(str, str2, list, fTSEditTextView$b);
        this.qbJ = false;
    }

    public final boolean akL() {
        IS(this.fDj);
        aWs();
        return true;
    }

    protected final int getLayoutId() {
        return R.i.diK;
    }

    protected final void bpV() {
        super.bpV();
        this.qbx.setVisibility(8);
    }

    protected final void stopSearch() {
        super.stopSearch();
        this.qbx.setVisibility(8);
    }

    private void bpW() {
        if (bh.ou(n.a(this.lZN.vYI)).length() > 0) {
            if (2 == this.lZN.wJY) {
                this.qbP = 15;
            } else if (1 == this.lZN.wJY) {
                this.qbP = 1;
            }
            Intent intent = new Intent();
            c.a(intent, this.lZN, this.qbP);
            if (this.qbP == 15 && 2 == this.lZN.wJY) {
                intent.putExtra("Contact_Search_Mobile", this.muF.trim());
            }
            intent.putExtra("add_more_friend_search_scene", 2);
            com.tencent.mm.plugin.search.a.ifs.d(intent, (Context) this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.qbJ && !this.qbK) {
            com.tencent.mm.bc.g.d(this.fDj, this.qbL, 3, 16);
        }
    }

    private void IS(String str) {
        this.qbJ = true;
        this.qbK = false;
        this.qbL = 1;
        if (str != null && str.length() != 0 && str.trim().length() != 0) {
            this.qbP = Character.isDigit(str.charAt(0)) ? 15 : 3;
            e 4 = new 4(this);
            this.qbN = 0;
            this.qbO = 0;
            ar.CG().a(106, 4);
            k acVar = new ac(str, 3);
            ar.CG().a(acVar, 0);
            getString(R.l.dGO);
            this.lNB = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dDg), true, new 5(this, acVar, 4));
        }
    }

    private void bpX() {
        com.tencent.mm.sdk.platformtools.ag.y(new 7(this));
    }

    public void onClickBg(View view) {
    }

    public final void cs(View view) {
        super.cs(view);
        if (!this.qca.zet.yig.hasFocus()) {
            this.qca.zet.cxa();
            showVKB();
        }
    }
}
