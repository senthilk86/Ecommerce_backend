package com.ecommerce.config;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            // Create admin user
            User admin = new User();
            admin.setEmail("admin@ecommerce.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setFirstName("Admin");
            admin.setLastName("User");
            admin.setRole(User.Role.ADMIN);
            admin.setActive(true);
            userRepository.save(admin);
            
            // Create regular user
            User user = new User();
            user.setEmail("user@example.com");
            user.setPassword(passwordEncoder.encode("password123"));
            user.setFirstName("John");
            user.setLastName("Doe");
            user.setRole(User.Role.USER);
            user.setActive(true);
            userRepository.save(user);
        }
        
        if (categoryRepository.count() == 0) {
            // Create categories
            Category electronics = new Category();
            electronics.setName("Electronics");
            electronics.setDescription("Electronic devices and gadgets");
            electronics.setImageUrl("https://images.unsplash.com/photo-1498049794561-7780e7231661");
            categoryRepository.save(electronics);
            
            Category clothing = new Category();
            clothing.setName("Clothing");
            clothing.setDescription("Fashion and apparel");
            clothing.setImageUrl("https://images.unsplash.com/photo-1489987707025-afc232f7ea0f");
            categoryRepository.save(clothing);
            
            Category books = new Category();
            books.setName("Books");
            books.setDescription("Books and literature");
            books.setImageUrl("https://images.unsplash.com/photo-1495446815901-a7297e633e8d");
            categoryRepository.save(books);
            
            // Create products
            Product laptop = new Product();
            laptop.setName("Premium Laptop");
            laptop.setDescription("High-performance laptop with latest processor");
            laptop.setPrice(new BigDecimal("1299.99"));
            laptop.setStockQuantity(50);
            laptop.setImageUrl("https://images.unsplash.com/photo-1496181133206-80ce9b88a853");
            laptop.setSpecifications("Intel i7, 16GB RAM, 512GB SSD");
            laptop.setCategory(electronics);
            laptop.setActive(true);
            productRepository.save(laptop);
            
            Product smartphone = new Product();
            smartphone.setName("Smartphone Pro");
            smartphone.setDescription("Latest smartphone with amazing camera");
            smartphone.setPrice(new BigDecimal("899.99"));
            smartphone.setStockQuantity(100);
            smartphone.setImageUrl("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9");
            smartphone.setSpecifications("6.5 inch display, 128GB storage");
            smartphone.setCategory(electronics);
            smartphone.setActive(true);
            productRepository.save(smartphone);
            
            Product tshirt = new Product();
            tshirt.setName("Premium T-Shirt");
            tshirt.setDescription("Comfortable cotton t-shirt");
            tshirt.setPrice(new BigDecimal("29.99"));
            tshirt.setStockQuantity(200);
            tshirt.setImageUrl("https://images.unsplash.com/photo-1521572163474-6864f9cf17ab");
            tshirt.setSpecifications("100% Cotton, Available in S, M, L, XL");
            tshirt.setCategory(clothing);
            tshirt.setActive(true);
            productRepository.save(tshirt);
            
            Product jeans = new Product();
            jeans.setName("Designer Jeans");
            jeans.setDescription("Stylish denim jeans");
            jeans.setPrice(new BigDecimal("79.99"));
            jeans.setStockQuantity(150);
            jeans.setImageUrl("https://images.unsplash.com/photo-1542272604-787c3835535d");
            jeans.setSpecifications("Denim, Multiple sizes available");
            jeans.setCategory(clothing);
            jeans.setActive(true);
            productRepository.save(jeans);
            
            Product book = new Product();
            book.setName("Bestseller Novel");
            book.setDescription("Captivating fiction novel");
            book.setPrice(new BigDecimal("19.99"));
            book.setStockQuantity(300);
            book.setImageUrl("https://images.unsplash.com/photo-1544947950-fa07a98d237f");
            book.setSpecifications("Paperback, 400 pages");
            book.setCategory(books);
            book.setActive(true);
            productRepository.save(book);
            
            System.out.println("Sample data initialized successfully!");
            System.out.println("Admin credentials - Email: admin@ecommerce.com, Password: admin123");
            System.out.println("User credentials - Email: user@example.com, Password: password123");
        }
    }
}
