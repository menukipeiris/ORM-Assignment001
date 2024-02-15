# **ORM Supplementary Assignment 01**

## **Annotations**

#### **@Entity Annotation**

The @Entity annotation is used to mark a Java class as an entity, indicating that instances of this class will be persisted to a relational database. An entity in JPA represents a table in a database, and each instance of the entity corresponds to a row in that table.

#### **@Id Annotation**
The @Id annotation in Java is used to designate a field or property of an entity class as the primary key.

#### **@GeneratedValue Annotation**
The @GeneratedValue annotation in Java, specifically within the context of the Java Persistence API (JPA), is used to specify how the primary key values for entities should be generated.

#### **@OneToMany Annotation**
This annotation is used to define a one to many relationship between two entities.

#### **@ManyToOne Annotation**

@ManyToOne annotation in Hibernate is used to create a many-to-one relationship between two entities. The @ManyToOne annotation indicates that the many instances of one entity can be associated with only one instance of another entity.

#### **@JoinColumn Annotation**

The @JoinColumn annotation in Hibernate is used to specify the mapping of a foreign key column in a relationship between two entities. The @JoinColumn annotation is applied on the owning side of the association to define the foreign key column name and other attributes which are related to the join column.


## **@GeneratedValue (Generation Types)**

#### **1.GenerationType.IDENTITY**

GenerationType.IDENTITY is one of the strategies available for generating primary key values in JPA (Java Persistence API) when using the @GeneratedValue annotation.

#### **2.GenerationType.AUTO**

This is a default strategy and the persistence provider which automatically selects an appropriate generation strategy based on the database usage.

#### **3.GenerationType.TABLE**

This strategy uses a separate database table to generate primary key values. The persistence provider manages this table and uses it to allocate unique values for primary keys.

#### **4.GenerationType.SEQUENCE**

This generation-type strategy uses a database sequence to generate primary key values. It requires the usage of database sequence objects, which varies depending on the database which is being used.

## **Cascade operations in Hibernate**

Cascading is a feature in Hibernate, which is an object-relational mapping(ORM) tool used in Java to map Java classes to database tables. Cascading refers to the ability to automatically propagate the state of an entity across associations between entities.

### **Different Cascade Types in Hibernate**

#### **1.CascadeType.ALL**

CascadeType.ALL is a cascading type in Hibernate that specifies that all state transitions (create,update,delete,and refresh) should be cascaded from the parent entity to the child entities. When CascadeType.ALL is used, and any operation performed on the parent entity will be automatically propagated to all child entities. This means that if you persist, update, or delete a parent entity, all child entities associated with it will also be persisted, updated,or deleted accordingly.

#### **2.CascadeType.PERSIST**

CascadeType.PERSIST is a cascading type in Hibernate that specifies that the create (or persist) operation should be cascaded from the parent entity to the child entities. When CascadeType.PERSIST is used, any new child entities associated with a parent entity will be automatically persisted when the parent entity is persisted. However, updates or deletions made to the parent entity will not be cascaded to the child entities.

#### **3.CascadeType.MERGE**

CascadeType.MERGE is a cascading type in Hibernate that specifies that the update (or merge) operations should be cascaded from the parent entity to the child entities. When CascadeType.MERGE is used, any changes made to a detached parent entity will be automatically merged with its associated child entities when the parent entity is merged back into the persistence context. However, new child entities that are not already associated with the parent entity will not be automatically persisted.

#### **4.CascadeType.REMOVE**

CascadeType.REMOVE is a cascading type in Hibernate that specifies that the delete operation should be cascaded from the parent entity to the child entities. When CascadeType.REMOVE is used, any child entities associated with a parent entity will be automatically deleted when the parent entity is deleted. However, updates or modifications made to the parent entity will not be cascaded to the child entities.

#### **5.CascadeType.REFRESH**

CascadeType.REFRESH is a cascading type in Hibernate that specifies that the refresh operations should be cascaded from the parent entity to the child entities. When CascadeType.REFRESH is used, any child entities associated with a parent entity will be automatically refreshed when the parent entity is refreshed. This means that the latest state of the child entities will be loaded from the database and any changes made to the child entities will be discarded.

#### **6.CascadeType.DETACH**

CascadeType.DETACH is a cascading type in Hibernate that specifies that the detach operation should be cascaded from the parent entity to the child entities. When CascadeType.DETACH is used, any child entities associated with a parent entity will be automatically detached when the parent entity is detached. This means that the child entities will become detached from the persistence context and their state will no longer be managed by Hibernate.

#### **7.CascadeType.REPLICATE**

CascadeType.REPLICATE is a cascading type in Hibernate that specifies that the replicate operation should be cascaded from the parent entity to the child entities. When CascadeType.REPLICATE is used, any child entities associated with a parent entity will be automatically replicated when the parent entity is replicated. This means that new child entities will be created and persisted in the database with the same state as the original child entities.

#### **8.CascadeType.SAVE_UPDATE**

CascadeType.SAVE_UPDATE is a cascading type in Hibernate that specifies that the save or update operation should be cascaded from the parent entity to the child entities. When CascadedType.SAVE_UPDATE is used, any child entities associated with a parent entity will be automatically saved or updated when the parent entity is saved or updated. This means that any changes made to the child entities will be persisted in the database along with the parent entity.


## **Assignments**

1.Query query1 = session.createQuery("select title from Book where publicationYear > '2010'");

2.Query query2 = session.createQuery("update Book set price = price + (price * 10.0 / 100.0)  where author.id = :author_id");

4.Query query3 = session.createQuery("select avg (price) from Book ");

5.Query query4 = session.createQuery("select a.name, count (b.title) from Author a left join a.books b group by a.id,a.name");

6.Query query5 = session.createQuery("select b from Book b join b.author a where a.country = :countryName");

7.Query query6 = session.createQuery("select a.name from Author a where (select count(b.title) from Book b where b.author = a) > " +
"(select avg(count(b.title)) from Book b group by b.author)");
