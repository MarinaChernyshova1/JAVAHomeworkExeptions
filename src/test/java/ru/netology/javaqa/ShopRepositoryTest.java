package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testWhenIdExists ()  {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Кружка", 5000);
        Product product2 = new Product(2, "Термос", 5500);
        Product product3 = new Product(3, "Котелок", 6000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        repository.remove(2);

        Product[] actual = repository.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void testWhenTrowsNotFoundException ()  {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Кружка", 5000);
        Product product2 = new Product(2, "Термос", 5500);
        Product product3 = new Product(3, "Котелок", 6000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class, ()->{
            repository.remove(4);
        });
    }
    @Test
    public void testWhenIdAlreadyExists ()  {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Кружка", 5000);
        Product product2 = new Product(3, "Термос", 5500);
        Product product3 = new Product(3, "Котелок", 6000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class,
                ()->{
            repository.add();
        });





    }



}