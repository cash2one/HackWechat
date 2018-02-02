package com.tencent.mapsdk.rastercore;

import android.graphics.Point;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.b.a;
import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.c.b;
import com.tencent.mapsdk.rastercore.c.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class d$a {
    public static double a(LatLng latLng, LatLng latLng2) {
        double longitude = latLng.getLongitude();
        double latitude = latLng.getLatitude();
        longitude *= 0.01745329251994329d;
        latitude *= 0.01745329251994329d;
        double longitude2 = latLng2.getLongitude() * 0.01745329251994329d;
        double latitude2 = latLng2.getLatitude() * 0.01745329251994329d;
        double sin = Math.sin(longitude);
        double sin2 = Math.sin(latitude);
        longitude = Math.cos(longitude);
        latitude = Math.cos(latitude);
        double sin3 = Math.sin(longitude2);
        double sin4 = Math.sin(latitude2);
        longitude2 = Math.cos(longitude2);
        latitude2 = Math.cos(latitude2);
        r18 = new double[3];
        double[] dArr = new double[]{longitude * latitude, latitude * sin, sin2};
        dArr[0] = latitude2 * longitude2;
        dArr[1] = latitude2 * sin3;
        dArr[2] = sin4;
        return Math.asin(Math.sqrt((((r18[0] - dArr[0]) * (r18[0] - dArr[0])) + ((r18[1] - dArr[1]) * (r18[1] - dArr[1]))) + ((r18[2] - dArr[2]) * (r18[2] - dArr[2]))) / 2.0d) * 1.27420015798544E7d;
    }

    public static LatLng a(c cVar) {
        return new LatLng((double) ((float) (57.29577951308232d * ((2.0d * Math.atan(Math.exp((((double) ((float) ((cVar.a() * 180.0d) / 2.003750834E7d))) * 3.141592653589793d) / 180.0d))) - 1.5707963267948966d))), (double) ((float) ((cVar.b() * 180.0d) / 2.003750834E7d)));
    }

    public static c a(PointF pointF, c cVar, PointF pointF2, a aVar) {
        return new c(cVar.b() + (((double) (pointF.x - pointF2.x)) * aVar.d()), cVar.a() - (((double) (pointF.y - pointF2.y)) * aVar.d()));
    }

    public static c a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new c((latLng.getLongitude() * 2.003750834E7d) / 180.0d, ((Math.log(Math.tan(((latLng.getLatitude() + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d);
    }

    public static com.tencent.mapsdk.rastercore.c.a a(float f, Point point) {
        com.tencent.mapsdk.rastercore.c.a eVar = new e();
        eVar.a(f);
        eVar.a(point);
        return eVar;
    }

    public static com.tencent.mapsdk.rastercore.c.a a(CameraPosition cameraPosition) {
        com.tencent.mapsdk.rastercore.c.a cVar = new com.tencent.mapsdk.rastercore.c.c();
        cVar.a(cameraPosition);
        return cVar;
    }

    public static com.tencent.mapsdk.rastercore.c.a a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        com.tencent.mapsdk.rastercore.c.a bVar = new b();
        bVar.a(latLngBounds);
        bVar.c(i3);
        bVar.a(i);
        bVar.b(i2);
        return bVar;
    }

    public static d$a a() {
        return a.a;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static boolean a(byte[] bArr, String str) {
        IOException e;
        Throwable th;
        Closeable fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                a(fileOutputStream);
                return true;
            } catch (IOException e2) {
                e = e2;
                try {
                    new StringBuilder("saveData error:").append(e.toString());
                    a(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    a(fileOutputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            new StringBuilder("saveData error:").append(e.toString());
            a(fileOutputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            a(fileOutputStream);
            throw th;
        }
    }

    public static byte[] a(InputStream inputStream) {
        Closeable byteArrayOutputStream;
        IOException e;
        Throwable th;
        byte[] bArr = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr2 = new byte[Downloads.RECV_BUFFER_SIZE];
                while (true) {
                    int read = inputStream.read(bArr2, 0, Downloads.RECV_BUFFER_SIZE);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
                a(byteArrayOutputStream);
            } catch (IOException e2) {
                e = e2;
                try {
                    new StringBuilder("IO:").append(e.toString());
                    a(byteArrayOutputStream);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    a(byteArrayOutputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            byteArrayOutputStream = bArr;
            new StringBuilder("IO:").append(e.toString());
            a(byteArrayOutputStream);
            return bArr;
        } catch (Throwable th3) {
            byteArrayOutputStream = bArr;
            th = th3;
            a(byteArrayOutputStream);
            throw th;
        }
        return bArr;
    }

    public static byte[] a(String str) {
        Exception e;
        Throwable th;
        byte[] bArr = null;
        Closeable fileInputStream;
        Closeable byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = bArr;
                try {
                    new StringBuilder("get ").append(str).append("failed:").append(e.toString());
                    a(fileInputStream);
                    a(byteArrayOutputStream);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    a(fileInputStream);
                    a(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                byteArrayOutputStream = bArr;
                th = th3;
                a(fileInputStream);
                a(byteArrayOutputStream);
                throw th;
            }
            try {
                byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                a(fileInputStream);
                a(byteArrayOutputStream);
            } catch (Exception e3) {
                e = e3;
                new StringBuilder("get ").append(str).append("failed:").append(e.toString());
                a(fileInputStream);
                a(byteArrayOutputStream);
                return bArr;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            new StringBuilder("get ").append(str).append("failed:").append(e.toString());
            a(fileInputStream);
            a(byteArrayOutputStream);
            return bArr;
        } catch (Throwable th32) {
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            th = th32;
            a(fileInputStream);
            a(byteArrayOutputStream);
            throw th;
        }
        return bArr;
    }

    public static String b() {
        StringBuilder stringBuilder = new StringBuilder(com.tencent.mapsdk.rastercore.tile.a.a.a().b());
        b(stringBuilder.toString());
        stringBuilder.append("bingLogo.dat");
        return stringBuilder.toString();
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return true;
            }
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            return file.mkdirs();
        } catch (Exception e) {
            return false;
        }
    }

    public static String c() {
        b(com.tencent.mapsdk.rastercore.tile.a.a.a().b());
        return com.tencent.mapsdk.rastercore.tile.a.a.a().b() + "/frontier.dat";
    }

    private static String d() {
        String b = com.tencent.mapsdk.rastercore.tile.a.a.a().b();
        b(b);
        return b + "cache.info";
    }

    public final int a(int i, int i2) {
        Throwable th;
        int i3 = -1;
        Closeable closeable = null;
        Closeable fileInputStream;
        try {
            File file = new File(d());
            if (!file.exists()) {
                file.createNewFile();
            }
            fileInputStream = new FileInputStream(file);
            try {
                String property;
                Properties properties = new Properties();
                properties.load(fileInputStream);
                switch (i2) {
                    case 0:
                        property = properties.getProperty("tencent_version__" + i, String.valueOf(b.a));
                        break;
                    case 1:
                        property = properties.getProperty("tencent_clean_version", String.valueOf(b.b));
                        break;
                    case 2:
                        property = properties.getProperty("bing_version__" + i, String.valueOf(b.c));
                        break;
                    case 3:
                        property = properties.getProperty("satelite_version", String.valueOf(b.d));
                        break;
                    default:
                        a(fileInputStream);
                        break;
                }
                i3 = Integer.parseInt(property);
                a(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                a(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            a(fileInputStream);
            throw th;
        }
        return i3;
    }

    public final int a(String str, boolean z) {
        Closeable fileInputStream;
        Exception exception;
        Throwable th;
        Closeable closeable = null;
        String d = d();
        try {
            File file = new File(d);
            if (file.exists() && file.isFile()) {
                fileInputStream = new FileInputStream(file);
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    String str2 = str + "_style";
                    if (z) {
                        str2 = str2 + "_bing";
                    }
                    Object property = properties.getProperty(str2, "1000");
                    if (!TextUtils.isEmpty(property)) {
                        int parseInt = Integer.parseInt(property);
                        a(fileInputStream);
                        return parseInt;
                    }
                } catch (Exception e) {
                    Exception exception2 = e;
                    closeable = fileInputStream;
                    exception = exception2;
                    try {
                        new StringBuilder("error read file:").append(d).append(" with error:").append(exception.getMessage());
                        a(closeable);
                        return 1000;
                    } catch (Throwable th2) {
                        th = th2;
                        a(closeable);
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    closeable = fileInputStream;
                    th = th4;
                    a(closeable);
                    throw th;
                }
            }
            fileInputStream = null;
            a(fileInputStream);
        } catch (Exception e2) {
            exception = e2;
            new StringBuilder("error read file:").append(d).append(" with error:").append(exception.getMessage());
            a(closeable);
            return 1000;
        }
        return 1000;
    }

    public final boolean a(int i, int i2, int i3) {
        Closeable fileInputStream;
        Closeable closeable;
        Throwable th;
        Throwable th2;
        Closeable closeable2 = null;
        try {
            Properties properties = new Properties();
            File file = new File(d());
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    closeable = fileInputStream;
                } catch (Throwable th3) {
                    th = th3;
                    closeable = fileInputStream;
                    fileInputStream = null;
                    th2 = th;
                    a(closeable);
                    a(fileInputStream);
                    throw th2;
                }
            }
            closeable = null;
            switch (i2) {
                case 0:
                    properties.put("tencent_version__" + i, String.valueOf(i3));
                    break;
                case 1:
                    properties.put("tencent_clean_version", String.valueOf(i3));
                    break;
                case 2:
                    properties.put("bing_version__" + i, String.valueOf(i3));
                    break;
                case 3:
                    properties.put("satelite_version", String.valueOf(i3));
                    break;
            }
            try {
                fileInputStream = new FileOutputStream(file);
                try {
                    properties.store(fileInputStream, "mapinfo");
                    a(closeable);
                    a(fileInputStream);
                    return true;
                } catch (Throwable th4) {
                    th2 = th4;
                    a(closeable);
                    a(fileInputStream);
                    throw th2;
                }
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                th2 = th;
                a(closeable);
                a(fileInputStream);
                throw th2;
            }
        } catch (Throwable th52) {
            closeable = null;
            th2 = th52;
            fileInputStream = null;
            a(closeable);
            a(fileInputStream);
            throw th2;
        }
    }

    public final boolean a(String str, int i, boolean z) {
        Closeable fileInputStream;
        Closeable closeable;
        Exception e;
        Throwable th;
        Closeable closeable2 = null;
        String d = d();
        try {
            Properties properties = new Properties();
            File file = new File(d);
            if (file.exists() && file.isFile()) {
                fileInputStream = new FileInputStream(d);
                try {
                    properties.load(fileInputStream);
                    fileInputStream.close();
                    closeable = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        new StringBuilder("error read file:").append(d).append(" with error:").append(e.getMessage());
                        a(fileInputStream);
                        a(closeable2);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = fileInputStream;
                        a(closeable);
                        a(closeable2);
                        throw th;
                    }
                }
            }
            closeable = null;
            try {
                Object obj = str + "_style";
                if (z) {
                    obj = obj + "_bing";
                }
                properties.put(obj, String.valueOf(i));
                fileInputStream = new FileOutputStream(d);
            } catch (Exception e3) {
                e = e3;
                fileInputStream = closeable;
                new StringBuilder("error read file:").append(d).append(" with error:").append(e.getMessage());
                a(fileInputStream);
                a(closeable2);
                return false;
            } catch (Throwable th3) {
                th = th3;
                a(closeable);
                a(closeable2);
                throw th;
            }
            try {
                properties.store(fileInputStream, "mapinfo");
                a(closeable);
                a(fileInputStream);
            } catch (Exception e4) {
                e = e4;
                closeable2 = fileInputStream;
                fileInputStream = closeable;
                new StringBuilder("error read file:").append(d).append(" with error:").append(e.getMessage());
                a(fileInputStream);
                a(closeable2);
                return false;
            } catch (Throwable th4) {
                th = th4;
                closeable2 = fileInputStream;
                a(closeable);
                a(closeable2);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            new StringBuilder("error read file:").append(d).append(" with error:").append(e.getMessage());
            a(fileInputStream);
            a(closeable2);
            return false;
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            a(closeable);
            a(closeable2);
            throw th;
        }
        return false;
    }
}
