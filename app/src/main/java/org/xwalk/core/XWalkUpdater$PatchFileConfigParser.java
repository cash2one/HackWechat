package org.xwalk.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.xwalk.core.XWalkUpdater.PatchFileConfig;

public class XWalkUpdater$PatchFileConfigParser {
    private static final String ADD_FLAG = "ADD:";
    private static final int ADD_TYPE = 1;
    private static final int APK_FILE_TYPE = 1;
    private static final String DEL_FLAG = "DEL:";
    private static final int DEL_TYPE = 3;
    private static final int EXTRACTED_FILE_TYPE = 2;
    private static final String MOD_FLAG = "MOD:";
    private static final int MOD_TYPE = 2;
    private static final String PATCH_SUFFIX = ".patch";

    public static ArrayList<PatchFileConfig> getPatchFileConfigList(int i) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(XWalkEnvironment.getPatchConfig(i)))));
            ArrayList<PatchFileConfig> arrayList = new ArrayList();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return arrayList;
                }
                if (!(readLine == null || readLine.isEmpty())) {
                    int i2;
                    if (readLine.startsWith(ADD_FLAG)) {
                        readLine = readLine.substring(4);
                        i2 = 1;
                    } else if (readLine.startsWith(MOD_FLAG)) {
                        readLine = readLine.substring(4);
                        i2 = 2;
                    } else if (readLine.startsWith(DEL_FLAG)) {
                        readLine = readLine.substring(4);
                        i2 = 3;
                    } else {
                        i2 = 0;
                    }
                    for (String str : r1.split(",")) {
                        if (!(str == null || str.isEmpty())) {
                            PatchFileConfig patchFileConfig = new PatchFileConfig();
                            patchFileConfig.originalFileName = str;
                            patchFileConfig.type = i2;
                            if (i2 == 2) {
                                patchFileConfig.patchFileName = patchFileConfig.originalFileName + PATCH_SUFFIX;
                            }
                            if (i2 == 2 && patchFileConfig.originalFileName.equals(XWalkEnvironment.XWALK_CORE_APK_NAME)) {
                                patchFileConfig.originalFileType = 1;
                            } else {
                                patchFileConfig.originalFileType = 2;
                            }
                            Log.d("XWalkLib", "getPatchFileConfigList config:" + patchFileConfig.toString());
                            arrayList.add(patchFileConfig);
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.e("XWalkLib", "getPatchFileConfigList error:" + e.getMessage());
            return null;
        }
    }
}
