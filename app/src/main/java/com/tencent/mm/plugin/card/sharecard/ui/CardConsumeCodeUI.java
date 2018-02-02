package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.c.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.j;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public class CardConsumeCodeUI extends DrawStatusBarActivity implements OnClickListener, a, d.a {
    private final String TAG = "MicroMsg.CardConsumeCodeUI";
    private Vibrator kEd;
    private int kFm = 3;
    private b kIK;
    private String kNS;
    private int kNT = 3;
    private int kNU = 0;
    private a kNV;
    private TextView kNW;
    private TextView kNX;
    private LinearLayout kNY;
    private ImageView kNZ;
    private View kOa;
    private LinearLayout kOb;
    private View kOc;
    private TextView kOd;
    private TextView kOe;
    private TextView kOf;
    private boolean kOg = false;

    protected final int getLayoutId() {
        return R.i.dbR;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
        setResult(0);
        this.kIK = (b) getIntent().getParcelableExtra("key_card_info_data");
        this.kFm = getIntent().getIntExtra("key_from_scene", 3);
        this.kNT = getIntent().getIntExtra("key_previous_scene", 3);
        this.kNS = getIntent().getStringExtra("key_mark_user");
        this.kNU = getIntent().getIntExtra("key_from_appbrand_type", 0);
        if (this.kIK == null || this.kIK.atB() == null || this.kIK.atC() == null) {
            x.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            return;
        }
        initView();
        am.auG().m("", "", 3);
    }

    protected final void initView() {
        if (this.kIK.ati()) {
            if (TextUtils.isEmpty(this.kIK.atB().kKZ)) {
                setMMTitle(getString(R.l.dNU, new Object[]{getString(R.l.dcq)}));
            } else {
                setMMTitle(getString(R.l.dNU, new Object[]{this.kIK.atB().kKZ}));
            }
        }
        setBackBtn(new 1(this));
        if (this.kNV == null) {
            this.kNV = new a(this, this.mController.contentView);
            a aVar = this.kNV;
            aVar.kNP = aVar.kaY.getWindow().getAttributes().screenBrightness;
            a aVar2 = this.kNV;
            aVar2.kNI = (TextView) aVar2.kND.findViewById(R.h.bRz);
            aVar2.kNJ = (TextView) aVar2.kND.findViewById(R.h.bRF);
            aVar2.kNK = (CheckBox) aVar2.kND.findViewById(R.h.cBo);
            aVar2.kNK.setChecked(true);
            aVar2.kNK.setOnClickListener(aVar2.inN);
            if (aVar2.kNP < 0.8f) {
                aVar2.ae(0.8f);
            }
            this.kNV.kNO = new a.a(this) {
                final /* synthetic */ CardConsumeCodeUI kOh;

                {
                    this.kOh = r1;
                }

                public final void nN(int i) {
                    am.auM().A(this.kOh.kIK.atF(), i, 1);
                }
            };
        }
        this.kNV.kIK = this.kIK;
        this.kNV.kNN = true;
        if (this.kIK.ath()) {
            aVar = this.kNV;
            String str = this.kNS;
            aVar.kNM = 1;
            aVar.kNL = str;
        }
        this.kEd = (Vibrator) getSystemService("vibrator");
        this.kNW = (TextView) findViewById(R.h.bOV);
        this.kNX = (TextView) findViewById(R.h.title);
        this.kNY = (LinearLayout) findViewById(R.h.bKC);
        this.kNZ = (ImageView) findViewById(R.h.bKB);
        this.kOa = findViewById(R.h.cal);
        this.kOb = (LinearLayout) findViewById(R.h.bWt);
        if (this.kIK.ati()) {
            findViewById(R.h.bQi).setBackgroundColor(getResources().getColor(R.e.brI));
            m.b(this, true);
            com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, -1, true);
        } else {
            int wO = l.wO(this.kIK.atB().hbM);
            findViewById(R.h.bQi).setBackgroundColor(wO);
            m.a(this, this.kIK);
            com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, wO, true);
        }
        if (!this.kIK.ati() || TextUtils.isEmpty(this.kIK.atB().kJP)) {
            this.kNW.setText(this.kIK.atB().kLa);
            this.kNX.setText(this.kIK.atB().title);
        } else {
            this.kNY.setVisibility(0);
            this.kNW.setVisibility(8);
            this.kNX.setVisibility(8);
            this.kOa.setVisibility(8);
            m.a(this.kNZ, this.kIK.atB().kJP, getResources().getDimensionPixelSize(R.f.bwk), R.g.bDT, true);
        }
        if (this.kIK.atB().vSm != null) {
            oq oqVar = this.kIK.atB().vSm;
            if (!TextUtils.isEmpty(oqVar.title)) {
                if (this.kOc == null) {
                    this.kOc = ((ViewStub) findViewById(R.h.bRG)).inflate();
                }
                this.kOc.setOnClickListener(this);
                this.kOd = (TextView) this.kOc.findViewById(R.h.bRI);
                this.kOe = (TextView) this.kOc.findViewById(R.h.bRH);
                this.kOf = (TextView) this.kOc.findViewById(R.h.bRE);
                this.kOd.setVisibility(0);
                this.kOd.setText(oqVar.title);
                Drawable drawable = getResources().getDrawable(R.g.bAn);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                drawable.setColorFilter(l.wO(this.kIK.atB().hbM), Mode.SRC_IN);
                this.kOd.setCompoundDrawables(null, null, drawable, null);
                this.kOd.setTextColor(l.wO(this.kIK.atB().hbM));
                this.kOd.setOnClickListener(this);
                if (TextUtils.isEmpty(oqVar.kJQ)) {
                    this.kOe.setVisibility(0);
                    this.kOe.setText(getString(R.l.dOG));
                } else {
                    this.kOe.setVisibility(0);
                    this.kOe.setText(oqVar.kJQ);
                }
                if (!TextUtils.isEmpty(oqVar.kJR)) {
                    this.kOf.setVisibility(0);
                    this.kOf.setText(oqVar.kJR);
                }
                LayoutParams layoutParams = this.kNZ.getLayoutParams();
                layoutParams.height = getResources().getDimensionPixelSize(R.f.bwl);
                layoutParams.width = getResources().getDimensionPixelSize(R.f.bwl);
                this.kNZ.setLayoutParams(layoutParams);
                layoutParams = this.kNY.getLayoutParams();
                layoutParams.height = com.tencent.mm.bv.a.fromDPToPix(this, 54);
                layoutParams.width = com.tencent.mm.bv.a.fromDPToPix(this, 54);
                this.kNY.setLayoutParams(layoutParams);
                m.a(this.kNZ, this.kIK.atB().kJP, getResources().getDimensionPixelSize(R.f.bwl), R.g.bDT, true);
                this.kOb.setPadding(0, com.tencent.mm.bv.a.fromDPToPix(this, 10), 0, com.tencent.mm.bv.a.fromDPToPix(this, 30));
            }
        }
        am.auL().a(this);
        if (this.kIK.atv()) {
            am.auN().a(this);
            if (am.auN().isEmpty()) {
                x.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
                am.auN().vV(this.kIK.atF());
                return;
            }
            am.auN().atR();
        }
    }

    protected void onResume() {
        this.kNV.ava();
        am.auL().a(this, true);
        super.onResume();
    }

    protected void onPause() {
        am.auL().a(this, false);
        super.onPause();
    }

    protected void onDestroy() {
        a aVar = this.kNV;
        aVar.ae(aVar.kNP);
        l.u(aVar.inI);
        l.u(aVar.kNH);
        aVar.kNO = null;
        aVar.kaY = null;
        am.auL().c(this);
        am.auL().b(this);
        if (this.kIK.atv()) {
            am.auN().b(this);
            am.auN().atS();
        }
        this.kEd.cancel();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
            setResult(-1);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void f(b bVar) {
        x.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
        if (bVar != null && bVar.atF() != null && bVar.atF().equals(this.kIK.atF())) {
            this.kIK = bVar;
            this.kNV.kIK = this.kIK;
            this.kNV.ava();
        }
    }

    public final void atY() {
        this.kEd.vibrate(300);
    }

    public final void atZ() {
        x.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
        finish();
    }

    public final void vX(String str) {
        x.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
        if (this.kOg) {
            x.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
            return;
        }
        x.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
        this.kOg = true;
        Intent intent = new Intent(this, CardConsumeSuccessUI.class);
        intent.putExtra("KEY_CARD_ID", this.kIK.atF());
        intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
        intent.putExtra("KEY_CARD_COLOR", this.kIK.atB().hbM);
        intent.putExtra("key_stastic_scene", this.kFm);
        intent.putExtra("key_from_scene", 0);
        startActivity(intent);
    }

    public final void atT() {
        this.kNV.ava();
    }

    public final void vU(String str) {
        com.tencent.mm.plugin.card.b.d.a(this, str, true);
    }

    public final void onSuccess() {
        this.kNV.ava();
    }

    public void onClick(View view) {
        if (view.getId() == R.h.bRI || view.getId() == R.h.bRD) {
            if (this.kIK.atu()) {
                j.b bVar = new j.b();
                com.tencent.mm.plugin.card.b.b.a(this, bVar.kJD, bVar.kJE, false, this.kIK);
            } else {
                oq oqVar = this.kIK.atB().vSm;
                if (!(com.tencent.mm.plugin.card.b.b.a(this.kIK.atF(), oqVar, this.kNT, this.kNU) || oqVar == null || TextUtils.isEmpty(oqVar.url))) {
                    com.tencent.mm.plugin.card.b.b.a(this, l.v(oqVar.url, oqVar.vSM), 1);
                    g.pQN.h(11941, new Object[]{Integer.valueOf(9), this.kIK.atF(), this.kIK.atG(), "", oqVar.title});
                    if (l.a(oqVar, this.kIK.atF())) {
                        String atF = this.kIK.atF();
                        String str = oqVar.title;
                        l.wU(atF);
                        com.tencent.mm.plugin.card.b.b.a(this, this.kIK.atB().kLa);
                    }
                }
            }
            finish();
        }
    }
}
