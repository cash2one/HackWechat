package org.xwalk.core.extension;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.Log;

class ReflectionHelper {
    private static final String TAG = "JsStubReflectHelper";
    static Set<Class<?>> primitives = new HashSet();
    private Map<String, String> bindingClasses = new HashMap();
    private Map<String, ReflectionHelper> constructorReflections = new HashMap();
    private MemberInfo entryPoint = null;
    private String[] eventList = null;
    private Map<String, MemberInfo> members = new HashMap();
    private Class<?> myClass;

    public ReflectionHelper(Class<?> cls) {
        this.myClass = cls;
        init();
    }

    void getMemberInfo(AccessibleObject[] accessibleObjectArr, MemberType memberType) {
        for (AccessibleObject accessibleObject : accessibleObjectArr) {
            if (accessibleObject.isAnnotationPresent(JsApi.class) || accessibleObject.isAnnotationPresent(JsConstructor.class)) {
                MemberInfo memberInfo = new MemberInfo(this);
                String name = ((Member) accessibleObject).getName();
                memberInfo.javaName = name;
                memberInfo.accesser = accessibleObject;
                memberInfo.isStatic = Modifier.isStatic(((Member) accessibleObject).getModifiers());
                if (accessibleObject.isAnnotationPresent(JsApi.class)) {
                    JsApi jsApi = (JsApi) accessibleObject.getAnnotation(JsApi.class);
                    if (memberType != MemberType.JS_PROPERTY || !jsApi.isEventList()) {
                        memberInfo.type = memberType;
                        memberInfo.isWritable = jsApi.isWritable();
                        memberInfo.isEntryPoint = jsApi.isEntryPoint();
                        memberInfo.withPromise = jsApi.withPromise();
                        memberInfo.jsName = name;
                        memberInfo.wrapArgs = jsApi.wrapArgs();
                        memberInfo.wrapReturns = jsApi.wrapReturns();
                    } else if (((Field) accessibleObject).getType().equals(String[].class)) {
                        try {
                            this.eventList = (String[]) ((Field) accessibleObject).get(null);
                        } catch (IllegalArgumentException e) {
                        } catch (IllegalAccessException e2) {
                        }
                    } else {
                        Log.w(TAG, "Invalid type for Supported JS event list" + name);
                    }
                } else if (accessibleObject.isAnnotationPresent(JsConstructor.class)) {
                    if (memberType != MemberType.JS_METHOD) {
                        Log.w(TAG, "Invalid @JsConstructor on non-function member:" + name);
                    } else {
                        JsConstructor jsConstructor = (JsConstructor) accessibleObject.getAnnotation(JsConstructor.class);
                        memberInfo.type = MemberType.JS_CONSTRUCTOR;
                        memberInfo.isEntryPoint = jsConstructor.isEntryPoint();
                        memberInfo.mainClass = jsConstructor.mainClass();
                        memberInfo.withPromise = false;
                        if (memberInfo.mainClass != null) {
                            memberInfo.jsName = memberInfo.mainClass.getSimpleName();
                            this.bindingClasses.put(memberInfo.mainClass.getName(), memberInfo.jsName);
                            this.constructorReflections.put(memberInfo.jsName, new ReflectionHelper(memberInfo.mainClass));
                        }
                    }
                }
                if (memberInfo.isEntryPoint) {
                    if (this.entryPoint != null) {
                        Log.w(TAG, "Entry point already exist, try to set another:" + memberInfo.jsName);
                    } else if (memberType != MemberType.JS_PROPERTY || isBindingClass(((Field) memberInfo.accesser).getType())) {
                        this.entryPoint = memberInfo;
                    } else {
                        Log.w(TAG, "Invalid entry point setting on property:" + name);
                    }
                }
                if (this.members.containsKey(memberInfo.jsName)) {
                    Log.w(TAG, "Conflict namespace - " + memberInfo.jsName);
                } else {
                    this.members.put(memberInfo.jsName, memberInfo);
                }
            }
        }
    }

    boolean isBindingClass(Class<?> cls) {
        return BindingObject.class.isAssignableFrom(cls);
    }

