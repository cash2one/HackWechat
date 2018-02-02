package com.tencent.mm.plugin.music.model.f;

import android.text.TextUtils;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.music.model.b.b;
import com.tencent.mm.plugin.music.model.b.c$a;
import com.tencent.mm.plugin.music.model.b.d;
import com.tencent.mm.plugin.music.model.b.e;
import com.tencent.mm.plugin.music.model.b.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.BitSet;
import java.util.Map;
import java.util.Map.Entry;

public final class c implements IMediaHTTPConnection {
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;
    private HttpURLConnection mConnection = null;
    private long mCurrentOffset = -1;
    private Map<String, String> mHeaders = null;
    private InputStream mInputStream = null;
    private String mMimeType = "";
    private long mTotalSize = -1;
    private URL mURL = null;
    private b oLR;
    public URL oLS = null;

    public final boolean connect(URL url, Map<String, String> map) {
        Logger.i("MicroMsg.MMMediaHTTPConnection", "connect");
        Logger.i("MicroMsg.MMMediaHTTPConnection", "connect: uri=" + url + ", headers=" + map);
        disconnect();
        this.mAllowCrossDomainRedirect = true;
        this.mURL = url;
        this.oLS = url;
        this.mHeaders = map;
        this.mTotalSize = -1;
        this.mMimeType = "";
        String Gi = d.Gi(this.mURL.toString());
        if (!TextUtils.isEmpty(Gi) && !Gi.equalsIgnoreCase(this.mURL.toString())) {
            x.i("MicroMsg.MMMediaHTTPConnection", "use temp shake music url to play:%s", new Object[]{Gi});
            try {
                this.mURL = new URL(Gi);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMMediaHTTPConnection", e, "playUrl", new Object[0]);
            }
        } else if (d.Gj(this.mURL.toString())) {
            x.i("MicroMsg.MMMediaHTTPConnection", "play url :%s", new Object[]{d.Gk(Gi)});
            try {
                this.mURL = new URL(d.Gk(Gi));
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMMediaHTTPConnection", e2, "removeUrl", new Object[0]);
            }
        }
        if (this.mURL != null) {
            e.i(this.mURL.toString(), map);
            Logger.i("MicroMsg.MMMediaHTTPConnection", "headers=" + map);
        }
        this.oLR = new b(this);
        b bVar = this.oLR;
        String url2 = bVar.oLa.oLS.toString();
        bVar.oLb = new com.tencent.mm.plugin.music.model.b.c(url2);
        bVar.oLb.ieE = bVar.oLa.getSize();
        com.tencent.mm.plugin.music.model.b.c cVar = bVar.oLb;
        x.i("MicroMsg.IndexBitMgr", "initData");
        if (cVar.ieE <= 0) {
            x.e("MicroMsg.IndexBitMgr", "fileLength is invalid!");
        } else {
            if (cVar.ieE % 8192 == 0 || cVar.ieE < 8192) {
                cVar.count = (int) (cVar.ieE / 8192);
            } else {
                cVar.count = ((int) (cVar.ieE / 8192)) + 1;
            }
            if (cVar.ieE <= 8192) {
                x.i("MicroMsg.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
                cVar.count = 1;
            }
            x.i("MicroMsg.IndexBitMgr", "fileLength:%d, count:%d", new Object[]{Long.valueOf(cVar.ieE), Integer.valueOf(cVar.count)});
            cVar.oLf = new BitSet(cVar.count);
            cVar.oLg = e.Gm(cVar.mUrl);
            if (TextUtils.isEmpty(cVar.oLg)) {
                x.e("MicroMsg.IndexBitMgr", "initData musicId is null!'");
            } else {
                x.i("MicroMsg.IndexBitMgr", "musicId:%s", new Object[]{cVar.oLg});
                com.tencent.mm.plugin.music.model.h.b Gy = h.bdD().Gy(cVar.oLg);
                if (Gy == null) {
                    x.e("MicroMsg.IndexBitMgr", "initData pMusic is null!'");
                } else {
                    x.i("MicroMsg.IndexBitMgr", "initData music field_fileCacheComplete:%d", new Object[]{Integer.valueOf(Gy.field_fileCacheComplete)});
                    if (Gy.field_indexBitData == null) {
                        x.e("MicroMsg.IndexBitMgr", "initData field_indexBitData is null!'");
                    } else {
                        cVar.oLf = c$a.aB(Gy.field_indexBitData);
                        if (cVar.oLf == null) {
                            x.e("MicroMsg.IndexBitMgr", "initData bitSet is null");
                            cVar.oLf = new BitSet(cVar.count);
                        } else if (cVar.count < cVar.oLf.cardinality()) {
                            x.e("MicroMsg.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", new Object[]{Integer.valueOf(cVar.count), Integer.valueOf(cVar.oLf.cardinality())});
                            cVar.clearCache();
                        }
                        x.i("MicroMsg.IndexBitMgr", "initData bitSet:" + cVar.oLf.toString());
                        x.i("MicroMsg.IndexBitMgr", "initData bitSet count %d, cardinality:" + cVar.count + "," + cVar.oLf.cardinality());
                    }
                }
            }
        }
        bVar.oLc = new f(url2);
        if (!new File(bVar.oLc.fileName).exists()) {
            x.i("MicroMsg.FileBytesCacheMgr", "piece file not exist, clear cache!");
            bVar.oLb.clearCache();
        } else if (bVar.oLc.bel() != bVar.oLa.getSize() && bVar.oLa.getSize() != -1) {
            x.i("MicroMsg.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
            bVar.oLb.clearCache();
            f fVar = bVar.oLc;
            Logger.i("MicroMsg.PieceFileCache", "deleteFile");
            f.deleteFile(fVar.fileName);
        } else if (bVar.oLa.getSize() == -1) {
            x.i("MicroMsg.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
        } else {
            x.i("MicroMsg.FileBytesCacheMgr", "piece file exist!");
        }
        long size = bVar.oLa.getSize();
        f fVar2 = bVar.oLc;
        Logger.i("MicroMsg.PieceFileCache", "open");
        try {
            File file = new File(fVar2.fileName);
            if (!file.exists()) {
                x.i("MicroMsg.PieceFileCache", "create file:%b", new Object[]{Boolean.valueOf(file.createNewFile())});
            }
            fVar2.randomAccessFile = new RandomAccessFile(file, "rws");
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[]{fVar2.fileName});
        } catch (Throwable e22) {
            Logger.e("MicroMsg.PieceFileCache", "file not found", e22);
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[]{fVar2.fileName});
        } catch (Throwable e222) {
            Logger.e("MicroMsg.PieceFileCache", "io ", e222);
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[]{fVar2.fileName});
        } catch (Throwable th) {
            Logger.e("MicroMsg.PieceFileCache", "create RandomAccessFile file  %s  success", new Object[]{fVar2.fileName});
        }
        bVar.oLc.setLength(size);
        e.T(url2, size);
        x.i("MicroMsg.FileBytesCacheMgr", "attach() fileLength is " + size + ",pieceFileCache length is " + bVar.oLc.getLength());
        Gi = bVar.oLa.getMIMEType();
        if (!(TextUtils.isEmpty(Gi) || "application/octet-stream".equalsIgnoreCase(Gi))) {
            e.dx(url2, Gi);
            e.dy(url2, Gi);
        }
        bVar.wn = -1;
        bVar.hX = 0;
        bVar.oLd = -1;
        bVar.oLe = 0;
        return true;
    }

