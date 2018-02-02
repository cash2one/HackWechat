package com.tencent.smtt.utils;

import android.content.Context;
import android.provider.Settings.System;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public final class n {
    private static n AaT = null;
    private static Context mContext = null;

    private n() {
    }

    static void abp(String str) {
        DataOutputStream dataOutputStream;
        Throwable th;
        if (f.cFr()) {
            DataOutputStream dataOutputStream2 = null;
            try {
                File file = new File(f.cFs(), "ins.dat");
                if (!file.exists()) {
                    file.createNewFile();
                }
                dataOutputStream = new DataOutputStream(new BufferedOutputStream(f.V(file)));
                try {
                    dataOutputStream.writeUTF(str);
                    dataOutputStream.flush();
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    dataOutputStream2 = dataOutputStream;
                    if (dataOutputStream2 != null) {
                        dataOutputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                if (dataOutputStream2 != null) {
                    dataOutputStream2.close();
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                dataOutputStream = null;
                th = th4;
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                throw th;
            }
        }
    }

    static void abq(String str) {
        try {
            System.putString(mContext.getContentResolver(), "sys_setting_tbs_qb_installer", str);
        } catch (Exception e) {
        }
    }

    public static n hV(Context context) {
        mContext = context.getApplicationContext();
        if (AaT == null) {
            AaT = new n();
        }
        return AaT;
    }
}
