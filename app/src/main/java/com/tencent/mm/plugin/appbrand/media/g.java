package com.tencent.mm.plugin.appbrand.media;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class g {
    public static boolean tk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("aac".equalsIgnoreCase(str)) {
            return true;
        }
        if ("mp3".equalsIgnoreCase(str)) {
            return true;
        }
        return "wav".equalsIgnoreCase(str) ? false : false;
    }

    public static boolean tl(String str) {
        boolean z = false;
        File file = new File(str);
        if (file.exists()) {
            x.i("MicroMsg.AudioRecordUtil", "delete audio file");
            file.delete();
            try {
                z = file.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AudioRecordUtil", e, "prepareCacheFile", new Object[z]);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.AudioRecordUtil", e2, "prepareCacheFile", new Object[z]);
            }
        } else {
            try {
                x.i("MicroMsg.AudioRecordUtil", "new audio file");
                z = file.createNewFile();
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.AudioRecordUtil", e22, "prepareCacheFile", new Object[z]);
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.AudioRecordUtil", e222, "prepareCacheFile", new Object[z]);
            }
        }
        return z;
    }
}
