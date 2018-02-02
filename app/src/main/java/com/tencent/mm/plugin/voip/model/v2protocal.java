package com.tencent.mm.plugin.voip.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.buq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class v2protocal {
    public static final int oFK;
    public static int saT;
    public static final int snX;
    public static boolean snY = false;
    public int channelStrategy = 0;
    public int defaultHeight = 240;
    public int defaultWidth = 320;
    public int[] field_ChannelReportDial = null;
    public int[] field_EngineAudioReportStat = null;
    public int[] field_SpeedTestSvrParaArray = null;
    public int field_audioDuration = 0;
    public byte[] field_capInfo = null;
    int field_channelReportLength = 0;
    int field_channelStatLength = 0;
    public int field_connectingStatusKey = 0;
    int field_engine2ndReportLength = 0;
    int field_engine2ndStatLength = 0;
    int field_engineQosStatLength = 0;
    int field_engineVersionStatLength = 0;
    public int[] field_jbmBitratRsSvrParamArray = null;
    public double[] field_jbmBitratRsSvrParamDoubleArray = null;
    public int field_jbmParamArraySize = 0;
    public int field_jbmParamDoubleArraySize = 0;
    public int field_localImgHeight = 0;
    public int field_localImgWidth = 0;
    public int field_mGetValidSample = 0;
    int field_netFlowRecv = 0;
    int field_netFlowSent = 0;
    int field_newEngineExtStatLength = 0;
    int field_newEngineReportLength = 0;
    int field_newEngineStatLength = 0;
    public byte[] field_peerId = null;
    public int field_pstnChannelInfoLength = 0;
    public int field_pstnEngineInfoLength = 0;
    public int[] field_punchSvrArray = null;
    public int field_realLinkQualityInfoBuffLen = 0;
    public int field_recvVideoLen = 120;
    public int field_relayDataSyncKey = 0;
    public int[] field_relaySvrArray = null;
    public int[] field_relayTcpSvrArray = null;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgOrien = 0;
    public int field_remoteImgWidth = 0;
    public int field_sendVideoLen = 100;
    int field_speedTestInfoLength = 0;
    int field_statInfoLength = 0;
    public int field_statusSyncKey = 0;
    public int field_videoDuration = 0;
    public int field_voipcsChannelInfoLength = 0;
    public int field_voipcsEngineInfoLength = 0;
    private af handler = null;
    public long hzX = 0;
    public int nDA = 0;
    public int nDF = 0;
    public int nDx = 0;
    public long nDy = 0;
    public String nTr = "";
    public int netType = 0;
    public boolean oxo = false;
    public int snZ = 0;
    public int soA = 0;
    public int soB = -1;
    public int soC = -1;
    public int soD = 0;
    public int soE = 0;
    public int soF = 0;
    public int soG = 0;
    public int soH = 100;
    public int soI = 300;
    public int soJ = 1;
    public int soK = 1;
    public int soL = 0;
    public int soM = 1;
    public int soN = 0;
    public int soO = 0;
    public int soP = 0;
    public int soQ = 0;
    public int soR = 0;
    public int soS = 0;
    public int soT = 0;
    public int soU = 0;
    public int soV = 0;
    public int[] soW = null;
    public int soX = 0;
    public int soY = 0;
    public int soZ = 0;
    public int soa = 0;
    public int sob = 0;
    public int soc = 0;
    public long sod = 0;
    public byte[] soe = null;
    public byte[] sof = null;
    public byte[] sog = null;
    public int soh = 0;
    public byte[] soi = null;
    public int soj = 500;
    public int sok = 30;
    public int sol = 999;
    public int som = 0;
    public int son = 20;
    public int soo = 0;
    public int sop = 0;
    public int soq = 0;
    public int sor = 0;
    public int sos = 0;
    public int sot = 65536;
    public int sou = 0;
    public int sov = 0;
    public int sow = 7;
    public int sox = 3;
    public int soy = 3;
    public int soz = 0;
    byte[] spA = new byte[Downloads.RECV_BUFFER_SIZE];
    public byte[] spB = new byte[2048];
    public byte[] spC = new byte[2048];
    public byte[] spD = new byte[2048];
    public byte[] spE = new byte[2048];
    public int[] spF = new int[30];
    int spG = 0;
    public h spH = new h();
    public int spa = 0;
    public byte[] spb = null;
    public int spc = 0;
    public int spd = 0;
    public int spe = 0;
    public int spf = 0;
    public byte[] spg = new byte[1500];
    public int sph = 0;
    public byte[] spi = null;
    public byte[] spj = null;
    public int spk = 0;
    public int spl = 0;
    public int spm = 0;
    public long spn = 0;
    public byte[] spo = new byte[8];
    public int spp = 0;
    public int spq = 0;
    public int spr = 0;
    public int sps = 0;
    public int spt = 0;
    byte[] spu = new byte[Downloads.RECV_BUFFER_SIZE];
    byte[] spv = new byte[2048];
    byte[] spw = new byte[2048];
    byte[] spx = new byte[Downloads.RECV_BUFFER_SIZE];
    byte[] spy = new byte[Downloads.RECV_BUFFER_SIZE];
    byte[] spz = new byte[2048];

    private native int forceredirect(int i, int i2);

    private native int setsvraddr(int i, int i2, int i3, String str, String str2);

    private native int uninit(int i, long j, int i2);

    public native int SendDTMF(int i);

    public native int SendRUDP(byte[] bArr, int i);

    public native int SetDTMFPayload(int i);

    public native int StartSpeedTest(long j, int i);

    public native int StopSpeedTest();

    public native int app2EngineDataEx(int i, int i2, byte[] bArr, int i3, int i4);

    public native int app2EngineLinkQualityEx(int i, byte[] bArr);

    public native int connectToPeer();

    public native int connectToPeerDirect();

    public native int connectToPeerRelay();

    public native int doubleLinkSwitch(int i);

    public native int exchangeCabInfo(byte[] bArr, int i);

    public native int freeJNIReport();

    public native int getAVDuration(byte[] bArr, int i);

    public native int getChannelInfo(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int getChannelReport(byte[] bArr, int i);

    public native int getCurrentConnType();

    public native int getEngine2ndInfo(byte[] bArr, int i);

    public native int getEngine2ndInfoReport(byte[] bArr, int i);

    public native int getEngineQosInfo(byte[] bArr, int i);

    public native int getEngineVersionInfo(byte[] bArr, int i);

    public native int getNewEngineExtInfo(byte[] bArr, int i);

    public native int getNewEngineInfo(byte[] bArr, int i);

    public native int getNewEngineInfoReport(byte[] bArr, int i);

    public native int getPstnChannelInfo(byte[] bArr, int i, int i2, int i3);

    public native int getPstnEngineInfo(byte[] bArr, int i);

    public native int getStatInfo(byte[] bArr, int i, int[] iArr, int i2);

    public native int getVoipcsChannelInfo(byte[] bArr, int i, int i2);

    public native int getVoipcsEngineInfo(byte[] bArr, int i);

    public native int getcurstrategy();

    public native int handleCommand(byte[] bArr, int i);

    public native int init(int i, int i2, int i3, int i4, int i5, int i6, String str, int i7);

    public native int isDCReady();

    public native int isDCSameLan();

    public native int isRelayConnReady();

    public native int parseSyncKeyBuff(byte[] bArr, int i);

    public native int playCallback(byte[] bArr, int i);

    public native int recordCallback(byte[] bArr, int i, int i2);

    public native int setActive();

    public native int setAppCmd(int i, byte[] bArr, int i2);

    public native int setConfigInfo(int i, long j, int i2, long j2, byte[] bArr, int i3, int i4, int i5, int i6, int i7, byte[] bArr2, int i8, int i9, int i10, int i11, byte[] bArr3, int i12, int i13);

    public native int setInactive();

    public native int setJNIAppCmd(int i, byte[] bArr, int i2);

    public native int setNetSignalValue(int i, int i2);

    public native int setSvrConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public native int setjbmbitraterssvrparam();

    public native int startEngine();

    public native int videoDecode(int[] iArr);

    public native int videoEncodeToLocal(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public native int videoEncodeToSend(byte[] bArr, int i, int i2, int i3, int i4);

    public native int videoRorate90D(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7, int i8);

    static {
        int yp = m.yp();
        if ((yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            d.t(ac.getContext(), "libvoipCodec_v7a.so");
        } else if ((yp & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            d.t(ac.getContext(), "libvoipCodec.so");
        } else {
            d.t(ac.getContext(), "libvoipCodec_v5.so");
        }
        k.b("voipMain", v2protocal.class.getClassLoader());
        yp = m.yp();
        saT = yp;
        yp = (yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? 16000 : 8000;
        oFK = yp;
        snX = ((yp / 1000) * 20) * 2;
    }

    public final int td(int i) {
        int appCmd = setAppCmd(i, new byte[]{(byte) 0}, 1);
        if (appCmd < 0) {
            a.et("MicroMsg.Voip", "setAppCmd: type:" + appCmd + ":ret:" + appCmd);
        }
        return appCmd;
    }

    public static String bHP() {
        String str = Build.MANUFACTURER;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.MODEL;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        String str3 = VERSION.SDK;
        if (str3.contains(",")) {
            str3 = str3.replace(',', ' ');
        }
        String str4 = VERSION.RELEASE;
        if (str4.contains(",")) {
            str4 = str3.replace(',', ' ');
        }
        return "," + str + "," + str2 + "," + str3 + "," + str4;
    }

    public static long aP(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getLong();
    }

    private String bHQ() {
        return "," + this.channelStrategy;
    }

    public final String bHR() {
        if (this.field_videoDuration == 0) {
            a.eu("MicroMsg.Voip", "captureFrames:" + this.spp + ", videoduration: 0");
            return ",0";
        }
        a.eu("MicroMsg.Voip", "capturefps:" + (this.spp / this.field_videoDuration) + " framecount:" + this.spp + " videoDuration:" + this.field_videoDuration);
        return "," + (this.spp / this.field_videoDuration);
    }

    private String bHS() {
        a.eu("MicroMsg.Voip", "usePreConnect:" + this.soF);
        return "," + this.soF;
    }

    private String bHT() {
        a.eu("MicroMsg.Voip", "preConnectSuccess:" + this.soG);
        return "," + this.soG;
    }

    public final String bHU() {
        if (VERSION.SDK_INT < 11) {
            this.sox = 0;
            this.soy = 2;
        } else {
            this.sox = 3;
            this.soy = 3;
        }
        if (q.gFV.gDg >= 0) {
            this.sox = q.gFV.gDg;
        }
        if (VERSION.SDK_INT >= 11 && l.xg() && 2 == q.gGe.gEP) {
            this.soy = 2;
        }
        if (q.gFV.gDh >= 0) {
            this.soy = q.gFV.gDh;
        }
        if (VERSION.SDK_INT < 11) {
            this.sow = 1;
        } else {
            this.sow = 7;
        }
        if (q.gFV.gCG) {
            this.sow = 1;
        }
        if (q.gFV.gDf >= 0) {
            this.sow = q.gFV.gDf;
        }
        if (q.gFV.gCH > 0) {
            this.soz = 3;
            this.soA = 0;
        } else if (q.gFV.gDi >= 0) {
            this.soz = q.gFV.gDi;
            this.soA = q.gFV.gDi;
        }
        if (q.gFV.gDj >= 0) {
            this.soz = q.gFV.gDj;
        }
        if (q.gFV.gDk >= 0) {
            this.soA = q.gFV.gDk;
        }
        return "," + this.sox + "," + this.soy + "," + this.sow + "," + this.soz + "," + this.soA;
    }

    public v2protocal(af afVar) {
        this.handler = afVar;
    }

    public int keep_onNotifyFromJni(int i, int i2, byte[] bArr) {
        if (i == 100) {
            a.b(bArr, "MicroMsg.Voip", i2);
        } else if (i == 101) {
            a.b(bArr, "MicroMsg.v2Core", i2);
        } else {
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = bArr;
            this.handler.sendMessage(message);
        }
        return 0;
    }

    public int keep_onNotifyFromJniInt(int i, int i2, int[] iArr) {
        if (iArr != null) {
            a.eu("MicroMsg.VoipService", "callByJni : arg1:" + i + " arg2:" + i2);
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = iArr;
            this.handler.sendMessage(message);
        }
        return 0;
    }

    public final int a(bth com_tencent_mm_protocal_c_bth, bth com_tencent_mm_protocal_c_bth2, bth com_tencent_mm_protocal_c_bth3, int i, int i2) {
        if (com_tencent_mm_protocal_c_bth == null || com_tencent_mm_protocal_c_bth.wUx <= 0) {
            a.et("MicroMsg.Voip", "forceRedirect: [TRANSPORT]No relay svr ip");
        } else {
            a.et("MicroMsg.Voip", "forceRedirect: got relay svr addr from server");
            this.field_relaySvrArray = a.a(com_tencent_mm_protocal_c_bth);
        }
        if (com_tencent_mm_protocal_c_bth2 == null || com_tencent_mm_protocal_c_bth2.wUx <= 0) {
            a.et("MicroMsg.Voip", "forceRedirect: No punch svr ip");
        } else {
            a.et("MicroMsg.Voip", "forceRedirect: got punch svr addr from server");
            this.field_punchSvrArray = a.a(com_tencent_mm_protocal_c_bth2);
        }
        if (com_tencent_mm_protocal_c_bth3 == null || com_tencent_mm_protocal_c_bth3.wUx <= 0) {
            a.et("MicroMsg.Voip", "forceRedirect: No relay tcp svr ip");
        } else {
            a.et("MicroMsg.Voip", "forceRedirect: got relay tcp svr addr from server");
            this.field_relayTcpSvrArray = a.a(com_tencent_mm_protocal_c_bth3);
        }
        int forceredirect = forceredirect(i, i2);
        a.et("MicroMsg.Voip", "v2protocal forceRedirect ret :" + forceredirect);
        return forceredirect;
    }

    public final int a(bth com_tencent_mm_protocal_c_bth, bth com_tencent_mm_protocal_c_bth2, bth com_tencent_mm_protocal_c_bth3, buq com_tencent_mm_protocal_c_buq) {
        if (com_tencent_mm_protocal_c_bth.wUx > 0) {
            a.et("MicroMsg.Voip", "setSvrAddr: got relay svr addr from server");
            this.field_relaySvrArray = a.a(com_tencent_mm_protocal_c_bth);
        } else {
            a.et("MicroMsg.Voip", "setSvrAddr: [TRANSPORT]No relay svr ip");
        }
        if (com_tencent_mm_protocal_c_bth2.wUx > 0) {
            a.et("MicroMsg.Voip", "setSvrAddr: got punch svr addr from server");
            this.field_punchSvrArray = a.a(com_tencent_mm_protocal_c_bth2);
        } else {
            a.et("MicroMsg.Voip", "setSvrAddr: No punch svr ip");
        }
        if (com_tencent_mm_protocal_c_bth3.wUx > 0) {
            a.et("MicroMsg.Voip", "setSvrAddr:got tcpsvr addr from server");
            this.field_relayTcpSvrArray = a.a(com_tencent_mm_protocal_c_bth3);
        } else {
            a.et("MicroMsg.Voip", "setSvrAddr:no tcp svr addr ip");
        }
        int i = setsvraddr(com_tencent_mm_protocal_c_buq.wWd, com_tencent_mm_protocal_c_buq.wWe, com_tencent_mm_protocal_c_buq.wWf, com_tencent_mm_protocal_c_buq.userName, com_tencent_mm_protocal_c_buq.mBX);
        a.et("MicroMsg.Voip", "v2protocal setsvraddr ret :" + i);
        return i;
    }

    public final int bEv() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        this.netType = a.getNetType(ac.getContext());
        this.sob = this.netType;
        if (this.netType == 5) {
            this.netType = 4;
        }
        boolean z5 = this.sob >= 4 && (saT & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 && (saT & 255) >= 26;
        if (!z5 || (saT & 255) < 30) {
            z = false;
        } else {
            z = true;
        }
        if (q.gFU.gEt <= 0 || q.gFU.gDV.width < 480 || q.gFU.gDV.height < 360 || q.gFU.gDX.width < 480 || q.gFU.gDX.height < 360) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (q.gFU.gEt < 2 || q.gFU.gDV.width < 640 || q.gFU.gDV.height < 480 || q.gFU.gDX.width < 640 || q.gFU.gDX.height < 480) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (q.gFU.gEt == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        c cVar = q.gFU;
        if ((z5 || z2) && !z4) {
            if (z3) {
                this.defaultWidth = 640;
                this.defaultHeight = 480;
            } else {
                this.defaultWidth = 480;
                this.defaultHeight = 360;
            }
            snY = true;
            a.et("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        }
        a.et("MicroMsg.Voip", "steve: Android CPUFlag:" + (saT & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z5 + ", bEnable480FromSvr:" + z2 + ", bDisable480FromSvr:" + z4 + ", bEnable640FromLocal:" + z + ", bEnable640FromSvr:" + z3);
        this.soW = new int[(this.defaultWidth * this.defaultHeight)];
        ar.Hg();
        this.soa = com.tencent.mm.z.c.Cg();
        if ((saT & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            d.t(ac.getContext(), "libvoipCodec_v7a.so");
            a.eu("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
        } else if ((saT & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            d.t(ac.getContext(), "libvoipCodec.so");
            a.eu("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
        } else {
            d.t(ac.getContext(), "libvoipCodec_v5.so");
            a.eu("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
        }
        int i3 = VERSION.SDK_INT;
        int bID = OpenGlRender.bID();
        Display defaultDisplay = ((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        if ((q.gFU.gEu & 16) != 0) {
            z = true;
        } else {
            z = false;
        }
        if ((q.gFU.gEu & 32) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((q.gFU.gEu & 15) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        if (z) {
            i2 = i | 2;
        } else {
            i2 = i;
        }
        if (z2) {
            i2 |= 4;
        }
        i2 = init(this.netType | (i2 << 8), 2, this.defaultHeight | (this.defaultWidth << 16), (width << 16) | height, this.soa, saT | ((bID << 24) | (i3 << 16)), e.gZJ + "app_lib/", 0);
        a.et("MicroMsg.Voip", "protocal init ret :" + i2 + ",uin= " + this.soa + ", gl_vs:" + bID + ", cpuFlag0=" + saT);
        this.oxo = true;
        if (i2 < 0) {
            reset();
        }
        return i2;
    }

    public final String jl(boolean z) {
        if (this.oxo) {
            a.et("MicroMsg.Voip", "call protocalUninit now...needStatInfo=" + z);
            this.field_ChannelReportDial = new int[6];
            this.field_ChannelReportDial[0] = this.spH.slb;
            this.field_ChannelReportDial[1] = this.spH.slh;
            this.field_ChannelReportDial[2] = this.soX;
            this.field_ChannelReportDial[3] = this.soY;
            this.field_ChannelReportDial[4] = this.soZ;
            this.field_ChannelReportDial[5] = this.spa;
            this.field_EngineAudioReportStat = new int[8];
            bHU();
            this.field_EngineAudioReportStat[0] = this.sor;
            this.field_EngineAudioReportStat[1] = this.sos;
            this.field_EngineAudioReportStat[2] = this.sox;
            this.field_EngineAudioReportStat[3] = this.soy;
            this.field_EngineAudioReportStat[4] = this.sow;
            this.field_EngineAudioReportStat[5] = this.soz;
            this.field_EngineAudioReportStat[6] = this.soA;
            this.field_EngineAudioReportStat[7] = -1;
            this.oxo = false;
            uninit(this.nDx, this.nDy, this.nDF);
            snY = false;
            a.et("MicroMsg.Voip", "uninit over.");
            if (z) {
                getStatInfo(this.spu, this.spu.length, this.spF, 30);
                getEngineVersionInfo(this.spv, this.spv.length);
                getEngineQosInfo(this.spw, this.spw.length);
                StringBuilder stringBuilder = new StringBuilder();
                long j = (long) this.soa;
                if (this.soa < 0) {
                    j = ((long) this.soa) + 4294967296L;
                }
                StringBuilder append = new StringBuilder().append(j).append(",").append(this.nDy).append(",").append(this.nDx).append(",").append(this.nDF).append(",");
                h hVar = this.spH;
                String stringBuilder2 = append.append(hVar.skR + "," + hVar.skS + "," + hVar.skT + "," + hVar.skU + "," + hVar.skV + "," + hVar.skW + "," + hVar.skX + "," + hVar.skY + "," + hVar.skZ + "," + hVar.sla + "," + hVar.slb).toString();
                a.et("MicroMsg.Voip", "voipreport:DailStatString:" + stringBuilder2);
                append = stringBuilder.append(stringBuilder2).append(new String(this.spu, 0, this.field_statInfoLength)).append(bHP()).append(bHQ()).append("," + this.spH.slc).append(new String(this.spv, 0, this.field_engineVersionStatLength)).append(bHR());
                a.eu("MicroMsg.Voip", "cpuCapacity:" + saT);
                stringBuilder2 = append.append("," + saT).append(bHS()).append(bHT()).append(new String(this.spw, 0, this.field_engineQosStatLength)).toString();
                a.et("MicroMsg.Voip", "statInfoBuffer = " + new String(this.spu, 0, this.field_statInfoLength));
                a.et("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.spv, 0, this.field_engineVersionStatLength));
                a.et("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.spw, 0, this.field_engineQosStatLength));
                a.et("MicroMsg.Voip", "voipreport:StatString = " + stringBuilder2);
                ak.a.hfM.aV(this.field_netFlowRecv, this.field_netFlowSent);
                a.eu("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
                return stringBuilder2;
            }
        }
        return "";
    }

    public static String bHV() {
        return "\u0000";
    }

    public final String bHW() {
        long j = 0;
        if (this.sop == 0 && this.soq == 0) {
            this.spH.sli = 0;
        } else if (this.soq != 0 && this.sop != 0) {
            this.spH.sli = 3;
        } else if (this.soq != 0) {
            this.spH.sli = 1;
        } else if (this.sop != 0) {
            this.spH.sli = 2;
        }
        this.spH.slq = a.getNetType(ac.getContext());
        this.spH.slp = this.field_videoDuration;
        this.spH.slo = this.field_audioDuration;
        this.sou = ar.Hh().xW();
        long j2 = (this.spH.sly <= 0 || this.spH.sls <= this.spH.sly) ? 0 : this.spH.sls - this.spH.sly;
        a.eu("MicroMsg.Voip", "voipreport:acceptcalltime:" + j2);
        setJNIAppCmd(1, this.spo, this.spo.length);
        long aP = aP(this.spo);
        h hVar = this.spH;
        long j3 = (aP <= this.spH.slw || this.spH.slw <= 0) ? 0 : aP - this.spH.slw;
        hVar.slz = j3;
        h hVar2 = this.spH;
        if (aP > this.spH.sly && this.spH.sly > 0) {
            j = aP - this.spH.sly;
        }
        hVar2.slA = j;
        a.eu("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.spH.slz + " lCalledWaitTime:" + this.spH.slA);
        StringBuilder append = new StringBuilder().append(this.soo).append(",").append(this.nDx).append(",").append(this.nDy).append(",").append(this.nDF).append(",").append(this.spH.skR).append(",").append(this.spH.sld).append(",").append(this.spH.sle).append(",").append(this.spH.slf).append(",").append(this.spH.slg).append(",").append(this.spH.slh).append(",").append(this.spH.sli).append(",").append(this.spH.slb).append(",").append(this.spH.slj).append(",").append(this.spH.slk).append(",").append(this.spH.sll).append(",").append(this.spH.slm).append(",").append(this.spH.sln).append(",").append(this.spH.slo).append(",").append(this.spH.slp).append(",").append(this.spH.slq).append(bHS()).append(bHT()).append(bHP()).append(",").append(this.spH.slr).append(",").append(this.sot).append(",").append(this.sou).append(",").append(j2).append(",").append(this.spH.slz).append(",").append(this.spH.slA).append(",").append(this.sov).append(",").append(this.sob).append(bHQ()).append(",").append(saT & 255).append(",").append(this.soB).append(",").append(this.soC);
        String str = VERSION.INCREMENTAL;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.DISPLAY;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        str = append.append("," + str + "," + str2).append(",").append(this.spH.slt).append(",").append(this.spH.slv).append(",").append(this.spH.slu).toString();
        a.et("MicroMsg.Voip", "voipreport:initNetType:" + this.sob);
        a.et("MicroMsg.Voip", "voipreport:NewDialStatString:" + str);
        a.et("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + bHQ());
        return str;
    }

    public final String bHX() {
        getChannelInfo(this.spx, this.spx.length, this.soX, this.soY, this.soZ, this.spa);
        a.et("MicroMsg.Voip", "voipreport:oldChannelString: " + (this.nDy + "," + this.nDx + "," + this.nDF + this.spH.bGH() + ("," + this.spH.slh) + new String(this.spx, 0, this.field_channelStatLength)));
        getChannelReport(this.spx, this.spx.length);
        String str = new String(this.spx, 0, this.field_channelReportLength);
        a.et("MicroMsg.Voip", "voipreport:newChannelString: " + str);
        return str;
    }

    public final String bHY() {
        getNewEngineInfo(this.spy, this.spy.length);
        getNewEngineExtInfo(this.spz, this.spz.length);
        a.et("MicroMsg.Voip", "voipreport:oldNewEngineString:" + (this.nDF + "," + this.nDy + this.spH.bGH() + "," + this.sop + "," + this.soq + bHR() + new String(this.spy, 0, this.field_newEngineStatLength) + "," + this.sor + "," + this.sos + bHU() + new String(this.spz, 0, this.field_newEngineExtStatLength)));
        getNewEngineInfoReport(this.spy, this.spy.length);
        String str = this.nDF + "," + this.nDy + this.spH.bGH() + "," + this.sop + "," + this.soq + bHR() + new String(this.spy, 0, this.field_newEngineReportLength);
        a.et("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:" + str);
        return str;
    }

    public final String bHZ() {
        getEngine2ndInfo(this.spA, this.spA.length);
        a.et("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:" + (this.nDy + "," + this.nDx + "," + this.nDF + new String(this.spA, 0, this.field_engine2ndStatLength)));
        getEngine2ndInfoReport(this.spA, this.spA.length);
        String str = this.nDy + "," + this.nDx + "," + this.nDF + new String(this.spA, 0, this.field_engine2ndReportLength);
        a.et("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:" + str);
        return str;
    }

    public final void reset() {
        a.et("MicroMsg.Voip", "v2protocal reset!");
        this.field_punchSvrArray = null;
        this.field_relaySvrArray = null;
        this.field_relayTcpSvrArray = null;
        this.field_peerId = null;
        this.field_capInfo = null;
        this.nDx = 0;
        this.sod = 0;
        this.soc = 0;
        this.nDF = 0;
        this.nDy = 0;
        this.channelStrategy = 0;
        this.nDA = 0;
        this.hzX = 0;
        this.soe = null;
        this.sof = null;
        this.sog = null;
        this.soh = 0;
        this.soi = null;
        this.spa = 0;
        this.spb = null;
        this.spc = 0;
        this.spd = 0;
        this.spi = null;
        this.spj = null;
        this.spp = 0;
        this.spq = 0;
        this.spr = 0;
        this.sps = 0;
        this.spt = 0;
        this.field_videoDuration = 0;
        this.field_audioDuration = 0;
        this.spG = 0;
        this.soG = 0;
        this.soF = 0;
        this.field_engineVersionStatLength = 0;
        this.field_engineQosStatLength = 0;
        this.field_statusSyncKey = 0;
        this.field_relayDataSyncKey = 0;
        this.field_connectingStatusKey = 0;
        this.sor = 0;
        this.sos = 0;
        this.sot = 65536;
        this.sou = 0;
        this.sov = 0;
        this.soC = -1;
        this.soD = 0;
        this.spm = 0;
        this.snZ = 0;
        this.nTr = "";
        this.spk = 0;
        this.spl = 0;
        this.spH.reset();
        this.spH.bGG();
        snY = false;
        this.field_jbmBitratRsSvrParamArray = null;
        this.field_jbmParamArraySize = 0;
        this.field_jbmBitratRsSvrParamDoubleArray = null;
        this.field_jbmParamDoubleArraySize = 0;
        a.et("MicroMsg.Voip", "freeJNIReport : " + freeJNIReport() + ". [0: null, no need to free, 1: free success!]");
    }
}
