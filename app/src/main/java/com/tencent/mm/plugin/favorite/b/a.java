package com.tencent.mm.plugin.favorite.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.r;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.pluginsdk.k.e;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public final class a {

    private static class a implements Runnable {
        f mqC;

        public a(f fVar) {
            this.mqC = fVar;
        }

        public final void run() {
            Throwable e;
            InputStream inputStream;
            String ou;
            long me;
            String a;
            String i;
            Throwable th;
            List list = this.mqC.field_favProto.weU;
            MediaMetadataRetriever mediaMetadataRetriever;
            if (list.size() > 0) {
                boolean z = false;
                int size = list.size();
                x.i("MicroMsg.Fav.FavAddService", "run addfavservice copyrunable info.field_type = %d", new Object[]{Integer.valueOf(this.mqC.field_type)});
                uq uqVar;
                if (this.mqC.field_type == 18 && this.mqC.field_sourceType == 6) {
                    int i2 = 0;
                    while (i2 < size) {
                        boolean z2;
                        uqVar = (uq) list.get(i2);
                        if (uqVar.wdv && uqVar.wdx) {
                            z2 = z;
                        } else {
                            z2 = true;
                        }
                        i2++;
                        z = z2;
                    }
                } else {
                    for (int i3 = 0; i3 < size; i3++) {
                        String bV;
                        uqVar = (uq) list.get(i3);
                        if (bh.ov(uqVar.mvG)) {
                            uqVar.TD(j.bk(uqVar.toString(), this.mqC.field_type));
                        }
                        if (!(uqVar.wdv && uqVar.wdx)) {
                            z = true;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        String str = uqVar.wdh;
                        if (FileOp.bO(str)) {
                            bV = g.bV(str);
                            String bW = g.bW(str);
                            uqVar.TB(bV);
                            uqVar.TC(bW);
                            uqVar.fw(new File(str).length());
                            bV = j.h(uqVar);
                            if (!str.equals(bV)) {
                                FileOp.x(str, bV);
                            }
                        } else {
                            x.i("MicroMsg.Fav.FavAddService", "copy file fail, type:%d, %s not exist!", new Object[]{Integer.valueOf(uqVar.bjS), str});
                        }
                        bV = uqVar.wdj;
                        if (bh.ov(bV) && FileOp.bO(str) && this.mqC.field_type == 4 && this.mqC.field_favProto.weS.fqd == 13) {
                            bV = j.h(uqVar) + "_tempthumb";
                            Bitmap Rs = c.Rs(str);
                            if (Rs != null) {
                                try {
                                    x.i("MicroMsg.Fav.FavAddService", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                    e.a(Rs, CompressFormat.JPEG, bV);
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.Fav.FavAddService", e2, "", new Object[0]);
                                }
                            }
                            uqVar.TF(bV);
                            try {
                                x.i("MicroMsg.Fav.FavAddService", "add fav service: get video duration");
                                mediaMetadataRetriever = new MediaMetadataRetriever();
                                try {
                                    mediaMetadataRetriever.setDataSource(str);
                                    uqVar.CI(bh.fM((long) bh.getInt(mediaMetadataRetriever.extractMetadata(9), 0)));
                                    mediaMetadataRetriever.release();
                                } catch (Exception e3) {
                                    e2 = e3;
                                    try {
                                        x.printErrStackTrace("MicroMsg.Fav.FavAddService", e2, "get video duration error. path %s", new Object[]{str});
                                        if (mediaMetadataRetriever != null) {
                                            mediaMetadataRetriever.release();
                                        }
                                        if (FileOp.bO(bV)) {
                                            inputStream = null;
                                            try {
                                                inputStream = FileOp.openRead(bV);
                                                ou = bh.ou(g.a(inputStream, Downloads.RECV_BUFFER_SIZE));
                                                me = FileOp.me(bV);
                                                a = g.a(inputStream, 0, 256);
                                                uqVar.TG(ou);
                                                uqVar.TH(a);
                                                uqVar.fx(me);
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception e4) {
                                                    }
                                                }
                                            } catch (FileNotFoundException e5) {
                                                x.e("MicroMsg.Fav.FavAddService", "FileOp thumbpath error !");
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception e6) {
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception e7) {
                                                    }
                                                }
                                            }
                                            i = j.i(uqVar);
                                            if (bV.equals(i)) {
                                                FileOp.x(bV, i);
                                            }
                                        } else {
                                            x.i("MicroMsg.Fav.FavAddService", "copy thumb fail, %s not exist!", new Object[]{bV});
                                        }
                                        x.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", new Object[]{Long.valueOf(this.mqC.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                            } catch (Exception e8) {
                                e2 = e8;
                                mediaMetadataRetriever = null;
                                x.printErrStackTrace("MicroMsg.Fav.FavAddService", e2, "get video duration error. path %s", new Object[]{str});
                                if (mediaMetadataRetriever != null) {
                                    mediaMetadataRetriever.release();
                                }
                                if (FileOp.bO(bV)) {
                                    x.i("MicroMsg.Fav.FavAddService", "copy thumb fail, %s not exist!", new Object[]{bV});
                                } else {
                                    inputStream = null;
                                    inputStream = FileOp.openRead(bV);
                                    ou = bh.ou(g.a(inputStream, Downloads.RECV_BUFFER_SIZE));
                                    me = FileOp.me(bV);
                                    a = g.a(inputStream, 0, 256);
                                    uqVar.TG(ou);
                                    uqVar.TH(a);
                                    uqVar.fx(me);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    i = j.i(uqVar);
                                    if (bV.equals(i)) {
                                        FileOp.x(bV, i);
                                    }
                                }
                                x.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", new Object[]{Long.valueOf(this.mqC.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            } catch (Throwable th4) {
                                th = th4;
                                mediaMetadataRetriever = null;
                            }
                        }
                        if (FileOp.bO(bV)) {
                            inputStream = null;
                            inputStream = FileOp.openRead(bV);
                            ou = bh.ou(g.a(inputStream, Downloads.RECV_BUFFER_SIZE));
                            me = FileOp.me(bV);
                            a = g.a(inputStream, 0, 256);
                            uqVar.TG(ou);
                            uqVar.TH(a);
                            uqVar.fx(me);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            i = j.i(uqVar);
                            if (bV.equals(i)) {
                                FileOp.x(bV, i);
                            }
                        } else {
                            x.i("MicroMsg.Fav.FavAddService", "copy thumb fail, %s not exist!", new Object[]{bV});
                        }
                        x.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", new Object[]{Long.valueOf(this.mqC.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
                ag.y(new 1(this, z));
                return;
            }
            return;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }

    public static int a(cf cfVar) {
        f zU;
        int i = 1;
        f fVar = new f();
        fVar.field_favProto = cfVar.fqp.fqr;
        fVar.field_sessionId = cfVar.fqp.fqu;
        vk vkVar = fVar.field_favProto.weS;
        if (vkVar != null) {
            int i2;
            fVar.field_sourceId = vkVar.wfc;
            if (fVar.field_sourceId == null || fVar.field_sourceId.equals("")) {
                i2 = 0;
            } else {
                f zU2 = h.getFavItemInfoStorage().zU(fVar.field_sourceId);
                if (zU2 != null && zU2.field_id > 0) {
                    int i3 = zU2.field_id;
                    if (i3 <= 0) {
                        x.e("MicroMsg.Fav.ModFavItemLogic", "modUpdateTime favId illegal:%d", new Object[]{Integer.valueOf(i3)});
                    } else {
                        LinkedList linkedList = new LinkedList();
                        aru com_tencent_mm_protocal_c_aru = new aru();
                        com_tencent_mm_protocal_c_aru.wzz = 1;
                        com_tencent_mm_protocal_c_aru.wzA = (int) (System.currentTimeMillis() / 1000);
                        linkedList.add(com_tencent_mm_protocal_c_aru);
                        ar.CG().a(new r(i3, linkedList, null), 0);
                    }
                }
                i2 = zU2 != null ? 1 : 0;
            }
            if (i2 != 0) {
                x.w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
                i = 0;
                if (i != 0) {
                    zU = h.getFavItemInfoStorage().zU(fVar.field_sourceId);
                    if (zU != null) {
                        j.dn(zU.field_localId);
                    }
                } else {
                    fVar.field_flag = 0;
                    fVar.field_updateTime = System.currentTimeMillis();
                    fVar.field_localId = System.currentTimeMillis();
                    j.dn(fVar.field_localId);
                    fVar.field_type = cfVar.fqp.type;
                    if (cfVar.fqp.desc != null || cfVar.fqp.desc.length() < 10001) {
                        fVar.field_favProto.Uh(cfVar.fqp.desc);
                    } else {
                        x.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
                        fVar.field_favProto.Uh(cfVar.fqp.desc.substring(0, 10001));
                    }
                    fVar.field_xml = f.c(fVar);
                    C(fVar);
                    j.t(fVar);
                    fVar.zR("MicroMsg.Fav.FavAddService");
                }
                return 0;
            }
            fVar.field_fromUser = vkVar.fzO;
            fVar.field_toUser = vkVar.toUser;
            fVar.field_sourceType = vkVar.fqd;
            fVar.field_sourceId = vkVar.wfc;
            fVar.field_sourceCreateTime = vkVar.hVE;
        }
        x.i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", new Object[]{fVar.field_fromUser, fVar.field_toUser, fVar.field_sourceId, Integer.valueOf(fVar.field_sourceType)});
        if (i != 0) {
            fVar.field_flag = 0;
            fVar.field_updateTime = System.currentTimeMillis();
            fVar.field_localId = System.currentTimeMillis();
            j.dn(fVar.field_localId);
            fVar.field_type = cfVar.fqp.type;
            if (cfVar.fqp.desc != null) {
            }
            fVar.field_favProto.Uh(cfVar.fqp.desc);
            fVar.field_xml = f.c(fVar);
            C(fVar);
            j.t(fVar);
            fVar.zR("MicroMsg.Fav.FavAddService");
        } else {
            zU = h.getFavItemInfoStorage().zU(fVar.field_sourceId);
            if (zU != null) {
                j.dn(zU.field_localId);
            }
        }
        return 0;
    }

    public static void B(f fVar) {
        fVar.field_updateTime = System.currentTimeMillis();
        if (!j.x(fVar)) {
            fVar.field_localId = System.currentTimeMillis();
        }
        C(fVar);
        j.t(fVar);
    }

    private static void C(f fVar) {
        com.tencent.mm.plugin.fav.a.g.cT(fVar.field_localId);
        if (fVar.field_favProto.weU.size() > 0) {
            com.tencent.mm.sdk.f.e.post(new a(fVar), "AddFavService_copy");
            return;
        }
        fVar.field_itemStatus = 9;
        if (j.x(fVar)) {
            h.getFavItemInfoStorage().a(fVar, new String[0]);
        } else {
            h.getFavItemInfoStorage().f(fVar);
        }
        h.aIn().run();
    }
}
