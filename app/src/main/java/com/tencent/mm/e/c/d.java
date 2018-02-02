package com.tencent.mm.e.c;

import com.tencent.mm.e.b.g$a;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqpinyin.voicerecoapi.a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class d implements a {
    BlockingQueue<g$a> fmm = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    boolean fmn = false;
    String fmo;
    private a fmy;
    private a fmz;
    private FileOutputStream mFileOutputStream;

    public final boolean cL(String str) {
        x.i("MicroMsg.SpeexWriter", "initWriter, path: " + str);
        if (str == null) {
            return false;
        }
        this.fmo = str;
        try {
            this.mFileOutputStream = new FileOutputStream(new File(str));
            this.fmy = new a();
            int cCZ = this.fmy.cCZ();
            if (cCZ == 0) {
                return true;
            }
            x.e("MicroMsg.SpeexWriter", "speexInit failed: " + cCZ);
            return false;
        } catch (Exception e) {
            if (this.mFileOutputStream != null) {
                try {
                    this.mFileOutputStream.close();
                } catch (IOException e2) {
                }
            }
            x.e("MicroMsg.SpeexWriter", "Error on init file: ", new Object[]{e});
            return false;
        }
    }

    public final int a(g$a com_tencent_mm_e_b_g_a, int i) {
        return a(com_tencent_mm_e_b_g_a, 0, false);
    }

    public final int a(g$a com_tencent_mm_e_b_g_a, int i, boolean z) {
        if (this.fmy == null || com_tencent_mm_e_b_g_a.buf == null || com_tencent_mm_e_b_g_a.flp == 0) {
            x.e("MicroMsg.SpeexWriter", "try write invalid data to file");
            return -1;
        }
        try {
            byte[] R = this.fmy.R(com_tencent_mm_e_b_g_a.buf, com_tencent_mm_e_b_g_a.flp);
            if (R == null || R.length <= 0) {
                x.e("MicroMsg.SpeexWriter", "convert failed: " + (R == null ? "outBuffer is null" : "size is zero"));
                return -1;
            }
            x.d("MicroMsg.SpeexWriter", "write to file, len: %d", new Object[]{Integer.valueOf(R.length)});
            this.mFileOutputStream.write(R);
            this.mFileOutputStream.flush();
            return R.length;
        } catch (Exception e) {
            x.e("MicroMsg.SpeexWriter", "write to file failed", new Object[]{e});
            return -1;
        }
    }

    public final void vE() {
        x.i("MicroMsg.SpeexWriter", "wait Stop");
        synchronized (this) {
            this.fmn = true;
        }
        if (this.fmz != null) {
            try {
                e.S(this.fmz);
                this.fmz = null;
            } catch (InterruptedException e) {
                x.e("MicroMsg.SpeexWriter", "thread speex interrupted");
            }
        }
        if (this.fmy != null) {
            this.fmy.cDa();
            this.fmy = null;
        }
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e2) {
                x.e("MicroMsg.SpeexWriter", "close silk file: " + this.fmo + "msg: " + e2.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    public final boolean vF() {
        if (this.fmy != null) {
            this.fmy.cDa();
            this.fmy = null;
        }
        this.fmy = new a();
        int cCZ = this.fmy.cCZ();
        if (cCZ == 0) {
            return true;
        }
        x.e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: " + cCZ);
        return false;
    }

    public static boolean B(String str, String str2) {
        FileInputStream fileInputStream;
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            x.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + file.length());
            try {
                a aVar = new a();
                if (aVar.cCZ() != 0) {
                    x.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
                    aVar.cDa();
                    return false;
                }
                b.deleteFile(str2);
                File file2 = new File(str2);
                file2.createNewFile();
                file2.setReadable(true);
                try {
                    byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read > 0) {
                            byte[] R = aVar.R(bArr, read);
                            if (R == null) {
                                fileInputStream2.close();
                                return false;
                            }
                            try {
                                x.i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + com.tencent.mm.a.e.d(str2, R) + ", readLen = " + read);
                            } catch (Exception e) {
                                fileInputStream = fileInputStream2;
                            }
                        } else {
                            fileInputStream2.close();
                            aVar.cDa();
                            x.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - currentTimeMillis));
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    aVar.cDa();
                    return false;
                }
            } catch (Exception e3) {
                x.e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + e3.getMessage());
                return false;
            }
        }
        x.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
        return false;
    }
}
