package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

public class a {
    private static a AmU = null;
    private f AmV = null;

    public static a cHu() {
        if (AmU == null) {
            synchronized (a.class) {
                if (AmU == null) {
                    AmU = new a();
                }
            }
        }
        return AmU;
    }

    public static f cHv() {
        a cHu = cHu();
        if (cHu.AmV == null) {
            synchronized (a.class) {
                if (cHu.AmV == null) {
                    cHu.AmV = new f();
                }
            }
        }
        return cHu.AmV;
    }

    public static void cHw() {
        c.d("MicroMsg.Voip", new Object[]{"registerEvents"});
        cHv();
    }
}
