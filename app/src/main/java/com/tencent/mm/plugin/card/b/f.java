package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.big;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.protocal.c.ki;
import com.tencent.mm.protocal.c.ko;
import com.tencent.mm.protocal.c.kt;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.protocal.c.qz;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    public static ArrayList<ShareCardInfo> wG(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                x.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
                return null;
            }
            ArrayList<ShareCardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                ShareCardInfo shareCardInfo = new ShareCardInfo();
                a(shareCardInfo, optJSONObject);
                arrayList.add(shareCardInfo);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            return null;
        }
    }

    public static void a(ShareCardInfo shareCardInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
            return;
        }
        try {
            a(shareCardInfo, new JSONObject(str).optJSONObject("share_card"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            x.e("MicroMsg.CardInfoParser", e.getMessage());
        }
    }

    public static void a(ShareCardInfo shareCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
            return;
        }
        shareCardInfo.field_card_id = wI(jSONObject.optString("card_id"));
        shareCardInfo.field_card_tp_id = wI(jSONObject.optString("card_tp_id"));
        shareCardInfo.field_app_id = jSONObject.optString("app_id");
        shareCardInfo.field_consumer = jSONObject.optString("consumer");
        shareCardInfo.field_share_time = (long) jSONObject.optInt("share_time");
        shareCardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        shareCardInfo.field_status = jSONObject.optInt("state_flag");
        shareCardInfo.field_updateSeq = jSONObject.optLong("sequence");
        shareCardInfo.field_from_username = jSONObject.optString("from_user_name");
        shareCardInfo.field_begin_time = jSONObject.optLong("begin_time");
        shareCardInfo.field_end_time = (long) jSONObject.optInt("end_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        shareCardInfo.kKT = x(optJSONObject);
        shareCardInfo.kKS = y(optJSONObject2);
        shareCardInfo.kKU = z(optJSONObject3);
        if (shareCardInfo.kKT != null) {
            shareCardInfo.a(shareCardInfo.kKT);
        }
        if (shareCardInfo.kKS != null) {
            ko koVar = shareCardInfo.kKS;
            shareCardInfo.kKS = koVar;
            try {
                shareCardInfo.field_cardTpInfoData = koVar.toByteArray();
            } catch (Exception e) {
                x.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            }
            shareCardInfo.field_end_time = (long) optJSONObject2.optInt("end_time");
            shareCardInfo.field_begin_time = (long) optJSONObject2.optInt("begin_time");
        }
        if (shareCardInfo.kKU != null) {
            big com_tencent_mm_protocal_c_big = shareCardInfo.kKU;
            shareCardInfo.kKU = com_tencent_mm_protocal_c_big;
            try {
                shareCardInfo.field_shareInfoData = com_tencent_mm_protocal_c_big.toByteArray();
            } catch (Throwable e2) {
                x.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[]{e2.getMessage()});
                x.printErrStackTrace("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            }
        }
        shareCardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
    }

    public static ArrayList<CardInfo> wH(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_array");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                x.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
                return null;
            }
            ArrayList<CardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                CardInfo cardInfo = new CardInfo();
                a(cardInfo, optJSONObject);
                arrayList.add(cardInfo);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            return null;
        }
    }

    public static void a(CardInfo cardInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
            return;
        }
        try {
            a(cardInfo, new JSONObject(str));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
    }

    private static void a(CardInfo cardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
            return;
        }
        cardInfo.field_card_id = wI(jSONObject.optString("card_id"));
        cardInfo.field_card_tp_id = wI(jSONObject.optString("card_tp_id"));
        cardInfo.field_delete_state_flag = jSONObject.optInt("state_flag");
        cardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        cardInfo.field_updateSeq = jSONObject.optLong("sequence");
        cardInfo.field_from_username = jSONObject.optString("from_username");
        cardInfo.field_begin_time = jSONObject.optLong("begin_time", 0);
        cardInfo.field_end_time = jSONObject.optLong("end_time", 0);
        cardInfo.kJS = jSONObject.optString("encrypt_code");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        cardInfo.kKT = x(optJSONObject);
        cardInfo.kKS = y(optJSONObject2);
        cardInfo.kKU = z(optJSONObject3);
        if (cardInfo.kKS != null) {
            ko koVar = cardInfo.kKS;
            cardInfo.kKS = koVar;
            try {
                cardInfo.field_cardTpInfoData = koVar.toByteArray();
            } catch (Exception e) {
                x.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            }
            cardInfo.field_block_mask = Integer.toString(cardInfo.kKS.vRP);
            cardInfo.field_card_type = cardInfo.kKS.kJO;
            if (TextUtils.isEmpty(cardInfo.field_card_tp_id)) {
                cardInfo.field_card_tp_id = cardInfo.kKS.kJN;
            }
            if (cardInfo.field_begin_time == 0 && optJSONObject2 != null) {
                cardInfo.field_begin_time = optJSONObject2.optLong("begin_time");
            }
            if (cardInfo.field_end_time == 0 && optJSONObject2 != null) {
                cardInfo.field_end_time = optJSONObject2.optLong("end_time");
            }
            if (cardInfo.kKS.vSn != null) {
                cardInfo.field_is_dynamic = cardInfo.kKS.vSn.vZD;
            }
        }
        if (cardInfo.kKT != null) {
            cardInfo.a(cardInfo.kKT);
            cardInfo.field_status = cardInfo.kKT.status;
        }
        if (cardInfo.kKU != null) {
            big com_tencent_mm_protocal_c_big = cardInfo.kKU;
            cardInfo.kKU = com_tencent_mm_protocal_c_big;
            try {
                cardInfo.field_shareInfoData = com_tencent_mm_protocal_c_big.toByteArray();
            } catch (Throwable e2) {
                x.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[]{e2.getMessage()});
                x.printErrStackTrace("MicroMsg.CardInfo", e2, "", new Object[0]);
            }
        }
        cardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
    }

    private static String wI(String str) {
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            return "";
        }
        return str;
    }

    private static kg x(JSONObject jSONObject) {
        LinkedList linkedList = null;
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
            return null;
        }
        kg kgVar = new kg();
        try {
            kgVar.status = jSONObject.optInt(DownloadInfo.STATUS);
            kgVar.vQX = jSONObject.optInt("init_balance");
            kgVar.vQY = jSONObject.optInt("init_bonus");
            JSONArray optJSONArray = jSONObject.optJSONArray("cell_list0");
            if (optJSONArray != null) {
                kgVar.vQZ = k(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list1");
            if (optJSONArray != null) {
                kgVar.vRa = k(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list2");
            if (optJSONArray != null) {
                kgVar.vRb = k(optJSONArray);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("acceptors");
            if (optJSONArray2 != null) {
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    LinkedList linkedList2 = new LinkedList();
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        linkedList2.add((String) optJSONArray2.get(i));
                    }
                    linkedList = linkedList2;
                }
                kgVar.vRc = linkedList;
            }
            kgVar.vRd = jSONObject.optInt("avail_num");
            kgVar.vRe = jSONObject.optInt("code_type");
            kgVar.code = jSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            JSONArray optJSONArray3 = jSONObject.optJSONArray("secondary_fields");
            if (optJSONArray3 != null) {
                kgVar.vRf = l(optJSONArray3);
            }
            kgVar.vRg = jSONObject.optLong("stock_num");
            kgVar.vRh = jSONObject.optInt("limit_num");
            kgVar.vRi = jSONObject.optString("user_report_url");
            JSONObject optJSONObject = jSONObject.optJSONObject("third_field");
            if (optJSONObject != null) {
                kgVar.vRj = A(optJSONObject);
            }
            kgVar.vRk = m(jSONObject.optJSONArray("action_sheets"));
            optJSONObject = jSONObject.optJSONObject("card_list_field");
            if (optJSONObject != null) {
                kgVar.vRl = A(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("operate_field");
            if (optJSONObject != null) {
                kgVar.vRm = A(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("limit_field");
            if (optJSONObject != null) {
                kgVar.vRn = A(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("detail_table");
            if (optJSONObject != null) {
                kgVar.vRo = D(optJSONObject);
            }
            kgVar.vRp = jSONObject.optString("background_pic_url");
            optJSONObject = jSONObject.optJSONObject("gifting_info_cell");
            if (optJSONObject != null) {
                kgVar.vRq = A(optJSONObject);
            }
            kgVar.vRr = jSONObject.optString("sign_number");
            optJSONObject = jSONObject.optJSONObject("unavailable_qrcode_field");
            if (optJSONObject != null) {
                kgVar.vRs = A(optJSONObject);
            }
            kgVar.vRt = jSONObject.optBoolean("is_commom_card");
            kgVar.vRu = jSONObject.optBoolean("is_location_authorized");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        return kgVar;
    }

    private static LinkedList<kt> k(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<kt> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            kt ktVar = new kt();
            ktVar.title = jSONObject.optString("title");
            ktVar.kJQ = jSONObject.optString("sub_title");
            ktVar.kNs = jSONObject.optString("tips");
            ktVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            ktVar.vSM = jSONObject.optLong("show_flag");
            ktVar.vSN = jSONObject.optString("primary_color");
            ktVar.vSO = jSONObject.optString("secondary_color");
            ktVar.oZC = jSONObject.optString("icon_url");
            ktVar.vRx = jSONObject.optString("app_brand_user_name");
            ktVar.vRy = jSONObject.optString("app_brand_pass");
            linkedList.add(ktVar);
        }
        return linkedList;
    }

    public static ko y(JSONObject jSONObject) {
        ih ihVar = null;
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
            return null;
        }
        ko koVar = new ko();
        try {
            ki kiVar;
            bri com_tencent_mm_protocal_c_bri;
            wc wcVar;
            av avVar;
            koVar.kJN = jSONObject.optString("card_tp_id");
            koVar.kJP = jSONObject.optString("logo_url");
            koVar.fFm = jSONObject.optString("appid");
            koVar.vRF = jSONObject.optString("app_username");
            koVar.vRG = jSONObject.optInt("card_category");
            koVar.kJO = jSONObject.optInt("card_type");
            koVar.kLa = jSONObject.optString("brand_name");
            koVar.title = jSONObject.optString("title");
            koVar.kJQ = jSONObject.optString("sub_title");
            koVar.hbM = jSONObject.optString("color");
            koVar.liT = jSONObject.optString("notice");
            koVar.vRH = jSONObject.optString("service_phone");
            koVar.vRK = jSONObject.optString("image_text_url");
            koVar.vRL = jSONObject.optString("source_icon");
            koVar.bhd = jSONObject.optString("source");
            JSONArray optJSONArray = jSONObject.optJSONArray("primary_fields");
            if (optJSONArray != null) {
                koVar.vRI = l(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("introduce_fields");
            if (optJSONArray != null) {
                koVar.vRJ = l(optJSONArray);
            }
            koVar.vRM = jSONObject.optInt("shop_count");
            koVar.vRN = jSONObject.optString("limit_wording");
            koVar.kKZ = jSONObject.optString("card_type_name");
            koVar.vRO = jSONObject.optString("h5_show_url");
            koVar.vRP = jSONObject.optInt("block_mask");
            koVar.vRQ = jSONObject.optString("middle_icon");
            koVar.vRR = jSONObject.optString("accept_wording");
            koVar.vRS = jSONObject.optLong("control_flag");
            koVar.vRT = jSONObject.optString("advertise_wording");
            koVar.vRU = jSONObject.optString("advertise_url");
            koVar.vRV = jSONObject.optString("public_service_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("announcement");
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
                kiVar = null;
            } else {
                kiVar = new ki();
                kiVar.type = optJSONObject.optInt(DownloadSettingTable$Columns.TYPE);
                kiVar.text = optJSONObject.optString("text");
                kiVar.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                kiVar.qox = optJSONObject.optInt("endtime");
                kiVar.bZN = optJSONObject.optInt("create_time");
                kiVar.vRv = optJSONObject.optString("thumb_url");
            }
            koVar.vRW = kiVar;
            koVar.vRX = jSONObject.optString("public_service_tip");
            koVar.vRY = jSONObject.optString("primary_sub_title");
            koVar.vRZ = jSONObject.optInt("gen_type");
            koVar.vSa = B(jSONObject.optJSONObject("detail_struct"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("use_condition");
            if (optJSONObject2 == null) {
                x.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
                com_tencent_mm_protocal_c_bri = null;
            } else {
                int i;
                bna C;
                com_tencent_mm_protocal_c_bri = new bri();
                com_tencent_mm_protocal_c_bri.title = optJSONObject2.optString("title");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("outer_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    x.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
                } else {
                    com_tencent_mm_protocal_c_bri.wSN = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        C = C(optJSONArray2.optJSONObject(i));
                        if (C != null) {
                            com_tencent_mm_protocal_c_bri.wSN.add(C);
                        }
                    }
                }
                optJSONArray2 = optJSONObject2.optJSONArray("inner_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    x.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
                } else {
                    com_tencent_mm_protocal_c_bri.wSO = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        C = C(optJSONArray2.optJSONObject(i));
                        if (C != null) {
                            com_tencent_mm_protocal_c_bri.wSO.add(C);
                        }
                    }
                }
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("detail_field");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    x.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
                } else {
                    com_tencent_mm_protocal_c_bri.wSP = l(optJSONArray3);
                }
            }
            koVar.vSb = com_tencent_mm_protocal_c_bri;
            optJSONObject = jSONObject.optJSONObject("follow_box");
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
                wcVar = null;
            } else {
                wcVar = new wc();
                wcVar.text = optJSONObject.optString("text");
                wcVar.wgA = optJSONObject.optInt("follow");
                x.i("MicroMsg.CardInfoParser", "follow:" + wcVar.wgA + "　text:" + wcVar.text);
            }
            koVar.vSc = wcVar;
            optJSONObject = jSONObject.optJSONObject("guidance");
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
                avVar = null;
            } else {
                avVar = new av();
                avVar.text = optJSONObject.optString("text");
                avVar.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            }
            koVar.vSd = avVar;
            koVar.vSe = jSONObject.optInt("need_direct_jump", 0);
            koVar.vSf = jSONObject.optInt("is_acceptable", 0);
            koVar.vSg = jSONObject.optString("unacceptable_wording");
            koVar.vSh = jSONObject.optInt("has_hongbao", 0);
            koVar.vSi = jSONObject.optString("accept_ui_title");
            koVar.vSj = jSONObject.optInt("show_accept_view", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("brand_field");
            if (optJSONObject3 != null) {
                koVar.vSk = A(optJSONObject3);
            }
            koVar.vSl = jSONObject.optString("shop_name");
            optJSONObject3 = jSONObject.optJSONObject("pay_and_qrcode_field");
            if (optJSONObject3 != null) {
                koVar.vSm = A(optJSONObject3);
            }
            optJSONObject = jSONObject.optJSONObject("dynamic_qr_code_info");
            if (optJSONObject != null) {
                rs rsVar;
                if (optJSONObject == null) {
                    x.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
                    rsVar = null;
                } else {
                    rsVar = new rs();
                    rsVar.vZD = optJSONObject.optBoolean("is_dynamic");
                    rsVar.vZE = optJSONObject.optBoolean("can_refresh");
                    rsVar.vZF = optJSONObject.optString("refresh_wording");
                    x.i("MicroMsg.CardInfoParser", "is_dynamic:" + rsVar.vZD + "　can_refresh:" + rsVar.vZE + "　refresh_wording:" + rsVar.vZF);
                }
                koVar.vSn = rsVar;
            }
            koVar.vSo = jSONObject.optBoolean("is_card_code_exposed");
            koVar.vSp = jSONObject.optInt("qrcode_correct_level");
            koVar.vSq = jSONObject.optBoolean("dismiss_qrcode_icon_on_card");
            koVar.vSr = jSONObject.optBoolean("need_location");
            optJSONObject3 = jSONObject.optJSONObject("bluetooth_info");
            if (optJSONObject3 != null) {
                if (optJSONObject3 == null) {
                    x.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
                } else {
                    ihVar = new ih();
                    ihVar.name = optJSONObject3.optString("name");
                    ihVar.vOt = optJSONObject3.optInt("report_time_interval", 0);
                    x.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", new Object[]{ihVar.name});
                }
                koVar.vSs = ihVar;
            }
            koVar.vSt = jSONObject.optString("biz_nickname");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        return koVar;
    }

    private static LinkedList<oq> l(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<oq> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            oq A = A(jSONArray.getJSONObject(i));
            if (A != null) {
                linkedList.add(A);
            }
        }
        return linkedList;
    }

    private static big z(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
            return null;
        }
        big com_tencent_mm_protocal_c_big = new big();
        com_tencent_mm_protocal_c_big.wLJ = jSONObject.optString("gift_msg_title");
        return com_tencent_mm_protocal_c_big;
    }

    private static LinkedList<av> m(JSONArray jSONArray) {
        LinkedList<av> linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    av avVar = new av();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    avVar.text = jSONObject.optString("text");
                    avVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    linkedList.add(avVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                }
            }
        }
        return linkedList;
    }

    private static oq A(JSONObject jSONObject) {
        aja com_tencent_mm_protocal_c_aja = null;
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
            return null;
        }
        oq oqVar = new oq();
        oqVar.title = jSONObject.optString("title");
        oqVar.kJR = jSONObject.optString("aux_title");
        oqVar.kJQ = jSONObject.optString("sub_title");
        oqVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        oqVar.vSM = jSONObject.optLong("show_flag");
        oqVar.vSN = jSONObject.optString("primary_color");
        oqVar.vSO = jSONObject.optString("secondary_color");
        oqVar.oZC = jSONObject.optString("icon_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("gifting_info");
        if (optJSONObject != null) {
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
            } else {
                x.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[]{optJSONObject});
                com_tencent_mm_protocal_c_aja = new aja();
                com_tencent_mm_protocal_c_aja.vEM = o.bY(optJSONObject.optString("biz_uin"));
                com_tencent_mm_protocal_c_aja.vEN = optJSONObject.optString("order_id");
            }
            oqVar.vXw = com_tencent_mm_protocal_c_aja;
        }
        oqVar.vRx = jSONObject.optString("app_brand_user_name");
        oqVar.vRy = jSONObject.optString("app_brand_pass");
        return oqVar;
    }

    private static qz B(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
            return null;
        }
        qz qzVar = new qz();
        qzVar.title = jSONObject.optString("title");
        qzVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        qzVar.desc = jSONObject.optString("abstract");
        qzVar.peD = jSONObject.optString("detail");
        qzVar.vZb = jSONObject.optString("ad_title");
        JSONArray optJSONArray = jSONObject.optJSONArray("icon_url_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
        } else {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                Object obj = "";
                try {
                    obj = optJSONArray.getString(i);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                    x.e("MicroMsg.CardInfoParser", "getMessage:" + e.getMessage());
                }
                linkedList.add(obj);
            }
            qzVar.vZa = linkedList;
        }
        return qzVar;
    }

    private static bna C(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
            return null;
        }
        bna com_tencent_mm_protocal_c_bna = new bna();
        com_tencent_mm_protocal_c_bna.tag = jSONObject.optString("tag");
        com_tencent_mm_protocal_c_bna.hbM = jSONObject.optString("color");
        return com_tencent_mm_protocal_c_bna;
    }

    private static ra D(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
            return null;
        }
        ra raVar = new ra();
        raVar.title = jSONObject.optString("title");
        raVar.kJQ = jSONObject.optString("sub_title");
        raVar.vZc = jSONObject.optInt("show_num", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("rows");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
            return raVar;
        }
        try {
            raVar.vZd = l(optJSONArray);
            return raVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            x.e("MicroMsg.CardInfoParser", e.getMessage());
            return raVar;
        }
    }
}
