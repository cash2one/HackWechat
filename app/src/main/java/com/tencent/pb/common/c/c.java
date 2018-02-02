package com.tencent.pb.common.c;

import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.f;

public final class c {
    public static int level = 0;
    private static int zQh = 2;
    private static boolean zQi = false;

    public static void C(boolean z, int i) {
        zQh = 0;
        zQi = true;
    }

    private static void C(int i, String str, String str2) {
        e cHY = f.cHY();
        if (cHY != null) {
            cHY.m(i, "MTSDK" + str, str2);
        }
    }

    public static void d(String str, Object... objArr) {
        if (zQi && zQh <= 1 && str != null) {
            C(1, str, " " + y(objArr));
        }
    }

    public static void l(String str, Object... objArr) {
        if (zQi && zQh <= 2) {
            C(2, str, " " + y(objArr));
        }
    }

    public static void m(String str, Object... objArr) {
        if (zQi && zQh <= 3 && str != null) {
            C(3, str, " " + y(objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        if (zQi && zQh <= 4) {
            C(4, str, " " + y(objArr));
        }
    }

    private static String y(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(250);
        for (Object obj : objArr) {
            if (obj != null) {
                stringBuffer.append("|");
                if (obj instanceof Throwable) {
                    stringBuffer.append(((Throwable) obj).getMessage());
                } else {
                    stringBuffer.append(obj.toString());
                }
            }
        }
        return stringBuffer.toString();
    }
}
