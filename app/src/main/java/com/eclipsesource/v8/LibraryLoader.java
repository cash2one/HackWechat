package com.eclipsesource.v8;

import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class LibraryLoader {
    static final String DELIMITER = System.getProperty("line.separator");
    static final String SEPARATOR = System.getProperty("file.separator");
    static final String SWT_LIB_DIR = ".j2v8";

    LibraryLoader() {
    }

    private static String computeLibraryShortName() {
        String os = getOS();
        return "j2v8" + "_" + os + "_" + getArchSuffix();
    }

    private static String computeLibraryFullName() {
        return "lib" + computeLibraryShortName() + "." + getOSFileExtension();
    }

    static void loadLibrary(String str) {
        if (isAndroid()) {
            System.loadLibrary("j2v8");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String computeLibraryShortName = computeLibraryShortName();
        String computeLibraryFullName = computeLibraryFullName();
        String str2 = System.getProperty("user.dir") + SEPARATOR + "jni" + SEPARATOR + computeLibraryFullName();
        if (!load(computeLibraryFullName, stringBuffer) && !load(computeLibraryShortName, stringBuffer)) {
            if (!new File(str2).exists() || !load(str2, stringBuffer)) {
                if (str == null) {
                    str = System.getProperty("user.home");
                }
                if (!extract(str + SEPARATOR + computeLibraryFullName, computeLibraryFullName, stringBuffer)) {
                    throw new UnsatisfiedLinkError("Could not load J2V8 library. Reasons: " + stringBuffer.toString());
                }
            }
        }
    }

    static boolean load(String str, StringBuffer stringBuffer) {
        try {
            if (str.indexOf(SEPARATOR) != -1) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            return true;
        } catch (UnsatisfiedLinkError e) {
            if (stringBuffer.length() == 0) {
                stringBuffer.append(DELIMITER);
            }
            stringBuffer.append('\t');
            stringBuffer.append(e.getMessage());
            stringBuffer.append(DELIMITER);
            return false;
        }
    }

    static boolean extract(String str, String str2, StringBuffer stringBuffer) {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        boolean z = true;
        File file = new File(str);
        try {
            if (file.exists()) {
                file.delete();
            }
            InputStream resourceAsStream = LibraryLoader.class.getResourceAsStream("/" + str2);
            if (resourceAsStream != null) {
                try {
                    byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                    while (true) {
                        try {
                            int read = resourceAsStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (Throwable th) {
                            inputStream = resourceAsStream;
                            fileOutputStream = fileOutputStream2;
                        }
                    }
                    fileOutputStream2.close();
                    resourceAsStream.close();
                    chmod("755", str);
                    if (load(str, stringBuffer)) {
                        return true;
                    }
                } catch (Throwable th2) {
                    InputStream inputStream2 = resourceAsStream;
                    fileOutputStream = null;
                    inputStream = inputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    file.delete();
                    return false;
                }
            }
        } catch (Throwable th3) {
            z = false;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (z && file.exists()) {
                file.delete();
            }
            return false;
        }
        return false;
    }

    static void chmod(String str, String str2) {
        if (!isWindows()) {
            try {
                Runtime.getRuntime().exec(new String[]{"chmod", str, str2}).waitFor();
            } catch (Throwable th) {
            }
        }
    }

    static String getOsName() {
        return System.getProperty("os.name") + System.getProperty("java.specification.vendor");
    }

    static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    static boolean isMac() {
        return getOsName().startsWith("Mac");
    }

    static boolean isLinux() {
        return getOsName().startsWith("Linux");
    }

    static boolean isNativeClient() {
        return getOsName().startsWith("nacl");
    }

    static boolean isAndroid() {
        return getOsName().contains("Android");
    }

    static String getArchSuffix() {
        String property = System.getProperty("os.arch");
        if (property.equals("i686")) {
            return "x86";
        }
        if (property.equals("amd64")) {
            return "x86_64";
        }
        if (property.equals("nacl")) {
            return "armv7l";
        }
        if (property.equals("aarch64")) {
            return "armv7l";
        }
        return property;
    }

    static String getOSFileExtension() {
        if (isWindows()) {
            return "dll";
        }
        if (isMac()) {
            return "dylib";
        }
        if (isLinux()) {
            return "so";
        }
        if (isNativeClient()) {
            return "so";
        }
        throw new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
    }

    static String getOS() {
        if (isWindows()) {
            return "win32";
        }
        if (isMac()) {
            return "macosx";
        }
        if (isLinux() && !isAndroid()) {
            return "linux";
        }
        if (isAndroid()) {
            return "android";
        }
        throw new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
    }
}
