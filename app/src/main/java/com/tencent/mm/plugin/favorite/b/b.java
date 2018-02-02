package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class b {
    private Queue<c> flN = new LinkedList();
    private Map<String, a> flP = new HashMap();
    boolean flR = false;
    boolean flS = false;
    public int flT = 0;
    long flU = 0;
    public ak flY = new ak(g.Dm().oAt.getLooper(), new 5(this), false);
    private i.a hBx = new 6(this);
    public n hsr = new 1(this);
    Map<String, a> mra = new HashMap();
    Set<String> mrb = new HashSet();
    boolean mrc = an.isWifi(ac.getContext());
    int mrd = 0;
    boolean mre = true;
    private Runnable mrf = new 4(this);

    static /* synthetic */ void a(b bVar, c cVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        f db = ((r) g.k(r.class)).getFavItemInfoStorage().db(cVar.field_favLocalId);
        if (db == null) {
            x.e("MicroMsg.Fav.FavCdnService", "klem onCdnTranFinish item info null!");
            return;
        }
        Iterator it = db.field_favProto.weU.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (!cVar.field_dataId.equals(uqVar.mvG)) {
                if (cVar.field_dataId.equals(j.Ac(uqVar.mvG))) {
                    uqVar.Tt(cVar.field_cdnKey);
                    uqVar.Ts(cVar.field_cdnUrl);
                    db.field_xml = f.c(db);
                    ((r) g.k(r.class)).getFavItemInfoStorage().a(db, new String[]{"localId"});
                    x.i("MicroMsg.Fav.FavCdnService", "klem onCdnTranFinish thumb key and url updated, md5:%s, cdnUrl:%s", new Object[]{cVar.field_dataId, cVar.field_cdnUrl});
                    break;
                }
            }
            uqVar.Tv(cVar.field_cdnKey);
            uqVar.Tu(cVar.field_cdnUrl);
            if (cVar.field_type == 0 && cVar.aHH()) {
                x.i("MicroMsg.Fav.FavCdnService", "video stream, id:%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFileId});
                uqVar.TJ(com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFileId);
            }
            db.field_xml = f.c(db);
            ((r) g.k(r.class)).getFavItemInfoStorage().a(db, new String[]{"localId"});
            x.i("MicroMsg.Fav.FavCdnService", "klem onCdnTranFinish data key and url updated, md5:%s, cdnUrl:%s", new Object[]{cVar.field_dataId, cVar.field_cdnUrl});
        }
        d(cVar);
    }

    public b() {
        g.Dk();
        g.Di().a(this.hsr);
    }

    public final void eX(boolean z) {
        g.Dm().F(new 2(this, z));
    }

    public final void Ah(String str) {
        x.i("MicroMsg.Fav.FavCdnService", "add force job %s", new Object[]{str});
        g.Dm().F(new 3(this, str));
    }

    public final void run() {
        x.i("MicroMsg.Fav.FavCdnService", "run fav cdn server");
        g.Dm().cfF().removeCallbacks(this.mrf);
        g.Dm().F(this.mrf);
    }

    final void OW() {
        c cVar;
        this.flU = System.currentTimeMillis();
        if (!this.flR && this.flN.size() == 0) {
            if (com.tencent.mm.compatible.util.f.ze()) {
                List<c> aHT = h.aIs().aHT();
                if (!(aHT == null || aHT.size() == 0)) {
                    for (c cVar2 : aHT) {
                        if (this.flP.containsKey(cVar2.field_dataId)) {
                            x.d("MicroMsg.Fav.FavCdnService", "File is Already running:" + cVar2.field_dataId);
                        } else {
                            this.flN.add(cVar2);
                            this.flP.put(cVar2.field_dataId, null);
                        }
                    }
                    x.i("MicroMsg.Fav.FavCdnService", "klem GetNeedRun procing:" + this.flP.size() + ",send:" + this.flN.size() + "]");
                    this.flN.size();
                }
            } else {
                x.e("MicroMsg.Fav.FavCdnService", "klem getNeedRunInfo sdcard not available");
                vB();
            }
        }
        if (!this.flR && this.flN.size() <= 0) {
            vB();
            x.i("MicroMsg.Fav.FavCdnService", "klem No Data Any More , Stop Service");
        } else if (!this.flR && this.flN.size() > 0) {
            cVar2 = (c) this.flN.poll();
            if (cVar2 != null && !bh.ov(cVar2.field_dataId)) {
                boolean z;
                i iVar;
                a aVar = (a) this.mra.get(cVar2.field_dataId);
                if (aVar == null) {
                    aVar = new a(this, (byte) 0);
                    aVar.ics = 1;
                    aVar.mrj = bh.Wp();
                    this.mra.put(cVar2.field_dataId, aVar);
                } else if (bh.Wp() - aVar.mrj > 180000 && aVar.errCode != -6101) {
                    aVar.ics = 1;
                    aVar.mrj = bh.Wp();
                    this.mra.put(cVar2.field_dataId, aVar);
                } else if (aVar.ics <= 3) {
                    aVar.ics++;
                    this.mra.put(cVar2.field_dataId, aVar);
                } else {
                    x.e("MicroMsg.Fav.FavCdnService", "check favCDN:match transfer limit 3times , localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                    c(cVar2);
                    z = false;
                    if (!z) {
                        this.flR = true;
                        if (cVar2 == null) {
                            x.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[]{cVar2.field_dataId});
                            iVar = new i();
                            iVar.htt = this.hBx;
                            iVar.field_mediaId = cVar2.field_dataId;
                            if (cVar2.field_type == 0) {
                                iVar.fLH = true;
                                iVar.field_priority = com.tencent.mm.modelcdntran.b.hrJ;
                                iVar.field_needStorage = true;
                                iVar.field_totalLen = cVar2.field_totalLen;
                                iVar.field_aesKey = cVar2.field_cdnKey;
                                iVar.field_fileId = cVar2.field_cdnUrl;
                                iVar.field_isStreamMedia = cVar2.aHH();
                                iVar.field_fullpath = cVar2.field_path;
                                if (!FileOp.bO(iVar.field_fullpath)) {
                                    x.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[]{cVar2.field_path});
                                }
                                if (cVar2.aHH()) {
                                    iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                                } else {
                                    iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                                }
                                iVar.field_force_aeskeycdn = true;
                                iVar.field_trysafecdn = false;
                                x.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn)});
                                com.tencent.mm.modelcdntran.g.MJ().c(iVar);
                                return;
                            }
                            iVar.fLH = false;
                            iVar.field_totalLen = cVar2.field_totalLen;
                            iVar.field_aesKey = cVar2.field_cdnKey;
                            iVar.field_fileId = cVar2.field_cdnUrl;
                            iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
                            iVar.htt = this.hBx;
                            iVar.field_fullpath = cVar2.field_path + ".temp";
                            iVar.field_needStorage = true;
                            iVar.field_isStreamMedia = cVar2.aHH();
                            if (cVar2.aHH()) {
                                iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                            } else {
                                iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                            }
                            com.tencent.mm.modelcdntran.g.MJ().b(iVar, -1);
                            d(cVar2);
                        }
                    } else if (this.mrd >= 10) {
                        vB();
                    } else {
                        this.flY.J(500, 500);
                    }
                }
                if (cVar2.field_type == 0) {
                    x.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                } else if (this.mrb.contains(cVar2.field_dataId) || j.Ad(cVar2.field_dataId)) {
                    x.i("MicroMsg.Fav.FavCdnService", "check favCDN:force job[normal], localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                } else {
                    if (!an.isWifi(ac.getContext())) {
                        x.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, NOT WIFI, pause it, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                        c(cVar2);
                        z = false;
                    } else if (cVar2.field_type == 0) {
                        x.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI & SENDING, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                    } else if (!this.mre) {
                        x.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                        this.mrd = 0;
                    } else if (this.mrd < 10) {
                        x.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", new Object[]{Integer.valueOf(10), Integer.valueOf(this.mrd), Integer.valueOf(aVar.ics), Long.valueOf(cVar2.field_favLocalId), cVar2.field_dataId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_dataType)});
                        if (aVar.ics == 1) {
                            this.mrd++;
                        }
                    } else {
                        x.i("MicroMsg.Fav.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", new Object[]{Integer.valueOf(10)});
                        z = false;
                    }
                    if (!z) {
                        this.flR = true;
                        if (cVar2 == null) {
                            x.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[]{cVar2.field_dataId});
                            iVar = new i();
                            iVar.htt = this.hBx;
                            iVar.field_mediaId = cVar2.field_dataId;
                            if (cVar2.field_type == 0) {
                                iVar.fLH = false;
                                iVar.field_totalLen = cVar2.field_totalLen;
                                iVar.field_aesKey = cVar2.field_cdnKey;
                                iVar.field_fileId = cVar2.field_cdnUrl;
                                iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
                                iVar.htt = this.hBx;
                                iVar.field_fullpath = cVar2.field_path + ".temp";
                                iVar.field_needStorage = true;
                                iVar.field_isStreamMedia = cVar2.aHH();
                                if (cVar2.aHH()) {
                                    iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                                } else {
                                    iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                                }
                                com.tencent.mm.modelcdntran.g.MJ().b(iVar, -1);
                                d(cVar2);
                            }
                            iVar.fLH = true;
                            iVar.field_priority = com.tencent.mm.modelcdntran.b.hrJ;
                            iVar.field_needStorage = true;
                            iVar.field_totalLen = cVar2.field_totalLen;
                            iVar.field_aesKey = cVar2.field_cdnKey;
                            iVar.field_fileId = cVar2.field_cdnUrl;
                            iVar.field_isStreamMedia = cVar2.aHH();
                            iVar.field_fullpath = cVar2.field_path;
                            if (FileOp.bO(iVar.field_fullpath)) {
                                x.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[]{cVar2.field_path});
                            }
                            if (cVar2.aHH()) {
                                iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                            } else {
                                iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                            }
                            iVar.field_force_aeskeycdn = true;
                            iVar.field_trysafecdn = false;
                            x.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn)});
                            com.tencent.mm.modelcdntran.g.MJ().c(iVar);
                            return;
                        }
                    } else if (this.mrd >= 10) {
                        this.flY.J(500, 500);
                    } else {
                        vB();
                    }
                }
                z = true;
                if (!z) {
                    this.flR = true;
                    if (cVar2 == null) {
                        x.i("MicroMsg.Fav.FavCdnService", "doTransfer, md5:%s", new Object[]{cVar2.field_dataId});
                        iVar = new i();
                        iVar.htt = this.hBx;
                        iVar.field_mediaId = cVar2.field_dataId;
                        if (cVar2.field_type == 0) {
                            iVar.fLH = true;
                            iVar.field_priority = com.tencent.mm.modelcdntran.b.hrJ;
                            iVar.field_needStorage = true;
                            iVar.field_totalLen = cVar2.field_totalLen;
                            iVar.field_aesKey = cVar2.field_cdnKey;
                            iVar.field_fileId = cVar2.field_cdnUrl;
                            iVar.field_isStreamMedia = cVar2.aHH();
                            iVar.field_fullpath = cVar2.field_path;
                            if (FileOp.bO(iVar.field_fullpath)) {
                                x.e("MicroMsg.Fav.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[]{cVar2.field_path});
                            }
                            if (cVar2.aHH()) {
                                iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                            } else {
                                iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                            }
                            iVar.field_force_aeskeycdn = true;
                            iVar.field_trysafecdn = false;
                            x.i("MicroMsg.Fav.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn)});
                            com.tencent.mm.modelcdntran.g.MJ().c(iVar);
                            return;
                        }
                        iVar.fLH = false;
                        iVar.field_totalLen = cVar2.field_totalLen;
                        iVar.field_aesKey = cVar2.field_cdnKey;
                        iVar.field_fileId = cVar2.field_cdnUrl;
                        iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
                        iVar.htt = this.hBx;
                        iVar.field_fullpath = cVar2.field_path + ".temp";
                        iVar.field_needStorage = true;
                        iVar.field_isStreamMedia = cVar2.aHH();
                        if (cVar2.aHH()) {
                            iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                        } else {
                            iVar.field_fileType = cx(cVar2.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                        }
                        com.tencent.mm.modelcdntran.g.MJ().b(iVar, -1);
                        d(cVar2);
                    }
                } else if (this.mrd >= 10) {
                    vB();
                } else {
                    this.flY.J(500, 500);
                }
            }
        }
    }

    private static void c(c cVar) {
        if (1 == cVar.field_type) {
            cVar.field_status = 2;
        } else {
            cVar.field_status = 4;
        }
        ((r) g.k(r.class)).getFavCdnStorage().a(cVar, new String[]{"dataId"});
        d(cVar);
    }

    public final void pauseDownload(String str) {
        if (!bh.ov(str) && this.flP.containsKey(str)) {
            com.tencent.mm.modelcdntran.g.MJ().kI(str);
            x.i("MicroMsg.Fav.FavCdnService", "pause download md5%s", new Object[]{str});
            d(h.aIs().zT(str));
            Ak(str);
        }
    }

    public final void Ai(String str) {
        if (!bh.ov(str)) {
            com.tencent.mm.modelcdntran.g.MJ().kH(str);
            x.i("MicroMsg.Fav.FavCdnService", "pause upload md5%s", new Object[]{str});
            d(((r) g.k(r.class)).getFavCdnStorage().zT(str));
            Ak(str);
        }
    }

    public final void vB() {
        this.flN.clear();
        this.flP.clear();
        this.flS = false;
        this.flR = false;
    }

    private static int cx(int i, int i2) {
        if ((i & 1) == 0) {
            return i2;
        }
        x.w("MicroMsg.Fav.FavCdnService", "NEED To Exchange Type, defType %d", new Object[]{Integer.valueOf(i2)});
        if (com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO == i2) {
            return com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE;
        }
        return com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO;
    }

    static boolean cx(String str, String str2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable e;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    byte[] bArr = new byte[16384];
                    fileOutputStream.write("#!AMR\n".getBytes());
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    boolean z = true;
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2, "", new Object[0]);
                        z = false;
                    }
                    try {
                        fileOutputStream.close();
                        return z;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    fileInputStream2 = fileInputStream;
                    try {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e22, "", new Object[0]);
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Throwable e222) {
                                x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e222, "", new Object[0]);
                            }
                        }
                        if (fileOutputStream != null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Throwable e2222) {
                            x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2222, "", new Object[0]);
                            return false;
                        }
                    } catch (Throwable th) {
                        e2222 = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e4, "", new Object[0]);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e5) {
                                x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e5, "", new Object[0]);
                            }
                        }
                        throw e2222;
                    }
                } catch (Throwable th2) {
                    e2222 = th2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e6) {
                e2222 = e6;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2222, "", new Object[0]);
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            } catch (Throwable th3) {
                e2222 = th3;
                fileOutputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e2222;
            }
        } catch (Exception e7) {
            e2222 = e7;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2222, "", new Object[0]);
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th4) {
            e2222 = th4;
            fileOutputStream = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e2222;
        }
    }

    static boolean Aj(String str) {
        Throwable e;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2, "", new Object[0]);
                        return false;
                    }
                }
                String str2 = new String(bArr);
                x.i("MicroMsg.Fav.FavCdnService", "head " + str2 + "   AmrFileOperator.AMR_NB_HEAD #!AMR\n");
                boolean endsWith = str2.endsWith("#!AMR\n");
                try {
                    randomAccessFile.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e3, "", new Object[0]);
                }
                return endsWith;
            } catch (Exception e4) {
                e2 = e4;
                try {
                    x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e2, "", new Object[0]);
                    if (randomAccessFile != null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            randomAccessFile = null;
            x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e22, "", new Object[0]);
            if (randomAccessFile != null) {
                return false;
            }
            randomAccessFile.close();
            return false;
        } catch (Throwable th2) {
            e22 = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e22;
        }
    }

    final void Ak(String str) {
        this.flR = false;
        this.flP.remove(str);
        pauseDownload(str);
        if (this.flT > 0) {
            OW();
            return;
        }
        x.i("MicroMsg.Fav.FavCdnService", "klem stopFlag <= 0 , Stop Service");
        vB();
    }

    static void d(c cVar) {
        if (cVar.field_type == 0) {
            e(cVar);
        } else if (cVar.field_type == 1) {
            f(cVar);
        }
    }

    public static void e(c cVar) {
        int m = ((r) g.k(r.class)).getFavCdnStorage().m(cVar.field_favLocalId, 0);
        x.i("MicroMsg.Fav.FavCdnService", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[]{Integer.valueOf(m), Long.valueOf(cVar.field_favLocalId)});
        f db = ((r) g.k(r.class)).getFavItemInfoStorage().db(cVar.field_favLocalId);
        if (db == null) {
            x.e("MicroMsg.Fav.FavCdnService", "klem updateDownloadStatus iteminfo null");
        } else if (db.aHP()) {
            x.i("MicroMsg.Fav.FavCdnService", "klem updateUploadStatus waiting server upload skip.");
        } else if (cVar.field_status == 3 && m != cVar.field_status && db.field_type == 18 && ((r) g.k(r.class)).getFavCdnStorage().zT(cVar.field_dataId).field_status == 3) {
            a(cVar, db);
        } else {
            switch (m) {
                case 0:
                    return;
                case 1:
                    if (db.aHO()) {
                        ((r) g.k(r.class)).getFavItemInfoStorage().t(15, cVar.field_favLocalId);
                    } else {
                        ((r) g.k(r.class)).getFavItemInfoStorage().t(4, cVar.field_favLocalId);
                    }
                    x.i("MicroMsg.Fav.FavCdnService", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(db.field_id), Integer.valueOf(db.field_itemStatus)});
                    return;
                case 2:
                    ((r) g.k(r.class)).getFavItemInfoStorage().t(6, cVar.field_favLocalId);
                    x.i("MicroMsg.Fav.FavCdnService", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(db.field_id), Integer.valueOf(db.field_itemStatus)});
                    return;
                case 3:
                    if (db.field_type == 18) {
                        a(cVar, db);
                        return;
                    } else if (db.aHO()) {
                        ((r) g.k(r.class)).getFavItemInfoStorage().t(17, cVar.field_favLocalId);
                        x.i("MicroMsg.Fav.FavCdnService", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(db.field_id), Integer.valueOf(db.field_itemStatus)});
                        h.aIp().run();
                        return;
                    } else {
                        ((r) g.k(r.class)).getFavItemInfoStorage().t(9, cVar.field_favLocalId);
                        x.i("MicroMsg.Fav.FavCdnService", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(db.field_id), Integer.valueOf(db.field_itemStatus)});
                        h.aIn().run();
                        return;
                    }
                case 4:
                    if (db.aHO()) {
                        ((r) g.k(r.class)).getFavItemInfoStorage().t(16, cVar.field_favLocalId);
                    } else {
                        ((r) g.k(r.class)).getFavItemInfoStorage().t(6, cVar.field_favLocalId);
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(db.field_type), Integer.valueOf(-5), Long.valueOf(j.b(db)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cU(db.field_localId))});
                    x.i("MicroMsg.Fav.FavCdnService", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(db.field_id), Integer.valueOf(db.field_itemStatus)});
                    return;
                default:
                    return;
            }
        }
    }

    public static void f(c cVar) {
        x.i("MicroMsg.Fav.FavCdnService", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[]{Integer.valueOf(((r) g.k(r.class)).getFavCdnStorage().m(cVar.field_favLocalId, 1)), Long.valueOf(cVar.field_favLocalId)});
        f db = ((r) g.k(r.class)).getFavItemInfoStorage().db(cVar.field_favLocalId);
        if (db == null) {
            x.e("MicroMsg.Fav.FavCdnService", "klem updateDownloadStatus iteminfo null");
        } else if (db.aHP() || db.aHL() || db.aHM()) {
            x.i("MicroMsg.Fav.FavCdnService", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[]{Boolean.valueOf(db.aHP()), Boolean.valueOf(db.aHL()), Boolean.valueOf(db.aHM())});
        } else {
            switch (r1) {
                case 0:
                    x.i("MicroMsg.Fav.FavCdnService", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(db.field_id)});
                    ((r) g.k(r.class)).getFavItemInfoStorage().t(10, cVar.field_favLocalId);
                    return;
                case 1:
                    com.tencent.mm.plugin.fav.a.g.cV(db.field_localId);
                    ((r) g.k(r.class)).getFavItemInfoStorage().t(7, cVar.field_favLocalId);
                    return;
                case 2:
                    x.i("MicroMsg.Fav.FavCdnService", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(db.field_id)});
                    ((r) g.k(r.class)).getFavItemInfoStorage().t(8, cVar.field_favLocalId);
                    return;
                case 3:
                    x.i("MicroMsg.Fav.FavCdnService", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(db.field_id)});
                    com.tencent.mm.plugin.report.service.g.pQN.h(10659, new Object[]{Integer.valueOf(1), Integer.valueOf(db.field_type), Integer.valueOf(0), Long.valueOf(j.b(db)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cU(db.field_localId))});
                    ((r) g.k(r.class)).getFavItemInfoStorage().t(10, cVar.field_favLocalId);
                    return;
                case 4:
                    x.i("MicroMsg.Fav.FavCdnService", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(cVar.field_favLocalId), Integer.valueOf(db.field_id), Integer.valueOf(db.field_itemStatus)});
                    com.tencent.mm.plugin.report.service.g.pQN.h(10659, new Object[]{Integer.valueOf(1), Integer.valueOf(db.field_type), Integer.valueOf(-5), Long.valueOf(j.b(db)), Long.valueOf(com.tencent.mm.plugin.fav.a.g.cU(db.field_localId))});
                    ((r) g.k(r.class)).getFavItemInfoStorage().t(8, cVar.field_favLocalId);
                    return;
                default:
                    return;
            }
        }
    }

    private static void a(c cVar, f fVar) {
        Iterator it = fVar.field_favProto.weU.iterator();
        int i = 0;
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (!(uqVar.bjS == 1 || uqVar.bjS == 6)) {
                int i2;
                if (bh.ov(uqVar.wcJ)) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        if (i != 0) {
            return;
        }
        if (fVar.field_id > 0) {
            ((r) g.k(r.class)).getFavItemInfoStorage().t(17, cVar.field_favLocalId);
            h.aIp().run();
            return;
        }
        ((r) g.k(r.class)).getFavItemInfoStorage().t(9, cVar.field_favLocalId);
        h.aIn().run();
    }

    public final void g(c cVar) {
        if (cVar != null) {
            this.flN.add(cVar);
        }
    }
}
