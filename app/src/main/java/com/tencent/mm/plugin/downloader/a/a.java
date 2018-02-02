package com.tencent.mm.plugin.downloader.a;

import android.os.IInterface;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskState;

public interface a extends IInterface {
    int a(CDNTaskInfo cDNTaskInfo);

    void a(b bVar);

    void azQ();

    void azR();

    void azS();

    int b(CDNTaskInfo cDNTaskInfo);

    void b(b bVar);

    void ow(int i);

    boolean xA(String str);

    boolean xB(String str);

    CDNTaskState xC(String str);
}
