package com.tencent.mm.modelvideo;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.h;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelvideo.s.2;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.protocal.c.brb;
import com.tencent.mm.protocal.c.brc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g extends k implements com.tencent.mm.network.k {
    private static int hUm = 32000;
    private final int MAX_TIMES;
    private String fHk = "";
    String fileName;
    private b gJQ;
    private e gJT;
    private boolean hBF = true;
    private String hBn = "";
    private a hBx = new 1(this);
    com.tencent.mm.compatible.util.g.a hEZ = null;
    private r hTR;
    private int hTT = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
    private boolean hTU = false;
    private final long hUn = 1800000;
    boolean hUo = false;
    private int hUp = -1;
    private boolean hUq = false;
    private boolean hUr = false;
    private int hUs = 0;
    private int hUt = 0;
    int hUu = 0;
    ak hkO = new ak(new 2(this), true);
    int retCode = 0;
    private long startTime = 0;

    static /* synthetic */ void a(g gVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        n TS = n.TS();
        o.TU();
        TS.a(com_tencent_mm_modelcdntran_keep_SceneResult, s.nt(gVar.fileName));
    }

    static /* synthetic */ int l(g gVar) {
        o.TU();
        String nt = s.nt(gVar.hTR.getFileName());
        if (c.oy(nt)) {
            int i;
            com.tencent.mm.plugin.a.b bVar = new com.tencent.mm.plugin.a.b();
            long ox = bVar.ox(nt);
            long j = bVar.ieD;
            if (ox >= HardCoderJNI.ACTION_NET_RX || ox <= 0 || gVar.hTR.hVH <= 5 || bVar.ieE <= 0 || j <= 0) {
                i = 0;
            } else {
                i = ((int) j) + ((int) ((bVar.ieE * 5) / ((long) gVar.hTR.hVH)));
                if (i <= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    i += WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                }
            }
            x.i("MicroMsg.NetSceneUploadVideo", "%s check preload length[%d] moovPos[%d %d] duration[%d] filelen[%d]", gVar.TL(), Integer.valueOf(i), Long.valueOf(ox), Long.valueOf(j), Integer.valueOf(gVar.hTR.hVH), Long.valueOf(bVar.ieE));
            return i;
        }
        x.w("MicroMsg.NetSceneUploadVideo", "%s check preload length but it not mp4.", gVar.TL());
        return 0;
    }

    protected final void cancel() {
        x.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", TL(), this.hBn);
        if (!bh.ov(this.hBn)) {
            com.tencent.mm.modelcdntran.g.MJ().kH(this.hBn);
        }
        this.hTU = true;
        super.cancel();
    }

    private boolean TK() {
        if (s.ho(this.hTR.Ud())) {
            x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", TL(), this.hTR.Ud());
            return false;
        }
        com.tencent.mm.modelcdntran.g.MJ();
        if (com.tencent.mm.modelcdntran.c.hu(2) || this.hTR.hVM == 1) {
            this.hBn = d.a("upvideo", this.hTR.hVE, this.hTR.Ud(), this.hTR.getFileName());
            if (bh.ov(this.hBn)) {
                x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", TL(), this.hTR.getFileName());
                return false;
            }
            o.TU();
            String nu = s.nu(this.fileName);
            o.TU();
            String nt = s.nt(this.fileName);
            i iVar = new i();
            iVar.htt = this.hBx;
            iVar.field_mediaId = this.hBn;
            iVar.field_fullpath = nt;
            iVar.field_thumbpath = nj(nu);
            iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
            iVar.field_enable_hitcheck = this.hBF;
            iVar.field_largesvideo = com.tencent.mm.modelcontrol.d.MU().kM(nt);
            if (this.hTR != null && 3 == this.hTR.hVO) {
                iVar.field_smallVideoFlag = 1;
            }
            String str = "MicroMsg.NetSceneUploadVideo";
            String str2 = "%s upload video MMSightExtInfo is null? %b %s";
            Object[] objArr = new Object[3];
            objArr[0] = TL();
            objArr[1] = Boolean.valueOf(this.hTR.hVR == null);
            objArr[2] = this.fileName;
            x.i(str, str2, objArr);
            if (this.hTR.hVR != null && this.hTR.hVR.wwP) {
                x.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", TL());
                o.TU();
                n.TS().a("", s.nt(this.fileName), this.hTR.Ud(), "", "", 2, 2);
                iVar.field_largesvideo = true;
            }
            str = "MicroMsg.NetSceneUploadVideo";
            str2 = "%s checkAD file:%s adinfo:%s";
            objArr = new Object[3];
            objArr[0] = TL();
            objArr[1] = this.hTR.getFileName();
            objArr[2] = this.hTR.hVQ == null ? "null" : this.hTR.hVQ.hdu;
            x.i(str, str2, objArr);
            if (!(this.hTR.hVQ == null || bh.ov(this.hTR.hVQ.hdu))) {
                iVar.field_advideoflag = 1;
            }
            iVar.field_talker = this.hTR.Ud();
            iVar.field_chattype = s.eV(this.hTR.Ud()) ? 1 : 0;
            iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
            iVar.field_needStorage = false;
            iVar.field_isStreamMedia = false;
            iVar.field_trysafecdn = true;
            this.hUt = com.tencent.mm.a.e.bN(iVar.field_fullpath);
            this.hUs = com.tencent.mm.a.e.bN(iVar.field_thumbpath);
            if (this.hUs >= com.tencent.mm.modelcdntran.b.hsf) {
                x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", TL(), iVar.field_thumbpath, Integer.valueOf(this.hUs));
                return false;
            }
            int i;
            Map y = bi.y(this.hTR.Ug(), "msg");
            if (y != null) {
                iVar.field_fileId = (String) y.get(".msg.videomsg.$cdnvideourl");
                iVar.field_aesKey = (String) y.get(".msg.videomsg.$aeskey");
                this.hUr = true;
            } else {
                x.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", TL());
                try {
                    boolean z;
                    boolean z2;
                    boolean z3;
                    String[] split;
                    String[] split2 = bh.ou(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("UseVideoHash")).split(",");
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Dh();
                    int aJ = h.aJ(com.tencent.mm.kernel.a.Cg(), 100);
                    boolean z4 = (split2 == null || split2.length <= 0) ? false : bh.getInt(split2[0], 0) >= aJ;
                    boolean z5 = (split2 == null || split2.length < 2) ? false : bh.getInt(split2[1], 0) >= aJ;
                    boolean z6 = (split2 == null || split2.length < 3) ? false : bh.getInt(split2[2], 0) >= aJ;
                    if (com.tencent.mm.sdk.a.b.ceK()) {
                        z = true;
                        z2 = true;
                        z3 = true;
                    } else {
                        z = z5;
                        z2 = z4;
                        z3 = z6;
                    }
                    if (z2) {
                        s TU = o.TU();
                        x.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", Integer.valueOf(bh.getInt(split2[2], 0)), nt, bh.cgy());
                        long Wp = bh.Wp();
                        if (bh.ov(nt)) {
                            x.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", nt);
                            nu = "";
                        } else {
                            int[] nw = s.nw(nt);
                            if (nw == null || nw.length < 33) {
                                x.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", nt);
                                nu = "";
                            } else {
                                int i2;
                                TU.hhp.fx("VideoHash", "delete from VideoHash where CreateTime < " + (bh.Wo() - 432000));
                                int i3 = nw[32];
                                StringBuffer stringBuffer = new StringBuffer();
                                for (i = 0; i < 32; i++) {
                                    stringBuffer.append(Integer.toHexString(nw[i]));
                                }
                                int length = stringBuffer.length();
                                Vector vector = new Vector();
                                Vector vector2 = new Vector();
                                Vector vector3 = new Vector();
                                Vector vector4 = new Vector();
                                int i4 = -1;
                                Cursor a = TU.hhp.a("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = " + i3, null, 0);
                                while (a.moveToNext()) {
                                    long j = a.getLong(1);
                                    String string = a.getString(2);
                                    String string2 = a.getString(3);
                                    String string3 = a.getString(4);
                                    x.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", string, string2);
                                    if (bh.ov(string) || bh.ov(string2)) {
                                        com.tencent.mm.plugin.report.service.g.pQN.h(12696, Integer.valueOf(104), Integer.valueOf(i3));
                                        x.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", string, string2);
                                    } else if (length != string.length()) {
                                        com.tencent.mm.plugin.report.service.g.pQN.h(12696, Integer.valueOf(105), Integer.valueOf(i3));
                                        x.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", Integer.valueOf(length), Integer.valueOf(string.length()));
                                    } else {
                                        i2 = 0;
                                        aJ = 0;
                                        while (aJ < length) {
                                            if (stringBuffer.charAt(aJ) == string.charAt(aJ)) {
                                                i = i2 + 1;
                                            } else {
                                                i = i2;
                                            }
                                            aJ++;
                                            i2 = i;
                                        }
                                        if (i4 < 0 || vector3.size() <= i4 || ((Integer) vector3.get(i4)).intValue() < i2) {
                                            i = vector3.size();
                                        } else {
                                            i = i4;
                                        }
                                        vector3.add(Integer.valueOf(i2));
                                        vector.add(string2);
                                        vector2.add(string3);
                                        vector4.add(Long.valueOf(j));
                                        x.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", Integer.valueOf(i2), Integer.valueOf(length), vector3.get(i), Integer.valueOf(i), Integer.valueOf(vector3.size()));
                                        i4 = i;
                                    }
                                }
                                a.close();
                                if (i4 < 0 || vector3.size() <= 0) {
                                    com.tencent.mm.plugin.report.service.g.pQN.h(12696, Integer.valueOf(201), Integer.valueOf(i3));
                                    x.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", Integer.valueOf(i4), Integer.valueOf(vector3.size()));
                                    nu = "";
                                } else {
                                    int intValue = ((Integer) vector3.get(i4)).intValue();
                                    length = (intValue * 100) / 256;
                                    if (length < 77) {
                                        com.tencent.mm.plugin.report.service.g.pQN.h(12696, Integer.valueOf(202), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()));
                                        x.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", Long.valueOf(bh.bz(Wp)), Integer.valueOf(intValue), Integer.valueOf(length), Integer.valueOf(nw.length - 1), nt);
                                        nu = "";
                                    } else {
                                        str2 = bh.ou((String) vector.get(i4));
                                        i2 = 0;
                                        int i5 = 0;
                                        while (i5 < vector3.size()) {
                                            if (i5 == i4 || ((Integer) vector3.get(i5)).intValue() < intValue || str2.hashCode() == ((String) vector.get(i5)).hashCode()) {
                                                i = i2;
                                            } else {
                                                i = i2 + 1;
                                            }
                                            i5++;
                                            i2 = i;
                                        }
                                        if (i2 > 0) {
                                            TU.hhp.fx("VideoHash", "delete from VideoHash where size = " + i3);
                                            com.tencent.mm.plugin.report.service.g.pQN.h(12696, Integer.valueOf(203), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(i2));
                                            x.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", Integer.valueOf(i2), nt);
                                            nu = "";
                                        } else {
                                            Wp = bh.bz(Wp);
                                            long a2 = bh.a((Long) vector4.get(i4), 0);
                                            com.tencent.mm.plugin.report.service.g.pQN.h(12696, (Object[]) new Object[]{Integer.valueOf(300), String.format("%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(intValue), Long.valueOf(a2), Integer.valueOf(vector4.size()), Long.valueOf(Wp)})});
                                            com.tencent.mm.plugin.report.service.g.pQN.h(12696, (Object[]) new Object[]{Integer.valueOf(length + 3000), r5});
                                            x.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", Long.valueOf(Wp), Integer.valueOf(intValue), Integer.valueOf(length), Long.valueOf(a2), nt, str2, vector2.get(i4));
                                            nu = (String) vector2.get(i4);
                                            z4 = bh.Wp() % 1000 < ((long) (r14 * 10)) || length < 90;
                                            x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", Boolean.valueOf(z4), Long.valueOf(Wp), Integer.valueOf(r14), Integer.valueOf(length), Boolean.valueOf(com.tencent.mm.sdk.a.b.ceK()));
                                            if (z4 || com.tencent.mm.sdk.a.b.ceK()) {
                                                com.tencent.mm.sdk.f.e.b(new 2(TU, nt, nu, r5), "checkVideoHashByteDiff", 1);
                                            }
                                            nu = str2;
                                        }
                                    }
                                }
                            }
                        }
                        if (!bh.ov(nu)) {
                            split = nu.split("##");
                            if (z && split != null && split.length == 2) {
                                iVar.field_fileId = split[0];
                                iVar.field_aesKey = split[1];
                                this.hUq = true;
                            }
                            x.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", TL(), Boolean.valueOf(com.tencent.mm.sdk.a.b.ceK()), r12, Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(z3), Boolean.valueOf(this.hUq), iVar.field_fileId, iVar.field_aesKey);
                        }
                    }
                    split = null;
                    iVar.field_fileId = split[0];
                    iVar.field_aesKey = split[1];
                    this.hUq = true;
                    x.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", TL(), Boolean.valueOf(com.tencent.mm.sdk.a.b.ceK()), r12, Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(z3), Boolean.valueOf(this.hUq), iVar.field_fileId, iVar.field_aesKey);
                } catch (Throwable e) {
                    x.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", bh.i(e));
                }
            }
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            objArr = new Object[2];
            i = this.hUq ? 1 : this.hUr ? 2 : 0;
            objArr[0] = Integer.valueOf(i + 700);
            objArr[1] = Integer.valueOf(this.hTR.hlp);
            gVar.h(12696, objArr);
            if (bh.ov(iVar.field_aesKey) || bh.ov(iVar.field_aesKey)) {
                nu = "";
                iVar.field_aesKey = nu;
                iVar.field_fileId = nu;
            }
            x.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %b", TL(), iVar.field_mediaId, iVar.field_fileId, iVar.field_aesKey, Boolean.valueOf(this.hBF), Boolean.valueOf(iVar.field_largesvideo));
            if (com.tencent.mm.modelcdntran.g.MJ().c(iVar)) {
                if (this.hTR.hVM != 1) {
                    this.hTR.hVM = 1;
                    this.hTR.status = 104;
                    this.hTR.clientId = this.hBn;
                    this.hTR.fDt = 524544;
                    t.e(this.hTR);
                }
                return true;
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 226, 1, false);
            x.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", TL());
            this.hBn = "";
            return false;
        }
        r4 = new Object[3];
        com.tencent.mm.modelcdntran.g.MJ();
        r4[1] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hu(2));
        r4[2] = Integer.valueOf(this.hTR.hVM);
        x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", r4);
        return false;
    }

    public g(String str) {
        Assert.assertTrue(str != null);
        x.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:" + str);
        this.fileName = str;
        this.hTR = t.nF(str);
        if (this.hTR != null) {
            this.MAX_TIMES = 2500;
        } else {
            this.MAX_TIMES = 0;
        }
        this.hEZ = new com.tencent.mm.compatible.util.g.a();
        if (this.hTR != null && 3 == this.hTR.hVO) {
            this.hTT = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
        }
        x.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", TL(), Integer.valueOf(this.hTT));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        this.hTR = t.nF(this.fileName);
        if (this.hTR == null || !(this.hTR.status == 104 || this.hTR.status == 103)) {
            x.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", TL(), this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
        StringBuilder append = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.hTR.status).append(" [").append(this.hTR.hVC).append(",").append(this.hTR.hVD).append("] [").append(this.hTR.hUp).append(",").append(this.hTR.hlp).append("]  netTimes:").append(this.hTR.hVJ).append(" times:");
        int i = this.hUu;
        this.hUu = i + 1;
        x.d("MicroMsg.NetSceneUploadVideo", append.append(i).toString());
        if (this.startTime == 0) {
            this.startTime = bh.Wp();
            this.hUp = this.hTR.hUp;
        }
        o.TU();
        if (q.nn(s.nt(this.fileName))) {
            x.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", TL(), this.hTR.Ug());
            com.tencent.mm.plugin.report.service.g.pQN.a(354, 139, 1, false);
        }
        if (TK()) {
            x.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fileName);
            return 0;
        }
        String bV;
        if (this.hTR.hVL == 1) {
            this.hUo = true;
        } else if (this.hTR.hVE + 600 < bh.Wo()) {
            x.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
            t.ny(this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (!t.nx(this.fileName)) {
            x.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
            t.ny(this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
        b.a aVar = new b.a();
        aVar.hmj = new brb();
        aVar.hmk = new brc();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.hmi = f.CTRL_INDEX;
        aVar.hml = 39;
        aVar.hmm = 1000000039;
        this.gJQ = aVar.JZ();
        brb com_tencent_mm_protocal_c_brb = (brb) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_brb.nkp = (String) com.tencent.mm.kernel.g.Dj().CU().get(2, (Object) "");
        com_tencent_mm_protocal_c_brb.nko = this.hTR.Ud();
        com_tencent_mm_protocal_c_brb.vHU = this.fileName;
        if (this.hUo) {
            com_tencent_mm_protocal_c_brb.wSx = 2;
        }
        if (this.hTR.hVO == 3) {
            com_tencent_mm_protocal_c_brb.wSx = 3;
        }
        com_tencent_mm_protocal_c_brb.wSw = this.hTR.hVH;
        com_tencent_mm_protocal_c_brb.wxp = this.hTR.hVD;
        com_tencent_mm_protocal_c_brb.wSt = this.hTR.hlp;
        com_tencent_mm_protocal_c_brb.vZu = ab.bC(ac.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_brb.wxs = 2;
        com_tencent_mm_protocal_c_brb.wSu = 0;
        com_tencent_mm_protocal_c_brb.wSv = new bdn().bj(new byte[0]);
        com_tencent_mm_protocal_c_brb.wxr = new bdn().bj(new byte[0]);
        if (bh.ov(this.fHk)) {
            o.TU();
            bV = com.tencent.mm.a.g.bV(s.nt(this.fileName));
            this.fHk = bV;
        } else {
            bV = this.fHk;
        }
        com_tencent_mm_protocal_c_brb.wSA = bV;
        com_tencent_mm_protocal_c_brb.vHc = bc.HD();
        com_tencent_mm_protocal_c_brb.wSJ = this.hTR.fGG;
        bmf com_tencent_mm_protocal_c_bmf = this.hTR.hVQ;
        if (com_tencent_mm_protocal_c_bmf != null && !bh.ov(com_tencent_mm_protocal_c_bmf.hdo)) {
            com_tencent_mm_protocal_c_brb.wSB = bh.az(com_tencent_mm_protocal_c_bmf.hdo, "");
            com_tencent_mm_protocal_c_brb.wSC = com_tencent_mm_protocal_c_bmf.weC;
            com_tencent_mm_protocal_c_brb.wSD = bh.az(com_tencent_mm_protocal_c_bmf.hdq, "");
            com_tencent_mm_protocal_c_brb.wSF = bh.az(com_tencent_mm_protocal_c_bmf.hds, "");
            com_tencent_mm_protocal_c_brb.wSE = bh.az(com_tencent_mm_protocal_c_bmf.hdr, "");
            com_tencent_mm_protocal_c_brb.wSG = bh.az(com_tencent_mm_protocal_c_bmf.hdt, "");
        } else if (!(com_tencent_mm_protocal_c_bmf == null || bh.ov(com_tencent_mm_protocal_c_bmf.hds) || bh.ov(com_tencent_mm_protocal_c_bmf.hdr))) {
            com_tencent_mm_protocal_c_brb.wSF = com_tencent_mm_protocal_c_bmf.hds;
            com_tencent_mm_protocal_c_brb.wSE = com_tencent_mm_protocal_c_bmf.hdr;
        }
        if (com_tencent_mm_protocal_c_bmf != null) {
            com_tencent_mm_protocal_c_brb.wSI = bh.az(com_tencent_mm_protocal_c_bmf.hdu, "");
            com_tencent_mm_protocal_c_brb.wSH = bh.az(com_tencent_mm_protocal_c_bmf.hdv, "");
        }
        x.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", Integer.valueOf(com_tencent_mm_protocal_c_brb.wSw), Integer.valueOf(com_tencent_mm_protocal_c_brb.wxq), Integer.valueOf(com_tencent_mm_protocal_c_brb.wSt), Integer.valueOf(com_tencent_mm_protocal_c_brb.wSx), com_tencent_mm_protocal_c_brb.wSA, com_tencent_mm_protocal_c_brb.wSB, Integer.valueOf(com_tencent_mm_protocal_c_brb.wSC), com_tencent_mm_protocal_c_brb.wSD, com_tencent_mm_protocal_c_brb.wSG);
        s.b i2;
        Object obj;
        if (this.hTR.status == 103) {
            o.TU();
            i2 = s.i(s.nu(this.fileName), this.hTR.hVC, hUm);
            if (i2.ret < 0 || i2.flp == 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 225, 1, false);
                t.ny(this.fileName);
                x.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            x.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + i2.ret + " readlen:" + i2.flp + " newOff:" + i2.hWh + " netOff:" + this.hTR.hVC);
            if (i2.hWh < this.hTR.hVC) {
                x.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + i2.hWh + " OldtOff:" + this.hTR.hVC);
                t.ny(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            obj = new byte[i2.flp];
            System.arraycopy(i2.buf, 0, obj, 0, i2.flp);
            com_tencent_mm_protocal_c_brb.wxq = this.hTR.hVC;
            com_tencent_mm_protocal_c_brb.wxr = new bdn().bj(obj);
        } else {
            o.TU();
            i2 = s.i(s.nt(this.fileName), this.hTR.hUp, hUm);
            if (i2.ret < 0 || i2.flp == 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 224, 1, false);
                t.ny(this.fileName);
                x.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            x.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + i2.ret + " readlen:" + i2.flp + " newOff:" + i2.hWh + " netOff:" + this.hTR.hUp);
            if (i2.hWh < this.hTR.hUp) {
                x.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + i2.hWh + " OldtOff:" + this.hTR.hUp);
                t.ny(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            } else if (i2.hWh >= c.hTn) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 222, 1, false);
                x.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + c.hTn);
                t.ny(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            } else {
                obj = new byte[i2.flp];
                System.arraycopy(i2.buf, 0, obj, 0, i2.flp);
                com_tencent_mm_protocal_c_brb.wSu = this.hTR.hUp;
                com_tencent_mm_protocal_c_brb.wxq = this.hTR.hVC;
                com_tencent_mm_protocal_c_brb.wSv = new bdn().bj(obj);
            }
        }
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        brb com_tencent_mm_protocal_c_brb = (brb) ((b) qVar).hmg.hmo;
        if (!bh.ov(com_tencent_mm_protocal_c_brb.vHU) && com_tencent_mm_protocal_c_brb.wxs > 0 && !bh.ov(com_tencent_mm_protocal_c_brb.nkp) && !bh.ov(com_tencent_mm_protocal_c_brb.nko) && com_tencent_mm_protocal_c_brb.vZu > 0 && com_tencent_mm_protocal_c_brb.wxq <= com_tencent_mm_protocal_c_brb.wxp && com_tencent_mm_protocal_c_brb.wxq >= 0 && com_tencent_mm_protocal_c_brb.wSu <= com_tencent_mm_protocal_c_brb.wSt && com_tencent_mm_protocal_c_brb.wSu >= 0 && ((com_tencent_mm_protocal_c_brb.wSu != com_tencent_mm_protocal_c_brb.wSt || com_tencent_mm_protocal_c_brb.wxq != com_tencent_mm_protocal_c_brb.wxp) && com_tencent_mm_protocal_c_brb.wxp > 0 && com_tencent_mm_protocal_c_brb.wSt > 0 && (com_tencent_mm_protocal_c_brb.wSv.wJB > 0 || com_tencent_mm_protocal_c_brb.wxr.wJB > 0))) {
            return b.hmP;
        }
        x.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + com_tencent_mm_protocal_c_brb.nko);
        return b.hmQ;
    }

    protected final int Bh() {
        return this.MAX_TIMES;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.pQN.a(111, 221, 1, false);
        t.ny(this.fileName);
    }

    public final boolean Ke() {
        boolean Ke = super.Ke();
        if (Ke) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 210, 1, false);
        }
        return Ke;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.hBn);
        if (this.hTU) {
            x.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.hTR.Ud());
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 3 && i3 == -1 && !bh.ov(this.hBn)) {
            x.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hBn);
        } else {
            brc com_tencent_mm_protocal_c_brc = (brc) ((b) qVar).hmh.hmo;
            brb com_tencent_mm_protocal_c_brb = (brb) ((b) qVar).hmg.hmo;
            this.hTR = t.nF(this.fileName);
            if (this.hTR == null) {
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.gJT.a(i2, i3, str, this);
            } else if (this.hTR.status == 105) {
                x.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                this.gJT.a(i2, i3, str, this);
            } else if (this.hTR.status != 104 && this.hTR.status != 103) {
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hTR.status + " [" + this.fileName + "," + this.hTR.fFo + "," + this.hTR.Ue() + "," + this.hTR.Ud() + "] ");
                this.gJT.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 == -22) {
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.hTR.Ud());
                t.nz(this.fileName);
                this.gJT.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 != 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 220, 1, false);
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.hTR.Ud());
                t.ny(this.fileName);
                com.tencent.mm.plugin.report.service.g.pQN.h(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hTT), Integer.valueOf(0));
                this.gJT.a(i2, i3, str, this);
            } else if (i2 != 0 || i3 != 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 219, 1, false);
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.hTR.Ud());
                this.gJT.a(i2, i3, str, this);
            } else if (!bh.bw(com_tencent_mm_protocal_c_brb.wxr.wJD.oz) && com_tencent_mm_protocal_c_brb.wxq != com_tencent_mm_protocal_c_brc.wxq - com_tencent_mm_protocal_c_brb.wxr.wJB) {
                x.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + com_tencent_mm_protocal_c_brb.wxq + "," + com_tencent_mm_protocal_c_brb.wxr.wJB + "," + com_tencent_mm_protocal_c_brc.wxq + "] file:" + this.fileName + " user:" + com_tencent_mm_protocal_c_brb.nko);
                t.ny(this.fileName);
                this.gJT.a(i2, i3, str, this);
            } else if (bh.bw(com_tencent_mm_protocal_c_brb.wSv.wJD.oz) || com_tencent_mm_protocal_c_brb.wSu == com_tencent_mm_protocal_c_brc.wSu - com_tencent_mm_protocal_c_brb.wSv.wJB) {
                this.hTR.hVF = bh.Wo();
                this.hTR.fFo = com_tencent_mm_protocal_c_brc.vHe;
                this.hTR.fDt = 1028;
                x.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(this.hTR.fFo), Integer.valueOf(r.idu));
                if (!(CdnLogic.kMediaTypeFavoriteBigFile != r.idt || r.idu == 0 || this.hTR.fFo == 0)) {
                    this.hTR.fFo = (long) r.idu;
                    r.idu = 0;
                }
                Object obj = null;
                int i4 = this.hTR.status;
                if (i4 == 103) {
                    this.hTR.hVC = com_tencent_mm_protocal_c_brb.wxr.wJB + com_tencent_mm_protocal_c_brb.wxq;
                    this.hTR.fDt |= 64;
                    if (this.hTR.hVC >= this.hTR.hVD) {
                        this.hTR.status = 104;
                        this.hTR.fDt |= 256;
                    }
                } else if (i4 == 104) {
                    this.hTR.hUp = com_tencent_mm_protocal_c_brb.wSv.wJB + com_tencent_mm_protocal_c_brb.wSu;
                    this.hTR.fDt |= 8;
                    if (this.hTR.hUp >= this.hTR.hlp) {
                        this.hTR.status = 199;
                        this.hTR.fDt |= 256;
                        t.c(this.hTR);
                        obj = 1;
                    }
                } else {
                    x.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + i4 + " file:" + this.fileName + " user:" + com_tencent_mm_protocal_c_brb.nko);
                    t.ny(this.fileName);
                    this.gJT.a(i2, i3, str, this);
                    return;
                }
                t.e(this.hTR);
                if (this.hTU) {
                    this.gJT.a(i2, i3, str, this);
                } else if (obj == null) {
                    this.hkO.J(10, 10);
                } else {
                    boolean z;
                    com.tencent.mm.modelstat.b.hPA.f(((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH((long) this.hTR.hVI));
                    com.tencent.mm.plugin.report.service.g.pQN.h(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hTT), Integer.valueOf(this.hTR.hlp - this.hUp));
                    if (this.hTR == null) {
                        z = false;
                    } else {
                        com.tencent.mm.l.a WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(this.hTR.Ud());
                        z = (WO == null || ((int) WO.gJd) <= 0) ? false : WO.cia();
                    }
                    if (z || s.gR(this.hTR.Ud())) {
                        x.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", this.hTR.Ud());
                        if (this.hTR.fFo < 0) {
                            x.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hTR.fFo + " file:" + this.fileName + " toUser:" + this.hTR.Ud());
                            t.ny(this.fileName);
                        }
                    } else {
                        x.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
                        if (this.hTR.fFo <= 0) {
                            x.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hTR.fFo + " file:" + this.fileName + " toUser:" + this.hTR.Ud());
                            t.ny(this.fileName);
                        }
                    }
                    long zi = this.hEZ != null ? this.hEZ.zi() : 0;
                    x.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.hTR.Ud() + " msgsvrid:" + this.hTR.fFo + " thumbsize:" + this.hTR.hVD + " videosize:" + this.hTR.hlp + " useTime:" + zi);
                    x.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + hUm + " filesize:" + this.hTR.hlp + " useTime:" + zi);
                    a.a(this.hTR, 0);
                    this.gJT.a(i2, i3, str, this);
                }
            } else {
                x.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + com_tencent_mm_protocal_c_brb.wSu + "," + com_tencent_mm_protocal_c_brb.wSv.wJB + "," + com_tencent_mm_protocal_c_brc.wSu + "] file:" + this.fileName + " user:" + com_tencent_mm_protocal_c_brb.nko);
                t.ny(this.fileName);
                this.gJT.a(i2, i3, str, this);
            }
        }
    }

    public final int getType() {
        return f.CTRL_INDEX;
    }

    private String nj(String str) {
        boolean z;
        InputStream fileInputStream;
        Throwable e;
        File file = new File(str);
        File file2 = new File(file.getParentFile(), "send" + file.getName());
        InputStream inputStream = null;
        OutputStream outputStream = null;
        boolean z2 = false;
        x.d("MicroMsg.NetSceneUploadVideo", "getSendThumbnailPath:origin file: %d", Long.valueOf(file.length()));
        OutputStream fileOutputStream;
        try {
            if (file.length() <= 32768) {
                z = z2;
            } else if (file2.exists()) {
                x.d("MicroMsg.NetSceneUploadVideo", "dst file %s exist!", file2.getAbsolutePath());
                z = true;
            } else {
                Options UL = com.tencent.mm.sdk.platformtools.d.UL(file.getAbsolutePath());
                String str2 = "MicroMsg.NetSceneUploadVideo";
                String str3 = "getSendThumbnailPath:options %s";
                Object[] objArr = new Object[1];
                objArr[0] = UL == null ? "null" : UL.outWidth + "-" + UL.outHeight;
                x.i(str2, str3, objArr);
                if (UL == null || (UL.outWidth <= 288 && UL.outHeight <= 288)) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(fileInputStream, 0.0f, 288, 288);
                        if (a != null) {
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                z = a.compress(CompressFormat.JPEG, 60, fileOutputStream);
                                outputStream = fileOutputStream;
                                inputStream = fileInputStream;
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    x.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bh.i(e));
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            z = z2;
                                        } catch (IOException e4) {
                                            z = z2;
                                        }
                                    } else {
                                        z = z2;
                                    }
                                    if (z) {
                                        x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", TL(), Long.valueOf(file2.length()), file2.getAbsolutePath());
                                        return file2.getAbsolutePath();
                                    }
                                    x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", TL(), Long.valueOf(file.length()), file.getAbsolutePath());
                                    return str;
                                } catch (Throwable th) {
                                    e = th;
                                    outputStream = fileOutputStream;
                                    inputStream = fileInputStream;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (IOException e6) {
                                        }
                                    }
                                    throw e;
                                }
                            }
                        }
                        z = z2;
                        inputStream = fileInputStream;
                    } catch (Exception e7) {
                        e = e7;
                        fileOutputStream = null;
                        x.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bh.i(e));
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            z = z2;
                        } else {
                            fileOutputStream.close();
                            z = z2;
                        }
                        if (z) {
                            x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", TL(), Long.valueOf(file2.length()), file2.getAbsolutePath());
                            return file2.getAbsolutePath();
                        }
                        x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", TL(), Long.valueOf(file.length()), file.getAbsolutePath());
                        return str;
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = fileInputStream;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw e;
                    }
                }
                z = com.tencent.mm.sdk.platformtools.d.a(file.getAbsolutePath(), 288, 288, CompressFormat.JPEG, 60, file2.getParentFile().getAbsolutePath() + "/", file2.getName());
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e9) {
                }
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            fileInputStream = null;
            x.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bh.i(e));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
                z = z2;
            } else {
                z = z2;
            }
            if (z) {
                x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", TL(), Long.valueOf(file.length()), file.getAbsolutePath());
                return str;
            }
            x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", TL(), Long.valueOf(file2.length()), file2.getAbsolutePath());
            return file2.getAbsolutePath();
        } catch (Throwable th3) {
            e = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw e;
        }
        if (z) {
            x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", TL(), Long.valueOf(file2.length()), file2.getAbsolutePath());
            return file2.getAbsolutePath();
        }
        x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", TL(), Long.valueOf(file.length()), file.getAbsolutePath());
        return str;
    }

    private String TL() {
        return this.fileName + "_" + hashCode();
    }
}
