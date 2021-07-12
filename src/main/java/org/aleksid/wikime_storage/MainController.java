package org.aleksid.wikime_storage;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("article")
public class MainController {

    private final TextRepository textRepository;

    @Autowired
    public MainController(TextRepository repository) {
        this.textRepository = repository;
    }

    @GetMapping("{id}")
    public ArticleText getArticleText(@PathVariable("id") ArticleText articleText) {
        return articleText;
    }

    @PostMapping
    public ArticleText create(@RequestParam String articleId, @RequestParam String text) {
        ArticleText articleText = new ArticleText(articleId, text);
        return textRepository.save(articleText);
    }

    @PutMapping("{id}")
    public ArticleText update(@PathVariable("id") ArticleText fromDB, @RequestParam String articleId, @RequestParam String text) {
        ArticleText articleText = new ArticleText(articleId, text);
        BeanUtils.copyProperties(articleText, fromDB, "id");
        return textRepository.save(fromDB);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") ArticleText articleText) {
        textRepository.delete(articleText);
        return "200";
    }


}
