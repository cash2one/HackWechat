package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.compatible.d.m;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class a {
    public static final int saG;
    private static int saT;

    static {
        int yp = m.yp();
        saT = yp;
        saG = (yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? 16000 : 8000;
    }
}
