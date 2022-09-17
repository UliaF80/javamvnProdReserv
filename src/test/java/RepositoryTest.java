import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    @Test
    public void testFindById() {
        Repository repo = new Repository();

        Product book1 = new Book(112, "Robert", 150, "Jon");
        Product book2 = new Book(250, "Friends", 150, "Jon");
        Product smartphone1 = new Smartphone(150, "Samsung", 5000, "Samsung");
        Product smartphone2 = new Smartphone(312, "Lg", 3000, "Lg");
        Product smartphone3 = new Smartphone(211, "Samsung", 6000, "Samsung");

        repo.add(book1);
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.findById(0);

        Product[] expected = {book1, book2, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.getId();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testNotFoundException() {
        Repository repo = new Repository();

        Product book1 = new Book(112, "Robert", 150, "Jon");
        Product book2 = new Book(250, "Friends", 150, "Jon");
        Product smartphone1 = new Smartphone(150, "Samsung", 5000, "Samsung");
        Product smartphone2 = new Smartphone(312, "Lg", 3000, "Lg");
        Product smartphone3 = new Smartphone(211, "Samsung", 6000, "Samsung");

        repo.add(book1);
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(400);
        });
    }

    @Test
    public void testFindProduct() {
        Repository repo = new Repository();

        Product book1 = new Book(112, "Robert", 150, "Jon");
        Product book2 = new Book(250, "Friends", 150, "Jon");
        Product smartphone1 = new Smartphone(150, "Samsung", 5000, "Samsung");
        Product smartphone2 = new Smartphone(312, "Lg", 3000, "Lg");
        Product smartphone3 = new Smartphone(211, "Samsung", 6000, "Samsung");

        repo.add(book1);
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.findById(book1.id);

        Product[] expected = {book1, book2, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.products;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {
        Repository repo = new Repository();

        Product book1 = new Book(112, "Robert", 150, "Jon");
        Product book2 = new Book(250, "Friends", 150, "Jon");
        Product smartphone1 = new Smartphone(150, "Samsung", 5000, "Samsung");
        Product smartphone2 = new Smartphone(312, "Lg", 3000, "Lg");
        Product smartphone3 = new Smartphone(211, "Samsung", 6000, "Samsung");

        repo.add(book1);
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.removeById(book1.getId());

        Product[] expected = {book2, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.getId();
        Assertions.assertArrayEquals(expected, actual);
    }


}