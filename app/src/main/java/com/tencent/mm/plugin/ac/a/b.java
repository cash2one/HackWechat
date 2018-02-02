package com.tencent.mm.plugin.ac.a;

import android.os.Looper;
import com.tencent.mm.plugin.ac.a.a.1;
import com.tencent.mm.plugin.ac.a.a.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b implements a {
    public List<String> hCK = new LinkedList();
    public af jKT = new af(Looper.getMainLooper());
    public Map<String, List<a>> puU = new HashMap();
    public Map<String, Set<Integer>> puV = new HashMap();
    String puW;
    a puX;

    public final void a(final String str, final a aVar, final Set<Integer> set) {
        x.i("MicroMsg.FileScanQueueService", "startDecodeBlockLoop, fileUri: %s, callback: %x", new Object[]{str, Integer.valueOf(aVar.hashCode())});
        if (bh.ov(str)) {
            x.e("MicroMsg.FileScanQueueService", "start failed, uri is null or nil");
        } else {
            this.jKT.post(new Runnable(this) {
                final /* synthetic */ b pvb;

                public final void run() {
                    b bVar = this.pvb;
                    String str = str;
                    a aVar = aVar;
                    bVar.puV.put(str, set);
                    if (bVar.puU.containsKey(str)) {
                        List<a> list = (List) bVar.puU.get(str);
                        if (list != null) {
                            if (list != null) {
                                Object obj;
                                if (list != null && list.size() != 0) {
                                    for (a aVar2 : list) {
                                        if (aVar2 != null && aVar2 == aVar) {
                                            obj = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    x.e("MicroMsg.FileScanQueueService", "isCallbackInList, list is null or nil");
                                }
                                obj = null;
                                if (obj == null) {
                                    list.add(aVar);
                                }
                            }
                            x.e("MicroMsg.FileScanQueueService", "addToCallbackList, list is null or callback is already in list");
                        }
                        bVar.blq();
                        return;
                    }
                    List linkedList = new LinkedList();
                    linkedList.add(aVar);
                    bVar.puU.put(str, linkedList);
                    bVar.hCK.add(str);
                    bVar.blq();
                }
            });
        }
    }

    final void blq() {
        if (this.puX != null) {
            x.d("MicroMsg.FileScanQueueService", "it is scanning");
        } else if (this.puU.isEmpty()) {
            x.d("MicroMsg.FileScanQueueService", "queue is empty");
        } else {
            this.puW = (String) this.hCK.get(0);
            this.hCK.remove(0);
            this.puX = new a();
            this.puX.fEB = (Set) this.puV.get(this.puW);
            a aVar = this.puX;
            String str = this.puW;
            x.i("MicroMsg.scanner.DecodeFile", "start decode file: " + str);
            aVar.puR = this;
            ag.y(new 1(aVar, str));
        }
    }

    public final int a(d dVar) {
        this.jKT.post(new 3(this, dVar));
        return 0;
    }
}
