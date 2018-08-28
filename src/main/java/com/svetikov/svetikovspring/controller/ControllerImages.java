package com.svetikov.svetikovspring.controller;

import com.svetikov.svetikovspring.model.ImagesModel;
import com.svetikov.svetikovspring.repository.ImagesModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class ControllerImages {
    @Autowired
    ImagesModelRepository imagesModelRepository;

    @PostMapping("/save/images")
    public String saveImage(@RequestParam("file_img") MultipartFile file_img, RedirectAttributes redirectAttributes) throws IOException {
        log.info(">>>>>>>>>>>>>>>>>> " + file_img);
        ImagesModel imagesModel = new ImagesModel(file_img.getBytes());
        imagesModelRepository.save(imagesModel);
        redirectAttributes.addFlashAttribute("message", file_img.getOriginalFilename());
        return "redirect:/show/images/all1";
    }

    @GetMapping(value = "/show/images")
    public String showImages(Model model, HttpServletResponse response) {

        return "show_image";
    }

    @ResponseBody
    @GetMapping(value = "/show/images2", consumes = MediaType.ALL_VALUE, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> showImages2(HttpServletResponse response) {
        byte[] images = imagesModelRepository.findById(3).get().getBlob();
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        return ResponseEntity.ok(images);
    }

    @GetMapping("/show/images/all1")
    public String showAllImages(Model model){
        List<Integer> list=imagesModelRepository.findAllImages();
        model.addAttribute("id_img",list);
        return "imagesAll";
    }

    @ResponseBody
    @GetMapping(value = "/show/images/all/{model}",consumes = MediaType.ALL_VALUE,produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> showAllImagesList(@PathVariable int model,HttpServletResponse response){

        byte[] images=imagesModelRepository.findById(model).get().getBlob();
        return ResponseEntity.ok(images);
    }




}
