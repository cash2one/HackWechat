package c.t.m.g;

import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONException;
import org.json.JSONObject;

final class du {
    public String a;
    public String b;
    public int c;

    du() {
    }

    public du(JSONObject jSONObject) {
        try {
            this.a = jSONObject.getString("bid");
            this.b = jSONObject.getString("floor");
            this.c = jSONObject.getInt(DownloadSettingTable$Columns.TYPE);
        } catch (JSONException e) {
            throw e;
        }
    }
}
