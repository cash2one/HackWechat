package com.tencent.mapsdk.rastercore;

import android.content.Context;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mapsdk.rastercore.f.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    private String a;
    private c b;
    private String c;

    public d(Context context, b bVar) {
        String a = a.a(context);
        this.c = context.getPackageName();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("https://confinfo.map.qq.com/confinfo?apikey=");
        stringBuilder.append(a);
        stringBuilder.append("&type=2");
        stringBuilder.append("&pf=Android_2D");
        stringBuilder.append("&uk=");
        stringBuilder.append(a.a());
        this.a = stringBuilder.toString();
        this.b = new c(bVar);
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    private static String[] c(String str) {
        String[] strArr = new String[2];
        try {
            JSONObject jSONObject = new JSONObject(str);
            strArr[0] = jSONObject.optString("version");
            strArr[1] = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        } catch (JSONException e) {
        }
        return strArr;
    }

    public final void a() {
        this.b.execute(new String[]{this.a, this.c});
    }
}
