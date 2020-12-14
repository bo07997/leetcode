package leetcode.test.jvm.classloader;

import java.lang.reflect.Method;

/**
 * @author ldb
 * @Package leetcode.test.jvm.classloader
 * @date 2020/8/14 16:34
 */

public class Test2 {
	public static void main(String[] args) {
		//		ClassLoader loader = Test.class.getClassLoader();
		//		while (loader != null) {
		//			System.out.println(loader.toString());
		//			loader = loader.getParent();
		//		}
		testClassIdentity();
	}

	private Test2 instance;

	public static void testClassIdentity() {
		String classDataRootPath = "E:\\MyProject\\jvmtest";
		MyClassLoader fscl1 = new MyClassLoader(classDataRootPath);
		MyClassLoader fscl2 = new MyClassLoader(classDataRootPath);
		String className = "leetcode.test.jvm.classloader.Test";
		try {
			Class<?> class1 = fscl1.loadClass(className);
			Object obj1 = class1.newInstance();
			Class<?> class2 = fscl2.loadClass(className);
			Object obj2 = class2.newInstance();
			Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
			setSampleMethod.invoke(obj1, obj2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSample(Object instance) {
		this.instance = (Test2) instance;
		System.out.println("succes2s");
	}
}
