package com.tencent.mm.protocal;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class n {
    public String host = "";
    public String nQt = "";
    private int port = 80;
    private int type = 0;

    public static class a {
        public final int[] vBw = null;
        public final int[] vBx;
        public final int vBy;
        public final int vBz;

        public a(int[] iArr, int i, int i2) {
            this.vBx = iArr;
            this.vBy = i;
            this.vBz = i2;
        }
    }

    public n(int i, String str, int i2, String str2) {
        this.type = i;
        this.nQt = str;
        this.port = i2;
        this.host = str2;
    }

    public final String toString() {
        return this.type + "," + this.nQt + "," + this.port + "," + this.host;
    }

    private static n Tn(String str) {
        String[] split = str.split(",");
        if (split.length < 4) {
            return null;
        }
        n nVar = new n();
        try {
            nVar.type = bh.getInt(split[0], 0);
            nVar.nQt = bh.ou(split[1]);
            nVar.port = bh.getInt(split[2], 0);
            nVar.host = bh.ou(split[3]);
            return nVar;
        } catch (Throwable e) {
            x.e("MicroMsg.MMBuiltInIP", "exception:%s", bh.i(e));
            return null;
        }
    }

    public static String cy(List<n> list) {
        String str = "";
        for (n nVar : list) {
            str = str + nVar.toString() + "|";
        }
        return str;
    }

    public static List<n> To(String str) {
        List linkedList = new LinkedList();
        if (!bh.ov(str)) {
            try {
                for (String Tn : str.split("\\|")) {
                    n Tn2 = Tn(Tn);
                    if (Tn2 != null) {
                        linkedList.add(Tn2);
                    }
                }
            } catch (Throwable e) {
                x.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", str);
                x.e("MicroMsg.MMBuiltInIP", "exception:%s", bh.i(e));
            }
        }
        return linkedList;
    }

    public static a fl(String str, String str2) {
        x.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
        x.d("MicroMsg.MMBuiltInIP", "ports = " + str);
        x.d("MicroMsg.MMBuiltInIP", "timeouts = " + str2);
        int[] VE = bh.VE(str);
        int[] VE2 = bh.VE(str2);
        if (VE2 == null || VE2.length < 2) {
            VE2 = new int[]{0, 0};
            x.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
        }
        return new a(VE, (int) (((long) VE2[0]) * 1000), (int) (((long) VE2[1]) * 1000));
    }
}
