package com.tencent.mm.plugin.favorite.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.a;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c {
    public static boolean a(String str, LinkedList<uq> linkedList, long j) {
        if (str.length() == 0) {
            x.e("MicroMsg.FavPostLogic", "postNote null");
            return false;
        }
        f a;
        if (-1 == j) {
            a = a(linkedList, j);
        } else {
            a = h.getFavItemInfoStorage().db(j);
        }
        a.B(a);
        return true;
    }

    public static f a(LinkedList<uq> linkedList, long j) {
        f fVar = null;
        if (j != -1) {
            fVar = h.getFavItemInfoStorage().db(j);
            if (fVar == null) {
                fVar = j.do(j);
            }
            fVar.field_favProto.weU.clear();
        }
        if (fVar == null) {
            fVar = new f();
            fVar.field_type = 18;
            fVar.field_sourceType = 6;
            j(fVar);
            fVar.field_favProto.CR(1);
            fVar.field_favProto.CQ(127);
        }
        fVar.field_edittime = bh.Wo();
        fVar.field_updateTime = bh.Wp();
        fVar.field_favProto.fB(fVar.field_edittime);
        fVar.field_favProto.weS.fC(bh.Wp());
        fVar.field_favProto.av(linkedList);
        return fVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static List<String> aI(List<String> list) {
        if (list == null || list.size() == 0) {
            return list;
        }
        List<String> arrayList = new ArrayList();
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        for (String str : list) {
            Closeable closeable = null;
            try {
                closeable = FileOp.openRead(str);
                if (closeable == null) {
                    bh.d(closeable);
                } else {
                    if (MMBitmapFactory.checkIsImageLegal(closeable, decodeResultLogger)) {
                        arrayList.add(str);
                    } else if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                        g.pQN.k(12712, KVStatHelper.getKVStatString(closeable, 5, decodeResultLogger));
                    }
                    bh.d(closeable);
                }
            } catch (Exception e) {
                Closeable closeable2 = closeable;
                bh.d(closeable2);
            } catch (Throwable th) {
                bh.d(closeable);
            }
        }
        return arrayList;
    }

    public static boolean aJ(List<String> list) {
        List<String> aI = aI(list);
        if (aI == null || aI.size() == 0) {
            x.e("MicroMsg.FavPostLogic", "postImgs path null");
            return false;
        }
        f fVar = new f();
        fVar.field_type = 2;
        fVar.field_sourceType = 6;
        j(fVar);
        for (String str : aI) {
            uq uqVar = new uq();
            uqVar.TE(str);
            uqVar.TD(j.bk(uqVar.toString(), 2));
            d.b(str, 150, 150, CompressFormat.JPEG, 90, j.i(uqVar));
            uqVar.TF(j.i(uqVar));
            uqVar.CJ(2);
            fVar.field_favProto.weU.add(uqVar);
        }
        a.B(fVar);
        g.pQN.h(10648, new Object[]{Integer.valueOf(2), Integer.valueOf(aI.size())});
        return true;
    }

    public static void j(f fVar) {
        String FS = q.FS();
        vk vkVar = new vk();
        vkVar.Ui(FS);
        vkVar.Uj(FS);
        vkVar.CS(fVar.field_sourceType);
        vkVar.fC(bh.Wp());
        fVar.field_favProto.a(vkVar);
        fVar.field_fromUser = vkVar.fzO;
        fVar.field_toUser = vkVar.toUser;
    }
}
