package com.tencent.mm.plugin.nfc;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.plugin.nfc.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public class HCEService extends HostApduService {
    private static long mStartTime = -1;
    private static final byte[] oRD = new byte[]{(byte) 0, (byte) 0};
    private String mAppId = null;
    private boolean oRA = false;
    private a oRB = new a(this, (byte) 0);
    private com.tencent.mm.plugin.nfc.b.b oRC = new b();
    private c<ia> oRE = new 1(this);
    private ArrayList<String> oRw;
    private boolean oRx = false;
    private boolean oRy = true;
    private boolean oRz = false;

    private class b implements com.tencent.mm.plugin.nfc.b.b {
        final /* synthetic */ HCEService oRF;

        private b(HCEService hCEService) {
            this.oRF = hCEService;
        }

        public final void onCreate() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onCreate");
        }

        public final void onResume() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onResume");
            if (this.oRF.oRx) {
                this.oRF.bfp();
                this.oRF.oRx = false;
            }
        }

        public final void onPause() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onPause");
            this.oRF.bfq();
            this.oRF.oRx = true;
        }

        public final void onDestroy() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onDestroy");
        }
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onCreate");
        if (!com.tencent.mm.sdk.b.a.xef.d(this.oRE)) {
            com.tencent.mm.sdk.b.a.xef.a(this.oRE);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onDestroy");
        bfq();
        if (com.tencent.mm.sdk.b.a.xef.d(this.oRE)) {
            com.tencent.mm.sdk.b.a.xef.c(this.oRE);
        }
    }

    @TargetApi(21)
    private void bfp() {
        if (this.oRw == null) {
            x.e("MicroMsg.HCEService", "alvinluo mAidList is null, fail to register");
            return;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        if (defaultAdapter == null) {
            x.e("MicroMsg.HCEService", "alvinluo NfcAdapter is null when register aids");
        } else if (VERSION.SDK_INT < 21) {
            x.e("MicroMsg.HCEService", "alvinluo android version: %d is not satisfied when register aids", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
        } else {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                try {
                    ComponentName componentName = new ComponentName(this, HCEService.class);
                    x.i("MicroMsg.HCEService", "alvinluo register aids result: %b", new Object[]{Boolean.valueOf(instance.registerAidsForService(componentName, "payment", this.oRw))});
                    if (instance.registerAidsForService(componentName, "payment", this.oRw)) {
                        gZ(true);
                        List aidsForService = instance.getAidsForService(componentName, "payment");
                        if (aidsForService != null && aidsForService.size() > 0) {
                            for (int i = 0; i < aidsForService.size(); i++) {
                                x.e("MicroMsg.HCEService", "dynamicAIDList aid=" + ((String) aidsForService.get(i)));
                            }
                            return;
                        }
                        return;
                    }
                    gZ(false);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.HCEService", e, "alvinluo HCEService register aid exception", new Object[0]);
                    gZ(false);
                }
            }
        }
    }

    private void gZ(boolean z) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("errCode", 0);
            bundle.putString("errMsg", "");
        } else {
            bundle.putInt("errCode", 13006);
            bundle.putString("errMsg", "register aids failed");
        }
        d(this.mAppId, 12, bundle);
    }

    private static void d(String str, int i, Bundle bundle) {
        com.tencent.mm.sdk.b.b icVar = new ic();
        icVar.fyA.appId = str;
        icVar.fyA.type = i;
        icVar.fyA.extras = bundle;
        com.tencent.mm.sdk.b.a.xef.m(icVar);
    }

    @TargetApi(21)
    private void bfq() {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        if (defaultAdapter != null && VERSION.SDK_INT >= 21) {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                ComponentName componentName = new ComponentName(this, HCEService.class);
                x.i("MicroMsg.HCEService", "alvinluo HCEService unregister aids");
                instance.removeAidsForService(componentName, "payment");
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand");
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand start: %d", new Object[]{Long.valueOf(currentTimeMillis)});
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        this.mAppId = intent.getStringExtra("key_appid");
        this.oRw = intent.getStringArrayListExtra("key_aid_list");
        bfp();
        this.oRx = false;
        long currentTimeMillis2 = System.currentTimeMillis();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand end: %d, total: %d", new Object[]{Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
        return super.onStartCommand(intent, i, i2);
    }

    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND processCommandApdu, received command from system: %s", new Object[]{b.aD(bArr)});
        if (this.oRB != null) {
            this.oRB.dB(this.mAppId, new String(Base64.encode(bArr, 2)));
        }
        return null;
    }

    public void onDeactivated(int i) {
        x.i("MicroMsg.HCEService", "alvinluo HCEService onDeactivated reason: %d", new Object[]{Integer.valueOf(i)});
        this.oRz = false;
        this.oRA = false;
        Bundle bundle = new Bundle();
        bundle.putInt("key_on_deactivated_reason", i);
        d(this.mAppId, 41, bundle);
    }

    private synchronized void e(byte[] bArr, boolean z) {
        x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND sendResponseCommandToSystem isDefaultCommand: %b, hasCommandNotResponded: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.oRy)});
        if (this.oRy) {
            this.oRy = false;
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND send response command time: %d, cost: %d", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - mStartTime)});
            sendResponseApdu(bArr);
            if (z) {
                x.i("MicroMsg.HCEReportManager", "alvinluo reportHCEtimeExceeded appId: %s", new Object[]{this.mAppId});
                g.pQN.k(14838, r0);
            }
        }
    }
}
