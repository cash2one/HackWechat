package com.tencent.mm.ad;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.a.f;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ald;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class c implements e {
    boolean hkG = false;
    Set<String> hkH = new HashSet();
    f<String, c> hkI = new f(400);
    Stack<h> hkJ = new Stack();
    private as hkK = null;
    private as hkL = null;
    String hkM = null;
    f<String, String> hkN = new f(200);
    ak hkO = new ak(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ak.a(this) {
        final /* synthetic */ c hkP;
        private long hkQ = 0;

        {
            this.hkP = r3;
        }

        public final boolean uF() {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.hkP.hkG && currentTimeMillis - this.hkQ > 60000) {
                x.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", Long.valueOf(currentTimeMillis - this.hkQ));
                this.hkP.hkG = false;
            }
            if (this.hkP.hkG) {
                this.hkP.hkO.J(1000, 1000);
                return false;
            }
            this.hkQ = currentTimeMillis;
            this.hkP.hkG = true;
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < 5 && this.hkP.hkJ.size() > 0; i++) {
                g.pQN.a(138, 42, 1, true);
                linkedList.add(new bdo().UA(((h) this.hkP.hkJ.pop()).getUsername()));
            }
            com.tencent.mm.kernel.g.CG().a(new j(linkedList), 0);
            g.pQN.a(138, 44, 1, true);
            return false;
        }
    }, false);

    private static class c {
        public long hhB;
        public int hkU;

        private c() {
            this.hhB = 0;
            this.hkU = 0;
        }
    }

    private class a implements com.tencent.mm.sdk.platformtools.as.a {
        final /* synthetic */ c hkP;
        public h hkR = null;
        public byte[] hkS = null;

        public a(c cVar, h hVar) {
            this.hkP = cVar;
            this.hkR = hVar;
        }

        public final boolean JB() {
            u uVar;
            ByteArrayOutputStream byteArrayOutputStream;
            InputStream inputStream;
            ProtocolException protocolException;
            g gVar;
            Object[] objArr;
            SocketTimeoutException socketTimeoutException;
            IOException iOException;
            Exception exception;
            if (this.hkR == null) {
                return false;
            }
            if (!an.isNetworkConnected(ac.getContext())) {
                x.w("MicroMsg.HttpGetAvatar", "[tomys] network is unavailable, skip rest loading logic.");
                x.cfk();
            }
            String JH = this.hkR.JH();
            String str = "";
            if (com.tencent.mm.kernel.g.Dh().Cy()) {
                r1 = new Object[4];
                com.tencent.mm.kernel.g.Dh();
                r1[1] = o.getString(com.tencent.mm.kernel.a.Cg());
                r1[2] = Integer.valueOf(an.getNetTypeForStat(ac.getContext()));
                r1[3] = Integer.valueOf(an.getStrength(ac.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r1);
            }
            x.d("MicroMsg.HttpGetAvatar", "dkreferer dkavatar user: %s referer: %s", this.hkR.getUsername(), str);
            this.hkS = null;
            u uVar2 = null;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            InputStream inputStream2 = null;
            g.pQN.a(138, 40, 1, true);
            try {
                uVar2 = com.tencent.mm.network.b.a(JH, null);
                try {
                    uVar2.setRequestMethod("GET");
                    uVar2.setRequestProperty("referer", str);
                    uVar2.setConnectTimeout(5000);
                    uVar2.setReadTimeout(5000);
                    if (com.tencent.mm.network.b.a(uVar2) != 0) {
                        int responseCode = uVar2.getResponseCode();
                        Map headerFields = uVar2.getHeaderFields();
                        List list = headerFields != null ? (List) headerFields.get("X-ErrNo") : null;
                        str = (list == null || list.size() <= 0) ? "" : (String) list.get(0);
                        x.e("MicroMsg.HttpGetAvatar", "checkHttpConnection failed! url:%s code:%d xErr:%s", JH, Integer.valueOf(responseCode), str);
                        switch (responseCode) {
                            case TencentLocation.ERROR_UNKNOWN /*404*/:
                                g.pQN.a(138, 2, 1, true);
                                g.pQN.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hkR.getUsername(), uVar2.iav, Integer.valueOf(uVar2.hZy), uVar2.url.getHost(), JH, str);
                                break;
                            case 502:
                                g.pQN.a(138, 3, 1, true);
                                g.pQN.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hkR.getUsername(), uVar2.iav, Integer.valueOf(uVar2.hZy), uVar2.url.getHost(), JH, str);
                                break;
                            case 503:
                                g.pQN.a(138, 4, 1, true);
                                g.pQN.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hkR.getUsername(), uVar2.iav, Integer.valueOf(uVar2.hZy), uVar2.url.getHost(), JH, str);
                                break;
                            case 504:
                                g.pQN.a(138, 5, 1, true);
                                g.pQN.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hkR.getUsername(), uVar2.iav, Integer.valueOf(uVar2.hZy), uVar2.url.getHost(), JH, str);
                                break;
                            default:
                                g.pQN.a(138, 6, 1, true);
                                g.pQN.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hkR.getUsername(), uVar2.iav, Integer.valueOf(uVar2.hZy), uVar2.url.getHost(), JH, str);
                                break;
                        }
                        return true;
                    }
                    int contentLength = uVar2.aBw.getContentLength();
                    inputStream2 = uVar2.getInputStream();
                    if (inputStream2 == null) {
                        try {
                            x.d("MicroMsg.HttpGetAvatar", "getInputStream failed. url:%s", JH);
                            return true;
                        } catch (ProtocolException e) {
                            uVar = uVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            protocolException = e;
                            g.pQN.a(138, 1, 1, true);
                            gVar = g.pQN;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10001);
                            objArr[2] = protocolException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hkR.getUsername();
                            if (uVar != null) {
                                str = uVar.iav;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                            objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                            objArr[8] = JH;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                            if (uVar != null) {
                                try {
                                    uVar.aBw.disconnect();
                                } catch (Throwable e2) {
                                    x.e("MicroMsg.HttpGetAvatar", "exception:%s", bh.i(e2));
                                    x.e("MicroMsg.HttpGetAvatar", "close conn failed : %s", e2.getMessage());
                                    g.pQN.a(138, 9, 1, true);
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (SocketTimeoutException e3) {
                            uVar = uVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            socketTimeoutException = e3;
                            g.pQN.a(138, 8, 1, true);
                            gVar = g.pQN;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10002);
                            objArr[2] = socketTimeoutException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hkR.getUsername();
                            if (uVar != null) {
                                str = uVar.iav;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                            objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                            objArr[8] = JH;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (IOException e4) {
                            uVar = uVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            iOException = e4;
                            g.pQN.a(138, 7, 1, true);
                            gVar = g.pQN;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10003);
                            objArr[2] = iOException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hkR.getUsername();
                            if (uVar != null) {
                                str = uVar.iav;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                            objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                            objArr[8] = JH;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, iOException.getClass().getSimpleName(), iOException.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (Exception e5) {
                            uVar = uVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            exception = e5;
                            g.pQN.a(138, 0, 1, true);
                            gVar = g.pQN;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10003);
                            objArr[2] = exception.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hkR.getUsername();
                            if (uVar != null) {
                                str = uVar.iav;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            if (uVar != null) {
                                str = Integer.valueOf(uVar.hZy);
                            } else {
                                str = "null";
                            }
                            objArr[6] = str;
                            if (uVar != null) {
                                str = uVar.url.getHost();
                            } else {
                                str = "null";
                            }
                            objArr[7] = str;
                            objArr[8] = JH;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, exception.getClass().getSimpleName(), exception.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        }
                    }
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    g.pQN.a(138, 41, 1, true);
                    if (com.tencent.mm.sdk.a.b.ceK()) {
                        g.pQN.h(14058, Integer.valueOf(100001), Integer.valueOf(HardCoderJNI.sHCENCODEVIDEOTIMEOUT), "", Integer.valueOf(contentLength), this.hkR.getUsername(), uVar2.iav, Integer.valueOf(uVar2.hZy), uVar2.url.getHost(), JH, "");
                    }
                    this.hkS = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.close();
                    try {
                        uVar2.aBw.disconnect();
                        try {
                            inputStream2.close();
                            if (contentLength > 0) {
                                try {
                                    if (this.hkS.length < contentLength) {
                                        g.pQN.a(138, 15, 1, true);
                                        x.e("MicroMsg.HttpGetAvatar", "HTTP downloaded length is smaller than Content-Length field. Drop.");
                                    }
                                } catch (ProtocolException e6) {
                                    uVar = null;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                    protocolException = e6;
                                    g.pQN.a(138, 1, 1, true);
                                    gVar = g.pQN;
                                    objArr = new Object[10];
                                    objArr[0] = Integer.valueOf(100001);
                                    objArr[1] = Integer.valueOf(10001);
                                    objArr[2] = protocolException.getMessage();
                                    objArr[3] = Integer.valueOf(0);
                                    objArr[4] = this.hkR.getUsername();
                                    if (uVar != null) {
                                        str = "null";
                                    } else {
                                        str = uVar.iav;
                                    }
                                    objArr[5] = str;
                                    if (uVar != null) {
                                    }
                                    objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                                    if (uVar != null) {
                                    }
                                    objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                                    objArr[8] = JH;
                                    objArr[9] = "";
                                    gVar.h(14058, objArr);
                                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                                    if (uVar != null) {
                                        uVar.aBw.disconnect();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    return true;
                                } catch (SocketTimeoutException e32) {
                                    uVar = null;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                    socketTimeoutException = e32;
                                    g.pQN.a(138, 8, 1, true);
                                    gVar = g.pQN;
                                    objArr = new Object[10];
                                    objArr[0] = Integer.valueOf(100001);
                                    objArr[1] = Integer.valueOf(10002);
                                    objArr[2] = socketTimeoutException.getMessage();
                                    objArr[3] = Integer.valueOf(0);
                                    objArr[4] = this.hkR.getUsername();
                                    if (uVar != null) {
                                        str = "null";
                                    } else {
                                        str = uVar.iav;
                                    }
                                    objArr[5] = str;
                                    if (uVar != null) {
                                    }
                                    objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                                    if (uVar != null) {
                                    }
                                    objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                                    objArr[8] = JH;
                                    objArr[9] = "";
                                    gVar.h(14058, objArr);
                                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                                    if (uVar != null) {
                                        uVar.aBw.disconnect();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    return true;
                                } catch (IOException e42) {
                                    uVar = null;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                    iOException = e42;
                                    g.pQN.a(138, 7, 1, true);
                                    gVar = g.pQN;
                                    objArr = new Object[10];
                                    objArr[0] = Integer.valueOf(100001);
                                    objArr[1] = Integer.valueOf(10003);
                                    objArr[2] = iOException.getMessage();
                                    objArr[3] = Integer.valueOf(0);
                                    objArr[4] = this.hkR.getUsername();
                                    if (uVar != null) {
                                        str = "null";
                                    } else {
                                        str = uVar.iav;
                                    }
                                    objArr[5] = str;
                                    if (uVar != null) {
                                    }
                                    objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                                    if (uVar != null) {
                                    }
                                    objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                                    objArr[8] = JH;
                                    objArr[9] = "";
                                    gVar.h(14058, objArr);
                                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, iOException.getClass().getSimpleName(), iOException.getMessage());
                                    if (uVar != null) {
                                        uVar.aBw.disconnect();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    return true;
                                } catch (Exception e52) {
                                    uVar = null;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                    exception = e52;
                                    g.pQN.a(138, 0, 1, true);
                                    gVar = g.pQN;
                                    objArr = new Object[10];
                                    objArr[0] = Integer.valueOf(100001);
                                    objArr[1] = Integer.valueOf(10003);
                                    objArr[2] = exception.getMessage();
                                    objArr[3] = Integer.valueOf(0);
                                    objArr[4] = this.hkR.getUsername();
                                    if (uVar != null) {
                                        str = "null";
                                    } else {
                                        str = uVar.iav;
                                    }
                                    objArr[5] = str;
                                    if (uVar != null) {
                                        str = "null";
                                    } else {
                                        str = Integer.valueOf(uVar.hZy);
                                    }
                                    objArr[6] = str;
                                    if (uVar != null) {
                                        str = "null";
                                    } else {
                                        str = uVar.url.getHost();
                                    }
                                    objArr[7] = str;
                                    objArr[8] = JH;
                                    objArr[9] = "";
                                    gVar.h(14058, objArr);
                                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, exception.getClass().getSimpleName(), exception.getMessage());
                                    if (uVar != null) {
                                        uVar.aBw.disconnect();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    return true;
                                }
                            }
                            uVar = null;
                            byteArrayOutputStream = null;
                            inputStream = null;
                        } catch (ProtocolException e62) {
                            uVar = null;
                            byteArrayOutputStream = null;
                            inputStream = inputStream2;
                            protocolException = e62;
                            g.pQN.a(138, 1, 1, true);
                            gVar = g.pQN;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10001);
                            objArr[2] = protocolException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hkR.getUsername();
                            if (uVar != null) {
                                str = uVar.iav;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            if (uVar != null) {
                            }
                            objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                            if (uVar != null) {
                            }
                            objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                            objArr[8] = JH;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (SocketTimeoutException e322) {
                            uVar = null;
                            byteArrayOutputStream = null;
                            inputStream = inputStream2;
                            socketTimeoutException = e322;
                            g.pQN.a(138, 8, 1, true);
                            gVar = g.pQN;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10002);
                            objArr[2] = socketTimeoutException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hkR.getUsername();
                            if (uVar != null) {
                                str = uVar.iav;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            if (uVar != null) {
                            }
                            objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                            if (uVar != null) {
                            }
                            objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                            objArr[8] = JH;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (IOException e422) {
                            uVar = null;
                            byteArrayOutputStream = null;
                            inputStream = inputStream2;
                            iOException = e422;
                            g.pQN.a(138, 7, 1, true);
                            gVar = g.pQN;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10003);
                            objArr[2] = iOException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hkR.getUsername();
                            if (uVar != null) {
                                str = uVar.iav;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            if (uVar != null) {
                            }
                            objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                            if (uVar != null) {
                            }
                            objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                            objArr[8] = JH;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, iOException.getClass().getSimpleName(), iOException.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (Exception e522) {
                            uVar = null;
                            byteArrayOutputStream = null;
                            inputStream = inputStream2;
                            exception = e522;
                            g.pQN.a(138, 0, 1, true);
                            gVar = g.pQN;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10003);
                            objArr[2] = exception.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hkR.getUsername();
                            if (uVar != null) {
                                str = uVar.iav;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            if (uVar != null) {
                                str = Integer.valueOf(uVar.hZy);
                            } else {
                                str = "null";
                            }
                            objArr[6] = str;
                            if (uVar != null) {
                                str = uVar.url.getHost();
                            } else {
                                str = "null";
                            }
                            objArr[7] = str;
                            objArr[8] = JH;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, exception.getClass().getSimpleName(), exception.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        }
                    } catch (ProtocolException e622) {
                        uVar = uVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        protocolException = e622;
                        g.pQN.a(138, 1, 1, true);
                        gVar = g.pQN;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10001);
                        objArr[2] = protocolException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hkR.getUsername();
                        if (uVar != null) {
                            str = uVar.iav;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (uVar != null) {
                        }
                        objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                        if (uVar != null) {
                        }
                        objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                        objArr[8] = JH;
                        objArr[9] = "";
                        gVar.h(14058, objArr);
                        x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (SocketTimeoutException e3222) {
                        uVar = uVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        socketTimeoutException = e3222;
                        g.pQN.a(138, 8, 1, true);
                        gVar = g.pQN;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10002);
                        objArr[2] = socketTimeoutException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hkR.getUsername();
                        if (uVar != null) {
                            str = uVar.iav;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (uVar != null) {
                        }
                        objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                        if (uVar != null) {
                        }
                        objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                        objArr[8] = JH;
                        objArr[9] = "";
                        gVar.h(14058, objArr);
                        x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (IOException e4222) {
                        uVar = uVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        iOException = e4222;
                        g.pQN.a(138, 7, 1, true);
                        gVar = g.pQN;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10003);
                        objArr[2] = iOException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hkR.getUsername();
                        if (uVar != null) {
                            str = uVar.iav;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (uVar != null) {
                        }
                        objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                        if (uVar != null) {
                        }
                        objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                        objArr[8] = JH;
                        objArr[9] = "";
                        gVar.h(14058, objArr);
                        x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, iOException.getClass().getSimpleName(), iOException.getMessage());
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (Exception e5222) {
                        uVar = uVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        exception = e5222;
                        g.pQN.a(138, 0, 1, true);
                        gVar = g.pQN;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10003);
                        objArr[2] = exception.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hkR.getUsername();
                        if (uVar != null) {
                            str = uVar.iav;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (uVar != null) {
                            str = Integer.valueOf(uVar.hZy);
                        } else {
                            str = "null";
                        }
                        objArr[6] = str;
                        if (uVar != null) {
                            str = uVar.url.getHost();
                        } else {
                            str = "null";
                        }
                        objArr[7] = str;
                        objArr[8] = JH;
                        objArr[9] = "";
                        gVar.h(14058, objArr);
                        x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, exception.getClass().getSimpleName(), exception.getMessage());
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    }
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (ProtocolException e6222) {
                    uVar = uVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    protocolException = e6222;
                    g.pQN.a(138, 1, 1, true);
                    gVar = g.pQN;
                    objArr = new Object[10];
                    objArr[0] = Integer.valueOf(100001);
                    objArr[1] = Integer.valueOf(10001);
                    objArr[2] = protocolException.getMessage();
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = this.hkR.getUsername();
                    if (uVar != null) {
                        str = "null";
                    } else {
                        str = uVar.iav;
                    }
                    objArr[5] = str;
                    if (uVar != null) {
                    }
                    objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                    if (uVar != null) {
                    }
                    objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                    objArr[8] = JH;
                    objArr[9] = "";
                    gVar.h(14058, objArr);
                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (SocketTimeoutException e32222) {
                    uVar = uVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    socketTimeoutException = e32222;
                    g.pQN.a(138, 8, 1, true);
                    gVar = g.pQN;
                    objArr = new Object[10];
                    objArr[0] = Integer.valueOf(100001);
                    objArr[1] = Integer.valueOf(10002);
                    objArr[2] = socketTimeoutException.getMessage();
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = this.hkR.getUsername();
                    if (uVar != null) {
                        str = "null";
                    } else {
                        str = uVar.iav;
                    }
                    objArr[5] = str;
                    if (uVar != null) {
                    }
                    objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                    if (uVar != null) {
                    }
                    objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                    objArr[8] = JH;
                    objArr[9] = "";
                    gVar.h(14058, objArr);
                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (IOException e42222) {
                    uVar = uVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    iOException = e42222;
                    g.pQN.a(138, 7, 1, true);
                    gVar = g.pQN;
                    objArr = new Object[10];
                    objArr[0] = Integer.valueOf(100001);
                    objArr[1] = Integer.valueOf(10003);
                    objArr[2] = iOException.getMessage();
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = this.hkR.getUsername();
                    if (uVar != null) {
                        str = "null";
                    } else {
                        str = uVar.iav;
                    }
                    objArr[5] = str;
                    if (uVar != null) {
                    }
                    objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                    if (uVar != null) {
                    }
                    objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                    objArr[8] = JH;
                    objArr[9] = "";
                    gVar.h(14058, objArr);
                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, iOException.getClass().getSimpleName(), iOException.getMessage());
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (Exception e52222) {
                    uVar = uVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    exception = e52222;
                    g.pQN.a(138, 0, 1, true);
                    gVar = g.pQN;
                    objArr = new Object[10];
                    objArr[0] = Integer.valueOf(100001);
                    objArr[1] = Integer.valueOf(10003);
                    objArr[2] = exception.getMessage();
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = this.hkR.getUsername();
                    if (uVar != null) {
                        str = "null";
                    } else {
                        str = uVar.iav;
                    }
                    objArr[5] = str;
                    if (uVar != null) {
                        str = "null";
                    } else {
                        str = Integer.valueOf(uVar.hZy);
                    }
                    objArr[6] = str;
                    if (uVar != null) {
                        str = "null";
                    } else {
                        str = uVar.url.getHost();
                    }
                    objArr[7] = str;
                    objArr[8] = JH;
                    objArr[9] = "";
                    gVar.h(14058, objArr);
                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, exception.getClass().getSimpleName(), exception.getMessage());
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                }
            } catch (ProtocolException e62222) {
                uVar = uVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                protocolException = e62222;
                g.pQN.a(138, 1, 1, true);
                gVar = g.pQN;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10001);
                objArr[2] = protocolException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.hkR.getUsername();
                if (uVar != null) {
                    str = "null";
                } else {
                    str = uVar.iav;
                }
                objArr[5] = str;
                if (uVar != null) {
                }
                objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                if (uVar != null) {
                }
                objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                objArr[8] = JH;
                objArr[9] = "";
                gVar.h(14058, objArr);
                x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (SocketTimeoutException e322222) {
                uVar = uVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                socketTimeoutException = e322222;
                g.pQN.a(138, 8, 1, true);
                gVar = g.pQN;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10002);
                objArr[2] = socketTimeoutException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.hkR.getUsername();
                if (uVar != null) {
                    str = "null";
                } else {
                    str = uVar.iav;
                }
                objArr[5] = str;
                if (uVar != null) {
                }
                objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                if (uVar != null) {
                }
                objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                objArr[8] = JH;
                objArr[9] = "";
                gVar.h(14058, objArr);
                x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (IOException e422222) {
                uVar = uVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                iOException = e422222;
                g.pQN.a(138, 7, 1, true);
                gVar = g.pQN;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = iOException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.hkR.getUsername();
                if (uVar != null) {
                    str = "null";
                } else {
                    str = uVar.iav;
                }
                objArr[5] = str;
                if (uVar != null) {
                }
                objArr[6] = uVar != null ? Integer.valueOf(uVar.hZy) : "null";
                if (uVar != null) {
                }
                objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                objArr[8] = JH;
                objArr[9] = "";
                gVar.h(14058, objArr);
                x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, iOException.getClass().getSimpleName(), iOException.getMessage());
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (Exception e522222) {
                uVar = uVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                exception = e522222;
                g.pQN.a(138, 0, 1, true);
                gVar = g.pQN;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = exception.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.hkR.getUsername();
                if (uVar != null) {
                    str = "null";
                } else {
                    str = uVar.iav;
                }
                objArr[5] = str;
                if (uVar != null) {
                    str = "null";
                } else {
                    str = Integer.valueOf(uVar.hZy);
                }
                objArr[6] = str;
                if (uVar != null) {
                    str = "null";
                } else {
                    str = uVar.url.getHost();
                }
                objArr[7] = str;
                objArr[8] = JH;
                objArr[9] = "";
                gVar.h(14058, objArr);
                x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JH, exception.getClass().getSimpleName(), exception.getMessage());
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            }
        }

        public final boolean JC() {
            if (!(this.hkR == null || bh.ov(this.hkR.getUsername()))) {
                if (bh.bw(this.hkS)) {
                    this.hkP.hkH.remove(this.hkR.getUsername());
                    g.pQN.a(138, 10, 1, true);
                } else {
                    if (com.tencent.mm.z.ak.a.hfM != null) {
                        com.tencent.mm.z.ak.a.hfM.aV(this.hkS.length, 0);
                    }
                    this.hkP.a(new d(this.hkP, this.hkR, this.hkS));
                }
            }
            return false;
        }
    }

    private class b implements com.tencent.mm.sdk.platformtools.as.a {
        final /* synthetic */ c hkP;
        Bitmap hkT = null;
        String username = null;

        public b(c cVar, String str) {
            this.hkP = cVar;
            this.username = str;
        }

        public final boolean JB() {
            h hVar = null;
            int i = 0;
            if (bh.ov(this.username)) {
                return false;
            }
            String str = this.username;
            if (str == null ? false : str.startsWith("ammURL_")) {
                String str2 = (String) this.hkP.hkN.get(str);
                if (!bh.ov(str2)) {
                    h jm = n.JQ().jm(str);
                    if (jm == null || !str.equals(jm.getUsername())) {
                        Cursor a = n.JQ().hhp.a("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bh.ot(str2) + "\"", null, 2);
                        if (a != null) {
                            if (a.moveToFirst()) {
                                a.moveToFirst();
                                hVar = new h();
                                hVar.b(a);
                            }
                            a.close();
                        }
                        if (!(hVar == null || bh.ov(hVar.getUsername()))) {
                            FileOp.x(b.iW(hVar.getUsername()), b.iW(str));
                        }
                        hVar = new h();
                        hVar.username = str;
                        hVar.fWe = 3;
                        hVar.hlx = str2;
                        hVar.hly = str2;
                        hVar.fDt = 3;
                        hVar.bA(true);
                        hVar.fDt = 31;
                        n.JQ().a(hVar);
                    }
                }
            }
            d Jz = c.Jz();
            if (Jz == null) {
                return false;
            }
            if (d.hkY.containsKey(this.username)) {
                i = ((Integer) d.hkY.get(this.username)).intValue();
            }
            if (i != 0) {
                n.JP();
                Context context = n.getContext();
                if (context != null) {
                    Jz.e(this.username, com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), i));
                }
            }
            this.hkT = d.jd(this.username);
            return true;
        }

        public final boolean JC() {
            if (this.hkT == null) {
                h hVar;
                c cVar = this.hkP;
                String str = this.username;
                x.d("MicroMsg.AvatarService", "avatar service push: %s", str);
                if (bh.ov(str)) {
                    hVar = null;
                } else if (str.equals(cVar.hkM + "@bottle") && !bh.a((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(60, null), false)) {
                    hVar = null;
                } else if (!str.equals(cVar.hkM) || bh.a((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(59, null), false)) {
                    long Wo = bh.Wo();
                    c cVar2 = (c) cVar.hkI.get(str);
                    if (cVar2 == null || cVar2.hkU < 5 || Wo - cVar2.hhB >= 600) {
                        h ja = c.ja(str);
                        if (ja == null) {
                            x.w("MicroMsg.AvatarService", "checkUser block local no need: %s", str);
                            cVar2 = new c();
                            cVar2.hkU = 5;
                            cVar2.hhB = Wo;
                            cVar.hkI.l(str, cVar2);
                            hVar = null;
                        } else {
                            if (cVar2 == null || Wo - cVar2.hhB > 600) {
                                x.d("MicroMsg.AvatarService", "new user: %s", str);
                                cVar2 = new c();
                                cVar2.hkU = 1;
                                cVar2.hhB = Wo;
                                cVar.hkI.l(str, cVar2);
                            } else if (cVar2.hkU < 5) {
                                x.d("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", str, Integer.valueOf(cVar2.hkU), Long.valueOf(Wo - cVar2.hhB));
                                cVar2.hkU++;
                                cVar2.hhB = Wo;
                                cVar.hkI.l(str, cVar2);
                            }
                            hVar = ja;
                        }
                    } else {
                        x.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", str);
                        hVar = null;
                    }
                } else {
                    hVar = null;
                }
                if (hVar == null) {
                    cVar.hkH.remove(str);
                } else if (bh.ov(hVar.JH())) {
                    x.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(hVar.fWe));
                    if (4 == hVar.fWe) {
                        x.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
                    } else {
                        cVar.hkJ.push(hVar);
                        if (cVar.hkJ.size() > 5) {
                            cVar.hkO.J(0, 0);
                        } else {
                            cVar.hkO.J(1000, 1000);
                        }
                    }
                } else {
                    cVar.a(new a(cVar, hVar));
                }
                return false;
            }
            d Jz = c.Jz();
            if (Jz != null) {
                Jz.d(this.username, this.hkT);
            }
            this.hkP.hkH.remove(this.username);
            return false;
        }
    }

    private class d implements com.tencent.mm.sdk.platformtools.as.a {
        Bitmap bitmap = null;
        byte[] buf;
        final /* synthetic */ c hkP;
        h hkV = null;

        public d(c cVar, h hVar, byte[] bArr) {
            this.hkP = cVar;
            this.hkV = hVar;
            this.buf = bArr;
        }

        public final boolean JB() {
            if (this.hkV == null || bh.ov(this.hkV.getUsername())) {
                x.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
                g.pQN.a(138, 13, 1, true);
                return false;
            }
            if (c.Jz() != null) {
                this.bitmap = d.e(this.hkV.getUsername(), this.buf);
                if (this.bitmap == null) {
                    g.pQN.a(138, 14, 1, true);
                }
            }
            i JA = c.JA();
            if (JA == null) {
                return true;
            }
            this.hkV.fDt = -1;
            this.hkV.JI();
            JA.a(this.hkV);
            return true;
        }

        public final boolean JC() {
            if (!bh.ov(this.hkV.getUsername())) {
                d Jz = c.Jz();
                if (!(Jz == null || this.bitmap == null)) {
                    Jz.d(this.hkV.getUsername(), this.bitmap);
                }
                this.hkP.hkH.remove(this.hkV.getUsername());
            }
            return false;
        }
    }

    static /* synthetic */ i JA() {
        return com.tencent.mm.kernel.g.Dh().Cy() ? n.JQ() : null;
    }

    public c() {
        com.tencent.mm.kernel.g.CG().a(123, (e) this);
        this.hkG = false;
        this.hkM = q.FS();
    }

    public final Bitmap b(String str, boolean z, int i) {
        Bitmap bitmap;
        d Jz = Jz();
        if (Jz != null) {
            if (i < 0 || i <= 5) {
                bitmap = null;
            } else {
                bitmap = d.jc(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}));
                if (bitmap != null) {
                    x.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", Integer.valueOf(i));
                    return bitmap;
                }
                x.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", Integer.valueOf(i));
            }
            if (bitmap == null) {
                bitmap = d.jc(str);
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            if (i < 0 || i <= 5) {
                return bitmap;
            }
            x.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", Integer.valueOf(i));
            bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, (float) i);
            Jz.d(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}), bitmap);
            return bitmap;
        } else if (z) {
            return null;
        } else {
            x.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", str);
            if (this.hkH.contains(str)) {
                return null;
            }
            this.hkH.add(str);
            a(new b(this, str));
            return null;
        }
    }

    public final void iY(String str) {
        a(new b(this, str));
    }

    public final void iZ(final String str) {
        com.tencent.mm.kernel.g.Dm().F(new Runnable(this) {
            final /* synthetic */ c hkP;

            public final void run() {
                if (!bh.ov(str) && !str.equals(this.hkP.hkM)) {
                    i JA = c.JA();
                    if (JA != null) {
                        h jm = JA.jm(str);
                        if (jm != null && jm.getUsername().equals(str)) {
                            boolean z;
                            if (bh.Wo() - (((long) jm.hlA) * 60) > 86400) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                return;
                            }
                            if (bh.ov(jm.JH())) {
                                x.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", str);
                            } else if (c.Jz() != null) {
                                d.y(str, false);
                                d.y(str, true);
                                this.hkP.iY(str);
                            }
                        }
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|checkAvatarExpire";
            }
        });
    }

    static h ja(String str) {
        h jm = n.JQ().jm(str);
        if (jm != null && jm.getUsername().equals(str)) {
            return jm;
        }
        af WO = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WO(str);
        if (WO == null || !WO.field_username.equals(str)) {
            boolean z;
            String str2 = "MicroMsg.AvatarService";
            String str3 = "ct == null? :%s";
            Object[] objArr = new Object[2];
            if (WO == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            x.d(str2, str3, objArr);
            return null;
        } else if (WO.fWe == 4) {
            b.I(str, WO.fWe);
            x.d("MicroMsg.AvatarService", "ct imgFlag :%s", Integer.valueOf(WO.fWe));
            return null;
        } else {
            jm = new h();
            jm.username = str;
            jm.fWe = 3;
            byte[] WS = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WS(str);
            if (bh.bw(WS)) {
                return jm;
            }
            h a;
            try {
                a = b.a(str, (arp) new arp().aF(WS));
            } catch (Throwable e) {
                x.e("MicroMsg.AvatarService", "exception:%s", bh.i(e));
                a = jm;
            }
            return a;
        }
    }

    public final void cancel() {
        while (this.hkJ.size() > 0) {
            this.hkH.remove(this.hkJ.pop());
        }
    }

    final int a(com.tencent.mm.sdk.platformtools.as.a aVar) {
        if (aVar instanceof a) {
            if (this.hkK == null) {
                this.hkK = new as(1, "getavatar", 2, com.tencent.mm.kernel.g.Dm().oAt.getLooper());
            }
            return this.hkK.c(aVar);
        }
        if (this.hkL == null) {
            this.hkL = new as(1, "readsave", 1, com.tencent.mm.kernel.g.Dm().oAt.getLooper());
        }
        return this.hkL.c(aVar);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 123) {
            if (!(i == 0 && i2 == 0)) {
                g.pQN.a(138, 12, 1, true);
            }
            g.pQN.a(138, 45, 1, true);
            j jVar = (j) kVar;
            Set hashSet = new HashSet();
            if (jVar.hlD != null) {
                Iterator it = jVar.hlD.iterator();
                while (it.hasNext()) {
                    ald com_tencent_mm_protocal_c_ald = (ald) it.next();
                    String str2 = com_tencent_mm_protocal_c_ald.wsr.wJF;
                    if (com_tencent_mm_protocal_c_ald.vHb == null || com_tencent_mm_protocal_c_ald.vHb.wJD == null || com_tencent_mm_protocal_c_ald.vHb.wJD.oz == null) {
                        g.pQN.a(138, 11, 1, true);
                    } else {
                        hashSet.add(str2);
                        h hVar = new h();
                        hVar.username = str2;
                        hVar.fWe = 3;
                        g.pQN.a(138, 43, 1, true);
                        a(new d(this, hVar, com_tencent_mm_protocal_c_ald.vHb.wJD.oz));
                    }
                }
            }
            if (jVar.hlC != null) {
                Iterator it2 = jVar.hlC.iterator();
                while (it2.hasNext()) {
                    String str3 = ((bdo) it2.next()).wJF;
                    if (!hashSet.contains(str3)) {
                        this.hkH.remove(str3);
                    }
                }
            }
            this.hkG = false;
            if (this.hkJ.size() > 0) {
                this.hkO.J(0, 0);
            }
        }
    }

    static d Jz() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            return n.Jz();
        }
        return null;
    }

    public final String jb(String str) {
        if (bh.ov(str)) {
            return "";
        }
        String format;
        try {
            format = String.format("%s%x_%s", new Object[]{"ammURL_", Integer.valueOf(str.hashCode()), str.substring(str.length() - 24, str.length() - 4)});
        } catch (Exception e) {
            format = String.format("%s%x_", new Object[]{"ammURL_", Integer.valueOf(str.hashCode())});
        }
        this.hkN.put(format, str);
        return format;
    }
}
