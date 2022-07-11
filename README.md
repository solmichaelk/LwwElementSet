# LwwElementSet
  

## com.crdt.lww.entity

**JpaEntityInterface:** interface of Mocked JPA entity base class, defined getter and setter methods for ID

**JpaEntity:** Mocked JPA entity base class, implement getter and setter methods for ID, auto generate a random ID in constructor

**User:** Mocked User JPA entity, define additional name field


## com.crdt.lww.element

**ElementInterface:**  interface of base class of LWW element, defining 2 sets of getter and setter methods, for timestamp and orginal objects

**LwwElement:** abstract LWW element base class, implement getter and setter methods for timestamp and data

**StringLwwElement:** extension of LwwElement for String data type of elements

**JpaEntityLwwElement:** extension of LwwElement for JPA entity type of elements

  
## com.crdt.lww.set  

**ElementSetInterface:** interface of base class of LWW element set, defining methods for 4 LWW operations: Add, Remove, Exists and Get

**LwwElementSet:** abstract LWW element set base class, implement methods for LWW operations
* `add:` add or update an element in LWW element set, add or update operation is made to addList of LWW element set with a latest timestamp
* `remove:` remove an element in LWW element set, add or update operation is made to removeList of LWW element set with a latest timestamp
* `exists(Object):` check if an object is existed in LWW element set
* `exists(LwwElement):` check if a LwwElement object is existed in LWW element set
* `get:` return an ArrayList of all existed elements in a LWW element set
* `getAddListSize:` return the size of addList of LWW element set
* `getRemoveListSize` return the size of removeList of LWW element set
* `getCurrentTimestamp` return the current timestamp in milliseconds
* `abstract createNewElement` expects implementation from child class to return corresponding LwwElementSet instance

**StringLwwElementSet:** extension of LwwElementSet for String data type

**JpaEntityLwwElementSet:** extension of LwwElementSet for JPA entity objects

  
