package com.tencent.mm.plugin.offline.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bm.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.s$f;
import com.tencent.mm.plugin.offline.h;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders$DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bd;
import d.a.a.b;
import d.a.a.c;
import d.a.a.e;
import d.a.a.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static String kIw = "";
    private static String oZk = "";
    public static String oZl = "";
    public static int oZm = 1;
    public static String oZn = "";
    public static String oZo = "";
    public static String oZp = "";
    public static int oZq = 1;
    public static int oZr = 0;
    public static long oZs = 0;
    public static boolean oZt = false;
    public static String oZu = "";
    public static String oZv = "";
    private static Comparator<Bankcard> oZw = new 5();
    private static Comparator<a> oZx = new 6();

    public static class a {
        public String oZA;
        public String oZB;
        public int oZy;
        public String oZz;
    }

    public static boolean bhH() {
        k.bgX();
        String un = k.un(196630);
        return un != null && un.equals("1");
    }

    public static boolean bhI() {
        k.bgX();
        String un = k.un(196641);
        return un != null && un.equals("1");
    }

    public static Bankcard bhJ() {
        Bankcard bankcard;
        Object bhR = bhR();
        x.i("MicroMsg.WalletOfflineUtil", "step 1 getSelectedBindBankCard %s", new Object[]{bhR});
        List jJ = o.bLq().jJ(true);
        int i = 0;
        while (!TextUtils.isEmpty(bhR) && i < jJ.size()) {
            bankcard = (Bankcard) jJ.get(i);
            if (bankcard != null && bhR.equals(bankcard.field_bindSerial)) {
                x.i("MicroMsg.WalletOfflineUtil", "step 2 micropay: %s, forbidword: %s", new Object[]{Boolean.valueOf(bankcard.field_support_micropay), bankcard.field_forbidWord});
                if (bankcard.field_support_micropay) {
                    return bankcard;
                }
            }
            i++;
        }
        x.i("MicroMsg.WalletOfflineUtil", "step 3 clear default bindserial");
        GU("");
        bankcard = bhL();
        if (bankcard == null || !bh.ov(bankcard.field_forbidWord)) {
            i = 0;
            while (i < jJ.size()) {
                bankcard = (Bankcard) jJ.get(i);
                if (bankcard == null || !bankcard.field_support_micropay || bankcard.bKP()) {
                    i++;
                } else {
                    x.i("MicroMsg.WalletOfflineUtil", "do change first card: %s", new Object[]{bankcard.field_bankcardType});
                    return bankcard;
                }
            }
            bankcard = o.bLq().szU;
            if (bankcard == null || !bankcard.field_support_micropay) {
                bankcard = o.bLq().sQf;
                if (bankcard == null || !bankcard.field_support_micropay || !bh.ov(bankcard.field_forbidWord)) {
                    return null;
                }
                x.i("MicroMsg.WalletOfflineUtil", "do change balance: %s", new Object[]{bankcard.field_bankcardType});
                return bankcard;
            }
            x.i("MicroMsg.WalletOfflineUtil", "do change balance: %s", new Object[]{bankcard.field_bankcardType});
            return bankcard;
        }
        x.i("MicroMsg.WalletOfflineUtil", "do change main card: %s", new Object[]{bankcard.field_bankcardType});
        return bankcard;
    }

    public static Bankcard bhK() {
        Bankcard bhJ = bhJ();
        if (bhJ != null && bhJ.field_support_micropay && bh.ov(bhJ.field_forbidWord)) {
            return bhJ;
        }
        List jB = o.bLq().jB(true);
        for (int i = 0; i < jB.size(); i++) {
            bhJ = (Bankcard) jB.get(i);
            if (bhJ != null && bhJ.field_support_micropay) {
                return bhJ;
            }
        }
        return null;
    }

    public static Bankcard bhL() {
        Bankcard a = o.bLq().a(null, null, true, true);
        if (a == null) {
            x.e("MicroMsg.WalletOfflineUtil", "defaultBankcards == null");
        }
        return a;
    }

    public static int bhM() {
        return o.bLq().jB(true).size();
    }

    public static List<Bankcard> hf(boolean z) {
        List<Bankcard> arrayList = new ArrayList();
        List jB = o.bLq().jB(true);
        for (int i = 0; i < jB.size(); i++) {
            Bankcard bankcard = (Bankcard) jB.get(i);
            if (z) {
                arrayList.add(bankcard);
            } else {
                arrayList.add(bankcard);
            }
        }
        x.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + arrayList.size());
        return arrayList;
    }

    public static List<Bankcard> bhN() {
        List<Bankcard> arrayList = new ArrayList();
        List jJ = o.bLq().jJ(true);
        for (int i = 0; i < jJ.size(); i++) {
            arrayList.add((Bankcard) jJ.get(i));
        }
        x.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + arrayList.size());
        return arrayList;
    }

    public static int bhO() {
        k.bgX();
        String un = k.un(196629);
        if (TextUtils.isEmpty(un) || !wP(un)) {
            return 0;
        }
        return Integer.valueOf(un).intValue();
    }

    public static void ur(int i) {
        k.bgX();
        k.au(196640, String.valueOf(i));
    }

    public static void us(int i) {
        k.bgX();
        k.au(196642, String.valueOf(i));
    }

    public static String bhP() {
        k.bgX();
        return k.un(196632);
    }

    public static String bhQ() {
        k.bgX();
        return k.un(196631);
    }

    public static void GT(String str) {
        k.bgX();
        k.au(196631, str);
    }

    public static void dm(Context context) {
        String cfi = w.cfi();
        if ("zh_CN".equals(cfi)) {
            cfi = context.getString(i.uOB);
        } else if ("zh_TW".equals(cfi)) {
            cfi = context.getString(i.uOE);
        } else if ("zh_HK".equals(cfi)) {
            cfi = context.getString(i.uOD);
        } else {
            cfi = context.getResources().getString(i.uOC);
        }
        as(context, cfi);
    }

    private static void as(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    public static boolean wP(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static String bhR() {
        k.bgX();
        return k.un(196633);
    }

    public static void GU(String str) {
        x.i("MicroMsg.WalletOfflineUtil", "setSelectBindSerial %s %s", new Object[]{str, bh.cgy().toString()});
        k.bgX();
        k.au(196633, str);
    }

    public static void bhS() {
        x.i("MicroMsg.WalletOfflineUtil", "clear offline data");
        k.bgX();
        k.au(196630, "0");
        k.bgX();
        k.au(196626, "");
        k.bgX();
        k.au(196627, "");
        k.bgX();
        k.au(196628, "");
        k.bgX();
        k.au(196617, "");
        k.bgX();
        k.au(196632, "");
        k.bgX();
        k.au(196641, "");
        k.bgX();
        k.au(196647, "");
        k.bgX();
        k.au(196649, "");
        k("", "", "", "");
        k.bgX();
        k.au(196629, new StringBuilder("0").toString());
        GT("");
        k.bgX();
        k.bgY().oXc = null;
        k.bgX();
        k.bha();
        k.bgX();
        String un = k.un(196617);
        com.tencent.mm.wallet_core.c.a.cBn();
        com.tencent.mm.wallet_core.c.a.clearToken(un);
        GY("");
        GV("");
    }

    public static void a(Activity activity, s$f com_tencent_mm_plugin_offline_a_s_f) {
        x.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
        if (com_tencent_mm_plugin_offline_a_s_f == null || com_tencent_mm_plugin_offline_a_s_f.oXr == null) {
            x.e("MicroMsg.WalletOfflineUtil", "order == null");
        } else if (bhI()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_orders", com_tencent_mm_plugin_offline_a_s_f.oXr);
            bundle.putInt("key_pay_type", 2);
            if (com_tencent_mm_plugin_offline_a_s_f.fLm != null) {
                Parcelable realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(com_tencent_mm_plugin_offline_a_s_f.fLm.fKP, com_tencent_mm_plugin_offline_a_s_f.fLm.fKQ, com_tencent_mm_plugin_offline_a_s_f.fLm.fKR, com_tencent_mm_plugin_offline_a_s_f.fLm.fKS, com_tencent_mm_plugin_offline_a_s_f.fLm.fKT, 8);
                bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            }
            com.tencent.mm.wallet_core.a.a(activity, j.class, bundle);
        }
    }

    public static Orders K(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Orders orders = new Orders();
        Commodity commodity = new Commodity();
        commodity.pal = (String) map.get(".sysmsg.paymsg.user_roll.buy_uin");
        commodity.pam = (String) map.get(".sysmsg.paymsg.user_roll.buy_name");
        commodity.pan = (String) map.get(".sysmsg.paymsg.user_roll.sale_uin");
        commodity.pao = (String) map.get(".sysmsg.paymsg.user_roll.sale_name");
        commodity.fuI = (String) map.get(".sysmsg.paymsg.user_roll.trans_id");
        commodity.desc = (String) map.get(".sysmsg.paymsg.user_roll.goods_name");
        commodity.ljg = ((double) bh.getInt((String) map.get(".sysmsg.paymsg.user_roll.pay_num"), -1)) / 100.0d;
        commodity.pas = (String) map.get(".sysmsg.paymsg.user_roll.trade_state");
        commodity.pat = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        commodity.pax = (String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name");
        commodity.paE = (String) map.get(".sysmsg.paymsg.user_roll.discount");
        commodity.pav = bh.getInt((String) map.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
        commodity.paz = (String) map.get(".sysmsg.paymsg.user_roll.fee_type");
        commodity.paA = (String) map.get(".sysmsg.paymsg.user_roll.appusername");
        commodity.pac = (String) map.get(".sysmsg.paymsg.user_roll.app_telephone");
        commodity.sOk = ((double) bh.getInt((String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1)) / 100.0d;
        Promotions promotions = new Promotions();
        promotions.name = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname");
        promotions.paA = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username");
        promotions.type = Orders.sOi;
        commodity.sOl = promotions.paA;
        promotions.peY = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url");
        promotions.url = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url");
        int i = bh.getInt((String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
        commodity.sNN = i;
        commodity.sOo = (String) map.get(".sysmsg.paymsg.user_roll.rateinfo");
        commodity.sOp = (String) map.get(".sysmsg.paymsg.user_roll.discount_rateinfo");
        commodity.sOq = (String) map.get(".sysmsg.paymsg.user_roll.original_feeinfo");
        if (!bh.ov(promotions.name)) {
            commodity.sOt = true;
            commodity.sOs.add(promotions);
        }
        for (int i2 = 0; i2 < 255; i2++) {
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            Promotions promotions2 = new Promotions();
            if (i2 == 0) {
                str = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.icon");
                str2 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.wording");
                str3 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.url");
                str4 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.btn_text");
                str5 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.type");
                str6 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.title");
                str7 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_type");
                str8 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_id");
                str9 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.send_record_id");
                str10 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.award_id");
                str11 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.user_record_id");
                str12 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.small_title");
                str13 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_username");
                str14 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_path");
                str15 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_mch_id");
                str16 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_version");
                str17 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.get_award_params");
                str18 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.query_award_status_params");
            } else {
                str = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".icon");
                str2 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".wording");
                str3 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".url");
                str4 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".btn_text");
                str5 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".type");
                str6 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".title");
                str7 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_type");
                str8 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_id");
                str9 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".send_record_id");
                str10 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".award_id");
                str11 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".user_record_id");
                str12 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".small_title");
                str13 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_tinyapp_username");
                str14 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_tinyapp_path");
                str15 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_mch_id");
                str16 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + ".activity_tinyapp_version");
                str17 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + "get_award_params");
                str18 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i2 + "query_award_status_params");
            }
            if (bh.ov(str2)) {
                x.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[]{Integer.valueOf(i2 + 1)});
                break;
            }
            promotions2.peY = str;
            promotions2.name = str2;
            promotions2.url = str3;
            promotions2.sNx = str4;
            promotions2.type = Orders.sOj;
            promotions2.sOA = bh.getInt(str5, 0);
            promotions2.title = str6;
            promotions2.sOB = bh.getInt(str7, 0);
            promotions2.sIr = bh.getLong(str8, 0);
            promotions2.sNu = bh.getInt(str9, 0);
            promotions2.sOC = bh.getInt(str10, 0);
            promotions2.sNv = bh.getInt(str11, 0);
            promotions2.sOD = str12;
            promotions2.sOE = str13;
            promotions2.sOF = str14;
            promotions2.sNw = bh.getLong(str15, 0);
            promotions2.sOG = bh.getInt(str16, 0);
            promotions2.sOH = str17;
            promotions2.sOI = str18;
            b b = b(map, i2);
            if (b != null) {
                promotions2.sOJ = b;
            }
            commodity.sOs.add(promotions2);
        }
        str = (String) map.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
        str2 = (String) map.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
        commodity.sOu.text = str;
        commodity.sOu.url = str2;
        str = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
        str2 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
        str3 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
        str4 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
        str5 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
        if (!(bh.ov(str) || bh.ov(str2) || bh.ov(str3) || bh.ov(str4))) {
            commodity.sOr = new RecommendTinyAppInfo();
            commodity.sOr.sNz = str;
            commodity.sOr.sNA = str2;
            commodity.sOr.sNB = str3;
            commodity.sOr.sAb = str4;
            commodity.sOr.sAc = str5;
            commodity.sOr.sNC = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text");
            commodity.sOr.sOK = bh.getLong((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0);
            commodity.sOr.sOL = bh.getLong((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0);
            commodity.sOr.sON = bh.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
            commodity.sOr.sOO = bh.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
            commodity.sOr.sOP = (long) bh.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
            commodity.sOr.sOM = (long) bh.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
            commodity.sOr.sND = bh.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
        }
        orders.sNW = new ArrayList();
        orders.sNW.add(commodity);
        orders.sOg = bh.getInt((String) map.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
        orders.sOh = (String) map.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording");
        orders.sNP = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        orders.sNN = i;
        orders.fuH = (String) map.get(".sysmsg.req_key");
        commodity.sOk = bh.getDouble((String) map.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0d) / 100.0d;
        if (TextUtils.isEmpty((String) map.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
            x.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
        } else {
            int i3 = 0;
            while (true) {
                if (i3 == 0) {
                    str = "";
                } else {
                    str = String.valueOf(i3);
                }
                str3 = ".sysmsg.paymsg.user_roll.discount_array.record" + str + ".favor_desc";
                str4 = ".sysmsg.paymsg.user_roll.discount_array.record" + str + ".payment_amount";
                if (TextUtils.isEmpty((CharSequence) map.get(str3)) || TextUtils.isEmpty((CharSequence) map.get(str4))) {
                    x.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
                } else {
                    Orders$DiscountInfo orders$DiscountInfo = new Orders$DiscountInfo();
                    orders$DiscountInfo.pKc = (String) map.get(str3);
                    orders$DiscountInfo.sOz = bh.getDouble((String) map.get(str4), 0.0d);
                    commodity.sOn.add(orders$DiscountInfo);
                    i3++;
                }
            }
            x.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
        }
        return orders;
    }

    private static b b(Map<String, String> map, int i) {
        String str;
        if (i == 0) {
            str = ".sysmsg.paymsg.user_roll.activity_info.record.exposure_info.";
        } else {
            str = ".sysmsg.paymsg.user_roll.activity_info.record" + i + ".exposure_info.";
        }
        if (map == null) {
            return null;
        }
        b bVar = new b();
        bVar.Avf = bh.getInt((String) map.get(str + "is_query_others"), 0);
        bVar.vZA = (String) map.get(str + "draw_lottery_params");
        bVar.wbu = bh.getInt((String) map.get(str + "is_show_btn"), 0);
        bVar.wbv = new d.a.a.a();
        String str2 = str + "btn_info.";
        bVar.wbv.Avb = (String) map.get(str2 + "btn_words");
        bVar.wbv.Avc = (String) map.get(str2 + "btn_color");
        bVar.wbv.Avd = bh.getInt((String) map.get(str2 + "btn_op_type"), 0);
        bVar.wbv.url = (String) map.get(str2 + SlookSmartClipMetaTag.TAG_TYPE_URL);
        bVar.wbv.wme = (String) map.get(str2 + "get_lottery_params");
        str2 = str2 + "mini_app_info.";
        bVar.wbv.Ave = new e();
        bVar.wbv.Ave.wDr = (String) map.get(str2 + "activity_tinyapp_username");
        bVar.wbv.Ave.wDs = (String) map.get(str2 + "activity_tinyapp_path");
        bVar.wbv.Ave.wDt = bh.getInt((String) map.get(str2 + "activity_tinyapp_version"), 0);
        bVar.Avg = bh.getInt((String) map.get(str + "user_opertaion_type"), 0);
        bVar.Avh = bh.getInt((String) map.get(str + "is_show_layer"), 0);
        bVar.Avj = (String) map.get(str + "background_img_whole");
        bVar.wbt = new LinkedList();
        for (int i2 = 0; i2 < 255; i2++) {
            if (i2 == 0) {
                str2 = str + "single_exposure_info_list.record";
            } else {
                str2 = str + "single_exposure_info_list.record" + i2 + ".";
            }
            f fVar = new f();
            fVar.peY = (String) map.get(str2 + "logo");
            fVar.Avt = (String) map.get(str2 + "award_name");
            fVar.Avu = (String) map.get(str2 + "award_description");
            fVar.Avv = (String) map.get(str2 + "background_img");
            fVar.Avw = (String) map.get(str2 + "award_name_color");
            fVar.Avx = (String) map.get(str2 + "award_description_color");
            if (!(bh.ov(fVar.peY) && bh.ov(fVar.Avt) && bh.ov(fVar.Avu) && bh.ov(fVar.Avv) && bh.ov(fVar.Avw) && bh.ov(fVar.Avx))) {
                bVar.wbt.add(fVar);
            }
            if (bh.ov(fVar.Avt) || bh.ov(fVar.Avu)) {
                break;
            }
        }
        bVar.Avi = new d.a.a.d();
        str2 = str + "layer_info.";
        bVar.Avi.Avk = (String) map.get(str2 + "layer_title");
        bVar.Avi.Avl = (String) map.get(str2 + "layer_logo");
        bVar.Avi.Avm = (String) map.get(str2 + "layer_type");
        bVar.Avi.Avn = (String) map.get(str2 + "layer_name");
        bVar.Avi.Avo = (String) map.get(str2 + "layer_description");
        bVar.Avi.Avp = bh.getInt((String) map.get(str2 + "is_show_layer_btn"), 0);
        bVar.Avi.Avq = new c();
        String str3 = str2 + "layer_btn_info.";
        bVar.Avi.Avq.Avb = (String) map.get(str3 + "btn_words");
        bVar.Avi.Avq.Avc = (String) map.get(str3 + "btn_color");
        bVar.Avi.Avq.Avd = bh.getInt((String) map.get(str3 + "btn_op_type"), 0);
        bVar.Avi.Avq.wme = (String) map.get(str3 + "get_lottery_params");
        bVar.Avi.Avq.url = (String) map.get(str3 + SlookSmartClipMetaTag.TAG_TYPE_URL);
        str3 = str3 + "mini_app_info.";
        bVar.Avi.Avq.Ave = new e();
        bVar.Avi.Avq.Ave.wDr = (String) map.get(str3 + "activity_tinyapp_username");
        bVar.Avi.Avq.Ave.wDs = (String) map.get(str3 + "activity_tinyapp_path");
        bVar.Avi.Avq.Ave.wDt = bh.getInt((String) map.get(str3 + "activity_tinyapp_version"), 0);
        if (!bh.ov((String) map.get(str2 + "voice_url"))) {
            bVar.Avi.Avr = new com.tencent.mm.bq.b(((String) map.get(str2 + "voice_url")).getBytes());
        }
        if (!bh.ov((String) map.get(str2 + "voice_data"))) {
            bVar.Avi.Avs = new com.tencent.mm.bq.b(((String) map.get(str2 + "voice_data")).getBytes());
        }
        return bVar;
    }

    public static void a(Activity activity, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.WalletOfflineUtil", "transid == null");
        } else if (bhI()) {
            Bundle bundle = new Bundle();
            if (kVar instanceof com.tencent.mm.plugin.offline.a.e) {
                Parcelable parcelable = ((com.tencent.mm.plugin.offline.a.e) kVar).oWt;
                if (parcelable != null) {
                    bundle.putParcelable("key_realname_guide_helper", parcelable);
                }
            }
            bundle.putString("key_trans_id", str);
            bundle.putInt("key_pay_type", 2);
            com.tencent.mm.wallet_core.a.a(activity, j.class, bundle);
        }
    }

    public static void f(Activity activity, int i) {
        a(activity, i, -1);
    }

    public static void a(Activity activity, int i, int i2) {
        Parcelable payInfo = new PayInfo();
        payInfo.fCW = 5;
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 5);
        bundle.putInt("key_offline_add_fee", i);
        if (i2 >= 0) {
            bundle.putInt("key_entry_scene", i2);
        }
        if (!o.bLq().bLM()) {
            if (o.bLq().bLJ()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.d.class, bundle);
                return;
            } else if (o.bLq().bLN()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.d.class, bundle);
                return;
            }
        }
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.c.class, bundle);
    }

    public static void g(Activity activity, int i) {
        a(activity, "create", activity.getString(i.uXH), 0, i);
    }

    private static void a(Activity activity, String str, String str2, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("oper", str);
        bundle.putInt("offline_chg_fee", i);
        bundle.putString("pwd_tips", str2);
        if (i2 >= 0) {
            bundle.putInt("offline_from_scene", i2);
        }
        com.tencent.mm.wallet_core.a.a(activity, h.class, bundle);
    }

    public static void D(Activity activity) {
        a(activity, "freeze", activity.getString(i.uXK), 0, -1);
    }

    public static void E(Activity activity) {
        h(activity, -1);
    }

    public static void h(Activity activity, int i) {
        String str = "create";
        String str2 = "";
        k.bgX();
        String un = k.un(196640);
        int intValue = (TextUtils.isEmpty(un) || !wP(un)) ? 0 : Integer.valueOf(un).intValue();
        a(activity, str, str2, intValue > 0 ? intValue * 100 : HardCoderJNI.sHCENCODEVIDEOTIMEOUT, i);
    }

    public static void c(final Activity activity, String str) {
        com.tencent.mm.ui.base.h.a(activity, false, str, "", activity.getString(i.uXP), activity.getString(i.dEn), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                a.bhS();
                a.E(activity);
                activity.finish();
            }
        }, new 2(activity));
    }

    public static void bhT() {
        k.bgX();
        k.au(196643, "1");
    }

    public static void ut(int i) {
        k.bgX();
        k.au(196644, String.valueOf(i));
    }

    public static int bhU() {
        k.bgX();
        String un = k.un(196644);
        if (TextUtils.isEmpty(un) || !wP(un)) {
            return 0;
        }
        return Integer.valueOf(un).intValue();
    }

    public static String bhV() {
        if (!TextUtils.isEmpty(oZk)) {
            return oZk;
        }
        bhY();
        if (TextUtils.isEmpty(oZk)) {
            x.e("MicroMsg.WalletOfflineUtil", "token is null");
        }
        return oZk;
    }

    public static void k(String str, String str2, String str3, String str4) {
        oZk = str;
        oZl = str2;
        oZn = str3;
        oZo = str4;
        GV(oZn);
        g.Di().gPJ.a(new bd(new com.tencent.mm.z.bd.a() {
            public final void a(com.tencent.mm.network.e eVar) {
                if (eVar != null && eVar.Kx() != null) {
                    if (a.oZk != null) {
                        eVar.Kx().g("offline_token", a.oZk.getBytes());
                    }
                    if (a.oZl != null) {
                        eVar.Kx().g("offline_token_V2", a.oZl.getBytes());
                    }
                    if (a.oZo != null) {
                        eVar.Kx().g("offline_key_list", a.oZo.getBytes());
                    }
                }
            }
        }), 0);
    }

    public static String bhW() {
        if (!TextUtils.isEmpty(oZl)) {
            return oZl;
        }
        bhY();
        if (TextUtils.isEmpty(oZl)) {
            x.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
        }
        return oZl;
    }

    public static String bhX() {
        if (!TextUtils.isEmpty(oZn)) {
            return oZn;
        }
        if (TextUtils.isEmpty(oZn)) {
            k.bgX();
            String un = k.un(196656);
            oZn = un;
            return un;
        }
        if (TextUtils.isEmpty(oZn)) {
            x.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
        }
        return oZn;
    }

    public static void GV(String str) {
        k.bgX();
        k.au(196656, str);
        oZn = str;
    }

    private static void bhY() {
        g.Di().gPJ.a(new bd(new 4()), 0);
    }

    public static LinkedList<a> GW(String str) {
        LinkedList<a> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = o(new JSONArray(str));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    private static LinkedList<a> o(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return null;
        }
        LinkedList<a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                a aVar = new a();
                aVar.oZy = jSONObject.optInt("card_id");
                aVar.oZz = jSONObject.optString("bank_type");
                aVar.oZA = jSONObject.optString("bind_serial");
                aVar.oZB = jSONObject.optString("forbid_word");
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    public static String bhZ() {
        k.bgX();
        return k.un(196647);
    }

    private static String bia() {
        k.bgX();
        return k.un(196616);
    }

    public static void GX(String str) {
        k.bgX();
        k.au(196616, str);
    }

    public static void F(Activity activity) {
        com.tencent.mm.ui.base.h.bu(activity, activity.getResources().getString(i.uXI));
        if (!TextUtils.isEmpty(bia())) {
            as(activity, bia());
        }
    }

    public static boolean bib() {
        int i = 0;
        List jB = o.bLq().jB(true);
        LinkedList GW = GW(bhX());
        if (GW == null || jB.size() != GW.size()) {
            return false;
        }
        Collections.sort(GW, oZx);
        Collections.sort(jB, oZw);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < GW.size(); i2++) {
            stringBuilder.append(((a) GW.get(i2)).oZA);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        while (i < jB.size()) {
            stringBuilder2.append(((Bankcard) jB.get(i)).field_bindSerial);
            i++;
        }
        return ab.UZ(stringBuilder.toString()).equals(ab.UZ(stringBuilder2.toString()));
    }

    private static String bic() {
        if (!TextUtils.isEmpty(oZp)) {
            return oZp;
        }
        k.bgX();
        String un = k.un(196615);
        oZp = un;
        return un;
    }

    public static void GY(String str) {
        k.bgX();
        k.au(196615, str);
        oZp = str;
    }

    private static LinkedList<b> GZ(String str) {
        LinkedList<b> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = p(new JSONArray(str));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    private static LinkedList<b> p(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return null;
        }
        LinkedList<b> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                b bVar = new b();
                bVar.oZz = jSONObject.optString("bank_type");
                bVar.oZC = jSONObject.optString("icon_url");
                linkedList.add(bVar);
            }
        }
        return linkedList;
    }

    public static int bid() {
        k.bgX();
        String un = k.un(196649);
        if (TextUtils.isEmpty(un) || !wP(un)) {
            return 0;
        }
        return Integer.valueOf(un).intValue();
    }

    public static boolean bie() {
        Object bhP = bhP();
        if (TextUtils.isEmpty(bhP)) {
            return false;
        }
        if ((System.currentTimeMillis() / 1000) - Long.valueOf(bhP).longValue() >= ((long) bid())) {
            return true;
        }
        return false;
    }

    public static String Ha(String str) {
        LinkedList GZ = GZ(bic());
        if (GZ == null) {
            return "";
        }
        String str2 = "";
        for (int i = 0; i < GZ.size(); i++) {
            b bVar = (b) GZ.get(i);
            if (bVar != null && str.equals(bVar.oZz)) {
                return bVar.oZC;
            }
        }
        return str2;
    }

    public static String Hb(String str) {
        int i = 0;
        LinkedList GW = GW(bhX());
        LinkedList GZ = GZ(bic());
        if (GW == null || GZ == null || GW.size() == 0 || GZ.size() == 0) {
            x.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
            return "";
        }
        String str2 = "";
        for (int i2 = 0; i2 < GW.size(); i2++) {
            a aVar = (a) GW.get(i2);
            if (aVar != null && str.equals(aVar.oZA)) {
                Object obj = aVar.oZz;
                break;
            }
        }
        String str3 = str2;
        if (TextUtils.isEmpty(obj)) {
            x.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
            return "";
        }
        str2 = "";
        while (i < GZ.size()) {
            b bVar = (b) GZ.get(i);
            if (bVar != null && obj.equals(bVar.oZz)) {
                return bVar.oZC;
            }
            i++;
        }
        return str2;
    }

    public static boolean df(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            x.d("MicroMsg.WalletOfflineUtil", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                x.i("MicroMsg.WalletOfflineUtil", "is in backGround.");
                return false;
            }
        }
        if (((KeyguardManager) ac.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        x.i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
        return true;
    }

    public static void Hc(String str) {
        g.Dj().CU().a(com.tencent.mm.storage.w.a.xvr, str);
    }

    public static String bif() {
        Object obj = g.Dj().CU().get(com.tencent.mm.storage.w.a.xvr, "");
        if (obj != null) {
            return (String) obj;
        }
        return null;
    }

    public static void Hd(String str) {
        g.Dj().CU().a(com.tencent.mm.storage.w.a.xvZ, str);
    }

    public static String big() {
        Object obj = g.Dj().CU().get(com.tencent.mm.storage.w.a.xvZ, "");
        if (obj != null) {
            return (String) obj;
        }
        return null;
    }

    public static void uu(int i) {
        if (i < 0) {
            i = 0;
        }
        g.Dj().CU().a(com.tencent.mm.storage.w.a.xwa, Integer.valueOf(i));
    }

    public static int bih() {
        int intValue;
        Object obj = g.Dj().CU().get(com.tencent.mm.storage.w.a.xwa, null);
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
        } else {
            intValue = 0;
        }
        if (intValue < 0) {
            return 0;
        }
        return intValue;
    }

    public static void He(String str) {
        g.Dj().CU().a(com.tencent.mm.storage.w.a.xwb, str);
    }

    public static String bii() {
        Object obj = g.Dj().CU().get(com.tencent.mm.storage.w.a.xwb, "");
        if (obj != null) {
            return (String) obj;
        }
        return null;
    }

    public static int getNetworkType(Context context) {
        if (!an.isConnected(context)) {
            return -1;
        }
        if (an.isWifi(context)) {
            return 1;
        }
        if (an.is2G(context)) {
            return 2;
        }
        if (an.is3G(context)) {
            return 3;
        }
        if (an.is4G(context)) {
            return 4;
        }
        return 0;
    }

    public static boolean bij() {
        Map chI;
        boolean z = false;
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100232");
        if (fn.isValid()) {
            chI = fn.chI();
            if (chI.containsKey("open") && "1".equals(chI.get("open"))) {
                x.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
            }
        }
        fn = com.tencent.mm.z.c.c.IF().fn("100261");
        if (fn.isValid()) {
            chI = fn.chI();
            if (chI.containsKey("open") && "1".equals(chI.get("open"))) {
                z = true;
            }
        }
        x.v("MicroMsg.WalletOfflineUtil", "isPosEnabled: " + z);
        return z;
    }
}
