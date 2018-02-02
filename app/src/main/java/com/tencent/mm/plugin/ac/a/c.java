package com.tencent.mm.plugin.ac.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.g.a.on;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.a.p;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.p.a;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.c.akj;
import com.tencent.mm.protocal.c.xg;
import com.tencent.mm.protocal.c.xh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {
    public static boolean a(a aVar, l lVar, OnClickListener onClickListener, String str, int i, int i2, Runnable runnable, Bundle bundle) {
        if (aVar == null || aVar.getContext() == null) {
            x.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
            return false;
        }
        int RG = lVar.RG();
        int i3 = ((xg) lVar.gJQ.hmg.hmo).vVn;
        x.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", new Object[]{Integer.valueOf(RG), Integer.valueOf(i3)});
        x.i("MicroMsg.scanner.GetA8KeyRedirect", "source=" + i);
        Intent intent = new Intent();
        intent.putExtra("geta8key_scene", i);
        intent.putExtra("KPublisherId", "qrcode");
        intent.putExtra("prePublishId", "qrcode");
        i.CB(vg(i));
        String RE;
        String string;
        String RE2;
        Intent z;
        switch (RG) {
            case 1:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + lVar.we());
                intent.putExtra(SlookAirButtonFrequentContactAdapter.DATA, lVar.we());
                intent.putExtra("showShare", false);
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                intent.putExtra("pay_channel", vg(i));
                intent.putExtra("geta8key_session_id", lVar.RM());
                b.ifs.j(intent, aVar.getContext());
                new af(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 2:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + lVar.RE());
                Context context = aVar.getContext();
                Context context2 = aVar.getContext();
                RG = R.l.eBq;
                Object[] objArr = new Object[1];
                if (bh.ov(str)) {
                    str = lVar.RE();
                }
                objArr[0] = str;
                h.a(context, context2.getString(RG, objArr), aVar.getContext().getString(R.l.dGO), new 1(intent, lVar, i2, i, aVar), onClickListener);
                return true;
            case 3:
                RE = lVar.RE();
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: " + RE);
                if (RE == null || RE.length() == 0) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
                    return false;
                }
                string = aVar.getContext().getString(R.l.eBp);
                if (RE.startsWith("http")) {
                    string = aVar.getContext().getString(R.l.eBq, new Object[]{RE});
                }
                Uri parse = Uri.parse(RE);
                if (parse != null) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    if (bh.k(aVar.getContext(), intent2)) {
                        h.a(aVar.getContext(), string, aVar.getContext().getString(R.l.dGO), false, new 2(aVar, intent2), onClickListener);
                        return true;
                    }
                }
                return false;
            case 4:
                return false;
            case 6:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + lVar.RE());
                intent.putExtra("rawUrl", lVar.RE());
                intent.putExtra("pay_channel", vg(i));
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("isWebwx", false);
                intent.putExtra("geta8key_session_id", lVar.RM());
                intent.putExtra("geta8key_cookie", lVar.RN());
                b.ifs.j(intent, aVar.getContext());
                return true;
            case 7:
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[]{lVar.RF(), lVar.RE(), lVar.RI()});
                intent.putExtra("title", lVar.getTitle());
                intent.putExtra("rawUrl", lVar.RE());
                intent.putExtra("k_share_url", lVar.RI());
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : " + vg(i));
                intent.putExtra("pay_channel", vg(i));
                intent.putExtra("geta8key_session_id", lVar.RM());
                intent.putExtra("geta8key_cookie", lVar.RN());
                List<akj> RL = lVar.RL();
                if (!bh.cA(RL)) {
                    akj com_tencent_mm_protocal_c_akj;
                    Object obj;
                    String[] strArr;
                    String[] strArr2;
                    for (akj com_tencent_mm_protocal_c_akj2 : RL) {
                        if (com_tencent_mm_protocal_c_akj2 == null || bh.ov(com_tencent_mm_protocal_c_akj2.vNj)) {
                            x.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                                strArr = new String[RL.size()];
                                strArr2 = new String[RL.size()];
                                for (RG = 0; RG < RL.size(); RG++) {
                                    com_tencent_mm_protocal_c_akj2 = (akj) RL.get(RG);
                                    x.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[]{Integer.valueOf(RG), com_tencent_mm_protocal_c_akj2.vNj, com_tencent_mm_protocal_c_akj2.pQt});
                                    strArr[RG] = r8;
                                    strArr2[RG] = RE;
                                }
                                intent.putExtra("geta8key_result_http_header_key_list", strArr);
                                intent.putExtra("geta8key_result_http_header_value_list", strArr2);
                                intent.putExtra("k_has_http_header", true);
                            }
                        } else if (bh.ov(com_tencent_mm_protocal_c_akj2.pQt)) {
                            x.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                                strArr = new String[RL.size()];
                                strArr2 = new String[RL.size()];
                                for (RG = 0; RG < RL.size(); RG++) {
                                    com_tencent_mm_protocal_c_akj2 = (akj) RL.get(RG);
                                    x.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[]{Integer.valueOf(RG), com_tencent_mm_protocal_c_akj2.vNj, com_tencent_mm_protocal_c_akj2.pQt});
                                    strArr[RG] = r8;
                                    strArr2[RG] = RE;
                                }
                                intent.putExtra("geta8key_result_http_header_key_list", strArr);
                                intent.putExtra("geta8key_result_http_header_value_list", strArr2);
                                intent.putExtra("k_has_http_header", true);
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        strArr = new String[RL.size()];
                        strArr2 = new String[RL.size()];
                        for (RG = 0; RG < RL.size(); RG++) {
                            com_tencent_mm_protocal_c_akj2 = (akj) RL.get(RG);
                            x.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[]{Integer.valueOf(RG), com_tencent_mm_protocal_c_akj2.vNj, com_tencent_mm_protocal_c_akj2.pQt});
                            strArr[RG] = r8;
                            strArr2[RG] = RE;
                        }
                        intent.putExtra("geta8key_result_http_header_key_list", strArr);
                        intent.putExtra("geta8key_result_http_header_value_list", strArr2);
                        intent.putExtra("k_has_http_header", true);
                    }
                }
                b.ifs.j(intent, aVar.getContext());
                new af(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 8:
                string = lVar.we();
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: " + string);
                if (!bh.ov(string)) {
                    try {
                        new p().IC(string);
                        aVar.getContext().startActivity(new Intent(aVar.getContext(), VcardContactUI.class));
                        aVar.hs(false);
                        return true;
                    } catch (Throwable e) {
                        x.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e.getMessage() + " " + string);
                        x.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e, "", new Object[0]);
                    } catch (Throwable e2) {
                        x.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e2.getMessage() + " " + string);
                        x.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e2, "", new Object[0]);
                    }
                }
                h.a(aVar.getContext(), aVar.getContext().getString(R.l.eBx), aVar.getContext().getString(R.l.dGO), false, onClickListener);
                return true;
            case 9:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_scene", 5);
                return b.ifs.a(aVar.getContext(), lVar.RE(), bundle2);
            case 10:
            case 11:
                a(aVar, RG, lVar.RE(), vg(i));
                new af(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 12:
            case 15:
                a(aVar, RG, lVar.RE(), vg(i));
                return true;
            case 14:
                RE = lVar.RE();
                if (RE != null) {
                    RE = RE.replace("wxpd://", "");
                }
                intent = new Intent();
                intent.putExtra("key_product_id", RE);
                intent.putExtra("key_product_scene", 7);
                d.b(aVar.getContext(), "product", ".ui.MallProductUI", intent);
                return true;
            case 16:
                RE2 = lVar.RE();
                intent = new Intent().setClassName(ac.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
                z = bh.z(ac.getContext(), intent);
                if (z == null) {
                    z = intent;
                }
                ac.getContext().startService(z.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, RE2).putExtra("isFromWifi", true));
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
                return true;
            case 17:
                Intent intent3 = new Intent();
                intent3.putExtra("free_wifi_url", lVar.RE());
                string = "free_wifi_mid";
                xh xhVar = (xh) lVar.gJQ.hmh.hmo;
                if (xhVar == null || xhVar.vDT == null) {
                    x.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
                    RE = null;
                } else {
                    RE = xhVar.vDT;
                }
                intent3.putExtra(string, RE);
                string = "free_wifi_ssid";
                xhVar = (xh) lVar.gJQ.hmh.hmo;
                if (xhVar == null || xhVar.SSID == null) {
                    x.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
                    RE = null;
                } else {
                    RE = xhVar.SSID;
                }
                intent3.putExtra(string, RE);
                intent3.putExtra("free_wifi_source", 1);
                intent3.putExtra("free_wifi_ap_key", lVar.RE());
                ar.Hg();
                if (com.tencent.mm.z.c.CU().get(303104, null) != null) {
                    h.a(aVar.getContext(), R.l.ejC, R.l.dGO, R.l.ejR, R.l.dEn, new 3(aVar, intent3), onClickListener);
                } else {
                    d.b(aVar.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                    aVar.hs(false);
                }
                return true;
            case 18:
                a IO = com.tencent.mm.plugin.scanner.util.p.IO(lVar.RE());
                if (IO == null) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
                } else if (com.tencent.mm.plugin.scanner.util.p.nG(IO.kJO)) {
                    intent = new Intent();
                    intent.putExtra("key_card_id", IO.kJN);
                    intent.putExtra("key_card_ext", IO.fGV);
                    intent.putExtra("key_from_scene", 0);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    d.b(aVar.getContext(), "card", ".ui.CardDetailUI", intent);
                    x.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
                } else {
                    com.tencent.mm.plugin.scanner.util.p.aw(aVar.getContext(), aVar.getContext().getString(R.l.dOR));
                }
                return false;
            case 20:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + lVar.RE());
                ar.CG().a(new aa(lVar.RE()), 0);
                return true;
            case 21:
                z = new Intent();
                z.setClass(aVar.getContext(), ProductUI.class);
                z.putExtra("key_ProductUI_getProductInfoScene", 5);
                z.putExtra("key_Qrcode_Url", lVar.RE());
                aVar.getContext().startActivity(z);
                return true;
            case 22:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + lVar.RE());
                com.tencent.mm.pluginsdk.wallet.h.a(aVar.getContext(), 1, lVar.RE(), vg(i), null);
                new af(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 23:
                RE = lVar.RE();
                if (bh.ov(RE)) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
                    return true;
                }
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[]{RE});
                com.tencent.mm.sdk.b.b xVar = new com.tencent.mm.g.a.x();
                xVar.fnP.url = RE;
                com.tencent.mm.sdk.b.a.xef.m(xVar);
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
                return true;
            case 24:
                com.tencent.mm.sdk.b.b onVar = new on();
                onVar.fGv.fGw = str;
                com.tencent.mm.sdk.b.a.xef.m(onVar);
                return true;
            case 25:
                RE = lVar.RE();
                ArrayList IP = com.tencent.mm.plugin.scanner.util.p.IP(RE);
                if (IP == null || IP.size() == 0) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
                } else if (com.tencent.mm.plugin.scanner.util.p.N(IP)) {
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 0);
                    intent.putExtra("src_username", "");
                    intent.putExtra("js_url", "");
                    intent.putExtra("key_in_card_list", RE);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    d.b(aVar.getContext(), "card", ".ui.CardAddEntranceUI", intent);
                    x.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
                } else {
                    com.tencent.mm.plugin.scanner.util.p.aw(aVar.getContext(), aVar.getContext().getString(R.l.dOR));
                }
                return false;
            case 26:
                RE2 = lVar.RE();
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: " + RE2);
                Context context3 = aVar.getContext();
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: " + RE2);
                Uri parse2 = Uri.parse(RE2);
                int i4;
                if (parse2.getQueryParameter("search_query") == null || parse2.getQueryParameter("search_query").length() <= 0) {
                    if (i2 == 2) {
                        i4 = i3 == 22 ? 1048 : HardCoderJNI.FUNC_TERMINATE_APP;
                    } else if (i2 == 1) {
                        i4 = i3 == 22 ? 1049 : HardCoderJNI.FUNC_UNIFY_CPU_IO_THREAD_CORE;
                    } else {
                        i4 = i3 == 22 ? 1047 : HardCoderJNI.FUNC_REG_PRELOAD_BOOT_RESOURCE;
                    }
                    ((com.tencent.mm.plugin.appbrand.m.d) g.h(com.tencent.mm.plugin.appbrand.m.d.class)).b(context3, RE2, i4, bundle);
                } else {
                    RE = parse2.getQueryParameter("search_query");
                    String queryParameter = parse2.getQueryParameter("appid");
                    String queryParameter2 = parse2.getQueryParameter("search_extInfo");
                    int i5 = bh.getInt(parse2.getQueryParameter("debug"), 0);
                    i4 = bh.getInt(parse2.getQueryParameter("version"), 0);
                    com.tencent.mm.sdk.b.b kwVar = new kw();
                    kwVar.fCe.scene = 1;
                    kwVar.fCe.appId = queryParameter;
                    kwVar.fCe.type = i5;
                    kwVar.fCe.version = i4;
                    kwVar.fCe.fCf = RE;
                    kwVar.fCe.url = RE2;
                    kwVar.fCe.fCg = queryParameter2;
                    com.tencent.mm.sdk.b.a.xef.m(kwVar);
                    intent = com.tencent.mm.bc.b.QM();
                    intent.putExtra("ftsbizscene", 99999);
                    intent.putExtra("ftsQuery", RE);
                    intent.putExtra("ftsqrcodestring", RE2);
                    Map b = com.tencent.mm.bc.b.b(300, false, 262144);
                    b.put("query", RE);
                    RE = com.tencent.mm.plugin.aj.a.g.zH(bh.VI((String) b.get("scene")));
                    b.put("sessionid", RE);
                    intent.putExtra("rawUrl", com.tencent.mm.bc.b.r(b));
                    intent.putExtra("key_session_id", RE);
                    d.b(ac.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", intent);
                }
                aVar.hs(false);
                return true;
            default:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + lVar.RG());
                return false;
        }
    }

    private static void a(a aVar, int i, String str, int i2) {
        x.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[]{Integer.valueOf(i), str});
        com.tencent.mm.sdk.b.b gwVar = new gw();
        gwVar.fxb.actionCode = i;
        gwVar.fxb.result = str;
        gwVar.fxb.context = aVar.getContext();
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", i2);
        gwVar.fxb.fxd = bundle;
        gwVar.fqI = new 4(aVar, gwVar);
        com.tencent.mm.sdk.b.a.xef.a(gwVar, Looper.myLooper());
    }

    protected static int vg(int i) {
        if (i == 30 || i == 37 || i == 38 || i == 40) {
            return 13;
        }
        if (i == 4 || i == 47) {
            return 12;
        }
        if (i == 34) {
            return 24;
        }
        return 0;
    }
}
