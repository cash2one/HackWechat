package com.tencent.mm.pluginsdk;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    public static boolean Rb(String str) {
        if (str.length() <= 0) {
            return false;
        }
        return true;
    }

    public static String Id(String str) {
        CharSequence trim = str.trim();
        boolean startsWith = trim.startsWith("+");
        if (startsWith && trim.length() > 1) {
            trim = trim.substring(1, trim.length());
        }
        Matcher matcher = Pattern.compile("[^0-9]").matcher(trim);
        if (startsWith) {
            return "+" + matcher.replaceAll("").trim();
        }
        return matcher.replaceAll("").trim();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String[] b(Context context, Uri uri) {
        Throwable e;
        if (uri == null) {
            x.d("MicroMsg.AddressBookUtil", "uri == null");
            return null;
        } else if (com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
            CharSequence charSequence;
            CharSequence charSequence2;
            Cursor query;
            Cursor query2;
            try {
                query = context.getContentResolver().query(uri, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            query.moveToFirst();
                            int columnIndex = query.getColumnIndex("has_phone_number");
                            if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                String str;
                                String str2;
                                query2 = context.getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + query.getString(query.getColumnIndex("_id")), null, null);
                                if (query2 != null) {
                                    if (query2.moveToFirst()) {
                                        str = null;
                                        str2 = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                            String string = query2.getString(columnIndex);
                                            str = query2.getString(columnIndex2);
                                            x.d("MicroMsg.AddressBookUtil", "username : " + str);
                                            if (string != null) {
                                                x.d("MicroMsg.AddressBookUtil", "phoneNumber : " + string);
                                                if (string == null) {
                                                    string = null;
                                                } else {
                                                    string = string.replaceAll("\\D", "");
                                                    if (string.startsWith("86")) {
                                                        string = string.substring(2);
                                                    }
                                                }
                                                x.d("MicroMsg.AddressBookUtil", "phoneNumber : " + string);
                                                if (PhoneNumberUtils.isGlobalPhoneNumber(string)) {
                                                    str2 = string;
                                                }
                                                x.d("MicroMsg.AddressBookUtil", "phoneResult : " + str2);
                                            }
                                            query2.moveToNext();
                                        }
                                        if (!(query2 == null || query2.isClosed())) {
                                            query2.close();
                                        }
                                        charSequence = str;
                                        charSequence2 = str2;
                                        if (!(query == null || query.isClosed())) {
                                            query.close();
                                        }
                                        if (!TextUtils.isEmpty(charSequence) && TextUtils.isEmpty(charSequence2)) {
                                            return null;
                                        }
                                        return new String[]{charSequence, charSequence2};
                                    }
                                }
                                str = null;
                                str2 = null;
                                query2.close();
                                charSequence = str;
                                charSequence2 = str2;
                                query.close();
                                if (!TextUtils.isEmpty(charSequence)) {
                                }
                                return new String[]{charSequence, charSequence2};
                            }
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.AddressBookUtil", e2, "getContactsInfo2:", new Object[0]);
                        query2 = null;
                    } catch (Throwable th) {
                        e2 = th;
                    }
                }
                charSequence = null;
                charSequence2 = null;
                query.close();
            } catch (Throwable e22) {
                Throwable th2 = e22;
                query2 = null;
                charSequence2 = null;
                charSequence = null;
                try {
                    x.printErrStackTrace("MicroMsg.AddressBookUtil", th2, "getContactsInfo1:", new Object[0]);
                    query2.close();
                    if (!TextUtils.isEmpty(charSequence)) {
                    }
                    return new String[]{charSequence, charSequence2};
                } catch (Throwable th3) {
                    e22 = th3;
                    query = query2;
                    if (!(query == null || query.isClosed())) {
                        query.close();
                    }
                    throw e22;
                }
            } catch (Throwable th4) {
                e22 = th4;
                query = null;
                query.close();
                throw e22;
            }
            if (!TextUtils.isEmpty(charSequence)) {
            }
            return new String[]{charSequence, charSequence2};
        } else {
            x.e("MicroMsg.AddressBookUtil", "no contact permission");
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static List<String[]> dW(Context context) {
        List<String[]> linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, null);
            } catch (Throwable e) {
                x.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception occured [%s]", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "", new Object[0]);
                query = null;
            }
            if (query == null) {
                x.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
                return linkedList;
            }
            try {
                if (query.getCount() <= 0 || !query.moveToFirst()) {
                    query.close();
                    return linkedList;
                }
                do {
                    String string = query.getString(query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                    String string2 = query.getString(query.getColumnIndex("contact_id"));
                    String string3 = query.getString(query.getColumnIndex("data1"));
                    String string4 = query.getString(query.getColumnIndex("raw_contact_id"));
                    Long valueOf = Long.valueOf(query.getLong(query.getColumnIndex("photo_id")));
                    linkedList.add(new String[]{string2, string, string3, string4, String.valueOf(valueOf)});
                } while (query.moveToNext());
                query.close();
                return linkedList;
            } catch (Throwable e2) {
                x.e("MicroMsg.AddressBookUtil", "getMobileInfo: exception2 occured [%s]", new Object[]{e2.getMessage()});
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e2, "", new Object[0]);
            } catch (Throwable th) {
                query.close();
            }
        } else {
            x.e("MicroMsg.AddressBookUtil", "no contact permission");
            return linkedList;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static List<String[]> bV(Context context) {
        List<String[]> linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, "sort_key_alt");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "", new Object[0]);
                x.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo(), [%s]", new Object[]{e.getMessage()});
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, null);
            }
            if (query == null) {
                x.e("MicroMsg.AddressBookUtil", "getMobileInfo: mobile is null");
                return linkedList;
            }
            try {
                if (query.getCount() <= 0 || !query.moveToFirst()) {
                    query.close();
                    return linkedList;
                }
                do {
                    String string = query.getString(query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                    String string2 = query.getString(query.getColumnIndex("contact_id"));
                    String string3 = query.getString(query.getColumnIndex("data1"));
                    String string4 = query.getString(query.getColumnIndex("raw_contact_id"));
                    linkedList.add(new String[]{string2, string, string3, string4});
                } while (query.moveToNext());
                query.close();
                return linkedList;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e2, "", new Object[0]);
                x.e("MicroMsg.AddressBookUtil", "exception in getMoblieOrderInfo()2, [%s]", new Object[]{e2.getMessage()});
            } catch (Throwable th) {
                query.close();
            }
        } else {
            x.e("MicroMsg.AddressBookUtil", "no contact permission");
            return linkedList;
        }
    }

    public static List<String[]> dX(Context context) {
        List<String[]> linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
            try {
                Cursor query = contentResolver.query(Email.CONTENT_URI, null, null, null, null);
                if (query == null) {
                    return linkedList;
                }
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(query.getColumnIndex("data1"));
                        String string2 = query.getString(query.getColumnIndex("contact_id"));
                        String string3 = query.getString(query.getColumnIndex("data4"));
                        String string4 = query.getString(query.getColumnIndex("raw_contact_id"));
                        String string5 = query.getString(query.getColumnIndex("photo_id"));
                        linkedList.add(new String[]{string2, string3, string, string4, string5});
                    } while (query.moveToNext());
                }
                query.close();
                return linkedList;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "getEmailInfo", new Object[0]);
            }
        } else {
            x.e("MicroMsg.AddressBookUtil", "no contact permission");
            return linkedList;
        }
    }

    public static List<String> dY(Context context) {
        Throwable e;
        List<String> linkedList = new LinkedList();
        ContentResolver contentResolver = context.getContentResolver();
        if (com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = contentResolver.query(Phone.CONTENT_URI, null, null, null, null);
                if (query == null) {
                    try {
                        x.e("MicroMsg.AddressBookUtil", "getPhonesCursor: cursor is null.");
                        if (query != null) {
                            query.close();
                        }
                        return linkedList;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.e("MicroMsg.AddressBookUtil", "exception in getMobileList, [%s]", new Object[]{e.getMessage()});
                            x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "", new Object[0]);
                            if (query != null) {
                                query.close();
                            }
                            return linkedList;
                        } catch (Throwable th) {
                            e = th;
                            if (query != null) {
                                query.close();
                            }
                            throw e;
                        }
                    }
                }
                if (query.moveToFirst()) {
                    do {
                        linkedList.add(query.getString(query.getColumnIndex("data1")));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
                return linkedList;
            } catch (Exception e3) {
                e = e3;
                query = null;
                x.e("MicroMsg.AddressBookUtil", "exception in getMobileList, [%s]", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "", new Object[0]);
                if (query != null) {
                    query.close();
                }
                return linkedList;
            } catch (Throwable th2) {
                e = th2;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw e;
            }
        }
        x.e("MicroMsg.AddressBookUtil", "no contact permission");
        return linkedList;
    }

    public static String g(String str, Context context) {
        String str2 = "";
        if (com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = context.getContentResolver().query(Contacts.CONTENT_URI, new String[]{SlookAirButtonFrequentContactAdapter.DISPLAY_NAME}, "_id = ?", new String[]{str}, null);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "getContactNameById:", new Object[0]);
                query = null;
            }
            if (query == null) {
                return str2;
            }
            String string;
            if (query.moveToFirst()) {
                string = query.getString(0);
            } else {
                string = str2;
            }
            query.close();
            return string;
        }
        x.e("MicroMsg.AddressBookUtil", "no contact permission");
        return str2;
    }

    public static Uri bXW() {
        try {
            return Contacts.CONTENT_URI;
        } catch (Exception e) {
            return null;
        }
    }

    public static Bitmap a(String str, Context context, boolean z) {
        if (str == null || str.equals("")) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            InputStream openContactPhotoInputStream = Contacts.openContactPhotoInputStream(contentResolver, ContentUris.withAppendedId(Contacts.CONTENT_URI, bh.VJ(str)), z);
            if (openContactPhotoInputStream == null) {
                return null;
            }
            Bitmap decodeStream = d.decodeStream(openContactPhotoInputStream);
            if (decodeStream != null) {
                return d.a(decodeStream, true, 4.0f);
            }
            return decodeStream;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "getAvatar, contactId:%s", new Object[]{str});
            return null;
        }
    }

    public static boolean b(String str, Context context, byte[] bArr) {
        Throwable e;
        if (str == null || str.equals("")) {
            return false;
        }
        if (com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                ContentResolver contentResolver = context.getContentResolver();
                long VJ = bh.VJ(str);
                ContentValues contentValues = new ContentValues();
                x.d("MicroMsg.AddressBookUtil", "where is %s", new Object[]{String.format("%s=%d and %s='%s'", new Object[]{"raw_contact_id", Long.valueOf(VJ), "mimetype", "vnd.android.cursor.item/photo"})});
                query = contentResolver.query(Data.CONTENT_URI, null, r3, null, null);
                if (query != null) {
                    try {
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                        if (query.moveToFirst()) {
                            columnIndexOrThrow = query.getInt(columnIndexOrThrow);
                        } else {
                            columnIndexOrThrow = -1;
                        }
                        contentValues.put("raw_contact_id", Long.valueOf(VJ));
                        contentValues.put("is_super_primary", Integer.valueOf(1));
                        contentValues.put("data15", bArr);
                        contentValues.put("mimetype", "vnd.android.cursor.item/photo");
                        if (columnIndexOrThrow >= 0) {
                            boolean z;
                            if (contentResolver.update(Data.CONTENT_URI, contentValues, "_id = " + columnIndexOrThrow, null) > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (query != null) {
                                query.close();
                            }
                            return z;
                        }
                        contentResolver.insert(Data.CONTENT_URI, contentValues);
                        if (query != null) {
                            query.close();
                        }
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "", new Object[0]);
                            query.close();
                            if (query != null) {
                                return false;
                            }
                            query.close();
                            return false;
                        } catch (Throwable th) {
                            e = th;
                            if (query != null) {
                                query.close();
                            }
                            throw e;
                        }
                    }
                } else if (query == null) {
                    return false;
                } else {
                    query.close();
                    return false;
                }
            } catch (Exception e3) {
                e = e3;
                query = null;
                x.printErrStackTrace("MicroMsg.AddressBookUtil", e, "", new Object[0]);
                if (!(query == null || query.isClosed())) {
                    query.close();
                }
                if (query != null) {
                    return false;
                }
                query.close();
                return false;
            } catch (Throwable th2) {
                e = th2;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw e;
            }
        }
        x.e("MicroMsg.AddressBookUtil", "no contact permission");
        return false;
    }
}
