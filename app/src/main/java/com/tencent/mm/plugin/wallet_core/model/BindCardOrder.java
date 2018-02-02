package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.n.a;
import com.tencent.mm.plugin.wallet_core.model.n.b;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class BindCardOrder implements Parcelable {
    public static final Creator<BindCardOrder> CREATOR = new 1();
    public static int sLH = 1;
    public static int sLI = 2;
    public static int sLJ = 6;
    public int jumpType;
    public String oZz;
    private String sLG = "";
    public int sLK;
    public String sLL = "";
    public String sLM = "";
    public String sLN = "";
    public String sLO = "";
    public String sLP = "";
    public int sLQ;
    public int sLR;
    public n sLS;
    public a sLT;
    public b sLU;

    protected BindCardOrder(Parcel parcel) {
        this.sLG = parcel.readString();
        try {
            W(new JSONObject(this.sLG));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BindCardOrder", e, "", new Object[0]);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sLG);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean bKV() {
        return this.jumpType == sLH && this.sLT != null;
    }

    public final boolean bKW() {
        return this.jumpType == sLJ && this.sLT != null;
    }

    public final void W(JSONObject jSONObject) {
        this.sLG = jSONObject == null ? "" : jSONObject.toString();
        x.i("MicroMsg.BindCardOrder", "feed json %s", new Object[]{this.sLG});
        try {
            this.sLK = jSONObject.optInt("show_bind_succ_page", 0);
            this.sLL = jSONObject.optString("bind_succ_btn_wording", "");
            this.sLM = jSONObject.optString("bind_succ_remind_wording", "");
            this.jumpType = jSONObject.optInt("jump_type", 0);
            this.sLP = jSONObject.optString("bind_serial");
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_info");
            this.sLS = new n();
            if (optJSONObject != null) {
                n nVar = this.sLS;
                nVar.sIr = optJSONObject.optLong("activity_id");
                nVar.sNs = optJSONObject.optLong("activity_type", 0);
                nVar.sNt = optJSONObject.optLong("award_id");
                nVar.sNu = optJSONObject.optInt("send_record_id");
                nVar.sNv = optJSONObject.optInt("user_record_id");
                nVar.sNw = optJSONObject.optLong("activity_mch_id", 0);
            }
            optJSONObject = jSONObject.optJSONObject("h5_info");
            if (optJSONObject != null) {
                this.sLT = new a();
                this.sLT.X(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("native_info");
            if (optJSONObject != null) {
                this.sLT = new a();
                this.sLT.X(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("tinyapp_info");
            if (optJSONObject != null) {
                this.sLU = new b();
                b bVar = this.sLU;
                bVar.sNz = optJSONObject.optString("tinyapp_name");
                bVar.sNA = optJSONObject.optString("tinyapp_logo");
                bVar.sNB = optJSONObject.optString("tinyapp_desc");
                bVar.sAb = optJSONObject.optString("tinyapp_username");
                bVar.sAc = optJSONObject.optString("tinyapp_path");
                bVar.sNC = optJSONObject.optString("activity_tinyapp_btn_text");
                bVar.sND = optJSONObject.optInt("tinyapp_version", 0);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BindCardOrder", e, "", new Object[0]);
        }
    }
}
