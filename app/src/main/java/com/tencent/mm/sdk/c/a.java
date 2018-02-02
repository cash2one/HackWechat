package com.tencent.mm.sdk.c;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public final class a extends b {
    private HttpURLConnection jCg = null;

    public a(HttpURLConnection httpURLConnection) {
        this.jCg = httpURLConnection;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(b$b com_tencent_mm_sdk_c_b_b, c cVar) {
        OutputStream outputStream;
        OutputStream outputStream2;
        Throwable e;
        x.i("MicroMsg.HttpURLConnectionWrapper", "request : %s", new Object[]{com_tencent_mm_sdk_c_b_b});
        OutputStream outputStream3 = null;
        InputStream inputStream = null;
        int i = 0;
        try {
            String str;
            this.jCg.setConnectTimeout(com_tencent_mm_sdk_c_b_b.gKi);
            this.jCg.setRequestMethod(com_tencent_mm_sdk_c_b_b.pow == 0 ? "GET" : "POST");
            if (com_tencent_mm_sdk_c_b_b.pow == 1) {
                this.jCg.setDoInput(true);
                this.jCg.setDoOutput(true);
            }
            this.jCg.setUseCaches(false);
            this.jCg.setRequestProperty("User-Agent", "weixin/android");
            this.jCg.setRequestProperty("Host", com_tencent_mm_sdk_c_b_b.host);
            System.setProperty("http.keepAlive", "false");
            this.jCg.setRequestProperty("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.jCg.setRequestProperty("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
            HttpURLConnection httpURLConnection = this.jCg;
            String str2 = "Cookie";
            Map map = com_tencent_mm_sdk_c_b_b.poy;
            if (map == null || map.size() == 0) {
                str = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                int i2 = 0;
                for (String str3 : map.keySet()) {
                    stringBuilder.append(URLEncoder.encode(str3, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) map.get(str3), ProtocolPackage.ServerEncoding));
                    int i3 = i2 + 1;
                    if (map.size() > i3) {
                        stringBuilder.append("; ");
                    }
                    i2 = i3;
                }
                str3 = stringBuilder.toString();
            }
            httpURLConnection.setRequestProperty(str2, str3);
            this.jCg.connect();
            if (com_tencent_mm_sdk_c_b_b.pow == 1) {
                outputStream3 = this.jCg.getOutputStream();
                a(com_tencent_mm_sdk_c_b_b, outputStream3);
                outputStream3.flush();
                outputStream = outputStream3;
            } else {
                outputStream = null;
            }
            int responseCode;
            try {
                byte[] bArr;
                int read;
                responseCode = this.jCg.getResponseCode();
                String headerField = this.jCg.getHeaderField("set-cookie");
                str3 = this.jCg.getHeaderField("Content-Encoding");
                this.jCg.getHeaderField("Content-Disposition");
                InputStream inputStream2 = this.jCg.getInputStream();
                if (str3 != null) {
                    try {
                        if (str3.contains("gzip")) {
                            inputStream = new GZIPInputStream(inputStream2);
                            outputStream2 = null;
                            if (cVar.xeu == null && bh.ov(cVar.xeu.filePath)) {
                                outputStream2 = new FileOutputStream(new File(cVar.xeu.filePath), true);
                            } else {
                                outputStream2 = new ByteArrayOutputStream();
                            }
                            bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                            while (true) {
                                read = inputStream.read(bArr);
                                if (read > 0) {
                                    break;
                                }
                                outputStream2.write(bArr, 0, read);
                                outputStream2.flush();
                            }
                            cVar.status = responseCode;
                            cVar.poy = HI(headerField);
                            cVar.content = outputStream2 instanceof ByteArrayOutputStream ? new String(((ByteArrayOutputStream) outputStream2).toByteArray()) : "";
                            outputStream2.flush();
                            outputStream2.close();
                            x.d("MicroMsg.HttpURLConnectionWrapper", "Response: %s" + cVar);
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e2, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e22, "", new Object[0]);
                                }
                            }
                            if (this.jCg != null) {
                                this.jCg.disconnect();
                            }
                        }
                    } catch (Exception e3) {
                        e22 = e3;
                        inputStream = inputStream2;
                        i = responseCode;
                        outputStream3 = outputStream;
                        try {
                            x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e22, "", new Object[0]);
                            cVar.status = i != 0 ? 503 : 500;
                            if (outputStream3 != null) {
                                try {
                                    outputStream3.close();
                                } catch (Throwable e222) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e222, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e2222) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e2222, "", new Object[0]);
                                }
                            }
                            if (this.jCg != null) {
                                this.jCg.disconnect();
                            }
                        } catch (Throwable th) {
                            e2222 = th;
                            if (outputStream3 != null) {
                                try {
                                    outputStream3.close();
                                } catch (Throwable e4) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e4, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e42) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e42, "", new Object[0]);
                                }
                            }
                            if (this.jCg != null) {
                                this.jCg.disconnect();
                            }
                            throw e2222;
                        }
                    } catch (Throwable th2) {
                        e2222 = th2;
                        inputStream = inputStream2;
                        outputStream3 = outputStream;
                        if (outputStream3 != null) {
                            outputStream3.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (this.jCg != null) {
                            this.jCg.disconnect();
                        }
                        throw e2222;
                    }
                }
                inputStream = inputStream2;
                outputStream2 = null;
                try {
                    if (cVar.xeu == null) {
                    }
                    outputStream2 = new ByteArrayOutputStream();
                    bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        read = inputStream.read(bArr);
                        if (read > 0) {
                            break;
                        }
                        outputStream2.write(bArr, 0, read);
                        outputStream2.flush();
                    }
                    cVar.status = responseCode;
                    cVar.poy = HI(headerField);
                    if (outputStream2 instanceof ByteArrayOutputStream) {
                    }
                    cVar.content = outputStream2 instanceof ByteArrayOutputStream ? new String(((ByteArrayOutputStream) outputStream2).toByteArray()) : "";
                    outputStream2.flush();
                    outputStream2.close();
                } catch (Throwable e22222) {
                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e22222, "", new Object[0]);
                    cVar.status = responseCode == 0 ? 503 : 500;
                    if (outputStream2 != null) {
                        outputStream2.flush();
                        outputStream2.close();
                    }
                } catch (Throwable th3) {
                    if (outputStream2 != null) {
                        outputStream2.flush();
                        outputStream2.close();
                    }
                }
                x.d("MicroMsg.HttpURLConnectionWrapper", "Response: %s" + cVar);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (this.jCg != null) {
                    this.jCg.disconnect();
                }
            } catch (Exception e5) {
                e22222 = e5;
                i = responseCode;
                outputStream3 = outputStream;
                x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e22222, "", new Object[0]);
                if (i != 0) {
                }
                cVar.status = i != 0 ? 503 : 500;
                if (outputStream3 != null) {
                    outputStream3.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (this.jCg != null) {
                    this.jCg.disconnect();
                }
            } catch (Throwable th4) {
                e22222 = th4;
                outputStream3 = outputStream;
                if (outputStream3 != null) {
                    outputStream3.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (this.jCg != null) {
                    this.jCg.disconnect();
                }
                throw e22222;
            }
        } catch (Exception e6) {
            e22222 = e6;
            x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e22222, "", new Object[0]);
            if (i != 0) {
            }
            cVar.status = i != 0 ? 503 : 500;
            if (outputStream3 != null) {
                outputStream3.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (this.jCg != null) {
                this.jCg.disconnect();
            }
        }
    }

    private static void a(b$b com_tencent_mm_sdk_c_b_b, OutputStream outputStream) {
        if (com_tencent_mm_sdk_c_b_b.pox != null) {
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            for (String str : com_tencent_mm_sdk_c_b_b.pox.keySet()) {
                stringBuilder.append(obj != null ? "" : "&").append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) com_tencent_mm_sdk_c_b_b.pox.get(str), ProtocolPackage.ServerEncoding));
                obj = null;
            }
            outputStream.write(stringBuilder.toString().getBytes());
        }
    }
}
