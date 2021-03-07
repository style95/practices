package three;

import java.util.LinkedList;

public class ThreePointSeven {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        Dog dog1 = new Dog(0, "dog1");
        Dog dog2 = new Dog(0, "dog2");
        Dog dog3 = new Dog(0, "dog3");
        Dog dog4 = new Dog(0, "dog4");
        Dog dog5 = new Dog(0, "dog5");
        Dog dog6 = new Dog(0, "dog6");


        Cat cat1 = new Cat(0, "cat1");
        Cat cat2 = new Cat(0, "cat2");
        Cat cat3 = new Cat(0, "cat3");
        Cat cat4 = new Cat(0, "cat4");
        Cat cat5 = new Cat(0, "cat5");
        Cat cat6 = new Cat(0, "cat6");

        shelter.enqueue(dog1);
        shelter.enqueue(dog2);
        shelter.enqueue(cat1);
        shelter.enqueue(dog3);
        shelter.enqueue(dog4);
        shelter.enqueue(cat2);
        shelter.enqueue(cat3);
        shelter.enqueue(dog5);
        shelter.enqueue(cat4);
        shelter.enqueue(cat5);
        shelter.enqueue(dog6);
        shelter.enqueue(cat6);

        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueCat());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueCat());
        System.out.println(shelter.dequeueCat());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());


    }
}

class Animal {
    int index;
    String name;

    public Animal(int i, String n) {
        this.index = i;
        this.name = n;
    }

    public String toString() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(int i, String n) {
        super(i, n);
    }
}
class Cat extends Animal {
    public Cat(int i, String n) {
        super(i, n);
    }
}


class AnimalShelter {
    int index = 0;
    LinkedList<Cat> cats = new LinkedList<>();
    LinkedList<Dog> dogs = new LinkedList<>();


    public void enqueue(Animal animal) {
        if(animal instanceof Dog) {
            animal.index = index++;
            dogs.add((Dog) animal);
        } else {
            animal.index = index++;
            cats.add((Cat) animal);
        }
    }

    public Cat dequeueCat() {
        Cat cat = cats.getFirst();
        cats.removeFirst();
        return cat;
    }

    public Dog dequeueDog() {
        Dog dog = dogs.getFirst();
        dogs.removeFirst();
        return dog;
    }

    public Animal dequeueAny() {
        if(dogs.isEmpty()) {
            Cat cat = cats.getFirst();
            cats.removeFirst();
            return cat;
        }
        if(cats.isEmpty()) {
            Dog dog = dogs.getFirst();
            dogs.removeFirst();
            return dog;
        }

        Dog dog = dogs.getFirst();
        Cat cat = cats.getFirst();
        if(dog.index > cat.index) {
            cats.removeFirst();
            return cat;
        }
        dogs.removeFirst();
        return dog;
    }
}
