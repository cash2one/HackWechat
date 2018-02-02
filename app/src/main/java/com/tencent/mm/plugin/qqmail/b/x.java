package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.qqmail.b.h.a;
import com.tencent.mm.plugin.qqmail.b.h.b;
import com.tencent.mm.plugin.qqmail.b.h.c;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public final class x extends h {
    private u ppY;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final c a(String str, String str2, b bVar, a aVar) {
        Throwable e;
        c cVar;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + bVar);
        OutputStream outputStream = null;
        InputStream inputStream = null;
        int i = 0;
        try {
            this.ppY = com.tencent.mm.network.b.a(b(str, str2, bVar.pow == 0 ? bVar.pox : null), null);
            this.ppY.setConnectTimeout(gKi);
            this.ppY.setRequestMethod(bVar.pow == 0 ? "GET" : "POST");
            this.ppY.Vz();
            this.ppY.VA();
            this.ppY.setUseCaches(false);
            this.ppY.setRequestProperty("User-Agent", aBs);
            this.ppY.setRequestProperty("Host", host);
            System.setProperty("http.keepAlive", "false");
            this.ppY.setRequestProperty("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.ppY.setRequestProperty("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
            this.ppY.setRequestProperty("Cookie", M(bVar.poy));
            this.ppY.connect();
            OutputStream outputStream2 = this.ppY.getOutputStream();
            int responseCode;
            try {
                Object obj;
                InputStream inputStream2;
                OutputStream outputStream3;
                String str3;
                StringBuilder stringBuilder;
                Object valueOf;
                Serializable serializable;
                byte[] bArr;
                int read;
                Map HI;
                c cVar2;
                if (bVar.pow == 1) {
                    a(bVar, outputStream2);
                }
                outputStream2.flush();
                responseCode = this.ppY.getResponseCode();
                String headerField = this.ppY.getHeaderField("set-cookie");
                String headerField2 = this.ppY.getHeaderField("Content-Encoding");
                String headerField3 = this.ppY.getHeaderField("Content-Disposition");
                if (headerField3 != null && headerField3.contains("attachment;")) {
                    if (str2.contains("download")) {
                        obj = 1;
                        inputStream2 = this.ppY.getInputStream();
                        if (headerField2 != null) {
                            try {
                                if (headerField2.contains("gzip")) {
                                    inputStream = new GZIPInputStream(inputStream2);
                                    outputStream3 = null;
                                    if (obj == null) {
                                        try {
                                            str3 = pov;
                                            stringBuilder = new StringBuilder();
                                            if (bVar.pox.get("default_attach_name") != null) {
                                                valueOf = Long.valueOf(System.currentTimeMillis());
                                            } else {
                                                serializable = (Serializable) bVar.pox.get("default_attach_name");
                                            }
                                            outputStream3 = new FileOutputStream(new File(str3, stringBuilder.append(valueOf).toString()), true);
                                        } catch (Throwable e2) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e2, "", new Object[0]);
                                            cVar = new c(responseCode == 0 ? 503 : 500, null, null);
                                            if (outputStream3 != null) {
                                                outputStream3.flush();
                                                outputStream3.close();
                                            }
                                            if (outputStream2 != null) {
                                                try {
                                                    outputStream2.close();
                                                } catch (Throwable e3) {
                                                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e3, "", new Object[0]);
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable e32) {
                                                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e32, "", new Object[0]);
                                                }
                                            }
                                            if (this.ppY == null) {
                                                return cVar;
                                            }
                                            this.ppY.aBw.disconnect();
                                            return cVar;
                                        } catch (Throwable th) {
                                            if (outputStream3 != null) {
                                                outputStream3.flush();
                                                outputStream3.close();
                                            }
                                        }
                                    } else {
                                        outputStream3 = new ByteArrayOutputStream();
                                    }
                                    bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                    while (true) {
                                        read = inputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        outputStream3.write(bArr, 0, read);
                                        outputStream3.flush();
                                        aVar.bkh();
                                    }
                                    HI = HI(headerField);
                                    if (obj == null) {
                                        headerField3 = "";
                                    } else {
                                        headerField3 = new String(((ByteArrayOutputStream) outputStream3).toByteArray());
                                    }
                                    cVar2 = new c(responseCode, HI, headerField3);
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + cVar2);
                                    outputStream3.flush();
                                    outputStream3.close();
                                    if (outputStream2 != null) {
                                        try {
                                            outputStream2.close();
                                        } catch (Throwable e22) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e22, "", new Object[0]);
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable e222) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e222, "", new Object[0]);
                                        }
                                    }
                                    if (this.ppY != null) {
                                        this.ppY.aBw.disconnect();
                                    }
                                    return cVar2;
                                }
                            } catch (Exception e4) {
                                e222 = e4;
                                inputStream = inputStream2;
                                outputStream = outputStream2;
                                i = responseCode;
                                try {
                                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e222, "", new Object[0]);
                                    cVar = new c(i != 0 ? 503 : 500, null, null);
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Throwable e322) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e322, "", new Object[0]);
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable e3222) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e3222, "", new Object[0]);
                                        }
                                    }
                                    if (this.ppY == null) {
                                        return cVar;
                                    }
                                    this.ppY.aBw.disconnect();
                                    return cVar;
                                } catch (Throwable th2) {
                                    e222 = th2;
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Throwable e32222) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e32222, "", new Object[0]);
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable e322222) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e322222, "", new Object[0]);
                                        }
                                    }
                                    if (this.ppY != null) {
                                        this.ppY.aBw.disconnect();
                                    }
                                    throw e222;
                                }
                            } catch (Throwable th3) {
                                e222 = th3;
                                inputStream = inputStream2;
                                outputStream = outputStream2;
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (this.ppY != null) {
                                    this.ppY.aBw.disconnect();
                                }
                                throw e222;
                            }
                        }
                        inputStream = inputStream2;
                        outputStream3 = null;
                        if (obj == null) {
                            outputStream3 = new ByteArrayOutputStream();
                        } else {
                            str3 = pov;
                            stringBuilder = new StringBuilder();
                            if (bVar.pox.get("default_attach_name") != null) {
                                serializable = (Serializable) bVar.pox.get("default_attach_name");
                            } else {
                                valueOf = Long.valueOf(System.currentTimeMillis());
                            }
                            outputStream3 = new FileOutputStream(new File(str3, stringBuilder.append(valueOf).toString()), true);
                        }
                        bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            outputStream3.write(bArr, 0, read);
                            outputStream3.flush();
                            aVar.bkh();
                        }
                        HI = HI(headerField);
                        if (obj == null) {
                            headerField3 = new String(((ByteArrayOutputStream) outputStream3).toByteArray());
                        } else {
                            headerField3 = "";
                        }
                        cVar2 = new c(responseCode, HI, headerField3);
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + cVar2);
                        outputStream3.flush();
                        outputStream3.close();
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (this.ppY != null) {
                            this.ppY.aBw.disconnect();
                        }
                        return cVar2;
                    }
                }
                obj = null;
                inputStream2 = this.ppY.getInputStream();
                if (headerField2 != null) {
                    if (headerField2.contains("gzip")) {
                        inputStream = new GZIPInputStream(inputStream2);
                        outputStream3 = null;
                        if (obj == null) {
                            str3 = pov;
                            stringBuilder = new StringBuilder();
                            if (bVar.pox.get("default_attach_name") != null) {
                                valueOf = Long.valueOf(System.currentTimeMillis());
                            } else {
                                serializable = (Serializable) bVar.pox.get("default_attach_name");
                            }
                            outputStream3 = new FileOutputStream(new File(str3, stringBuilder.append(valueOf).toString()), true);
                        } else {
                            outputStream3 = new ByteArrayOutputStream();
                        }
                        bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            outputStream3.write(bArr, 0, read);
                            outputStream3.flush();
                            aVar.bkh();
                        }
                        HI = HI(headerField);
                        if (obj == null) {
                            headerField3 = "";
                        } else {
                            headerField3 = new String(((ByteArrayOutputStream) outputStream3).toByteArray());
                        }
                        cVar2 = new c(responseCode, HI, headerField3);
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + cVar2);
                        outputStream3.flush();
                        outputStream3.close();
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (this.ppY != null) {
                            this.ppY.aBw.disconnect();
                        }
                        return cVar2;
                    }
                }
                inputStream = inputStream2;
                outputStream3 = null;
                if (obj == null) {
                    outputStream3 = new ByteArrayOutputStream();
                } else {
                    str3 = pov;
                    stringBuilder = new StringBuilder();
                    if (bVar.pox.get("default_attach_name") != null) {
                        serializable = (Serializable) bVar.pox.get("default_attach_name");
                    } else {
                        valueOf = Long.valueOf(System.currentTimeMillis());
                    }
                    outputStream3 = new FileOutputStream(new File(str3, stringBuilder.append(valueOf).toString()), true);
                }
                bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    outputStream3.write(bArr, 0, read);
                    outputStream3.flush();
                    aVar.bkh();
                }
                HI = HI(headerField);
                if (obj == null) {
                    headerField3 = new String(((ByteArrayOutputStream) outputStream3).toByteArray());
                } else {
                    headerField3 = "";
                }
                cVar2 = new c(responseCode, HI, headerField3);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + cVar2);
                outputStream3.flush();
                outputStream3.close();
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (this.ppY != null) {
                    this.ppY.aBw.disconnect();
                }
                return cVar2;
            } catch (Exception e5) {
                e222 = e5;
                i = responseCode;
                outputStream = outputStream2;
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e222, "", new Object[0]);
                if (i != 0) {
                }
                cVar = new c(i != 0 ? 503 : 500, null, null);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (this.ppY == null) {
                    return cVar;
                }
                this.ppY.aBw.disconnect();
                return cVar;
            } catch (Throwable th4) {
                e222 = th4;
                outputStream = outputStream2;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (this.ppY != null) {
                    this.ppY.aBw.disconnect();
                }
                throw e222;
            }
        } catch (Exception e6) {
            e222 = e6;
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e222, "", new Object[0]);
            if (i != 0) {
            }
            cVar = new c(i != 0 ? 503 : 500, null, null);
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (this.ppY == null) {
                return cVar;
            }
            this.ppY.aBw.disconnect();
            return cVar;
        }
    }

    public final void cancel() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "cancel conection.");
        if (this.ppY != null) {
            this.ppY.aBw.disconnect();
        }
    }

    private static void a(b bVar, OutputStream outputStream) {
        if (bVar.pox != null) {
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            for (String str : bVar.pox.keySet()) {
                stringBuilder.append(obj != null ? "" : "&").append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) bVar.pox.get(str), ProtocolPackage.ServerEncoding));
                obj = null;
            }
            outputStream.write(stringBuilder.toString().getBytes());
        }
    }
}
