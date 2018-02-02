package com.tencent.mm.pluginsdk.k;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

public final class d {
    public static final String a(ContentResolver contentResolver, Uri uri) {
        OutputStream fileOutputStream;
        InputStream openInputStream;
        Throwable e;
        if (uri == null) {
            return null;
        }
        String type = contentResolver.getType(uri);
        String b = b(contentResolver, uri);
        if (bh.ov(b)) {
            b = "share_file" + Sd(type);
        }
        File file = new File(e.gHs, b);
        if (FileOp.bO(file.getAbsolutePath())) {
            FileOp.deleteFile(file.getAbsolutePath());
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    com.tencent.mm.a.e.c(openInputStream);
                    com.tencent.mm.a.e.a(fileOutputStream);
                    return null;
                }
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            b = file.getAbsolutePath();
                            com.tencent.mm.a.e.c(openInputStream);
                            com.tencent.mm.a.e.a(fileOutputStream);
                            return b;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                        com.tencent.mm.a.e.c(openInputStream);
                        com.tencent.mm.a.e.a(fileOutputStream);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        com.tencent.mm.a.e.c(openInputStream);
                        com.tencent.mm.a.e.a(fileOutputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                openInputStream = null;
                x.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                com.tencent.mm.a.e.c(openInputStream);
                com.tencent.mm.a.e.a(fileOutputStream);
                return null;
            } catch (Throwable th2) {
                e = th2;
                openInputStream = null;
                com.tencent.mm.a.e.c(openInputStream);
                com.tencent.mm.a.e.a(fileOutputStream);
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            openInputStream = null;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
            com.tencent.mm.a.e.c(openInputStream);
            com.tencent.mm.a.e.a(fileOutputStream);
            return null;
        } catch (Throwable th3) {
            e = th3;
            openInputStream = null;
            fileOutputStream = null;
            com.tencent.mm.a.e.c(openInputStream);
            com.tencent.mm.a.e.a(fileOutputStream);
            throw e;
        }
    }

    private static String b(ContentResolver contentResolver, Uri uri) {
        Cursor query;
        String name;
        Throwable e;
        String[] split;
        try {
            query = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        name = new File(query.getString(0)).getName();
                        if (query != null) {
                            query.close();
                        }
                        return name;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.ShareUtil", e, "getFileName", new Object[0]);
                        split = URLDecoder.decode(uri.toString(), "utf8").split("/");
                        name = split[split.length - 1];
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.ShareUtil", e3, "getFileName From Uri", new Object[0]);
                        name = null;
                    } catch (Throwable th) {
                        e3 = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e3;
                    }
                    if (query != null) {
                        query.close();
                    }
                    return name;
                }
            }
            name = null;
            if (query != null) {
                query.close();
            }
        } catch (Exception e4) {
            e3 = e4;
            query = null;
            x.printErrStackTrace("MicroMsg.ShareUtil", e3, "getFileName", new Object[0]);
            split = URLDecoder.decode(uri.toString(), "utf8").split("/");
            name = split[split.length - 1];
            if (query != null) {
                query.close();
            }
            return name;
        } catch (Throwable th2) {
            e3 = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e3;
        }
        return name;
    }

    public static final String a(ContentResolver contentResolver, Uri uri, int i) {
        OutputStream fileOutputStream;
        InputStream openInputStream;
        Throwable e;
        Throwable th;
        if (uri == null) {
            return null;
        }
        String absolutePath = new File(ac.getContext().getCacheDir(), "share_img_tmp_" + i + Sd(contentResolver.getType(uri))).getAbsolutePath();
        if (FileOp.bO(absolutePath)) {
            FileOp.deleteFile(absolutePath);
        }
        try {
            fileOutputStream = new FileOutputStream(absolutePath);
            try {
                openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    com.tencent.mm.a.e.c(openInputStream);
                    com.tencent.mm.a.e.a(fileOutputStream);
                    return null;
                }
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            com.tencent.mm.a.e.c(openInputStream);
                            com.tencent.mm.a.e.a(fileOutputStream);
                            return absolutePath;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                        com.tencent.mm.a.e.c(openInputStream);
                        com.tencent.mm.a.e.a(fileOutputStream);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        com.tencent.mm.a.e.c(openInputStream);
                        com.tencent.mm.a.e.a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                openInputStream = null;
                x.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                com.tencent.mm.a.e.c(openInputStream);
                com.tencent.mm.a.e.a(fileOutputStream);
                return null;
            } catch (Throwable e4) {
                openInputStream = null;
                th = e4;
                com.tencent.mm.a.e.c(openInputStream);
                com.tencent.mm.a.e.a(fileOutputStream);
                throw th;
            }
        } catch (Exception e5) {
            e4 = e5;
            openInputStream = null;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.ShareUtil", e4, "copy google photo img fail", new Object[0]);
            com.tencent.mm.a.e.c(openInputStream);
            com.tencent.mm.a.e.a(fileOutputStream);
            return null;
        } catch (Throwable e42) {
            openInputStream = null;
            fileOutputStream = null;
            th = e42;
            com.tencent.mm.a.e.c(openInputStream);
            com.tencent.mm.a.e.a(fileOutputStream);
            throw th;
        }
    }

    private static String Sd(String str) {
        if (bh.ov(str)) {
            return "";
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType == null || extensionFromMimeType.length() == 0) {
            String[] split = str.split("/");
            if (split != null && split.length > 1) {
                extensionFromMimeType = split[1];
            }
        }
        return "." + extensionFromMimeType;
    }
}
