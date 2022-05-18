package UTN.TP_3_GRUPO_6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Entidades.Autor;
import Entidades.Nacionalidad;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory;
    	
    	Configuration configuration = new Configuration();
    	configuration.configure();	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
 
    	session.beginTransaction();
    	
	    	Autor autor = new Autor();
	    	Nacionalidad nacionalidad = new Nacionalidad();
	    	
	    	autor.setID(100);
	    	autor.setNombre("Matias");
	    	autor.setApellido("Vieitez");
	    	autor.setvNacionalidad(1);
	    	autor.setEmail("matias.vieitez@red.com");
	    	
	    	nacionalidad.setID(1);
	    	nacionalidad.setDescripcion("Argentino");
	    	
    	
	    	session.save(autor);
	    	
	    	session.getTransaction().commit();
	    	
	    	session.close();
    	
    	sessionFactory.close();
    }
}
