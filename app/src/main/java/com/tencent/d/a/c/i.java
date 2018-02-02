package com.tencent.d.a.c;

import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    public String AcA = "";
    private long Acp = -1;
    private String Acs = null;
    public String Act = null;
    private String Acu = "";
    private String Acv = "";
    private String Acw = "";
    private String Acx = "";
    private String Acy = "";
    public int Acz = 20;
    public String signature = "";

    public final String toString() {
        return "SoterSignatureResult{rawValue='" + this.Acs + '\'' + ", fid='" + this.Act + '\'' + ", counter=" + this.Acp + ", TEEName='" + this.Acu + '\'' + ", TEEVersion='" + this.Acv + '\'' + ", FpName='" + this.Acw + '\'' + ", FpVersion='" + this.Acx + '\'' + ", cpuId='" + this.Acy + '\'' + ", saltLen=" + this.Acz + ", jsonValue='" + this.AcA + '\'' + ", signature='" + this.signature + '\'' + '}';
    }

    public static i abz(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            i iVar = new i();
            iVar.AcA = str;
            iVar.Acs = jSONObject.optString("raw");
            iVar.Act = jSONObject.optString("fid");
            iVar.Acp = jSONObject.optLong("counter");
            iVar.Acu = jSONObject.optString("tee_n");
            iVar.Acv = jSONObject.optString("tee_v");
            iVar.Acw = jSONObject.optString("fp_n");
            iVar.Acx = jSONObject.optString("fp_v");
            iVar.Acy = jSONObject.optString("cpu_id");
            iVar.Acz = jSONObject.optInt("rsa_pss_saltlen", 20);
            return iVar;
        } catch (JSONException e) {
            c.e("Soter.SoterSignatureResult", "soter: convert from json failed." + e.toString(), new Object[0]);
            return null;
        }
    }
}
