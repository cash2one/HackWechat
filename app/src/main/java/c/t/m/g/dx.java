package c.t.m.g;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import org.json.JSONException;
import org.json.JSONObject;

final class dx {
    public static final dx a = new dx();
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public final Bundle m = new Bundle();

    dx() {
    }

    private dx(dx dxVar) {
        if (dxVar.m.size() > 0) {
            this.m.putAll(dxVar.m);
            return;
        }
        this.b = dxVar.b;
        this.c = dxVar.c;
        this.d = dxVar.d;
        this.e = dxVar.e;
        this.f = dxVar.f;
        this.g = dxVar.g;
        this.h = dxVar.h;
        this.i = dxVar.i;
        this.j = dxVar.j;
        this.k = dxVar.k;
        this.l = dxVar.l;
    }

    public static dx a(dx dxVar) {
        if (dxVar == null) {
            return null;
        }
        return new dx(dxVar);
    }

    public dx(JSONObject jSONObject) {
        try {
            if (jSONObject.has(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL1)) {
                String string = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_NATION);
                String string2 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL1);
                String string3 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL2);
                String string4 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL3);
                String string5 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_LOCALITY);
                String string6 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_SUBLOCALITY);
                String string7 = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_ROUTE);
                this.m.putString(TencentExtraKeys.LOCATION_KEY_NATION, string);
                this.m.putString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL1, string2);
                this.m.putString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL2, string3);
                this.m.putString(TencentExtraKeys.LOCATION_KEY_ADMIN_LEVEL3, string4);
                this.m.putString(TencentExtraKeys.LOCATION_KEY_LOCALITY, string5);
                this.m.putString(TencentExtraKeys.LOCATION_KEY_SUBLOCALITY, string6);
                this.m.putString(TencentExtraKeys.LOCATION_KEY_ROUTE, string7);
                return;
            }
            this.c = jSONObject.getString("name");
            this.d = jSONObject.getString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            this.b = jSONObject.getString(TencentExtraKeys.LOCATION_KEY_NATION);
            this.e = jSONObject.getString("province");
            this.f = jSONObject.getString("city");
            this.g = jSONObject.getString("district");
            this.h = jSONObject.getString("town");
            this.i = jSONObject.getString("village");
            this.j = jSONObject.getString("street");
            this.k = jSONObject.getString("street_no");
            Object optString = jSONObject.optString("mergedname");
            Object optString2 = jSONObject.optString("mergedaddr");
            if (!TextUtils.isEmpty(optString)) {
                this.c = optString;
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.l = optString2;
            }
        } catch (JSONException e) {
            throw e;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubnationData{");
        stringBuilder.append("name=").append(this.c).append(",");
        stringBuilder.append("address=").append(this.l).append(",");
        stringBuilder.append("code=").append(this.d).append(",");
        stringBuilder.append("nation=").append(this.b).append(",");
        stringBuilder.append("province=").append(this.e).append(",");
        stringBuilder.append("city=").append(this.f).append(",");
        stringBuilder.append("district=").append(this.g).append(",");
        stringBuilder.append("town=").append(this.h).append(",");
        stringBuilder.append("village=").append(this.i).append(",");
        stringBuilder.append("street=").append(this.j).append(",");
        stringBuilder.append("street_no=").append(this.k).append(",");
        stringBuilder.append("bundle").append(this.m).append(",");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
