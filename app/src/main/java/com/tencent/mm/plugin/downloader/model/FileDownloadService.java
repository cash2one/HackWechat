package com.tencent.mm.plugin.downloader.model;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.downloader.b$c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public class FileDownloadService extends IntentService {
    public static final String EXTRA_ID = (lsF + SlookAirButtonFrequentContactAdapter.ID);
    public static final String EXTRA_PACKAGE_NAME = (lsF + "package_name");
    private static final String lsF = (FileDownloadService.class.getSimpleName() + "_extra_");
    public static final String lsG = (lsF + "action_type");
    public static final String lsH = (lsF + "file_path");
    public static final String lsI = (lsF + "md5");
    public static final String lsJ = (lsF + "change_url");

    public FileDownloadService() {
        super("FileDownloadService");
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            x.i("MicroMsg.FileDownloadService", "handle intent type : %d", new Object[]{Integer.valueOf(intent.getIntExtra(lsG, 0))});
            String str;
            String str2;
            switch (intent.getIntExtra(lsG, 0)) {
                case 1:
                    long longExtra = intent.getLongExtra(EXTRA_ID, -1);
                    boolean booleanExtra = intent.getBooleanExtra(lsJ, false);
                    if (longExtra < 0) {
                        x.e("MicroMsg.FileDownloadService", "Invalid id");
                        return;
                    }
                    if (g.Dh().Cy()) {
                        g.Dh();
                        if (!a.Cs()) {
                            com.tencent.mm.plugin.downloader.e.a ce = e.ce(longExtra);
                            if (ce != null) {
                                x.i("MicroMsg.FileDownloadService", "filePath = " + ce.field_filePath);
                                if (bh.ov(ce.field_filePath) || !e.bO(ce.field_filePath)) {
                                    com.tencent.mm.plugin.report.service.g.pQN.a(710, 5, 1, false);
                                    x.i("MicroMsg.FileDownloadService", "file not exists, appid = " + ce.field_appId);
                                    return;
                                } else if (bh.ov(ce.field_md5)) {
                                    x.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
                                    ce.field_status = 3;
                                    e.c(ce);
                                    f.aAd().i(longExtra, booleanExtra);
                                    return;
                                } else if (cd(ce.field_filePath, ce.field_md5)) {
                                    ce.field_status = 3;
                                    e.c(ce);
                                    f.aAd().i(longExtra, booleanExtra);
                                    return;
                                } else {
                                    str = "";
                                    try {
                                        str = n.x(new File(ce.field_filePath));
                                    } catch (Exception e) {
                                        x.e("MicroMsg.FileDownloadService", "readChannelId exception : " + e.getMessage());
                                    }
                                    ce.field_status = 4;
                                    ce.field_channelId = str;
                                    ce.field_errCode = d.lrZ;
                                    ce.field_downloadedSize = (long) e.bN(ce.field_filePath);
                                    e.c(ce);
                                    x.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", new Object[]{str, Long.valueOf(ce.field_downloadedSize), Integer.valueOf(e.bN(ce.field_filePath))});
                                    b.deleteFile(ce.field_filePath);
                                    if (!an.isWifi(this) || booleanExtra || bh.ov(ce.field_secondaryUrl) || ce.field_downloaderType == 3) {
                                        f aAd = f.aAd();
                                        com.tencent.mm.plugin.downloader.e.a ce2 = e.ce(longExtra);
                                        if (ce2 != null) {
                                            Context context = ac.getContext();
                                            if (ce2.field_showNotification && bh.ov(ce2.field_fileName)) {
                                                str2 = ce2.field_downloadUrl;
                                                f.a(context.getString(b$c.lrc), "", null);
                                            } else if (ce2.field_showNotification && !bh.ov(ce2.field_fileName)) {
                                                String str3 = ce2.field_downloadUrl;
                                                f.a(ce2.field_fileName, context.getString(b$c.lrc), null);
                                            }
                                            aAd.lsp.b(longExtra, d.lrZ, booleanExtra);
                                            return;
                                        }
                                        return;
                                    }
                                    g.a aVar = new g.a();
                                    aVar.xL(ce.field_secondaryUrl);
                                    aVar.ci(ce.field_fileSize);
                                    aVar.xN(ce.field_fileName);
                                    aVar.setAppId(ce.field_appId);
                                    aVar.xO(ce.field_md5);
                                    aVar.ep(true);
                                    aVar.ox(1);
                                    aVar.cu(ce.field_packageName);
                                    x.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = " + f.aAd().a(aVar.lsE));
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    x.d("MicroMsg.FileDownloadService", "no user login");
                    return;
                case 3:
                    str = intent.getStringExtra(lsH);
                    str2 = intent.getStringExtra(lsI);
                    if (bh.ov(str) || !e.bO(str)) {
                        x.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
                        return;
                    } else if (bh.ov(str2) || cd(str, str2)) {
                        Uri fromFile = Uri.fromFile(new File(str));
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setDataAndType(fromFile, "application/vnd.android.package-archive");
                        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        startActivity(intent2);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private static boolean cd(String str, String str2) {
        File file = new File(str);
        x.i("MicroMsg.FileDownloadService", "MD5 Check: %s, File Exists: %b", new Object[]{str, Boolean.valueOf(file.exists())});
        long currentTimeMillis = System.currentTimeMillis();
        String i = com.tencent.mm.a.g.i(file);
        x.i("MicroMsg.FileDownloadService", "MD5 Check Time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        x.i("MicroMsg.FileDownloadService", "Original MD5: %s, Calculated MD5: %s", new Object[]{str2, i});
        if (bh.ov(str2)) {
            return file.exists();
        }
        if (!bh.ov(i)) {
            return str2.equalsIgnoreCase(i);
        }
        x.i("MicroMsg.FileDownloadService", "check from file failed, may caused by low memory while checking md5");
        return file.exists();
    }
}
