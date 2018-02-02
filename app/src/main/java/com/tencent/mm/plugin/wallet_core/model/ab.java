package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.b.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.et;
import com.tencent.mm.protocal.c.eu;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ab {
    public static void a(JSONObject jSONObject, int i) {
        x.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard()");
        try {
            af afVar;
            JSONObject optJSONObject;
            Object obj;
            Bankcard bankcard;
            JSONObject optJSONObject2;
            Bankcard bankcard2;
            Object az;
            k kVar;
            Bankcard bankcard3;
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                n.setTimeStamp(String.valueOf(optLong));
            } else {
                x.w("MicroMsg.WalletQueryBankcardParser", "no time_stamp at WalletQueryBankcardParser.");
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
            x.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo()");
            af afVar2 = new af();
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getUserInfo() json == null or json.length() == 0");
                afVar = null;
            } else {
                afVar2.field_is_reg = jSONObject2.getInt("is_reg");
                afVar2.field_true_name = jSONObject2.optString("true_name");
                afVar2.field_cre_type = jSONObject2.optInt("cre_type", -1);
                afVar2.field_main_card_bind_serialno = jSONObject2.optString("last_card_bind_serialno");
                afVar2.field_cre_name = jSONObject2.optString("cre_name");
                afVar2.field_ftf_pay_url = jSONObject2.optString("transfer_url");
                afVar2.field_reset_passwd_flag = jSONObject2.optString("reset_passwd_flag");
                afVar2.field_find_passwd_url = jSONObject2.optString("reset_passwd_url");
                o.bLq();
                ag.MY(afVar2.field_main_card_bind_serialno);
                afVar2.field_isDomesticUser = "2".equals(jSONObject2.optString("icard_user_flag", "2"));
                optJSONObject = jSONObject2.optJSONObject("touch_info");
                if (optJSONObject != null) {
                    afVar2.field_is_open_touch = optJSONObject.optInt("is_open_touch", 0);
                    x.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo field_is_open_touch() is " + afVar2.field_is_open_touch);
                } else {
                    x.e("MicroMsg.WalletQueryBankcardParser", "touch_info is null ");
                    afVar2.field_is_open_touch = o.bLq().bLO() ? 1 : 0;
                    x.e("MicroMsg.WalletQueryBankcardParser", "old field_is_open_touch is " + afVar2.field_is_open_touch);
                }
                afVar2.field_lct_wording = jSONObject2.optString("lct_wording");
                afVar2.field_lct_url = jSONObject2.optString("lct_url");
                x.i("MicroMsg.WalletQueryBankcardParser", "field_lct_wording: " + afVar2.field_lct_wording + ", field_lct_url:" + afVar2.field_lct_url);
                afVar2.field_lqt_state = jSONObject2.optInt("lqt_state", -1);
                optJSONObject = jSONObject2.optJSONObject("lqb_show_info");
                x.i("MicroMsg.WalletQueryBankcardParser", "field_lqt_state: %s, lqb_show_info: %s", new Object[]{Integer.valueOf(afVar2.field_lqt_state), optJSONObject});
                if (optJSONObject != null) {
                    afVar2.field_is_show_lqb = optJSONObject.optInt("is_show_lqb");
                    afVar2.field_is_open_lqb = optJSONObject.optInt("is_open_lqb");
                    afVar2.field_lqb_open_url = optJSONObject.optString("lqb_open_url");
                }
                if (zk(i) || i == 3 || i == 4) {
                    g.Dk();
                    g.Dj().CU().a(a.xwy, Integer.valueOf(afVar2.field_lqt_state));
                    g.Dk();
                    g.Dj().CU().a(a.xwz, afVar2.field_lct_wording);
                }
                afVar = afVar2;
            }
            afVar.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
            afVar.field_paymenu_use_new = jSONObject.optInt("paymenu_use_new");
            x.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard, paymenu_use_new: %s", new Object[]{Integer.valueOf(afVar.field_paymenu_use_new)});
            String optString = jSONObject.optString("support_bank_word");
            g.Dk();
            g.Dj().CU().a(a.xnP, bh.ou(optString));
            ArrayList t = t(jSONObject.optJSONArray("Array"));
            ArrayList u = u(jSONObject.optJSONArray("virtual_card_array"));
            JSONObject optJSONObject3 = jSONObject.optJSONObject("balance_info");
            String str = "MicroMsg.WalletQueryBankcardParser";
            String str2 = "Bankcard getBalance %s";
            Object[] objArr = new Object[1];
            if (optJSONObject3 == null) {
                optString = "";
            } else {
                obj = optJSONObject3;
            }
            objArr[0] = optString;
            x.i(str, str2, objArr);
            if (optJSONObject3 == null || optJSONObject3.length() <= 0) {
                x.i("MicroMsg.WalletQueryBankcardParser", "getBalance() json == null or json.length() == 0");
                bankcard = null;
            } else {
                boolean z;
                Bankcard bankcard4 = new Bankcard((byte) 0);
                a(bankcard4, optJSONObject3.optLong("balance_version", -1), optJSONObject3.optLong("time_out", 7200), optJSONObject3.optInt("avail_balance"));
                bankcard4.sLf = ((double) optJSONObject3.optInt("avail_balance")) / 100.0d;
                bankcard4.sLg = optJSONObject3.optString("balance_show_wording");
                bankcard4.sLj = optJSONObject3.optString("max_fetch_wording");
                bankcard4.sLk = optJSONObject3.optString("avail_fetch_wording");
                bankcard4.sLh = ((double) optJSONObject3.optInt("fetch_balance")) / 100.0d;
                bankcard4.field_cardType |= Bankcard.sKU;
                bankcard4.field_bankcardType = optJSONObject3.optString("balance_bank_type");
                bankcard4.field_bindSerial = optJSONObject3.optString("balance_bind_serial");
                bankcard4.field_forbidWord = optJSONObject3.optString("balance_forbid_word");
                if (bh.ov(bankcard4.field_forbidWord)) {
                    bankcard4.field_bankcardState = 0;
                } else {
                    bankcard4.field_bankcardState = 8;
                }
                bankcard4.field_fetchArriveTime = optJSONObject3.optLong("fetch_arrive_time");
                bankcard4.field_mobile = optJSONObject3.optString("mobile");
                if (optJSONObject3.optInt("support_micropay", 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                bankcard4.field_support_micropay = z;
                x.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + optJSONObject3.optInt("support_micropay", 0));
                bankcard4.sLi = optJSONObject3.optString("balance_list_url");
                optString = ac.getContext().getString(i.uOR);
                bankcard4.field_desc = optString;
                bankcard4.field_bankName = optString;
                bankcard4.field_bankcardTail = "10000";
                bankcard4.field_forbid_title = optJSONObject3.optString("forbid_title");
                bankcard4.field_forbid_url = optJSONObject3.optString("forbid_url");
                optJSONObject2 = optJSONObject3.optJSONObject("balance_menu_info");
                if (optJSONObject2 != null) {
                    x.d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", new Object[]{optJSONObject2.toString()});
                    g.Dj().CU().a(a.xxt, optString);
                } else {
                    g.Dj().CU().a(a.xxt, "");
                }
                bankcard = bankcard4;
            }
            x.i("MicroMsg.WalletQueryBankcardParser", "hy: cache time: %d", new Object[]{Integer.valueOf(jSONObject.optInt("query_cache_time"))});
            optJSONObject2 = jSONObject.optJSONObject("complex_switch_info");
            if (optJSONObject2 != null) {
                optJSONObject = optJSONObject2.optJSONObject("bind_newcard_switch");
                optJSONObject.optInt("forbid_bind_card");
                optJSONObject.optString("forbid_word");
            }
            g bKX = g.bKX();
            bKX.sLX = optJSONObject2;
            try {
                if (bKX.sLX != null) {
                    optJSONObject2 = bKX.sLX.optJSONObject("bind_newcard_switch");
                    bKX.sLW = optJSONObject2.optInt("forbid_bind_card");
                    bKX.oZB = optJSONObject2.optString("forbid_word");
                } else {
                    bKX.sLW = 0;
                    bKX.oZB = "";
                }
            } catch (Throwable e) {
                bKX.sLW = 0;
                bKX.oZB = "";
                x.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", e, "", new Object[0]);
            }
            x.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", new Object[]{bKX.sLX, Integer.valueOf(bKX.sLW), bKX.oZB});
            JSONArray optJSONArray = jSONObject.optJSONArray("history_card_array");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getHistroyBankcard() json == null or json.length() == 0");
                bankcard2 = null;
            } else {
                bankcard2 = d.bKU().V(optJSONArray.getJSONObject(0));
                bankcard2.field_cardType |= Bankcard.sKV;
            }
            optJSONArray = jSONObject.optJSONArray("balance_notice");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("fetch_notice");
            if (optJSONArray != null) {
                az = bh.az(optJSONArray.toString(), "");
            } else {
                str = "";
            }
            if (optJSONArray2 != null) {
                obj = bh.az(optJSONArray2.toString(), "");
            } else {
                obj = "";
            }
            x.i("MicroMsg.WalletQueryBankcardParser", "hy: balance notice: %s, fetchNotice: %s", new Object[]{az, obj});
            g.Dk();
            g.Dj().CU().a(a.xnN, az);
            g.Dk();
            g.Dj().CU().a(a.xnO, obj);
            g.Dk();
            g.Dj().CU().lH(true);
            optJSONObject2 = jSONObject.optJSONObject("bank_priority");
            List linkedList = new LinkedList();
            if (optJSONObject2 != null) {
                try {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("bankinfo_array");
                    if (optJSONArray3 != null) {
                        int length = optJSONArray3.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            c cVar = new c();
                            JSONObject jSONObject3 = optJSONArray3.getJSONObject(i2);
                            cVar.oZA = jSONObject3.optString("bind_serial");
                            cVar.sKQ = jSONObject3.optString("polling_forbid_word");
                            linkedList.add(cVar);
                        }
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e2, "", new Object[0]);
                }
            }
            jSONObject.optString("query_order_time");
            optJSONObject2 = jSONObject.optJSONObject("loan_entry_info");
            if (optJSONObject2 == null) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo json is null");
                kVar = null;
            } else {
                x.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo()");
                kVar = new k();
                kVar.field_title = optJSONObject2.optString("title");
                kVar.field_loan_jump_url = optJSONObject2.optString("loan_jump_url");
                x.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_loan_jump_url:" + kVar.field_loan_jump_url);
                kVar.field_is_show_entry = optJSONObject2.optInt("is_show_entry", 0);
                kVar.field_tips = optJSONObject2.optString("tips");
                kVar.field_is_overdue = optJSONObject2.optInt("is_overdue", 0);
                if (optJSONObject2.has("available_otb")) {
                    kVar.field_available_otb = e.d(optJSONObject2.optDouble("available_otb") / 100.0d, "CNY");
                }
                if (optJSONObject2.has("index")) {
                    kVar.field_red_dot_index = optJSONObject2.optInt("index");
                }
                x.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_index:" + kVar.field_red_dot_index + "  field_is_overdue:" + kVar.field_is_overdue + "  field_is_show_entry:" + kVar.field_is_show_entry);
            }
            optJSONObject2 = jSONObject.optJSONObject("fetch_info");
            b bVar = o.bLq().sQd;
            x.d("MicroMsg.WalletQueryBankcardParser", "fetchInfo: %s", new Object[]{bVar});
            if (optJSONObject2 != null) {
                bVar = a(optJSONObject2, true);
            } else {
                x.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard() fetch_info is null");
            }
            optJSONObject2 = jSONObject.optJSONObject("lqt_info");
            if (optJSONObject2 == null) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getLqtInfo, json object is null!");
                bankcard3 = null;
            } else {
                x.i("MicroMsg.WalletQueryBankcardParser", "now get getLqtInfo: %s", new Object[]{optJSONObject2.toString()});
                bankcard3 = new Bankcard((byte) 0);
                bankcard3.field_bankcardType = optJSONObject2.optString("lqt_bank_type");
                bankcard3.field_bindSerial = optJSONObject2.optString("lqt_bind_serial");
                bankcard3.field_bankName = optJSONObject2.optString("lqt_bank_name");
                bankcard3.sLf = ((double) optJSONObject2.optLong("total_balance")) / 100.0d;
                bankcard3.sLh = ((double) optJSONObject2.optLong("avail_balance")) / 100.0d;
                bankcard3.sLn = new e();
                bankcard3.sLn.oPH = optJSONObject2.optString("lqt_logo_url");
                bankcard3.field_forbidWord = optJSONObject2.optString("lqt_forbid_word");
                bankcard3.field_forbid_title = optJSONObject2.optString("forbid_title");
                bankcard3.field_forbid_url = optJSONObject2.optString("forbid_url");
                bankcard3.sLg = optJSONObject2.optString("lqt_show_wording");
                bankcard3.field_mobile = optJSONObject2.optString("mobile");
                bankcard3.field_support_micropay = optJSONObject2.optInt("support_micropay", 0) == 1;
                bankcard3.field_cardType |= Bankcard.sKX;
                if (bh.ov(bankcard3.field_bankName)) {
                    bankcard3.field_bankName = ac.getContext().getString(i.uTa);
                }
                bankcard3.field_desc = bankcard3.field_bankName;
                if (bh.ov(bankcard3.field_forbidWord)) {
                    bankcard3.field_bankcardState = 0;
                } else {
                    bankcard3.field_bankcardState = 8;
                }
            }
            o.bLq().a(afVar, t, u, bankcard, bankcard2, kVar, bVar, bankcard3, r11, i, linkedList);
        } catch (Throwable e22) {
            x.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard Exception :" + e22.getMessage());
            x.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e22, "", new Object[0]);
        }
    }

    public static boolean zk(int i) {
        if (i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23) {
            return true;
        }
        return false;
    }

    public static Bankcard a(et etVar) {
        x.i("MicroMsg.WalletQueryBankcardParser", "Bankcard getBalance from balance info %s", new Object[]{etVar});
        Bankcard bankcard = null;
        if (etVar != null) {
            boolean z;
            bankcard = new Bankcard((byte) 0);
            a(bankcard, etVar.vKu, (long) etVar.vKv, bh.getInt(etVar.vKq, 0));
            bankcard.sLf = ((double) bh.getInt(etVar.vKq, 0)) / 100.0d;
            bankcard.sLg = etVar.sLg;
            bankcard.sLj = etVar.sLj;
            bankcard.sLk = etVar.sLk;
            bankcard.sLh = ((double) bh.getInt(etVar.vKs, 0)) / 100.0d;
            bankcard.field_cardType |= Bankcard.sKU;
            bankcard.field_bankcardType = etVar.vKm;
            bankcard.field_bindSerial = etVar.vKn;
            bankcard.field_forbidWord = etVar.vKo;
            if (bh.ov(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 0;
            } else {
                bankcard.field_bankcardState = 8;
            }
            bankcard.field_mobile = etVar.fAf;
            if (bh.getInt(etVar.vKt, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            bankcard.field_support_micropay = z;
            x.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + etVar.vKt);
            bankcard.sLi = etVar.sLi;
            String string = ac.getContext().getString(i.uOR);
            bankcard.field_desc = string;
            bankcard.field_bankName = string;
            bankcard.field_bankcardTail = "10000";
            bankcard.field_forbid_title = etVar.vKx;
            bankcard.field_forbid_url = etVar.vKy;
            eu euVar = etVar.vKA;
            if (euVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_show_menu", euVar.vKB);
                    List<ev> list = euVar.vKC;
                    JSONArray jSONArray = new JSONArray();
                    for (ev evVar : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("title", evVar.title);
                        jSONObject2.put("jump_type", evVar.szZ);
                        jSONObject2.put("jump_h5_url", evVar.sAa);
                        jSONObject2.put("tinyapp_username", evVar.sAb);
                        jSONObject2.put("tinyapp_path", evVar.sAc);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("balance_menu_item", jSONArray);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e, "Bankcard getBalance from balance, assemble menuInfoJson error: %s", new Object[]{e.getMessage()});
                }
                x.d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", new Object[]{jSONObject.toString()});
                g.Dj().CU().a(a.xxt, jSONObject.toString());
            } else {
                g.Dj().CU().a(a.xxt, "");
            }
        }
        return bankcard;
    }

    public static b a(JSONObject jSONObject, boolean z) {
        int i = 0;
        if (jSONObject == null) {
            x.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is null");
            return null;
        }
        x.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is valid");
        b bVar = new b();
        bVar.sKJ = jSONObject.optString("fetch_charge_title");
        x.i("MicroMsg.WalletQueryBankcardParser", "fetch_charge_title:" + bVar.sKJ);
        if (z) {
            x.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery true");
            bVar.szw = jSONObject.optInt("is_cal_charge", 0);
            bVar.szv = jSONObject.optInt("is_show_charge", 0);
            bVar.szx = jSONObject.optInt("is_full_fetch_direct", 0);
            bVar.szy = jSONObject.optDouble("min_charge_fee", 0.0d) / 100.0d;
            bVar.pKP = jSONObject.optDouble("remain_fee", 0.0d) / 100.0d;
            bVar.sKL = jSONObject.optString("card_list_wording_title", "");
            bVar.sKM = jSONObject.optString("card_list_wording_content", "");
            if (jSONObject.has("withdraw_sector")) {
                bVar.sKN = b.U(jSONObject.optJSONObject("withdraw_sector"));
            }
            x.i("MicroMsg.WalletQueryBankcardParser", " is_cal_charge:" + bVar.szw + " is_show_charge:" + bVar.szv + " min_charge_fee:" + bVar.szy + " remain_fee:" + bVar.pKP + " is_full_fetch_direct:" + bVar.szx);
        } else {
            x.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery false");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), itemJsonArray is null");
        } else {
            bVar.sKK = new LinkedList();
            while (i < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    b bVar2 = new b();
                    bVar2.aAM = optJSONObject.optString("key");
                    bVar2.value = optJSONObject.optString(DownloadSettingTable$Columns.VALUE);
                    x.i("MicroMsg.WalletQueryBankcardParser", "feeItem.key is " + bVar2.aAM + " , feeItem.value is " + bVar2.value);
                    if (!(TextUtils.isEmpty(bVar2.aAM) || TextUtils.isEmpty(bVar2.value))) {
                        bVar.sKK.add(bVar2);
                    }
                } else {
                    x.e("MicroMsg.WalletQueryBankcardParser", "item index " + i + " is empty");
                }
                i++;
            }
            x.i("MicroMsg.WalletQueryBankcardParser", "itemsList size is " + bVar.sKK.size());
        }
        return bVar;
    }

    private static void a(Bankcard bankcard, long j, long j2, int i) {
        e.a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new 1(j2, j, i, bankcard));
    }

    private static ArrayList<Bankcard> t(JSONArray jSONArray) {
        x.i("MicroMsg.WalletQueryBankcardParser", "getBankcards()");
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Bankcard V = d.bKU().V(jSONArray.getJSONObject(i));
                if (V != null) {
                    d.d(V);
                    arrayList.add(V);
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<Bankcard> u(JSONArray jSONArray) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Bankcard bankcard = new Bankcard();
                bankcard.field_cardType |= Bankcard.sKT;
                bankcard.field_bankName = jSONObject.getString("bank_name");
                bankcard.field_bankcardType = jSONObject.getString("bank_type");
                bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
                bankcard.sLa = jSONObject.getString("card_id");
                bankcard.field_bizUsername = jSONObject.getString("app_username");
                bankcard.field_wxcreditState = jSONObject.getInt("card_status");
                if (bankcard.field_wxcreditState != 2) {
                    bankcard.field_bankcardState = 9;
                } else {
                    bankcard.field_bankcardState = 0;
                }
                bankcard.field_desc = ac.getContext().getString(i.uXU, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
                bankcard.sLn = new e();
                bankcard.sLn.oPH = jSONObject.getString("logo_url");
                bankcard.sLn.sLu = jSONObject.getString("background_logo_url");
                bankcard.sLn.sLv = jSONObject.getString("big_logo_url");
                arrayList.add(bankcard);
            }
        }
        return arrayList;
    }
}
