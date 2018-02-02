package com.qq.wx.voice.embed.recognizer;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;

final class f {
    private boolean a = false;
    String b = null;

    f() {
    }

    private static boolean a(String str, String str2) {
        return new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString()).exists();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String b(String str, String str2) {
        File file = new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString());
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            ByteBuffer map = fileInputStream.getChannel().map(MapMode.READ_ONLY, 0, file.length());
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(map);
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            try {
                fileInputStream.close();
                return bigInteger;
            } catch (IOException e) {
                return bigInteger;
            }
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (IOException e3) {
            }
        }
    }

    private static boolean c(String str, String[] strArr) {
        for (String compareTo : strArr) {
            if (str.compareTo(compareTo) == 0) {
                return true;
            }
        }
        return false;
    }

    private static void e(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileChannel channel;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream2;
        Throwable th;
        FileChannel fileChannel = null;
        File file = new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString());
        File file2 = new File(new StringBuilder(String.valueOf(str3)).append("/").append(str).toString());
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    channel = fileInputStream.getChannel();
                    try {
                        fileChannel = fileOutputStream.getChannel();
                        channel.transferTo(0, channel.size(), fileChannel);
                        try {
                            fileInputStream.close();
                            channel.close();
                            fileOutputStream.close();
                            fileChannel.close();
                        } catch (IOException e) {
                        }
                    } catch (IOException e2) {
                        fileInputStream2 = fileInputStream;
                        try {
                            fileInputStream2.close();
                            channel.close();
                            fileOutputStream.close();
                            fileChannel.close();
                        } catch (IOException e3) {
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileOutputStream2 = fileOutputStream;
                        th = th3;
                        try {
                            fileInputStream.close();
                            channel.close();
                            fileOutputStream2.close();
                            fileChannel.close();
                        } catch (IOException e4) {
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    channel = null;
                    fileInputStream2 = fileInputStream;
                    fileInputStream2.close();
                    channel.close();
                    fileOutputStream.close();
                    fileChannel.close();
                } catch (Throwable th4) {
                    fileOutputStream2 = fileOutputStream;
                    th = th4;
                    channel = null;
                    fileInputStream.close();
                    channel.close();
                    fileOutputStream2.close();
                    fileChannel.close();
                    throw th;
                }
            } catch (IOException e6) {
                channel = null;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                fileInputStream2.close();
                channel.close();
                fileOutputStream.close();
                fileChannel.close();
            } catch (Throwable th5) {
                th = th5;
                channel = null;
                fileOutputStream2 = null;
                fileInputStream.close();
                channel.close();
                fileOutputStream2.close();
                fileChannel.close();
                throw th;
            }
        } catch (IOException e7) {
            channel = null;
            fileOutputStream = null;
            fileInputStream2 = null;
            fileInputStream2.close();
            channel.close();
            fileOutputStream.close();
            fileChannel.close();
        } catch (Throwable th6) {
            th = th6;
            channel = null;
            fileOutputStream2 = null;
            fileInputStream = null;
            fileInputStream.close();
            channel.close();
            fileOutputStream2.close();
            fileChannel.close();
            throw th;
        }
    }

    public final int a(Context context, String str, String str2, String str3) {
        if (this.a) {
            return 0;
        }
        if (!a("libwxvoiceembed.so", str)) {
            return -201;
        }
        if (!a("libwxvoiceembed.bin", str)) {
            return -202;
        }
        String stringBuilder = new StringBuilder(String.valueOf(context.getFilesDir().getAbsolutePath())).append("/NamesSearch/").toString();
        File file = new File(stringBuilder);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!a("libwxvoiceembed.so", stringBuilder)) {
            e("libwxvoiceembed.so", str, stringBuilder);
        }
        if (!a("libwxvoiceembed.bin", stringBuilder)) {
            e("libwxvoiceembed.bin", str, stringBuilder);
        }
        try {
            String b = b("libwxvoiceembed.so", stringBuilder);
            if (b.compareTo(b("libwxvoiceembed.so", str)) != 0) {
                e("libwxvoiceembed.so", str, stringBuilder);
            }
            if (!c(b, str2.split(";"))) {
                return -203;
            }
            try {
                String b2 = b("libwxvoiceembed.bin", stringBuilder);
                if (b2.compareTo(b("libwxvoiceembed.bin", str)) != 0) {
                    e("libwxvoiceembed.bin", str, stringBuilder);
                }
                if (!c(b2, str3.split(";"))) {
                    return -204;
                }
                this.b = stringBuilder;
                this.a = true;
                return 0;
            } catch (FileNotFoundException e) {
                return -204;
            }
        } catch (FileNotFoundException e2) {
            return -203;
        }
    }

    public final int d(String str, String str2, String str3) {
        if (this.a) {
            return 0;
        }
        if (!a("libwxvoiceembed.so", str)) {
            return -201;
        }
        if (!a("libwxvoiceembed.bin", str)) {
            return -202;
        }
        try {
            if (!c(b("libwxvoiceembed.so", str), str2.split(";"))) {
                return -203;
            }
            try {
                if (!c(b("libwxvoiceembed.bin", str), str3.split(";"))) {
                    return -204;
                }
                this.b = str;
                this.a = true;
                return 0;
            } catch (FileNotFoundException e) {
                return -204;
            }
        } catch (FileNotFoundException e2) {
            return -203;
        }
    }
}
