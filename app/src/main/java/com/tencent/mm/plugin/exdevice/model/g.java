package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.akk;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.protocal.c.akn;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.bol;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xwalk.core.R$styleable;

public final class g implements e {
    String fzT;
    long gAc;
    long gLP;
    String hBn = "";
    public a hBx = new 2(this);
    boolean lLT = false;
    boolean lLU = false;
    boolean lLV = false;
    String lLW;
    String lLX;
    int lLY;
    String lLZ = "send_data_sucess";
    String lMa = "send_data_failed";
    private String lMb = "send_data_sending";
    boolean lMc = false;
    boolean lMd = false;
    public HashMap<String, String> lMe = new HashMap();
    akl lMf;
    long lMg;
    List<b> lMh = null;
    List<b> lMi = new ArrayList();
    HashMap<String, String> lMj = new HashMap();
    HashMap<String, Integer> lMk = new HashMap();
    HashMap<String, Boolean> lMl = new HashMap();
    j.a lMm;
    j.a lMn;
    j.a lMo;
    j.a lMp;
    Runnable lMq = new 1(this);
    akl lMr;
    String lMs;
    String lMt;
    int lMu;
    HashMap<Integer, String> lMv = new HashMap();

    static /* synthetic */ void a(g gVar, String str, int i) {
        com.tencent.mm.sdk.b.b ebVar = new eb();
        ebVar.fsI.ffq = str;
        if (i >= 100) {
            ebVar.fsI.fsK = gVar.lLZ;
        } else {
            ebVar.fsI.fsK = gVar.lMb;
        }
        ebVar.fsI.progress = i;
        com.tencent.mm.sdk.b.a.xef.m(ebVar);
    }

