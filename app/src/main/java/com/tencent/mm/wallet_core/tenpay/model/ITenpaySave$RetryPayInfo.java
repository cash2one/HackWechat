package com.tencent.mm.wallet_core.tenpay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class ITenpaySave$RetryPayInfo implements Parcelable {
    public static final Creator<ITenpaySave$RetryPayInfo> CREATOR = new 1();
    public int zIc;
    public int zId;
    public String zIe;

    public ITenpaySave$RetryPayInfo() {
        this.zIc = -1;
        this.zId = -1;
        this.zIe = "";
    }

    protected ITenpaySave$RetryPayInfo(Parcel parcel) {
        this.zIc = parcel.readInt();
        this.zId = parcel.readInt();
        this.zIe = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zIc);
        parcel.writeInt(this.zId);
        parcel.writeString(this.zIe);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean cBO() {
        if (this.zIc == -1 || this.zId == -1) {
            return false;
        }
        return true;
    }

    public final void X(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("retry_pay_info");
            if (optJSONObject != null) {
                this.zIc = optJSONObject.optInt("retry_interval", -1);
                this.zId = optJSONObject.optInt("max_retry_count", -1);
                this.zIe = optJSONObject.optString("retry_fail_wording", "");
            }
        }
    }
}
