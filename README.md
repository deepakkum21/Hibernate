# Hibernate

Hibernate


1. An ORM(Obeject relational Mapping) framework.
2. Used in data layer of an Apllication.
3. Implements JPA.


The Problem:-
1. Mapping member variables to columns.
2. Mapping relationships. (varibale is of referenced type)
3. Handling datatypes. (bol in java needs to be handled in db as varchar)
4. Managing changes to object state.


Saving Without Hibernate:-
1. JDBC Database configuartion.
2. The Model Object.
3. Service method to create the model object.
4. Database design.
5. DOA method to save the object using sql queries.

The Hibernate way:-
1. JDBC Database configuartion- Hibernate configuartion (XML file).
2. The Model Object- Annotations.
3. Service method to create the model object - Use the Hibernate API.
4. Database Design not needed.
5. DOA method to save the object using sql queries. (Not needed).

Using Hibernate API:-
1. Create Session factory (Once).
2. Create Sessions from Session Factory.
3. Use the session to save the model objects.

eg  	SessionFactory sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(userDetails);
		transaction.commit();           // session.getTransaction().commit();
		
		
Note: 
MySql uses storage engine to 
1. MYISAM storage engine:- locks whole table
2. INNODB storage engine:- locks row of a table		


=> If certain field don't want to be persisted, mark that field as @Transient or static


Object as Attribute
1. Entity object
2. Value object  => @Embeddable (class)  , @Embedded(for attibute)

Note:- 
1. Cannot use @Embedded and @Id over a attribute who is value object wants to act like a primary key, use @EmbeddedId


@Entity(name = "Emp") :This name will be used to name Entity@Table(name = "Emp") :This name will be used to name a table in DB
So in first case your table and entity will have same name, that will allow you to access your table with same name as entity while writing HQL or JPQL.
And in second case while writing queries you have to use the name given in @Entity and name given in @Table will be used to name the table in DB.

@Entity(name = "Emp") : This name will be used to identify the domain this name only identify by hql queries ..ie ..name of the domain object
@Table(name = "Emp"): This name will be used to which table referred by domain object..ie ..name of the table.



Why importing most of the Annotations like @Id, @Entity, @Table, @Embeddable etc from javax.persistence
=> These are from JPA specification and hibernate is a implementor of that JPA specification.
=> Easy to switch tp other ORM instaed of hibernate which implements JPA specification.

Name one of the annotation which is not part of JPA (but part of hibernate)
=> @CollectionId(colum)
=> @GenericGenerator

