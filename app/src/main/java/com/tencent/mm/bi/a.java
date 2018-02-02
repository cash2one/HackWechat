package com.tencent.mm.bi;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import org.json.JSONObject;

public final class a {
    private static String gZL = "";
    public static Set<String> hZq;
    public static int hZr = 1;

    private static String cd(boolean z) {
        if (z && c.vdg) {
            ar.Hg();
            return com.tencent.mm.z.c.FC();
        }
        if (bh.ov(gZL)) {
            gZL = e.gZL.replace("/data/user/0", "/data/data");
        }
        return gZL;
    }

    public static String Vg() {
        File file;
        if (aw.cgc() > 1048576) {
            file = new File(cd(false), "wenote/res");
        } else {
            file = new File(e.bnF, "wenote/res");
        }
        return file.getAbsolutePath();
    }

    public static String Vh() {
        File file = new File(cd(false), "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            return file.getAbsolutePath();
        }
        file = new File(e.bnF, "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            return file.getAbsolutePath();
        }
        return "";
    }

    public static String Vi() {
        File file = new File(cd(true), "wenote/loc/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String Vj() {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(cd(false), "wenote/html/upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        return stringBuilder.append(file.getAbsolutePath()).append("/wenoteupload.htm").toString();
    }

    public static String Vk() {
        File file = new File(cd(true), "wenote/image/localpath");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String Vl() {
        File file = new File(cd(true), "wenote/voice/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static int Nj() {
        InputStream fileInputStream;
        Throwable e;
        try {
            fileInputStream = new FileInputStream(new File(Vh(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        x.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", new Object[]{str, Integer.valueOf(new JSONObject(str).getInt("version"))});
                        com.tencent.mm.a.e.c(fileInputStream);
                        return r0;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.c(fileInputStream);
                    return 1;
                } catch (Throwable th) {
                    e = th;
                    com.tencent.mm.a.e.c(fileInputStream);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.c(fileInputStream);
            return 1;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            com.tencent.mm.a.e.c(fileInputStream);
            throw e;
        }
    }

    public static int Nk() {
        InputStream open;
        Reader inputStreamReader;
        Reader bufferedReader;
        Throwable e;
        InputStream inputStream;
        Reader reader = null;
        try {
            open = ac.getContext().getAssets().open("wenote_config.conf");
            try {
                inputStreamReader = new InputStreamReader(open);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    reader = inputStreamReader;
                    inputStream = open;
                    try {
                        x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                        com.tencent.mm.a.e.c(inputStream);
                        com.tencent.mm.a.e.a(reader);
                        com.tencent.mm.a.e.a(bufferedReader);
                        return 1;
                    } catch (Throwable th) {
                        e = th;
                        open = inputStream;
                        inputStreamReader = reader;
                        com.tencent.mm.a.e.c(open);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(bufferedReader);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    bufferedReader = null;
                    com.tencent.mm.a.e.c(open);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    throw e;
                }
                try {
                    String str = "";
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            str = str + readLine;
                        } else {
                            x.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", new Object[]{str, Integer.valueOf(new JSONObject(str).getInt("version"))});
                            com.tencent.mm.a.e.c(open);
                            com.tencent.mm.a.e.a(inputStreamReader);
                            com.tencent.mm.a.e.a(bufferedReader);
                            return r0;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    reader = inputStreamReader;
                    inputStream = open;
                    x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.c(inputStream);
                    com.tencent.mm.a.e.a(reader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    return 1;
                } catch (Throwable th3) {
                    e = th3;
                    com.tencent.mm.a.e.c(open);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                inputStream = open;
                x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                com.tencent.mm.a.e.c(inputStream);
                com.tencent.mm.a.e.a(reader);
                com.tencent.mm.a.e.a(bufferedReader);
                return 1;
            } catch (Throwable th4) {
                e = th4;
                bufferedReader = null;
                inputStreamReader = null;
                com.tencent.mm.a.e.c(open);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(bufferedReader);
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            inputStream = null;
            x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.c(inputStream);
            com.tencent.mm.a.e.a(reader);
            com.tencent.mm.a.e.a(bufferedReader);
            return 1;
        } catch (Throwable th5) {
            e = th5;
            bufferedReader = null;
            inputStreamReader = null;
            open = null;
            com.tencent.mm.a.e.c(open);
            com.tencent.mm.a.e.a(inputStreamReader);
            com.tencent.mm.a.e.a(bufferedReader);
            throw e;
        }
    }
}
