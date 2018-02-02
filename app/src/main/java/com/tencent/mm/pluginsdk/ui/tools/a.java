package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e$h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a {
    private static Intent vvB;
    private static WeakReference<Activity> vvC;
    private static final HashMap<String, String> vvD;

    public static boolean a(Activity activity, String str, String str2, int i) {
        x.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[]{str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length())});
        if (new File(str).exists()) {
            int i2;
            String SJ = SJ(str2);
            String SI = SI(SJ);
            if (!SI.equals("")) {
                x.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[]{SI});
                Intent fg = fg(SJ, str);
                fg.setPackage(SI);
                if (bh.k(activity, fg)) {
                    x.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
                    activity.startActivity(fg);
                    return false;
                }
                x.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
                x.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
            }
            x.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", new Object[]{x(activity, SJ, str).name()});
            if (x(activity, SJ, str) == a.vvI) {
                Intent fi = fi(str, str2);
                if (bh.k(activity, fi)) {
                    fi.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    activity.startActivity(fi);
                    g.pQN.h(11168, new Object[]{Integer.valueOf(5), Integer.valueOf(i)});
                    return false;
                }
                fi.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                Intent fh = fh(SJ, str);
                if (bh.k(activity, fh)) {
                    activity.startActivity(fh);
                    g.pQN.h(11168, new Object[]{Integer.valueOf(5), Integer.valueOf(i)});
                    x.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
                } else {
                    x.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
                    return true;
                }
            }
            if (!bh.ov(str2)) {
                ar.Hg();
                SJ = (String) c.CU().get(com.tencent.mm.storage.w.a.xrA, "");
                if (!bh.ov(SJ) && SJ.contains(str2)) {
                    i2 = 1;
                    if (i2 != 0) {
                        return true;
                    }
                    b(activity, str, str2);
                    return false;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                return true;
            }
            b(activity, str, str2);
            return false;
        }
        x.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
        return true;
    }

    public static void b(Activity activity, String str, String str2, int i) {
        boolean z = true;
        x.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[]{str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length())});
        if (new File(str).exists()) {
            boolean z2;
            boolean z3;
            Parcelable fg;
            String SJ = SJ(str2);
            String SI = SI(SJ);
            if (!SI.equals("")) {
                x.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[]{SI});
                Intent fg2 = fg(SJ, str);
                fg2.setPackage(SI);
                if (bh.k(activity, fg2)) {
                    x.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
                    activity.startActivity(fg2);
                    return;
                }
                x.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
            }
            x.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", new Object[]{x(activity, SJ, str).name()});
            Object fg3;
            switch (1.vvE[x(activity, SJ, str).ordinal()]) {
                case 1:
                    z2 = false;
                    fg3 = fg(SJ, str);
                    z3 = true;
                    break;
                case 2:
                    z2 = false;
                    fg3 = fg(SJ, str);
                    z3 = false;
                    break;
                case 3:
                    z2 = true;
                    fg3 = fg(SJ, str);
                    z3 = true;
                    break;
                case 4:
                    Intent fi = fi(str, str2);
                    if (!bh.k(activity, fi)) {
                        z2 = false;
                        fg3 = fg(SJ, str);
                        z3 = true;
                        break;
                    }
                    activity.startActivity(fi);
                    return;
                default:
                    z2 = false;
                    fg = fg(SJ, str);
                    z3 = true;
                    break;
            }
            String SJ2 = SJ(str2);
            Uri fromFile = Uri.fromFile(new File(str));
            Bundle bundle = new Bundle();
            bundle.putString("targeturl", fromFile.toString());
            bundle.putString("filepath", str);
            bundle.putString("fileext", str2);
            bundle.putParcelable("targetintent", fg);
            Intent intent = new Intent();
            intent.putExtra(DownloadSettingTable$Columns.TYPE, 0);
            intent.putExtra("title", activity.getResources().getString(R.l.dTx));
            intent.putExtra("needupate", z2);
            SI = "not_show_recommend_app";
            if (z3) {
                z = false;
            }
            intent.putExtra(SI, z);
            intent.putExtra("mimetype", SJ2);
            intent.putExtra("targetintent", fg);
            intent.putExtra("transferback", bundle);
            intent.putExtra("scene", i);
            b(activity, str, str2);
            vvB = intent;
            vvC = new WeakReference(activity);
            return;
        }
        x.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
    }

    private static void b(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.setComponent(new ComponentName(e$h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
        activity.sendBroadcast(intent);
    }

    public static void ae(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
        intent.getStringExtra("file_path");
        Object stringExtra = intent.getStringExtra("file_ext");
        x.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", new Object[]{Boolean.valueOf(booleanExtra)});
        if (!ar.GZ() && ar.Hj()) {
            ar.Hg();
            Object obj = (String) c.CU().get(com.tencent.mm.storage.w.a.xrA, "");
            if (!booleanExtra) {
                obj = obj.replace(stringExtra, "");
            } else if (!obj.contains(stringExtra)) {
                obj = obj.concat(stringExtra);
            }
            ar.Hg();
            c.CU().a(com.tencent.mm.storage.w.a.xrA, obj);
            if (!(booleanExtra || vvB == null || vvC == null || vvC.get() == null)) {
                vvB.setClass((Context) vvC.get(), AppChooserUI.class);
                ((Activity) vvC.get()).startActivityForResult(vvB, 2);
            }
            vvB = null;
        }
    }

    public static void a(Activity activity, int i, int i2, Intent intent, boolean z, int i3, int i4, int i5) {
        if (i != 2) {
            return;
        }
        if (-1 == i2 && intent != null) {
            String stringExtra = intent.getStringExtra("selectpkg");
            Bundle bundleExtra = intent.getBundleExtra("transferback");
            Intent intent2 = (Intent) bundleExtra.getParcelable("targetintent");
            String string = bundleExtra.getString("filepath");
            String string2 = bundleExtra.getString("fileext");
            if (intent2 != null) {
                Intent fi;
                x.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", new Object[]{stringExtra});
                if ("com.tencent.mtt".equals(stringExtra) && string != null) {
                    fi = fi(string, string2);
                    fi.addFlags(SQLiteGlobal.journalSizeLimit);
                    fi.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
                    fi.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 4);
                    if (bh.k(activity, fi)) {
                        x.i("MicroMsg.AppChooserIntentUtil", "user has installed new version of QQbrowser");
                        activity.startActivity(fi);
                        g.pQN.h(11168, new Object[]{Integer.valueOf(5), Integer.valueOf(i5)});
                        return;
                    }
                }
                fi = new Intent(intent2);
                fi.setPackage(stringExtra);
                fi.addFlags(SQLiteGlobal.journalSizeLimit);
                if (bh.k(activity, fi)) {
                    activity.startActivity(fi);
                    return;
                }
                x.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
                if (z) {
                    h.h(activity, i3, i4);
                    return;
                }
                return;
            }
            x.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
            if (z) {
                h.h(activity, i3, i4);
            }
        } else if (4098 == i2) {
            x.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
            if (z) {
                h.h(activity, i3, i4);
            }
        } else if (4097 == i2) {
            x.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
            if (z) {
                h.h(activity, i3, i4);
            }
        } else {
            x.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
        }
    }

    private static Intent fg(String str, String str2) {
        Uri fromFile = Uri.fromFile(new File(str2));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(fromFile, str);
        return intent;
    }

    private static Intent fh(String str, String str2) {
        Intent intent = new Intent();
        intent.setPackage("com.tencent.mtt");
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str2)), str);
        return intent;
    }

    private static Intent fi(String str, String str2) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
        File file = new File(str);
        intent.setPackage("com.tencent.mtt");
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 4);
        intent.putExtra("key_reader_sdk_id", 1);
        intent.putExtra("key_reader_sdk_type", 0);
        intent.putExtra("key_reader_sdk_format", str2);
        intent.putExtra("key_reader_sdk_path", str);
        intent.setData(Uri.fromFile(file));
        return intent;
    }

    private static String SI(String str) {
        int i = 274528;
        ar.Hg();
        t CU = c.CU();
        if (str != null) {
            i = 274528 + str.hashCode();
        }
        return (String) CU.get(i, "");
    }

    private static a x(Context context, String str, String str2) {
        if (!r.ed(context)) {
            return a.vvF;
        }
        if (bh.k(context, fh(str, str2))) {
            return a.vvI;
        }
        if (r.Rx(str)) {
            return a.vvG;
        }
        return a.vvH;
    }

    private static String SJ(String str) {
        String str2 = null;
        if (str != null && str.length() > 0) {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (str2 == null || str2.length() == 0) {
            str2 = (String) vvD.get(str);
        }
        if (str2 != null && str2.length() != 0) {
            return str2;
        }
        x.w("MicroMsg.AppChooserIntentUtil", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
        return "*/" + str;
    }

    static {
        HashMap hashMap = new HashMap();
        vvD = hashMap;
        hashMap.put("wps", "application/wps");
        vvD.put("ett", "application/ett");
        vvD.put("log", "application/log");
        vvD.put("wpt", "application/wpt");
        vvD.put("et", "application/et");
        vvD.put("ksdps", "application/ksdps");
        vvD.put("kset", "application/kset");
        vvD.put("kswps", "application/kswps");
    }
}
