package com.tencent.mm.plugin.favorite.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bi.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.b.af;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j {
    private static long mqp = 0;
    public static List<Integer> mqq = new LinkedList();
    private static HashMap<Long, ArrayList<String>> mqr = new HashMap();

    public static long b(f fVar) {
        return b.b(fVar);
    }

    public static String aID() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.FC()).append("favorite/").toString();
    }

    public static String aIE() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.FC()).append("favorite/web/").toString();
    }

    public static String aIF() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.FC()).append("favorite/voice/").toString();
    }

    public static String aIG() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.FC()).append("favorite/music/").toString();
    }

    public static uq a(f fVar, String str) {
        if (bh.ov(str) || fVar == null || fVar.field_favProto.weU.size() == 0) {
            return null;
        }
        Iterator it = fVar.field_favProto.weU.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (uqVar.mvG.equals(str)) {
                return uqVar;
            }
        }
        return null;
    }

    public static List<f> b(long j, int i, Set<Integer> set, n nVar) {
        if (j == 0) {
            return h.getFavItemInfoStorage().a(i, 20, set, nVar);
        }
        return h.getFavItemInfoStorage().a(j, i, set, nVar);
    }

    public static long r(long j, int i) {
        x.i("MicroMsg.FavoriteLogic", "tryStartBatchGet...");
        long g = h.getFavItemInfoStorage().g(j, 20, i);
        long f = h.getFavItemInfoStorage().f(j, 20, i);
        x.v("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[]{Long.valueOf(g), Long.valueOf(f), Long.valueOf(j)});
        if (g == 0) {
            return f;
        }
        LinkedList q = h.getFavItemInfoStorage().q(g, i);
        if (q.size() > 0) {
            x.i("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[]{Long.valueOf(g), Long.valueOf(f), Long.valueOf(j)});
            x.i("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[]{Integer.valueOf(q.size())});
            if (!ar.CG().a(new n(q), 0)) {
                x.w("MicroMsg.FavoriteLogic", "do scene BatchGetFav fail");
                n.aIT();
            }
        }
        if (f == 0) {
            return g;
        }
        return g < f ? g : f;
    }

    public static void startSync() {
        ar.CG().a(new p(), 0);
    }

    public static String Aa(String str) {
        if (bh.ov(str)) {
            return null;
        }
        File file = new File(aIE() + g.s(str.getBytes()));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static boolean e(uq uqVar) {
        return new File(h(uqVar)).exists();
    }

    public static boolean f(uq uqVar) {
        return p.UR(h(uqVar));
    }

    public static boolean aIH() {
        return n.aIU() > 0;
    }

    public static void n(f fVar) {
        if (fVar.aHM()) {
            switch (fVar.field_itemStatus) {
                case 3:
                    fVar.field_itemStatus = 1;
                    h.getFavItemInfoStorage().a(fVar, new String[]{"localId"});
                    h.aIo().run();
                    return;
                case 6:
                    if (h.aIs().cW(fVar.field_localId).size() == 0) {
                        fVar.field_itemStatus = 9;
                        h.getFavItemInfoStorage().a(fVar, new String[]{"localId"});
                        ar.CG().a(new l(fVar), 0);
                        return;
                    }
                    fVar.field_itemStatus = 4;
                    h.aIs().d(fVar);
                    h.getFavItemInfoStorage().a(fVar, new String[]{"localId"});
                    for (com.tencent.mm.plugin.fav.a.c cVar : h.aIs().cW(fVar.field_localId)) {
                        x.i("MicroMsg.FavoriteLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), cVar.field_dataId, Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen)});
                        h.aIr().Ah(cVar.field_dataId);
                    }
                    h.aIr().run();
                    return;
                case 11:
                    fVar.field_itemStatus = 9;
                    h.getFavItemInfoStorage().a(fVar, new String[]{"localId"});
                    h.aIn().run();
                    return;
                case 14:
                    h.getFavItemInfoStorage().t(12, fVar.field_localId);
                    h.aIn().run();
                    return;
                case 16:
                    h.getFavItemInfoStorage().t(15, fVar.field_localId);
                    h.aIs().d(fVar);
                    for (com.tencent.mm.plugin.fav.a.c cVar2 : h.aIs().cW(fVar.field_localId)) {
                        x.i("MicroMsg.FavoriteLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), cVar2.field_dataId, Integer.valueOf(cVar2.field_dataType), Integer.valueOf(cVar2.field_totalLen)});
                        h.aIr().Ah(cVar2.field_dataId);
                    }
                    h.aIr().run();
                    return;
                case 18:
                    h.getFavItemInfoStorage().t(17, fVar.field_localId);
                    h.aIp().run();
                    return;
                default:
                    return;
            }
        }
        x.f("MicroMsg.FavoriteLogic", "restartItemUpload status not upload failed!");
    }

    public static void o(f fVar) {
        if (fVar != null) {
            if (fVar.field_itemStatus == 8 || fVar.field_itemStatus == 10) {
                fVar.field_itemStatus = 7;
                List<uq> list = fVar.field_favProto.weU;
                if (list.size() != 0) {
                    for (uq uqVar : list) {
                        a(fVar, uqVar, true);
                        b(fVar, uqVar, true);
                    }
                    return;
                }
                return;
            }
            x.e("MicroMsg.FavoriteLogic", "status not download failed or done!");
        }
    }

    public static void a(f fVar, uq uqVar, boolean z) {
        if (fVar != null && !bh.ov(uqVar.mvG)) {
            x.i("MicroMsg.FavoriteLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), uqVar.mvG});
            com.tencent.mm.plugin.fav.a.c zT = h.aIs().zT(uqVar.mvG);
            if (zT != null && zT.field_status == 3) {
                h.aIs().b(zT, new String[]{"dataId"});
                zT = null;
            }
            if (zT != null && (bh.ov(zT.field_cdnUrl) || bh.ov(zT.field_cdnKey) || bh.ov(zT.field_dataId) || !zT.field_cdnUrl.equals(uqVar.wcJ) || !zT.field_cdnKey.equals(uqVar.wcL) || !zT.field_dataId.equals(uqVar.mvG))) {
                h.aIs().b(zT, new String[]{"dataId"});
                zT = null;
            }
            if (zT == null || zT.field_type != 1) {
                File file = new File(h(uqVar));
                if (!bh.ov(uqVar.wcL) && !bh.ov(uqVar.wcJ) && !file.exists()) {
                    x.i("MicroMsg.FavoriteLogic", "klem big img not exist, start download.");
                    long currentTimeMillis = System.currentTimeMillis();
                    a(uqVar, fVar, 1, true);
                    if (z) {
                        h.aIr().Ah(uqVar.mvG);
                        if (!bh.ov(uqVar.wdL) && uqVar.wdL.equals("WeNoteHtmlFile")) {
                            h.aIr().g(h.aIs().zT(uqVar.mvG));
                        }
                    }
                    h.aIr().run();
                    x.i("MicroMsg.FavoriteLogic", "insert cdn item use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return;
                }
                return;
            }
            x.i("MicroMsg.FavoriteLogic", "klem data not download completed.");
            zT.field_status = 1;
            h.aIs().a(zT, new String[]{"dataId"});
            if (z) {
                h.aIr().Ah(uqVar.mvG);
                if (!bh.ov(uqVar.wdL) && uqVar.wdL.equals("WeNoteHtmlFile")) {
                    h.aIr().g(h.aIs().zT(uqVar.mvG));
                }
            }
            h.aIr().run();
        }
    }

    public static void b(f fVar, uq uqVar, boolean z) {
        if (!bh.ov(uqVar.mvG)) {
            String Ac = Ac(uqVar.mvG);
            com.tencent.mm.plugin.fav.a.c zT = h.aIs().zT(Ac);
            if (zT != null && zT.field_status == 3) {
                h.aIs().b(zT, new String[]{"dataId"});
                zT = null;
            }
            if (zT == null || zT.field_type != 1) {
                File file = new File(i(uqVar));
                if (!bh.ov(uqVar.wcF) && !bh.ov(uqVar.hbj) && !file.exists()) {
                    a(uqVar, fVar, 1);
                    h.aIr().Ah(Ac);
                    h.aIr().run();
                    return;
                }
                return;
            }
            zT.field_status = 1;
            h.aIs().a(zT, new String[]{"dataId"});
            h.aIr().Ah(Ac);
            h.aIr().run();
        }
    }

    public static void g(uq uqVar) {
        com.tencent.mm.plugin.fav.a.c zT = h.aIs().zT(uqVar.mvG);
        if (!(zT == null || zT.field_status == 3)) {
            zT.field_status = 2;
            h.aIs().a(zT, new String[]{"dataId"});
            h.aIr().pauseDownload(uqVar.mvG);
        }
        zT = h.aIs().zT(Ac(uqVar.mvG));
        if (zT != null && zT.field_status != 3) {
            zT.field_status = 2;
            h.aIs().a(zT, new String[]{"dataId"});
            h.aIr().pauseDownload(Ac(uqVar.mvG));
        }
    }

    public static uq p(f fVar) {
        if (fVar == null) {
            return new uq();
        }
        return fVar.field_favProto.weU.size() == 0 ? new uq() : (uq) fVar.field_favProto.weU.get(0);
    }

    public static float bv(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static float dh(long j) {
        float f = 1.0f;
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static void q(f fVar) {
        if (fVar.aHL()) {
            x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, itemStatu:%d", new Object[]{Integer.valueOf(fVar.field_itemStatus)});
            Iterator it = fVar.field_favProto.weU.iterator();
            while (it.hasNext()) {
                uq uqVar = (uq) it.next();
                com.tencent.mm.plugin.fav.a.c zT = h.aIs().zT(uqVar.mvG);
                if (!(zT == null || zT.field_status == 3)) {
                    zT.field_status = 2;
                    h.aIs().a(zT, new String[]{"dataId"});
                    h.aIr().Ai(uqVar.mvG);
                }
                zT = h.aIs().zT(Ac(uqVar.mvG));
                if (!(zT == null || zT.field_status == 3)) {
                    zT.field_status = 2;
                    h.aIs().a(zT, new String[]{"dataId"});
                    h.aIr().Ai(Ac(uqVar.mvG));
                }
            }
            f db = h.getFavItemInfoStorage().db(fVar.field_localId);
            x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[]{Integer.valueOf(db.field_itemStatus)});
            switch (db.field_itemStatus) {
                case 1:
                    h.getFavItemInfoStorage().t(3, db.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(3)});
                    return;
                case 4:
                    h.getFavItemInfoStorage().t(6, db.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(6)});
                    return;
                case 9:
                    h.getFavItemInfoStorage().t(11, db.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(11)});
                    return;
                case 12:
                    h.getFavItemInfoStorage().t(14, db.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(14)});
                    return;
                case 15:
                    h.getFavItemInfoStorage().t(16, db.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(16)});
                    return;
                case 17:
                    h.getFavItemInfoStorage().t(18, db.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(18)});
                    return;
                default:
                    return;
            }
        }
        x.e("MicroMsg.FavoriteLogic", "pauseItemUpload, not uploading");
    }

    public static String bk(String str, int i) {
        return g.s((str + i + System.currentTimeMillis()).getBytes());
    }

    public static String h(uq uqVar) {
        if (uqVar == null) {
            return "";
        }
        String str = uqVar.mvG;
        if (bh.ov(str) || !ar.Hj()) {
            return "";
        }
        File Ab = Ab(str);
        Object obj = null;
        if (uqVar.bjS == 8 && !bh.ov(uqVar.title)) {
            str = uqVar.title;
            Ab = Ab(uqVar.mvG);
            obj = 1;
        }
        if (uqVar.wcY != null && uqVar.wcY.trim().length() > 0 && r0 == null) {
            str = str + "." + uqVar.wcY;
        }
        return new File(Ab, str).getAbsolutePath();
    }

    public static String i(uq uqVar) {
        if (uqVar == null || bh.ov(uqVar.mvG)) {
            return "";
        }
        String Ac = Ac(uqVar.mvG);
        return new File(Ab(Ac), Ac).getAbsolutePath();
    }

    private static File Ab(String str) {
        int hashCode = str.hashCode() & 255;
        r3 = new Object[3];
        ar.Hg();
        r3[0] = c.FC();
        r3[1] = "favorite";
        r3[2] = Integer.valueOf(hashCode);
        File file = new File(String.format("%s/%s/%d/", r3));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }

    public static String Ac(String str) {
        return str + "_t";
    }

    public static boolean Ad(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return str.endsWith("_t");
    }

    public static boolean a(long j, Runnable runnable) {
        return a(h.getFavItemInfoStorage().db(j), true, runnable);
    }

    public static boolean a(f fVar, Runnable runnable) {
        return a(fVar, true, null);
    }

    public static boolean a(f fVar, boolean z, Runnable runnable) {
        if (fVar == null) {
            x.w("MicroMsg.FavoriteLogic", "delete fav item fail, item is null");
            ag.y(runnable);
            return false;
        }
        if (Looper.myLooper() == ar.Dm().oAt.getLooper()) {
            x.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), Boolean.valueOf(z)});
            a(fVar, z);
            ag.y(runnable);
        } else {
            x.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), Boolean.valueOf(z)});
            ar.Dm().F(new 1(fVar, z, runnable));
        }
        return true;
    }

    private static void a(f fVar, boolean z) {
        r(fVar);
        h.aIv().dd(fVar.field_localId);
        h.getFavItemInfoStorage().g(fVar);
        h.aIs().cZ(fVar.field_localId);
        h.aIq().l(fVar);
        if (z) {
            Set aIJ = aIJ();
            aIJ.add(fVar.field_id);
            d(aIJ);
            aII();
        }
    }

    public static boolean aK(List<f> list) {
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.FavoriteLogic", "delete fav item fail, item is null");
            return false;
        }
        Set aIJ = aIJ();
        for (f fVar : list) {
            r(fVar);
            h.aIv().dd(fVar.field_localId);
            h.getFavItemInfoStorage().g(fVar);
            h.aIs().cZ(fVar.field_localId);
            h.aIq().l(fVar);
            aIJ.add(fVar.field_id);
            x.d("MicroMsg.FavoriteLogic", "delete id %d", new Object[]{Integer.valueOf(fVar.field_id)});
        }
        d(aIJ);
        aII();
        return true;
    }

    public static void aL(List<Integer> list) {
        if (list.size() == 0) {
            x.e("MicroMsg.FavoriteLogic", "setDeleted list null");
            return;
        }
        Set aIJ = aIJ();
        x.i("MicroMsg.FavoriteLogic", "setDeleted before del:%s", new Object[]{aIJ.toString()});
        for (Integer num : list) {
            boolean remove = aIJ.remove(num.toString());
            x.i("MicroMsg.FavoriteLogic", "setDeleted id:%d, ret:%b", new Object[]{num, Boolean.valueOf(remove)});
        }
        x.i("MicroMsg.FavoriteLogic", "setDeleted after del:%s", new Object[]{aIJ.toString()});
        d(aIJ);
    }

    public static void aII() {
        Set<String> aIJ = aIJ();
        if (aIJ.size() == 0) {
            x.v("MicroMsg.FavoriteLogic", "doBatchDel no item to delete");
            return;
        }
        x.i("MicroMsg.FavoriteLogic", "doBatchDel idList:%s", new Object[]{aIJ.toString()});
        LinkedList linkedList = new LinkedList();
        for (String str : aIJ) {
            try {
                linkedList.add(Integer.valueOf(bh.getInt(str, 0)));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FavoriteLogic", e, "", new Object[0]);
                x.e("MicroMsg.FavoriteLogic", "doBatchDel parseInt error:%s", new Object[]{e.getMessage()});
            }
        }
        x.i("MicroMsg.FavoriteLogic", "doBatchDel after parse, total size %d", new Object[]{Integer.valueOf(linkedList.size())});
        if (linkedList.size() > 0) {
            ar.CG().a(new m(linkedList), 0);
        }
    }

    private static void d(Set<String> set) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : set) {
            stringBuffer.append(append).append(",");
        }
        Object obj = "";
        if (stringBuffer.length() > 0) {
            obj = stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        x.i("MicroMsg.FavoriteLogic", "set need del IDs: %s", new Object[]{obj});
        ar.Hg();
        c.CU().set(225282, obj);
    }

    private static Set<String> aIJ() {
        ar.Hg();
        String str = (String) c.CU().get(225282, "");
        x.i("MicroMsg.FavoriteLogic", "get need del IDs: %s", new Object[]{str});
        Set<String> hashSet = new HashSet();
        if (bh.ov(str)) {
            return hashSet;
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            return hashSet;
        }
        for (Object add : split) {
            hashSet.add(add);
        }
        return hashSet;
    }

    private static void r(f fVar) {
        Set set = a.hZq;
        List list = fVar.field_favProto.weU;
        for (int i = 0; i < list.size(); i++) {
            String i2 = i((uq) list.get(i));
            if (set == null || !set.contains(i2)) {
                com.tencent.mm.loader.stub.b.deleteFile(i2);
            }
            i2 = h((uq) list.get(i));
            if (set == null || !set.contains(i2)) {
                com.tencent.mm.loader.stub.b.deleteFile(i2);
            }
        }
    }

    public static void a(uq uqVar, f fVar, int i, boolean z) {
        if (i == 1 && (bh.ov(uqVar.wcL) || bh.ov(uqVar.wcJ))) {
            x.e("MicroMsg.FavoriteLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
        } else if (i == 0 && bh.ov(h(uqVar))) {
            x.e("MicroMsg.FavoriteLogic", "insertCdnDataInfo, type send, path must not be null!");
        } else if (h.aIs().zT(uqVar.mvG) != null) {
            x.v("MicroMsg.FavoriteLogic", "cdn info exist, id[%s], return", new Object[]{uqVar.mvG});
        } else {
            int i2;
            x.i("MicroMsg.FavoriteLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[]{Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id)});
            com.tencent.mm.plugin.fav.a.c cVar = new com.tencent.mm.plugin.fav.a.c();
            cVar.field_dataId = uqVar.mvG;
            cVar.field_totalLen = (int) uqVar.wde;
            cVar.field_type = i;
            cVar.field_favLocalId = fVar.field_localId;
            cVar.field_cdnKey = uqVar.wcL;
            cVar.field_cdnUrl = uqVar.wcJ;
            cVar.field_path = h(uqVar);
            if (uqVar.bjS == 3) {
                String str = uqVar.wcY;
                i2 = (bh.ov(str) || !str.equals("speex")) ? (bh.ov(str) || !str.equals("silk")) ? -2 : -4 : -3;
                cVar.field_dataType = i2;
            } else {
                cVar.field_dataType = uqVar.bjS;
            }
            cVar.field_modifyTime = bh.Wp();
            boolean isWifi = an.isWifi(ac.getContext());
            if (i == 0) {
                x.i("MicroMsg.FavoriteLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen)});
                if (z) {
                    i2 = 1;
                } else if (isWifi) {
                    i2 = 1;
                } else if (cVar.field_dataType == 8 || cVar.field_dataType == 4 || cVar.field_dataType == 15) {
                    long j = ac.getContext().getSharedPreferences(ac.cfs(), 0).getLong("fav_mx_auto_upload_size", 0);
                    if (j == 0) {
                        j = 26214400;
                    }
                    if (((long) cVar.field_totalLen) <= j) {
                        x.i("MicroMsg.FavoriteLogic", "match max auto upload, max size %d", new Object[]{Long.valueOf(j)});
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    cVar.field_status = 1;
                    x.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo upload status traning");
                } else {
                    cVar.field_status = 4;
                    x.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo upload status pause");
                }
            }
            if (i == 1) {
                x.i("MicroMsg.FavoriteLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen)});
                if (z) {
                    i2 = 1;
                } else if (isWifi) {
                    i2 = 1;
                } else if (cVar.field_dataType == 8 || cVar.field_dataType == 4 || cVar.field_dataType == 15) {
                    if (((long) cVar.field_totalLen) <= ac.getContext().getSharedPreferences(ac.cfs(), 0).getLong("fav_mx_auto_download_size", 26214400)) {
                        x.i("MicroMsg.FavoriteLogic", "match max auto download, max size %d", new Object[]{Long.valueOf(ac.getContext().getSharedPreferences(ac.cfs(), 0).getLong("fav_mx_auto_download_size", 26214400))});
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    cVar.field_status = 1;
                    x.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo download status traning");
                } else {
                    cVar.field_status = 4;
                    x.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo download status pause");
                }
            }
            h.aIs().b(cVar);
            if (i == 1) {
                com.tencent.mm.plugin.favorite.b.b.f(cVar);
            } else {
                com.tencent.mm.plugin.favorite.b.b.e(cVar);
            }
        }
    }

    public static void a(uq uqVar, f fVar, int i) {
        if (i == 1 && (uqVar.wdp <= 0 || bh.ov(uqVar.wcF) || bh.ov(uqVar.hbj))) {
            x.e("MicroMsg.FavoriteLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
        } else if (i == 0 && bh.ov(i(uqVar))) {
            x.e("MicroMsg.FavoriteLogic", "insertCdnThumbInfo, type send, path must not be null!");
        } else {
            String Ac = Ac(uqVar.mvG);
            if (h.aIs().zT(Ac) != null) {
                x.w("MicroMsg.FavoriteLogic", "cdn info exist, id[%s], return", new Object[]{Ac});
                return;
            }
            x.v("MicroMsg.FavoriteLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[]{Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id)});
            com.tencent.mm.plugin.fav.a.c cVar = new com.tencent.mm.plugin.fav.a.c();
            cVar.field_cdnKey = uqVar.wcF;
            cVar.field_cdnUrl = uqVar.hbj;
            cVar.field_dataId = Ac;
            cVar.field_favLocalId = fVar.field_localId;
            cVar.field_totalLen = (int) uqVar.wdp;
            cVar.field_type = i;
            cVar.field_status = 1;
            cVar.field_path = i(uqVar);
            cVar.field_modifyTime = bh.Wp();
            cVar.field_attrFlag |= 1;
            h.aIs().b(cVar);
            if (i == 1) {
                com.tencent.mm.plugin.favorite.b.b.f(cVar);
            } else {
                com.tencent.mm.plugin.favorite.b.b.e(cVar);
            }
        }
    }

    private static void s(f fVar) {
        int i;
        com.tencent.mm.plugin.fav.a.h hVar;
        com.tencent.mm.plugin.fav.a.h de = h.aIv().de(fVar.field_localId);
        if (de == null) {
            de = new com.tencent.mm.plugin.fav.a.h();
            de.field_localId = fVar.field_localId;
            i = 1;
            hVar = de;
        } else {
            i = 0;
            hVar = de;
        }
        hVar.field_tagContent = "";
        for (String str : fVar.field_tagProto.wfi) {
            hVar.field_tagContent += " " + str;
        }
        for (String str2 : fVar.field_tagProto.wfj) {
            hVar.field_tagContent += " " + str2;
            h.aIq().zX(str2);
        }
        hVar.field_content = "";
        hVar.field_time = fVar.field_updateTime;
        hVar.field_type = fVar.field_type;
        if (i != 0) {
            h.aIv().a(hVar);
            return;
        }
        h.aIv().a(hVar, new String[]{"localId"});
    }

    public static void t(f fVar) {
        int i;
        com.tencent.mm.plugin.fav.a.h hVar;
        com.tencent.mm.plugin.fav.a.h de = h.aIv().de(fVar.field_localId);
        if (de == null) {
            de = new com.tencent.mm.plugin.fav.a.h();
            de.field_localId = fVar.field_localId;
            i = 1;
            hVar = de;
        } else {
            i = 0;
            hVar = de;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (fVar.field_favProto.title != null) {
            stringBuffer.append(fVar.field_favProto.title);
        }
        if (fVar.field_favProto.desc != null) {
            stringBuffer.append(fVar.field_favProto.desc);
        }
        if (fVar.field_favProto.weS != null) {
            vk vkVar = fVar.field_favProto.weS;
            if (!bh.ov(vkVar.fzO)) {
                stringBuffer.append(vkVar.fzO);
                ar.Hg();
                af WO = c.EY().WO(vkVar.fzO);
                if (WO != null) {
                    stringBuffer.append(WO.field_nickname).append(WO.field_conRemark);
                }
                ar.Hg();
                WO = c.EY().WO(vkVar.toUser);
                if (WO != null) {
                    stringBuffer.append(WO.field_nickname).append(WO.field_conRemark);
                }
                stringBuffer.append(vkVar.wet);
            }
        }
        LinkedList linkedList = fVar.field_favProto.weU;
        hVar.field_subtype = 0;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (uqVar.desc != null) {
                stringBuffer.append(uqVar.desc);
            }
            if (uqVar.title != null) {
                stringBuffer.append(uqVar.title);
            }
            int i2 = uqVar.bjS;
            hVar.field_subtype = com.tencent.mm.plugin.fav.a.h.pG(i2) | hVar.field_subtype;
        }
        if (fVar.field_favProto.web != null) {
            if (fVar.field_favProto.web.desc != null) {
                stringBuffer.append(fVar.field_favProto.web.desc);
            }
            if (fVar.field_favProto.web.title != null) {
                stringBuffer.append(fVar.field_favProto.web.title);
            }
        }
        if (fVar.field_favProto.wed != null) {
            if (fVar.field_favProto.wed.desc != null) {
                stringBuffer.append(fVar.field_favProto.wed.desc);
            }
            if (fVar.field_favProto.wed.title != null) {
                stringBuffer.append(fVar.field_favProto.wed.title);
            }
        }
        hVar.field_tagContent = "";
        for (String str : fVar.field_tagProto.wfi) {
            hVar.field_tagContent += " " + str;
            stringBuffer.append(str);
        }
        for (String str2 : fVar.field_tagProto.wfj) {
            hVar.field_tagContent += " " + str2;
            stringBuffer.append(str2);
            h.aIq().zX(str2);
        }
        hVar.field_content = stringBuffer.toString();
        hVar.field_time = fVar.field_updateTime;
        hVar.field_type = fVar.field_type;
        if (i != 0) {
            h.aIv().a(hVar);
            return;
        }
        h.aIv().a(hVar, new String[]{"localId"});
    }

    public static ArrayList<f> a(List<String> list, List<String> list2, List<Integer> list3, List<f> list4, Set<Integer> set, n nVar) {
        List a = h.aIv().a(list, list2, list3);
        ArrayList<f> arrayList = new ArrayList();
        if (a.size() == 0) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int size = i + 20 < a.size() ? i + 20 : a.size();
            x.v("MicroMsg.FavoriteLogic", "start:%d  end:%d listSize:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(a.size())});
            Collection a2 = h.getFavItemInfoStorage().a(a.subList(i, size), list4, set, nVar);
            if (a2 != null && a2.size() > 0) {
                arrayList.addAll(a2);
            }
            if (size >= a.size()) {
                return arrayList;
            }
            i = size;
        }
    }

    public static int Ae(String str) {
        if (!bh.ov(str) && str.equals("speex")) {
            return 1;
        }
        if (bh.ov(str) || !str.equals("silk")) {
            return 0;
        }
        return 2;
    }

    public static void di(long j) {
        x.i("MicroMsg.FavoriteLogic", "setUsedCapacity:%d", new Object[]{Long.valueOf(j)});
        ar.Hg();
        c.CU().a(w.a.xpC, Long.valueOf(j));
    }

    public static void dj(long j) {
        x.i("MicroMsg.FavoriteLogic", "setTotalCapacity:%d", new Object[]{Long.valueOf(j)});
        ar.Hg();
        c.CU().a(w.a.xpD, Long.valueOf(j));
    }

    public static long aIK() {
        long aIL = aIL() - aIM();
        if (aIL < 0) {
            return 1024;
        }
        return aIL;
    }

    public static long aIL() {
        ar.Hg();
        return ((Long) c.CU().get(w.a.xpD, Long.valueOf(0))).longValue();
    }

    public static long aIM() {
        ar.Hg();
        return ((Long) c.CU().get(w.a.xpC, Long.valueOf(0))).longValue();
    }

    public static boolean aIN() {
        if (aIL() != 0 && aIK() < 10485760) {
            return true;
        }
        return false;
    }

    public static boolean aIO() {
        if (aIL() != 0 && aIK() < 52428800) {
            return true;
        }
        return false;
    }

    public static void dk(long j) {
        ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putLong("fav_mx_auto_download_size", j).commit();
    }

    public static void dl(long j) {
        ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putLong("fav_mx_auto_upload_size", j).commit();
    }

    public static void dm(long j) {
        ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putLong("fav_mx_file_size", j).commit();
    }

    public static String ah(float f) {
        if (f < 1024.0f) {
            return String.format("%.1fB", new Object[]{Float.valueOf(f)});
        } else if (f < 1048576.0f) {
            return String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
        } else if (f < 1.07374182E9f) {
            return String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static void a(List<f> list, String[] strArr) {
        if (list != null && !list.isEmpty() && strArr != null && strArr.length > 0) {
            List<f> linkedList = new LinkedList();
            for (f fVar : list) {
                int i = 0;
                for (String zS : strArr) {
                    i |= fVar.zS(zS);
                }
                if (i != 0) {
                    h.getFavItemInfoStorage().a(fVar, new String[]{"localId"});
                    s(fVar);
                    linkedList.add(fVar);
                }
            }
            for (f fVar2 : linkedList) {
                k.a(fVar2, 3);
            }
        }
    }

    public static void a(f fVar, Collection<String> collection, int i) {
        if (fVar != null) {
            x.d("MicroMsg.FavoriteLogic", "mod tags %s", new Object[]{collection});
            Set hashSet = new HashSet();
            hashSet.addAll(fVar.field_tagProto.wfj);
            fVar.field_tagProto.wfj.clear();
            if (!(collection == null || collection.isEmpty())) {
                fVar.field_tagProto.wfj.addAll(collection);
                hashSet.removeAll(collection);
            }
            h.getFavItemInfoStorage().a(fVar, new String[]{"localId"});
            s(fVar);
            h.aIq().c(hashSet);
            k.a(fVar, i);
        }
    }

    public static String a(Context context, List<String> list) {
        if (context == null || list == null || list.isEmpty()) {
            return "";
        }
        String str = (String) list.get(0);
        String string = context.getResources().getString(R.l.egK);
        int i = 1;
        while (i < list.size()) {
            String str2 = str + string + ((String) list.get(i));
            i++;
            str = str2;
        }
        return str;
    }

    public static String B(Context context, int i) {
        if (context == null) {
            return "";
        }
        switch (i) {
            case 1:
                return context.getString(R.l.egB);
            case 2:
                return context.getString(R.l.egD);
            case 3:
                return context.getString(R.l.egJ);
            case 4:
                return context.getString(R.l.egI);
            case 5:
                return context.getString(R.l.egH);
            case 6:
                return context.getString(R.l.egE);
            case 7:
                return context.getString(R.l.egF);
            case 8:
                return context.getString(R.l.egC);
            default:
                return "";
        }
    }

    public static Integer W(Context context, String str) {
        if (context == null) {
            return Integer.valueOf(-1);
        }
        if (context.getString(R.l.egD).equals(str)) {
            return Integer.valueOf(2);
        }
        if (context.getString(R.l.egF).equals(str)) {
            return Integer.valueOf(7);
        }
        if (context.getString(R.l.egE).equals(str)) {
            return Integer.valueOf(6);
        }
        if (context.getString(R.l.egB).equals(str)) {
            return Integer.valueOf(1);
        }
        if (context.getString(R.l.egI).equals(str)) {
            return Integer.valueOf(4);
        }
        if (context.getString(R.l.egH).equals(str)) {
            return Integer.valueOf(5);
        }
        if (context.getString(R.l.egJ).equals(str)) {
            return Integer.valueOf(3);
        }
        if (context.getString(R.l.egC).equals(str)) {
            return Integer.valueOf(8);
        }
        return Integer.valueOf(-1);
    }

    public static String gv(String str) {
        ar.Hg();
        com.tencent.mm.storage.x WO = c.EY().WO(str);
        if (WO == null) {
            x.w("MicroMsg.FavoriteLogic", "wtf get contact null, username %s", new Object[]{str});
            return "";
        }
        String AQ = WO.AQ();
        if (!s.eV(AQ)) {
            return AQ;
        }
        List gj = m.gj(str);
        String FS = q.FS();
        if (gj == null || gj.isEmpty()) {
            x.w("MicroMsg.FavoriteLogic", "get members from username error, content empty");
            return AQ;
        }
        gj.remove(FS);
        gj.add(0, FS);
        return m.b(gj, 3);
    }

    public static void dn(long j) {
        mqp = j;
    }

    public static void aIP() {
        if (0 >= mqp) {
            x.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
            return;
        }
        f db = h.getFavItemInfoStorage().db(mqp);
        mqp = 0;
        if (db == null) {
            x.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
            return;
        }
        x.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav ,go on");
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 5);
        intent.putExtra("key_fav_item_id", db.field_localId);
        d.b(ac.getContext(), "favorite", ".ui.FavTagEditUI", intent);
    }

    public static boolean u(f fVar) {
        if (fVar == null) {
            return false;
        }
        if (fVar.field_itemStatus == 8 || fVar.field_itemStatus == 10 || fVar.field_itemStatus == 7) {
            return true;
        }
        return false;
    }

    public static List<Long> aIQ() {
        return h.getFavItemInfoStorage().aIg();
    }

    public static List<f> f(List<f> list, List<Long> list2) {
        int i = 0;
        List<f> arrayList = new ArrayList();
        if (list2 == null) {
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
            Long valueOf = Long.valueOf(((f) list.get(list.size() - 1)).field_localId);
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (valueOf.equals(list2.get(i2))) {
                    i = i2 + 1;
                    break;
                }
            }
        }
        int i3 = i;
        while (i3 < i + 20 && i3 < list2.size()) {
            f db = h.getFavItemInfoStorage().db(((Long) list2.get(i3)).longValue());
            if (db != null) {
                arrayList.add(db);
            }
            i3++;
        }
        return arrayList;
    }

    public static boolean pJ(int i) {
        for (int i2 : com.tencent.mm.plugin.fav.a.a.mnR) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static f Af(String str) {
        f fVar = new f();
        fVar.field_localId = -1;
        fVar.field_id = -1;
        fVar.field_xml = str;
        fVar.field_type = 18;
        fVar.zQ(str);
        return fVar;
    }

    public static void a(uq uqVar, int i) {
        if (!bh.ov(uqVar.mvG)) {
            x.i("MicroMsg.FavoriteLogic", "restart cdndata download, dataId %s", new Object[]{uqVar.mvG});
            com.tencent.mm.plugin.fav.a.c zT = h.aIs().zT(uqVar.mvG);
            if (zT != null && (zT.field_status == 3 || zT.field_status == 4)) {
                h.aIs().b(zT, new String[]{"dataId"});
                zT = null;
            }
            if (zT == null || zT.field_type != 1) {
                File file = new File(h(uqVar));
                if (!bh.ov(uqVar.wcL) && !bh.ov(uqVar.wcJ) && !file.exists()) {
                    x.i("MicroMsg.FavoriteLogic", "klem big img not exist, start download.");
                    long currentTimeMillis = System.currentTimeMillis();
                    f fVar = new f();
                    fVar.field_localId = -1;
                    fVar.field_id = -1;
                    fVar.field_type = i;
                    a(uqVar, fVar, 1, true);
                    h.aIr().Ah(uqVar.mvG);
                    h.aIr().run();
                    x.i("MicroMsg.FavoriteLogic", "insert cdn item use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return;
                }
                return;
            }
            x.i("MicroMsg.FavoriteLogic", "klem data not download completed.");
            zT.field_status = 1;
            h.aIs().a(zT, new String[]{"dataId"});
            h.aIr().Ah(uqVar.mvG);
            h.aIr().run();
        }
    }

    public static void b(uq uqVar, int i) {
        if (!bh.ov(uqVar.mvG) && !bh.ov(uqVar.wcF) && !bh.ov(uqVar.hbj)) {
            String Ac = Ac(uqVar.mvG);
            com.tencent.mm.plugin.fav.a.c zT = h.aIs().zT(Ac);
            if (zT != null && (zT.field_status == 3 || zT.field_status == 4)) {
                h.aIs().b(zT, new String[]{"dataId"});
                zT = null;
            }
            if (zT == null || zT.field_type != 1) {
                File file = new File(i(uqVar));
                if (!bh.ov(uqVar.wcF) && !bh.ov(uqVar.hbj) && !file.exists()) {
                    f fVar = new f();
                    fVar.field_localId = -1;
                    fVar.field_id = -1;
                    fVar.field_type = i;
                    a(uqVar, fVar, 1);
                    h.aIr().Ah(Ac);
                    h.aIr().run();
                    return;
                }
                return;
            }
            zT.field_status = 1;
            h.aIs().a(zT, new String[]{"dataId"});
            h.aIr().Ah(Ac);
            h.aIr().run();
        }
    }

    public static boolean v(f fVar) {
        if (fVar == null) {
            return false;
        }
        uq p = p(fVar);
        if (p == null) {
            return false;
        }
        int bsA;
        int i;
        boolean a;
        long Wq = bh.Wq();
        com.tencent.mm.plugin.sight.base.a Js = com.tencent.mm.plugin.sight.base.d.Js(h(p));
        if (Js != null) {
            bsA = Js.bsA();
            i = p.duration;
            if (i <= 0 || Math.abs(i - bsA) >= 2) {
                p.CI(bsA);
                a = h.getFavItemInfoStorage().a(fVar, new String[]{"localId"});
            } else {
                a = false;
            }
        } else {
            a = false;
            i = 0;
            bsA = 0;
        }
        x.i("MicroMsg.FavoriteLogic", "repair video duration[%d TO %d] %b cost time %d", new Object[]{Integer.valueOf(i), Integer.valueOf(bsA), Boolean.valueOf(a), Long.valueOf(bh.bA(Wq))});
        return a;
    }

    public static void a(r rVar) {
        if (rVar.hmG != null && rVar.hmG.Hp() != null && rVar.hmG.Hp().vBp == -435) {
            f dc = h.getFavItemInfoStorage().dc((long) rVar.mqN);
            if (dc != null && dc.field_favProto != null && dc.field_favProto.weU != null) {
                dc.field_favProto.CR(dc.field_favProto.version + 2);
                dc.field_itemStatus = 1;
                h.getFavItemInfoStorage().a(dc, new String[]{"localId"});
                h.aIo().run();
            }
        }
    }

    public static void e(String str, Context context) {
        String nG = t.nG(str);
        x.i("MicroMsg.FavoriteLogic", "save video now video path %s out path %s", new Object[]{str, nG});
        if (bh.ov(nG)) {
            Toast.makeText(context, context.getString(R.l.eTd), 1).show();
            return;
        }
        Toast.makeText(context, context.getString(R.l.eTe, new Object[]{nG}), 1).show();
        k.b(nG, context);
    }

    public static boolean a(List<f> list, Context context, OnClickListener onClickListener) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        d dVar = new d();
        int i = 0;
        int i2 = 0;
        Object obj = null;
        int i3 = 0;
        int i4 = 0;
        for (f fVar : list) {
            if (!(fVar == null || fVar.field_favProto == null || fVar.field_favProto.weU == null)) {
                if (fVar.field_type == 3) {
                    i2++;
                } else {
                    Object obj2;
                    Iterator it = fVar.field_favProto.weU.iterator();
                    int i5 = 0;
                    int i6 = i;
                    i = i4;
                    while (it.hasNext()) {
                        uq uqVar = (uq) it.next();
                        if (uqVar.wdR == 2) {
                            i6++;
                        } else if (uqVar.wdR == 1) {
                            i++;
                        } else {
                            i5++;
                        }
                    }
                    if (d.k(fVar)) {
                        i4 = i3 + 1;
                        if (i5 > 0) {
                            i5--;
                        }
                    } else {
                        i4 = i3;
                    }
                    if (obj == null && r7 == fVar.field_favProto.weU.size()) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                    i3 = i4;
                    i4 = i;
                    i = i6;
                }
            }
        }
        if (1 == list.size()) {
            if (((f) list.get(0)).field_type == 14 && (i > 0 || i4 > 0)) {
                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.eeO));
                return false;
            } else if (i > 0) {
                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.eeP));
                return false;
            } else if (i4 > 0) {
                switch (((f) list.get(0)).field_type) {
                    case 2:
                        com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.eeR));
                        break;
                    case 4:
                    case 16:
                        com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.eeS));
                        break;
                    case 8:
                        com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.eeQ));
                        break;
                }
                return false;
            } else if (i3 > 0) {
                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.dBN));
                return false;
            } else if (i2 > 0) {
                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.dBO));
                return false;
            }
        } else if (i > 0 || i4 > 0 || i3 > 0 || i2 > 0) {
            if (obj != null) {
                com.tencent.mm.ui.base.h.a(context, context.getString(R.l.eeU), "", context.getString(R.l.dUc), context.getString(R.l.dUa), onClickListener, null, R.e.bui);
            } else {
                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.eeT));
            }
            return false;
        }
        return true;
    }

    public static boolean w(f fVar) {
        if (fVar.field_favProto == null) {
            return false;
        }
        Iterator it = fVar.field_favProto.weU.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (uqVar.wdR == 2) {
                return true;
            }
            if (uqVar.wdR == 1) {
                return true;
            }
        }
        return false;
    }

    public static f do(long j) {
        f fVar = new f();
        fVar.field_type = 18;
        fVar.field_sourceType = 6;
        String FS = q.FS();
        vk vkVar = new vk();
        vkVar.Ui(FS);
        vkVar.Uj(FS);
        vkVar.CS(fVar.field_sourceType);
        vkVar.fC(bh.Wp());
        fVar.field_favProto.a(vkVar);
        fVar.field_fromUser = vkVar.fzO;
        fVar.field_toUser = vkVar.toUser;
        fVar.field_favProto.CR(1);
        fVar.field_favProto.CQ(127);
        fVar.field_edittime = bh.Wo();
        fVar.field_updateTime = bh.Wp();
        fVar.field_favProto.fB(fVar.field_edittime);
        fVar.field_favProto.weS.fC(bh.Wp());
        fVar.field_itemStatus = 9;
        fVar.field_localId = j;
        h.getFavItemInfoStorage().f(fVar);
        return fVar;
    }

    public static boolean x(f fVar) {
        if (h.getFavItemInfoStorage().db(fVar.field_localId) != null) {
            return true;
        }
        return false;
    }

    private static String dp(long j) {
        StringBuilder stringBuilder = new StringBuilder();
        f db = h.getFavItemInfoStorage().db(j);
        if (db == null || db.field_favProto == null || db.field_favProto.weU.size() <= 1) {
            return "";
        }
        uy uyVar = db.field_favProto.vCU;
        String str = "";
        String str2 = "";
        if (uyVar != null) {
            str = uyVar.weM;
            str2 = uyVar.weL;
        }
        stringBuilder.append("<noteinfo>");
        stringBuilder.append("<noteauthor>").append(str2).append("</noteauthor>");
        stringBuilder.append("<noteeditor>").append(str).append("</noteeditor>");
        stringBuilder.append("<edittime>").append(db.field_favProto.vCV).append("</edittime>");
        stringBuilder.append("<favlocalid>").append(db.field_localId).append("</favlocalid>");
        stringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.aG(db.field_favProto.weU).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
        stringBuilder.append("</noteinfo>");
        return stringBuilder.toString();
    }

    private static f Ag(String str) {
        if (str == null || str.equals("")) {
            x.e("MicroMsg.FavoriteLogic", "parseSnsNoteInfoXml but xml is null");
            return null;
        }
        String str2;
        String replace = str.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
        if (replace.startsWith("<noteinfo>")) {
            str2 = replace;
        } else {
            str2 = "<noteinfo>" + replace + "</noteinfo>";
        }
        Map y = bi.y(str2, "noteinfo");
        if (y == null) {
            x.e("MicroMsg.FavoriteLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
            return null;
        }
        f fVar = new f();
        try {
            fVar.field_favProto = new ve();
            fVar.field_type = 18;
            fVar.field_favProto.fB(bh.getLong((String) y.get(".noteinfo.edittime"), 0));
            uy uyVar = new uy();
            uyVar.weM = (String) y.get(".noteinfo.noteeditor");
            uyVar.weL = (String) y.get(".noteinfo.noteauthor");
            fVar.field_favProto.a(uyVar);
            fVar.field_localId = bh.getLong((String) y.get(".noteinfo.favlocalid"), System.currentTimeMillis());
            com.tencent.mm.plugin.fav.a.a.b.a(str2, fVar.field_favProto);
            return fVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FavoriteLogic", e, "", new Object[0]);
            x.e("MicroMsg.FavoriteLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", new Object[]{e.toString()});
            return null;
        }
    }

    public static void d(Context context, String str, String str2, String str3) {
        f Ag = Ag(str);
        if (Ag != null) {
            com.tencent.mm.sdk.b.b koVar = new ko();
            koVar.fBM.type = 2;
            koVar.fBM.field_localId = -1;
            koVar.fBM.context = context;
            koVar.fBM.fBT = 4;
            koVar.fBM.fBV = true;
            Bundle bundle = new Bundle();
            bundle.putString("noteauthor", Ag.field_favProto.vCU.weL);
            bundle.putString("noteeditor", Ag.field_favProto.vCU.weM);
            bundle.putLong("edittime", Ag.field_favProto.vCV);
            bundle.putString("notexml", f.c(Ag));
            bundle.putString("snslocalid", str2);
            bundle.putString("snsthumbpath", str3);
            bundle.putString("snsnotelinkxml", str);
            koVar.fBM.fBR = bundle;
            koVar.fBM.field_favProto = Ag.field_favProto;
            com.tencent.mm.sdk.b.a.xef.m(koVar);
        }
    }

    public static f a(ve veVar) {
        f fVar = new f();
        fVar.field_favProto = new ve();
        fVar.field_type = 18;
        fVar.field_favProto = veVar;
        return fVar;
    }

    public static void b(fv fvVar) {
        f db;
        uq uqVar;
        if (fvVar.fvq.fvx == -1) {
            db = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
            if (db != null && db.field_favProto != null && db.field_favProto.weU.size() > 1) {
                uqVar = (uq) db.field_favProto.weU.get(0);
                fvVar.fvr.fvI = bh.ov(uqVar.wcJ);
            }
        } else if (fvVar.fvq.fvx != -3 || fvVar.fvq.fqk <= 0) {
            f db2;
            if (fvVar.fvq.fvx == -2 && fvVar.fvq.fqk > 0) {
                db2 = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
                if (!(db2 == null || db2.field_itemStatus != 10 || bh.ov(db2.field_xml))) {
                    db2.zQ(db2.field_xml);
                    if (db2.field_favProto != null && db2.field_favProto.weU.size() > 1) {
                        uqVar = (uq) db2.field_favProto.weU.get(0);
                        if (!(bh.ov(uqVar.wcJ) || bh.ov(uqVar.wcL))) {
                            h.getFavItemInfoStorage().a(db2, new String[]{"localId"});
                            return;
                        }
                    }
                }
            }
            Intent intent = new Intent();
            if (fvVar.fvq.fqk > 0 && !bh.ov(fvVar.fvq.desc) && fvVar.fvq.fvx > 0) {
                db2 = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
                if (db2 != null) {
                    intent.putExtra("fav_note_xml", f.c(db2));
                    intent.putExtra("fav_note_item_updatetime", db2.field_updateTime);
                }
            }
            db2 = c.a(fvVar.fvq.fqr.weU, fvVar.fvq.fqk);
            if (bh.ov(fvVar.fvq.desc)) {
                if (db2.field_favProto.version != 0) {
                    db2.field_favProto.CR(db2.field_favProto.version + 1);
                } else {
                    db2.field_favProto.CR(db2.field_favProto.version + 2);
                }
                db2.field_itemStatus = 1;
                y(db2);
                h.getFavItemInfoStorage().a(db2, new String[]{"localId"});
                h.aIo().run();
                return;
            }
            if (fvVar.fvq.fvx > 0) {
                intent.putExtra("fav_note_item_status", db2.field_itemStatus);
                fvVar.fvq.fvt = intent;
                db2.field_favProto.CR(db2.field_favProto.version + 1);
            }
            db2.field_itemStatus = 1;
            y(db2);
            h.getFavItemInfoStorage().a(db2, new String[]{"localId"});
            if (fvVar.fvq.desc.equals("fav_add_new_note")) {
                if (db2.field_favProto.version != 0) {
                    db2.field_favProto.CR(db2.field_favProto.version + 1);
                } else {
                    db2.field_favProto.CR(db2.field_favProto.version + 2);
                }
                h.getFavItemInfoStorage().a(db2, new String[]{"localId"});
                c.a(fvVar.fvq.title, fvVar.fvq.fqr.weU, fvVar.fvq.fqk);
            }
        } else {
            db = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
            if (db != null) {
                db.field_itemStatus = fvVar.fvq.fvt.getIntExtra("fav_note_item_status", db.field_itemStatus);
                db.field_updateTime = fvVar.fvq.fvt.getLongExtra("fav_note_item_updatetime", db.field_updateTime);
                db.zQ(fvVar.fvq.fvt.getStringExtra("fav_note_xml"));
                h.getFavItemInfoStorage().a(db, new String[]{"localId"});
            }
        }
    }

    private static void b(f fVar, boolean z) {
        uy uyVar = new uy();
        if (!z) {
            uyVar.weL = q.FS();
        }
        uyVar.weM = q.FS();
        fVar.field_favProto.fB(bh.Wo());
        fVar.field_favProto.a(uyVar);
    }

    public static void y(f fVar) {
        if (fVar != null) {
            uy uyVar = fVar.field_favProto.vCU;
            if ((uyVar == null || bh.ov(uyVar.weM)) && fVar.field_type == 18) {
                if (fVar.field_favProto.weS.fqd == 6) {
                    b(fVar, false);
                } else {
                    b(fVar, true);
                }
                h.getFavItemInfoStorage().a(fVar, new String[]{"localId"});
            }
        }
    }

    private static void c(fv fvVar) {
        if (bh.ov(fvVar.fvq.desc)) {
            fvVar.fvr.ret = -1;
            return;
        }
        f Ag = Ag(fvVar.fvq.desc);
        if (Ag == null || Ag.field_localId <= 0) {
            fvVar.fvr.ret = -1;
            return;
        }
        boolean A = A(Ag);
        String str = fvVar.fvq.fvw;
        ArrayList arrayList;
        if (A) {
            fvVar.fvr.ret = 1;
            arrayList = (ArrayList) mqr.get(Long.valueOf(Ag.field_localId));
            if (arrayList != null) {
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
                if (arrayList.size() == 0) {
                    mqr.remove(Long.valueOf(Ag.field_localId));
                }
            }
        } else if (bh.ov(str)) {
            fvVar.fvr.ret = -1;
        } else {
            long j = Ag.field_localId;
            if (mqr.get(Long.valueOf(j)) == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = (ArrayList) mqr.get(Long.valueOf(j));
            }
            arrayList.add(str);
            mqr.put(Long.valueOf(j), arrayList);
            f db = h.getFavItemInfoStorage().db(j);
            if (db == null || db.field_localId <= 0) {
                fvVar.fvr.ret = -1;
            } else if (A(db) || db.field_itemStatus == 10) {
                fvVar.fvr.ret = -1;
                ar.Dm().g(new 2(db), 500);
            } else {
                fvVar.fvr.ret = -1;
            }
        }
    }

    public static synchronized void z(f fVar) {
        synchronized (j.class) {
            if (fVar != null) {
                if (fVar.field_type == 18) {
                    if (!(!mqr.containsKey(Long.valueOf(fVar.field_localId)) || mqr.get(Long.valueOf(fVar.field_localId)) == null || ((ArrayList) mqr.get(Long.valueOf(fVar.field_localId))).size() == 0)) {
                        x.i("MicroMsg.FavoriteLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", new Object[]{Long.valueOf(fVar.field_localId), dp(fVar.field_localId)});
                        com.tencent.mm.sdk.b.b nrVar = new nr();
                        nrVar.fFH.fFI = (ArrayList) mqr.get(Long.valueOf(fVar.field_localId));
                        nrVar.fFH.fFJ = r2;
                        com.tencent.mm.sdk.b.a.xef.m(nrVar);
                        mqr.remove(Long.valueOf(fVar.field_localId));
                    }
                }
            }
        }
    }

    private static boolean A(f fVar) {
        if (fVar == null) {
            return false;
        }
        boolean z;
        Iterator it = fVar.field_favProto.weU.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if ((uqVar.bjS == 8 || uqVar.bjS == 4 || uqVar.bjS == 2 || uqVar.bjS == 3) && (bh.ov(uqVar.wcJ) || bh.ov(uqVar.wcL))) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public static void d(fv fvVar) {
        int i = 0;
        if (fvVar.fvq.fvx == 1) {
            String str;
            fvVar.fvr.path = dp(fvVar.fvq.fqk);
            fv.b bVar = fvVar.fvr;
            f db = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
            if (db == null || db.field_favProto == null) {
                str = "";
            } else {
                if (db.field_type != 18 || db.field_favProto.weU.size() > 1) {
                    Iterator it = db.field_favProto.weU.iterator();
                    while (it.hasNext()) {
                        uq uqVar = (uq) it.next();
                        switch (uqVar.bjS) {
                            case 2:
                                str = i(uqVar);
                                if (!e.bO(str)) {
                                    String h = h(uqVar);
                                    if (!e.bO(h)) {
                                        if (!uqVar.wcE) {
                                            if (!uqVar.wcK) {
                                                str = "";
                                                break;
                                            }
                                            a(db, uqVar, true);
                                            str = h;
                                            break;
                                        }
                                        b(db, uqVar, true);
                                        break;
                                    }
                                    com.tencent.mm.sdk.platformtools.d.b(h, 150, 150, CompressFormat.JPEG, 90, str);
                                    str = i(uqVar);
                                    break;
                                }
                                break;
                            default:
                        }
                    }
                }
                str = "";
            }
            bVar.fvC = str;
        } else if (fvVar.fvq.fvx == 2) {
            r0 = new f();
            r0.field_type = 2;
            uq uqVar2 = new uq();
            uqVar2.TD(bk(uqVar2.toString(), 2));
            String h2 = h(uqVar2);
            uqVar2.TE(h2);
            uqVar2.CJ(2);
            r0.field_favProto.weU.add(uqVar2);
            fvVar.fvr.path = f.c(r0);
            fvVar.fvr.fvC = h2;
        } else if (fvVar.fvq.fvx == 3) {
            r0 = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
            if (r0 != null) {
                fvVar.fvr.path = q.FS() + ";" + r0.field_fromUser + ";" + r0.field_updateTime;
            }
        } else if (fvVar.fvq.fvx == 4) {
            r0 = Ag(fvVar.fvq.desc);
            if (r0 != null) {
                fvVar.fvq.fqr = r0.field_favProto;
            }
        } else if (fvVar.fvq.fvx == 5) {
            c(fvVar);
        } else if (fvVar.fvq.fvx == 6) {
            f db2 = h.getFavItemInfoStorage().db(fvVar.fvq.fqk);
            if (db2 == null) {
                fvVar.fvr.ret = 0;
                return;
            }
            fv.b bVar2 = fvVar.fvr;
            if (db2.field_id > 0) {
                i = 1;
            }
            bVar2.ret = i;
        } else {
            r0 = new f();
            r0.field_type = 18;
            r0.field_favProto = fvVar.fvq.fqr;
            fvVar.fvr.path = f.c(r0);
        }
    }
}
