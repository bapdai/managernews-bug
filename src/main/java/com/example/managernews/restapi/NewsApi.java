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
@RequestMapping("/api/v1/news")
public class NewsApi {
    // CURD
    @Autowired
    NewsService newsService;
    //
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<News>> getList(){
        return ResponseEntity.ok(newsService.findAll());
    }
    //
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        Optional<News> optionalNews = newsService.findById(id);
        if (!optionalNews.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalNews.get());
    }
    //
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<News> create(@RequestBody News news) {
        return ResponseEntity.ok(newsService.save(news));
    }

    //    Sua thong tin(U)
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
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
        exitsNews.setStatus(news.getStatus());
        exitsNews.setAuthor(news.getAuthor());
        return ResponseEntity.ok(newsService.save(exitsNews));
    }
    //        Xoa thong tin
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!newsService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        newsService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
