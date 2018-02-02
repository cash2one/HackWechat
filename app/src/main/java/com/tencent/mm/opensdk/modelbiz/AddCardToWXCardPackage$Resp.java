package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem;
import com.tencent.mm.opensdk.utils.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class AddCardToWXCardPackage$Resp extends BaseResp {
    public List<WXCardItem> cardArrary;

    public AddCardToWXCardPackage$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        return (this.cardArrary == null || this.cardArrary.size() == 0) ? false : true;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        if (this.cardArrary == null) {
            this.cardArrary = new LinkedList();
        }
        String string = bundle.getString("_wxapi_add_card_to_wx_card_list");
        if (string != null && string.length() > 0) {
            try {
                JSONArray jSONArray = ((JSONObject) new JSONTokener(string).nextValue()).getJSONArray("card_list");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    WXCardItem wXCardItem = new WXCardItem();
                    wXCardItem.cardId = jSONObject.optString("card_id");
                    wXCardItem.cardExtMsg = jSONObject.optString("card_ext");
                    wXCardItem.cardState = jSONObject.optInt("is_succ");
                    this.cardArrary.add(wXCardItem);
                }
            } catch (Exception e) {
            }
        }
    }

    public int getType() {
        return 9;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            jSONStringer.key("card_list");
            jSONStringer.array();
            for (WXCardItem wXCardItem : this.cardArrary) {
                jSONStringer.object();
                jSONStringer.key("card_id");
                jSONStringer.value(wXCardItem.cardId);
                jSONStringer.key("card_ext");
                jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                jSONStringer.key("is_succ");
                jSONStringer.value((long) wXCardItem.cardState);
                jSONStringer.endObject();
            }
            jSONStringer.endArray();
            jSONStringer.endObject();
        } catch (Exception e) {
            Log.e("MicroMsg.AddCardToWXCardPackage", "Resp.toBundle exception:" + e.getMessage());
        }
        bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
    }
}
