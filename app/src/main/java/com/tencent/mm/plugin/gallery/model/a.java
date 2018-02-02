package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.gallery.model.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static final int mQo = (d.fN(14) ? 20 : 30);
    public b mQp = new b();
    private a mQq = new a(this, (byte) 0);
    private f<String> mQr = new f();
    private f<b> mQs = new f();
    private volatile boolean mQt = false;

    public final Bitmap b(String str, int i, String str2, long j) {
        if (bh.ov(str)) {
            x.w("MircoMsg.CacheService", "file path is null");
            return null;
        }
        Bitmap bitmap = this.mQp.getBitmap(str);
        if (bitmap != null) {
            x.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[]{str});
            return bitmap;
        }
        x.v("MircoMsg.CacheService", "filePathInService size is : [%d]", new Object[]{Integer.valueOf(this.mQr.size())});
        if (this.mQr.bt(str)) {
            x.w("MircoMsg.CacheService", "has already getting bitmap from file, %s", new Object[]{str});
            aNB();
            return null;
        }
        if (this.mQr.size() > mQo) {
            x.w("MircoMsg.CacheService", "the running task has exceed 40, remove the first one");
            x.w("MircoMsg.CacheService", "filePathInService size: [%d], waitingDecodeTask size:[%d]", new Object[]{Integer.valueOf(this.mQr.size()), Integer.valueOf(this.mQs.size())});
            if (!this.mQs.isEmpty()) {
                b bVar = (b) this.mQs.aNX();
                if (bVar != null) {
                    this.mQr.bu(bVar.mFilePath);
                }
            }
        }
        this.mQr.add(str);
        this.mQs.add(new b(this, str, i, str2, j));
        aNB();
        return null;
    }

    public final Bitmap Br(String str) {
        if (bh.ov(str)) {
            x.w("MircoMsg.CacheService", "file path is null");
            return null;
        }
        Bitmap bitmap = this.mQp.getBitmap(str);
        if (bitmap == null) {
            return null;
        }
        x.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[]{str});
        return bitmap;
    }

    private void aNB() {
        if (this.mQt) {
            x.w("MircoMsg.CacheService", "is decoding now, wait a minute");
        } else if (this.mQs == null || this.mQs.size() <= 0) {
            x.i("MircoMsg.CacheService", "all job empty");
            if (c.aNF() != null) {
                c.aNF().x(new Runnable(this) {
                    final /* synthetic */ a mQu;

                    {
                        this.mQu = r1;
                    }

                    public final void run() {
                        b a = this.mQu.mQp;
                        if (a.mQB != null) {
                            d dVar = a.mQB;
                            if (dVar.mpK) {
                                dVar.mpK = false;
                                dVar.aNN();
                                dVar.aNO();
                                dVar.qj(-1);
                                dVar.aNQ();
                            }
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|tryStartDocode";
                    }
                });
            }
        } else {
            this.mQt = true;
            b bVar = (b) this.mQs.aNX();
            if (bVar == null) {
                x.e("MircoMsg.CacheService", "obj is null");
                this.mQt = false;
                aNB();
                return;
            }
            a aVar = this.mQq;
            if (c.aNF() == null) {
                x.w("MircoMsg.CacheService", "add thread object, but worker thread is null");
                return;
            }
            e aNF = c.aNF();
            Runnable 1 = new 1(aVar, bVar);
            af aNR = aNF.aNR();
            if (aNR == null) {
                x.e("MicroMsg.GalleryHandlerThread", "post at front of queue, but decode handler is null");
                return;
            }
            boolean postAtFrontOfQueueV2 = aNR.postAtFrontOfQueueV2(1);
            x.i("MicroMsg.GalleryHandlerThread", "postAtFrontOfQueue:[%b]", new Object[]{Boolean.valueOf(postAtFrontOfQueueV2)});
        }
    }

    public final void a(b bVar) {
        b bVar2 = this.mQp;
        if (bVar2.hla.size() > 64) {
            b bVar3 = (b) bVar2.hla.remove(0);
            x.i("MicroMsg.GalleryCache", "has exceed the max listener size[%d], remove some listeners[%s]", new Object[]{Integer.valueOf(64), bVar3});
        }
        x.v("MicroMsg.GalleryCache", "try add listener[%s]", new Object[]{bVar});
        if (!bVar2.hla.contains(bVar)) {
            x.d("MicroMsg.GalleryCache", "add listener[%s] ok", new Object[]{bVar});
            bVar2.hla.add(bVar);
        }
    }
}
