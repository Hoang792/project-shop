package com.example.quanlydt.controllor;

import org.springframework.ui.Model;
import com.example.quanlydt.entity.Phone;
import com.example.quanlydt.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
public class PhoneControllor {

    @Autowired
    private PhoneService phoneService;

    // Thư mục lưu trữ ảnh
    private final String UPLOAD_DIR = "src/main/resources/static/images/";

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("phones", phoneService.getAllPhones());
        return "index";
    }

    @GetMapping("/search")
    public String searchPhones(@RequestParam("query") String query, Model model) {
        List<Phone> phones = phoneService.searchPhones(query);
        model.addAttribute("phones", phones);
        return "shopview"; // Trả về trang shopview với danh sách điện thoại tìm được
    }

    @GetMapping("/shopview")
    public String shopView(Model model) {
        model.addAttribute("phones", phoneService.getAllPhones());
        return "shopview"; // Trả về tên file shop.html
    }

    @GetMapping("/add")
    public String addPhoneForm(Model model) {
        model.addAttribute("phone", new Phone());
        return "addPhone";
    }

    @PostMapping("/save")
    public String savePhone(@ModelAttribute("phone") Phone phone,
                            @RequestParam("file") MultipartFile file) throws IOException {
        // Lưu ảnh
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.write(path, file.getBytes());
            phone.setImage(fileName); // Đường dẫn tương đối đến ảnh
        }
        phoneService.savePhone(phone);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editPhone(@RequestParam("id") Long id, Model model) {
        Optional<Phone> phone = phoneService.findPhoneById(id);
        phone.ifPresent(p -> model.addAttribute("phone", p));
        return "editPhone";
    }

    @PostMapping("/update")
    public String updatePhone(@ModelAttribute("phone") Phone phone,
                              @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.write(path, file.getBytes());
            phone.setImage(fileName);
        }
        phoneService.savePhone(phone);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deletePhone(@RequestParam("id") Long id) {
        phoneService.deletePhone(id);
        return "redirect:/";
    }
}
