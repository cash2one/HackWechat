package com.tencent.mm.plugin.card.sharecard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.g.b.cz;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.c.big;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.protocal.c.ki;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.protocal.c.ko;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public class ShareCardInfo extends cz implements Parcelable, b {
    public static final Creator<ShareCardInfo> CREATOR = new 1();
    protected static a gJc;
    public String kJS = "";
    public ko kKS;
    public kg kKT;
    public big kKU;
    public kj kKV;
    public boolean kKW = true;

    static {
        a aVar = new a();
        aVar.hSY = new Field[19];
        aVar.columns = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_id";
        aVar.xjA.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "card_id";
        aVar.columns[1] = "card_tp_id";
        aVar.xjA.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "from_username";
        aVar.xjA.put("from_username", "TEXT");
        stringBuilder.append(" from_username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "consumer";
        aVar.xjA.put("consumer", "TEXT");
        stringBuilder.append(" consumer TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "app_id";
        aVar.xjA.put("app_id", "TEXT");
        stringBuilder.append(" app_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "share_time";
        aVar.xjA.put("share_time", "LONG");
        stringBuilder.append(" share_time LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "local_updateTime";
        aVar.xjA.put("local_updateTime", "LONG");
        stringBuilder.append(" local_updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "updateTime";
        aVar.xjA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "begin_time";
        aVar.xjA.put("begin_time", "LONG");
        stringBuilder.append(" begin_time LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "end_time";
        aVar.xjA.put("end_time", "LONG");
        stringBuilder.append(" end_time LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "updateSeq";
        aVar.xjA.put("updateSeq", "LONG");
        stringBuilder.append(" updateSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "block_mask";
        aVar.xjA.put("block_mask", "LONG");
        stringBuilder.append(" block_mask LONG");
        stringBuilder.append(", ");
        aVar.columns[13] = "dataInfoData";
        aVar.xjA.put("dataInfoData", "BLOB");
        stringBuilder.append(" dataInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "cardTpInfoData";
        aVar.xjA.put("cardTpInfoData", "BLOB");
        stringBuilder.append(" cardTpInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[15] = "shareInfoData";
        aVar.xjA.put("shareInfoData", "BLOB");
        stringBuilder.append(" shareInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[16] = "shopInfoData";
        aVar.xjA.put("shopInfoData", "BLOB");
        stringBuilder.append(" shopInfoData BLOB");
        stringBuilder.append(", ");
        aVar.columns[17] = "categoryType";
        aVar.xjA.put("categoryType", "INTEGER default '0' ");
        stringBuilder.append(" categoryType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "itemIndex";
        aVar.xjA.put("itemIndex", "INTEGER default '0' ");
        stringBuilder.append(" itemIndex INTEGER default '0' ");
        aVar.columns[19] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final boolean ati() {
        return atB() != null && atB().kJO == 10;
    }

    public final boolean atj() {
        return atB() != null && atB().kJO == 0;
    }

    public final boolean atk() {
        return atB() != null && atB().kJO == 20;
    }

    public final boolean atl() {
        return atB() != null && atB().kJO == 11;
    }

    public final boolean atm() {
        return atB() != null && atB().kJO == 30;
    }

    public final boolean atn() {
        return l.nG(atB().kJO);
    }

    public final boolean ato() {
        return (atB().vRP & 2) == 0;
    }

    public final boolean atp() {
        return (atB().vRP & 1) == 0;
    }

    public final boolean atq() {
        return (atB().vRS & 1) == 0;
    }

    public final boolean atr() {
        return (atB().vRS & 16) == 0;
    }

    public final boolean ats() {
        return (atB().vRS & 2) > 0;
    }

    public final boolean att() {
        return false;
    }

    public final boolean atu() {
        return (atB().vRS & 4) > 0;
    }

    public final boolean atv() {
        return (atB().vRS & 8) > 0;
    }

    public final boolean atx() {
        return this.kKT != null && this.kKT.status == 0;
    }

    public final boolean isAcceptable() {
        if (!atx()) {
            return false;
        }
        if (this.kKS != null) {
            x.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.kKS.vSf);
        }
        x.i("MicroMsg.ShareCardInfo", "stock_num:" + this.kKT.vRg + " limit_num:" + this.kKT.vRh);
        if (this.kKS == null || this.kKS.vSf != 1) {
            return ((this.kKS == null || this.kKS.vSf != 0) && this.kKT.vRg != 0 && this.kKT.vRh == 0) ? false : false;
        } else {
            return true;
        }
    }

    public final boolean aty() {
        if (!atx()) {
            return false;
        }
        if (this.kKS != null) {
            x.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.kKS.vSf);
        }
        x.i("MicroMsg.ShareCardInfo", "avail_num:" + this.kKT.vRd);
        if (this.kKS != null && this.kKS.vSf == 1) {
            return true;
        }
        if (this.kKT.vRd > 0) {
            return true;
        }
        return ((this.kKS == null || this.kKS.vSf != 0) && this.kKT.vRd == 0) ? false : false;
    }

    public final boolean atz() {
        if (this.kKS == null || this.kKS.vRW == null || TextUtils.isEmpty(this.kKS.vRW.text)) {
            return false;
        }
        ki kiVar = this.kKS.vRW;
        int currentTimeMillis = kiVar.qox - ((int) (System.currentTimeMillis() / 1000));
        if (kiVar.qox <= 0 || currentTimeMillis <= 0) {
            return false;
        }
        return true;
    }

    public final boolean atA() {
        return this.kKS != null && this.kKS.vSj == 1;
    }

    public final ko atB() {
        if (this.kKS != null) {
            return this.kKS;
        }
        try {
            this.kKS = (ko) new ko().aF(this.field_cardTpInfoData);
            return this.kKS;
        } catch (Throwable e) {
            x.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            return new ko();
        }
    }

    public final kg atC() {
        if (this.kKT != null) {
            return this.kKT;
        }
        try {
            this.kKT = (kg) new kg().aF(this.field_dataInfoData);
            return this.kKT;
        } catch (Throwable e) {
            x.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            return new kg();
        }
    }

    public final void a(kg kgVar) {
        this.kKT = kgVar;
        if (this.kKT != null) {
            try {
                this.field_dataInfoData = kgVar.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            }
        }
    }

    public final big atD() {
        if (this.kKU != null) {
            return this.kKU;
        }
        try {
            this.kKU = (big) new big().aF(this.field_shareInfoData);
            return this.kKU;
        } catch (Throwable e) {
            x.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            return new big();
        }
    }

    public final kj atE() {
        if (this.kKV != null) {
            return this.kKV;
        }
        try {
            this.kKV = (kj) new kj().aF(this.field_shopInfoData);
            return this.kKV;
        } catch (Throwable e) {
            x.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            return null;
        }
    }

    public final void a(kj kjVar) {
        this.kKV = kjVar;
        try {
            this.field_shopInfoData = kjVar.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.ShareCardInfo", e, "", new Object[0]);
        }
    }

    public ShareCardInfo(Parcel parcel) {
        int i;
        int i2 = 0;
        this.field_card_id = parcel.readString();
        this.field_card_tp_id = parcel.readString();
        this.field_from_username = parcel.readString();
        this.field_status = parcel.readInt();
        this.field_share_time = parcel.readLong();
        this.field_local_updateTime = parcel.readLong();
        this.field_updateTime = parcel.readLong();
        this.field_updateSeq = parcel.readLong();
        this.field_block_mask = parcel.readLong();
        this.field_end_time = parcel.readLong();
        this.field_categoryType = parcel.readInt();
        this.field_itemIndex = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_dataInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_dataInfoData[i] = parcel.readByte();
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_cardTpInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_cardTpInfoData[i] = parcel.readByte();
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_shareInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_shareInfoData[i] = parcel.readByte();
            }
        }
        i = parcel.readInt();
        if (i > 0) {
            this.field_shopInfoData = new byte[i];
            while (i2 < i) {
                this.field_shopInfoData[i2] = parcel.readByte();
                i2++;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.field_card_id);
        parcel.writeString(this.field_card_tp_id);
        parcel.writeString(this.field_from_username);
        parcel.writeInt(this.field_status);
        parcel.writeLong(this.field_share_time);
        parcel.writeLong(this.field_local_updateTime);
        parcel.writeLong(this.field_updateTime);
        parcel.writeLong(this.field_updateSeq);
        parcel.writeLong(this.field_block_mask);
        parcel.writeLong(this.field_end_time);
        parcel.writeInt(this.field_categoryType);
        parcel.writeInt(this.field_itemIndex);
        if (this.field_dataInfoData != null) {
            parcel.writeInt(this.field_dataInfoData.length);
            for (byte writeByte : this.field_dataInfoData) {
                parcel.writeByte(writeByte);
            }
        }
        if (this.field_cardTpInfoData != null) {
            parcel.writeInt(this.field_cardTpInfoData.length);
            for (byte writeByte2 : this.field_cardTpInfoData) {
                parcel.writeByte(writeByte2);
            }
        }
        if (this.field_shareInfoData != null) {
            parcel.writeInt(this.field_shareInfoData.length);
            for (byte writeByte22 : this.field_shareInfoData) {
                parcel.writeByte(writeByte22);
            }
        }
        if (this.field_shopInfoData != null) {
            parcel.writeInt(this.field_shopInfoData.length);
            while (i2 < this.field_shopInfoData.length) {
                parcel.writeByte(this.field_shopInfoData[i2]);
                i2++;
            }
        }
    }

    public final long getEndTime() {
        return this.field_end_time;
    }

    public final String atF() {
        return this.field_card_id;
    }

    public final String atG() {
        return this.field_card_tp_id;
    }

    public final String atH() {
        return this.field_from_username;
    }

    public final void vT(String str) {
        this.field_from_username = str;
    }

    public final long atI() {
        return this.field_local_updateTime;
    }

    public final boolean atg() {
        return atB() != null && atB().vRZ == 0;
    }

    public final boolean ath() {
        return atB() != null && atB().vRZ == 1;
    }

    public final String nE(int i) {
        if (i == 10) {
            return (String) am.auF().getValue("key_share_card_local_city");
        }
        if (i != 0) {
            return "";
        }
        if (com.tencent.mm.plugin.card.sharecard.a.b.auV()) {
            return ac.getResources().getString(R.l.dOZ);
        }
        return "";
    }

    public final String atJ() {
        return "";
    }

    public final int atK() {
        return this.field_categoryType;
    }

    public final String atL() {
        x.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.kJS);
        return this.kJS;
    }

    public final boolean atw() {
        return atB() != null && atB().vSe == 1;
    }
}
