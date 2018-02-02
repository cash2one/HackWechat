package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.eclipse.jdt.annotation.Nullable;

public final class j implements f {
    private aj a;

    public j(aj ajVar) {
        this.a = ajVar;
    }

    public final int a() {
        return this.a.a;
    }

    public final String a(String str) {
        return this.a.a(str);
    }

    public final String b() {
        return this.a.b;
    }

    public final int c() {
        return this.a.c;
    }

    public final byte[] d() {
        return this.a.d;
    }

    public static byte[] a(File file) {
        IOException e;
        Throwable th;
        if (!file.exists()) {
            return new byte[0];
        }
        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
        Closeable bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        bArr = byteArrayOutputStream.toByteArray();
                        a(bufferedInputStream);
                        a(byteArrayOutputStream);
                        return bArr;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
            try {
                throw e;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            a(bufferedInputStream);
            a(byteArrayOutputStream);
            throw th;
        }
    }

    public static int a(Context context) {
        Object obj;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return -1;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType();
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public static boolean b(Context context) {
        boolean z = true;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            z = false;
        }
        if (z) {
            return false;
        }
        try {
            boolean isConnected;
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo2 != null) {
                isConnected = networkInfo2.isConnected();
                if (!(isConnected || networkInfo == null)) {
                    isConnected = networkInfo.isConnected();
                }
            } else {
                isConnected = false;
            }
            return isConnected;
        } catch (Exception e) {
            return false;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            String str2 = "";
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                stringBuilder.append(Integer.toHexString(b & 255)).append(str2);
            }
            str = stringBuilder.toString();
        } catch (Exception e) {
        }
        return str;
    }

    private static String d(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            String str2 = "";
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() != 2) {
                    toHexString = "0" + toHexString;
                }
                stringBuilder.append(toHexString).append(str2);
            }
            str = stringBuilder.toString().substring(8, 24);
        } catch (Exception e) {
        }
        return str;
    }

    public static int c(Context context) {
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(8192);
            String[] split = "B2E6AD38C9EA55FC,8B51908CDE852ABE,6F350C90F0B8C2F7,18A9EF1D9AFDB74D,B0F7B644A29E1C82,2E0111E09CC76BBD,8FFA91856B5C9ED1,569EA369CE0CE6BE,490A7AD1901C1407,15A805FD6A78BF07,92DFF18D49ED5200,D80FF7253FEDC748,2044A6443164DDC8,488324C2DC64A6D5,E0EC01B2D80C2E57".split(",");
            for (PackageInfo packageInfo : installedPackages) {
                for (String equalsIgnoreCase : split) {
                    if (d(packageInfo.packageName).equalsIgnoreCase(equalsIgnoreCase)) {
                        return 1;
                    }
                }
            }
            try {
                context.getPackageManager();
                split = "B2E6AD38C9EA55FC,8B51908CDE852ABE,6F350C90F0B8C2F7,18A9EF1D9AFDB74D,B0F7B644A29E1C82,2E0111E09CC76BBD,8FFA91856B5C9ED1,569EA369CE0CE6BE,490A7AD1901C1407,15A805FD6A78BF07,92DFF18D49ED5200,D80FF7253FEDC748,2044A6443164DDC8,488324C2DC64A6D5,E0EC01B2D80C2E57".split(",");
                for (File file : new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "Android" + File.separatorChar + SlookAirButtonFrequentContactAdapter.DATA).listFiles()) {
                    for (String equalsIgnoreCase2 : split) {
                        if (d(file.getName()).equalsIgnoreCase(equalsIgnoreCase2)) {
                            return 1;
                        }
                    }
                }
                return 2;
            } catch (Throwable th) {
                return 3;
            }
        } catch (Throwable th2) {
            return 3;
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr, 0, bArr.length);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public static byte[] b(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return null;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        Object obj = new byte[0];
        Object obj2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            try {
                Object obj3;
                int read = inflaterInputStream.read(obj2);
                if (read > 0) {
                    i += read;
                    obj3 = new byte[i];
                    System.arraycopy(obj, 0, obj3, 0, obj.length);
                    System.arraycopy(obj2, 0, obj3, obj.length, read);
                } else {
                    obj3 = obj;
                }
                if (read <= 0) {
                    try {
                        byteArrayInputStream.close();
                        inflaterInputStream.close();
                        return obj3;
                    } catch (IOException e) {
                        return null;
                    }
                }
                obj = obj3;
            } catch (Exception e2) {
                return null;
            }
        }
    }
}
