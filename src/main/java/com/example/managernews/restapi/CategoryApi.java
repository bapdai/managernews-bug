package com.example.managernews.restapi;

import com.example.managernews.entity.Category;
import com.example.managernews.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/category")
public class CategoryApi {
    // CURD
    @Autowired
    CategoryService categoryService;
    //
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getList(){
        return ResponseEntity.ok(categoryService.findAll());
    }
    //
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        Optional<Category> optionalCategory = categoryService.findById(id);
        if (!optionalCategory.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalCategory.get());
    }
    //
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Category> create(@RequestBody Category category) {
//        return ResponseEntity.ok(categoryService.save(category));
//    }

    //    Sua thong tin(U)
//    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
//    public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category category) {
//        Optional<Category> optionalRegister = categoryService.findById(id);
//        if (!optionalRegister.isPresent()) {
//            ResponseEntity.badRequest().build();
//        }
//        Category exitsCategory = optionalRegister.get();
//        //     map object
//        exitsCategory.setId(category.getId());
//        exitsCategory.setName(category.getName());
//        return ResponseEntity.ok(categoryService.save(exitsCategory));
//    }
    //        Xoa thong tin
//    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
//    public ResponseEntity<?> delete(@PathVariable Integer id) {
//        if (!categoryService.findById(id).isPresent()) {
//            ResponseEntity.badRequest().build();
//        }
//        categoryService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
}
