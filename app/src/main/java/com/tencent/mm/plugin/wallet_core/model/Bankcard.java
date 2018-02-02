package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.b.dr;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Field;

public class Bankcard extends dr implements Parcelable {
    public static final Creator<Bankcard> CREATOR = new Creator<Bankcard>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Bankcard(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Bankcard[i];
        }
    };
    public static a gJc;
    public static int sKR = 1;
    public static int sKS = 2;
    public static int sKT = 4;
    public static int sKU = 8;
    public static int sKV = 16;
    public static int sKW = 32;
    public static int sKX = 64;
    public static int sKY = FileUtils.S_IWUSR;
    public String sKZ;
    public int sKv;
    public String sKx;
    public String sLa;
    public String sLb;
    public String sLd;
    public String sLe;
    public double sLf;
    public String sLg;
    public double sLh;
    public String sLi;
    public String sLj;
    public String sLk;
    public String sLl;
    public boolean sLm;
    public e sLn;
    public long sLo;
    public long sLp;
    public long sLq;
    public String sLr;
    public int sLs;

    static {
        a aVar = new a();
        aVar.hSY = new Field[39];
        aVar.columns = new String[40];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bindSerial";
        aVar.xjA.put("bindSerial", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "bindSerial";
        aVar.columns[1] = "cardType";
        aVar.xjA.put("cardType", "INTEGER");
        stringBuilder.append(" cardType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "bankcardState";
        aVar.xjA.put("bankcardState", "INTEGER");
        stringBuilder.append(" bankcardState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "forbidWord";
        aVar.xjA.put("forbidWord", "TEXT");
        stringBuilder.append(" forbidWord TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "bankName";
        aVar.xjA.put("bankName", "TEXT");
        stringBuilder.append(" bankName TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "bankcardType";
        aVar.xjA.put("bankcardType", "TEXT");
        stringBuilder.append(" bankcardType TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "bankcardTypeName";
        aVar.xjA.put("bankcardTypeName", "TEXT");
        stringBuilder.append(" bankcardTypeName TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "bankcardTag";
        aVar.xjA.put("bankcardTag", "INTEGER");
        stringBuilder.append(" bankcardTag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "bankcardTail";
        aVar.xjA.put("bankcardTail", "TEXT");
        stringBuilder.append(" bankcardTail TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "supportTag";
        aVar.xjA.put("supportTag", "INTEGER");
        stringBuilder.append(" supportTag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "mobile";
        aVar.xjA.put("mobile", "TEXT");
        stringBuilder.append(" mobile TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "trueName";
        aVar.xjA.put("trueName", "TEXT");
        stringBuilder.append(" trueName TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "desc";
        aVar.xjA.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "bankPhone";
        aVar.xjA.put("bankPhone", "TEXT");
        stringBuilder.append(" bankPhone TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "bizUsername";
        aVar.xjA.put("bizUsername", "TEXT");
        stringBuilder.append(" bizUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "onceQuotaKind";
        aVar.xjA.put("onceQuotaKind", "DOUBLE");
        stringBuilder.append(" onceQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[16] = "onceQuotaVirtual";
        aVar.xjA.put("onceQuotaVirtual", "DOUBLE");
        stringBuilder.append(" onceQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[17] = "dayQuotaKind";
        aVar.xjA.put("dayQuotaKind", "DOUBLE");
        stringBuilder.append(" dayQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[18] = "dayQuotaVirtual";
        aVar.xjA.put("dayQuotaVirtual", "DOUBLE");
        stringBuilder.append(" dayQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[19] = "fetchArriveTime";
        aVar.xjA.put("fetchArriveTime", "LONG");
        stringBuilder.append(" fetchArriveTime LONG");
        stringBuilder.append(", ");
        aVar.columns[20] = "fetchArriveTimeWording";
        aVar.xjA.put("fetchArriveTimeWording", "TEXT");
        stringBuilder.append(" fetchArriveTimeWording TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "repay_url";
        aVar.xjA.put("repay_url", "TEXT");
        stringBuilder.append(" repay_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "wxcreditState";
        aVar.xjA.put("wxcreditState", "INTEGER");
        stringBuilder.append(" wxcreditState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "bankcardClientType";
        aVar.xjA.put("bankcardClientType", "INTEGER");
        stringBuilder.append(" bankcardClientType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[24] = "ext_msg";
        aVar.xjA.put("ext_msg", "TEXT");
        stringBuilder.append(" ext_msg TEXT");
        stringBuilder.append(", ");
        aVar.columns[25] = "support_micropay";
        aVar.xjA.put("support_micropay", "INTEGER");
        stringBuilder.append(" support_micropay INTEGER");
        stringBuilder.append(", ");
        aVar.columns[26] = "arrive_type";
        aVar.xjA.put("arrive_type", "TEXT");
        stringBuilder.append(" arrive_type TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "avail_save_wording";
        aVar.xjA.put("avail_save_wording", "TEXT");
        stringBuilder.append(" avail_save_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[28] = "fetch_charge_rate";
        aVar.xjA.put("fetch_charge_rate", "DOUBLE");
        stringBuilder.append(" fetch_charge_rate DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[29] = "full_fetch_charge_fee";
        aVar.xjA.put("full_fetch_charge_fee", "DOUBLE");
        stringBuilder.append(" full_fetch_charge_fee DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[30] = "fetch_charge_info";
        aVar.xjA.put("fetch_charge_info", "TEXT");
        stringBuilder.append(" fetch_charge_info TEXT");
        stringBuilder.append(", ");
        aVar.columns[31] = "tips";
        aVar.xjA.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "forbid_title";
        aVar.xjA.put("forbid_title", "TEXT");
        stringBuilder.append(" forbid_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "forbid_url";
        aVar.xjA.put("forbid_url", "TEXT");
        stringBuilder.append(" forbid_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "no_micro_word";
        aVar.xjA.put("no_micro_word", "TEXT");
        stringBuilder.append(" no_micro_word TEXT");
        stringBuilder.append(", ");
        aVar.columns[35] = "card_bottom_wording";
        aVar.xjA.put("card_bottom_wording", "TEXT");
        stringBuilder.append(" card_bottom_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[36] = "support_lqt_turn_in";
        aVar.xjA.put("support_lqt_turn_in", "INTEGER");
        stringBuilder.append(" support_lqt_turn_in INTEGER");
        stringBuilder.append(", ");
        aVar.columns[37] = "support_lqt_turn_out";
        aVar.xjA.put("support_lqt_turn_out", "INTEGER");
        stringBuilder.append(" support_lqt_turn_out INTEGER");
        stringBuilder.append(", ");
        aVar.columns[38] = "is_hightlight_pre_arrive_time_wording";
        aVar.xjA.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
        stringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
        aVar.columns[39] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    public Bankcard() {
        this.sLe = null;
        this.sLl = null;
        this.sLm = false;
    }

    public Bankcard(byte b) {
        this.sLe = null;
        this.sLl = null;
        this.sLm = false;
        this.field_bankcardTag = 1;
    }

    public static boolean dY(int i, int i2) {
        x.d("MicroMsg.Bankcard", "supportBankcardTag : " + i + ", bankcardTag : " + i2);
        return (i & i2) > 0;
    }

    public static boolean zh(int i) {
        return (i & 2) > 0;
    }

    public final int a(int i, Orders orders) {
        if (this.field_bankcardState != 0) {
            x.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
            return this.field_bankcardState;
        } else if (orders != null && orders.fuH.equals(this.sLe)) {
            return 4;
        } else {
            int i2;
            if ((this.field_bankcardTag & i) > 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                if (bKS()) {
                    return 5;
                }
                return 6;
            } else if (orders == null || orders.sNT.isEmpty() || orders.sNT.contains(this.field_bankcardType)) {
                return 0;
            } else {
                return 7;
            }
        }
    }

    public static String N(Context context, int i) {
        switch (i) {
            case 1:
                return context.getString(i.uUw);
            case 2:
                return context.getString(i.uUC);
            case 3:
                return context.getString(i.uUH);
            case 4:
                return context.getString(i.uUy);
            case 5:
                return context.getString(i.uUu);
            case 6:
                return context.getString(i.uUA);
            case 7:
                return context.getString(i.uUF);
            default:
                return context.getString(i.uUD);
        }
    }

    public final boolean bKO() {
        boolean z = (this.field_cardType & sKT) > 0;
        x.d("MicroMsg.Bankcard", "isWXCredit, ret = " + z);
        return z;
    }

    public final boolean bKP() {
        boolean z = (this.field_cardType & sKU) > 0;
        x.d("MicroMsg.Bankcard", "isWXCredit, ret = " + z);
        return z;
    }

    public final boolean bKQ() {
        boolean z = (this.field_cardType & sKX) > 0;
        x.d("MicroMsg.Bankcard", "isLqtCard, ret = " + z);
        return z;
    }

    public final boolean bKR() {
        boolean z = (this.field_cardType & sKS) > 0;
        x.d("MicroMsg.Bankcard", "isCredit, ret = " + z);
        return z;
    }

    public final boolean bKS() {
        boolean z = (this.field_cardType & sKR) <= 0;
        x.d("MicroMsg.Bankcard", "isDomestic, ret = " + z);
        return z;
    }

    public final boolean bKT() {
        return (this.field_cardType & sKY) > 0;
    }

    protected final a Ac() {
        return gJc;
    }

    public int describeContents() {
        return 0;
    }

    public Bankcard(Parcel parcel) {
        boolean z = true;
        this.sLe = null;
        this.sLl = null;
        this.sLm = false;
        this.field_bankName = parcel.readString();
        this.field_desc = parcel.readString();
        this.field_bankcardType = parcel.readString();
        this.field_bindSerial = parcel.readString();
        this.field_cardType = parcel.readInt();
        this.sLm = parcel.readInt() == 1;
        this.field_mobile = parcel.readString();
        this.field_onceQuotaKind = parcel.readDouble();
        this.field_onceQuotaVirtual = parcel.readDouble();
        this.field_dayQuotaKind = parcel.readDouble();
        this.field_dayQuotaVirtual = parcel.readDouble();
        this.field_bankcardTail = parcel.readString();
        this.field_bankPhone = parcel.readString();
        this.field_bankcardTag = parcel.readInt();
        this.field_bankcardState = parcel.readInt();
        this.sLe = parcel.readString();
        this.sKv = parcel.readInt();
        this.sLl = parcel.readString();
        this.field_bankcardClientType = parcel.readInt();
        this.field_ext_msg = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.field_support_micropay = z;
        this.field_arrive_type = parcel.readString();
        this.field_fetch_charge_rate = parcel.readDouble();
        this.field_full_fetch_charge_fee = parcel.readDouble();
        this.field_no_micro_word = parcel.readString();
        this.field_card_bottom_wording = parcel.readString();
        this.sLr = parcel.readString();
        this.sLo = parcel.readLong();
        this.sLq = parcel.readLong();
        this.sLp = parcel.readLong();
        this.sLs = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.field_bankName);
        parcel.writeString(this.field_desc);
        parcel.writeString(this.field_bankcardType);
        parcel.writeString(this.field_bindSerial);
        parcel.writeInt(this.field_cardType);
        parcel.writeInt(this.sLm ? 1 : 0);
        parcel.writeString(this.field_mobile);
        parcel.writeDouble(this.field_onceQuotaKind);
        parcel.writeDouble(this.field_onceQuotaVirtual);
        parcel.writeDouble(this.field_dayQuotaKind);
        parcel.writeDouble(this.field_dayQuotaVirtual);
        parcel.writeString(this.field_bankcardTail);
        parcel.writeString(this.field_bankPhone);
        parcel.writeInt(this.field_bankcardTag);
        parcel.writeInt(this.field_bankcardState);
        parcel.writeString(this.sLe);
        parcel.writeInt(this.sKv);
        parcel.writeString(this.sLl);
        parcel.writeInt(this.field_bankcardClientType);
        parcel.writeString(this.field_ext_msg);
        if (!this.field_support_micropay) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.field_arrive_type);
        parcel.writeDouble(this.field_fetch_charge_rate);
        parcel.writeDouble(this.field_full_fetch_charge_fee);
        parcel.writeString(this.field_no_micro_word);
        parcel.writeString(this.field_card_bottom_wording);
        parcel.writeString(this.sLr);
        parcel.writeLong(this.sLo);
        parcel.writeLong(this.sLq);
        parcel.writeLong(this.sLp);
        parcel.writeInt(this.sLs);
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }
}
