package com.google.android.exoplayer2.h;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.h.q.c;
import com.google.android.exoplayer2.h.q.d;
import com.google.android.exoplayer2.h.q.e;
import com.google.android.exoplayer2.h.q.f;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.t;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class n implements q {
    private static final Pattern aBn = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> aBo = new AtomicReference();
    private final t<? super n> aAB;
    private InputStream aAC;
    private long aBA;
    private final boolean aBp;
    private final int aBq;
    private final int aBr;
    private final String aBs;
    private final l<String> aBt;
    private final f aBu;
    private final f aBv;
    private HttpURLConnection aBw;
    private long aBx;
    private long aBy;
    private long aBz;
    private i asH;
    private boolean opened;

    public n(String str, t<? super n> tVar, int i, int i2, boolean z, f fVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.aBs = str;
        this.aBt = null;
        this.aAB = tVar;
        this.aBv = new f();
        this.aBq = i;
        this.aBr = i2;
        this.aBp = z;
        this.aBu = fVar;
    }

    public final Uri getUri() {
        return this.aBw == null ? null : Uri.parse(this.aBw.getURL().toString());
    }

    public final long a(i iVar) {
        HttpURLConnection a;
        String headerField;
        this.asH = iVar;
        this.aBA = 0;
        this.aBz = 0;
        URL url = new URL(iVar.uri.toString());
        byte[] bArr = iVar.aAJ;
        long j = iVar.position;
        long j2 = iVar.aAL;
        boolean lq = iVar.lq();
        int i;
        if (this.aBp) {
            i = 0;
            while (true) {
                int i2 = i + 1;
                if (i <= 20) {
                    try {
                        a = a(url, bArr, j, j2, lq, false);
                        int responseCode = a.getResponseCode();
                        if (responseCode != 300 && responseCode != 301 && responseCode != HardCoderJNI.SCENE_QUIT_CHATTING && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                            break;
                        }
                        bArr = null;
                        headerField = a.getHeaderField("Location");
                        a.disconnect();
                        if (headerField == null) {
                            throw new ProtocolException("Null location redirect");
                        }
                        URL url2 = new URL(url, headerField);
                        headerField = url2.getProtocol();
                        if ("https".equals(headerField) || "http".equals(headerField)) {
                            url = url2;
                            i = i2;
                        } else {
                            throw new ProtocolException("Unsupported protocol redirect: " + headerField);
                        }
                    } catch (IOException e) {
                        throw new c("Unable to connect to " + iVar.uri.toString(), e, iVar);
                    }
                }
                throw new NoRouteToHostException("Too many redirects: " + i2);
            }
        }
        a = a(url, bArr, j, j2, lq, true);
        this.aBw = a;
        try {
            i = this.aBw.getResponseCode();
            b.i("DefaultHttpDataSource", "open, responseCode:%d", Integer.valueOf(i));
            if (i < 200 || i > 299) {
                Map headerFields = this.aBw.getHeaderFields();
                lw();
                e eVar = new e(i, headerFields, iVar);
                if (i == 416) {
                    eVar.initCause(new g());
                }
                throw eVar;
            }
            headerField = this.aBw.getContentType();
            if (this.aBt == null || this.aBt.X(headerField)) {
                long j3 = (i != 200 || iVar.position == 0) ? 0 : iVar.position;
                this.aBx = j3;
                if (iVar.lq()) {
                    this.aBy = iVar.aAL;
                } else if (iVar.aAL != -1) {
                    this.aBy = iVar.aAL;
                } else {
                    j3 = a(this.aBw);
                    this.aBy = j3 != -1 ? j3 - this.aBx : -1;
                }
                try {
                    this.aAC = this.aBw.getInputStream();
                    this.opened = true;
                    if (this.aAB != null) {
                        this.aAB.ls();
                    }
                    return this.aBy;
                } catch (IOException e2) {
                    lw();
                    throw new c(e2, iVar, 1);
                }
            }
            lw();
            throw new d(headerField, iVar);
        } catch (IOException e22) {
            lw();
            throw new c("Unable to connect to " + iVar.uri.toString(), e22, iVar);
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        try {
            if (this.aBz != this.aBx) {
                Object obj = (byte[]) aBo.getAndSet(null);
                if (obj == null) {
                    obj = new byte[Downloads.RECV_BUFFER_SIZE];
                }
                while (this.aBz != this.aBx) {
                    int read = this.aAC.read(obj, 0, (int) Math.min(this.aBx - this.aBz, (long) obj.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read == -1) {
                        throw new EOFException();
                    } else {
                        this.aBz += (long) read;
                        if (this.aAB != null) {
                            this.aAB.cQ(read);
                        }
                    }
                }
                aBo.set(obj);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.aBy != -1) {
                long j = this.aBy - this.aBA;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.aAC.read(bArr, i, i2);
            if (read2 != -1) {
                this.aBA += (long) read2;
                if (this.aAB == null) {
                    return read2;
                }
                this.aAB.cQ(read2);
                return read2;
            } else if (this.aBy == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new c(e, this.asH, 2);
        }
    }

    public final void close() {
        try {
            if (this.aAC != null) {
                HttpURLConnection httpURLConnection = this.aBw;
                long j = this.aBy == -1 ? this.aBy : this.aBy - this.aBA;
                if (t.SDK_INT == 19 || t.SDK_INT == 20) {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (j != -1 ? j <= 2048 : inputStream.read() == -1) {
                            String name = inputStream.getClass().getName();
                            if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                                Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                declaredMethod.setAccessible(true);
                                declaredMethod.invoke(inputStream, new Object[0]);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                this.aAC.close();
            }
            this.aAC = null;
            lw();
            if (this.opened) {
                this.opened = false;
                if (this.aAB != null) {
                    this.aAB.lt();
                }
            }
        } catch (IOException e2) {
            throw new c(e2, this.asH, 3);
        } catch (Throwable th) {
            this.aAC = null;
            lw();
            if (this.opened) {
                this.opened = false;
                if (this.aAB != null) {
                    this.aAB.lt();
                }
            }
        }
    }

    private HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.aBq);
        httpURLConnection.setReadTimeout(this.aBr);
        if (this.aBu != null) {
            for (Entry entry : this.aBu.lx().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Entry entry2 : this.aBv.lx().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.aBs);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private static long a(HttpURLConnection httpURLConnection) {
        long j = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException e) {
                b.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]", new Object[0]);
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = aBn.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return parseLong;
            }
            if (j == parseLong) {
                return j;
            }
            b.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]", new Object[0]);
            return Math.max(j, parseLong);
        } catch (NumberFormatException e2) {
            b.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]", new Object[0]);
            return j;
        }
    }

    private void lw() {
        if (this.aBw != null) {
            try {
                this.aBw.disconnect();
            } catch (Exception e) {
                b.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.aBw = null;
        }
    }
}
