package com.example.managernews.restapi;

import com.example.managernews.entity.Category;
import com.example.managernews.entity.News;
import com.example.managernews.service.CategoryService;
import com.example.managernews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminApi {
    @Autowired
    CategoryService categoryService;
    //
    @RequestMapping(method = RequestMethod.GET, path = "view/category")
    public ResponseEntity<List<Category>> getList(){
        return ResponseEntity.ok(categoryService.findAll());
    }
    //
    @RequestMapping(method = RequestMethod.GET, path = "view/category-id")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        Optional<Category> optionalCategory = categoryService.findById(id);
        if (!optionalCategory.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalCategory.get());
    }
    //
    @RequestMapping(method = RequestMethod.POST, path = "post/category")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.save(category));
    }

    //    Sua thong tin(U)
    @RequestMapping(method = RequestMethod.PUT, path = "put/category-id")
    public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category category) {
        Optional<Category> optionalRegister = categoryService.findById(id);
        if (!optionalRegister.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Category exitsCategory = optionalRegister.get();
        //     map object
        exitsCategory.setId(category.getId());
        exitsCategory.setName(category.getName());
        return ResponseEntity.ok(categoryService.save(exitsCategory));
    }
    //        Xoa thong tin
    @RequestMapping(method = RequestMethod.DELETE, path = "delete/category-id")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!categoryService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    /*    */
    @Autowired
    NewsService newsService;
    //
    @RequestMapping(method = RequestMethod.GET, path = "view/news")
    public ResponseEntity<List<News>> getList(){
        return ResponseEntity.ok(newsService.findAll());
    }
    //
    @RequestMapping(method = RequestMethod.GET, path = "view/news-id")
    public ResponseEntity<?> getDetail(@PathVariable int id) {
        Optional<News> optionalNews = newsService.findById(id);
        if (!optionalNews.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalNews.get());
    }
    //
    @RequestMapping(method = RequestMethod.POST,path = "post/news")
    public ResponseEntity<News> create(@RequestBody News news) {
        return ResponseEntity.ok(newsService.save(news));
    }

    //    Sua thong tin(U)
    @RequestMapping(method = RequestMethod.PUT, path = "put/news-id")
    public ResponseEntity<News> update(@PathVariable Integer id, @RequestBody News news) {
        Optional<News> optionalNews = newsService.findById(id);
        if (!optionalNews.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        News exitsNews = optionalNews.get();
        //     map object
        exitsNews.setId(news.getId());
        exitsNews.setTitle(news.getTitle());
        exitsNews.setDescription(news.getDescription());
        exitsNews.setContent(news.getContent());
        exitsNews.setViews(news.getViews());
        exitsNews.setStatus(news.getStatus());
        exitsNews.setAuthor(news.getAuthor());
        return ResponseEntity.ok(newsService.save(exitsNews));
    }
    //        Xoa thong tin
    @RequestMapping(method = RequestMethod.DELETE, path = "delete/news-id")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!newsService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        newsService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
