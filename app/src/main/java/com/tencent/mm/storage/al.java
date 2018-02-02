package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class al {
    public String aeskey;
    public long fFo;
    public String fqR;
    public String fqV;
    public String fuY;
    public int gjE;
    public String gjF = "";
    public int hEK;
    public long hVE;
    public String hVz;
    public int height;
    public String id;
    public String nBo;
    public String talker;
    public String thumbUrl;
    public int width;
    public int xyG;
    public int xyH;
    public int xyI;
    public int xyJ;
    public String xyK = "";
    public String xyL;
    public String xyM;
    public String xyN;
    public boolean xyO = true;
    public String xyP;

    public static al a(Map<String, String> map, String str, String str2, String str3) {
        if (map == null) {
            return null;
        }
        al alVar = new al();
        alVar.xyK = str2;
        alVar.talker = str;
        alVar.id = (String) map.get(".msg.emoji.$idbuffer");
        alVar.hVz = (String) map.get(".msg.emoji.$fromusername");
        String str4 = (String) map.get(".msg.emoji.$androidmd5");
        alVar.fqR = str4;
        if (str4 == null) {
            alVar.fqR = (String) map.get(".msg.emoji.$md5");
        }
        if (!bh.ov(alVar.fqR)) {
            alVar.fqR = alVar.fqR.toLowerCase();
        }
        try {
            alVar.xyG = Integer.valueOf((String) map.get(".msg.emoji.$type")).intValue();
            if (map.get(".msg.emoji.$androidlen") != null) {
                alVar.xyH = Integer.valueOf((String) map.get(".msg.emoji.$androidlen")).intValue();
            } else if (map.get(".msg.emoji.$len") != null) {
                alVar.xyH = Integer.valueOf((String) map.get(".msg.emoji.$len")).intValue();
            }
            if (map.get(".msg.gameext.$type") != null) {
                alVar.xyI = Integer.valueOf((String) map.get(".msg.gameext.$type")).intValue();
            }
            if (map.get(".msg.gameext.$content") != null) {
                alVar.xyJ = Integer.valueOf((String) map.get(".msg.gameext.$content")).intValue();
            }
            if (map.get(".msg.emoji.$productid") != null) {
                alVar.fqV = (String) map.get(".msg.emoji.$productid");
            }
            if (map.get(".msg.emoji.$cdnurl") != null) {
                alVar.nBo = (String) map.get(".msg.emoji.$cdnurl");
            }
            if (map.get(".msg.emoji.$designerid") != null) {
                alVar.xyL = (String) map.get(".msg.emoji.$designerid");
            }
            if (map.get(".msg.emoji.$thumburl") != null) {
                alVar.thumbUrl = (String) map.get(".msg.emoji.$thumburl");
            }
            if (map.get(".msg.emoji.$encrypturl") != null) {
                alVar.fuY = (String) map.get(".msg.emoji.$encrypturl");
            }
            if (map.get(".msg.emoji.$aeskey") != null) {
                alVar.aeskey = (String) map.get(".msg.emoji.$aeskey");
            }
            if (map.get(".msg.emoji.$width") != null) {
                alVar.width = Integer.valueOf((String) map.get(".msg.emoji.$width")).intValue();
            }
            if (map.get(".msg.emoji.$height") != null) {
                alVar.height = Integer.valueOf((String) map.get(".msg.emoji.$height")).intValue();
            }
            if (map.get(".msg.emoji.$externurl") != null) {
                alVar.xyM = (String) map.get(".msg.emoji.$externurl");
            }
            if (map.get(".msg.emoji.$externmd5") != null) {
                alVar.xyN = (String) map.get(".msg.emoji.$externmd5");
            }
            if (map.get(".msg.emoji.$activityid") != null) {
                alVar.xyP = (String) map.get(".msg.emoji.$activityid");
            }
            if (!bh.ov(str3)) {
                alVar.gjF = str3;
            }
            x.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", new Object[]{alVar.id, alVar.fqR, Integer.valueOf(alVar.xyG), Integer.valueOf(alVar.xyH), Integer.valueOf(alVar.xyI), Integer.valueOf(alVar.xyJ), alVar.fqV, alVar.nBo, alVar.xyL, alVar.thumbUrl, alVar.fuY, Integer.valueOf(alVar.width), Integer.valueOf(alVar.height), alVar.xyM, alVar.xyN});
            return alVar;
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }
}
