package com.tencent.mm.plugin.gcm.modelgcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.gcm.a;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import java.util.List;

public class GcmBroadcastReceiver extends BroadcastReceiver {
    static List<Pair<Long, Long>> nyf = new LinkedList();
    private static volatile boolean nyg = false;
    private static WakerLock wakerlock = null;

    public static void aRZ() {
        nyf.clear();
    }

    public void onReceive(Context context, Intent intent) {
        x.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive in.");
        String stringExtra;
        if (intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION")) {
            a aSa = a.aSa();
            String aSd = aSa.aSd();
            stringExtra = intent.getStringExtra("registration_id");
            x.i("GcmBroadcastReceiver", "REGISTRATION intent received:" + intent.toString());
            if (intent.getStringExtra("error") == null) {
                if (!(intent.getStringExtra("unregistered") != null || stringExtra == null || aSd.compareTo(stringExtra) == 0)) {
                    if (aa.VO() == null) {
                        x.w("GcmBroadcastReceiver", "gcm reg id recv, but mmpushcore not init, id = " + stringExtra);
                    } else {
                        aSa.af(context, stringExtra);
                        aa.VO().post(new 2(aSa));
                    }
                }
            }
            d.pPH.a(452, 25, 1, false);
            return;
        }
        a aSa2 = a.aSa();
        Object[] objArr;
        if (aSa2 == null || bh.ov(aSa2.aSd())) {
            aSd = "GcmBroadcastReceiver";
            stringExtra = "Gcm push is not reg to server. reg == null[%b], isRegToSvr[%b]";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(aSa2 == null);
            objArr[1] = Boolean.valueOf(aSa2 == null ? false : aSa2.aSi());
            x.i(aSd, stringExtra, objArr);
            g.pQN.k(11250, new StringBuilder("1,2").toString());
            d.pPH.a(452, aSa2 == null ? 26 : 27, 1, false);
        } else if (aSa2.aSe()) {
            d.pPH.a(452, 42, 1, false);
            if (nyg) {
                x.i("GcmBroadcastReceiver", "Gcm push isRegistrationExpired and reNewalRegistting return");
                d.pPH.a(452, 44, 1, false);
            } else if (aa.VO() == null) {
                x.i("GcmBroadcastReceiver", "Gcm push isRegistrationExpired but handler is null wait for next push");
            } else {
                nyg = true;
                aa.VO().postDelayed(new 1(this, aSa2), 500);
            }
        } else {
            nyg = false;
            try {
                if (k.aX(context)) {
                    x.i("GcmBroadcastReceiver", "Logout or exit MM. no need show Notification.");
                    g.pQN.k(11250, new StringBuilder("1,2").toString());
                    d.pPH.a(452, 28, 1, false);
                    return;
                }
                Bundle extras = intent.getExtras();
                a.J(context);
                aSd = a.c(intent);
                if (extras.isEmpty()) {
                    x.i("GcmBroadcastReceiver", "Intent extras is empty: ");
                    g.pQN.k(11250, new StringBuilder("1,0").toString());
                    d.pPH.a(452, 29, 1, false);
                    return;
                }
                String string = extras.getString("seq");
                String string2 = extras.getString(OpenSDKTool4Assistant.EXTRA_UIN);
                String string3 = extras.getString("cmd");
                String string4 = extras.getString("username");
                String string5 = extras.getString("time");
                String string6 = extras.getString("collapse_key");
                String string7 = extras.getString("sound");
                String string8 = extras.getString("alert");
                String string9 = extras.getString("msgType");
                String string10 = extras.getString("badge");
                String string11 = extras.getString("from");
                extras.getString("ext");
                if ("send_error".equals(aSd)) {
                    aSd = "GcmBroadcastReceiver";
                    stringExtra = "Send error:. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]";
                    objArr = new Object[11];
                    objArr[0] = string;
                    objArr[1] = string2;
                    objArr[2] = string3;
                    objArr[3] = bh.VT(string4);
                    objArr[4] = string5;
                    objArr[5] = string6;
                    objArr[6] = string7;
                    objArr[7] = Integer.valueOf(string8 == null ? -1 : string8.length());
                    objArr[8] = string9;
                    objArr[9] = string10;
                    objArr[10] = string11;
                    x.i(aSd, stringExtra, objArr);
                    g.pQN.k(11250, new StringBuilder("1,1").toString());
                    d.pPH.a(452, 30, 1, false);
                } else if ("deleted_messages".equals(aSd)) {
                    x.i("GcmBroadcastReceiver", "Deleted messages on server.");
                    g.pQN.k(11250, new StringBuilder("1,1").toString());
                    d.pPH.a(452, 31, 1, false);
                } else if ("gcm".equals(aSd)) {
                    d.pPH.a(452, 32, 1, false);
                    aSd = "GcmBroadcastReceiver";
                    stringExtra = "Received gcm msg. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]";
                    objArr = new Object[11];
                    objArr[0] = string;
                    objArr[1] = string2;
                    objArr[2] = string3;
                    objArr[3] = bh.VT(string4);
                    objArr[4] = string5;
                    objArr[5] = string6;
                    objArr[6] = string7;
                    objArr[7] = Integer.valueOf(string8 == null ? -1 : string8.length());
                    objArr[8] = string9;
                    objArr[9] = string10;
                    objArr[10] = string11;
                    x.i(aSd, stringExtra, objArr);
                    long j = bh.ov(string2) ? 0 : bh.getLong(string2, 0);
                    long j2 = bh.ov(string) ? 0 : bh.getLong(string, 0);
                    long j3 = bh.ov(string3) ? 0 : bh.getLong(string3, 0);
                    int CA = com.tencent.mm.kernel.a.CA();
                    if (j == 0 || !Integer.toHexString(CA).equals(Long.toHexString(j))) {
                        x.e("GcmBroadcastReceiver", "Logined user changed. no need show Notification.uin:" + j + ", oldUin:" + CA);
                        g.pQN.k(11250, new StringBuilder("1,3").toString());
                        d dVar = d.pPH;
                        if (j == 0) {
                            j3 = 33;
                        } else {
                            j3 = 34;
                        }
                        dVar.a(452, j3, 1, false);
                        return;
                    }
                    Object obj;
                    for (Pair pair : nyf) {
                        if (((Long) pair.first).longValue() == j3 && ((Long) pair.second).longValue() == j2) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        x.w("GcmBroadcastReceiver", "already has this seq:" + j2);
                        d.pPH.a(452, 35, 1, false);
                        return;
                    }
                    nyf.add(Pair.create(Long.valueOf(j3), Long.valueOf(j2)));
                    if (nyf.size() > 60) {
                        nyf.remove(0);
                    }
                    if (wakerlock == null) {
                        wakerlock = new WakerLock(context);
                        x.i("GcmBroadcastReceiver", "start new wakerlock");
                    }
                    wakerlock.lock(200, "GcmBroadcastReceiver.onReceive");
                    b gkVar = new gk();
                    gkVar.fwx.type = 13;
                    com.tencent.mm.sdk.b.a.xef.m(gkVar);
                }
                x.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive out.");
            } catch (Throwable e) {
                x.e("GcmBroadcastReceiver", "GcmBroadcastReceiver error :" + e.toString());
                x.printErrStackTrace("GcmBroadcastReceiver", e, "", new Object[0]);
                d.pPH.a(452, 36, 1, false);
            }
        }
    }
}
