package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.pb.common.c.c;

public final class j {
    public static boolean acg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("client_");
    }

    public static int cId() {
        int i = 0;
        try {
            return a.cHv().nJW;
        } catch (Exception e) {
            c.m("tagorewang:VoiceGroupUtil", new Object[]{"getActiveRoomId err: ", e});
            return i;
        }
    }

    public static long cIe() {
        try {
            return a.cHv().Anx;
        } catch (Exception e) {
            c.m("tagorewang:VoiceGroupUtil", new Object[]{"getActiveRoomKey err: ", e});
            return 0;
        }
    }
}
