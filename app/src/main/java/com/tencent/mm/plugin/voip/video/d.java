package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

public final class d {
    public static Context mContext;
    private static final HashMap<String, Integer> stp;
    public Object stq = new Object();
    public ToneGenerator str;
    private final int sts = 250;

    static {
        HashMap hashMap = new HashMap();
        stp = hashMap;
        hashMap.put("1", Integer.valueOf(1));
        stp.put("2", Integer.valueOf(2));
        stp.put(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, Integer.valueOf(3));
        stp.put("4", Integer.valueOf(4));
        stp.put("5", Integer.valueOf(5));
        stp.put("6", Integer.valueOf(6));
        stp.put("7", Integer.valueOf(7));
        stp.put("8", Integer.valueOf(8));
        stp.put("9", Integer.valueOf(9));
        stp.put("0", Integer.valueOf(0));
        stp.put("#", Integer.valueOf(11));
        stp.put("*", Integer.valueOf(10));
    }

    public d(Context context) {
        mContext = context;
        if (context != null) {
            try {
                synchronized (this.stq) {
                    if (bIC() && this.str == null) {
                        this.str = new ToneGenerator(3, 66);
                    }
                }
            } catch (Exception e) {
                x.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
                x.d("MicroMsg.DTMFToneGenerator", e.getMessage());
                this.str = null;
            }
        }
    }

    private d() {
    }

    public static boolean bIC() {
        return System.getInt(mContext.getContentResolver(), "dtmf_tone", 1) == 1;
    }

    public static int MH(String str) {
        if (str == null || str.equals("") || !stp.containsKey(str)) {
            return -1;
        }
        return ((Integer) stp.get(str)).intValue();
    }
}
