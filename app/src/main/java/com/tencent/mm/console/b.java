package com.tencent.mm.console;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.console.a.a;
import com.tencent.mm.console.a.c;
import com.tencent.mm.console.a.d;
import com.tencent.mm.console.a.e;
import com.tencent.mm.console.a.f;
import com.tencent.mm.console.a.g;
import com.tencent.mm.console.a.h;
import com.tencent.mm.console.a.i;
import com.tencent.mm.console.a.j;
import com.tencent.mm.console.a.k;
import com.tencent.mm.console.a.l;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.g.a.pm;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.i.a.b.m;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.q.y;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.protocal.c.asp;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.o;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ay;
import com.tencent.mm.z.az;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bd;
import com.tencent.mm.z.bh$a;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.wcdb.FileUtils;
import com.tencent.xweb.WebView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class b {
    static {
        c.init();
        h.init();
        i.init();
        f.init();
        d.init();
        e.init();
        a.init();
        com.tencent.mm.console.a.b.init();
        k.init();
        g.init();
        j.init();
        l.init();
        try {
            Class.forName("com.tencent.mm.console.a.b.a");
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.CommandProcessor", th, "", new Object[0]);
        }
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.a(), new String[]{"//fsd"});
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.b(), new String[]{"//hcsetting"});
    }

    private static int eY(String str) {
        if (!str.startsWith("//") || str.length() <= 2) {
            return 0;
        }
        int indexOf = str.indexOf(" ");
        if (indexOf == -1) {
            indexOf = str.length();
        }
        try {
            indexOf = bh.getInt(str.substring(2, indexOf), 0);
            int i = com.tencent.mm.protocal.d.vAz % 256;
            if (i == 0 || indexOf < i || indexOf % i != 0) {
                return 0;
            }
            return indexOf / i;
        } catch (Exception e) {
            return 0;
        }
    }

    private static String eZ(String str) {
        int indexOf = str.indexOf(" ");
        if (indexOf < 0) {
            return "";
        }
        return str.substring(indexOf).trim();
    }

    public static boolean u(final Context context, final String str) {
        if (!str.startsWith("//")) {
            return false;
        }
        if (com.tencent.mm.pluginsdk.cmd.b.aU(context, str)) {
            return true;
        }
        if (str.startsWith("//clearWXSNSDB")) {
            com.tencent.mm.sdk.b.a.xef.m(new pm());
            return true;
        } else if (str.startsWith("//verifytokenerror")) {
            r.iel = true;
            return true;
        } else if (str.startsWith("//resetbackupdata")) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.valueOf(false));
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.valueOf(false));
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.valueOf(false));
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.valueOf(false));
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.valueOf(false));
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.valueOf(false));
            ar.Hg().FM().chL();
            ar.Hg().FN().chL();
            ar.Hg().FL().chL();
            Toast.makeText(ac.getContext(), "backup data has been reset!", 1).show();
            return true;
        } else if (str.equalsIgnoreCase("//ftsmsbiz")) {
            asq QX = com.tencent.mm.bc.d.QX();
            r1 = new StringBuilder();
            Iterator it = QX.ksP.iterator();
            while (it.hasNext()) {
                asp com_tencent_mm_protocal_c_asp = (asp) it.next();
                r1.append(String.format("%s | %.2f | %s", new Object[]{com.tencent.mm.z.r.gu(com_tencent_mm_protocal_c_asp.vIy), Double.valueOf(com_tencent_mm_protocal_c_asp.wAg), n.ag("yyyy-MM-dd HH:mm", com_tencent_mm_protocal_c_asp.wAh / 1000)}));
                r1.append("\n");
            }
            r0 = new TextView(context);
            r0.setText(r1.toString());
            r0.setGravity(19);
            r0.setTextSize(1, 10.0f);
            r0.setLayoutParams(new LayoutParams(-1, -2));
            r0.setTextColor(-16711936);
            r0.setTypeface(Typeface.MONOSPACE);
            r1 = context.getResources().getDimensionPixelSize(R.f.bvv);
            r0.setPadding(r1, r1, r1, r1);
            com.tencent.mm.ui.base.h.a(context, null, r0, null);
            return true;
        } else if (str.startsWith("//setgamejs")) {
            r0 = str.split(" ");
            if (r0.length == 2) {
                if (r0[1] == null || r0[1].isEmpty() || r0[1].endsWith("/")) {
                    u.makeText(context, "param set error, please don't end with /", 0).show();
                } else {
                    r1 = ac.getContext().getSharedPreferences("app_brand_global_sp", 0);
                    if (r1 != null) {
                        r1 = r1.edit();
                        r1.remove("app_brand_game_js_path");
                        r1.commit();
                        if (!r0[1].equalsIgnoreCase("null")) {
                            r1.putString("app_brand_game_js_path", r0[1]);
                            r1.commit();
                        }
                    }
                }
            }
            return true;
        } else {
            if (com.tencent.mm.sdk.a.b.ceK()) {
                if (str.startsWith("//launchapp clear")) {
                    com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_LAUNCH_APP_NOT_ASK_PKG_STRING, (Object) "");
                    return true;
                } else if (str.startsWith("//setsupportwxcode")) {
                    com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.valueOf(true));
                    return true;
                } else if (str.startsWith("//setnotsupportwxcode")) {
                    com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.valueOf(false));
                    return true;
                } else if (str.startsWith("//resetsupportwxcode")) {
                    com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, null);
                    return true;
                }
            }
            Intent intent;
            if (str.startsWith("//testsightwidget")) {
                intent = new Intent();
                intent.putExtra("KSightPath", "/mnt/sdcard/tencent/tempvideo4.mp4");
                intent.putExtra("KSightThumbPath", "");
                intent.putExtra("sight_md5", com.tencent.mm.a.g.bV("/mnt/sdcard/tencent/tempvideo4.mp4"));
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", bh.Wo());
                intent.putExtra("Ksnsupload_type", 14);
                com.tencent.mm.bm.d.b(context, "sns", ".ui.SnsUploadUI", intent);
                return true;
            } else if (str.startsWith("//openremitbank")) {
                com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(1));
                return true;
            } else if (str.startsWith("//closeremitbank")) {
                com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(0));
                return true;
            } else {
                com.tencent.mm.sdk.b.b bcVar;
                if (str.startsWith("//ftstemplatetest")) {
                    bcVar = new bc();
                    bcVar.fpl.fpm = 27;
                    bcVar.fpl.fpm = 1;
                    bcVar.fpl.filePath = "/sdcard/fts_template.zip";
                    com.tencent.mm.sdk.b.a.xef.m(bcVar);
                }
                if (str.startsWith("//sightforward")) {
                    intent = new Intent();
                    intent.setClassName(context, "com.tencent.mm.ui.transmit.SightForwardUI");
                    context.startActivity(intent);
                    return true;
                } else if (str.startsWith("//remit")) {
                    com.tencent.mm.bm.d.b(context, "remittance", ".ui.RemittanceBusiUI", new Intent());
                    return true;
                } else if (str.startsWith("//uplog")) {
                    r0 = "weixin";
                    if (ar.Hj()) {
                        r0 = q.FS();
                    }
                    r2 = str.split(" ");
                    r1 = 0;
                    if (r2 != null) {
                        if (r2.length > 1) {
                            r1 = bh.getInt(r2[1], 0);
                        }
                        if (r2.length > 2) {
                            r0 = r2[2];
                        }
                    }
                    ar.CG().d(new bd(new 1(r0, r1)));
                    context.getString(R.l.dGO);
                    ar.a(new 10(com.tencent.mm.ui.base.h.a(context, context.getString(R.l.eYF), false, null), context));
                    return true;
                } else if (str.startsWith("//upcrash")) {
                    r0 = "weixin";
                    if (ar.Hj()) {
                        r0 = q.FS();
                    }
                    r2 = str.split(" ");
                    r1 = 0;
                    if (r2 != null) {
                        if (r2.length > 1) {
                            r1 = bh.getInt(r2[1], 0);
                        }
                        if (r2.length > 2) {
                            r0 = r2[2];
                        }
                    }
                    ar.CG().d(new bd(new 11(r0, r1)));
                    return true;
                } else if (str.startsWith("//switchnotificationstatus")) {
                    com.tencent.mm.k.f.bm(!com.tencent.mm.k.f.zn());
                    return true;
                } else if (str.startsWith("//fixError0831")) {
                    x.i("MicroMsg.CommandProcessor", "fixError0831");
                    com.tencent.mm.sdk.b.a.xef.m(new bi());
                    return true;
                } else if (str.startsWith("//resetbankremit")) {
                    com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0));
                    return true;
                } else if (str.startsWith("//busiluck ")) {
                    r0 = "weixin://openNativeUrl/weixinHB/startreceivebizhbrequest?sendid=" + str.replace("//busiluck ", "");
                    r1 = new Intent();
                    r1.putExtra("key_way", 5);
                    r1.putExtra("key_native_url", r0);
                    com.tencent.mm.bm.d.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", r1);
                    return true;
                } else if (str.startsWith("//testsoter")) {
                    intent = new Intent();
                    intent.setClassName(ac.getPackageName(), "com.tencent.mm.plugin.soter.ui.SoterTestUI");
                    context.startActivity(intent);
                    return true;
                } else if (str.startsWith("//facevideo")) {
                    r0 = str.split(" ");
                    if (r0.length == 3) {
                        aq.hfP.S("imgType", r0[1]);
                        aq.hfP.S("depth", r0[2]);
                    }
                    return true;
                } else if (str.startsWith("//alpha")) {
                    r0 = str.split(" ");
                    if (r0.length == 2) {
                        aq.hfP.S("alpha_duration", r0[1]);
                    }
                    return true;
                } else if (str.startsWith("//rectwidth")) {
                    r0 = str.split(" ");
                    if (r0.length == 2) {
                        aq.hfP.S("rect_width", r0[1]);
                    }
                    return true;
                } else if (str.startsWith("//newyearsw ")) {
                    ar.Hg();
                    r0 = ((Integer) com.tencent.mm.z.c.CU().get(w.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue() ^ 1;
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(w.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(r0));
                    return true;
                } else if (str.startsWith("//commitxlog")) {
                    ar.CG().a(1, "", 0, false);
                    x.cfk();
                    return true;
                } else if (str.startsWith("//open neattextview")) {
                    com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, Boolean.valueOf(true));
                    return true;
                } else if (str.startsWith("//close neattextview")) {
                    com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, Boolean.valueOf(false));
                    return true;
                } else if (str.startsWith("//unprint specialtext")) {
                    MMNeatTextView.ztU = false;
                    return true;
                } else if (str.startsWith("//print specialtext")) {
                    MMNeatTextView.ztU = true;
                    return true;
                } else if (str.startsWith("//netstatus")) {
                    r1 = an.eO(ac.getContext());
                    com.tencent.mm.ui.base.h.a(context, r1, "netstatus", context.getString(R.l.eVo), context.getString(R.l.dUa), new 12(context, r1), null);
                    return true;
                } else {
                    long j;
                    if (str.startsWith("//scaninterval ")) {
                        j = -1;
                        try {
                            j = bh.getLong(str.split(" ")[1], -1);
                        } catch (Exception e) {
                        }
                        if (j > 0) {
                            ar.Hg();
                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_WECHAT_FILE_SCAN_INTERVAL_LONG, Long.valueOf(j));
                            x.i("MicroMsg.CommandProcessor", "summerclean reset scaninterval[%d]", Long.valueOf(j));
                            return true;
                        }
                    }
                    if (str.startsWith("//scanwait ")) {
                        j = -1;
                        try {
                            j = bh.getLong(str.split(" ")[1], -1);
                        } catch (Exception e2) {
                        }
                        if (j > 0) {
                            ar.Hg();
                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_WECHAT_FILE_SCAN_WAIT_TIME_LONG, Long.valueOf(j));
                            x.i("MicroMsg.CommandProcessor", "summerclean reset scanwait[%d]", Long.valueOf(j));
                            return true;
                        }
                    }
                    if (str.equalsIgnoreCase("//delayquery")) {
                        r.ieo = !r.ieo;
                        return true;
                    } else if (str.startsWith("//newinit -hard")) {
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Dj().CU().set(15, Integer.valueOf(0));
                        return true;
                    } else if (str.startsWith("//opensearchpreload ")) {
                        r0 = str.split("\\s+");
                        if (r0.length == 2) {
                            if ("1".equals(r0[1].trim())) {
                                com.tencent.mm.plugin.aj.d.bOL().ke(true);
                            } else if ("0".equals(r0[1].trim())) {
                                com.tencent.mm.plugin.aj.d.bOL().ke(false);
                            }
                        }
                        return true;
                    } else if (str.startsWith("//closesearchhtmlpreload ")) {
                        r0 = str.split("\\s+");
                        if (r0.length == 2) {
                            if ("1".equals(r0[1].trim())) {
                                com.tencent.mm.plugin.aj.a.g.bOT();
                            } else if ("0".equals(r0[1].trim())) {
                                com.tencent.mm.plugin.aj.a.g.bOT();
                            }
                        }
                        return true;
                    } else if (str.equalsIgnoreCase("//swipe")) {
                        r0 = ac.cft();
                        r0.edit().putBoolean("settings_support_swipe", !r0.getBoolean("settings_support_swipe", true)).commit();
                        return true;
                    } else if (str.equalsIgnoreCase("//multiwebview")) {
                        r0 = LauncherUI.cmG().getSharedPreferences(ac.cfs(), 0);
                        r1 = r0.getBoolean("settings_multi_webview", false);
                        if (r1) {
                            r0.edit().putBoolean("settings_multi_webview", !r1).commit();
                        }
                        return true;
                    } else if (str.equalsIgnoreCase("//sightinfo")) {
                        ar.Hg();
                        r0 = ((Boolean) com.tencent.mm.z.c.CU().get(344065, Boolean.valueOf(false))).booleanValue();
                        ar.Hg();
                        com.tencent.mm.z.c.CU().set(344065, Boolean.valueOf(!r0));
                        ar.Hg();
                        com.tencent.mm.z.c.CU().lH(true);
                        return true;
                    } else if (str.startsWith("//sighttest")) {
                        r0 = bh.VI(str.replace("//sighttest ", ""));
                        ar.Hg();
                        com.tencent.mm.z.c.CU().set(344066, Integer.valueOf(r0));
                        ar.Hg();
                        com.tencent.mm.z.c.CU().lH(true);
                        return true;
                    } else if (str.startsWith("//wxcamera")) {
                        x.i("MicroMsg.CommandProcessor", "set param %d", Integer.valueOf(bh.VI(str.replace("//wxcamera ", ""))));
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, Integer.valueOf(r0));
                        return true;
                    } else if (str.startsWith("//printcrash")) {
                        r0 = str.replace("//printcrash ", "");
                        r1 = new TextView(context);
                        r1.setText(fT(bh.getInt(r0, 0)));
                        r1.setGravity(19);
                        r1.setTextSize(1, 8.0f);
                        r1.setLayoutParams(new LayoutParams(-1, -2));
                        r1.setTextColor(-16711936);
                        r1.setTypeface(Typeface.MONOSPACE);
                        r0 = context.getResources().getDimensionPixelSize(R.f.bvV);
                        r1.setPadding(r0, r0, r0, r0);
                        r1.setMovementMethod(ScrollingMovementMethod.getInstance());
                        com.tencent.mm.ui.base.h.a(context, null, r1, null);
                        return true;
                    } else if (str.startsWith("//printleak")) {
                        r0 = new TextView(context);
                        r0.setText(com.tencent.mm.compatible.b.f.xZ());
                        r0.setGravity(19);
                        r0.setTextSize(1, 8.0f);
                        r0.setLayoutParams(new LayoutParams(-1, -2));
                        r0.setTextColor(-16711936);
                        r0.setTypeface(Typeface.MONOSPACE);
                        r1 = context.getResources().getDimensionPixelSize(R.f.bvV);
                        r0.setPadding(r1, r1, r1, r1);
                        r0.setMovementMethod(ScrollingMovementMethod.getInstance());
                        com.tencent.mm.ui.base.h.a(context, null, r0, null);
                        return true;
                    } else if (str.startsWith("//resetmapcnt")) {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_TENCENT_MAP_COUNT_INT, Integer.valueOf(0));
                        return true;
                    } else if (str.equals("//testrsa")) {
                        com.tencent.mm.protocal.ac.F("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                        return true;
                    } else if (str.equals("//testrsabad")) {
                        com.tencent.mm.protocal.ac.F("010001", "F338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                        return true;
                    } else if (str.equals("//walletofflinetest")) {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(false));
                        return false;
                    } else if (str.startsWith("//makemsgdata ")) {
                        r0 = bh.getInt(str.split(" ")[1], 0);
                        ar.Hg();
                        com.tencent.mm.z.c.Fa().E(ChattingUI.a.ywi, (long) r0);
                        return true;
                    } else if (str.startsWith("//pullappservice")) {
                        ao.bYV().ej(ac.getContext());
                        return true;
                    } else if (str.startsWith("//boundaryconfig")) {
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig SessionTextMsg:%d", Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("InputLimitSessionTextMsg"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig SNSObjectText:%d", Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("InputLimitSNSObjectText"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig SnsCommentMaxSize:%d", Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsCommentMaxSize"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig FavText:%d", Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("InputLimitFavText"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionBufSize:%d", Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("InputLimitSendEmotionBufSize"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionWidth:%d", Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("InputLimitSendEmotionWidth"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig FavImageSize:%d", Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("InputLimitFavImageSize"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig FavVoiceLength:%d", Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("InputLimitFavVoiceLength"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig ShortVideoAutoDownloadBufSize:%d", Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("InputLimitSessionShortVideoBufSize"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig VideoSize:%d", Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("InputLimitVideoSize"), 0)));
                        x.i("MicroMsg.CommandProcessor", "boundaryconfig FileSize:%d", Integer.valueOf(bh.getInt(com.tencent.mm.k.g.zY().getValue("InputLimitFileSize"), 0)));
                        return true;
                    } else if (str.startsWith("//whatsnew")) {
                        MMAppMgr.W((Activity) context);
                        return true;
                    } else if (str.startsWith("//profile ")) {
                        ar.Hg();
                        r0 = com.tencent.mm.z.c.EY().WO(str.replace("//profile ", "").trim());
                        if (!(r0 == null || r0.AO() == 0)) {
                            r1 = new Intent();
                            r1.putExtra("Contact_User", r0.getUsername());
                            com.tencent.mm.bm.d.b(context, "profile", ".ui.ContactInfoUI", r1);
                        }
                        return true;
                    } else if (str.startsWith("//minigameupdate")) {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_MINIGAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(0));
                        return true;
                    } else if (str.startsWith("//cs")) {
                        intent = new Intent();
                        intent.putExtra("voipCSBizId", "gh_b35727b00b78");
                        intent.putExtra("voipCSAppId", "wx6e7147e8d764e85d");
                        com.tencent.mm.bm.d.b(ac.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                        return true;
                    } else if (str.startsWith("//acs")) {
                        intent = new Intent();
                        intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                        intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                        com.tencent.mm.bm.d.b(ac.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                        return true;
                    } else if (str.startsWith("//wifiset")) {
                        intent = new Intent();
                        intent.putExtra("free_wifi_ssid", "Xiaomi_WENDY");
                        intent.putExtra("free_wifi_passowrd", "WX12345789");
                        com.tencent.mm.bm.d.b(ac.getContext(), "freewifi", ".ui.FreeWifiCopyPwdUI", intent);
                        return true;
                    } else if (str.startsWith("//bcs")) {
                        intent = new Intent();
                        intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                        intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                        intent.putExtra("voipCSAllowBackCamera", "1");
                        intent.putExtra("voipCSShowOther", "1");
                        intent.putExtra("voipCSAvatarUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=28737416,3249768666&fm=58");
                        intent.putExtra("voipCSContext", "test");
                        com.tencent.mm.bm.d.b(ac.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                        return true;
                    } else if (str.startsWith("//getfpkey")) {
                        r1 = be.cjW();
                        com.tencent.mm.ui.base.h.a(context, r1, "Fingerprint Key", context.getString(R.l.eVo), context.getString(R.l.dUa), new 13(context, r1), null);
                        return true;
                    } else if (str.startsWith("//commitwd")) {
                        WatchDogPushReceiver.Th();
                        return true;
                    } else if (str.startsWith("//setsnstestenv")) {
                        String[] split = str.split(" +");
                        if (split.length > 1) {
                            r3 = split[1];
                            if (com.tencent.mm.sdk.platformtools.q.isIPv4Address(r3) || com.tencent.mm.sdk.platformtools.q.isIPv6Address(r3)) {
                                if (split.length > 2) {
                                    r2 = split[2];
                                    if (com.tencent.mm.sdk.platformtools.q.isIPv4Address(r2) || com.tencent.mm.sdk.platformtools.q.isIPv6Address(r2)) {
                                        r1 = split.length > 3 ? split[3] : null;
                                        r.idM = r3 != null;
                                        r.idD = r3;
                                        r.ief = r2;
                                        r.ieg = r1;
                                        com.tencent.mm.modelcdntran.g.MG().ML();
                                        Toast.makeText(context, String.format("%s %s %s", new Object[]{r.idD, r.ief, r.ieg}), 1).show();
                                        return true;
                                    }
                                }
                                r2 = null;
                                r1 = null;
                                if (r3 != null) {
                                }
                                r.idM = r3 != null;
                                r.idD = r3;
                                r.ief = r2;
                                r.ieg = r1;
                                com.tencent.mm.modelcdntran.g.MG().ML();
                                Toast.makeText(context, String.format("%s %s %s", new Object[]{r.idD, r.ief, r.ieg}), 1).show();
                                return true;
                            }
                        }
                        r3 = null;
                        r2 = null;
                        r1 = null;
                        if (r3 != null) {
                        }
                        r.idM = r3 != null;
                        r.idD = r3;
                        r.ief = r2;
                        r.ieg = r1;
                        com.tencent.mm.modelcdntran.g.MG().ML();
                        Toast.makeText(context, String.format("%s %s %s", new Object[]{r.idD, r.ief, r.ieg}), 1).show();
                        return true;
                    } else if (str.startsWith("//snsvcodec")) {
                        r0 = str.split(" +");
                        if (r0.length > 1) {
                            r0 = r0[1];
                            if ("on".equalsIgnoreCase(r0)) {
                                fU(1);
                                x.i("MicroMsg.CommandProcessor", "snsvcodec val: 1");
                            } else if ("off".equalsIgnoreCase(r0)) {
                                fU(0);
                                x.i("MicroMsg.CommandProcessor", "snsvcodec val: 0");
                            }
                        } else {
                            fU(-1);
                            x.i("MicroMsg.CommandProcessor", "snsvcodec val: -1");
                        }
                        return true;
                    } else if (str.startsWith("//snswxpc")) {
                        r0 = str.split(" +");
                        if (r0.length > 1) {
                            r0 = r0[1];
                            if ("on".equalsIgnoreCase(r0)) {
                                fV(1);
                                x.i("MicroMsg.CommandProcessor", "snswxpc val: 1");
                            } else if ("off".equalsIgnoreCase(r0)) {
                                fV(0);
                                x.i("MicroMsg.CommandProcessor", "snswxpc val: 0");
                            }
                        } else {
                            fV(-1);
                            x.i("MicroMsg.CommandProcessor", "snswxpc val: -1");
                        }
                        return true;
                    } else if (str.startsWith("//mmdumpsys")) {
                        ar.Dm().F(new 14());
                        return true;
                    } else if (str.startsWith("//remittance reset")) {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().set(327729, "0");
                        return true;
                    } else if (str.startsWith("//wv ")) {
                        r0 = str.replace("//wv ", "");
                        r1 = new Intent();
                        r1.putExtra("rawUrl", r0);
                        com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", r1);
                        return true;
                    } else if (str.startsWith("//wvjsapi ")) {
                        r0 = str.replace("//wvjsapi ", "");
                        r1 = new Intent();
                        r1.putExtra("rawUrl", r0);
                        com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewTestUI", r1);
                        return true;
                    } else if (str.startsWith("//setibeacontabuinopen")) {
                        if (!ar.Hj()) {
                            return false;
                        }
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(1));
                        return true;
                    } else if (str.startsWith("//setibeacontabuinclose")) {
                        if (!ar.Hj()) {
                            return false;
                        }
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(0));
                        return true;
                    } else if (str.startsWith("//setibeaconpushopen")) {
                        if (!ar.Hj()) {
                            return false;
                        }
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(true));
                        return true;
                    } else if (str.startsWith("//setibeaconpushclose")) {
                        if (!ar.Hj()) {
                            return false;
                        }
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(false));
                        return true;
                    } else if (str.startsWith("//ibeacon")) {
                        r0 = false;
                        r1 = false;
                        if (VERSION.SDK_INT >= 18) {
                            r0 = true;
                        }
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null && defaultAdapter.getState() == 12) {
                            r1 = true;
                        }
                        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                        r2 = r0 && r1 && hasSystemFeature;
                        r1 = "isNowSupportedIbeacon:" + r2 + "\n\nisSystemSupported:" + r0 + "\nisBlueStateOn:" + r1 + "\nisSupportedBLE:" + hasSystemFeature + "\nSDK:" + VERSION.SDK_INT + "\nModel:" + Build.BRAND + "-" + com.tencent.mm.compatible.d.q.yJ() + "\noperatingSystemInfo:" + com.tencent.mm.compatible.d.q.yN();
                        com.tencent.mm.ui.base.h.a(context, r1, "TestResult", context.getString(R.l.dQK), context.getString(R.l.dUa), new 15(context, r1), null);
                        return true;
                    } else if (str.startsWith("//gettbs")) {
                        r0 = com.tencent.mm.compatible.d.q.gFX.gGL;
                        r1 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                        r2 = r1.getString("tbs_download", null);
                        r3 = r1.getString("tbs_webview_disable", null);
                        boolean z = r1.getBoolean("x5_jscore_enabled", false);
                        int tbsCoreVersion = WebView.getTbsCoreVersion(context);
                        r6 = WebView.getTbsSDKVersion(context);
                        String string = r1.getString("tbs_webview_min_sdk_version", null);
                        r1 = r1.getString("tbs_webview_max_sdk_version", null);
                        Toast.makeText(context, String.format("forceSys:%b\ntbs_download:%s\ntbs_disable:%s\ntbs_disable_min_sdk_version:%s\ntbs_disable_max_sdk_version:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d\nx5JsCoreEnabled:%b", new Object[]{Boolean.valueOf(r0), r2, r3, string, r1, Integer.valueOf(tbsCoreVersion), Integer.valueOf(r6), Boolean.valueOf(z)}), 1).show();
                        return true;
                    } else if (str.startsWith("//deletetbs")) {
                        intent = new Intent();
                        intent.setComponent(new ComponentName(ac.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                        context.sendBroadcast(intent);
                        r0 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                        r0.putLong("last_check_ts", 0);
                        r0.apply();
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.valueOf(false));
                        return true;
                    } else if (str.startsWith("//tbsDisableOverScroll")) {
                        r1 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                        try {
                            r0 = str.substring(str.indexOf(":") + 1);
                        } catch (IndexOutOfBoundsException e3) {
                            r0 = "";
                        }
                        r1.putBoolean("tbs_disable_over_scroll", Boolean.parseBoolean(r0));
                        r1.apply();
                        return true;
                    } else if (str.startsWith("//enabletbs")) {
                        r1 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                        r2 = str.replace("//enabletbs ", "");
                        r1.putString("tbs_webview_disable", "1".equals(r2) ? "0" : "1");
                        if ("0".equals(r2)) {
                            r1.putString("tbs_webview_min_sdk_version", "0");
                            r1.putString("tbs_webview_max_sdk_version", "0");
                        }
                        r1.apply();
                        return true;
                    } else if (str.startsWith("//wvsha1")) {
                        r1 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                        try {
                            r0 = str.substring(str.indexOf(":") + 1);
                        } catch (IndexOutOfBoundsException e4) {
                            r0 = "";
                        }
                        r1.putBoolean("wvsha1", Boolean.parseBoolean(r0));
                        r1.apply();
                        return true;
                    } else {
                        if (str.startsWith("//channelId")) {
                            com.tencent.mm.ui.base.h.B(context, com.tencent.mm.sdk.platformtools.f.fdS, DownloadInfoColumns.CHANNELID);
                        }
                        if (str.startsWith("//traceroute")) {
                            com.tencent.mm.bm.d.y(context, "traceroute", ".ui.NetworkDiagnoseIntroUI");
                            return true;
                        }
                        if (str.startsWith("//qzone ")) {
                            new s(context).Su(str.replace("//qzone ", ""));
                        }
                        if (str.startsWith("//dumpcrash")) {
                            com.tencent.mm.sdk.platformtools.k.q(com.tencent.mm.compatible.util.e.gZK + "crash/", com.tencent.mm.compatible.util.e.gZM, false);
                            return true;
                        } else if (str.startsWith("//dumpanr")) {
                            com.tencent.mm.sdk.platformtools.k.q("/data/anr/", com.tencent.mm.compatible.util.e.gZM, false);
                            return true;
                        } else if (str.startsWith("//testanr")) {
                            try {
                                Thread.sleep(10000);
                            } catch (Throwable e5) {
                                x.printErrStackTrace("MicroMsg.CommandProcessor", e5, "", new Object[0]);
                            }
                            return true;
                        } else if (str.startsWith("//opensnsadRightbar")) {
                            r.idC = true;
                            return true;
                        } else if (str.startsWith("//setlocation ")) {
                            r0 = str.split(" ");
                            if (r0 == null || !com.tencent.mm.sdk.a.b.ceK()) {
                                return false;
                            }
                            r.icS = true;
                            if (r0.length > 0) {
                                r.lat = bh.getDouble(r0[1], 0.0d);
                            }
                            if (r0.length > 1) {
                                r.lng = bh.getDouble(r0[2], 0.0d);
                            }
                            return true;
                        } else if (str.startsWith("//switchsdcard")) {
                            String str2;
                            ArrayList cgb = aw.cgb();
                            int size = cgb.size();
                            x.i("MicroMsg.CommandProcessor", "switchsdcard sdcard size = " + size);
                            if (!(size <= 0 || cgb.get(0) == null || bh.ov(((aw.a) cgb.get(0)).xhO))) {
                                for (r0 = 0; r0 < size; r0++) {
                                    x.i("MicroMsg.CommandProcessor", "switchsdcard list i = " + r0 + " StatMountParse: " + cgb.get(r0));
                                }
                            }
                            for (r2 = 0; r2 < size; r2++) {
                                if (!((aw.a) cgb.get(r2)).xhO.equals(com.tencent.mm.compatible.util.e.bnD)) {
                                    str2 = ((aw.a) cgb.get(r2)).xhO;
                                    break;
                                }
                            }
                            str2 = null;
                            Activity activity = (Activity) context;
                            x.i("MicroMsg.CommandProcessor", "switchsdcard newSdcard: " + str2);
                            if (bh.ov(str2)) {
                                com.tencent.mm.ui.base.h.bs(context, context.getString(R.l.eQo));
                                return true;
                            }
                            com.tencent.mm.ui.base.h.a(context, context.getString(R.l.eQp), "", context.getString(R.l.dFU), context.getString(R.l.dEn), new 16(str2, context, activity), null);
                            return true;
                        } else if (str.startsWith("//getip")) {
                            ar.CG().d(new bd(new 17()));
                            return true;
                        } else if (str.startsWith("//localjsapi")) {
                            x.v("MicroMsg.CommandProcessor", "alvinluo path: %s", "file://" + com.tencent.mm.compatible.util.e.bnF + "test_jsapi.html");
                            r1 = new Intent();
                            r1.putExtra("rawUrl", r0);
                            com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", r1);
                            return true;
                        } else if (str.startsWith("//getlocalkey")) {
                            r1 = be.cjV();
                            com.tencent.mm.ui.base.h.a(context, r1, "Fingerprint Key", context.getString(R.l.eVo), context.getString(R.l.dUa), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ((ClipboardManager) context.getSystemService("clipboard")).setText(r1);
                                    Toast.makeText(context, R.l.eVp, 0).show();
                                }
                            }, null);
                            return true;
                        } else if (str.startsWith("//getdevid")) {
                            r1 = com.tencent.mm.compatible.d.q.yF();
                            com.tencent.mm.ui.base.h.a(context, r1, "devid", context.getString(R.l.dQK), context.getString(R.l.dUa), new 3(context, r1), null);
                            return true;
                        } else if (str.startsWith("//testhtml")) {
                            intent = new Intent();
                            intent.putExtra("rawUrl", "file:///android_asset/jsapi/reader_test1.html");
                            com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                            return true;
                        } else if (str.startsWith("//testlocalhtml ")) {
                            r0 = str.replace("//testlocalhtml ", "");
                            r1 = new Intent();
                            r1.putExtra("rawUrl", "file://" + r0);
                            r1.putExtra("neverGetA8Key", true);
                            com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", r1);
                            return true;
                        } else if (str.startsWith("//setkey")) {
                            if (be.XK(str.replace("//setkey", ""))) {
                                Toast.makeText(context, R.l.eUv, 0).show();
                            }
                            return true;
                        } else if (str.startsWith("//checkspell")) {
                            r1 = str.replace("//checkspell ", "");
                            if (bh.ov(r1)) {
                                return true;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            for (r0 = 0; r0 < r1.length(); r0++) {
                                stringBuilder.append("[" + r1.charAt(r0) + ":" + SpellMap.g(r1.charAt(r0)) + "]");
                            }
                            com.tencent.mm.ui.base.h.B(context, stringBuilder.toString(), "Check Spell");
                            return true;
                        } else if (str.startsWith("//gallery ")) {
                            r0 = str.replace("//gallery ", "");
                            if (bh.ov(r0)) {
                                return true;
                            }
                            context.getSharedPreferences(ac.cfs(), 0).edit().putString("gallery", r0).commit();
                            return true;
                        } else if (str.startsWith("//svgtag")) {
                            r0 = str.replace("//svgtag ", "");
                            if (r0.equals("on")) {
                                com.tencent.mm.bw.c.lu(true);
                            } else if (r0.equals("off")) {
                                com.tencent.mm.bw.c.lu(false);
                            }
                            return true;
                        } else if (str.startsWith("//svgcode")) {
                            try {
                                r0 = str.replace("//svgcode ", "");
                                if (!r0.equals("on")) {
                                    r0.equals("off");
                                }
                                Class cls = Class.forName("com.tencent.mm.BuildConfig");
                                Field declaredField = cls.getDeclaredField("SVGCode");
                                declaredField.setAccessible(true);
                                r0 = declaredField.getBoolean(cls);
                                try {
                                    Toast.makeText(ac.getContext(), "Using SVG Code : " + r0 + " " + com.tencent.mm.svg.b.b.clh(), 1).show();
                                } catch (Exception e6) {
                                }
                            } catch (Throwable e52) {
                                x.printErrStackTrace("MicroMsg.CommandProcessor", e52, "", new Object[0]);
                                r0 = false;
                            } catch (Throwable e522) {
                                x.printErrStackTrace("MicroMsg.CommandProcessor", e522, "", new Object[0]);
                                r0 = false;
                            } catch (Throwable e5222) {
                                x.printErrStackTrace("MicroMsg.CommandProcessor", e5222, "", new Object[0]);
                                r0 = false;
                            } catch (Throwable e52222) {
                                x.printErrStackTrace("MicroMsg.CommandProcessor", e52222, "", new Object[0]);
                                r0 = false;
                            }
                            return true;
                        } else if (str.startsWith("//testMbanner")) {
                            try {
                                r0 = str.replace("//testMbanner ", "").split(",");
                                if (r0.length >= 2) {
                                    az.Hs().a(new ay(Integer.valueOf(r0[0]).intValue(), Integer.valueOf(r0[1]).intValue(), null));
                                }
                            } catch (Exception e7) {
                            }
                            return true;
                        } else {
                            if (str.startsWith("//testrsa")) {
                                com.tencent.mm.protocal.ac.F("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                            }
                            if (str.startsWith("//recomT")) {
                                try {
                                    ar.Hg().FF().a(str.replace("//recomT ", ""), true, null);
                                } catch (Exception e8) {
                                }
                                return true;
                            } else if (str.startsWith("//recomF")) {
                                try {
                                    ar.Hg().FF().a(str.replace("//recomF ", ""), false, null);
                                } catch (Exception e9) {
                                }
                                return true;
                            } else if (str.startsWith("//testgetreg")) {
                                try {
                                    r0 = str.replace("//testgetreg ", "").split(",");
                                    if (r0.length > 2) {
                                        new bh$a().gY(Integer.valueOf(r0[0]).intValue()).ha(Integer.valueOf(r0[1]).intValue()).gZ(Integer.valueOf(r0[2]).intValue()).commit();
                                    }
                                } catch (Exception e10) {
                                }
                                return true;
                            } else if (str.startsWith("//resetwxpayagree")) {
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Dj().CU().a(w.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.valueOf(false));
                                return true;
                            } else if (str.startsWith("//ffmpeg")) {
                                try {
                                    r0 = str.indexOf("-r ");
                                    r1 = str.indexOf("-b ");
                                    r0 = str.substring(r0 + 3, r1);
                                    r1 = str.substring(r1 + 3);
                                    float f = bh.getFloat(r0.trim(), 0.0f);
                                    r1 = bh.getInt(r1.trim(), 0);
                                    com.tencent.mm.plugin.sight.base.b.qsX = r1;
                                    com.tencent.mm.plugin.sight.base.b.qsY = f;
                                    Toast.makeText(ac.getContext(), "set C2C video encode frame rate " + f + " bitrate " + r1, 0).show();
                                } catch (Exception e11) {
                                    Toast.makeText(ac.getContext(), "set C2C video frame rate fail, please ensure your command.", 1).show();
                                }
                                return true;
                            } else if (str.startsWith("//onlinevideo")) {
                                try {
                                    r0 = bh.getInt(str.replace("//onlinevideo ", ""), 0);
                                    ar.Hg();
                                    com.tencent.mm.z.c.CU().a(w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(r0));
                                    Toast.makeText(ac.getContext(), r0 > 0 ? "online video" : "offline video", 0).show();
                                } catch (Throwable e522222) {
                                    x.printErrStackTrace("MicroMsg.CommandProcessor", e522222, "", new Object[0]);
                                    Toast.makeText(ac.getContext(), "set online video fail, please ensure your command.", 1).show();
                                }
                                return true;
                            } else if (str.startsWith("//hevcinfo")) {
                                r0 = com.tencent.mm.plugin.s.e.aZD();
                                r1 = ChattingUI.a.ywi;
                                au auVar = new au();
                                auVar.dS(r1);
                                auVar.eR(2);
                                auVar.setType(1);
                                auVar.aq(System.currentTimeMillis());
                                auVar.setContent(r0);
                                ba.i(auVar);
                                return true;
                            } else if (str.startsWith("//presns")) {
                                com.tencent.mm.kernel.g.Dm().g(new 4(), 3000);
                                Toast.makeText(ac.getContext(), "preload sns", 0).show();
                                return true;
                            } else if (str.startsWith("//calcwxdata")) {
                                ar.Hg();
                                com.tencent.mm.z.c.CU().a(w.a.USERINFO_BACKGROUND_CALC_TIME_LONG, Long.valueOf(0));
                                Toast.makeText(ac.getContext(), "calc wx data success", 0).show();
                                return true;
                            } else if (str.startsWith("//checkspace")) {
                                try {
                                    r0 = bh.getInt(str.replace("//checkspace ", ""), 0);
                                    r1 = new bb();
                                    r1.fpj.fpk = r0;
                                    com.tencent.mm.sdk.b.a.xef.m(r1);
                                    Toast.makeText(ac.getContext(), "check space code " + r0, 0).show();
                                } catch (Throwable e5222222) {
                                    x.printErrStackTrace("MicroMsg.CommandProcessor", e5222222, "", new Object[0]);
                                    Toast.makeText(ac.getContext(), "check space code fail, please ensure your command.", 1).show();
                                }
                                return true;
                            } else if (str.startsWith("//upfacemodel")) {
                                ar.CG().d(new m(42));
                                return true;
                            } else if (str.startsWith("//facett")) {
                                ar.Hg();
                                com.tencent.mm.z.c.CU().a(w.a.USERINFO_FACE_SHOW_TUTORIAL_BOOLEAN_SYNC, Boolean.valueOf(false));
                                return true;
                            } else if (str.startsWith("//switchpaytype")) {
                                r0 = str.split(" ");
                                if (r0 == null || r0.length < 2) {
                                    return false;
                                }
                                try {
                                    r0 = bh.getInt(r0[1], 0);
                                    ar.Hg();
                                    com.tencent.mm.z.c.CU().set(339975, Integer.valueOf(r0));
                                    return true;
                                } catch (Exception e12) {
                                    x.e("MicroMsg.CommandProcessor", "hy: switch wallet type error");
                                    return false;
                                }
                            } else if (str.startsWith("//setNfcOpenUrl ")) {
                                r0 = str.replace("//setNfcOpenUrl ", "");
                                r1 = ac.cfu().edit();
                                if (r0.equalsIgnoreCase("null")) {
                                    r0 = "";
                                }
                                r1.putString("nfc_open_url", r0);
                                r1.commit();
                                return true;
                            } else if (str.startsWith("//setMBV8Debug ")) {
                                r0 = str.replace("//setMBV8Debug ", "");
                                r1 = ac.cfu().edit();
                                if (r0.equalsIgnoreCase("true")) {
                                    r1.putBoolean("appbrandgame_open_v8debug", true);
                                } else {
                                    r1.putBoolean("appbrandgame_open_v8debug", false);
                                }
                                r1.commit();
                                return true;
                            } else if (str.startsWith("//setAppBrandActionBar ")) {
                                r0 = str.replace("//setAppBrandActionBar ", "");
                                r1 = ac.cfu().edit();
                                if (r0.equalsIgnoreCase("new")) {
                                    r1.putBoolean("appbrand_new_actionbar", true);
                                } else {
                                    r1.putBoolean("appbrand_new_actionbar", false);
                                }
                                r1.commit();
                                return true;
                            } else if (str.startsWith("//snskvtest ")) {
                                r0 = str.replace("//snskvtest", "").trim();
                                if (r0.equals("0")) {
                                    r.idY = false;
                                } else if (r0.equals("1")) {
                                    r.idY = true;
                                }
                                return true;
                            } else if (str.startsWith("//emoji ")) {
                                ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yl(str.replace("//emoji ", ""));
                                return true;
                            } else if (str.startsWith("//share ")) {
                                r0 = Integer.valueOf(str.replace("//share ", "")).intValue();
                                ar.Hg();
                                com.tencent.mm.z.c.CU().set(229635, Integer.valueOf(r0));
                                return true;
                            } else if (str.startsWith("//dumpappinfoblob ")) {
                                com.tencent.mm.pluginsdk.model.app.f RF = com.tencent.mm.pluginsdk.model.app.an.bin().RF(str.replace("//dumpappinfoblob ", ""));
                                com.tencent.mm.ui.base.h.B(context, RF.vK() + "\n" + RF.vL() + "\n" + RF.vM(), "");
                                return true;
                            } else if (str.startsWith("//googleauth ")) {
                                r0 = str.replace("//googleauth ", "");
                                if (!TextUtils.isEmpty(r0)) {
                                    if ("webview".equals(r0)) {
                                        context.getSharedPreferences(ac.cfs(), 0).edit().putBoolean("googleauth", true).commit();
                                    } else if ("local".equals(r0)) {
                                        context.getSharedPreferences(ac.cfs(), 0).edit().putBoolean("googleauth", false).commit();
                                    }
                                }
                                return true;
                            } else if (str.startsWith("//clrgamecache")) {
                                com.tencent.mm.pluginsdk.q.j bXZ = com.tencent.mm.pluginsdk.q.a.bXZ();
                                if (bXZ != null) {
                                    bXZ.cQ(context);
                                }
                                return true;
                            } else if (str.startsWith("//clearwepkg")) {
                                bcVar = new tv();
                                bcVar.fMD.fpr = 6;
                                r1 = str.replace("//clearwepkg ", "").trim();
                                if (!(bh.ov(r1) || r1.equals("//clearwepkg"))) {
                                    bcVar.fMD.fME = r1;
                                }
                                com.tencent.mm.sdk.b.a.xef.m(bcVar);
                                return true;
                            } else if (str.startsWith("//googlemap")) {
                                r.idB = true;
                                return true;
                            } else if (str.startsWith("//sosomap")) {
                                r.idB = false;
                                return true;
                            } else if (str.startsWith("//opentrace")) {
                                com.tencent.mm.ui.applet.d dVar = new com.tencent.mm.ui.applet.d();
                                com.tencent.mm.ui.applet.d.fC(ac.getContext());
                                return true;
                            } else if (str.startsWith("//updateConversation")) {
                                x.i("MicroMsg.CommandProcessor", "update all conversation start");
                                ar.Hg();
                                for (String str3 : com.tencent.mm.z.c.Fd().ciF()) {
                                    ar.Hg();
                                    au dk = com.tencent.mm.z.c.Fa().dk(str3, " and not ( type = 10000 and isSend != 2 ) ");
                                    ar.Hg();
                                    com.tencent.mm.z.c.Fd().ad(dk);
                                }
                                x.i("MicroMsg.CommandProcessor", "update all conversation end");
                                return true;
                            } else if (str.startsWith("//setshakecarddata")) {
                                com.tencent.mm.pluginsdk.q.a.bXY().bry();
                                return true;
                            } else if (str.startsWith("//clearshakecarddata")) {
                                com.tencent.mm.pluginsdk.q.a.bXY().brz();
                                return true;
                            } else if (str.startsWith("//pageSize")) {
                                Context context2 = ac.getContext();
                                r1 = new StringBuilder("pageSize is ");
                                ar.Hg();
                                Toast.makeText(context2, r1.append(com.tencent.mm.z.c.EV().getPageSize()).toString(), 1).show();
                                return true;
                            } else if (str.startsWith("//resetDBStatus")) {
                                ar.Hg();
                                File file = new File(com.tencent.mm.z.c.CS());
                                try {
                                    r1 = new StringBuilder();
                                    ar.Hg();
                                    com.tencent.mm.ui.tools.e.g(new File(r1.append(com.tencent.mm.z.c.FB()).append(file.getName().replace(".db", ".db.backup")).toString()), file);
                                    x.i("MicroMsg.CommandProcessor", "backupPath db path is %s", r1);
                                    com.tencent.mm.a.e.b(file, new File(file.getAbsolutePath() + "err" + System.currentTimeMillis()));
                                    Toast.makeText(ac.getContext(), "db状态已重置,请重启微信", 1).show();
                                } catch (Exception e13) {
                                    x.w("MicroMsg.CommandProcessor", "delete failed: " + e13.getMessage());
                                }
                                return true;
                            } else if (str.startsWith("//makesnsdata ")) {
                                y.bYe().em((long) bh.getInt(str.replace("//makesnsdata ", ""), 0));
                                return true;
                            } else if (str.startsWith("//setsnsupload ")) {
                                r.idL = bh.getInt(str.replace("//setsnsupload ", ""), 0);
                                return true;
                            } else if (str.startsWith("//logsnstable")) {
                                com.tencent.mm.sdk.b.a.xef.m(new cj());
                                return true;
                            } else if (str.startsWith("//fpsreset ")) {
                                bcVar = new fo();
                                if (str.equalsIgnoreCase("//fpsreset on")) {
                                    bcVar.fuU.fpr = 1;
                                } else {
                                    bcVar.fuU.fpr = 0;
                                }
                                com.tencent.mm.sdk.b.a.xef.m(bcVar);
                                return true;
                            } else if (str.startsWith("//resetsnstip")) {
                                ar.Hg();
                                com.tencent.mm.z.c.CU().set(327776, Integer.valueOf(0));
                                return true;
                            } else if (str.startsWith("//checkcount")) {
                                ar.Hg();
                                r0 = com.tencent.mm.z.c.Fa().EO(ChattingUI.a.ywi);
                                ar.Hg();
                                Toast.makeText(context, "current count :" + r0 + " countAuto :" + com.tencent.mm.z.c.Fa().EM(ChattingUI.a.ywi), 1).show();
                                return true;
                            } else if (str.startsWith("//changeframe ")) {
                                ac.getContext().getSharedPreferences("preferences_animation", 0).edit().putFloat("frameInterval", Float.valueOf(str.replace("//changeframe ", "")).floatValue()).commit();
                                return true;
                            } else if (str.startsWith("//opendumpview")) {
                                com.tencent.mm.ui.applet.c cVar = new com.tencent.mm.ui.applet.c();
                                com.tencent.mm.ui.applet.c.fB(ac.getContext());
                                return true;
                            } else if (str.startsWith("//dumpmemory")) {
                                System.gc();
                                System.gc();
                                com.tencent.mm.ca.b.clo();
                                return true;
                            } else if (str.startsWith("//dumpsnsfile")) {
                                com.tencent.mm.sdk.b.a.xef.m(new pp());
                                return true;
                            } else if (str.startsWith("//coverage")) {
                                com.tencent.mm.plugin.report.b.f.Ix(str.trim().substring(10));
                                return true;
                            } else if (str.startsWith("//dumpthreadpool")) {
                                com.tencent.mm.sdk.f.e.cgU();
                                return true;
                            } else if (str.startsWith("//testverifypsw ")) {
                                str3 = str.replace("//testverifypsw ", "").trim();
                                if (str3.equals("0")) {
                                    r.iea = false;
                                } else if (str3.equals("1")) {
                                    r.iea = true;
                                }
                                x.d("MicroMsg.CommandProcessor", "summerdktext testverifypsw msg[%s], testVerifyPsw[%b]", str, Boolean.valueOf(r.iea));
                                return true;
                            } else if (str.startsWith("//pickpoi")) {
                                intent = new Intent();
                                intent.putExtra("map_view_type", 8);
                                com.tencent.mm.bm.d.b(context, "location", ".ui.RedirectUI", intent);
                                return true;
                            } else if (str.startsWith("//configlist")) {
                                if (str.matches("^//configlist set ([\\S]*)=([\\S]*)$")) {
                                    List aA = t.aA(str, "^//configlist set ([\\S]*)=([\\S]*)$");
                                    if (aA != null && aA.size() == 2) {
                                        com.tencent.mm.k.g.zY().put((String) aA.get(0), (String) aA.get(1));
                                        com.tencent.mm.sdk.b.a.xef.m(new ck());
                                    }
                                } else if (str.matches("^//configlist get ([\\S]*)$")) {
                                    List aA2 = t.aA(str, "^//configlist get ([\\S]*)$");
                                    if (aA2 != null && aA2.size() == 1) {
                                        str3 = (String) aA2.get(0);
                                        Toast.makeText(context, str3 + "=" + com.tencent.mm.k.g.zY().getValue(str3), 0).show();
                                    }
                                } else {
                                    ar.Hg();
                                    str3 = (String) com.tencent.mm.z.c.CU().get(278530, (Object) "");
                                    ar.Hg();
                                    r1 = (String) com.tencent.mm.z.c.CU().get(278529, (Object) "");
                                    r2 = com.tencent.mm.compatible.util.e.bnF + "dynacfg.xml";
                                    bh.q(r2, (str3 + r1).getBytes());
                                    Toast.makeText(context, "output dynacfg xml to " + r2, 0).show();
                                }
                                return true;
                            } else if (str.startsWith("//security")) {
                                try {
                                    ar.Hg().FG().a(str.replace("//security ", ""), true, null);
                                } catch (Exception e14) {
                                }
                                return true;
                            } else if (str.startsWith("//updatepackage")) {
                                try {
                                    ar.CG().d(new com.tencent.mm.az.k(bh.getInt(str.replace("//updatepackage ", "").trim(), 0)));
                                } catch (Exception e15) {
                                }
                                return true;
                            } else if (str.startsWith("//copypackage")) {
                                x.i("MicroMsg.CommandProcessor", "summercmd copypackage msg:%s", str);
                                r0 = aw.cgb();
                                r6 = r0.size();
                                x.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d", Integer.valueOf(r6));
                                if (r6 < 2) {
                                    com.tencent.mm.ui.base.h.bs(context, context.getString(R.l.dXE));
                                } else {
                                    com.tencent.mm.ui.base.h.a(context, context.getString(R.l.dXG), "", context.getString(R.l.dFU), context.getString(R.l.dEn), new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            com.tencent.mm.sdk.f.e.post(new 1(this), "copypackage");
                                        }
                                    }, null);
                                }
                                return true;
                            } else if (str.startsWith("//copy -n ")) {
                                x.i("MicroMsg.CommandProcessor", "summercmd copy -n msg:%s ", str);
                                r0 = aw.cgb();
                                r6 = r0.size();
                                x.i("MicroMsg.CommandProcessor", "summercmd copy -n size:%d", Integer.valueOf(r6));
                                if (r6 < 2) {
                                    com.tencent.mm.ui.base.h.bs(context, context.getString(R.l.dXE));
                                } else {
                                    com.tencent.mm.ui.base.h.a(context, context.getString(R.l.dXG), "", context.getString(R.l.dFU), context.getString(R.l.dEn), new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass6 gIu;

                                                {
                                                    this.gIu = r1;
                                                }

                                                public final void run() {
                                                    try {
                                                        String substring = str.substring(10);
                                                        String str = com.tencent.mm.compatible.util.e.bnD;
                                                        ar.Hg();
                                                        String str2 = com.tencent.mm.z.c.FC() + substring;
                                                        x.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", substring, str, r1, str2, str2.substring(str.length()));
                                                        for (int i = 0; i < r6; i++) {
                                                            Object obj = ((aw.a) r0.get(i)).xhO;
                                                            if (!(bh.ov(obj) || str.contains(obj))) {
                                                                File file = new File(obj + r5);
                                                                if (file.exists() && file.isDirectory()) {
                                                                    File file2 = new File(str2);
                                                                    if (!file2.exists()) {
                                                                        file2.mkdir();
                                                                    }
                                                                    x.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", file2.getAbsolutePath(), file.getAbsolutePath(), Boolean.valueOf(com.tencent.mm.sdk.platformtools.k.q(file.getAbsolutePath(), file2.getAbsolutePath(), false)));
                                                                    if (com.tencent.mm.sdk.platformtools.k.q(file.getAbsolutePath(), file2.getAbsolutePath(), false)) {
                                                                        new af(Looper.getMainLooper()).post(new 1(this));
                                                                        return;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        new af(Looper.getMainLooper()).post(new 2(this));
                                                    } catch (Exception e) {
                                                        x.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", e.getMessage());
                                                    }
                                                }
                                            }, "copy -n");
                                        }
                                    }, null);
                                }
                                return true;
                            } else if (str.startsWith("//deletepackage")) {
                                try {
                                    str3 = str.replace("//deletepackage ", "");
                                    r1 = new cc();
                                    r1.fqn.fqo = bh.getInt(str3, 0);
                                    com.tencent.mm.sdk.b.a.xef.m(r1);
                                } catch (Exception e16) {
                                }
                                return true;
                            } else if (str.startsWith("//audiowritetofile")) {
                                com.tencent.mm.compatible.d.q.gFV.gDl = true;
                                return true;
                            } else if (str.startsWith("//bankcard")) {
                                intent = new Intent();
                                intent.putExtra("BaseScanUI_select_scan_mode", 7);
                                intent.putExtra("bank_card_owner", "test");
                                if (!(com.tencent.mm.modelvideo.y.aV(context) || com.tencent.mm.au.a.aU(context))) {
                                    com.tencent.mm.bm.d.b((Activity) context, "scanner", ".ui.BaseScanUI", intent);
                                }
                                return true;
                            } else {
                                if (str.startsWith("//banner")) {
                                    Map y = com.tencent.mm.sdk.platformtools.bi.y("<sysmsg type=\"banner\"><mainframebanner type=\"11\"><showtype>1</showtype></mainframebanner></sysmsg>", "sysmsg");
                                    str3 = (String) y.get(".sysmsg.mainframebanner.$type");
                                    r1 = (String) y.get(".sysmsg.mainframebanner.showtype");
                                    r2 = (String) y.get(".sysmsg.mainframebanner.data");
                                    x.d("MicroMsg.CommandProcessor", "type:%s showType:%s data:%s", str3, r1, r2);
                                }
                                if (str.startsWith("//gamemsg")) {
                                    bcVar = new mb();
                                    bcVar.fDH.content = str;
                                    com.tencent.mm.sdk.b.a.xef.m(bcVar);
                                    return true;
                                } else if (str.startsWith("//shortcut#")) {
                                    bcVar = new tt();
                                    bcVar.fMm.fMn = str;
                                    com.tencent.mm.sdk.b.a.xef.m(bcVar);
                                    return true;
                                } else if (str.startsWith("//gallerytype")) {
                                    o.ysd = !o.ysd;
                                    return true;
                                } else {
                                    context.getString(R.l.eWd);
                                    if (str.startsWith("//fullexit")) {
                                        ae.Vd("show_whatsnew");
                                        com.tencent.mm.kernel.k.e(context, true);
                                        MMAppMgr.ar(context);
                                        ar.hold();
                                        com.tencent.mm.kernel.g.Dk().fM("");
                                        MMAppMgr.adg();
                                        return true;
                                    } else if (str.startsWith("//cleardldb")) {
                                        ar.Hg();
                                        com.tencent.mm.z.c.Fe().aAj();
                                        return true;
                                    } else if (str.startsWith("//setcardlayouttestdata")) {
                                        r0 = str.replace("//setcardlayouttestdata ", "");
                                        ar.Hg();
                                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_CARDLAYOUT_TESTDATA_STRING, r0);
                                        return true;
                                    } else if (str.startsWith("//delchatroomsysmsg")) {
                                        str3 = str.replace("//delchatroomsysmsg ", "");
                                        r1 = str3.indexOf(" ");
                                        r2 = str3.substring(0, r1);
                                        str3 = str3.substring(r1);
                                        if (bh.ov(r2)) {
                                            return false;
                                        }
                                        if (!str3.startsWith("<")) {
                                            return false;
                                        }
                                        au auVar2 = new au();
                                        auVar2.aq(System.currentTimeMillis());
                                        auVar2.setType(10002);
                                        auVar2.setContent(str3);
                                        auVar2.eR(0);
                                        auVar2.dS(r2);
                                        ba.i(auVar2);
                                        return true;
                                    } else {
                                        if (str.startsWith("//resetcrseq")) {
                                            r0 = str.split(" ");
                                            try {
                                                long j2 = bh.getLong(r0[1], -1);
                                                long j3 = bh.getLong(r0[2], -1);
                                                long j4 = bh.getLong(r0[3], -1);
                                                r0 = bh.getInt(r0[4], -1);
                                                if (j2 > 0) {
                                                    r1 = j2 + "@chatroom";
                                                    ar.Hg();
                                                    com.tencent.mm.storage.ae WY = com.tencent.mm.z.c.Fd().WY(r1);
                                                    if (WY != null) {
                                                        x.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] before [%d, %d, %d] [%d, %d, %d]", WY.getUsername(), Long.valueOf(WY.vY()), Long.valueOf(WY.vW()), Integer.valueOf(WY.vX()), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(r0));
                                                        if (j3 > -1) {
                                                            WY.am(j3);
                                                        }
                                                        if (j4 > -1) {
                                                            WY.al(j4);
                                                        }
                                                        if (r0 >= 0) {
                                                            WY.eW(r0);
                                                        }
                                                        ar.Hg();
                                                        r0 = com.tencent.mm.z.c.Fd().a(WY, WY.getUsername(), false);
                                                        x.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] done [%d, %d, %d] ret:%d", WY.getUsername(), Long.valueOf(WY.vY()), Long.valueOf(WY.vW()), Integer.valueOf(WY.vX()), Integer.valueOf(r0));
                                                        return true;
                                                    }
                                                }
                                            } catch (Throwable e52222222) {
                                                x.printErrStackTrace("MicroMsg.CommandProcessor", e52222222, "summerbadcr resetcrseq", new Object[0]);
                                            }
                                        }
                                        if (str.startsWith("//printchatroominfo")) {
                                            str3 = ChattingUI.a.ywi;
                                            if (!com.tencent.mm.z.s.eV(str3)) {
                                                return false;
                                            }
                                            ar.Hg();
                                            com.tencent.mm.storage.q hD = com.tencent.mm.z.c.Fh().hD(str3);
                                            if (hD == null) {
                                                x.e("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], member is null", str3);
                                                return false;
                                            }
                                            ar.Dm().F(new 7(hD, str3, str));
                                            return true;
                                        } else if (str.equals("//testupdate")) {
                                            str3 = "";
                                            try {
                                                str3 = bh.convertStreamToString(context.getAssets().open("aplha_update_info.xml"));
                                            } catch (Throwable e17) {
                                                x.printErrStackTrace("MicroMsg.CommandProcessor", e17, "", new Object[0]);
                                            }
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().set(352273, str3);
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().set(352274, Long.valueOf(System.currentTimeMillis()));
                                            new com.tencent.mm.pluginsdk.model.app.a(str3).bYC();
                                            return true;
                                        } else if (str.equals("//checkUpdate0") || str.equals("//checkUpdate1")) {
                                            com.tencent.mm.pluginsdk.q.x.bYd().hF(str.equals("//checkUpdate1"));
                                            com.tencent.mm.pluginsdk.q.x.vcC = true;
                                            return true;
                                        } else if (str.equals("//debugsnstimelinestat")) {
                                            r.idT = !r.idT;
                                            Toast.makeText(ac.getContext(), "debugSnsTimelineStat: " + r.idT, 0).show();
                                            return true;
                                        } else if (str.startsWith("//abtestmsg") && com.tencent.mm.sdk.a.b.ceK()) {
                                            com.tencent.mm.z.c.a.a im = com.tencent.mm.z.c.a.im(str.replace("//abtestmsg", ""));
                                            com.tencent.mm.z.c.c.IF().i(im.hiv, 0);
                                            com.tencent.mm.z.c.c.IG().i(im.hiw, 1);
                                            return true;
                                        } else if (str.startsWith("//triggergetabtest")) {
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(1));
                                            return true;
                                        } else if (str.startsWith("//vad")) {
                                            r0 = ac.cft();
                                            if (r0 == null) {
                                                return false;
                                            }
                                            if (str.startsWith("//vad get")) {
                                                com.tencent.mm.ui.base.h.B(context, com.tencent.mm.bg.a.c.Va(), "VAD PARAMS").show();
                                                return true;
                                            }
                                            r0 = r0.edit();
                                            if (str.startsWith("//vad sd")) {
                                                r0.putInt("s_delay_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            if (str.startsWith("//vad st")) {
                                                r0.putInt("sil_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            if (str.startsWith("//vad snr")) {
                                                r0.putFloat("s_n_ration", Float.valueOf(str.substring(10).trim()).floatValue());
                                            }
                                            if (str.startsWith("//vad sw")) {
                                                r0.putInt("s_window", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            if (str.startsWith("//vad sl")) {
                                                r0.putInt("s_length", Integer.valueOf(str.substring(9).trim()).intValue());
                                            }
                                            r0.apply();
                                            return true;
                                        } else if (str.startsWith("//dumpabtestrecords")) {
                                            if (2 < x.getLogLevel()) {
                                                return false;
                                            }
                                            if (str.contains("info")) {
                                                r0 = com.tencent.mm.z.c.c.IG().chH();
                                            } else {
                                                r0 = com.tencent.mm.z.c.c.IF().chH();
                                            }
                                            r1 = new TextView(context);
                                            r1.setText(r0);
                                            r1.setGravity(8388627);
                                            r1.setTextSize(1, 10.0f);
                                            r1.setLayoutParams(new LayoutParams(-1, -2));
                                            r1.setTextColor(-16744704);
                                            r1.setTypeface(Typeface.MONOSPACE);
                                            r1.setMovementMethod(new ScrollingMovementMethod());
                                            r0 = context.getResources().getDimensionPixelSize(R.f.bvv);
                                            r1.setPadding(r0, r0, r0, r0);
                                            com.tencent.mm.ui.base.h.a(context, null, r1, null);
                                            return true;
                                        } else if (str.startsWith("//triggerWebViewCookiesCleanup")) {
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(0));
                                            return true;
                                        } else if (str.startsWith("//cleanwebcache")) {
                                            com.tencent.mm.sdk.b.a.xef.m(new bk());
                                            return true;
                                        } else if (str.startsWith("//triggerWebViewCacheCleanup")) {
                                            intent = new Intent();
                                            intent.setComponent(new ComponentName(com.tencent.mm.ui.e.h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                                            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                                            context.sendBroadcast(intent);
                                            return true;
                                        } else if (str.startsWith("//dumpsnsabtest")) {
                                            com.tencent.mm.sdk.b.a.xef.m(new ch());
                                            return true;
                                        } else if (str.startsWith("//dumpsilkvoicefile")) {
                                            r.idX = true;
                                            return true;
                                        } else if (str.startsWith("//fucktit")) {
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.valueOf(true));
                                            return true;
                                        } else if (str.startsWith("//clog ")) {
                                            com.tencent.mm.plugin.report.service.g.pQN.dR(str.substring(7), "test cLog " + System.currentTimeMillis());
                                            return true;
                                        } else if (str.startsWith("//testformsg") && com.tencent.mm.sdk.a.b.ceK()) {
                                            str3 = str.substring(12).trim();
                                            x.i("MicroMsg.CommandProcessor", "MMCore.getSysCmdMsgExtension() " + ar.getSysCmdMsgExtension());
                                            bw bwVar = new bw();
                                            bwVar.vGZ = com.tencent.mm.platformtools.n.os(str3);
                                            bwVar.ngq = 10002;
                                            ar.getSysCmdMsgExtension().b(new com.tencent.mm.ae.d.a(bwVar, false, false, false));
                                            return true;
                                        } else if (str.startsWith("//canwebviewcachedownload")) {
                                            r0 = bh.getInt(bh.ou(str.substring(25)).trim(), 1) > 0;
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_SET_CAN_WEBVIEW_CACHE_DOWNLOAD_BOOLEAN, Boolean.valueOf(r0));
                                            return true;
                                        } else if (str.startsWith("//canwebviewcacheprepushdownload")) {
                                            r0 = bh.getInt(bh.ou(str.substring(32)).trim(), 1) > 0;
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_SET_CAN_WEBVIEW_CACHE_PRE_PUSH_DOWNLOAD_BOOLEAN, Boolean.valueOf(r0));
                                            return true;
                                        } else if (str.startsWith("//resetsnslukcy")) {
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCTRLHASSHOW_BOOLEAN_SYNC, Boolean.valueOf(false));
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(0));
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(0));
                                            com.tencent.mm.sdk.b.a.xef.m(new qf());
                                            return true;
                                        } else if (str.startsWith("//mmimgdec ")) {
                                            str3 = str.substring(11);
                                            if ("on".equalsIgnoreCase(str3)) {
                                                MMBitmapFactory.setUseMMBitmapFactory(true);
                                                Toast.makeText(context, "内置图片(png)解析库开启", 0).show();
                                            } else if ("off".equalsIgnoreCase(str3)) {
                                                MMBitmapFactory.setUseMMBitmapFactory(false);
                                                Toast.makeText(context, "内置图片(png)解析库关闭", 0).show();
                                            }
                                            return true;
                                        } else if (str.startsWith("//enablempsp")) {
                                            am.a.lB(false);
                                            Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                            return true;
                                        } else if (str.startsWith("//disablempsp")) {
                                            am.a.lB(true);
                                            Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                            return true;
                                        } else if (str.startsWith("//soterpay")) {
                                            com.tencent.mm.bm.d.y(context, "fingerprint", ".ui.SoterPayTestUI");
                                            return true;
                                        } else if (str.startsWith(context.getString(R.l.eVb))) {
                                            r.iee = !r.iee;
                                            Toast.makeText(ac.getContext(), String.format("showVoipDebugLog:%b", new Object[]{Boolean.valueOf(r.iee)}), 0).show();
                                            return true;
                                        } else if (str.startsWith("//getdltaskinfo")) {
                                            str3 = str.replace("//getdltaskinfo ", "");
                                            try {
                                                if (com.tencent.mm.plugin.downloader.model.e.ce(bh.getLong(str3, 0)) != null) {
                                                    x.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.plugin.downloader.model.e.ce(bh.getLong(str3, 0)).field_downloadId), com.tencent.mm.plugin.downloader.model.e.ce(bh.getLong(str3, 0)).field_downloadUrl, com.tencent.mm.plugin.downloader.model.e.ce(bh.getLong(str3, 0)).field_filePath, com.tencent.mm.plugin.downloader.model.e.ce(bh.getLong(str3, 0)).field_md5);
                                                } else {
                                                    x.i("getdltaskinfo", "infoID null");
                                                }
                                            } catch (Exception e18) {
                                                if (com.tencent.mm.plugin.downloader.model.e.xH(str3) != null) {
                                                    x.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.plugin.downloader.model.e.xH(str3).field_downloadId), com.tencent.mm.plugin.downloader.model.e.xH(str3).field_downloadUrl, com.tencent.mm.plugin.downloader.model.e.xH(str3).field_filePath, com.tencent.mm.plugin.downloader.model.e.xH(str3).field_md5);
                                                } else {
                                                    x.i("getdltaskinfo", "infoURL null");
                                                }
                                            }
                                            return true;
                                        } else if (str.startsWith("//testscan ")) {
                                            r0 = str.split(" ");
                                            r.ied = bh.getFloat(r0[1], 0.0f);
                                            r.iec = bh.getFloat(r0[2], 0.0f);
                                            Toast.makeText(ac.getContext(), "mode auto:" + r.ied + ",mode continuous:" + r.iec, 1).show();
                                            return true;
                                        } else if (str.startsWith("//switchrecordmode")) {
                                            r1 = ac.cft();
                                            r2 = r1.getBoolean("settings_voicerecorder_mode", false);
                                            r1.edit().putBoolean("settings_voicerecorder_mode", !r2).commit();
                                            if (r2) {
                                                Toast.makeText(ac.getContext(), "Turn off silk record", 1).show();
                                            } else {
                                                Toast.makeText(ac.getContext(), "Turn on silk record", 1).show();
                                            }
                                            return true;
                                        } else if (str.startsWith("//indoorsensorconfig ")) {
                                            com.tencent.mm.modelstat.e.SS().mL(str.replace("//indoorsensorconfig ", ""));
                                            return true;
                                        } else if (str.startsWith("//testindoorsensor ")) {
                                            String[] split2 = str.replace("//testindoorsensor ", "").split(",");
                                            com.tencent.mm.modelstat.e.SS().a(12345, false, split2[0].equals("1"), bh.getFloat(split2[1], 0.0f), bh.getFloat(split2[2], 0.0f), 12);
                                            return true;
                                        } else if (str.startsWith("//facedebug")) {
                                            return true;
                                        } else {
                                            if (str.startsWith("//rstfacett")) {
                                                return true;
                                            }
                                            if (str.startsWith("//switchjsc")) {
                                                str3 = str.replace("//switchjsc ", "");
                                                r1 = ac.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                                                if ("clear".equals(str3)) {
                                                    r1.edit().remove("switch_x5_jscore").apply();
                                                } else if ("true".equals(str3)) {
                                                    r1.edit().putBoolean("switch_x5_jscore", true).apply();
                                                } else if ("false".equals(str3)) {
                                                    r1.edit().putBoolean("switch_x5_jscore", false).apply();
                                                }
                                                return true;
                                            } else if (str.startsWith("//rfcdn")) {
                                                try {
                                                    com.tencent.mm.modelcdntran.g.MK().keep_OnRequestDoGetCdnDnsInfo(888);
                                                } catch (Throwable e522222222) {
                                                    x.e("MicroMsg.CommandProcessor", "rfcdn :%s", bh.i(e522222222));
                                                }
                                                return true;
                                            } else {
                                                if (str.startsWith("//testcrscroll ")) {
                                                    r0 = str.split(" ");
                                                    if (r0 != null && r0.length > 1) {
                                                        com.tencent.mm.ui.chatting.b.w.yBh = bh.getInt(r0[1], 0);
                                                        x.i("MicroMsg.CommandProcessor", "summerbadcr testscroll new BADCR_SCROLL_DELAY[%d]", Integer.valueOf(com.tencent.mm.ui.chatting.b.w.yBh));
                                                        return true;
                                                    }
                                                }
                                                if (str.startsWith("//switchx5jscore")) {
                                                    r0 = ac.cft();
                                                    r0.edit().putBoolean("switch_x5_jscore", !r0.getBoolean("switch_x5_jscore", true)).apply();
                                                    return true;
                                                } else if (str.startsWith("//removeaudioplayer")) {
                                                    r0 = str.split(" ");
                                                    if (r0.length >= 2) {
                                                        r0 = bh.getInt(r0[1], 3);
                                                        if (r0 >= 2 && r0 <= 9) {
                                                            ar.Hg();
                                                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_MUSIC_RREMOVE_PLAYING_AUDIO_PLAYER_GROUP_COUNT_INT_SYNC, Integer.valueOf(r0));
                                                        }
                                                    }
                                                    return true;
                                                } else if (str.startsWith("//showaudiotoast")) {
                                                    r0 = str.split(" ");
                                                    if (r0.length >= 2) {
                                                        r0 = bh.getInt(r0[1], 0);
                                                        ar.Hg();
                                                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_MUSIC_SHOW_AUDIO_TOAST_BOOLEAN_SYNC, Boolean.valueOf(r0 == 1));
                                                    }
                                                    return true;
                                                } else if (str.startsWith("//switchmusicplayer")) {
                                                    x.i("MicroMsg.CommandProcessor", "msg:%s", str);
                                                    r2 = str.split(" ");
                                                    if (r2.length > 2) {
                                                        Object obj;
                                                        if (bh.getInt(r2[1], 0) == 0) {
                                                            obj = null;
                                                        } else {
                                                            r1 = 1;
                                                        }
                                                        int i = bh.getInt(r2[2], -1);
                                                        ar.Hg();
                                                        r2 = ((Integer) com.tencent.mm.z.c.CU().get(w.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(0))).intValue();
                                                        r0 = 1;
                                                        if (i == -1) {
                                                            if (obj != null) {
                                                                r1 = 255;
                                                            } else {
                                                                r1 = 0;
                                                            }
                                                        } else if (i == 0) {
                                                            if (obj != null) {
                                                                r1 = r2 | 1;
                                                            } else {
                                                                r1 = r2 & -2;
                                                            }
                                                        } else if (i == 1) {
                                                            if (obj != null) {
                                                                r1 = r2 | 2;
                                                            } else {
                                                                r1 = r2 & -3;
                                                            }
                                                        } else if (i == 4) {
                                                            if (obj != null) {
                                                                r1 = r2 | 4;
                                                            } else {
                                                                r1 = r2 & -5;
                                                            }
                                                        } else if (i == 6) {
                                                            if (obj != null) {
                                                                r1 = r2 | 16;
                                                            } else {
                                                                r1 = r2 & -17;
                                                            }
                                                        } else if (i == 7) {
                                                            if (obj != null) {
                                                                r1 = r2 | 32;
                                                            } else {
                                                                r1 = r2 & -33;
                                                            }
                                                        } else if (i == 8) {
                                                            if (obj != null) {
                                                                r1 = r2 | 64;
                                                            } else {
                                                                r1 = r2 & -65;
                                                            }
                                                        } else if (i != 9) {
                                                            r0 = null;
                                                            r1 = r2;
                                                        } else if (obj != null) {
                                                            r1 = r2 | FileUtils.S_IWUSR;
                                                        } else {
                                                            r1 = r2 & -129;
                                                        }
                                                        if (r0 != null) {
                                                            ar.Hg();
                                                            com.tencent.mm.z.c.CU().a(w.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(r1));
                                                        }
                                                    }
                                                    return true;
                                                } else if (str.startsWith("//testdefaultrsa")) {
                                                    x.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa");
                                                    r0 = str.split(" ");
                                                    r0 = r0 != null && r0.length > 1;
                                                    com.tencent.mm.protocal.ac.F("", "", 0);
                                                    new v("", "", "", 0).RX().a(com.tencent.mm.kernel.g.Di().CG().CK(), new 8(r0, context));
                                                    return true;
                                                } else if (str.startsWith("//dumpdefaultrsa")) {
                                                    return v(context, "");
                                                } else {
                                                    if (str.startsWith("//hardwareinfo")) {
                                                        ((com.tencent.mm.plugin.hardwareopt.a.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).fK(true);
                                                        return true;
                                                    } else if (str.startsWith("//showStringName")) {
                                                        r0 = ac.cft();
                                                        r0.edit().putBoolean("ShowStringName", !r0.getBoolean("ShowStringName", false)).commit();
                                                        return true;
                                                    } else if (str.startsWith("//mmphotoedit")) {
                                                        com.tencent.mm.bm.d.b(context, "mmsight", ".ui.TestVideoEditUI", new Intent());
                                                        return true;
                                                    } else if (str.startsWith("//openwebviewhistory")) {
                                                        com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.fts.FtsBrowseHistoryUI", new Intent());
                                                        return true;
                                                    } else if (str.startsWith("//msgDelay")) {
                                                        com.tencent.mm.ui.conversation.a.m.fW(context);
                                                        return true;
                                                    } else if (str.startsWith("//cpDelayedMsg")) {
                                                        com.tencent.mm.ui.conversation.a.m.fX(context);
                                                        return true;
                                                    } else if (str.startsWith("//testhce")) {
                                                        com.tencent.mm.bm.d.y(context, "nfc", ".ui.HceTestUI");
                                                        return true;
                                                    } else if (str.startsWith("//testservice ")) {
                                                        str3 = str.replace("//testservice ", "");
                                                        r1 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                                                        r2 = "forceTrigger";
                                                        r0 = str3 != null && str3.equals("1");
                                                        r1.putBoolean(r2, r0).commit();
                                                        return true;
                                                    } else if (str.startsWith("//openDetect")) {
                                                        ac.getContext().getSharedPreferences("system_config_prefs", 4).edit().putBoolean("msg_delay_close_detect", false).apply();
                                                        return true;
                                                    } else if (str.startsWith("//closeDetect")) {
                                                        ac.getContext().getSharedPreferences("system_config_prefs", 4).edit().putBoolean("msg_delay_close_detect", true).apply();
                                                        return true;
                                                    } else {
                                                        x.d("MicroMsg.CommandProcessor", "processed : in ret:[%d]", Integer.valueOf(eY(str)));
                                                        switch (eY(str)) {
                                                            case 0:
                                                                return false;
                                                            case 568:
                                                                Assert.assertTrue("test errlog", false);
                                                                return true;
                                                            case 569:
                                                                ar.Hg().FD();
                                                                return true;
                                                            case 570:
                                                                if (be.XK(eZ(str))) {
                                                                    Toast.makeText(context, R.l.eUv, 0).show();
                                                                }
                                                                return true;
                                                            case 571:
                                                                str3 = eZ(str);
                                                                ar.Hg();
                                                                com.tencent.mm.z.c.CU().set(8195, str3);
                                                                return true;
                                                            case 572:
                                                                com.tencent.mm.sdk.platformtools.f.fdU = Integer.valueOf(eZ(str)).intValue();
                                                                return true;
                                                            case 574:
                                                                StringBuilder append = new StringBuilder().append(com.tencent.mm.compatible.d.q.yE());
                                                                ar.Hg();
                                                                com.tencent.mm.ui.base.h.B(context, com.tencent.mm.a.g.s(append.append(com.tencent.mm.z.c.Cg()).toString().getBytes()), "md5");
                                                                return true;
                                                            case 579:
                                                                ak.a.GQ().Q(eZ(str), "");
                                                                return true;
                                                            case 580:
                                                                ar.CG().d(new bd(new 9()));
                                                                return true;
                                                            case 581:
                                                                com.tencent.mm.pluginsdk.model.app.an.bim().RD(eZ(str));
                                                                return true;
                                                            case 582:
                                                                str3 = eZ(str);
                                                                ar.Hg();
                                                                r0 = com.tencent.mm.z.c.EY().WO(str3);
                                                                if (r0 == null || r0.AO() == 0) {
                                                                    return false;
                                                                }
                                                                r0.Ag();
                                                                com.tencent.mm.z.s.t(r0);
                                                                return true;
                                                            case 583:
                                                                ar.Hg();
                                                                com.tencent.mm.z.c.FE();
                                                                return true;
                                                            case 584:
                                                            case 585:
                                                                com.tencent.mm.z.bc.hV(eZ(str));
                                                                return true;
                                                            case 586:
                                                                r0 = str.split(" ");
                                                                if (r0 != null && r0.length == 3) {
                                                                    com.tencent.mm.modelmulti.t.bd(bh.getInt(r0[1], 0), bh.getInt(r0[2], 0));
                                                                }
                                                                return true;
                                                            case 587:
                                                                com.tencent.mm.sdk.b.a.xef.m(new ci());
                                                                return true;
                                                            case 588:
                                                                com.tencent.mm.a.e.bS("/sdcard/tencent/MicroMsg/back");
                                                                ar.Hg();
                                                                com.tencent.mm.sdk.platformtools.k.q(com.tencent.mm.z.c.FB(), "/sdcard/tencent/MicroMsg/back", false);
                                                                return true;
                                                            case 590:
                                                                return true;
                                                            case 591:
                                                                try {
                                                                    r0 = str.split(" ");
                                                                    if (r0 != null && r0.length > 1) {
                                                                        ar.Hg().FH().p(com.tencent.mm.sdk.platformtools.bi.y(r0[0], "sysmsg"));
                                                                    }
                                                                } catch (Throwable e5222222222) {
                                                                    x.printErrStackTrace("MicroMsg.CommandProcessor", e5222222222, "hy: error occured in commandProcessor", new Object[0]);
                                                                }
                                                                return true;
                                                            default:
                                                                return false;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean v(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!bh.ov(str)) {
            stringBuffer.append(str + "\n\n");
        }
        stringBuffer.append("Default RSA Info:\n");
        stringBuffer.append("ClientVersion: " + com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION + "\n");
        stringBuffer.append("BASE_RSA_PUBLIC_VERSION = 169\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYN = C8B29DB2928FF09CBF561E20E0BDCB9700BF14E02E8291F45811C41569153644267C7C74060BD9D35B6D831F532D3552C8D453682C624F935DFF256E9ACA6735DBB7F9578CF87B0223A8C59CF1740CBA1C34A531D3C0AFED9A076781DCB9611448B3384DF377AF1FF3FD3663756ED675F663F3CCA0B1C7C800644721ECC0823730EC77F8159C2D48BFE0493035914655D24E77940F31C770DD661D7512342CC67C13D1FFBDA1EF32961F5DEA5D94F176FA7A338338D9E039EC194F90637C324B1C627CBBE9DC4004843B37FE7854C6D8A99A5E288EC525E0847618BD0196A87218060ADF0C8D82D8AF07BF718BDDA54D0140DF8293EE76FFC93D3DCFD20F8883 len(512" + ")\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYE = 010001\n\n");
        stringBuffer.append("REQ_RSA_PUBLIC_VERSION = 170\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYN = 994B7DB5D0A2C31D8F68D63224EEC9EB5866B665B03656B357EACCA065257A9B8360E647F91E770B0B52B8015CEBF06CCEE57164021661F1DAF533284C12FAB4EB6D7B808F62E6AD3975BD138693ADCA93A147BC81843A9ED177D504A3D157CC8DD99ADA3DC2A348E498939507A70A6C20880B070D030CDEC304B3C3248F9D2D352B8932D865BFDAD64CF74F98A073043CB43A51A3F582AF36E2523FC56A8224DD2056EDF8790ABE32724F205A949A31E2FFD055823F9D249081482672EAC75BE0755E0EE9DF3FBCA3F50004CFC17B84590FA963DA07765B983EDC39673CCE269CACB6CBAFCA62C13FCBF1461F7C07E8FFA5B6E3EB4D54DEC6872AC8B26585EF len(512" + ")\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYE = 010001\n");
        x.i("MicroMsg.CommandProcessor", "summercert dumpdefaultrsa " + stringBuffer.toString());
        if (!com.tencent.mm.sdk.a.b.ceK()) {
            return false;
        }
        View textView = new TextView(context);
        textView.setText(stringBuffer.toString());
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvV);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        com.tencent.mm.ui.base.h.a(context, null, textView, null);
        if (!com.tencent.mm.protocal.ac.cdP()) {
            return true;
        }
        Toast.makeText(context, "dump file:" + com.tencent.mm.compatible.util.e.bnF + "DefaultRSA.java", 1).show();
        return true;
    }

    private static StringBuilder fT(int i) {
        BufferedReader bufferedReader;
        Throwable e;
        Date date = new Date(bh.Wp() - (((long) i) * 86400000));
        String str = com.tencent.mm.compatible.util.e.gZM + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt";
        StringBuilder stringBuilder = new StringBuilder();
        if (!new File(str).exists()) {
            return new StringBuilder(" day -" + i + " no crash.");
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            try {
                if (bh.ov(bufferedReader.readLine())) {
                    bufferedReader.close();
                    StringBuilder stringBuilder2 = new StringBuilder("read day -" + i + "file failed");
                    try {
                        bufferedReader.close();
                        return stringBuilder2;
                    } catch (Exception e2) {
                        return stringBuilder2;
                    }
                }
                while (true) {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        stringBuilder.append(new String(Base64.decode(str.split("error_")[1], 0)).split("#accinfo.uin=")[1]);
                        stringBuilder.append("\n_____________________________________\n");
                    } else {
                        try {
                            break;
                        } catch (Exception e3) {
                        }
                    }
                }
                bufferedReader.close();
                return stringBuilder;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            try {
                x.printErrStackTrace("MicroMsg.CommandProcessor", e, "", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e6) {
                    }
                }
                return stringBuilder;
            } catch (Throwable th) {
                e = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e7) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    private static void fU(int i) {
        SharedPreferences bh = am.bh(ac.getContext(), "sp_sns_dynswitch_stg");
        switch (i) {
            case -1:
                bh.edit().remove("st_sw_use_vcodec_img").commit();
                return;
            case 0:
                bh.edit().putBoolean("st_sw_use_vcodec_img", false).commit();
                return;
            case 1:
                bh.edit().putBoolean("st_sw_use_vcodec_img", true).commit();
                return;
            default:
                throw new IllegalArgumentException("Bad op parameter: " + i);
        }
    }

    private static void fV(int i) {
        SharedPreferences bh = am.bh(ac.getContext(), "sp_sns_dynswitch_stg");
        switch (i) {
            case -1:
                bh.edit().remove("st_sw_use_wxpc_img").commit();
                return;
            case 0:
                bh.edit().putBoolean("st_sw_use_wxpc_img", false).commit();
                return;
            case 1:
                bh.edit().putBoolean("st_sw_use_wxpc_img", true).commit();
                return;
            default:
                throw new IllegalArgumentException("Bad op parameter: " + i);
        }
    }
}
