package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l {
    public static e H(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            eVar.obK = jSONObject.optInt("hbType");
            eVar.fLD = jSONObject.optInt("hbStatus");
            eVar.obL = jSONObject.optString("statusMess");
            eVar.obM = jSONObject.optString("gameMess");
            eVar.obN = jSONObject.optString("wishing");
            eVar.obO = jSONObject.optString("sendNick");
            eVar.obP = jSONObject.optString("sendHeadImg");
            eVar.nZa = jSONObject.optString("sendId");
            eVar.obQ = jSONObject.optString("adMessage");
            eVar.obR = jSONObject.optString("adUrl");
            eVar.fLR = jSONObject.optLong("amount");
            eVar.obS = jSONObject.optLong("recNum");
            eVar.obT = jSONObject.optLong("recAmount");
            eVar.liB = jSONObject.optInt("totalNum");
            eVar.obU = jSONObject.optLong("totalAmount");
            eVar.obV = jSONObject.optString("receiveId");
            eVar.obW = jSONObject.optInt("hasWriteAnswer");
            eVar.obX = jSONObject.optInt("isSender");
            eVar.obY = jSONObject.optInt("isContinue");
            eVar.obZ = jSONObject.optString("headTitle");
            eVar.fLE = jSONObject.optInt("receiveStatus");
            eVar.oca = jSONObject.optInt("canShare");
            eVar.nZf = jSONObject.optInt("jumpChange");
            eVar.nZh = jSONObject.optString("changeWording");
            eVar.nZg = jSONObject.optString("changeUrl");
            eVar.ocg = jSONObject.optInt("hbKind");
            eVar.nZi = jSONObject.optString("externMess");
            eVar.ocj = jSONObject.optString("sendUserName");
            if (bh.ov(eVar.obO) && !bh.ov(eVar.ocj)) {
                eVar.obO = ((b) g.h(b.class)).gu(eVar.ocj);
            }
            eVar.ocb = new a();
            JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
            if (optJSONObject != null) {
                eVar.ocb.gEx = optJSONObject.optInt("enable");
                eVar.ocb.obw = optJSONObject.optString("fissionContent");
                eVar.ocb.obv = optJSONObject.optString("fissionUrl");
            }
            eVar.occ = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("operationHeader");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    eVar.occ.add(J(optJSONArray.getJSONObject(i)));
                }
            }
            eVar.oce = jSONObject.optString("watermark");
            eVar.ocf = jSONObject.optString("context");
            eVar.oci = jSONObject.optString("contextMd5");
            eVar.resourceId = jSONObject.optInt("resourceId");
            eVar.ocd = J(jSONObject.optJSONObject("operationTail"));
            eVar.och = I(jSONObject);
        }
        return eVar;
    }

    private static LinkedList<m> I(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("record");
        LinkedList<m> linkedList = new LinkedList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                m mVar = new m();
                if (jSONObject2 != null) {
                    mVar.ocD = jSONObject2.optString("receiveName");
                    mVar.ocE = jSONObject2.optString("receiveHeadImg");
                    mVar.ocq = jSONObject2.optLong("receiveAmount");
                    mVar.ocr = jSONObject2.optString("receiveTime");
                    mVar.ocF = jSONObject2.optString("answer");
                    mVar.obV = jSONObject2.optString("receiveId");
                    mVar.ocG = jSONObject2.optString("gameTips");
                    mVar.userName = jSONObject2.optString("userName");
                    if (bh.ov(mVar.ocD) && !bh.ov(mVar.userName)) {
                        mVar.ocD = ((b) g.h(b.class)).gu(mVar.userName);
                    }
                }
                linkedList.add(mVar);
            }
        }
        return linkedList;
    }

    public static ah J(JSONObject jSONObject) {
        ah ahVar = new ah();
        if (jSONObject != null) {
            ahVar.gEx = jSONObject.optInt("enable", 0);
            ahVar.content = jSONObject.optString("content");
            ahVar.iconUrl = jSONObject.optString("iconUrl");
            ahVar.type = jSONObject.optString(DownloadSettingTable$Columns.TYPE);
            ahVar.name = jSONObject.optString("name");
            ahVar.odF = jSONObject.optInt("ossKey");
            ahVar.odG = jSONObject.optInt("focus");
        }
        return ahVar;
    }
}
