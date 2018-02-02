package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.b.i;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public class CardIndexUI extends CardBaseUI {
    private final String TAG = "MicroMsg.CardIndexUI";
    int fromScene = 0;
    private View kTD;
    private TextView kTE;
    private f kTF;
    private TextView kTG;
    private TextView kTH;
    private ImageView kTI;
    private LinearLayout kTJ;
    int kTK = -1;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CardIndexUI", "oncreate");
        this.mStartTime = System.currentTimeMillis();
        initView();
        ar.CG().a(984, this);
        am.auz();
        b.nF(1);
        int i = am.auE().kJG;
        if (c.Bq().aQ(262152, 266256) || i > 0) {
            g.pQN.h(11324, new Object[]{"CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), ""});
            return;
        }
        g.pQN.h(11324, new Object[]{"CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), ""});
    }

    protected void onDestroy() {
        ar.CG().b(984, this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        g.pQN.h(13219, new Object[]{"CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis)});
        super.onDestroy();
    }

    protected final void initView() {
        if (getIntent() != null) {
            this.kTK = getIntent().getIntExtra("key_card_type", -1);
        }
        super.initView();
    }

    protected final void asS() {
        if (1 == this.kTK) {
            setMMTitle(R.l.dOF);
        } else if (3 == this.kTK) {
            setMMTitle(R.l.dPM);
        } else {
            setMMTitle(R.l.eLK);
        }
        this.kTG = (TextView) findViewById(R.h.cAr);
        this.kTH = (TextView) findViewById(R.h.cAs);
        this.kTI = (ImageView) findViewById(R.h.cAp);
        this.kTD = findViewById(R.h.bQw);
        this.kTE = (TextView) findViewById(R.h.bQx);
        this.kTJ = (LinearLayout) findViewById(R.h.cAq);
        this.kTD.setVisibility(8);
        this.kTH.setVisibility(0);
        this.kTG.setVisibility(0);
        this.kTI.setVisibility(8);
        LayoutParams layoutParams = (LayoutParams) this.kTJ.getLayoutParams();
        layoutParams.topMargin = BackwardSupportUtil.b.b(this, 100.0f);
        this.kTJ.setLayoutParams(layoutParams);
        if (1 == this.kTK) {
            this.kTH.setText(getString(R.l.dOw));
            this.kTG.setText(getString(R.l.dOv));
        } else if (3 == this.kTK) {
            this.kTH.setText(getString(R.l.dOA));
            this.kTG.setText(getString(R.l.dOz));
        } else {
            this.kTH.setText(getString(R.l.dOX));
            this.kTG.setText(getString(R.l.dPf));
        }
        this.kTE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CardIndexUI kTL;

            {
                this.kTL = r1;
            }

            public final void onClick(View view) {
                if (!TextUtils.isEmpty(this.kTL.kTF.kLf)) {
                    com.tencent.mm.plugin.card.b.b.a(this.kTL, this.kTL.kTF.kLf, 0);
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onStop() {
        super.onStop();
    }

    protected final int asT() {
        if (1 == this.kTK) {
            return a.kLK;
        }
        if (3 == this.kTK) {
            return a.kLJ;
        }
        return a.kLG;
    }

    protected final BaseAdapter asU() {
        if (3 == this.kTK) {
            return new k(this, asT());
        }
        return new c(this, asT());
    }

    public final void a(int i, int i2, String str, k kVar) {
        super.a(i, i2, str, kVar);
        if (i != 0 || i2 != 0) {
            return;
        }
        if (kVar instanceof com.tencent.mm.plugin.card.model.x) {
            ar.Hg();
            this.kTF = i.wM((String) com.tencent.mm.z.c.CU().get(282885, ""));
            if (this.kTF == null) {
                this.kTF = new f();
            }
            if (!(this.kTF == null || TextUtils.isEmpty(this.kTF.kLd))) {
                this.kTG.setText(this.kTF.kLd);
            }
            if (this.kTF == null || !this.kTF.kLg) {
                this.kTD.setVisibility(8);
                return;
            }
            this.kTE.setText(this.kTF.kLe);
            if (TextUtils.isEmpty(this.kTF.kLe) || TextUtils.isEmpty(this.kTF.kLf)) {
                this.kTD.setVisibility(8);
            } else {
                this.kTD.setVisibility(0);
            }
        } else if ((kVar instanceof ad) && ((ad) kVar).kMd && (this.kIf instanceof c)) {
            ((c) this.kIf).lU(false);
            ((c) this.kIf).lU(true);
            ((c) this.kIf).Xy();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
