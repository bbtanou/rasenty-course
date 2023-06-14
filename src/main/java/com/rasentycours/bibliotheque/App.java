package com.rasentycours.bibliotheque;

import com.rasentycours.bibliotheque.service.ReaderService;

public class App {

    public static void main(String[] args) {
        ReaderService readerService = new ReaderService();

        readerService.addReader();
        readerService.addReader();
        readerService.addReader();

        readerService.showReaders();

    }

}