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
=> @NotFound(action=NotFoundAction.IGNORE)




## Hibernate Collection
1. Bag Semantic  		 => List/ArrayList   (can put in order and reterive in nay order)
2. Bag Semantic with Id  => List/ArrayList
3. List Semantic         => List/ArrayList   (maintains the order)  
4. Set Semantic          => Set
5. Map Semantic          => Map


CASCADING :-
1. When we are saving user we use save(user) and if have to save multiple vehicles for that particular user, we have to save them one by one which makes code look untidy or when we ahve to delete the user and delete the relevant vehicle associated with that particular user one by one.



## Hibernate Inheritance
1. SingleTable Strategy (by default)
2. TablePerClass Strategy
3. Joined

### SingleTable Strategy (by default)
=> In this only one table is created irrespective of what class it is being referred.
=> that table will have a DTYPE(discriminator type) column which will have the name of the Enity.
=> This table will have all the columns (adding the columns which different entity have) but will skip the value if the particular enyity doesnot have the value for that.

### TablePerClass Strategy
=> Doesnot need DiscriminatorColumn.
=> This is normalized form where we don't have column where null value is present as it is present in case of SingleTable since that field is not present in that class. No blank column will be inherited.
=> All the filds of parent class with the annotationon it is carried forward to the child.

### Joined Strategy
=> A strategy in which fields that are specific to a subclass are mapped to a separate table than the fields that are common to the parent class, and a join is performed to instantiate the subclass.