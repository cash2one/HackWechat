package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.ba.a;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public final class b {
    private static boolean isDeleteCancel = false;
    private static r tipDialog = null;

    public static void a(d dVar, Activity activity, x xVar, int i) {
        a(dVar, activity, xVar, false, null, i);
    }

    public static void a(d dVar, Activity activity, x xVar, boolean z, Runnable runnable, int i) {
        if (dVar == null || activity == null || xVar == null) {
            boolean z2;
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "bizInfo null : %s, context null : %s, ct null : %s";
            Object[] objArr = new Object[3];
            if (dVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (activity == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (xVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            com.tencent.mm.sdk.platformtools.x.e(str, str2, objArr);
            return;
        }
        String string;
        if (dVar.Lf()) {
            string = activity.getString(R.l.dNd);
        } else {
            string = activity.getString(R.l.dNe, new Object[]{xVar.AQ()});
        }
        h.a(activity, string, "", activity.getString(R.l.dWi), activity.getString(R.l.dEn), new 1(dVar, activity, xVar, z, i, runnable), null);
    }

    public static void a(d dVar, Activity activity, x xVar, boolean z) {
        a(dVar, activity, xVar, false, 0);
    }

    public static void a(d dVar, Activity activity, x xVar, boolean z, int i) {
        boolean z2 = true;
        if (dVar == null || activity == null || xVar == null) {
            boolean z3;
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "error args, %b, %b, %b";
            Object[] objArr = new Object[3];
            if (dVar == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[0] = Boolean.valueOf(z3);
            if (activity == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[1] = Boolean.valueOf(z3);
            if (xVar != null) {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            com.tencent.mm.sdk.platformtools.x.e(str, str2, objArr);
            return;
        }
        final String str3 = xVar.field_username;
        xVar.Ah();
        ar.Hg();
        c.EX().b(new com.tencent.mm.ay.c(str3, i));
        if (s.gC(str3)) {
            ar.Hg();
            c.EY().WU(str3);
            ar.Hg();
            c.Fh().hJ(str3);
        } else {
            isDeleteCancel = false;
            activity.getString(R.l.dGO);
            tipDialog = h.a(activity, activity.getString(R.l.dHc), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    b.isDeleteCancel = true;
                }
            });
            a anonymousClass3 = new a() {
                public final boolean HB() {
                    return b.isDeleteCancel;
                }

                public final void HA() {
                    y.Mf().jL(str3);
                    if (b.tipDialog != null) {
                        b.tipDialog.dismiss();
                        b.tipDialog = null;
                    }
                }
            };
            ar.Hg();
            c.EY().a(str3, xVar);
            if (dVar.Le()) {
                f.ka(dVar.field_username);
            } else {
                ba.a(str3, anonymousClass3);
                ar.Hg();
                c.Fd().WX(str3);
            }
            if (activity != null && z) {
                activity.setResult(-1, activity.getIntent().putExtra("_delete_ok_", true));
            }
        }
        if (com.tencent.mm.app.plugin.a.a.a(dVar)) {
            com.tencent.mm.sdk.b.b eoVar = new eo();
            eoVar.ftf.frn = str3;
            com.tencent.mm.sdk.b.a.xef.m(eoVar);
        }
        i Me = y.Me();
        if (!bh.ov(str3)) {
            int delete = Me.gJP.delete("BizKF", "brandUsername = ?", new String[]{str3});
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", new Object[]{str3, Integer.valueOf(delete)});
        }
        if (z) {
            if (activity.getIntent().getIntExtra("Kdel_from", -1) == 0) {
                Intent intent = new Intent(activity, LauncherUI.class);
                intent.addFlags(67108864);
                activity.startActivity(intent);
            }
            activity.finish();
        }
    }
}
