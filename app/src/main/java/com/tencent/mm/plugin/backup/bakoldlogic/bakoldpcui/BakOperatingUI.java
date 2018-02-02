package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public class BakOperatingUI extends MMWizardActivity implements e$d {
    private af handler = new af(Looper.getMainLooper());
    private int krK = -1;
    private boolean krO = false;
    private ProgressBar krP = null;
    private TextView krQ = null;
    private TextView krR = null;
    private TextView krS = null;
    private boolean krT = false;
    private int krU = 0;
    private boolean krV = false;

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.BakOperatingUI", "onCreate");
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            x.i("MicroMsg.BakOperatingUI", "onCreate WizardRootKillSelf cmd:%d", new Object[]{Integer.valueOf(this.krK)});
            return;
        }
        a.aql().aqm().a(this);
        a.aql().aqm().dM(true);
        this.krT = getIntent().getBooleanExtra("from_bak_banner", false);
        if (this.krT) {
            int i = a.aql().aqm().krd;
            if (2 == i || a.aql().aqm().krc == 2) {
                this.krK = 1;
                this.krU = a.aql().aqm().aqw();
            } else if (4 == i) {
                this.krK = 6;
                this.krU = a.aql().aqm().aqw();
            } else if (5 == i) {
                this.krK = 6;
                this.krO = true;
                com.tencent.mm.plugin.backup.a.ifs.up();
                a.aql().aqm().aoC();
            }
        } else {
            this.krK = getIntent().getIntExtra("cmd", 6);
        }
        if (this.krK == 6 && a.aql().aqm().kqW.krn) {
            this.krO = true;
            com.tencent.mm.plugin.backup.a.ifs.up();
            a.aql().aqm().aoC();
        }
        x.i("MicroMsg.BakOperatingUI", "before initView onCreate BakOperatingUI  nowCmd:%d fromBanner:%b status:%d opePercent:%d", new Object[]{Integer.valueOf(this.krK), Boolean.valueOf(this.krT), Integer.valueOf(a.aql().aqm().krd), Integer.valueOf(this.krU)});
        initView();
        if (a.aql().aqm().krc == 2) {
            this.krR.setText(getString(R.l.dKj));
            this.krQ.setText(getString(R.l.dKa) + this.krU + "%");
            this.krS.setText(getString(R.l.dKi));
        } else if (6 == this.krK) {
            if (this.krO) {
                this.krR.setText(getString(R.l.dKh));
                this.krS.setText(getString(R.l.dKg));
                this.krQ.setText(getString(R.l.dJZ) + this.krU + "%");
                return;
            }
            this.krR.setText(getString(R.l.dKk));
            this.krQ.setText(getString(R.l.dKb) + this.krU + "%");
            this.krS.setText(getString(R.l.dKi));
        } else if (1 == this.krK) {
            this.krR.setText(getString(R.l.dKf));
            this.krQ.setText(getString(R.l.dJY) + this.krU + "%");
            this.krS.setText(getString(R.l.dKi));
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dKm);
        if (!this.krO) {
            if (6 == this.krK) {
                addTextOptionMenu(0, getString(R.l.dKc), new 1(this));
            } else if (1 == this.krK) {
                addTextOptionMenu(0, getString(R.l.dJR), new 4(this));
            } else {
                x.e("MicroMsg.BakOperatingUI", "BakOperatingUI operate type is invalid");
            }
        }
        setBackBtn(new 5(this));
        this.krP = (ProgressBar) findViewById(R.h.bMr);
        this.krP.setProgress(this.krU);
        this.krR = (TextView) findViewById(R.h.bMw);
        this.krS = (TextView) findViewById(R.h.bMx);
        this.krQ = (TextView) findViewById(R.h.bMs);
    }

    protected final int getLayoutId() {
        return R.i.daW;
    }

    private void aqG() {
        a.aql().aqm().pause();
        i a = h.a(this, R.l.dKd, 0, R.l.dHd, R.l.dFR, new 6(this), new 7(this));
        a.setCanceledOnTouchOutside(false);
        a.setCancelable(false);
    }

    public void onDestroy() {
        super.onDestroy();
        a.aql().aqm().a(null);
        a.aql().aqm().dM(false);
        x.i("MicroMsg.BakOperatingUI", "BakOperatingUI onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.krK)});
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        a.aql().aqm().dM(true);
        a.aql().aqm().a(this);
        x.i("MicroMsg.BakOperatingUI", "onResume nowCmd:%d", new Object[]{Integer.valueOf(this.krK)});
        super.onResume();
    }

    protected void onPause() {
        a.aql().aqm().dM(false);
        super.onPause();
        x.i("MicroMsg.BakOperatingUI", "onPause nowCmd:%d", new Object[]{Integer.valueOf(this.krK)});
    }

    public final synchronized void mW(final int i) {
        x.d("MicroMsg.BakOperatingUI", "BakOperatingUI onNetProgress percent:%d, isFinishingWizard:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.krV)});
        if (!this.krV) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI krW;

                public final void run() {
                    if (this.krW.krP != null) {
                        this.krW.krP.setProgress(i);
                    }
                    if (this.krW.krQ != null) {
                        int i = R.l.dJY;
                        int i2 = R.l.dKf;
                        if (6 == this.krW.krK) {
                            i = R.l.dKb;
                            i2 = R.l.dKk;
                        }
                        this.krW.krQ.setText(this.krW.getString(i) + i + "%");
                        this.krW.krR.setText(this.krW.getString(i2));
                    }
                }
            });
        }
    }

    public final synchronized void mX(int i) {
        if (!this.krV) {
            x.d("MicroMsg.BakOperatingUI", "BakOperatingUI onMergeProgress percent:%d", new Object[]{Integer.valueOf(i)});
            this.handler.post(new 9(this, i));
        }
    }

    public final synchronized void aqz() {
        x.d("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", new Object[]{Integer.valueOf(this.krK)});
        if (!this.krV) {
            if (6 == this.krK || 5 == a.aql().aqm().krd) {
                this.krK = 6;
                this.krO = true;
                com.tencent.mm.plugin.backup.a.ifs.up();
                a.aql().aqm().aoC();
            } else {
                x.e("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", new Object[]{Integer.valueOf(this.krK)});
            }
            this.handler.post(new 10(this));
        }
    }

    public final synchronized void aok() {
        if (!this.krV) {
            this.krO = false;
            x.d("MicroMsg.BakOperatingUI", "onMergeFinish now cmd:%d", new Object[]{Integer.valueOf(this.krK)});
            this.handler.post(new 11(this));
        }
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        synchronized (this) {
            if (i != 4) {
                z = super.onKeyDown(i, keyEvent);
            } else if (this.krO) {
                aqG();
                a.aql().aqm().pause();
            } else {
                x.d("MicroMsg.BakOperatingUI", "onKeyDown keyCode == KeyEvent.KEYCODE_BACK  finishWizard cmd:%d", new Object[]{Integer.valueOf(this.krK)});
                this.krV = true;
                a.aql().aqm().dM(false);
                DU(1);
            }
        }
        return z;
    }

    public final void onError(int i) {
        this.handler.post(new 2(this, i));
    }

    public final void aqA() {
        this.handler.post(new 3(this));
    }
}
