package com.tencent.mm.plugin.music.model.c;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.plugin.music.model.b.d;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements Runnable {
    public com.tencent.mm.av.a fAA;
    public int hey = 0;
    public boolean isStop = true;
    public String mimeType = "";
    public boolean mrc;
    public float oLp;
    private long oLq = 307200;
    public int oLr = -1;
    public b oLs;

    public a(com.tencent.mm.av.a aVar) {
        this.fAA = aVar;
        this.mrc = an.isWifi(ac.getContext());
    }

    public final void start() {
        if (this.isStop) {
            this.isStop = false;
            e.post(this, "music_download_thread");
        }
    }

    public final void run() {
        long j;
        long j2;
        long j3;
        long j4;
        Throwable e;
        RandomAccessFile randomAccessFile;
        u j5;
        RandomAccessFile randomAccessFile2;
        InputStream inputStream;
        u uVar;
        if (!this.isStop) {
            boolean isNetworkConnected = an.isNetworkConnected(ac.getContext());
            this.hey = 0;
            this.oLr = 0;
            if (isNetworkConnected) {
                String Gi;
                long j6;
                boolean z;
                String str;
                Object obj;
                String Gk;
                if (this.mrc) {
                    Object obj2;
                    Gi = d.Gi(this.fAA.hHQ);
                    boolean Gn = com.tencent.mm.plugin.music.model.b.e.Gn(Gi);
                    x.i("MicroMsg.Music.MusicDownloadTask", "contain shake tag downloadUrl:%s", new Object[]{Gi});
                    Gk = d.Gk(Gi);
                    j = this.fAA.field_wifiDownloadedLength;
                    j2 = this.fAA.field_songWifiFileLength;
                    if (j2 != 0) {
                        this.oLq = j2 / 4;
                    }
                    if (j < this.oLq) {
                        j6 = this.oLq;
                    } else {
                        j6 = (long) (((float) j) + (0.15f * ((float) this.fAA.field_songWifiFileLength)));
                    }
                    if (this.fAA.field_wifiEndFlag == 1) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    j3 = j2;
                    j2 = j;
                    z = Gn;
                    str = Gk;
                    obj = obj2;
                    j4 = j3;
                } else {
                    Gk = d.Gi(this.fAA.hHQ);
                    j = this.fAA.field_downloadedLength;
                    j2 = this.fAA.field_songFileLength;
                    if (j2 != 0) {
                        this.oLq = j2 / 4;
                    }
                    if (j < this.oLq) {
                        j6 = this.oLq;
                    } else {
                        j6 = (long) (((float) j) + (0.15f * ((float) this.fAA.field_songFileLength)));
                    }
                    j3 = j2;
                    j2 = j;
                    z = false;
                    str = Gk;
                    obj = this.fAA.field_endFlag == 1 ? 1 : null;
                    j4 = j3;
                }
                if (this.oLq < 256000) {
                    this.oLq = 256000;
                    x.i("MicroMsg.Music.MusicDownloadTask", "music firstTimeDownloadSize is less than startPlayLength, update firstTimeDownloadSize");
                }
                File file = new File(g.b(this.fAA, this.mrc));
                if (!file.exists()) {
                    try {
                        x.i("MicroMsg.Music.MusicDownloadTask", "create file:%b", new Object[]{Boolean.valueOf(file.createNewFile())});
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2, " createNewFile fail, path:%s", new Object[]{file.getAbsolutePath()});
                    }
                    j2 = 0;
                    j6 = this.oLq;
                    obj = null;
                    x.i("MicroMsg.Music.MusicDownloadTask", "music file delete and create again %d", new Object[]{Long.valueOf(j6)});
                }
                x.i("MicroMsg.Music.MusicDownloadTask", "downloadLength=%d musicFile.Length=%d endRange=%d", new Object[]{Long.valueOf(j2), Long.valueOf(file.length()), Long.valueOf(j6)});
                if ((j2 >= this.oLq && this.oLp == 0.0f) || r10 != null) {
                    x.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                    this.isStop = true;
                    ag.y(new a(this, 1));
                } else if (bh.ov(str)) {
                    x.e("MicroMsg.Music.MusicDownloadTask", "downloadUrl is null");
                    this.isStop = true;
                    ag.y(new a(this, -2));
                } else {
                    InputStream inputStream2 = null;
                    try {
                        if (file.exists()) {
                            randomAccessFile = new RandomAccessFile(file, "rws");
                            try {
                                x.i("MicroMsg.Music.MusicDownloadTask", "create connection %s", new Object[]{str});
                                Map hashMap = new HashMap(10);
                                hashMap.put("Accept-Encoding", "gzip, deflate");
                                if (j6 > j2) {
                                    x.d("MicroMsg.Music.MusicDownloadTask", "range : %d-%d", new Object[]{Long.valueOf(j2), Long.valueOf(j6)});
                                    hashMap.put("range", "bytes=" + j2 + "-" + j6);
                                }
                                if (z || g.FM(str)) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "set cookie");
                                    hashMap.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
                                    hashMap.put("referer", "stream12.qqmusic.qq.com");
                                }
                                hashMap.put("user-agent", System.getProperty("http.agent") + " Built-in music  MicroMessenger/" + g.dh(ac.getContext()));
                                j5 = j(str, hashMap);
                                try {
                                    int responseCode = j5.getResponseCode();
                                    if (responseCode == 200 || responseCode == b.CTRL_INDEX) {
                                        long j7;
                                        x.i("MicroMsg.Music.MusicDownloadTask", "getResponseCode:%d", new Object[]{Integer.valueOf(responseCode)});
                                        x.d("MicroMsg.Music.MusicDownloadTask", "user-agent: " + j5.aBw.getRequestProperty("user-agent"));
                                        x.i("MicroMsg.Music.MusicDownloadTask", "ContentType:%s", new Object[]{j5.aBw.getContentType()});
                                        this.mimeType = Gi;
                                        if (!TextUtils.isEmpty(this.mimeType) && TextUtils.isEmpty(this.fAA.field_mimetype)) {
                                            this.fAA.field_mimetype = this.mimeType;
                                            com.tencent.mm.plugin.music.model.h.a bdA = h.bdA();
                                            String str2 = this.fAA.field_musicId;
                                            str = this.mimeType;
                                            ContentValues contentValues = new ContentValues();
                                            contentValues.put("mimetype", str);
                                            bdA.gJP.update("Music", contentValues, "musicId=?", new String[]{str2});
                                            com.tencent.mm.av.a aVar = (com.tencent.mm.av.a) bdA.oMR.get(str2);
                                            if (aVar != null) {
                                                aVar.field_mimetype = str;
                                            }
                                        }
                                        long[] Gu = Gu(j5.getHeaderField("Content-Range"));
                                        x.i("MicroMsg.Music.MusicDownloadTask", "content-range: %s contentLen=%d", new Object[]{str, Long.valueOf(bh.getLong(j5.getHeaderField("Content-Length"), 0))});
                                        if (Gu == null) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not support range feature");
                                            if (j2 != 0) {
                                                j2 = 0;
                                            }
                                            j4 = j6;
                                        } else {
                                            if (j2 > 0) {
                                                if (j2 != Gu[0]) {
                                                    x.e("MicroMsg.Music.MusicDownloadTask", "return http error, need to download again");
                                                    tB(6);
                                                    if (j4 == 0 && j2 > 0) {
                                                        x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                                        try {
                                                            randomAccessFile.setLength(j2);
                                                        } catch (Throwable e22) {
                                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22, " music raf close fail", new Object[0]);
                                                        }
                                                        dO(j2);
                                                        if (j2 < 256000) {
                                                            ag.y(new a(this, 1));
                                                        }
                                                    } else if (j4 != 0 && j2 != j4) {
                                                        x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                                        y(j2, j4);
                                                    } else if (j4 == 0 || j2 != j4) {
                                                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                                    } else {
                                                        x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                                        dO(j4);
                                                        if (j2 < 256000) {
                                                            ag.y(new a(this, 1));
                                                        }
                                                    }
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Throwable e222) {
                                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222, " music raf close fail", new Object[0]);
                                                    }
                                                    if (j5 != null) {
                                                        j5.aBw.disconnect();
                                                    }
                                                    this.isStop = true;
                                                    x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                                    return;
                                                }
                                            }
                                            j4 = Gu[2];
                                        }
                                        if (j4 != 0) {
                                            j7 = j4;
                                        } else {
                                            j7 = 10000000;
                                        }
                                        x.i("MicroMsg.Music.MusicDownloadTask", "fileLen=%d downloadLength=%d", new Object[]{Long.valueOf(j7), Long.valueOf(j2)});
                                        randomAccessFile.setLength(j7);
                                        randomAccessFile.seek(j2);
                                        InputStream inputStream3 = j5.getInputStream();
                                        try {
                                            byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                                            while (!this.isStop) {
                                                int read = inputStream3.read(bArr);
                                                if (read <= 0) {
                                                    x.e("MicroMsg.Music.MusicDownloadTask", "read length:%d, isStop:%b, downloadLength:%d, realFileLength:%d", new Object[]{Integer.valueOf(read), Boolean.valueOf(this.isStop), Long.valueOf(j2), Long.valueOf(j7)});
                                                    break;
                                                }
                                                randomAccessFile.write(bArr, 0, read);
                                                j2 += (long) read;
                                                x.v("MicroMsg.Music.MusicDownloadTask", "update updateCurrentDownloadLength %d %d", new Object[]{Long.valueOf(j2), Long.valueOf(j7)});
                                                if (this.mrc) {
                                                    this.fAA.field_wifiDownloadedLength = j2;
                                                    this.fAA.field_songWifiFileLength = j7;
                                                } else {
                                                    this.fAA.field_downloadedLength = j2;
                                                    this.fAA.field_songFileLength = j7;
                                                }
                                                if (j2 >= 256000) {
                                                    ag.y(new a(this, 1));
                                                }
                                            }
                                            if (j4 == 0 && j2 > 0) {
                                                x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                                try {
                                                    randomAccessFile.setLength(j2);
                                                } catch (Throwable e2222) {
                                                    x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222, " music raf close fail", new Object[0]);
                                                }
                                                dO(j2);
                                                if (j2 < 256000) {
                                                    ag.y(new a(this, 1));
                                                }
                                            } else if (j4 != 0 && j2 != j4) {
                                                x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                                y(j2, j4);
                                            } else if (j4 == 0 || j2 != j4) {
                                                x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                            } else {
                                                x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                                dO(j4);
                                                if (j2 < 256000) {
                                                    ag.y(new a(this, 1));
                                                }
                                            }
                                            if (inputStream3 != null) {
                                                try {
                                                    inputStream3.close();
                                                } catch (Throwable e22222) {
                                                    x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222, " music is close fail", new Object[0]);
                                                }
                                            }
                                            try {
                                                randomAccessFile.close();
                                            } catch (Throwable e222222) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222, " music raf close fail", new Object[0]);
                                            }
                                            if (j5 != null) {
                                                j5.aBw.disconnect();
                                            }
                                            this.isStop = true;
                                            x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                            return;
                                        } catch (ProtocolException e3) {
                                            e222222 = e3;
                                            InputStream inputStream4 = inputStream3;
                                            randomAccessFile2 = randomAccessFile;
                                            long j8 = j4;
                                            inputStream = inputStream4;
                                            uVar = j5;
                                            j = j2;
                                            j2 = j8;
                                        } catch (NoRouteToHostException e4) {
                                            e222222 = e4;
                                            inputStream2 = inputStream3;
                                        } catch (UnknownServiceException e5) {
                                            e222222 = e5;
                                            inputStream2 = inputStream3;
                                        } catch (IOException e6) {
                                            e222222 = e6;
                                            inputStream2 = inputStream3;
                                        } catch (Exception e7) {
                                            e222222 = e7;
                                            inputStream2 = inputStream3;
                                        } catch (Throwable th) {
                                            e222222 = th;
                                            inputStream2 = inputStream3;
                                        }
                                    } else {
                                        tA(responseCode);
                                        x.e("MicroMsg.Music.MusicDownloadTask", "music http req error responseCode:%d", new Object[]{Integer.valueOf(responseCode)});
                                        this.oLr = responseCode;
                                        tB(-1);
                                        if (j4 == 0 && j2 > 0) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile.setLength(j2);
                                            } catch (Throwable e2222222) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222, " music raf close fail", new Object[0]);
                                            }
                                            dO(j2);
                                            if (j2 < 256000) {
                                                ag.y(new a(this, 1));
                                            }
                                        } else if (j4 != 0 && j2 != j4) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                            y(j2, j4);
                                        } else if (j4 == 0 || j2 != j4) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        } else {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                            dO(j4);
                                            if (j2 < 256000) {
                                                ag.y(new a(this, 1));
                                            }
                                        }
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable e22222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222, " music raf close fail", new Object[0]);
                                        }
                                        if (j5 != null) {
                                            j5.aBw.disconnect();
                                        }
                                        this.isStop = true;
                                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                        return;
                                    }
                                } catch (ProtocolException e8) {
                                    e22222222 = e8;
                                    randomAccessFile2 = randomAccessFile;
                                    j3 = j4;
                                    inputStream = null;
                                    uVar = j5;
                                    j = j2;
                                    j2 = j3;
                                    try {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                        this.hey = 750;
                                        tB(5);
                                        if (j2 != 0) {
                                        }
                                        if (j2 == 0) {
                                        }
                                        if (j2 == 0) {
                                        }
                                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Throwable e222222222) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222, " music is close fail", new Object[0]);
                                            }
                                        }
                                        if (randomAccessFile2 != null) {
                                            try {
                                                randomAccessFile2.close();
                                            } catch (Throwable e2222222222) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222, " music raf close fail", new Object[0]);
                                            }
                                        }
                                        if (uVar != null) {
                                            uVar.aBw.disconnect();
                                        }
                                        this.isStop = true;
                                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                    } catch (Throwable th2) {
                                        e2222222222 = th2;
                                        randomAccessFile = randomAccessFile2;
                                        inputStream2 = inputStream;
                                        j3 = j2;
                                        j2 = j;
                                        j5 = uVar;
                                        j4 = j3;
                                        if (j4 != 0) {
                                        }
                                        if (j4 == 0) {
                                        }
                                        if (j4 == 0) {
                                        }
                                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Throwable e9) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e9, " music is close fail", new Object[0]);
                                            }
                                        }
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                            } catch (Throwable e92) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e92, " music raf close fail", new Object[0]);
                                            }
                                        }
                                        if (j5 != null) {
                                            j5.aBw.disconnect();
                                        }
                                        this.isStop = true;
                                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                        throw e2222222222;
                                    }
                                } catch (NoRouteToHostException e10) {
                                    e2222222222 = e10;
                                    try {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                        this.hey = 751;
                                        tB(5);
                                        if (j4 != 0) {
                                        }
                                        if (j4 == 0) {
                                        }
                                        if (j4 == 0) {
                                        }
                                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Throwable e22222222222) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222, " music is close fail", new Object[0]);
                                            }
                                        }
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                            } catch (Throwable e222222222222) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222, " music raf close fail", new Object[0]);
                                            }
                                        }
                                        if (j5 != null) {
                                            j5.aBw.disconnect();
                                        }
                                        this.isStop = true;
                                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                    } catch (Throwable th3) {
                                        e222222222222 = th3;
                                        if (j4 != 0 && j2 > 0) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile.setLength(j2);
                                            } catch (Throwable e922) {
                                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e922, " music raf close fail", new Object[0]);
                                            }
                                            dO(j2);
                                            if (j2 < 256000) {
                                                ag.y(new a(this, 1));
                                            }
                                        } else if (j4 == 0 && j2 != j4) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                            y(j2, j4);
                                        } else if (j4 == 0 && j2 == j4) {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                            dO(j4);
                                            if (j2 < 256000) {
                                                ag.y(new a(this, 1));
                                            }
                                        } else {
                                            x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (randomAccessFile != null) {
                                            randomAccessFile.close();
                                        }
                                        if (j5 != null) {
                                            j5.aBw.disconnect();
                                        }
                                        this.isStop = true;
                                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                        throw e222222222222;
                                    }
                                } catch (UnknownServiceException e11) {
                                    e222222222222 = e11;
                                    x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                    this.hey = 752;
                                    tB(5);
                                    if (j4 != 0) {
                                    }
                                    if (j4 == 0) {
                                    }
                                    if (j4 == 0) {
                                    }
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable e2222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222, " music is close fail", new Object[0]);
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable e22222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222, " music raf close fail", new Object[0]);
                                        }
                                    }
                                    if (j5 != null) {
                                        j5.aBw.disconnect();
                                    }
                                    this.isStop = true;
                                    x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                } catch (IOException e12) {
                                    e22222222222222 = e12;
                                    x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                    this.hey = 753;
                                    tB(5);
                                    if (j4 != 0) {
                                    }
                                    if (j4 == 0) {
                                    }
                                    if (j4 == 0) {
                                    }
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable e222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222, " music is close fail", new Object[0]);
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable e2222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222, " music raf close fail", new Object[0]);
                                        }
                                    }
                                    if (j5 != null) {
                                        j5.aBw.disconnect();
                                    }
                                    this.isStop = true;
                                    x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                } catch (Exception e13) {
                                    e2222222222222222 = e13;
                                    x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                    this.hey = 754;
                                    tB(5);
                                    if (j4 != 0) {
                                    }
                                    if (j4 == 0) {
                                    }
                                    if (j4 == 0) {
                                    }
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable e22222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222, " music is close fail", new Object[0]);
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable e222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222, " music raf close fail", new Object[0]);
                                        }
                                    }
                                    if (j5 != null) {
                                        j5.aBw.disconnect();
                                    }
                                    this.isStop = true;
                                    x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                }
                            } catch (ProtocolException e14) {
                                e222222222222222222 = e14;
                                randomAccessFile2 = randomAccessFile;
                                j = j2;
                                j2 = j4;
                                inputStream = null;
                                uVar = null;
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                this.hey = 750;
                                tB(5);
                                if (j2 != 0 && j > 0) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                    try {
                                        randomAccessFile2.setLength(j);
                                    } catch (Throwable e2222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222, " music raf close fail", new Object[0]);
                                    }
                                    dO(j);
                                    if (j < 256000) {
                                        ag.y(new a(this, 1));
                                    }
                                } else if (j2 == 0 && j != j2) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                    y(j, j2);
                                } else if (j2 == 0 && j == j2) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                    dO(j2);
                                    if (j < 256000) {
                                        ag.y(new a(this, 1));
                                    }
                                } else {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (randomAccessFile2 != null) {
                                    randomAccessFile2.close();
                                }
                                if (uVar != null) {
                                    uVar.aBw.disconnect();
                                }
                                this.isStop = true;
                                x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            } catch (NoRouteToHostException e15) {
                                e2222222222222222222 = e15;
                                j5 = null;
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                this.hey = 751;
                                tB(5);
                                if (j4 != 0 && j2 > 0) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                    try {
                                        randomAccessFile.setLength(j2);
                                    } catch (Throwable e22222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222, " music raf close fail", new Object[0]);
                                    }
                                    dO(j2);
                                    if (j2 < 256000) {
                                        ag.y(new a(this, 1));
                                    }
                                } else if (j4 == 0 && j2 != j4) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                    y(j2, j4);
                                } else if (j4 == 0 && j2 == j4) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                    dO(j4);
                                    if (j2 < 256000) {
                                        ag.y(new a(this, 1));
                                    }
                                } else {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                if (j5 != null) {
                                    j5.aBw.disconnect();
                                }
                                this.isStop = true;
                                x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            } catch (UnknownServiceException e16) {
                                e22222222222222222222 = e16;
                                j5 = null;
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                this.hey = 752;
                                tB(5);
                                if (j4 != 0 && j2 > 0) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                    try {
                                        randomAccessFile.setLength(j2);
                                    } catch (Throwable e222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222, " music raf close fail", new Object[0]);
                                    }
                                    dO(j2);
                                    if (j2 < 256000) {
                                        ag.y(new a(this, 1));
                                    }
                                } else if (j4 == 0 && j2 != j4) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                    y(j2, j4);
                                } else if (j4 == 0 && j2 == j4) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                    dO(j4);
                                    if (j2 < 256000) {
                                        ag.y(new a(this, 1));
                                    }
                                } else {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                if (j5 != null) {
                                    j5.aBw.disconnect();
                                }
                                this.isStop = true;
                                x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            } catch (IOException e17) {
                                e222222222222222222222 = e17;
                                j5 = null;
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                this.hey = 753;
                                tB(5);
                                if (j4 != 0 && j2 > 0) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                    try {
                                        randomAccessFile.setLength(j2);
                                    } catch (Throwable e2222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222, " music raf close fail", new Object[0]);
                                    }
                                    dO(j2);
                                    if (j2 < 256000) {
                                        ag.y(new a(this, 1));
                                    }
                                } else if (j4 == 0 && j2 != j4) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                    y(j2, j4);
                                } else if (j4 == 0 && j2 == j4) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                    dO(j4);
                                    if (j2 < 256000) {
                                        ag.y(new a(this, 1));
                                    }
                                } else {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                if (j5 != null) {
                                    j5.aBw.disconnect();
                                }
                                this.isStop = true;
                                x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            } catch (Exception e18) {
                                e2222222222222222222222 = e18;
                                j5 = null;
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                this.hey = 754;
                                tB(5);
                                if (j4 != 0 && j2 > 0) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                    try {
                                        randomAccessFile.setLength(j2);
                                    } catch (Throwable e22222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222222222222222, " music raf close fail", new Object[0]);
                                    }
                                    dO(j2);
                                    if (j2 < 256000) {
                                        ag.y(new a(this, 1));
                                    }
                                } else if (j4 == 0 && j2 != j4) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                    y(j2, j4);
                                } else if (j4 == 0 && j2 == j4) {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                                    dO(j4);
                                    if (j2 < 256000) {
                                        ag.y(new a(this, 1));
                                    }
                                } else {
                                    x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                if (j5 != null) {
                                    j5.aBw.disconnect();
                                }
                                this.isStop = true;
                                x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            } catch (Throwable th4) {
                                e22222222222222222222222 = th4;
                                j5 = null;
                                if (j4 != 0) {
                                }
                                if (j4 == 0) {
                                }
                                if (j4 == 0) {
                                }
                                x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                if (j5 != null) {
                                    j5.aBw.disconnect();
                                }
                                this.isStop = true;
                                x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                throw e22222222222222222222222;
                            }
                        }
                        this.isStop = true;
                        x.e("MicroMsg.Music.MusicDownloadTask", "create fail or musicFile not exist, musicFile:%s", new Object[]{file.getAbsolutePath()});
                        tB(19);
                        if (j4 == 0 && j2 > 0) {
                            x.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                            RandomAccessFile randomAccessFile3 = null;
                            try {
                                randomAccessFile3.setLength(j2);
                            } catch (Throwable e222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222, " music raf close fail", new Object[0]);
                            }
                            dO(j2);
                            if (j2 < 256000) {
                                ag.y(new a(this, 1));
                            }
                        } else if (j4 != 0 && j2 != j4) {
                            x.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                            y(j2, j4);
                        } else if (j4 == 0 || j2 != j4) {
                            x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        } else {
                            x.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j4), Long.valueOf(j2)});
                            dO(j4);
                            if (j2 < 256000) {
                                ag.y(new a(this, 1));
                            }
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (ProtocolException e19) {
                        e222222222222222222222222 = e19;
                        randomAccessFile2 = null;
                        j = j2;
                        j2 = j4;
                        inputStream = null;
                        uVar = null;
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                        this.hey = 750;
                        tB(5);
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        if (j2 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (NoRouteToHostException e20) {
                        e222222222222222222222222 = e20;
                        randomAccessFile = null;
                        j5 = null;
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                        this.hey = 751;
                        tB(5);
                        if (j4 != 0) {
                        }
                        if (j4 == 0) {
                        }
                        if (j4 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (j5 != null) {
                            j5.aBw.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (UnknownServiceException e21) {
                        e222222222222222222222222 = e21;
                        randomAccessFile = null;
                        j5 = null;
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                        this.hey = 752;
                        tB(5);
                        if (j4 != 0) {
                        }
                        if (j4 == 0) {
                        }
                        if (j4 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (j5 != null) {
                            j5.aBw.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (IOException e23) {
                        e222222222222222222222222 = e23;
                        randomAccessFile = null;
                        j5 = null;
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                        this.hey = 753;
                        tB(5);
                        if (j4 != 0) {
                        }
                        if (j4 == 0) {
                        }
                        if (j4 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (j5 != null) {
                            j5.aBw.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (Exception e24) {
                        e222222222222222222222222 = e24;
                        randomAccessFile = null;
                        j5 = null;
                        x.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222222222222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                        this.hey = 754;
                        tB(5);
                        if (j4 != 0) {
                        }
                        if (j4 == 0) {
                        }
                        if (j4 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (j5 != null) {
                            j5.aBw.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (Throwable th5) {
                        e222222222222222222222222 = th5;
                        randomAccessFile = null;
                        j5 = null;
                        if (j4 != 0) {
                        }
                        if (j4 == 0) {
                        }
                        if (j4 == 0) {
                        }
                        x.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (j5 != null) {
                            j5.aBw.disconnect();
                        }
                        this.isStop = true;
                        x.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                        throw e222222222222222222222222;
                    }
                }
            } else if (this.fAA.field_wifiDownloadedLength != 0 && this.fAA.field_wifiDownloadedLength >= this.oLq && (((float) this.fAA.field_wifiDownloadedLength) / ((float) this.fAA.field_songWifiFileLength)) - this.oLp >= 0.15f) {
                x.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                this.isStop = true;
                this.mrc = true;
                ag.y(new a(this, 1));
            } else if (this.fAA.field_downloadedLength == 0 || this.fAA.field_downloadedLength < this.oLq || (((float) this.fAA.field_downloadedLength) / ((float) this.fAA.field_songFileLength)) - this.oLp < 0.15f) {
                x.i("MicroMsg.Music.MusicDownloadTask", "not connect network");
                this.isStop = true;
                tB(4);
            } else {
                x.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                this.isStop = true;
                this.mrc = false;
                ag.y(new a(this, 1));
            }
        }
    }

    private static u j(String str, Map<String, String> map) {
        u uVar = null;
        int i = 0;
        while (true) {
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            x.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", new Object[]{str});
            uVar = com.tencent.mm.network.b.a(str, null);
            uVar.setRequestMethod("GET");
            uVar.setConnectTimeout(25000);
            uVar.aBw.setInstanceFollowRedirects(true);
            for (Entry entry : map.entrySet()) {
                uVar.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            int responseCode = uVar.getResponseCode();
            x.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", new Object[]{Integer.valueOf(responseCode), Integer.valueOf(i)});
            if (responseCode != 300 && responseCode != 301 && responseCode != HardCoderJNI.SCENE_QUIT_CHATTING && responseCode != 303) {
                return uVar;
            }
            tA(responseCode);
            String headerField = uVar.getHeaderField("Location");
            if (headerField == null) {
                x.e("MicroMsg.Music.MusicDownloadTask", "Invalid redirect,  response:%d", new Object[]{Integer.valueOf(responseCode)});
                return uVar;
            }
            URL url = new URL(uVar.aBw.getURL(), headerField);
            x.i("MicroMsg.Music.MusicDownloadTask", "location:%s", new Object[]{headerField});
            x.i("MicroMsg.Music.MusicDownloadTask", "tempUrl:%s", new Object[]{url.toString()});
            if (url.getProtocol().equals("https") || url.getProtocol().equals("http")) {
                responseCode = i + 1;
                if (responseCode > 5) {
                    x.e("MicroMsg.Music.MusicDownloadTask", "Too many redirects: " + responseCode);
                    return uVar;
                }
                str = url.toString();
                i = responseCode;
            } else {
                x.e("MicroMsg.Music.MusicDownloadTask", "Unsupported protocol redirect,  response:%d", new Object[]{Integer.valueOf(responseCode)});
                return uVar;
            }
        }
    }

    private static void tA(int i) {
        if (i == 300 || i == 301 || i == HardCoderJNI.SCENE_QUIT_CHATTING || i == 303) {
            IDKey iDKey = new IDKey();
            iDKey.SetID(558);
            iDKey.SetKey(15);
            iDKey.SetValue(1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(iDKey);
            com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, true);
        }
    }

    private void tB(int i) {
        ag.y(new a(this, i));
    }

    private void dO(long j) {
        if (this.mrc) {
            this.fAA.field_wifiDownloadedLength = j;
            h.bdA().U(this.fAA.field_musicId, j);
            h.bdA().bL(this.fAA.field_musicId, 1);
            h.bdA().V(this.fAA.field_musicId, j);
        } else {
            this.fAA.field_downloadedLength = j;
            h.bdA().W(this.fAA.field_musicId, j);
            h.bdA().bM(this.fAA.field_musicId, 1);
            h.bdA().X(this.fAA.field_musicId, j);
        }
        ag.y(new a(this, 2));
    }

    private void y(long j, long j2) {
        if (this.mrc) {
            this.fAA.field_wifiDownloadedLength = j;
            h.bdA().U(this.fAA.field_musicId, j);
            h.bdA().bL(this.fAA.field_musicId, 0);
            h.bdA().V(this.fAA.field_musicId, j2);
        } else {
            this.fAA.field_downloadedLength = j;
            h.bdA().W(this.fAA.field_musicId, j);
            h.bdA().bM(this.fAA.field_musicId, 0);
            h.bdA().X(this.fAA.field_musicId, j2);
        }
        ag.y(new a(this, 3));
    }

    private static long[] Gu(String str) {
        if (bh.ov(str)) {
            return null;
        }
        try {
            String[] split = str.replace("bytes", "").trim().split("-");
            long longValue = Long.valueOf(split[0]).longValue();
            split = split[1].split("/");
            long longValue2 = Long.valueOf(split[0]).longValue();
            long longValue3 = Long.valueOf(split[1]).longValue();
            return new long[]{longValue, longValue2, longValue3};
        } catch (Exception e) {
            return null;
        }
    }
}
