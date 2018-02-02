package com.tencent.mm.plugin.favorite;

import com.tencent.mm.g.a.fs;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;

public final class e extends c<fs> {
    private z<Long, f> mpa;
    private h mpb;

    public e() {
        this.mpa = new z(10);
        this.xen = fs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        f fVar;
        fs fsVar = (fs) bVar;
        if (fsVar.fvc.fqk == 0) {
            fVar = null;
        } else if (fsVar.fvc.fvj) {
            fVar = h.getFavItemInfoStorage().db(fsVar.fvc.fqk);
            if (fVar != null) {
                this.mpa.put(Long.valueOf(fsVar.fvc.fqk), fVar);
            }
        } else {
            f fVar2 = (f) this.mpa.get(Long.valueOf(fsVar.fvc.fqk));
            String str = "MicroMsg.FavImageServiceListener";
            String str2 = "get item from cache itemInfo is null? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(fVar2 == null);
            x.d(str, str2, objArr);
            if (fVar2 == null) {
                fVar = h.getFavItemInfoStorage().db(fsVar.fvc.fqk);
                if (fVar != null) {
                    this.mpa.put(Long.valueOf(fsVar.fvc.fqk), fVar);
                }
            } else {
                fVar = fVar2;
            }
        }
        x.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[]{Integer.valueOf(fsVar.fvc.opType), Long.valueOf(fsVar.fvc.fqk)});
        if (fVar != null || fsVar.fvc.opType == 3 || fsVar.fvc.opType == 4) {
            switch (fsVar.fvc.opType) {
                case 0:
                    fsVar.fvd.fvk = h.a(fsVar.fvc.fve, fVar);
                    break;
                case 1:
                    if (this.mpb != null) {
                        this.mpb.b(fsVar.fvc.fvf, fsVar.fvc.fve, fVar, fsVar.fvc.fvg, fsVar.fvc.width, fsVar.fvc.height);
                        break;
                    }
                    x.w("MicroMsg.FavImageServiceListener", "imageServer is null");
                    break;
                case 2:
                    x.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[]{Boolean.valueOf(fsVar.fvc.fvh)});
                    if (!fsVar.fvc.fvh) {
                        fsVar.fvd.fvk = h.b(fsVar.fvc.fve, fVar, fsVar.fvc.maxWidth);
                        break;
                    }
                    fsVar.fvd.fvk = h.j(fsVar.fvc.fve);
                    break;
                case 3:
                    x.d("MicroMsg.FavImageServiceListener", "create image server");
                    if (this.mpb != null) {
                        this.mpb.destory();
                    }
                    this.mpb = new h(fsVar.fvc.context, 16);
                    break;
                case 4:
                    x.d("MicroMsg.FavImageServiceListener", "destroy image server");
                    if (this.mpb != null) {
                        this.mpb.destory();
                        this.mpb = null;
                        break;
                    }
                    break;
            }
        }
        return false;
    }
}