    public final void disconnect() {
        Logger.i("MicroMsg.MMMediaHTTPConnection", "disconnect");
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
        if (this.oLR != null) {
            b bVar = this.oLR;
            bVar.bej();
            bVar.oLb.bek();
            bVar.oLc.close();
            bVar.oLa = null;
            x.i("MicroMsg.FileBytesCacheMgr", "detach()");
            this.oLR = null;
        }
    }

    private void teardownConnection() {
        if (this.mConnection != null) {
            this.mInputStream = null;
            this.mConnection.disconnect();
            this.mConnection = null;
            this.mCurrentOffset = -1;
        }
    }

    private static final boolean isLocalHost(URL url) {
        if (url == null) {
            return false;
        }
        String host = url.getHost();
        if (host == null) {
            return false;
        }
        try {
            if (host.equalsIgnoreCase("localhost")) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "isLocalHost IllegalArgumentException:%s", new Object[]{String.valueOf(e)});
            return false;
        }
    }

    private void seekTo(long j) {
        Object obj;
        teardownConnection();
        int i = 0;
        try {
            int i2;
            String requestMethod;
            URL url = this.mURL;
            boolean isLocalHost = isLocalHost(url);
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (isLocalHost) {
                    this.mConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
                } else {
                    this.mConnection = (HttpURLConnection) url.openConnection();
                }
                this.mConnection.setConnectTimeout(30000);
                this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
                String str = "Accept-Encoding";
                Object obj2 = null;
                if (this.mHeaders != null) {
                    for (Entry entry : this.mHeaders.entrySet()) {
                        this.mConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        if (obj2 == null && str.equals(entry.getKey())) {
                            obj = 1;
                        } else {
                            obj = obj2;
                        }
                        obj2 = obj;
                    }
                }
                if (j > 0) {
                    try {
                        this.mConnection.setRequestProperty("Range", "bytes=" + j + "-");
                    } catch (IOException e) {
                        obj = e;
                        i = i4;
                    }
                }
                if (obj2 == null) {
                    this.mConnection.setRequestProperty(str, "");
                }
                i = this.mConnection.getResponseCode();
                e.bJ(this.oLS.toString(), i);
                if (i != 300 && i != 301 && i != HardCoderJNI.SCENE_QUIT_CHATTING && i != 303 && i != 307) {
                    break;
                }
                i2 = i3 + 1;
                if (i2 > 20) {
                    throw new NoRouteToHostException("Too many redirects: " + i2);
                }
                requestMethod = this.mConnection.getRequestMethod();
                if (i != 307 || requestMethod.equals("GET") || requestMethod.equals("HEAD")) {
                    String headerField = this.mConnection.getHeaderField("Location");
                    if (headerField == null) {
                        throw new NoRouteToHostException("Invalid redirect");
                    }
                    url = new URL(this.mURL, headerField);
                    if (url.getProtocol().equals("https") || url.getProtocol().equals("http")) {
                        boolean equals = this.mURL.getProtocol().equals(url.getProtocol());
                        if (this.mAllowCrossProtocolRedirect || equals) {
                            equals = this.mURL.getHost().equals(url.getHost());
                            if (this.mAllowCrossDomainRedirect || equals) {
                                if (i != 307) {
                                    this.mURL = url;
                                }
                                i3 = i2;
                                i4 = i;
                            } else {
                                throw new NoRouteToHostException("Cross-domain redirects are disallowed");
                            }
                        }
                        throw new NoRouteToHostException("Cross-protocol redirects are disallowed");
                    }
                    throw new NoRouteToHostException("Unsupported protocol redirect");
                }
                throw new NoRouteToHostException("Invalid redirect");
            }
            if (this.mAllowCrossDomainRedirect) {
                this.mURL = this.mConnection.getURL();
            }
            if (i == com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX) {
                requestMethod = this.mConnection.getHeaderField("Content-Range");
                this.mTotalSize = -1;
                if (requestMethod != null) {
                    i2 = requestMethod.lastIndexOf(47);
                    if (i2 >= 0) {
                        try {
                            this.mTotalSize = bh.getLong(requestMethod.substring(i2 + 1), 0);
                        } catch (NumberFormatException e2) {
                        }
                    }
                }
            } else if (i != 200) {
                throw new IOException();
            } else {
                this.mTotalSize = (long) this.mConnection.getContentLength();
            }
            if (j <= 0 || i == com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX) {
                this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
                this.mCurrentOffset = j;
                return;
            }
            throw new ProtocolException();
        } catch (IOException e3) {
            obj = e3;
            this.mTotalSize = -1;
            this.mInputStream = null;
            this.mConnection = null;
            this.mCurrentOffset = -1;
            Logger.e("MicroMsg.MMMediaHTTPConnection", "seekTo exception:%s", new Object[]{obj + ", response:" + i});
            throw obj;
        }
    }

    public final int readAt(byte[] bArr, int i, int i2) {
        try {
            int size;
            if (this.oLR != null) {
                b bVar = this.oLR;
                if (bArr == null || i < 0 || i2 < 0) {
                    x.e("MicroMsg.FileBytesCacheMgr", "read() params is invalid, offset:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                } else if (bVar.oLa.getSize() <= 0) {
                    x.e("MicroMsg.FileBytesCacheMgr", "read()，fileLength is error, file length is " + bVar.oLa.getSize());
                } else {
                    if (((long) (i + i2)) > bVar.oLa.getSize()) {
                        x.e("MicroMsg.FileBytesCacheMgr", "read() endOffset is error,  startOffset %d, endOffset:%d, file length:%d ", new Object[]{Integer.valueOf(i), Integer.valueOf(i + i2), Long.valueOf(bVar.oLa.getSize())});
                        size = ((int) bVar.oLa.getSize()) - i;
                    } else {
                        size = i2;
                    }
                    if (bVar.oLb.cT(i, size)) {
                        size = bVar.oLc.b(bArr, (long) i, size);
                        if (size > 0) {
                            if (size != i2) {
                                return size;
                            }
                            Logger.i("MicroMsg.MMMediaHTTPConnection", "read from cache, n%d, size %d " + size + "," + i2);
                            return size;
                        }
                    }
                }
                size = -1;
                if (size > 0) {
                    if (size != i2) {
                        return size;
                    }
                    Logger.i("MicroMsg.MMMediaHTTPConnection", "read from cache, n%d, size %d " + size + "," + i2);
                    return size;
                }
            }
            if (this.mTotalSize <= 0 || ((long) i) < this.mTotalSize || i2 <= 0) {
                Logger.d("MicroMsg.MMMediaHTTPConnection", "read from network");
                if (((long) i) != this.mCurrentOffset) {
                    seekTo((long) i);
                }
                size = this.mInputStream.read(bArr, 0, i2);
                if (size == -1) {
                    size = 0;
                }
                this.mCurrentOffset += (long) size;
                if (this.oLR == null) {
                    return size;
                }
                b bVar2 = this.oLR;
                if (bArr == null || i < 0 || size < 0) {
                    x.e("MicroMsg.FileBytesCacheMgr", "write() params is invalid, offset:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(size)});
                    return size;
                } else if (bVar2.oLa.getSize() <= 0) {
                    x.e("MicroMsg.FileBytesCacheMgr", "write() fileLength is error, file length is " + bVar2.oLa.getSize());
                    return size;
                } else {
                    int i3 = i + size;
                    if (((long) i3) > bVar2.oLa.getSize()) {
                        x.e("MicroMsg.FileBytesCacheMgr", "write() endOffset is error, endOffset:%d, file length:%d", new Object[]{Integer.valueOf(i3), Long.valueOf(bVar2.oLa.getSize())});
                        return size;
                    }
                    if (((long) i3) == bVar2.oLa.getSize()) {
                        bVar2.bej();
                        bVar2.tw(i);
                        bVar2.p(bArr, i, size);
                        bVar2.bej();
                        bVar2.tw(i);
                        return size;
                    } else if (!bVar2.tu(i) || !bVar2.tu(i3)) {
                        bVar2.bej();
                        bVar2.tw(i);
                        bVar2.p(bArr, i, size);
                        return size;
                    } else if (bVar2.tv(i) && bVar2.tv(i3)) {
                        return size;
                    } else {
                        if (bVar2.tv(i)) {
                            bVar2.p(bArr, i, size);
                            return size;
                        }
                        bVar2.bej();
                        bVar2.tw(i);
                        bVar2.p(bArr, i, size);
                        return size;
                    }
                }
            }
            x.e("MicroMsg.MMMediaHTTPConnection", "offset is illegal, mTotalSize:%d, offset:%d, size:%d", new Object[]{Long.valueOf(this.mTotalSize), Integer.valueOf(i), Integer.valueOf(i2)});
            return 0;
        } catch (ProtocolException e) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => " + e);
            e.bK(this.oLS.toString(), 750);
            return -1010;
        } catch (NoRouteToHostException e2) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => " + e2);
            e.bK(this.oLS.toString(), 751);
            return -1010;
        } catch (UnknownServiceException e3) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => " + e3);
            e.bK(this.oLS.toString(), 752);
            return -1010;
        } catch (IOException e4) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => -1 " + e4);
            e.bK(this.oLS.toString(), 753);
            return -1;
        } catch (Exception e5) {
            Logger.e("MicroMsg.MMMediaHTTPConnection", "unknown exception " + e5);
            Logger.e("MicroMsg.MMMediaHTTPConnection", "readAt " + i + " / " + i2 + " => -1");
            e.bK(this.oLS.toString(), 754);
            return -1;
        }
    }

    public final long getSize() {
        if (this.mTotalSize > 0) {
            return this.mTotalSize;
        }
        if (e.Gq(this.oLS.toString()) > 0) {
            this.mTotalSize = e.Gq(this.oLS.toString());
            return this.mTotalSize;
        }
        if (this.mConnection == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                seekTo(0);
                x.d("MicroMsg.MMMediaHTTPConnection", "getSize cost time :%d!", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            } catch (IOException e) {
                Logger.e("MicroMsg.MMMediaHTTPConnection", "getSize exception:%s", new Object[]{String.valueOf(e)});
                this.mTotalSize = -1;
            }
        }
        if (this.mTotalSize > 0) {
            return this.mTotalSize;
        }
        if (e.Gr(this.oLS.toString()) <= 0) {
            return -1;
        }
        this.mTotalSize = e.Gr(this.oLS.toString());
        return this.mTotalSize;
    }

    public final String getMIMEType() {
        if (TextUtils.isEmpty(this.mMimeType)) {
            String Gp = e.Gp(this.oLS.toString());
            if (TextUtils.isEmpty(Gp)) {
                long currentTimeMillis;
                if (this.mConnection == null) {
                    try {
                        currentTimeMillis = System.currentTimeMillis();
                        seekTo(0);
                        Gp = this.mConnection.getContentType();
                        x.d("MicroMsg.MMMediaHTTPConnection", "getMIMEType cost time :%d!", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    } catch (IOException e) {
                        Logger.e("MicroMsg.MMMediaHTTPConnection", "getMIMEType exception:%s", new Object[]{String.valueOf(e)});
                        Gp = "";
                    }
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                    Gp = this.mConnection.getContentType();
                    Logger.i("MicroMsg.MMMediaHTTPConnection", "getMIMEType mimeType:" + Gp);
                    x.d("MicroMsg.MMMediaHTTPConnection", "getMIMEType cost time 2 :%d!", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
                this.mMimeType = Gp;
                if (!TextUtils.isEmpty(Gp)) {
                    return Gp;
                }
                Gp = e.Go(this.oLS.toString());
                this.mMimeType = Gp;
                return TextUtils.isEmpty(Gp) ? "application/octet-stream" : Gp;
            } else {
                this.mMimeType = Gp;
                return Gp;
            }
        }
        Logger.i("MicroMsg.MMMediaHTTPConnection", "getMIMEType mimeType:" + this.mMimeType);
        return this.mMimeType;
    }

    public final String getUri() {
        return this.mURL.toString();
    }
}
