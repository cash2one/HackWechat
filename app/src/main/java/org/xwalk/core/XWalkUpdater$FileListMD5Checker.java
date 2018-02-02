package org.xwalk.core;

import com.tencent.xweb.util.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class XWalkUpdater$FileListMD5Checker {
    public static boolean checkFileListMd5(int i, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(str))));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return true;
                }
                if (!(readLine == null || readLine.isEmpty())) {
                    String[] split = readLine.split(":");
                    if (!(split == null || split.length != 2 || split[0] == null || split[0].isEmpty() || split[1] == null || split[1].isEmpty() || checkFileMd5(i, split[0], split[1]))) {
                        Log.e("XWalkLib", "checkFileListMd5 error name:" + split[0] + ",md5:" + split[1]);
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            Log.e("XWalkLib", "checkFileListMd5 error:" + e.getMessage());
            return false;
        }
    }

    private static boolean checkFileMd5(int i, String str, String str2) {
        String downloadApkPath;
        if (XWalkEnvironment.XWALK_CORE_APK_NAME.equals(str)) {
            downloadApkPath = XWalkEnvironment.getDownloadApkPath(i);
        } else {
            downloadApkPath = XWalkEnvironment.getExtractedCoreFile(i, str);
        }
        if (c.gh(downloadApkPath, str2)) {
            Log.i("XWalkLib", "checkFileMd5 successful path:" + downloadApkPath);
            return true;
        }
        Log.e("XWalkLib", "checkFileMd5 error path:" + downloadApkPath);
        return false;
    }
}
