package com.tencent.mm.ah;

import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.Map;

public final class a {
    private static int hrx = 0;
    private static int hry = 0;

    public static class a {
        private static final f<Integer, a> hdO = new f(100);
        public String fzO;
        public String hrA;
        public String hrB;
        public String hrC;
        public String hrD;
        public String hrE;
        public String hrF;
        public String hrG;
        public String hrH;
        public String hrz;
        public String toUser;

        public static final a ky(String str) {
            if (bh.ov(str)) {
                x.e("MicroMsg.BrandQALogic", "empty xml to parse");
                return null;
            }
            int indexOf = str.indexOf("<qamsg");
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            int hashCode = str.hashCode();
            a aVar = (a) hdO.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                return aVar;
            }
            Map y = bi.y(str, "qamsg");
            if (y == null) {
                x.e("MicroMsg.BrandQALogic", "parse msg failed");
                return null;
            }
            try {
                a aVar2 = new a();
                aVar2.fzO = (String) y.get(".qamsg.$fromUser");
                aVar2.hrz = (String) y.get(".qamsg.$fromNickname");
                aVar2.toUser = (String) y.get(".qamsg.$title");
                aVar2.hrA = (String) y.get(".qamsg.question.$id");
                aVar2.hrB = (String) y.get(".qamsg.question.$fromUser");
                aVar2.hrC = (String) y.get(".qamsg.question.content");
                aVar2.hrD = (String) y.get(".qamsg.answer.$id");
                aVar2.hrE = (String) y.get(".qamsg.answer.$fromUser");
                aVar2.hrF = (String) y.get(".qamsg.answer.content");
                aVar2.hrD = (String) y.get(".qamsg.answer1.$id");
                aVar2.hrG = (String) y.get(".qamsg.answer1.$fromUser");
                aVar2.hrH = (String) y.get(".qamsg.answer1.content");
                hdO.l(Integer.valueOf(hashCode), aVar2);
                return aVar2;
            } catch (Throwable e) {
                x.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
                x.printErrStackTrace("MicroMsg.BrandQALogic", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static String a(a aVar) {
        if (aVar == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(bh.ou(aVar.hrH));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(bh.ou(aVar.hrF));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(bh.ou(aVar.hrC));
        return stringBuilder.toString();
    }

    public static String b(a aVar) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (!q.gr(aVar.fzO)) {
            stringBuilder.append(aVar.hrz);
            stringBuilder.append(": ");
        }
        String str = bh.ov(aVar.hrH) ? bh.ov(aVar.hrF) ? aVar.hrC : aVar.hrF : aVar.hrH;
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
