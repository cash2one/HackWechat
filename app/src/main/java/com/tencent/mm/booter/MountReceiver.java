package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import java.io.File;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class MountReceiver extends BroadcastReceiver {
    private String action = "";
    private Context context = null;
    private af gyf = new 1(this, Looper.getMainLooper());

    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && !t.ov(intent.getAction())) {
            this.context = context;
            this.action = intent.getAction();
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            x.i("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b SDCARD_ROOT[%s] primaryExtStg[%s]", this.action, Boolean.valueOf(ar.Hj()), e.bnD, absolutePath);
            boolean equals = this.action.equals("android.intent.action.MEDIA_MOUNTED");
            if (equals || this.action.equals("android.intent.action.MEDIA_EJECT") || this.action.equals("android.intent.action.MEDIA_SHARED")) {
                Object obj = !e.bnD.equalsIgnoreCase("/dev/null") ? 1 : null;
                if (obj != null) {
                    try {
                        StatFs statFs = new StatFs(e.bnD);
                        x.i("MicroMsg.MountReceiver", "CheckSD path[%s] blocksize:%d blockcount:%d availcount:%d", e.bnD, Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
                    } catch (Exception e) {
                        x.e("MicroMsg.MountReceiver", "CheckSD failed :%s", e.getMessage());
                        obj = null;
                    }
                }
                Uri data = intent.getData();
                if (data != null) {
                    String path = data.getPath();
                    if (!e.bnD.equalsIgnoreCase(path)) {
                        if (equals && r0 == null) {
                            g.pQN.a(340, e.bnD.equalsIgnoreCase("/dev/null") ? 9 : 12, 1, false);
                            if (!t.ov(absolutePath) && absolutePath.equalsIgnoreCase(path)) {
                                if (new File(w.gZK + "SdcardInfo.cfg").exists()) {
                                    s sVar = new s(w.gZK + "SdcardInfo.cfg");
                                    String str = (String) sVar.get(1, "");
                                    int intValue = ((Integer) sVar.get(2, Integer.valueOf(0))).intValue();
                                    int i = VERSION.SDK_INT;
                                    String str2 = e.bnD;
                                    sVar.set(1, absolutePath);
                                    sVar.set(2, Integer.valueOf(i));
                                    e.eK(absolutePath);
                                    x.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%d, %s] to new [%d, %s], [%s] to [%s]", Integer.valueOf(intValue), str, Integer.valueOf(i), absolutePath, str2, e.bnD);
                                } else {
                                    x.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%s] to new [%s], ver[%d]", e.bnD, absolutePath, Integer.valueOf(VERSION.SDK_INT));
                                    e.bnD = absolutePath;
                                    e.eK(absolutePath);
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
                g.pQN.a(340, equals ? 13 : 14, 1, false);
                if (equals) {
                    ar.Dm().F(new 2(this));
                    return;
                }
                u.fI(context);
                ar.Dm().F(new 3(this));
            }
        }
    }
}
