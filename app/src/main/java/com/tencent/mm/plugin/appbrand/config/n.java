package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.ct;
import com.tencent.mm.protocal.c.cz;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public enum n {
    ;

    static ct g(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("AppConfig");
        ct ctVar = new ct();
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("VersionList");
            ctVar.vHK = new LinkedList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    bsu com_tencent_mm_protocal_c_bsu = new bsu();
                    com_tencent_mm_protocal_c_bsu.type = optJSONObject2.optInt(DownloadSettingTable$Columns.TYPE);
                    com_tencent_mm_protocal_c_bsu.version = optJSONObject2.optInt("version");
                    ctVar.vHK.add(com_tencent_mm_protocal_c_bsu);
                }
            }
        }
        return ctVar;
    }

    static String a(cz czVar) {
        if (czVar == null) {
            return "AppRunningFlagInfo{null}";
        }
        return "AppRunningFlagInfo{RunningFlag=" + czVar.vId + ", StopServiceTime" + czVar.vIe + ", AppForbiddenReason" + czVar.vIf + ", SessionOpenForbiddenReason" + czVar.vIg + ", TimelineOpenForbiddenReason" + czVar.vIh + "}";
    }
}
