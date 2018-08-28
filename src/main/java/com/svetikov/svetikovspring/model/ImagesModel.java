package com.svetikov.svetikovspring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Blob;
@Getter
@Setter
@ToString
@Entity
@Table(name = "images_storage")
public class ImagesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_images;
    @Lob
    private byte[] blob;

    public ImagesModel() {
    }

    public ImagesModel(byte[] blob) {
        this.blob = blob;
    }
}
