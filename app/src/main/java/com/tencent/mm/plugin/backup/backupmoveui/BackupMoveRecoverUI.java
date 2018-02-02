package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.reflect.Method;

@a(3)
public class BackupMoveRecoverUI extends MMWizardActivity implements d {
    private static boolean kmE = false;
    private static boolean kmx = false;
    public TextView kmA;
    public TextView kmB;
    public TextView kmC;
    public ImageView kmD;
    public TextView kmy;
    public TextView kmz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            x.i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
            getSupportActionBar().hide();
            com.tencent.mm.plugin.backup.a.ifs.up();
            initView();
            try {
                Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
                WifiManager wifiManager = (WifiManager) getSystemService("wifi");
                b.aoR().aoU().kle = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
                x.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", new Object[]{Boolean.valueOf(b.aoR().aoU().kle)});
            } catch (Exception e) {
                x.e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[]{bh.cgy()});
            }
        }
    }

    public final void initView() {
        this.kmC = (TextView) findViewById(R.h.bMh);
        this.kmD = (ImageView) findViewById(R.h.bMi);
        this.kmA = (TextView) findViewById(R.h.bMp);
        this.kmB = (TextView) findViewById(R.h.brx);
        this.kmy = (TextView) findViewById(R.h.bLW);
        this.kmz = (TextView) findViewById(R.h.bLV);
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
        kmE = true;
        b.aoR().aoU().kkd = this;
        kmx = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
        mz(b.aoR().aol().kiJ);
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.BackupMoveRecoverUI", "onPause.");
        kmE = false;
    }

    public void onDestroy() {
        x.i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        apo();
        return true;
    }

    public final void mz(int i) {
        Context context = this;
        while (true) {
            e aol = b.aoR().aol();
            x.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d]", new Object[]{Integer.valueOf(i), Boolean.valueOf(kmE), Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL)});
            TextView textView;
            int i2;
            Object[] objArr;
            switch (i) {
                case -100:
                    DU(1);
                    return;
                case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                    context.kmD.setImageResource(R.k.dvR);
                    context.kmA.setText(R.l.dIT);
                    b.aoR().aoS().stop();
                    context.kmB.setVisibility(4);
                    context.kmy.setVisibility(4);
                    context.kmz.setVisibility(4);
                    apn();
                    return;
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                    context.kmD.setImageResource(R.k.dvR);
                    context.kmA.setText(R.l.dIY);
                    context.kmB.setVisibility(4);
                    context.kmy.setVisibility(4);
                    context.kmz.setVisibility(4);
                    apn();
                    return;
                case -13:
                    context.kmD.setImageResource(R.k.dvR);
                    context.kmA.setText(R.l.dHL);
                    context.kmB.setText(getString(R.l.dHM, new Object[]{bh.bx(b.aoR().aoU().kls)}));
                    context.kmB.setVisibility(0);
                    context.kmy.setVisibility(4);
                    context.kmz.setVisibility(4);
                    apn();
                    return;
                case -12:
                    context.kmD.setImageResource(R.k.dvP);
                    context.kmA.setText(R.l.dHw);
                    context.kmB.setText(R.l.dHY);
                    context.kmB.setVisibility(0);
                    context.kmy.setVisibility(4);
                    context.kmz.setVisibility(4);
                    apn();
                    h.a(context, R.l.dHJ, 0, R.l.dJQ, 0, new OnClickListener(context) {
                        final /* synthetic */ BackupMoveRecoverUI kmF;

                        {
                            this.kmF = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.BackupMoveRecoverUI", "move phone old version");
                            this.kmF.DU(1);
                        }
                    }, null, R.e.brv);
                    return;
                case -5:
                    context.kmD.setImageResource(R.k.dvR);
                    context.kmA.setText(R.l.dHE);
                    context.kmy.setText(R.l.dIm);
                    context.kmz.setText(R.l.dIp);
                    context.kmB.setVisibility(4);
                    context.kmy.setVisibility(0);
                    context.kmz.setVisibility(0);
                    context.kmy.setOnClickListener(new View.OnClickListener(context) {
                        final /* synthetic */ BackupMoveRecoverUI kmF;

                        {
                            this.kmF = r1;
                        }

                        public final void onClick(View view) {
                            g.pQN.h(11788, new Object[]{Integer.valueOf(9)});
                            Intent intent = new Intent();
                            intent.putExtra("BaseScanUI_select_scan_mode", 1);
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            com.tencent.mm.bm.d.b(this.kmF.mController.xIM, "scanner", ".ui.BaseScanUI", intent);
                        }
                    });
                    context.kmz.setOnClickListener(new 4(context, i));
                    apn();
                    return;
                case -4:
                    context.kmD.setImageResource(R.k.dvR);
                    context.kmA.setText(getString(R.l.dHZ, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL), "0M"}));
                    context.kmB.setText(R.l.dHK);
                    context.kmy.setText(R.l.dIm);
                    context.kmz.setText(R.l.dIp);
                    context.kmy.setOnClickListener(new 15(context));
                    context.kmz.setOnClickListener(new 16(context, i));
                    context.kmB.setTextColor(getResources().getColor(R.e.brw));
                    context.kmB.setVisibility(0);
                    context.kmy.setVisibility(0);
                    context.kmz.setVisibility(0);
                    app();
                    return;
                case -3:
                    context.kmD.setImageResource(R.k.dvR);
                    context.kmA.setText(R.l.dHC);
                    context.kmB.setText(R.l.dHD);
                    context.kmy.setText(R.l.dIk);
                    context.kmz.setText(R.l.dIp);
                    context.kmB.setTextColor(getResources().getColor(R.e.brw));
                    context.kmB.setVisibility(0);
                    context.kmy.setVisibility(0);
                    context.kmz.setVisibility(0);
                    context.kmy.setOnClickListener(new 17(context));
                    context.kmz.setOnClickListener(new 2(context, i));
                    apn();
                    return;
                case -2:
                case -1:
                    context.kmD.setImageResource(R.k.dvR);
                    context.kmA.setText(R.l.dHN);
                    String cl = com.tencent.mm.plugin.backup.a.g.cl(context);
                    if (cl == null || cl.equals("")) {
                        context.kmB.setText(getString(R.l.dHO, new Object[]{"移动网络", b.aoR().aoU().klk}));
                    } else {
                        context.kmB.setText(getString(R.l.dHO, new Object[]{cl, b.aoR().aoU().klk}));
                    }
                    context.kmB.setTextColor(getResources().getColor(R.e.brw));
                    context.kmB.setVisibility(0);
                    context.kmy.setVisibility(4);
                    context.kmz.setVisibility(4);
                    apn();
                    return;
                case 1:
                    context.kmD.setImageResource(R.k.dvP);
                    context.kmA.setText(R.l.dHw);
                    context.kmB.setText(R.l.dHY);
                    context.kmB.setVisibility(0);
                    context.kmy.setVisibility(4);
                    context.kmz.setVisibility(4);
                    apn();
                    return;
                case 3:
                    finish();
                    return;
                case 4:
                    context.kmD.setImageResource(R.k.dvP);
                    textView = context.kmA;
                    i2 = R.l.dIq;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aol.kiK);
                    objArr[1] = Integer.valueOf(aol.kiL);
                    b.aoR().aoU();
                    objArr[2] = c.aoZ();
                    textView.setText(getString(i2, objArr));
                    context.kmB.setText(R.l.dJI);
                    context.kmB.setTextColor(getResources().getColor(R.e.brw));
                    context.kmB.setVisibility(0);
                    context.kmy.setVisibility(4);
                    context.kmz.setVisibility(4);
                    app();
                    return;
                case 22:
                    context.kmD.setImageResource(R.k.dvP);
                    context.kmA.setText(R.l.dIl);
                    context.kmB.setText(R.l.dHY);
                    context.kmB.setTextColor(getResources().getColor(R.e.brx));
                    context.kmB.setVisibility(0);
                    context.kmy.setVisibility(4);
                    context.kmz.setVisibility(4);
                    app();
                    return;
                case 23:
                    context.kmD.setImageResource(R.k.dvP);
                    textView = context.kmA;
                    i2 = R.l.dIq;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aol.kiK);
                    objArr[1] = Integer.valueOf(aol.kiL);
                    b.aoR().aoU();
                    objArr[2] = c.aoZ();
                    textView.setText(getString(i2, objArr));
                    context.kmB.setText(R.l.dHY);
                    context.kmB.setTextColor(getResources().getColor(R.e.brx));
                    context.kmB.setVisibility(0);
                    context.kmy.setVisibility(4);
                    context.kmz.setVisibility(4);
                    app();
                    return;
                case 24:
                    x.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", new Object[]{Boolean.valueOf(kmx)});
                    if (kmx) {
                        context.kmD.setImageResource(R.k.dvP);
                        context.kmA.setText(R.l.dIr);
                        context.kmB.setText(R.l.dIt);
                        context.kmB.setTextColor(getResources().getColor(R.e.brx));
                        context.kmy.setText(R.l.dIn);
                        context.kmz.setText(R.l.dIo);
                        context.kmC.setText(R.l.dJJ);
                        context.kmB.setVisibility(0);
                        context.kmy.setVisibility(0);
                        context.kmz.setVisibility(0);
                        context.kmy.setOnClickListener(new 11(context));
                        context.kmz.setOnClickListener(new View.OnClickListener(context) {
                            final /* synthetic */ BackupMoveRecoverUI kmF;

                            public final void onClick(View view) {
                                x.i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
                                h.a(this.kmF, R.l.dHy, R.l.dHx, R.l.dIo, R.l.dHo, new 1(this), null, R.e.brw);
                            }
                        });
                        context.kmC.setOnClickListener(new 13(context));
                        return;
                    } else if (kmE) {
                        b.aoR().aoU();
                        if (c.aoW()) {
                            b.aoR().aoU().aoC();
                            return;
                        }
                        x.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                        b.aoR().aol().kiJ = -22;
                        mz(-22);
                        g.pQN.a(485, 6, 1, false);
                        return;
                    } else {
                        return;
                    }
                case 25:
                    if (kmE) {
                        b.aoR().aol().kiJ = 24;
                        i = 24;
                    } else {
                        return;
                    }
                case 26:
                    context.kmD.setImageResource(R.k.dvV);
                    context.kmA.setText(getString(R.l.dIi, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL)}));
                    context.kmB.setText(R.l.dIj);
                    context.kmB.setTextColor(getResources().getColor(R.e.brx));
                    context.kmB.setVisibility(0);
                    context.kmy.setVisibility(4);
                    context.kmz.setVisibility(4);
                    apn();
                    return;
                case 27:
                    context.kmD.setImageResource(R.k.dvW);
                    context.kmA.setText(R.l.dIg);
                    context.kmB.setText(getString(R.l.dIh, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL)}));
                    context.kmB.setTextColor(getResources().getColor(R.e.brx));
                    context.kmy.setText(R.l.dHr);
                    context.kmB.setVisibility(0);
                    context.kmy.setVisibility(0);
                    context.kmz.setVisibility(4);
                    context.kmy.setOnClickListener(new 14(context));
                    apn();
                    return;
                case 52:
                    context.kmD.setImageResource(R.k.dvP);
                    context.kmA.setText(R.l.dHV);
                    context.kmy.setText(R.l.dHX);
                    context.kmz.setText(R.l.dHW);
                    context.kmB.setVisibility(4);
                    context.kmy.setVisibility(0);
                    context.kmz.setVisibility(0);
                    context.kmy.setOnClickListener(new 1(context));
                    context.kmz.setOnClickListener(new View.OnClickListener(context) {
                        final /* synthetic */ BackupMoveRecoverUI kmF;

                        {
                            this.kmF = r1;
                        }

                        public final void onClick(View view) {
                            b.aoR().aoU().dD(true);
                        }
                    });
                    apn();
                    return;
                default:
                    return;
            }
        }
    }

    public final void aok() {
    }

    private void apn() {
        this.kmC.setText(R.l.dHq);
        this.kmC.setOnClickListener(new 6(this));
    }

    private void apo() {
        int i = b.aoR().aol().kiJ;
        x.i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, backupPcState:%d ", new Object[]{Integer.valueOf(i), Integer.valueOf(i)});
        switch (i) {
            case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -13:
            case -5:
            case -3:
            case -2:
            case -1:
            case 1:
                b.aoR().aoU().a(false, false, -100);
                return;
            case 24:
                b.aoR().aol().kiJ = 25;
                break;
            case 26:
                h.a(this, R.l.dIL, R.l.dIK, R.l.dJD, R.l.dHo, new 8(this, i), null, R.e.brw);
                return;
            case 27:
                x.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", new Object[]{Integer.valueOf(i)});
                b.aoR().aoU().a(true, false, -100);
                b.aoR().aoS().stop();
                return;
            case 52:
                h.a(this, R.l.dHA, R.l.dHz, R.l.dIp, R.l.dHo, new 7(this, i), null, R.e.brw);
                return;
        }
        DU(1);
    }

    private void app() {
        this.kmC.setText(R.l.dHs);
        this.kmC.setOnClickListener(new 9(this));
    }

    protected final int getLayoutId() {
        return R.i.daP;
    }
}
