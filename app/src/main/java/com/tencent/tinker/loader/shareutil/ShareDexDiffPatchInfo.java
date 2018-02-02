package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public class ShareDexDiffPatchInfo {
    public final String AkA;
    public final String AkB;
    public final String AkC;
    public final String AkD;
    public final boolean AkE;
    public final String Akx;
    public final String Aky;
    public final String Akz;
    public final String gJo;
    public final String path;

    public ShareDexDiffPatchInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.Akx = str;
        this.path = str2;
        this.Aky = str3;
        this.Akz = str4;
        this.AkC = str5;
        this.AkA = str6;
        this.AkB = str7;
        this.AkD = str8;
        if (str8.equals("jar")) {
            this.AkE = true;
            if (SharePatchFileUtil.abM(str)) {
                this.gJo = str + ".jar";
            } else {
                this.gJo = str;
            }
        } else if (str8.equals("raw")) {
            this.AkE = false;
            this.gJo = str;
        } else {
            throw new TinkerRuntimeException("can't recognize dex mode:" + str8);
        }
    }

    public static void m(String str, ArrayList<ShareDexDiffPatchInfo> arrayList) {
        if (str != null && str.length() != 0) {
            for (String str2 : str.split("\n")) {
                if (str2 != null && str2.length() > 0) {
                    String[] split = str2.split(",", 8);
                    if (split != null && split.length >= 8) {
                        arrayList.add(new ShareDexDiffPatchInfo(split[0].trim(), split[1].trim(), split[2].trim(), split[3].trim(), split[4].trim(), split[5].trim(), split[6].trim(), split[7].trim()));
                    }
                }
            }
        }
    }

    public static boolean c(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (shareDexDiffPatchInfo == null) {
            return false;
        }
        String str = shareDexDiffPatchInfo.Akx;
        String str2 = ShareTinkerInternals.cHg() ? shareDexDiffPatchInfo.Akz : shareDexDiffPatchInfo.Aky;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() != 32) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.Akx);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.Aky);
        stringBuffer.append(",");
        stringBuffer.append(this.Akz);
        stringBuffer.append(",");
        stringBuffer.append(this.AkA);
        stringBuffer.append(",");
        stringBuffer.append(this.AkB);
        stringBuffer.append(",");
        stringBuffer.append(this.AkC);
        stringBuffer.append(",");
        stringBuffer.append(this.AkD);
        return stringBuffer.toString();
    }
}
