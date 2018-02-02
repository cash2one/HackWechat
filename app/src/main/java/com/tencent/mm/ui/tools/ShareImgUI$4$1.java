package com.tencent.mm.ui.tools;

import android.os.Parcelable;
import com.tencent.mm.ui.tools.ShareImgUI.4;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class ShareImgUI$4$1 implements Runnable {
    final /* synthetic */ ArrayList zmL;
    final /* synthetic */ Parcelable zmM;
    final /* synthetic */ boolean[] zmN;
    final /* synthetic */ CountDownLatch zmO;
    final /* synthetic */ 4 zmP;

    ShareImgUI$4$1(4 4, ArrayList arrayList, Parcelable parcelable, boolean[] zArr, CountDownLatch countDownLatch) {
        this.zmP = 4;
        this.zmL = arrayList;
        this.zmM = parcelable;
        this.zmN = zArr;
        this.zmO = countDownLatch;
    }

    public final void run() {
        if (!ShareImgUI.a(this.zmP.zmI, this.zmL, this.zmM)) {
            this.zmN[0] = true;
        }
        this.zmO.countDown();
    }
}
