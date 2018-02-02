package com.tencent.mm.plugin.sns.ui;

import android.os.AsyncTask;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

class SnsAdNativeLandingTestUI$a extends AsyncTask<String, Void, Void> {
    private static Set<String> rlL = new HashSet();
    private static byte[] rlM = new byte[0];
    final String fileName;
    final String filePath;
    final af handler;
    final String rlN;
    final String rlO;
    final String rlP;
    final int rlR;
    final a ryM;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return y((String[]) objArr);
    }

    public SnsAdNativeLandingTestUI$a(String str, String str2, af afVar, a aVar) {
        this(str, str2, afVar, aVar, 0);
    }

    public SnsAdNativeLandingTestUI$a(String str, String str2, af afVar, a aVar, int i) {
        FileOp.mh(str);
        this.rlP = str;
        this.fileName = str2;
        this.filePath = str + "/" + str2;
        this.rlO = "temp_" + str2;
        this.rlN = str + "/" + this.rlO;
        this.handler = afVar;
        this.rlR = i;
        this.ryM = new 1(this, afVar, aVar);
    }

    private Void y(String... strArr) {
        InputStream inputStream;
        OutputStream fileOutputStream;
        Exception exception;
        HttpURLConnection httpURLConnection;
        Throwable th;
        Exception exception2;
        HttpURLConnection httpURLConnection2 = null;
        int i = 0;
        synchronized (rlM) {
            if (rlL.contains(strArr[0])) {
            } else {
                rlL.add(strArr[0]);
                try {
                    if (FileOp.bO(this.filePath)) {
                        this.ryM.La(this.filePath);
                        synchronized (rlM) {
                            rlL.remove(strArr[0]);
                        }
                    } else {
                        if (FileOp.bO(this.rlN)) {
                            FileOp.deleteFile(this.rlN);
                        }
                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(strArr[0]).openConnection();
                        try {
                            httpURLConnection3.connect();
                            if (httpURLConnection3.getResponseCode() != 200) {
                                this.ryM.KZ("Server returned HTTP " + httpURLConnection3.getResponseCode() + " " + httpURLConnection3.getResponseMessage());
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                synchronized (rlM) {
                                    rlL.remove(strArr[0]);
                                }
                            } else {
                                httpURLConnection3.getContentLength();
                                inputStream = httpURLConnection3.getInputStream();
                                try {
                                    fileOutputStream = new FileOutputStream(this.rlN);
                                } catch (Exception e) {
                                    fileOutputStream = null;
                                    HttpURLConnection httpURLConnection4 = httpURLConnection3;
                                    exception = e;
                                    httpURLConnection = httpURLConnection4;
                                    try {
                                        this.ryM.KZ(exception.getMessage());
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e2) {
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                synchronized (rlM) {
                                                    rlL.remove(strArr[0]);
                                                }
                                                return null;
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        synchronized (rlM) {
                                            rlL.remove(strArr[0]);
                                        }
                                        return null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        httpURLConnection2 = httpURLConnection;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e3) {
                                                if (httpURLConnection2 != null) {
                                                    httpURLConnection2.disconnect();
                                                }
                                                synchronized (rlM) {
                                                    rlL.remove(strArr[0]);
                                                }
                                                throw th;
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        synchronized (rlM) {
                                            rlL.remove(strArr[0]);
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    fileOutputStream = null;
                                    httpURLConnection2 = httpURLConnection3;
                                    th = th3;
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    synchronized (rlM) {
                                        rlL.remove(strArr[0]);
                                    }
                                    throw th;
                                }
                                try {
                                    byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                                    int i2 = 0;
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                        i2 += read;
                                        if (this.rlR != 0 && i2 - r1 >= this.rlR) {
                                            this.ryM.cf(this.rlN, i2);
                                            i = i2;
                                        }
                                    }
                                    FileOp.at(this.rlN, this.filePath);
                                    this.ryM.La(this.filePath);
                                    try {
                                        fileOutputStream.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (IOException e4) {
                                    }
                                    if (httpURLConnection3 != null) {
                                        httpURLConnection3.disconnect();
                                    }
                                    synchronized (rlM) {
                                        rlL.remove(strArr[0]);
                                    }
                                } catch (Exception e5) {
                                    exception2 = e5;
                                    httpURLConnection = httpURLConnection3;
                                    exception = exception2;
                                    this.ryM.KZ(exception.getMessage());
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    synchronized (rlM) {
                                        rlL.remove(strArr[0]);
                                    }
                                    return null;
                                } catch (Throwable th32) {
                                    httpURLConnection2 = httpURLConnection3;
                                    th = th32;
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    synchronized (rlM) {
                                        rlL.remove(strArr[0]);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e52) {
                            fileOutputStream = null;
                            inputStream = null;
                            exception2 = e52;
                            httpURLConnection = httpURLConnection3;
                            exception = exception2;
                            this.ryM.KZ(exception.getMessage());
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            synchronized (rlM) {
                                rlL.remove(strArr[0]);
                            }
                            return null;
                        } catch (Throwable th322) {
                            fileOutputStream = null;
                            inputStream = null;
                            httpURLConnection2 = httpURLConnection3;
                            th = th322;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            synchronized (rlM) {
                                rlL.remove(strArr[0]);
                            }
                            throw th;
                        }
                    }
                } catch (Exception e6) {
                    exception = e6;
                    httpURLConnection = null;
                    fileOutputStream = null;
                    inputStream = null;
                    this.ryM.KZ(exception.getMessage());
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    synchronized (rlM) {
                        rlL.remove(strArr[0]);
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    inputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    synchronized (rlM) {
                        rlL.remove(strArr[0]);
                    }
                    throw th;
                }
            }
        }
        return null;
    }
}
