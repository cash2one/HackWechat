package com.tencent.qqmusic.mediaplayer.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class CpuInfoUtil$OutputCpuThread extends Thread {
    public boolean isStop = false;

    public CpuInfoUtil$OutputCpuThread(String str) {
        super(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        Process exec;
        BufferedReader bufferedReader;
        Throwable e;
        BufferedReader bufferedReader2 = null;
        super.run();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            exec = Runtime.getRuntime().exec("top -m 10 -s cpu -t");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                int i = 0;
                while (true) {
                    int i2;
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null || this.isStop) {
                            try {
                                break;
                            } catch (Throwable e2) {
                                Logger.e("CpuInfoUtil", e2);
                            }
                        } else {
                            i2 = i + 1;
                            stringBuilder.append(readLine).append("\n");
                            if (i2 > 15) {
                                Logger.d("CpuInfoUtil", stringBuilder.toString());
                                stringBuilder.delete(0, stringBuilder.length() - 1);
                                sleep(5000);
                                i = 0;
                            } else {
                                i = i2;
                            }
                        }
                    } catch (Throwable e22) {
                        Logger.e("CpuInfoUtil", e22);
                        i = i2;
                    } catch (Throwable th) {
                        e22 = th;
                    }
                }
                bufferedReader.close();
                if (exec != null) {
                    exec.destroy();
                }
            } catch (Exception e3) {
                e22 = e3;
                try {
                    Logger.e("CpuInfoUtil", e22);
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Throwable e222) {
                            Logger.e("CpuInfoUtil", e222);
                        }
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                } catch (Throwable th2) {
                    e222 = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e4) {
                            Logger.e("CpuInfoUtil", e4);
                        }
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw e222;
                }
            } catch (Throwable th3) {
                e222 = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (exec != null) {
                    exec.destroy();
                }
                throw e222;
            }
        } catch (Exception e5) {
            e222 = e5;
            exec = null;
            Logger.e("CpuInfoUtil", e222);
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (exec != null) {
                exec.destroy();
            }
        } catch (Throwable th4) {
            e222 = th4;
            exec = null;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (exec != null) {
                exec.destroy();
            }
            throw e222;
        }
    }
}
