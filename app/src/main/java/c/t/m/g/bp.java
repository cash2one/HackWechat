package c.t.m.g;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import org.json.JSONObject;

public final class bp extends bk {
    aa a = new aa();

    public bp() {
        Object string = m.a().getSharedPreferences(d(), 0).getString("halley_cloud_param_content", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                this.a.a(string);
            } catch (Throwable th) {
                m.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", "").commit();
            }
        }
    }

    private static String d() {
        return "Halley_Cloud_Param_Content_" + m.b() + "_for_SettingsHandler";
    }

    public final void a(bg bgVar) {
        String c = this.a.c();
        bgVar.a.put("confVersion", c);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("Setting");
            if (optJSONObject != null) {
                Object optString = optJSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
                if (!TextUtils.isEmpty(optString)) {
                    this.a.a(optString);
                    m.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", this.a.a.toString()).commit();
                }
            }
            m.i().post(new bq(this));
        } catch (Throwable th) {
            m.i().post(new bq(this));
        }
    }

    public final String c() {
        return "settings";
    }

    public final void b() {
        m.i().post(new bq(this));
    }
}
