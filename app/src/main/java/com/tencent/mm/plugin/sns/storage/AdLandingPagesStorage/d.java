package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class d {
    public static String ei(String str, String str2) {
        return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_img_" + ab.UZ(str2);
    }

    public static String ej(String str, String str2) {
        FileOp.mh(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_sight_" + ab.UZ(str2);
    }

    public static Bitmap ek(String str, String str2) {
        Bitmap bitmap = null;
        if (!(bh.ov(str2) || bh.ov(str))) {
            try {
                String ei = ei(str, str2);
                if (!TextUtils.isEmpty(ei) && new File(ei).exists()) {
                    bitmap = MMBitmapFactory.decodeFile(ei);
                }
            } catch (Throwable e) {
                x.e("AdLandingPagesDownloadResourceHelper", "%s", bh.i(e));
            }
        }
        return bitmap;
    }

    public static void a(String str, int i, a aVar) {
        a("adId", str, false, i, 0, aVar);
    }

    public static void a(String str, String str2, boolean z, int i, int i2, a aVar) {
        if (bh.ov(str2) || bh.ov(str)) {
            aVar.bxd();
            return;
        }
        x.i("AdLandingPagesDownloadResourceHelper", "start download img for " + str2 + " for adid:" + str);
        String ei = ei(str, str2);
        new b(ei, z, i, 0, new 1(aVar, str2, str, ei)).execute(new String[]{str2});
    }

    public static void a(String str, String str2, boolean z, int i, a aVar) {
        FileOp.mh(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        ab.UZ(str2);
        String ej = ej(str, str2);
        if (FileOp.bO(ej)) {
            ag.y(new 2(aVar, ej));
            return;
        }
        x.i("AdLandingPagesDownloadResourceHelper", "start download sight for " + str2 + " for adid:" + str);
        new b(ej, z, i, 0, new 3(aVar, str2, str, ej)).execute(new String[]{str2});
    }

    public static void a(String str, String str2, boolean z, int i, b bVar) {
        if (bh.ov(str2) || bh.ov(str)) {
            bVar.KZ("the res or adId is null");
            return;
        }
        ei(str, str2);
        String str3 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str4 = str + "_stream_" + ab.UZ(str2);
        x.i("AdLandingPagesDownloadResourceHelper", "start download video for " + str2 + " for adid:" + str);
        new ad(str3, str4, z, i, 0, new af(Looper.getMainLooper()), new 4(bVar, str2, str)).execute(new String[]{str2});
    }
}
