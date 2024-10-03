# Notes pour le cours de Java Advancee

## Rappel:

### Notions de base:

#### Common points with other languages:

##### Control structures:

1. For loop:
   Syntax:

```java
for ( initialisation; termination; increment ) {
    statement(s)
}
```

2. While loop:
   Syntax:

```java
while (expression) {
    statement(s)
}
```

3. Do-While loop:
   Syntax:

```java
do {
    statement(s)
} while (expression);
```

4. Conditional statements:
   Syntax:

```java
if (condition) {
    statement(s)
} else if (condition) {
    statement(s)
} else {
    statement(s)
}
```

##### Variables:

1. Declaration:

Syntax: `type variableName = value;` or `type variableName;`

2. Reference, value and primitive types:

On ne manipule pas explicitement les pointeurs/addresses.
Pour les types primitifs, on manipule directement la valeur.
Pour les types références, on manipule une référence à l'objet.

#### L'orienté objet:

##### Classes et objets:

Classe: Modèle pour créer caractéristiques et comportements d'un objet.
Contient 2 types de membress:

- Champs (variables):
  - Variables deffinisant les caractéristiques de l'objet.
- Méthodes (fonctions):
  - Fonctions définissant les comportements de l'objet.

Objet: Instance d'une classe.

##### Definition d'une classe:

Les classes sont logiquemnet regroupées dans des packages.

Exemple:

```java
package nameOfPackage;

public class ClassName { // Besoin de visibilite
    // Champs
    type fieldName; // Besoin de visibilite
    // Méthodes
    type methodName() { //...
        // Code
    }
}

```

##### Constructeurs:

1. Principle:

Un constructeur permet d'instancier une classe en initialisant less valeurs de ses attributs avec dess valeurs pertinentes.

\*Au java, si aucune constructeur n'est défini, un constructeur par défaut est créé **_(implicitement)_**.\*

Definition d'un constructeur:

- Même nom que la classe.
- N'a pas de type de retour.

Exemple:

```java
class Greeter {
    int nbGreetings = 2;
    boolean fr;

    Greeter(boolean fr) {
        this.fr = fr;
    }

    void printHello(){
        // Code
    }
}

```

2. Appel d'un constructeur:

On a 2 facon d'appeler un constructeur:

- Pour initialiser un objet, `new MyClass([params]);`
- Uniquement au sein d'un constructeur, `this([params]);`
  Par exemple:

```java
Greeter (boolean fr, int nbGreetings) {
    this.fr = fr;
    this.nbGreetings = 3;
}

Greeter (boolean fr) {
    this(fr, 2);
}
```

##### Utilisaion and manipulation of objects:

1. Declaration:

It can be declared as: `ClassName objectName;` or `ClassName objectName = new ClassName();`

For initialisation, we can:

- Use a constructor: `ClassName objectName = new ClassName([params]);` or `objectName = new ClassName();`
- Use an other objects: `objectName = otherObject;`

We can also declare and initialise in the same line: `ClassName objectName = new ClassName([params]);`
Example:

```java
Greeter g1;
g1 = new Greeter(true);
Greeter g2 = new Greeter(false);
```

Notons que tous les types primitifs possèdent une classe correspondante (wrapper class).

Par exemple: `int` -> `Integer`, `double` -> `Double`, `char` -> `Character`, etc.

Ces classes a autres methodes comme `parseInt`, `parseDouble`, `toString`, `valueOf`, etc.

2. Access to a member:

From an instance: `myObject.myField`  
From a current instance ( au sein de la classe ): `this.myField`  
From a class: Only a static field: `ClassName.myField`

Example:

```java
Greeter ( boolean fr, int nbGreetings ) {
    this.fr = fr;
    this.nbGreetings = nbGreetings;
}
```

Note that:

- Le constructeur est une sorte de méthodes particulière.
- Pour manipuler, il faut instancier

3. Comparison:

Il éxiste 2 types de comparaisons:

- `==` : Compare les références. ( Ex: `object1 == object2` ). Il retourne true <=> si 2 objets **font référence au même objet en mémoire**.
- Le méthode `equals` : Proposé par tous les objets java. Par défaut, il compare les références. Il pourrait être redéfini.

_Note that:_
_La classe `String` redéfinit la méthode `equals` pour comparer les valeurs._
_Exemple:_

```java
String s1 = "Hello";
String s2 = "Hello";
System.out.println(s1.equals(s2)); // true
System.out.println(s1 == s2); // false (car les références sont différentes)
```

En effet, s1 et s2 représentent les objets different en mémoire meme si les valeurs sont les mêmes.

###### Accessibilié

4 types de visibilité:
Summary
![](assets/images/access_modifier.png)

Detail
![](assets/images/detail_access.png)

###### Persistance

1. final:
   Pour un champ, il est initialisé à la construction de l'objet et non modifiable.
2. static:
   Un membre est independant de l'instance de la classe, il devient un membre de la classe et non de l'objet.

Exemple:

```java
public class myClassWithId {
    private static int instanceCounter = 0;
    private final int myId = instanceCounter++;
    public int getMyId() {
        return myId;    
    }
}
```
En main:
```java
myClassWithId c1 = new myClassWithId();
System.out.println(c1.getMyId());
myClassWithId c2 = c1;
System.out.println(c2.getMyId());
myClassWithId c3 = new myClassWithId();
System.out.println(c3.getMyId());
```
Output to be `0 0 1`


