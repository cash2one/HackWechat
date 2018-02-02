package com.tencent.mm.permission;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.k.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class b {
    static final String ffq;
    static final String ffr;
    static Map<Integer, a> ibJ;
    c ibK = new 1(this);
    private c ibL = new 2(this);
    private c ibM = new 3(this);

    static /* synthetic */ void b(int i, boolean z, boolean z2) {
        x.i("MicroMsg.PermissionMgr", "makeMark, setOrClear: " + z);
        ar.He().setInt(((a) ibJ.get(Integer.valueOf(i))).ibO, z ? 1 : 0);
        if (true == z) {
            a.VZ().Wa();
        }
        if (!z && true == z2) {
            long j = ar.He().getLong(((a) ibJ.get(Integer.valueOf(i))).ibP, 0);
            if (0 != j && System.currentTimeMillis() - j >= 86400000) {
                ab("LastTick: " + j + ", CurrentTtick: " + System.currentTimeMillis() + "\n", ar.He().Dl(((a) ibJ.get(Integer.valueOf(i))).ibQ) == 1 ? 6 : 5);
                ar.He().setLong(((a) ibJ.get(Integer.valueOf(i))).ibP, 0);
            }
        }
    }

    static /* synthetic */ boolean iU(int i) {
        int Dl = ar.He().Dl(((a) ibJ.get(Integer.valueOf(i))).ibO);
        x.i("MicroMsg.PermissionMgr", "current mark status: " + Dl);
        return Dl == 0;
    }

    static /* synthetic */ boolean t(int i, boolean z) {
        int ok;
        int ok2;
        int ok3;
        boolean z2;
        a aVar = new a();
        if (ar.Hj()) {
            ok = ok("ShowPermissionDialog");
            ok2 = ok("OnlyScanRunningService");
            ok3 = ok("Interval4ShowPmsDialog");
        } else {
            ok = 1;
            ok2 = 1;
            ok3 = 3600000;
        }
        x.i("MicroMsg.PermissionMgr", "showDlg: %d, filter: %d, interval: %d", new Object[]{Integer.valueOf(ok), Integer.valueOf(ok2), Integer.valueOf(ok3)});
        long j = 0;
        for (a aVar2 : ibJ.values()) {
            long j2 = ar.He().getLong(aVar2.ibP, 0);
            if (j < j2) {
                j = j2;
            }
        }
        boolean z3 = 1 == ok && System.currentTimeMillis() - j >= ((long) ok3);
        if (z3) {
            String str;
            z2 = 1 == ok2;
            List arrayList = new ArrayList();
            List<a$b> arrayList2 = new ArrayList();
            List<com.tencent.mm.compatible.e.a.a> arrayList3 = new ArrayList();
            com.tencent.mm.compatible.e.a.a(e.gZK + "permissioncfg.cfg", arrayList2, arrayList3);
            String str2 = null;
            PInt pInt = new PInt(0);
            PBool pBool = new PBool();
            for (a$b com_tencent_mm_compatible_e_a_b : arrayList2) {
                pInt.value = 0;
                pBool.value = true;
                if (com.tencent.mm.compatible.e.a.a(Build.MANUFACTURER, com_tencent_mm_compatible_e_a_b.gHd, pInt, pBool) && com.tencent.mm.compatible.e.a.a(Build.MODEL, com_tencent_mm_compatible_e_a_b.model, pInt, pBool)) {
                    com.tencent.mm.compatible.e.a.a(VERSION.RELEASE, com_tencent_mm_compatible_e_a_b.version, pInt, pBool);
                }
                str = (!pBool.value || pInt.value <= 0) ? str2 : (String) com_tencent_mm_compatible_e_a_b.gHc.get(i);
                str2 = str;
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            List<PackageInfo> bh = com.tencent.mm.compatible.e.a.bh(z2);
            if (bh != null) {
                for (PackageInfo packageInfo : bh) {
                    str2 = null;
                    for (com.tencent.mm.compatible.e.a.a aVar3 : arrayList3) {
                        pInt.value = 0;
                        pBool.value = true;
                        if (com.tencent.mm.compatible.e.a.a(packageInfo.packageName, aVar3.ffw, pInt, pBool)) {
                            if (aVar3.gGZ == 0 && aVar3.gHa == 0) {
                                pBool.value = true;
                            } else if (aVar3.gGZ > packageInfo.versionCode || aVar3.gHa < packageInfo.versionCode) {
                                pBool.value = false;
                            } else {
                                pInt.value++;
                                pBool.value = true;
                            }
                        }
                        str = (!pBool.value || pInt.value <= 0) ? str2 : (String) aVar3.gHc.get(i);
                        str2 = str;
                    }
                    if (str2 != null) {
                        arrayList.add(str2);
                    }
                }
            }
            x.i("MicroMsg.PermissionMgr", "len of tips list: " + Integer.valueOf(arrayList.size()));
            if (arrayList.size() != 0) {
                a(i, arrayList, z);
                c(arrayList, z);
                z2 = true;
            } else {
                if (System.currentTimeMillis() - ar.He().getLong(42, 0) < 2592000000L) {
                    cg(z);
                } else if (1 == i) {
                    ar.He().setLong(42, System.currentTimeMillis());
                    PermissionWarningDialog.a(ac.getContext(), 1 == ok2, z);
                }
                z2 = false;
            }
            ar.He().setLong(((a) ibJ.get(Integer.valueOf(i))).ibP, System.currentTimeMillis());
        } else {
            z2 = false;
        }
        x.i("MicroMsg.PermissionMgr", "showPermissionDialog cost: " + aVar.zi() + ", needShowDlg: " + z3);
        return z2;
    }

    static {
        String yF = q.yF();
        ffq = yF;
        ffr = o.getString(yF.hashCode());
        Map hashMap = new HashMap();
        ibJ = hashMap;
        hashMap.put(Integer.valueOf(1), new a(38, 40, 41, R.l.dGg, R.l.dFY));
        ibJ.put(Integer.valueOf(2), new a(43, 44, 45, R.l.dGf, R.l.dFZ));
    }

    public b() {
        com.tencent.mm.sdk.b.a.xef.b(this.ibK);
        com.tencent.mm.sdk.b.a.xef.b(this.ibL);
        com.tencent.mm.sdk.b.a.xef.b(this.ibM);
    }

    private static int ok(String str) {
        int i = 0;
        try {
            i = bh.getInt(g.zY().getValue(str), 0);
        } catch (Exception e) {
            x.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: " + str);
        }
        return i;
    }

    public static void cg(boolean z) {
        ab("App_List:\n", z ? 4 : 3);
    }

    public static void j(boolean z, boolean z2) {
        StringBuilder stringBuilder = new StringBuilder();
        PackageManager packageManager = ac.getContext().getPackageManager();
        List<PackageInfo> bh = com.tencent.mm.compatible.e.a.bh(z);
        if (bh != null) {
            stringBuilder.append("App_List:\n");
            for (PackageInfo packageInfo : bh) {
                if (packageInfo != null) {
                    String str = "";
                    if (!(packageInfo.applicationInfo == null || packageManager == null)) {
                        str = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                    }
                    stringBuilder.append(str + ":" + packageInfo.packageName + ":" + packageInfo.versionCode + "\n");
                }
            }
        }
        ab(stringBuilder.toString(), z2 ? 4 : 3);
    }

    private static void c(List<String> list, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Match_Tips:\n");
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append((String) list.get(i));
            stringBuilder.append("\n");
        }
        ab(stringBuilder.toString(), z ? 2 : 1);
    }

    private static void a(int i, List<String> list, boolean z) {
        int i2;
        int i3;
        int size = list.size() > 5 ? 5 : list.size();
        int[] iArr = new int[]{R.l.dGc, R.l.dGh, R.l.dGe, R.l.dGb, R.l.dGa};
        Context context = ac.getContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getString(((a) ibJ.get(Integer.valueOf(i))).ibS));
        for (i2 = 0; i2 < size; i2++) {
            stringBuilder.append(context.getString(iArr[i2]));
            stringBuilder.append((String) list.get(i2));
            stringBuilder.append('\n');
        }
        s He = ar.He();
        i2 = ((a) ibJ.get(Integer.valueOf(i))).ibQ;
        if (z) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        He.setInt(i2, i3);
        PermissionWarningDialog.i(context, context.getString(((a) ibJ.get(Integer.valueOf(i))).ibR), stringBuilder.toString());
    }

    private static void ab(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n#client.version=").append(d.vAz).append("\n");
        stringBuilder.append("#accinfo.revision=").append(com.tencent.mm.sdk.platformtools.e.REV).append("\n");
        stringBuilder.append("#accinfo.uin=").append(aq.hfP.H("last_login_uin", ffr)).append("\n");
        stringBuilder.append("#accinfo.dev=").append(ffq).append("\n");
        stringBuilder.append("#accinfo.build=").append(com.tencent.mm.sdk.platformtools.e.TIME).append(":").append(com.tencent.mm.sdk.platformtools.e.HOSTNAME).append(":").append(f.fdS).append("\n");
        Date date = new Date();
        stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append("\n");
        stringBuilder.append("#permission.type=").append(String.valueOf(i)).append('\n');
        stringBuilder.append("#permission.content:\n");
        Intent intent = new Intent();
        intent.setClassName(ac.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionWriteSdcard", false);
        intent.putExtra("exceptionPid", Process.myPid());
        String str2 = "userName";
        String H = aq.hfP.H("login_weixin_username", "");
        if (bh.ov(H)) {
            H = aq.hfP.H("login_user_name", "never_login_crash");
        }
        intent.putExtra(str2, H);
        intent.putExtra("tag", "permission");
        x.d("MicroMsg.PermissionMgr", "report type: %d, len: %d", new Object[]{Integer.valueOf(i), Integer.valueOf((stringBuilder.toString() + str).length())});
        intent.putExtra("exceptionMsg", Base64.encodeToString(H.getBytes(), 2));
        ac.getContext().startService(intent);
    }
}
