package com.tencent.mm.plugin.freewifi.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FreeWifiManufacturerLoadingUI extends MMActivity {
    private String bssid;
    private ak fhK;
    private ImageView mHO;
    private TextView mHP;
    private Button mHQ;
    private final int mHR = 1;
    private final int mHS = 2;
    private final int mHT = 3;
    private int[] mHU = new int[]{R.g.bCk, R.g.bCl, R.g.bCm, R.g.bCn, R.g.bCo};
    af mHV = new 1(this);
    af mHW = new af();
    private String ssid;

    static /* synthetic */ void b(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, String str) {
        freeWifiManufacturerLoadingUI.ai(0, "");
        freeWifiManufacturerLoadingUI.AU(freeWifiManufacturerLoadingUI.getString(R.l.ejW));
        freeWifiManufacturerLoadingUI.aMH();
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "opening url : " + str);
        ag.y(new 7(freeWifiManufacturerLoadingUI, str));
    }

    static /* synthetic */ void f(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_channel_id", 10);
        intent.setClass(freeWifiManufacturerLoadingUI, FreeWifiSuccUI.class);
        freeWifiManufacturerLoadingUI.startActivity(intent);
        freeWifiManufacturerLoadingUI.finish();
        freeWifiManufacturerLoadingUI.overridePendingTransition(R.a.bqB, R.a.bqA);
    }

    static /* synthetic */ boolean g(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        String by = by(ac.getContext());
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "topActivityName : " + by);
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "getClas().getName()=" + freeWifiManufacturerLoadingUI.getClass().getName());
        boolean z = by != null && by.equals(freeWifiManufacturerLoadingUI.getClass().getName());
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ret = " + z);
        return z;
    }

    static /* synthetic */ String m(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readLine = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(readLine);
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 != null) {
                stringBuilder.append(readLine2);
            } else {
                x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body=" + stringBuilder.toString());
                return m.AC(readLine);
            }
        }
    }

    private void aMH() {
        if (this.fhK != null) {
            this.fhK.TG();
        }
        this.mHV.sendEmptyMessage(2);
    }

    protected final int getLayoutId() {
        return R.i.diA;
    }

    public void finish() {
        aMH();
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ekc);
        this.ssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid");
        this.bssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid");
        this.mHO = (ImageView) findViewById(R.h.cjz);
        this.mHP = (TextView) findViewById(R.h.cjA);
        this.mHQ = (Button) findViewById(R.h.cjB);
        this.mHQ.setOnClickListener(new 2(this));
        setBackBtn(new 3(this));
        aMI();
    }

    public final void aMI() {
        this.mHV.sendEmptyMessage(1);
        if (this.fhK != null) {
            this.fhK.TG();
        }
        this.fhK = new ak(new 4(this), true);
        this.fhK.J(200, 200);
        j.aLR().aLz().post(new 5(this, this.ssid));
    }

    private void ai(int i, String str) {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "errcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        if (i != 0) {
            aMH();
            if (i == 1154) {
                AU(getString(R.l.ejV) + "(031" + b.mDg.mDi + "-" + Math.abs(i) + ")");
                return;
            }
            AU(getString(R.l.ejU) + "(031" + b.mDg.mDi + "-" + Math.abs(i) + ")");
            this.mHW.postDelayed(new 6(this), 0);
        }
    }

    private void AU(String str) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = str;
        this.mHV.sendMessage(obtain);
    }

    private static String by(Context context) {
        try {
            String className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "top activity name =" + className);
            return className;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", e, "", new Object[0]);
            return "(null)";
        }
    }
}
