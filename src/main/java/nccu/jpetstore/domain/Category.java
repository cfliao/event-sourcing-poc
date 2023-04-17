package nccu.jpetstore.domain;

public class Category {

    private String categoryId;
    private String name;
    private String description;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Category{categoryId='%s', name='%s', description='%s'}",
                categoryId, name, description);
    }

}
