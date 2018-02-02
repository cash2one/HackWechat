package com.tencent.mm.plugin.voip.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.mm.R;
import com.tencent.mm.bn.d.a;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class l {
    private static boolean smQ = false;
    private static OnClickListener smR = new 3();

    public static long a(String str, String str2, int i, int i2, String str3) {
        return a(str, str2, i, i2, str3, false);
    }

    public static long a(String str, String str2, int i, int i2, String str3, boolean z) {
        cf auVar = new au();
        auVar.aq(ba.hR(str));
        auVar.eR(i);
        auVar.setType(50);
        auVar.dS(str);
        auVar.dY(str3);
        auVar.setContent(str2);
        auVar.eQ(i2);
        if (z) {
            auVar.fb(auVar.gjE | 8);
        }
        ar.Hg();
        long Q = c.Fa().Q(auVar);
        if (Q < 0) {
            x.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
        }
        x.d("MicroMsg.VoipPluginManager", "inset voip  msgId " + Q);
        return Q;
    }

    public static void bHk() {
        ar.Hg();
        c.CU().set(20480, Long.valueOf(System.currentTimeMillis()));
    }

    public static boolean bHl() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            ar.Hg();
            long longValue = ((Long) c.CU().get(20480, Integer.valueOf(-1))).longValue();
            if (longValue < 0) {
                return false;
            }
            currentTimeMillis -= longValue;
            x.d("MicroMsg.VoipPluginManager", "diff is" + currentTimeMillis);
            if (currentTimeMillis < 21600000) {
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }

    public static void aB(final Context context, String str) {
        new String[1][0] = context.getResources().getString(R.l.eUe);
        smQ = false;
        try {
            ar.Hg();
            cf Ey = c.Fa().Ey(str);
            if (Ey != null) {
                long j = Ey.field_createTime;
                smQ = d.bIm();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        if (bh.ov(str)) {
            x.e("MicroMsg.VoipPluginManager", "talker is null");
            return;
        }
        int Km = ar.CG().Km();
        x.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus " + Km);
        if (Km != 4 && Km != 6) {
            g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().smS.siL.ske.nDx), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(4), Integer.valueOf(0)});
            h.a(context, R.l.eVz, R.l.eVD, smR);
        } else if (!smQ) {
            try {
                ar.Hg();
                Map Tk = a.Tk((String) c.CU().get(77829, null));
                if (Tk != null) {
                    a aVar;
                    if (Tk != null && Tk.size() > 0) {
                        if (Tk.containsKey(str)) {
                            aVar = (a) Tk.get(str);
                            aVar.hitCount++;
                            Tk.put(str, aVar);
                        } else {
                            aVar = new a();
                            aVar.hitCount++;
                            Tk.put(str, aVar);
                        }
                    }
                    ar.Hg();
                    c.CU().set(77829, a.as(Tk));
                    for (Entry entry : Tk.entrySet()) {
                        aVar = (a) entry.getValue();
                        x.d("MicroMsg.VoipPluginManager", "val1 " + aVar.hitCount + " " + aVar.hJB + "name " + ((String) entry.getKey()));
                    }
                } else {
                    Map hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.hitCount++;
                    hashMap.put(str, aVar2);
                    ar.Hg();
                    c.CU().set(77829, a.as(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        aVar2 = (a) entry2.getValue();
                        x.d("MicroMsg.VoipPluginManager", "val2 " + aVar2.hitCount + " " + aVar2.hJB + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
            }
            InviteRemindDialog.k(context, str, 0);
            bHm();
        } else if (an.isWap(context)) {
            h.a(context, R.l.eVP, 0, R.l.eVQ, R.l.dEn, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    l.dB(context);
                    l.bHm();
                }
            }, smR);
        } else if (an.isWifi(context) || bHl()) {
            d.bGj().aG(context, str);
        } else {
            h.a(context, R.l.eVC, R.l.eVD, new 1(context, str), smR);
        }
    }

    private static void bHm() {
        b spVar = new sp();
        spVar.fKq.fuL = 8;
        com.tencent.mm.sdk.b.a.xef.m(spVar);
    }

    public static void dB(Context context) {
        try {
            Intent intent = new Intent("/");
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ApnSettings"));
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
        } catch (Exception e) {
            searchIntentByClass(context, "ApnSettings");
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            List installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                x.e("MicroMsg.VoipPluginManager", "package  size" + installedPackages.size());
                for (int i = 0; i < installedPackages.size(); i++) {
                    try {
                        x.e("MicroMsg.VoipPluginManager", "package " + ((PackageInfo) installedPackages.get(i)).packageName);
                        Intent intent = new Intent();
                        intent.setPackage(((PackageInfo) installedPackages.get(i)).packageName);
                        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            try {
                                x.e("MicroMsg.VoipPluginManager", "activityName count " + size);
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i2)).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent("/");
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        context.startActivity(intent2);
                                        return intent2;
                                    }
                                }
                                continue;
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
                            }
                        } else {
                            continue;
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
                    }
                }
            }
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.VoipPluginManager", e22, "", new Object[0]);
        }
        return null;
    }

    public static void aC(Context context, String str) {
        com.tencent.mm.k.g.zZ();
        if (com.tencent.mm.k.c.zJ() == 2) {
            int i = 1;
        } else {
            boolean z = false;
        }
        com.tencent.mm.bm.d.ccW();
        if (i == 0) {
            x.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[]{Boolean.valueOf(false), Boolean.valueOf(false)});
        }
        smQ = false;
        try {
            ar.Hg();
            cf Ey = c.Fa().Ey(str);
            if (Ey != null) {
                long j = Ey.field_createTime;
                smQ = d.bIm();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        aE(context, str);
    }

    public static void aD(Context context, String str) {
        smQ = false;
        try {
            ar.Hg();
            cf Ey = c.Fa().Ey(str);
            if (Ey != null) {
                long j = Ey.field_createTime;
                smQ = d.bIm();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        aE(context, str);
    }

    private static void aE(final Context context, final String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.VoipPluginManager", "talker is null");
            return;
        }
        int Km = ar.CG().Km();
        x.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus " + Km);
        if (Km != 4 && Km != 6) {
            g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().smS.siL.ske.nDx), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(4), Integer.valueOf(0)});
            h.a(context, R.l.eVz, R.l.eVD, smR);
        } else if (!smQ) {
            try {
                ar.Hg();
                Map Tk = a.Tk((String) c.CU().get(77829, null));
                if (Tk != null) {
                    a aVar;
                    if (Tk != null && Tk.size() > 0) {
                        if (Tk.containsKey(str)) {
                            aVar = (a) Tk.get(str);
                            aVar.hitCount++;
                            Tk.put(str, aVar);
                        } else {
                            aVar = new a();
                            aVar.hitCount++;
                            Tk.put(str, aVar);
                        }
                    }
                    ar.Hg();
                    c.CU().set(77829, a.as(Tk));
                    for (Entry entry : Tk.entrySet()) {
                        aVar = (a) entry.getValue();
                        x.d("MicroMsg.VoipPluginManager", "val1 " + aVar.hitCount + " " + aVar.hJB + "name " + ((String) entry.getKey()));
                    }
                } else {
                    Map hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.hitCount++;
                    hashMap.put(str, aVar2);
                    ar.Hg();
                    c.CU().set(77829, a.as(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        aVar2 = (a) entry2.getValue();
                        x.d("MicroMsg.VoipPluginManager", "val2 " + aVar2.hitCount + " " + aVar2.hJB + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
            }
            InviteRemindDialog.k(context, str, 1);
            bHm();
        } else if (an.isWap(context)) {
            h.a(context, R.l.eVP, 0, R.l.eVQ, R.l.dEn, new 5(context), smR);
        } else if (an.isWifi(context) || bHl()) {
            d.bGj().aF(context, str);
        } else {
            h.a(context, R.l.eVC, R.l.eVD, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    l.bHk();
                    d.bGj().aF(context, str);
                }
            }, smR);
        }
    }
}
