package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.by.f;
import com.tencent.mm.by.g;
import com.tencent.mm.by.h.a;
import com.tencent.mm.by.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements a {
    final /* synthetic */ c ksz;

    c$2(c cVar) {
        this.ksz = cVar;
    }

    public final void Db() {
        if (this.ksz.ksx != null) {
            g gVar = this.ksz.ksx;
            for (Object obj : gVar.xBk.keySet()) {
                ((i) gVar.xBk.get(obj)).ckW();
            }
        }
    }

    public final void Dc() {
    }

    public final void Dd() {
        if (this.ksz.ksx != null) {
            g gVar = this.ksz.ksx;
            if (gVar.xBl.size() != 0) {
                x.i("MicroMsg.MemoryStorage", "attachTable begin stg:%s size:%d", "stg_null", Integer.valueOf(gVar.xBl.size()));
                if (gVar.xAK == null) {
                    x.e("MicroMsg.MemoryStorage", "attachTable db is null");
                } else if (gVar.xBi.inTransaction()) {
                    x.w("MicroMsg.MemoryStorage", "attachTable is in transcation ,give up attach table size:%d", Integer.valueOf(gVar.xBl.size()));
                } else {
                    while (gVar.xBl.size() > 0) {
                        if (gVar.xBi.inTransaction()) {
                            x.w("MicroMsg.MemoryStorage", "attachTable is in transcation , break attach table size:%d", Integer.valueOf(gVar.xBl.size()));
                            return;
                        }
                        g.a aVar = (g.a) gVar.xBl.peek();
                        if (aVar == null) {
                            gVar.xBl.poll();
                        } else {
                            String tableName = aVar.getTableName();
                            if (bh.ov(tableName)) {
                                x.e("MicroMsg.MemoryStorage", "attachTable Error table Name :%s", tableName);
                                gVar.xBl.poll();
                            } else if (f.a(gVar.xAK, tableName)) {
                                x.e("MicroMsg.MemoryStorage", "attachTable Error Attach table twice :%s", tableName);
                                gVar.xBl.poll();
                            } else {
                                if (gVar.Yg(tableName) != 0) {
                                    try {
                                        if (gVar.veZ) {
                                            gVar.xAK.execSQL("DETACH DATABASE old");
                                            x.i("MicroMsg.MemoryStorage", "DETACH DATABASE ");
                                            gVar.veZ = false;
                                        }
                                        if (bh.ov(gVar.xBi.getKey())) {
                                            gVar.xAK.execSQL("ATTACH DATABASE '" + gVar.xBi.getPath() + "' AS old ");
                                        } else {
                                            gVar.xAK.execSQL("ATTACH DATABASE '" + gVar.xBi.getPath() + "' AS old KEY '" + gVar.xBi.getKey() + "'");
                                        }
                                        x.i("MicroMsg.MemoryStorage", "ATTACH DATABASE ");
                                        gVar.veZ = true;
                                    } catch (Throwable e) {
                                        gVar.veZ = false;
                                        x.e("MicroMsg.MemoryStorage", "ERROR : attach disk db [%s] , will do again !", e.getMessage());
                                        x.e("MicroMsg.MemoryStorage", "exception:%s", bh.i(e));
                                    }
                                    if (gVar.Yg(tableName) != 0) {
                                        x.e("MicroMsg.MemoryStorage", "copy table failed :" + tableName);
                                        return;
                                    }
                                }
                                x.i("MicroMsg.MemoryStorage", "attachTable %s succ , waitsize:%d finsize:%d", tableName, Integer.valueOf(gVar.xBl.size()), Integer.valueOf(gVar.xBk.size()));
                                gVar.xBk.put(tableName, new i(gVar.xBi, tableName));
                                aVar.a(gVar);
                                gVar.xBl.poll();
                            }
                        }
                    }
                }
            }
        }
    }
}
