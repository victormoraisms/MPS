package Persistencia;

public abstract class DAOFactory {
	public static final int RAM = 1;
	public static final int FILE = 2;
	
	public abstract UserDAO getUserDAO();
	
	public static DAOFactory getDAOFactory(int factoryType)
        {
            switch (factoryType)
            {
                case RAM :
                    return new RamDAOFactory();
                case FILE :
                    return new ArquivoDAOFactory();

                default :
                    return null;
            }
        }
}
