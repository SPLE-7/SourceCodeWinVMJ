package LibraryManagementSystem.statistik;

import LibraryManagementSystem.statistik.core.Statistik;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class StatistikFactory{
    private static final Logger LOGGER = Logger.getLogger(StatistikFactory.class.getName());

    public StatistikFactory()
    {

    }

    public static Statistik createStatistik(String fullyQualifiedName, Object ... base)
    {
        Statistik record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            for (Constructor<?> c : clz.getDeclaredConstructors()) {
                if (c.getParameterCount() == base.length) {
                    constructor = c;
                    break;
                }
            }
            record = (Statistik) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of Statistik.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of Statistik.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of Statistik.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of Statistik.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
