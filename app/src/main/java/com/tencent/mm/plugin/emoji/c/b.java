package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.a.e;
import com.tencent.mm.ak.a;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONObject;

public final class b extends c<bc> {
    public b() {
        this.xen = bc.class.getName().hashCode();
    }

    private static boolean a(bc bcVar) {
        InputStream fileInputStream;
        Reader inputStreamReader;
        Throwable th;
        Throwable e;
        int i;
        if (bcVar instanceof bc) {
            String readLine;
            if (bcVar.fpl.fpm == 33) {
                File file = new File(bcVar.fpl.filePath);
                if (file.exists()) {
                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                    File file2 = new File(a.Nh(), "temp");
                    File file3 = new File(file2, "emoji_template.zip");
                    file2.mkdirs();
                    e.x(file.getAbsolutePath(), file3.getAbsolutePath());
                    if (bh.ft(file3.getAbsolutePath(), file2.getAbsolutePath()) >= 0) {
                        Reader reader;
                        try {
                            String str;
                            fileInputStream = new FileInputStream(new File(file2, "config.conf"));
                            try {
                                inputStreamReader = new InputStreamReader(fileInputStream);
                            } catch (Throwable e2) {
                                reader = null;
                                inputStreamReader = null;
                                th = e2;
                                i = 1;
                                try {
                                    x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                    e.c(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    e.g(file2);
                                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                    if (a.huR >= i) {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                                    } else {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                                        a.n(file);
                                    }
                                    return false;
                                } catch (Throwable th2) {
                                    e2 = th2;
                                    e.c(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    throw e2;
                                }
                            } catch (Throwable th3) {
                                e2 = th3;
                                reader = null;
                                inputStreamReader = null;
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                throw e2;
                            }
                            try {
                                reader = new BufferedReader(inputStreamReader);
                                try {
                                    str = "";
                                    while (true) {
                                        readLine = reader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        str = str + readLine;
                                    }
                                    i = new JSONObject(str).getInt("version");
                                } catch (Throwable e22) {
                                    th = e22;
                                    i = 1;
                                    x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                    e.c(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    e.g(file2);
                                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                    if (a.huR >= i) {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                                        a.n(file);
                                    } else {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                                    }
                                    return false;
                                }
                            } catch (Throwable e222) {
                                reader = null;
                                th = e222;
                                i = 1;
                                x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                e.g(file2);
                                com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                if (a.huR >= i) {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                                } else {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                                    a.n(file);
                                }
                                return false;
                            } catch (Throwable th4) {
                                e222 = th4;
                                reader = null;
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                throw e222;
                            }
                            try {
                                x.d("MicroMsg.emoji.EmojiResUpdateListener", "config file content:%s version:%d", new Object[]{str, Integer.valueOf(i)});
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                            } catch (Exception e3) {
                                th = e3;
                                x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                e.g(file2);
                                com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                if (a.huR >= i) {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                                    a.n(file);
                                } else {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                                }
                                return false;
                            }
                        } catch (Throwable e2222) {
                            reader = null;
                            inputStreamReader = null;
                            fileInputStream = null;
                            th = e2222;
                            i = 1;
                            x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                            e.c(fileInputStream);
                            e.a(inputStreamReader);
                            e.a(reader);
                            e.g(file2);
                            com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                            if (a.huR >= i) {
                                x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                            } else {
                                x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                                a.n(file);
                            }
                            return false;
                        } catch (Throwable th5) {
                            e2222 = th5;
                            reader = null;
                            inputStreamReader = null;
                            fileInputStream = null;
                            e.c(fileInputStream);
                            e.a(inputStreamReader);
                            e.a(reader);
                            throw e2222;
                        }
                    }
                    i = 1;
                    e.g(file2);
                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                    if (a.huR >= i) {
                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                        a.n(file);
                    } else {
                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.huR), Integer.valueOf(i)});
                    }
                } else {
                    x.e("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener file not exist");
                }
            } else if (bcVar.fpl.fpm == 37) {
                if (bcVar.fpl.fpn == 1) {
                    i.aBg().a(bcVar, false);
                } else if (bcVar.fpl.fpn == 2) {
                    i.aBg().b(bcVar, false);
                } else if (bcVar.fpl.fpn == 3) {
                    if (!i.aBg().a(bcVar, i.a.lwm)) {
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest need no update.");
                    } else if (i.a(bcVar, i.a.lwm, i.lvQ)) {
                        r1 = new File(new File(i.aBh(), i.lvQ), i.lwb);
                        if (r1.exists()) {
                            i.B(r1);
                        } else {
                            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest config don't exist.");
                        }
                    } else {
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest unzip file failed.");
                    }
                } else if (bcVar.fpl.fpn == 5) {
                    if (i.aBg().a(bcVar, i.a.lwo)) {
                        if (i.a(bcVar, i.a.lwo, i.lvR)) {
                            r1 = new File(new File(i.aBh(), i.lvR), i.lwc);
                            if (r1.exists()) {
                                i.C(r1);
                            } else {
                                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                            }
                        } else {
                            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                        }
                    }
                } else if (bcVar.fpl.fpn == 4) {
                    i.aBg();
                    x.d("MicroMsg.emoji.EmojiResUpdateMgr", "updateAppleColorEmoji");
                    if (i.b(bcVar)) {
                        com.tencent.mm.bx.b.cgX();
                        readLine = bcVar.fpl.filePath;
                        com.tencent.mm.bx.b.cgY();
                        k.fp(readLine, com.tencent.mm.bx.b.xkq);
                        com.tencent.mm.bx.b.cgX().init();
                    }
                }
            }
        }
        return false;
    }
}
