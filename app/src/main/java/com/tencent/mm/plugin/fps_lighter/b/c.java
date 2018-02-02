package com.tencent.mm.plugin.fps_lighter.b;

import android.app.Activity;
import com.b.a.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public final class c implements Serializable {
    public static HashMap<String, Integer> mAM;
    public float mAE = 60.0f;
    public float mAF = 16.666668f;
    public final long mAG = 8000;
    public final long mAH = 120000;
    boolean mAI = false;
    boolean mAJ = false;
    boolean mAK = false;
    public int mAL = 3;
    public String mAN = "FRAGMENT_UNKNOW";
    String mAO;
    int mAP = 100;

    protected c() {
        int t = b.t(ac.getContext());
        if (t >= 2015) {
            this.mAL = 0;
        } else if (t >= 2013) {
            this.mAL = 1;
        } else if (t > 2010) {
            this.mAL = 2;
        } else {
            this.mAL = 3;
        }
    }

    public static long aKK() {
        return 120000;
    }

    public static long aKL() {
        return TimeUnit.NANOSECONDS.convert(8000, TimeUnit.MILLISECONDS);
    }

    static {
        HashMap hashMap = new HashMap();
        mAM = hashMap;
        hashMap.put("SnsTimeLineUI", Integer.valueOf(0));
        mAM.put("FRAGMENT_MAINUI", Integer.valueOf(1));
        mAM.put("FRAGMENT_ADDRESS", Integer.valueOf(4));
        mAM.put("FRAGMENT_CHATTING", Integer.valueOf(3));
        mAM.put("ChattingUI", Integer.valueOf(3));
        mAM.put("SnsUserUI", Integer.valueOf(5));
    }

    public final void u(Activity activity) {
        this.mAO = activity.getClass().getSimpleName();
    }
}
