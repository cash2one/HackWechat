package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

public final class o {
    public static o pTF;
    public String bgo;
    public String fWi;
    public String iIb;
    public String iIk;
    public List<String> pTA;
    public List<String> pTB;
    public String pTC;
    public String pTD;
    public String pTE;
    public b pTo;
    c pTp;
    public c pTq;
    c pTr;
    public String pTs;
    public a pTt;
    public a pTu;
    public a pTv;
    public a pTw;
    public List<String> pTx;
    public List<String> pTy;
    public List<String> pTz;
    public String title;
    public String url;

    public static class b {
        private String iIq;
        private String iIr;
        private String iIs;

        public b(String str, String str2, String str3) {
            if (str == null) {
                str = "";
            }
            this.iIq = str;
            if (str2 == null) {
                str2 = "";
            }
            this.iIr = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.iIs = str3;
        }

        public final String Rf() {
            StringBuilder stringBuilder = new StringBuilder();
            if (bh.Vq(this.iIq) || bh.Vq(this.iIr) || bh.Vq(this.iIs)) {
                if (this.iIs.trim().length() > 0) {
                    stringBuilder.append(this.iIs);
                }
                if (this.iIr.trim().length() > 0) {
                    stringBuilder.append(this.iIr);
                }
                if (this.iIq.trim().length() > 0) {
                    stringBuilder.append(this.iIq);
                }
            } else {
                if (this.iIq.trim().length() > 0) {
                    stringBuilder.append(this.iIq);
                }
                if (this.iIr.trim().length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.iIr);
                }
                if (this.iIs.trim().length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.iIs);
                }
            }
            return stringBuilder.toString();
        }
    }

    public static class c {
        public String pTI;
        public String pTJ;

        public c(String str, String str2) {
            this.pTI = str;
            this.pTJ = str2;
        }
    }
}
