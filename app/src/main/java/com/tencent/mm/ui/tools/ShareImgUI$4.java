package com.tencent.mm.ui.tools;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

class ShareImgUI$4 implements Runnable {
    final /* synthetic */ Bundle jrm;
    final /* synthetic */ ShareImgUI zmI;
    final /* synthetic */ ShareImgUI$b zmJ;
    final /* synthetic */ long zmK;

    ShareImgUI$4(ShareImgUI shareImgUI, Bundle bundle, ShareImgUI$b shareImgUI$b, long j) {
        this.zmI = shareImgUI;
        this.jrm = bundle;
        this.zmJ = shareImgUI$b;
        this.zmK = j;
    }

    public final void run() {
        ArrayList parcelableArrayList = this.jrm.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            x.e("MicroMsg.ShareImgUI", "getParcelableArrayList failed");
            ShareImgUI.a(this.zmI, this.zmJ, null);
            return;
        }
        ShareImgUI shareImgUI;
        ShareImgUI$b shareImgUI$b;
        ArrayList arrayList = new ArrayList();
        CountDownLatch countDownLatch = new CountDownLatch(parcelableArrayList.size());
        boolean[] zArr = new boolean[]{false};
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            Parcelable parcelable = (Parcelable) it.next();
            e.post(new 1(this, arrayList, parcelable, zArr, countDownLatch), "getMultiSendFilePathListItem" + parcelable.toString());
        }
        try {
            countDownLatch.await();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShareImgUI", e, "hy: timeout when getmulti", new Object[0]);
            ShareImgUI.a(this.zmI, this.zmJ, null);
        }
        if (zArr[0]) {
            x.d("MicroMsg.ShareImgUI", "hy: has non path img");
            shareImgUI = this.zmI;
            shareImgUI$b = this.zmJ;
        } else {
            x.i("MicroMsg.ShareImgUI", "hy: getMultiSendFilePathList done. using: %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.zmK)});
            shareImgUI = this.zmI;
            shareImgUI$b = this.zmJ;
            if (arrayList.size() > 0) {
                ShareImgUI.a(shareImgUI, shareImgUI$b, arrayList);
            }
        }
        arrayList = null;
        ShareImgUI.a(shareImgUI, shareImgUI$b, arrayList);
    }
}