    void init() {
        primitives.add(Byte.class);
        primitives.add(Integer.class);
        primitives.add(Long.class);
        primitives.add(Double.class);
        primitives.add(Character.class);
        primitives.add(Float.class);
        primitives.add(Boolean.class);
        primitives.add(Short.class);
        getMemberInfo(this.myClass.getDeclaredMethods(), MemberType.JS_METHOD);
        getMemberInfo(this.myClass.getDeclaredFields(), MemberType.JS_PROPERTY);
    }

    public static void registerHandlers(ReflectionHelper reflectionHelper, MessageHandler messageHandler, Object obj) {
        if (reflectionHelper != null && messageHandler != null) {
            for (String str : reflectionHelper.getMembers().keySet()) {
                MemberInfo memberInfo = (MemberInfo) reflectionHelper.getMembers().get(str);
                messageHandler.register(memberInfo.jsName, memberInfo.javaName, memberInfo.type, obj, reflectionHelper);
            }
        }
    }

    Map<String, MemberInfo> getMembers() {
        return this.members;
    }

    ReflectionHelper getConstructorReflection(String str) {
        if (this.constructorReflections.containsKey(str)) {
            return (ReflectionHelper) this.constructorReflections.get(str);
        }
        return null;
    }

    ReflectionHelper getReflectionByBindingClass(String str) {
        if (this.bindingClasses.containsKey(str)) {
            return getConstructorReflection((String) this.bindingClasses.get(str));
        }
        return null;
    }

    Boolean hasMethod(String str) {
        if (!this.members.containsKey(str)) {
            return Boolean.valueOf(false);
        }
        MemberInfo memberInfo = (MemberInfo) this.members.get(str);
        boolean z = memberInfo.type == MemberType.JS_METHOD || memberInfo.type == MemberType.JS_CONSTRUCTOR;
        return Boolean.valueOf(z);
    }

    Boolean hasProperty(String str) {
        if (!this.members.containsKey(str)) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(((MemberInfo) this.members.get(str)).type == MemberType.JS_PROPERTY);
    }

    MemberInfo getMemberInfo(String str) {
        return (MemberInfo) this.members.get(str);
    }

    Object[] getArgsFromJson(XWalkExternalExtension xWalkExternalExtension, int i, Method method, JSONArray jSONArray) {
        int i2 = 0;
        Class[] parameterTypes = method.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        boolean isStatic = Modifier.isStatic(method.getModifiers());
        while (i2 < parameterTypes.length) {
            try {
                Object obj = parameterTypes[i2];
                if (isStatic && obj.equals(JsContextInfo.class)) {
                    int i3 = i2 + 1;
                    try {
                        objArr[i2] = new JsContextInfo(i, xWalkExternalExtension, method.getClass(), Integer.toString(0));
                        i2 = i3;
                    } catch (Exception e) {
                        i2 = i3;
                    }
                    i2++;
                } else {
                    objArr[i2] = jSONArray.get(i2);
                    i2++;
                }
            } catch (Exception e2) {
            }
        }
        return objArr;
    }

    public static boolean isSerializable(Object obj) {
        Class cls = obj.getClass();
        return cls.isPrimitive() || primitives.contains(cls) || (obj instanceof String) || (obj instanceof Map) || (obj instanceof JSONArray) || (obj instanceof JSONObject);
    }

    public static Object toSerializableObject(Object obj) {
        int i = 0;
        if (obj.getClass().isArray()) {
            JSONArray jSONArray = new JSONArray();
            Object[] objArr = (Object[]) obj;
            for (int i2 = 0; i2 < objArr.length; i2++) {
                try {
                    jSONArray.put(i2, toSerializableObject(objArr[i2]));
                } catch (Exception e) {
                }
            }
            return jSONArray;
        } else if (isSerializable(obj)) {
            return obj;
        } else {
            try {
                String str = (String) obj.getClass().getMethod("toJSONString", new Class[0]).invoke(obj, new Object[0]);
                if (str.trim().charAt(0) == '[') {
                    return new JSONArray(str);
                }
                return new JSONObject(str);
            } catch (Exception e2) {
                Log.w(TAG, "No serialization method: \"toJSONString\", or errors happened.");
                try {
                    Class cls = obj.getClass();
                    JSONObject jSONObject = new JSONObject();
                    Field[] fields = cls.getFields();
                    int length = fields.length;
                    while (i < length) {
                        Field field = fields[i];
                        jSONObject.put(field.getName(), field.get(obj));
                        i++;
                    }
                    return jSONObject;
                } catch (Exception e3) {
                    Log.e(TAG, "Field to serialize object to JSON.");
                    return null;
                }
            }
        }
    }

