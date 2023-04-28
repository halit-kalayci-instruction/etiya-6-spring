package com.etiya.ecommercedemo.business.concretes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryManagerTest {

    // Mockito
    @BeforeEach
    void setUp() {
        // Her test öncesi çalıştırılacak alan.
    }

    @AfterEach
    void tearDown() {
        // Her test sonrası çalıştırılacak alan.
    }

    @Test
    void add() {
        // 3A Principle
        // 3A prensipi

        // Arrange, Act, Assert

        // Arrange => Testimi yapacağım ortamın hazırlanması.  Örn. Mock objelerin oluşturulması. Bağımlılıkların yüklenmesi.

        // Act (Action) => CategoryManager.Add(); (Test edeceğim metodu işleme almak.)

        // Assert (Beklenti) => Expected durum ile Actual durum karşılaştırmasının yapıldığı nokta.
        // categoryManager.add().throwsException() ? boolean
    }
}