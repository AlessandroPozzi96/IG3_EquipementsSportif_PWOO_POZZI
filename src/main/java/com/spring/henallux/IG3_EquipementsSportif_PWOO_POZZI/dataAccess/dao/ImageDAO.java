package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.ImageEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.ImageRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageDAO {
    private ProviderConverter providerConverter;
    private ImageRepository imageRepository;

    @Autowired
    public ImageDAO(ProviderConverter providerConverter, ImageRepository imageRepository) {
        this.providerConverter = providerConverter;
        this.imageRepository = imageRepository;
    }

    public ArrayList<Image> getAllImages() {
        List<ImageEntity> imageEntityList = imageRepository.findAll();
        ArrayList<Image> imageArrayList = new ArrayList<>();
        for (ImageEntity entity : imageEntityList) {
            Image image = providerConverter.imageEntityToImageModel(entity);
            imageArrayList.add(image);
        }
        return imageArrayList;
    }

    public ArrayList<Image> findByArticleEntityCodeBarre(Integer codeBarre) {
        List<ImageEntity> imageEntityList = imageRepository.findByArticleEntityCodeBarre(codeBarre);
        ArrayList<Image> imageArrayList = new ArrayList<>();
        for (ImageEntity entity : imageEntityList) {
            Image image = providerConverter.imageEntityToImageModel(entity);
            imageArrayList.add(image);
        }
        return imageArrayList;
    }
}
