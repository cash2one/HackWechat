package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.acb;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.z.ar;
import java.util.Collection;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI extends MMActivity implements OnItemClickListener, e {
    private acb lCN;
    private Button lDm;
    private int lGB;
    private EmojiStoreV2RewardBannerView lGC;
    private GridInScrollView lGD;
    private View lGE;
    private View lGF;
    private MMFormInputView lGG;
    private TextView lGH;
    private TextView lGI;
    private b lGJ;
    private b lGK;
    private int lGL = a.lGS;
    private boolean lGM = false;
    private OnClickListener lGN = new 2(this);
    private OnClickListener lGO = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2RewardUI lGQ;

        {
            this.lGQ = r1;
        }

        public final void onClick(View view) {
            if (this.lGQ.lGL == a.lGS) {
                this.lGQ.oS(a.lGT);
            }
        }
    };
    private TextWatcher lGP = new 4(this);
    private AnimationDrawable lGy;
    private ProgressDialog ltM;
    private int lxO;
    private String lxU;
    private String lyx;
    private af mHandler = new 1(this);

    class c {
        final /* synthetic */ EmojiStoreV2RewardUI lGQ;
        TextView lGV;

        public c(EmojiStoreV2RewardUI emojiStoreV2RewardUI, View view) {
            this.lGQ = emojiStoreV2RewardUI;
            this.lGV = (TextView) view.findViewById(R.h.cDs);
        }
    }

    static /* synthetic */ void i(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        emojiStoreV2RewardUI.lGL = a.lGS;
        if (emojiStoreV2RewardUI.lGF != null) {
            emojiStoreV2RewardUI.lGF.setVisibility(8);
            emojiStoreV2RewardUI.lGE.setVisibility(0);
            emojiStoreV2RewardUI.lGF.startAnimation(AnimationUtils.loadAnimation(emojiStoreV2RewardUI.mController.xIM, R.a.bql));
        }
    }

    protected final int getLayoutId() {
        return R.i.dga;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lyx = getIntent().getStringExtra("extra_id");
        this.lxU = getIntent().getStringExtra("name");
        this.lxO = getIntent().getIntExtra("scene", 0);
        this.lGB = getIntent().getIntExtra("pageType", 0);
        initView();
        this.lCN = i.aBE().lwQ.Yb(this.lyx);
        if (this.lCN == null || this.lCN.wkV == null) {
            eE(false);
        } else {
            o.PA().a(this.lCN.wkV.waT, null, f.g(this.lyx, this.lCN.wkV.waT, new Object[0]));
            o.PA().a(this.lCN.wkV.waU, null, f.g(this.lyx, this.lCN.wkV.waU, new Object[0]));
        }
        au();
        ar.CG().a(830, this);
        ar.CG().a(822, this);
        g.pQN.a(408, 0, 1, false);
    }

    protected void onDestroy() {
        ar.CG().b(830, this);
        ar.CG().b(822, this);
        if (this.lGy != null && this.lGy.isRunning()) {
            this.lGy.stop();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", this.mController.xJg);
        if (this.lGL == a.lGS) {
            if (this.lGM) {
                g.pQN.a(408, 2, 1, false);
            } else {
                g.pQN.a(408, 1, 1, false);
                g.pQN.h(12738, new Object[]{this.lyx, Integer.valueOf(this.lGB), Integer.valueOf(this.lxO), Integer.valueOf(4)});
            }
            super.onBackPressed();
            return;
        }
        oS(a.lGS);
    }

    private void oS(int i) {
        if (i == a.lGT) {
            this.lGL = a.lGT;
            if (this.lGF != null) {
                this.lGF.setVisibility(0);
                this.lGF.startAnimation(AnimationUtils.loadAnimation(this.mController.xIM, R.a.bqk));
                this.lGG.pqM.requestFocus();
                showVKB();
                this.lGE.setVisibility(8);
                return;
            }
            return;
        }
        aWs();
        this.mHandler.postDelayed(new 5(this), 300);
    }

    protected final void initView() {
        if (bh.ov(this.lxU)) {
            setMMTitle(R.l.eaJ);
        } else {
            setMMTitle(getString(R.l.eaR, new Object[]{this.lxU}));
        }
        setMMSubTitle(R.l.eXs);
        setBackBtn(new 6(this));
        this.lGE = findViewById(R.h.cHZ);
        this.lGF = findViewById(R.h.cIa);
        this.lGG = (MMFormInputView) findViewById(R.h.cIb);
        this.lDm = (Button) findViewById(R.h.cIc);
        this.lDm.setOnClickListener(this.lGN);
        this.lDm.setEnabled(false);
        this.lGG.setInputType(8194);
        this.lGG.addTextChangedListener(this.lGP);
        this.lGG.pqM.setFilters(new InputFilter[]{new LengthFilter(12)});
        this.lGH = (TextView) findViewById(R.h.cHX);
        this.lGH.setOnClickListener(this.lGO);
        this.lGI = (TextView) findViewById(R.h.cHV);
        this.lGC = (EmojiStoreV2RewardBannerView) findViewById(R.h.bML);
        this.lGD = (GridInScrollView) findViewById(16908298);
        this.lGJ = new b(this);
        this.lGD.setAdapter(this.lGJ);
        this.lGD.setOnItemClickListener(this);
        this.lGy = (AnimationDrawable) getResources().getDrawable(R.g.bBN);
    }

    private void au() {
        if (this.lCN != null) {
            this.lGH.setVisibility(0);
            this.lGI.setVisibility(0);
            if (this.lCN.wkV == null || bh.ov(this.lCN.wkV.waS)) {
                this.lGC.setBackgroundDrawable(getResources().getDrawable(R.g.bBW));
                this.lGC.setImageDrawable(this.lGy);
                this.lGC.setScaleType(ScaleType.CENTER);
                this.lGy.start();
            } else {
                String str = this.lCN.wkV.waS;
                ar.Hg();
                String G = EmojiLogic.G(com.tencent.mm.z.c.Fp(), this.lyx, str);
                if (com.tencent.mm.a.e.bO(G)) {
                    this.lGC.cR(G, null);
                    this.lGC.setScaleType(ScaleType.FIT_XY);
                    if (this.lGy != null && this.lGy.isRunning()) {
                        this.lGy.stop();
                    }
                } else {
                    o.PA().a(str, this.lGC, f.g(this.lyx, str, new Object[0]), new 7(this, str, G));
                    this.lGC.setBackgroundDrawable(getResources().getDrawable(R.g.bBW));
                    this.lGC.setImageDrawable(this.lGy);
                    this.lGC.setScaleType(ScaleType.CENTER);
                    this.lGy.start();
                }
            }
        } else {
            this.lGH.setVisibility(8);
            this.lGI.setVisibility(8);
        }
        if (this.lCN == null || this.lCN.wkU == null) {
            this.lGD.setVisibility(8);
            return;
        }
        this.lGD.setVisibility(0);
        b bVar = this.lGJ;
        Collection collection = this.lCN.wkU;
        if (bVar.lGr == null) {
            bVar.lGr = new LinkedList();
        }
        bVar.lGr.clear();
        bVar.lGr.addAll(collection);
        bVar.notifyDataSetChanged();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.lGJ != null) {
            sm oT = this.lGJ.oT(i);
            if (oT != null) {
                x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[]{Integer.valueOf(i)});
                a(this.lyx, oT);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 8001:
                if (i2 == -1) {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, EmojiStoreV2RewardThanksUI.class);
                    intent2.putExtra("extra_id", this.lyx);
                    startActivity(intent2);
                    g.pQN.h(12738, new Object[]{this.lyx, Integer.valueOf(this.lGB), Integer.valueOf(this.lxO), Integer.valueOf(1)});
                    g.pQN.a(408, 9, 1, false);
                    eE(true);
                    finish();
                    return;
                } else if (i2 == 0) {
                    g.pQN.h(12738, new Object[]{this.lyx, Integer.valueOf(this.lGB), Integer.valueOf(this.lxO), Integer.valueOf(3)});
                    g.pQN.a(408, 3, 1, false);
                    return;
                } else {
                    if (!this.lGM) {
                        this.lGM = true;
                        g.pQN.h(12738, new Object[]{this.lyx, Integer.valueOf(this.lGB), Integer.valueOf(this.lxO), Integer.valueOf(2)});
                    }
                    g.pQN.a(408, 4, 1, false);
                    return;
                }
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
        switch (kVar.getType()) {
            case 822:
                com.tencent.mm.plugin.emoji.f.o oVar = (com.tencent.mm.plugin.emoji.f.o) kVar;
                if (i == 0 && i2 == 0) {
                    x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
                    this.lCN = oVar.aBW();
                    o.PA().a(this.lCN.wkV.waT, null, f.g(this.lyx, this.lCN.wkV.waT, new Object[0]));
                    this.mHandler.sendEmptyMessage(1002);
                    return;
                }
                x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
                return;
            case 830:
                b bVar = (b) kVar;
                if (i == 0 && i2 == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("extinfo_key_10", true);
                    Context context = this.mController.xIM;
                    String str2 = bVar.aBN().vIT;
                    String str3 = bVar.aBN().nfn;
                    if (!bh.ov(str2)) {
                        PayInfo a = h.a(str2, str3, null, null, 5, 0);
                        a.vzx = bundle;
                        h.a(context, a, 8001);
                        return;
                    }
                    return;
                } else if (i == 4) {
                    if (!this.lGM) {
                        this.lGM = true;
                        g.pQN.h(12738, new Object[]{this.lyx, Integer.valueOf(this.lGB), Integer.valueOf(this.lxO), Integer.valueOf(2)});
                    }
                    if (i2 == b.lyu) {
                        g.pQN.a(408, 6, 1, false);
                        if (bh.ov(str)) {
                            yE(getString(R.l.eaM));
                            return;
                        } else {
                            yE(str);
                            return;
                        }
                    } else if (i2 == b.lyv) {
                        g.pQN.a(408, 7, 1, false);
                        if (bh.ov(str)) {
                            yE(getString(R.l.eaO));
                            return;
                        } else {
                            yE(str);
                            return;
                        }
                    } else if (i2 == b.lyw) {
                        g.pQN.a(408, 5, 1, false);
                        if (bh.ov(str)) {
                            yE(getString(R.l.eaN));
                            return;
                        } else {
                            yE(str);
                            return;
                        }
                    } else {
                        g.pQN.a(408, 8, 1, false);
                        Toast.makeText(this, getString(R.l.eam), 0).show();
                        return;
                    }
                } else {
                    if (!this.lGM) {
                        this.lGM = true;
                        g.pQN.h(12738, new Object[]{this.lyx, Integer.valueOf(this.lGB), Integer.valueOf(this.lxO), Integer.valueOf(2)});
                    }
                    g.pQN.a(408, 8, 1, false);
                    Toast.makeText(this, getString(R.l.eam), 0).show();
                    return;
                }
            default:
                x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", new Object[]{Integer.valueOf(kVar.getType())});
                return;
        }
    }

    private void a(String str, sm smVar) {
        aCw();
        this.lGK = new b(str, smVar);
        ar.CG().a(this.lGK, 0);
    }

    private void aCw() {
        getString(R.l.dGO);
        this.ltM = com.tencent.mm.ui.base.h.a(this, getString(R.l.dHc), true, new 8(this));
    }

    private void yE(String str) {
        com.tencent.mm.ui.base.h.a(this.mController.xIM, str, null, getString(R.l.eah), new 9(this));
    }

    private void eE(boolean z) {
        x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
        if (z) {
            ar.CG().a(new com.tencent.mm.plugin.emoji.f.o(this.lyx, com.tencent.mm.plugin.emoji.f.o.lze), 0);
            return;
        }
        ar.CG().a(new com.tencent.mm.plugin.emoji.f.o(this.lyx, com.tencent.mm.plugin.emoji.f.o.lzf), 0);
        aCw();
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
