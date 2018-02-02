package com.tencent.mm.plugin.card.sharecard.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.protocal.c.ko;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CardConsumeSuccessUI extends DrawStatusBarActivity implements e {
    private View Iv;
    private final String TAG = "MicroMsg.CardConsumeSuccessUI";
    private OnClickListener inN = new OnClickListener(this) {
        final /* synthetic */ CardConsumeSuccessUI kOz;

        {
            this.kOz = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.bIf) {
                CardConsumeSuccessUI.a(this.kOz);
            } else if (view.getId() == R.h.cPE) {
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", this.kOz.kOu);
                intent.putExtra("Klabel_name_list", this.kOz.kOv);
                intent.putExtra("Kother_user_name_list", this.kOz.kOw);
                intent.putExtra("k_sns_label_ui_title", this.kOz.getString(R.l.dPl));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("KLabel_is_filter_private", true);
                d.b(this.kOz, "sns", ".ui.SnsLabelUI", intent, 1);
            }
        }
    };
    private r jmO = null;
    af jzN = new af(Looper.getMainLooper());
    private String kIw = "";
    private String kJJ = "";
    private TextView kNW;
    private TextView kNX;
    private TextView kOi;
    private TextView kOj;
    private TextView kOk;
    private TextView kOl;
    private ImageView kOm;
    private Button kOn;
    private CheckBox kOo;
    private j kOp;
    private String kOq = "";
    private String kOr = "";
    int kOs = 0;
    int kOt = 0;
    public int kOu = 0;
    private String kOv = "";
    private String kOw = "";
    public ArrayList<String> kOx = new ArrayList();
    public ArrayList<String> kOy = new ArrayList();
    private long mStartTime = 0;

    static /* synthetic */ void a(CardConsumeSuccessUI cardConsumeSuccessUI) {
        if (cardConsumeSuccessUI.kOp == null || cardConsumeSuccessUI.kOp.kNi == null || cardConsumeSuccessUI.kOp.kNi.isEmpty()) {
            x.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list == null || mConsumedInfo.list.isEmpty()!");
            return;
        }
        cardConsumeSuccessUI.dY(true);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardConsumeSuccessUI.kOp.kNi.size(); i++) {
            ko koVar = ((q) cardConsumeSuccessUI.kOp.kNi.get(i)).kKS;
            bia com_tencent_mm_protocal_c_bia = new bia();
            if (koVar != null) {
                com_tencent_mm_protocal_c_bia.kJN = koVar.kJN;
                cardConsumeSuccessUI.kJJ = koVar.kJN;
            }
            com_tencent_mm_protocal_c_bia.fGV = ((q) cardConsumeSuccessUI.kOp.kNi.get(i)).fGV;
            com_tencent_mm_protocal_c_bia.vEH = "";
            com_tencent_mm_protocal_c_bia.vEG = "";
            com_tencent_mm_protocal_c_bia.vEI = cardConsumeSuccessUI.kOt;
            linkedList.add(com_tencent_mm_protocal_c_bia);
        }
        String str = cardConsumeSuccessUI.kOs == 1 ? cardConsumeSuccessUI.kOp.kNj : cardConsumeSuccessUI.kIw;
        bii a = l.a(cardConsumeSuccessUI.kOu, cardConsumeSuccessUI.kOx, cardConsumeSuccessUI.kOy);
        k gVar = cardConsumeSuccessUI.kOo.isChecked() ? new g(0, linkedList, cardConsumeSuccessUI.kOp.kNl, str, a, 20, null) : new g(0, linkedList, "", str, a, 20, null);
        if (cardConsumeSuccessUI.kOo != null && cardConsumeSuccessUI.kOo.getVisibility() == 0) {
            if (cardConsumeSuccessUI.kOo.isChecked()) {
                com.tencent.mm.plugin.report.service.g.pQN.h(11324, new Object[]{"CardConsumeSuccessFollowServices", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.h(11324, new Object[]{"CardConsumeSuccessView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
            }
        }
        ar.CG().a(gVar, 0);
    }

    private void dY(boolean z) {
        if (z) {
            this.jmO = r.b(this, getString(R.l.ctB), true, 0, null);
        } else if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
            this.jmO = null;
        }
    }

    protected final int getLayoutId() {
        return R.i.dbS;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
        this.mStartTime = System.currentTimeMillis();
        setMMTitle("");
        setResult(0);
        ar.CG().a(902, this);
        ar.CG().a(910, this);
        String str = "";
        this.kOs = getIntent().getIntExtra("key_from_scene", 0);
        if (this.kOs == 1) {
            x.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
            this.kOq = getIntent().getStringExtra("key_consumed_card_id");
            this.kOr = getIntent().getStringExtra("key_consumed_Code");
            if (TextUtils.isEmpty(this.kOq)) {
                x.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
                nO(0);
                finish();
                return;
            }
            x.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.kOr);
            dY(true);
            ar.CG().a(new com.tencent.mm.plugin.card.sharecard.model.d("", this.kOq, this.kOr), 0);
            avb();
            this.kOt = 7;
        } else if (this.kOs == 2) {
            x.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
            this.kIw = getIntent().getStringExtra("key_card_id");
            if (TextUtils.isEmpty(this.kIw)) {
                x.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                nO(0);
                finish();
                return;
            }
            x.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.kIw);
            dY(true);
            ar.CG().a(new com.tencent.mm.plugin.card.sharecard.model.d(this.kIw, "", ""), 0);
            avb();
            this.kOt = 4;
        } else {
            x.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
            this.kIw = getIntent().getStringExtra("KEY_CARD_ID");
            if (ww(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON"))) {
                String str2;
                if (!(this.kOp == null || bh.cA(this.kOp.kNi))) {
                    ko koVar = ((q) this.kOp.kNi.get(0)).kKS;
                    if (koVar != null) {
                        str2 = koVar.hbM;
                        if (bh.ov(str2)) {
                            str2 = getIntent().getStringExtra("KEY_CARD_COLOR");
                        }
                        this.kOt = getIntent().getIntExtra("key_stastic_scene", 0);
                        str = str2;
                    }
                }
                str2 = str;
                if (bh.ov(str2)) {
                    str2 = getIntent().getStringExtra("KEY_CARD_COLOR");
                }
                this.kOt = getIntent().getIntExtra("key_stastic_scene", 0);
                str = str2;
            } else {
                x.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                nO(0);
                finish();
                return;
            }
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(11324, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.kOt), "", Integer.valueOf(0), ""});
        initView();
        if (!TextUtils.isEmpty(r1)) {
            wx(r1);
        }
    }

    private boolean ww(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
            return false;
        }
        this.kOp = com.tencent.mm.plugin.card.b.r.wX(str);
        if (this.kOp != null) {
            return true;
        }
        x.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is " + str);
        return false;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        ar.CG().b(902, this);
        ar.CG().b(910, this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (TextUtils.isEmpty(this.kIw)) {
            com.tencent.mm.plugin.report.service.g.pQN.h(13219, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(this.kOs), this.kJJ, this.kOq, Long.valueOf(currentTimeMillis)});
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.h(13219, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(this.kOs), this.kJJ, this.kIw, Long.valueOf(currentTimeMillis)});
        }
        super.onDestroy();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        this.Iv = this.mController.contentView;
        this.kNW = (TextView) findViewById(R.h.bPP);
        this.kNX = (TextView) findViewById(R.h.bRx);
        this.kOi = (TextView) findViewById(R.h.bQk);
        this.kOj = (TextView) findViewById(R.h.cPF);
        this.kOk = (TextView) findViewById(R.h.cPE);
        this.kOl = (TextView) findViewById(R.h.cPD);
        this.kOm = (ImageView) findViewById(R.h.bQY);
        this.kOn = (Button) findViewById(R.h.bIf);
        this.kOo = (CheckBox) findViewById(R.h.bLr);
        this.kOn.setOnClickListener(this.inN);
        this.kOo.setOnClickListener(this.inN);
        this.kOk.setOnClickListener(this.inN);
        if (this.kOp != null) {
            au();
        }
    }

    private void au() {
        if (this.kOp == null) {
            x.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
            return;
        }
        findViewById(R.h.cIv).setVisibility(0);
        if (TextUtils.isEmpty(this.kOp.kNk) || TextUtils.isEmpty(this.kOp.kNl)) {
            this.kOo.setVisibility(8);
            x.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
        } else {
            this.kOo.setText(this.kOp.kNk);
            this.kOo.setVisibility(0);
        }
        if (this.kOp.kNi == null || this.kOp.kNi.size() <= 0) {
            this.kOn.setEnabled(false);
            x.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
            return;
        }
        this.kOj.setText(getString(R.l.dNV, new Object[]{Integer.valueOf(this.kOp.kNi.size())}));
        ko koVar = ((q) this.kOp.kNi.get(0)).kKS;
        if (koVar != null) {
            wx(koVar.hbM);
            this.kNW.setText(koVar.kLa);
            this.kNX.setText(koVar.title);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bwt);
            if (TextUtils.isEmpty(koVar.kJP)) {
                x.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
                this.kOm.setImageResource(R.g.bDT);
            } else {
                c$a com_tencent_mm_aq_a_a_c_a = new c$a();
                com_tencent_mm_aq_a_a_c_a.hDD = com.tencent.mm.compatible.util.e.bnF;
                o.PB();
                com_tencent_mm_aq_a_a_c_a.hDW = null;
                com_tencent_mm_aq_a_a_c_a.hDC = m.wk(koVar.kJP);
                com_tencent_mm_aq_a_a_c_a.hDA = true;
                com_tencent_mm_aq_a_a_c_a.hDY = true;
                com_tencent_mm_aq_a_a_c_a.hDy = true;
                com_tencent_mm_aq_a_a_c_a.hDH = dimensionPixelSize;
                com_tencent_mm_aq_a_a_c_a.hDG = dimensionPixelSize;
                com_tencent_mm_aq_a_a_c_a.hDP = R.g.bDT;
                o.PA().a(koVar.kJP, this.kOm, com_tencent_mm_aq_a_a_c_a.PK());
            }
            if (TextUtils.isEmpty(koVar.vRR)) {
                this.kOn.setText(R.l.dNT);
                return;
            }
            x.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
            this.kOn.setText(koVar.vRR);
            return;
        }
        x.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    }

    private void avb() {
        this.mController.contentView.setBackgroundColor(getResources().getColor(R.e.brI));
        findViewById(R.h.cIv).setVisibility(4);
    }

    @TargetApi(16)
    private void wx(String str) {
        int wO = l.wO(str);
        this.Iv.setBackgroundColor(wO);
        com.tencent.mm.plugin.card.b.m.a(this, wO);
        a.d(this.mController.contentView, wO, true);
        if (com.tencent.mm.compatible.util.d.fM(16)) {
            this.kOn.setBackground(l.ch(wO, getResources().getDimensionPixelSize(R.f.bwe) / 2));
        } else {
            this.kOn.setBackgroundDrawable(l.ch(wO, getResources().getDimensionPixelSize(R.f.bwe) / 2));
        }
        this.Iv.invalidate();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " scene cmd is " + kVar.getType());
        dY(false);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof g) {
                g gVar = (g) kVar;
                if (gVar.kLO == 0) {
                    h.bu(this, getString(R.l.dNz));
                    setResult(-1);
                    this.kOn.setEnabled(false);
                    l.axg();
                    x.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
                    nO(-1);
                    String str2 = ((g) kVar).kLN;
                    ShareCardInfo shareCardInfo = new ShareCardInfo();
                    f.a(shareCardInfo, str2);
                    l.a(shareCardInfo);
                    am.auH().asi();
                    finish();
                    return;
                }
                x.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + gVar.kLO);
                com.tencent.mm.plugin.card.b.d.b(this, gVar.kLP);
                h.bu(this, getString(R.l.dNw));
            } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) kVar;
                if (dVar.kLO == 0) {
                    if (TextUtils.isEmpty(dVar.kLN) || !ww(dVar.kLN)) {
                        x.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
                        if (this.kOs == 1) {
                            nO(0);
                            finish();
                            return;
                        }
                        avb();
                        wy(dVar.kLP);
                        if (bh.ov(dVar.kLP)) {
                            h.bu(this, getString(R.l.dNy));
                            return;
                        } else {
                            h.bu(this, dVar.kLP);
                            return;
                        }
                    }
                    x.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
                    this.jzN.post(new Runnable(this) {
                        final /* synthetic */ CardConsumeSuccessUI kOz;

                        {
                            this.kOz = r1;
                        }

                        public final void run() {
                            this.kOz.au();
                        }
                    });
                } else if (this.kOs == 1) {
                    nO(0);
                    finish();
                } else {
                    x.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + dVar.kLO);
                    avb();
                    wy(dVar.kLP);
                }
            }
        } else if ((kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) && this.kOs == 1) {
            nO(0);
            finish();
        } else {
            com.tencent.mm.plugin.card.b.d.b(this, str);
        }
    }

    private void wy(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.dNy);
        }
        h.a((Context) this, str, "", false, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ CardConsumeSuccessUI kOz;

            {
                this.kOz = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                CardConsumeSuccessUI.nO(0);
                this.kOz.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
            nO(0);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static void nO(int i) {
        x.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is " + i);
        b bvVar = new bv();
        bvVar.fpY.bjW = i;
        com.tencent.mm.sdk.b.a.xef.m(bvVar);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.kOu = intent.getIntExtra("Ktag_range_index", 0);
                    x.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.kOu)});
                    if (this.kOu >= 2) {
                        this.kOv = intent.getStringExtra("Klabel_name_list");
                        this.kOw = intent.getStringExtra("Kother_user_name_list");
                        x.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.kOu), this.kOv});
                        if (TextUtils.isEmpty(this.kOv) && TextUtils.isEmpty(this.kOw)) {
                            x.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
                            return;
                        }
                        List asList = Arrays.asList(this.kOv.split(","));
                        this.kOy = l.ao(asList);
                        this.kOx = l.an(asList);
                        if (this.kOw != null && this.kOw.length() > 0) {
                            this.kOx.addAll(Arrays.asList(this.kOw.split(",")));
                        }
                        if (this.kOy != null) {
                            x.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.kOy.size());
                        }
                        if (this.kOx != null) {
                            x.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.kOx.size());
                            Iterator it = this.kOx.iterator();
                            while (it.hasNext()) {
                                x.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (this.kOu == 2) {
                            this.kOl.setVisibility(0);
                            this.kOl.setText(getString(R.l.dPk, new Object[]{avc()}));
                            return;
                        } else if (this.kOu == 3) {
                            this.kOl.setVisibility(0);
                            this.kOl.setText(getString(R.l.dPj, new Object[]{avc()}));
                            return;
                        } else {
                            this.kOl.setVisibility(8);
                            return;
                        }
                    }
                    this.kOl.setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String avc() {
        if (!TextUtils.isEmpty(this.kOv) && !TextUtils.isEmpty(this.kOw)) {
            return this.kOv + "," + l.wS(this.kOw);
        }
        if (!TextUtils.isEmpty(this.kOv)) {
            return this.kOv;
        }
        if (TextUtils.isEmpty(this.kOw)) {
            return "";
        }
        return l.wS(this.kOw);
    }
}
