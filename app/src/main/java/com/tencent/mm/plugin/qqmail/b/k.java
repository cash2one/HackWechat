package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    String fzO = null;
    private String[] poM = null;
    private String[] poN = null;
    private String[] poO = null;
    String poP = null;
    a[] poQ = null;
    a[] poR = null;
    String poi = null;

    public k(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2) {
        if (!bh.ov(str)) {
            this.fzO = str;
        }
        if (strArr == null || strArr.length <= 0) {
            this.poM = null;
        } else {
            this.poM = strArr;
        }
        if (strArr2 == null || strArr2.length <= 0) {
            this.poN = null;
        } else {
            this.poN = strArr2;
        }
        if (strArr3 == null || strArr3.length <= 0) {
            this.poO = null;
        } else {
            this.poO = strArr3;
        }
        if (bh.ov(str2)) {
            this.poi = null;
        } else {
            this.poi = str2;
        }
    }

    final String bkj() {
        if (this.poM == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("To: ");
        for (String str : this.poM) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    final String bkk() {
        if (this.poN == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Cc: ");
        for (String str : this.poN) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    final String bkl() {
        if (this.poO == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Bcc: ");
        for (String str : this.poN) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    public static String HL(String str) {
        String s;
        String str2 = null;
        String str3 = "abEdf4&^^*sxcSD$%&1sdfz@!~AZcT4s322dA%^&&*$##C$%__SDy4d_(*%";
        int length = str3.length();
        try {
            s = g.s((str + "d$3^&xRw%&*_(").getBytes());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MailContentFormatter", e, "", new Object[0]);
            x.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e.getLocalizedMessage());
            s = str2;
        }
        char[] cArr = new char[(s.length() * 2)];
        int i = 0;
        for (int i2 = 0; i2 < s.length(); i2++) {
            int i3 = i + 1;
            cArr[i] = s.charAt(i2);
            char charAt = s.charAt(i2);
            i = i3 + 1;
            cArr[i3] = (char) (str3.charAt(charAt % length) + s.charAt(i2));
        }
        try {
            str2 = g.s(new String(cArr).getBytes("ISO-8859-1"));
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MailContentFormatter", e2, "", new Object[0]);
            x.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e2.getLocalizedMessage());
        }
        return str2;
    }
}
