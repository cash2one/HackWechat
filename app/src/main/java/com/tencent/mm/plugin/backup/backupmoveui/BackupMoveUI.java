package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.reflect.Method;

@a(3)
public class BackupMoveUI extends MMWizardActivity implements d {
    public TextView kmA;
    public TextView kmB;
    public TextView kmC;
    public ImageView kmD;
    public TextView kmy;
    public TextView kmz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            x.i("MicroMsg.BackupMoveUI", "onCreate.");
            getSupportActionBar().hide();
            com.tencent.mm.plugin.backup.a.ifs.up();
            initView();
            try {
                Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
                WifiManager wifiManager = (WifiManager) getSystemService("wifi");
                b.aoR().aoT().kle = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
                x.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[]{Boolean.valueOf(b.aoR().aoT().kle)});
            } catch (Exception e) {
                x.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[]{new ai()});
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

    protected final int getLayoutId() {
        return R.i.daP;
    }

    public void onResume() {
        super.onResume();
        b.aoR().aoT().kkd = this;
        mz(b.aoR().aol().kiJ);
    }

    public void onDestroy() {
        x.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
        if (b.aoR().aoT().klL != null) {
            b.aoR().aoT().klL.stop();
        }
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
        e aol = b.aoR().aol();
        x.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL)});
        TextView textView;
        int i2;
        Object[] objArr;
        switch (i) {
            case -100:
                DU(1);
                return;
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                this.kmD.setImageResource(R.k.dvR);
                this.kmA.setText(R.l.dHF);
                this.kmB.setVisibility(4);
                this.kmy.setVisibility(4);
                this.kmz.setVisibility(4);
                apn();
                return;
            case DownloadResult.CODE_URL_ERROR /*-21*/:
                this.kmD.setImageResource(R.k.dvR);
                this.kmA.setText(R.l.dHS);
                this.kmB.setVisibility(4);
                this.kmy.setVisibility(4);
                this.kmz.setVisibility(4);
                apn();
                return;
            case -11:
                this.kmD.setImageResource(R.k.dvT);
                this.kmA.setText(getString(R.l.dHZ, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL), "0M"}));
                this.kmB.setText(R.l.dHI);
                this.kmB.setTextColor(this.mController.xIM.getResources().getColor(R.e.btB));
                this.kmB.setVisibility(0);
                this.kmy.setVisibility(4);
                this.kmz.setVisibility(4);
                apn();
                return;
            case -4:
                this.kmD.setImageResource(R.k.dvT);
                b.aoR().aoT().klL.start();
                this.kmA.setText(getString(R.l.dHZ, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL), "0M"}));
                this.kmB.setText(R.l.dHK);
                this.kmB.setTextColor(this.mController.xIM.getResources().getColor(R.e.btB));
                this.kmB.setVisibility(0);
                this.kmy.setVisibility(4);
                this.kmz.setVisibility(4);
                this.kmC.setText(R.l.dHs);
                this.kmC.setOnClickListener(new 4(this));
                b.aoR().aoT().klG = c.kiv;
                return;
            case 1:
                this.kmD.setImageResource(R.k.dvP);
                this.kmA.setText(R.l.dHw);
                this.kmB.setText(R.l.dHY);
                this.kmB.setVisibility(0);
                this.kmy.setVisibility(4);
                this.kmz.setVisibility(4);
                apn();
                return;
            case 3:
                finish();
                return;
            case 4:
                this.kmD.setImageResource(R.k.dvP);
                textView = this.kmA;
                i2 = R.l.dIA;
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aol.kiK);
                objArr[1] = Integer.valueOf(aol.kiL);
                b.aoR().aoT();
                objArr[2] = com.tencent.mm.plugin.backup.c.d.aph();
                textView.setText(getString(i2, objArr));
                this.kmB.setText(R.l.dJI);
                this.kmB.setTextColor(getResources().getColor(R.e.brw));
                this.kmB.setVisibility(0);
                this.kmy.setVisibility(4);
                this.kmz.setVisibility(4);
                apn();
                return;
            case 12:
                this.kmD.setImageResource(R.k.dvP);
                this.kmA.setText(R.l.dIc);
                this.kmB.setText(R.l.dHY);
                this.kmB.setTextColor(getResources().getColor(R.e.brx));
                this.kmB.setVisibility(0);
                this.kmy.setVisibility(4);
                this.kmz.setVisibility(4);
                apn();
                return;
            case 13:
                this.kmD.setImageResource(R.k.dvP);
                this.kmA.setText(getString(R.l.dHt, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL)}));
                this.kmB.setText(R.l.dHY);
                this.kmB.setTextColor(getResources().getColor(R.e.brx));
                this.kmB.setVisibility(0);
                this.kmy.setVisibility(4);
                this.kmz.setVisibility(4);
                apn();
                return;
            case 14:
                this.kmD.setImageResource(R.k.dvP);
                textView = this.kmA;
                i2 = R.l.dIA;
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aol.kiK);
                objArr[1] = Integer.valueOf(aol.kiL);
                b.aoR().aoT();
                objArr[2] = com.tencent.mm.plugin.backup.c.d.aph();
                textView.setText(getString(i2, objArr));
                this.kmB.setText(R.l.dHY);
                this.kmB.setTextColor(getResources().getColor(R.e.brx));
                this.kmB.setVisibility(0);
                this.kmy.setVisibility(4);
                this.kmz.setVisibility(4);
                apn();
                return;
            case 15:
                this.kmD.setImageResource(R.k.dvS);
                this.kmA.setText(R.l.dvS);
                this.kmB.setText(getString(R.l.dHU, new Object[]{Integer.valueOf(aol.kiK), Integer.valueOf(aol.kiL)}));
                this.kmB.setTextColor(getResources().getColor(R.e.brx));
                this.kmy.setText(R.l.dHr);
                this.kmB.setVisibility(0);
                this.kmy.setVisibility(0);
                this.kmz.setVisibility(4);
                this.kmy.setOnClickListener(new 1(this));
                apn();
                return;
            case 51:
                byte[] bArr = b.aoR().aoT().bitmapData;
                this.kmD.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                this.kmA.setText(R.l.dIf);
                this.kmA.setTextColor(this.mController.xIM.getResources().getColor(R.e.black));
                this.kmB.setVisibility(4);
                this.kmy.setVisibility(4);
                this.kmz.setVisibility(4);
                apn();
                return;
            default:
                return;
        }
    }

    public final void aok() {
    }

    private void apn() {
        this.kmC.setText(R.l.dHq);
        this.kmC.setOnClickListener(new 2(this));
    }

    private void apo() {
        x.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[]{Integer.valueOf(b.aoR().aol().kiJ)});
        switch (b.aoR().aol().kiJ) {
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -11:
            case -4:
            case 1:
            case 4:
            case 12:
            case 13:
            case 14:
            case 51:
                h.a((Context) this, R.l.dIe, R.l.dId, R.l.dIz, R.l.dHo, new 3(this), null, R.e.brw);
                return;
            case 15:
                x.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
                b.aoR().aoV().cancel();
                b.aoR().aoV().aoP();
                b.aoR().aoT().al(true);
                b.aoR().aoS().stop();
                b.aoR().aol().kiJ = -100;
                DU(1);
                return;
            default:
                DU(1);
                return;
        }
    }
}
