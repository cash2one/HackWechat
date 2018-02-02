package com.tencent.mm.plugin.ext.openapi.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.ad.n;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ext.c.e$a;
import com.tencent.mm.plugin.ext.c.e.2;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.e.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import org.xwalk.core.R$styleable;

public class ExtControlProviderOpenApi extends ExtContentProviderBase {
    public static boolean lZP = false;
    private static final String[] lZQ = new String[]{"retCode", "selfId"};
    private static final String[] lZR = new String[]{"retCode", "sportConfig"};
    private static final String[] lZS = new String[]{"openid", "avatar"};
    private static final String[] lZT = new String[]{"voiceType", "sampleRateInHz", "channelConfig", "audioFormat", DownloadInfoColumns.FILEPATH};
    private static final String[] lZU = new String[]{"ssid", "macAddress", "isSupportWechat", "name"};
    private Context context;
    private af handler;
    private String[] lZV = null;
    private int lZW = -1;

    public ExtControlProviderOpenApi(String[] strArr, int i, Context context) {
        this.lZV = strArr;
        this.lZW = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        this.handler = new af();
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", new Object[]{Integer.valueOf(this.lZW)});
        a(uri, this.context, this.lZW, this.lZV);
        String str3 = this.maf;
        if (uri == null) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
            cs(3, 5);
            return a.By(5);
        } else if (bh.ov(this.maf)) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
            cs(3, 7);
            return a.By(7);
        } else if (bh.ov(aFM())) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
            cs(3, 6);
            return a.By(6);
        } else if (aqY()) {
            int i = 1;
            if (!lZP) {
                i = aFN();
            }
            if (i != 1) {
                x.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = " + i);
                cs(2, i);
                return a.By(i);
            }
            String str4;
            String str5;
            Intent intent;
            long j;
            Intent intent2;
            switch (this.lZW) {
                case 22:
                    return h(uri.getQueryParameter("op"), uri.getQueryParameter("scene"), uri.getQueryParameter("msgType"), uri.getQueryParameter("msgState"));
                case 23:
                    return k(strArr2);
                case 25:
                    return l(strArr2);
                case 34:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        str3 = "MicroMsg.ExtControlProviderOpenApi";
                        str4 = "sendSight wrong args,args == null:%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(strArr2 == null);
                        x.e(str3, str4, objArr);
                        cs(3, 3401);
                        return a.By(3401);
                    }
                    Object obj;
                    str5 = strArr2[0];
                    if (bh.ov(str5) || !e.bO(str5)) {
                        obj = null;
                    } else {
                        c cVar = new c();
                        obj = SightVideoJNI.isSightOk(str5, cVar.qte, cVar.qtf, cVar.qtg, cVar.qti, cVar.qth, cVar.qth.length) == 0 ? 1 : null;
                    }
                    if (obj == null) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
                        cs(3, 3402);
                        return a.By(3402);
                    }
                    intent = new Intent();
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.addFlags(67108864);
                    intent.putExtra("sight_local_path", str5);
                    d.a(this.context, ".ui.transmit.SightForwardUI", intent);
                    J(12, 0, 1);
                    return a.By(1);
                case 35:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
                    if (strArr2 == null || strArr2.length <= 0 || bh.ov(strArr2[0])) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
                        cs(3, 3201);
                        return a.By(3201);
                    }
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", new Object[]{strArr2[0]});
                    i = new com.tencent.mm.plugin.ext.b.c(this.context, str5).aFI();
                    x.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", new Object[]{Integer.valueOf(i)});
                    if (i != -1) {
                        J(14, 0, i);
                        i = 0;
                    } else {
                        J(15, 0, i);
                    }
                    return a.By(i);
                case 36:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
                    if (strArr2 == null || strArr2.length < 3) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
                        cs(3, 3301);
                        return a.By(3301);
                    }
                    str5 = strArr2[0];
                    int i2 = bh.getInt(strArr2[1], -1);
                    str4 = strArr2[2];
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", new Object[]{str5, Integer.valueOf(i2), str4});
                    if (bh.ov(str5) || i2 < 0 || bh.ov(str4)) {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
                        cs(3, 3302);
                        return a.By(3302);
                    }
                    b qsVar = new qs();
                    qsVar.fIx.fIy = str5;
                    qsVar.fIx.fIz = i2;
                    qsVar.fIx.fIA = str4;
                    qsVar.fIx.bgo = com.tencent.mm.pluginsdk.a.g(str5, this.context);
                    com.tencent.mm.sdk.b.a.xef.m(qsVar);
                    J(16, 0, 1);
                    return a.By(1);
                case 37:
                    x.d("MicroMsg.ExtControlProviderOpenApi", com.tencent.mm.plugin.appbrand.jsapi.wifi.c.NAME);
                    this.handler = new af(Looper.getMainLooper());
                    MatrixCursor matrixCursor = (MatrixCursor) new 1(this, strArr2).b(this.handler);
                    if (matrixCursor == null) {
                        J(19, 4, 14);
                        return a.By(14);
                    }
                    J(18, 0, 1);
                    x.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
                    return matrixCursor;
                case 38:
                    x.d("MicroMsg.ExtControlProviderOpenApi", com.tencent.mm.plugin.appbrand.jsapi.wifi.a.NAME);
                    this.handler = new af(Looper.getMainLooper());
                    Integer num = (Integer) new 2(this, strArr2).b(this.handler);
                    if (num == null) {
                        J(21, 4, 14);
                        return a.By(14);
                    }
                    J(20, 0, num.intValue());
                    return a.By(num.intValue());
                case 40:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
                    if (strArr2 == null || strArr2.length < 3) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
                        J(23, 3, 2);
                        return a.By(2);
                    }
                    long j2 = bh.getLong(strArr2[0], -1);
                    j = bh.getLong(strArr2[1], -1);
                    long j3 = bh.getLong(strArr2[2], -1);
                    x.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)});
                    if (j < 0 || j2 < 0 || j3 < 0) {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "param err");
                        J(23, 3, 2);
                        return a.By(2);
                    }
                    aFJ();
                    b feVar = new fe();
                    feVar.fui.action = 2;
                    feVar.fui.fuk = j;
                    feVar.fui.ful = j2;
                    feVar.fui.fum = j3;
                    if (com.tencent.mm.sdk.b.a.xef.m(feVar) && feVar.fuj.fuo) {
                        J(22, 0, feVar.fuj.fup);
                        return a.By(feVar.fuj.fup);
                    }
                    J(23, 4, 8);
                    return a.By(8);
                case 41:
                    x.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
                    aFJ();
                    b feVar2 = new fe();
                    feVar2.fui.action = 3;
                    if (com.tencent.mm.sdk.b.a.xef.m(feVar2) && feVar2.fuj.fuo) {
                        str4 = feVar2.fuj.fun;
                        Cursor matrixCursor2 = new MatrixCursor(lZR);
                        matrixCursor2.addRow(new Object[]{Integer.valueOf(feVar2.fuj.fup), bh.ou(str4)});
                        J(22, 0, feVar2.fuj.fup);
                        x.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[]{Integer.valueOf(feVar2.fuj.fup)});
                        return matrixCursor2;
                    }
                    J(23, 4, 8);
                    return a.By(8);
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                    intent2 = new Intent();
                    intent2.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent2.putExtra("key_from_scene", 4);
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", new Object[]{str3});
                    } else {
                        x.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", new Object[]{strArr2[0], str3});
                        intent2.putExtra("key_business_attach", strArr2[0]);
                    }
                    intent2.putExtra("key_appid", str3);
                    d.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                    g.pQN.h(12097, new Object[]{Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                    J(24, 0, 1);
                    return a.By(1);
                case 46:
                    x.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", new Object[]{str3});
                    ar.Hg();
                    if (com.tencent.mm.z.c.isSDCardAvailable()) {
                        intent2 = new Intent();
                        intent2.putExtra("key_from_openapi", true);
                        intent2.putExtra("key_openapi_appid", str3);
                        d.b(this.context, "clean", ".ui.CleanUI", intent2);
                        J(26, 0, 1);
                        return a.By(1);
                    }
                    J(27, 5, 4);
                    return a.By(4101);
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    com.tencent.mm.plugin.ext.c.e.aFX().mContext = this.context;
                    if (strArr2 == null || strArr2.length <= 0) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
                        return a.By(4201);
                    }
                    int i3 = bh.getInt(strArr2[0], -1);
                    if (i3 < 0 || !(i3 == 0 || i3 == 1 || i3 == 2)) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
                        J(32, 3, 2);
                        return a.By(4201);
                    }
                    str5 = null;
                    if (i3 != 0 && i3 != 1) {
                        str4 = null;
                    } else if (strArr2.length < 2) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
                        return a.By(4205);
                    } else {
                        str3 = strArr2[1];
                        if (i3 != 1) {
                            str4 = str3;
                        } else if (strArr2.length < 3) {
                            x.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
                            return a.By(4208);
                        } else {
                            str5 = strArr2[2];
                            str4 = str3;
                        }
                    }
                    x.i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", new Object[]{Integer.valueOf(i3), str4});
                    e$a zC;
                    switch (i3) {
                        case 0:
                            com.tencent.mm.plugin.ext.c.e aFX = com.tencent.mm.plugin.ext.c.e.aFX();
                            if (bh.ov(str4)) {
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
                                com.tencent.mm.plugin.ext.c.e.D(null, -1, 4205);
                                return a.By(4205);
                            }
                            e$a com_tencent_mm_plugin_ext_c_e_a;
                            zC = com.tencent.mm.plugin.ext.c.c.zC(str4);
                            if (zC == null || bh.ov(zC.url)) {
                                com.tencent.mm.plugin.ext.c.d.b al = com.tencent.mm.plugin.ext.c.e.al(str4, false);
                                if (al == null) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
                                    com.tencent.mm.plugin.ext.c.e.D(null, -1, 4206);
                                    return a.By(4206);
                                }
                                zC = aFX.a(al);
                                if (zC == null || bh.ov(zC.url)) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
                                    return a.By(4203);
                                }
                                com_tencent_mm_plugin_ext_c_e_a = zC;
                            } else {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[]{str4, zC});
                                com_tencent_mm_plugin_ext_c_e_a = zC;
                            }
                            if (com_tencent_mm_plugin_ext_c_e_a.type != 19) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
                                return a.By(1);
                            } else if (com.tencent.mm.plugin.ext.c.c.zE(com_tencent_mm_plugin_ext_c_e_a.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[]{com_tencent_mm_plugin_ext_c_e_a.url.toUpperCase()});
                                com.tencent.mm.plugin.ext.c.e.D(com_tencent_mm_plugin_ext_c_e_a.url, com_tencent_mm_plugin_ext_c_e_a.type, 4207);
                                return a.Ro(com_tencent_mm_plugin_ext_c_e_a.url);
                            } else if (com.tencent.mm.plugin.ext.c.c.zD(com_tencent_mm_plugin_ext_c_e_a.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", new Object[]{com_tencent_mm_plugin_ext_c_e_a.url});
                                com.tencent.mm.plugin.ext.c.e.D(com_tencent_mm_plugin_ext_c_e_a.url, com_tencent_mm_plugin_ext_c_e_a.type, 1);
                                return a.By(1);
                            } else {
                                j = bh.Wq();
                                b$b zF = com.tencent.mm.plugin.ext.c.c.zF(com_tencent_mm_plugin_ext_c_e_a.url);
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", new Object[]{zF.toString(), Long.valueOf(bh.bA(j))});
                                if (zF == b$b.WHITE) {
                                    com.tencent.mm.plugin.ext.c.c.zA(com_tencent_mm_plugin_ext_c_e_a.url);
                                    com.tencent.mm.plugin.ext.c.e.D(com_tencent_mm_plugin_ext_c_e_a.url, com_tencent_mm_plugin_ext_c_e_a.type, 1);
                                    return a.By(1);
                                }
                                if (zF != b$b.BLACK) {
                                    String str6 = com_tencent_mm_plugin_ext_c_e_a.url;
                                    int i4 = com_tencent_mm_plugin_ext_c_e_a.type;
                                    int i5 = com_tencent_mm_plugin_ext_c_e_a.mbu;
                                    x.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", new Object[]{str6});
                                    long currentTimeMillis = System.currentTimeMillis();
                                    x.i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", new Object[]{(Boolean) new 2(aFX, Boolean.valueOf(true), str6, i4, i5).b(com.tencent.mm.plugin.ext.c.e.aFZ()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                    if (((Boolean) new 2(aFX, Boolean.valueOf(true), str6, i4, i5).b(com.tencent.mm.plugin.ext.c.e.aFZ())).booleanValue()) {
                                        com.tencent.mm.plugin.ext.c.c.zA(com_tencent_mm_plugin_ext_c_e_a.url);
                                        com.tencent.mm.plugin.ext.c.e.D(com_tencent_mm_plugin_ext_c_e_a.url, com_tencent_mm_plugin_ext_c_e_a.type, 1);
                                        return a.By(1);
                                    }
                                }
                                com.tencent.mm.plugin.ext.c.c.zB(com_tencent_mm_plugin_ext_c_e_a.url);
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", new Object[]{com_tencent_mm_plugin_ext_c_e_a.url});
                                com.tencent.mm.plugin.ext.c.e.D(com_tencent_mm_plugin_ext_c_e_a.url, com_tencent_mm_plugin_ext_c_e_a.type, 4207);
                                return a.Ro(com_tencent_mm_plugin_ext_c_e_a.url);
                            }
                        case 1:
                            com.tencent.mm.plugin.ext.c.e aFX2 = com.tencent.mm.plugin.ext.c.e.aFX();
                            if (bh.ov(str4)) {
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
                                com.tencent.mm.plugin.ext.c.e.E(null, -1, 4205);
                                return a.By(4205);
                            }
                            e$a zC2 = com.tencent.mm.plugin.ext.c.c.zC(str4);
                            if (zC2 != null && !bh.ov(zC2.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[]{str4, zC2});
                                zC = zC2;
                            } else if (bh.ov(str5)) {
                                x.w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
                                com.tencent.mm.plugin.ext.c.e.E(null, -1, 4208);
                                return a.By(4208);
                            } else {
                                com.tencent.mm.plugin.ext.c.d.b al2 = com.tencent.mm.plugin.ext.c.e.al(str4, true);
                                if (al2 == null) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
                                    com.tencent.mm.plugin.ext.c.e.E(null, -1, 4206);
                                    return a.By(4206);
                                } else if (bh.ov(al2.fqR)) {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
                                    com.tencent.mm.plugin.ext.c.e.E(null, -1, 4210);
                                    return a.By(4210);
                                } else if (al2.fqR.equalsIgnoreCase(str5)) {
                                    zC = aFX2.a(al2);
                                    if (zC == null || bh.ov(zC.url)) {
                                        x.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
                                        com.tencent.mm.plugin.ext.c.e.E(null, -1, 4203);
                                        return a.By(4203);
                                    }
                                    com.tencent.mm.plugin.ext.c.c.a(str4, zC);
                                } else {
                                    x.w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
                                    com.tencent.mm.plugin.ext.c.e.E(null, -1, 4209);
                                    return a.By(4209);
                                }
                            }
                            if (zC.type == 19 && com.tencent.mm.plugin.ext.c.c.zE(zC.url)) {
                                x.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[]{zC.url});
                                com.tencent.mm.plugin.ext.c.e.E(zC.url, zC.type, 4207);
                                return a.By(4207);
                            }
                            x.i("MicroMsg.ExtQrCodeHandler", "hy: do open");
                            x.i("MicroMsg.ExtQrCodeHandler", "hy: start open: %s", new Object[]{zC.toString()});
                            intent = new Intent(aFX2.mContext, RedirectToQrCodeStubUI.class);
                            intent.putExtra("K_STR", zC.url);
                            intent.putExtra("K_TYPE", zC.type);
                            intent.putExtra("K_VERSION", zC.mbu);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            aFX2.mContext.startActivity(intent);
                            com.tencent.mm.plugin.ext.c.e.E(zC.url, zC.type, 1);
                            return a.By(1);
                        case 2:
                            com.tencent.mm.plugin.ext.c.e.aFX();
                            return com.tencent.mm.plugin.ext.c.e.aFY();
                        default:
                            return null;
                    }
                default:
                    cs(3, 15);
                    return null;
            }
        } else {
            x.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
            cs(1, 3);
            return a.By(3);
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor h(String str, String str2, String str3, String str4) {
        int i = -1;
        x.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", new Object[]{str});
        if (this.context == null) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
            cs(4, 2001);
            return a.By(2001);
        } else if (bh.ov(str)) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
            cs(3, 2002);
            return a.By(2002);
        } else {
            try {
                i = bh.getInt(str, -1);
            } catch (Exception e) {
            }
            if (i == 1) {
                return K(str2, str3, str4);
            }
            if (i == 2) {
                x.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
                if (com.tencent.mm.plugin.ext.b.aFB().XC(this.maf) == null) {
                    x.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", new Object[]{this.maf, aFM()});
                    return a.By(TXLiveConstants.PLAY_EVT_PLAY_LOADING);
                }
                boolean z;
                bb aFB = com.tencent.mm.plugin.ext.b.aFB();
                String str5 = this.maf;
                if (str5 == null || str5.length() <= 0) {
                    z = false;
                } else {
                    z = aFB.gJP.delete("OpenMsgListener", "appId=?", new String[]{bh.ot(str5)}) > 0;
                }
                x.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", new Object[]{Boolean.valueOf(z), this.maf, aFM()});
                if (!z) {
                    return a.By(TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER);
                }
                J(0, 0, 1);
                return a.By(1);
            }
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", new Object[]{Integer.valueOf(i)});
            cs(3, 2003);
            return a.By(2003);
        }
    }

    private Cursor K(String str, String str2, String str3) {
        Exception exception;
        x.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
        if (bh.ov(str) || bh.ov(str2) || bh.ov(str3)) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", new Object[]{str, str2, str3});
            cs(3, TXLiveConstants.PLAY_EVT_PLAY_BEGIN);
            return a.By(TXLiveConstants.PLAY_EVT_PLAY_BEGIN);
        }
        MatrixCursor matrixCursor = null;
        try {
            int parseInt = Integer.parseInt(str3);
            int parseInt2 = Integer.parseInt(str);
            int parseInt3 = Integer.parseInt(str2);
            if (parseInt != 2) {
                x.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: " + parseInt);
                cs(3, TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
                return a.By(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
            }
            if (com.tencent.mm.plugin.ext.b.aFB().XC(this.maf) == null) {
                com.tencent.mm.sdk.e.c baVar = new ba();
                baVar.field_appId = this.maf;
                baVar.field_packageName = aFM();
                String str4 = this.maf;
                if (bh.ov(str4) ? false : com.tencent.mm.pluginsdk.model.app.g.i(com.tencent.mm.pluginsdk.model.app.g.aZ(str4, true))) {
                    baVar.field_status = 1;
                } else {
                    baVar.field_status = 0;
                }
                baVar.field_sceneFlag = parseInt2;
                baVar.field_msgTypeFlag = parseInt3;
                baVar.field_msgState = parseInt;
                x.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.ext.b.aFB().b(baVar)), aFM(), Integer.valueOf(parseInt2), Integer.valueOf(parseInt), Integer.valueOf(parseInt), Integer.valueOf(baVar.field_status)});
                if (!com.tencent.mm.plugin.ext.b.aFB().b(baVar)) {
                    return a.By(TXLiveConstants.PLAY_EVT_PLAY_END);
                }
            }
            x.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", new Object[]{this.maf, aFM()});
            StringBuilder append = new StringBuilder().append(q.FS());
            ar.Hg();
            String UZ = ab.UZ(append.append(com.tencent.mm.z.c.Cg()).toString());
            Cursor matrixCursor2 = new MatrixCursor(lZQ);
            try {
                matrixCursor2.addRow(new Object[]{Integer.valueOf(1), bh.ou(UZ)});
                J(0, 0, 1);
                x.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[]{Integer.valueOf(1)});
                return matrixCursor2;
            } catch (Exception e) {
                Exception exception2 = e;
                Cursor cursor = matrixCursor2;
                exception = exception2;
                J(1, 4, 12);
                x.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", new Object[]{exception.getMessage()});
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                return a.By(12);
            }
        } catch (Exception e2) {
            exception = e2;
            J(1, 4, 12);
            x.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", new Object[]{exception.getMessage()});
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            return a.By(12);
        }
    }

    private Cursor k(String[] strArr) {
        x.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
            cs(3, 3001);
            return a.By(3001);
        }
        Cursor matrixCursor = new MatrixCursor(lZS);
        int i = 0;
        while (i < strArr.length && i < 5) {
            if (!bh.ov(strArr[i])) {
                bj XM = com.tencent.mm.plugin.ext.b.aFC().XM(strArr[i]);
                if (XM == null || bh.ov(XM.field_openId) || bh.ov(XM.field_username)) {
                    x.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
                } else {
                    ar.Hg();
                    com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(XM.field_username);
                    if (WO == null || WO.field_username == null || WO.field_username.length() <= 0) {
                        x.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
                    } else {
                        try {
                            n.Jz();
                            String x = com.tencent.mm.ad.d.x(WO.field_username, false);
                            if (bh.ov(x)) {
                                x.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
                            } else {
                                String str = WO.field_username;
                                com.tencent.mm.ad.d.b.ji(x);
                                if (FileOp.md(x)) {
                                    matrixCursor.addRow(new Object[]{strArr[i], x});
                                } else {
                                    x.w("MicroMsg.ExtControlProviderOpenApi", "hy: copy or replace avatar from sfs to file system failed");
                                }
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", new Object[]{e.getMessage()});
                            J(7, 4, 12);
                            matrixCursor.close();
                            return a.By(12);
                        }
                    }
                }
            }
            i++;
        }
        J(6, 0, 1);
        return matrixCursor;
    }

    private Cursor l(String[] strArr) {
        x.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
        if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
            x.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
            cs(3, 3101);
            return a.By(3101);
        }
        MatrixCursor matrixCursor = null;
        int i = 0;
        while (i < 5 && i < strArr.length) {
            String str = strArr[i];
            try {
                if (o.g(str, 0, true)) {
                    String ax;
                    if (matrixCursor == null) {
                        matrixCursor = new MatrixCursor(lZT);
                    }
                    i iVar = new i();
                    String str2 = com.tencent.mm.plugin.ext.b.aFE() + "/" + ab.UZ(str);
                    x.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", new Object[]{str2});
                    if (!e.bO(str2) || bN(str2) == 0) {
                        ax = iVar.ax(str, str2);
                    } else {
                        x.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                        ax = str2;
                    }
                    if (bN(str2) == 0) {
                        ax = iVar.ax(str, str2);
                    }
                    if (bh.ov(ax)) {
                        x.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
                    } else {
                        x.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", new Object[]{Integer.valueOf(i)});
                        matrixCursor.addRow(new Object[]{Integer.valueOf(1), Integer.valueOf(iVar.mSampleRate), Integer.valueOf(iVar.fkO), Integer.valueOf(2), ax});
                    }
                } else {
                    x.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", new Object[]{strArr[i]});
                }
            } catch (Exception e) {
                x.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", new Object[]{e.getMessage()});
            }
            i++;
        }
        if (matrixCursor != null) {
            J(8, 0, 1);
            return matrixCursor;
        }
        J(9, 3, 4);
        return a.By(4);
    }

    private static int bN(String str) {
        if (str == null) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    private void aFJ() {
        String str = (String) com.tencent.mm.plugin.ext.b.aFA().get(w.a.xsg, null);
        x.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", new Object[]{str, aFM()});
        if (str == null) {
            com.tencent.mm.plugin.ext.b.aFA().a(w.a.xsg, aFM());
        } else if (!com.tencent.mm.compatible.loader.a.a(str.split(";"), r1)) {
            com.tencent.mm.plugin.ext.b.aFA().a(w.a.xsg, str + ";" + aFM());
        }
    }
}
