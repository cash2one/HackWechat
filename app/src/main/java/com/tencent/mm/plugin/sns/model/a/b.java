package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.a.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.c;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class b extends c {
    private static HashSet<String> qYX = new HashSet();
    private long dnsCostTime = -1;
    protected aqr fHC = null;
    private int hZy = -1;
    private String host = "";
    protected a qYD;
    protected n qYE = null;
    protected a qYF = null;
    private String qYG = "";
    private String qYH = "";
    private String qYI = "";
    private int qYJ = 0;
    protected int qYK = 0;
    private long qYL = -1;
    protected long qYM = -1;
    protected long qYN = -1;
    protected long qYO = -1;
    protected String qYP = "";
    protected PString qYQ = new PString();
    protected int qYR;
    protected long qYS;
    protected long qYT;
    protected long qYU;
    private int qYV = 0;
    protected int qYW = 0;
    private Map<String, List<String>> qYY;
    int qYZ = 0;
    private int retCode = -1;

    public abstract boolean bwh();

    protected abstract int bwi();

    public abstract boolean p(InputStream inputStream);

    public final /* synthetic */ Object buP() {
        return bwj();
    }

    public b(a aVar, a aVar2) {
        super(aVar, aVar2);
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

    public u b(u uVar) {
        return uVar;
    }

    protected static boolean a(int i, long j, PString pString) {
        if (System.currentTimeMillis() - j < 1000) {
            return false;
        }
        pString.value += String.format("ts=%d&size=%d|", new Object[]{Long.valueOf(r2 / 1000), Integer.valueOf(i)});
        return true;
    }

    public final boolean a(an anVar, String str, long j, String str2) {
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

    public final Integer bwj() {
        g.Dk();
        if (!g.Dj().isSDCardAvailable() || this.qYF == null) {
            ik(false);
            return Integer.valueOf(2);
        }
        if (bwg()) {
            x.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", this.qYF.qTQ + this.qYF.bwf());
            FileOp.deleteFile(r0);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.qYO = System.currentTimeMillis();
        x.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.qYF.mediaId + " " + this.qYF.qYz + " type " + this.qYF.qYB);
        FileOp.mh(this.qYF.getPath());
        an anVar = this.qYF.qYC;
        String str = "";
        if (anVar == null) {
            str = "";
        } else if (anVar.equals(an.xyR)) {
            str = "album_friend";
        } else if (anVar.equals(an.xyS)) {
            str = "album_self";
        } else if (anVar.equals(an.xyT)) {
            str = "album_stranger";
        } else if (anVar.equals(an.xyU)) {
            str = "profile_friend";
        } else if (anVar.equals(an.xyV)) {
            str = "profile_stranger";
        } else if (anVar.equals(an.xyW)) {
            str = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
        } else if (anVar.equals(an.xyQ)) {
            str = "timeline";
        }
        if (!bh.ov(str)) {
            str = "&scene=" + str;
        }
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[]{Integer.valueOf(d.vAz), o.getString(ae.bvc()), Integer.valueOf(com.tencent.mm.sdk.platformtools.an.getNetTypeForStat(ac.getContext())), Integer.valueOf(com.tencent.mm.sdk.platformtools.an.getStrength(ac.getContext())), str});
        this.qYF.url = KK(this.qYF.url);
        this.dnsCostTime = bh.Wp();
        long j = (long) com.tencent.mm.k.g.zY().getInt(this.qYF.qYA ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime", 0);
        x.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", Boolean.valueOf(this.qYF.qYA), Boolean.valueOf(this.qYF.qYz), com.tencent.mm.k.g.zY().getValue(this.qYF.qYA ? "SnsSightDomainList" : "SnsAlbumDomainList"), Long.valueOf(j));
        if (j <= 0) {
            j = 259200;
        }
        com.tencent.mm.network.b.b bVar = new com.tencent.mm.network.b.b(this.qYF.url, a(anVar, this.qYF.url, j, r6));
        this.dnsCostTime = bh.bz(this.dnsCostTime);
        try {
            str = bh.ov(bVar.ip) ? InetAddress.getByName(bVar.host).getHostAddress() : bVar.ip;
        } catch (Exception e) {
            str = "-";
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", format, this.qYF.url, this.qYF.mediaId, Integer.valueOf(bVar.hZy), str, this.qYF.url, Integer.valueOf(this.qYF.qYB), Boolean.valueOf(r1), anVar.toString());
        this.qYK = 1;
        u a = a(bVar, format);
        String str2 = "MicroMsg.SnsCdnDownloadBase";
        String str3 = "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s";
        Object[] objArr = new Object[5];
        objArr[0] = bVar.ip;
        objArr[1] = Boolean.valueOf(a != null);
        objArr[2] = Integer.valueOf(this.qYK);
        objArr[3] = Boolean.valueOf(bVar.hZB);
        objArr[4] = bVar.hZA;
        x.i(str2, str3, objArr);
        int i = 2;
        if (a != null) {
            i = c(a);
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", Long.valueOf(bh.bz(currentTimeMillis)), Long.valueOf(this.qYL), this.qYF.mediaId, this.qYF.url, Integer.valueOf(this.qYZ));
        return Integer.valueOf(i);
    }

    private u a(com.tencent.mm.network.b.b bVar, String str) {
        String message;
        try {
            this.qYI = bVar.ip;
            this.hZy = bVar.hZy;
            this.qYM = bh.Wp();
            u a = com.tencent.mm.network.b.a(this.qYF.url, bVar);
            a.setRequestMethod("GET");
            a.setRequestProperty("referer", str);
            if (bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsDownloadHttpKeep"), 0) > 0) {
                x.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
                a.setRequestProperty("Connection", "close");
            }
            a.setConnectTimeout(25000);
            a.setReadTimeout(25000);
            u b = b(a);
            this.qYY = b.getHeaderFields();
            List list = (List) this.qYY.get("X-ClientIp");
            if (list != null && list.size() > 0) {
                this.qYH = (String) list.get(0);
            }
            list = (List) this.qYY.get("X-ServerIp");
            if (list != null && list.size() > 0) {
                this.qYG = (String) list.get(0);
            }
            list = (List) this.qYY.get("X-ErrNo");
            if (list != null && list.size() > 0) {
                this.qYJ = bh.VI((String) list.get(0));
            }
            list = (List) this.qYY.get("X-RtFlag");
            if (list != null && list.size() > 0) {
                this.qYK = bh.VI((String) list.get(0));
            }
            try {
                this.retCode = b.getResponseCode();
                this.host = b.url.getHost();
                if (this.retCode == 200 || this.retCode == com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX) {
                    P(b.getHeaderFields());
                    if (d(b)) {
                        this.qYM = bh.bz(this.qYM);
                        list = (List) this.qYY.get("Content-Length");
                        if (list != null && list.size() > 0) {
                            this.qYW = bh.VI((String) list.get(0));
                        }
                        x.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", this.qYF.url, this.qYH, this.qYG, Integer.valueOf(this.qYW), Integer.valueOf(this.qYJ));
                        return b;
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.a(22, 62, 1, true);
                    x.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.qYF.mediaId);
                    ik(false);
                    return null;
                }
                P(b.getHeaderFields());
                if (this.qYF.qYA) {
                    if (this.retCode >= 400 && this.retCode < 500) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(22, 78, 1, true);
                    } else if (this.retCode >= 500 && this.retCode < 600) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(22, 79, 1, true);
                    }
                } else if (this.retCode >= 400 && this.retCode < 500) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(22, 56, 1, true);
                } else if (this.retCode >= 500 && this.retCode < 600) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(22, 57, 1, true);
                }
                if (this.qYF.qYz) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(150, 14, 1, true);
                }
                x.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.qYF.mediaId + " " + this.qYF.url + " " + this.retCode);
                ik(false);
                return null;
            } catch (SocketTimeoutException e) {
                this.retCode = 1;
                ik(false);
                message = e.getMessage();
                if (this.qYF.qYA) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(22, 77, 1, true);
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.a(22, 55, 1, true);
                }
                if (this.qYF.qYz) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(150, 14, 1, true);
                }
                x.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.qYF.mediaId + " " + this.qYF.url + " msg:" + message);
                return null;
            } catch (Exception e2) {
                ik(false);
                message = e2.getMessage();
                if (this.qYF.qYz) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(150, 14, 1, true);
                }
                x.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.qYF.mediaId + " " + this.qYF.url + " msg:" + message);
                return null;
            }
        } catch (Throwable e3) {
            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e3, "connect fail : " + e3.getMessage(), new Object[0]);
            this.retCode = 2;
            ik(false);
            return null;
        }
    }

    private int c(u uVar) {
        Throwable e;
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            this.qYU = bh.Wp();
            InputStream inputStream3 = uVar.getInputStream();
            try {
                this.qYN = bh.Wp();
                boolean p = p(inputStream3);
                inputStream3.close();
                x.i("MicroMsg.SnsCdnDownloadBase", "reportResult ret : " + p);
                if (p) {
                    this.qYN = bh.bz(this.qYN);
                    this.qYL = bh.bz(this.qYO);
                    boolean bwh = bwh();
                    x.i("MicroMsg.SnsCdnDownloadBase", "processData ret : " + bwh);
                    if (bwh) {
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        ik(true);
                        if (this.qYF.qYz) {
                            return 3;
                        }
                        return 1;
                    }
                    this.retCode = 3;
                    ik(false);
                    if (uVar == null) {
                        return 2;
                    }
                    uVar.aBw.disconnect();
                    return 2;
                }
                ik(false);
                if (uVar == null) {
                    return 2;
                }
                uVar.aBw.disconnect();
                return 2;
            } catch (Exception e2) {
                e = e2;
                inputStream = inputStream3;
                try {
                    x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "snscdndownload fail : " + e.getMessage(), new Object[0]);
                    this.retCode = 4;
                    ik(false);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e3, "", new Object[0]);
                        }
                    }
                    if (uVar != null) {
                        return 2;
                    }
                    uVar.aBw.disconnect();
                    return 2;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e32, "", new Object[0]);
                        }
                    }
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = inputStream3;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                throw th;
            }
        } catch (Exception e4) {
            e32 = e4;
            inputStream = null;
            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e32, "snscdndownload fail : " + e32.getMessage(), new Object[0]);
            this.retCode = 4;
            ik(false);
            if (inputStream != null) {
                inputStream.close();
            }
            if (uVar != null) {
                return 2;
            }
            uVar.aBw.disconnect();
            return 2;
        } catch (Throwable th4) {
            th = th4;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            throw th;
        }
    }

    private static void P(Map<String, List<String>> map) {
        if (map != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : map.keySet()) {
                    List<String> list = (List) map.get(str);
                    if (list != null) {
                        stringBuffer.append(str + ":");
                        for (String str2 : list) {
                            stringBuffer.append(str2 + "|");
                        }
                        stringBuffer.append(";");
                    }
                }
                x.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", stringBuffer.toString());
            } catch (Exception e) {
            }
        }
    }

    private static boolean d(u uVar) {
        try {
            List list = (List) uVar.getHeaderFields().get("cache-control");
            if (list == null || list.size() == 0) {
                return true;
            }
            if (bh.ov(list.toString()) || !list.toString().contains("no-cache")) {
                return true;
            }
            if (list.toString().contains("no-cache")) {
                return false;
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            return false;
        }
    }

    private static long KL(String str) {
        long j = 0;
        if (str == null || str.length() == 0) {
            return j;
        }
        try {
            String[] split = str.split("\\.");
            return bh.getLong(split[3], 0) + (((16777216 * bh.getLong(split[0], 0)) + (HardCoderJNI.ACTION_ALLOC_MEMORY * bh.getLong(split[1], 0))) + (256 * bh.getLong(split[2], 0)));
        } catch (Exception e) {
            return j;
        }
    }

    private void ik(boolean z) {
        long j;
        String str;
        if (this.qYF == null || !this.qYF.qYA) {
            if (z) {
                com.tencent.mm.plugin.report.service.g.pQN.a(22, 53, this.qYL, true);
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.a(22, 52, 1, true);
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(22, 51, 1, true);
        } else {
            if (z) {
                com.tencent.mm.plugin.report.service.g.pQN.a(22, 75, this.qYL, true);
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.a(22, 74, 1, true);
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(22, 73, 1, true);
        }
        if (!(this.qYF == null || !this.qYF.qYz || z || i.b(this.qYE))) {
            com.tencent.mm.plugin.report.service.g.pQN.a(150, 66, 1, true);
        }
        this.qYV = this.qYZ;
        int i = com.tencent.mm.sdk.platformtools.an.isWifi(ac.getContext()) ? 1 : 0;
        int strength = com.tencent.mm.sdk.platformtools.an.getStrength(ac.getContext());
        String str2 = "MicroMsg.SnsCdnDownloadBase";
        String str3 = "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]";
        Object[] objArr = new Object[11];
        objArr[0] = Integer.valueOf(this.hZy);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(strength);
        objArr[3] = Long.valueOf(this.dnsCostTime);
        objArr[4] = Long.valueOf(this.qYM);
        objArr[5] = Long.valueOf(this.qYN);
        objArr[6] = Long.valueOf(this.qYL);
        objArr[7] = this.qYG;
        objArr[8] = this.qYI;
        objArr[9] = this.qYH;
        objArr[10] = this.qYF == null ? "" : this.qYF.url;
        x.v(str2, str3, objArr);
        int netType = com.tencent.mm.sdk.platformtools.an.getNetType(ac.getContext());
        int i2 = 0;
        if (this.qYF != null) {
            i2 = this.qYF.qYB == 4 ? 1 : 0;
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", Integer.valueOf(this.retCode), Integer.valueOf(this.qYV), Integer.valueOf(netType), Integer.valueOf(i2), Integer.valueOf(this.qYJ));
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr2 = new Object[19];
        if (this.qYF == null) {
            str2 = "";
        } else {
            str2 = this.qYF.url;
        }
        objArr2[0] = str2;
        objArr2[1] = Long.valueOf(KL(this.qYI));
        if (z) {
            j = this.qYL;
        } else {
            j = 0;
        }
        objArr2[2] = Long.valueOf(j);
        objArr2[3] = "";
        objArr2[4] = Integer.valueOf(i);
        objArr2[5] = Long.valueOf(this.dnsCostTime);
        objArr2[6] = Long.valueOf(this.qYM);
        objArr2[7] = Integer.valueOf(0);
        objArr2[8] = Integer.valueOf(0);
        objArr2[9] = Long.valueOf(this.qYN);
        objArr2[10] = Long.valueOf(KL(this.qYH));
        objArr2[11] = Long.valueOf(KL(this.qYG));
        objArr2[12] = Integer.valueOf(this.hZy);
        objArr2[13] = Integer.valueOf(strength);
        objArr2[14] = Integer.valueOf(this.retCode);
        objArr2[15] = Integer.valueOf(this.qYV);
        objArr2[16] = Integer.valueOf(netType);
        objArr2[17] = Integer.valueOf(i2);
        objArr2[18] = Integer.valueOf(this.qYJ);
        gVar.h(10736, objArr2);
        boolean isConnected = com.tencent.mm.sdk.platformtools.an.isConnected(ac.getContext());
        x.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + isConnected + " urlIp: " + this.qYP);
        if (!(z || bh.ov(this.qYP) || !isConnected)) {
            com.tencent.mm.network.b.reportFailIp(this.qYP);
        }
        x.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", this.qYQ.value);
        int bwi = bwi();
        str2 = "";
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
        c fn = com.tencent.mm.z.c.c.IF().fn(str);
        i = 0;
        if (fn.isValid()) {
            i = bh.getInt((String) fn.chI().get("needUploadData"), 1);
            str2 = fn.field_expId;
        }
        if (i != 0) {
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            dVar.q("20ImgSize", this.qYZ + ",");
            dVar.q("21NetType", (com.tencent.mm.sdk.platformtools.an.isWifi(ac.getContext()) ? 1 : 0) + ",");
            dVar.q("22DelayTime", (this.qYL - this.qYM) + ",");
            dVar.q("23RetCode", this.retCode + ",");
            dVar.q("24DnsCostTime", this.dnsCostTime + ",");
            dVar.q("25ConnectCostTime", this.qYM + ",");
            dVar.q("26SendCostTime", ",");
            dVar.q("27WaitResponseCostTime", this.qYT + ",");
            dVar.q("28ReceiveCostTime", this.qYN + ",");
            dVar.q("29ClientAddrIP", this.qYH + ",");
            dVar.q("30ServerAddrIP", this.qYI + ",");
            dVar.q("31dnstype", this.hZy + ",");
            dVar.q("32signal", com.tencent.mm.sdk.platformtools.an.getStrength(ac.getContext()) + ",");
            dVar.q("33host", this.host + ",");
            dVar.q("34MediaType", bwi + ",");
            dVar.q("35X_Errno", this.qYJ + ",");
            dVar.q("36MaxPackageSize", this.qYR + ",");
            dVar.q("37MaxPackageTimeStamp", this.qYS + ",");
            dVar.q("38PackageRecordList", this.qYQ.value + ",");
            dVar.q("39ExpLayerId", str + ",");
            dVar.q("40ExpId", str2 + ",");
            dVar.q("41FeedId", ",");
            x.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + dVar.Sz());
            com.tencent.mm.plugin.report.service.g.pQN.h(13480, dVar);
            if (this.retCode != 200) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14071, dVar);
            }
        }
    }

    public final void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.qYF != null) {
            x.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", num, this.qYF.url, this.qYF.mediaId, Integer.valueOf(this.qYV), Integer.valueOf(qYX.size()));
            qYX.remove(this.qYF.qTU);
            if (this.qYF.qYz && num.intValue() != 2) {
                au.Kw(this.qYF.mediaId);
                bwk();
            } else if (!this.qYF.qYz && this.qYF.qYB == 4) {
                ae.bvs().dZ(this.qYF.mediaId, this.qYF.getPath() + i.j(this.fHC));
            }
            this.qYD.a(num.intValue(), this.fHC, this.qYF.qYB, this.qYF.qYz, this.qYF.qTU, this.qYV);
        }
    }

    public final void bwk() {
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

    public final af buO() {
        return ae.bvg();
    }
}
