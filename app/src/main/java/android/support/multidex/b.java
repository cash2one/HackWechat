package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class b {
    private static Method oH;

    static List<File> a(Context context, ApplicationInfo applicationInfo, File file, boolean z) {
        List<File> a;
        Object obj = null;
        new StringBuilder("MultiDexExtractor.load(").append(applicationInfo.sourceDir).append(", ").append(z).append(")");
        File file2 = new File(applicationInfo.sourceDir);
        long d = c.d(file2);
        if (d == -1) {
            d--;
        }
        if (!z) {
            SharedPreferences i = i(context);
            if (!(i.getLong("timestamp", -1) == b(file2) && i.getLong("crc", -1) == d)) {
                obj = 1;
            }
            if (obj == null) {
                try {
                    a = a(context, file2, file);
                } catch (IOException e) {
                }
                new StringBuilder("load found ").append(a.size()).append(" secondary dex files");
                return a;
            }
        }
        a = a(file2, file);
        long b = b(file2);
        int size = a.size() + 1;
        Editor edit = i(context).edit();
        edit.putLong("timestamp", b);
        edit.putLong("crc", d);
        edit.putInt("dex.number", size);
        if (oH != null) {
            try {
                oH.invoke(edit, new Object[0]);
            } catch (InvocationTargetException e2) {
            } catch (IllegalAccessException e3) {
            }
            new StringBuilder("load found ").append(a.size()).append(" secondary dex files");
            return a;
        }
        edit.commit();
        new StringBuilder("load found ").append(a.size()).append(" secondary dex files");
        return a;
    }

    private static List<File> a(Context context, File file, File file2) {
        String str = file.getName() + ".classes";
        int i = i(context).getInt("dex.number", 1);
        List<File> arrayList = new ArrayList(i);
        int i2 = 2;
        while (i2 <= i) {
            File file3 = new File(file2, str + i2 + ".zip");
            if (file3.isFile()) {
                arrayList.add(file3);
                if (c(file3)) {
                    i2++;
                } else {
                    new StringBuilder("Invalid zip file: ").append(file3);
                    throw new IOException("Invalid ZIP file.");
                }
            }
            throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
        }
        return arrayList;
    }

    private static long b(File file) {
        long lastModified = file.lastModified();
        if (lastModified == -1) {
            return lastModified - 1;
        }
        return lastModified;
    }

    private static List<File> a(File file, File file2) {
        String str = file.getName() + ".classes";
        a(file2, str);
        List<File> arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipEntry entry = zipFile.getEntry("classes2" + ".dex");
            int i = 2;
            while (entry != null) {
                File file3 = new File(file2, str + i + ".zip");
                arrayList.add(file3);
                new StringBuilder("Extraction is needed for file ").append(file3);
                boolean z = false;
                int i2 = 0;
                while (i2 < 3 && !z) {
                    int i3 = i2 + 1;
                    a(zipFile, entry, file3, str);
                    boolean c = c(file3);
                    new StringBuilder("Extraction ").append(c ? "success" : "failed").append(" - length ").append(file3.getAbsolutePath()).append(": ").append(file3.length());
                    if (!c) {
                        file3.delete();
                        if (file3.exists()) {
                            new StringBuilder("Failed to delete corrupted secondary dex '").append(file3.getPath()).append("'");
                            z = c;
                            i2 = i3;
                        }
                    }
                    z = c;
                    i2 = i3;
                }
                if (z) {
                    i2 = i + 1;
                    entry = zipFile.getEntry("classes" + i2 + ".dex");
                    i = i2;
                } else {
                    throw new IOException("Could not create zip file " + file3.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    private static SharedPreferences i(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static void a(File file, String str) {
        file.mkdirs();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new 1(str));
            if (listFiles == null) {
                new StringBuilder("Failed to list secondary dex dir content (").append(file.getPath()).append(").");
                return;
            }
            for (File file2 : listFiles) {
                new StringBuilder("Trying to delete old file ").append(file2.getPath()).append(" of size ").append(file2.length());
                if (file2.delete()) {
                    new StringBuilder("Deleted old file ").append(file2.getPath());
                } else {
                    new StringBuilder("Failed to delete old file ").append(file2.getPath());
                }
            }
            return;
        }
        throw new IOException("Failed to create dex directory " + file.getPath());
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        Closeable inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(str, ".zip", file.getParentFile());
        new StringBuilder("Extracting ").append(createTempFile.getPath());
        ZipOutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            new StringBuilder("Renaming to ").append(file.getPath());
            if (createTempFile.renameTo(file)) {
                b(inputStream);
                createTempFile.delete();
                return;
            }
            throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
        } catch (Throwable th) {
            b(inputStream);
            createTempFile.delete();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean c(File file) {
        try {
            new ZipFile(file).close();
            return true;
        } catch (ZipException e) {
            new StringBuilder("File ").append(file.getAbsolutePath()).append(" is not a valid zip file.");
        } catch (IOException e2) {
            new StringBuilder("Got an IOException trying to open zip file: ").append(file.getAbsolutePath());
        }
        return false;
    }

    private static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    static {
        try {
            oH = Editor.class.getMethod("apply", new Class[0]);
        } catch (NoSuchMethodException e) {
            oH = null;
        }
    }
}
