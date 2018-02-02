package com.tencent.mm.modelfriend;

import com.tencent.mm.g.b.bo;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class o extends bo {
    protected static a gJc;

    static {
        a aVar = new a();
        aVar.hSY = new Field[16];
        aVar.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "googleid";
        aVar.xjA.put("googleid", "TEXT");
        stringBuilder.append(" googleid TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "googlename";
        aVar.xjA.put("googlename", "TEXT");
        stringBuilder.append(" googlename TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "googlephotourl";
        aVar.xjA.put("googlephotourl", "TEXT");
        stringBuilder.append(" googlephotourl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "googlegmail";
        aVar.xjA.put("googlegmail", "TEXT");
        stringBuilder.append(" googlegmail TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "username";
        aVar.xjA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "nickname";
        aVar.xjA.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "nicknameqp";
        aVar.xjA.put("nicknameqp", "TEXT");
        stringBuilder.append(" nicknameqp TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "usernamepy";
        aVar.xjA.put("usernamepy", "TEXT");
        stringBuilder.append(" usernamepy TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "small_url";
        aVar.xjA.put("small_url", "TEXT");
        stringBuilder.append(" small_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "big_url";
        aVar.xjA.put("big_url", "TEXT");
        stringBuilder.append(" big_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "ret";
        aVar.xjA.put("ret", "INTEGER");
        stringBuilder.append(" ret INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = DownloadInfo.STATUS;
        aVar.xjA.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "googleitemid";
        aVar.xjA.put("googleitemid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" googleitemid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xjz = "googleitemid";
        aVar.columns[13] = "googlecgistatus";
        aVar.xjA.put("googlecgistatus", "INTEGER default '2' ");
        stringBuilder.append(" googlecgistatus INTEGER default '2' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "contecttype";
        aVar.xjA.put("contecttype", "TEXT");
        stringBuilder.append(" contecttype TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "googlenamepy";
        aVar.xjA.put("googlenamepy", "TEXT");
        stringBuilder.append(" googlenamepy TEXT");
        aVar.columns[16] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("googleIDgoogleid\n");
        stringBuffer.append("googleNamegooglename\n");
        stringBuffer.append("googlePhotoUrlgooglephotourl\n");
        stringBuffer.append("googleGmailgooglegmail\n");
        stringBuffer.append("userNameusername\n");
        stringBuffer.append("nickNamenickname\n");
        stringBuffer.append("nickNameQuanPinnicknameqp\n");
        stringBuffer.append("nickNamePYInitialusernamepy\n");
        stringBuffer.append("smallHeaderUrlsmall_url\n");
        stringBuffer.append("bigHeaderUrlbig_url\n");
        stringBuffer.append("retret\n");
        stringBuffer.append("statusstatus\n");
        stringBuffer.append("googleItemIDgoogleitemid\n");
        stringBuffer.append("cgiStatusgooglecgistatus\n");
        stringBuffer.append("contactTypecontecttype\n");
        stringBuffer.append("googleNamePYInitialgooglenamepy\n");
        return stringBuffer.toString();
    }
}
