package com.tencent.mm.ui.contact;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashSet;

public final class s {
    public static final int yTD = p(256, 16, 1, 2, 4);
    public static final int yTE = p(16, 1, 2, 4, 64, 16384);
    public static final int yTF = p(16, 1, 2, 4, 64, Downloads.RECV_BUFFER_SIZE);
    public static final int yTG = p(yTD, 64, 16384, Downloads.RECV_BUFFER_SIZE);
    public static final int yTH = p(16, 2, 16384, 4);
    public static final int yTI = p(yTD, 16384, 64, Downloads.RECV_BUFFER_SIZE);
    public static final int yTJ = p(yTD, 16384, 64, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 8192);
    public static final int yTK = p(16, 32, 1, 4, 2, 64);
    public static final int yTL = p(yTE, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);

    public static HashSet<String> cwj() {
        HashSet<String> hashSet = new HashSet();
        hashSet.add("weixin");
        return hashSet;
    }

    public static void g(HashSet<String> hashSet) {
        hashSet.remove("filehelper");
    }

    public static HashSet<String> cwk() {
        HashSet<String> hashSet = new HashSet();
        hashSet.add("officialaccounts");
        hashSet.add("newsapp");
        for (Object add : com.tencent.mm.z.s.hfr) {
            hashSet.add(add);
        }
        hashSet.add("weibo");
        hashSet.add("qqmail");
        hashSet.add("fmessage");
        hashSet.add("tmessage");
        hashSet.add("floatbottle");
        hashSet.add("lbsapp");
        hashSet.add("shakeapp");
        hashSet.add("medianote");
        hashSet.add("qqfriend");
        hashSet.add("readerapp");
        hashSet.add("newsapp");
        hashSet.add("blogapp");
        hashSet.add("facebookapp");
        hashSet.add("masssendapp");
        hashSet.add("meishiapp");
        hashSet.add("feedsapp");
        hashSet.add("voipapp");
        hashSet.add("filehelper");
        hashSet.add("officialaccounts");
        hashSet.add("helper_entry");
        hashSet.add("pc_share");
        hashSet.add("cardpackage");
        hashSet.add("voicevoipapp");
        hashSet.add("voiceinputapp");
        hashSet.add("linkedinplugin");
        hashSet.add("appbrandcustomerservicemsg");
        return hashSet;
    }

    public static boolean fa(int i, int i2) {
        return (i & i2) > 0;
    }

    public static int fb(int i, int i2) {
        return (i2 ^ -1) & i;
    }

    public static int p(int... iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i2 |= iArr[i];
            i++;
        }
        return i2;
    }
}
