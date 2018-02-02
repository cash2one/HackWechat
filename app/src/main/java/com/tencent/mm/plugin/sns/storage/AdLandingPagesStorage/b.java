package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.AsyncTask;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.xwalk.core.R$styleable;

public final class b extends AsyncTask<String, Void, String> {
    private static Set<String> rnL = Collections.synchronizedSet(new HashSet());
    private String filePath;
    private boolean rlS;
    private int rlT;
    private a rnM;
    private int scene;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return z((String[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        if (((String) obj) == null) {
            this.rnM.bxM();
        } else {
            this.rnM.bxd();
        }
    }

    public b(String str, boolean z, int i, int i2, a aVar) {
        this.filePath = str;
        this.rlS = z;
        this.rlT = i;
        this.scene = i2;
        this.rnM = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private String z(String... strArr) {
        HttpURLConnection httpURLConnection;
        int responseCode;
        String UZ;
        int bwi;
        int bz;
        d dVar;
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection2;
        Exception exception;
        int i;
        Throwable th;
        if (FileOp.bO(this.filePath)) {
            return null;
        }
        if (rnL.contains(strArr[0])) {
            return "downloading";
        }
        long Wp = bh.Wp();
        int i2 = 0;
        rnL.add(strArr[0]);
        FileOp.mh(this.filePath.substring(0, this.filePath.lastIndexOf("/")));
        InputStream inputStream2 = null;
        OutputStream outputStream2 = null;
        this.rnM.bxc();
        String str;
        try {
            httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
            try {
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    try {
                        this.rnM.bxd();
                        str = "Server returned HTTP " + httpURLConnection.getResponseCode() + " " + httpURLConnection.getResponseMessage();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        rnL.remove(strArr[0]);
                        UZ = ab.UZ(strArr[0]);
                        bwi = bwi();
                        bz = (int) bh.bz(Wp);
                        dVar = new d();
                        dVar.q("20UrlMd5", UZ + ",");
                        dVar.q("21MediaType", bwi + ",");
                        dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                        dVar.q("23CostTime", bz + ",");
                        dVar.q("24RetCode", responseCode + ",");
                        dVar.q("25Scene", this.scene + ",");
                        dVar.q("26Size", new StringBuilder("0,").toString());
                        dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                        x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                        g.pQN.h(13572, dVar);
                        return str;
                    } catch (Exception e) {
                        inputStream = null;
                        outputStream = null;
                        httpURLConnection2 = httpURLConnection;
                        exception = e;
                        i = responseCode;
                        try {
                            this.rnM.bxd();
                            FileOp.deleteFile(this.filePath);
                            responseCode = -1;
                        } catch (Throwable th2) {
                            responseCode = i;
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            outputStream2 = outputStream;
                            inputStream2 = inputStream;
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e2) {
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    rnL.remove(strArr[0]);
                                    UZ = ab.UZ(strArr[0]);
                                    bwi = bwi();
                                    bz = (int) bh.bz(Wp);
                                    dVar = new d();
                                    dVar.q("20UrlMd5", UZ + ",");
                                    dVar.q("21MediaType", bwi + ",");
                                    dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                                    dVar.q("23CostTime", bz + ",");
                                    dVar.q("24RetCode", responseCode + ",");
                                    dVar.q("25Scene", this.scene + ",");
                                    dVar.q("26Size", i2 + ",");
                                    dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                                    g.pQN.h(13572, dVar);
                                    throw th;
                                }
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            rnL.remove(strArr[0]);
                            UZ = ab.UZ(strArr[0]);
                            bwi = bwi();
                            bz = (int) bh.bz(Wp);
                            dVar = new d();
                            dVar.q("20UrlMd5", UZ + ",");
                            dVar.q("21MediaType", bwi + ",");
                            if (this.rlS) {
                            }
                            dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                            dVar.q("23CostTime", bz + ",");
                            dVar.q("24RetCode", responseCode + ",");
                            dVar.q("25Scene", this.scene + ",");
                            dVar.q("26Size", i2 + ",");
                            dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                            x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                            g.pQN.h(13572, dVar);
                            throw th;
                        }
                        try {
                            str = exception.toString();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    rnL.remove(strArr[0]);
                                    UZ = ab.UZ(strArr[0]);
                                    bwi = bwi();
                                    bz = (int) bh.bz(Wp);
                                    dVar = new d();
                                    dVar.q("20UrlMd5", UZ + ",");
                                    dVar.q("21MediaType", bwi + ",");
                                    dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                                    dVar.q("23CostTime", bz + ",");
                                    dVar.q("24RetCode", new StringBuilder("-1,").toString());
                                    dVar.q("25Scene", this.scene + ",");
                                    dVar.q("26Size", i2 + ",");
                                    dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                                    g.pQN.h(13572, dVar);
                                    return str;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            rnL.remove(strArr[0]);
                            UZ = ab.UZ(strArr[0]);
                            bwi = bwi();
                            bz = (int) bh.bz(Wp);
                            dVar = new d();
                            dVar.q("20UrlMd5", UZ + ",");
                            dVar.q("21MediaType", bwi + ",");
                            if (this.rlS) {
                            }
                            dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                            dVar.q("23CostTime", bz + ",");
                            dVar.q("24RetCode", new StringBuilder("-1,").toString());
                            dVar.q("25Scene", this.scene + ",");
                            dVar.q("26Size", i2 + ",");
                            dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                            x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                            g.pQN.h(13572, dVar);
                            return str;
                        } catch (Throwable th22) {
                            th = th22;
                            httpURLConnection = httpURLConnection2;
                            outputStream2 = outputStream;
                            inputStream2 = inputStream;
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            rnL.remove(strArr[0]);
                            UZ = ab.UZ(strArr[0]);
                            bwi = bwi();
                            bz = (int) bh.bz(Wp);
                            dVar = new d();
                            dVar.q("20UrlMd5", UZ + ",");
                            dVar.q("21MediaType", bwi + ",");
                            if (this.rlS) {
                            }
                            dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                            dVar.q("23CostTime", bz + ",");
                            dVar.q("24RetCode", responseCode + ",");
                            dVar.q("25Scene", this.scene + ",");
                            dVar.q("26Size", i2 + ",");
                            dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                            x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                            g.pQN.h(13572, dVar);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        rnL.remove(strArr[0]);
                        UZ = ab.UZ(strArr[0]);
                        bwi = bwi();
                        bz = (int) bh.bz(Wp);
                        dVar = new d();
                        dVar.q("20UrlMd5", UZ + ",");
                        dVar.q("21MediaType", bwi + ",");
                        if (this.rlS) {
                        }
                        dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                        dVar.q("23CostTime", bz + ",");
                        dVar.q("24RetCode", responseCode + ",");
                        dVar.q("25Scene", this.scene + ",");
                        dVar.q("26Size", i2 + ",");
                        dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                        x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                        g.pQN.h(13572, dVar);
                        throw th;
                    }
                }
                httpURLConnection.getContentLength();
                inputStream = httpURLConnection.getInputStream();
                try {
                    outputStream = new FileOutputStream(this.filePath);
                } catch (Exception e4) {
                    outputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    exception = e4;
                    i = responseCode;
                    this.rnM.bxd();
                    FileOp.deleteFile(this.filePath);
                    responseCode = -1;
                    str = exception.toString();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    rnL.remove(strArr[0]);
                    UZ = ab.UZ(strArr[0]);
                    bwi = bwi();
                    bz = (int) bh.bz(Wp);
                    dVar = new d();
                    dVar.q("20UrlMd5", UZ + ",");
                    dVar.q("21MediaType", bwi + ",");
                    if (this.rlS) {
                    }
                    dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                    dVar.q("23CostTime", bz + ",");
                    dVar.q("24RetCode", new StringBuilder("-1,").toString());
                    dVar.q("25Scene", this.scene + ",");
                    dVar.q("26Size", i2 + ",");
                    dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                    g.pQN.h(13572, dVar);
                    return str;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream2 = inputStream;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    rnL.remove(strArr[0]);
                    UZ = ab.UZ(strArr[0]);
                    bwi = bwi();
                    bz = (int) bh.bz(Wp);
                    dVar = new d();
                    dVar.q("20UrlMd5", UZ + ",");
                    dVar.q("21MediaType", bwi + ",");
                    if (this.rlS) {
                    }
                    dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                    dVar.q("23CostTime", bz + ",");
                    dVar.q("24RetCode", responseCode + ",");
                    dVar.q("25Scene", this.scene + ",");
                    dVar.q("26Size", i2 + ",");
                    dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                    g.pQN.h(13572, dVar);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                    bwi = 0;
                    while (true) {
                        try {
                            i2 = inputStream.read(bArr);
                            if (i2 == -1) {
                                try {
                                    break;
                                } catch (IOException e5) {
                                }
                            } else if (isCancelled()) {
                                break;
                            } else {
                                outputStream.write(bArr, 0, i2);
                                bwi += i2;
                            }
                        } catch (Exception e42) {
                            i2 = bwi;
                            httpURLConnection2 = httpURLConnection;
                            exception = e42;
                            i = responseCode;
                        } catch (Throwable th5) {
                            th = th5;
                            i2 = bwi;
                            outputStream2 = outputStream;
                            inputStream2 = inputStream;
                        }
                    }
                    outputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    rnL.remove(strArr[0]);
                    UZ = ab.UZ(strArr[0]);
                    i = bwi();
                    bz = (int) bh.bz(Wp);
                    dVar = new d();
                    dVar.q("20UrlMd5", UZ + ",");
                    dVar.q("21MediaType", i + ",");
                    dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                    dVar.q("23CostTime", bz + ",");
                    dVar.q("24RetCode", responseCode + ",");
                    dVar.q("25Scene", this.scene + ",");
                    dVar.q("26Size", bwi + ",");
                    dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                    g.pQN.h(13572, dVar);
                    return null;
                } catch (Exception e422) {
                    httpURLConnection2 = httpURLConnection;
                    exception = e422;
                    i = responseCode;
                    this.rnM.bxd();
                    FileOp.deleteFile(this.filePath);
                    responseCode = -1;
                    str = exception.toString();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    rnL.remove(strArr[0]);
                    UZ = ab.UZ(strArr[0]);
                    bwi = bwi();
                    bz = (int) bh.bz(Wp);
                    dVar = new d();
                    dVar.q("20UrlMd5", UZ + ",");
                    dVar.q("21MediaType", bwi + ",");
                    if (this.rlS) {
                    }
                    dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                    dVar.q("23CostTime", bz + ",");
                    dVar.q("24RetCode", new StringBuilder("-1,").toString());
                    dVar.q("25Scene", this.scene + ",");
                    dVar.q("26Size", i2 + ",");
                    dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                    g.pQN.h(13572, dVar);
                    return str;
                } catch (Throwable th6) {
                    th = th6;
                    outputStream2 = outputStream;
                    inputStream2 = inputStream;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    rnL.remove(strArr[0]);
                    UZ = ab.UZ(strArr[0]);
                    bwi = bwi();
                    bz = (int) bh.bz(Wp);
                    dVar = new d();
                    dVar.q("20UrlMd5", UZ + ",");
                    dVar.q("21MediaType", bwi + ",");
                    if (this.rlS) {
                    }
                    dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                    dVar.q("23CostTime", bz + ",");
                    dVar.q("24RetCode", responseCode + ",");
                    dVar.q("25Scene", this.scene + ",");
                    dVar.q("26Size", i2 + ",");
                    dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                    g.pQN.h(13572, dVar);
                    throw th;
                }
            } catch (Exception e4222) {
                Exception exception2 = e4222;
                i = 0;
                inputStream = null;
                outputStream = null;
                httpURLConnection2 = httpURLConnection;
                exception = exception2;
                this.rnM.bxd();
                FileOp.deleteFile(this.filePath);
                responseCode = -1;
                str = exception.toString();
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                rnL.remove(strArr[0]);
                UZ = ab.UZ(strArr[0]);
                bwi = bwi();
                bz = (int) bh.bz(Wp);
                dVar = new d();
                dVar.q("20UrlMd5", UZ + ",");
                dVar.q("21MediaType", bwi + ",");
                if (this.rlS) {
                }
                dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                dVar.q("23CostTime", bz + ",");
                dVar.q("24RetCode", new StringBuilder("-1,").toString());
                dVar.q("25Scene", this.scene + ",");
                dVar.q("26Size", i2 + ",");
                dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                g.pQN.h(13572, dVar);
                return str;
            } catch (Throwable th7) {
                th = th7;
                responseCode = 0;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                rnL.remove(strArr[0]);
                UZ = ab.UZ(strArr[0]);
                bwi = bwi();
                bz = (int) bh.bz(Wp);
                dVar = new d();
                dVar.q("20UrlMd5", UZ + ",");
                dVar.q("21MediaType", bwi + ",");
                if (this.rlS) {
                }
                dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
                dVar.q("23CostTime", bz + ",");
                dVar.q("24RetCode", responseCode + ",");
                dVar.q("25Scene", this.scene + ",");
                dVar.q("26Size", i2 + ",");
                dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
                x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
                g.pQN.h(13572, dVar);
                throw th;
            }
        } catch (Exception e6) {
            exception = e6;
            i = 0;
            inputStream = null;
            outputStream = null;
            httpURLConnection2 = null;
            this.rnM.bxd();
            FileOp.deleteFile(this.filePath);
            responseCode = -1;
            str = exception.toString();
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            rnL.remove(strArr[0]);
            UZ = ab.UZ(strArr[0]);
            bwi = bwi();
            bz = (int) bh.bz(Wp);
            dVar = new d();
            dVar.q("20UrlMd5", UZ + ",");
            dVar.q("21MediaType", bwi + ",");
            if (this.rlS) {
            }
            dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
            dVar.q("23CostTime", bz + ",");
            dVar.q("24RetCode", new StringBuilder("-1,").toString());
            dVar.q("25Scene", this.scene + ",");
            dVar.q("26Size", i2 + ",");
            dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
            x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
            g.pQN.h(13572, dVar);
            return str;
        } catch (Throwable th222) {
            responseCode = 0;
            th = th222;
            httpURLConnection = null;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            rnL.remove(strArr[0]);
            UZ = ab.UZ(strArr[0]);
            bwi = bwi();
            bz = (int) bh.bz(Wp);
            dVar = new d();
            dVar.q("20UrlMd5", UZ + ",");
            dVar.q("21MediaType", bwi + ",");
            if (this.rlS) {
            }
            dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
            dVar.q("23CostTime", bz + ",");
            dVar.q("24RetCode", responseCode + ",");
            dVar.q("25Scene", this.scene + ",");
            dVar.q("26Size", i2 + ",");
            dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
            x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
            g.pQN.h(13572, dVar);
            throw th;
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        rnL.remove(strArr[0]);
        UZ = ab.UZ(strArr[0]);
        i = bwi();
        bz = (int) bh.bz(Wp);
        dVar = new d();
        dVar.q("20UrlMd5", UZ + ",");
        dVar.q("21MediaType", i + ",");
        dVar.q("22IsPreload", (this.rlS ? 1 : 0) + ",");
        dVar.q("23CostTime", bz + ",");
        dVar.q("24RetCode", responseCode + ",");
        dVar.q("25Scene", this.scene + ",");
        dVar.q("26Size", bwi + ",");
        dVar.q("27StartDownloadTime", (Wp / 1000) + ",");
        x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.Sz());
        g.pQN.h(13572, dVar);
        return null;
    }

    private int bwi() {
        switch (this.rlT) {
            case 41:
            case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
            case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
            case 1000000001:
                return 1;
            case 61:
                return 2;
            case 62:
                return 3;
            default:
                return 0;
        }
    }
}
