package UTN.TP_3_GRUPO_6;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Entidades.Autor;
import Entidades.Biblioteca;
import Entidades.Genero;
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

		// SAVE NACIONALIDAD
		Nacionalidad nacionalidad = new Nacionalidad();
		nacionalidad.setID(1);
		nacionalidad.setDescripcion("Argentino");
		Nacionalidad nacionalidad2 = new Nacionalidad();
		nacionalidad2.setID(2);
		nacionalidad2.setDescripcion("Chileno");
		Nacionalidad nacionalidad3 = new Nacionalidad();
		nacionalidad3.setID(3);
		nacionalidad3.setDescripcion("Uruguayo");

		// AUTOR
		Autor autor = new Autor();
		autor.setID(100);
		autor.setNombre("Matias");
		autor.setApellido("Vieitez");
		autor.setNacionalidad(nacionalidad);
		autor.setEmail("matias.vieitez@red.com");

		Autor autor2 = new Autor();
		autor2.setID(101);
		autor2.setNombre("Julian");
		autor2.setApellido("Martinez");
		autor2.setNacionalidad(nacionalidad2);
		autor2.setEmail("julian.martinez@red.com");

		Autor autor3 = new Autor();
		autor3.setID(102);
		autor3.setNombre("Pedro");
		autor3.setApellido("Dominguez");
		autor3.setNacionalidad(nacionalidad3);
		autor3.setEmail("pedro.dominguez@red.com");

		// SAVE AUTOR
		session.save(autor);
		session.save(autor2);
		session.save(autor3);

		// GENERO
		Genero genero = new Genero();
		genero.setID(1);
		genero.setDescripcion("Drama");
		Genero genero2 = new Genero();
		genero2.setID(2);
		genero2.setDescripcion("Suspenso");
		Genero genero3 = new Genero();
		genero3.setID(3);
		genero3.setDescripcion("Terror");
		Genero genero4 = new Genero();
		genero4.setID(4);
		genero4.setDescripcion("Comedia");
		Genero genero5 = new Genero();
		genero5.setID(5);
		genero5.setDescripcion("Romantica");
	
		// SAVE GENERO
		session.save(genero);
		session.save(genero2);
		session.save(genero3);
		session.save(genero4);
		session.save(genero5);
        
		// LIBRO
		Libro libro = new Libro("123456789", "Los Ojos del Perro Siberiano", new Date("01/03/1998"), "Espa??ol", 222,
				"Los ojos del perro siberiano es una novela juvenil perteneciente al escritor argentino Antonio Santa Ana.",
				genero, autor);
		Libro libro2 = new Libro("144146789", "Las cronicas de Narnia", new Date("11/04/1996"), "Espa??ol", 124,
				"Las Cr??nicas de Narnia (t??tulo original en ingl??s: The Chronicles of Narnia) es una heptalog??a de libros juveniles",
				genero2, autor2);
		Libro libro3 = new Libro("156456789", "Harry Potter", new Date("21/11/1991"), "Espa??ol", 315,
				"Harry Potter es una serie de novelas fant??sticas escrita por la autora brit??nica J. K. Rowling, en la que se describen las aventuras del joven aprendiz de magia y hechicer??a Harry Potter",
				genero3, autor3);
		Libro libro4 = new Libro("176456789", "100 a??os de Soledad", new Date("11/07/1991"), "Espa??ol", 415,
				"Cien a??os de soledad es una novela del escritor colombiano Gabriel Garc??a M??rquez", genero3, autor2);
		Libro libro5 = new Libro("166456789", "Las almas muertas", new Date("11/12/1981"), "Espa??ol", 367,
				"es una obra escrita por Nikol??i G??gol y publicada en 1842", genero2, autor3);

		// SAVE LIBRO
		session.save(libro);
		session.save(libro2);
		session.save(libro3);
		session.save(libro4);
		session.save(libro5);

		// BIBLIOTECA
		Biblioteca biblioteca = new Biblioteca(1, new Date(), 1, libro);
		Biblioteca biblioteca2 = new Biblioteca(2, new Date(), 1, libro2);
		Biblioteca biblioteca3 = new Biblioteca(3, new Date(), 2, libro3);
		Biblioteca biblioteca4 = new Biblioteca(4, new Date(), 1, libro4);
		Biblioteca biblioteca5 = new Biblioteca(5, new Date(), 2, libro5);
		// ALTA BIBLIOTECA
		session.save(biblioteca);
		session.save(biblioteca2);
		session.save(biblioteca3);
		session.save(biblioteca4);
		session.save(biblioteca5);
		//BAJA BIBLIOTECA
		session.delete(biblioteca);
		//UPDATE BIBLIOTECA
		biblioteca2.setEstado(2);
		session.update(biblioteca2);
		
		//LISTADO
		Biblioteca bli=(Biblioteca)session.get(Biblioteca.class,2);
		System.out.println("BIBLIOTECA DE LA BASE");
        System.out.println(bli.toString());	

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
