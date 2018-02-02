package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject implements Parcelable {
    public static final Creator<MallTransactionObject> CREATOR = new Creator<MallTransactionObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallTransactionObject(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallTransactionObject[i];
        }
    };
    public String desc;
    public int fjw;
    public int fpn;
    public String fuI;
    public int hzW;
    public String iOg;
    public double ljg = 0.0d;
    public List<HelpCenter> oZZ = new LinkedList();
    public String paA;
    public String paB;
    public String paC;
    public String paD;
    public String paE;
    public double paF;
    public String paG;
    public String paH;
    public String paI;
    public String paJ;
    public String paK;
    public int paL;
    public int paM;
    public double paN;
    public String paO;
    public int paP;
    public String paQ;
    public int paR;
    public int paS;
    public int paT;
    public String paU;
    public String paV;
    public String paW;
    public String paX;
    public String paY;
    public String paZ;
    public int paa = -1;
    public String pac;
    public int pak;
    public String pal;
    public String pam;
    public String pan;
    public String pao;
    public String pap;
    public String paq;
    public String par;
    public String pas;
    public String pat;
    public String pau;
    public int pav;
    public String paw;
    public String pax;
    public String pay;
    public String paz;
    public double pba;
    public String pbb;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallTransactionObject(Parcel parcel) {
        this.fpn = parcel.readInt();
        this.pak = parcel.readInt();
        this.fjw = parcel.readInt();
        this.pal = parcel.readString();
        this.pam = parcel.readString();
        this.pan = parcel.readString();
        this.pao = parcel.readString();
        this.desc = parcel.readString();
        this.pap = parcel.readString();
        this.paq = parcel.readString();
        this.ljg = parcel.readDouble();
        this.par = parcel.readString();
        this.pas = parcel.readString();
        this.pat = parcel.readString();
        this.pau = parcel.readString();
        this.hzW = parcel.readInt();
        this.pav = parcel.readInt();
        this.fuI = parcel.readString();
        this.paw = parcel.readString();
        this.pax = parcel.readString();
        this.paz = parcel.readString();
        this.paA = parcel.readString();
        this.pac = parcel.readString();
        this.paB = parcel.readString();
        this.iOg = parcel.readString();
        this.paC = parcel.readString();
        this.paD = parcel.readString();
        this.paE = parcel.readString();
        this.paF = parcel.readDouble();
        this.paG = parcel.readString();
        this.paH = parcel.readString();
        this.paI = parcel.readString();
        this.paJ = parcel.readString();
        this.paL = parcel.readInt();
        this.paR = parcel.readInt();
        this.paN = parcel.readDouble();
        this.paO = parcel.readString();
        this.paP = parcel.readInt();
        this.paQ = parcel.readString();
        this.paR = parcel.readInt();
        this.paS = parcel.readInt();
        this.paT = parcel.readInt();
        this.paU = parcel.readString();
        this.paV = parcel.readString();
        this.paW = parcel.readString();
        this.paX = parcel.readString();
        this.paY = parcel.readString();
        this.paZ = parcel.readString();
        this.pba = parcel.readDouble();
        this.pbb = parcel.readString();
        this.paK = parcel.readString();
        this.paa = parcel.readInt();
        int readInt = parcel.readInt();
        this.oZZ = new LinkedList();
        for (int i = 0; i < readInt; i++) {
            this.oZZ.add((HelpCenter) parcel.readParcelable(HelpCenter.class.getClassLoader()));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fpn);
        parcel.writeInt(this.pak);
        parcel.writeInt(this.fjw);
        parcel.writeString(this.pal);
        parcel.writeString(this.pam);
        parcel.writeString(this.pan);
        parcel.writeString(this.pao);
        parcel.writeString(this.desc);
        parcel.writeString(this.pap);
        parcel.writeString(this.paq);
        parcel.writeDouble(this.ljg);
        parcel.writeString(this.par);
        parcel.writeString(this.pas);
        parcel.writeString(this.pat);
        parcel.writeString(this.pau);
        parcel.writeInt(this.hzW);
        parcel.writeInt(this.pav);
        parcel.writeString(this.fuI);
        parcel.writeString(this.paw);
        parcel.writeString(this.pax);
        parcel.writeString(this.paz);
        parcel.writeString(this.paA);
        parcel.writeString(this.pac);
        parcel.writeString(this.paB);
        parcel.writeString(this.iOg);
        parcel.writeString(this.paC);
        parcel.writeString(this.paD);
        parcel.writeString(this.paE);
        parcel.writeDouble(this.paF);
        parcel.writeString(this.paG);
        parcel.writeString(this.paH);
        parcel.writeString(this.paI);
        parcel.writeString(this.paJ);
        parcel.writeInt(this.paL);
        parcel.writeInt(this.paR);
        parcel.writeDouble(this.paN);
        parcel.writeString(this.paO);
        parcel.writeInt(this.paP);
        parcel.writeString(this.paQ);
        parcel.writeInt(this.paR);
        parcel.writeInt(this.paS);
        parcel.writeInt(this.paT);
        parcel.writeString(this.paU);
        parcel.writeString(this.paV);
        parcel.writeString(this.paW);
        parcel.writeString(this.paX);
        parcel.writeString(this.paY);
        parcel.writeString(this.paZ);
        parcel.writeDouble(this.pba);
        parcel.writeString(this.pbb);
        parcel.writeString(this.paK);
        parcel.writeInt(this.paa);
        parcel.writeInt(this.oZZ.size());
        for (HelpCenter writeParcelable : this.oZZ) {
            parcel.writeParcelable(writeParcelable, i);
        }
    }

    public static MallTransactionObject P(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MallTransactionObject mallTransactionObject = new MallTransactionObject();
        mallTransactionObject.type = jSONObject.optInt("rec_type", 1);
        mallTransactionObject.fpn = jSONObject.optInt("sub_pay_type", 0);
        mallTransactionObject.pak = jSONObject.optInt("pay_scene");
        mallTransactionObject.fjw = jSONObject.optInt("user_type");
        mallTransactionObject.pal = jSONObject.optString("buy_uin");
        mallTransactionObject.pam = jSONObject.optString("buy_name");
        mallTransactionObject.pan = jSONObject.optString("sale_uin");
        mallTransactionObject.pao = jSONObject.optString("sale_name");
        mallTransactionObject.fuI = jSONObject.optString("trans_id");
        mallTransactionObject.paw = jSONObject.optString("sp_billno");
        mallTransactionObject.desc = jSONObject.optString("goods_name");
        mallTransactionObject.pap = jSONObject.optString("goods_detail");
        mallTransactionObject.ljg = jSONObject.optDouble("fee") / 100.0d;
        mallTransactionObject.par = jSONObject.optString("fee_color");
        mallTransactionObject.pas = jSONObject.optString("trade_state");
        mallTransactionObject.pat = jSONObject.optString("trade_state_name");
        mallTransactionObject.pau = jSONObject.optString("trade_state_color");
        mallTransactionObject.pax = jSONObject.optString("buy_bank_name");
        mallTransactionObject.pay = jSONObject.optString("card_tail");
        mallTransactionObject.hzW = jSONObject.optInt("create_timestamp");
        mallTransactionObject.pav = jSONObject.optInt("modify_timestamp");
        mallTransactionObject.paz = jSONObject.optString("fee_type");
        JSONObject optJSONObject = jSONObject.optJSONObject("appinfo");
        if (optJSONObject != null) {
            mallTransactionObject.paA = optJSONObject.optString("app_username");
            mallTransactionObject.pac = optJSONObject.optString("app_telephone");
            mallTransactionObject.paB = optJSONObject.optString("app_nickname");
            mallTransactionObject.iOg = optJSONObject.optString("app_icon_url");
            mallTransactionObject.paJ = optJSONObject.optString("safeguard_url");
            mallTransactionObject.paK = optJSONObject.optString(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
        }
        mallTransactionObject.paC = jSONObject.optString("deliver_price");
        mallTransactionObject.paD = jSONObject.optString("preferential_price");
        mallTransactionObject.paE = jSONObject.optString("discount");
        mallTransactionObject.paF = jSONObject.optDouble("original_total_fee") / 100.0d;
        mallTransactionObject.paG = jSONObject.optString("total_price");
        mallTransactionObject.paH = jSONObject.optString("receipt_company");
        mallTransactionObject.paI = jSONObject.optString("biz_pledge");
        mallTransactionObject.paL = jSONObject.optInt("pre_fetch_timestamp");
        mallTransactionObject.paM = jSONObject.optInt("arrived_timestamp");
        mallTransactionObject.paN = jSONObject.optDouble("transfer_fee") / 100.0d;
        mallTransactionObject.paO = jSONObject.optString("receiver_name");
        mallTransactionObject.paP = jSONObject.optInt("allow_resend_msg");
        mallTransactionObject.paQ = jSONObject.optString("charge_fee");
        mallTransactionObject.paR = jSONObject.optInt("receive_timestamp");
        mallTransactionObject.paS = jSONObject.optInt("refund_timestamp");
        mallTransactionObject.paT = jSONObject.optInt("create_timestamp");
        mallTransactionObject.paU = jSONObject.optString("buy_bank_type");
        mallTransactionObject.paV = jSONObject.optString("payer_name");
        mallTransactionObject.paW = jSONObject.optString("true_name");
        mallTransactionObject.paX = jSONObject.optString("refund_bank_type");
        mallTransactionObject.paY = jSONObject.optString("rateinfo");
        mallTransactionObject.paZ = jSONObject.optString("original_feeinfo");
        mallTransactionObject.pba = jSONObject.optDouble("fetch_total_fee") / 100.0d;
        mallTransactionObject.pbb = jSONObject.optString("fetch_total_fee_color");
        mallTransactionObject.paa = jSONObject.optInt("userroll_type");
        mallTransactionObject.oZZ = Q(jSONObject);
        return mallTransactionObject;
    }

    private static List<HelpCenter> Q(JSONObject jSONObject) {
        List<HelpCenter> linkedList = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("help_center");
            for (int i = 0; i < jSONArray.length(); i++) {
                HelpCenter helpCenter = new HelpCenter();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                helpCenter.fpa = jSONObject2.optBoolean("is_show_button");
                helpCenter.name = jSONObject2.optString("name");
                helpCenter.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                linkedList.add(helpCenter);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallTransactionObject", e, "", new Object[0]);
            x.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", new Object[]{e.getMessage()});
        }
        return linkedList;
    }
}
