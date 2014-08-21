package nerver.more;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * this class test all the sort class that extends the abstract SortEverything!!! 
 * @author Mr.Zou
 */
public class SortEverythingTest {

	@Test
	public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		int count = 0;
		for (Class<?> c : getAllNeedTestCase(SortEverything.class)) {  
			Integer[] array = SortEverything.createTheDataSample(100, 200);
			SortEverything method = (SortEverything) c.newInstance();
			method.sort(array);
			assertTrue(testOrder(array));
			if (testOrder(array))  {
				System.out.println(c.getSimpleName() + " sort well!!");
				count++;
			}
			count--;
			/*SortEverything.printAllElement(array);*/
		}  
		if (count == 0) 
			System.out.println("\n=====================\nAll the method pass the test!");
		
	}
	private boolean testOrder(Comparable[] arr) {
		if (arr == null)
			return false;
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i].compareTo(arr[i+1]) > 0)
				return false;
		return true;
	}

	private List<Class<?>> getAllNeedTestCase(Class<?> clazz) throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (Class<?> c: getClasses(clazz)) {
			if (clazz.isAssignableFrom(c) && !clazz.equals(c)) {
				classes.add(c);
			}
		}
		return classes;
	}
	
	private List<Class<?>> getClasses(Class<?> clazz) throws ClassNotFoundException {
		String pack = clazz.getPackage().getName();
		String path = pack.replace('.', '/');
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource(path);
		return getClasses(new File(url.getFile()), pack);
	}
	private List<Class<?>> getClasses(File file, String pack) throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (!file.exists()) return classes;
		for (File f: file.listFiles()) {
			if (f.isDirectory()) {
				classes.addAll(getClasses(f, pack));
			}
			String name = f.getName();
			if (name.endsWith(".class")) {
				classes.add(Class.forName(pack + "." + name.substring(0, name.length() - 6)));
			}
		}
		return classes;
	}
	
}
