package com.example.myapplication.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bike {
    private String name;
    private String imageUrl;
    private String description;

    public Bike() {
    }

    public Bike(String name, String imageUrl, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public static List<Bike> createBikeList() {
        return Arrays.asList(
                new Bike("Triban", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQKkazLSJZNK2Sux31XSSdIF9wSMomglcuZnnQb0B7m8rH1F-RzwQjFkTVCinsrkmMb99-3AGDh&usqp=CAc", "Opis"),
                new Bike("FONDRIEST", "https://www.mediaexpert.pl/media/cache/gallery/product/4/145/951/131/f4faic7a/images/19/1909283/rower-FONDRIEST-TF4-M17-Czarny-bok-2.jpg", "Opis 2"),
                new Bike("Romet", "https://static3.domenasportowa.pl/pol_pm_Rower-Romet-Huragan-700C-2020-240102_1.jpg", "Opis 3"),
                new Bike("Romet", "https://static3.domenasportowa.pl/pol_pm_Rower-Romet-Huragan-700C-2020-240102_1.jpg", "Opis 3"),
                new Bike("Romet", "https://static3.domenasportowa.pl/pol_pm_Rower-Romet-Huragan-700C-2020-240102_1.jpg", "Opis 3"),
                new Bike("Romet", "https://static3.domenasportowa.pl/pol_pm_Rower-Romet-Huragan-700C-2020-240102_1.jpg", "Opis 3"),
                new Bike("Romet", "https://static3.domenasportowa.pl/pol_pm_Rower-Romet-Huragan-700C-2020-240102_1.jpg", "Opis 3"),
                new Bike("Romet", "https://static3.domenasportowa.pl/pol_pm_Rower-Romet-Huragan-700C-2020-240102_1.jpg", "Opis 3"),
                new Bike("Romet", "https://static3.domenasportowa.pl/pol_pm_Rower-Romet-Huragan-700C-2020-240102_1.jpg", "Opis 3"),
                new Bike("Romet", "https://static3.domenasportowa.pl/pol_pm_Rower-Romet-Huragan-700C-2020-240102_1.jpg", "Opis 3")
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
