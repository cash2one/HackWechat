package com.tencent.mm.modelvideo;

import android.media.MediaExtractor;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.IOException;

public final class q {
    private static String K(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    public static boolean nm(String str) {
        Throwable e;
        Throwable th;
        x.d("MicroMsg.VideoFile", " filepath " + str);
        if (bh.ov(str)) {
            return false;
        }
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[10];
                fileInputStream.read(bArr, 0, 10);
                String K = K(bArr);
                if (!bh.ov(K)) {
                    K = K.toUpperCase();
                    x.d("MicroMsg.VideoFile", "file type " + K);
                    if (K.contains("00000014667479707174")) {
                        x.d("MicroMsg.VideoFile", "file type qt ");
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                        return true;
                    }
                }
                try {
                    fileInputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bh.i(e)});
                    if (fileInputStream != null) {
                        return false;
                    }
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (IOException e5) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e7) {
            e = e7;
            fileInputStream = null;
            x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bh.i(e)});
            if (fileInputStream != null) {
                return false;
            }
            fileInputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static boolean nn(String str) {
        Throwable e;
        Throwable th;
        if (!e.bO(str)) {
            return false;
        }
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[32];
                fileInputStream.read(bArr, 0, 32);
                String K = K(bArr);
                if (bh.ov(K) || !K.toUpperCase().contains("68766331")) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (IOException e2) {
                        return false;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                }
                return true;
            } catch (Exception e4) {
                e = e4;
                try {
                    x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bh.i(e)});
                    if (fileInputStream != null) {
                        return false;
                    }
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (IOException e5) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e7) {
            e = e7;
            fileInputStream = null;
            x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bh.i(e)});
            if (fileInputStream != null) {
                return false;
            }
            fileInputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static boolean no(String str) {
        MediaExtractor mediaExtractor;
        String string;
        Throwable th;
        Throwable th2;
        Throwable th3;
        MediaExtractor mediaExtractor2 = null;
        if (!e.bO(str)) {
            return false;
        }
        x.d("MicroMsg.VideoFile", "check is h265 video %s", new Object[]{str});
        try {
            mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                int trackCount = mediaExtractor.getTrackCount();
                for (int i = 0; i < trackCount; i++) {
                    try {
                        string = mediaExtractor.getTrackFormat(i).getString("mime");
                    } catch (Throwable th4) {
                        th2 = th4;
                    }
                    try {
                        if ("video/hevc".equalsIgnoreCase(string)) {
                            mediaExtractor.release();
                            return true;
                        }
                    } catch (Throwable th42) {
                        th2 = th42;
                    }
                    if ("video/hevc".equalsIgnoreCase(string)) {
                        mediaExtractor.release();
                        return true;
                    }
                }
                mediaExtractor.release();
                return false;
            } catch (Throwable th422) {
                th2 = th422;
            }
        } catch (Throwable th5) {
            th2 = th5;
            mediaExtractor = null;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            throw th2;
        }
    }

    public static boolean np(String str) {
        FileInputStream fileInputStream;
        Throwable e;
        Throwable th;
        x.d("MicroMsg.VideoFile", " filepath " + str);
        if (bh.ov(str)) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[7];
                fileInputStream.read(bArr, 0, 7);
                String K = K(bArr);
                if (!bh.ov(K)) {
                    K = K.toUpperCase();
                    x.d("MicroMsg.VideoFile", "file type " + K);
                    if (K.contains("234558544D3355")) {
                        x.d("MicroMsg.VideoFile", "it is m3u8 file");
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                        return true;
                    }
                }
                try {
                    fileInputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bh.i(e)});
                    if (fileInputStream != null) {
                        return false;
                    }
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (IOException e5) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e7) {
            e = e7;
            fileInputStream = null;
            x.e("MicroMsg.VideoFile", "exception:%s", new Object[]{bh.i(e)});
            if (fileInputStream != null) {
                return false;
            }
            fileInputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }
}
