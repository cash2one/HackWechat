package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class dt {
    public int a;
    public final ArrayList<TencentPoi> b = new ArrayList();
    public dx c;

    dt() {
    }

    public dt(JSONObject jSONObject) {
        this.a = jSONObject.optInt("stat");
        if (jSONObject.has("subnation")) {
            this.c = new dx(jSONObject.optJSONObject("subnation"));
        } else if (jSONObject.has("results")) {
            this.c = a(jSONObject.optJSONArray("results"));
        } else {
            this.c = dx.a;
            new StringBuilder("DetailsData: unknown json ").append(jSONObject.toString());
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("poilist");
        if (optJSONArray != null) {
            try {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.b.add(new dw(optJSONArray.getJSONObject(i)));
                }
            } catch (JSONException e) {
            }
        }
    }

    private static dx a(@Nullable JSONArray jSONArray) {
        int i = 2;
        if (jSONArray == null) {
            return null;
        }
        dx a = dx.a(dx.a);
        int length = jSONArray.length();
        if (length > 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            a.b = optJSONObject.optString("n");
            a.e = optJSONObject.optString("p");
            a.f = optJSONObject.optString("c");
            a.g = optJSONObject.optString("d");
            a.d = optJSONObject.optString("adcode");
        }
        if (length > 1) {
            optJSONObject = jSONArray.optJSONObject(1);
            a.m.putString("addrdesp.name", optJSONObject.optString("address_name"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("landmark");
            optJSONObject = optJSONObject.optJSONObject("second_landmark");
            if (optJSONObject2 != null) {
                a.m.putParcelable(TencentLocation.EXTRA_ADDRDESP_LANDMARK, new ds(optJSONObject2));
            }
            if (optJSONObject != null) {
                a.m.putParcelable(TencentLocation.EXTRA_ADDRDESP_SECOND_LANDMARK, new ds(optJSONObject));
            }
        }
        if (length <= 2) {
            return a;
        }
        ArrayList arrayList = new ArrayList();
        while (i < length) {
            ds dsVar = new ds(jSONArray.optJSONObject(i));
            arrayList.add(dsVar);
            if ("ST".equals(dsVar.b)) {
                a.j = dsVar.a;
            } else if ("ST_NO".equals(dsVar.b)) {
                a.k = dsVar.a;
            }
            i++;
        }
        a.m.putParcelableArrayList(TencentLocation.EXTRA_ADDRDESP_OTHERS_RESULTS, arrayList);
        return a;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DetailsData{");
        stringBuilder.append("subnation=").append(this.c).append(",");
        stringBuilder.append("poilist=[");
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            stringBuilder.append((TencentPoi) it.next()).append(",");
        }
        stringBuilder.append("]");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
