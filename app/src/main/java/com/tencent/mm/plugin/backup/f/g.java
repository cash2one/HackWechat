package com.tencent.mm.plugin.backup.f;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ak;

public final class g {
    static int index = 0;
    private a knM;
    int[] kpl = new int[]{1000, 1000, 1000, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, 5000, 9000, 13000, 26000, 26000, 26000};
    int kpm = 0;
    boolean kpn = false;
    ak kpo = new ak(Looper.getMainLooper(), new 1(this), false);

    public interface a {
        void apA();

        void apz();
    }

    static /* synthetic */ int JO() {
        int i = index;
        index = i + 1;
        return i;
    }

    public g(a aVar) {
        this.knM = aVar;
    }
}
