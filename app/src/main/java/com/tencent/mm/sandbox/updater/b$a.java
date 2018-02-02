package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.agx;
import com.tencent.mm.protocal.c.agy;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

class b$a extends AsyncTask<agx, Integer, agy> {
    private String host = null;
    private u ppY = null;
    final /* synthetic */ b xcA;
    private int xcB = 200;
    private PInt xcC = new PInt();
    private a xcx = null;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((agx[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        agy com_tencent_mm_protocal_c_agy = (agy) obj;
        x.d("MicroMsg.NetSceneGetUpdatePack", "onPostExecute, netRet=" + this.xcB + ", svrRet=" + this.xcC.value + ", result=" + com_tencent_mm_protocal_c_agy);
        this.xcx.a(this.xcB, this.xcC.value, com_tencent_mm_protocal_c_agy);
    }

    public b$a(b bVar, String str, a aVar) {
        this.xcA = bVar;
        this.host = str;
        this.xcx = aVar;
    }

    private agy a(agx... com_tencent_mm_protocal_c_agxArr) {
        Throwable e;
        InputStream inputStream;
        OutputStream outputStream;
        if (com_tencent_mm_protocal_c_agxArr.length == 0 || com_tencent_mm_protocal_c_agxArr[0] == null) {
            this.xcB = -1;
            return null;
        }
        x.d("MicroMsg.NetSceneGetUpdatePack", "doInBackground, params=" + com_tencent_mm_protocal_c_agxArr[0]);
        agx com_tencent_mm_protocal_c_agx = com_tencent_mm_protocal_c_agxArr[0];
        PByteArray pByteArray = new PByteArray();
        int i = 6;
        if (b.foreground) {
            i = 7;
        }
        try {
            MMProtocalJni.pack(com_tencent_mm_protocal_c_agx.toByteArray(), pByteArray, b.j(this.xcA), b.k(this.xcA), q.yF(), b.l(this.xcA), 113, 0, new byte[0], new byte[0], b.m(this.xcA), i);
            InputStream inputStream2 = null;
            OutputStream outputStream2;
            try {
                this.ppY = com.tencent.mm.network.b.a("http://" + this.host + "/cgi-bin/micromsg-bin/getupdatepack", null);
                this.ppY.setRequestMethod("POST");
                this.ppY.Vz();
                this.ppY.VA();
                this.ppY.setUseCaches(false);
                this.ppY.setRequestProperty("User-Agent", "Android QQMail HTTP Client");
                this.ppY.setRequestProperty("Connection", "Keep-Alive");
                this.ppY.setRequestProperty("Cache-Control", "no-cache");
                this.ppY.setRequestProperty("Content-Type", "application/octet-stream");
                this.ppY.setRequestProperty("accept", "*/*");
                this.ppY.setRequestProperty("Accept-Charset", "UTF-8");
                this.ppY.setConnectTimeout(15000);
                this.ppY.connect();
                outputStream2 = this.ppY.getOutputStream();
                try {
                    outputStream2.write(pByteArray.value);
                    outputStream2.flush();
                    this.xcx.fD(150 + ((long) pByteArray.value.length));
                    this.xcB = this.ppY.getResponseCode();
                    if (this.xcB != 200) {
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2, "", new Object[0]);
                            }
                        }
                        if (this.ppY != null) {
                            this.ppY.aBw.disconnect();
                            this.ppY = null;
                        }
                        return null;
                    }
                    Object obj;
                    InputStream inputStream3;
                    String headerField = this.ppY.getHeaderField("Content-Encoding");
                    InputStream inputStream4 = this.ppY.getInputStream();
                    long j = 150;
                    if (headerField == null || !headerField.contains("gzip")) {
                        obj = null;
                        inputStream3 = inputStream4;
                    } else {
                        inputStream3 = new GZIPInputStream(inputStream4);
                        obj = 1;
                    }
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            int read = inputStream3.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                            j += (long) read;
                        }
                        if (obj == null || !inputStream4.markSupported()) {
                            this.xcx.fE(j);
                        } else {
                            inputStream4.mark(1);
                            j = 150;
                            while (true) {
                                int read2 = inputStream4.read(bArr);
                                if (read2 <= 0) {
                                    break;
                                }
                                j += (long) read2;
                            }
                            this.xcx.fE(j);
                        }
                        PByteArray pByteArray2 = new PByteArray();
                        MMProtocalJni.unpack(pByteArray2, byteArrayOutputStream.toByteArray(), b.j(this.xcA), new PByteArray(), this.xcC, new PInt(), new PInt(0), new PInt(255));
                        agy com_tencent_mm_protocal_c_agy = (agy) new agy().aF(pByteArray2.value);
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Throwable e3) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3, "", new Object[0]);
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Throwable e32) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e32, "", new Object[0]);
                            }
                        }
                        if (this.ppY == null) {
                            return com_tencent_mm_protocal_c_agy;
                        }
                        this.ppY.aBw.disconnect();
                        this.ppY = null;
                        return com_tencent_mm_protocal_c_agy;
                    } catch (Exception e4) {
                        e2 = e4;
                        inputStream = inputStream3;
                        outputStream = outputStream2;
                        try {
                            x.e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", e2.getMessage());
                            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2, "", new Object[0]);
                            this.xcB = -1;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable e22) {
                                    x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e22, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e222) {
                                    x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e222, "", new Object[0]);
                                }
                            }
                            if (this.ppY != null) {
                                this.ppY.aBw.disconnect();
                                this.ppY = null;
                            }
                            return null;
                        } catch (Throwable th) {
                            e222 = th;
                            outputStream2 = outputStream;
                            inputStream2 = inputStream;
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (Throwable e322) {
                                    x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e322, "", new Object[0]);
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable e3222) {
                                    x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3222, "", new Object[0]);
                                }
                            }
                            if (this.ppY != null) {
                                this.ppY.aBw.disconnect();
                                this.ppY = null;
                            }
                            throw e222;
                        }
                    } catch (Throwable th2) {
                        e222 = th2;
                        inputStream2 = inputStream3;
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (this.ppY != null) {
                            this.ppY.aBw.disconnect();
                            this.ppY = null;
                        }
                        throw e222;
                    }
                } catch (Exception e5) {
                    e222 = e5;
                    inputStream = null;
                    outputStream = outputStream2;
                    x.e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", e222.getMessage());
                    x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e222, "", new Object[0]);
                    this.xcB = -1;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (this.ppY != null) {
                        this.ppY.aBw.disconnect();
                        this.ppY = null;
                    }
                    return null;
                } catch (Throwable th3) {
                    e222 = th3;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (this.ppY != null) {
                        this.ppY.aBw.disconnect();
                        this.ppY = null;
                    }
                    throw e222;
                }
            } catch (Exception e6) {
                e222 = e6;
                inputStream = null;
                outputStream = null;
                x.e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", e222.getMessage());
                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e222, "", new Object[0]);
                this.xcB = -1;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (this.ppY != null) {
                    this.ppY.aBw.disconnect();
                    this.ppY = null;
                }
                return null;
            } catch (Throwable th4) {
                e222 = th4;
                outputStream2 = null;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (this.ppY != null) {
                    this.ppY.aBw.disconnect();
                    this.ppY = null;
                }
                throw e222;
            }
        } catch (Throwable e2222) {
            x.e("MicroMsg.NetSceneGetUpdatePack", "Exception in MMProtocalJni.pack(), [%s]", e2222.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2222, "", new Object[0]);
            return null;
        }
    }

    protected final void onCancelled() {
        x.d("MicroMsg.NetSceneGetUpdatePack", "task had been cancelled.");
        if (this.ppY != null) {
            this.ppY.aBw.disconnect();
        }
    }
}
