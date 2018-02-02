package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@a(3)
public class BackupPcUI extends MMWizardActivity {
    private static boolean kmx = false;
    private TextView kmA;
    private TextView kmB;
    private TextView kmC;
    private ImageView kmD;
    private TextView kmy;
    private TextView kmz;
    public c kos = new 3(this);

    static /* synthetic */ void m(BackupPcUI backupPcUI) {
        x.i("MicroMsg.BackupPcUI", "jumpToNetworkDisconnectDoc.");
        Intent intent = new Intent();
        intent.putExtra("title", backupPcUI.getString(R.l.dJd));
        intent.putExtra("rawUrl", backupPcUI.getString(R.l.dJc, new Object[]{w.cfi()}));
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        d.b(backupPcUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            x.i("MicroMsg.BackupPcUI", "onCreate.");
            getSupportActionBar().hide();
            com.tencent.mm.plugin.backup.a.ifs.up();
            initView();
            if (b.aps().apt().knK) {
                b.aps().apt().knK = false;
                int aow = g.aow();
                if (aow < 50) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(400, 4, 1, false);
                    com.tencent.mm.plugin.report.service.g.pQN.h(13736, Integer.valueOf(4), b.aps().apt().knE, g.cl(this), Integer.valueOf(0), Integer.valueOf(b.aps().apt().knJ));
                    h.a(this, R.l.dIS, R.l.dIR, R.l.dJQ, 0, new 1(this, aow), null, R.e.brv);
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        x.i("MicroMsg.BackupPcUI", "onStart.");
        kmx = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.BackupPcUI", "onPause.");
        e apu = b.aps().apu();
        c cVar = this.kos;
        synchronized (apu.knP) {
            apu.knP.remove(cVar);
        }
        com.tencent.mm.plugin.backup.backuppcmodel.d apv = b.aps().apv();
        cVar = this.kos;
        synchronized (apv.knP) {
            apv.knP.remove(cVar);
        }
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.BackupPcUI", "onResume.");
        e apu = b.aps().apu();
        c cVar = this.kos;
        synchronized (apu.knP) {
            apu.knP.add(cVar);
        }
        com.tencent.mm.plugin.backup.backuppcmodel.d apv = b.aps().apv();
        cVar = this.kos;
        synchronized (apv.knP) {
            apv.knP.add(cVar);
        }
        this.kos.mz(b.aps().aol().kiJ);
    }

    public final void initView() {
        this.kmC = (TextView) findViewById(R.h.bMh);
        this.kmD = (ImageView) findViewById(R.h.bMi);
        this.kmA = (TextView) findViewById(R.h.bMp);
        this.kmB = (TextView) findViewById(R.h.brx);
        this.kmy = (TextView) findViewById(R.h.bLW);
        this.kmz = (TextView) findViewById(R.h.bLV);
    }

    protected final int getLayoutId() {
        return R.i.daP;
    }

    public void onDestroy() {
        x.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", bh.cgy());
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        apo();
        return true;
    }

    private void apo() {
        x.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d", Integer.valueOf(b.aps().aol().kiJ));
        switch (b.aps().aol().kiJ) {
            case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -13:
            case -5:
            case -3:
            case -2:
            case -1:
            case 1:
            case 11:
            case 21:
                if (1 != b.aps().apt().knD && 3 != b.aps().apt().knD) {
                    if (2 != b.aps().apt().knD && 4 != b.aps().apt().knD) {
                        b.aps().aol().kiJ = -100;
                        break;
                    } else {
                        b.aps().apv().a(false, false, -100);
                        return;
                    }
                }
                b.aps().apu().al(false);
                b.aps().aol().kiJ = -100;
                break;
            case 15:
                x.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
                apE();
                return;
            case 24:
                b.aps().aol().kiJ = 25;
                break;
            case 26:
                h.a(this, R.l.dIL, R.l.dIK, R.l.dJD, R.l.dHo, new 2(this), null, R.e.brw);
                return;
            case 27:
                x.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
                apE();
                return;
        }
        DU(1);
    }

    private void apE() {
        x.i("MicroMsg.BackupPcUI", "exitBackupPc.");
        if (1 == b.aps().apt().knD || 3 == b.aps().apt().knD) {
            b.aps().apw().cancel();
            b.aps().apw().aoP();
            b.aps().apu().al(true);
            b.aps().aoS().stop();
            b.aps().aol().kiJ = -100;
            DU(1);
        } else if (2 == b.aps().apt().knD || 4 == b.aps().apt().knD) {
            b.aps().apv().a(true, true, -100);
            b.aps().aoS().stop();
        }
    }
}
