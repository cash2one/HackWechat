package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WxaAttributes$e {
    public String fqR;
    public String name;

    public static List<WxaAttributes$e> rc(String str) {
        if (bh.ov(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            List<WxaAttributes$e> linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                WxaAttributes$e wxaAttributes$e = new WxaAttributes$e();
                wxaAttributes$e.name = jSONObject.getString("name");
                wxaAttributes$e.fqR = jSONObject.getString("md5");
                linkedList.add(wxaAttributes$e);
            }
            return linkedList;
        } catch (JSONException e) {
            x.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", new Object[]{e});
            return null;
        }
    }
}
