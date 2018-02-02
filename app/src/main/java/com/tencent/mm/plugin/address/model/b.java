package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahb;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.b gJQ;
    private e gJT;

    public b() {
        a aVar = new a();
        aVar.hmj = new ahb();
        aVar.hmk = new ahc();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        aVar.hmi = 1191;
        this.gJQ = aVar.JZ();
        ahb com_tencent_mm_protocal_c_ahb = (ahb) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ahb.cOY = 2;
        LinkedList linkedList = new LinkedList();
        linkedList.add("invoice_info.title");
        linkedList.add("invoice_info.tax_number");
        linkedList.add("invoice_info.bank_number");
        linkedList.add("invoice_info.bank_name");
        linkedList.add("invoice_info.type");
        linkedList.add("invoice_info.email");
        linkedList.add("invoice_info.company_address");
        linkedList.add("invoice_info.company_address_detail");
        linkedList.add("invoice_info.company_address_postcode");
        linkedList.add("invoice_info.phone");
        com_tencent_mm_protocal_c_ahb.wov = linkedList;
        com_tencent_mm_protocal_c_ahb.wou = false;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.address.a.a.XF().ilP = new com.tencent.mm.plugin.o.a.a();
            x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
            ahc com_tencent_mm_protocal_c_ahc = (ahc) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
            x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + com_tencent_mm_protocal_c_ahc.wow);
            if (com_tencent_mm_protocal_c_ahc.wow != null) {
                try {
                    JSONArray jSONArray = new JSONObject(com_tencent_mm_protocal_c_ahc.wow).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                                com.tencent.mm.plugin.o.a.b bVar = new com.tencent.mm.plugin.o.a.b();
                                bVar.nBI = jSONObject.getInt("group_id");
                                bVar.nBR = jSONObject.getString("invoice_url");
                                x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "get groupid:" + jSONObject.getInt("group_id") + "get invoiceUrl:" + jSONObject.getString("invoice_url"));
                                JSONArray jSONArray2 = jSONObject.getJSONArray("field_list");
                                if (jSONArray2 != null && jSONArray2.length() > 0) {
                                    for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i5);
                                        String string = jSONObject2.getString("key");
                                        Object obj = -1;
                                        switch (string.hashCode()) {
                                            case -1787383122:
                                                if (string.equals("bank_name")) {
                                                    obj = 2;
                                                    break;
                                                }
                                                break;
                                            case -192204195:
                                                if (string.equals("tax_number")) {
                                                    obj = 1;
                                                    break;
                                                }
                                                break;
                                            case 3575610:
                                                if (string.equals(DownloadSettingTable$Columns.TYPE)) {
                                                    obj = 4;
                                                    break;
                                                }
                                                break;
                                            case 96619420:
                                                if (string.equals("email")) {
                                                    obj = 5;
                                                    break;
                                                }
                                                break;
                                            case 106642798:
                                                if (string.equals("phone")) {
                                                    obj = 6;
                                                    break;
                                                }
                                                break;
                                            case 110371416:
                                                if (string.equals("title")) {
                                                    obj = null;
                                                    break;
                                                }
                                                break;
                                            case 330208940:
                                                if (string.equals("bank_number")) {
                                                    obj = 3;
                                                    break;
                                                }
                                                break;
                                            case 944498430:
                                                if (string.equals("company_address_detail")) {
                                                    obj = 7;
                                                    break;
                                                }
                                                break;
                                        }
                                        switch (obj) {
                                            case null:
                                                bVar.title = jSONObject2.getString(DownloadSettingTable$Columns.VALUE);
                                                break;
                                            case 1:
                                                bVar.nBK = jSONObject2.getString(DownloadSettingTable$Columns.VALUE);
                                                break;
                                            case 2:
                                                bVar.nBM = jSONObject2.getString(DownloadSettingTable$Columns.VALUE);
                                                break;
                                            case 3:
                                                bVar.nBL = jSONObject2.getString(DownloadSettingTable$Columns.VALUE);
                                                break;
                                            case 4:
                                                bVar.type = jSONObject2.getString(DownloadSettingTable$Columns.VALUE);
                                                break;
                                            case 5:
                                                bVar.fWi = jSONObject2.getString(DownloadSettingTable$Columns.VALUE);
                                                break;
                                            case 6:
                                                bVar.nBO = jSONObject2.getString(DownloadSettingTable$Columns.VALUE);
                                                bVar.nBP = jSONObject2.getString(DownloadSettingTable$Columns.VALUE);
                                                break;
                                            case 7:
                                                bVar.nBQ = jSONObject2.getString(DownloadSettingTable$Columns.VALUE);
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.address.b.a.a XF = com.tencent.mm.plugin.address.a.a.XF();
                                if (bVar.type != null && bVar.type.equals("0")) {
                                    bVar.nBJ = "";
                                    bVar.nBP = "";
                                    bVar.fWi = "";
                                    XF.ilP.nBH.add(bVar);
                                } else if (bVar.type != null && bVar.type.equals("1")) {
                                    bVar.nBJ = bVar.title;
                                    bVar.title = "";
                                    bVar.nBO = "";
                                    bVar.nBK = "";
                                    bVar.nBL = "";
                                    bVar.nBM = "";
                                    bVar.nBQ = "";
                                    XF.ilP.nBH.add(bVar);
                                }
                                x.i("MicroMsg.InvoiceMgr", "type is error..");
                            } catch (JSONException e) {
                                x.e("MicroMsg.NetSceneGetUserAutoFillInfo", "parse error for no." + i4);
                            }
                        }
                    }
                } catch (JSONException e2) {
                    x.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1191;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