##### Dialogue avec l'extérieur

###### Les sorties:

Sortie standard: `System.out`
- out: un champ statique de la classe `System` de type `PrintStream`
- les méthodes sont:
    - println: une méthode de la classe `PrintStream`
    - print: une méthode de la classe `PrintStream`
    - write: une méthode de la classe `PrintStream`

Une sortie d’erreur est également disponible : `System.err`.

###### Les entrées:
`Scanner`, par exemple, se manipule comme suit :
```java
Scanner sc = new Scanner(System.in); //on lit l’entrée standard
Integer i= null; //Integer est une encapsulation deint en faisant
// un type non primitif
i = sc.nextInt(); //Récupération du prochain int de
l’entrée standard
nbGreetings = i
System.out.println("Nous saluerons: " + i + " fois");
sc.close();
```

#### Bonne pratique:
##### Setter, getter et checker:
- Le seter permet de changer la valeur de l’attribut et est nommé setAtt
- Le geter renvoie la valeur de l’attribut et est nommé getAtt
- Le checker est un cas particulier lorsque att est booléen. Son geter se notera isAtt
##### Documentation:
Les tags les plus usités sont :
- @param décrit un paramètre d’une méthode
- @return décrit ce que retourne une fonction
- @throws exception propagée par la méthode
- @author auteur de la classe
- @version version de la classe
- @see référence à d’autres méthodes/classes : @see MyClass#myMethod(prototype)
- @since début de validité de la méthode
- @deprecated indique la méthode va disparaître dans une version future

### Héritage:

L’héritage est un des principes fondamentaux de tout langage objet. 
Il permet de baser une classe A sur une autre (notée ici B), en "récupérant" l’implémentation sans avoir à la dupliquer.

```uml
A --> B
```

En général, A aura au moins les mêmes membres (attributs et méthodes) que B.
- On dit alors que A hérite de B
- A dérive de B
- A est une sous-classe de B
- B est une super-classe de A

En général, si A hérite de B, tous les membres accessibles (public, package ou protected) sur B sont accessible sur A.

On parle d’héritage d’interface. En notant IA et IB l’interface de A et B (vu comme l’ensemble des membres accessibles qu’ils soient méthodes ou champs), on a IA ⊆ IB

Par abus, il arrive de considérer qu’une relation d’héritage implique une relation de sous-typage. Par exemple, si A hérite de B, on pourra considérer qu’A est un sous type de B (e.g. Carré est un sous-type de Rectangle).

#### Usages de l'héritage:

En règle général, l’héritage permet de:
- Spécialiser une classe. On va alors ajouter des fonctionnalités et/ou modifier le
comportement de certaines méthodes.
- Abstraire ou généraliser un ensemble de classes pour les regrouper au sein d’un
même concept (qui sera abstrait ou concret @see abstraction).

##### Spécialisation

Au sein de la classe dérivée, tous les champs `public` et `protected` de la classe mère sont accessibles, `package` se comportant normalement. Les membres `private` de la classe mère ne sont pas accessibles depuis la classe fille.

![](assets/images/heri_access.png)

Toutes les méthodes peuvent être re-définies pour en changer le comportement.
Il également possible d’en changer la visibilité, mais *uniquement pour l’augmenter,jamais la restreindre*

#### Mise en oeuvre:

##### Premières remarques
En java, toute classe hérite implicitement d’Object

* ***En java il n’est pas possible d’hériter de plusieurs classes***

Mot clé final:  
- Pour une classe : elle ne peut être dérivée et donc ne peut avoir de classe fille. On parlera parfois de feuille.
- Pour une méthode : elle ne peut être redéfinie (i.e. son comportement ne peut être changé au sein d’une classe fille).

#####  Classes dérivées : ce qui change du fait de l’héritage

###### Déclaration

Dans la déclaration de la classe fille, on utilisera simplement le mot clé
`extends` pour indiquer un héritage suivi du nom de la classe mère.

```java
public class Safe{
    ...
}
public class SafeWithCode extends Safe{
    ...
}
```
###### Constructeur et initialisation

**Lors de l’instanciation d’une classe dérivée, sa classe mère est également instanciée**
- Si rien n’est précisé, le constructeur *sans argument* de la classe mère est appelée implicitement
- Si la classe mère ne possède pas de constructeur sans argument ou si on souhaite invoquer un autre constructeur, **un constructeur de la classe mère doit être appelé explicitement dans la première ligne de la classe dérivée**. L’appel aux
constructeurs de la classe mère se fait à l’aide du mot-clé super
Exemple:
```java
public SafeWithCode(int capacity, int code){
    super(); //appel explicite au constructeur sans
    argument de la classe mère Safe
    this.code = code;
}
```
Voir cette exemple:
```java
public SafeWithCode(int capacity, int code){
    //appel implicite au constructeur sans
    argument de la classe mère Safe
    this.code = code;
}
```
On obtient une erreur de compilation car la classe mère Safe ne possède pas de constructeur sans argument.

On peut (et doit) donc faire référence explicitement au dit constructeur :
```java
public SafeWithCode(int capacity, int code){
    super(capacity);
    this.code = code;
}
