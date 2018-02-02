package com.tencent.mm.plugin.address.e;

import android.util.Log;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

public final class e {
    public static String a(b bVar) {
        JSONObject jSONObject = new JSONObject();
        if (bVar == null) {
            return jSONObject.toString();
        }
        try {
            jSONObject.put(DownloadSettingTable$Columns.TYPE, bVar.type);
            if (bVar.type == null || !bVar.type.equals("1")) {
                jSONObject.put("title", bVar.title);
                if (bVar.nBK != null) {
                    jSONObject.put("taxNumber", bVar.nBK);
                } else {
                    jSONObject.put("taxNumber", "");
                }
                if (bVar.nBQ != null) {
                    jSONObject.put("companyAddress", bVar.nBQ);
                } else {
                    jSONObject.put("companyAddress", "");
                }
                if (bVar.nBO != null) {
                    jSONObject.put("telephone", bVar.nBO);
                } else {
                    jSONObject.put("telephone", "");
                }
                if (bVar.nBM != null) {
                    jSONObject.put("bankName", bVar.nBM);
                } else {
                    jSONObject.put("bankName", "");
                }
                if (bVar.nBL != null) {
                    jSONObject.put("bankAccount", bVar.nBL);
                } else {
                    jSONObject.put("bankAccount", "");
                }
                return jSONObject.toString();
            }
            jSONObject.put("title", bVar.nBJ);
            jSONObject.put("taxNumber", "");
            jSONObject.put("companyAddress", "");
            jSONObject.put("telephone", "");
            jSONObject.put("bankName", "");
            jSONObject.put("bankAccount", "");
            return jSONObject.toString();
        } catch (Throwable e) {
            x.e("MicroMsg.InvoiceUtil", "put json value error : %s", new Object[]{Log.getStackTraceString(e)});
        }
    }
}
