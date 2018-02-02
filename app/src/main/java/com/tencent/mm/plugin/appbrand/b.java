package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.o;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.launching.aa;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.File;

public final class b implements a {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr) {
        int i = -1;
        boolean z = false;
        if (com.tencent.mm.sdk.a.b.ceK()) {
            if (!"//wxafts".equals(strArr[0])) {
                SharedPreferences cft;
                if (!"//localwxalibrary".equals(strArr[0])) {
                    if (!"//getsearchshowoutwxaapp".equals(strArr[0])) {
                        if (!"//callsearchshowoutwxaapp".equals(strArr[0])) {
                            int i2;
                            String toLowerCase = strArr[1].toLowerCase();
                            boolean z2;
                            switch (toLowerCase.hashCode()) {
                                case -2120258717:
                                    if (toLowerCase.equals("incremental_insert_24")) {
                                        i2 = 11;
                                        break;
                                    }
                                case -2120258713:
                                    if (toLowerCase.equals("incremental_insert_28")) {
                                        i2 = 12;
                                        break;
                                    }
                                case -2094503115:
                                    if (toLowerCase.equals("incremental_delete_28")) {
                                        i2 = 13;
                                        break;
                                    }
                                case -2086708598:
                                    if (toLowerCase.equals("deletebetalib")) {
                                        z2 = false;
                                        break;
                                    }
                                case -1958532869:
                                    if (toLowerCase.equals("historycount")) {
                                        i2 = 4;
                                        break;
                                    }
                                case -1897191982:
                                    if (toLowerCase.equals("starmax")) {
                                        i2 = 7;
                                        break;
                                    }
                                case -1513405239:
                                    if (toLowerCase.equals("clear_mocklib")) {
                                        i2 = 16;
                                        break;
                                    }
                                case -917899243:
                                    if (toLowerCase.equals("deletecontact")) {
                                        i2 = 3;
                                        break;
                                    }
                                case -901868261:
                                    if (toLowerCase.equals("force_modularizing")) {
                                        i2 = 17;
                                        break;
                                    }
                                case -823215646:
                                    if (toLowerCase.equals("prunepkg")) {
                                        i2 = 2;
                                        break;
                                    }
                                case -725390129:
                                    if (toLowerCase.equals("clearguide")) {
                                        i2 = 9;
                                        break;
                                    }
                                case -501183631:
                                    if (toLowerCase.equals("releasepkghighversion")) {
                                        i2 = 10;
                                        break;
                                    }
                                case -358696710:
                                    if (toLowerCase.equals("deletelib")) {
                                        z2 = true;
                                        break;
                                    }
                                case -78191370:
                                    if (toLowerCase.equals("incremental_delete_latest")) {
                                        i2 = 14;
                                        break;
                                    }
                                case 3545755:
                                    if (toLowerCase.equals("sync")) {
                                        i2 = 6;
                                        break;
                                    }
                                case 98712316:
                                    if (toLowerCase.equals("guide")) {
                                        i2 = 8;
                                        break;
                                    }
                                case 424332448:
                                    if (toLowerCase.equals("incremental_lib")) {
                                        i2 = 15;
                                        break;
                                    }
                                case 1005455806:
                                    if (toLowerCase.equals("useisolatectxwxalibrary")) {
                                        i2 = 18;
                                        break;
                                    }
                                case 1127987502:
                                    if (toLowerCase.equals("resetsyncversion")) {
                                        i2 = 5;
                                        break;
                                    }
                                default:
                                    i2 = -1;
                                    break;
                            }
                            int i3;
                            ae aeVar;
                            switch (i2) {
                                case 0:
                                    ai Zo = f.Zo();
                                    c aeVar2 = new ae();
                                    aeVar2.field_appId = "@LibraryAppId";
                                    aeVar2.field_debugType = 999;
                                    aeVar2.field_version = 1;
                                    Zo.iGt.a(aeVar2, ae.iGb);
                                    i3 = y.VERSION;
                                    d.lv(2);
                                    break;
                                case 1:
                                    f.Zo().aj("@LibraryAppId", 0);
                                    i3 = y.VERSION;
                                    d.lv(2);
                                    break;
                                case 2:
                                    af.aal();
                                    break;
                                case 3:
                                    q.qU(strArr[2]);
                                    break;
                                case 4:
                                    if (bh.getInt(strArr[2].trim(), 0) > 0) {
                                        z = true;
                                    }
                                    g.Dj().CU().a(w.a.xrM, Boolean.valueOf(z));
                                    break;
                                case 5:
                                    q.qT(strArr[2]);
                                    break;
                                case 6:
                                    r.qY(strArr[2]);
                                    break;
                                case 7:
                                    k.iJV = Integer.valueOf(Math.max(0, bh.getInt(strArr[2], 10)));
                                    break;
                                case 8:
                                    com.tencent.mm.bm.d.y(ac.getContext(), "appbrand", ".ui.AppBrandGuideUI");
                                    break;
                                case 9:
                                    g.Dj().CU().a(w.a.xrL, Boolean.valueOf(false));
                                    break;
                                case 10:
                                    try {
                                        String str = strArr[2];
                                        WxaAttributes.d dVar = new WxaAttributes.d();
                                        dVar.fIm = 1000;
                                        dVar.iPG = "fake";
                                        f.Zo().a(str, dVar);
                                        break;
                                    } catch (Exception e) {
                                        break;
                                    }
                                case 11:
                                    aeVar = new ae();
                                    aeVar.field_appId = "wx4ffb369b6881ee5e";
                                    aeVar.field_version = 24;
                                    aeVar.field_versionMd5 = "a47b978d23679075cbbed1030f71b7bb";
                                    aeVar.field_versionState = 0;
                                    aeVar.field_debugType = 0;
                                    aeVar.field_pkgPath = "/sdcard/_276854502_24.wxapkg";
                                    f.Zo().d(aeVar);
                                    break;
                                case 12:
                                    aeVar = new ae();
                                    aeVar.field_appId = "wx4ffb369b6881ee5e";
                                    aeVar.field_version = 28;
                                    aeVar.field_versionMd5 = "5713e70880cc2d356905d6189ba37a72";
                                    aeVar.field_versionState = 0;
                                    aeVar.field_debugType = 0;
                                    aeVar.field_pkgPath = "/sdcard/_276854502_28.wxapkg";
                                    f.Zo().d(aeVar);
                                    break;
                                case 13:
                                    aeVar = new ae();
                                    aeVar.field_appId = "wx4ffb369b6881ee5e";
                                    aeVar.field_version = 28;
                                    aeVar.field_debugType = 0;
                                    f.Zo().a(aeVar);
                                    break;
                                case 14:
                                    ai Zo2 = f.Zo();
                                    ae a = Zo2.a("wx4ffb369b6881ee5e", 0, new String[]{"version"});
                                    if (a != null) {
                                        Zo2.a(a);
                                        break;
                                    }
                                    break;
                                case 15:
                                    new com.tencent.mm.plugin.appbrand.appcache.g(bh.getInt(strArr[2], 78), strArr[3]).run();
                                    break;
                                case 16:
                                    y.ZT();
                                    Toast.makeText(ac.getContext(), "MockLib已清除，重启微信生效", 1).show();
                                    break;
                                case 17:
                                    if (strArr.length < 3 || !strArr[2].equalsIgnoreCase("false")) {
                                        z = true;
                                    }
                                    aa.jym = z;
                                    break;
                                case 18:
                                    cft = ac.cft();
                                    if (strArr.length > 2) {
                                        if (!"open".equalsIgnoreCase(strArr[2])) {
                                            if (!"close".equalsIgnoreCase(strArr[2])) {
                                                if ("auto".equalsIgnoreCase(strArr[2])) {
                                                    cft.edit().putInt("useisolatectxwxalibrary", 0).commit();
                                                    break;
                                                }
                                            }
                                            cft.edit().putInt("useisolatectxwxalibrary", -1).commit();
                                            break;
                                        }
                                        cft.edit().putInt("useisolatectxwxalibrary", 1).commit();
                                        break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        ((com.tencent.mm.plugin.appbrand.m.f) g.h(com.tencent.mm.plugin.appbrand.m.f.class)).abg();
                    } else if (strArr.length <= 1 || !strArr[1].contains("daily")) {
                        o.jG(o.a.iKh);
                    } else {
                        o.jG(o.a.iKg);
                    }
                } else {
                    cft = ac.cft();
                    String str2 = strArr[1];
                    switch (str2.hashCode()) {
                        case 3569038:
                            if (str2.equals("true")) {
                                i = 1;
                                break;
                            }
                            break;
                        case 94746189:
                            if (str2.equals("clear")) {
                                i = 0;
                                break;
                            }
                            break;
                        case 97196323:
                            if (str2.equals("false")) {
                                i = 2;
                                break;
                            }
                            break;
                    }
                    switch (i) {
                        case 0:
                            cft.edit().remove("localwxalibrary").commit();
                            break;
                        case 1:
                            cft.edit().putBoolean("localwxalibrary", true).commit();
                            break;
                        case 2:
                            cft.edit().putBoolean("localwxalibrary", false).commit();
                            break;
                        default:
                            break;
                    }
                }
            } else if (strArr[1].contains("delete")) {
                com.tencent.mm.plugin.appbrand.l.c cVar = com.tencent.mm.plugin.appbrand.l.c.a.jJe;
                e.g(new File(((com.tencent.mm.plugin.appbrand.compat.a.f) g.h(com.tencent.mm.plugin.appbrand.compat.a.f.class)).Rh()));
                x.i("MicroMsg.WxaFTSSearchCore", "forceUnzipBasicTemplate");
                cVar.prepare();
            }
        }
        return true;
    }
}
