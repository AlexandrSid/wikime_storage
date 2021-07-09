package org.aleksid.wikime_storage;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("article")
public class MainController {

    private final TextRepository textRepository;

    @Autowired
    public MainController(TextRepository repositroy) {
        this.textRepository = repositroy;
    }

    @GetMapping("{id}")
    public ArticleText getArticleText(@PathVariable("id") ArticleText articleText) {
        return articleText;
    }

    @PostMapping
    public ArticleText create(@RequestBody ArticleText articleText) {
        return textRepository.save(articleText);
    }

    @PutMapping("{id}")
    public ArticleText update(@PathVariable("id") ArticleText fromDB, @RequestBody ArticleText articleText) {
        BeanUtils.copyProperties(articleText, fromDB, "id");
        return textRepository.save(fromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") ArticleText articleText) {
        textRepository.delete(articleText);
    }


}
