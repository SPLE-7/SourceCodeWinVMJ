package LibraryManagementSystem.buku;

import LibraryManagementSystem.buku.core.Buku;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class BukuFactory{
    private static final Logger LOGGER = Logger.getLogger(BukuFactory.class.getName());

    public BukuFactory()
    {

    }

    public static Buku createBuku(String fullyQualifiedName, Object ... base)
    {
        Buku record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            for (Constructor<?> c : clz.getDeclaredConstructors()) {
                if (c.getParameterCount() == base.length) {
                    constructor = c;
                    break;
                }
            }
            record = (Buku) constructor.newInstance(base);
        }
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of Buku.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of Buku.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of Buku.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of Buku.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
