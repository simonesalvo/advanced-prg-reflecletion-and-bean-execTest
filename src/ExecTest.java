import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Simone Salvo on 17/01/2018.
 */
public class ExecTest {

    private List<String> classes;
    private List<Class> loadedClasses;
    private ClassLoader classLoader;

    public static void main(String[] args) {
          new ExecTest(args);
    }

    private ExecTest(String[] args) {
        this.classLoader = ExecTest.class.getClassLoader();
        this.loadedClasses = new ArrayList<>();
        this.classes = new ArrayList<>();
        Collections.addAll(this.classes, args);
        this.loadGivenClasses();
        this.instantiateGivenClasses();
    }

    private void instantiateGivenClasses() {
        Method[] allMethods;
        Object obj;
        if (loadedClasses.size() > 0) {
            for(Class c: this.loadedClasses) {
                try {
                    obj = c.newInstance();
                    if (obj!= null) {
                        allMethods = obj.getClass().getDeclaredMethods();
                        for (Method method : allMethods) {
                            if (isMethodNonPrivate(method.getModifiers()) && method.getName().startsWith("test")) {
                                    method.invoke(obj);
                                }
                            }
                        }
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isMethodNonPrivate(int modifiers) {
        return (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers));
    }

    private void loadGivenClasses() {
        if (classes.size()> 0){
            for(String c: this.classes) {
                try {
                    loadedClasses.add(classLoader.loadClass(c));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
