package com.example.managernews.service;

import com.example.managernews.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired
    private NewsService newsService;

    public List<News> findAll() {
        return newsService.findAll();
    }

    public Optional<News> findById(Integer id){
        return newsService.findById(id);
    }

    public News save(News news){
        return newsService.save(news);
    }

    public void deleteById(Integer id) {
        newsService.deleteById(id);
    }
}
