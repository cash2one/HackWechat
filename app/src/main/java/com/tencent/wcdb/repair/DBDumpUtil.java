package com.tencent.wcdb.repair;

import android.text.TextUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.support.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBDumpUtil {
    private static final String TAG = "WCDB.DBDumpUtil";

    public interface ExecuteSqlCallback {
        String preExecute(String str);
    }

    private static native boolean nativeDumpDB(String str, String str2, String str3);

    private static native boolean nativeIsSqlComplete(String str);

    public static boolean doRecoveryDb(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        return doRecoveryDb(sQLiteDatabase, str, str2, str3, null, null, null, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean doRecoveryDb(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, List<String> list, List<String> list2, ExecuteSqlCallback executeSqlCallback, boolean z) {
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            Log.w(TAG, "Database is not open");
            return false;
        } else if (!nativeDumpDB(str, str2, str3)) {
            return false;
        } else {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(str3));
                sQLiteDatabase.execSQL("PRAGMA foreign_keys=OFF;");
                sQLiteDatabase.beginTransaction();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                Object obj = null;
                try {
                    HashMap hashMap = new HashMap();
                    Object obj2 = null;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String str4;
                            String str5;
                            int i4;
                            if (obj2 != null) {
                                obj = obj + "\n" + readLine;
                                if (obj.endsWith(";")) {
                                    if (!nativeIsSqlComplete(obj)) {
                                    }
                                }
                            } else if (readLine.startsWith("INSERT") || readLine.startsWith("CREATE TABLE")) {
                                if (readLine.endsWith(";") && nativeIsSqlComplete(readLine)) {
                                    str4 = readLine;
                                } else {
                                    if (!TextUtils.isEmpty(obj)) {
                                        readLine = obj + "\n" + readLine;
                                    }
                                    obj2 = 1;
                                    obj = readLine;
                                }
                            }
                            Object obj3 = null;
                            String tableNameFromSql;
                            if (list2 != null && list2.size() > 0) {
                                tableNameFromSql = getTableNameFromSql(str4);
                                for (String readLine2 : list2) {
                                    if (tableNameFromSql.equals(readLine2)) {
                                        obj3 = null;
                                        str5 = str4;
                                        str4 = tableNameFromSql;
                                        break;
                                    }
                                }
                                i4 = 1;
                                str5 = str4;
                                str4 = tableNameFromSql;
                            } else if (list == null || list.size() <= 0) {
                                String str6 = str4;
                                str4 = null;
                                str5 = str6;
                            } else {
                                tableNameFromSql = getTableNameFromSql(str4);
                                for (String readLine22 : list) {
                                    if (tableNameFromSql.equals(readLine22)) {
                                        obj3 = 1;
                                        str5 = "";
                                        str4 = tableNameFromSql;
                                        break;
                                    }
                                }
                                obj3 = null;
                                str5 = str4;
                                str4 = tableNameFromSql;
                            }
                            if (obj3 != null) {
                                Log.i(TAG, "filter table %s", str4);
                                obj = str5;
                                obj2 = null;
                            } else {
                                try {
                                    if (str5.startsWith("CREATE TABLE")) {
                                        hashMap.put(str4, buildColumnsString(getColumnNamesFromSql(str5)));
                                    } else if (str5.startsWith("INSERT INTO")) {
                                        readLine22 = (String) hashMap.get(str4);
                                        if (!TextUtils.isEmpty(readLine22)) {
                                            StringBuilder stringBuilder = new StringBuilder("INSERT INTO ");
                                            stringBuilder.append("\"").append(str4).append("\"");
                                            CharSequence stringBuilder2 = stringBuilder.toString();
                                            stringBuilder.append(readLine22);
                                            str5 = str5.replace(stringBuilder2, stringBuilder.toString());
                                        }
                                    }
                                    readLine22 = null;
                                    if (executeSqlCallback != null) {
                                        readLine22 = executeSqlCallback.preExecute(str5);
                                    }
                                    if (TextUtils.isEmpty(readLine22)) {
                                        readLine22 = str5;
                                    }
                                    i2++;
                                    sQLiteDatabase.execSQL(readLine22);
                                    i4 = i3 + 1;
                                    if (i4 >= 100) {
                                        try {
                                            sQLiteDatabase.setTransactionSuccessful();
                                            sQLiteDatabase.endTransaction();
                                            sQLiteDatabase.beginTransaction();
                                            i4 = 0;
                                        } catch (Exception e) {
                                            i++;
                                            obj = null;
                                            obj2 = null;
                                            i3 = i4;
                                        }
                                    }
                                } catch (Exception e2) {
                                    i4 = i3;
                                    i++;
                                    obj = null;
                                    obj2 = null;
                                    i3 = i4;
                                }
                                obj = null;
                                obj2 = null;
                                i3 = i4;
                            }
                        } else {
                            try {
                                break;
                            } catch (IOException e3) {
                            }
                        }
                    }
                    bufferedReader.close();
                    if (i2 <= i) {
                        return false;
                    }
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.setTransactionSuccessful();
                    }
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                    if (z) {
                        File file = new File(str3);
                        if (file.exists()) {
                            file.delete();
                        }
                        file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    Log.i(TAG, "restore : %d , fail:%d ", Integer.valueOf(i2), Integer.valueOf(i));
                    return true;
                } catch (IOException e4) {
                    Log.w(TAG, "I/O error in read sql file ");
                    return false;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (FileNotFoundException e6) {
                Log.w(TAG, "SQL file '%s' not found", str3);
                return false;
            }
        }
    }

    public static String buildColumnsString(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append((String) arrayList.get(i));
            if (i != arrayList.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        String stringBuilder2 = stringBuilder.toString();
        System.out.println(stringBuilder2);
        return stringBuilder2;
    }

    public static String getTableNameFromSql(String str) {
        if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        String[] split = str.split("\\s");
        if (split == null || split.length <= 1) {
            return null;
        }
        return split[2].replaceAll("\"", "");
    }

    public static byte[] readFromFile(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        File file = new File(str);
        if (file.exists()) {
            try {
                int length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[length];
                    if (fileInputStream.read(bArr) != length) {
                        Log.w(TAG, "readFromFile error, size is not equal, path = %s, file length is %d, count is %d", str, Integer.valueOf(length), Integer.valueOf(fileInputStream.read(bArr)));
                        try {
                            fileInputStream.close();
                            return null;
                        } catch (IOException e) {
                            return null;
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                    return bArr;
                } catch (Exception e3) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    Log.e(TAG, "readFromFile failed!");
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                fileInputStream2 = null;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                Log.e(TAG, "readFromFile failed!");
                return null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        Log.w(TAG, "readFromFile error, file is not exit, path = %s", str);
        return null;
    }

    public static ArrayList<String> getColumnNamesFromSql(String str) {
        ArrayList<String> arrayList = new ArrayList();
        String[] split = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")).trim().split(",");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
            arrayList.add(split[i].substring(0, split[i].indexOf(" ")));
        }
        return arrayList;
    }
}
