package com.rasentycours.bibliotheque;

import com.rasentycours.bibliotheque.service.BookService;
import com.rasentycours.bibliotheque.service.CategoryService;
import com.rasentycours.bibliotheque.service.SubscriptionTypeService;

public class App {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        bookService.addBook();
        bookService.addBook();
        bookService.addBook();
        bookService.showBooks();
        //
        bookService.findBook();
        //
        bookService.updateBook();
        bookService.showBooks();
        /*
         * CategoryService service = new CategoryService();
         * service.addCategory();
         * service.addCategory();
         * service.addCategory();
         * 
         * service.showCategories();
         * 
         * service.updateCategory();
         * 
         * service.showCategories();
         * 
         * service.deleteCategorieById();
         * 
         * service.showCategories();
         * service.findCategoryById();
         * 
         * SubscriptionTypeService service = new SubscriptionTypeService();
         * service.addSubscriptionType();
         * service.addSubscriptionType();
         * service.addSubscriptionType();
         * 
         * service.showSubcriptionTypes();
         * 
         * service.updateSubcriptionType();
         * 
         * service.showSubcriptionTypes();
         * 
         * service.deleteSubcriptionTypeById();
         * 
         * service.showSubcriptionTypes();
         * service.findSubscriptionTypeById();
         */

    }

}