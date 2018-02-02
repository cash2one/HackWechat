package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.aac;
import com.tencent.mm.protocal.c.an;
import com.tencent.mm.protocal.c.ao;
import com.tencent.mm.protocal.c.ap;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo implements Parcelable {
    public static final Creator<CardGiftInfo> CREATOR = new 1();
    public String fFh;
    public String hbM;
    public String kKA;
    public String kKB;
    public String kKC;
    public String kKD;
    public String kKE;
    public String kKF;
    public String kKG;
    public String kKH;
    public LinkedList<AcceptedCardItem> kKI = new LinkedList();
    public LinkedList<AccepterItem> kKJ = new LinkedList();
    public String kKK;
    public int kKL;
    public String kKM;
    public String kKN;
    public String kKf;
    public String kKg;
    public String kKh;
    public String kKi;
    public String kKj;
    public String kKk;
    public String kKl;
    public String kKm;
    public String kKn;
    public String kKo;
    public String kKp;
    public String kKq;
    public String kKr;
    public boolean kKs;
    public int kKt;
    public int kKu;
    public int kKv;
    public String kKw;
    public String kKx;
    public int kKy;
    public String kKz;
    public String toUserName;

    protected CardGiftInfo(Parcel parcel) {
        this.toUserName = parcel.readString();
        this.fFh = parcel.readString();
        this.kKf = parcel.readString();
        this.kKg = parcel.readString();
        this.kKh = parcel.readString();
        this.kKi = parcel.readString();
        this.kKj = parcel.readString();
        this.kKk = parcel.readString();
        this.kKl = parcel.readString();
        this.kKm = parcel.readString();
        this.kKn = parcel.readString();
        this.kKo = parcel.readString();
        this.kKp = parcel.readString();
        this.kKq = parcel.readString();
        this.kKr = parcel.readString();
        this.hbM = parcel.readString();
        this.kKs = parcel.readByte() != (byte) 0;
        this.kKt = parcel.readInt();
        this.kKu = parcel.readInt();
        this.kKv = parcel.readInt();
        this.kKw = parcel.readString();
        this.kKx = parcel.readString();
        this.kKy = parcel.readInt();
        this.kKz = parcel.readString();
        this.kKA = parcel.readString();
        this.kKB = parcel.readString();
        this.kKC = parcel.readString();
        this.kKD = parcel.readString();
        this.kKE = parcel.readString();
        this.kKF = parcel.readString();
        this.kKG = parcel.readString();
        this.kKH = parcel.readString();
        parcel.readTypedList(this.kKI, AcceptedCardItem.CREATOR);
        parcel.readTypedList(this.kKJ, AccepterItem.CREATOR);
        this.kKK = parcel.readString();
        this.kKL = parcel.readInt();
        this.kKM = parcel.readString();
        this.kKN = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.toUserName);
        parcel.writeString(this.fFh);
        parcel.writeString(this.kKf);
        parcel.writeString(this.kKg);
        parcel.writeString(this.kKh);
        parcel.writeString(this.kKi);
        parcel.writeString(this.kKj);
        parcel.writeString(this.kKk);
        parcel.writeString(this.kKl);
        parcel.writeString(this.kKm);
        parcel.writeString(this.kKn);
        parcel.writeString(this.kKo);
        parcel.writeString(this.kKp);
        parcel.writeString(this.kKq);
        parcel.writeString(this.kKr);
        parcel.writeString(this.hbM);
        parcel.writeByte(this.kKs ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.kKt);
        parcel.writeInt(this.kKu);
        parcel.writeInt(this.kKv);
        parcel.writeString(this.kKw);
        parcel.writeString(this.kKx);
        parcel.writeInt(this.kKy);
        parcel.writeString(this.kKz);
        parcel.writeString(this.kKA);
        parcel.writeString(this.kKB);
        parcel.writeString(this.kKC);
        parcel.writeString(this.kKD);
        parcel.writeString(this.kKE);
        parcel.writeString(this.kKF);
        parcel.writeString(this.kKG);
        parcel.writeString(this.kKH);
        parcel.writeTypedList(this.kKI);
        parcel.writeTypedList(this.kKJ);
        parcel.writeString(this.kKK);
        parcel.writeInt(this.kKL);
        parcel.writeString(this.kKM);
        parcel.writeString(this.kKN);
    }

    public String toString() {
        return "CardGiftInfo{toUserName='" + this.toUserName + '\'' + ", fromUserName='" + this.fFh + '\'' + ", fromUserImgUrl='" + this.kKf + '\'' + ", fromUserContent='" + this.kKg + '\'' + ", fromUserContentPicUrl='" + this.kKh + '\'' + ", fromUserContentVideoUrl='" + this.kKi + '\'' + ", fromUserContentThumbPicUrl='" + this.kKj + '\'' + ", picAESKey='" + this.kKk + '\'' + ", videoAESKey='" + this.kKl + '\'' + ", thumbVideoAESKey='" + this.kKm + '\'' + ", cardBackgroundPicUrl='" + this.kKn + '\'' + ", cardLogoLUrl='" + this.kKo + '\'' + ", cardTitle='" + this.kKp + '\'' + ", cardPrice='" + this.kKq + '\'' + ", footerWording='" + this.kKr + '\'' + ", color='" + this.hbM + '\'' + ", needJump=" + this.kKs + ", picDataLength=" + this.kKt + ", videoDataLength=" + this.kKu + ", thumbDataLength=" + this.kKv + ", descTitle='" + this.kKw + '\'' + ", descIconUrl='" + this.kKx + '\'' + ", descLayoutMode=" + this.kKy + ", giftingMediaTitle='" + this.kKz + '\'' + ", descriptionTitleColor='" + this.kKA + '\'' + ", cardTitleColor='" + this.kKB + '\'' + ", cardPriceTitleColor='" + this.kKC + '\'' + ", userCardId='" + this.kKD + '\'' + ", operationTitle='" + this.kKE + '\'' + ", operationUrl='" + this.kKF + '\'' + ", cardTpId='" + this.kKG + '\'' + ", cardCode='" + this.kKH + '\'' + ", accepted_card_list_size='" + this.kKI.size() + '\'' + ", accepter_list_size='" + this.kKJ.size() + '\'' + ", accepter_list_title='" + this.kKK + '\'' + ", out_of_card='" + this.kKL + '\'' + ", operation_wxa_username='" + this.kKM + '\'' + ", operation_wxa_path='" + this.kKN + '\'' + '}';
    }

    public static CardGiftInfo a(an anVar) {
        CardGiftInfo cardGiftInfo = new CardGiftInfo();
        cardGiftInfo.toUserName = anVar.vEQ;
        cardGiftInfo.fFh = anVar.vER;
        cardGiftInfo.kKf = anVar.vES;
        cardGiftInfo.kKg = anVar.content;
        cardGiftInfo.kKh = anVar.vET;
        cardGiftInfo.kKi = anVar.vEU;
        cardGiftInfo.kKj = anVar.vEV;
        cardGiftInfo.kKk = anVar.vEW;
        cardGiftInfo.kKm = anVar.vEY;
        cardGiftInfo.kKl = anVar.vEX;
        cardGiftInfo.kKn = anVar.vEZ;
        cardGiftInfo.kKo = anVar.vFa;
        cardGiftInfo.kKp = anVar.kKO;
        cardGiftInfo.kKq = anVar.kKP;
        cardGiftInfo.kKr = anVar.vFb;
        cardGiftInfo.hbM = anVar.hbM;
        cardGiftInfo.kKs = anVar.vFc;
        cardGiftInfo.kKt = anVar.vFd;
        cardGiftInfo.kKu = anVar.vFe;
        cardGiftInfo.kKv = anVar.vFf;
        cardGiftInfo.kKw = anVar.vFg;
        cardGiftInfo.kKx = anVar.vFh;
        cardGiftInfo.kKy = anVar.vFi;
        cardGiftInfo.kKz = anVar.vFj;
        cardGiftInfo.kKA = anVar.vFk;
        cardGiftInfo.kKB = anVar.vFl;
        cardGiftInfo.kKC = anVar.vFm;
        cardGiftInfo.kKD = anVar.vFn;
        cardGiftInfo.kKE = anVar.vFo;
        cardGiftInfo.kKF = anVar.vFp;
        cardGiftInfo.kKG = anVar.kJN;
        cardGiftInfo.kKH = anVar.vFq;
        Iterator it = anVar.kKI.iterator();
        while (it.hasNext()) {
            ao aoVar = (ao) it.next();
            LinkedList linkedList = cardGiftInfo.kKI;
            AcceptedCardItem acceptedCardItem = new AcceptedCardItem();
            acceptedCardItem.kKP = aoVar.kKP;
            acceptedCardItem.kKO = aoVar.kKO;
            linkedList.add(acceptedCardItem);
        }
        it = anVar.kKJ.iterator();
        while (it.hasNext()) {
            ap apVar = (ap) it.next();
            linkedList = cardGiftInfo.kKJ;
            AccepterItem accepterItem = new AccepterItem();
            accepterItem.kKP = apVar.kKP;
            accepterItem.kKO = apVar.kKO;
            accepterItem.kKR = apVar.kKR;
            accepterItem.kKQ = apVar.kKQ;
            linkedList.add(accepterItem);
        }
        cardGiftInfo.kKK = anVar.kKK;
        cardGiftInfo.kKL = anVar.kKL;
        cardGiftInfo.kKM = anVar.kKM;
        cardGiftInfo.kKN = anVar.kKN;
        return cardGiftInfo;
    }

    public static CardGiftInfo a(aac com_tencent_mm_protocal_c_aac) {
        CardGiftInfo cardGiftInfo = new CardGiftInfo();
        cardGiftInfo.toUserName = com_tencent_mm_protocal_c_aac.vEQ;
        cardGiftInfo.fFh = com_tencent_mm_protocal_c_aac.vER;
        cardGiftInfo.kKf = com_tencent_mm_protocal_c_aac.vES;
        cardGiftInfo.kKg = com_tencent_mm_protocal_c_aac.content;
        cardGiftInfo.kKh = com_tencent_mm_protocal_c_aac.vET;
        cardGiftInfo.kKi = com_tencent_mm_protocal_c_aac.vEU;
        cardGiftInfo.kKj = com_tencent_mm_protocal_c_aac.vEV;
        cardGiftInfo.kKk = com_tencent_mm_protocal_c_aac.vEW;
        cardGiftInfo.kKm = com_tencent_mm_protocal_c_aac.vEY;
        cardGiftInfo.kKl = com_tencent_mm_protocal_c_aac.vEX;
        cardGiftInfo.kKn = com_tencent_mm_protocal_c_aac.vEZ;
        cardGiftInfo.kKo = com_tencent_mm_protocal_c_aac.vFa;
        cardGiftInfo.kKp = com_tencent_mm_protocal_c_aac.kKO;
        cardGiftInfo.kKq = com_tencent_mm_protocal_c_aac.kKP;
        cardGiftInfo.kKr = com_tencent_mm_protocal_c_aac.vFb;
        cardGiftInfo.hbM = com_tencent_mm_protocal_c_aac.hbM;
        cardGiftInfo.kKs = com_tencent_mm_protocal_c_aac.vFc;
        cardGiftInfo.kKt = com_tencent_mm_protocal_c_aac.vFd;
        cardGiftInfo.kKu = com_tencent_mm_protocal_c_aac.vFe;
        cardGiftInfo.kKv = com_tencent_mm_protocal_c_aac.vFf;
        cardGiftInfo.kKw = com_tencent_mm_protocal_c_aac.vFg;
        cardGiftInfo.kKx = com_tencent_mm_protocal_c_aac.vFh;
        cardGiftInfo.kKy = com_tencent_mm_protocal_c_aac.vFi;
        cardGiftInfo.kKz = com_tencent_mm_protocal_c_aac.vFj;
        cardGiftInfo.kKA = com_tencent_mm_protocal_c_aac.vFk;
        cardGiftInfo.kKB = com_tencent_mm_protocal_c_aac.vFl;
        cardGiftInfo.kKC = com_tencent_mm_protocal_c_aac.vFm;
        cardGiftInfo.kKD = com_tencent_mm_protocal_c_aac.vFn;
        cardGiftInfo.kKE = com_tencent_mm_protocal_c_aac.vFo;
        cardGiftInfo.kKF = com_tencent_mm_protocal_c_aac.vFp;
        cardGiftInfo.kKG = com_tencent_mm_protocal_c_aac.kJN;
        cardGiftInfo.kKH = com_tencent_mm_protocal_c_aac.vFq;
        return cardGiftInfo;
    }
}
