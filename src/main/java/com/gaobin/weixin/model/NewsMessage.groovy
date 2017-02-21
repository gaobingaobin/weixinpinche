package com.gaobin.weixin.model
/**
 * Created with IntelliJ IDEA.
 * User: gaobin
 * Date: 2017/2/21
 * Time: 9:37
 * To change this template use File | Settings | File Templates.
 * Description: 
 */
class NewsMessage extends BaseMessage{
    private int ArticleCount;
    private List<News> Articles;

    int getArticleCount() {
        return ArticleCount
    }

    void setArticleCount(int articleCount) {
        ArticleCount = articleCount
    }

    List<News> getArticles() {
        return Articles
    }

    void setArticles(List<News> articles) {
        Articles = articles
    }
}