    static /* synthetic */ void a(g gVar, List list) {
        List arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceType", ((b) list.get(i)).field_deviceType);
            hashMap.put("deviceID", ((b) list.get(i)).field_deviceID);
            hashMap.put("displayName", c((b) list.get(i)));
            hashMap.put("iconUrl", ((b) list.get(i)).iconUrl);
            hashMap.put("ability", ((b) list.get(i)).gfT);
            hashMap.put("abilityInf", ((b) list.get(i)).gfU);
            arrayList.add(hashMap);
        }
        com.tencent.mm.sdk.b.b dxVar = new dx();
        dxVar.fsx.frK = arrayList;
        com.tencent.mm.sdk.b.a.xef.m(dxVar);
    }

    public g() {
        this.lMi.clear();
        this.lMj.clear();
        this.lMl.clear();
        this.lMh = ad.aEk().aEO();
        if (this.lMh != null && this.lMh.size() > 0) {
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", new Object[]{Integer.valueOf(this.lMh.size())});
            int size = this.lMh.size();
            int i = 0;
            while (i < size) {
                if (((b) this.lMh.get(i)).gfT.contains("internet_to_device") && !((b) this.lMh.get(i)).gfT.contains("wechat_to_device")) {
                    this.lMi.add(this.lMh.get(i));
                }
                i++;
            }
            this.lMp = new 3(this);
            this.lMm = new 4(this);
            this.lMn = new 5(this);
            this.lMo = new 6(this);
            ar.CG().a(1717, this);
            j.aEb().a(14, this.lMm);
            j.aEb().a(12, this.lMn);
            j.aEb().a(13, this.lMo);
            j.aEb().a(15, this.lMp);
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
            Java2CExDevice.initWCLanDeviceLib();
        }
    }

    static Boolean co(long j) {
        boolean z = false;
        ar.Hg();
        cf dH = c.Fa().dH(j);
        if (dH.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        String str = dH.field_content;
        if (dH.getType() == 49) {
            g$a fT = g$a.fT(str);
            if (fT != null && fT.type == 6) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }

    static Boolean cp(long j) {
        boolean z = false;
        ar.Hg();
        cf dH = c.Fa().dH(j);
        if (dH.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (dH.getType() == 3) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    static Boolean cq(long j) {
        boolean z = false;
        ar.Hg();
        cf dH = c.Fa().dH(j);
        if (dH.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (dH.cjm()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    static Boolean cr(long j) {
        boolean z = false;
        ar.Hg();
        cf dH = c.Fa().dH(j);
        if (dH.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (dH.getType() == 62) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static byte[] yS(String str) {
        u a;
        InputStream inputStream;
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "url %s", new Object[]{str});
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            a = com.tencent.mm.network.b.a(str, null);
            try {
                a.setRequestMethod("GET");
                a.setConnectTimeout(25000);
                a.setReadTimeout(25000);
                inputStream = a.getInputStream();
                try {
                    if (a.getResponseCode() == 200) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                            while (true) {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            byteArrayOutputStream.close();
                            inputStream.close();
                            a.aBw.disconnect();
                            bArr = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22) {
                                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                }
                            }
                            a.aBw.disconnect();
                        } catch (Exception e3) {
                            e22 = e3;
                            try {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable e222) {
                                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e2222) {
                                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222, "", new Object[0]);
                                    }
                                }
                                if (a != null) {
                                    a.aBw.disconnect();
                                }
                                return bArr;
                            } catch (Throwable th2) {
                                th = th2;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable e22222) {
                                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22222, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e222222) {
                                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222222, "", new Object[0]);
                                    }
                                }
                                if (a != null) {
                                    a.aBw.disconnect();
                                }
                                throw th;
                            }
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e2222222) {
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222222, "", new Object[0]);
                        }
                    }
                    a.aBw.disconnect();
                } catch (Exception e4) {
                    e2222222 = e4;
                    byteArrayOutputStream = bArr;
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222222, "", new Object[0]);
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (a != null) {
                        a.aBw.disconnect();
                    }
                    return bArr;
                } catch (Throwable e22222222) {
                    byteArrayOutputStream = bArr;
                    th = e22222222;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (a != null) {
                        a.aBw.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e22222222 = e5;
                inputStream = bArr;
                byteArrayOutputStream = bArr;
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22222222, "", new Object[0]);
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (a != null) {
                    a.aBw.disconnect();
                }
                return bArr;
            } catch (Throwable e222222222) {
                inputStream = bArr;
                byteArrayOutputStream = bArr;
                th = e222222222;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (a != null) {
                    a.aBw.disconnect();
                }
                throw th;
            }
        } catch (Exception e6) {
            e222222222 = e6;
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222222222, "", new Object[0]);
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (a != null) {
                a.aBw.disconnect();
            }
            return bArr;
        } catch (Throwable e2222222222) {
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
            th = e2222222222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (a != null) {
                a.aBw.disconnect();
            }
            throw th;
        }
        return bArr;
    }

    public final bnp aDZ() {
        com.tencent.mm.sdk.b.b htVar = new ht();
        htVar.fyb.frH = this.lLW;
        com.tencent.mm.sdk.b.a.xef.m(htVar);
        return htVar.fyc.fyd;
    }

    final boolean a(akl com_tencent_mm_protocal_c_akl, long j) {
        int i = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String cs = cs(j);
        if (cs != null && cs.length() > 0) {
            File file = new File(cs);
            str2 = file.getName();
            i = (int) file.length();
            str3 = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
            str = com.tencent.mm.a.g.i(file);
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", new Object[]{cs});
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", new Object[]{Integer.valueOf(i)});
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", new Object[]{str});
        }
        ar.Hg();
        cf dH = c.Fa().dH(j);
        if (dH.field_msgId == 0) {
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
            return false;
        }
        switch (dH.getType()) {
            case 3:
                akm com_tencent_mm_protocal_c_akm = new akm();
                com_tencent_mm_protocal_c_akm.waP = str3;
                com_tencent_mm_protocal_c_akm.nfp = str2;
                com_tencent_mm_protocal_c_akm.ktH = i;
                com_tencent_mm_protocal_c_akm.vZL = str;
                com_tencent_mm_protocal_c_akl.wrH = com_tencent_mm_protocal_c_akm;
                com_tencent_mm_protocal_c_akl.wrE = 3;
                break;
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                ar.Hg();
                au.b EL = c.Fa().EL(dH.field_content);
                akn com_tencent_mm_protocal_c_akn = new akn();
                com_tencent_mm_protocal_c_akn.vOa = (float) EL.nQx;
                com_tencent_mm_protocal_c_akn.vOb = (float) EL.nQy;
                com_tencent_mm_protocal_c_akn.wrM = (float) EL.fzv;
                com_tencent_mm_protocal_c_akn.njX = EL.label;
                com_tencent_mm_protocal_c_akn.wrN = EL.nTe;
                com_tencent_mm_protocal_c_akl.wrG = com_tencent_mm_protocal_c_akn;
                com_tencent_mm_protocal_c_akl.wrE = 2;
                break;
            case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
            case 268435505:
                g$a fT = g$a.fT(dH.field_content);
                if (fT != null) {
                    if (fT.type != 3) {
                        if (fT.type != 6) {
                            if (fT.type != 5) {
                                if (fT.type == 2) {
                                    akm com_tencent_mm_protocal_c_akm2 = new akm();
                                    com_tencent_mm_protocal_c_akm2.waP = "jpg";
                                    com_tencent_mm_protocal_c_akm2.nfp = str2;
                                    com_tencent_mm_protocal_c_akm2.ktH = i;
                                    com_tencent_mm_protocal_c_akm2.vZL = str;
                                    com_tencent_mm_protocal_c_akl.wrH = com_tencent_mm_protocal_c_akm2;
                                    com_tencent_mm_protocal_c_akl.wrE = 3;
                                    break;
                                }
                            }
                            akp com_tencent_mm_protocal_c_akp = new akp();
                            com_tencent_mm_protocal_c_akp.nfX = fT.url;
                            com_tencent_mm_protocal_c_akp.fon = fT.title;
                            com_tencent_mm_protocal_c_akp.wrO = fT.description;
                            com_tencent_mm_protocal_c_akp.niZ = fT.appName;
                            com_tencent_mm_protocal_c_akl.wrJ = com_tencent_mm_protocal_c_akp;
                            com_tencent_mm_protocal_c_akl.wrE = 5;
                            break;
                        }
                        akk com_tencent_mm_protocal_c_akk = new akk();
                        com_tencent_mm_protocal_c_akk.waP = fT.hbc;
                        com_tencent_mm_protocal_c_akk.nfp = fT.title;
                        com_tencent_mm_protocal_c_akk.ktH = i;
                        com_tencent_mm_protocal_c_akk.vZL = str;
                        com_tencent_mm_protocal_c_akl.wrI = com_tencent_mm_protocal_c_akk;
                        com_tencent_mm_protocal_c_akl.wrE = 4;
                        break;
                    }
                    ako com_tencent_mm_protocal_c_ako = new ako();
                    com_tencent_mm_protocal_c_ako.fon = fT.title;
                    com_tencent_mm_protocal_c_ako.wrO = fT.description;
                    com_tencent_mm_protocal_c_ako.nfX = fT.url;
                    com_tencent_mm_protocal_c_ako.wrP = fT.hba;
                    com_tencent_mm_protocal_c_ako.vWd = fT.hbs;
                    com_tencent_mm_protocal_c_ako.wrQ = fT.hbt;
                    com_tencent_mm_protocal_c_ako.niZ = fT.appName;
                    com_tencent_mm_protocal_c_ako.wrR = fT.hbj;
                    com_tencent_mm_protocal_c_ako.wrS = fT.hbk;
                    com_tencent_mm_protocal_c_ako.wrT = fT.hbq;
                    com_tencent_mm_protocal_c_akl.wrF = com_tencent_mm_protocal_c_ako;
                    com_tencent_mm_protocal_c_akl.wrE = 1;
                    break;
                }
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
                return false;
                break;
            case 62:
                akq com_tencent_mm_protocal_c_akq = new akq();
                com_tencent_mm_protocal_c_akq.waP = str3;
                com_tencent_mm_protocal_c_akq.ktH = i;
                com_tencent_mm_protocal_c_akq.vZL = str;
                com_tencent_mm_protocal_c_akq.nfp = str2;
                com_tencent_mm_protocal_c_akl.wrK = com_tencent_mm_protocal_c_akq;
                com_tencent_mm_protocal_c_akl.wrE = 6;
                break;
        }
        return true;
    }

    static String w(String str, long j) {
        InputStream openRead;
        Throwable e;
        IOException e2;
        if (str == null) {
            return null;
        }
        String substring = str.substring(0, str.lastIndexOf("/"));
        substring = substring + "/" + ("image_hd_" + str.hashCode());
        OutputStream cVar;
        try {
            cVar = new com.tencent.mm.modelsfs.c(new File(substring), j);
            try {
                openRead = FileOp.openRead(str);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (openRead.read(bArr) != -1) {
                        cVar.write(bArr);
                    }
                    try {
                        cVar.flush();
                        cVar.close();
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (Throwable e3) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3, "", new Object[0]);
                                return null;
                            }
                        }
                        return substring;
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32, "", new Object[0]);
                        return null;
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    try {
                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", new Object[]{e2.getMessage()});
                        if (cVar != null) {
                            try {
                                cVar.flush();
                                cVar.close();
                            } catch (Throwable e322) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322, "", new Object[0]);
                                return null;
                            }
                        }
                        if (openRead != null) {
                            return null;
                        }
                        try {
                            openRead.close();
                            return null;
                        } catch (Throwable e3222) {
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3222, "", new Object[0]);
                            return null;
                        }
                    } catch (Throwable th) {
                        e3222 = th;
                        if (cVar != null) {
                            try {
                                cVar.flush();
                                cVar.close();
                            } catch (Throwable e32222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32222, "", new Object[0]);
                                return null;
                            }
                        }
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (Throwable e322222) {
                                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322222, "", new Object[0]);
                                return null;
                            }
                        }
                        throw e322222;
                    }
                }
            } catch (IOException e5) {
                e2 = e5;
                openRead = null;
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", new Object[]{e2.getMessage()});
                if (cVar != null) {
                    cVar.flush();
                    cVar.close();
                }
                if (openRead != null) {
                    return null;
                }
                openRead.close();
                return null;
            } catch (Throwable th2) {
                e322222 = th2;
                openRead = null;
                if (cVar != null) {
                    cVar.flush();
                    cVar.close();
                }
                if (openRead != null) {
                    openRead.close();
                }
                throw e322222;
            }
        } catch (IOException e6) {
            e2 = e6;
            openRead = null;
            cVar = null;
            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", new Object[]{e2.getMessage()});
            if (cVar != null) {
                cVar.flush();
                cVar.close();
            }
            if (openRead != null) {
                return null;
            }
            openRead.close();
            return null;
        } catch (Throwable th3) {
            e322222 = th3;
            openRead = null;
            cVar = null;
            if (cVar != null) {
                cVar.flush();
                cVar.close();
            }
            if (openRead != null) {
                openRead.close();
            }
            throw e322222;
        }
    }

    private String cs(long j) {
        String str = "";
        ar.Hg();
        cf dH = c.Fa().dH(j);
        if (dH.field_msgId == 0) {
            return "";
        }
        int type = dH.getType();
        String str2 = dH.field_content;
        if (dH.aNc()) {
            g$a fT = g$a.fT(str2);
            if (fT != null && (fT.type == 6 || fT.type == 2)) {
                com.tencent.mm.pluginsdk.model.app.b Rz = an.aqd().Rz(fT.fny);
                if (Rz != null) {
                    return Rz.field_fileFullPath;
                }
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                return str;
            } else if (fT == null) {
                return str;
            } else {
                if (fT.type != 3 && fT.type != 5) {
                    return str;
                }
                this.lLU = true;
                return str;
            }
        } else if (type == 3) {
            com.tencent.mm.aq.e n = o.Pw().n(dH);
            if (n == null) {
                return str;
            }
            str = o.Pw().lm(n.hzQ);
            if (bh.ov(str)) {
                return o.Pw().lm(n.hzS);
            }
            return str;
        } else if (type == 62) {
            com.tencent.mm.modelvideo.o.TU();
            return s.nt(dH.field_imgPath);
        } else if (type != 48) {
            return str;
        } else {
            this.lLU = true;
            return str;
        }
    }

    static void cm(String str, String str2) {
        com.tencent.mm.sdk.b.b ebVar = new eb();
        ebVar.fsI.fsK = str2;
        ebVar.fsI.ffq = str;
        com.tencent.mm.sdk.b.a.xef.m(ebVar);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
        } else if (kVar instanceof n) {
            n nVar = (n) kVar;
            if (i == 0 && i2 == 0) {
                bol com_tencent_mm_protocal_c_bol = (nVar.gJQ == null || nVar.gJQ.hmh.hmo == null) ? null : (bol) nVar.gJQ.hmh.hmo;
                String str2 = com_tencent_mm_protocal_c_bol.wQT;
                if (1 == nVar.lNc) {
                    cm(nVar.ffq, this.lLZ);
                    return;
                }
                String str3 = nVar.ffq;
                String str4 = (String) this.lMj.get(str3);
                cm(str3, this.lMb);
                String cs = (!this.lLV || this.lLW == null) ? cs(this.gAc) : this.lLX;
                if (str4 == null || str4.length() == 0) {
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
                    cm(str3, this.lMa);
                    return;
                }
                if (!this.lLT) {
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
                    Java2CExDevice.stopScanWCLanDevice();
                    this.lLT = true;
                }
                if (!(this.lMl.containsKey(str3) && ((Boolean) this.lMl.get(str3)).booleanValue())) {
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: " + str4);
                    if (Java2CExDevice.connectWCLanDevice(str4.getBytes(), true) != 0) {
                        cm(str3, this.lMa);
                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
                    }
                }
                int useWCLanDeviceService;
                if (this.lLU) {
                    useWCLanDeviceService = Java2CExDevice.useWCLanDeviceService(str4.getBytes(), str2.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.lMv.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.lMk.put(str3, Integer.valueOf(useWCLanDeviceService));
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: " + useWCLanDeviceService);
                        return;
                    }
                    cm(str3, this.lMa);
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
                    return;
                } else if (cs == null || cs.length() == 0) {
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
                    cm(str3, this.lMa);
                    return;
                } else {
                    useWCLanDeviceService = Java2CExDevice.sendFileToWCLanDevice(str4.getBytes(), str2.getBytes(), cs.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.lMv.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.lMk.put(str3, Integer.valueOf(useWCLanDeviceService));
                        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =" + useWCLanDeviceService);
                        return;
                    }
                    cm(str3, this.lMa);
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
                    return;
                }
            }
            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            cm(nVar.ffq, this.lMa);
        }
    }

    static String c(b bVar) {
        if (bVar == null) {
            return "";
        }
        String str = null;
        if (!bh.ov(bVar.gfN)) {
            str = bVar.gfN;
        } else if (!bh.ov(bVar.gfO)) {
            str = bVar.gfO;
        } else if (bVar.field_mac != 0) {
            str = com.tencent.mm.plugin.exdevice.j.b.cK(bVar.field_mac);
        } else if (!bh.ov(bVar.field_deviceID)) {
            str = bVar.field_deviceID;
        }
        return bh.ou(str);
    }
}
