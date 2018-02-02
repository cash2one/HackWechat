package com.tencent.mm.plugin.traceroute.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import org.xwalk.core.R$styleable;

public class NetworkDiagnoseAllInOneUI extends MMActivity implements OnClickListener {
    private ImageView fvf;
    private a$a gyF;
    private ak ikI;
    private Button krY;
    private c nXT;
    private int sfj;
    private TextView sfk;
    private TextView sfl;
    private TextView sfm;
    private TextView sfn;
    private r sfo;
    private int sfp;
    private String sfq;
    private com.tencent.mm.sdk.b.c<kc> sfr;
    private boolean sfs;
    private boolean sft;
    private boolean sfu;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.a.bqo, R.a.bpQ);
        setMMTitle("");
        getSupportActionBar().hide();
        Intent intent = getIntent();
        this.sfj = intent.getIntExtra("diagnose_state", 0);
        this.sfp = intent.getIntExtra("diagnose_percent", 1);
        this.sfq = intent.getStringExtra("diagnose_kvInfo");
        x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", new Object[]{Integer.valueOf(this.sfj), Integer.valueOf(this.sfp), this.sfq});
        if (this.sfj == 0) {
            this.sfj = 1;
            x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
            ar.CG().a(new bd(new 4(this)), 0);
        }
        this.krY = (Button) findViewById(R.h.cbz);
        this.sfk = (TextView) findViewById(R.h.cbx);
        this.sfl = (TextView) findViewById(R.h.cbw);
        this.fvf = (ImageView) findViewById(R.h.cbB);
        this.sfm = (TextView) findViewById(R.h.cbC);
        this.sfn = (TextView) findViewById(R.h.cby);
        this.sfk.setOnClickListener(this);
        this.krY.setOnClickListener(this);
        this.sfl.setOnClickListener(this);
        biE();
        this.sfr = new 1(this);
        a.xef.a(this.sfr);
        this.gyF = new 2(this);
        this.ikI = new ak(new 3(this), true);
        if (this.sfj == 0 || this.sfj == 1) {
            this.ikI.J(1000, 1000);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bqm);
    }

    protected final int getLayoutId() {
        return R.i.doS;
    }

    private void biE() {
        x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", new Object[]{Integer.valueOf(this.sfj)});
        switch (this.sfj) {
            case 0:
            case 1:
                this.fvf.setImageResource(R.k.dzv);
                this.sfm.setText(getString(R.l.dYE, new Object[]{Integer.valueOf(this.sfp)}));
                this.sfn.setText(R.l.dYz);
                this.krY.setVisibility(4);
                this.sfl.setVisibility(4);
                return;
            case 2:
                this.fvf.setImageResource(R.k.dzv);
                this.sfm.setText(R.l.dYI);
                this.sfn.setText(R.l.dYC);
                this.krY.setVisibility(0);
                this.sfl.setVisibility(4);
                return;
            case 3:
                Intent intent = new Intent();
                intent.putExtra("title", R.l.exE);
                intent.putExtra("rawUrl", getString(R.l.exB));
                intent.putExtra("showShare", false);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                ja(false);
                finish();
                return;
            case 4:
                this.fvf.setImageResource(R.k.dzt);
                this.sfm.setText(R.l.dYH);
                this.sfn.setText(R.l.dYA);
                this.krY.setVisibility(0);
                this.krY.setText(R.l.dYx);
                this.sfl.setVisibility(0);
                return;
            case 5:
                this.fvf.setImageResource(R.k.dzt);
                this.sfm.setText(R.l.dYF);
                this.sfn.setText(R.l.dYA);
                this.krY.setVisibility(0);
                this.krY.setText(R.l.dYx);
                this.sfl.setVisibility(0);
                return;
            case 6:
                this.fvf.setImageResource(R.k.dzu);
                this.sfm.setText(R.l.dYG);
                this.sfn.setText(R.l.dYB);
                this.krY.setVisibility(0);
                this.krY.setText(R.l.dYw);
                this.sfl.setVisibility(4);
                return;
            default:
                return;
        }
    }

    private void ja(boolean z) {
        if (!bh.ov(this.sfq)) {
            x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", new Object[]{Boolean.valueOf(z)});
            if (!z) {
                g.pQN.k(14533, "," + this.sfq);
            } else if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 71, "", "")) {
                getString(R.l.dGO);
                this.sfo = h.a(this, getString(R.l.dYJ), true, null);
                this.krY.setEnabled(false);
                if (this.nXT == null) {
                    this.nXT = c.OP();
                }
                this.nXT.a(this.gyF, true);
            }
            this.sfq = null;
        }
    }

    public void onClick(View view) {
        if ((this.sfj == 5 || this.sfj == 4) && view == this.krY) {
            ja(true);
            return;
        }
        ja(false);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        a.xef.c(this.sfr);
        if (this.nXT != null) {
            this.nXT.c(this.gyF);
            this.nXT = null;
        }
        if (this.ikI != null) {
            this.ikI.TG();
            this.ikI = null;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case R$styleable.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                if (iArr[0] == 0) {
                    ja(true);
                    return;
                } else {
                    h.a(this, getString(R.l.ezP), getString(R.l.ezT), getString(R.l.est), getString(R.l.ezN), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ NetworkDiagnoseAllInOneUI sfv;

                        {
                            this.sfv = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.sfv.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new 6(this));
                    return;
                }
            default:
                return;
        }
    }
}
