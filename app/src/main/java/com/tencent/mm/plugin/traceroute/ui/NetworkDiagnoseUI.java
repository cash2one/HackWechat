package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class NetworkDiagnoseUI extends MMActivity {
    private af handler = new 2(this);
    private TextView moY;
    private int oAN = 0;
    private final int sfK = 100;
    private int sfL = 0;
    private a sfM;
    private MMProgressBar sfN;
    private ak sfO = new ak(new 1(this), true);

    static /* synthetic */ void a(NetworkDiagnoseUI networkDiagnoseUI, boolean z) {
        Intent intent = new Intent(networkDiagnoseUI, NetworkDiagnoseReportUI.class);
        intent.putExtra("diagnose_result", z);
        if (!z) {
            intent.putExtra("diagnose_log_file_path", a.seO);
        }
        networkDiagnoseUI.startActivity(intent);
        networkDiagnoseUI.finish();
    }

    static /* synthetic */ void e(NetworkDiagnoseUI networkDiagnoseUI) {
        networkDiagnoseUI.sfO.TG();
        if (networkDiagnoseUI.sfM != null) {
            networkDiagnoseUI.sfM.stop();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.moY = (TextView) findViewById(R.h.cHI);
        this.sfN = (MMProgressBar) findViewById(R.h.cbA);
        this.sfN.ycn = new MMProgressBar.a(this) {
            final /* synthetic */ NetworkDiagnoseUI sfP;

            {
                this.sfP = r1;
            }

            public final void yq(int i) {
                if (i < 5) {
                    this.sfP.moY.setText(this.sfP.getString(R.l.dUq));
                } else if (i < 5 || i >= 95) {
                    this.sfP.moY.setText(this.sfP.getString(R.l.eSk));
                } else {
                    this.sfP.moY.setText(this.sfP.getString(R.l.enB));
                }
            }
        };
        setMMTitle("");
        setBackBtn(new 4(this));
        new af().postDelayed(new 5(this), 200);
    }

    protected final int getLayoutId() {
        return R.i.doV;
    }

    protected void onPause() {
        this.sfN.ml(false);
        super.onPause();
    }

    protected void onResume() {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            this.sfN.ml(true);
            super.onResume();
            return;
        }
        u.fI(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bFz();
        return true;
    }

    private void bFz() {
        h.a(this, R.l.dTU, R.l.dYy, R.l.dHd, R.l.dFR, new 7(this), new 8(this));
    }
}
