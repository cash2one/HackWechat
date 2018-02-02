package com.tencent.mm.sdk.e;

import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class a {
    private String filePath;
    private Properties xjw;

    public a(String str) {
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        this.xjw = null;
        this.filePath = null;
        this.xjw = new Properties();
        this.filePath = str;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                this.xjw.load(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e2.getLocalizedMessage());
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e22.getLocalizedMessage());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e4.getLocalizedMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            x.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public final boolean fv(String str, String str2) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        try {
            fileOutputStream = new FileOutputStream(this.filePath);
            try {
                this.xjw.setProperty(str, str2);
                this.xjw.store(fileOutputStream, "");
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e2) {
                    x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e2.getLocalizedMessage());
                    return true;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e22) {
                        x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e22.getLocalizedMessage());
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            x.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e4.getLocalizedMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            x.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public final boolean ai(String str, long j) {
        return fv(str, String.valueOf(j));
    }

    public final boolean cX(String str, int i) {
        return fv(str, String.valueOf(i));
    }

    public final String getValue(String str) {
        if (this.xjw == null || !this.xjw.containsKey(str)) {
            return null;
        }
        return this.xjw.getProperty(str);
    }

    public final Long Wa(String str) {
        Long l = null;
        String value = getValue(str);
        if (value != null) {
            try {
                l = Long.valueOf(Long.parseLong(value));
            } catch (Exception e) {
                x.e("MicroMsg.ReadConfig", "getLongValue ParseLong : %s Failed. [%s]", value, e.getLocalizedMessage());
            }
        }
        return l;
    }

    public final Integer Wb(String str) {
        Integer num = null;
        String value = getValue(str);
        if (value != null) {
            try {
                num = Integer.valueOf(Integer.parseInt(value));
            } catch (Exception e) {
                x.e("MicroMsg.ReadConfig", "getIntegerValue ParseInteger : %s Failed. [%s]", value, e.getLocalizedMessage());
            }
        }
        return num;
    }

    public static String getValue(String str, String str2) {
        return new a(str).getValue(str2);
    }

    public static Long fw(String str, String str2) {
        return new a(str).Wa(str2);
    }

    public static boolean ag(String str, String str2, String str3) {
        return new a(str).fv(str2, str3);
    }

    public static boolean h(String str, String str2, long j) {
        return new a(str).ai(str2, j);
    }
}
