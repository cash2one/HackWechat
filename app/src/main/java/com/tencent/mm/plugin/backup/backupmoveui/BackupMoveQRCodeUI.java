package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class BackupMoveQRCodeUI extends MMWizardActivity implements d {
    private ImageView kms;
    private TextView kmt;
    private TextView kmu;
    private boolean kmv = false;

    static /* synthetic */ void d(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        backupMoveQRCodeUI.kmv = false;
        b.aoR().aoT().dF(false);
        b.aoR().aoS().stop();
        b.aoR().aoT().al(false);
        b.aoR().aol().kiJ = -100;
        backupMoveQRCodeUI.DU(1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            if (ar.Hj()) {
                initView();
                com.tencent.mm.plugin.backup.f.b.clear();
                com.tencent.mm.plugin.backup.f.b.d aoT = b.aoR().aoT();
                com.tencent.mm.plugin.backup.f.b.a(aoT.klw);
                com.tencent.mm.plugin.backup.a.d.mA(21);
                com.tencent.mm.plugin.backup.f.b.a(aoT.klu);
                b.aoR().aom();
                com.tencent.mm.plugin.backup.f.b.a(aoT);
                com.tencent.mm.plugin.backup.f.b.a(b.aoR().aoS());
                com.tencent.mm.plugin.backup.f.b.mA(2);
                b.aoR().kiE = null;
                aoT.klF = false;
                b.aoR().aoT().klG = c.kiu;
                com.tencent.mm.plugin.backup.a.d.aor();
                return;
            }
            finish();
        }
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.plugin.backup.f.b.a(b.aoR().aoT());
        b.aoR().aoT().kkd = this;
        b.aoR().aoT().klL.start();
    }

    public void onResume() {
        super.onResume();
        mz(b.aoR().aol().kiJ);
    }

    public final void initView() {
        setMMTitle(R.l.dvP);
        this.kms = (ImageView) findViewById(R.h.bMl);
        this.kmt = (TextView) findViewById(R.h.bMn);
        this.kmu = (TextView) findViewById(R.h.bMm);
        setBackBtn(new 1(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        apm();
        return true;
    }

    private void apm() {
        if (ar.Cs()) {
            h.a(this, R.l.dIe, R.l.dId, R.l.dIz, R.l.dHo, new 2(this), null, R.e.brw);
            return;
        }
        x.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
        b.aoR().aoS().stop();
        b.aoR().aoT().al(true);
        b.aoR().aol().kiJ = -100;
        DU(1);
    }

    public void onStop() {
        x.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onStop.");
        if (b.aoR().aoT().klL != null) {
            b.aoR().aoT().klL.stop();
        }
        super.onStop();
    }

    protected final int getLayoutId() {
        return R.i.daO;
    }

    public final void mz(int i) {
        x.i("MicroMsg.BackupMoveQRCodeUI", "onUpdateUIProgress backupState:%d", new Object[]{Integer.valueOf(i)});
        if (!this.kmv) {
            switch (i) {
                case -33:
                    this.kmv = true;
                    h.a(this, R.l.dHP, 0, R.l.dHn, R.l.dHo, new 8(this), new 9(this), R.e.brv);
                    return;
                case -32:
                    this.kmv = true;
                    h.a(this, R.l.dHQ, 0, R.l.dHm, R.l.dHo, new 5(this), new 6(this), R.e.brv);
                    return;
                case -31:
                    this.kmv = true;
                    h.a(this, R.l.dHR, 0, R.l.dHn, R.l.dHo, new 3(this), new 4(this), R.e.brv);
                    return;
                case -12:
                    h.a(this, R.l.dHT, 0, R.l.dJQ, 0, new OnClickListener(this) {
                        final /* synthetic */ BackupMoveQRCodeUI kmw;

                        {
                            this.kmw = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
                        }
                    }, null, R.e.brv);
                    return;
                case -11:
                case -4:
                    this.kmt.setText(R.l.dHI);
                    this.kmt.setTextColor(this.mController.xIM.getResources().getColor(R.e.btB));
                    this.kms.setImageResource(R.k.dvU);
                    this.kmu.setVisibility(4);
                    return;
                case 2:
                    x.i("MicroMsg.BackupMoveQRCodeUI", "auth success. go to BackupMoveUI.");
                    b.aoR().aol().kiJ = 12;
                    MMWizardActivity.A(this, new Intent(this, BackupMoveUI.class));
                    return;
                case 51:
                    byte[] bArr = b.aoR().aoT().bitmapData;
                    this.kms.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.kmt.setText(R.l.dIf);
                    this.kmt.setTextColor(this.mController.xIM.getResources().getColor(R.e.black));
                    this.kmu.setVisibility(4);
                    return;
                default:
                    return;
            }
        }
    }

    public final void aok() {
    }
}
