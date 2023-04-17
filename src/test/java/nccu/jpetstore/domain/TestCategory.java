package nccu.jpetstore.domain;

import nccu.jpetstore.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCategory {
    private Category category;
    private String categoryId;
    private String categoryName;
    private String categoryDescription;

    @BeforeEach
    public void setUp() {
        category = new Category();
        categoryId = "C123";
        categoryName = "Electronics";
        categoryDescription = "Electronic gadgets and devices";

        category.setCategoryId(categoryId);
        category.setName(categoryName);
        category.setDescription(categoryDescription);
       // System.out.println(category);
    }

    @Test
    public void testCategoryId() {
        assertEquals(categoryId, category.getCategoryId());
    }

    @Test
    public void testCategoryName() {
        assertEquals(categoryName, category.getName());
    }

    @Test
    public void testCategoryDescription() {
        assertEquals(categoryDescription, category.getDescription());
    }
}

