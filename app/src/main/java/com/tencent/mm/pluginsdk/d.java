package com.tencent.mm.pluginsdk;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.u;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class d {
    public static String vcf = "";
    private static final Map<String, Long> vcg;

    public interface a {
        void a(int i, int i2, String str, k kVar, boolean z);
    }

    static {
        Map hashMap = new HashMap();
        vcg = hashMap;
        hashMap.put("weixin://", Long.valueOf(0));
        vcg.put("weixin://dl/stickers", Long.valueOf(1));
        vcg.put("weixin://dl/games", Long.valueOf(2));
        vcg.put("weixin://dl/moments", Long.valueOf(4));
        vcg.put("weixin://dl/add", Long.valueOf(8));
        vcg.put("weixin://dl/shopping", Long.valueOf(16));
        vcg.put("weixin://dl/groupchat", Long.valueOf(32));
        vcg.put("weixin://dl/scan", Long.valueOf(64));
        vcg.put("weixin://dl/profile", Long.valueOf(128));
        vcg.put("weixin://dl/settings", Long.valueOf(256));
        vcg.put("weixin://dl/general", Long.valueOf(512));
        vcg.put("weixin://dl/help", Long.valueOf(1024));
        vcg.put("weixin://dl/notifications", Long.valueOf(2048));
        vcg.put("weixin://dl/terms", Long.valueOf(4096));
        vcg.put("weixin://dl/chat", Long.valueOf(8192));
        vcg.put("weixin://dl/features", Long.valueOf(16384));
        vcg.put("weixin://dl/clear", Long.valueOf(32768));
        vcg.put("weixin://dl/feedback", Long.valueOf(HardCoderJNI.ACTION_ALLOC_MEMORY));
        vcg.put("weixin://dl/faq", Long.valueOf(HardCoderJNI.ACTION_NET_RX));
        vcg.put("weixin://dl/recommendation", Long.valueOf(HardCoderJNI.ACTION_NET_TX));
        vcg.put("weixin://dl/groups", Long.valueOf(524288));
        vcg.put("weixin://dl/tags", Long.valueOf(1048576));
        vcg.put("weixin://dl/officialaccounts", Long.valueOf(2097152));
        vcg.put("weixin://dl/posts", Long.valueOf(4194304));
        vcg.put("weixin://dl/favorites", Long.valueOf(8388608));
        vcg.put("weixin://dl/privacy", Long.valueOf(16777216));
        vcg.put("weixin://dl/security", Long.valueOf(33554432));
        vcg.put("weixin://dl/wallet", Long.valueOf(67108864));
        vcg.put("weixin://dl/businessPay", Long.valueOf(134217728));
        vcg.put("weixin://dl/businessPay/", Long.valueOf(134217728));
        vcg.put("weixin://dl/wechatout", Long.valueOf(268435456));
        vcg.put("weixin://dl/protection", Long.valueOf(1073741824));
        vcg.put("weixin://dl/card", Long.valueOf(2147483648L));
        vcg.put("weixin://dl/about", Long.valueOf(1125899906842624L));
        vcg.put("weixin://dl/blacklist", Long.valueOf(4294967296L));
        vcg.put("weixin://dl/textsize", Long.valueOf(8589934592L));
        vcg.put("weixin://dl/sight", Long.valueOf(17179869184L));
        vcg.put("weixin://dl/languages", Long.valueOf(34359738368L));
        vcg.put("weixin://dl/chathistory", Long.valueOf(68719476736L));
        vcg.put("weixin://dl/bindqq", Long.valueOf(137438953472L));
        vcg.put("weixin://dl/bindmobile", Long.valueOf(274877906944L));
        vcg.put("weixin://dl/bindemail", Long.valueOf(549755813888L));
        vcg.put("weixin://dl/securityassistant", Long.valueOf(1099511627776L));
        vcg.put("weixin://dl/broadcastmessage", Long.valueOf(2199023255552L));
        vcg.put("weixin://dl/setname", Long.valueOf(4398046511104L));
        vcg.put("weixin://dl/myQRcode", Long.valueOf(8796093022208L));
        vcg.put("weixin://dl/myaddress", Long.valueOf(17592186044416L));
        vcg.put("weixin://dl/hidemoments", Long.valueOf(35184372088832L));
        vcg.put("weixin://dl/blockmoments", Long.valueOf(70368744177664L));
        vcg.put("weixin://dl/stickersetting", Long.valueOf(140737488355328L));
        vcg.put("weixin://dl/log", Long.valueOf(281474976710656L));
        vcg.put("weixin://dl/wechatoutcoupon", Long.valueOf(562949953421312L));
        vcg.put("weixin://dl/wechatoutshare", Long.valueOf(18014398509481984L));
        vcg.put("weixin://dl/personalemoticon", Long.valueOf(4503599627370496L));
        vcg.put("weixin://dl/designeremoji", Long.valueOf(9007199254740992L));
        vcg.put("weixin://dl/sightdraft", Long.valueOf(576460752303423488L));
        vcg.put("weixin://dl/jumpWxa/", Long.valueOf(576460752303423489L));
    }

    public static boolean ae(String str, long j) {
        if (!bh.ov(str)) {
            long longValue;
            String Ri = Ri(str);
            if (vcg.containsKey(Ri)) {
                longValue = ((Long) vcg.get(Ri)).longValue();
            } else {
                longValue = -1;
            }
            if (longValue != -1 && (longValue == 0 || (longValue & j) == longValue)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Re(String str) {
        String Ri = Ri(str);
        return vcg.containsKey(Ri) || Rf(Ri);
    }

    public static boolean Rf(String str) {
        return !bh.ov(str) && str.startsWith("weixin://dl/business");
    }

    public static boolean j(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (bh.ov(uri.getQueryParameter("ticket"))) {
            return k(uri);
        }
        return true;
    }

    public static boolean k(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (uri.toString().startsWith("weixin://dl/business/tempsession/") || uri.toString().startsWith("weixin://dl/businessTempSession/")) {
            return true;
        }
        return false;
    }

    private static boolean Rg(String str) {
        if ((!str.equals("weixin://dl/wechatout") && !str.equals("weixin://dl/wechatoutcoupon") && !str.equals("weixin://dl/wechatoutshare")) || Boolean.valueOf(com.tencent.mm.plugin.ipcall.d.aTd()).booleanValue()) {
            return false;
        }
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName(ac.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
        ac.getContext().startActivity(intent);
        return true;
    }

    public static void a(Context context, String str, String str2, int i, String str3, a aVar) {
        String str4 = bh.ov(str) ? str3 : str;
        if (!Rg(str4)) {
            k lVar = new l(str4, str2, i, (int) System.currentTimeMillis(), new byte[0]);
            ar.CG().a(233, new 1(context, i, str2, str4, aVar));
            ar.CG().a(lVar, 0);
        }
    }

    public static void a(Context context, String str, int i, a aVar, String str2, String str3) {
        a(context, str, i, null, aVar, str2, str3);
    }

    public static void a(Context context, String str, int i, Bundle bundle, a aVar, String str2, String str3) {
        LinkedList linkedList = new LinkedList();
        cl clVar = new cl();
        if (!(bh.ov(str2) || bh.ov(str3))) {
            x.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", new Object[]{str2, str3});
            clVar.vHA = str2;
            clVar.signature = str3;
            linkedList.add(clVar);
        }
        if (!Rg(str)) {
            k akVar = new ak(str, i, linkedList);
            ar.CG().a(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, new 2(bundle, context, i, str, aVar));
            ar.CG().a(akVar, 0);
        }
    }

    public static void a(Context context, String str, int i, a aVar) {
        a(context, str, i, null, aVar, null, null);
    }

    public static void a(Context context, String str, int i, Bundle bundle, a aVar) {
        a(context, str, i, bundle, aVar, null, null);
    }

    public static boolean Rh(String str) {
        return a(null, str, 0, null, (int) System.currentTimeMillis(), new byte[0], null);
    }

    public static boolean a(Context context, int i, byte[] bArr, String str) {
        return a(context, str, 0, null, i, bArr, null);
    }

    public static boolean a(Context context, String str, int i, Bundle bundle, String str2) {
        return a(context, str, i, bundle, (int) System.currentTimeMillis(), new byte[0], str2);
    }

    private static boolean a(Context context, String str, int i, Bundle bundle, int i2, byte[] bArr, String str2) {
        String Ri = Ri(str);
        if (bh.ov(Ri)) {
            return false;
        }
        String substring;
        String encode;
        Uri parse;
        String queryParameter;
        if (vcg.containsKey(Ri)) {
            long longValue = ((Long) vcg.get(Ri)).longValue();
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, deepLinkMap contains uri, result = %d", new Object[]{Long.valueOf(longValue)});
            Ri = null;
            Intent intent = new Intent();
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (longValue == 0) {
                Ri = "com.tencent.mm.ui.LauncherUI";
            } else if (longValue == 1) {
                Ri = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                g.pQN.h(12065, new Object[]{Integer.valueOf(7)});
            } else if (longValue == 2) {
                intent.putExtra("from_deeplink", true);
                intent.putExtra("game_report_from_scene", 6);
                Ri = "com.tencent.mm.plugin.game.ui.GameCenterUI";
            } else if (longValue == 4) {
                if (((q.Gd() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0 ? 1 : null) != null) {
                    Ri = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                    intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                }
            } else if (longValue == 8) {
                Ri = "com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI";
            } else if (longValue == 16) {
                b hmVar = new hm();
                com.tencent.mm.sdk.b.a.xef.m(hmVar);
                r4 = hmVar.fxP.url;
                if (!bh.ov(r4)) {
                    intent.putExtra("rawUrl", r4);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("geta8key_session_id", i2);
                    intent.putExtra("geta8key_cookie", bArr);
                    Ri = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                }
            } else if (longValue == 32) {
                intent.putExtra("titile", ac.getContext().getString(R.l.dDn));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", s.p(new int[]{s.yTF, 256, WXMediaMessage.TITLE_LENGTH_LIMIT}));
                Ri = "com.tencent.mm.ui.contact.SelectContactUI";
            } else if (longValue == 64) {
                Ri = "com.tencent.mm.plugin.scanner.ui.BaseScanUI";
                intent.putExtra("animation_pop_in", true);
            } else if (longValue == 128) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI";
            } else if (longValue == 256) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsUI";
            } else if (longValue == 512) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == 1024) {
                Q(ac.getContext(), i2);
            } else if (longValue == 2048) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI";
            } else if (longValue == 4096) {
                intent.putExtra("title", ac.getContext().getResources().getString(R.l.eAY));
                intent.putExtra("rawUrl", ac.getContext().getResources().getString(R.l.eSl));
                intent.putExtra("showShare", false);
                intent.putExtra("geta8key_session_id", i2);
                intent.putExtra("geta8key_cookie", bArr);
                Ri = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == 8192) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI";
            } else if (longValue == 16384) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI";
            } else if (longValue == 32768) {
                Ri = "com.tencent.mm.plugin.clean.ui.CleanUI";
            } else if (longValue == HardCoderJNI.ACTION_ALLOC_MEMORY) {
                try {
                    r4 = "";
                    int indexOf = str.indexOf("?");
                    if (indexOf > 0) {
                        substring = str.substring(indexOf + 1);
                    } else {
                        substring = r4;
                    }
                    com.tencent.mm.kernel.g.Dh();
                    r4 = com.tencent.mm.kernel.a.Cg();
                    encode = URLEncoder.encode(com.tencent.mm.protocal.d.vAx, ProtocolPackage.ServerEncoding);
                    String encode2 = URLEncoder.encode(bh.cgr(), ProtocolPackage.ServerEncoding);
                    r8 = URLEncoder.encode(com.tencent.mm.compatible.d.q.yE(), ProtocolPackage.ServerEncoding);
                    String encode3 = URLEncoder.encode(com.tencent.mm.protocal.d.vAs, ProtocolPackage.ServerEncoding);
                    r10 = URLEncoder.encode(com.tencent.mm.protocal.d.vAt, ProtocolPackage.ServerEncoding);
                    r4 = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&version=" + com.tencent.mm.protocal.d.vAz + "&lang=" + w.eL(ac.getContext()) + "&" + bh.ou(substring) + ("&uin=" + r4 + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + r8 + "&deviceBrand=" + encode3 + "&deviceModel=" + r10 + "&ostype=" + URLEncoder.encode(com.tencent.mm.protocal.d.vAu, ProtocolPackage.ServerEncoding) + "&clientSeqID=" + URLEncoder.encode(ar.CB(), ProtocolPackage.ServerEncoding) + "&signature=" + URLEncoder.encode(bh.fa(ac.getContext()), ProtocolPackage.ServerEncoding) + "&scene=" + (bh.ov(substring) ? 0 : 1));
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", r4);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("geta8key_session_id", i2);
                    intent.putExtra("geta8key_cookie", bArr);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
                    Ri = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                } catch (UnsupportedEncodingException e) {
                    x.e("MicroMsg.DeepLinkHelper", "[oneliang]UnsupportedEncodingException:%s", new Object[]{e.getMessage()});
                }
            } else if (longValue == HardCoderJNI.ACTION_NET_RX) {
                com.tencent.mm.kernel.g.Dh();
                r4 = com.tencent.mm.kernel.a.Cg();
                ar.Hg();
                r2 = bh.e((Integer) c.CU().get(12304, null));
                Ri = ac.getContext().getString(R.l.eNr, new Object[]{Integer.valueOf(r4), Integer.valueOf(r2)});
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", Ri);
                intent.putExtra("geta8key_session_id", i2);
                intent.putExtra("geta8key_cookie", bArr);
                Ri = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == HardCoderJNI.ACTION_NET_TX) {
                Ri = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
            } else if (longValue == 524288) {
                Ri = "com.tencent.mm.ui.contact.ChatroomContactUI";
            } else if (longValue == 1048576) {
                Ri = "com.tencent.mm.plugin.label.ui.ContactLabelManagerUI";
            } else if (longValue == 2097152) {
                Ri = "com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI";
            } else if (longValue == 268435456) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bm.d.b(ac.getContext(), "ipcall", ".ui.IPCallAddressUI", intent);
                return true;
            } else if (longValue == 4194304) {
                ar.Hg();
                intent.putExtra("sns_userName", (String) c.CU().get(2, null));
                intent.addFlags(67108864);
                ar.Hg();
                r2 = bh.a((Integer) c.CU().get(68389, null), 0);
                ar.Hg();
                c.CU().set(68389, Integer.valueOf(r2 + 1));
                Ri = "com.tencent.mm.plugin.sns.ui.SnsUserUI";
            } else if (longValue == 8388608) {
                Ri = "com.tencent.mm.plugin.favorite.ui.FavoriteIndexUI";
            } else if (longValue == 16777216) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI";
            } else if (longValue == 33554432) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI";
            } else if (longValue == 67108864) {
                Ri = "com.tencent.mm.plugin.mall.ui.MallIndexUI";
            } else if (longValue == 134217728) {
                if (!(context == null || bh.ov(str))) {
                    if (str.startsWith("weixin://dl/businessPay")) {
                        parse = Uri.parse(str);
                        if (parse != null) {
                            r4 = parse.getQueryParameter("reqkey");
                            queryParameter = parse.getQueryParameter("appid");
                            if (bh.ov(r4)) {
                                x.w("MicroMsg.DeepLinkHelper", "reqkey null");
                            } else {
                                Parcelable payInfo = new PayInfo();
                                payInfo.fuH = r4;
                                payInfo.appId = queryParameter;
                                payInfo.fCV = 36;
                                payInfo.ncX = false;
                                intent = new Intent();
                                intent.putExtra("key_pay_info", payInfo);
                                if (q.Gf()) {
                                    com.tencent.mm.bm.d.b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent, 1);
                                } else {
                                    com.tencent.mm.bm.d.b(context, "wallet", ".pay.ui.WalletPayUI", intent, 1);
                                }
                            }
                        } else {
                            x.w("MicroMsg.DeepLinkHelper", "payUri null");
                        }
                    }
                }
                intent = null;
            } else if (longValue == 1073741824) {
                Ri = "com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI";
            } else if (longValue == 2147483648L) {
                x.i("MicroMsg.DeepLinkHelper", "enter to cardhome");
                Ri = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
            } else if (longValue == 4294967296L) {
                intent.putExtra("filter_type", com.tencent.mm.z.x.hB(ac.getContext().getString(R.l.enF)).getType());
                intent.putExtra("titile", ac.getContext().getString(R.l.eMI));
                intent.putExtra("list_attr", WXMediaMessage.THUMB_LENGTH_LIMIT);
                Ri = "com.tencent.mm.ui.contact.SelectSpecialContactUI";
            } else if (longValue == 8589934592L) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI";
            } else if (longValue == 17179869184L) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == 34359738368L) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI";
            } else if (longValue == 68719476736L) {
                Ri = "com.tencent.mm.plugin.backup.backupmoveui.BackupUI";
            } else if (longValue == 137438953472L) {
                intent.setClassName(ac.getContext(), "com.tencent.mm.ui.bindqq.BindQQUI");
                MMWizardActivity.A(context, intent);
                return true;
            } else if (longValue == 274877906944L) {
                intent.setClassName(ac.getContext(), "com.tencent.mm.ui.bindmobile.BindMContactIntroUI");
                MMWizardActivity.A(context, intent);
                return true;
            } else if (longValue == 549755813888L) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI";
            } else if (longValue == 1099511627776L) {
                com.tencent.mm.bm.d.b(ac.getContext(), "profile", ".ui.ContactInfoUI", intent.putExtra("Contact_User", "qqsync"));
                return true;
            } else if (longValue == 2199023255552L) {
                Ri = "com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI";
            } else if (longValue == 4398046511104L) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI";
            } else if (longValue == 8796093022208L) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI";
            } else if (longValue == 17592186044416L) {
                intent.putExtra("launch_from_webview", false);
                com.tencent.mm.bm.d.a(ac.getContext(), "address", ".ui.WalletSelectAddrUI", intent, true);
                return true;
            } else if (longValue == 35184372088832L) {
                intent.putExtra("k_sns_tag_id", 4);
                intent.putExtra("k_sns_from_settings_about_sns", 1);
                com.tencent.mm.bm.d.b(ac.getContext(), "sns", ".ui.SnsBlackDetailUI", intent);
                return true;
            } else if (longValue == 70368744177664L) {
                intent.putExtra("k_sns_tag_id", 5);
                intent.putExtra("k_sns_from_settings_about_sns", 2);
                intent.putExtra("k_tag_detail_sns_block_scene", 8);
                com.tencent.mm.bm.d.b(ac.getContext(), "sns", ".ui.SnsTagDetailUI", intent);
            } else if (longValue == 140737488355328L) {
                Ri = "com.tencent.mm.plugin.emoji.ui.EmojiMineUI";
            } else if (longValue == 281474976710656L) {
                b bsVar = new bs();
                bsVar.fpT.fpV = "//uplog";
                bsVar.fpT.context = ac.getContext();
                com.tencent.mm.sdk.b.a.xef.m(bsVar);
                return true;
            } else if (longValue == 562949953421312L) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bm.d.b(ac.getContext(), "ipcall", ".ui.IPCallAddressUI", intent);
                com.tencent.mm.bm.d.b(ac.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent);
                return true;
            } else if (longValue == 18014398509481984L) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bm.d.b(ac.getContext(), "ipcall", ".ui.IPCallAddressUI", intent);
                com.tencent.mm.bm.d.b(ac.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent);
                com.tencent.mm.bm.d.b(ac.getContext(), "ipcall", ".ui.IPCallShareCouponCardUI", intent);
            } else if (longValue == 576460752303423488L) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                intent.setClassName(ac.getContext(), "com.tencent.mm.plugin.sight.draft.ui.SightDraftUI");
                ac.getContext().startActivity(intent);
            } else if (longValue == 1125899906842624L) {
                Ri = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI";
            } else if (longValue == 4503599627370496L) {
                intent.putExtra("emoji_tab", 1);
                Ri = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                g.pQN.h(12065, new Object[]{Integer.valueOf(7)});
            } else if (longValue == 9007199254740992L) {
                Ri = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI";
            } else if (longValue == 576460752303423489L) {
                Uri parse2 = Uri.parse(str);
                r10 = parse2.getQueryParameter("appid");
                r4 = parse2.getQueryParameter("userName");
                r8 = parse2.getQueryParameter("path");
                int i3 = 0;
                u.b t = u.GK().t("key_data_center_session_id", false);
                if (t != null) {
                    i3 = ((Integer) t.get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
                }
                x.i("MicroMsg.DeepLinkHelper", "appid = %s, userName = %s, path = %s, translateLinkScene = %d, type = %d", new Object[]{r10, r4, r8, Integer.valueOf(i), Integer.valueOf(i3)});
                u.GK().hy("key_data_center_session_id");
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.fnp = URLEncoder.encode(str2);
                if (i == 2) {
                    appBrandStatObject.scene = 1065;
                    ((com.tencent.mm.plugin.appbrand.m.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(context, r4, null, i3, 0, r8, appBrandStatObject);
                } else if (i == 1) {
                    appBrandStatObject.scene = 1069;
                    appBrandStatObject.fnp = r10;
                    ((com.tencent.mm.plugin.appbrand.m.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(context, r4, null, i3, 0, r8, appBrandStatObject, r10);
                } else if (i == 6) {
                    appBrandStatObject.scene = 1007;
                    ((com.tencent.mm.plugin.appbrand.m.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(context, r4, null, i3, 0, r8, appBrandStatObject);
                } else if (i == 7) {
                    appBrandStatObject.scene = 1008;
                    ((com.tencent.mm.plugin.appbrand.m.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(context, r4, null, i3, 0, r8, appBrandStatObject);
                } else {
                    appBrandStatObject.scene = 1000;
                    ((com.tencent.mm.plugin.appbrand.m.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(context, r4, null, 0, 0, r8, appBrandStatObject);
                }
                return true;
            }
            if (bh.ov(Ri)) {
                return false;
            }
            intent.setClassName(ac.getContext(), Ri);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e2, "", new Object[]{""});
                }
            } else {
                ac.getContext().startActivity(intent);
                com.tencent.mm.ui.base.b.B(ac.getContext(), intent);
            }
            return true;
        } else if (Ri.startsWith("weixin://dl/businessTempSession/")) {
            r4 = new Intent();
            r4.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            parse = Uri.parse(str);
            if (parse == null) {
                x.e("MicroMsg.DeepLinkHelper", "tempsession uri is null");
                return false;
            }
            substring = parse.getQueryParameter("sessionFrom");
            encode = parse.getQueryParameter("showtype");
            Ri = parse.getQueryParameter("username");
            if (bh.ov(Ri)) {
                Ri = parse.getQueryParameter("userName");
            }
            if (bh.ov(Ri)) {
                x.e("MicroMsg.DeepLinkHelper", "tempsession user is null");
                return false;
            }
            int i4 = bh.getInt(bh.ou(parse.getQueryParameter("scene")), 0);
            if (i4 != 0 && i == 4) {
                x.i("MicroMsg.DeepLinkHelper", "Jsapi assign scene to " + i4);
                i = i4;
            }
            x.i("MicroMsg.DeepLinkHelper", "tempsession jump, %s, %s, %s, %s, %s.", new Object[]{Ri, substring, Integer.valueOf(i), str, encode});
            r4.setClassName(ac.getContext(), "com.tencent.mm.ui.chatting.ChattingUI");
            r4.putExtra("Chat_User", Ri);
            r4.putExtra("finish_direct", true);
            r4.putExtra("key_is_temp_session", true);
            r4.putExtra("key_temp_session_from", substring);
            r4.putExtra("key_temp_session_scene", i);
            r4.putExtra("key_temp_session_show_type", bh.getInt(encode, 0));
            ar.Hg();
            com.tencent.mm.l.a WO = c.EY().WO(Ri);
            if (WO == null || ((int) WO.gJd) <= 0) {
                com.tencent.mm.z.ak.a.hfL.a(Ri, "", new 3(r4, context));
            } else {
                context.startActivity(r4);
            }
            return true;
        } else if (Ri.startsWith("weixin://dl/businessGame/detail/") || Ri.startsWith("weixin://dl/businessGame/detail")) {
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_DETAIL");
            parse = Uri.parse(str);
            Ri = null;
            r4 = new Intent();
            if (parse != null) {
                Ri = "com.tencent.mm.plugin.game.ui.GameDetailUI";
                r4.putExtra("game_app_id", parse.getQueryParameter("appid"));
                r4.putExtra("game_report_from_scene", 6);
            }
            if (bh.ov(Ri)) {
                return false;
            }
            r4.setClassName(ac.getContext(), Ri);
            if (context != null) {
                try {
                    context.startActivity(r4);
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e22, "", new Object[]{""});
                }
            } else {
                ac.getContext().startActivity(r4);
                com.tencent.mm.ui.base.b.B(ac.getContext(), r4);
            }
            return true;
        } else if (Ri.startsWith("weixin://dl/businessGame/library/") || Ri.startsWith("weixin://dl/businessGame/library")) {
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_LIBRARY");
            Intent intent2 = new Intent();
            queryParameter = "com.tencent.mm.plugin.game.ui.GameLibraryUI";
            if (bh.ov(queryParameter)) {
                return false;
            }
            intent2.putExtra("game_report_from_scene", 6);
            intent2.setClassName(ac.getContext(), queryParameter);
            if (context != null) {
                try {
                    context.startActivity(intent2);
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e222, "", new Object[]{""});
                }
            } else {
                ac.getContext().startActivity(intent2);
                com.tencent.mm.ui.base.b.B(ac.getContext(), intent2);
            }
            return true;
        } else if (!Ri.startsWith("weixin://dl/businessWebview/link/") && !Ri.startsWith("weixin://dl/businessWebview/link")) {
            return false;
        } else {
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith H5_LINK");
            parse = Uri.parse(str);
            r4 = new Intent();
            Ri = null;
            if (parse != null) {
                x.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, translateLinkScene: %s", new Object[]{parse.getQueryParameter(SlookSmartClipMetaTag.TAG_TYPE_URL), Integer.valueOf(i)});
                Ri = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                r4.putExtra("rawUrl", queryParameter);
                r4.putExtra("geta8key_session_id", i2);
                r4.putExtra("geta8key_cookie", bArr);
                r4.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (i == 1) {
                    r4.putExtra("show_openapp_dialog", false);
                    r4.putExtra("pay_channel", 40);
                    i.CB(39);
                } else if (i == 2) {
                    r4.putExtra("pay_channel", 39);
                    i.CB(39);
                }
                r4.putExtra("transaction_for_openapi_openwebview", vcf);
                if (bundle != null) {
                    r4.putExtras(bundle);
                }
            }
            if (bh.ov(Ri)) {
                return false;
            }
            r4.setClassName(ac.getContext(), Ri);
            if (context != null) {
                try {
                    context.startActivity(r4);
                } catch (Throwable e2222) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e2222, "", new Object[]{""});
                }
            } else {
                ac.getContext().startActivity(r4);
                com.tencent.mm.ui.base.b.B(ac.getContext(), r4);
            }
            return true;
        }
    }

    public static void dZ(Context context) {
        Q(context, (int) System.currentTimeMillis());
    }

    private static void Q(Context context, int i) {
        String string;
        if (!f.xeD && w.cfi().equals("zh_CN")) {
            string = context.getString(R.l.eXt);
        } else if (w.cfi().equals("zh_HK")) {
            string = context.getString(R.l.eXu);
        } else if (w.cfi().equals("zh_TW")) {
            string = context.getString(R.l.eXv);
        } else {
            string = context.getString(R.l.eXw);
        }
        x.d("MicroMsg.DeepLinkHelper", "using faq webpage");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("show_feedback", false);
        intent.putExtra("geta8key_session_id", i);
        com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    private static String Ri(String str) {
        if (bh.ov(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() + "://" + parse.getHost() + parse.getPath();
    }

    public static void v(Context context, String str, String str2) {
        if (!Rg(str2)) {
            ProgressDialog a = h.a(context, "", true, null);
            int i = 6;
            if (!bh.ov(str)) {
                if (com.tencent.mm.z.s.eV(str)) {
                    i = 7;
                } else if (com.tencent.mm.z.s.gF(str)) {
                    i = 9;
                }
            }
            a(context, str2, i, new 4(a, context));
        }
    }

    public static void aT(Context context, String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
        } else if (str.startsWith("weixin://dl/login/phone_view")) {
            Uri parse = Uri.parse(str);
            x.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", new Object[]{parse.getQueryParameter("cc"), parse.getQueryParameter("num")});
            Intent intent = new Intent();
            intent.putExtra("input_country_code", r1);
            intent.putExtra("input_mobile_number", r0);
            intent.putExtra("from_deep_link", true);
            intent.putExtra("mobile_input_purpose", 1);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bm.d.b(context, "accountsync", "com.tencent.mm.ui.account.mobile.MobileInputUI", intent);
        } else if (str.startsWith("weixin://dl/login/common_view")) {
            x.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", new Object[]{Uri.parse(str).getQueryParameter("username")});
            Intent intent2 = new Intent();
            intent2.putExtra("login_username", r0);
            intent2.putExtra("from_deep_link", true);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bm.d.b(context, "accountsync", "com.tencent.mm.ui.account.LoginUI", intent2);
        } else {
            x.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", new Object[]{str});
        }
    }
}
