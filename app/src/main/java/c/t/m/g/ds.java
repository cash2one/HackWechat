package c.t.m.g;

import android.os.Parcel;
import com.tencent.map.geolocation.TencentLocation;
import org.json.JSONObject;

final class ds implements dy {
    public String a;
    public String b;
    public String c;
    public double d;
    public double e;
    public double f;
    public String g;
    public String h;

    static {
        1 1 = new 1();
    }

    public ds(JSONObject jSONObject) {
        this.a = jSONObject.optString("name");
        this.b = jSONObject.optString("dtype");
        this.c = jSONObject.optString("addr");
        this.d = jSONObject.optDouble("pointx");
        this.e = jSONObject.optDouble("pointy");
        this.f = jSONObject.optDouble("dist");
        this.g = jSONObject.optString(TencentLocation.EXTRA_DIRECTION);
        this.h = jSONObject.optString("tag");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AddressData{");
        stringBuilder.append("name=").append(this.a).append(",");
        stringBuilder.append("dtype=").append(this.b).append(",");
        stringBuilder.append("pointx=").append(this.d).append(",");
        stringBuilder.append("pointy=").append(this.e).append(",");
        stringBuilder.append("dist=").append(this.f).append(",");
        stringBuilder.append("direction=").append(this.g).append(",");
        stringBuilder.append("tag=").append(this.h).append(",");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.e);
        parcel.writeDouble(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }
}