    public static String objToJSON(Object obj) {
        if (obj == null) {
            return "null";
        }
        Object toSerializableObject = toSerializableObject(obj);
        return toSerializableObject instanceof String ? JSONObject.quote(toSerializableObject.toString()) : toSerializableObject.toString();
    }

    Object invokeMethod(XWalkExternalExtension xWalkExternalExtension, int i, Object obj, String str, JSONArray jSONArray) {
        if (!hasMethod(str).booleanValue()) {
            throw new NoSuchMethodException("No such method:" + str);
        } else if (getMemberInfo(str).isStatic || this.myClass.isInstance(obj)) {
            Method method = (Method) ((MemberInfo) this.members.get(str)).accesser;
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(obj, getArgsFromJson(xWalkExternalExtension, i, method, jSONArray));
        } else {
            throw new InvocationTargetException(new Exception("Invalid target to set property:" + str));
        }
    }

    Object getProperty(Object obj, String str) {
        if (!hasProperty(str).booleanValue()) {
            throw new NoSuchFieldException("No such property:" + str);
        } else if (getMemberInfo(str).isStatic || this.myClass.isInstance(obj)) {
            Field field = (Field) ((MemberInfo) this.members.get(str)).accesser;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(obj);
        } else {
            throw new InvocationTargetException(new Exception("Invalid target to set property:" + str));
        }
    }

    void setProperty(Object obj, String str, Object obj2) {
        if (!hasProperty(str).booleanValue()) {
            throw new NoSuchFieldException("No such property:" + str);
        } else if (getMemberInfo(str).isStatic || this.myClass.isInstance(obj)) {
            Field field = (Field) ((MemberInfo) this.members.get(str)).accesser;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            field.set(obj, obj2);
        } else {
            throw new InvocationTargetException(new Exception("Invalid target to set property:" + str));
        }
    }

    String[] getEventList() {
        return this.eventList;
    }

    MemberInfo getEntryPoint() {
        return this.entryPoint;
    }

    boolean isEventSupported(String str) {
        if (this.eventList == null) {
            return false;
        }
        for (String equals : this.eventList) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    boolean isInstance(Object obj) {
        return this.myClass.isInstance(obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Object handleMessage(MessageInfo messageInfo, Object obj) {
        Object obj2 = null;
        try {
            JSONArray jSONArray;
            String cmd = messageInfo.getCmd();
            if (messageInfo.getBinaryArgs() != null) {
                jSONArray = new JSONArray();
                jSONArray.put(messageInfo.getBinaryArgs());
                jSONArray.put(messageInfo.getCallbackId());
            } else {
                jSONArray = messageInfo.getArgs();
            }
            String jsName = messageInfo.getJsName();
            XWalkExternalExtension extension = messageInfo.getExtension();
            int instanceId = messageInfo.getInstanceId();
            switch (cmd.hashCode()) {
                case -633190737:
                    if (cmd.equals("invokeNative")) {
                        break;
                    }
                case 996179031:
                    if (cmd.equals("setProperty")) {
                        obj2 = 3;
                        break;
                    }
                case 1084758859:
                    if (cmd.equals("getProperty")) {
                        obj2 = 2;
                        break;
                    }
                case 1811874389:
                    if (cmd.equals("newInstance")) {
                        obj2 = 1;
                        break;
                    }
                default:
                    obj2 = -1;
                    break;
            }
            switch (obj2) {
                case null:
                    return invokeMethod(extension, instanceId, obj, jsName, jSONArray);
                case 1:
                    return Boolean.valueOf(messageInfo.getInstanceHelper().addBindingObject(messageInfo.getObjectId(), (BindingObject) invokeMethod(extension, instanceId, obj, jsName, jSONArray)));
                case 2:
                    return getProperty(obj, jsName);
                case 3:
                    setProperty(obj, jsName, jSONArray.get(0));
                    return null;
                default:
                    Log.w(TAG, "Unsupported cmd: " + cmd);
                    return null;
            }
        } catch (Exception e) {
            Log.w(TAG, "Invalid message, error msg:\n" + e.toString());
            return null;
        }
    }
}
