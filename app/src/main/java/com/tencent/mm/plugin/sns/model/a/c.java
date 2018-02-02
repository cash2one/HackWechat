package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.o;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.network.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class c extends l<String, Integer, Integer> {
    private static HashSet<String> qYX = new HashSet();
    private long dnsCostTime = -1;
    protected aqr fHC = null;
    private int hZy = -1;
    private String host = "";
    protected a qYD;
    protected n qYE = null;
    protected a qYF = null;
    int qYZ = 0;

    public interface a {
        void a(int i, aqr com_tencent_mm_protocal_c_aqr, int i2, boolean z, String str, int i3);
    }

    public abstract boolean bwh();

    protected abstract int bwi();

    public /* synthetic */ Object buP() {
        return bwj();
    }

    public static boolean KM(String str) {
        if (qYX.contains(i.aE(1, str)) || qYX.contains(i.aE(5, str))) {
            return true;
        }
        return false;
    }

    public c(a aVar, a aVar2) {
        this.qYD = aVar;
        this.qYF = aVar2;
        if (aVar2 != null) {
            this.fHC = aVar2.qTV;
            qYX.add(aVar2.qTU);
            aVar2.init();
        }
    }

    public boolean bwg() {
        return true;
    }

    public String KK(String str) {
        return str;
    }

    protected final void b(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        String str;
        int i;
        int bwi = bwi();
        String str2 = "";
        switch (bwi) {
            case 1:
                str = "100105";
                break;
            case 2:
                str = "100106";
                break;
            case 3:
                str = "100100";
                break;
            default:
                return;
        }
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn(str);
        if (fn.isValid()) {
            i = bh.getInt((String) fn.chI().get("needUploadData"), 1);
            str2 = fn.field_expId;
        } else {
            i = 0;
        }
        if (i != 0) {
            int i2;
            if (this.qYF.qYB == 8) {
                i = 1;
            } else if (this.qYF.qYB == 6 || this.qYF.qYB == 4) {
                i = 2;
            } else if (this.qYF.qYB == 5) {
                i = 4;
            } else if (this.qYF.qYB == 2 || this.qYF.qYB == 1 || this.qYF.qYB == 3) {
                i = 0;
            } else {
                i = 5;
            }
            d dVar = new d();
            dVar.q("20ImgSize", com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + ",");
            String str3 = "21NetType";
            StringBuilder stringBuilder = new StringBuilder();
            if (an.isWifi(ac.getContext())) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            dVar.q(str3, stringBuilder.append(i2).append(",").toString());
            dVar.q("22DelayTime", com_tencent_mm_modelcdntran_keep_SceneResult.field_delayTime + ",");
            dVar.q("23RetCode", com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode + ",");
            dVar.q("24DnsCostTime", com_tencent_mm_modelcdntran_keep_SceneResult.field_dnsCostTime + ",");
            dVar.q("25ConnectCostTime", com_tencent_mm_modelcdntran_keep_SceneResult.field_connectCostTime + ",");
            dVar.q("26SendCostTime", ",");
            dVar.q("27WaitResponseCostTime", com_tencent_mm_modelcdntran_keep_SceneResult.field_waitResponseCostTime + ",");
            dVar.q("28ReceiveCostTime", com_tencent_mm_modelcdntran_keep_SceneResult.field_receiveCostTime + ",");
            dVar.q("29ClientAddrIP(uint)", com_tencent_mm_modelcdntran_keep_SceneResult.field_clientHostIP + ",");
            dVar.q("30ServerAddrIP(uint)", com_tencent_mm_modelcdntran_keep_SceneResult.field_serverHostIP + ",");
            dVar.q("31dnstype", this.hZy + ",");
            dVar.q("32signal(int)", an.getStrength(ac.getContext()) + ",");
            dVar.q("33host(string)", this.host + ",");
            dVar.q("34MediaType", bwi + ",");
            dVar.q("35X_Errno(string)", com_tencent_mm_modelcdntran_keep_SceneResult.field_xErrorNo + ",");
            dVar.q("36MaxPackageSize", ",");
            dVar.q("37MaxPackageTimeStamp", ",");
            dVar.q("38PackageRecordList", ",");
            dVar.q("39ExpLayerId", str + ",");
            dVar.q("40ExpId", str2 + ",");
            dVar.q("41FeedId", ",");
            dVar.q("42BizType", i + ",");
            dVar.q("43CSeqCheck(uint)", com_tencent_mm_modelcdntran_keep_SceneResult.field_cSeqCheck + ",");
            dVar.q("44isPrivate(uint)", (com_tencent_mm_modelcdntran_keep_SceneResult.field_usePrivateProtocol ? 1 : 0) + ",");
            x.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + dVar.Sz());
            g.pQN.h(13480, dVar);
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 200 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                g.pQN.h(14071, dVar);
            }
        }
    }

    public boolean a(com.tencent.mm.storage.an anVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (anVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || anVar.time == 0 || bh.by((long) anVar.time) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", e.getMessage());
            return false;
        }
    }

    public Integer bwj() {
        com.tencent.mm.kernel.g.Dk();
        if (!com.tencent.mm.kernel.g.Dj().isSDCardAvailable() || this.qYF == null) {
            return Integer.valueOf(2);
        }
        int i;
        if (bwg()) {
            x.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", this.qYF.qTQ + this.qYF.bwf());
            FileOp.deleteFile(r0);
        }
        System.currentTimeMillis();
        x.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.qYF.mediaId + " " + this.qYF.qYz + " type " + this.qYF.qYB);
        FileOp.mh(this.qYF.getPath());
        com.tencent.mm.storage.an anVar = this.qYF.qYC;
        String str = "";
        if (anVar == null) {
            str = "";
        } else if (anVar.equals(com.tencent.mm.storage.an.xyR)) {
            str = "album_friend";
        } else if (anVar.equals(com.tencent.mm.storage.an.xyS)) {
            str = "album_self";
        } else if (anVar.equals(com.tencent.mm.storage.an.xyT)) {
            str = "album_stranger";
        } else if (anVar.equals(com.tencent.mm.storage.an.xyU)) {
            str = "profile_friend";
        } else if (anVar.equals(com.tencent.mm.storage.an.xyV)) {
            str = "profile_stranger";
        } else if (anVar.equals(com.tencent.mm.storage.an.xyW)) {
            str = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
        } else if (anVar.equals(com.tencent.mm.storage.an.xyQ)) {
            str = "timeline";
        }
        if (!bh.ov(str)) {
            str = "&scene=" + str;
        }
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.vAz), o.getString(ae.bvc()), Integer.valueOf(an.getNetTypeForStat(ac.getContext())), Integer.valueOf(an.getStrength(ac.getContext())), str});
        this.qYF.url = KK(this.qYF.url);
        this.dnsCostTime = bh.Wp();
        long j = (long) com.tencent.mm.k.g.zY().getInt(this.qYF.qYA ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime", 0);
        x.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", Boolean.valueOf(this.qYF.qYA), Boolean.valueOf(this.qYF.qYz), com.tencent.mm.k.g.zY().getValue(this.qYF.qYA ? "SnsSightDomainList" : "SnsAlbumDomainList"), Long.valueOf(j));
        if (j <= 0) {
            j = 259200;
        }
        boolean a = a(anVar, this.qYF.url, j, r6);
        this.dnsCostTime = bh.bz(this.dnsCostTime);
        com.tencent.mm.modelcdntran.i hVar = new h();
        if (a(hVar, a, format)) {
            hVar.htt = new com.tencent.mm.modelcdntran.i.a(this) {
                final /* synthetic */ c qZa;

                {
                    this.qZa = r1;
                }

                public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                    int i2 = 2;
                    int i3 = 1;
                    String str2 = "MicroMsg.SnsCdnDownloadBase";
                    String str3 = "download done mediaID:%s,  sceneResult is null:%b";
                    Object[] objArr = new Object[2];
                    objArr[0] = str;
                    objArr[1] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null);
                    x.i(str2, str3, objArr);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                            b.reportFailIp(com_tencent_mm_modelcdntran_keep_SceneResult.field_serverIP);
                        } else {
                            this.qZa.qYZ = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
                            if (!this.qZa.bwh()) {
                                i3 = 2;
                            } else if (this.qZa.qYF.qYz) {
                                i3 = 3;
                            }
                            i2 = i3;
                        }
                        this.qZa.b(com_tencent_mm_modelcdntran_keep_SceneResult);
                        ae.aNT().post(new 1(this, str, i2, com_tencent_mm_modelcdntran_keep_SceneResult));
                    }
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] h(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (com.tencent.mm.modelcdntran.g.MJ().b(hVar, -1)) {
                x.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
                i = 1;
                return Integer.valueOf(i);
            }
            x.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
        }
        i = 2;
        return Integer.valueOf(i);
    }

    private boolean a(h hVar, boolean z, String str) {
        try {
            this.host = new URL(this.qYF.url).getHost();
            List arrayList = new ArrayList();
            this.hZy = b.a(this.host, false, arrayList);
            List arrayList2 = new ArrayList();
            int a = b.a(this.host, true, arrayList2);
            Random random = new Random();
            random.setSeed(bh.Wp());
            Collections.shuffle(arrayList, random);
            Collections.shuffle(arrayList2, random);
            while (arrayList.size() > 2) {
                arrayList.remove(0);
            }
            while (arrayList2.size() > 2) {
                arrayList2.remove(0);
            }
            hVar.field_mediaId = this.qYF.mediaId + "_" + this.qYF.qYB;
            hVar.url = this.qYF.url;
            hVar.host = this.host;
            hVar.referer = str;
            hVar.htn = this.qYF.getPath() + this.qYF.bwf();
            hVar.hto = bO(arrayList);
            hVar.htp = bO(arrayList2);
            hVar.htq = this.hZy;
            hVar.htr = a;
            hVar.isColdSnsData = z;
            hVar.signalQuality = an.getStrength(ac.getContext());
            hVar.snsScene = this.qYF.qYC.tag;
            if (this.qYF.qTV != null) {
                hVar.snsCipherKey = this.qYF.qYz ? this.qYF.qTV.wxY : this.qYF.qTV.wxV;
            }
            if (this.qYF.qYB == 8) {
                hVar.fWx = 3;
                hVar.hts = 109;
                hVar.fileType = 20204;
            } else if (this.qYF.qYB == 6 || this.qYF.qYB == 4) {
                hVar.fWx = 3;
                hVar.hts = 105;
                hVar.fileType = CdnLogic.kMediaTypeAdVideo;
            } else if (this.qYF.qYB == 5) {
                hVar.fWx = 3;
                hVar.hts = 150;
                hVar.fileType = 20250;
            } else if (this.qYF.qYB == 2 || this.qYF.qYB == 1 || this.qYF.qYB == 3) {
                hVar.fWx = 3;
                hVar.hts = 100;
                hVar.fileType = 20201;
            }
            x.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d:%s", Integer.valueOf(this.qYF.qYB), hVar);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            x.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:" + e);
            return false;
        }
    }

    private static String[] bO(List<String> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = (String) list.get(i);
        }
        return strArr;
    }

    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
    }

    public void bwk() {
        if (!ae.bve()) {
            System.currentTimeMillis();
            if (this.qYF.qQL.qQR == 4) {
                x.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
                this.qYE = com.tencent.mm.plugin.sns.lucky.a.a.dX(this.qYF.getPath() + i.e(this.fHC), this.qYF.getPath() + i.g(this.fHC));
                ae.bvs().a(this.qYF.mediaId, this.qYE, this.qYF.qQL.qQR);
            } else if (this.qYF.qQL.qQR == 5) {
                x.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
                this.qYE = com.tencent.mm.plugin.sns.lucky.a.a.dX(this.qYF.getPath() + i.e(this.fHC), this.qYF.getPath() + i.h(this.fHC));
                ae.bvs().a(this.qYF.mediaId, this.qYE, this.qYF.qQL.qQR);
            } else if (this.qYF.qQL.list.size() <= 1) {
                ae.bvs().a(this.qYF.mediaId, this.qYE, this.qYF.qQL.qQR);
            } else {
                ae.bvs().a(this.qYF.mediaId, this.qYE, 0);
                List linkedList = new LinkedList();
                int i = 0;
                while (i < this.qYF.qQL.list.size() && i < 4) {
                    aqr com_tencent_mm_protocal_c_aqr = (aqr) this.qYF.qQL.list.get(i);
                    n Kb = ae.bvs().Kb(com_tencent_mm_protocal_c_aqr.nGJ);
                    if (i.b(Kb)) {
                        linkedList.add(Kb);
                        x.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + Kb + " " + com_tencent_mm_protocal_c_aqr.nGJ);
                        i++;
                    } else {
                        return;
                    }
                }
                this.qYE = n.i(i.h(linkedList, ae.bvD()));
                x.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.qYF.qQL.hKZ + " " + this.qYE);
                ae.bvs().a(this.qYF.qQL.hKZ, this.qYE, this.qYF.qQL.qQR);
            }
            String str = null;
            if (this.qYF.qQL.qQR == 0) {
                str = "0-" + this.qYF.qQL.hKZ;
            } else if (this.qYF.qQL.qQR == 1) {
                str = "1-" + this.qYF.qQL.hKZ;
            } else if (this.qYF.qQL.qQR == 4) {
                str = "4-" + this.qYF.qQL.hKZ;
            } else if (this.qYF.qQL.qQR == 5) {
                str = "5-" + this.qYF.qQL.hKZ;
            }
            ae.bvs().Ka(str);
        }
    }

    public af buO() {
        return ae.bvg();
    }
}
