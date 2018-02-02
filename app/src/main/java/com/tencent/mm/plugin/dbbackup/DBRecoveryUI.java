package com.tencent.mm.plugin.dbbackup;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.dbbackup.a.a;
import com.tencent.mm.plugin.dbbackup.a.a.b;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;

public class DBRecoveryUI extends MMActivity implements b {
    private static final int[] lpE = new int[]{0, 5, 70, 80, 90, 100, 100};
    private int irz;
    private View lpA;
    private int lpB;
    private boolean lpC;
    private OnClickListener lpD = new 1(this);
    private a lpv;
    private View lpw;
    private View lpx;
    private ProgressBar lpy;
    private TextView lpz;

    static /* synthetic */ void e(DBRecoveryUI dBRecoveryUI) {
        if (dBRecoveryUI.lpv != null) {
            x.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
            return;
        }
        StringBuilder append = new StringBuilder().append(q.yE());
        g.Dh();
        byte[] bytes = append.append(com.tencent.mm.kernel.a.Cg()).toString().getBytes();
        String CQ = g.Dj().CQ();
        String path = g.Dj().gQj.getPath();
        String str = path + "-recovery";
        dBRecoveryUI.lpB = 0;
        String str2 = g.Dj().gQi + "dbback/";
        a.a aVar = new a.a();
        aVar.lqI = dBRecoveryUI;
        aVar.lqF = com.tencent.mm.a.g.t(bytes);
        aVar.lqG = com.tencent.mm.a.g.s(bytes).substring(0, 7).getBytes();
        aVar.lqB = CQ;
        aVar.lqA = path;
        aVar.lqz = str;
        aVar.lqC = g.Dj().cachePath + "heavyDetailInfo";
        aVar.lqH = dBRecoveryUI.irz == 0;
        a.a xz = aVar.xy(CQ + ".sm").xz(CQ + ".bak").xy(str2 + "corrupted/EnMicroMsg.db.sm").xz(str2 + "corrupted/EnMicroMsg.db.bak").xy(str2 + "EnMicroMsg.db.sm").xz(str2 + "EnMicroMsg.db.bak");
        a aVar2 = new a((byte) 0);
        a.a(aVar2, xz.lqz);
        a.b(aVar2, xz.lqA);
        a.c(aVar2, xz.lqB);
        a.d(aVar2, xz.lqC);
        a.a(aVar2, new ArrayList(xz.lqD));
        a.b(aVar2, new ArrayList(xz.lqE));
        a.a(aVar2, Arrays.copyOf(xz.lqF, xz.lqF.length));
        a.b(aVar2, Arrays.copyOf(xz.lqG, xz.lqG.length));
        a.a(aVar2, xz.lqH);
        a.a(aVar2, xz.lqI);
        dBRecoveryUI.lpv = aVar2;
        dBRecoveryUI.lpv.execute(new Void[0]);
        dBRecoveryUI.lpC = true;
    }

    static /* synthetic */ void f(DBRecoveryUI dBRecoveryUI) {
        if (dBRecoveryUI.lpv != null) {
            dBRecoveryUI.lpv.mCancellationSignal.cancel();
            x.i("MicroMsg.DBRecoveryTask", "Recovery cancel triggered.");
            dBRecoveryUI.lpv = null;
            return;
        }
        x.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.irz = getIntent().getIntExtra("scene", 2);
        this.lpC = false;
        setMMTitle(R.l.dXY);
        this.lpw = findViewById(R.h.cPh);
        this.lpx = findViewById(R.h.ccs);
        this.lpy = (ProgressBar) findViewById(R.h.cDY);
        this.lpz = (TextView) findViewById(R.h.cEb);
        View findViewById = findViewById(R.h.cPe);
        findViewById.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ DBRecoveryUI lpF;

            {
                this.lpF = r1;
            }

            public final void onClick(View view) {
                if (g.Dj().CQ() == null) {
                    h.h(this.lpF, R.l.dYb, R.l.dGO);
                    return;
                }
                this.lpF.lpw.setVisibility(8);
                this.lpF.lpx.setVisibility(0);
                this.lpF.lpA.setEnabled(true);
                DBRecoveryUI.e(this.lpF);
            }
        });
        this.lpA = findViewById(R.h.bPo);
        this.lpA.setOnClickListener(new 3(this));
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ DBRecoveryUI lpF;

            {
                this.lpF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.lpF.lpC) {
                    this.lpF.lpA.callOnClick();
                } else {
                    this.lpF.finish();
                }
                return true;
            }
        });
        if (this.irz == 0) {
            findViewById.callOnClick();
        }
        d.pPH.a(181, (long) (this.irz + 51), 1, true);
    }

    public void onBackPressed() {
        if (this.lpC) {
            this.lpA.callOnClick();
        } else {
            finish();
        }
    }

    protected final int getLayoutId() {
        return R.i.dfp;
    }

    public final void I(int i, int i2, int i3) {
        float f = 1.0f;
        if (i > 0 && i <= 6) {
            if (i3 > 0) {
                int i4 = lpE[i - 1];
                int i5 = lpE[i] - i4;
                float f2 = ((float) i2) / ((float) i3);
                if (f2 <= 1.0f) {
                    f = f2;
                }
                this.lpy.setProgress((int) ((f * ((float) i5)) + ((float) i4)));
            } else if (this.lpB != i) {
                this.lpy.setProgress(lpE[i - 1]);
            }
            this.lpB = i;
            String str = getResources().getStringArray(R.c.bqO)[i - 1];
            this.lpz.setText(String.format(str, new Object[]{Integer.valueOf(i2)}));
        }
    }

    public final void p(long j, long j2) {
        this.lpC = false;
        azC();
        h.a(this, getString(R.l.dYc, new Object[]{Long.valueOf((j2 / 1024) / 1024), Long.valueOf((j / 1024) / 1024)}), getString(R.l.cRU), false, this.lpD);
    }

    public final void onSuccess() {
        this.lpC = false;
        ag.h(new 6(this, h.a(this, R.l.dYd, R.l.dGO, false, new 5(this))), 5000);
    }

    public final void azB() {
        this.lpC = false;
        azC();
        h.a(this, R.l.dXZ, R.l.cRU, false, this.lpD);
    }

    public final void afG() {
        this.lpC = false;
        azC();
        h.a(this, R.l.dYa, R.l.cRU, false, this.lpD);
    }

    private static void azC() {
        t CU = g.Dj().CU();
        CU.set(89, Integer.valueOf(2));
        CU.lH(true);
    }
}
