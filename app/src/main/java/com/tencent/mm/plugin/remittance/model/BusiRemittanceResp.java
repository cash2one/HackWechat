package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp implements Parcelable {
    public static final Creator<BusiRemittanceResp> CREATOR = new 1();
    public int pKa = 0;
    public String pKb = "";
    public String pKc = "";
    public int pKd;
    public String pKe;
    public String pKf;
    public List<vv> pKg = new LinkedList();
    public io pKh;
    public int pKi = 0;
    public int pKj = 0;
    public int pKk = 400;

    BusiRemittanceResp() {
    }

    BusiRemittanceResp(JSONObject jSONObject) {
        this.pKa = jSONObject.optInt("show_photo", 0);
        this.pKb = jSONObject.optString("photo_url", "");
        this.pKc = jSONObject.optString("favor_desc", "");
        this.pKd = jSONObject.optInt("scan_scene", 0);
        this.pKe = jSONObject.optString("favor_req_sign", "");
        this.pKf = jSONObject.optString("favor_req_extend", "");
        this.pKi = jSONObject.optInt("get_favor_flag", 0);
        this.pKj = jSONObject.optInt("photo_style", 0);
        this.pKk = jSONObject.optInt("get_favor_interval", 400);
        this.pKg = b.r(jSONObject.optJSONArray("favor_list"));
        JSONObject optJSONObject = jSONObject.optJSONObject("favor_comm_resp");
        if (optJSONObject != null) {
            this.pKh = new io();
            this.pKh.vOP = optJSONObject.optString("default_fav_compose_id");
            this.pKh.vON = b.r(optJSONObject.optJSONArray("favor_info_list"));
            this.pKh.vOQ = optJSONObject.optString("favor_resp_sign");
            this.pKh.vOR = optJSONObject.optString("no_compose_wording");
            this.pKh.vOO = b.q(optJSONObject.optJSONArray("favor_compose_result_list"));
        }
    }

    protected BusiRemittanceResp(Parcel parcel) {
        int readInt;
        this.pKa = parcel.readInt();
        this.pKb = parcel.readString();
        this.pKc = parcel.readString();
        this.pKd = parcel.readInt();
        this.pKe = parcel.readString();
        this.pKf = parcel.readString();
        this.pKi = parcel.readInt();
        this.pKj = parcel.readInt();
        this.pKk = parcel.readInt();
        this.pKg = new LinkedList();
        int readInt2 = parcel.readInt();
        for (int i = 0; i < readInt2; i++) {
            byte[] bArr;
            readInt = parcel.readInt();
            if (readInt > 0) {
                bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                try {
                    vv vvVar = new vv();
                    vvVar.aF(bArr);
                    this.pKg.add(vvVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e, "", new Object[0]);
                }
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            bArr = new byte[readInt];
            parcel.readByteArray(bArr);
            this.pKh = new io();
            try {
                this.pKh.aF(bArr);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e2, "", new Object[0]);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte[] toByteArray;
        parcel.writeInt(this.pKa);
        parcel.writeString(this.pKb);
        parcel.writeString(this.pKc);
        parcel.writeInt(this.pKd);
        parcel.writeString(this.pKe);
        parcel.writeString(this.pKf);
        parcel.writeInt(this.pKi);
        parcel.writeInt(this.pKj);
        parcel.writeInt(this.pKk);
        parcel.writeInt(this.pKg.size());
        if (this.pKg.size() > 0) {
            for (int i2 = 0; i2 < this.pKg.size(); i2++) {
                byte[] bArr = new byte[0];
                try {
                    toByteArray = ((vv) this.pKg.get(i2)).toByteArray();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e, "", new Object[0]);
                    toByteArray = bArr;
                }
                parcel.writeInt(toByteArray.length);
                if (toByteArray.length > 0) {
                    parcel.writeByteArray(toByteArray);
                }
            }
        }
        toByteArray = new byte[0];
        try {
            toByteArray = this.pKh.toByteArray();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e2, "", new Object[0]);
        }
        parcel.writeInt(toByteArray.length);
        if (toByteArray.length > 0) {
            parcel.writeByteArray(toByteArray);
        }
    }

    public int describeContents() {
        return 0;
    }
}
