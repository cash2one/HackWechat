package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class m {
    boolean pyw = true;
    Runnable xHM;

    public final boolean c(Activity activity, Runnable runnable) {
        x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", new Object[]{Boolean.valueOf(a.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", ""))});
        if (a.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "")) {
            x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", new Object[]{Boolean.valueOf(a.a(activity, "android.permission.READ_PHONE_STATE", 96, "", ""))});
            if (a.a(activity, "android.permission.READ_PHONE_STATE", 96, "", "")) {
                x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "start time check launcherUIOnCreate from begin time ==" + (System.currentTimeMillis() - LauncherUI.xGR));
                f.ed(LauncherUI.xGR);
                return true;
            }
            this.xHM = runnable;
            return false;
        }
        this.xHM = runnable;
        return false;
    }

    public final boolean a(Activity activity, int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.LauncherUI.LauncherUICheckPermissionHelper";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bh.cgy();
            x.w(str, str2, objArr);
            ag.h(new 1(this), 500);
            return true;
        }
        x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        int i2;
        switch (i) {
            case 32:
            case 64:
            case 96:
                i2 = R.l.ezS;
                if (i == 96) {
                    i2 = R.l.ezR;
                } else if (i == 64) {
                    i2 = R.l.ezP;
                }
                if (iArr[0] == 0) {
                    if (i == 32) {
                        d.pPH.a(462, 0, 1, true);
                    } else if (i == 96) {
                        d.pPH.a(462, 1, 1, true);
                        q.bf(true);
                    } else {
                        d.pPH.a(462, 2, 1, true);
                    }
                    if (this.xHM != null) {
                        this.xHM.run();
                    }
                } else {
                    h.a(activity, activity.getString(i2), activity.getString(R.l.ezT), activity.getString(R.l.est), activity.getString(R.l.cancel), false, new 2(this, i, activity), new 3(this, i, activity));
                }
                return true;
            case 33:
            case 70:
            case 97:
                i2 = R.l.ezS;
                if (i == 97) {
                    i2 = R.l.ezR;
                } else if (i == 70) {
                    i2 = R.l.ezP;
                }
                if (iArr[0] != 0) {
                    this.pyw = false;
                    h.a(activity, activity.getString(i2), activity.getString(R.l.ezT), activity.getString(R.l.est), activity.getString(R.l.cancel), false, new 4(this, i, activity), new 5(this, i, activity));
                } else if (i == 33) {
                    d.pPH.a(462, 9, 1, true);
                } else if (i == 97) {
                    d.pPH.a(462, 10, 1, true);
                } else {
                    d.pPH.a(462, 11, 1, true);
                }
                return true;
            default:
                return false;
        }
    }
}
