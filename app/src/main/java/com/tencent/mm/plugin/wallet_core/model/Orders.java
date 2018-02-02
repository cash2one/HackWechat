package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bq.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.a;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import d.a.a.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class Orders implements Parcelable {
    public static final Creator<Orders> CREATOR = new 1();
    public static int sOi = 0;
    public static int sOj = 1;
    public String fpL;
    public String fuH = "";
    public String lOX = "";
    public String lbT = "0";
    public String oPH;
    public double pKL;
    public double pNX = 0.0d;
    public String paz;
    public int sIJ;
    public String sKt;
    public long sNE;
    public double sNF = 0.0d;
    public int sNG;
    public String sNH;
    public int sNI;
    public String sNJ;
    public String sNK;
    public String sNL;
    public String sNM;
    public int sNN;
    public boolean sNO = false;
    public String sNP = "";
    public long sNQ = 0;
    public String sNR = "";
    public String sNS;
    public Set<String> sNT = new HashSet();
    public int sNU = 0;
    public String sNV = "";
    public List<Commodity> sNW = new ArrayList();
    public f sNX = new f();
    public int sNY = 0;
    public String sNZ = "";
    public String sOa = "";
    public DeductInfo sOb;
    public long sOc;
    public long sOd;
    public int sOe = 0;
    public int sOf = 0;
    public int sOg = 0;
    public String sOh = "";
    public String token = "";
    public String username;

    public static class Commodity implements Parcelable {
        public static final Creator<Commodity> CREATOR = new 1();
        public String desc;
        public String fuI;
        public double ljg = 0.0d;
        public String paA;
        public String paE;
        public String pac;
        public String pal;
        public String pam;
        public String pan;
        public String pao;
        public String paq;
        public String pas;
        public String pat;
        public int pav;
        public String pax;
        public String paz;
        public int sNN;
        public double sOk = 0.0d;
        public String sOl;
        public String sOm;
        public List<DiscountInfo> sOn = new ArrayList();
        public String sOo;
        public String sOp;
        public String sOq;
        public RecommendTinyAppInfo sOr = null;
        public List<Promotions> sOs = new ArrayList();
        public boolean sOt = false;
        public a sOu = new a();

        public int describeContents() {
            return 0;
        }

        public Commodity(Parcel parcel) {
            this.pal = parcel.readString();
            this.pam = parcel.readString();
            this.pan = parcel.readString();
            this.pao = parcel.readString();
            this.desc = parcel.readString();
            this.paq = parcel.readString();
            this.ljg = parcel.readDouble();
            this.pas = parcel.readString();
            this.pat = parcel.readString();
            this.pav = parcel.readInt();
            this.fuI = parcel.readString();
            this.pax = parcel.readString();
            this.paz = parcel.readString();
            this.paA = parcel.readString();
            this.pac = parcel.readString();
            this.sOm = parcel.readString();
            this.paE = parcel.readString();
            parcel.readTypedList(this.sOn, DiscountInfo.CREATOR);
            this.sOo = parcel.readString();
            this.sOq = parcel.readString();
            this.sOr = (RecommendTinyAppInfo) parcel.readParcelable(RecommendTinyAppInfo.class.getClassLoader());
            parcel.readTypedList(this.sOs, Promotions.CREATOR);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.pal);
            parcel.writeString(this.pam);
            parcel.writeString(this.pan);
            parcel.writeString(this.pao);
            parcel.writeString(this.desc);
            parcel.writeString(this.paq);
            parcel.writeDouble(this.ljg);
            parcel.writeString(this.pas);
            parcel.writeString(this.pat);
            parcel.writeInt(this.pav);
            parcel.writeString(this.fuI);
            parcel.writeString(this.pax);
            parcel.writeString(this.paz);
            parcel.writeString(this.paA);
            parcel.writeString(this.pac);
            parcel.writeString(this.sOm);
            parcel.writeString(this.paE);
            parcel.writeTypedList(this.sOn);
            parcel.writeString(this.sOo);
            parcel.writeString(this.sOq);
            parcel.writeParcelable(this.sOr, 0);
            parcel.writeTypedList(this.sOs);
        }
    }

    public static class RecommendTinyAppInfo implements Parcelable {
        public static final Creator<RecommendTinyAppInfo> CREATOR = new 1();
        public String sAb;
        public String sAc;
        public String sNA;
        public String sNB;
        public String sNC;
        public int sND;
        public String sNz;
        public long sOK;
        public long sOL;
        public long sOM;
        public int sON;
        public int sOO;
        public long sOP;

        public RecommendTinyAppInfo(Parcel parcel) {
            this.sNz = parcel.readString();
            this.sNA = parcel.readString();
            this.sNB = parcel.readString();
            this.sAb = parcel.readString();
            this.sAc = parcel.readString();
            this.sND = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.sNz);
            parcel.writeString(this.sNA);
            parcel.writeString(this.sNB);
            parcel.writeString(this.sAb);
            parcel.writeString(this.sAc);
            parcel.writeInt(this.sND);
        }
    }

    public static Orders Y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Orders orders = new Orders();
        try {
            orders.sNE = bh.Wp();
            orders.pNX = jSONObject.getDouble("total_fee") / 100.0d;
            orders.lbT = jSONObject.getString("num");
            orders.sIJ = jSONObject.optInt("bank_card_tag", 1);
            orders.paz = jSONObject.optString("fee_type", "");
            orders.pKL = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
            orders.sNF = jSONObject.optDouble("fetch_fee", 0.0d) / 100.0d;
            orders.sNG = jSONObject.optInt("is_assign_userinfo_pay");
            orders.sKt = jSONObject.optString("true_name");
            orders.sNH = jSONObject.optString("cre_id");
            orders.sNI = jSONObject.optInt("ce_type");
            orders.sNJ = jSONObject.optString("assign_pay_info");
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            orders.sOc = jSONObject.optLong("free_fee");
            orders.sOd = jSONObject.optLong("remain_fee");
            orders.sOe = jSONObject.optInt("not_support_bind_card", 0);
            orders.sOf = jSONObject.optInt("not_support_retry", 0);
            int i = jSONObject.optInt("support_all_bank", 0) == 1 ? 1 : 0;
            if (i != 0) {
                orders.sNT = new HashSet();
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                Commodity commodity = new Commodity();
                commodity.desc = jSONObject2.getString("desc");
                commodity.ljg = ((double) jSONObject2.getInt("fee")) / 100.0d;
                commodity.paq = jSONObject2.optInt("count", 1);
                commodity.pas = jSONObject2.getString("pay_status");
                commodity.pax = jSONObject2.optString("buy_bank_name");
                commodity.pat = jSONObject2.getString("pay_status_name");
                commodity.pan = jSONObject2.optString("spid");
                commodity.pao = jSONObject2.optString("sp_name");
                commodity.pav = jSONObject2.optInt("modify_timestamp");
                commodity.fuI = jSONObject2.getString("transaction_id");
                commodity.paz = jSONObject2.optString("fee_type");
                if (bh.ov(orders.paz)) {
                    orders.paz = commodity.paz;
                }
                commodity.paA = jSONObject2.optString("appusername");
                commodity.pac = jSONObject2.optString("app_telephone");
                orders.sNW.add(commodity);
                if (i == 0) {
                    orders.sNS = jSONObject2.optString("support_bank");
                    orders.sNT = MS(orders.sNS);
                }
            }
            if (jSONObject.has("is_open_fee_protocal")) {
                orders.sNO = e.h(jSONObject, "is_open_fee_protocal");
            } else {
                orders.sNO = Bankcard.dY(orders.sIJ, 2);
            }
            orders.sNX = Z(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
            if (optJSONObject == null) {
                x.e("MicroMsg.Orders", "bindqueryresp is null ");
            } else {
                optJSONObject = optJSONObject.optJSONObject("user_info");
                if (optJSONObject == null) {
                    x.e("MicroMsg.Orders", "user_info is null ");
                } else {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("touch_info");
                    if (optJSONObject2 == null) {
                        x.e("MicroMsg.Orders", "touch_info is null ");
                    } else {
                        orders.sNU = ((l) g.h(l.class)).aKe() ? optJSONObject2.optInt("use_touch_pay", 0) : 0;
                        orders.sNV = optJSONObject2.optString("touch_forbidword");
                        String optString = optJSONObject2.optString("touch_challenge");
                        boolean z = 1 == optJSONObject2.optInt("need_change_auth_key");
                        s.sPp.mzI = optString;
                        s.sPp.mzJ = z;
                        x.i("MicroMsg.Orders", "hy: use_touch_pay is %s, challenge is: %s, is need change: %b", new Object[]{Integer.valueOf(orders.sNU), optString, Boolean.valueOf(z)});
                    }
                }
            }
            orders.sNY = jSONObject.optInt("needbindcardtoshowfavinfo");
            orders.sNZ = jSONObject.optString("discount_wording");
            orders.sOa = jSONObject.optString("favor_rule_wording");
            a(orders, jSONObject.optJSONObject("entrustpayinfo"));
            return orders;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
            return orders;
        }
    }

    private static f Z(JSONObject jSONObject) {
        f fVar = new f();
        JSONObject optJSONObject = jSONObject.optJSONObject("favinfo");
        if (optJSONObject == null) {
            x.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
            return fVar;
        }
        int i;
        fVar.sDn = ((double) optJSONObject.optLong("tradeAmount")) / 100.0d;
        fVar.sDo = ((double) optJSONObject.optLong("totalFavAmount")) / 100.0d;
        fVar.sDp = ((double) optJSONObject.optLong("afterFavorTradeAmount")) / 100.0d;
        fVar.sDq = optJSONObject.optString("favorComposeId");
        fVar.sDt = optJSONObject.optInt("useNaturalDefense");
        fVar.sDu = optJSONObject.optString("discountWording");
        fVar.sDv = optJSONObject.optString("favorRuleWording");
        fVar.sDw = optJSONObject.optDouble("showFavorAmount", 0.0d) / 100.0d;
        fVar.sDx = optJSONObject.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
        fVar.sDy = optJSONObject.optInt("isVariableFavor");
        fVar.sDz = optJSONObject.optString("invariableFavorDesc");
        fVar.sDA = optJSONObject.optString("variableFavorDesc");
        JSONArray optJSONArray = optJSONObject.optJSONArray("tradeFavList");
        for (i = 0; i < optJSONArray.length(); i++) {
            int i2;
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            q qVar = new q();
            qVar.sDZ = jSONObject2.optInt("favType");
            qVar.sEa = jSONObject2.optInt("favSubType");
            qVar.sEb = jSONObject2.optLong("favProperty");
            qVar.sEc = jSONObject2.optString("favorTypeDesc");
            qVar.sDk = jSONObject2.optString("favId");
            qVar.sEd = jSONObject2.optString("favName");
            qVar.sEe = jSONObject2.optString("favDesc");
            qVar.sDl = jSONObject2.optString("favorUseManual");
            qVar.sDm = jSONObject2.optString("favorRemarks");
            qVar.sEf = ((double) jSONObject2.optLong("favPrice")) / 100.0d;
            qVar.sEg = ((double) jSONObject2.optLong("realFavFee")) / 100.0d;
            qVar.sEh = jSONObject2.optInt("needBankPay");
            qVar.sEi = jSONObject2.optString("bankNo");
            qVar.pax = jSONObject2.optString("bankName");
            qVar.sEj = jSONObject2.optString("bankLogoUrl");
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("bind_serial_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    qVar.sEk.add(b.bc(optJSONArray2.optString(i2).getBytes()));
                }
            }
            fVar.sDr.add(qVar);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("favorComposeList");
        if (optJSONObject2 != null) {
            fVar.sDs = new com.tencent.mm.plugin.wallet.a.g();
            optJSONArray = optJSONObject2.optJSONArray("favorComposeInfo");
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                optJSONObject2 = optJSONArray.getJSONObject(i2);
                h hVar = new h();
                hVar.sDE = optJSONObject2.optString("faovrComposeId");
                hVar.sDF = ((double) optJSONObject2.optLong("totalFavorAmount")) / 100.0d;
                hVar.sDp = ((double) optJSONObject2.optLong("afterFavorTradeAmount")) / 100.0d;
                hVar.sDw = optJSONObject2.optDouble("showFavorAmount", 0.0d) / 100.0d;
                hVar.sDx = optJSONObject2.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
                hVar.sDy = optJSONObject2.optInt("isVariableFavor");
                hVar.sDz = optJSONObject2.optString("invariableFavorDesc");
                hVar.sDA = optJSONObject2.optString("variableFavorDesc");
                optJSONArray2 = optJSONObject2.optJSONArray("composeArray");
                for (i = 0; i < optJSONArray2.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i);
                    com.tencent.mm.plugin.wallet.a.e eVar = new com.tencent.mm.plugin.wallet.a.e();
                    eVar.sDk = jSONObject3.optString("favId");
                    eVar.sDl = jSONObject3.optString("favorUseManual");
                    eVar.sDm = jSONObject3.optString("favorRemarks");
                    hVar.sDG.add(eVar);
                }
                fVar.sDs.sDC.add(hVar);
            }
        }
        a aVar = new a();
        optJSONObject = optJSONObject.optJSONObject("bank_card_info");
        if (optJSONObject != null) {
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("bind_serial_favor_info_list");
            if (optJSONArray3 != null) {
                for (i2 = 0; i2 < optJSONArray3.length(); i2++) {
                    com.tencent.mm.plugin.wallet.a.b bVar = new com.tencent.mm.plugin.wallet.a.b();
                    optJSONObject2 = optJSONArray3.getJSONObject(i2);
                    bVar.oZA = optJSONObject2.optString("bind_serial");
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("bind_serial_favor_list");
                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                        for (i = 0; i < optJSONArray4.length(); i++) {
                            c cVar = new c();
                            JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i);
                            cVar.pKc = optJSONObject3.optString("favor_desc");
                            cVar.sDj = optJSONObject3.optInt("is_default_show", 0);
                            bVar.sDi.add(cVar);
                        }
                    }
                    aVar.sDg.add(bVar);
                }
            }
            JSONArray optJSONArray5 = optJSONObject.optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
            if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                aVar.sDh = new k();
                for (i = 0; i < optJSONArray5.length(); i++) {
                    com.tencent.mm.plugin.wallet.a.l lVar = new com.tencent.mm.plugin.wallet.a.l();
                    lVar.pKc = optJSONArray5.optJSONObject(i).optString("favor_desc");
                    aVar.sDh.sDL.add(lVar);
                }
            }
        }
        fVar.sDB = aVar;
        return fVar;
    }

    public static Orders a(JSONObject jSONObject, Orders orders) {
        if (jSONObject == null || orders == null) {
            x.w("MicroMsg.Orders", "oldOrders is null");
        } else {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("appservice");
                if (optJSONObject != null) {
                    orders.sNL = optJSONObject.optString("app_recommend_desc");
                    orders.sNM = optJSONObject.optString("app_telephone");
                    orders.sNN = optJSONObject.optInt("recommend_level", 2);
                    orders.lOX = optJSONObject.optString("share_to_friends_url");
                }
                int i = orders.sNN;
                List<Commodity> list = orders.sNW;
                orders.sNP = jSONObject.optString("pay_result_tips");
                JSONArray jSONArray = jSONObject.getJSONArray("payresult");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Commodity commodity;
                    if (list != null && list.size() == 1) {
                        commodity = (Commodity) list.get(0);
                        commodity.sOs = new ArrayList();
                        commodity.sOn = new ArrayList();
                        commodity.fuI = jSONObject2.getString("transaction_id");
                        a(commodity, jSONObject2, i);
                    } else if (list != null) {
                        String string = jSONObject2.getString("transaction_id");
                        for (Commodity commodity2 : list) {
                            if (string != null && string.equals(commodity2.fuI)) {
                                a(commodity2, jSONObject2, i);
                                break;
                            }
                        }
                    }
                }
                optJSONObject = jSONObject.optJSONObject("extinfo");
                if (optJSONObject != null) {
                    orders.sNQ = optJSONObject.optLong("fetch_pre_arrive_time") * 1000;
                    orders.sNR = optJSONObject.optString("fetch_pre_arrive_time_wording");
                }
                orders.sOg = jSONObject.optInt("is_use_new_paid_succ_page", 0);
                orders.sOh = jSONObject.optString("pay_succ_btn_wording");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
            }
        }
        return orders;
    }

    private static void a(Commodity commodity, JSONObject jSONObject, int i) {
        int i2 = 0;
        commodity.paE = jSONObject.optString("discount");
        commodity.pas = jSONObject.getString("pay_status");
        commodity.pat = jSONObject.getString("pay_status_name");
        commodity.pax = jSONObject.optString("buy_bank_name");
        commodity.pav = jSONObject.optInt("pay_timestamp");
        commodity.sOm = jSONObject.optString("card_tail");
        commodity.sNN = i;
        commodity.sOo = jSONObject.optString("rateinfo");
        commodity.sOp = jSONObject.optString("discount_rateinfo");
        commodity.sOq = jSONObject.optString("original_feeinfo");
        if (jSONObject.has("total_fee")) {
            commodity.ljg = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
        }
        commodity.sOk = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
        commodity.paz = jSONObject.optString("fee_type", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
        if (optJSONObject != null) {
            Promotions promotions = new Promotions();
            promotions.type = sOi;
            promotions.name = optJSONObject.optString("nickname");
            promotions.paA = optJSONObject.optString("username");
            commodity.sOl = promotions.paA;
            promotions.peY = optJSONObject.optString("logo_round_url");
            promotions.url = optJSONObject.optString("subscribe_biz_url");
            if (!(bh.ov(promotions.name) || bh.ov(promotions.url))) {
                commodity.sOs.add(promotions);
                commodity.sOt = true;
            }
        }
        JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            Promotions promotions2 = new Promotions();
            promotions2.type = sOj;
            promotions2.peY = jSONObject2.optString("icon");
            promotions2.name = jSONObject2.optString("wording");
            promotions2.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            promotions2.sNx = jSONObject2.optString("btn_text");
            promotions2.sOA = jSONObject2.optInt(DownloadSettingTable$Columns.TYPE);
            promotions2.title = jSONObject2.optString("title");
            promotions2.sIr = jSONObject2.optLong("activity_id");
            promotions2.sOB = jSONObject2.optInt("activity_type", 0);
            promotions2.sOD = jSONObject2.optString("small_title");
            promotions2.sOC = jSONObject2.optInt("award_id");
            promotions2.sNu = jSONObject2.optInt("send_record_id");
            promotions2.sNv = jSONObject2.optInt("user_record_id");
            promotions2.sOE = jSONObject2.optString("activity_tinyapp_username");
            promotions2.sOF = jSONObject2.optString("activity_tinyapp_path");
            promotions2.sNw = jSONObject2.optLong("activity_mch_id");
            promotions2.sOG = jSONObject2.optInt("activity_tinyapp_version");
            promotions2.sOH = jSONObject2.optString("get_award_params");
            promotions2.sOI = jSONObject2.optString("query_award_status_params");
            a(promotions2, jSONObject2.optJSONObject("exposure_info"));
            commodity.sOs.add(promotions2);
        }
        optJSONObject = jSONObject.optJSONObject("link_ativity_info");
        if (optJSONObject != null) {
            commodity.sOu.text = optJSONObject.optString("text");
            commodity.sOu.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("discount_array");
        if (optJSONArray != null) {
            int length2 = optJSONArray.length();
            while (i2 < length2) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                DiscountInfo discountInfo = new DiscountInfo();
                if (optJSONObject2 != null) {
                    discountInfo.sOz = optJSONObject2.optDouble("payment_amount");
                    discountInfo.pKc = optJSONObject2.optString("favor_desc");
                    commodity.sOn.add(discountInfo);
                }
                i2++;
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("tinyapp_info");
        if (optJSONObject3 != null) {
            if (commodity.sOr == null) {
                commodity.sOr = new RecommendTinyAppInfo();
            }
            commodity.sOr.sNz = optJSONObject3.optString("tinyapp_name");
            commodity.sOr.sNA = optJSONObject3.optString("tinyapp_logo");
            commodity.sOr.sNB = optJSONObject3.optString("tinyapp_desc");
            commodity.sOr.sAb = optJSONObject3.optString("tinyapp_username");
            commodity.sOr.sAc = optJSONObject3.optString("tinyapp_path");
            commodity.sOr.sNC = optJSONObject3.optString("activity_tinyapp_btn_text");
            commodity.sOr.sOK = optJSONObject3.optLong("activity_id");
            commodity.sOr.sOL = optJSONObject3.optLong("activity_type");
            commodity.sOr.sOM = optJSONObject3.optLong("award_id");
            commodity.sOr.sON = optJSONObject3.optInt("send_record_id");
            commodity.sOr.sOO = optJSONObject3.optInt("user_record_id");
            commodity.sOr.sOP = optJSONObject3.optLong("activity_mch_id");
            commodity.sOr.sND = optJSONObject3.optInt("tinyapp_version");
        }
    }

    public static void a(Promotions promotions, JSONObject jSONObject) {
        x.i("MicroMsg.Orders", "parseExposureInfo: %s", new Object[]{jSONObject});
        if (jSONObject == null) {
            promotions.sOJ = null;
            return;
        }
        try {
            d.a.a.b bVar = new d.a.a.b();
            JSONArray optJSONArray = jSONObject.optJSONArray("single_exposure_info_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                bVar.wbt = new LinkedList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    d.a.a.f fVar = new d.a.a.f();
                    fVar.peY = jSONObject2.optString("logo");
                    fVar.Avt = jSONObject2.optString("award_name");
                    fVar.Avu = jSONObject2.optString("award_description");
                    fVar.Avv = jSONObject2.optString("background_img");
                    fVar.Avx = jSONObject2.optString("award_description_color");
                    fVar.Avw = jSONObject2.optString("award_name_color");
                    bVar.wbt.add(fVar);
                }
            }
            bVar.Avf = jSONObject.optInt("is_query_others", 0);
            bVar.vZA = jSONObject.optString("draw_lottery_params");
            bVar.wbu = jSONObject.optInt("is_show_btn");
            bVar.Avj = jSONObject.optString("background_img_whole");
            JSONObject optJSONObject = jSONObject.optJSONObject("btn_info");
            if (optJSONObject != null) {
                bVar.wbv = new d.a.a.a();
                bVar.wbv.Avb = optJSONObject.optString("btn_words");
                bVar.wbv.Avc = optJSONObject.optString("btn_color");
                bVar.wbv.Avd = optJSONObject.optInt("btn_op_type");
                bVar.wbv.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                bVar.wbv.wme = optJSONObject.optString("get_lottery_params");
                optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                if (optJSONObject != null) {
                    bVar.wbv.Ave = new d.a.a.e();
                    bVar.wbv.Ave.wDr = optJSONObject.optString("activity_tinyapp_username");
                    bVar.wbv.Ave.wDs = optJSONObject.optString("activity_tinyapp_path");
                    bVar.wbv.Ave.wDt = optJSONObject.optInt("activity_tinyapp_version");
                }
            }
            bVar.wbs = jSONObject.optString("exposure_info_modify_params");
            bVar.Avg = jSONObject.optInt("user_opertaion_type");
            bVar.Avh = jSONObject.optInt("is_show_layer");
            optJSONObject = jSONObject.optJSONObject("layer_info");
            if (optJSONObject != null) {
                bVar.Avi = new d();
                bVar.Avi.Avk = optJSONObject.optString("layer_title");
                bVar.Avi.Avl = optJSONObject.optString("layer_logo");
                bVar.Avi.Avm = optJSONObject.optString("layer_type");
                bVar.Avi.Avn = optJSONObject.optString("layer_name");
                bVar.Avi.Avo = optJSONObject.optString("layer_description");
                bVar.Avi.Avp = optJSONObject.optInt("is_show_layer_btn");
                if (!bh.ov(optJSONObject.optString("voice_url"))) {
                    bVar.Avi.Avr = new b(optJSONObject.optString("voice_url").getBytes());
                }
                if (!bh.ov(optJSONObject.optString("voice_data"))) {
                    bVar.Avi.Avs = new b(optJSONObject.optString("voice_data").getBytes());
                }
                optJSONObject = optJSONObject.optJSONObject("layer_btn_info");
                if (optJSONObject != null) {
                    bVar.Avi.Avq = new d.a.a.c();
                    bVar.Avi.Avq.Avb = optJSONObject.optString("btn_words");
                    bVar.Avi.Avq.Avc = optJSONObject.optString("btn_color");
                    bVar.Avi.Avq.Avd = optJSONObject.optInt("btn_op_type");
                    bVar.Avi.Avq.wme = optJSONObject.optString("get_lottery_params");
                    bVar.Avi.Avq.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                    if (optJSONObject != null) {
                        bVar.Avi.Avq.Ave = new d.a.a.e();
                        bVar.Avi.Avq.Ave.wDr = optJSONObject.optString("activity_tinyapp_username");
                        bVar.Avi.Avq.Ave.wDs = optJSONObject.optString("activity_tinyapp_path");
                        bVar.Avi.Avq.Ave.wDt = optJSONObject.optInt("activity_tinyapp_version");
                    }
                }
            }
            promotions.sOJ = bVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Orders", e, "parseExposureInfo error: %s", new Object[]{e.getMessage()});
        }
    }

    private static void a(Orders orders, JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            x.i("MicroMsg.Orders", "parseDeductInfo json is not null");
            orders.sOb = new DeductInfo();
            orders.sOb.title = jSONObject.optString("contract_title");
            orders.sOb.desc = jSONObject.optString("contract_desc");
            orders.sOb.sGa = jSONObject.optInt("auto_deduct_flag", 0);
            orders.sOb.sOv = jSONObject.optString("contract_url");
            orders.sOb.sOx = jSONObject.optInt("is_select_pay_way", 0);
            orders.sOb.sFs = jSONObject.optInt("deduct_show_type", 0);
            orders.sOb.kLA = jSONObject.optString("button_wording", "");
            orders.sOb.sFt = jSONObject.optString("deduct_rule_wording", "");
            orders.sOb.sOy = jSONObject.optString("open_deduct_wording", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("show_info");
            int length = optJSONArray.length();
            if (length > 0) {
                orders.sOb.sOw = new ArrayList();
                while (i < length) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        DeductShowInfo deductShowInfo = new DeductShowInfo();
                        deductShowInfo.name = optJSONObject.optString("name");
                        deductShowInfo.value = optJSONObject.optString(DownloadSettingTable$Columns.VALUE);
                        deductShowInfo.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                        orders.sOb.sOw.add(deductShowInfo);
                    } else {
                        x.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=" + i);
                    }
                    i++;
                }
                return;
            }
            x.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is " + length);
            return;
        }
        x.i("MicroMsg.Orders", "parseDeductInfo json is null");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reqKey:").append(this.fuH).append("\n");
        stringBuilder.append("token").append(this.token).append("\n");
        stringBuilder.append("num").append(this.lbT).append("\n");
        stringBuilder.append("totalFee").append(this.pNX).append("\n");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    private static HashSet<String> MS(String str) {
        HashSet<String> hashSet = new HashSet();
        if (!bh.ov(str)) {
            for (Object add : str.split("\\|")) {
                hashSet.add(add);
            }
            if (hashSet.size() > 0) {
                hashSet.retainAll(hashSet);
            } else {
                hashSet.clear();
            }
        }
        return hashSet;
    }

    public Orders(Parcel parcel) {
        boolean z = true;
        this.sNE = parcel.readLong();
        this.fuH = parcel.readString();
        this.token = parcel.readString();
        this.lbT = parcel.readString();
        this.pNX = parcel.readDouble();
        this.sIJ = parcel.readInt();
        this.paz = parcel.readString();
        this.pKL = parcel.readDouble();
        this.sNF = parcel.readDouble();
        this.sNG = parcel.readInt();
        this.sKt = parcel.readString();
        this.sNH = parcel.readString();
        this.sNI = parcel.readInt();
        this.sNJ = parcel.readString();
        this.username = parcel.readString();
        this.fpL = parcel.readString();
        this.oPH = parcel.readString();
        this.sNK = parcel.readString();
        this.sNL = parcel.readString();
        this.sNM = parcel.readString();
        this.sNN = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.sNO = z;
        this.sNP = parcel.readString();
        this.lOX = parcel.readString();
        this.sNQ = parcel.readLong();
        this.sNR = parcel.readString();
        parcel.readTypedList(this.sNW, Commodity.CREATOR);
        this.sNS = parcel.readString();
        this.sNT = MS(this.sNS);
        this.sNU = parcel.readInt();
        this.sNV = parcel.readString();
        this.sOb = (DeductInfo) parcel.readParcelable(DeductInfo.class.getClassLoader());
        this.sOe = parcel.readInt();
        this.sOf = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.sNE);
        parcel.writeString(this.fuH);
        parcel.writeString(this.token);
        parcel.writeString(this.lbT);
        parcel.writeDouble(this.pNX);
        parcel.writeInt(this.sIJ);
        parcel.writeString(this.paz);
        parcel.writeDouble(this.pKL);
        parcel.writeDouble(this.sNF);
        parcel.writeInt(this.sNG);
        parcel.writeString(this.sKt);
        parcel.writeString(this.sNH);
        parcel.writeInt(this.sNI);
        parcel.writeString(this.sNJ);
        parcel.writeString(this.username);
        parcel.writeString(this.fpL);
        parcel.writeString(this.oPH);
        parcel.writeString(this.sNK);
        parcel.writeString(this.sNL);
        parcel.writeString(this.sNM);
        parcel.writeInt(this.sNN);
        parcel.writeInt(this.sNO ? 1 : 0);
        parcel.writeString(this.sNP);
        parcel.writeString(this.lOX);
        parcel.writeLong(this.sNQ);
        parcel.writeString(this.sNR);
        parcel.writeTypedList(this.sNW);
        parcel.writeString(this.sNS);
        parcel.writeInt(this.sNU);
        parcel.writeString(this.sNV);
        parcel.writeParcelable(this.sOb, 1);
        parcel.writeInt(this.sOe);
        parcel.writeInt(this.sOf);
    }
}
