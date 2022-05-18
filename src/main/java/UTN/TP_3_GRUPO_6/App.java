package UTN.TP_3_GRUPO_6;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Entidades.Autor;
import Entidades.Biblioteca;
import Entidades.Libro;
import Entidades.Nacionalidad;

public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory;

		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
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

		Libro libro = new Libro("123456789", "Los Ojos del Perro Siberiano", new Date("01/03/1998"), "Español", 222,
				"Los ojos del perro siberiano es una novela juvenil perteneciente al escritor argentino Antonio Santa Ana.",
				autor);

		session.save(libro);
		
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.setID(1);
		biblioteca.setFechaDeAlta(new Date()); 
		biblioteca.setEstado(1);
		biblioteca.setLibro(libro);
		
		session.save(biblioteca);

		session.getTransaction().commit();

		session.close();

		sessionFactory.close();
	}
}
