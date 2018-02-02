package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.w;
import com.tencent.mm.k.g;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.pluginsdk.q$x;
import com.tencent.mm.pluginsdk.q.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Map;

public final class t {
    static ProgressDialog iln = null;
    private static boolean xJZ = false;
    static SecurityImage xKa = null;

    public static boolean a(final Activity activity, int i, int i2, final Intent intent, String str) {
        if (i != 4) {
            return false;
        }
        x.d("MicroMsg.MMErrorProcessor", "errType = " + i + " errCode = " + i2);
        switch (i2) {
            case -205:
            case -72:
            case -9:
            case -4:
            case -3:
                x.e("MicroMsg.MMErrorProcessor", "account expired=" + i2);
                h.a(activity, R.l.euv, R.l.dGO, new 6(intent, activity));
                return true;
            case -140:
            case -104:
                x.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i2), str});
                if (bh.ov(str) || !str.startsWith("autoauth_errmsg_")) {
                    if (i2 == -104) {
                        x.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", new Object[]{str});
                        break;
                    }
                }
                str = str.substring(16);
                if (!bh.ov(str) && str.startsWith("<")) {
                    Map y = bi.y(str, "e");
                    if (!(y == null || bh.ov((String) y.get(".e.Content")))) {
                        str = (String) y.get(".e.Content");
                    }
                }
                if (bh.ov(str)) {
                    str = ac.getContext().getString(R.l.euv);
                }
                h.a(activity, str, ac.getContext().getString(R.l.dGO), new 12(intent, activity));
                return true;
            case -100:
                String Ci = ar.Ci();
                x.e("MicroMsg.MMErrorProcessor", "account expired=" + i2 + " lastKickReason=" + Ci);
                a.xef.m(new w());
                b izVar = new iz();
                izVar.fzC.status = 0;
                izVar.fzC.aAk = 1;
                a.xef.m(izVar);
                ac.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
                String str2;
                if (xJZ) {
                    String str3 = "MicroMsg.MMErrorProcessor";
                    String str4 = "already show kickout dialog before, ignore. lastKickReason[%s]";
                    Object[] objArr = new Object[1];
                    if (bh.ov(Ci)) {
                        str2 = "";
                    } else {
                        str2 = Ci;
                    }
                    objArr[0] = str2;
                    x.i(str3, str4, objArr);
                    return true;
                }
                if (!bh.ov(Ci)) {
                    com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(Ci);
                    if (eA != null) {
                        x.i("MicroMsg.MMErrorProcessor", "account expired br showType[%d]", new Object[]{Integer.valueOf(eA.showType)});
                        if ((eA.showType == 3 || eA.showType == 4) && eA.a(activity, new 7(intent, activity, eA), new 8(intent, activity))) {
                            xJZ = true;
                            x.i("MicroMsg.MMErrorProcessor", "show kickout dialog by new logic.");
                            return true;
                        }
                    }
                }
                if (!bh.ov(Ci) && Ci.startsWith("<")) {
                    Map y2 = bi.y(Ci, "e");
                    if (!(y2 == null || bh.ov((String) y2.get(".e.Content")))) {
                        str2 = (String) y2.get(".e.Content");
                        x.i("MicroMsg.MMErrorProcessor", "account expired summerauthkick errmsg=" + str2 + " |v=" + y2);
                        Ci = str2;
                    }
                }
                x.i("MicroMsg.MMErrorProcessor", "account expired lastKickReason[%s]", new Object[]{Ci});
                if (bh.ov(Ci)) {
                    Ci = com.tencent.mm.bv.a.ac(activity, R.l.euu);
                }
                h.a(activity, Ci, activity.getString(R.l.dGO), new 9(intent, activity), new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        if (intent != null) {
                            if (!(activity instanceof LauncherUI)) {
                                activity.finish();
                            }
                            activity.startActivity(intent);
                            com.tencent.mm.ui.base.b.B(activity, intent);
                            d.br(activity);
                        }
                    }
                });
                xJZ = true;
                x.i("MicroMsg.MMErrorProcessor", "show kickout dialog by old logic.");
                return true;
            case -75:
                x.e("MicroMsg.MMErrorProcessor", "account expired=" + i2);
                h.a(activity, R.l.dDF, R.l.dGO, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            com.tencent.mm.ui.base.b.B(activity, intent);
                            d.br(activity);
                        }
                    }
                });
                return true;
        }
        return false;
    }

    public static i a(Activity activity, String str, String str2, Intent intent) {
        b izVar = new iz();
        izVar.fzC.status = 0;
        izVar.fzC.aAk = 1;
        a.xef.m(izVar);
        return h.a(activity, str, activity.getString(R.l.dGO), new 1(str2, activity, intent), new 2(str2, activity, intent));
    }

    public static boolean X(Activity activity) {
        boolean z = true;
        if (bh.VI(g.zY().getValue("SilentDownloadApkAtWiFi")) != 0) {
            return false;
        }
        ar.Hg();
        boolean z2 = (((Integer) c.CU().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
        if (!(an.isWifi(activity) && z2)) {
            z = false;
        }
        if ((f.fdU & 1) != 0) {
            x.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
            z = false;
        } else {
            x.d("MicroMsg.MMErrorProcessor", "not channel pack.");
        }
        if (z && p.bZb()) {
            return Y(activity);
        }
        return false;
    }

    public static boolean fu(Context context) {
        String bYY = p.bYY();
        x.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", new Object[]{bYY, Integer.valueOf(p.bYZ())});
        if (bh.ov(bYY) || p.bZa()) {
            return false;
        }
        ar.Dm().F(new 3(r3, bYY, context));
        return true;
    }

    public static boolean c(final Activity activity, int i, int i2) {
        x.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.protocal.d.vAz), Integer.valueOf(f.fdS), Integer.valueOf(f.fdU)});
        if (i != 4) {
            return false;
        }
        s b;
        switch (i2) {
            case -17:
                long j = ac.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1);
                x.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", new Object[]{Long.valueOf(j), Long.valueOf(bh.by(j))});
                if (j != -1 && bh.by(j) < 86400) {
                    return true;
                }
                if ((f.fdU & 2) != 0) {
                    x.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    return true;
                }
                x.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                String value = g.zY().getValue("SilentDownloadApkAtWiFi");
                ar.Hg();
                boolean z = ((((Integer) c.CU().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : null) != null && (bh.ov(value) || bh.VI(value) == 0);
                if ((f.fdU & 1) != 0) {
                    x.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    z = false;
                } else {
                    x.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                }
                if (bh.VI(value) != 0) {
                    x.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
                }
                x.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", new Object[]{Boolean.valueOf(z)});
                if (z) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(405, 40, 1, true);
                    return Y(activity);
                } else if (q$x.bYd() == null) {
                    return false;
                } else {
                    b = q$x.bYd().b(activity, new 5(null, activity));
                    com.tencent.mm.plugin.report.service.g.pQN.a(405, 38, 1, true);
                    b.update(2);
                    return true;
                }
            case -16:
                if (q$x.bYd() == null) {
                    return false;
                }
                b = q$x.bYd().b(activity, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(405, 37, 1, true);
                        activity.finish();
                        MMAppMgr.b(activity, true);
                    }
                });
                com.tencent.mm.plugin.report.service.g.pQN.a(405, 36, 1, true);
                b.update(1);
                return true;
            default:
                return false;
        }
    }

    private static boolean Y(Activity activity) {
        com.tencent.mm.pluginsdk.model.app.a bYz = com.tencent.mm.pluginsdk.model.app.a.bYz();
        if (bYz != null) {
            bYz.bYC();
            x.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
            return true;
        } else if (q$x.bYd() == null) {
            return false;
        } else {
            q$x.bYd().dr(activity).update(2);
            return true;
        }
    }
}
