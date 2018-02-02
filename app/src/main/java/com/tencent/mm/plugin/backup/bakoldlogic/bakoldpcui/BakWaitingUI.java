package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BakWaitingUI extends MMWizardActivity implements c {
    private af handler = new af(Looper.getMainLooper());
    private boolean ksd;
    private int pK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            a.aql().aqm().kqS = this;
            this.pK = a.aql().aqm().kqZ;
            this.ksd = getIntent().getBooleanExtra("from_back_finish", false);
            x.i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", new Object[]{Integer.valueOf(this.pK), Boolean.valueOf(this.ksd)});
            initView();
            aqI();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dKm);
        if (this.ksd) {
            findViewById(R.h.bMy).setVisibility(8);
        } else {
            findViewById(R.h.bMy).setVisibility(0);
        }
        setBackBtn(new 1(this));
    }

    protected final int getLayoutId() {
        return R.i.daX;
    }

    public final void mU(int i) {
        this.pK = i;
        this.handler.post(new 2(this));
    }

    public void onDestroy() {
        super.onDestroy();
        a.aql().aqm().kqS = null;
        x.i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", new Object[]{Integer.valueOf(this.pK), Boolean.valueOf(this.ksd)});
    }

    public final void mV(final int i) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakWaitingUI kse;

            public final void run() {
                x.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(i)});
                if (i == -1) {
                    x.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", this.kse.getString(R.l.dJe));
                    intent.putExtra("rawUrl", this.kse.getString(R.l.dIB, new Object[]{w.cfi()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(this.kse, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
    }

    final void aqI() {
        if (6 == this.pK || 1 == this.pK) {
            Intent intent = new Intent(this, BakOperatingUI.class);
            intent.putExtra("cmd", this.pK);
            MMWizardActivity.A(this, intent);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        DU(1);
        return true;
    }

    public final void onError(final int i) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakWaitingUI kse;

            public final void run() {
                x.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(i)});
                if (i == -1) {
                    x.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", this.kse.getString(R.l.dJe));
                    intent.putExtra("rawUrl", this.kse.getString(R.l.dIB, new Object[]{w.cfi()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(this.kse, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                MMWizardActivity.A(this.kse, new Intent(this.kse, BakConnErrorUI.class));
            }
        });
    }
}
