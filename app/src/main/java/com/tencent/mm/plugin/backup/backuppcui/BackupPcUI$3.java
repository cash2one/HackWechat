package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b$c;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

class BackupPcUI$3 implements b$c {
    final /* synthetic */ BackupPcUI kot;

    BackupPcUI$3(BackupPcUI backupPcUI) {
        this.kot = backupPcUI;
    }

    public final void aoj() {
        x.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", new Object[]{Integer.valueOf(b.aps().apt().knD)});
        switch (b.aps().apt().knD) {
            case 1:
                b.aps().aol().kiJ = 11;
                mz(11);
                return;
            case 2:
                b.aps().aol().kiJ = 21;
                mz(21);
                return;
            case 3:
                b.aps().aol().kiJ = 12;
                mz(12);
                return;
            case 4:
                b.aps().aol().kiJ = 22;
                mz(22);
                return;
            default:
                return;
        }
    }

    public final void mz(int i) {
        while (true) {
            x.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d", new Object[]{Integer.valueOf(i)});
            e aol = b.aps().aol();
            TextView c;
            BackupPcUI backupPcUI;
            int i2;
            Object[] objArr;
            switch (i) {
                case -100:
                    BackupPcUI.a(this.kot);
                    return;
                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                    apG();
                    BackupPcUI.c(this.kot).setText(R.l.dIQ);
                    BackupPcUI.d(this.kot).setVisibility(4);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    apn();
                    return;
                case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                    apG();
                    BackupPcUI.c(this.kot).setText(R.l.dIT);
                    b.aps().aoS().stop();
                    BackupPcUI.d(this.kot).setVisibility(4);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    apn();
                    return;
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                    apG();
                    BackupPcUI.c(this.kot).setText(R.l.dIY);
                    BackupPcUI.d(this.kot).setVisibility(4);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    apn();
                    return;
                case -13:
                    apG();
                    BackupPcUI.c(this.kot).setText(R.l.dIV);
                    b.aps().aoS().stop();
                    BackupPcUI.d(this.kot).setVisibility(4);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    apn();
                    return;
                case -5:
                    apG();
                    BackupPcUI.c(this.kot).setText(R.l.dIP);
                    BackupPcUI.d(this.kot).setVisibility(4);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    apn();
                    return;
                case -4:
                    if (1 == b.aps().apt().knD || 3 == b.aps().apt().knD) {
                        BackupPcUI.b(this.kot).setImageResource(R.k.dvY);
                        BackupPcUI.c(this.kot).setText(this.kot.getString(R.l.dJG, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL), "0M"}));
                        BackupPcUI.d(this.kot).setText(R.l.dIU);
                        BackupPcUI.f(this.kot).setText(R.l.dJC);
                        BackupPcUI.f(this.kot).setOnClickListener(new 3(this));
                    } else if (2 == b.aps().apt().knD || 4 == b.aps().apt().knD) {
                        BackupPcUI.b(this.kot).setImageResource(R.k.dwc);
                        BackupPcUI.c(this.kot).setText(this.kot.getString(R.l.dJp, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL), "0M"}));
                        BackupPcUI.d(this.kot).setText(R.l.dIZ);
                        BackupPcUI.f(this.kot).setText(R.l.dJE);
                        BackupPcUI.f(this.kot).setOnClickListener(new 4(this));
                    }
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brw));
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(0);
                    app();
                    return;
                case -3:
                    apG();
                    BackupPcUI.c(this.kot).setText(R.l.dIO);
                    BackupPcUI.f(this.kot).setText(R.l.dJa);
                    BackupPcUI.d(this.kot).setVisibility(4);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(0);
                    BackupPcUI.f(this.kot).setOnClickListener(new 6(this));
                    apn();
                    return;
                case -2:
                case -1:
                    apG();
                    BackupPcUI.c(this.kot).setText(R.l.dIW);
                    String cl = g.cl(this.kot);
                    if (cl == null || cl.equals("")) {
                        BackupPcUI.d(this.kot).setText(this.kot.getString(R.l.dIX, new Object[]{b.aps().apt().knE, "移动网络"}));
                    } else {
                        BackupPcUI.d(this.kot).setText(this.kot.getString(R.l.dIX, new Object[]{b.aps().apt().knE, cl}));
                    }
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brw));
                    BackupPcUI.f(this.kot).setText(R.l.dJa);
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(0);
                    BackupPcUI.f(this.kot).setOnClickListener(new 5(this));
                    apn();
                    return;
                case 1:
                    BackupPcUI.b(this.kot).setImageResource(R.k.dwa);
                    BackupPcUI.c(this.kot).setText(R.l.dIG);
                    BackupPcUI.d(this.kot).setVisibility(4);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    apn();
                    return;
                case 4:
                    switch (b.aps().apt().knD) {
                        case 1:
                        case 3:
                            BackupPcUI.b(this.kot).setImageResource(R.k.dwa);
                            c = BackupPcUI.c(this.kot);
                            backupPcUI = this.kot;
                            i2 = R.l.dJG;
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(aol.kiK);
                            objArr[1] = Integer.valueOf(aol.kiL);
                            b.aps().apt();
                            objArr[2] = c.apy();
                            c.setText(backupPcUI.getString(i2, objArr));
                            break;
                        case 2:
                        case 4:
                            BackupPcUI.b(this.kot).setImageResource(R.k.dwe);
                            c = BackupPcUI.c(this.kot);
                            backupPcUI = this.kot;
                            i2 = R.l.dJp;
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(aol.kiK);
                            objArr[1] = Integer.valueOf(aol.kiL);
                            b.aps().apt();
                            objArr[2] = c.apy();
                            c.setText(backupPcUI.getString(i2, objArr));
                            break;
                    }
                    BackupPcUI.d(this.kot).setText(R.l.dJI);
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brw));
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    app();
                    return;
                case 5:
                    switch (b.aps().apt().knD) {
                        case 1:
                        case 3:
                            BackupPcUI.b(this.kot).setImageResource(R.k.dwa);
                            c = BackupPcUI.c(this.kot);
                            backupPcUI = this.kot;
                            i2 = R.l.dJG;
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(aol.kiK);
                            objArr[1] = Integer.valueOf(aol.kiL);
                            b.aps().apt();
                            objArr[2] = c.apy();
                            c.setText(backupPcUI.getString(i2, objArr));
                            BackupPcUI.f(this.kot).setText(R.l.dJC);
                            BackupPcUI.f(this.kot).setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ BackupPcUI$3 kou;

                                {
                                    this.kou = r1;
                                }

                                public final void onClick(View view) {
                                    h.a(this.kou.kot, R.l.dIJ, R.l.dII, R.l.dJC, R.l.dHo, new 1(this), null, R.e.brw);
                                }
                            });
                            break;
                        case 2:
                        case 4:
                            BackupPcUI.b(this.kot).setImageResource(R.k.dwe);
                            c = BackupPcUI.c(this.kot);
                            backupPcUI = this.kot;
                            i2 = R.l.dJp;
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(aol.kiK);
                            objArr[1] = Integer.valueOf(aol.kiL);
                            b.aps().apt();
                            objArr[2] = c.apy();
                            c.setText(backupPcUI.getString(i2, objArr));
                            BackupPcUI.f(this.kot).setText(R.l.dJE);
                            BackupPcUI.f(this.kot).setOnClickListener(new 2(this));
                            break;
                    }
                    BackupPcUI.d(this.kot).setText(R.l.dJH);
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brw));
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(0);
                    app();
                    return;
                case 11:
                    BackupPcUI.b(this.kot).setImageResource(R.k.dwa);
                    BackupPcUI.c(this.kot).setText(R.l.dJB);
                    BackupPcUI.d(this.kot).setText(R.l.dJA);
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brx));
                    BackupPcUI.e(this.kot).setText(R.l.dJy);
                    BackupPcUI.f(this.kot).setText(R.l.dJz);
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(0);
                    BackupPcUI.f(this.kot).setVisibility(0);
                    apn();
                    BackupPcUI.e(this.kot).setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ BackupPcUI$3 kou;

                        {
                            this.kou = r1;
                        }

                        public final void onClick(View view) {
                            ar.Hg();
                            x.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", new Object[]{Boolean.valueOf(((Boolean) com.tencent.mm.z.c.CU().get(a.xtj, Boolean.valueOf(false))).booleanValue())});
                            if (((Boolean) com.tencent.mm.z.c.CU().get(a.xtj, Boolean.valueOf(false))).booleanValue()) {
                                h.a(this.kou.kot, R.l.dJb, 0, R.l.dJQ, 0, new 1(this), null, R.e.brv);
                                return;
                            }
                            b.aps().apt().mI(2);
                            b.aps().aol().kiJ = 12;
                            this.kou.mz(12);
                            b.aps().apw().cancel();
                            b.aps().apw().aoP();
                            b.aps().apw().dH(true);
                            com.tencent.mm.plugin.report.service.g.pQN.a(400, 7, 1, false);
                            com.tencent.mm.plugin.report.service.g.pQN.h(13735, new Object[]{Integer.valueOf(9), Integer.valueOf(b.aps().apt().knJ)});
                        }
                    });
                    BackupPcUI.f(this.kot).setOnClickListener(new 9(this));
                    return;
                case 12:
                    BackupPcUI.b(this.kot).setImageResource(R.k.dwa);
                    BackupPcUI.c(this.kot).setText(R.l.dJf);
                    BackupPcUI.d(this.kot).setText(R.l.dJg);
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brx));
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    app();
                    return;
                case 14:
                    BackupPcUI.b(this.kot).setImageResource(R.k.dwa);
                    c = BackupPcUI.c(this.kot);
                    backupPcUI = this.kot;
                    i2 = R.l.dJG;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aol.kiK);
                    objArr[1] = Integer.valueOf(aol.kiL);
                    b.aps().apt();
                    objArr[2] = c.apy();
                    c.setText(backupPcUI.getString(i2, objArr));
                    BackupPcUI.d(this.kot).setText(R.l.dJg);
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brx));
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    app();
                    return;
                case 15:
                    BackupPcUI.b(this.kot).setImageResource(R.k.dvZ);
                    BackupPcUI.c(this.kot).setText(R.l.dIC);
                    BackupPcUI.d(this.kot).setText(this.kot.getString(R.l.dID, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL)}));
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brx));
                    BackupPcUI.e(this.kot).setText(R.l.dHr);
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(0);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    BackupPcUI.e(this.kot).setOnClickListener(new 10(this));
                    apn();
                    return;
                case 21:
                    BackupPcUI.b(this.kot).setImageResource(R.k.dwe);
                    BackupPcUI.c(this.kot).setText(R.l.dJn);
                    BackupPcUI.e(this.kot).setText(R.l.dJm);
                    BackupPcUI.d(this.kot).setVisibility(4);
                    BackupPcUI.e(this.kot).setVisibility(0);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    BackupPcUI.e(this.kot).setOnClickListener(new 11(this));
                    apn();
                    return;
                case 22:
                    BackupPcUI.b(this.kot).setImageResource(R.k.dwe);
                    BackupPcUI.c(this.kot).setText(R.l.dJf);
                    BackupPcUI.d(this.kot).setText(R.l.dJg);
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brx));
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    app();
                    return;
                case 23:
                    BackupPcUI.b(this.kot).setImageResource(R.k.dwe);
                    c = BackupPcUI.c(this.kot);
                    backupPcUI = this.kot;
                    i2 = R.l.dJp;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aol.kiK);
                    objArr[1] = Integer.valueOf(aol.kiL);
                    b.aps().apt();
                    objArr[2] = c.apy();
                    c.setText(backupPcUI.getString(i2, objArr));
                    BackupPcUI.d(this.kot).setText(R.l.dJg);
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brx));
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    app();
                    return;
                case 24:
                    if (BackupPcUI.apF()) {
                        BackupPcUI.b(this.kot).setImageResource(R.k.dwe);
                        BackupPcUI.c(this.kot).setText(R.l.dJq);
                        BackupPcUI.d(this.kot).setText(R.l.dJs);
                        BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brx));
                        BackupPcUI.e(this.kot).setText(R.l.dJl);
                        BackupPcUI.f(this.kot).setText(R.l.dJo);
                        BackupPcUI.h(this.kot).setText(R.l.dJJ);
                        BackupPcUI.d(this.kot).setVisibility(0);
                        BackupPcUI.e(this.kot).setVisibility(0);
                        BackupPcUI.f(this.kot).setVisibility(0);
                        BackupPcUI.e(this.kot).setOnClickListener(new 12(this));
                        BackupPcUI.f(this.kot).setOnClickListener(new 13(this));
                        BackupPcUI.h(this.kot).setOnClickListener(new 14(this));
                        return;
                    } else if (bh.bF(this.kot)) {
                        b.aps().apv();
                        if (d.aoW()) {
                            b.aps().apv().aoC();
                            return;
                        }
                        b.aps().aol().kiJ = -22;
                        mz(-22);
                        com.tencent.mm.plugin.report.service.g.pQN.a(400, 64, 1, false);
                        return;
                    } else {
                        return;
                    }
                case 25:
                    if (bh.bF(this.kot)) {
                        b.aps().aol().kiJ = 24;
                        i = 24;
                    } else {
                        return;
                    }
                case 26:
                    BackupPcUI.b(this.kot).setImageResource(R.k.dwe);
                    BackupPcUI.c(this.kot).setText(this.kot.getString(R.l.dJh, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL)}));
                    BackupPcUI.d(this.kot).setText(R.l.dJk);
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brx));
                    BackupPcUI.h(this.kot).setText(R.l.dJo);
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(4);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    apn();
                    return;
                case 27:
                    BackupPcUI.b(this.kot).setImageResource(R.k.dwd);
                    BackupPcUI.c(this.kot).setText(R.l.dJi);
                    BackupPcUI.d(this.kot).setText(this.kot.getString(R.l.dJj, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL)}));
                    BackupPcUI.d(this.kot).setTextColor(this.kot.getResources().getColor(R.e.brx));
                    BackupPcUI.e(this.kot).setText(R.l.dHr);
                    BackupPcUI.d(this.kot).setVisibility(0);
                    BackupPcUI.e(this.kot).setVisibility(0);
                    BackupPcUI.f(this.kot).setVisibility(4);
                    BackupPcUI.e(this.kot).setOnClickListener(new 15(this));
                    apn();
                    return;
                default:
                    return;
            }
        }
    }

    private void apG() {
        if (1 == b.aps().apt().knD || 3 == b.aps().apt().knD) {
            BackupPcUI.b(this.kot).setImageResource(R.k.dvY);
        } else if (2 == b.aps().apt().knD || 4 == b.aps().apt().knD) {
            BackupPcUI.b(this.kot).setImageResource(R.k.dwc);
        }
    }

    private void apn() {
        BackupPcUI.h(this.kot).setText(R.l.dHq);
        BackupPcUI.h(this.kot).setOnClickListener(new 7(this));
    }

    private void app() {
        BackupPcUI.h(this.kot).setText(R.l.dHs);
        BackupPcUI.h(this.kot).setOnClickListener(new 8(this));
    }

    public final void aok() {
    }
}
