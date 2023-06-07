package com.rasentycours.bibliotheque;

import com.rasentycours.bibliotheque.service.CategoryService;

public class App {

    public static void main(String[] args) {

        CategoryService service = new CategoryService();

        service.addCategory();
        service.addCategory();
        service.addCategory();

        service.showCategories();

        service.updateCategory();

        service.showCategories();

        service.deleteCategoryById();

        service.showCategories();

        service.findCategoryById();
    }
}